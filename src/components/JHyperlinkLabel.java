/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package components;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.TextAttribute;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
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
    
    public static final Color UNVISITED_HYPERLINK_COLOR = new Color(0x0000EE);
    
    public static final Color VISITED_HYPERLINK_COLOR = new Color(0x551A8B);
    
    public static final Color SELECTED_HYPERLINK_COLOR = Color.RED;
    
    public static final String URI_PROPERTY_CHANGED = "URIPropertyChanged";
    
    public static final String UNVISITED_HYPERLINK_COLOR_PROPERTY_CHANGED = 
            "UnvisitedColorPropertyChanged";
    
    public static final String VISITED_HYPERLINK_COLOR_PROPERTY_CHANGED = 
            "VisitedColorPropertyChanged";
    
    public static final String SELECTED_HYPERLINK_COLOR_PROPERTY_CHANGED = 
            "SelectedColorPropertyChanged";
    
    public static final String HYPERLINK_VISITED_PROPERTY_CHANGED = 
            "HyperlinkVisitedPropertyChanged";
    
    public static final String FAILURE_MESSAGES_SHOWN_PROPERTY_CHANGED = 
            "FailureMessagesShownPropertyChanged";
    
    protected static final int HYPERLINK_VISITED_FLAG = 0x01;
    
    protected static final int HYPERLINK_CLICKED_FLAG = 0x02;
    
    protected static final int HYPERLINK_HOVERED_FLAG = 0x04;
    
    protected static final int SHOW_FAILURE_MESSAGES_FLAG = 0x08;
    
    private URI uri = null;
    
    private Color unvisitedColor = null;
    
    private Color visitedColor = null;
    
    private Color selectedColor = null;
    
    private int flags = SHOW_FAILURE_MESSAGES_FLAG;
    /**
     * 
     * @param uri 
     */
    private void initialize(URI uri){
        setURI(uri);
        addMouseListener(new Handler());
    }
    
    public JHyperlinkLabel(String text, Icon icon, int horizontalAlignment, 
            URI uri){
        super(text,icon,horizontalAlignment);
        initialize(uri);
    }
    
    public JHyperlinkLabel(String text, Icon icon, int horizontalAlignment){
        this(text,icon,horizontalAlignment,null);
    }
    
    public JHyperlinkLabel(String text, int horizontalAlignment, URI uri){
        super(text,horizontalAlignment);
        initialize(uri);
    }
    
    public JHyperlinkLabel(String text, int horizontalAlignment){
        this(text,horizontalAlignment,null);
    }
    
    public JHyperlinkLabel(String text, URI uri){
        super(text);
        initialize(uri);
    }
    
    public JHyperlinkLabel(String text){
        this(text,null);
    }
    
    public JHyperlinkLabel(Icon icon, int horizontalAlignment, URI uri){
        super(icon,horizontalAlignment);
        initialize(uri);
    }
    
    public JHyperlinkLabel(Icon icon, int horizontalAlignment){
        this(icon,horizontalAlignment,null);
    }
    
    public JHyperlinkLabel(Icon icon, URI uri){
        super(icon);
        initialize(uri);
    }
    
    public JHyperlinkLabel(Icon icon){
        this(icon,null);
    }
    
    public JHyperlinkLabel(URI uri){
        super();
        initialize(uri);
    }
    
    public JHyperlinkLabel(){
        super();
        initialize(null);
    }
    
    protected boolean getFlag(int flag){
        return (flags & flag) == flag;
    }
    
    protected boolean setFlag(int flag, boolean value){
        int old = flags;
        flags = (value) ? (flags | flag) : (flags & ~flag);
        return old != flags;
    }
    
    protected boolean setFlag(int flag, boolean value, String propName){
        boolean change = setFlag(flag,value);
        if (change)
            firePropertyChange(propName,!value,value);
        return change;
    }
    
    public boolean isVisited(){
        return getFlag(HYPERLINK_VISITED_FLAG);
    }
    
    public void setVisited(boolean value){
        if (setFlag(HYPERLINK_VISITED_FLAG,value,HYPERLINK_VISITED_PROPERTY_CHANGED)){
            repaint();
        }
    }
    
    protected boolean isSelected(){
        return getFlag(HYPERLINK_CLICKED_FLAG);
    }
    
    protected void setSelected(boolean value){
        if (setFlag(HYPERLINK_CLICKED_FLAG,value)){
            repaint();
        }
    }
    
    protected boolean isHoveredOver(){
        return getFlag(HYPERLINK_HOVERED_FLAG);
    }
    
    protected void setHoveredOver(boolean value){
        if (setFlag(HYPERLINK_HOVERED_FLAG,value)){
            repaint();
        }
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
        if (!Objects.equals(this.uri, uri)){
            URI old = this.uri;
            this.uri = uri;
            firePropertyChange(URI_PROPERTY_CHANGED,old,uri);
            setVisited(false);
            if (super.getToolTipText() == null){
                ToolTipManager toolTipManager = ToolTipManager.sharedInstance();
                if (uri != null){
                    if (old == null)
                        toolTipManager.registerComponent(this);
                } else
                    toolTipManager.unregisterComponent(this);
            }
        }
    }
    
    public URL getURL() throws MalformedURLException{
        if (getURI() != null)
            return getURI().toURL();
        return null;
    }
    
    public void setURL(URL url) throws URISyntaxException{
        setURI((url!=null)?url.toURI():null);
    }
    
    public void setURL(String url) throws MalformedURLException, URISyntaxException{
        setURL((url!=null)?new URL(url):null);
    }
    
    public Color getUnvisitedHyperlinkColor(){
        if (unvisitedColor == null)
            return UNVISITED_HYPERLINK_COLOR;
        return unvisitedColor;
    }
    
    public void setUnvisitedHyperlinkColor(Color color){
        if (!Objects.equals(unvisitedColor, color)){
            Color old = unvisitedColor;
            unvisitedColor = color;
            firePropertyChange(UNVISITED_HYPERLINK_COLOR_PROPERTY_CHANGED,old,
                    color);
            repaint();
        }
    }
    
    public Color getVisitedHyperlinkColor(){
        if (visitedColor == null)
            return VISITED_HYPERLINK_COLOR;
        return visitedColor;
    }
    
    public void setVisitedHyperlinkColor(Color color){
        if (!Objects.equals(visitedColor, color)){
            Color old = visitedColor;
            visitedColor = color;
            firePropertyChange(VISITED_HYPERLINK_COLOR_PROPERTY_CHANGED,old,
                    color);
            repaint();
        }
    }
    
    public Color getSelectedHyperlinkColor(){
        if (selectedColor == null)
            return SELECTED_HYPERLINK_COLOR;
        return selectedColor;
    }
    
    public void setSelectedHyperlinkColor(Color color){
        if (!Objects.equals(selectedColor, color)){
            Color old = selectedColor;
            selectedColor = color;
            firePropertyChange(SELECTED_HYPERLINK_COLOR_PROPERTY_CHANGED,old,
                    color);
            repaint();
        }
    }
    
    protected Color getHyperlinkColor(){
        if (getURI() == null)
            return null;
        if (isSelected())
            return getSelectedHyperlinkColor();
        if (isVisited())
            return getVisitedHyperlinkColor();
        return getUnvisitedHyperlinkColor();
    }
    
    @Override
    protected void paintComponent(java.awt.Graphics g){
        if (getURI() != null){
            HashMap<TextAttribute, Object> map = new HashMap<>();
            map.put(TextAttribute.FOREGROUND, getHyperlinkColor());
            if (isHoveredOver())
                map.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_LOW_TWO_PIXEL);
            else
                map.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
            g.setFont(g.getFont().deriveFont(map));
        }
        super.paintComponent(g);
    }
    
    @Override
    public String getToolTipText(){
        String tooltip = super.getToolTipText();
        return (tooltip == null && getURI() != null) ? getURI().toString() : tooltip;
    }
    
    @Override
    public void setToolTipText(String text){
        super.setToolTipText(text);
        if (text == null && getURI() != null)
            ToolTipManager.sharedInstance().registerComponent(this);
    }
    
    public void openHyperlink(){
        if (getURI() == null)
            throw new IllegalStateException();
        if (Desktop.isDesktopSupported()){
            try{
                Desktop.getDesktop().browse(getURI());
                setVisited(true);
            } catch (IOException ex){
                Logger.getLogger("SwingExtended").log(Level.WARNING, 
                        "Failed to open hyperlink", ex);
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
            if (getFailureMessagesAreShown())
                JOptionPane.showMessageDialog(this, 
                        "Java is not able to open hyperlinks on this device.",
                        "Failed to Open Hyperlink",JOptionPane.WARNING_MESSAGE);
        }
    }
    
    private class Handler extends MouseAdapter{
        /**
         * This is for opening the hyperlink when clicked.
         * @param evt The mouse event to process.
         */
        @Override
        public void mouseClicked(MouseEvent evt) {
                // If there is a URI and the label was pressed with the left 
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
         */
        @Override
        public void mouseEntered(MouseEvent evt) {
            setHoveredOver(true);
        }
        /**
         * This is for un-highlighting the label when not hovered over.
         */
        @Override
        public void mouseExited(MouseEvent evt) {
            setHoveredOver(false);
        }
    }
}
