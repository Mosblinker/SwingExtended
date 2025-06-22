/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package components;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
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
     * This is the default color for a hyperlink that has been selected.
     */
    public static final Color SELECTED_HYPERLINK_COLOR = Color.RED;
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
     * This identifies that the color for a selected hyperlink has changed.
     */
    public static final String SELECTED_HYPERLINK_COLOR_PROPERTY_CHANGED = 
            "SelectedColorPropertyChanged";
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
     * This is the flag that indicates whether the hyperlink is currently being 
     * selected by the user.
     */
    protected static final int HYPERLINK_SELECTED_FLAG = 0x02;
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
     * selected by the user.
     */
    private Color selectedColor = null;
    /**
     * This is a bunch of flags that control the state of this label.
     */
    private int flags = SHOW_FAILURE_MESSAGES_FLAG;
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
     * alignment, and URI. The label is centered vertically in its display area, 
     * and the text is on the trailing edge of the image.
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
     * @param uri The URI of the hyperlink that this label links to.
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
     * alignment, and URI. The label is centered vertically in its display area.
     * @param text The text to be displayed by this label.
     * @param horizontalAlignment The horizontal alignment for the contents of 
     * this label. This should be one of the following constants defined in 
     * {@code SwingConstants}: 
     *      {@code LEFT}, 
     *      {@code CENTER},
     *      {@code RIGHT},
     *      {@code LEADING}, or
     *      {@code TRAILING}.
     * @param uri The URI of the hyperlink that this label links to.
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
     * This constructs a JHyperlinkLabel with the given text and URI. The label 
     * is centered vertically and aligned against the leading edge of its 
     * display area.
     * @param text The text to be displayed by this label.
     * @param uri The URI of the hyperlink that this label links to.
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
     * alignment, and URI. The label is centered vertically in its display area.
     * @param icon The icon to be displayed by this label.
     * @param horizontalAlignment The horizontal alignment for the contents of 
     * this label. This should be one of the following constants defined in 
     * {@code SwingConstants}: 
     *      {@code LEFT}, 
     *      {@code CENTER},
     *      {@code RIGHT},
     *      {@code LEADING}, or
     *      {@code TRAILING}.
     * @param uri The URI of the hyperlink that this label links to.
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
     * This constructs a JHyperlinkLabel with the given icon and URI. The label 
     * is centered horizontally and vertically in its display area.
     * @param icon The icon to be displayed by this label.
     * @param uri The URI of the hyperlink that this label links to.
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
     * This constructs a JHyperlinkLabel with the given URI for the hyperlink, 
     * and with no text or icon. The label is centered vertically and its 
     * contents will be aligned against the leading edge of its display area.
     * @param uri The URI of the hyperlink that this label links to.
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
     * @see #HYPERLINK_SELECTED_FLAG
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
     * @see #HYPERLINK_SELECTED_FLAG
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
     * @see #HYPERLINK_SELECTED_FLAG
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
     * This sets whether the hyperlink has been visited yet.
     * @param value Whether the hyperlink has been visited yet.
     * 
     */
    public void setVisited(boolean value){
            // If the visited status of the hyperlink has changed
        if (setFlag(HYPERLINK_VISITED_FLAG,value,HYPERLINK_VISITED_PROPERTY_CHANGED))
            repaint();
    }
    
    protected boolean isSelected(){
        return getFlag(HYPERLINK_SELECTED_FLAG);
    }
    
    protected void setSelected(boolean value){
            // If the hyperlink has been selected or un-selected
        if (setFlag(HYPERLINK_SELECTED_FLAG,value))
            repaint();
    }
    
    protected boolean isHoveredOver(){
        return getFlag(HYPERLINK_HOVERED_FLAG);
    }
    
    protected void setHoveredOver(boolean value){
            // If the hyperlink is being hovered over
        if (setFlag(HYPERLINK_HOVERED_FLAG,value))
            repaint();
    }
    
    public boolean getFailureMessagesAreShown(){
        return getFlag(SHOW_FAILURE_MESSAGES_FLAG);
    }
    
    public void setFailureMessagesAreShown(boolean value){
        setFlag(SHOW_FAILURE_MESSAGES_FLAG,value,
                FAILURE_MESSAGES_SHOWN_PROPERTY_CHANGED);
    }
    
    public URI getURI(){
        return uri;
    }
    
    public void setURI(URI uri){
            // If the new URI is different from the old URI
        if (!Objects.equals(this.uri, uri)){
                // Get the old URI
            URI old = this.uri;
                // Set the URI
            this.uri = uri;
            firePropertyChange(URI_PROPERTY_CHANGED,old,uri);
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
    
    public URL getURL() throws MalformedURLException{
            // If the URI is not null
        if (getURI() != null)
            return getURI().toURL();
        return null;
    }
    
    public void setURL(URL url) throws URISyntaxException{
            // If the given URL is not null, convert it to a URI.
        setURI((url!=null)?url.toURI():null);
    }
    
    public void setURL(String url) throws MalformedURLException, URISyntaxException{
            // If th given String is not null, then convert it to a URL
        setURL((url!=null)?new URL(url):null);
    }
    
    public Color getUnvisitedHyperlinkColor(){
            // If the unvisited hyperlink color is not set
        if (unvisitedColor == null)
            return UNVISITED_HYPERLINK_COLOR;
        return unvisitedColor;
    }
    
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
    
    public Color getVisitedHyperlinkColor(){
            // If the visited hyperlink color is not set
        if (visitedColor == null)
            return VISITED_HYPERLINK_COLOR;
        return visitedColor;
    }
    
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
    
    public Color getSelectedHyperlinkColor(){
            // If the selected hyperlink color is not set
        if (selectedColor == null)
            return SELECTED_HYPERLINK_COLOR;
        return selectedColor;
    }
    
    public void setSelectedHyperlinkColor(Color color){
            // If the selected hyperlink color would change
        if (!Objects.equals(selectedColor, color)){
                // Get the old color when the hyperlink is selected
            Color old = selectedColor;
            selectedColor = color;
            firePropertyChange(SELECTED_HYPERLINK_COLOR_PROPERTY_CHANGED,old,
                    color);
                // If the URI is set and the hyperlink is currently selected
            if (getURI() != null && isSelected())
                repaint();
        }
    }
    
    protected Color getHyperlinkColor(){
            // If the URI is not set
        if (getURI() == null)
            return null;
            // If the hyperlink is currently selected
        if (isSelected())
            return getSelectedHyperlinkColor();
            // If the hyperlink has been visited
        if (isVisited())
            return getVisitedHyperlinkColor();
        return getUnvisitedHyperlinkColor();
    }
    
    @Override
    protected void paintComponent(java.awt.Graphics g){
            // If the URI is set to a non-null value
        if (getURI() != null){
                // This is a map of attributes to apply to the font
            HashMap<TextAttribute, Object> map = new HashMap<>();
                // Set the foreground color to the color for the hyperlink
            map.put(TextAttribute.FOREGROUND, getHyperlinkColor());
                // If the hyperlink is being hovered over
            if (isHoveredOver())
                    // Draw a thicker underline lower than normal
                map.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_LOW_TWO_PIXEL);
            else
                map.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
                // Derive the font with the text attributes applied to it
            g.setFont(g.getFont().deriveFont(map));
        }
        super.paintComponent(g);
    }
    
    @Override
    public String getToolTipText(){
            // If the tool tip text is set
        if (isToolTipTextSet())
            return super.getToolTipText();
            // If there is a URI set, display it as the tool tip text.
        return (getURI() != null) ? getURI().toString() : null;
    }
    
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
     * text.
     * @return Whether the text for the tool tip has been set.
     * @see #setToolTipText(java.lang.String) 
     * @see #getToolTipText() 
     * @see #TOOL_TIP_TEXT_KEY
     */
    public boolean isToolTipTextSet(){
        return super.getToolTipText() != null;
    }
    /**
     * 
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
     * @see #copyHyperlink() 
     * @see #openHyperlink() 
     * @see #getURI() 
     * @see #setURI(java.net.URI) 
     * @see #getURL() 
     * @see #setURL(java.net.URL) 
     * @see #setURL(java.lang.String) 
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
     * @see #getToolkit() 
     * @see Toolkit#getSystemClipboard() 
     * @see #copyHyperlink(java.awt.datatransfer.Clipboard) 
     * @see #openHyperlink() 
     * @see #getURI() 
     * @see #setURI(java.net.URI) 
     * @see #getURL() 
     * @see #setURL(java.net.URL) 
     * @see #setURL(java.lang.String) 
     */
    public void copyHyperlink(){
        copyHyperlink(getToolkit().getSystemClipboard());
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
                ((isVisited())?",visited":"")+
                ",failureMessagesAreShown="+getFailureMessagesAreShown()+
                ",unvisitedColor="+Objects.toString(unvisitedColor, "")+
                ",visitedColor="+Objects.toString(visitedColor, "")+
                ",selectedColor="+Objects.toString(selectedColor, "");
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
                // If there is a URI and the label was clicked on with the left 
                // mouse button
            if (getURI() != null && SwingUtilities.isLeftMouseButton(evt))
                openHyperlink();
        }
        /**
         * This processes the label being pressed.
         * @param evt The mouse event to process.
         */
        @Override
        public void mousePressed(MouseEvent evt){
                // If the label was pressed with the left mouse button
            if (SwingUtilities.isLeftMouseButton(evt))
                setSelected(true);
        }
        /**
         * This processes the label being released.
         * @param evt The mouse event to process.
         */
        @Override
        public void mouseReleased(MouseEvent evt){
                // If the left mouse button was released
            if (SwingUtilities.isLeftMouseButton(evt))
                setSelected(false);
        }
        /**
         * This is for highlighting the label when hovered over.
         * @param evt The mouse event to process.
         */
        @Override
        public void mouseEntered(MouseEvent evt) {
            setHoveredOver(true);
        }
        /**
         * This is for un-highlighting the label when not hovered over.
         * @param evt The mouse event to process.
         */
        @Override
        public void mouseExited(MouseEvent evt) {
            setHoveredOver(false);
        }
    }
}
