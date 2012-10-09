/*
 *    uDig - User Friendly Desktop Internet GIS client
 *    http://udig.refractions.net
 *    (C) 2012, Refractions Research Inc.
 *
 *    This library is free software; you can redistribute it and/or
 *    modify it under the terms of the GNU Lesser General Public
 *    License as published by the Free Software Foundation;
 *    version 2.1 of the License.
 *
 *    This library is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *    Lesser General Public License for more details.
 */
package net.refractions.udig.tool.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import net.refractions.udig.tools.internal.CursorPosition;

import org.geotools.geometry.jts.JTS;
import org.geotools.referencing.CRS;
import org.geotools.referencing.crs.DefaultGeographicCRS;
import org.junit.Test;
import org.opengis.referencing.crs.CoordinateReferenceSystem;

import com.vividsolutions.jts.geom.Coordinate;

public class CursorPositionTest {
    
    @Test
	public void testParseString() throws Exception {
		Coordinate coord=CursorPosition.parse("124,88", DefaultGeographicCRS.WGS84); //$NON-NLS-1$
		assertEquals(new Coordinate(124,88), coord);
		coord=CursorPosition.parse("(124,88)", DefaultGeographicCRS.WGS84); //$NON-NLS-1$
		assertEquals(new Coordinate(124,88), coord);
		coord=CursorPosition.parse("124 88", DefaultGeographicCRS.WGS84); //$NON-NLS-1$
		assertEquals(new Coordinate(124,88), coord);
		coord=CursorPosition.parse("(124 88)", DefaultGeographicCRS.WGS84); //$NON-NLS-1$
		assertEquals(new Coordinate(124,88), coord);
		coord=CursorPosition.parse("124 88LL", DefaultGeographicCRS.WGS84); //$NON-NLS-1$
		assertEquals(new Coordinate(124,88), coord);
		coord=CursorPosition.parse("(124 88)LL", DefaultGeographicCRS.WGS84); //$NON-NLS-1$
		assertEquals(new Coordinate(124,88), coord);
		coord=CursorPosition.parse(" (124 88 )", DefaultGeographicCRS.WGS84); //$NON-NLS-1$
		assertEquals(new Coordinate(124,88), coord);
		coord=CursorPosition.parse("( 124, 88 )", DefaultGeographicCRS.WGS84); //$NON-NLS-1$
		assertEquals(new Coordinate(124,88), coord);
		coord=CursorPosition.parse("(124, 88)LL", DefaultGeographicCRS.WGS84); //$NON-NLS-1$
		assertEquals(new Coordinate(124,88), coord);
		coord=CursorPosition.parse("[124 88]", DefaultGeographicCRS.WGS84); //$NON-NLS-1$
		assertEquals(new Coordinate(124,88), coord);
		coord=CursorPosition.parse("[124 88]LATLONG", DefaultGeographicCRS.WGS84); //$NON-NLS-1$
		assertEquals(new Coordinate(124,88), coord);
		coord=CursorPosition.parse("[124 88]LAT LONG", DefaultGeographicCRS.WGS84); //$NON-NLS-1$
		assertEquals(new Coordinate(124,88), coord);
		coord=CursorPosition.parse("124 88LAT LONG", DefaultGeographicCRS.WGS84); //$NON-NLS-1$
		assertEquals(new Coordinate(124,88), coord);
		coord=CursorPosition.parse("124 88ll", DefaultGeographicCRS.WGS84); //$NON-NLS-1$
		assertEquals(new Coordinate(124,88), coord);
		CoordinateReferenceSystem albers = CRS.decode("EPSG:3005"); //$NON-NLS-1$
		coord=CursorPosition.parse("124 88LAT LONG", albers); //$NON-NLS-1$
		Coordinate expected=new Coordinate();
		JTS.transform(new Coordinate(124,88), expected, CRS.findMathTransform(DefaultGeographicCRS.WGS84,albers));
		assertEquals(expected.x, coord.x, 0.00001);

		coord=CursorPosition.parse("aasdf asdf", DefaultGeographicCRS.WGS84); //$NON-NLS-1$
		assertNull(coord);
		
		coord=CursorPosition.parse("13g4", DefaultGeographicCRS.WGS84); //$NON-NLS-1$
		assertNull(coord);
		
	}
}
