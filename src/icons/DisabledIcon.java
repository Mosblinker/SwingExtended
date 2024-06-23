/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package icons;

import java.awt.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.util.Objects;
import javax.swing.*;

/**
 * This is an Icon that serves as a disabled version of another Icon.
 * @author Milo Steier
 */
public class DisabledIcon implements DerivedIcon{
    /**
     * The icon to render the disabled version of.
     */
    private final Icon icon;
    /**
     * This constructs a DisabledIcon that will render the disabled version of 
     * the given Icon.
     * @param icon The base Icon for this to represent the disabled version of 
     * (cannot be null).
     */
    public DisabledIcon(Icon icon){
        this.icon = Objects.requireNonNull(icon, "Icon cannot be null");
    }
    /**
     * {@inheritDoc }
     * @return {@inheritDoc }
     */
    @Override
    public Icon getIcon(){
        return icon;
    }
    /**
     * This draws a grayed out version of the {@link #getIcon() original icon} 
     * at the specified location, so as to represent a disabled version of the  
     * original icon.
     * @param c {@inheritDoc}
     * @param g {@inheritDoc}
     * @param x {@inheritDoc}
     * @param y {@inheritDoc}
     * @see #getIcon() 
     */
    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        int width = getIconWidth();     // This gets the icon width
        int height = getIconHeight();   // This gets the icon height
        g = g.create();
            // If the Graphics object is null or the width or height are less 
        if (g == null || width <= 0 || height <= 0)  // than or equal to zero
            return;
            // HACK: This gets the preapplied scaling transform so that the 
            // image can be scaled in a similar way, so as to attempt to make 
            // the rendered image as close to a 1:1 match to how the icon would 
            // be rendered on screen
            // TODO: Look into making a Graphics (and Graphics2D) wrapper that 
            // renders all colors, paints, and images in gray scale so the hack 
            // becomes unnecessary
        double xScale = 1;  // This gets the preapplied x scaling tranform, if there is one
        double yScale = 1;  // This gets the preapplied y scaling tranform, if there is one
            // If the graphics object is a Graphics2D
        if (g instanceof Graphics2D){
                // Get its transform so that we can get the scaling transform
            AffineTransform tr = ((Graphics2D)g).getTransform();
            xScale = tr.getScaleX();
            yScale = tr.getScaleY();
        }
            // This creates a BufferedImage to render the base icon to
        BufferedImage img = new BufferedImage((int)Math.ceil(width*xScale),
                (int)Math.ceil(height*yScale),
                BufferedImage.TYPE_INT_ARGB);
            // The graphics object to render the icon to
        Graphics2D g2D = img.createGraphics();
        g2D.setFont(g.getFont());
        g2D.setColor(g.getColor());
            // Scale the image so that it behaves in a similar way to the given graphics object
        g2D.scale(img.getWidth()/((double)width), img.getHeight()/((double)height));
        g2D.translate(-1*x, -1*y);
        getIcon().paintIcon(c, g2D, x, y);
        g2D.dispose();
        g.drawImage(GrayFilter.createDisabledImage(img), x, y, width, height, c);
        g.dispose();
    }
    /**
     * This compares this DisabledIcon with the given object to see if it 
     * matches this DisabledIcon. Two DisabledIcons are equal if they have the 
     * same original Icon.
     * @param obj The object to be compared with.
     * @return Whether the object is equal to this DisabledIcon.
     * @see #getIcon() 
     */
    @Override
    public boolean equals(Object obj){
        if (obj == this)                        // If the object is this DisabledIcon
            return true;
        else if (obj instanceof DisabledIcon)   // If the object is a DisabledIcon
            return icon.equals(((DisabledIcon)obj).icon);
        return false;
    }
    /**
     * This returns the hash code for this DisabledIcon.
     * @return The hash code for this DisabledIcon.
     */
    @Override
    public int hashCode() {
        int hash = 3;   // This gets the hash code
        hash = 59 * hash + Objects.hashCode(this.icon);
        return hash;
    }
    /**
     * This returns a String containing parameters for this DisabledIcon.
     * @return A String with the parameters for this icon.
     */
    protected String paramString(){
        return "icon="+getIcon().toString();
    }
    @Override
    public String toString(){
        return getClass().getName()+"["+paramString()+"]";
    }
}
