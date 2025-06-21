/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package components;

import java.awt.Color;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Objects;
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
    
    private URI uri = null;
    
    private Color unvisitedColor = null;
    
    private Color visitedColor = null;
    
    private Color selectedColor = null;
    
    private volatile boolean isPainting = false;
    
    private void initialize(){
        
    }
    
    public JHyperlinkLabel(){
        initialize();
    }
    
    public URI getURI(){
        return uri;
    }
    
    public void setURI(URI uri){
        if (!Objects.equals(this.uri, uri)){
            URI old = this.uri;
            this.uri = uri;
            firePropertyChange(URI_PROPERTY_CHANGED,old,uri);
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
    
}
