/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.image.BufferedImage;
import static java.beans.BeanInfo.*;

/**
 * This is a class that can be used to create procedurally generated images to 
 * use for the icon of a BeanInfo, and allows for all four possible variants 
 * of icons to be supported without having to write code for each one. This also 
 * provides some commonly used colors and methods for painting the image used 
 * for the icon. <p>
 * 
 * To make things easy and simple, the icon generated is controlled by two 
 * values that are derived from the icon's type: the scale and the color mode. 
 * The scale determines the size of the icon, and is traditionally 1 if the icon 
 * is to be 16 x 16 and 2 if the icon is to be 32 x 32. Any scale less than or 
 * equal to zero will result in no icon being generated. The color mode 
 * determines whether the icon should be a color or monochrome icon, with 0 
 * indicating a color icon and 1 indicating a monochrome icon. This is done for 
 * ease of programming, as the color mode can act as an index for an array in a 
 * two-dimensional array of colors for the icon. Any color mode less than zero 
 * will result in no icon being generated, and any color mode greater than 1 is 
 * undefined and may result in unpredictable behavior (typically an 
 * IndexOutOfBoundsException being thrown).
 * 
 * @author Milo Steier
 * @see java.beans.BeanInfo BeanInfo
 * @see java.beans.BeanInfo#getIcon(int) 
 * @see java.beans.SimpleBeanInfo SimpleBeanInfo
 * @see java.beans.SimpleBeanInfo#loadImage(java.lang.String) 
 * @see java.beans.BeanInfo#ICON_COLOR_16x16 ICON_COLOR_16x16
 * @see java.beans.BeanInfo#ICON_COLOR_32x32 ICON_COLOR_32x32
 * @see java.beans.BeanInfo#ICON_MONO_16x16 ICON_MONO_16x16
 * @see java.beans.BeanInfo#ICON_MONO_32x32 ICON_MONO_32x32
 */
