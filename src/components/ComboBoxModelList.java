/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package components;

import java.util.*;
import javax.swing.*;

/**
 * This is a List that maps the List interface to the methods of a 
 * ComboBoxModel. The contents of the ComboBoxModelList are derived from its 
 * stored ComboBoxModel, with the {@link #size() size} and {@link #get(int) 
 * get} methods delegated to the {@link ComboBoxModel#getSize() getSize} and 
 * {@link ComboBoxModel#getElementAt(int) getElementAt} methods of the 
 * ComboBoxModel, respectively. The implementation of the {@code add}, {@code 
 * remove}, and {@code set} operations are dependent on whether the stored 
 * ComboBoxModel implements the {@link MutableComboBoxModel} interface, such as 
 * {@link DefaultComboBoxModel}, or the {@link java.util.List List} interface. 
 * If the stored ComboBoxModel does not implement MutableComboBoxModel or List, 
 * then it is assumed that the ComboBoxModel is unmodifiable, and thus the 
 * ComboBoxModelList will also be unmodifiable. Otherwise, modifying the 
 * ComboBoxModelList will also modify the underlying ComboBoxModel. <p>
 * 
 * ComboBoxModelList implements the MutableComboBoxModel interface, so that it 
 * may be used as a ComboBoxModel. When constructed with no ComboBoxModel 
 * provided, the ComboBoxModelList will construct its own DefaultComboBoxModel. 
 * <p>
 * 
 * The iterators returned by this class's {@link #iterator() iterator} and 
 * {@link #listIterator() listIterator} methods are fail-fast, i.e. if the 
 * structure of the list is modified at any time after the iterator is created 
 * in any way other than the iterator's own modifier methods, the iterator will 
 * generally throw a {@link java.util.ConcurrentModificationException 
 * ConcurrentModificationException}, though this is not guaranteed. The iterator 
 * modifier methods are dependent on the list's modifier methods, and thus are 
 * dependent on the underlying ComboBoxModel's modifier methods if present.
 * 
 * @author Milo Steier
 * @param <E> The data type of the elements for the list and JComboBox.
 */
