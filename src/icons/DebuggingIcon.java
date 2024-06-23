/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package icons;

import java.awt.*;
import java.awt.geom.Area;
import java.awt.image.*;
import java.util.Objects;
import javax.swing.*;

/**
 * This is an icon that is primarily intended to be used in the debugging of 
 * other icons so as to ensure that their {@link 
 * #paintIcon(java.awt.Component, java.awt.Graphics, int, int) paintIcon} method 
 * is properly drawing what it is intended to be drawing. This icon can draw a 
 * set background color behind the icon being debugged, as well as drawing a  
 * bounding box and crosshair in the center over the icon being debugged. This 
 * icon also provides methods of converting it into an image in the event that a 
 * closer inspection of the icon in an image editing program is desired. 
 * Another debugging feature that this icon provides is the ability to set a 
 * specific location to give to the icon without having to actually draw the 
 * icon at that location. This is handy for debugging icons that are sensitive 
 * to their location, as this allows for the icon to believe it is being painted 
 * in a certain location while actually being painted where this icon is being 
 * painted.
 * @author Milo Steier
 */
public class DebuggingIcon implements DerivedIcon{
    /**
     * The icon being debugged.
     */
    private final Icon icon;
    /**
     * The background color for this icon.
     */
    private Color bg;
    /**
     * The foreground for this icon, used to draw the bounding box and 
     * crosshair.
     */
    private Color fg;
    /**
     * Whether the debug elements are to be drawn.
     */
    private boolean debugEnabled;
    /**
     * This is the location that the icon being debugged thinks it is rendering 
     * at.
     */
    private Point point;
    /**
     * This constructs a DebuggingIcon to debug the given icon with the given 
     * foreground, background, location, and whether the debug elements are 
     * enabled.
     * @param icon The icon to be debugged (cannot be null or a DebuggingIcon).
     * @param debug Whether the debug elements should be shown (if false, then 
     * the icon is rendered as is).
     * @param fg The foreground to render behind the icon (if null, then the 
     * debug elements rendered over the icon will invert the color of the icon).
     * @param bg The background to render behind the icon.
     * @param point The location to give to the icon when rendering it, or null.
     * @throws IllegalArgumentException If the icon is a DebuggingIcon.
     * @throws NullPointerException If the icon is null.
     */
    public DebuggingIcon(Icon icon, boolean debug, Color fg, Color bg, Point point){
        if (icon instanceof DebuggingIcon)  // If the icon is a DebuggingIcon
            throw new IllegalArgumentException("Icon must not be a DebuggingIcon");
        this.icon = Objects.requireNonNull(icon, "Icon cannot be null");
        debugEnabled = debug;
        this.bg = bg;
        this.fg = fg;
            // Create a copy of the point if not null. Otherwise, store null.
        this.point = (point != null) ? point.getLocation() : null;
    }
    /**
     * This constructs a DebuggingIcon to debug the given icon with the given 
     * foreground, background, location, and whether the debug elements are 
     * enabled.
     * @param icon The icon to be debugged (cannot be null or a DebuggingIcon).
     * @param debug Whether the debug elements should be shown (if false, then 
     * the icon is rendered as is).
     * @param fg The foreground to render behind the icon (if null, then the 
     * debug elements rendered over the icon will invert the color of the icon).
     * @param bg The background to render behind the icon.
     * @param x The x-coordinate of the location to give to the icon when 
     * rendering it.
     * @param y The y-coordinate of the location to give to the icon when 
     * rendering it.
     * @throws IllegalArgumentException If the icon is a DebuggingIcon.
     * @throws NullPointerException If the icon is null.
     */
    public DebuggingIcon(Icon icon, boolean debug, Color fg, Color bg, int x, int y){
        this(icon,debug,fg,bg,new Point(x,y));
    }
    /**
     * This constructs a DebuggingIcon to debug the given icon with the given 
     * foreground, background, and whether the debug elements are enabled. 
     * @param icon The icon to be debugged (cannot be null or a DebuggingIcon).
     * @param debug Whether the debug elements should be shown (if false, then 
     * the icon is rendered as is).
     * @param fg The foreground to render behind the icon (if null, then the 
     * debug elements rendered over the icon will invert the color of the icon).
     * @param bg The background to render behind the icon.
     * @throws IllegalArgumentException If the icon is a DebuggingIcon.
     * @throws NullPointerException If the icon is null.
     */
    public DebuggingIcon(Icon icon, boolean debug, Color fg, Color bg){
        this(icon,debug,fg,bg,null);
    }
    /**
     * This constructs a DebuggingIcon to debug the given icon with the given 
     * background, location, and whether the debug elements are enabled, along 
     * with a default inverted foreground.
     * @param icon The icon to be debugged (cannot be null or a DebuggingIcon).
     * @param debug Whether the debug elements should be shown (if false, then 
     * the icon is rendered as is).
     * @param bg The background to render behind the icon.
     * @param point The location to give to the icon when rendering it, or null.
     * @throws IllegalArgumentException If the icon is a DebuggingIcon.
     * @throws NullPointerException If the icon is null.
     */
    public DebuggingIcon(Icon icon, boolean debug, Color bg, Point point){
        this(icon,debug,null,bg,point);
    }
    /**
     * This constructs a DebuggingIcon to debug the given icon with the given 
     * background, location, and whether the debug elements are enabled, along 
     * with a default inverted foreground.
     * @param icon The icon to be debugged (cannot be null or a DebuggingIcon).
     * @param debug Whether the debug elements should be shown (if false, then 
     * the icon is rendered as is).
     * @param bg The background to render behind the icon.
     * @param x The x-coordinate of the location to give to the icon when 
     * rendering it.
     * @param y The y-coordinate of the location to give to the icon when 
     * rendering it.
     * @throws IllegalArgumentException If the icon is a DebuggingIcon.
     * @throws NullPointerException If the icon is null.
     */
    public DebuggingIcon(Icon icon, boolean debug, Color bg, int x, int y){
        this(icon,debug,bg,new Point(x,y));
    }
    /**
     * This constructs a DebuggingIcon to debug the given icon with the given 
     * background and whether the debug elements are enabled, along with a 
     * default inverted foreground.
     * @param icon The icon to be debugged (cannot be null or a DebuggingIcon).
     * @param debug Whether the debug elements should be shown (if false, then 
     * the icon is rendered as is).
     * @param bg The background to render behind the icon.
     * @throws IllegalArgumentException If the icon is a DebuggingIcon.
     * @throws NullPointerException If the icon is null.
     */
    public DebuggingIcon(Icon icon, boolean debug, Color bg){
        this(icon,debug,bg,(Point)null);
    }
    /**
     * This constructs a DebuggingIcon to debug the given icon with the given 
     * location and value determining whether the debug elements are enabled, 
     * along with a default inverted foreground and green background.
     * @param icon The icon to be debugged (cannot be null or a DebuggingIcon).
     * @param debug Whether the debug elements should be shown (if false, then 
     * the icon is rendered as is).
     * @param point The location to give to the icon when rendering it, or null.
     * @throws IllegalArgumentException If the icon is a DebuggingIcon.
     * @throws NullPointerException If the icon is null.
     */
    public DebuggingIcon(Icon icon, boolean debug, Point point){
        this(icon,debug,Color.GREEN,point);
    }
    /**
     * This constructs a DebuggingIcon to debug the given icon with the given 
     * location and value determining whether the debug elements are enabled, 
     * along with a default inverted foreground and green background.
     * @param icon The icon to be debugged (cannot be null or a DebuggingIcon).
     * @param debug Whether the debug elements should be shown (if false, then 
     * the icon is rendered as is).
     * @param x The x-coordinate of the location to give to the icon when 
     * rendering it.
     * @param y The y-coordinate of the location to give to the icon when 
     * rendering it.
     * @throws IllegalArgumentException If the icon is a DebuggingIcon.
     * @throws NullPointerException If the icon is null.
     */
    public DebuggingIcon(Icon icon, boolean debug, int x, int y){
        this(icon,debug,new Point(x,y));
    }
    /**
     * This constructs a DebuggingIcon to debug the given icon with the given 
     * value determining whether the debug elements are enabled, along with a 
     * default inverted foreground and green background.
     * @param icon The icon to be debugged (cannot be null or a DebuggingIcon).
     * @param debug Whether the debug elements should be shown (if false, then 
     * the icon is rendered as is).
     * @throws IllegalArgumentException If the icon is a DebuggingIcon.
     * @throws NullPointerException If the icon is null.
     */
    public DebuggingIcon(Icon icon, boolean debug){
        this(icon,debug,(Point)null);
    }
    /**
     * This constructs a DebuggingIcon to debug the given icon with the given 
     * foreground, background, and location. The debug elements will be enabled 
     * and shown by default.
     * @param icon The icon to be debugged (cannot be null or a DebuggingIcon).
     * @param fg The foreground to render behind the icon (if null, then the 
     * debug elements rendered over the icon will invert the color of the icon).
     * @param bg The background to render behind the icon.
     * @param point The location to give to the icon when rendering it, or null.
     * @throws IllegalArgumentException If the icon is a DebuggingIcon.
     * @throws NullPointerException If the icon is null.
     */
    public DebuggingIcon(Icon icon, Color bg, Color fg, Point point){
        this(icon,true,fg,bg,point);
    }
    /**
     * This constructs a DebuggingIcon to debug the given icon with the given 
     * foreground, background, and location. The debug elements will be enabled 
     * and shown by default.
     * @param icon The icon to be debugged (cannot be null or a DebuggingIcon).
     * @param fg The foreground to render behind the icon (if null, then the 
     * debug elements rendered over the icon will invert the color of the icon).
     * @param bg The background to render behind the icon.
     * @param x The x-coordinate of the location to give to the icon when 
     * rendering it.
     * @param y The y-coordinate of the location to give to the icon when 
     * rendering it.
     * @throws IllegalArgumentException If the icon is a DebuggingIcon.
     * @throws NullPointerException If the icon is null.
     */
    public DebuggingIcon(Icon icon, Color bg, Color fg, int x, int y){
        this(icon,true,fg,bg,x,y);
    }
    /**
     * This constructs a DebuggingIcon to debug the given icon with the given 
     * foreground and background. The debug elements will be enabled and shown 
     * by default.
     * @param icon The icon to be debugged (cannot be null or a DebuggingIcon).
     * @param fg The foreground to render behind the icon (if null, then the 
     * debug elements rendered over the icon will invert the color of the icon).
     * @param bg The background to render behind the icon.
     * @throws IllegalArgumentException If the icon is a DebuggingIcon.
     * @throws NullPointerException If the icon is null.
     */
    public DebuggingIcon(Icon icon, Color bg, Color fg){
        this(icon,true,fg,bg);
    }
    /**
     * This constructs a DebuggingIcon to debug the given icon with the given 
     * background and location, along with a default inverted foreground. The 
     * debug elements will be enabled and shown by default.
     * @param icon The icon to be debugged (cannot be null or a DebuggingIcon).
     * @param bg The background to render behind the icon.
     * @param point The location to give to the icon when rendering it, or null.
     * @throws IllegalArgumentException If the icon is a DebuggingIcon.
     * @throws NullPointerException If the icon is null.
     */
    public DebuggingIcon(Icon icon, Color bg, Point point){
        this(icon,true,bg,point);
    }
    /**
     * This constructs a DebuggingIcon to debug the given icon with the given 
     * background and location, along with a default inverted foreground. The 
     * debug elements will be enabled and shown by default.
     * @param icon The icon to be debugged (cannot be null or a DebuggingIcon).
     * @param bg The background to render behind the icon.
     * @param x The x-coordinate of the location to give to the icon when 
     * rendering it.
     * @param y The y-coordinate of the location to give to the icon when 
     * rendering it.
     * @throws IllegalArgumentException If the icon is a DebuggingIcon.
     * @throws NullPointerException If the icon is null.
     */
    public DebuggingIcon(Icon icon, Color bg, int x, int y){
        this(icon,true,bg,x,y);
    }
    /**
     * This constructs a DebuggingIcon to debug the given icon with the given 
     * background, along with a default inverted foreground. The debug elements 
     * will be enabled and shown by default.
     * @param icon The icon to be debugged (cannot be null or a DebuggingIcon).
     * @param bg The background to render behind the icon.
     * @throws IllegalArgumentException If the icon is a DebuggingIcon.
     * @throws NullPointerException If the icon is null.
     */
    public DebuggingIcon(Icon icon, Color bg){
        this(icon,true,bg);
    }
    /**
     * This constructs a DebuggingIcon to debug the given icon with the given 
     * location and a default inverted foreground and green background. The 
     * debug elements will be enabled and shown by default.
     * @param icon The icon to be debugged (cannot be null or a DebuggingIcon).
     * @param point The location to give to the icon when rendering it, or null.
     * @throws IllegalArgumentException If the icon is a DebuggingIcon.
     * @throws NullPointerException If the icon is null.
     */
    public DebuggingIcon(Icon icon, Point point){
        this(icon,true,point);
    }
    /**
     * This constructs a DebuggingIcon to debug the given icon with the given 
     * location and a default inverted foreground and green background. The 
     * debug elements will be enabled and shown by default.
     * @param icon The icon to be debugged (cannot be null or a DebuggingIcon).
     * @param x The x-coordinate of the location to give to the icon when 
     * rendering it.
     * @param y The y-coordinate of the location to give to the icon when 
     * rendering it.
     * @throws IllegalArgumentException If the icon is a DebuggingIcon.
     * @throws NullPointerException If the icon is null.
     */
    public DebuggingIcon(Icon icon, int x, int y){
        this(icon,true,x,y);
    }
    /**
     * This constructs a DebuggingIcon to debug the given icon with a default 
     * inverted foreground and green background. The debug elements will be 
     * enabled and shown by default.
     * @param icon The icon to be debugged (cannot be null or a DebuggingIcon).
     * @throws IllegalArgumentException If the icon is a DebuggingIcon.
     * @throws NullPointerException If the icon is null.
     */
    public DebuggingIcon(Icon icon){
        this(icon,true);
    }
    /**
     * This returns the icon being debugged.
     * @return The icon being debugged.
     */
    @Override
    public Icon getIcon(){
        return icon;
    }
    /**
     * This draws the {@link #getIcon() icon being debugged} at the specified 
     * location. If the debug elements are {@link #isDebugEnabled() enabled}, 
     * then a {@link #getDebugBackground() background} will be drawn behind the 
     * icon if set and a bounding box and crosshair will be drawn over the icon. 
     * If no {@link #getDebugForeground() foreground} has been set, then the 
     * bounding box and crosshair will be drawn in an inverted color to the rest 
     * of the icon. If a {@link #getDebugLocation() debug location} for the icon 
     * has been specified, then the icon will be told that it is to render at 
     * that location, when it is actually rendering at the location specified by 
     * the given x and y coordinates.
     * @param c {@inheritDoc }
     * @param g {@inheritDoc }
     * @param x {@inheritDoc }
     * @param y {@inheritDoc }
     * @see #getIcon() 
     * @see #getDebugBackground() 
     * @see #getDebugForeground() 
     * @see #isDebugEnabled() 
     * @see #getDebugX() 
     * @see #getDebugY() 
     * @see #getDebugLocation() 
     */
    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        int width = getIconWidth();     // Get the icon width
        int height = getIconHeight();   // Get the icon height
        if (width <= 0 || height <= 0)  // If nothing is actually being drawn
            return;
            // Get a copy of the graphics context
        Graphics graphics = g.create();
            // If the debug elements are enabled and a background color is set
        if (isDebugEnabled() && getDebugBackground() != null){
            graphics.clipRect(x, y, width, height);
            graphics.setColor(getDebugBackground());
            graphics.drawRect(x, y, width-1, height-1);
            graphics.fillRect(x, y, width-1, height-1);
            graphics.dispose();
            graphics = g.create();
        }   // This is the x-coordinate for the icon being debugged. If a point 
            // has been specified, then it will use the point's x. Otherwise, 
        int iconX = (point != null) ? point.x : x;  // use the given x
            // This is the y-coordinate for the icon being debugged. If a point 
            // has been specified, then it will use the point's y. Otherwise, 
        int iconY = (point != null) ? point.y : y;  // use the given y
        graphics.translate(x-iconX, y-iconY);
        getIcon().paintIcon(c, graphics, iconX, iconY);
        if (isDebugEnabled()){  // If the debug elements are enabled
            graphics.dispose();
            graphics = g.create(/*x,y,width,height*/);
            graphics.setPaintMode();
            int halfWidth = width / 2;                  // This gets half the width
            int halfHeight = height / 2;                // This gets half the height
            int widthParity = width % 2;                // This gets the parity of the width
            int heightParity = height % 2;              // This gets the parity of the height
            int rectWidth = halfWidth-2+widthParity;    // This gets the width for the 4 rectangles
            int rectHeight = halfHeight-2+heightParity; // This gets the height for the 4 rectangles
            if (getDebugForeground() != null){          // If a foreground color is set
                graphics.setColor(getDebugForeground());
            }
            else{   // This should result in the colors getting inverted
                graphics.setColor(Color.BLACK);
                graphics.setXORMode(Color.WHITE);
            }   // If the graphics context is a Graphics2D object
                // (Graphics2D contexts can have a scale applied which may cause gaps)
            if (graphics instanceof Graphics2D){
                    // An area to use to fill in the overlay
                Area area = new Area(new java.awt.Rectangle(x,y,width,height));
                    // A for loop to remove rectangles from the overlay, so as 
                    // to produce an outline and a crosshair
                for (int i = 0; i < 4; i++){
                    area.subtract(new Area(new Rectangle(
                            x+1+(halfWidth*(i%2)),
                            y+1+(halfHeight*(i>>1)),
                            rectWidth,rectHeight)));
                }
                ((Graphics2D)graphics).fill(area);
            }
            else{
                graphics.drawRect(x, y, width-1, height-1);
                graphics.fillRect(x+rectWidth+1, y+1, 2-widthParity, height-2);
                    // This draws the horizontal lines in a way to avoid them 
                for (int i = 0; i < 2; i++){    // overlapping with the vertical line
                    graphics.fillRect(x+1+(halfWidth*i), y+rectHeight+1, 
                            rectWidth, 2-heightParity);
                }
            }
        }
        graphics.dispose();
    }
    /**
     * This returns the background color to fill in the area behind the {@link 
     * #getIcon() icon} when the debug elements are {@link #isDebugEnabled() 
     * enabled}. 
     * @return The background for the debug icon, or null if no background is 
     * set.
     * @see #setDebugBackground(java.awt.Color) 
     * @see #getDebugForeground() 
     * @see #isDebugEnabled() 
     * @see #paintIcon(java.awt.Component, java.awt.Graphics, int, int) 
     */
    public Color getDebugBackground(){
        return bg;
    }
    /**
     * This sets the background color to use to fill in the area behind the 
     * {@link #getIcon() icon} when the debug elements are {@link 
     * #isDebugEnabled() enabled}. 
     * @param color The background for the debug icon, or null for no 
     * background.
     * @return This DebuggingIcon.
     * @see #getDebugBackground() 
     * @see #setDebugForeground(java.awt.Color) 
     * @see #isDebugEnabled() 
     * @see #setDebugEnabled(boolean) 
     * @see #paintIcon(java.awt.Component, java.awt.Graphics, int, int) 
     */
    public DebuggingIcon setDebugBackground(Color color){
        bg = color;
        return this;
    }
    /**
     * This returns the foreground color to use to draw the debug elements over 
     * the {@link #getIcon() icon} when the debug elements are {@link 
     * #isDebugEnabled() enabled}. If this is null, then the debug elements will 
     * invert the colors they are rendered over.
     * @return The foreground color for the debug icon, or null if the 
     * foreground inverts the colors.
     * @see #setDebugForeground(java.awt.Color) 
     * @see #getDebugBackground() 
     * @see #isDebugEnabled() 
     * @see #paintIcon(java.awt.Component, java.awt.Graphics, int, int) 
     */
    public Color getDebugForeground(){
        return fg;
    }
    /**
     * This sets the foreground color to use to draw the debug elements the 
     * {@link #getIcon() icon} when the debug elements are {@link 
     * #isDebugEnabled() enabled}. If this is set to null, then the debug 
     * elements will invert the colors they are rendered over.
     * @param color The foreground color for the debug icon, or null.
     * @return This DebuggingIcon.
     * @see #getDebugForeground() 
     * @see #setDebugBackground(java.awt.Color) 
     * @see #isDebugEnabled() 
     * @see #setDebugEnabled(boolean) 
     * @see #paintIcon(java.awt.Component, java.awt.Graphics, int, int) 
     */
    public DebuggingIcon setDebugForeground(Color color){
        fg = color;
        return this;
    }
    /**
     * This returns whether the debug elements are enabled and drawn. If this 
     * returns false, then the {@link #getIcon() icon being debugged} is drawn 
     * as is. 
     * @return Whether the debug elements are enabled.
     * @see #setDebugEnabled(boolean) 
     * @see #getIcon() 
     * @see #paintIcon(java.awt.Component, java.awt.Graphics, int, int) 
     */
    public boolean isDebugEnabled(){
        return debugEnabled;
    }
    /**
     * This sets whether the debug elements are enabled and drawn. When this is 
     * false, then the {@link #getIcon() icon being debugged} is drawn as is. 
     * @param enabled Whether the debug elements should be enabled.
     * @return This DebuggingIcon.
     * @see #isDebugEnabled() 
     * @see #getIcon() 
     * @see #paintIcon(java.awt.Component, java.awt.Graphics, int, int) 
     */
    public DebuggingIcon setDebugEnabled(boolean enabled){
        debugEnabled = enabled;
        return this;
    }
    /**
     * This returns the currently set x-coordinate to give to the {@link 
     * #getIcon() icon being debugged} when it is being rendered. This is 
     * separate from the location that the icon is actually drawn at, as the 
     * icon is still rendered at the top-left corner of this icon as given by 
     * the {@link #paintIcon(java.awt.Component, java.awt.Graphics, int, int) 
     * paintIcon method}. If this is null, then the icon is given the 
     * x-coordinate of this icon's top-left corner when being drawn.
     * @return The x-coordinate for the debug icon, or null if the icon is given 
     * the x-coordinate provided to this icon.
     * @see #getDebugY() 
     * @see #getDebugLocation() 
     * @see #setDebugLocation(int, int) 
     * @see #setDebugLocation(java.awt.Point) 
     * @see #getIcon() 
     * @see #paintIcon(java.awt.Component, java.awt.Graphics, int, int) 
     */
    public Integer getDebugX(){
            // If a point is set, return its x-coordinate. Otherwise, return 
        return (point != null) ? point.x : null;    // null.
    }
    /**
     * This returns the currently set y-coordinate to give to the {@link 
     * #getIcon() icon being debugged} when it is being rendered. This is 
     * separate from the location that the icon is actually drawn at, as the 
     * icon is still rendered at the top-left corner of this icon as given by 
     * the {@link #paintIcon(java.awt.Component, java.awt.Graphics, int, int) 
     * paintIcon method}. If this is null, then the icon is given the 
     * y-coordinate of this icon's top-left corner when being drawn.
     * @return The y-coordinate for the debug icon, or null if the icon is given 
     * the y-coordinate provided to this icon.
     * @see #getDebugX() 
     * @see #getDebugLocation() 
     * @see #setDebugLocation(int, int) 
     * @see #setDebugLocation(java.awt.Point) 
     * @see #getIcon() 
     * @see #paintIcon(java.awt.Component, java.awt.Graphics, int, int) 
     */
    public Integer getDebugY(){
            // If a point is set, return its y-coordinate. Otherwise, return 
        return (point != null) ? point.y : null;    // null.
    }
    /**
     * This returns the currently set location to give to the {@link #getIcon() 
     * icon being debugged} when it is being rendered. This is separate from the 
     * location that the icon is actually drawn at, as the icon is still 
     * rendered at the top-left corner of this icon as given by the {@link 
     * #paintIcon(java.awt.Component, java.awt.Graphics, int, int) paintIcon 
     * method}. If this is null, then the icon is given the location that this 
     * icon is being rendered.
     * @return The location to give to the debug icon, or null if the icon is 
     * given the location provided to this icon.
     * @see #getDebugX() 
     * @see #getDebugY() 
     * @see #setDebugLocation(int, int) 
     * @see #setDebugLocation(java.awt.Point) 
     * @see #getIcon() 
     * @see #paintIcon(java.awt.Component, java.awt.Graphics, int, int) 
     */
    public Point getDebugLocation(){
            // If a point is set, return a copy of it. Otherwise, return null.
        return (point != null) ? point.getLocation() : null;
    }
    /**
     * This sets the location to give to the {@link #getIcon() icon being 
     * debugged} when it is being rendered. This is separate from the location 
     * that the icon is actually drawn at, as the icon is still rendered at the 
     * top-left corner of this icon as given by the {@link 
     * #paintIcon(java.awt.Component, java.awt.Graphics, int, int) paintIcon 
     * method}. 
     * @param x The x-coordinate of the location to give to the icon when 
     * rendering it.
     * @param y The y-coordinate of the location to give to the icon when 
     * rendering it.
     * @return This DebuggingIcon.
     * @see #getDebugX() 
     * @see #getDebugY() 
     * @see #getDebugLocation() 
     * @see #setDebugLocation(java.awt.Point) 
     * @see #getIcon() 
     * @see #paintIcon(java.awt.Component, java.awt.Graphics, int, int) 
     */
    public DebuggingIcon setDebugLocation(int x, int y){
        if (point == null)      // If the point is currently null
            point = new Point(x,y);
        else
            point.setLocation(x, y);
        return this;
    }
    /**
     * This sets the location to give to the {@link #getIcon() icon being 
     * debugged} when it is being rendered. This is separate from the location 
     * that the icon is actually drawn at, as the icon is still rendered at the 
     * top-left corner of this icon as given by the {@link 
     * #paintIcon(java.awt.Component, java.awt.Graphics, int, int) paintIcon 
     * method}. If this is set to null, then the icon is given the location that 
     * this icon is being rendered.
     * @param point The location to give to the icon when rendering it, or null 
     * to give the icon the location that this icon is rendered at.
     * @return This DebuggingIcon.
     * @see #getDebugX() 
     * @see #getDebugY() 
     * @see #getDebugLocation() 
     * @see #setDebugLocation(int, int) 
     * @see #getIcon() 
     * @see #paintIcon(java.awt.Component, java.awt.Graphics, int, int) 
     */
    public DebuggingIcon setDebugLocation(Point point){
        if (point == null)  // If the new point is null
            this.point = null;
        else
            setDebugLocation(point.x,point.y);
        return this;
    }
    /**
     * This turns this icon into an image of the given width and height. This 
     * effectively calls {@link 
     * #paintIcon(java.awt.Component, java.awt.Graphics, int, int) paintIcon} 
     * with the given {@code Component}, x, and y, along with the graphics 
     * context from a BufferedImage after creating it. The {@code debug} 
     * value determines whether the debug elements will be enabled for this 
     * image only, and overrides {@link #isDebugEnabled() isDebugEnabled}. The 
     * {@code bg} value is used as the background color for the image if 
     * non-null.
     * @param c A {@code Component} to get useful properties for painting.
     * @param debug Whether the debug elements will be enabled (this overrides 
     * {@link #isDebugEnabled() isDebugEnabled}).
     * @param bg The background color for the image, or null if the image will 
     * not have a background.
     * @param x The x-coordinate on the image for the icon's top-left corner.
     * @param y The y-coordinate on the image for the icon's top-left corner.
     * @param w The width for the image (cannot be less than or equal to zero).
     * @param h The height for the image (cannot be less than or equal to zero).
     * @return A BufferedImage with this icon rendered on it.
     * @throws IllegalArgumentException If the width or height are less than or 
     * equal to zero.
     * @see #paintIcon
     * @see #getIcon() 
     * @see #getIconWidth() 
     * @see #getIconHeight() 
     * @see #isDebugEnabled() 
     * @see #setDebugEnabled(boolean) 
     * @see #toImage(java.awt.Component, boolean, java.awt.Color, int, int)
     * @see #toImage(java.awt.Component, boolean, java.awt.Color)
     * @see #toImage(java.awt.Component, boolean, int, int, int, int)
     * @see #toImage(java.awt.Component, boolean, int, int)
     * @see #toImage(java.awt.Component, boolean)
     * @see #toImage(java.awt.Component, java.awt.Color, int, int, int, int)
     * @see #toImage(java.awt.Component, java.awt.Color, int, int)
     * @see #toImage(java.awt.Component, java.awt.Color)
     * @see #toImage(java.awt.Component, int, int, int, int)
     * @see #toImage(java.awt.Component, int, int)
     * @see #toImage(java.awt.Component)
     */
    public BufferedImage toImage(Component c, boolean debug, Color bg, int x, 
            int y, int w, int h){
        if (w <= 0)         // If the width is less than or equal to zero
            throw new IllegalArgumentException("Width must be greater than zero: (" + w + " <= 0)");
        else if (h <= 0)    // If the height is less than or equal to zero
            throw new IllegalArgumentException("Height must be greater than zero: (" + h + " <= 0)");
            // Create the image to render to
        BufferedImage image = new BufferedImage(w,h,BufferedImage.TYPE_INT_ARGB);
            // Create the graphics context from the image
        Graphics2D g = image.createGraphics();
        if (bg != null){    // If a background color was given
            g.setColor(bg);
            g.fillRect(0, 0, image.getWidth(), image.getHeight());
            g.setBackground(bg);
        }
        if (c != null){     // If a component was provided, set up the graphics
            g.setFont(c.getFont());
            g.setColor(c.getForeground());
        }
        else
            g.setColor(Color.BLACK);
            // Temporarily store whether the debug elements are set to be enabled
        boolean tempDebug = isDebugEnabled();
        setDebugEnabled(debug).paintIcon(c, g, x, y);
        setDebugEnabled(tempDebug);
        g.dispose();
        return image;
    }
    /**
     * This turns this icon into an image of the icon's {@link #getIconWidth() 
     * width} and {@link #getIconHeight() height}, grown by the given horizontal 
     * and vertical expansion. This effectively creates a BufferedImage of size 
     * {@code (getIconWidth() + (2 * h))} by {@code (getIconHeight() + (2 * 
     * v))}, and then calls {@link 
     * #paintIcon(java.awt.Component, java.awt.Graphics, int, int) paintIcon} 
     * with the given {@code Component}, and using the {@code h} and {@code v} 
     * values as the x and y coordinates, respectively, along with giving it 
     * the graphics context from the previously created BufferedImage. This is 
     * equivalent to calling {@link 
     * #toImage(java.awt.Component, boolean, java.awt.Color, int, int, int, int) 
     * toImage}{@code (c, debug, bg, getIconWidth()+(2*h), 
     * getIconHeight()+(2*v))}. The {@code debug} value determines whether the 
     * debug elements will be enabled for this image only, and overrides {@link 
     * #isDebugEnabled() isDebugEnabled}. The {@code bg} value is used as the 
     * background color for the image if non-null.
     * @param c A {@code Component} to get useful properties for painting.
     * @param debug Whether the debug elements will be enabled (this overrides 
     * {@link #isDebugEnabled() isDebugEnabled}).
     * @param bg The background color for the image, or null if the image will 
     * not have a background.
     * @param h The horizontal expansion and x-coordinate on the image for the 
     * icon's top-left corner (cannot be less than or equal to half the width of 
     * the icon).
     * @param v The vertical expansion and y-coordinate on the image for the 
     * icon's top-left corner (cannot be less than or equal to half the height 
     * of the icon).
     * @return A BufferedImage with this icon rendered on it, or null if the 
     * icon's width or height are less than or equal to zero.
     * @throws IllegalArgumentException If the horizontal or vertical expansion 
     * are less than or equal to half the icon's width or height, respectively.
     * @see #paintIcon
     * @see #getIcon() 
     * @see #getIconWidth() 
     * @see #getIconHeight() 
     * @see #isDebugEnabled() 
     * @see #setDebugEnabled(boolean) 
     * @see #toImage(java.awt.Component, boolean, java.awt.Color, int, int, int, int)
     * @see #toImage(java.awt.Component, boolean, java.awt.Color, int, int)
     * @see #toImage(java.awt.Component, boolean, java.awt.Color)
     * @see #toImage(java.awt.Component, boolean, int, int, int, int)
     * @see #toImage(java.awt.Component, boolean, int, int)
     * @see #toImage(java.awt.Component, boolean)
     * @see #toImage(java.awt.Component, java.awt.Color, int, int, int, int)
     * @see #toImage(java.awt.Component, java.awt.Color, int, int)
     * @see #toImage(java.awt.Component, java.awt.Color)
     * @see #toImage(java.awt.Component, int, int, int, int)
     * @see #toImage(java.awt.Component, int, int)
     * @see #toImage(java.awt.Component)
     */
    public BufferedImage toImage(Component c, boolean debug, Color bg, int h, int v){
        int width = getIconWidth();     // Get the icon's width
        int height = getIconHeight();   // Get the icon's height
        if (width <= 0 || height <= 0)  // If the icon would not draw anything
            return null;
        width += (2*h);
        height += (2*v);
        if (width <= 0)                 // If the width was shrunk too small
            throw new IllegalArgumentException("Horizontal expansion is too small (" + h + " <= -" + ((getIconWidth()+1)/2)+")");
        else if (height <= 0)           // If the height was shrunk too small
            throw new IllegalArgumentException("Vertical expansion is too small (" + v + " <= -" + ((getIconHeight()+1)/2)+")");
        return toImage(c,debug,bg,h,v,width,height);
    }
    /**
     * This turns this icon into an image of the icon's {@link #getIconWidth() 
     * width} and {@link #getIconHeight() height}. This effectively creates a 
     * BufferedImage that is the same size as this icon, and then calls {@link 
     * #paintIcon(java.awt.Component, java.awt.Graphics, int, int) paintIcon} 
     * with the given {@code Component} and an x and y of zero, along with 
     * giving it the graphics context from the previously created BufferedImage. 
     * This is equivalent to calling {@link 
     * #toImage(java.awt.Component, boolean, java.awt.Color, int, int) 
     * toImage}{@code (c, debug, bg, 0, 0)}. The {@code debug} value determines 
     * whether the debug elements will be enabled for this image only, and 
     * overrides {@link #isDebugEnabled() isDebugEnabled}. The {@code bg} value 
     * is used as the background color for the image if non-null.
     * @param c A {@code Component} to get useful properties for painting.
     * @param debug Whether the debug elements will be enabled (this overrides 
     * {@link #isDebugEnabled() isDebugEnabled}).
     * @param bg The background color for the image, or null if the image will 
     * not have a background.
     * @return A BufferedImage with this icon rendered on it, or null if the 
     * icon's width or height are less than or equal to zero.
     * @see #paintIcon
     * @see #getIcon() 
     * @see #getIconWidth() 
     * @see #getIconHeight() 
     * @see #isDebugEnabled() 
     * @see #setDebugEnabled(boolean) 
     * @see #toImage(java.awt.Component, boolean, java.awt.Color, int, int, int, int)
     * @see #toImage(java.awt.Component, boolean, java.awt.Color, int, int)
     * @see #toImage(java.awt.Component, boolean, int, int, int, int)
     * @see #toImage(java.awt.Component, boolean, int, int)
     * @see #toImage(java.awt.Component, boolean)
     * @see #toImage(java.awt.Component, java.awt.Color, int, int, int, int)
     * @see #toImage(java.awt.Component, java.awt.Color, int, int)
     * @see #toImage(java.awt.Component, java.awt.Color)
     * @see #toImage(java.awt.Component, int, int, int, int)
     * @see #toImage(java.awt.Component, int, int)
     * @see #toImage(java.awt.Component)
     */
    public BufferedImage toImage(Component c, boolean debug, Color bg){
        return toImage(c,debug,bg,0,0);
    }
    /**
     * This turns this icon into an image of the given width and height. This 
     * effectively calls {@link 
     * #paintIcon(java.awt.Component, java.awt.Graphics, int, int) paintIcon} 
     * with the given {@code Component}, x, and y, along with the graphics 
     * context from a BufferedImage after creating it. This is equivalent to 
     * calling {@link 
     * #toImage(java.awt.Component, boolean, java.awt.Color, int, int, int, int) 
     * toImage}{@code (c, debug, null, x, y, w, h)}. The {@code debug} value 
     * determines whether the debug elements will be enabled for this image 
     * only, and overrides {@link #isDebugEnabled() isDebugEnabled}.
     * @param c A {@code Component} to get useful properties for painting.
     * @param debug Whether the debug elements will be enabled (this overrides 
     * {@link #isDebugEnabled() isDebugEnabled}).
     * @param x The x-coordinate on the image for the icon's top-left corner.
     * @param y The y-coordinate on the image for the icon's top-left corner.
     * @param w The width for the image (cannot be less than or equal to zero).
     * @param h The height for the image (cannot be less than or equal to zero).
     * @return A BufferedImage with this icon rendered on it.
     * @throws IllegalArgumentException If the width or height are less than or 
     * equal to zero.
     * @see #paintIcon
     * @see #getIcon() 
     * @see #getIconWidth() 
     * @see #getIconHeight() 
     * @see #isDebugEnabled() 
     * @see #setDebugEnabled(boolean) 
     * @see #toImage(java.awt.Component, boolean, java.awt.Color, int, int, int, int)
     * @see #toImage(java.awt.Component, boolean, java.awt.Color, int, int)
     * @see #toImage(java.awt.Component, boolean, java.awt.Color)
     * @see #toImage(java.awt.Component, boolean, int, int)
     * @see #toImage(java.awt.Component, boolean)
     * @see #toImage(java.awt.Component, java.awt.Color, int, int, int, int)
     * @see #toImage(java.awt.Component, java.awt.Color, int, int)
     * @see #toImage(java.awt.Component, java.awt.Color)
     * @see #toImage(java.awt.Component, int, int, int, int)
     * @see #toImage(java.awt.Component, int, int)
     * @see #toImage(java.awt.Component)
     */
    public BufferedImage toImage(Component c, boolean debug, int x, int y, int w, int h){
        return toImage(c,debug,null,x,y,w,h);
    }
    /**
     * This turns this icon into an image of the icon's {@link #getIconWidth() 
     * width} and {@link #getIconHeight() height}, grown by the given horizontal 
     * and vertical expansion. This effectively creates a BufferedImage of size 
     * {@code (getIconWidth() + (2 * h))} by {@code (getIconHeight() + (2 * 
     * v))}, and then calls {@link 
     * #paintIcon(java.awt.Component, java.awt.Graphics, int, int) paintIcon} 
     * with the given {@code Component}, and using the {@code h} and {@code v} 
     * values as the x and y coordinates, respectively, along with giving it 
     * the graphics context from the previously created BufferedImage. This is 
     * equivalent to calling {@link 
     * #toImage(java.awt.Component, boolean, java.awt.Color, int, int) 
     * toImage}{@code (c, debug, null, h, v)}. The {@code debug} value 
     * determines whether the debug elements will be enabled for this image 
     * only, and overrides {@link #isDebugEnabled() isDebugEnabled}.
     * @param c A {@code Component} to get useful properties for painting.
     * @param debug Whether the debug elements will be enabled (this overrides 
     * {@link #isDebugEnabled() isDebugEnabled}).
     * @param h The horizontal expansion and x-coordinate on the image for the 
     * icon's top-left corner (cannot be less than or equal to half the width of 
     * the icon).
     * @param v The vertical expansion and y-coordinate on the image for the 
     * icon's top-left corner (cannot be less than or equal to half the height 
     * of the icon).
     * @return A BufferedImage with this icon rendered on it, or null if the 
     * icon's width or height are less than or equal to zero.
     * @throws IllegalArgumentException If the horizontal or vertical expansion 
     * are less than or equal to half the width or height, respectively.
     * @see #paintIcon
     * @see #getIcon() 
     * @see #getIconWidth() 
     * @see #getIconHeight() 
     * @see #isDebugEnabled() 
     * @see #setDebugEnabled(boolean) 
     * @see #toImage(java.awt.Component, boolean, java.awt.Color, int, int, int, int)
     * @see #toImage(java.awt.Component, boolean, java.awt.Color, int, int)
     * @see #toImage(java.awt.Component, boolean, java.awt.Color)
     * @see #toImage(java.awt.Component, boolean, int, int, int, int)
     * @see #toImage(java.awt.Component, boolean)
     * @see #toImage(java.awt.Component, java.awt.Color, int, int, int, int)
     * @see #toImage(java.awt.Component, java.awt.Color, int, int)
     * @see #toImage(java.awt.Component, java.awt.Color)
     * @see #toImage(java.awt.Component, int, int, int, int)
     * @see #toImage(java.awt.Component, int, int)
     * @see #toImage(java.awt.Component)
     */
    public BufferedImage toImage(Component c, boolean debug, int h, int v){
        return toImage(c,debug,null,h,v);
    }
    /**
     * This turns this icon into an image of the icon's {@link #getIconWidth() 
     * width} and {@link #getIconHeight() height}. This effectively creates a 
     * BufferedImage that is the same size as this icon, and then calls {@link 
     * #paintIcon(java.awt.Component, java.awt.Graphics, int, int) paintIcon} 
     * with the given {@code Component} and an x and y of zero, along with 
     * giving it the graphics context from the previously created BufferedImage. 
     * This is equivalent to calling {@link 
     * #toImage(java.awt.Component, boolean, java.awt.Color) toImage}{@code (c, 
     * debug, null)}. The {@code debug} value determines whether the debug 
     * elements will be enabled for this image only, and overrides {@link 
     * #isDebugEnabled() isDebugEnabled}.
     * @param c A {@code Component} to get useful properties for painting.
     * @param debug Whether the debug elements will be enabled (this overrides 
     * {@link #isDebugEnabled() isDebugEnabled}).
     * @return A BufferedImage with this icon rendered on it, or null if the 
     * icon's width or height are less than or equal to zero.
     * @see #paintIcon
     * @see #getIcon() 
     * @see #getIconWidth() 
     * @see #getIconHeight() 
     * @see #isDebugEnabled() 
     * @see #setDebugEnabled(boolean) 
     * @see #toImage(java.awt.Component, boolean, java.awt.Color, int, int, int, int)
     * @see #toImage(java.awt.Component, boolean, java.awt.Color, int, int)
     * @see #toImage(java.awt.Component, boolean, java.awt.Color)
     * @see #toImage(java.awt.Component, boolean, int, int, int, int)
     * @see #toImage(java.awt.Component, boolean, int, int)
     * @see #toImage(java.awt.Component, java.awt.Color, int, int, int, int)
     * @see #toImage(java.awt.Component, java.awt.Color, int, int)
     * @see #toImage(java.awt.Component, java.awt.Color)
     * @see #toImage(java.awt.Component, int, int, int, int)
     * @see #toImage(java.awt.Component, int, int)
     * @see #toImage(java.awt.Component)
     */
    public BufferedImage toImage(Component c, boolean debug){
        return toImage(c,debug,null);
    }
    /**
     * This turns this icon into an image of the given width and height. This 
     * effectively calls {@link 
     * #paintIcon(java.awt.Component, java.awt.Graphics, int, int) paintIcon} 
     * with the given {@code Component}, x, and y, along with the graphics 
     * context from a BufferedImage after creating it. This is equivalent to 
     * calling {@link 
     * #toImage(java.awt.Component, boolean, java.awt.Color, int, int, int, int) 
     * toImage}{@code (c,} {@link #isDebugEnabled() isDebugEnabled(),} {@code 
     * bg, x, y, w, h)}. The {@code bg} value is used as the background color 
     * for the image if non-null.
     * @param c A {@code Component} to get useful properties for painting.
     * @param bg The background color for the image, or null if the image will 
     * not have a background.
     * @param x The x-coordinate on the image for the icon's top-left corner.
     * @param y The y-coordinate on the image for the icon's top-left corner.
     * @param w The width for the image (cannot be less than or equal to zero).
     * @param h The height for the image (cannot be less than or equal to zero).
     * @return A BufferedImage with this icon rendered on it.
     * @throws IllegalArgumentException If the width or height are less than or 
     * equal to zero.
     * @see #paintIcon
     * @see #getIcon() 
     * @see #getIconWidth() 
     * @see #getIconHeight() 
     * @see #isDebugEnabled() 
     * @see #setDebugEnabled(boolean) 
     * @see #toImage(java.awt.Component, boolean, java.awt.Color, int, int, int, int)
     * @see #toImage(java.awt.Component, boolean, java.awt.Color, int, int)
     * @see #toImage(java.awt.Component, boolean, java.awt.Color)
     * @see #toImage(java.awt.Component, boolean, int, int, int, int)
     * @see #toImage(java.awt.Component, boolean, int, int)
     * @see #toImage(java.awt.Component, boolean)
     * @see #toImage(java.awt.Component, java.awt.Color, int, int)
     * @see #toImage(java.awt.Component, java.awt.Color)
     * @see #toImage(java.awt.Component, int, int, int, int)
     * @see #toImage(java.awt.Component, int, int)
     * @see #toImage(java.awt.Component)
     */
    public BufferedImage toImage(Component c, Color bg, int x, int y, int w, int h){
        return toImage(c,isDebugEnabled(),bg,x,y,w,h);
    }
    /**
     * This turns this icon into an image of the icon's {@link #getIconWidth() 
     * width} and {@link #getIconHeight() height}, grown by the given horizontal 
     * and vertical expansion. This effectively creates a BufferedImage of size 
     * {@code (getIconWidth() + (2 * h))} by {@code (getIconHeight() + (2 * 
     * v))}, and then calls {@link 
     * #paintIcon(java.awt.Component, java.awt.Graphics, int, int) paintIcon} 
     * with the given {@code Component}, and using the {@code h} and {@code v} 
     * values as the x and y coordinates, respectively, along with giving it 
     * the graphics context from the previously created BufferedImage. This is 
     * equivalent to calling {@link 
     * #toImage(java.awt.Component, boolean, java.awt.Color, int, int) 
     * toImage}{@code (c,} {@link #isDebugEnabled() isDebugEnabled(),} {@code 
     * bg, h, v)}. The {@code bg} value is used as the background color for the 
     * image if non-null.
     * @param c A {@code Component} to get useful properties for painting.
     * @param bg The background color for the image, or null if the image will 
     * not have a background.
     * @param h The horizontal expansion and x-coordinate on the image for the 
     * icon's top-left corner (cannot be less than or equal to half the width of 
     * the icon).
     * @param v The vertical expansion and y-coordinate on the image for the 
     * icon's top-left corner (cannot be less than or equal to half the height 
     * of the icon).
     * @return A BufferedImage with this icon rendered on it, or null if the 
     * icon's width or height are less than or equal to zero.
     * @throws IllegalArgumentException If the horizontal or vertical expansion 
     * are less than or equal to half the width or height, respectively.
     * @see #paintIcon
     * @see #getIcon() 
     * @see #getIconWidth() 
     * @see #getIconHeight() 
     * @see #isDebugEnabled() 
     * @see #setDebugEnabled(boolean) 
     * @see #toImage(java.awt.Component, boolean, java.awt.Color, int, int, int, int)
     * @see #toImage(java.awt.Component, boolean, java.awt.Color, int, int)
     * @see #toImage(java.awt.Component, boolean, java.awt.Color)
     * @see #toImage(java.awt.Component, boolean, int, int, int, int)
     * @see #toImage(java.awt.Component, boolean, int, int)
     * @see #toImage(java.awt.Component, boolean)
     * @see #toImage(java.awt.Component, java.awt.Color, int, int, int, int)
     * @see #toImage(java.awt.Component, java.awt.Color)
     * @see #toImage(java.awt.Component, int, int, int, int)
     * @see #toImage(java.awt.Component, int, int)
     * @see #toImage(java.awt.Component)
     */
    public BufferedImage toImage(Component c, Color bg, int h, int v){
        return toImage(c,isDebugEnabled(),bg,h,v);
    }
    /**
     * This turns this icon into an image of the icon's {@link #getIconWidth() 
     * width} and {@link #getIconHeight() height}. This effectively creates a 
     * BufferedImage that is the same size as this icon, and then calls {@link 
     * #paintIcon(java.awt.Component, java.awt.Graphics, int, int) paintIcon} 
     * with the given {@code Component} and an x and y of zero, along with 
     * giving it the graphics context from the previously created BufferedImage. 
     * This is equivalent to calling {@link 
     * #toImage(java.awt.Component, boolean, java.awt.Color) toImage}{@code (c,} 
     * {@link #isDebugEnabled() isDebugEnabled(),} {@code bg)}. The {@code bg} 
     * value is used as the background color for the image if non-null.
     * @param c A {@code Component} to get useful properties for painting.
     * @param bg The background color for the image, or null if the image will 
     * not have a background.
     * @return A BufferedImage with this icon rendered on it, or null if the 
     * icon's width or height are less than or equal to zero.
     * @see #paintIcon
     * @see #getIcon() 
     * @see #getIconWidth() 
     * @see #getIconHeight() 
     * @see #isDebugEnabled() 
     * @see #setDebugEnabled(boolean) 
     * @see #toImage(java.awt.Component, boolean, java.awt.Color, int, int, int, int)
     * @see #toImage(java.awt.Component, boolean, java.awt.Color, int, int)
     * @see #toImage(java.awt.Component, boolean, java.awt.Color)
     * @see #toImage(java.awt.Component, boolean, int, int, int, int)
     * @see #toImage(java.awt.Component, boolean, int, int)
     * @see #toImage(java.awt.Component, boolean)
     * @see #toImage(java.awt.Component, java.awt.Color, int, int, int, int)
     * @see #toImage(java.awt.Component, java.awt.Color, int, int)
     * @see #toImage(java.awt.Component, int, int, int, int)
     * @see #toImage(java.awt.Component, int, int)
     * @see #toImage(java.awt.Component)
     */
    public BufferedImage toImage(Component c, Color bg){
        return toImage(c,isDebugEnabled(),bg);
    }
    /**
     * This turns this icon into an image of the given width and height. This 
     * effectively calls {@link 
     * #paintIcon(java.awt.Component, java.awt.Graphics, int, int) paintIcon} 
     * with the given {@code Component}, x, and y, along with the graphics 
     * context from a BufferedImage after creating it. This is equivalent to 
     * calling {@link 
     * #toImage(java.awt.Component, boolean, java.awt.Color, int, int, int, int) 
     * toImage}{@code (c,} {@link #isDebugEnabled() isDebugEnabled(),} {@code 
     * null, x, y, w, h)}.
     * @param c A {@code Component} to get useful properties for painting.
     * @param x The x-coordinate on the image for the icon's top-left corner.
     * @param y The y-coordinate on the image for the icon's top-left corner.
     * @param w The width for the image (cannot be less than or equal to zero).
     * @param h The height for the image (cannot be less than or equal to zero).
     * @return A BufferedImage with this icon rendered on it.
     * @throws IllegalArgumentException If the width or height are less than or 
     * equal to zero.
     * @see #paintIcon
     * @see #getIcon() 
     * @see #getIconWidth() 
     * @see #getIconHeight() 
     * @see #isDebugEnabled() 
     * @see #setDebugEnabled(boolean) 
     * @see #toImage(java.awt.Component, boolean, java.awt.Color, int, int, int, int)
     * @see #toImage(java.awt.Component, boolean, java.awt.Color, int, int)
     * @see #toImage(java.awt.Component, boolean, java.awt.Color)
     * @see #toImage(java.awt.Component, boolean, int, int, int, int)
     * @see #toImage(java.awt.Component, boolean, int, int)
     * @see #toImage(java.awt.Component, boolean)
     * @see #toImage(java.awt.Component, java.awt.Color, int, int, int, int)
     * @see #toImage(java.awt.Component, java.awt.Color, int, int)
     * @see #toImage(java.awt.Component, java.awt.Color)
     * @see #toImage(java.awt.Component, int, int)
     * @see #toImage(java.awt.Component)
     */
    public BufferedImage toImage(Component c, int x, int y, int w, int h){
        return toImage(c,isDebugEnabled(),x,y,w,h);
    }
    /**
     * This turns this icon into an image of the icon's {@link #getIconWidth() 
     * width} and {@link #getIconHeight() height}, grown by the given horizontal 
     * and vertical expansion. This effectively creates a BufferedImage of size 
     * {@code (getIconWidth() + (2 * h))} by {@code (getIconHeight() + (2 * 
     * v))}, and then calls {@link 
     * #paintIcon(java.awt.Component, java.awt.Graphics, int, int) paintIcon} 
     * with the given {@code Component}, and using the {@code h} and {@code v} 
     * values as the x and y coordinates, respectively, along with giving it 
     * the graphics context from the previously created BufferedImage. This is 
     * equivalent to calling {@link 
     * #toImage(java.awt.Component, boolean, java.awt.Color, int, int) 
     * toImage}{@code (c,} {@link #isDebugEnabled() isDebugEnabled(),} {@code 
     * null, h, v)}.
     * @param c A {@code Component} to get useful properties for painting.
     * @param h The horizontal expansion and x-coordinate on the image for the 
     * icon's top-left corner (cannot be less than or equal to half the width of 
     * the icon).
     * @param v The vertical expansion and y-coordinate on the image for the 
     * icon's top-left corner (cannot be less than or equal to half the height 
     * of the icon).
     * @return A BufferedImage with this icon rendered on it, or null if the 
     * icon's width or height are less than or equal to zero.
     * @throws IllegalArgumentException If the horizontal or vertical expansion 
     * are less than or equal to half the width or height, respectively.
     * @see #paintIcon
     * @see #getIcon() 
     * @see #getIconWidth() 
     * @see #getIconHeight() 
     * @see #isDebugEnabled() 
     * @see #setDebugEnabled(boolean) 
     * @see #toImage(java.awt.Component, boolean, java.awt.Color, int, int, int, int)
     * @see #toImage(java.awt.Component, boolean, java.awt.Color, int, int)
     * @see #toImage(java.awt.Component, boolean, java.awt.Color)
     * @see #toImage(java.awt.Component, boolean, int, int, int, int)
     * @see #toImage(java.awt.Component, boolean, int, int)
     * @see #toImage(java.awt.Component, boolean)
     * @see #toImage(java.awt.Component, java.awt.Color, int, int, int, int)
     * @see #toImage(java.awt.Component, java.awt.Color, int, int)
     * @see #toImage(java.awt.Component, java.awt.Color)
     * @see #toImage(java.awt.Component, int, int, int, int)
     * @see #toImage(java.awt.Component)
     */
    public BufferedImage toImage(Component c, int h, int v){
        return toImage(c,isDebugEnabled(),h,v);
    }
    /**
     * This turns this icon into an image of the icon's {@link #getIconWidth() 
     * width} and {@link #getIconHeight() height}. This effectively creates a 
     * BufferedImage that is the same size as this icon, and then calls {@link 
     * #paintIcon(java.awt.Component, java.awt.Graphics, int, int) paintIcon} 
     * with the given {@code Component} and an x and y of zero, along with 
     * giving it the graphics context from the previously created BufferedImage. 
     * This is equivalent to calling {@link 
     * #toImage(java.awt.Component, boolean, java.awt.Color) toImage}{@code (c,} 
     * {@link #isDebugEnabled() isDebugEnabled(),} {@code null)}.
     * @param c A {@code Component} to get useful properties for painting.
     * @return A BufferedImage with this icon rendered on it, or null if the 
     * icon's width or height are less than or equal to zero.
     * @see #paintIcon
     * @see #getIcon() 
     * @see #getIconWidth() 
     * @see #getIconHeight() 
     * @see #isDebugEnabled() 
     * @see #setDebugEnabled(boolean) 
     * @see #toImage(java.awt.Component, boolean, java.awt.Color, int, int, int, int)
     * @see #toImage(java.awt.Component, boolean, java.awt.Color, int, int)
     * @see #toImage(java.awt.Component, boolean, java.awt.Color)
     * @see #toImage(java.awt.Component, boolean, int, int, int, int)
     * @see #toImage(java.awt.Component, boolean, int, int)
     * @see #toImage(java.awt.Component, boolean)
     * @see #toImage(java.awt.Component, java.awt.Color, int, int, int, int)
     * @see #toImage(java.awt.Component, java.awt.Color, int, int)
     * @see #toImage(java.awt.Component, java.awt.Color)
     * @see #toImage(java.awt.Component, int, int, int, int)
     * @see #toImage(java.awt.Component, int, int)
     */
    public BufferedImage toImage(Component c){
        return toImage(c,isDebugEnabled());
    }
    /**
     * This returns a String containing parameters for this DebuggingIcon.
     * @return A String with the parameters for this icon.
     */
    protected String paramString(){
            // If the point is not null, add it to the string
        return ((point != null) ? (point.x+","+point.y) : "") + 
                ","+getIconWidth()+"x"+getIconHeight() + 
                ",icon="+getIcon().toString();
    }
    @Override
    public String toString(){
        return getClass().getName()+"["+paramString()+"]";
    }
}
