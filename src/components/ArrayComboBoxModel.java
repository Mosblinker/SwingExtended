/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package components;

import java.util.*;
import java.util.function.*;
import javax.swing.*;

/**
 *
 * @author Milo Steier
 * @param <E>
 */
public class ArrayComboBoxModel<E> extends ArrayListModel<E> implements 
        MutableComboBoxModel<E>{
    
    private Object selected = null;
    
    public ArrayComboBoxModel(){
        super();
    }
    
    public ArrayComboBoxModel(int initialCapacity){
        super(initialCapacity);
    }
    
    public ArrayComboBoxModel(Collection<? extends E> c){
        super(c);
        if (!isEmpty())
            selected = get(0);
    }
    
    public ArrayComboBoxModel(E[] arr){
        this(Arrays.asList(arr));
    }
    
    @Override
    public void add(int index, E element){
        super.add(index, element);
            // If the list was previously empty, the selected item is not set, 
            // and the element that was added was not null
        if (size() == 1 && selected == null && element != null)
            setSelectedItem(element);
    }
    @Override
    public void addElement(E item) {
        add(item);
    }
    @Override
    public void insertElementAt(E item, int index) {
        add(index,item);
    }
    @Override
    public E remove(int index){
            // Remove the element at the given index
        E value = super.remove(index);
        if (value == selected){     // If the selected item was removed
                // If the list is now empty, set the selected item to null. 
                // Otherwise, select the element before the removed element
            setSelectedItem((isEmpty())?null:get(Math.max(0, index-1)));
        }
        return value;
    }
    @Override
    protected void removeRange(int fromIndex, int toIndex){
        int selIndex = (selected != null) ? indexOf(selected) : -1;
        super.removeRange(fromIndex, toIndex);
        if (selIndex >= fromIndex && selIndex <= toIndex)
            setSelectedItem(null);
    }
    @Override
    protected boolean removeIf(Predicate<? super E> filter, int fromIndex, int toIndex){
        boolean modified = super.removeIf(filter, fromIndex, toIndex);
        if (modified && selected != null && !contains(selected))
            setSelectedItem(null);
        return modified;
    }
    @Override
    protected boolean batchRemove(Collection<?> c, boolean retain, 
            int fromIndex, int toIndex){
        boolean modified = super.batchRemove(c, retain, fromIndex, toIndex);
        if (modified && selected != null && c.contains(selected) != retain)
            setSelectedItem(null);
        return modified;
    }
    @Override
    public void removeElement(Object obj) {
        remove(obj);
    }
    @Override
    public void removeElementAt(int index) {
        remove(index);
    }
    @Override
    public E set(int index, E element){
        E old = super.set(index, element);
        if (old == selected)
            setSelectedItem(element);
        return old;
    }
    @Override
    public void setSelectedItem(Object anItem) {
        if (!Objects.equals(selected, anItem)){
            selected = anItem;
            fireContentsChanged(-1,-1);
        }
    }
    @Override
    public Object getSelectedItem() {
        return selected;
    }
    
}
