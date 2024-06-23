/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package icons.box;

import icons.*;
import java.awt.*;
import java.util.Objects;

/**
 * This is a BoxIcon that wraps around and derives stuff from another BoxIcon. 
 * This is primarily for situations where a variant of a BoxIcon that can 
 * reflect changes to the original is desired, such as a BoxIcon that has a 
 * different outline color to the original.
 * @author Milo Steier
 * @see BoxIcon
 * @see ColorBoxIcon
 * @see SelectColorBoxIcon
 * @see DisabledBoxIcon
 * @see RolloverBoxIcon
 */
public abstract class DerivedBoxIcon extends BoxIcon implements DerivedIcon{
    /**
     * This stores the original icon.
     */
    private final BoxIcon icon;
    /**
     * This constructs a DerivedBoxIcon that derives from the given BoxIcon.
     * @param icon The icon to derive from (cannot be null).
     */
    public DerivedBoxIcon(BoxIcon icon){
        super(0,0);
        this.icon = Objects.requireNonNull(icon, "Box Icon cannot be null");
    }
    /**
     * This returns the underlying BoxIcon for this DerivedBoxIcon.
     * @return The underlying icon.
     */
    @Override
    public BoxIcon getIcon(){
        return icon;
    }
    /**
     * {@inheritDoc } This delegates to the {@code getOutline} method of the 
     * {@link #getIcon() underlying icon}.
     * @return {@inheritDoc } 
     * @see #getIcon() 
     * @see #paintIcon2D 
     */
    @Override
    protected Color getOutline(){
        return getIcon().getOutline();
    }
    /**
     * {@inheritDoc } This delegates to the {@code getBackground} method of the 
     * {@link #getIcon() underlying icon}.
     * @return {@inheritDoc } 
     * @see #getIcon() 
     * @see #paintIcon2D 
     * @see #isOpaque() 
     * @see #setOpaque(boolean) 
     */
    @Override
    protected Color getBackground(){
        return getIcon().getBackground();
    }
    /**
     * {@inheritDoc } This delegates to the {@code getContentGap} method of the 
     * {@link #getIcon() underlying icon}.
     * @return {@inheritDoc } 
     * @see #getIcon() 
     * @see #getIconWidth() 
     * @see #getIconHeight() 
     * @see #setContentGap(int) 
     */
    @Override
    public int getContentGap(){
        return getIcon().getContentGap();
    }
    /**
     * {@inheritDoc } This will also set the gap for {@link #getIcon() 
     * underlying icon} since this delegates to the {@code setContentGap} method 
     * of the underlying icon.
     * @param gap {@inheritDoc }
     * @throws IllegalArgumentException {@inheritDoc }
     * @see #getIcon() 
     * @see #getIconWidth() 
     * @see #getIconHeight() 
     * @see #getContentGap() 
     */
    @Override
    public void setContentGap(int gap){
        getIcon().setContentGap(gap);
    }
    /**
     * {@inheritDoc } This delegates to the {@code paintContents} method of the 
     * {@link #getIcon() underlying icon}.
     * @param g {@inheritDoc }
     * @param c {@inheritDoc }
     * @param x {@inheritDoc }
     * @param y {@inheritDoc }
     * @param width {@inheritDoc }
     * @param height {@inheritDoc }
     * @see #getIcon() 
     * @see #paintIcon2D 
     * @see #getIconWidth() 
     * @see #getIconHeight() 
     * @see #getContentGap() 
     */
    @Override
    protected void paintContents(Graphics2D g, Component c, int x, int y, 
            int width, int height) {
        getIcon().paintContents(g, c, x, y, width, height);
    }
    /**
     * {@inheritDoc } This delegates to the {@code configureGraphics} method of 
     * the {@link #getIcon() underlying icon}.
     * @param g {@inheritDoc } 
     * @see #getIcon() 
     * @see #paintIcon2D 
     */
    @Override
    protected void configureGraphics(Graphics2D g){
        getIcon().configureGraphics(g);
    }
    /**
     * {@inheritDoc } 
     * @return {@inheritDoc } 
     * @see #getIcon() 
     * @see #getIconHeight() 
     * @see #getIconSize(java.awt.Dimension) 
     * @see #getIconSize() 
     * @see #setIconSize(int, int) 
     * @see #setIconSize(java.awt.Dimension) 
     */
    @Override
    public int getIconWidth(){
        return getIcon().getIconWidth();
    }
    /**
     * {@inheritDoc }
     * @return {@inheritDoc } 
     * @see #getIcon() 
     * @see #getIconWidth() 
     * @see #getIconSize(java.awt.Dimension) 
     * @see #getIconSize() 
     * @see #setIconSize(int, int) 
     * @see #setIconSize(java.awt.Dimension) 
     */
    @Override
    public int getIconHeight(){
        return getIcon().getIconHeight();
    }
    /**
     * {@inheritDoc } This will also set the size of the {@link #getIcon() 
     * underlying icon} since this delegates to the {@code setIconSize} method 
     * of the underlying icon.
     * @param width {@inheritDoc }
     * @param height {@inheritDoc }
     * @see #getIcon() 
     * @see #getIconWidth()
     * @see #getIconHeight()
     * @see #getIconSize(java.awt.Dimension) 
     * @see #getIconSize() 
     * @see #setIconSize(java.awt.Dimension) 
     */
    @Override
    public void setIconSize(int width, int height){
        getIcon().setIconSize(width, height);
    }
    /**
     * {@inheritDoc } This delegates to the {@code isOpaque} method of the 
     * {@link #getIcon() underlying icon}.
     * @return {@inheritDoc } 
     * @see #getIcon() 
     * @see #setOpaque(boolean) 
     */
    @Override
    public boolean isOpaque(){
        return getIcon().isOpaque();
    }
    /**
     * {@inheritDoc } This will also set whether the {@link #getIcon() 
     * underlying icon} is opaque since this delegates to the {@code setOpaque} 
     * method of the underlying icon.
     * @param value {@inheritDoc }
     * @see #getIcon() 
     * @see #isOpaque() 
     */
    @Override
    public void setOpaque(boolean value){
        getIcon().setOpaque(value);
    }
    /**
     * This compares this DerivedBoxIcon with the given DerivedBoxIcon to see if 
     * they match. Two DerivedBoxIcon are equal if they have the same {@link 
     * #getIcon() underlying icon}.
     * @param icon The DerivedBoxIcon to be compared with.
     * @return Whether the icon is equal to this DerivedBoxIcon.
     * @see #getIcon() 
     * @see #equals(java.lang.Object) 
     */
    protected boolean equals(DerivedBoxIcon icon){
        return icon == this || (icon != null && this.icon.equals(icon.icon));
    }
    /**
     * This compares this DerivedBoxIcon with the given object to see if it 
     * matches this DerivedBoxIcon. Two DerivedBoxIcon are equal if they have 
     * the same {@link #getIcon() underlying icon}.
     * @param obj The object to be compared with.
     * @return Whether the object is equal to this DerivedBoxIcon.
     * @see #getIcon() 
     */
    @Override
    public boolean equals(Object obj){
        if (obj == this)                        // If the object is this
            return true;
        else if (obj instanceof DerivedBoxIcon) // If the object is a DerivedBoxIcon
            return equals((DerivedBoxIcon)obj);
        return false;
    }
    /**
     * This returns the hash code for this DerivedBoxIcon.
     * @return The hash code for this DerivedBoxIcon.
     */
    @Override
    public int hashCode() {
        int hash = 3;   // Get the hash code
        hash = 71 * hash + Objects.hashCode(this.icon);
        return hash;
    }
    @Override
    protected String paramString(){
        return "icon="+getIcon().toString();
    }
}
