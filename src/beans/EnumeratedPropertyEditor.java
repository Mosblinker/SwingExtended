/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans;

import java.util.Objects;

/**
 * This is a PropertyEditor intended for use with enumerated values. To use 
 * this, override the {@link #getValues() getValues} method and the {@link 
 * #getTags() getTags} method so that they return the known values and the tag 
 * values corresponding to those values, respectively, and this will do the 
 * rest. The tag values should be in the same order as the known values, as this 
 * determines which value to set when setting the value using a String based off 
 * the index of the matching String in the tags array.
 * @author Milo Steier
 */
public abstract class EnumeratedPropertyEditor extends java.beans.PropertyEditorSupport{
    /**
     * This constructs a EnumeratedPropertyEditor object.
     */
    public EnumeratedPropertyEditor(){
        super();
    }
    /**
     * This constructs a EnumeratedPropertyEditor object.
     * @param source The source used for event firing.
     */
    public EnumeratedPropertyEditor(Object source){
        super(source);
    }
    @Override
    public abstract String[] getTags();
    /**
     * If the property value must be one of a set of known values, then this 
     * method should return an array containing those values. The values in the 
     * returned array should be in the same order as the {@link #getTags() tags} 
     * that correspond to them.
     * @return The array containing the values for this property.
     * @see #getTags() 
     */
    public abstract Object[] getValues();
    /**
     * This returns the index of the given value in the given array.
     * @param value The value to find.
     * @param arr The array to search in.
     * @return The index of the value in the array, or -1 if either the array is 
     * null or the value is not in the array.
     */
    protected int indexOf(Object value, Object[] arr){
        if (arr == null)    // If the array is null
            return -1;
            // A for loop to go through the array
        for (int i = 0; i < arr.length; i++){
                // If the value at the current index matches the given value
            if (Objects.equals(arr[i], value))
                return i;
        }
        return -1;
    }
    /**
     * This returns the value that corresponds to the given tag.
     * @param tag The tag to get the value for.
     * @return The value that corresponds to the tag, or null if no value 
     * corresponds to that tag.
     * @see #getTags() 
     * @see #getValues() 
     * @see #indexOf(java.lang.Object, java.lang.Object[]) 
     * @see #getTagForValue(java.lang.Object) 
     */
    protected Object getValueForTag(String tag){
        int index = indexOf(tag, getTags());    // Get the index of the tag
        Object[] values = getValues();          // Get the possible values
            // If there are values and the index is within range, return the 
            // value at the index. Otherwise, return null.
        return (values != null && index >= 0 && index < values.length) ? 
                values[index] : null;
    }
    /**
     * This returns the tag that corresponds to the given value.
     * @param value The value to get the tag for.
     * @return The tag that corresponds to the value, or null if no tag 
     * corresponds to that value.
     * @see #getTags() 
     * @see #getValues() 
     * @see #indexOf(java.lang.Object, java.lang.Object[]) 
     * @see #getValueForTag(java.lang.String) 
     */
    protected String getTagForValue(Object value){
        int index = indexOf(value,getValues());     // Get the index of the value
        String[] tags = getTags();                  // Get the array of tags
            // If there are tags and the index is within range, return the 
            // tag at the index. Otherwise, return null.
        return (tags != null && index >= 0 && index < tags.length) ? tags[index] : null;
    }
    /**
     * This sets the property value by parsing the given String. If the given 
     * String is not one of the {@link #getTags() tag values}, then this will 
     * throw an IllegalArgumentException.
     * @param text {@inheritDoc }
     * @throws IllegalArgumentException If the given String is not a known tag 
     * value.
     * @see #getTags() 
     * @see #getValues() 
     */
    @Override
    public void setAsText(String text){
        Object value = getValueForTag(text);    // Get the value corresponding to the tag
        if (value == null)                      // If no value was found
            throw new IllegalArgumentException(text);
        else
            super.setValue(value);
    }
    @Override
    public String getAsText(){
        return getTagForValue(getValue());
    }
    /**
     * {@inheritDoc } If the object is not one of the predefined values, then 
     * this will throw an IllegalArgumentException.
     * @param value {@inheritDoc }
     * @see #getValues() 
     */
    @Override
    public void setValue(Object value){
        if (indexOf(value,getValues()) < 0) // If the value is not a valid value
            throw new IllegalArgumentException();
        super.setValue(value);
    }
    /**
     * This returns the name of the given value. This will be the String 
     * returned by {@link #getJavaInitializationString() 
     * getJavaInitializationString} when the given value is set.
     * @param value The value to get the name of.
     * @return The name for the value. May be null if the value should be 
     * initialized based off its {@code toString} method.
     * @see #getJavaInitializationString() 
     */
    public String getNameForValue(Object value){
        return null;
    }
    @Override
    public String getJavaInitializationString(){
        Object value = getValue();              // Get the current value
        if (value == null)                      // If the value is null
            return "null";
        String name = getNameForValue(value);   // Get the name for the value
        if (name != null)                       // If the name is not null
            return name;
        else if (value instanceof String)       // If the value is a String
            return "\"" + value.toString() + "\"";
        else
            return value.toString();
    }
}
