/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package components;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

/**
 * This is a cell renderer used to display the x, y, width, and height of 
 * Rectangle objects in a JList, along with the width and height of Dimension 
 * objects and the x and y coordinates of Point objects.
 * @author Milo Steier
 * @see Rectangle
 * @see Dimension
 * @see Point
 */
public class BoundsCellRenderer extends DefaultListCellRenderer{
    @Override
    public Component getListCellRendererComponent(JList list, Object value, 
            int index, boolean isSelected, boolean cellHasFocus){
        if (value instanceof Rectangle){        // If the object is a Rectangle
            Rectangle temp = (Rectangle) value; // Get the Rectangle object
            value = rectangleToString(temp.x,temp.y,temp.width,temp.height);
        }
        else if (value instanceof Dimension){   // If the object is a Dimension
            Dimension temp = (Dimension) value; // Get the Dimension object
            value = dimensionToString(temp.width,temp.height);
        }
        else if (value instanceof Point){       // If the object is a Point
            Point temp = (Point) value;         // Get the Point object
            value = pointToString(temp.x,temp.y);
        }
        return super.getListCellRendererComponent(list,value,index,isSelected,
                cellHasFocus);
    }
    /**
     * This returns a String stating the given x and y coordinates of a point.
     * @param x The x-coordinate of the point.
     * @param y The y-coordinate of the point.
     * @return A String stating the x and y coordinates.
     */
    public String pointToString(int x, int y){
        return "(" + x + ", " + y + ")";
    }
    /**
     * This returns a String stating the given width and height.
     * @param width The width.
     * @param height The height.
     * @return A String stating the width and height.
     */
    public String dimensionToString(int width, int height){
        return width + " x " + height;
    }
    /**
     * This returns a String stating the x, y, width, and height of a rectangle. 
     * This is effectively calling {@link #pointToString(int, int) 
     * pointToString}{@code (x,y)} and {@link #dimensionToString(int, int) 
     * dimensionToString}{@code (width,height)} and combining the two Strings 
     * together.
     * @param x The x-coordinate of the rectangle.
     * @param y The y-coordinate of the rectangle.
     * @param width The width of the rectangle.
     * @param height The height of the rectangle.
     * @return A String stating the x, y, width, and height of a rectangle.
     * @see #pointToString(int, int) 
     * @see #dimensionToString(int, int) 
     */
    public String rectangleToString(int x, int y, int width, int height){
        return pointToString(x,y)+", "+dimensionToString(width,height);
    }
}
