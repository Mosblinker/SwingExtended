/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package icons.box;

import java.awt.Color;

/**
 * This is an icon that can display a disabled version of a BoxIcon.
 * @author Milo Steier
 * @see BoxIcon
 * @see ColorBoxIcon
 * @see SelectColorBoxIcon
 * @see DerivedBoxIcon
 * @see RolloverBoxIcon
 */
public class DisabledBoxIcon extends DerivedBoxIcon{
    /**
     * This constructs a DisabledBoxIcon that is the disabled version of the 
     * given icon.
     * @param icon The icon that this is the disabled version of (cannot be 
     * null).
     */
    public DisabledBoxIcon(BoxIcon icon){
        super(icon);
    }
    /**
     * This returns the color to use for the outline of the box.
     * @return The color to use for the outline of the box.
     * @see #paintIcon2D(java.awt.Component, java.awt.Graphics2D, int, int) 
     */
    @Override
    protected Color getOutline() {
        return Color.GRAY;
    }
    /**
     * This returns the color to use to fill in the background of the box if the 
     * icon is opaque.
     * @return The background color for this icon.
     * @see #paintIcon2D(java.awt.Component, java.awt.Graphics2D, int, int) 
     * @see #isOpaque() 
     * @see #setOpaque(boolean) 
     */
    @Override
    protected Color getBackground() {
        return Color.LIGHT_GRAY;
    }
}