public class ComboBoxModelList<E> extends ListModelList<E> implements MutableComboBoxModel<E>{
    /**
     * This constructs a ComboBoxModelList with the given ComboBoxModel. 
     * @param model The ComboBoxModel that this maps the List methods to (cannot 
     * be null).
     * @throws NullPointerException If the ComboBoxModel is null.
     */
    public ComboBoxModelList(ComboBoxModel<? extends E> model){
        super(model);
    }
    /**
     * This constructs a ComboBoxModelList with a {@link DefaultComboBoxModel 
     * DefaultComboBoxModel}.
     * @see DefaultComboBoxModel#DefaultComboBoxModel() 
     */
    public ComboBoxModelList(){
        this(new DefaultComboBoxModel<>());
    }
    /**
     * This constructs a ComboBoxModelList with a {@link DefaultComboBoxModel 
     * DefaultComboBoxModel} which contains the elements of the specified 
     * collection, in the order they are returned by the collection's iterator.
     * @param c The collection of elements to store in this list.
     * @throws NullPointerException If the collection is null.
     */
    public ComboBoxModelList(Collection<? extends E> c){
        this();
        ComboBoxModelList.this.addAll(c);
        if (!isEmpty())   // If elements were added
            ComboBoxModelList.this.setSelectedItem(get(0));
    }
    /**
     * This constructs a ComboBoxModelList with a {@link DefaultComboBoxModel 
     * DefaultComboBoxModel} which contains the elements of the specified array, 
     * in the order they appear in the array.
     * @param arr The array of elements to store in this list.
     * @throws NullPointerException If the array is null.
     */
    public ComboBoxModelList(E[] arr){
        this(Arrays.asList(Objects.requireNonNull(arr)));
    }
    /**
     * This constructs a ComboBoxModelList with the ComboBoxModel from the given 
     * ComboBoxModelList.
     * @param model The ComboBoxModelList to get the model of.
     * @throws NullPointerException If the ComboBoxModelList is null.
     */
    public ComboBoxModelList(ComboBoxModelList<? extends E> model){
        this(model.extractListModel());
    }
    /**
     * This returns the underlying ComboBoxModel that this ComboBoxModelList 
     * depends on.
     * @return The underlying ComboBoxModel.
     */
    @Override
    public ComboBoxModel<? extends E> getListModel(){
        return (ComboBoxModel<? extends E>) super.getListModel();
    }
    /**
     * This extracts the underlying ComboBoxModel for this ComboBoxModelList. If 
     * the underlying ComboBoxModel is not a ComboBoxModelList, then it is 
     * returned as is, and this is equivalent to calling {@link 
     * #getListModel()}. Otherwise, this extracts the underlying ComboBoxModel 
     * from the stored ComboBoxModelList, returning the first ComboBoxModel that 
     * is not a ComboBoxModelList.
     * @return The underlying ComboBoxModel for this ComboBoxModelList.
     * @see #getListModel() 
     */
    @Override
    protected ComboBoxModel<? extends E> extractListModel(){
        return (ComboBoxModel<? extends E>) super.extractListModel();
    }
    @Override
    protected void add(ListModel<? extends E> model, int index, E element){
        super.add(model, index, element);
            // If the list was previously empty, the selected item is not set, 
            // and the element that was added was not null
        if (size() == 1 && getSelectedItem() == null && element != null)
            setSelectedItem(element);
    }
    /**
     * This appends the specified element to the end of this list. This method 
     * is identical to {@link #add(java.lang.Object) add}, with the exception 
     * that this does not return anything. <p>
     * 
     * Note that not all ComboBoxModels may support adding elements. If the 
     * {@link #getListModel() underlying ComboBoxModel} does not implement 
     * {@link MutableComboBoxModel}, then this will throw an 
     * UnsupportedOperationException.
     * 
     * @param item The element to be appended to this list.
     * @throws UnsupportedOperationException If the underlying ComboBoxModel 
     * does not implement MutableComboBoxModel.
     * @see #add(java.lang.Object) 
     * @see #add(int, java.lang.Object) 
     * @see #insertElementAt(java.lang.Object, int) 
     * @see #getListModel() 
     * @see MutableComboBoxModel#addElement(java.lang.Object) 
     */
    @Override
    public void addElement(E item) {
        super.addElement(item);
    }
    /**
     * This inserts the specified element at the specified index in this list, 
     * shifting the element currently at that index (if any) and any subsequent 
     * elements to the right. This method is identical to {@link 
     * #add(int, java.lang.Object) add}. <p>
     * 
     * Note that not all ComboBoxModels may support inserting elements. If the 
     * {@link #getListModel() underlying ComboBoxModel} does not implement 
     * {@link MutableComboBoxModel}, then this will throw an 
     * UnsupportedOperationException.
     * 
     * @param item The element to be inserted.
     * @param index The index at which the specified element is to be inserted.
     * @throws IndexOutOfBoundsException If the index is out of bounds. {@code 
     * (index < 0 || index > size())}
     * @throws UnsupportedOperationException If the underlying ComboBoxModel 
     * does not implement MutableComboBoxModel.
     * @see #add(java.lang.Object) 
     * @see #add(int, java.lang.Object) 
     * @see #addElement(java.lang.Object) 
     * @see #getListModel() 
     * @see MutableComboBoxModel#insertElementAt(java.lang.Object, int) 
     */
    @Override
    public void insertElementAt(E item, int index) {
        super.insertElementAt(item, index);
    }
    @Override
    protected E remove(ListModel<? extends E> model, int index){
        E obj = super.remove(model, index); // Remove the requested object
        if (obj == getSelectedItem()){      // If the selected item was removed
                // If the list is now empty, set the selected item to null. 
                // Otherwise, get the item before the item that was removed
            setSelectedItem((isEmpty())?null:get(Math.max(0, index-1)));
        }
        return obj;
    }
    /**
     * This removes the first occurrence of the specified element from this 
     * list, if it is present. If this list does not contain the element, then 
     * no change will occur. This method is identical to {@link 
     * #remove(java.lang.Object) remove}, with the exception that this does not 
     * return anything. <p>
     * 
     * Note that not all ComboBoxModels may support removing elements. If the 
     * {@link #getListModel() underlying ComboBoxModel} does not implement 
     * {@link MutableComboBoxModel}, then this will throw an 
     * UnsupportedOperationException.
     * 
     * @param o {@inheritDoc }
     * @throws UnsupportedOperationException If the underlying ComboBoxModel 
     * does not implement MutableComboBoxModel.
     * @see #remove(java.lang.Object) 
     * @see #remove(int) 
     * @see #removeElementAt(int) 
     * @see #getListModel() 
     * @see MutableComboBoxModel#removeElement(java.lang.Object) 
     */
    @Override
    public void removeElement(Object o) {
        super.removeElement(o);
    }
    /**
     * This removes the element at the specified index from this list, shifting 
     * any subsequent elements to the left. This method is identical to {@link 
     * #remove(int) remove}, with the exception that this does not return 
     * anything. <p>
     * 
     * Note that not all ListModels may support removing elements. If the 
     * {@link #getListModel() underlying ListModel} is not one that is known to 
     * support removing elements, then this will throw an 
     * UnsupportedOperationException.
     * 
     * @param index The index of the element to be removed.
     * @throws IndexOutOfBoundsException If the index is out of bounds. {@code 
     * (index < 0 || index >= size())}
     * @throws UnsupportedOperationException If the underlying ComboBoxModel 
     * does not implement MutableComboBoxModel.
     * @see #remove(java.lang.Object) 
     * @see #remove(int) 
     * @see #removeElement(java.lang.Object) 
     * @see #getListModel() 
     * @see MutableComboBoxModel#removeElementAt(int) 
     */
    @Override
    public void removeElementAt(int index) {
        super.removeElementAt(index);
    }
    @Override
    protected void removeRange(ListModel<? extends E> model, int fromIndex, int toIndex){
            // If the range of items to be removed encompasses the entire list
        if (fromIndex <= 0 && toIndex >= size())
            setSelectedItem(null);
        else{
            Object sel = getSelectedItem(); // Get the currently selected item
                // Get the index of the selected item (the actual object, not an 
            int index = -1;                 // equivalent one)
                // A for loop to find the item in the range to be removed
            for (int i = fromIndex; i < toIndex && index < 0; i++){
                if (get(i) == sel)  // If the item was found in the range
                    index = i;
            }
            if (index >= 0){        // If the item is in the range to be removed
                    // If the range starts at the start of the list, get the 
                    // first item not in the range. Otherwise, get the item 
                    // before the range
                setSelectedItem(get((fromIndex==0)?toIndex:(fromIndex-1)));
            }
        }
        super.removeRange(model, fromIndex, toIndex);
    }
    @Override
    public void clear(){
        setSelectedItem(null);
        super.clear();
    }
    /**
     * This sets the selected item. This method delegates to the {@link 
     * ComboBoxModel#setSelectedItem(java.lang.Object) setSelectedItem} method 
     * of the {@link #getListModel() underlying ComboBoxModel}.
     * @param o {@inheritDoc }
     * @see #getSelectedItem() 
     * @see #getListModel() 
     * @see ComboBoxModel#setSelectedItem(java.lang.Object) 
     */
    @Override
    public void setSelectedItem(Object o) {
        getListModel().setSelectedItem(o);
    }
    /**
     * This gets the selected item. This method delegates to the {@link 
     * ComboBoxModel#getSelectedItem() getSelectedItem} method of the {@link 
     * #getListModel() underlying ComboBoxModel}.
     * @return {@inheritDoc }
     * @see #setSelectedItem(java.lang.Object) 
     * @see #getListModel() 
     * @see ComboBoxModel#getSelectedItem() 
     */
    @Override
    public Object getSelectedItem() {
        return getListModel().getSelectedItem();
    }
    /**
     * {@inheritDoc }
     */
    @Override
    protected String unsupportedOperationMsg(String op){
        return "Support for "+op+" operations on the ComboBoxModel is unknown.";
    }
}
