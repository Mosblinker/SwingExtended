/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package icons.box;

import java.awt.*;
import java.awt.geom.*;

/**
 * This is an icon that can be used to signify a color selection option. 
 * @author Milo Steier
 * @see BoxIcon
 * @see ColorBoxIcon
 * @see DerivedBoxIcon
 * @see DisabledBoxIcon
 * @see RolloverBoxIcon
 */
public class SelectColorBoxIcon extends BoxIcon{
    /**
     * This contains the colors for the hue gradient.
     * @see #HUE_GRADIENT_FRACTIONS
     */
    protected static final Color[] HUE_GRADIENT_COLORS = {
        Color.RED,Color.YELLOW,Color.GREEN,Color.CYAN,Color.BLUE,Color.MAGENTA,Color.RED
    };
    /**
     * This generates the color distribution for the hue gradient based off of 
     * the {@link #HUE_GRADIENT_COLORS hue gradient colors}.
     * @return An array containing the hue gradient color distribution.
     * @see #HUE_GRADIENT_COLORS
     * @see #HUE_GRADIENT_FRACTIONS
     */
    private static float[] getHueGradientFractions(){
            // This gets the generated array
        float[] arr = new float[HUE_GRADIENT_COLORS.length];
        float d = arr.length-1;     // Get the denominator for the fractions
            // A for loop to create the fractions.
        for (int i = 0; i < arr.length; i++){
            arr[i] = i / d;
        }
        return arr;
    }
    /**
     * This contains the color distribution for the hue gradient. The colors are 
     * evenly distributed.
     * @see #HUE_GRADIENT_COLORS
     */
    protected static final float[] HUE_GRADIENT_FRACTIONS = getHueGradientFractions();
    /**
     * This contains a completely transparent color.
     */
    protected static final Color TRANSPARENT_COLOR = new Color(0,0,0,0);
    /**
     * This stores the gradient for the hue. The hue gradient is initialized the 
     * first time it is requested, and is reinitialized if the width changes.
     */
    private java.awt.LinearGradientPaint hueGradient = null;
    /**
     * This stores the gradient for the saturation. The saturation gradient is 
     * initialized the first time it is requested, and is reinitialized if the 
     * height changes.
     */
    private java.awt.GradientPaint satGradient = null;
    /**
     * This constructs a SelectColorBoxIcon with the given width, height, gap, 
     * and whether the icon is opaque.
     * @param width The width for the icon.
     * @param height The height of the icon.
     * @param gap The amount of space between the outline and the contents of 
     * the box (cannot be negative).
     * @param opaque Whether the icon is opaque.
     * @throws IllegalArgumentException If the gap between the outline and the 
     * contents is negative.
     */
    public SelectColorBoxIcon(int width, int height, int gap, boolean opaque){
        super(width,height,gap,opaque);
    }
    /**
     * This constructs a SelectColorBoxIcon that is opaque and with the given 
     * width, height, and gap.
     * @param width The width for the icon.
     * @param height The height of the icon.
     * @param gap The amount of space between the outline and the contents of 
     * the box (cannot be negative).
     * @throws IllegalArgumentException If the gap between the outline and the 
     * contents is negative.
     */
    public SelectColorBoxIcon(int width, int height, int gap){
        super(width,height,gap);
    }
    /**
     * This constructs a SelectColorBoxIcon with the given width, height, and 
     * whether the icon is opaque, along with a 1 pixel gap between the outline 
     * and the contents of the box.
     * @param width The width for the icon.
     * @param height The height of the icon.
     * @param opaque Whether the icon is opaque.
     */
    public SelectColorBoxIcon(int width, int height, boolean opaque){
        super(width,height,opaque);
    }
    /**
     * This constructs a SelectColorBoxIcon that is opaque and with the given 
     * width and height, along with a 1 pixel gap between the outline and the 
     * contents of the box.
     * @param width The width for the icon.
     * @param height The height of the icon.
     */
    public SelectColorBoxIcon(int width, int height){
        super(width,height);
    }
    /**
     * This checks to see if the distance between the two given points matches 
     * the given target distance.
     * @param start The start point.
     * @param end The end point.
     * @param target The target distance.
     * @return Whether the distance between the two points matches the target 
     * distance.
     * @see java.awt.geom.Point2D#distance(java.awt.geom.Point2D) 
     */
    private boolean matchDistance(Point2D start, Point2D end, double target){
        return start.distance(end) == target;
    }
    /**
     * This returns the gradient used to render the hue values. The gradient 
     * goes from left to right across the given width (assuming the gradient is 
     * rendered at the origin).
     * @param width The width of the area to fill with the gradient.
     * @return The hue gradient.
     * @see #getSaturationGradient(int) 
     * @see #getGradients(int, int) 
     * @see #paintContents 
     * @see #getIconWidth() 
     */
    protected LinearGradientPaint getHueGradient(int width){
            // Subtract 1 from the width so that the last pixel is the last color
        width--;
            // If the hue gradient has not been initialized yet or the distance 
            // between the start and end of the gradient is not equal to the width
        if (hueGradient == null || !matchDistance(hueGradient.getStartPoint(),
                hueGradient.getEndPoint(),width))
            hueGradient = new LinearGradientPaint(0,0,width,0
                    ,HUE_GRADIENT_FRACTIONS,HUE_GRADIENT_COLORS);
        return hueGradient;
    }
    /**
     * This returns the gradient used to represent the saturation when combined 
     * with the {@link #getHueGradient(int) hue gradient}. The gradient goes 
     * from top to bottom across the given height (assuming the gradient is 
     * rendered at the origin), and starts off transparent and ends being gray.
     * @param height The height of the area to fill with the gradient.
     * @return The saturation gradient.
     * @see #getHueGradient(int) 
     * @see #getGradients(int, int) 
     * @see #paintContents 
     * @see #getIconHeight() 
     */
    protected GradientPaint getSaturationGradient(int height){
            // Subtract 1 from the height so that the last pixel is the last color
        height--;
            // If the saturation gradient has not been initialized yet or the 
            // distance between the start and end of the gradient is not equal to the height
        if (satGradient == null || !matchDistance(satGradient.getPoint1(),
                satGradient.getPoint2(),height));
            satGradient = new GradientPaint(0, 0, TRANSPARENT_COLOR, 0, 
                    height, Color.GRAY);
        return satGradient;
    }
    /**
     * This returns an array containing the {@link #getHueGradient(int) hue} and 
     * {@link #getSaturationGradient(int) saturation} gradients, in order in 
     * which they are to be rendered in.
     * @param width The width of the area to fill with the gradients.
     * @param height The height of the area to fill with the gradients.
     * @return An array containing the gradients.
     * @see #getHueGradient(int) 
     * @see #getSaturationGradient(int) 
     * @see #paintContents 
     * @see #getIconWidth() 
     * @see #getIconHeight() 
     */
    protected Paint[] getGradients(int width, int height){
        return new Paint[]{getHueGradient(width),getSaturationGradient(height)};
    }
    @Override
    protected void paintContents(Graphics2D g, Component c, int x, int y, 
            int width, int height) {
        g = (Graphics2D)g.create();
        g.translate(x, y);
            // Go through the gradients to render the icon
        for (Paint gradient : getGradients(width,height)){
            g.setPaint(gradient);
            g.fillRect(0, 0, width, height);
        }
        g.dispose();
    }
}
