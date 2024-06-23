/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package icons.files;

import icons.*;
import java.awt.*;
import java.awt.geom.*;

/**
 * This is an icon that provides the basic framework for an icon that can be 
 * used to represent some type of file. This icon can be one of two sizes, 16x20 
 * and 48x64. The smaller of the two is the default size and is intended for 
 * things like JFileChoosers, while the larger is intended for situations where 
 * a larger file icon is more desirable.
 * @author Milo Steier
 */
public abstract class AbstractFileIcon implements Icon2D{
    /**
     * This stores whether this is the large or small version of the icon.
     */
    protected boolean largeIcon;
    /**
     * This constructs an AbstractFileIcon. The icon will be 16x20.
     */
    public AbstractFileIcon(){
        this(false);
    }
    /**
     * This constructs an AbstractFileIcon. The size of the icon is dependent on 
     * the given value. If the given value is true, then this icon will be 
     * 48x64. If the given value is false, then this icon will be 16x20.
     * @param isLarge Whether the icon should be large (true for a 48x64 icon, 
     * false for a 16x20 icon).
     */
    public AbstractFileIcon(boolean isLarge){
        largeIcon = isLarge;
    }
    /**
     * This returns whether this is a large (48x64) icon or a small (16x20) 
     * icon.
     * @return Whether this is a large icon or a small icon.
     * @see #getIconWidth
     * @see #getIconHeight
     */
    public boolean isLargeIcon(){
        return largeIcon;
    }
    /**
     * This paints a shape with an opaque background. This will also account for 
     * a wider line width caused by a scaling transform being applied to the 
     * graphics context.
     * @param g The graphics context to paint to.
     * @param outline The outline of the shape to paint.
     * @param shape The inside of the shape to paint.
     * @param fg The foreground for the shape.
     * @param bg The background for the shape.
     * @see #paintOpaqueShape(Graphics2D, Shape, Color, Color) 
     */
    protected static void paintOpaqueShape(Graphics2D g, Shape outline, 
            Shape shape, Color fg, Color bg){
            // This gets the currently set transformation from the graphics
        AffineTransform tr = g.getTransform();
            // If an x scale has been applied and is greater than 1, store 0.5
        double dX = (tr.getScaleX() > 1) ? 0.5 : 0;
            // If a y scale has been applied and is greater than 1, store 0.5
        double dY = (tr.getScaleY() > 1) ? 0.5 : 0;
            // HACK: Translate the x and y if they have a scale applied that is 
            // greater than 1, so as to account for the wider line width
        g.translate(dX, dY);
            // Paint the background
        g.setColor(bg);
        g.fill(shape);
            // Paint the foreground
        g.setColor(fg);
        g.draw(outline);
            // Restore the previous transformation
        g.setTransform(tr);
    }
    /**
     * This paints a shape with an opaque background. This will also account for 
     * a wider line width caused by a scaling transform being applied to the 
     * graphics context.
     * @param g The graphics context to paint to.
     * @param shape The shape to paint.
     * @param fg The foreground for the shape.
     * @param bg The background for the shape.
     * @see #paintOpaqueShape(Graphics2D, Shape, Shape, Color, Color) 
     */
    protected static void paintOpaqueShape(Graphics2D g, Shape shape, Color fg, 
            Color bg){
        paintOpaqueShape(g,shape,shape,fg,bg);
    }
    /**
     * {@inheritDoc }
     * @return The width for the icon (48 for large icons, 16 for small icons).
     * @see #isLargeIcon 
     */
    @Override
    public int getIconWidth() {
            // If this is a large icon, return 48. Otherwise, return 16.
        return (isLargeIcon()) ? 48 : 16;
    }
    /**
     * {@inheritDoc }
     * @return The height for the icon (64 for large icons, 20 for small icons).
     * @see #isLargeIcon 
     */
    @Override
    public int getIconHeight() {
            // If this is a large icon, return 64. Otherwise, return 20.
        return (isLargeIcon()) ? 64 : 20;
    }
}
