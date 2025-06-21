/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package components;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Objects;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

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
    
    protected static final int HYPERLINK_VISITED_FLAG = 0x01;
    
    protected static final int HYPERLINK_CLICKED_FLAG = 0x02;
    
    
    
    private URI uri = null;
    
    private Color unvisitedColor = null;
    
    private Color visitedColor = null;
    
    private Color selectedColor = null;
    
    private int flags = 0;
    
    private volatile boolean isPainting = false;
    
    private void initialize(){
        addMouseListener(new Handler());
    }
    
    public JHyperlinkLabel(){
        initialize();
    }
    
    protected boolean getFlag(int flag){
        return (flags & flag) == flag;
    }
    
    protected boolean setFlag(int flag, boolean value){
        int old = flags;
        flags = (value) ? (flags | flag) : (flags & ~flag);
        return old != flags;
    }
    
    public boolean isVisited(){
        return getFlag(HYPERLINK_VISITED_FLAG);
    }
    
    public void setVisited(boolean value){
        if (setFlag(HYPERLINK_VISITED_FLAG,value)){
            fireStateChanged();
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
    
    public URI getURI(){
        return uri;
    }
    
    public void setURI(URI uri){
        if (!Objects.equals(this.uri, uri)){
            URI old = this.uri;
            this.uri = uri;
            boolean reset = setFlag(HYPERLINK_VISITED_FLAG,false);
            firePropertyChange(URI_PROPERTY_CHANGED,old,uri);
            if (reset)
                fireStateChanged();
            repaint();
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
    
    public Color getSelecteddHyperlinkColor(){
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
    
    @Override
    public Color getForeground(){
        if (getURI() != null && isPainting){
            if (isSelected())
                return getSelecteddHyperlinkColor();
            else if (isVisited())
                return getVisitedHyperlinkColor();
            return getUnvisitedHyperlinkColor();
        }
        return super.getForeground();
    }
    
    @Override
    protected void paintComponent(java.awt.Graphics g){
        boolean temp = isPainting;
        isPainting = true;
        super.paintComponent(g);
        isPainting = temp;
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
    
    public void addChangeListener(ChangeListener l){
        if (l != null)
            listenerList.add(ChangeListener.class, l);
    }
    
    public void removeChangeListener(ChangeListener l){
        listenerList.remove(ChangeListener.class, l);
    }
    
    public ChangeListener[] getChangeListeners(){
        return listenerList.getListeners(ChangeListener.class);
    }
    
    protected void fireStateChanged(){
        ChangeEvent evt = new ChangeEvent(this);
        for (ChangeListener l : getChangeListeners()){
            if (l != null)
                l.stateChanged(evt);
        }
    }
    
    private class Handler extends MouseAdapter{
        /**
         * This is for opening the hyperlink when clicked.
         * @param evt The mouse event to process.
         */
        @Override
        public void mouseClicked(MouseEvent evt) {
            // TODO: Implement opening the link when clicked
                // If the label was pressed with the left mouse button
            if (SwingUtilities.isLeftMouseButton(evt))
                setVisited(true);
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
    }
}
