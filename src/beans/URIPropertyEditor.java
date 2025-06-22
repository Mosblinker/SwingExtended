/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans;

import java.beans.PropertyEditorSupport;
import java.net.URI;

/**
 * This is a property editor for editing URI objects.
 * @author Mosblinker
 */
public class URIPropertyEditor extends PropertyEditorSupport{
    /**
     * This constructs a URIPropertyEditor object.
     */
    public URIPropertyEditor(){
        super();
    }
    /**
     * This constructs a URIPropertyEditor object.
     * @param source The source used for event firing.
     */
    public URIPropertyEditor(Object source){
        super(source);
    }
    @Override
    public void setAsText(String text){
        setValue(URI.create(text));
    }
    @Override
    public String getJavaInitializationString(){
            // Get the value
        Object value = getValue();
            // If the value is not null, provide the String to create it using 
            // create method provided by URI.
        return (value != null) ? 
                "java.net.URI.create(\""+value.toString()+"\")" : "null";
    }
}
