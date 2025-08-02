/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package components;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.TextAttribute;
import java.io.IOException;
import java.net.*;
import java.util.HashMap;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

/**
 * This is a label that acts as a hyperlink to a website or resource. The user 
 * is able to click on this to open the website in their browser.
 * @author Mosblinker
 */
public class JHyperlinkLabel extends JLabel{
    /**
     * This is the default color used for hyperlinks that have not been visited 
     * yet.
     */
    public static final Color UNVISITED_HYPERLINK_COLOR = new Color(0x0000EE);
    /**
     * This is the default color used for hyperlinks that have been visited.
     */
    public static final Color VISITED_HYPERLINK_COLOR = new Color(0x551A8B);
    /**
     * This is the default color for a hyperlink that has been activated.
     */
    public static final Color ACTIVATED_HYPERLINK_COLOR = Color.RED;
    /**
     * This identifies that the URI for the hyperlink has changed.
     */
    public static final String URI_PROPERTY_CHANGED = "URIPropertyChanged";
    /**
     * This identifies that the color for an unvisited hyperlink has changed.
     */
    public static final String UNVISITED_HYPERLINK_COLOR_PROPERTY_CHANGED = 
            "UnvisitedColorPropertyChanged";
    /**
     * This identifies that the color for a visited hyperlink has changed.
     */
    public static final String VISITED_HYPERLINK_COLOR_PROPERTY_CHANGED = 
            "VisitedColorPropertyChanged";
    /**
     * This identifies that the color for a activated hyperlink has changed.
     */
    public static final String ACTIVATED_HYPERLINK_COLOR_PROPERTY_CHANGED = 
            "ActivatedColorPropertyChanged";
    /**
     * This identifies that a change has been made to whether the hyperlink has 
     * been visited.
     */
    public static final String HYPERLINK_VISITED_PROPERTY_CHANGED = 
            "HyperlinkVisitedPropertyChanged";
    /**
     * This identifies that a change has been made to wether failure message 
     * prompts will be shown for when the hyperlink fails to open.
     */
    public static final String FAILURE_MESSAGES_SHOWN_PROPERTY_CHANGED = 
            "FailureMessagesShownPropertyChanged";
    /**
     * This is the flag that indicates whether the hyperlink has been visited.
     */
    protected static final int HYPERLINK_VISITED_FLAG = 0x01;
    /**
     * This is the flag that indicates whether the hyperlink is currently 
     * activated.
     */
    protected static final int HYPERLINK_ACTIVATED_FLAG = 0x02;
    /**
     * This is the flag that indicates whether the hyperlink is being hovered 
     * over with the mouse.
     */
    protected static final int HYPERLINK_HOVERED_FLAG = 0x04;
    /**
     * This is the flag that indicates whether failure messages will be shown to 
     * the user when the hyperlink fails to open.
     */
    protected static final int SHOW_FAILURE_MESSAGES_FLAG = 0x08;
    /**
     * This is the URI for the hyperlink.
     */
    private URI uri = null;
    /**
     * This is the color to use for the foreground of a hyperlink that has not 
     * been visited yet.
     */
    private Color unvisitedColor = null;
    /**
     * This is the color to use for the foreground of a hyperlink that has been 
     * visited.
     */
    private Color visitedColor = null;
    /**
     * This is the color to use for the foreground when the hyperlink is being 
     * activated.
     */
    private Color activatedColor = null;
    /**
     * This is a bunch of flags that control the state of this label.
     */
    private int flags = SHOW_FAILURE_MESSAGES_FLAG;
    /**
     * This contains whether the label is currently being painted.
     */
    private volatile boolean isPainting = false;
    /**
     * This stores whether the cursor has actually been set for this label.
     */
    private boolean cursorIsSet = false;
    /**
     * This is the hand cursor to use for this label.
     */
    private Cursor handCursor = null;
    /**
     * This initializes this JHyperlinkLabel.
     * @param uri The URI of the hyperlink for this label.
     */
    private void initialize(URI uri){
        setURI(uri);
        addMouseListener(new Handler());
    }
    /**
     * This constructs a JHyperlinkLabel with the given text, icon, horizontal 
     * alignment, and {@code URI}. The label is centered vertically in its 
     * display area, and the text is on the trailing edge of the image.
     * @param text The text to be displayed by this label.
     * @param icon The icon to be displayed by this label.
     * @param horizontalAlignment The horizontal alignment for the contents of 
     * this label. This should be one of the following constants defined in 
     * {@code SwingConstants}: 
     *      {@code LEFT}, 
     *      {@code CENTER},
     *      {@code RIGHT},
     *      {@code LEADING}, or
     *      {@code TRAILING}.
     * @param uri The {@code URI} of the hyperlink that this label links to.
     */
    public JHyperlinkLabel(String text, Icon icon, int horizontalAlignment, 
            URI uri){
        super(text,icon,horizontalAlignment);
        initialize(uri);
    }
    /**
     * This constructs a JHyperlinkLabel with the given text, icon, and 
     * horizontal alignment. The label is centered vertically in its display 
     * area, and the text is on the trailing edge of the image.
     * @param text The text to be displayed by this label.
     * @param icon The icon to be displayed by this label.
     * @param horizontalAlignment The horizontal alignment for the contents of 
     * this label. This should be one of the following constants defined in 
     * {@code SwingConstants}: 
     *      {@code LEFT}, 
     *      {@code CENTER},
     *      {@code RIGHT},
     *      {@code LEADING}, or
     *      {@code TRAILING}.
     */
    public JHyperlinkLabel(String text, Icon icon, int horizontalAlignment){
        this(text,icon,horizontalAlignment,null);
    }
    /**
     * This constructs a JHyperlinkLabel with the given text, horizontal 
     * alignment, and {@code URI}. The label is centered vertically in its 
     * display area.
     * @param text The text to be displayed by this label.
     * @param horizontalAlignment The horizontal alignment for the contents of 
     * this label. This should be one of the following constants defined in 
     * {@code SwingConstants}: 
     *      {@code LEFT}, 
     *      {@code CENTER},
     *      {@code RIGHT},
     *      {@code LEADING}, or
     *      {@code TRAILING}.
     * @param uri The {@code URI} of the hyperlink that this label links to.
     */
    public JHyperlinkLabel(String text, int horizontalAlignment, URI uri){
        super(text,horizontalAlignment);
        initialize(uri);
    }
    /**
     * This constructs a JHyperlinkLabel with the given text, and horizontal 
     * alignment. The label is centered vertically in its display area.
     * @param text The text to be displayed by this label.
     * @param horizontalAlignment The horizontal alignment for the contents of 
     * this label. This should be one of the following constants defined in 
     * {@code SwingConstants}: 
     *      {@code LEFT}, 
     *      {@code CENTER},
     *      {@code RIGHT},
     *      {@code LEADING}, or
     *      {@code TRAILING}.
     */
    public JHyperlinkLabel(String text, int horizontalAlignment){
        this(text,horizontalAlignment,null);
    }
    /**
     * This constructs a JHyperlinkLabel with the given text and {@code URI}. 
     * The label is centered vertically and aligned against the leading edge of 
     * its display area.
     * @param text The text to be displayed by this label.
     * @param uri The {@code URI} of the hyperlink that this label links to.
     */
    public JHyperlinkLabel(String text, URI uri){
        super(text);
        initialize(uri);
    }
    /**
     * This constructs a JHyperlinkLabel with the given text. The label is 
     * centered vertically and aligned against the leading edge of its 
     * display area.
     * @param text The text to be displayed by this label.
     */
    public JHyperlinkLabel(String text){
        this(text,null);
    }
    /**
     * This constructs a JHyperlinkLabel with the given icon, horizontal 
     * alignment, and {@code URI}. The label is centered vertically in its 
     * display area.
     * @param icon The icon to be displayed by this label.
     * @param horizontalAlignment The horizontal alignment for the contents of 
     * this label. This should be one of the following constants defined in 
     * {@code SwingConstants}: 
     *      {@code LEFT}, 
     *      {@code CENTER},
     *      {@code RIGHT},
     *      {@code LEADING}, or
     *      {@code TRAILING}.
     * @param uri The {@code URI} of the hyperlink that this label links to.
     */
    public JHyperlinkLabel(Icon icon, int horizontalAlignment, URI uri){
        super(icon,horizontalAlignment);
        initialize(uri);
    }
    /**
     * This constructs a JHyperlinkLabel with the given icon, horizontal 
     * alignment. The label is centered vertically in its display area.
     * @param icon The icon to be displayed by this label.
     * @param horizontalAlignment The horizontal alignment for the contents of 
     * this label. This should be one of the following constants defined in 
     * {@code SwingConstants}: 
     *      {@code LEFT}, 
     *      {@code CENTER},
     *      {@code RIGHT},
     *      {@code LEADING}, or
     *      {@code TRAILING}.
     */
    public JHyperlinkLabel(Icon icon, int horizontalAlignment){
        this(icon,horizontalAlignment,null);
    }
    /**
     * This constructs a JHyperlinkLabel with the given icon and {@code URI}. 
     * The label is centered horizontally and vertically in its display area.
     * @param icon The icon to be displayed by this label.
     * @param uri The {@code URI} of the hyperlink that this label links to.
     */
    public JHyperlinkLabel(Icon icon, URI uri){
        super(icon);
        initialize(uri);
    }
    /**
     * This constructs a JHyperlinkLabel with the given icon. The label is 
     * centered horizontally and vertically in its display area.
     * @param icon The icon to be displayed by this label.
     */
    public JHyperlinkLabel(Icon icon){
        this(icon,null);
    }
    /**
     * This constructs a JHyperlinkLabel with the given {@code URI} for the 
     * hyperlink, and with no text or icon. The label is centered vertically and 
     * its contents will be aligned against the leading edge of its display area.
     * @param uri The {@code URI} of the hyperlink that this label links to.
     */
    public JHyperlinkLabel(URI uri){
        super();
        initialize(uri);
    }
    /**
     * This constructs a JHyperlinkLabel with no text or icon. The label is 
     * centered vertically and its contents will be aligned against the leading 
     * edge of its display area.
     */
    public JHyperlinkLabel(){
        super();
        initialize(null);
    }
    /**
     * This returns whether the given flag is set on the flags for this label.
     * @param flag The flag to check for.
     * @return Whether the given flag is set for this label.
     * @see #setFlag(int, boolean) 
     * @see #setFlag(int, boolean, java.lang.String) 
     * @see #HYPERLINK_VISITED_FLAG
     * @see #HYPERLINK_ACTIVATED_FLAG
     * @see #HYPERLINK_HOVERED_FLAG
     * @see #SHOW_FAILURE_MESSAGES_FLAG
     */
    protected boolean getFlag(int flag){
        return (flags & flag) == flag;
    }
    /**
     * This sets or clears the given flag for this label based off the given 
     * value.
     * @param flag The flag to set or clear.
     * @param value {@code true} if the flag should be set, {@code false} if the 
     * flag should be cleared.
     * @return Whether the flags changed as a result of this method.
     * @see #getFlag(int) 
     * @see #setFlag(int, boolean, java.lang.String) 
     * @see #HYPERLINK_VISITED_FLAG
     * @see #HYPERLINK_ACTIVATED_FLAG
     * @see #HYPERLINK_HOVERED_FLAG
     * @see #SHOW_FAILURE_MESSAGES_FLAG
     */
    protected boolean setFlag(int flag, boolean value){
            // Get the current value for the flags
        int old = flags;
            // If the given value is true, set the flag. Otherwise clear the 
        flags = (value) ? (flags | flag) : (flags & ~flag); // flag
        return old != flags;
    }
    /**
     * This sets or clears the given flag for this label based off the given 
     * value. This will also fire a property change with the given property 
     * name.
     * @param flag The flag to set or clear.
     * @param value {@code true} if the flag should be set, {@code false} if the 
     * flag should be cleared.
     * @param propName The property name of the property being changed.
     * @return Whether the flags changed as a result of this method.
     * @see #getFlag(int) 
     * @see #setFlag(int, boolean) 
     * @see #HYPERLINK_VISITED_FLAG
     * @see #HYPERLINK_ACTIVATED_FLAG
     * @see #HYPERLINK_HOVERED_FLAG
     * @see #SHOW_FAILURE_MESSAGES_FLAG
     */
    protected boolean setFlag(int flag, boolean value, String propName){
            // Set or clear the flag and get whether there was a change
        boolean change = setFlag(flag,value);
            // If the flag changed as a result
        if (change)
            firePropertyChange(propName,!value,value);
        return change;
    }
    /**
     * This returns whether the hyperlink has been visited yet.
     * @return Whether the hyperlink has been visited yet.
     * @see #setVisited(boolean) 
     * @see #getURI() 
     * @see #setURI(java.net.URI) 
     * @see #getUnvisitedHyperlinkColor() 
     * @see #setUnvisitedHyperlinkColor(java.awt.Color) 
     * @see #getVisitedHyperlinkColor() 
     * @see #setVisitedHyperlinkColor(java.awt.Color) 
     */
    public boolean isVisited(){
        return getFlag(HYPERLINK_VISITED_FLAG);
    }
    /**
     * This sets whether the hyperlink has been visited yet. The default for 
     * this value is {@code false}.
     * @param value Whether the hyperlink has been visited yet.
     * @see #isVisited() 
     * @see #getURI() 
     * @see #setURI(java.net.URI) 
     * @see #getUnvisitedHyperlinkColor() 
     * @see #setUnvisitedHyperlinkColor(java.awt.Color) 
     * @see #getVisitedHyperlinkColor() 
     * @see #setVisitedHyperlinkColor(java.awt.Color) 
     */
    public void setVisited(boolean value){
            // If the visited status of the hyperlink has changed
        if (setFlag(HYPERLINK_VISITED_FLAG,value,HYPERLINK_VISITED_PROPERTY_CHANGED))
            repaint();
    }
    /**
     * This returns whether this label is currently activated.
     * @return {@code true} if the label is currently activated, {@code false} 
     * otherwise.
     * @see #setActivated(boolean) 
     * @see #isHoveredOver() 
     * @see #setHoveredOver(boolean) 
     * @see #getActivatedHyperlinkColor() 
     * @see #setActivatedHyperlinkColor(java.awt.Color) 
     */
    protected boolean isActivated(){
        return getFlag(HYPERLINK_ACTIVATED_FLAG);
    }
    /**
     * This sets whether this label is currently activated.
     * @param value {@code true} if the label is currently activated, {@code 
     * false} otherwise.
     * @see #isActivated() 
     * @see #isHoveredOver() 
     * @see #setHoveredOver(boolean) 
     * @see #getActivatedHyperlinkColor() 
     * @see #setActivatedHyperlinkColor(java.awt.Color) 
     */
    protected void setActivated(boolean value){
            // If the hyperlink has been activated or unactivated
        if (setFlag(HYPERLINK_ACTIVATED_FLAG,value))
            repaint();
    }
    /**
     * This returns whether this label is currently being hovered over by the 
     * mouse.
     * @return {@code true} if this label is currently being hovered over, 
     * {@code false} otherwise.
     * @see #setHoveredOver(boolean) 
     * @see #isActivated() 
     * @see #setActivated(boolean) 
     */
    protected boolean isHoveredOver(){
        return getFlag(HYPERLINK_HOVERED_FLAG);
    }
    /**
     * This sets whether this label is currently being hovered over by the 
     * mouse.
     * @param value {@code true} if this label is currently being hovered over, 
     * {@code false} otherwise.
     * @see #isHoveredOver() 
     * @see #isActivated() 
     * @see #setActivated(boolean) 
     */
    protected void setHoveredOver(boolean value){
            // If the hyperlink is being hovered over
        if (setFlag(HYPERLINK_HOVERED_FLAG,value))
            repaint();
    }
    /**
     * This returns whether the user will be notified with a message dialog when 
     * the hyperlink fails to open.
     * @return {@code true} if a message dialog will be displayed if the 
     * hyperlink fails to open, {@code false} otherwise.
     * @see #setFailureMessagesAreShown(boolean) 
     * @see #openHyperlink() 
     */
    public boolean getFailureMessagesAreShown(){
        return getFlag(SHOW_FAILURE_MESSAGES_FLAG);
    }
    /**
     * This sets whether the user will be notified with a message dialog when 
     * the hyperlink fails to open. The default for this value is {@code true}.
     * @param value {@code true} if a message dialog will be displayed if the 
     * hyperlink fails to open, {@code false} otherwise.
     * @see #getFailureMessagesAreShown() 
     * @see #openHyperlink() 
     */
    public void setFailureMessagesAreShown(boolean value){
        setFlag(SHOW_FAILURE_MESSAGES_FLAG,value,
                FAILURE_MESSAGES_SHOWN_PROPERTY_CHANGED);
    }
    /**
     * This returns the {@code URI} for the hyperlink.
     * @return The {@code URI} for the hyperlink.
     * @see #setURI(java.net.URI) 
     * @see #isVisited() 
     * @see #setVisited(boolean) 
     */
    public URI getURI(){
        return uri;
    }
    /**
     * This sets the {@code URI} for the hyperlink. This will also make it so 
     * that the hyperlink is {@link #isVisited() unvisited}. The default for 
     * this value is null. 
     * @param uri The {@code URI} for the hyperlink, or null.
     * @see #getURI() 
     * @see #isVisited() 
     * @see #setVisited(boolean) 
     */
    public void setURI(URI uri){
            // If the new URI is different from the old URI
        if (!Objects.equals(this.uri, uri)){
                // Get the old URI
            URI old = this.uri;
                // Set the URI
            this.uri = uri;
            firePropertyChange(URI_PROPERTY_CHANGED,old,uri);
                // If the old URI is null and the new URI is not null or 
                // if the old URI is not null and the new URI is null
            if (old == null && uri != null || old != null && uri == null){
                repaint();
                    // Update the cursor
                updateDefaultCursor();
            }
                // If the tool tip is not set for this label
            if (!isToolTipTextSet()){
                    // Get the shared instance of the tool tip manager
                ToolTipManager toolTipManager = ToolTipManager.sharedInstance();
                    // If the new URI is not null
                if (uri != null){
                        // If the old URI is not null
                    if (old == null)
                            // Register this component, since the URI will be 
                            // displayed as the tool tip
                        toolTipManager.registerComponent(this);
                } else
                        // Unregister this component
                    toolTipManager.unregisterComponent(this);
            }
        }
        setVisited(false);
    }
    /**
     * This returns the color to use as the foreground color of the text when 
     * there's a hyperlink set and that hyperlink has not been visited yet.
     * @return The color for unvisited hyperlinks. If no color has been set for 
     * unvisited hyperlinks, then {@link UNVISITED_HYPERLINK_COLOR 
     * UNVISITED_HYPERLINK_COLOR} is returned.
     * @see #setUnvisitedHyperlinkColor(java.awt.Color) 
     * @see #isUnvisitedHyperlinkColorSet() 
     * @see #getVisitedHyperlinkColor() 
     * @see #setVisitedHyperlinkColor(java.awt.Color) 
     * @see #isVisited() 
     * @see #setVisited(boolean) 
     * @see #getURI() 
     * @see #setURI(java.net.URI) 
     * @see UNVISITED_HYPERLINK_COLOR
     */
    public Color getUnvisitedHyperlinkColor(){
            // If the unvisited hyperlink color is not set
        if (unvisitedColor == null)
            return UNVISITED_HYPERLINK_COLOR;
        return unvisitedColor;
    }
    /**
     * This sets the color to use as the foreground color of the text when 
     * there's a hyperlink set and that hyperlink has not been visited yet.
     * @param color The color for unvisited hyperlinks. If this is null, then 
     * {@link UNVISITED_HYPERLINK_COLOR UNVISITED_HYPERLINK_COLOR} will be used 
     * instead.
     * @see #getUnvisitedHyperlinkColor() 
     * @see #isUnvisitedHyperlinkColorSet() 
     * @see #getVisitedHyperlinkColor() 
     * @see #setVisitedHyperlinkColor(java.awt.Color) 
     * @see #isVisited() 
     * @see #setVisited(boolean) 
     * @see #getURI() 
     * @see #setURI(java.net.URI) 
     * @see UNVISITED_HYPERLINK_COLOR
     */
    public void setUnvisitedHyperlinkColor(Color color){
            // If the unvisited hyperlink color would change
        if (!Objects.equals(unvisitedColor, color)){
                // Get the old color for unvisited hyperlinks
            Color old = unvisitedColor;
            unvisitedColor = color;
            firePropertyChange(UNVISITED_HYPERLINK_COLOR_PROPERTY_CHANGED,old,
                    color);
                // If the URI is set and the hyperlink has not been visited yet
            if (getURI() != null && !isVisited())
                repaint();
        }
    }
    /**
     * This returns whether a color for unvisited hyperlinks has been explicitly 
     * set for this label.
     * @return {@code true} if the unvisited hyperlink color has been explicitly 
     * set for this label; {@code false} otherwise.
     * @see #getUnvisitedHyperlinkColor() 
     * @see #setUnvisitedHyperlinkColor(java.awt.Color) 
     * @see #isVisited() 
     * @see #setVisited(boolean) 
     * @see #getURI() 
     * @see #setURI(java.net.URI) 
     * @see UNVISITED_HYPERLINK_COLOR
     */
    public boolean isUnvisitedHyperlinkColorSet(){
        return unvisitedColor != null;
    }
    /**
     * This returns the color to use as the foreground color of the text when 
     * there's a hyperlink set and that hyperlink has been visited.
     * @return The color for visited hyperlinks. If no color has been set for 
     * visited hyperlinks, then {@link VISITED_HYPERLINK_COLOR 
     * VISITED_HYPERLINK_COLOR} is returned.
     * @see #setVisitedHyperlinkColor(java.awt.Color) 
     * @see #isVisitedHyperlinkColorSet() 
     * @see #getUnvisitedHyperlinkColor() 
     * @see #setUnvisitedHyperlinkColor(java.awt.Color) 
     * @see #isVisited() 
     * @see #setVisited(boolean) 
     * @see #getURI() 
     * @see #setURI(java.net.URI) 
     * @see VISITED_HYPERLINK_COLOR
     */
    public Color getVisitedHyperlinkColor(){
            // If the visited hyperlink color is not set
        if (visitedColor == null)
            return VISITED_HYPERLINK_COLOR;
        return visitedColor;
    }
    /**
     * This sets the color to use as the foreground color of the text when 
     * there's a hyperlink set and that hyperlink has been visited.
     * @param color The color for visited hyperlinks. If this is null, then 
     * {@link VISITED_HYPERLINK_COLOR VISITED_HYPERLINK_COLOR} will be used 
     * instead.
     * @see #getVisitedHyperlinkColor() 
     * @see #isVisitedHyperlinkColorSet() 
     * @see #getUnvisitedHyperlinkColor() 
     * @see #setUnvisitedHyperlinkColor(java.awt.Color) 
     * @see #isVisited() 
     * @see #setVisited(boolean) 
     * @see #getURI() 
     * @see #setURI(java.net.URI) 
     * @see VISITED_HYPERLINK_COLOR
     */
    public void setVisitedHyperlinkColor(Color color){
            // If the visited hyperlink color would change
        if (!Objects.equals(visitedColor, color)){
                // Get the old color for visited hyperlinks
            Color old = visitedColor;
            visitedColor = color;
            firePropertyChange(VISITED_HYPERLINK_COLOR_PROPERTY_CHANGED,old,
                    color);
                // If the URI is set and the hyperlink has been visited
            if (getURI() != null && isVisited())
                repaint();
        }
    }
    /**
     * This returns whether a color for visited hyperlinks has been explicitly 
     * set for this label.
     * @return {@code true} if the visited hyperlink color has been explicitly 
     * set for this label; {@code false} otherwise.
     * @see #getVisitedHyperlinkColor() 
     * @see #setVisitedHyperlinkColor(java.awt.Color) 
     * @see #isVisited() 
     * @see #setVisited(boolean) 
     * @see #getURI() 
     * @see #setURI(java.net.URI) 
     * @see VISITED_HYPERLINK_COLOR
     */
    public boolean isVisitedHyperlinkColorSet(){
        return visitedColor != null;
    }
    /**
     * This returns the color to use as the foreground color of the text when 
     * there's a hyperlink set and the hyperlink is activated.
     * @return The color for activated hyperlinks. If no color has been set for 
     * activated hyperlinks, then {@link #ACTIVATED_HYPERLINK_COLOR 
     * ACTIVATED_HYPERLINK_COLOR} is returned.
     * @see #setActivatedHyperlinkColor(java.awt.Color) 
     * @see #isActivatedHyperlinkColorSet() 
     * @see #getURI() 
     * @see #setURI(java.net.URI) 
     * @see #ACTIVATED_HYPERLINK_COLOR
     */
    public Color getActivatedHyperlinkColor(){
            // If the activated hyperlink color is not set
        if (activatedColor == null)
            return ACTIVATED_HYPERLINK_COLOR;
        return activatedColor;
    }
    /**
     * This sets the color to use as the foreground color of the text when 
     * there's a hyperlink set and the hyperlink is activated.
     * @param color The color for activated hyperlinks. If this is null, then 
     * {@link #ACTIVATED_HYPERLINK_COLOR ACTIVATED_HYPERLINK_COLOR} will be used 
     * instead.
     * @see #getActivatedHyperlinkColor
     * @see #isActivatedHyperlinkColorSet() 
     * @see #getURI() 
     * @see #setURI(java.net.URI) 
     * @see #ACTIVATED_HYPERLINK_COLOR
     */
    public void setActivatedHyperlinkColor(Color color){
            // If the activated hyperlink color would change
        if (!Objects.equals(activatedColor, color)){
                // Get the old color when the hyperlink is activated
            Color old = activatedColor;
            activatedColor = color;
            firePropertyChange(ACTIVATED_HYPERLINK_COLOR_PROPERTY_CHANGED,old,
                    color);
                // If the URI is set and the hyperlink is currently activated
            if (getURI() != null && isActivated())
                repaint();
        }
    }
    /**
     * This returns whether a color for activated hyperlinks has been explicitly 
     * set for this label.
     * @return {@code true} if the activated hyperlink color has been explicitly 
     * set for this label; {@code false} otherwise.
     * @see #getActivatedHyperlinkColor() 
     * @see #setActivatedHyperlinkColor(java.awt.Color) 
     * @see #getURI() 
     * @see #setURI(java.net.URI) 
     * @see #ACTIVATED_HYPERLINK_COLOR
     */
    public boolean isActivatedHyperlinkColorSet(){
        return activatedColor != null;
    }
    /**
     * This returns the foreground color for the hyperlink text.
     * @return The color for the hyperlink color. If there is no hyperlink set 
     * or this label is disabled, then this will return null.
     * @see #getURI() 
     * @see #setURI(java.net.URI) 
     * @see #isVisited() 
     * @see #setVisited(boolean) 
     * @see #isActivated() 
     * @see #setActivated(boolean) 
     * @see #isEnabled() 
     * @see #setEnabled(boolean) 
     * @see #getUnvisitedHyperlinkColor() 
     * @see #setUnvisitedHyperlinkColor(java.awt.Color) 
     * @see #getVisitedHyperlinkColor() 
     * @see #setVisitedHyperlinkColor(java.awt.Color) 
     * @see #getActivatedHyperlinkColor() 
     * @see #setActivatedHyperlinkColor(java.awt.Color) 
     */
    protected Color getHyperlinkColor(){
            // If the URI is not set or the label is disabled
        if (getURI() == null || !isEnabled())
            return null;
            // If the hyperlink is currently activated
        if (isActivated())
            return getActivatedHyperlinkColor();
            // If the hyperlink has been visited
        if (isVisited())
            return getVisitedHyperlinkColor();
        return getUnvisitedHyperlinkColor();
    }
    /**
     * This derives the font to use for the hyperlink from the given font.
     * @param font The font to use to draw the label.
     * @return The font to use for the hyperlink text.
     * @see #getURI() 
     * @see #getHyperlinkColor() 
     * @see #isHoveredOver() 
     * @see #getFont() 
     * @see #paintComponent(java.awt.Graphics) 
     */
    protected Font deriveHyperlinkFont(Font font){
            // If the URI is set to a non-null value and a non-null font has 
            // been provided
        if (getURI() != null && font != null){
                // This is a map of attributes to apply to the font
            HashMap<TextAttribute, Object> map = new HashMap<>();
                // Set the foreground color to the color for the hyperlink
            map.put(TextAttribute.FOREGROUND, getHyperlinkColor());
                // If the hyperlink is being hovered over and the label is 
                // enabled
            if (isHoveredOver() && isEnabled())
                    // Draw a thicker underline lower than normal
                map.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_LOW_TWO_PIXEL);
            else
                map.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
                // Derive the font with the text attributes applied to it
            return font.deriveFont(map);
        }
        return font;
    }
    /**
     * {@inheritDoc }
     * @param g {@inheritDoc }
     * @see #paint(java.awt.Graphics) 
     * @see javax.swing.plaf.ComponentUI
     */
    @Override
    protected void paintComponent(java.awt.Graphics g){
            // This gets whether the component was somehow already painting
        boolean temp = isPainting;
        isPainting = true;
            // Derive the hyperlink font from the font
        g.setFont(deriveHyperlinkFont(g.getFont()));
        super.paintComponent(g);
        isPainting = temp;
    }
    /**
     * {@inheritDoc }
     * @return {@inheritDoc }
     * @see #setFont(java.awt.Font) 
     */
    @Override
    public Font getFont(){
            // Get the font for the label
        Font font = super.getFont();
            // If the label is currently being painted
        if (isPainting)
                // Derive the hyperlink font from the font
            return deriveHyperlinkFont(font);
        return font;
    }
    /**
     * This returns the tooltip for this label. If {@link #setToolTipText 
     * setToolTipText} has been set to a non-null value, then that is what is 
     * returned. Otherwise, this will return the {@link #getURI() URI} as a 
     * String.
     * @return The text of the tool tip.
     * @see #setToolTipText(java.lang.String) 
     * @see #isToolTipTextSet() 
     * @see #TOOL_TIP_TEXT_KEY
     * @see #getURI() 
     * @see #setURI(java.net.URI) 
     */
    @Override
    public String getToolTipText(){
            // If the tool tip text is set
        if (isToolTipTextSet())
            return super.getToolTipText();
            // If there is a URI set, display it as the tool tip text.
        return (getURI() != null) ? getURI().toString() : null;
    }
    /**
     * This registers the text to display in a tool tip, the text that is 
     * displayed when the cursor lingers over the component. When this is not 
     * set, then the {@link #getURI() URI} will be displayed for the tool tip.
     * <p>
     * 
     * See <a href="http://docs.oracle.com/javase/tutorial/uiswing/components/tooltip.html">How to Use Tool Tips</a> 
     * in <em>The Java Tutorial</em> for more documentation about tool tips.
     * 
     * @param text The string to display; if the text is null, then the URI will 
     * be used for the tool tip instead.
     * @see #getToolTipText() 
     * @see #isToolTipTextSet() 
     * @see #TOOL_TIP_TEXT_KEY
     * @see #getURI() 
     */
    @Override
    public void setToolTipText(String text){
        super.setToolTipText(text);
            // If the tool tip text was set to null but there is a URI set
        if (text == null && getURI() != null)
                // The setToolTipText method will have unregistered this 
                // component, but it needs to be registered to display the URI.
                // Re-register this component with the tool tip manager
            ToolTipManager.sharedInstance().registerComponent(this);
    }
    /**
     * This returns whether {@link #setToolTipText(java.lang.String) 
     * setToolTipText} has been called with a non-null value for the tool tip 
     * text. When the tool tip text is not set, then the {@link #getURI() URI} 
     * will be displayed as the tool tip if one is set.
     * @return Whether the text for the tool tip has been set.
     * @see #setToolTipText(java.lang.String) 
     * @see #getToolTipText() 
     * @see #TOOL_TIP_TEXT_KEY
     */
    public boolean isToolTipTextSet(){
        return super.getToolTipText() != null;
    }
    /**
     * This returns the cursor to default to when no cursor is explicitly set 
     * for this label. If this label is enabled and has a {@link #getURI() URI} 
     * set, then this will return the {@link #getHandCursor() hand cursor}. 
     * Otherwise, this will return null.
     * @return The cursor to use when no cursor is explicitly set, or null to 
     * inherit the cursor.
     * @see #getCursor() 
     * @see #setCursor(java.awt.Cursor) 
     * @see #isCursorSet() 
     * @see #getHandCursor() 
     * @see #setHandCursor(java.awt.Cursor) 
     * @see #isHandCursorSet() 
     * @see #isEnabled() 
     * @see #getURI() 
     */
    protected Cursor getDefaultCursor(){
            // If the label is enabled and the URI is set
        return (isEnabled() && getURI() != null) ? getHandCursor() : null;
    }
    /**
     * This updates the cursor when using the default cursor.
     */
    private void updateDefaultCursor(){
            // If the cursor is not explicitly set
        if (!cursorIsSet)
            super.setCursor(getDefaultCursor());
    }
    /**
     * This sets the cursor image to use for the hand cursor. This is the cursor 
     * used when no cursor has been explicitly set for this label, this label is 
     * enabled, and has a {@link #getURI() URI} set.
     * @param cursor The cursor image for the hand cursor.
     * @see #isEnabled() 
     * @see #getURI() 
     * @see #isShowing() 
     * @see #getHandCursor() 
     * @see #isHandCursorSet() 
     * @see #getCursor() 
     * @see #setCursor(java.awt.Cursor) 
     * @see #isCursorSet() 
     * @see Toolkit#createCustomCursor(java.awt.Image, java.awt.Point, java.lang.String) 
     * @see Cursor
     * @see Cursor#getPredefinedCursor(int) 
     * @see Cursor#HAND_CURSOR
     */
    public void setHandCursor(Cursor cursor){
        handCursor = cursor;
        updateDefaultCursor();
    }
    /**
     * This gets the hand cursor set for the label. If the label does not have 
     * a cursor set for the hand cursor, then {@code Cursor.HAND_CURSOR} is 
     * returned.
     * @return The hand cursor for this label.
     * @see #setHandCursor(java.awt.Cursor) 
     * @see #isHandCursorSet() 
     * @see #getCursor() 
     * @see Cursor#getPredefinedCursor(int) 
     * @see Cursor#HAND_CURSOR
     */
    public Cursor getHandCursor(){
            // If the hand cursor is not set
        if (handCursor == null)
                // Get the predefined hand cursor
            return Cursor.getPredefinedCursor(Cursor.HAND_CURSOR);
        return handCursor;
    }
    /**
     * This returns whether the hand cursor has been explicitly set for this 
     * label. If this method returns {@code false}, then {@code 
     * Cursor.HAND_CURSOR} will be used for the hand cursor.
     * @return {@code true} if the hand cursor has been explicitly set for this 
     * label, {@code false} otherwise.
     * @see #isCursorSet() 
     * @see #getHandCursor() 
     */
    public boolean isHandCursorSet(){
        return handCursor != null;
    }
    /**
     * {@inheritDoc }
     * <p>
     * When the cursor is not explicitly set for this label, this label is 
     * enabled, and the {@link #getURI() URI} for this label is set, then the 
     * cursor will be the {@link #getHandCursor() hand cursor} for this label.
     * @param cursor {@inheritDoc }
     * @see #isEnabled() 
     * @see #getURI() 
     * @see #isShowing() 
     * @see #getCursor() 
     * @see #contains(int, int) 
     * @see Toolkit#createCustomCursor(java.awt.Image, java.awt.Point, java.lang.String) 
     * @see Cursor
     * @see Cursor#getPredefinedCursor(int) 
     * @see #getHandCursor() 
     * @see #setHandCursor(java.awt.Cursor) 
     */
    @Override
    public void setCursor(Cursor cursor){
            // Get if the cursor is not null
        cursorIsSet = cursor != null;
            // If the cursor is null
        if (!cursorIsSet)
                // Use the default cursor for this label
            cursor = getDefaultCursor();
        super.setCursor(cursor);
    }
    /**
     * This returns the cursor set in this component. If this label does not 
     * have a cursor set, then this will return the {@link #getHandCursor() hand 
     * cursor} if this label is enabled and has a {@link #getURI() URI} set. If 
     * this label does not have a cursor set and is either not enabled or does 
     * not have a URI set, then the cursor of its parent will be returned. If no 
     * cursor is set for the entire hierarchy, {@code Cursor.DEFAULT_CURSOR} is 
     * returned.
     * @return {@inheritDoc }
     * @see #setCursor(java.awt.Cursor) 
     * @see #getHandCursor() 
     * @see #setHandCursor(java.awt.Cursor) 
     * @see #isEnabled() 
     * @see #getURI() 
     */
    @Override
    public Cursor getCursor(){
        return super.getCursor();
    }
    /**
     * This returns whether the cursor has been explicitly set for this label. 
     * If this method returns {@code false}, then this label will use the 
     * {@link #getHandCursor() hand cursor} if the label is enabled and has a 
     * {@link #getURI() URI} set, otherwise this label is inherit its cursor 
     * from an ancestor.
     * @return {@inheritDoc }
     * @see #isHandCursorSet() 
     */
    @Override
    public boolean isCursorSet() {
        return cursorIsSet && super.isCursorSet();
    }
    /**
     * {@inheritDoc }
     * @param enabled {@inheritDoc }
     * @see #isEnabled() 
     * @see #isLightweight() 
     */
    @Override
    public void setEnabled(boolean enabled){
        super.setEnabled(enabled);
        updateDefaultCursor();
    }
    /**
     * This opens the hyperlink in the user's default browser. If this fails to 
     * open the browser, then this will display an error message to the user if 
     * {@link #getFailureMessagesAreShown() failure messages are to be shown}.
     * @throws IllegalStateException If the URI is not set.
     * @see #copyHyperlink(java.awt.datatransfer.Clipboard) 
     * @see #copyHyperlink() 
     * @see #getURI() 
     * @see #setURI(java.net.URI) 
     * @see #getFailureMessagesAreShown() 
     * @see #setFailureMessagesAreShown(boolean) 
     */
    public void openHyperlink(){
            // If the URI is not set
        if (getURI() == null)
            throw new IllegalStateException();
            // If the desktop is supported
        if (Desktop.isDesktopSupported()){
            try{    // Open the hyperlink with the user's default browser
                Desktop.getDesktop().browse(getURI());
                    // The hyperlink has been visited now
                setVisited(true);
            } catch (IOException ex){
                Logger.getLogger("SwingExtended").log(Level.WARNING, 
                        "Failed to open hyperlink", ex);
                    // Provide error feedback to the user
                UIManager.getLookAndFeel().provideErrorFeedback(this);
                    // If the program should show error messages
                if (getFailureMessagesAreShown())
                    JOptionPane.showMessageDialog(this, 
                            "Failed to open the hyperlink. This may be because "
                                    + "your default browser failed to launch.", 
                            "Failed to Open Hyperlink", 
                            JOptionPane.WARNING_MESSAGE);
            }
        } else {
            Logger.getLogger("SwingExtended").warning(
                    "Desktop is not supported on this device.");
                // Provide error feedback to the user
            UIManager.getLookAndFeel().provideErrorFeedback(this);
                // If the program should show error messages
            if (getFailureMessagesAreShown())
                JOptionPane.showMessageDialog(this, 
                        "Java is not able to open hyperlinks on this device.",
                        "Failed to Open Hyperlink",JOptionPane.WARNING_MESSAGE);
        }
    }
    /**
     * This copies the hyperlink to the given clipboard.
     * @param clipboard The clipboard to copy the hyperlink to.
     * @throws IllegalStateException If the URI is not set.
     * @see #copyHyperlink() 
     * @see #openHyperlink() 
     * @see #getURI() 
     * @see #setURI(java.net.URI) 
     */
    public void copyHyperlink(Clipboard clipboard){
            // If the URI is not set
        if (getURI() == null)
            throw new IllegalStateException();
            // A StringSelection to use to copy the hyperlink
        StringSelection selection = new StringSelection(getURI().toString());
        try{    // Put the selection onto the clipboard
            clipboard.setContents(selection, selection);
        } catch (IllegalStateException ex){
            Logger.getLogger("SwingExtended").log(Level.WARNING, 
                    "Clipboard is currently unavailable", ex);
                // Provide error feedback to the user
            UIManager.getLookAndFeel().provideErrorFeedback(this);
        }
    }
    /**
     * This copies the hyperlink to the system clipboard.
     * @throws IllegalStateException If the URI is not set.
     * @see #getToolkit() 
     * @see Toolkit#getSystemClipboard() 
     * @see #copyHyperlink(java.awt.datatransfer.Clipboard) 
     * @see #openHyperlink() 
     * @see #getURI() 
     * @see #setURI(java.net.URI) 
     */
    public void copyHyperlink(){
        copyHyperlink(getToolkit().getSystemClipboard());
    }
    /**
     * This adds the given {@code HyperlinkListener} to this label.
     * @param l The listener to add.
     * @see #removeHyperlinkListener(HyperlinkListener) 
     * @see #getHyperlinkListeners() 
     */
    public void addHyperlinkListener(HyperlinkListener l){
        if (l != null)          // If the listener is not null
            listenerList.add(HyperlinkListener.class, l);
    }
    /**
     * This removes the given {@code HyperlinkListener} from this label.
     * @param l The listener to remove.
     * @see #addHyperlinkListener(HyperlinkListener) 
     * @see #getHyperlinkListeners() 
     */
    public void removeHyperlinkListener(HyperlinkListener l){
        listenerList.remove(HyperlinkListener.class, l);
    }
    /**
     * This returns an array containing all the {@code HyperlinkListener}s that 
     * have been added to this label.
     * @return An array containing the {@code HyperlinkListener}s that have been 
     * added, or an empty array if none have been added.
     * @see #addHyperlinkListener(HyperlinkListener) 
     * @see #removeHyperlinkListener(HyperlinkListener) 
     */
    public HyperlinkListener[] getHyperlinkListeners(){
        return listenerList.getListeners(HyperlinkListener.class);
    }
    /**
     * This notifies all the {@code HyperlinkListener}s that have been added to 
     * this label that the hyperlink has been updated if the given {@code 
     * HyperlinkEvent} is not null.
     * @param evt The {@code HyperlinkEvent} to fire.
     * @see #addHyperlinkListener(javax.swing.event.HyperlinkListener) 
     * @see #removeHyperlinkListener(javax.swing.event.HyperlinkListener) 
     * @see #getHyperlinkListeners() 
     * @see #fireHyperlinkUpdate(javax.swing.event.HyperlinkEvent.EventType, 
     * java.net.URL, java.lang.String, java.awt.event.InputEvent) 
     * @see #fireHyperlinkUpdate(javax.swing.event.HyperlinkEvent.EventType, 
     * java.awt.event.InputEvent) 
     */
    protected void fireHyperlinkUpdate(HyperlinkEvent evt){
            // If the event is null
        if (evt == null)
            return;
            // A for loop to go through the hyperlink listeners
        for (HyperlinkListener l : listenerList.getListeners(
                HyperlinkListener.class)){
                // If the listener is not null
            if (l != null)
                l.hyperlinkUpdate(evt);
        }
    }
    /**
     * This notifies all the {@code HyperlinkListener}s that have been added to 
     * this label that the hyperlink has been updated with the given event type, 
     * URL, description, and input event.
     * @param type The event type for the hyperlink event.
     * @param url The affected URL, or null.
     * @param desc The description of the link, or null. This may be useful when 
     * attempting to form a URL resulted in a {@code MalformedURLException} 
     * being thrown. This description provides the text used when attempting to 
     * form the URL.
     * @param inputEvent The {@code InputEvent} that triggered this event, or 
     * null.
     * @see #addHyperlinkListener(javax.swing.event.HyperlinkListener) 
     * @see #removeHyperlinkListener(javax.swing.event.HyperlinkListener) 
     * @see #getHyperlinkListeners() 
     * @see #fireHyperlinkUpdate(javax.swing.event.HyperlinkEvent) 
     * @see #fireHyperlinkUpdate(javax.swing.event.HyperlinkEvent.EventType, 
     * java.awt.event.InputEvent) 
     */
    protected void fireHyperlinkUpdate(HyperlinkEvent.EventType type, URL url, 
            String desc, InputEvent inputEvent){
        fireHyperlinkUpdate(new HyperlinkEvent(this,type,url,desc,null,inputEvent));
    }
    /**
     * This notifies all the {@code HyperlinkListener}s that have been added to 
     * this label that the hyperlink has been updated with the given event type 
     * and input event, along with the {@link #getURI() URI} set for this label.
     * @param type The event type for the hyperlink event.
     * @param inputEvent The {@code InputEvent} that triggered this event, or 
     * null.
     * @see #getURI() 
     * @see #addHyperlinkListener(javax.swing.event.HyperlinkListener) 
     * @see #removeHyperlinkListener(javax.swing.event.HyperlinkListener) 
     * @see #getHyperlinkListeners() 
     * @see #fireHyperlinkUpdate(javax.swing.event.HyperlinkEvent) 
     * @see #fireHyperlinkUpdate(javax.swing.event.HyperlinkEvent.EventType, 
     * java.net.URL, java.lang.String, java.awt.event.InputEvent) 
     */
    protected void fireHyperlinkUpdate(HyperlinkEvent.EventType type, 
            InputEvent inputEvent){
            // The URL version of the URI
        URL url = null;
            // A description of the link
        String desc = null;
            // If the URI is not null
        if (getURI() != null){
            try {   // Try to convert it to a URL
                url = getURI().toURL();
            } catch (MalformedURLException | IllegalArgumentException ex) {
                Logger.getLogger("SwingExtended").log(Level.WARNING, 
                        "URI cannot be converted to URL", ex);
            }
            desc = getURI().toString();
        }
        fireHyperlinkUpdate(type,url,desc,inputEvent);
    }
    /**
     * This returns a String representation of this JHyperlinkLabel. This method 
     * is primarily intended to be used only for debugging purposes, and the 
     * content and format of the returned String may vary between 
     * implementations.
     * @return A String representation of this JHyperlinkLabel.
     */
    @Override
    protected String paramString(){
        return super.paramString()+
                ",uri="+Objects.toString(getURI(), "")+
                    // State whether the link has been visited yet
                ((isVisited())?",visited":"")+
                ",failureMessagesAreShown="+getFailureMessagesAreShown()+
                ",unvisitedColor="+Objects.toString(unvisitedColor, "")+
                ",visitedColor="+Objects.toString(visitedColor, "")+
                ",activatedColor="+Objects.toString(activatedColor, "");
    }
    /**
     * A handler class to handle mouse events on the label.
     */
    private class Handler extends MouseAdapter{
        /**
         * This is for opening the hyperlink when clicked.
         * @param evt The mouse event to process.
         */
        @Override
        public void mouseClicked(MouseEvent evt) {
                // If there is a URI, the label is enabled, and the label was 
                // clicked on with the left mouse button
            if (getURI() != null && isEnabled() && SwingUtilities.isLeftMouseButton(evt)){
                    // Notify the hyperlink listeners that the hyperlink is 
                    // activated
                fireHyperlinkUpdate(HyperlinkEvent.EventType.ACTIVATED,evt);
                    // Open the hyperlink
                openHyperlink();
            }
        }
        /**
         * This processes the label being pressed.
         * @param evt The mouse event to process.
         */
        @Override
        public void mousePressed(MouseEvent evt){
                // If the label was pressed with the left mouse button
            if (SwingUtilities.isLeftMouseButton(evt))
                setActivated(true);
        }
        /**
         * This processes the label being released.
         * @param evt The mouse event to process.
         */
        @Override
        public void mouseReleased(MouseEvent evt){
                // If the left mouse button was released
            if (SwingUtilities.isLeftMouseButton(evt))
                setActivated(false);
        }
        /**
         * This is for highlighting the label when hovered over.
         * @param evt The mouse event to process.
         */
        @Override
        public void mouseEntered(MouseEvent evt) {
            setHoveredOver(true);
                // Notify the hyperlink listeners that the label has been entered
            fireHyperlinkUpdate(HyperlinkEvent.EventType.ENTERED,evt);
        }
        /**
         * This is for un-highlighting the label when not hovered over.
         * @param evt The mouse event to process.
         */
        @Override
        public void mouseExited(MouseEvent evt) {
            setHoveredOver(false);
                // Notify the hyperlink listeners that the label has been exited
            fireHyperlinkUpdate(HyperlinkEvent.EventType.EXITED,evt);
        }
    }
    /**
     * This is the abstract class for an action that interacts with a hyperlink 
     * label.
     */
    public abstract class HyperlinkAction extends AbstractAction{
        /**
         * This creates a {@code HyperlinkAction}.
         */
        HyperlinkAction(){
            super();
        }
        /**
         * This creates a {@code HyperlinkAction} with the given name.
         * @param name The name ({@code Action.NAME}) for the action, or null.
         */
        HyperlinkAction(String name){
            super(name);
        }
        /**
         * This creates a {@code HyperlinkAction} with the given name and small 
         * icon.
         * @param name The name ({@code Action.NAME}) for the action, or null.
         * @param icon The small icon ({@code Action.SMALL_ICON}) for the 
         * action, or null.
         */
        HyperlinkAction(String name, Icon icon){
            super(name,icon);
        }
        /**
         * This returns the parent {@code JHyperlinkLabel} for this action.
         * @return The parent hyperlink label.
         */
        public JHyperlinkLabel getHyperlinkLabel(){
            return JHyperlinkLabel.this;
        }
        /**
         * This returns the URI for the hyperlink. This is equivalent to calling 
         * {@link #getHyperlinkLabel() getHyperlinkLabel()}{@code .}{@link 
         * JHyperlinkLabel#getURI() getURI()}.
         * @return The URI for the hyperlink.
         * @see #getHyperlinkLabel()
         * @see JHyperlinkLabel#getURI()
         */
        public URI getURI(){
            return getHyperlinkLabel().getURI();
        }
    }
    /**
     * This is an action that copies the link to a clipboard.
     * @see #copyHyperlink(java.awt.datatransfer.Clipboard) 
     * @see #copyHyperlink() 
     */
    public class CopyLinkAction extends HyperlinkAction{
        /**
         * The key used for storing the <code>Clipboard</code> that this action 
         * copies the hyperlink to. The default for this value is 
         * <code>null</code>, which indicates that the {@link 
         * Toolkit#getSystemClipboard() system clipboard} is used.
         */
        public static final String CLIPBOARD = "Clipboard";
        /**
         * This creates a {@code CopyLinkAction}.
         */
        public CopyLinkAction(){
            super();
        }
        /**
         * This creates a {@code CopyLinkAction} with the given name.
         * @param name The name ({@code Action.NAME}) for the action, or null.
         */
        public CopyLinkAction(String name){
            super(name);
        }
        /**
         * This creates a {@code CopyLinkAction} with the given name and small 
         * icon.
         * @param name The name ({@code Action.NAME}) for the action, or null.
         * @param icon The small icon ({@code Action.SMALL_ICON}) for the 
         * action, or null.
         */
        public CopyLinkAction(String name, Icon icon){
            super(name,icon);
        }
        /**
         * This creates a {@code CopyLinkAction} with the given clipboard.
         * @param clipboard The clipboard ({@code CopyLinkAction.CLIPBOARD}) for 
         * the action, or null.
         */
        public CopyLinkAction(Clipboard clipboard){
            this();
            putValue(CLIPBOARD,clipboard);
        }
        /**
         * This creates a {@code CopyLinkAction} with the given name and 
         * clipboard.
         * @param name The name ({@code Action.NAME}) for the action, or null.
         * @param clipboard The clipboard ({@code CopyLinkAction.CLIPBOARD}) for 
         * the action, or null.
         */
        public CopyLinkAction(String name, Clipboard clipboard){
            this(name);
            putValue(CLIPBOARD,clipboard);
        }
        /**
         * This creates a {@code CopyLinkAction} with the given name, small 
         * icon, and clipboard.
         * @param name The name ({@code Action.NAME}) for the action, or null.
         * @param icon The small icon ({@code Action.SMALL_ICON}) for the 
         * action, or null.
         * @param clipboard The clipboard ({@code CopyLinkAction.CLIPBOARD}) for 
         * the action, or null.
         */
        public CopyLinkAction(String name, Icon icon, Clipboard clipboard){
            this(name,icon);
            putValue(CLIPBOARD,clipboard);
        }
        /**
         * This is invoked when an action occurs. This will copy the link to the 
         * clipboard ({@code CopyLinkAction.CLIPBOARD}) set for this action. If 
         * no clipboard has been set for this action, then the link will be 
         * copied to the system clipboard.
         * @param evt The event to be processed.
         * @throws ClassCastException If a non-null value is set for the 
         * clipboard and that value cannot be cast to a {@link 
         * java.awt.datatransfer.Clipboard Clipboard}.
         * @throws IllegalStateException If the URI is not set.
         * @see CLIPBOARD
         * @see #getURI() 
         * @see #getHyperlinkLabel() 
         * @see JHyperlinkLabel#copyHyperlink(java.awt.datatransfer.Clipboard) 
         * @see JHyperlinkLabel#copyHyperlink() 
         * @see #getToolkit() 
         * @see Toolkit#getSystemClipboard() 
         */
        @Override
        public void actionPerformed(ActionEvent evt) {
                // Get the clipboard set for this action
            Clipboard clipboard = (Clipboard) getValue(CLIPBOARD);
                // If no clipboard has been set
            if (clipboard == null)
                getHyperlinkLabel().copyHyperlink();
            else
                getHyperlinkLabel().copyHyperlink(clipboard);
        }
    }
}
