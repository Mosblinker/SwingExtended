/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Window;

/**
 * This is a library class with some additional utilities methods not found in 
 * {@link javax.swing.SwingUtilities SwingUtilities}
 * @author Mosblinker
 * @see javax.swing.SwingUtilities
 */
public final class SwingExtendedUtilities {
    /**
     * This class cannot be constructed.
     */
    private SwingExtendedUtilities() {}
    /**
     * This sets the size of the given component, respecting its minimum size.
     * @param comp The component to set the size of.
     * @param width The new width of the component.
     * @param height The new height of the component.
     */
    public static void setComponentSize(Component comp, int width, int height){
            // Get the minimum size for the component
        Dimension min = comp.getMinimumSize();
            // Make sure the size is not smaller than the minimum size
        min.width = Math.max(width, min.width);
        min.height = Math.max(height, min.height);
            // If the component is a window
        if (comp instanceof Window)
            comp.setSize(min);
        else
            comp.setPreferredSize(min);
    }
    /**
     * This sets the size of the given component, respecting its minimum size.
     * @param comp The component to set the size of.
     * @param dim The size for the component.
     */
    public static void setComponentSize(Component comp, Dimension dim){
            // If there was a size provided
        if (dim != null)
            setComponentSize(comp,dim.width,dim.height);
    }
    /**
     * This sets the bounds of the given component, respecting its minimum size.
     * @param comp The component to set the bounds of.
     * @param x The new x-coordinate for the component.
     * @param y The new y-coordinate for the component.
     * @param width The new width for the component.
     * @param height The new height for the component.
     */
    public static void setComponentBounds(Component comp, int x, int y, 
            int width, int height){
            // Get the minimum size for the component
        Dimension min = comp.getMinimumSize();
            // Set the size of the component, making sure the size is not 
            // smaller than the minimum size.
        comp.setBounds(x, y, 
                Math.max(width, min.width), 
                Math.max(height, min.height));
    }
    /**
     * This sets the bounds of the given component, respecting its minimum size.
     * @param comp The component to set the bounds of.
     * @param rect The bounds for the component.
     */
    public static void setComponentBounds(Component comp, Rectangle rect){
            // If a rectangle was provided
        if (rect != null)
            setComponentBounds(comp,rect.x,rect.y,rect.width,rect.height);
    }
}