public abstract class BeanInfoIconFactory {
    /**
     * This is the color that is commonly used as a shadow behind most icons. 
     * This is a gray color that is half transparent.
     */
    public static final Color SHADOW_COLOR = new Color(0x80808080,true);
    /**
     * This contains a completely transparent color.
     */
    public static final Color TRANSPARENT_COLOR = new Color(0,0,0,0);
    /**
     * This contains multiple colors that are commonly used with BeanInfo icons. 
     * The first array contains the colors to use for color icons, while the 
     * second array contains the colors to use for monochrome icons. The third 
     * array contains the colors shared between color and monochrome icons. The 
     * first and second arrays will always be the same length, but the third 
     * array may not be the same length as the first and second arrays. These 
     * arrays are subject to change, with more colors being added as time goes 
     * on.
     */
    public static final Color[][] COMMON_INFO_ICON_COLORS = {
        {new Color(0x8694A2), new Color(0x55606B), new Color(0xDCE5EE)},
        {new Color(0x949494), new Color(0x606060), new Color(0xE5E5E5)},
        {new Color(0xF3F3F3), new Color(0xE0E0E0)}
    };
    /**
     * This creates and returns a vertical gradient from {@code y1} to {@code 
     * y2-1} starting with the color {@code color1} and ending with the color 
     * {@code color2}.
     * @param y1 The starting y-coordinate.
     * @param y2 The ending y-coordinate.
     * @param color1 The starting color.
     * @param color2 The ending color.
     * @return A vertical gradient from {@code y1} to {@code y2} using the given 
     * colors.
     * @see #createVerticalGradient(float, float, int, int) 
     */
    public static GradientPaint createVerticalGradient(float y1, float y2, 
            Color color1, Color color2){
        return new GradientPaint(0, y1, color1, 0, y2-1, color2);
    }
    /**
     * This creates and returns a vertical gradient from {@code y1} to {@code 
     * y2-1} starting with the color with {@code rgb1} RGB values and ending 
     * with the color with {@code rgb2} RGB values.
     * @param y1 The starting y-coordinate.
     * @param y2 The ending y-coordinate.
     * @param rgb1 The RGB values for the starting color.
     * @param rgb2 The RGB values for the ending color.
     * @return A vertical gradient from {@code y1} to {@code y2} using the given 
     * colors.
     * @see #createVerticalGradient(float, float, java.awt.Color, java.awt.Color) 
     */
    public static GradientPaint createVerticalGradient(float y1, float y2, 
            int rgb1, int rgb2){
        return createVerticalGradient(y1,y2,new Color(rgb1),new Color(rgb2));
    }
    /**
     * This checks to see if the color mode is valid, and if not, throws an 
     * IllegalArgumentException.
     * @param colorMode The color mode to check.
     * @throws IllegalArgumentException If the given color mode is neither 0 or 
     * 1.
     */
    protected static void checkColorMode(int colorMode){
            // If the color mode is out of range
        if (colorMode < 0 || colorMode >= 2)
            throw new IllegalArgumentException("Invalid color mode (" + 
                    colorMode + " is neither 0 (color) or 1 (mono))");
    }
    /**
     * This creates and returns a vertical gradient from {@code y1} to {@code 
     * y2-1} using the common outline gradient colors. The common outline 
     * gradient colors are the first two colors in the first and second {@link 
     * #COMMON_INFO_ICON_COLORS common color arrays}.
     * @param y1 The starting y-coordinate.
     * @param y2 The ending y-coordinate.
     * @param colorMode The color mode to use (0 for color, 1 for monochrome).
     * @return The gradient to use for the outline.
     * @throws IllegalArgumentException If the given color mode is neither 0 or 
     * 1.
     * @see #createVerticalGradient(float, float, java.awt.Color, java.awt.Color) 
     * @see #COMMON_INFO_ICON_COLORS
     * @see #createOutlineGradient(float, float, boolean) 
     */
    public static GradientPaint createOutlineGradient(float y1, float y2, 
            int colorMode){
        checkColorMode(colorMode);
        return createVerticalGradient(y1,y2,
                COMMON_INFO_ICON_COLORS[colorMode][0],
                COMMON_INFO_ICON_COLORS[colorMode][1]);
    }
    /**
     * This creates and returns a vertical gradient from {@code y1} to {@code 
     * y2-1} using the common outline gradient colors. The common outline 
     * gradient colors are the first two colors in the first and second {@link 
     * #COMMON_INFO_ICON_COLORS common color arrays}. This is equivalent to 
     * calling {@link #createOutlineGradient(float, float, int) 
     * createOutlineGradient}{@code (y1,y2,(mono)?1:0)}.
     * @param y1 The starting y-coordinate.
     * @param y2 The ending y-coordinate.
     * @param mono True if the gradient should be monochrome, false otherwise.
     * @return The gradient to use for the outline.
     * @see #createVerticalGradient(float, float, java.awt.Color, java.awt.Color) 
     * @see #COMMON_INFO_ICON_COLORS
     * @see #createOutlineGradient(float, float, int) 
     */
    public static GradientPaint createOutlineGradient(float y1, float y2, 
            boolean mono){
        return createOutlineGradient(y1,y2,(mono)?1:0);
    }
    /**
     * This creates and returns a vertical gradient from {@code y1} to {@code 
     * y2-1} using the common light gray fill gradient colors. The common light 
     * gray fill gradient colors are the first two colors in the third {@link 
     * #COMMON_INFO_ICON_COLORS common color array}.
     * @param y1 The starting y-coordinate.
     * @param y2 The ending y-coordinate.
     * @return The light gray fill gradient.
     * @see #createVerticalGradient(float, float, java.awt.Color, java.awt.Color) 
     */
    public static GradientPaint createLightGrayFillGradient(float y1, float y2){
        return createVerticalGradient(y1,y2,COMMON_INFO_ICON_COLORS[2][0],
                COMMON_INFO_ICON_COLORS[2][1]);
    }
    /**
     * This creates and returns a vertical gradient from {@code y1} to {@code 
     * y2-1} using the common light blue fill gradient colors. The common light 
     * blue fill gradient colors consist of the third color in the first and 
     * second {@link #COMMON_INFO_ICON_COLORS common color arrays} and the color 
     * {@link Color#WHITE white}.
     * @param y1 The starting y-coordinate.
     * @param y2 The ending y-coordinate.
     * @param colorMode The color mode to use (0 for color, 1 for monochrome).
     * @return The light blue fill gradient.
     * @throws IllegalArgumentException If the given color mode is neither 0 or 
     * 1.
     * @see #createVerticalGradient(float, float, java.awt.Color, java.awt.Color) 
     * @see #COMMON_INFO_ICON_COLORS
     * @see Color#WHITE
     * @see #createLightBlueFillGradient(float, float, boolean) 
     */
    public static GradientPaint createLightBlueFillGradient(float y1, float y2, 
            int colorMode){
        checkColorMode(colorMode);
        return createVerticalGradient(y1,y2,
                COMMON_INFO_ICON_COLORS[colorMode][2],Color.WHITE);
    }
    /**
     * This creates and returns a vertical gradient from {@code y1} to {@code 
     * y2-1} using the common light blue fill gradient colors. The common light 
     * blue fill gradient colors consist of the third color in the first and 
     * second {@link #COMMON_INFO_ICON_COLORS common color arrays} and the color 
     * {@link Color#WHITE white}.  This is equivalent to calling {@link 
     * #createLightBlueFillGradient(float, float, int) 
     * createLightBlueFillGradient}{@code (y1,y2,(mono)?1:0)}.
     * @param y1 The starting y-coordinate.
     * @param y2 The ending y-coordinate.
     * @param mono True if the gradient should be monochrome, false otherwise.
     * @return The light blue fill gradient.
     * @see #createVerticalGradient(float, float, java.awt.Color, java.awt.Color) 
     * @see #COMMON_INFO_ICON_COLORS
     * @see Color#WHITE
     * @see #createLightBlueFillGradient(float, float, int) 
     */
    public static GradientPaint createLightBlueFillGradient(float y1, float y2, 
            boolean mono){
        return createLightBlueFillGradient(y1,y2,(mono)?1:0);
    }
    
    
    
