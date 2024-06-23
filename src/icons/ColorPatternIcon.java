/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package icons;

import java.awt.*;
import java.util.Objects;
import javax.swing.event.*;
import painters.ColorPatternPainter;

/**
 * This is a simple icon that generates and displays a pattern can be used to 
 * test things that display icons. If a color is set, then the pattern will be 
 * derived from that color. Otherwise, the pattern will be generated using a set 
 * of predefined colors. The icon can be displayed in a horizontal or vertical, 
 * orientation, can be flipped, can have its colors inverted, and can be drawn 
 * to a specific scale. The colors can also be drawn using an actual gradient 
 * instead of the pseudo-gradient that it defaults to. Each setter method will 
 * return the calling ColorPatternIcon so that they can be chained together to 
 * change multiple properties with a single line of code. <p>
 * 
 * This can function both as an icon version of {@code ColorPatternPainter} and 
 * as an icon wrapper for a {@link ColorPatternPainter}. When no {@code 
 * ColorPatternPainter} is set for a {@code ColorPatternIcon}, then the {@code 
 * ColorPatternIcon} will use the default implementations for the {@code 
 * ColorPatternPainter} methods and will use it's own state. When a {@code 
 * ColorPatternPainter} is set for a {@code ColorPatternIcon}, then the {@code 
 * paint} method and all state related setter and getter methods of the {@code 
 * ColorPatternIcon} will delegate to their corresponding methods of the set 
 * {@code ColorPatternPainter}. In addition, setting the state of a {@code 
 * ColorPatternIcon} with a {@code ColorPatternPainter} will only affect the set 
 * {@code ColorPatternPainter}'s state and will not affect the stored state of 
 * the {@code ColorPatternIcon}. The stored state of a {@code ColorPatternIcon} 
 * is only used when no {@code ColorPatternPainter} is set. <p>
 * 
 * {@code ColorPatternIcon}s will notify any {@code ChangeListener}s 
 * registered to them if their {@link #getState state}, {@link #getColor color}, 
 * {@link #getScale scale}, or {@link #getPainter painter} changes. 
 * Additionally, if a painter is set, then the {@code ChangeListener}s will also 
 * be notified of any changes made to the painter. In other words, {@code 
 * ColorPatternIcon}s will notify the {@code ChangeListener}s if either the icon 
 * should be repainted or their set painter is changed.
 * 
 * @author Milo Steier
 * @see ColorPatternPainter
 */
