/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package icons.box;

import icons.*;
import java.awt.*;

/**
 * This is an icon that draws a box with an area filled in. This can be used to, 
 * for example, display a color or a texture that will be used when an area is 
 * filled when rendering something.
 * @author Milo Steier
 * @see ColorBoxIcon
 * @see SelectColorBoxIcon
 * @see DerivedBoxIcon
 * @see DisabledBoxIcon
 * @see RolloverBoxIcon
 */
public abstract class BoxIcon implements Icon2D{
    /**
     * The width for the icon.
     */
    private int width;
    /**
     * The height for the icon.
     */
    private int height;
    /**
     * Whether the background of the icon is opaque.
     */
    private boolean opaque;
    /**
     * The gap between the outline of the icon and the box contents.
     */
    private int gap;
    /**
     * This checks to see if the gap is valid, and if not, throws an 
     * IllegalArgumentException.
     * @param gap The gap to check.
     * @throws IllegalArgumentException If the gap between the outline and the 
     * contents is negative.
     */
    private void checkGap(int gap){
        if (gap < 0)    // If the gap is negative.
            throw new IllegalArgumentException(
                    "The gap between the outline and the contents cannot be negative ("+gap+" < 0)");
    }
    /**
     * This constructs a BoxIcon with the given width, height, gap, and whether 
     * the icon is opaque.
     * @param width The width for the icon.
     * @param height The height of the icon.
     * @param gap The amount of space between the outline and the contents of 
     * the box (cannot be negative).
     * @param opaque Whether the icon is opaque.
     * @throws IllegalArgumentException If the gap between the outline and the 
     * contents is negative.
     */
    public BoxIcon(int width, int height, int gap, boolean opaque){
        checkGap(gap);
        this.width = width;
        this.height = height;
        this.gap = gap;
        this.opaque = opaque;
    }
    /**
     * This constructs a BoxIcon that is opaque with the given width, height, 
     * and gap.
     * @param width The width for the icon.
     * @param height The height of the icon.
     * @param gap The amount of space between the outline and the contents of 
     * the box (cannot be negative).
     * @throws IllegalArgumentException If the gap between the outline and the 
     * contents is negative.
     */
    public BoxIcon(int width, int height, int gap){
        this(width,height,gap,true);
    }
    /**
     * This constructs a BoxIcon with the given width, height, and whether the 
     * icon is opaque, along with a 1 pixel gap between the outline and the 
     * contents of the box. 
     * @param width The width for the icon.
     * @param height The height of the icon.
     * @param opaque Whether the icon is opaque.
     */
    public BoxIcon(int width, int height, boolean opaque){
        this(width,height,1,opaque);
    }
    /**
     * This constructs a BoxIcon that is opaque and with the given width and 
     * height, along with a 1 pixel gap between the outline and the contents of 
     * the box.
     * @param width The width for the icon.
     * @param height The height of the icon.
     */
    public BoxIcon(int width, int height){
        this(width,height,true);
    }
    /**
     * This returns the color to use for the outline of the box.
     * @return The color to use for the outline of the box.
     * @see #paintIcon2D(java.awt.Component, java.awt.Graphics2D, int, int) 
     */
    protected Color getOutline(){
        return Color.BLACK;
    }
    /**
     * This returns the color to use to fill in the background of the box if the 
     * icon is opaque.
     * @return The background color for this icon.
     * @see #paintIcon2D 
     * @see #isOpaque() 
     * @see #setOpaque(boolean) 
     */
    protected Color getBackground(){
        return Color.WHITE;
    }
    /**
     * This returns the amount of space between the outline of the icon and the 
     * contents of the box.
     * @return The amount of pixels between the outline of the icon and the 
     * contents of the box.
     * @see #getIconWidth() 
     * @see #getIconHeight() 
     * @see #setContentGap(int) 
     */
    public int getContentGap(){
        return gap;
    }
    /**
     * This sets the amount of space between the outline of the icon and the 
     * contents of the box.
     * @param gap The amount of pixels between the outline of the icon and the 
     * contents of the box (cannot be negative).
     * @throws IllegalArgumentException If the gap between the outline and the 
     * contents is negative.
     * @see #getIconWidth() 
     * @see #getIconHeight() 
     * @see #getContentGap() 
     */
    public void setContentGap(int gap){
        checkGap(gap);
        this.gap = gap;
    }
    /**
     * This paints the contents of the box at the given location and within the 
     * given size.
     * @param g The graphics context to render to.
     * @param c A {@code Component} to get useful properties for painting.
     * @param x The x-coordinate for the top-left corner of the contents of the 
     * box.
     * @param y The y-coordinate for the top-left corner of the contents of the 
     * box.
     * @param width The width for the contents of the box.
     * @param height The height for the contents of the box.
     * @see #paintIcon2D
     * @see #getIconWidth() 
     * @see #getIconHeight() 
     * @see #getContentGap() 
     * @see #setContentGap(int) 
     */
    protected abstract void paintContents(Graphics2D g, Component c, int x, 
            int y, int width, int height);
    /**
     * This is used to configure the graphics context before this icon is drawn.
     * @param g The graphics context that this is rendering to.
     * @see #paintIcon2D
     */
    protected void configureGraphics(Graphics2D g){ }
    @Override
    public void paintIcon2D(Component c, Graphics2D g, int x, int y) {
        int width = getIconWidth();         // Get the icon width
        int height = getIconHeight();       // Get the icon height
        int off = getContentGap()+1;        // Get the gap for the contents
        int w = width-off-off;              // The width for the contents
        int h = height-off-off;             // The height for the contents
//        System.out.println(x + ", " + y + ", " + width + " x " + height + " -> " + (x+off) + ", " + (y+off) + ", " + w + " x " + h);
            // Subtract 1 from the width and height so as to not exceed the bounds
        width--;
        height--;
        
        configureGraphics(g);
        
        Color bg = getBackground();         // Get the background color
            // If the icon is opaque and the background is not null
        if (isOpaque() && bg != null){      
            g.setColor(bg);
            g.fillRect(x, y, width, height);
        }
        
        if (w > 0 && h > 0){    // If the contents would actually be drawn
                // A scratch graphics object for the contents
            Graphics2D cg = (Graphics2D)g.create(); 
            paintContents(cg,c,x+off,y+off,w,h);
            cg.dispose();
        }
        
        g.setColor(getOutline());
        g.drawRect(x, y, width, height);
    }
    /**
     * This returns the icon's width.
     * @return The width of this icon.
     * @see #getIconHeight() 
     * @see #getIconSize(java.awt.Dimension) 
     * @see #getIconSize() 
     * @see #setIconSize(int, int) 
     * @see #setIconSize(java.awt.Dimension) 
     */
    @Override
    public int getIconWidth() {
        return width;
    }
    /**
     * This returns the icon's height.
     * @return The height of this icon.
     * @see #getIconWidth() 
     * @see #getIconSize(java.awt.Dimension) 
     * @see #getIconSize() 
     * @see #setIconSize(int, int) 
     * @see #setIconSize(java.awt.Dimension) 
     */
    @Override
    public int getIconHeight() {
        return height;
    }
    /**
     * This stores the width and height of this icon into the given Dimension 
     * object. If the given Dimension object is null, then a new Dimension 
     * object will be returned. This version is useful as to avoid creating a 
     * new Dimension object.
     * @param dim The Dimension object to return with the dimensions of this 
     * icon, or null.
     * @return The Dimension object holding the dimensions of this icon.
     * @see #getIconWidth() 
     * @see #getIconHeight() 
     * @see #getIconSize() 
     * @see #setIconSize(int, int) 
     * @see #setIconSize(java.awt.Dimension) 
     */
    public Dimension getIconSize(Dimension dim){
        if (dim == null)    // If the dimension object is null
            return new Dimension(getIconWidth(),getIconHeight());
        dim.setSize(getIconWidth(),getIconHeight());
        return dim;
    }
    /**
     * This returns a Dimension object containing the width and height of this 
     * icon.
     * @return The Dimension object holding the dimensions of this icon.
     * @see #getIconWidth() 
     * @see #getIconHeight() 
     * @see #getIconSize(java.awt.Dimension) 
     * @see #setIconSize(int, int) 
     * @see #setIconSize(java.awt.Dimension) 
     */
    public Dimension getIconSize(){
        return getIconSize(null);
    }
    /**
     * This sets the size of this icon to the given width and height.
     * @param width The width for this icon.
     * @param height The height for this icon.
     * @see #getIconWidth() 
     * @see #getIconHeight() 
     * @see #getIconSize(java.awt.Dimension) 
     * @see #getIconSize() 
     * @see #setIconSize(int, int) 
     */
    public void setIconSize(int width, int height){
        this.width = width;
        this.height = height;
    }
    /**
     * This sets the size of this icon to the width and height of the given 
     * dimensions.
     * @param dim The Dimension object containing the width and height for this 
     * icon.
     * @see #getIconWidth() 
     * @see #getIconHeight() 
     * @see #getIconSize(java.awt.Dimension) 
     * @see #getIconSize() 
     * @see #setIconSize(int, int) 
     */
    public void setIconSize(Dimension dim){
        setIconSize(dim.width,dim.height);
    }
    /**
     * This returns whether this icon is opaque. That is to say that this icon 
     * will have a background rendered behind it.
     * @return Whether this icon is opaque.
     * @see #setOpaque(boolean) 
     */
    public boolean isOpaque(){
        return opaque;
    }
    /**
     * This sets whether this icon is opaque. If this icon is opaque, then a 
     * background will be rendered behind it. Otherwise, some of the underlying 
     * pixels may show through this icon.
     * @param value Whether this icon should be opaque.
     * @see #isOpaque() 
     */
    public void setOpaque(boolean value){
        opaque = value;
    }
    /**
     * This returns a String containing parameters for this icon.
     * @return A String with the parameters for this icon.
     */
    protected String paramString(){
        return getIconWidth() + "x" + getIconHeight() + ",opaque=" + isOpaque();
    }
    @Override
    public String toString(){
        return getClass().getName()+"["+paramString()+"]";
    }
}
