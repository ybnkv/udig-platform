/*
 *    uDig - User Friendly Desktop Internet GIS client
 *    http://udig.refractions.net
 *    (C) 2011, Refractions Research Inc.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * (http://www.eclipse.org/legal/epl-v10.html), and the Refractions BSD
 * License v1.0 (http://udig.refractions.net/files/bsd3-v10.html).
 */
package net.refractions.udig.style.raster.ui;

import net.refractions.udig.style.raster.internal.Messages;

import org.eclipse.jface.window.Window;
import org.geotools.styling.ColorMap;
import org.geotools.styling.ColorMapEntry;
import org.geotools.styling.ColorMapImpl;
import org.geotools.styling.builder.ColorMapEntryBuilder;

/**
 * Style panel for the ColorMap.TYPE_RAMP,
 * 
 * @author Emily
 *
 */
public class RampValuesPanel extends UniqueValuesPanel {

	
	/**
	 * Creates a new style panel
	 * @param page
	 */
	public RampValuesPanel(SingleBandEditorPage page) {
		super(page);
	}

	/**
	 * @see net.refractions.udig.style.raster.ui.UniqueValuesPanel#getColorMap()
	 */
	@Override
	public ColorMap getColorMap() throws Exception{
		sort();
		refresh();
		
		ColorMapImpl colorMap = new ColorMapImpl();
		colorMap.setType(ColorMapImpl.TYPE_RAMP);
		
		for (int i = 0; i < colors.size(); i ++){
			ColorEntry c1 = colors.get(i);			
			ColorMapEntryBuilder cme = new ColorMapEntryBuilder();
			ColorMapEntry e = cme.color(c1.getColor()).opacity(c1.getOpacity()).quantity(c1.getValue()).build();
			if (c1.getLabel() != null && !c1.getLabel().trim().isEmpty()){
				e.setLabel(c1.getLabel());
			}
			colorMap.addColorMapEntry(e);
			
		}
		return colorMap;
	}
	
	@Override
	public boolean canSupport(int colorMapType) {
		return (colorMapType == ColorMap.TYPE_RAMP);
	}
	@Override
	public String getName() {
		return Messages.RampValuesPanel_RampTypeName;
	}

	@Override
	public void computeValues() {
		ClassifyDialog dialog = new ClassifyDialog(page.getShell(), page.getGridCoverageReader());
		if (dialog.open() == Window.OK){
			dialog.updatePanel(this);
		}
	}

	@Override
	public String getComputeValuesLabel() {
		return Messages.RampValuesPanel_ComputeIntervalsButtonName;
	}

}
