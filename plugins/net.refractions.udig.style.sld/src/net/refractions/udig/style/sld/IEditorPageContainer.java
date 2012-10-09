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
package net.refractions.udig.style.sld;

public interface IEditorPageContainer {
    /**
     * Adjusts the enable state of the OK 
     * button to reflect the state of the currently active 
     * page in this container.
     * <p>
     * This method is called by the container itself
     * when its preference page changes and may be called
     * by the page at other times to force a button state
     * update.
     * </p>
     */
    public void updateButtons();

    /**
     * Updates the message (or error message) shown in the message line to 
     * reflect the state of the currently active page in this container.
     * <p>
     * This method is called by the container itself
     * when its preference page changes and may be called
     * by the page at other times to force a message 
     * update.
     * </p>
     */
    public void updateMessage();

    /**
     * Updates the title to reflect the state of the 
     * currently active page in this container.
     * <p>
     * This method is called by the container itself
     * when its page changes and may be called
     * by the page at other times to force a title  
     * update.
     * </p>
     */
    public void updateTitle();

}
