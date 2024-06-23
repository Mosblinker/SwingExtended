/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package icons.box;

import java.awt.Color;

/**
 * This is an icon that can be used as the rollover version of a BoxIcon.
 * @author Milo Steier
 * @see BoxIcon
 * @see ColorBoxIcon
 * @see SelectColorBoxIcon
 * @see DerivedBoxIcon
 * @see DisabledBoxIcon
 */
public class RolloverBoxIcon extends DerivedBoxIcon{
    /**
     * This stores the outline color for a normal rollover icon.
     */
    protected static final Color ROLLOVER_OUTLINE_COLOR = new Color(0x64A5E7);
    /**
     * This stores the background color for a normal rollover icon.
     */
    protected static final Color ROLLOVER_BACKGROUND_COLOR = new Color(0xCBD9E7);
    /**
     * This constructs a RolloverBoxIcon that is the rollover version of the 
     * given icon.
     * @param icon The icon that this is the rollover version of (cannot be 
     * null).
     */
    public RolloverBoxIcon(BoxIcon icon){
        super(icon);
    }
    /**
     * This returns the color to use for the outline of the box.
     * @return The color to use for the outline of the box.
     * @see #paintIcon2D(java.awt.Component, java.awt.Graphics2D, int, int) 
     */
    @Override
    protected Color getOutline() {
        return ROLLOVER_OUTLINE_COLOR;
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
        return ROLLOVER_BACKGROUND_COLOR;
    }
}
