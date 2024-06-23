/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package icons.box;

import java.awt.*;
import java.util.Objects;

/**
 * This is an icon that can be used to display a color.
 * @author Milo Steier
 * @see BoxIcon
 * @see SelectColorBoxIcon
 * @see DerivedBoxIcon
 * @see DisabledBoxIcon
 * @see RolloverBoxIcon
 */
public class ColorBoxIcon extends BoxIcon{
    /**
     * The color displayed by this icon.
     */
    private Color color;
    /**
     * This constructs a ColorBoxIcon with the given width, height, gap, color 
     * to display, and whether the icon is opaque.
     * @param width The width for the icon.
     * @param height The height of the icon.
     * @param color The color to display (cannot be null).
     * @param gap The amount of space between the outline and the contents of 
     * the box (cannot be negative).
     * @param opaque Whether the icon is opaque.
     * @throws IllegalArgumentException If the gap between the outline and the 
     * contents is negative.
     * @throws NullPointerException If the color is null.
     */
    public ColorBoxIcon(int width, int height, Color color, int gap, boolean opaque){
        super(width,height,gap,opaque);
        this.color = Objects.requireNonNull(color, "Color cannot be null");
    }
    /**
     * This constructs a ColorBoxIcon that is opaque and with the given width, 
     * height, gap, and color to display.
     * @param width The width for the icon.
     * @param height The height of the icon.
     * @param color The color to display (cannot be null).
     * @param gap The amount of space between the outline and the contents of 
     * the box (cannot be negative).
     * @throws IllegalArgumentException If the gap between the outline and the 
     * contents is negative.
     * @throws NullPointerException If the color is null.
     */
    public ColorBoxIcon(int width, int height, Color color, int gap){
        this(width,height,color,gap,true);
    }
    /**
     * This constructs a ColorBoxIcon with the given width, height, color to 
     * display, and whether the icon is opaque, along with a 1 pixel gap between 
     * the outline and the contents of the box.
     * @param width The width for the icon.
     * @param height The height of the icon.
     * @param color The color to display (cannot be null).
     * @param opaque Whether the icon is opaque.
     * @throws NullPointerException If the color is null.
     */
    public ColorBoxIcon(int width, int height, Color color, boolean opaque){
        this(width,height,color,1,opaque);
    }
    /**
     * This constructs a ColorBoxIcon that is opaque and with the given width, 
     * height, and color to display, along with a 1 pixel gap between the 
     * outline and the contents of the box.
     * @param width The width for the icon.
     * @param height The height of the icon.
     * @param color The color to display (cannot be null).
     * @throws NullPointerException If the color is null.
     */
    public ColorBoxIcon(int width, int height, Color color){
        this(width,height,color,1);
    }
    /**
     * This returns the color being displayed by this icon.
     * @return The color displayed by this icon.
     * @see #setColor(java.awt.Color) 
     */
    public Color getColor(){
        return color;
    }
    /**
     * This sets the color to display for this icon.
     * @param color The color to display (cannot be null).
     * @see #getColor() 
     */
    public void setColor(Color color){
        this.color = Objects.requireNonNull(color, "Color cannot be null");
    }
    @Override
    protected void paintContents(Graphics2D g, Component c, int x, int y, 
            int width, int height) {
        g.setColor(getColor());
            // Subtract 1 from the width and height so as to not exceed the bounds
        width--;
        height--;
        g.drawRect(x, y, width, height);
        g.fillRect(x, y, width, height);
    }
    @Override
    protected String paramString(){
        return super.paramString()+",color="+getColor();
    }
}
