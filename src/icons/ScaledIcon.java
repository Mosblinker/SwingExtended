/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package icons;

import java.awt.*;
import java.util.Map;
import java.util.Objects;
import javax.swing.Icon;

/**
 * This is an Icon that serves as a scaled version of another Icon. This icon 
 * can scale an icon either to a specific size or by a specific value, depending 
 * on whether a width and height or an x and y coordinate scaling factor were 
 * specified. If a width and height were specified, then the icon will be scaled 
 * up to a specific size, with the aspect ratio of the icon being preserved if 
 * either of the width or the height is negative or if the aspect ratio was 
 * explicitly set to be kept. If an x and y coordinate scaling factor were 
 * specified, then the icon's width will be scaled by the x-coordinate scaling 
 * factor and the icon's height will be scaled by the y-coordinate scaling 
 * factor. 
 * @author Milo Steier
 */
public class ScaledIcon implements Icon2D, DerivedIcon{
    /**
     * This is the target width for the icon. If this is null, then the icon is 
     * instead scaled using {@code xScale}. If this is negative, then this will 
     * be substituted with a value to maintain the aspect ratio. This will 
     * always be null when {@code height} is null, and will always be non-null 
     * when {@code height} is not null.
     */
    private Integer width;
    /**
     * This is the target height for the icon. If this is null, then the icon is 
     * instead scaled using {@code yScale}. If this is negative, then this will 
     * be substituted width a value to maintain the aspect ratio. This will 
     * always be null when {@code width} is null, and will always be non-null 
     * when {@code width} is not null.
     */
    private Integer height;
    /**
     * This is the scale for the x-axis. If this is null, then the icon is a 
     * fixed size and will use {@code width} for the width of the icon. If this 
     * is {@code NaN}, then {@code width} will still be used, but the aspect 
     * ratio will be maintained. Otherwise, this will be a positive value used 
     * to scale the width of the original icon. This will always be null when 
     * {@code yScale} is null, {@code NaN} when {@code yScale} is {@code NaN}, 
     * and a positive value when {@code yScale} is a positive value.
     */
    private Double xScale;
    /**
     * This is the scale for the y-axis. If this is null, then the icon is a 
     * fixed size and will use {@code height} for the height of the icon. If 
     * this is {@code NaN}, then {@code height} will still be used, but the 
     * aspect ratio will be maintained. Otherwise, this will be a positive value 
     * used to scale the height of the original icon. This will always be null 
     * when {@code xScale} is null, {@code NaN} when {@code xScale} is {@code 
     * NaN}, and a positive value when {@code xScale} is a positive value.
     */
    private Double yScale;
    /**
     * This is the icon that this is a scaled version of.
     */
    private final Icon icon;
    /**
     * This stores a map of rendering hints used to render the scaled icon.
     */
    private RenderingHints hintMap;
    /**
     * This constructs a ScaledIcon with the given width, height, xScale, and 
     * yScale. This is set up in such a way that {@code width} and {@code 
     * height} are either both null or not null, and {@code xScale} and {@code 
     * yScale} are either both null, {@link Double#NaN}, or not null. The {@code 
     * width} and {@code height} will be null when {@code xScale} and {@code 
     * yScale} are non-null, positive numbers. When {@code width} and {@code 
     * height} are not null, then {@code xScale} and {@code yScale} will be 
     * either null or {@code NaN}, depending on whether the size is fixed or 
     * subject to the aspect ratio.
     * @param icon The base Icon that this is a scaled version of (cannot be 
     * null).
     * @param width The width for the scaled version of the icon.
     * @param height The height for the scaled version of the icon.
     * @param xScale The x-axis scale for the scaled version of the icon.
     * @param yScale The y-axis scale for the scaled version of the icon.
     */
    private ScaledIcon(Icon icon, Integer width, Integer height, Double xScale, 
            Double yScale){
        this.icon = Objects.requireNonNull(icon, "Icon cannot be null");
        this.width = width;
        this.height = height;
        this.xScale = xScale;
        this.yScale = yScale;
        hintMap = new RenderingHints(RenderingHints.KEY_INTERPOLATION, 
                RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        hintMap.put(RenderingHints.KEY_ALPHA_INTERPOLATION, 
                RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        hintMap.put(RenderingHints.KEY_ANTIALIASING, 
                RenderingHints.VALUE_ANTIALIAS_ON);
        hintMap.put(RenderingHints.KEY_RENDERING, 
                RenderingHints.VALUE_RENDER_QUALITY);
        hintMap.put(RenderingHints.KEY_DITHERING, 
                RenderingHints.VALUE_DITHER_ENABLE);
    }
    /**
     * This returns the value to use for the scaling values when a size is 
     * specified and the scaling values are used to indicate if the aspect ratio 
     * is preserved.
     * @param keepAspectRatio Whether the aspect ratio is preserved or not.
     * @return {@link Double#NaN} if the aspect ratio is preserved, and null if 
     * it is not.
     * @see ScaledIcon#ScaledIcon(javax.swing.Icon, int, int, boolean) 
     * @see #setTargetSize(int, int, boolean) 
     */
    private static Double getKeepAspectRatioIndicator(boolean keepAspectRatio){
            // If the aspect ratio is maintained, return NaN. Otherwise, return
        return (keepAspectRatio) ? Double.NaN : null;   // null
    }
    /**
     * This constructs a ScaledIcon that scales the given icon up to the given 
     * width and height. If either of the given width or height are negative, or 
     * if {@code keepAspectRatio} is true, then the aspect ratio of the icon 
     * will be maintained and the given width and height will define a bounding 
     * box in which the scaled icon will fit within, with negative values being 
     * treated as if no limit was given for that value. If both the width and 
     * height are negative, then the icon will not be scaled. If the aspect 
     * ratio is not maintained, then the width and height will be used as the 
     * width and height of the scaled icon, respectively.
     * @param icon The icon to scale.
     * @param width The width for the bounding box of the scaled icon.
     * @param height The height for the bounding box of the scaled icon.
     * @param keepAspectRatio Whether the aspect ratio of the original icon is 
     * to be maintained regardless of whether either of the target width or 
     * height are negative.
     * @see ScaledIcon#ScaledIcon(javax.swing.Icon, int, int) 
     * @see #setTargetSize(int, int, boolean) 
     */
    public ScaledIcon(Icon icon, int width, int height, boolean keepAspectRatio){
        this(icon,width,height,getKeepAspectRatioIndicator(keepAspectRatio),
                getKeepAspectRatioIndicator(keepAspectRatio));
    }
    /**
     * This constructs a ScaledIcon that scales the given icon to the given 
     * width and height. If either of the given width or height are negative, 
     * then the aspect ratio of the icon will be maintained, with the 
     * non-negative value being used as the corresponding value for the scaled 
     * icon and the negative value being substituted with one that maintains the 
     * aspect ratio. If both the width and height are negative, then the icon 
     * will not be scaled. If neither of the width and height are negative, then 
     * they will be used as the width and height of the scaled icon, respectively.
     * @param icon The icon to scale.
     * @param width The width for the bounding box of the scaled icon.
     * @param height The height for the bounding box of the scaled icon.
     * @see ScaledIcon#ScaledIcon(javax.swing.Icon, int, int, boolean) 
     * @see #setTargetSize(int, int) 
     */
    public ScaledIcon(Icon icon, int width, int height){
        this(icon,width,height,false);
    }
    /**
     * This checks to see if the specified scale is valid, and if not, throws an 
     * IllegalArgumentException.
     * @param scale The specified scale to check.
     * @param name The name for the scale.
     * @throws IllegalArgumentException If the given scale is less than or equal 
     * to zero or is not finite.
     */
    private void checkScale(double scale, String name){
        if (scale <= 0)     // If the scale is less than or equal to zero
            throw new IllegalArgumentException(name+
                    " Scale cannot be less than or equal to zero ("+scale+" <= 0)");
        else if (!Double.isFinite(scale))   // If the scale is infinite or NaN
            throw new IllegalArgumentException(name+
                    " Scale must be a finite number greater than zero");
    }
    /**
     * This constructs a ScaledIcon that scales the given icon by the given x 
     * and y coordinate scaling factors.
     * @param icon The icon to scale.
     * @param xScale The value to use to scale the icon's width (must be greater 
     * than zero and cannot be {@link Double#POSITIVE_INFINITY}).
     * @param yScale The value to use to scale the icon's height (must be 
     * greater than zero and cannot be {@link Double#POSITIVE_INFINITY}).
     * @throws IllegalArgumentException If either of the given x or y coordinate 
     * scaling factors are either positive infinity or less than or equal to 
     * zero.
     * @see ScaledIcon#ScaledIcon(javax.swing.Icon, double) 
     * @see #setTargetScale(double, double) 
     */
    public ScaledIcon(Icon icon, double xScale, double yScale){
        this(icon,null,null,xScale,yScale);
        checkScale(xScale,"X");
        checkScale(yScale,"Y");
    }
    /**
     * This constructs a ScaledIcon that scales the given icon by the given 
     * scaling factor.
     * @param icon The icon to scale.
     * @param scale The value to use to scale the icon's width and height 
     * (must be greater than zero and cannot be {@link 
     * Double#POSITIVE_INFINITY}).
     * @throws IllegalArgumentException If the given scaling factor is either 
     * positive infinity or less than or equal to zero.
     * @see ScaledIcon#ScaledIcon(javax.swing.Icon, double, double) 
     * @see #setTargetScale(double) 
     */
    public ScaledIcon(Icon icon, double scale){
        this(icon,null,null,scale,scale);
        checkScale(scale,"X and Y");
    }
    /**
     * This constructs a ScaledIcon that is a copy of the given ScaledIcon.
     * @param icon The ScaledIcon to copy.
     */
    public ScaledIcon(ScaledIcon icon){
        this(icon.icon,icon.width,icon.height,icon.xScale,icon.yScale);
        ScaledIcon.this.setRenderingHints(icon.hintMap);
    }
    /**
     * {@inheritDoc } When drawing this icon, it will first scale the given 
     * graphics context by the {@link #getScaleX() horizontal} and {@link 
     * #getScaleY() vertical} scaling factors before passing it to the {@link 
     * #getIcon() original icon}, so as to produce a scaled version of it.
     * @param c {@inheritDoc }
     * @param g {@inheritDoc }
     * @param x {@inheritDoc }
     * @param y {@inheritDoc }
     * @see #getIcon() 
     * @see #paintIcon
     * @see #getIconWidth() 
     * @see #getIconHeight() 
     * @see #getScaleX() 
     * @see #getScaleY()
     */
    @Override
    public void paintIcon2D(Component c, Graphics2D g, int x, int y) {
//        System.out.print(g.getTransform() + " -> ");
        g.addRenderingHints(hintMap);
        g.translate(x, y);
//        System.out.print(g.getTransform() + " -> ");
        g.scale(getScaleX(), getScaleY());
        g.translate(-1*x, -1*y);
//        System.out.println(g.getTransform() + " " + x + " " + y);
        getIcon().paintIcon(c, g, x, y);
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
     * This returns the value of a single preference for the rendering 
     * algorithms used to render the scaled icon.
     * 
     * These hints include controls for the rendering quality and the 
     * time/quality trade-off when rendering. Refer to the {@link 
     * RenderingHints} class for the definitions for some common keys and 
     * values.
     * @param key The key of the hint to get (cannot be null).
     * @return An object representing the value for the specified hint, or null 
     * if no value has been set for the specified hint.
     * @see #setRenderingHint(java.awt.RenderingHints.Key, java.lang.Object) 
     * @see RenderingHints
     */
    public Object getRenderingHint(RenderingHints.Key key){
        return hintMap.get(Objects.requireNonNull(key,"Rendering hint key cannot be null"));
    }
    /**
     * This sets the value of a single preference for the rendering algorithms 
     * used to render the scaled icon.
     * 
     * These hints include controls for the rendering quality and the
     * time/quality trade-off when rendering. Refer to the {@link 
     * RenderingHints} class for the definitions for some common keys and 
     * values.
     * @param key The key of the hint to set (cannot be null).
     * @param value The value indicating the preference for the hint, or null to 
     * clear the currently set preference.
     * @return This ScaledIcon.
     * @see #getRenderingHint(java.awt.RenderingHints.Key) 
     * @see RenderingHints
     */
    public ScaledIcon setRenderingHint(RenderingHints.Key key, Object value){
            // If the hint is already set to the given value
        if (Objects.equals(getRenderingHint(key),value))
            return this;
        if (value == null)  // If the value is getting set to null
            hintMap.remove(key);
        else
            hintMap.put(key, value);
        return this;
    }
    /**
     * This checks to see if the given hint map is either null or contains a 
     * null key, and if so, then this throws a NullPointerException.
     * @param hints The hint map to check.
     */
    private void checkHintMap(Map<?,?> hints){
        if (hints == null)                  // If the hint map is null
            throw new NullPointerException("Rendering hint map cannot be null");
        else if (hints.containsKey(null))   // If the hint map contains a null key
            throw new NullPointerException("Rendering hint key cannot be null");
    }
    /**
     * This sets the value for multiple preferences for the rendering 
     * algorithms used to render the scaled icon based off the given map. Only 
     * the rendering hints that are present in the given map will be modified, 
     * and all other rendering hints are left unchanged.
     * 
     * These hints include controls for the rendering quality and the 
     * time/quality trade-off when rendering. Refer to the {@link 
     * RenderingHints} class for the definitions for some common keys and 
     * values.
     * @param hints The map containing the rendering hints to be set (cannot be 
     * null and cannot contain a null key).
     * @return This ScaledIcon.
     * @see #getRenderingHints() 
     * @see #setRenderingHints(java.util.Map) 
     * @see RenderingHints
     */
    public ScaledIcon addRenderingHints(Map<?,?> hints){
        checkHintMap(hints);
        hintMap.putAll(hints);
        return this;
    }
    /**
     * This replaces the values for all the preferences for the rendering 
     * algorithms used to render the scaled icon. All existing values for the 
     * rendering hints are discarded and the new set of rendering hints is 
     * initialized using the given map of rendering hints.
     * 
     * These hints include controls for the rendering quality and the 
     * time/quality trade-off when rendering. Refer to the {@link 
     * RenderingHints} class for the definitions for some common keys and 
     * values.
     * @param hints The map containing the rendering hints to be set (cannot be 
     * null and cannot contain a null key).
     * @return This ScaledIcon.
     * @see #getRenderingHints() 
     * @see #addRenderingHints(java.util.Map) 
     * @see RenderingHints
     */
    public ScaledIcon setRenderingHints(Map<?,?> hints){
        checkHintMap(hints);
        hintMap.clear();
        return addRenderingHints(hints);
    }
    /**
     * This returns a map containing all the currently set preferences for the 
     * rendering algorithms used to render the scaled icon.
     * 
     * These hints include controls for the rendering quality and the 
     * time/quality trade-off when rendering. Refer to the {@link 
     * RenderingHints} class for the definitions for some common keys and 
     * values.
     * @return A copy of the RenderingHints object used to store the rendering 
     * hints.
     * @see #setRenderingHints(java.util.Map) 
     * @see #addRenderingHints(java.util.Map) 
     * @see RenderingHints
     */
    public RenderingHints getRenderingHints(){
        return (RenderingHints) hintMap.clone();
    }
    /**
     * This divides the given two values and returns the result.
     * @param value1 The numerator.
     * @param value2 The denominator.
     * @return {@code value1/value2}, or zero if either are less than or equal 
     * to zero.
     * @see #getScaleX() 
     * @see #getScaleY() 
     * @see #scaleValue(int, double) 
     * @see #getSizeValue 
     * @see #getIconWidth() 
     * @see #getIconHeight() 
     */
    private double getScale(double value1, double value2){
            // If both values are greater than zero, return the product of 
            // dividing them. Otherwise, return zero.
        return (value1 > 0 && value2 > 0) ? value1/value2 : 0;
    }
    /**
     * This returns the amount by which the {@link #getIcon() original icon} is 
     * scaled horizontally. This is equivalent to dividing the {@link 
     * #getIconWidth() scaled icon's width} by the original icon's width.
     * @return The x-coordinate scaling factor.
     * @see #getScaleY() 
     * @see #getIcon() 
     * @see #getIconWidth() 
     */
    public double getScaleX(){
        return getScale(getIconWidth(),getIcon().getIconWidth());
    }
    /**
     * This returns the amount by which the {@link #getIcon() original icon} is 
     * scaled vertically. This is equivalent to dividing the {@link 
     * #getIconHeight() scaled icon's height} by the original icon's height.
     * @return The y-coordinate scaling factor.
     * @see #getScaleX() 
     * @see #getIcon() 
     * @see #getIconHeight() 
     */
    public double getScaleY(){
        return getScale(getIconHeight(),getIcon().getIconHeight());
    }
    /**
     * This scales the given value by the given scale and rounds it. This is 
     * equivalent to calling {@code (int)}{@link Math#ceil(double) 
     * Math.ceil}{@code (value * scale)}.
     * @param value The value to be scaled.
     * @param scale The scaling value to use.
     * @return The value multiplied by the scale and rounded.
     * @see Math#ceil(double)
     * @see #getScale(double, double) 
     * @see #getSizeValue
     * @see #getIconWidth() 
     * @see #getIconHeight() 
     */
    private int scaleValue(int value, double scale){
        return (int)Math.ceil(value*scale);
    }
    /**
     * This calculates the value for the size based off the given values. If 
     * {@code iconValue1} is less than or equal to zero, then this will return 
     * zero. Otherwise, if {@code value1} is null, then this will return {@code 
     * (iconValue1 * scale)}. Otherwise. if both {@code value1} and {@code 
     * value2} are less than zero, then {@code iconValue1} is returned. 
     * Otherwise, if {@code value1} is less than zero but {@code value2} is 
     * greater than or equal to zero, then this will return {@code (iconValue1 * 
     * (value2 / iconValue2))}. Otherwise, if {@code value1} is greater than or 
     * equal to zero, but either {@code scale} is null or {@code value2} is less 
     * than zero, then this will return {@code value1}. Otherwise, this will 
     * return the smaller of {@code value1} and {@code (iconValue1 * (value2 / 
     * iconValue2))}.
     * @param value1 The value set for this icon that corresponds to {@code 
     * iconValue1}.
     * @param value2 The value set for this icon that corresponds to {@code 
     * iconValue2}.
     * @param iconValue1 The value for the base icon that corresponds to {@code 
     * value1}.
     * @param iconValue2 The value for the base icon that corresponds to {@code 
     * value2}.
     * @param scale The scale value for the value.
     * @return The value for the size of the scaled icon.
     * @see #getIconWidth() 
     * @see #getIconHeight() 
     * @see #scaleValue(int, double) 
     * @see #getScale(double, double) 
     * @see #getInternalWidth() 
     * @see #getInternalHeight()
     * @see #getInternalScaleX()
     * @see #getInternalScaleY() 
     * @see #isSizeSet() 
     * @see #isAspectRatioKept() 
     */
    private int getSizeValue(Integer value1, Integer value2, int iconValue1, 
            int iconValue2, Double scale){
        if (iconValue1 <= 0)        // If the icon value is less than or equal to zero
            return 0;
        else if (value1 == null)    // If no target value is specified
            return scaleValue(iconValue1,scale);
        else if (value1 < 0)        // If a value should be substituted for the target value
                // If the other target value is also negative, then return the 
                // value for the icon. Otherwise, scale the value for the icon 
                // based off the other target value and the other value for the 
                // icon
            return (value2 < 0) ? iconValue1 : scaleValue(iconValue1,getScale(value2,iconValue2));
            // If the scale is null (size is fixed) or the other target value 
        else if (scale == null || value2 < 0)   // will be substituted
            return value1;
        return Math.min(value1, scaleValue(iconValue1,getScale(value2,iconValue2)));
    }
    /**
     * This returns the width of the scaled icon. If a {@link #isSizeSet() 
     * target size was specified}, then this will return a width that can fit 
     * within the bounding box formed by the {@link #getTargetWidth() target 
     * width} and {@link #getTargetHeight() height}. If {@link 
     * #isAspectRatioKept() aspect ratio is not preserved}, then this will 
     * return the target width. If a target scale was specified, then this will 
     * return the width of the {@link #getIcon() original icon} multiplied by 
     * the {@link #getTargetScaleX() target x-coordinate scaling factor}.
     * @return The width of the scaled icon.
     * @see #getIconHeight() 
     * @see #getIcon() 
     * @see #getScaleX() 
     * @see #getTargetWidth() 
     * @see #getTargetHeight() 
     * @see #getTargetScaleX()
     * @see #getTargetScaleY() 
     * @see #isSizeSet() 
     * @see #isAspectRatioKept() 
     * @see #setTargetSize(int, int, boolean) 
     * @see #setTargetSize(int, int) 
     * @see #setTargetScale(double, double) 
     * @see #setTargetScale(double) 
     */
    @Override
    public int getIconWidth() {
        return getSizeValue(width,height,getIcon().getIconWidth(),
                getIcon().getIconHeight(),xScale);
    }
    /**
     * This returns the height of the scaled icon. If a {@link #isSizeSet() 
     * target size was specified}, then this will return a height that can fit 
     * within the bounding box formed by the {@link #getTargetWidth() target 
     * width} and {@link #getTargetHeight() height}. If {@link 
     * #isAspectRatioKept() aspect ratio is not preserved}, then this will 
     * return the target height. If a target scale was specified, then this will 
     * return the height of the {@link #getIcon() original icon} multiplied by 
     * the {@link #getTargetScaleY() target y-coordinate scaling factor}.
     * @return The height of the scaled icon.
     * @see #getIconWidth() 
     * @see #getIcon() 
     * @see #getScaleY() 
     * @see #getTargetWidth() 
     * @see #getTargetHeight() 
     * @see #getTargetScaleX()
     * @see #getTargetScaleY() 
     * @see #isSizeSet() 
     * @see #isAspectRatioKept() 
     * @see #setTargetSize(int, int, boolean) 
     * @see #setTargetSize(int, int) 
     * @see #setTargetScale(double, double) 
     * @see #setTargetScale(double) 
     */
    @Override
    public int getIconHeight() {
        return getSizeValue(height,width,getIcon().getIconHeight(),
                getIcon().getIconWidth(),yScale);
    }
    /**
     * This returns the target width for the scaled icon. If this is negative 
     * or the {@link #isAspectRatioKept() aspect ratio is preserved}, then this 
     * serves as the width of the bounding box that the {@link #getIcon() 
     * original icon} will be scaled to fit within, with a negative width being 
     * treated as if the bounding box has no width limit. Otherwise, this will 
     * be the {@link #getIconWidth() width} of the scaled icon. This is the that 
     * this does not throw an IllegalStateException if a {@link #isSizeSet() 
     * target scale was specified instead of a size}, and will instead return 
     * null if a scale was specified.
     * @return The width for the bounding box of the scaled icon, or null if 
     * a target scale was specified.
     * @see #getTargetWidth() 
     * @see #getInternalHeight() 
     * @see #getInternalScaleX() 
     * @see #getInternalScaleY() 
     * @see #isSizeSet() 
     * @see #isAspectRatioKept() 
     * @see #getIcon() 
     * @see #getIconWidth() 
     * @see #getScaleX() 
     */
    protected Integer getInternalWidth(){
        return width;
    }
    /**
     * This returns the target height for the scaled icon. If this is negative 
     * or the {@link #isAspectRatioKept() aspect ratio is preserved}, then this 
     * serves as the height of the bounding box that the {@link #getIcon() 
     * original icon} will be scaled to fit within, with a negative height being 
     * treated as if the bounding box has no height limit. Otherwise, this will 
     * be the {@link #getIconHeight() height} of the scaled icon. This is the 
     * same as the {@link #getTargetHeight() getTargetHeight} method, except 
     * that this does not throw an IllegalStateException if a {@link 
     * #isSizeSet() target scale was specified instead of a size}, and will 
     * instead return null if a scale was specified.
     * @return The height for the bounding box of the scaled icon, or null if 
     * a target scale was specified.
     * @see #getTargetHeight() 
     * @see #getInternalWidth() 
     * @see #getInternalScaleX() 
     * @see #getInternalScaleY() 
     * @see #isSizeSet() 
     * @see #isAspectRatioKept() 
     * @see #getIcon() 
     * @see #getIconHeight() 
     * @see #getScaleY() 
     */
    protected Integer getInternalHeight(){
        return height;
    }
    /**
     * This returns the value used to scale the width of the {@link #getIcon() 
     * original icon} to get the scaled icon's {@link #getIconWidth() width}. 
     * This is the same as the {@link #getTargetScaleX() getTargetScaleX} 
     * method, except that this does not throw an IllegalStateException if a 
     * {@link #isSizeSet() target size was specified instead of a scale}. 
     * Instead, this will return either a null or {@link Double#NaN} value if a 
     * size was specified, with {@code NaN} being used to indicate that the 
     * {@link #isAspectRatioKept() aspect ratio is preserved} even if neither 
     * the target {@link #getTargetWidth() width} nor {@link #getTargetHeight() 
     * height} are negative.
     * @return A positive number to use to scale the width of the original icon 
     * if a target scale was specified, null if a width was specified and the 
     * aspect ratio is not preserved unless the width is negative, and {@link 
     * Double#NaN} if a width was specified and the aspect ratio is preserved 
     * regardless of whether the width is negative.
     * @see #getTargetScaleX() 
     * @see #getInternalScaleY() 
     * @see #getInternalWidth() 
     * @see #getInternalHeight() 
     * @see #isSizeSet() 
     * @see #isAspectRatioKept() 
     * @see #getIcon() 
     * @see #getIconWidth() 
     * @see #getScaleX() 
     */
    protected Double getInternalScaleX(){
        return xScale;
    }
    /**
     * This returns the value used to scale the height of the {@link #getIcon() 
     * original icon} to get the scaled icon's {@link #getIconHeight() height}. 
     * This is the same as the {@link #getTargetScaleY() getTargetScaleY} 
     * method, except that this does not throw an IllegalStateException if a 
     * {@link #isSizeSet() target size was specified instead of a scale}. 
     * Instead, this will return either a null or {@link Double#NaN} value if a 
     * size was specified, with {@code NaN} being used to indicate that the 
     * {@link #isAspectRatioKept() aspect ratio is preserved} even if neither 
     * the target {@link #getTargetWidth() width} nor {@link #getTargetHeight() 
     * height} are negative.
     * @return A positive number to use to scale the height of the original icon 
     * if a target scale was specified, null if a height was specified and the 
     * aspect ratio is not preserved unless the height is negative, and {@link 
     * Double#NaN} if a height was specified and the aspect ratio is preserved 
     * regardless of whether the height is negative.
     * @see #getTargetScaleY() 
     * @see #getInternalScaleX() 
     * @see #getInternalWidth() 
     * @see #getInternalHeight() 
     * @see #isSizeSet() 
     * @see #isAspectRatioKept() 
     * @see #getIcon() 
     * @see #getIconHeight() 
     * @see #getScaleY() 
     */
    protected Double getInternalScaleY(){
        return yScale;
    }
    /**
     * This unwraps and returns the given size value if it is not null, and 
     * throws an IllegalStateException if it is null.
     * @param value The size value to return.
     * @return The given size value.
     * @throws IllegalStateException If the given size value is null.
     * @see #getTargetScaleValue(java.lang.Double) 
     * @see #getTargetWidth() 
     * @see #getTargetHeight() 
     * @see #getInternalWidth() 
     * @see #getInternalHeight() 
     */
    private int getTargetSizeValue(Integer value){
        if (value == null)  // If the value is null
            throw new IllegalStateException("No size was specified");
        return value;
    }
    /**
     * This returns the target width for the scaled icon. If this is negative 
     * or the {@link #isAspectRatioKept() aspect ratio is preserved}, then this 
     * serves as the width of the bounding box that the {@link #getIcon() 
     * original icon} will be scaled to fit within, with a negative width being 
     * treated as if the bounding box has no width limit. Otherwise, this will 
     * be the {@link #getIconWidth() width} of the scaled icon.
     * @return The width for the bounding box of the scaled icon.
     * @throws IllegalStateException If a target scale was specified instead of 
     * a size.
     * @see #getIcon() 
     * @see #getIconWidth() 
     * @see #getScaleX() 
     * @see #getTargetHeight() 
     * @see #getTargetScaleX() 
     * @see #getTargetScaleY() 
     * @see #isSizeSet() 
     * @see #isAspectRatioKept() 
     * @see #setTargetSize(int, int, boolean) 
     * @see #setTargetSize(int, int) 
     * @see #setTargetScale(double, double) 
     * @see #setTargetScale(double) 
     */
    public int getTargetWidth(){
        return getTargetSizeValue(width);
    }
    /**
     * This returns the target height for the scaled icon. If this is negative 
     * or the {@link #isAspectRatioKept() aspect ratio is preserved}, then this 
     * serves as the height of the bounding box that the {@link #getIcon() 
     * original icon} will be scaled to fit within, with a negative height being 
     * treated as if the bounding box has no height limit. Otherwise, this will 
     * be the {@link #getIconHeight() height} of the scaled icon.
     * @return The height for the bounding box of the scaled icon.
     * @throws IllegalStateException If a target scale was specified instead of 
     * a size.
     * @see #getIcon() 
     * @see #getIconHeight() 
     * @see #getScaleY() 
     * @see #getTargetWidth() 
     * @see #getTargetScaleX() 
     * @see #getTargetScaleY() 
     * @see #isSizeSet() 
     * @see #isAspectRatioKept() 
     * @see #setTargetSize(int, int, boolean) 
     * @see #setTargetSize(int, int) 
     * @see #setTargetScale(double, double) 
     * @see #setTargetScale(double) 
     */
    public int getTargetHeight(){
        return getTargetSizeValue(height);
    }
    /**
     * This unwraps and returns the given scale value if it is neither null nor 
     * {@link Double#NaN}, and throws an IllegalStateException if it is either 
     * of those.
     * @param value The scale value to return.
     * @return The given scale value.
     * @throws IllegalStateException If the given scale value is either null or 
     * {@link Double#NaN}.
     * @see #getTargetSizeValue(java.lang.Integer) 
     * @see #getTargetScaleX() 
     * @see #getTargetScaleY() 
     * @see #getInternalScaleX() 
     * @see #getInternalScaleY() 
     */
    private double getTargetScaleValue(Double value){
            // If the value is either null or NaN
        if (value == null || Double.isNaN(value))
            throw new IllegalStateException("No scale was specified");
        return value;
    }
    /**
     * This returns the value used to scale the width of the {@link #getIcon() 
     * original icon} to get the scaled icon's {@link #getIconWidth() width}.
     * @return The value used to scale the width of the original icon.
     * @throws IllegalStateException If a target size was specified instead of 
     * a scale.
     * @see #getIcon() 
     * @see #getIconWidth() 
     * @see #getScaleX() 
     * @see #getTargetScaleY() 
     * @see #getTargetWidth() 
     * @see #getTargetHeight() 
     * @see #isSizeSet() 
     * @see #setTargetSize(int, int, boolean) 
     * @see #setTargetSize(int, int) 
     * @see #setTargetScale(double, double) 
     * @see #setTargetScale(double) 
     */
    public double getTargetScaleX(){
        return getTargetScaleValue(xScale);
    }
    /**
     * This returns the value used to scale the height of the {@link #getIcon() 
     * original icon} to get the scaled icon's {@link #getIconHeight() height}.
     * @return The value used to scale the height of the original icon.
     * @throws IllegalStateException If a target size was specified instead of 
     * a scale.
     * @see #getIcon() 
     * @see #getIconHeight() 
     * @see #getScaleY() 
     * @see #getTargetScaleX() 
     * @see #getTargetWidth() 
     * @see #getTargetHeight() 
     * @see #isSizeSet() 
     * @see #setTargetSize(int, int, boolean) 
     * @see #setTargetSize(int, int) 
     * @see #setTargetScale(double, double) 
     * @see #setTargetScale(double) 
     */
    public double getTargetScaleY(){
        return getTargetScaleValue(yScale);
    }
    /**
     * This sets the target {@link #getTargetWidth() width} and {@link 
     * #getTargetHeight() height} to the given values, clearing any target scale 
     * that may have been set. If either of the given width or height are 
     * negative, or if {@code keepAspectRatio} is true, then the {@link 
     * #getIcon() original icon}'s aspect ratio will be preserved in the scaled 
     * icon and the given width and height will define a bounding box in which 
     * the scaled icon will fit within, with negative values being treated as if 
     * no limit was given for that value. If both the width and height are 
     * negative, then the original icon will not be scaled and will be shown as 
     * is. If the aspect ratio is not preserved, then the given width and height 
     * will be used as the {@link #getIconWidth() width} and {@link 
     * #getIconHeight() height} of the scaled icon, respectively.
     * @param width The width for the bounding box of the scaled icon.
     * @param height The height for the bounding box of the scaled icon.
     * @param keepAspectRatio Whether the aspect ratio of the original icon is 
     * to be maintained regardless of whether either of the target width or 
     * height are negative.
     * @return This ScaledIcon.
     * @see #setTargetSize(int, int) 
     * @see #setTargetScale(double, double) 
     * @see #setTargetScale(double) 
     * @see #getTargetWidth() 
     * @see #getTargetHeight() 
     * @see #getIcon() 
     * @see #getIconWidth() 
     * @see #getIconHeight() 
     * @see #isSizeSet() 
     * @see #isAspectRatioKept() 
     */
    public ScaledIcon setTargetSize(int width, int height, boolean keepAspectRatio){
        this.width = width;
        this.height = height;
        this.xScale = getKeepAspectRatioIndicator(keepAspectRatio);
        this.yScale = this.xScale;
        return this;
    }
    /**
     * This sets the target {@link #getTargetWidth() width} and {@link 
     * #getTargetHeight() height} to the given values, clearing any target scale 
     * that may have been set. If either of the given width or height are 
     * negative, then the {@link #getIcon() original icon}'s aspect ratio will 
     * be preserved in the scaled icon, with the non-negative value being used 
     * as the corresponding value for the scaled icon and the negative value 
     * being substituted with one that maintains the aspect ratio. If both the 
     * width and height are negative, then the original icon will not be scaled 
     * and will be shown as is. If neither of the width and height are negative, 
     * then they are used as the {@link #getIconWidth() width} and {@link 
     * #getIconHeight() height} of the scaled icon, respectively. This is 
     * equivalent to calling {@link #setTargetSize(int, int, boolean) 
     * setTargetSize}{@code (width, height, false)}.
     * @param width The width for the bounding box of the scaled icon.
     * @param height The height for the bounding box of the scaled icon.
     * @return This ScaledIcon.
     * @see #setTargetSize(int, int, boolean) 
     * @see #setTargetScale(double, double) 
     * @see #setTargetScale(double) 
     * @see #getTargetWidth() 
     * @see #getTargetHeight() 
     * @see #getIcon() 
     * @see #getIconWidth() 
     * @see #getIconHeight() 
     * @see #isSizeSet() 
     * @see #isAspectRatioKept() 
     */
    public ScaledIcon setTargetSize(int width, int height){
        return setTargetSize(width,height,false);
    }
    /**
     * This sets the target {@link #getTargetScaleX() x} and {@link 
     * #getTargetScaleY() y} coordinate scaling factors to the given values, 
     * clearing any target size that may have been set.
     * @param xScale The value to use to scale the {@link #getIcon() original 
     * icon}'s width (must be greater than zero and cannot be {@link 
     * Double#POSITIVE_INFINITY}).
     * @param yScale The value to use to scale the {@link #getIcon() original 
     * icon}'s height (must be greater than zero and cannot be {@link 
     * Double#POSITIVE_INFINITY}).
     * @return This ScaledIcon.
     * @throws IllegalArgumentException If either of the given x or y coordinate 
     * scaling factors are either positive infinity or less than or equal to 
     * zero.
     * @see #setTargetScale(double) 
     * @see #setTargetSize(int, int, boolean) 
     * @see #setTargetSize(int, int) 
     * @see #getTargetScaleX() 
     * @see #getTargetScaleY() 
     * @see #getIcon() 
     * @see #getIconWidth() 
     * @see #getIconHeight() 
     * @see #isSizeSet() 
     * @see #isAspectRatioKept() 
     */
    public ScaledIcon setTargetScale(double xScale, double yScale){
        checkScale(xScale,"X");
        checkScale(yScale,"Y");
        this.width = null;
        this.height = null;
        this.xScale = xScale;
        this.yScale = yScale;
        return this;
    }
    /**
     * This sets the target {@link #getTargetScaleX() x} and {@link 
     * #getTargetScaleY() y} coordinate scaling factors to the given value, 
     * clearing any target size that may have been set.
     * @param scale The value to use to scale the {@link #getIcon() original 
     * icon}'s width and height (must be greater than zero and cannot be {@link 
     * Double#POSITIVE_INFINITY}).
     * @return This ScaledIcon.
     * @throws IllegalArgumentException If the given scaling factor is either 
     * positive infinity or less than or equal to zero.
     * @see #setTargetScale(double, double) 
     * @see #setTargetSize(int, int, boolean) 
     * @see #setTargetSize(int, int) 
     * @see #getTargetScaleX() 
     * @see #getTargetScaleY() 
     * @see #getIcon() 
     * @see #getIconWidth() 
     * @see #getIconHeight() 
     * @see #isSizeSet() 
     * @see #isAspectRatioKept() 
     */
    public ScaledIcon setTargetScale(double scale){
        checkScale(scale,"X and Y");
        return setTargetScale(scale,scale);
    }
    /**
     * This returns whether a size for the scaled icon was set. If a size was 
     * set, then the {@link #getIcon() original icon} is scaled up to the size 
     * that was set for it. If a size was not set, then the original icon is 
     * scaled based off x and y coordinate scaling factors.
     * @return Whether a size was specifically set for the scaled icon.
     * @see #isAspectRatioKept() 
     * @see #getIcon() 
     * @see #getTargetWidth() 
     * @see #getTargetHeight() 
     * @see #getTargetScaleX() 
     * @see #getTargetScaleY() 
     * @see #setTargetSize(int, int, boolean) 
     * @see #setTargetSize(int, int) 
     * @see #setTargetScale(double, double) 
     * @see #setTargetScale(double) 
     */
    public boolean isSizeSet(){
        return width != null && height != null;
    }
    /**
     * This returns whether the aspect ratio of the {@link #getIcon() original 
     * icon} is preserved in the scaled icon. If a width and height were 
     * specified, then this will return true if either the width or height are 
     * negative or the aspect ratio was set to be preserved. If x and y 
     * coordinate scaling factors were specified, then this will return true if 
     * the x and y coordinate scaling factors are equal to each other, or in 
     * other words, were set to the same value.
     * @return Whether the aspect ratio of the original icon is preserved.
     * @see #isSizeSet() 
     * @see #getIcon() 
     * @see #getTargetWidth() 
     * @see #getTargetHeight() 
     * @see #getTargetScaleX() 
     * @see #getTargetScaleY() 
     * @see #setTargetSize(int, int, boolean) 
     * @see #setTargetSize(int, int) 
     * @see #setTargetScale(double, double) 
     * @see #setTargetScale(double) 
     */
    public boolean isAspectRatioKept(){
        if (!isSizeSet())     // If a size was not specified
            return Objects.equals(xScale, yScale);
        return width < 0 || height < 0 || xScale != null || yScale != null;
    }
    /**
     * This returns a String containing parameters for this ScaledIcon.
     * @return A String with the parameters for this icon.
     */
    protected String paramString(){
        return getIconWidth()+"x"+getIconHeight() + 
                ",xScale="+getScaleX() + 
                ",yScale="+getScaleY() + 
                ",isSizeSet=" + isSizeSet() + 
                ",isAspectRatioKept=" + isAspectRatioKept() + 
                    // If a size was set, state the target size. Otherwise, 
                    // state the target scale
                ",targetS"+((isSizeSet())?("ize="+width+"x"+height):"cale="+xScale+"x"+yScale) + 
                ",icon="+getIcon();
    }
    @Override
    public String toString(){
        return getClass().getName()+"["+paramString()+"]";
    }
    /**
     * This scales the given image to fit within the given width and height,
     * while still maintaining the original aspect ratio of the image. <p>
     * This acts in a way similar to calling {@code getScaledInstance} on an 
     * image, with the difference being that this will always attempt to 
     * maintain the original aspect ratio of the image regardless of whether or 
     * not a negative value has been provided for either the width or height.<p>
     * If neither the width nor the height are negative values, then this will 
     * attempt to scale the image as close as possible to the given dimensions 
     * without having to distort the image or exceed the dimensions.
     * @param image The image to scale.
     * @param width The width to attempt to scale the image to.
     * @param height The height to attempt to scale the image to.
     * @param hints The flag to indicate the type of image scaling algorithm to 
     * use.
     * @return A scaled version of the image.
     * @see java.awt.Image#getScaledInstance(int, int, int) 
     */
    public static Image scaleImageToFit(Image image, int width, int height, int hints){
        if (image == null)                      // If the image is null
            return null;
            // If either the width or height are less than or equal to 0 
            // (A negative value for either one would have maintained the aspect 
        else if (width <= 0 || height <= 0) // ratio anyway)
            return image.getScaledInstance(width, height, hints);
        int imgWidth = image.getWidth(null);   // Get the width of the image
        int imgHeight = image.getHeight(null); // Get the height of the image
            // If either the image's width or the height match the given width 
            // or height, respectively, and the other one is less than or equal 
            // to the value given for it.
        if ((imgWidth == width && imgHeight <= height) || (imgWidth <= width && 
                imgHeight == height))
            return image.getScaledInstance(-1, -1, hints);
            // If the ratio of original vs target width is less than the ratio 
            // of original vs target height (i.e. if scaling the height while 
            // maintaining the aspect ratio is what will get the dimensions of 
            // the image the closest to the given dimensions)
        else if ((((double)imgWidth)/width) < (((double)imgHeight)/height))
            return image.getScaledInstance(-1, height, hints);
        else
            return image.getScaledInstance(width, -1, hints);
    }
}