    /**
     * This constructs a BeanInfoIconFactory.
     */
    public BeanInfoIconFactory(){ }
    /**
     * This returns the scale to use for the kind of icon that was requested. If 
     * this returns a value less than or equal to zero, then no icon will be 
     * generated.
     * @param iconKind The kind of icon that was requested.
     * @return The scale for the icon (1 for 16 x 16 icons, 2 for 32 x 32 
     * icons), or -1 if no icon is available for the requested kind of icon.
     * @see #createIconImage(int) 
     * @see #paintImage
     * @see #getImageColorMode
     * @see java.beans.BeanInfo#ICON_COLOR_16x16 ICON_COLOR_16x16
     * @see java.beans.BeanInfo#ICON_COLOR_32x32 ICON_COLOR_32x32
     * @see java.beans.BeanInfo#ICON_MONO_16x16 ICON_MONO_16x16
     * @see java.beans.BeanInfo#ICON_MONO_32x32 ICON_MONO_32x32
     */
    protected int getScaleForImage(int iconKind){
        switch(iconKind){
            case ICON_COLOR_16x16:  // 16x16 color icon
            case ICON_MONO_16x16:   // 16x16 monochrome icon
                return 1;
            case ICON_COLOR_32x32:  // 32x32 color icon
            case ICON_MONO_32x32:   // 32x32 monochrome icon
                return 2;
        }
        return -1;
    }
    /**
     * This returns the color mode to use for the icon. That is to say, this 
     * returns whether the icon is in color or monochrome. This is an integer 
     * primarily for ease of programming, as it is fairly easy to use a 
     * two-dimensional array of colors and have one array store the colors for 
     * color icons and the other array store the colors for monochrome icons. If 
     * this returns a value less than zero, then no icon will be generated. Any 
     * value greater than 1 is undefined and may result in unpredictable 
     * behavior.
     * @param iconKind The kind of icon that was requested.
     * @return The color mode for the icon (0 for color icons, 1 for monochrome 
     * icons), or -1 if no icon is available for the requested kind of icon.
     * @see #createIconImage(int) 
     * @see #paintImage
     * @see #getScaleForImage
     * @see java.beans.BeanInfo#ICON_COLOR_16x16 ICON_COLOR_16x16
     * @see java.beans.BeanInfo#ICON_COLOR_32x32 ICON_COLOR_32x32
     * @see java.beans.BeanInfo#ICON_MONO_16x16 ICON_MONO_16x16
     * @see java.beans.BeanInfo#ICON_MONO_32x32 ICON_MONO_32x32
     */
    protected int getImageColorMode(int iconKind){
        switch(iconKind){
            case ICON_COLOR_16x16:  // 16x16 color icon
            case ICON_COLOR_32x32:  // 32x32 color icon
                return 0;
            case ICON_MONO_16x16:   // 16x16 monochrome icon
            case ICON_MONO_32x32:   // 32x32 monochrome icon
                return 1;
        }
        return -1;
    }
    /**
     * This is used to render the image for the icon. This is called by {@link 
     * #createIconImage(int) createIconImage} to render the image and is given 
     * the value returned by {@link #getScaleForImage(int) getScaleForImage} for 
     * the {@code scale} and the value returned by {@link 
     * #getImageColorMode(int) getImageColorMode} for {@code colorMode}.
     * @param g The graphics context to render to.
     * @param scale The scale for the icon (1 for 16x16 icons, 2 for 32x32 
     * icons).
     * @param colorMode The color mode for the icon (0 for color icons, 1 for 
     * monochrome icons).
     * @param w The width of the icon (this will be {@code 16 * scale}).
     * @param h The height of the icon (this will be {@code 16 * scale}).
     * @see #getScaleForImage
     * @see #getImageColorMode
     * @see #createIconImage(int) 
     */
    protected abstract void paintImage(java.awt.Graphics2D g, int scale, 
            int colorMode, int w, int h);
    /**
     * This creates and returns an image object that can be used to represent 
     * the bean that this BeanInfoIconFactory is used for. 
     * @param iconKind The kind of icon requested. This should be one of the
     * constant values ICON_COLOR_16x16, ICON_COLOR_32x32, ICON_MONO_16x16, or
     * ICON_MONO_32x32.
     * @return An image object representing the requested icon, or null if no 
     * suitable icon is available.
     * @see #createIconImage(int, java.lang.String, java.beans.SimpleBeanInfo) 
     * @see #createIcon(int) 
     * @see java.beans.BeanInfo#getIcon(int) 
     * @see java.beans.BeanInfo#ICON_COLOR_16x16 ICON_COLOR_16x16
     * @see java.beans.BeanInfo#ICON_COLOR_32x32 ICON_COLOR_32x32
     * @see java.beans.BeanInfo#ICON_MONO_16x16 ICON_MONO_16x16
     * @see java.beans.BeanInfo#ICON_MONO_32x32 ICON_MONO_32x32
     */
    public java.awt.Image createIconImage(int iconKind){
        int scale = getScaleForImage(iconKind); // The scale for the icon
            // The index for the array of colors to use
        int cIndex = getImageColorMode(iconKind);
            // If the scale is less than 1 or the color array index is less than
            // zero (either case will indicate that no image should be drawn)
        if (scale < 1 || cIndex < 0)
            return null;
            // This gets the image for the icon
        BufferedImage img = new BufferedImage(16*scale,16*scale,BufferedImage.TYPE_INT_ARGB);
            // The graphics object used to paint the image
        java.awt.Graphics2D g = img.createGraphics();
        paintImage(g,scale,cIndex,img.getWidth(),img.getHeight());
        g.dispose();
        
        return img;
    }
    /**
     * This creates and returns an image object that can be used to represent 
     * the bean that this BeanInfoIconFactory is used for. This priorities 
     * loading the image at the given resource path using the given 
     * SimpleBeanInfo's {@link 
     * java.beans.SimpleBeanInfo#loadImage(java.lang.String) loadImage} method 
     * if neither of them are null. If either {@code resourceName} or {@code 
     * info} are null or the image returned by {@code 
     * info.loadImage(resourceName)} is null, then this will call {@link 
     * #createIconImage(int) createIconImage} with the given icon kind.
     * @param iconKind The kind of icon requested. This should be one of the
     * constant values ICON_COLOR_16x16, ICON_COLOR_32x32, ICON_MONO_16x16, or
     * ICON_MONO_32x32.
     * @param resourceName A pathname relative to the directory holding the 
     * class file of the current class, or null.
     * @param info The SimpleBeanInfo that represents the bean to get the icon 
     * for.
     * @return An image object representing the requested icon, or null if no 
     * suitable icon is available.
     * @see #createIconImage(int) 
     * @see #createIcon(int, java.lang.String, java.beans.SimpleBeanInfo) 
     * @see java.beans.SimpleBeanInfo#loadImage(java.lang.String) 
     * @see java.beans.BeanInfo#getIcon(int) 
     * @see java.beans.BeanInfo#ICON_COLOR_16x16 ICON_COLOR_16x16
     * @see java.beans.BeanInfo#ICON_COLOR_32x32 ICON_COLOR_32x32
     * @see java.beans.BeanInfo#ICON_MONO_16x16 ICON_MONO_16x16
     * @see java.beans.BeanInfo#ICON_MONO_32x32 ICON_MONO_32x32
     */
    public java.awt.Image createIconImage(int iconKind, String resourceName, 
            java.beans.SimpleBeanInfo info){
        java.awt.Image img = null;      // Gets the image loaded
            // If the resource name is not null and the bean info is not null
        if (resourceName != null && info != null)
            img = info.loadImage(resourceName);
            // If an image was loaded from the resource, return it. Otherwise, 
            // create the icon and return it.
        return (img != null) ? img : createIconImage(iconKind);
    }
    /**
     * This returns an icon displaying the image object returned by {@link 
     * #createIconImage(int) createIconImage}. This is equivalent to calling 
     * {@code createIconImage} and passing that into the constructor for an 
     * {@link javax.swing.ImageIcon ImageIcon}.
     * @param iconKind The kind of icon requested. This should be one of the
     * constant values ICON_COLOR_16x16, ICON_COLOR_32x32, ICON_MONO_16x16, or
     * ICON_MONO_32x32.
     * @return An ImageIcon object representing the requested icon, or null if 
     * no suitable icon is available.
     * @see #createIconImage(int) 
     * @see #createIcon(int, java.lang.String, java.beans.SimpleBeanInfo) 
     * @see java.beans.BeanInfo#ICON_COLOR_16x16 ICON_COLOR_16x16
     * @see java.beans.BeanInfo#ICON_COLOR_32x32 ICON_COLOR_32x32
     * @see java.beans.BeanInfo#ICON_MONO_16x16 ICON_MONO_16x16
     * @see java.beans.BeanInfo#ICON_MONO_32x32 ICON_MONO_32x32
     */
    public javax.swing.ImageIcon createIcon(int iconKind){
        java.awt.Image img = createIconImage(iconKind);     // Create the image
            // If the image is not null, create an icon for it. Otherwise, 
        return (img != null)?new javax.swing.ImageIcon(img):null;// return null
    }
    /**
     * This returns an icon displaying the image object returned by {@link 
     * #createIcon(int, java.lang.String, java.beans.SimpleBeanInfo) 
     * createIconImage}. This is equivalent to calling {@code createIconImage} 
     * and passing that into the constructor for an {@link javax.swing.ImageIcon 
     * ImageIcon}.
     * @param iconKind The kind of icon requested. This should be one of the
     * constant values ICON_COLOR_16x16, ICON_COLOR_32x32, ICON_MONO_16x16, or
     * ICON_MONO_32x32.
     * @param resourceName A pathname relative to the directory holding the 
     * class file of the current class, or null.
     * @param info The SimpleBeanInfo that represents the bean to get the icon 
     * for.
     * @return An ImageIcon object representing the requested icon, or null if 
     * no suitable icon is available.
     * @see #createIconImage(int, java.lang.String, java.beans.SimpleBeanInfo) 
     * @see #createIcon(int) 
     * @see java.beans.SimpleBeanInfo#loadImage(java.lang.String) 
     * @see java.beans.BeanInfo#ICON_COLOR_16x16 ICON_COLOR_16x16
     * @see java.beans.BeanInfo#ICON_COLOR_32x32 ICON_COLOR_32x32
     * @see java.beans.BeanInfo#ICON_MONO_16x16 ICON_MONO_16x16
     * @see java.beans.BeanInfo#ICON_MONO_32x32 ICON_MONO_32x32
     */
    public javax.swing.ImageIcon createIcon(int iconKind, String resourceName, 
            java.beans.SimpleBeanInfo info){
            // Create the image
        java.awt.Image img = createIconImage(iconKind,resourceName,info);
            // If the image is not null, create an icon for it. Otherwise, 
        return (img != null)?new javax.swing.ImageIcon(img):null;// return null
    }
}
