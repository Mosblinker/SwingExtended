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
    
    public static final String URI_PROPERTY_CHANGED = "URIPropertyChanged";
    
    private URI uri = null;
    
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
    
}
