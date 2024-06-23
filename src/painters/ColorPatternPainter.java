/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package painters;

import java.awt.*;
import java.awt.geom.*;
import java.util.EventListener;
import java.util.Objects;
import javax.swing.*;
import javax.swing.event.*;

/**
 * This is a simple painter that generates and displays a pattern can be used to 
 * test things that display painters. If given a color, then the pattern will be 
 * derived from that color. Otherwise, the pattern will be generated using a set 
 * of predefined colors. The painter can be displayed in a horizontal or 
 * vertical, orientation, can be flipped, and can have its colors inverted. The 
 * colors can also be drawn using an actual gradient instead of the 
 * pseudo-gradient that it defaults to. Each setter method will return the 
 * calling ColorPatternPainter so that they can be chained together to change 
 * multiple properties with a single line of code. When the value for the 
 * {@link #getState state} changes, any {@code ChangeListener}s registered to 
 * the painter will be notified.
 * @author Milo Steier
 * @see icons.ColorPatternIcon
 */
public class ColorPatternPainter implements Painter<Color>{
    /**
     * This is the flag for whether the graphic is in a horizontal or vertical 
     * orientation. If this is set, then the graphic is in a vertical 
     * orientation.
     */
    public static final int VERTICAL_ORIENTATION_FLAG = 0x01;
    /**
     * This is the flag for whether the graphic is flipped around by 180 
     * degrees.
     */
    public static final int FLIPPED_FLAG = 0x02;
    /**
     * This is the flag for whether the colors for the graphic are inverted to 
     * produce a negative image.
     */
    public static final int INVERTED_FLAG = 0x04;
    /**
     * This is the flag for whether the graphic will render its normal pattern 
     * or a true gradient.
     */
    public static final int TRUE_GRADIENT_FLAG = 0x08;
    /**
     * This is the flag for whether the graphic will fade to black or white for 
     * its pattern. When set, the color fades to white in the center. Otherwise, 
     * the color fades to black.
     */
    public static final int FADE_TO_WHITE_FLAG = 0x10;
    /**
     * This stores the maximum value a {@code ColorPatternPainter}'s state can 
     * be and still be considered valid.
     * @see #VERTICAL_ORIENTATION_FLAG
     * @see #FLIPPED_FLAG
     * @see #INVERTED_FLAG
     * @see #TRUE_GRADIENT_FLAG
     * @see FADE_TO_WHITE_FLAG
     */
    public static final int MAXIMUM_VALID_STATE = VERTICAL_ORIENTATION_FLAG | 
            FLIPPED_FLAG | INVERTED_FLAG | TRUE_GRADIENT_FLAG | FADE_TO_WHITE_FLAG;
    /**
     * This stores the values to use for generating the pattern, in the range of 
     * (0 - 255). Each color is derived from one of these to get the color to 
     * use for that section. This is the same as {@link #FLOATING_RANGE_VALUES}, 
     * except that this stores integer values for the colors.
     * @see #FLOATING_RANGE_VALUES
     */
    protected static final int[] COLOR_RANGE_VALUES = {
        0xFF,0xE0,0xC0,0xA0,0x80,0x60,0x40,0x20,0x00
    };
    /**
     * This converts the values in {@link #COLOR_RANGE_VALUES} into floating 
     * point values in the range of (0.0 - 1.0) to use when getting the color to 
     * use from a set color.
     * @return The floating point versions of the values in {@link 
     * #COLOR_RANGE_VALUES}.
     * @see #COLOR_RANGE_VALUES
     * @see #FLOATING_RANGE_VALUES
     */
    private static float[] getFloatRangeValues(){
            // An array to get the values as floating point numbers
        float[] values = new float[COLOR_RANGE_VALUES.length];
            // A for loop to set the values in the array
        for (int i = 0; i < values.length; i++)
            values[i] = (float)(COLOR_RANGE_VALUES[i] / 255.0);
        return values;
    }
    /**
     * This stores the values to use for generating the pattern, in the range of 
     * (0.0 - 0.1). Each color is derived from one of these to get the color to 
     * use for that section.This is the same as {@link #COLOR_RANGE_VALUES}, 
     * except that this stores floating point values for the colors.
     * @see #COLOR_RANGE_VALUES
     */
    protected static final float[] FLOATING_RANGE_VALUES = getFloatRangeValues();
    /**
     * This stores the distribution of colors for the gradients if a graphic is 
     * using gradients.
     */
    private static final float[] GRADIENT_FRACTIONS = new float[]{0.0f,0.5f,1.0f};
    /**
     * This contains the default colors to use for the gradients when a graphic 
     * is using gradients with no color provided. This contains two arrays, the 
     * first fades to black, and the second fades to white.
     */
    protected static final Color[][][] DEFAULT_GRADIENT_COLORS=new Color[][][]{{
        {Color.RED,Color.BLACK,Color.GREEN},
        {Color.BLUE,Color.BLACK,Color.WHITE}
    }, {
        {Color.RED,Color.WHITE,Color.GREEN},
        {Color.BLUE,Color.WHITE,Color.BLACK}
    }};
    /**
     * The default color to use for the border of a {@code ColorPatternPainter} 
     * when no color has been set.
     */
    protected static final Color DEFAULT_BORDER_COLOR = new Color(0xFF8000);
    /**
     * This is the internal width and height for the graphic. That is to say, 
     * this is the width and height at which the graphic is actually rendered 
     * at, with the graphic being scaled up or down to match the actual size 
     * provided.
     */
    protected static final int INTERNAL_SIZE = 20;
    /**
     * This returns a two-dimensional array containing the default colors to use 
     * for the color pattern when no color is set. When a {@code 
     * ColorPatternPainter} does not have a color provided, the pattern they 
     * display will consist of the four colors red, green, blue, and white. Each 
     * array in the returned two-dimensional array contains the value for each 
     * of the colors, with the first index of each array containing the red 
     * color, the second containing the green color, the third containing the 
     * blue color, and the last containing the white color to use for that 
     * value.
     * @return The default colors for the pattern.
     * @see #getUsesGradient
     * @see #setUsesGradient
     * @see #COLOR_RANGE_VALUES
     * @see #FLOATING_RANGE_VALUES
     * @deprecated Use {@link getDefaultColorsFull()} instead.
     */
    @Deprecated
    protected static Color[][] getDefaultColors(){
        return getDefaultColorsFull()[0];
    }
    /**
     * This returns a three-dimensional array containing the default colors to 
     * use for the color pattern when no color is set. When a {@code 
     * ColorPatternPainter} does not have a color provided, the pattern they 
     * display will consist of the four colors red, green, blue, and either 
     * white or black, depending on whether they fade to black or white. The 
     * returned three-dimensional array contains two two-dimensional arrays, the 
     * first one fades to black, and the second one fades to white. Each array 
     * in the two-dimensional arrays contains the value for each of the colors, 
     * with the first index of each array containing the red color, the second 
     * containing the green color, the third containing the blue color, and the 
     * last containing the white or black color to use for that value.
     * @return The default colors for the pattern.
     * @see #getUsesGradient
     * @see #setUsesGradient
     * @see #getFadesToWhite 
     * @see #setFadesToWhite
     * @see #COLOR_RANGE_VALUES
     * @see #FLOATING_RANGE_VALUES
     * @see DEFAULT_GRADIENT_COLORS
     */
    protected static Color[][][] getDefaultColorsFull(){
        if (defaultColors == null){     // If the array has not been initialized
            defaultColors = new Color[DEFAULT_GRADIENT_COLORS.length]
                    [COLOR_RANGE_VALUES.length][4];
                // A for loop to initialize the colors
            for (int i = 0; i < defaultColors[0].length; i++){
                    // Get the current value in the range
                int value = COLOR_RANGE_VALUES[i];
                    // A for loop to initialize the red, green, blue, and white
                    // and black values
                for (int r = 0; r < defaultColors[0][i].length; r++){
                    int b0 = r % 2;     // This gets the first bit in r
                    int b1 = r >> 1;    // This gets the second bit in r
                        // This gets if the red channel is used
                    int red = (1 & ~(b0 ^ b1));
                        // Use the bits to control the color produced for the 
                    defaultColors[0][i][r] = new Color( // fade to black
                            value*red,
                            value*b0,
                            value*b1);
                        // Use the bits to control the color produced for the 
                    defaultColors[1][i][r] = new Color( // fade to white
                            0xFF - (value * (b0 | b1)),
                            0xFF - (value * (red | b1)),
                            0xFF - (value * (red | b0)));
                }
            }
        }
        return defaultColors;
    }
    /**
     * This is an array containing the default colors to use for the pattern 
     * when no color has been set. This is initialized the first time a {@code 
     * ColorPatternPainter} invokes its {@link #getDefaultColorsFull
     * getDefaultColorsFull} method. When a {@code ColorPatternPainter}'s {@code 
     * paint} method is invoked with a null color, the pattern will be rendered 
     * from four colors instead of one, with those colors being red, green, 
     * blue, and either white or black, depending on whether the pattern fades 
     * to black or white.
     */
    private static Color[][][] defaultColors = null;
    /**
     * This stores the state for this ColorPatternPainter.
     */
    private int state;
    /**
     * This is a scratch Point2D object to use when generating the starting 
     * point for gradients. This is initially null and is initialized the first 
     * time it is used.
     */
    private Point2D startPoint = null;
    /**
     * This is a scratch Point2D object to use when generating the end point for 
     * gradients. This is initially null and is initialized the first time it is 
     * used.
     */
    private Point2D endPoint = null;
    /**
     * This is a scratch Rectangle2D object to use when filling a rectangle 
     * using the {@code fillRectangle} method. This is initially null and is 
     * initialized the first time it is used.
     */
    private Rectangle2D fillRect = null;
    /**
     * The list of EventListeners registered to this painter.
     */
    protected EventListenerList listenerList;
    /**
     * This constructs a {@code ColorPatternPainter} with the given state.
     * @param state The state for this painter (must be a positive integer 
     * between 0 and {@link #MAXIMUM_VALID_STATE}, inclusive).
     * @throws IllegalArgumentException If the given state is invalid.
     * @see #VERTICAL_ORIENTATION_FLAG
     * @see #FLIPPED_FLAG
     * @see #INVERTED_FLAG
     * @see #TRUE_GRADIENT_FLAG
     * @see #FADE_TO_WHITE_FLAG
     * @see #MAXIMUM_VALID_STATE
     */
    public ColorPatternPainter(int state){
        ColorPatternPainter.this.checkState(state);
        this.state = state;
        listenerList = new EventListenerList();
    }
    /**
     * This constructs a {@code ColorPatternPainter} with the default state of 
     * zero.
     */
    public ColorPatternPainter(){
        this(0);
    }
    /**
     * This constructs a {@code ColorPatternPainter} that is a copy of the given 
     * {@code ColorPatternPainter}.
     * @param painter The ColorPatternPainter to copy.
     */
    public ColorPatternPainter(ColorPatternPainter painter){
        this(painter.getState());
    }
    /**
     * This returns a float array containing the RGB color and alpha components 
     * of a color with the same hue and saturation of the given color, but with 
     * a value of 1.0.
     * @param color The color to get the maximum value color for.
     * @return A float array containing the RGBA components for a color with 
     * the same hue and saturation but with the value set to its maximum.
     */
    protected static float[] getMaxRGBComponents(Color color){
            // Get the RGBA components of the currently set color
        float[] rgba = color.getRGBComponents(null);
        float value = 0;    // Get the value for the color in the HSV space
            // A for loop to get the largest value in the RGB components
        for (int i = 0; i < 3; i++)
            value = Math.max(value, rgba[i]);
            // A for loop to max out the RGB components while maintaining the 
        for (int i = 0; i < 3; i++)     // hue and saturation for the color
            rgba[i] /= value;
        return rgba;
    }
    /**
     * This returns a two-dimensional array of colors to use to create the 
     * gradients used to render the graphic if this painter is {@link 
     * #getUsesGradient using gradients}. If the given color is null, then the 
     * arrays will be derived from the {@link #DEFAULT_GRADIENT_COLORS} array. 
     * Otherwise, the colors in the array will be derived from the given color.
     * The first array contains the colors for the top or left gradient and the 
     * second array contains the colors for the bottom or right gradient. 
     * @param color The color to use to generate the gradient. If this is null, 
     * then this will instead use the {@link #DEFAULT_GRADIENT_COLORS default 
     * colors} to generate the gradients.
     * @return The arrays containing the colors to use for the gradients.
     * @see #getMaxRGBComponents
     * @see #getUsesGradient
     * @see #setUsesGradient 
     * @see #isInverted 
     * @see #setInverted  
     * @see #invertColor 
     * @see #isRenderedFlipped 
     * @see #isFlipped 
     * @see #setFlipped 
     * @see #isVertical 
     * @see #setVertical 
     * @see #setState 
     * @see #getState 
     * @see #paint 
     * @see #DEFAULT_GRADIENT_COLORS
     * @see #getGradients 
     * @see #getColors 
     */
    protected Color[][] getGradientColors(Color color){
            // This will get the arrays of colors to use for the gradients.
        Color[][] c = new Color[2][3];  
        if (color != null){    // If a color has been set
                // Get the RGBA components for the color with the largest value 
            float[] rgba = getMaxRGBComponents(color);  // in HSV
                // This gets the value to use for the red, green, and blue 
                // values for the color to fade to. If fading to black, this 
                // will be a zero. If fading to white, this will be a 1
            float fadeValue = (getFadesToWhite())?1:0;
                // Create an array with that color and a black or white with a 
                // similar alpha component so that they can be oscilated to make 
            Color[] source = new Color[]{   // the color arrays
                    // The color with the maxxed out RGBA components
                new Color(rgba[0],rgba[1],rgba[2],rgba[3]),
                    // Fade color with the color's alpha component
                new Color(fadeValue,fadeValue,fadeValue,rgba[3])
            };
                // If the graphic is rendered flipped, start the source color 
                // array at index 1. Otherwise, start it at index 0.
            int i = (isRenderedFlipped()) ? 1 : 0;
                // A for loop to go through the arrays in the two-dimensional 
            for (Color[] arr : c) { // array of gradient colors
                    // A for loop to go through the current array
                for (int y = 0; y < arr.length; y++, i++) 
                        // Oscilate between the two colors to use
                    arr[y] = source[i%source.length];
            }
        }
        else{   // A for loop to go through the two-dimensional arrays
                // Get the default color array to use. If this fades to white, 
                // use the second array. Otherwise, use the white array
            Color[][] defColor = DEFAULT_GRADIENT_COLORS[(getFadesToWhite())?1:0];
            for (int x = 0; x < c.length; x++){
                    // A for loop to go through the current array
                for (int y = 0; y < c[x].length; y++){
                        // If the graphic is rendered flipped, then go through 
                        // the default gradient color arrays backwards
                    int x1 = (isRenderedFlipped()) ? defColor.length-1-x : x;
                        // If the graphic is set to be flipped, then go through 
                        // the current default gradient color array backwards
                    int y1 = (isFlipped()) ? defColor[x1].length-1-y : y;
                        // Get the color from the default gradient colors
                    c[x][y] = defColor[x1][y1];
                }
            }
        }
        if (isInverted()){  // If the colors are to be inverted
                // A for loop to go through the arrays of colors
            for (Color[] arr : c) {
                    // A for loop to invert the colors
                for (int y = 0; y < arr.length; y++) {
                    arr[y] = invertColor(arr[y]);
                }
            }
        }
        return c;
    }
    /**
     * This returns an array of {@code Paint} objects used to paint the gradient 
     * if this painter is {@link #getUsesGradient using gradients}. The colors 
     * for the gradient are calculated by the {@link #getGradientColors 
     * getGradientColors} method. The first value in the array is the gradient 
     * for the top or left part of the graphic, and the second is the gradient 
     * for the bottom or right part of the graphic.
     * @param color The color to use to generate the gradient. If this is null, 
     * then this will instead use the {@link #DEFAULT_GRADIENT_COLORS default 
     * colors} to generate the gradients.
     * @param x The x-coordinate of the top-left corner of the area that will be 
     * filled in with the two gradients.
     * @param y The y-coordinate of the top-left corner of the area that will be 
     * filled in with the two gradients.
     * @param w The width of the area that will be filled in with the two 
     * gradients.
     * @param h The height of the area that will be filled in with the two 
     * gradients.
     * @return The array containing the {@code Paint} objects used to paint the
     * gradients.
     * @see #getMaxRGBComponents
     * @see #getUsesGradient
     * @see #setUsesGradient 
     * @see #isInverted 
     * @see #setInverted  
     * @see #invertColor 
     * @see #isRenderedFlipped 
     * @see #isFlipped 
     * @see #setFlipped 
     * @see #isVertical 
     * @see #setVertical 
     * @see #setState 
     * @see #getState 
     * @see #paint 
     * @see #DEFAULT_GRADIENT_COLORS
     * @see #getGradientColors 
     * @see #getColors 
     */
    protected Paint[] getGradients(Color color,double x,double y,double w,double h){
            // This will get the arrays of colors to use for the gradients.
        Color[][] c = getGradientColors(color);
            // If the starting point scratch object is not initialized yet
        if (startPoint == null)
            startPoint = new Point2D.Double();
            // If the starting point scratch object is not initialized yet
        if (endPoint == null)
            endPoint = new Point2D.Double();
        if (isVertical())   // If the graphic is to be vertically oriented
            x = w = 0;      // Set the x and width to zero to eliminate the x component
        else
            y = h = 0;      // Set the y and height to zero to eliminate the y component
        startPoint.setLocation(x,y);    // Set the starting point
        endPoint.setLocation(x+w,y+h);  // Set the ending point
            // An array to store the returned gradients in
        Paint[] gradients = new Paint[c.length];
            // A for loop to finally initialize the gradients.
        for (int i = 0; i < gradients.length; i++)
            gradients[i] = new LinearGradientPaint(startPoint, endPoint, 
                    GRADIENT_FRACTIONS, c[i]);
        return gradients;
    }
    /**
     * This returns an array of {@code Color} objects used to paint the pattern 
     * if this painter is provided a color when painting and does not {@link 
     * #getUsesGradient use a gradient}.
     * @param color The color to use to generate the gradient (this cannot be 
     * null). 
     * @return The array containing the colors to use to paint the pattern. 
     * @throws NullPointerException If the color is null.
     * @see #getMaxRGBComponents
     * @see #getUsesGradient 
     * @see #setUsesGradient 
     * @see #COLOR_RANGE_VALUES
     * @see #FLOATING_RANGE_VALUES
     * @see #getGradients 
     */
    protected Color[] getColors(Color color){
            // Gets the RGBA components for the highest value color with the 
            // same hue and saturation in the HSV color space
        float[] rgba = getMaxRGBComponents(color);
            // Create an array to store the returned colors in
        Color[] colors = new Color[FLOATING_RANGE_VALUES.length];
            // A for loop to generate the colors based off the maxed out RGB 
        for (int i = 0; i < colors.length; i++){    // values
                // The red, green, and blue values for the current color
            float[] rgb = new float[3];
                // Go through the rgb components and calculate them for the 
                // current color
            for (int j = 0; j < rgb.length; j++){
                    // If the color fades to white
                if (getFadesToWhite()){
                    rgb[j] = rgba[j] + (float)((1.0-rgba[j])*(1.0-FLOATING_RANGE_VALUES[i]));
                } else  // If the color fades to black
                    rgb[j] = rgba[j]*FLOATING_RANGE_VALUES[i];
            }
            colors[i] = new Color(rgb[0],rgb[1],rgb[2],
                        // Last value is the alpha value, which is carried over
                    rgba[3]);
        }
        return colors;
    }
    /**
     * {@inheritDoc } <p>
     * 
     * This method delegates the work of rendering the graphic to a couple of 
     * protected methods: {@code paintBorder}, {@code paintGradients}, and 
     * {@code paintPattern}. The {@code paintBorder} method is called first to 
     * render the border for the graphic. Afterwords, either the {@code 
     * paintGradients} or the {@code paintPattern} will be called to render the 
     * rest of the graphic. If the graphic {@link #getUsesGradient uses 
     * gradients}, then the {@code paintGradients} method will be called. 
     * Otherwise, the {@code paintPattern} method will be called. There are two 
     * {@code paintPattern} methods, one that takes a color and one that does 
     * not. The former is used when this method is invoked with a non-null 
     * color, and the latter is used when this method is invoked with null for 
     * the color.
     * 
     * @todo Improve the handling of transparent colors.
     * 
     * @param g {@inheritDoc }
     * @param color The color to use for the rendered pattern. If this is null, 
     * then the pattern will be generated using a set of predefined colors.
     * @param width {@inheritDoc }
     * @param height {@inheritDoc }
     * @see #getState 
     * @see #setState 
     */
    @Override
    public void paint(Graphics2D g, Color color, int width, int height) {
            // Check if the graphics context is null
        Objects.requireNonNull(g);
            // If the width or height are less than or equal to zero
        if (width <= 0 || height <= 0)
            return;
            // Create a copy of the graphics context to render the graphic to
        g = (Graphics2D) g.create();
//            // Get the alpha component for the color
//        int alpha = (color != null) ? color.getAlpha() : 255;
            // Paint the border. If a color was provided, use it for the border. 
            // Otherwise, use the default border color for the border
        paintBorder(g,(color!=null)?color:DEFAULT_BORDER_COLOR,0,0,width,height);
            // The x-coordinate for the top-left corner of the pattern (also 
            // doubles as the scaling factor for x-coordinates)
        double x = width/((double)INTERNAL_SIZE);
            // The y-coordinate for the top-left corner of the pattern (also 
            // doubles as the scaling factor for y-coordinates)
        double y = height/((double)INTERNAL_SIZE);
            // The width for the pattern
        double w = width - x - x;
            // The height for the pattern
        double h = height - y - y;
        if (getUsesGradient())      // If this is using a gradient
            paintGradients(g,x,y,w,h,x,y,color);
        else if (color != null)     // If a color was provided
            paintPattern(g,x,y,w,h,x,y,color);
        else                        // Render the pattern using the default colors
            paintPattern(g,x,y,w,h,x,y);
        g.dispose();
    }
    /**
     * This renders the border for the graphic using the given color.
     * @param g The graphics context to render to.
     * @param color The color to use for the border.
     * @param x The x-coordinate of the top-left corner for the border.
     * @param y The y-coordinate of the top-left corner for the border.
     * @param w The width for the border.
     * @param h The height for the border.
     * @see #paint(Graphics2D, Color, int, int) 
     * @see #paintGradients
     * @see #paintPattern(Graphics2D, double, double, double, double, double, 
     * double, Color) 
     * @see #paintPattern(Graphics2D, double, double, double, double, double, 
     * double) 
     */
    protected void paintBorder(Graphics2D g,Color color,int x,int y,int w,int h){
        fillRectangle(g,color,x,y,w,h);
    }
    /**
     * This renders the part of the graphic inside the border when this painter 
     * {@link #getUsesGradient uses gradients} to render the graphic. 
     * @param g The graphics context to render to.
     * @param x The x-coordinate for the top-left corner of the area to fill 
     * with the pattern.
     * @param y The y-coordinate for the top-left corner of the area to fill 
     * with the pattern.
     * @param w The width of the area to fill with the pattern.
     * @param h The height of the area to fill with the pattern.
     * @param xScale The scaling factor for x-coordinates when rendering at the 
     * {@link #INTERNAL_SIZE internal size}.
     * @param yScale The scaling factor for y-coordinates when rendering at the 
     * {@link #INTERNAL_SIZE internal size}.
     * @param color The color to use for the rendered pattern. If this is null, 
     * then the pattern will be generated using a set of predefined colors.
     * @see #paint 
     * @see #paintPattern(Graphics2D, double, double, double, double, double, 
     * double, Color) 
     * @see #paintPattern(Graphics2D, double, double, double, double, double, 
     * double) 
     * @see #getGradients 
     * @see #getGradientColors 
     * @see #getUsesGradient 
     * @see #setUsesGradient 
     * @see #isVertical 
     * @see #setVertical 
     */
    protected void paintGradients(Graphics2D g,double x,double y,double w,
            double h,double xScale,double yScale,Color color){
            // Get the gradients to use
        Paint[] grad = getGradients(color,x,y,w-1,h-1); 
        double halfW = w/2; // Get half of the width
        double halfH = h/2; // Get half of the height
            // There should be two gradients, so render them one after the 
        for (int i = 0; i < grad.length; i++){  // other
            g.setPaint(grad[i]);
                // HACK: The first gradient is rendered 1 pixel wider or taller 
                // (depending on the orientation) than the second gradient so as 
                // to prevent gaps in the rendered graphic
            if (isVertical())   // If the graphic is rendered vertically
                fillRectangle(g,x+(halfW*i),y,halfW+(1-i),h);
            else
                fillRectangle(g,x,y+(halfH*i),w,halfH+(1-i));
        }
    }
    /**
     * This renders the pattern when this painter is not {@link #getUsesGradient 
     * using gradients} and when {@link #paint paint} is given a non-null color.
     * @param g The graphics context to render to.
     * @param x The x-coordinate for the top-left corner of the area to fill 
     * with the pattern.
     * @param y The y-coordinate for the top-left corner of the area to fill 
     * with the pattern.
     * @param w The width of the area to fill with the pattern.
     * @param h The height of the area to fill with the pattern.
     * @param xScale The scaling factor for x-coordinates when rendering at the 
     * {@link #INTERNAL_SIZE internal size}.
     * @param yScale The scaling factor for y-coordinates when rendering at the 
     * {@link #INTERNAL_SIZE internal size}.
     * @param color The color to use for the rendered pattern.
     * @see #paint 
     * @see #paintGradients 
     * @see #paintPattern(Graphics2D, double, double, double, double, double, 
     * double) 
     * @see #getColors 
     */
    protected void paintPattern(Graphics2D g,double x,double y,double w,
            double h,double xScale,double yScale,Color color){
            // Scale the graphics context so as to use a constant size (may be 
        g.scale(xScale,yScale);     // removed in the future)
            // Get the array of colors to use
        Color[] colors = getColors(color);
            // A for loop to render the top row and bottom row separately
        for (int r = 0; r < 2; r++){
                // A for loop to render the colored rectangles
            for (int i = 0; i < colors.length; i++){
                    // If this is flipped and rendering the top row or if 
                    // this is not flipped and rendering the bottom row, 
                    // then the colors used for the row are in order of last 
                    // to first. 
                    // HACK: The rectangles of the top row are rendered 
                    // larger so as to prevent gaps in the rendered graphic
                fillRectangle(g, colors, i, isRenderedFlipped()==(r==0), 
                        i+1, 1+(((INTERNAL_SIZE/2)-1)*r), 
                        (INTERNAL_SIZE-2)-(2*i), (INTERNAL_SIZE/2)-r);
            }
        }
    }
    /**
     * This renders the pattern when this painter is not {@link #getUsesGradient 
     * using gradients} and when {@link #paint paint} is given null for the 
     * color.
     * @param g The graphics context to render to.
     * @param x The x-coordinate for the top-left corner of the area to fill 
     * with the pattern.
     * @param y The y-coordinate for the top-left corner of the area to fill 
     * with the pattern.
     * @param w The width of the area to fill with the pattern.
     * @param h The height of the area to fill with the pattern.
     * @param xScale The scaling factor for x-coordinates when rendering at the 
     * {@link #INTERNAL_SIZE internal size}.
     * @param yScale The scaling factor for y-coordinates when rendering at the 
     * {@link #INTERNAL_SIZE internal size}.
     * @see #paint 
     * @see #paintGradients 
     * @see #paintPattern(Graphics2D, double, double, double, double, double, 
     * double, Color) 
     * @see #getDefaultColorsFull
     */
    protected void paintPattern(Graphics2D g,double x,double y,double w,
            double h,double xScale,double yScale){
            // Scale the graphics context so as to use a constant size (may be 
        g.scale(xScale,yScale);     // removed in the future)
            // Get the array of default colors to use. If this fades to white, 
                // use the second array. Otherwise, use the white array
        Color[][] defColors = getDefaultColorsFull()[(getFadesToWhite())?1:0];
            // A for loop to render the colors in the pattern
        for (int i = 0; i < defColors.length; i++){
                // A for loop to draw the rectangles for each color
            for (int r = 0; r < defColors[i].length; r++){
                    // Get the x-coordinate for the rectangle
                int rectX = i+1;
                    // If the graphic is vertically oriented and the current 
                    // index for the color is even (the color is red or blue) or 
                    // if the graphic is not vertically oriented and the current 
                    // index for the color is odd (the color is green or white)
                if (isVertical() == (r % 2 == 0))
                    rectX = (INTERNAL_SIZE-2)-rectX;
                    // HACK: Each rectangle overlaps with the next one and 
                    // the one under it, so as to prevent gaps in the 
                    // rendered graphic
                fillRectangle(g, defColors[i],r,isRenderedFlipped(),rectX,
                        1+(((INTERNAL_SIZE/2)-1)*(r>>1)),2,
                        (INTERNAL_SIZE/2)-(r>>1));
            }
        }   
            // The x-coordinate for the final rectangle
        int rectX = (INTERNAL_SIZE/2)-1;
            // The y-coordinate for the final rectangle
        int rectY = 1;
            // The width of the final rectangle
        int rectW = 2;
            // The height of the final rectangle
        int rectH = INTERNAL_SIZE-2;
            // Draw the final color, which is always black, with the x and y 
            // coordinates and the width and height being swapped if the graphic 
            // is vertically oriented. If this fades to white, then the final 
            // color is white. Otherwise, the final color is black
        fillRectangle(g, (getFadesToWhite())?Color.WHITE:Color.BLACK, 
                (isVertical())?rectY:rectX, (isVertical())?rectX:rectY, 
                (isVertical())?rectH:rectW, (isVertical())?rectW:rectH);
    }
    /**
     * This fills a rectangle of the given x, y, width, and height, and of the 
     * color at the given index in the given array onto the given graphics 
     * context. If the graphic {@link #isInverted is inverted}, then the color 
     * will be {@link #invertColor inverted}. If the graphic {@link #isVertical 
     * is vertically oriented}, then the x and y coordinates will be swapped and 
     * so will the width and height. If the {@code flipped} value is true, then 
     * the index will become {@code colors.length-1-index}.
     * @param g The graphics context to render to.
     * @param colors The array of colors to get the color for the rectangle.
     * @param index The index in the array to get the color for the rectangle.
     * @param flipIndex Whether the index should start from the end of the 
     * array.
     * @param x The x-coordinate of the top-left corner of the rectangle.
     * @param y The y-coordinate of the top-left corner of the rectangle.
     * @param w The width of the rectangle.
     * @param h The height of the rectangle.
     * @see #isInverted 
     * @see #invertColor 
     * @see #isVertical 
     * @see #fillRectangle(Graphics2D, Color, double, double, double, double) 
     */
    private void fillRectangle(Graphics2D g, Color[] colors, int index, 
            boolean flipIndex, double x, double y, double w, double h){
            // If flipped, start from the end of the array. Otherwise, use the 
        if (flipIndex)          // index as is.
            index = colors.length-1-index;
        if (isVertical())       // If the graphic is rendered vertically
            fillRectangle(g,colors[index],y,x,h,w);
        else
            fillRectangle(g,colors[index],x,y,w,h);
    }
    /**
     * This fills a rectangle of the given x, y, width, and height, and of the 
     * given color onto the given graphics context. If the graphic {@link 
     * #isInverted is inverted}, then the color will be {@link #invertColor 
     * inverted}. 
     * @param g The graphics context to render to.
     * @param color The color to use for the rectangle.
     * @param x The x-coordinate of the top-left corner of the rectangle.
     * @param y The y-coordinate of the top-left corner of the rectangle.
     * @param w The width of the rectangle.
     * @param h The height of the rectangle.
     * @see #isInverted 
     * @see #invertColor 
     * @see #fillRectangle(Graphics2D, double, double, double, double) 
     */
    protected void fillRectangle(Graphics2D g,Color color,double x,double y,
            double w,double h){
            // If colors are inverted, invert the color. Otherwise, use it as is.
        g.setColor((isInverted()) ? invertColor(color) : color);
        fillRectangle(g,x,y,w,h);
    }
    /**
     * This fills a rectangle of the given x, y, width, and height on the given 
     * graphics context.
     * @param g The graphics context to render to.
     * @param x The x-coordinate of the top-left corner of the rectangle.
     * @param y The y-coordinate of the top-left corner of the rectangle.
     * @param w The width of the rectangle.
     * @param h The height of the rectangle.
     * @see #fillRectangle(Graphics2D, Color, double, double, double, double) 
     */
    protected void fillRectangle(Graphics2D g,double x,double y,double w,double h){
        if (fillRect == null)   // If the fill rectangle is not initialized yet
            fillRect = new Rectangle2D.Double(x, y, w, h);
        else
            fillRect.setRect(x, y, w, h);
        g.fill(fillRect);
    }
    /**
     * This returns whether the graphic is rendered flipped. This is different 
     * from {@link #isFlipped} in that this actually indicates that it is 
     * flipped internally to make things easier. This is equivalent to {@code 
     * XOR}-ing isFlipped with {@link #isVertical}.
     * @return Whether {@code isFlipped} is true while {@code isVertical} is 
     * not, or vice versa.
     * @see #isFlipped
     * @see #isVertical
     */
    protected boolean isRenderedFlipped(){
        return isFlipped()!=isVertical();
    }
    /**
     * This inverts the given color to produce the negative of that color. The 
     * alpha component will be unaffected.
     * @param color The color to invert.
     * @return The inverted color.
     * @see #isInverted 
     * @see #setInverted 
     */
    protected Color invertColor(Color color){
        int rgb = color.getRGB();   // Get the RGB for the color
        return new Color((~rgb & 0xFFFFFF) | (rgb & 0xFF000000), true);
    }
    /**
     * This checks to see if the given state is valid, and if not, throws an 
     * IllegalArgumentException.
     * @param state The state to check.
     * @throws IllegalArgumentException If the state is negative or greater than 
     * {@link MAXIMUM_VALID_STATE}.
     * @see #MAXIMUM_VALID_STATE
     * @see #setState 
     */
    protected void checkState(int state){
            // If the state is invalid.
        if (state < 0 || state > MAXIMUM_VALID_STATE)
            throw new IllegalArgumentException("Invalid state: " + state);
    }
    /**
     * This sets the state for this {@code ColorPatternPainter}. The state is 
     * used to control how the graphic is rendered based off of which flags are 
     * set for the state.
     * @param state The state for this painter (must be a positive integer 
     * between 0 and {@link #MAXIMUM_VALID_STATE}, inclusive).
     * @return This {@code ColorPatternPainter}.
     * @throws IllegalArgumentException If the given state is negative or 
     * greater than {@code MAXIMUM_VALID_STATE}.
     * @see #VERTICAL_ORIENTATION_FLAG
     * @see #FLIPPED_FLAG
     * @see #INVERTED_FLAG
     * @see #TRUE_GRADIENT_FLAG
     * @see #FADE_TO_WHITE_FLAG
     * @see #MAXIMUM_VALID_STATE
     * @see #getState 
     * @see #setFlag 
     * @see #getFlag 
     * @see #setVertical 
     * @see #isVertical 
     * @see #setFlipped 
     * @see #isFlipped 
     * @see #setInverted 
     * @see #isInverted 
     * @see #setUsesGradient 
     * @see #getUsesGradient 
     * @see #setFadesToWhite
     * @see #getFadesToWhite 
     */
    public ColorPatternPainter setState(int state){
        if (state == this.state)    // If the state would not have changed
            return this;
        checkState(state);          // Check to see if the state is valid
        this.state = state;
        fireStateChanged();         // Fire a state change event
        return this;
    }
    /**
     * This returns the state for this {@code ColorPatternPainter}. The state is 
     * used to control how the graphic is rendered based off of which flags are 
     * set for the state.
     * @return The state for this {@code ColorPatternPainter}.
     * @see #VERTICAL_ORIENTATION_FLAG
     * @see #FLIPPED_FLAG
     * @see #INVERTED_FLAG
     * @see #TRUE_GRADIENT_FLAG
     * @see #FADE_TO_WHITE_FLAG
     * @see #MAXIMUM_VALID_STATE
     * @see #setState 
     * @see #setFlag 
     * @see #getFlag 
     * @see #setVertical 
     * @see #isVertical 
     * @see #setFlipped 
     * @see #isFlipped 
     * @see #setInverted 
     * @see #isInverted 
     * @see #setUsesGradient 
     * @see #getUsesGradient 
     * @see #setFadesToWhite
     * @see #getFadesToWhite 
     */
    public int getState(){
        return state;
    }
    /**
     * This sets the given flag for the state.
     * @param flag The flag to set.
     * @param value Whether the flag should be set or cleared.
     * @return This {@code ColorPatternPainter}.
     * @throws IllegalArgumentException If the state would become invalid 
     * because of setting the given flag.
     * @see #VERTICAL_ORIENTATION_FLAG
     * @see #FLIPPED_FLAG
     * @see #INVERTED_FLAG
     * @see #TRUE_GRADIENT_FLAG
     * @see #FADE_TO_WHITE_FLAG
     * @see #MAXIMUM_VALID_STATE
     * @see #setState 
     * @see #getState 
     * @see #getFlag 
     * @see #setVertical 
     * @see #isVertical 
     * @see #setFlipped 
     * @see #isFlipped 
     * @see #setInverted 
     * @see #isInverted 
     * @see #setUsesGradient 
     * @see #getUsesGradient 
     * @see #setFadesToWhite
     * @see #getFadesToWhite 
     */
    public ColorPatternPainter setFlag(int flag, boolean value){
            // If the flag is already set to the desired value.
        if (getFlag(flag) == value)    
            return this;
            // If the flag is to be set, then set it. Otherwise, clear it
        return setState((value)?(getState()|flag):Math.max(0,getState()&~flag));
    }
    /**
     * This returns whether the given flag is set for the state.
     * @param flag The flag to check for.
     * @return If the given flag is set.
     * @see #VERTICAL_ORIENTATION_FLAG
     * @see #FLIPPED_FLAG
     * @see #INVERTED_FLAG
     * @see #TRUE_GRADIENT_FLAG
     * @see #FADE_TO_WHITE_FLAG
     * @see #MAXIMUM_VALID_STATE
     * @see #setState 
     * @see #getState 
     * @see #setFlag 
     * @see #setVertical 
     * @see #isVertical 
     * @see #setFlipped 
     * @see #isFlipped 
     * @see #setInverted 
     * @see #isInverted 
     * @see #setUsesGradient 
     * @see #getUsesGradient 
     * @see #setFadesToWhite
     * @see #getFadesToWhite 
     */
    public boolean getFlag(int flag){
        return (getState() & flag) == flag;
    }
    /**
     * This sets whether this {@code ColorPatternPainter} is horizontally or 
     * vertically oriented.
     * @param value Whether the graphic should be vertically oriented.
     * @return This {@code ColorPatternPainter}.
     * @see #VERTICAL_ORIENTATION_FLAG
     * @see #setState 
     * @see #getState 
     * @see #setFlag 
     * @see #getFlag 
     * @see #isVertical 
     * @see #setFlipped 
     * @see #isFlipped 
     * @see #setInverted 
     * @see #isInverted 
     * @see #setUsesGradient 
     * @see #getUsesGradient 
     * @see #setFadesToWhite
     * @see #getFadesToWhite 
     */
    public ColorPatternPainter setVertical(boolean value){
        return setFlag(VERTICAL_ORIENTATION_FLAG,value);
    }
    /**
     * This returns whether this {@code ColorPatternPainter} is horizontally or 
     * vertically oriented.
     * @return Whether the graphic is vertically oriented.
     * @see #VERTICAL_ORIENTATION_FLAG
     * @see #setState 
     * @see #getState 
     * @see #setFlag 
     * @see #getFlag 
     * @see #setVertical 
     * @see #setFlipped 
     * @see #isFlipped 
     * @see #setInverted 
     * @see #isInverted 
     * @see #setUsesGradient 
     * @see #getUsesGradient 
     * @see #setFadesToWhite
     * @see #getFadesToWhite 
     */
    public boolean isVertical(){
        return getFlag(VERTICAL_ORIENTATION_FLAG);
    }
    /**
     * This sets whether this {@code ColorPatternPainter} is flipped.
     * @param value Whether the graphic should be flipped 180 degrees.
     * @return This {@code ColorPatternPainter}.
     * @see #FLIPPED_FLAG
     * @see #setState 
     * @see #getState 
     * @see #setFlag 
     * @see #getFlag 
     * @see #setVertical 
     * @see #isVertical 
     * @see #isFlipped 
     * @see #setInverted 
     * @see #isInverted 
     * @see #setUsesGradient 
     * @see #getUsesGradient 
     * @see #setFadesToWhite
     * @see #getFadesToWhite 
     */
    public ColorPatternPainter setFlipped(boolean value){
        return setFlag(FLIPPED_FLAG,value);
    }
    /**
     * This returns whether this {@code ColorPatternPainter} is flipped.
     * @return Whether the graphic is flipped 180 degrees.
     * @see #FLIPPED_FLAG
     * @see #setState 
     * @see #getState 
     * @see #setFlag 
     * @see #getFlag 
     * @see #setVertical 
     * @see #isVertical 
     * @see #setFlipped 
     * @see #setInverted 
     * @see #isInverted 
     * @see #setUsesGradient 
     * @see #getUsesGradient 
     * @see #setFadesToWhite
     * @see #getFadesToWhite 
     */
    public boolean isFlipped(){
        return getFlag(FLIPPED_FLAG);
    }
    /**
     * This sets whether the colors for this {@code ColorPatternPainter} should 
     * be inverted to produce a negative image.
     * @param value Whether the colors should be inverted.
     * @return This {@code ColorPatternPainter}.
     * @see #INVERTED_FLAG
     * @see #setState 
     * @see #getState 
     * @see #setFlag 
     * @see #getFlag 
     * @see #setVertical 
     * @see #isVertical 
     * @see #setFlipped 
     * @see #isFlipped 
     * @see #isInverted 
     * @see #setUsesGradient 
     * @see #getUsesGradient 
     * @see #setFadesToWhite
     * @see #getFadesToWhite 
     */
    public ColorPatternPainter setInverted(boolean value){
        return setFlag(INVERTED_FLAG,value);
    }
    /**
     * This returns whether the colors for this {@code ColorPatternPainter} are 
     * inverted to produce a negative image.
     * @return Whether the colors are inverted.
     * @see #INVERTED_FLAG
     * @see #setState 
     * @see #getState 
     * @see #setFlag 
     * @see #getFlag 
     * @see #setVertical 
     * @see #isVertical 
     * @see #setFlipped 
     * @see #isFlipped 
     * @see #setInverted 
     * @see #setUsesGradient 
     * @see #getUsesGradient 
     * @see #setFadesToWhite
     * @see #getFadesToWhite 
     */
    public boolean isInverted(){
        return getFlag(INVERTED_FLAG);
    }
    /**
     * This sets whether this {@code ColorPatternPainter} uses a gradient 
     * instead of a pattern.
     * @param value Whether this painter uses a gradient.
     * @return This {@code ColorPatternPainter}.
     * @see #TRUE_GRADIENT_FLAG
     * @see #setState 
     * @see #getState 
     * @see #setFlag 
     * @see #getFlag 
     * @see #setVertical 
     * @see #isVertical 
     * @see #setFlipped 
     * @see #isFlipped 
     * @see #setInverted 
     * @see #isInverted 
     * @see #getUsesGradient 
     * @see #setFadesToWhite
     * @see #getFadesToWhite 
     */
    public ColorPatternPainter setUsesGradient(boolean value){
        return setFlag(TRUE_GRADIENT_FLAG,value);
    }
    /**
     * This returns whether this {@code ColorPatternPainter} uses a gradient 
     * instead of a pattern.
     * @return Whether this painter uses a gradient.
     * @see #TRUE_GRADIENT_FLAG
     * @see #setState 
     * @see #getState 
     * @see #setFlag 
     * @see #getFlag 
     * @see #setVertical 
     * @see #isVertical 
     * @see #setFlipped 
     * @see #isFlipped 
     * @see #setInverted 
     * @see #isInverted 
     * @see #setUsesGradient 
     * @see #setFadesToWhite
     * @see #getFadesToWhite 
     */
    public boolean getUsesGradient(){
        return getFlag(TRUE_GRADIENT_FLAG);
    }
    /**
     * This sets whether the center colors for this {@code ColorPatternPainter} 
     * will fade to black or white. 
     * @param value Whether the colors should fade to white.
     * @return This {@code ColorPatternPainter}.
     * @see #FADE_TO_WHITE_FLAG
     * @see #setState 
     * @see #getState 
     * @see #setFlag 
     * @see #getFlag 
     * @see #setVertical 
     * @see #isVertical 
     * @see #setFlipped 
     * @see #isFlipped 
     * @see #setInverted 
     * @see #isInverted 
     * @see #setUsesGradient 
     * @see #getUsesGradient 
     * @see #getFadesToWhite 
     */
    public ColorPatternPainter setFadesToWhite(boolean value){
        return setFlag(FADE_TO_WHITE_FLAG,value);
    }
    /**
     * This gets whether the center colors for this {@code ColorPatternPainter} 
     * will fade to black or white. 
     * @return {@code true} if the colors fade to white, {@code false} if the 
     * colors fade to black.
     * @see #FADE_TO_WHITE_FLAG
     * @see #setState 
     * @see #getState 
     * @see #setFlag 
     * @see #getFlag 
     * @see #setVertical 
     * @see #isVertical 
     * @see #setFlipped 
     * @see #isFlipped 
     * @see #setInverted 
     * @see #isInverted 
     * @see #setUsesGradient 
     * @see #getUsesGradient 
     * @see #setFadesToWhite
     */
    public boolean getFadesToWhite(){
        return getFlag(FADE_TO_WHITE_FLAG);
    }
    /**
     * This returns an array of all the objects currently registered as 
     * <code><em>Foo</em>Listener</code>s on this painter. 
     * <code><em>Foo</em>Listener</code>s are registered via the 
     * <code>add<em>Foo</em>Listener</code> method. <p>
     * 
     * The listener type can be specified using a class literal, such as 
     * <code><em>Foo</em>Listener.class</code>. If no such listeners exist, then 
     * an empty array will be returned.
     * @param <T> The type of {@code EventListener} being requested.
     * @param listenerType The type of listeners being requested. This should 
     * be an interface that descends from {@code EventListener}.
     * @return An array of the objects registered as the given listener type on 
     * this painter, or an empty array if no such listeners have been added.
     */
    public <T extends EventListener> T[] getListeners(Class<T> listenerType){
        return listenerList.getListeners(listenerType);
    }
    /**
     * This adds the given {@code ChangeListener} to this painter.
     * @param l The listener to add.
     * @see #removeChangeListener(ChangeListener) 
     * @see #getChangeListeners() 
     */
    public void addChangeListener(ChangeListener l){
        if (l != null)          // If the listener is not null
            listenerList.add(ChangeListener.class, l);
    }
    /**
     * This removes the given {@code ChangeListener} from this painter.
     * @param l The listener to remove.
     * @see #addChangeListener(ChangeListener) 
     * @see #getChangeListeners() 
     */
    public void removeChangeListener(ChangeListener l){
        listenerList.remove(ChangeListener.class, l);
    }
    /**
     * This returns an array containing all the {@code ChangeListener}s that 
     * have been added to this painter.
     * @return An array containing the {@code ChangeListener}s that have been 
     * added, or an empty array if none have been added.
     * @see #addChangeListener(ChangeListener) 
     * @see #removeChangeListener(ChangeListener) 
     */
    public ChangeListener[] getChangeListeners(){
        return listenerList.getListeners(ChangeListener.class);
    }
    /**
     * This is used to notify the {@code ChangeListener}s that the state of this  
     * painter has changed.
     */
    protected void fireStateChanged(){
            // This constructs the evet to fire
        ChangeEvent evt = new ChangeEvent(this);
            // A for loop to go through the change listeners
        for (ChangeListener l : listenerList.getListeners(ChangeListener.class)){
            if (l != null)  // If the listener is not null
                l.stateChanged(evt);
        }
    }
    /**
     * This returns a String representation of this {@code ColorPatternPainter}. 
     * This method is primarily intended to be used only for debugging purposes, 
     * and the content and format of the returned String may vary between 
     * implementations.
     * @return A String representation of this {@code ColorPatternPainter}.
     */
    protected String paramString(){
        return "state=" + getState();
    }
    @Override
    public String toString(){
        return getClass().getName()+"["+paramString()+"]";
    }
}
