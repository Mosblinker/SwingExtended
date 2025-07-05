/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package icons;

import java.awt.*;
import java.awt.geom.*;

/**
 * This is the icon to use as the default profile picture when there is no 
 * profile picture set for a user.
 * @author Milo Steier
 */
public class DefaultPfpIcon implements Icon2D{
    /**
     * This is the ellipse used to draw the head.
     */
    private Ellipse2D head = null;
    /**
     * This is the ellipse used to draw the body.
     */
    private Ellipse2D bodyEllipse = null;
    /**
     * This is the rectangle used to draw the body.
     */
    private Rectangle2D bodyRect = null;
    /**
     * This is the background color for the icon.
     */
    private Color bg;
    /**
     * This is the foreground color for the icon.
     */
    private Color fg;
    /**
     * This is the width of the icon.
     */
    private int width;
    /**
     * This is the height of the icon.
     */
    private int height;
    /**
     * This constructs a DefaultPfpIcon with the given size and background 
     * color.
     * @param width The width of the icon.
     * @param height The height of the icon.
     * @param color The background color for the icon (cannot be null).
     * @throws NullPointerException If the given background color is null.
     * @throws IllegalArgumentException If either the width or height are less 
     * than or equal to zero.
     */
    public DefaultPfpIcon(int width, int height, Color color){
            // If either the given width or height are less than or equal to zero
        if (width <= 0 || height <= 0)
            throw new IllegalArgumentException("Width and height must be "
                    + "greater than zero (width="+ width+",height-="+height+")");
            // If the given color is null
        if (color == null)
            throw new NullPointerException();
        this.width = width;
        this.height = height;
        this.bg = color;
        fg = Color.WHITE;
            // Get the hue, saturation, and brightness of the background color
        float[] hsb = Color.RGBtoHSB(bg.getRed(), bg.getGreen(), bg.getBlue(), null);
            // If the background color is close enough to white that the 
            // foreground may be too difficult to see
        if (hsb[2] > 0.95 && hsb[1] < 0.05)
                // Use gray as the foreground color instead
            fg = Color.GRAY;
            // Construct the shapes to use
        constructShapes();
    }
    /**
     * This constructs a DefaultPfpIcon with the given size and a {@link 
     * Color#GRAY gray} background.
     * @param width The width of the icon.
     * @param height The height of the icon.
     * @throws IllegalArgumentException If either the width or height are less 
     * than or equal to zero.
     * @see Color#GRAY
     */
    public DefaultPfpIcon(int width, int height){
        this(width,height,Color.GRAY);
    }
    /**
     * This constructs a DefaultPfpIcon with the given size and background 
     * color.
     * @param size The width and height of the icon.
     * @param color The background color for the icon (cannot be null).
     * @throws NullPointerException If the given background color is null.
     * @throws IllegalArgumentException If the size is less than or equal to 
     * zero.
     */
    public DefaultPfpIcon(int size, Color color){
        this(size,size,color);
    }
    /**
     * This constructs a DefaultPfpIcon with the given size and a {@link 
     * Color#GRAY gray} background.
     * @param size The width and height of the icon.
     * @throws IllegalArgumentException If the size is less than or equal to 
     * zero.
     * @see Color#GRAY
     */
    public DefaultPfpIcon(int size){
        this(size,size);
    }
    /**
     * This constructs a 100x100 DefaultPfpIcon with the given background color.
     * @param color The background color for the icon (cannot be null).
     * @throws NullPointerException If the given background color is null.
     */
    public DefaultPfpIcon(Color color){
        this(100,color);
    }
    /**
     * This constructs a 100x100 DefaultPfpIcon with a {@link Color#GRAY gray} 
     * background.
     * @see Color#GRAY
     */
    public DefaultPfpIcon(){
        this(100,Color.GRAY);
    }
    /**
     * This returns the background color for this icon.
     * @return The background color for this icon.
     */
    public Color getColor(){
        return bg;
    }
    /**
     * This constructs the shapes used to draw the icon.
     */
    private void constructShapes(){
            // This is the x-coordinate of the center of the icon
        double centerX = getIconWidth()/2.0;
            // This is the y-coordinate of the center of the icon
        double centerY = getIconHeight()/2.0;
            // Get the smaller of the width and height
        double size = Math.min(getIconWidth(),getIconHeight());
            // This gets the radius for the head
        double r = size/5.0;
            // Create the head shape
        head = new Ellipse2D.Double();
            // Head is in the horizontal center, is r x r, and the bottom 
            // of the head is at the vertical center
        head.setFrameFromCenter(centerX, centerY-r, centerX-r, centerY);
            // Create the body ellipse
        bodyEllipse = new Ellipse2D.Double();
            // Get the y-coordinate for the top of the body
        double y = centerY+(getIconHeight()/10.0);
            // This ellipse is height/10 pixels below the center, is 1.25 times 
            // the width of the head, and is 0.35 the height of the icon
        bodyEllipse.setFrameFromCenter(centerX, y+(getIconHeight()*0.175), 
               size/4.0, y);
            // Create the body rectangle
        bodyRect = new Rectangle2D.Double();
            // This rectangle is from the center-left of the ellipse to the 
            // right of the ellipse and bottom of the icon
        bodyRect.setFrameFromDiagonal(
                bodyEllipse.getMinX(), bodyEllipse.getCenterY(), 
                bodyEllipse.getMaxX(), getIconHeight());
    }
    @Override
    public void paintIcon2D(Component c, Graphics2D g, int x, int y) {
            // Translate the graphics to the top-left of the icon
        g.translate(x, y);
            // Clip the graphics to the icon's size
        g.clipRect(0, 0, getIconWidth(), getIconHeight());
            // Enable antialiasing
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
                RenderingHints.VALUE_ANTIALIAS_ON);
            // Prioritize rendering quality over speed
        g.setRenderingHint(RenderingHints.KEY_RENDERING, 
                RenderingHints.VALUE_RENDER_QUALITY);
            // Draw the icon's background
        g.setColor(bg);
        g.fillRect(0, 0, getIconWidth(), getIconHeight());
            // Set the color to the icon's foreground
        g.setColor(fg);
            // Draw the head
        g.fill(head);
            // Draw the body ellipse
        g.fill(bodyEllipse);
            // Draw the body rectangle
        g.fill(bodyRect);
    }
    @Override
    public int getIconWidth() {
        return width;
    }
    @Override
    public int getIconHeight() {
        return height;
    }
    /**
     * This returns a String containing parameters for this DefaultPfpIcon.
     * @return A String with the parameters for this icon.
     */
    protected String paramString(){
        return getIconWidth()+"x"+getIconHeight()+
                ",color="+getBackground();
    }
    @Override
    public String toString(){
        return getClass().getName()+"["+paramString()+"]";
    }
}
