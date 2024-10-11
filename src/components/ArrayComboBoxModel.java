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
 * @param <E> The type of elements to be stored in this list.
 */
public class ArrayComboBoxModel<E> extends ArrayListModel<E> implements 
        MutableComboBoxModel<E>{
    /**
     * This is the currently selected object for this model.
     */
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
            // Add the element to the list
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
            // Get the index of the selected item if a non-null item is selected
        int selIndex = (selected != null) ? indexOf(selected) : -1;
            // Remove the values in the range
        super.removeRange(fromIndex, toIndex);
            // If the selected item was one of the items that were removed
        if (selIndex >= fromIndex && selIndex <= toIndex)
                // Clear the selected item
            setSelectedItem(null);
    }
    @Override
    protected boolean removeIf(Predicate<? super E> filter, int fromIndex, int toIndex){
            // Remove the elements in the given range that match the given 
            // filter
        boolean modified = super.removeIf(filter, fromIndex, toIndex);
            // If the list was modified, the selected item is not null, and the 
            // selected item is no longer in this list
        if (modified && selected != null && !contains(selected))
                // Clear the selected item
            setSelectedItem(null);
        return modified;
    }
    @Override
    protected boolean batchRemove(Collection<?> c, boolean retain, 
            int fromIndex, int toIndex){
            // Remove the elements in the given range that should be removed 
        boolean modified = super.batchRemove(c, retain, fromIndex, toIndex);
            // If the list was modified, the selected item is not null, and the 
            // selected item would not have been retained
        if (modified && selected != null && c.contains(selected) != retain)
                // Clear the selected item
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
            // Set the item in the list at the given index
        E old = super.set(index, element);
            // If the item previously at that index was selected
        if (old == selected)
                // Set the selected item to the new element
            setSelectedItem(element);
        return old;
    }
    @Override
    public void setSelectedItem(Object anItem) {
            // If the currently selected item does not match the given object
        if (!Objects.equals(selected, anItem)){
                // Set the selected item
            selected = anItem;
                // Fire a contents changed event indicating that the selected
                // item has changed
            fireContentsChanged(-1,-1);
        }
    }
    @Override
    public Object getSelectedItem() {
        return selected;
    }
}