public class ColorPatternIcon extends ColorPatternPainter implements Icon2D{
    /**
     * This is a {@code ColorPatternPainter} that can be used to override the 
     * normal {@code ColorPatternPainter} functionality of this {@code 
     * ColorPatternIcon}. When this is null, this {@code ColorPatternIcon} 
     * should use it's inherited {@code ColorPatternPainter} functionality.
     */
    private ColorPatternPainter painter = null;
    /**
     * The handler used to listen to the set {@code ColorPatternPainter}. This 
     * is initialized the first time a {@code ColorPatternPainter} is set.
     */
    private Handler handler = null;
    /**
     * This stores the color for this {@code ColorPatternIcon}.
     */
    private Color color;
    /**
     * This stores the width and height for this {@code ColorPatternIcon}.
     */
    private int size;
    /**
     * This stores the scale that has been set for this {@code 
     * ColorPatternIcon}.
     */
    private double scale = -1;
    /**
     * This constructs a {@code ColorPatternIcon} with the given color, state, 
     * and scale.
     * @param state The state for this icon (must be a positive integer between 
     * 0 and {@link #MAXIMUM_VALID_STATE}, inclusive).
     * @param color The color to use for this icon (or null to use a set of 
     * predefined colors).
     * @param scale The scaling factor for this icon (cannot be less than or 
     * equal to zero and cannot be {@link Double#POSITIVE_INFINITY}).
     * @throws IllegalArgumentException If the given state is invalid or if the 
     * given scaling factor is either negative, zero, or positive infinity.
     */
    public ColorPatternIcon(int state, Color color, double scale){
        super(state);
        this.color = color;
        ColorPatternIcon.this.setScale(scale);
    }
    /**
     * This constructs a {@code ColorPatternIcon} with the given color and 
     * state. The scale will be set to 2 by default.
     * @param state The state for this icon (must be a positive integer between 
     * 0 and {@link #MAXIMUM_VALID_STATE}, inclusive).
     * @param color The color to use for this icon (or null to use a set of 
     * predefined colors).
     * @throws IllegalArgumentException If the given state is invalid.
     */
    public ColorPatternIcon(int state, Color color){
        this(state,color,2);
    }
    /**
     * This constructs a {@code ColorPatternIcon} with the given state and 
     * scale. The color will be set to null by default.
     * @param state The state for this icon (must be a positive integer between 
     * 0 and {@link #MAXIMUM_VALID_STATE}, inclusive).
     * @param scale The scaling factor for this icon (cannot be less than or 
     * equal to zero and cannot be {@link Double#POSITIVE_INFINITY}).
     * @throws IllegalArgumentException If the given state is invalid or if the 
     * given scaling factor is either negative, zero, or positive infinity.
     */
    public ColorPatternIcon(int state, double scale){
        this(state,null,scale);
    }
    /**
     * This constructs a {@code ColorPatternIcon} with the given state. The 
     * color will be set to null and the scale will be set to 2 by default.
     * @param state The state for this icon (must be a positive integer between 
     * 0 and {@link #MAXIMUM_VALID_STATE}, inclusive).
     * @throws IllegalArgumentException If the given state is invalid.
     */
    public ColorPatternIcon(int state){
        this(state,2);
    }
    /**
     * This constructs a {@code ColorPatternIcon} with the given color and 
     * scale. The state will be set to zero by default.
     * @param color The color to use for this icon (or null to use a set of 
     * predefined colors).
     * @param scale The scaling factor for this icon (cannot be less than or 
     * equal to zero and cannot be {@link Double#POSITIVE_INFINITY}).
     * @throws IllegalArgumentException If the given scaling factor is either 
     * negative, zero, or positive infinity.
     */
    public ColorPatternIcon(Color color, double scale){
        this(0,color,scale);
    }
    /**
     * This constructs a {@code ColorPatternIcon} with the given color. The 
     * state will be set to zero and the scale will be set to 2 by default.
     * @param color The color to use for this icon (or null to use a set of 
     * predefined colors).
     */
    public ColorPatternIcon(Color color){
        this(0,color,2);
    }
    /**
     * This constructs a {@code ColorPatternIcon} with the given scale. The 
     * color will be set to null and the state will be set to zero by default.
     * @param scale The scaling factor for this icon (cannot be less than or 
     * equal to zero and cannot be {@link Double#POSITIVE_INFINITY}).
     * @throws IllegalArgumentException If the given scaling factor is either 
     * negative, zero, or positive infinity.
     */
    public ColorPatternIcon(double scale){
        this(0,scale);
    }
    /**
     * This constructs a {@code ColorPatternIcon} with the default settings. The 
     * color will be set to null, the state will be set to zero, and the scale 
     * will be set to 2 by default.
     */
    public ColorPatternIcon(){
        this(0);
    }
    /**
     * This constructs a {@code ColorPatternIcon} with the given {@code 
     * ColorPatternPainter}, color, and scale. If the given painter is null, 
     * then a default state of zero will be used.
     * @param painter The painter to delegate to, or null.
     * @param color The color to use for this icon (or null to use a set of 
     * predefined colors).
     * @param scale The scaling factor for this icon (cannot be less than or 
     * equal to zero and cannot be {@link Double#POSITIVE_INFINITY}).
     * @throws IllegalArgumentException If the given state is invalid or if the 
     * given scaling factor is either negative, zero, or positive infinity.
     */
    public ColorPatternIcon(ColorPatternPainter painter, Color color, 
            double scale){
        this(color,scale);
        if (painter != null)    // If the painter is not null
            ColorPatternIcon.this.setPainter(painter);
    }
    /**
     * This constructs a {@code ColorPatternIcon} with the given {@code 
     * ColorPatternPainter} and color. The scale will be set to 2 by default. If 
     * the given painter is null, then a default state of zero will be used.
     * @param painter The painter to delegate to, or null.
     * @param color The color to use for this icon (or null to use a set of 
     * predefined colors).
     */
    public ColorPatternIcon(ColorPatternPainter painter, Color color){
        this(painter,color,2);
    }
    /**
     * This constructs a {@code ColorPatternIcon} with the given {@code 
     * ColorPatternPainter} and scale. The color will be set to null by default. 
     * If the given painter is null, then a default state of zero will be used.
     * @param painter The painter to delegate to, or null.
     * @param scale The scaling factor for this icon (cannot be less than or 
     * equal to zero and cannot be {@link Double#POSITIVE_INFINITY}).
     * @throws IllegalArgumentException If the given state is invalid or if the 
     * given scaling factor is either negative, zero, or positive infinity.
     */
    public ColorPatternIcon(ColorPatternPainter painter, double scale){
        this(painter,null,scale);
    }
    /**
     * This constructs a {@code ColorPatternIcon} with the given {@code 
     * ColorPatternPainter}. The color will be set to null and the scale will be 
     * set to 2 by default. If the given painter is null, then a default state 
     * of zero will be used.
     * @param painter The painter to delegate to, or null.
     */
    public ColorPatternIcon(ColorPatternPainter painter){
        this(painter,null);
    }
    /**
     * This constructs a {@code ColorPatternIcon} that is a copy of the given 
     * {@code ColorPatternIcon}.
     * @param icon The {@code ColorPatternIcon} to copy.
     */
    public ColorPatternIcon(ColorPatternIcon icon){
        super(icon);
        color = icon.getColor();
        size = icon.getIconWidth();
        scale = icon.getScale();
        ColorPatternIcon.this.setPainter(icon.getPainter());
    }
    /**
     * {@inheritDoc } <p>
     * 
     * However, if a {@link #getPainter painter} is set for this {@code 
     * ColorPatternIcon}, then this will delegate the painting to the painter's 
     * {@code paint} method instead. <p>
     * 
     * If invoked with a null color, then this will instead use the {@link 
     * #getColor color} set for this icon. If that is also null, then this will 
     * use a set of predefined colors.
     * 
     * @param g {@inheritDoc }
     * @param color The color to use for the rendered pattern. If this is null, 
     * then the {@link #getColor color} set for this icon will be used. If that 
     * is also null, then the pattern will be generated using a set of 
     * predefined colors.
     * @param width {@inheritDoc }
     * @param height {@inheritDoc }
     * @see #getState 
     * @see #setState 
     * @see #getPainter 
     * @see #setPainter 
     * @see #getColor 
     * @see #setColor 
     * @see #paintIcon 
     * @see #paintIcon2D 
     */
    @Override
    public void paint(Graphics2D g, Color color, int width, int height) {
        if (color == null)      // If no color was provided
            color = getColor(); // Use the color set for this icon
        if (painter != null)    // If a painter is set for this icon
            painter.paint(g, color, width, height);
        else
            super.paint(g, color, width, height);
    }
    /**
     * {@inheritDoc } <p>
     * 
     * This method delegates the task of painting the icon to the {@link #paint 
     * paint} method, providing it with the icon's {@link #getIconWidth width}, 
     * {@link #getIconHeight height}, and {@link #getColor set color}.
     * 
     * @see #paint 
     * @see #getColor 
     * @see #setColor 
     * @see #getIconWidth 
     * @see #getIconHeight 
     * @see #getScale 
     * @see #setScale 
     */
    @Override
    public void paintIcon2D(Component c, Graphics2D g, int x, int y){
        g.translate(x, y);
        paint(g,getColor(),getIconWidth(),getIconHeight());
    }
    /**
     * This is used to check if the scale is valid, and if not, this throws an 
     * IllegalArgumentException.
     * @param scale The scale to check.
     * @throws IllegalArgumentException If the given scale is negative, zero, 
     * NaN, or positive infinity.
     * @see #setScale 
     */
    protected void checkScale(double scale){
            // If the scale is less than or equal to zero or if it is NaN or 
        if (scale <= 0 || !Double.isFinite(scale))  // infinite
            throw new IllegalArgumentException("Scale must be a finite number greater than 0");
    }
    /**
     * This sets the scaling factor to use when rendering this {@code 
     * ColorPatternIcon}.
     * @param scale The scaling factor for this icon (cannot be less than or 
     * equal to zero and cannot be {@link Double#POSITIVE_INFINITY}).
     * @return This {@code ColorPatternIcon}.
     * @throws IllegalArgumentException If the given scaling factor is either 
     * negative, zero, or positive infinity.
     * @see #getScale() 
     * @see #getIconWidth() 
     * @see #getIconHeight() 
     */
    public ColorPatternIcon setScale(double scale){
        if (this.scale == scale)    // If the scale would not change
            return this;
        checkScale(scale);          // Check the new scaling factor
        this.scale = scale;
            // Get the new size for the icon
        size = (int)Math.floor(INTERNAL_SIZE * scale);
        fireStateChanged();         // Fire a state change event
        return this;
    }
    /**
     * This returns the scaling factor used when rendering this {@code 
     * ColorPatternIcon}.
     * @return The scaling factor for this icon.
     * @see #setScale(double) 
     * @see #getIconWidth() 
     * @see #getIconHeight() 
     */
    public double getScale(){
        return scale;
    }
    /**
     * This sets the color to use for the pattern displayed by this {@code 
     * ColorPatternIcon}. If this is set to null, then the pattern will use a 
     * set of predefined colors.
     * @param color The color to use for this icon, or null to use the 
     * predefined colors.
     * @return This {@code ColorPatternIcon}.
     * @see #getColor() 
     */
    public ColorPatternIcon setColor(Color color){
        if (Objects.equals(color, this.color))  // If the color will not change
            return this;
        this.color = color;
        fireStateChanged();         // Fire a state change event
        return this;
    }
    /**
     * This returns the color used for the pattern displayed by this {@code 
     * ColorPatternIcon}. If this returns null, then this icon uses a set of 
     * predefined colors for the pattern.
     * @return The color used by this icon for the pattern, or null if no color 
     * is set.
     * @see #setColor
     */
    public Color getColor(){
        return color;
    }
    /**
     * This sets the state for this {@code ColorPatternIcon}. The state is used 
     * to control how this {@code ColorPatternIcon} is rendered based off of 
     * which flags are set for the state. If a {@link #getPainter painter} is 
     * set, then this will delegate to the {@code setState} method of the set 
     * painter and the state stored for this icon will be unaffected.
     * @param state The state for this icon. If a {@link #getPainter painter} is 
     * set, then this must be a valid state for the painter. Otherwise, this 
     * must be a positive integer between 0 and {@link #MAXIMUM_VALID_STATE}, 
     * inclusive.
     * @return This {@code ColorPatternIcon}.
     * @throws IllegalArgumentException If the given state is not a valid state.
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
     * @see #getPainter 
     * @see #setPainter 
     */
    @Override
    public ColorPatternIcon setState(int state){
        if (painter != null)    // If a painter is set for this icon
            painter.setState(state);
        else
            super.setState(state);
        return this;
    }
    /**
     * This returns the state for this {@code ColorPatternIcon}. The state is 
     * used to control how this {@code ColorPatternIcon} is rendered based off 
     * of which flags are set for the state. If a {@link #getPainter painter} is 
     * set, then this will delegate to the {@code getState} method of the set 
     * painter. 
     * @return The state for this {@code ColorPatternIcon}.
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
     * @see #getPainter 
     * @see #setPainter 
     */
    @Override
    public int getState(){
        if (painter != null)    // If a painter is set for this icon
            return painter.getState();
        return super.getState();
    }
    /**
     * {@inheritDoc } If a {@link #getPainter painter} is set, then the flag 
     * will be set for the painter's state and the state stored for this icon 
     * will be unaffected.
     * @param flag {@inheritDoc }
     * @param value {@inheritDoc }
     * @return This {@code ColorPatternIcon}.
     * @throws IllegalArgumentException {@inheritDoc }
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
     * @see #getPainter 
     * @see #setPainter 
     */
    @Override
    public ColorPatternIcon setFlag(int flag, boolean value){
        super.setFlag(flag, value);
        return this;
    }
    /**
     * {@inheritDoc } If a {@link #getPainter painter} is set, then this will 
     * return whether the given flag is set for the painter's state.
     * @param flag {@inheritDoc }
     * @return {@inheritDoc }
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
     * @see #getPainter 
     * @see #setPainter 
     */
    @Override
    public boolean getFlag(int flag){
        return super.getFlag(flag);
    }
    /**
     * This sets whether this {@code ColorPatternIcon} is horizontally or 
     * vertically oriented. If a {@link #getPainter painter} is set, then this 
     * will be set for the painter and the state stored for this icon will be 
     * unaffected. In other words, if there is a painter set, then this will be 
     * set for the painter and does not affect whether this icon will be 
     * horizontally or vertically oriented when no painter is set.
     * @param value Whether this icon should be vertically oriented.
     * @return This {@code ColorPatternIcon}.
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
     * @see #getPainter 
     * @see #setPainter 
     */
    @Override
    public ColorPatternIcon setVertical(boolean value){
        super.setVertical(value);
        return this;
    }
    /**
     * This returns whether this {@code ColorPatternIcon} is horizontally or 
     * vertically oriented.
     * @return Whether this icon is vertically oriented.
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
     * @see #getPainter 
     * @see #setPainter 
     */
    @Override
    public boolean isVertical(){
        return super.isVertical();
    }
    /**
     * This sets whether this {@code ColorPatternIcon} is flipped. If a {@link 
     * #getPainter painter} is set, then this will be set for the painter and 
     * the state stored for this icon will be unaffected. In other words, if 
     * there is a painter set, then this will be set for the painter and does 
     * not affect whether this icon will be flipped when no painter is set.
     * @param value Whether this icon should be flipped 180 degrees.
     * @return This {@code ColorPatternIcon}.
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
     * @see #getPainter 
     * @see #setPainter 
     */
    @Override
    public ColorPatternIcon setFlipped(boolean value){
        super.setFlipped(value);
        return this;
    }
    /**
     * This returns whether this {@code ColorPatternIcon} is flipped.
     * @return Whether this icon is flipped 180 degrees.
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
     * @see #getPainter 
     * @see #setPainter 
     */
    @Override
    public boolean isFlipped(){
        return super.isFlipped();
    }
    /**
     * This sets whether the colors for this {@code ColorPatternIcon} should be 
     * inverted to produce a negative image. If a {@link #getPainter painter} is 
     * set, then this will be set for the painter and the state stored for this 
     * icon will be unaffected. In other words, if there is a painter set, then 
     * this will be set for the painter and does not affect whether the colors 
     * for this icon will be inverted when no painter is set.
     * @param value Whether the colors should be inverted.
     * @return This {@code ColorPatternIcon}.
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
     * @see #getPainter 
     * @see #setPainter 
     */
    @Override
    public ColorPatternIcon setInverted(boolean value){
        super.setInverted(value);
        return this;
    }
    /**
     * This returns whether the colors for this {@code ColorPatternIcon} are 
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
     * @see #getPainter 
     * @see #setPainter 
     */
    @Override
    public boolean isInverted(){
        return super.isInverted();
    }
    /**
     * This sets whether this {@code ColorPatternIcon} uses a gradient instead 
     * of a pattern. If a {@link #getPainter painter} is set, then this will be 
     * set for the painter and the state stored for this icon will be 
     * unaffected. In other words, if there is a painter set, then this will be 
     * set for the painter and does not affect whether this icon will use a 
     * gradient when no painter is set.
     * @param value Whether this icon uses a gradient.
     * @return This {@code ColorPatternIcon}.
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
     * @see #getPainter 
     * @see #setPainter 
     */
    @Override
    public ColorPatternIcon setUsesGradient(boolean value){
        super.setUsesGradient(value);
        return this;
    }
    /**
     * This returns whether this {@code ColorPatternIcon} uses a gradient 
     * instead of a pattern.
     * @return Whether this icon uses a gradient.
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
     * @see #getPainter 
     * @see #setPainter 
     */
    @Override
    public boolean getUsesGradient(){
        return super.getUsesGradient();
    }
    /**
     * This sets whether the center colors for this {@code ColorPatternIcon} 
     * will fade to black or white. 
     * @param value Whether the colors should fade to white.
     * @return This {@code ColorPatternIcon}.
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
    @Override
    public ColorPatternIcon setFadesToWhite(boolean value){
        super.setFadesToWhite(value);
        return this;
    }
    /**
     * This gets whether the center colors for this {@code ColorPatternIcon} 
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
    @Override
    public boolean getFadesToWhite(){
        return super.getFadesToWhite();
    }
    /**
     * This sets the {@code ColorPatternPainter} that this {@code 
     * ColorPatternIcon} will delegate the rendering the pattern to when 
     * painting the icon. Additionally, the state for the given {@code 
     * ColorPatternPainter} will be used as the state for this {@code 
     * ColorPatternIcon} and any {@code ChangeListener}s registered to this icon 
     * will be notified each time a change to the painter occurs. If this is set 
     * to null, then the pattern will be rendered using the default 
     * implementation of the {@code ColorPatternPainter} {@code paint} method 
     * and will use it's own state instead. 
     * @param painter The {@code ColorPatternPainter} to use to render the 
     * pattern for this icon, or null.
     * @return This {@code ColorPatternIcon}.
     * @throws IllegalArgumentException If the painter is this icon.
     * @see #getPainter 
     * @see #paint 
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
     * @see #getFadesToWhite 
     */
    public ColorPatternIcon setPainter(ColorPatternPainter painter){
        if (painter == this)    // If the painter is this icon
            throw new IllegalArgumentException("Painter cannot be the icon");
        else if (painter == this.painter)   // If the painter would not change
            return this;
        if (handler == null)    // If the painter handler has not been initialized yet
            handler = new Handler();
            // If the old painter is not null
        else if (this.painter != null)
            this.painter.removeChangeListener(handler);
        this.painter = painter;
        if (painter != null)    // If the new painter is not null
            painter.addChangeListener(handler);
        fireStateChanged();         // Fire a state change event
        return this;
    }
    /**
     * This returns the {@code ColorPatternPainter} used to render the pattern 
     * for this icon. If this is null, then the pattern will be rendered using 
     * the default implementation for the {@code ColorPatternPainter} {@code 
     * paint} method. For more information, refer to the documentation for the 
     * {@link #setPainter setPainter} method.
     * @return The {@code ColorPatternPainter} used to render the pattern for 
     * this icon, or null.
     * @see #setPainter 
     * @see #paint 
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
     * @see #getFadesToWhite 
     */
    public ColorPatternPainter getPainter(){
        return painter;
    }
    /**
     * This returns a String representation of this {@code ColorPatternIcon}. 
     * This method is primarily intended to be used only for debugging purposes, 
     * and the content and format of the returned String may vary between 
     * implementations.
     * @return A String representation of this {@code ColorPatternIcon}.
     */
    @Override
    protected String paramString(){
        return getIconWidth() + "x" + getIconHeight() + 
                ",scale=" + getScale() + 
                ",color=" + Objects.toString(getColor(), "") + 
                "," + super.paramString()+
                ",painter="+Objects.toString(getPainter(),"");
    }
    /**
     * This returns the icon's width.
     * @return The width of this icon.
     * @see #getIconHeight 
     * @see #setScale 
     * @see #getScale 
     */
    @Override
    public int getIconWidth() {
        return size;
    }
    /**
     * This returns the icon's height.
     * @return The height of this icon.
     * @see #getIconWidth 
     * @see #setScale 
     * @see #getScale 
     */
    @Override
    public int getIconHeight() {
        return getIconWidth();
    }
    /**
     * A handler class used to listen for changes made to the set painter and 
     * forward the notification to the ChangeListeners registered to this icon.
     */
    private class Handler implements ChangeListener{
        @Override
        public void stateChanged(ChangeEvent evt) {
                // Forward the state changed event to the listeners
            fireStateChanged();     
        }
        
    }
}
