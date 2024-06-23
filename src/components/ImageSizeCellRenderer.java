/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package components;

import java.awt.Component;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.JList;

/**
 * This is an extension to the {@link BoundsCellRenderer} to allow it to display 
 * the width and height of Images and Icons in a JList in addition to 
 * dimensions, points, and rectangles.
 * @author Milo Steier
 */
public class ImageSizeCellRenderer extends BoundsCellRenderer{
    @Override
    public Component getListCellRendererComponent(JList list, Object value, 
            int index, boolean isSelected, boolean cellHasFocus){
        if (value instanceof Image){        // If the object is an Image
            Image img = (Image) value;      // Get the Image
            value = dimensionToString(img.getWidth(null), img.getHeight(null));
        }
        else if (value instanceof Icon){    // If the object is an Icon
            Icon icon = (Icon) value;       // Get the Icon
            value = dimensionToString(icon.getIconWidth(), icon.getIconHeight());
        }
        return super.getListCellRendererComponent(list,value,index,isSelected,
                cellHasFocus);
    }
}
