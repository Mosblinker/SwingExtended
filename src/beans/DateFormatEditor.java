/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans;

import java.text.SimpleDateFormat;

/**
 * This is a PropertyEditor used to set DateFormats.
 * @author Milo Steier
 */
public class DateFormatEditor extends java.beans.PropertyEditorSupport{
    /**
     * This constructs a DateFormatEditor object.
     */
    public DateFormatEditor(){
        super();
    }
    /**
     * This constructs a DateFormatEditor object.
     * @param source The source used for event firing.
     */
    public DateFormatEditor(Object source){
        super(source);
    }
    /**
     * This sets the property value by parsing the given String. If the given 
     * String is not null, then this will attempt to create a {@link 
     * SimpleDateFormat SimpleDateFormat} using the given String. If the given 
     * String is null or represents an invalid pattern, then this will throw an 
     * IllegalArgumentException.
     * @param text {@inheritDoc }
     * @see SimpleDateFormat#SimpleDateFormat(java.lang.String) 
     */
    @Override
    public void setAsText(String text){
        if (text == null)   // If the string is null
            throw new IllegalArgumentException();
        setValue(new SimpleDateFormat(text));
    }
    @Override
    public String getAsText(){
        Object value = getValue();              // Get the value
        if (value instanceof SimpleDateFormat)  // If the value is a SimpleDateFormat
            return ((SimpleDateFormat)value).toPattern();
        return super.getAsText();
    }
}
