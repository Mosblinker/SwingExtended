/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package icons;

import javax.swing.Icon;

/**
 * This is an interface for Icons that derive from other Icons.
 * @author Milo Steier
 * @see DisabledIcon
 * @see ScaledIcon
 * @see DebuggingIcon
 */
public interface DerivedIcon extends Icon{
    /**
     * This returns the original Icon.
     * @return The original Icon.
     */
    public Icon getIcon();
    /**
     * This returns the icon's width. This delegates to the {@code getIconWidth} 
     * method of the {@link #getIcon() original icon}.
     * @return The width of the icon.
     * @see #getIcon() 
     */
    @Override
    public default int getIconWidth(){
            // If the original icon is not null, return its width. Otherwise 
        return (getIcon()!=null)?getIcon().getIconWidth():-1;   // return -1.
    }
    /**
     * This returns the icon's height. This delegates to the {@code 
     * getIconHeight} method of the {@link #getIcon() original icon}.
     * @return The height of the icon.
     * @see #getIcon() 
     */
    @Override
    public default int getIconHeight(){
            // If the original icon is not null, return its height. Otherwise 
        return (getIcon()!=null)?getIcon().getIconHeight():-1;  // return -1.
    }
}
