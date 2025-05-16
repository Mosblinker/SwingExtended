/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package components;

import java.util.*;
import javax.swing.*;

/**
 *
 * @author Mosblinker
 */
public class ShortHexSpinnerModel extends SpinnerListModel{
    /**
     * 
     */
    public ShortHexSpinnerModel(){
        super(new HexStringList());
    }
    @Override
    public void setValue(Object elt){
            // If the given value is a String
        if (elt instanceof String)
            elt = ((String) elt).toUpperCase();
        super.setValue(elt);
    }
    /**
     * 
     * @param value
     * @return 
     */
    protected static Integer fromHexString(Object value){
            // If the given value is a String
        if (value instanceof String){
            try{    // Try to get the value of the string
                return Integer.valueOf((String)value,16);
            } catch (NumberFormatException ex) {}
        }
        return null;
    }
    /**
     * 
     * @return 
     */
    public Integer getUnsignedShort(){
        return fromHexString(getValue());
    }
    /**
     * 
     * @return 
     */
    public Short getShort(){
            // Get the value as an integer
        Integer value = getUnsignedShort();
            // If the value is not null, return it as a short.
        return (value != null) ? value.shortValue() : null;
    }
    /**
     * 
     * @param value 
     */
    public void setUnsignedShort(int value){
        setValue(getList().get(value));
    }
    /**
     * 
     * @param value 
     */
    public void setShort(short value){
        setUnsignedShort(Short.toUnsignedInt(value));
    }
    /**
     * 
     */
    protected static class HexStringList extends AbstractList<String>{
        @Override
        public String get(int index) {
                // Check the index
            Objects.checkIndex(index, size());
            return String.format("%04X", index);
        }
        @Override
        public boolean contains(Object o){
                // Try to convert the object into an integer
            Integer value = fromHexString(o);
            return value != null && value >= 0 && value < size();
        }
        @Override
        public int indexOf(Object o){
                // Try to convert the object into an integer
            Integer value = fromHexString(o);
                // If the resulting integer is not null and is within range of 
                // an unsigned short
            if (value != null && value >= 0 && value < size())
                return value;
            return -1;
        }
        @Override
        public int lastIndexOf(Object o){
            return indexOf(o);
        }
        @Override
        public int size() {
            return 1 << Short.SIZE;
        }
    }
}
