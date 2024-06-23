/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package components;

import java.util.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 * This is a List that maps the List interface to the methods of a ListModel. 
 * The contents of the ListModelList are derived from its stored ListModel, 
 * with the {@link #size() size} and {@link #get(int) get} methods delegated to 
 * the {@link ListModel#getSize() getSize} and {@link 
 * ListModel#getElementAt(int) getElementAt} methods of the ListModel, 
 * respectively. The implementation of the {@code add}, {@code remove}, and 
 * {@code set} operations are dependent on whether the stored ListModel is a 
 * known modifiable implementation of ListModel, such as {@link 
 * DefaultListModel} or {@link MutableComboBoxModel}, or if the ListModel 
 * implements the {@link List} interface. If the stored ListModel is not a known 
 * modifiable implementation, then it is assumed that the ListModel is 
 * unmodifiable, and thus the ListModelList will also be unmodifiable. 
 * Otherwise, modifying the ListModelList will also modify the underlying 
 * ListModel. <p>
 * 
 * ListModelList implements the ListModel interface, so that it may be used as a 
 * ListModel. When constructed with no ListModel provided, the ListModelList 
 * will construct its own DefaultListModel. <p>
 * 
 * The iterators returned by this class's {@link #iterator() iterator} and 
 * {@link #listIterator() listIterator} methods are fail-fast, i.e. if the 
 * structure of the list is modified at any time after the iterator is created 
 * in any way other than the iterator's own modifier methods, the iterator will 
 * generally throw a {@link java.util.ConcurrentModificationException 
 * ConcurrentModificationException}, though this is not guaranteed. The iterator 
 * modifier methods are dependent on the list's modifier methods, and thus are 
 * dependent on the underlying ListModel's modifier methods if present.
 * 
 * @author Milo Steier
 * @param <E> The data type of the elements for the list.
 * @see components.ComboBoxModelList
 */
public class ListModelList <E> extends AbstractList<E> implements List<E>, ListModel<E>{
    /**
     * The underlying ListModel used to store the contents of this list, and is 
     * what this list delegates its methods to.
     */
    private final ListModel<? extends E> model;
    /**
     * The list of EventListeners registered to this model.
     */
    protected EventListenerList listenerList;
    /**
     * This constructs a ListModelList with the given ListModel. 
     * @param model The ListModel that this maps the List methods to (cannot be 
     * null).
     * @throws NullPointerException If the ListModel is null.
     */
    public ListModelList(ListModel<? extends E> model){
        this.model = Objects.requireNonNull(model, "ListModel cannot be null");
        listenerList = new EventListenerList();
        model.addListDataListener(new Handler());
    }
    /**
     * This constructs a ListModelList with a {@link DefaultListModel 
     * DefaultListModel}.
     * @see DefaultListModel#DefaultListModel() 
     */
    public ListModelList(){
        this(new DefaultListModel<>());
    }
    /**
     * This constructs a ListModelList with a {@link DefaultListModel 
     * DefaultListModel} which contains the elements of the specified 
     * collection, in the order they are returned by the collection's iterator.
     * @param c The collection of elements to store in this list.
     * @throws NullPointerException If the collection is null.
     */
    public ListModelList(Collection<? extends E> c){
        this();
        ListModelList.this.addAll(c);
    }
    /**
     * This constructs a ListModelList with a {@link DefaultListModel 
     * DefaultListModel} which contains the elements of the specified array, in 
     * the order they appear in the array.
     * @param arr The array of elements to store in this list.
     * @throws NullPointerException If the array is null.
     */
    public ListModelList(E[] arr){
        this(Arrays.asList(Objects.requireNonNull(arr)));
    }
    /**
     * This constructs a ListModelList with the ListModel from the given 
     * ListModelList.
     * @param model The ListModelList to get the model of.
     * @throws NullPointerException If the ListModelList is null.
     */
    public ListModelList(ListModelList<? extends E> model){
        this(model.extractListModel());
    }
    /**
     * This returns the underlying ListModel that this ListModelList depends on.
     * @return The underlying ListModel.
     */
    public ListModel<? extends E> getListModel(){
        return model;
    }
    /**
     * This extracts the underlying ListModel for this ListModelList. If the 
     * underlying ListModel is not a ListModelList, then it is returned as 
     * is, and this is equivalent to calling {@link #getListModel()}. Otherwise, 
     * this extracts the underlying ListModel from the stored ListModelList, 
     * returning the first ListModel that is not a ListModelList.
     * @return The underlying ListModel for this ListModelList.
     * @see #getListModel() 
     */
    @SuppressWarnings("unchecked")
    protected ListModel<? extends E> extractListModel(){
        ListModel<? extends E> temp = this.model;   // The model to return
            // While the model is a ListModelList
        while (temp instanceof ListModelList)
            temp = ((ListModelList<? extends E>)temp).model;
        return temp;
    }
    /**
     * This returns the number of elements in this list. This method is 
     * identical to {@link #size() size}.
     * @return The number of elements in this list.
     * @see #size() 
     */
    @Override
    public int getSize() {
        return size();
    }
    /**
     * This returns the element at the specified index in this list. This method 
     * is identical to {@link #get(int) get}, which is the preferred method to 
     * use.
     * @param index The index of the element to return.
     * @return The element at the specified index in this list.
     * @throws IndexOutOfBoundsException If the index is out of bounds. {@code 
     * (index < 0 || index >= size())}
     * @see #get(int) 
     */
    @Override
    public E getElementAt(int index) {
        return get(index);
    }
    /**
     * This adds a {@code ListDataListener} to this ListModelList that will be 
     * notified when the structure of this list is modified.
     * @param l {@inheritDoc }
     * @see #removeListDataListener(ListDataListener) 
     * @see #getListDataListeners() 
     */
    @Override
    public void addListDataListener(ListDataListener l) {
        if (l != null)  // If the listener is not null
            listenerList.add(ListDataListener.class, l);
    }
    /**
     * This removes a {@code ListDataListener} from this ListModelList.
     * @param l {@inheritDoc }
     * @see #addListDataListener(ListDataListener) 
     * @see #getListDataListeners() 
     */
    @Override
    public void removeListDataListener(ListDataListener l) {
        listenerList.remove(ListDataListener.class, l);
    }
    /**
     * This returns an array of all the {@code ListDataListener}s that have been 
     * registered to this ListModelList.
     * @return An array containing the {@code ListDataListener}s that have been 
     * added, or an empty array if no listeners have been added.
     * @see #addListDataListener(ListDataListener) 
     * @see #removeListDataListener(ListDataListener) 
     */
    public ListDataListener[] getListDataListeners(){
        return listenerList.getListeners(ListDataListener.class);
    }
    /**
     * This returns an array of all the objects currently registered as 
     * <code><em>Foo</em>Listener</code>s on this model. 
     * <code><em>Foo</em>Listener</code>s are registered via the 
     * <code>add<em>Foo</em>Listener</code> method. <p>
     * 
     * The listener type can be specified using a class literal, such as 
     * <code><em>Foo</em>Listener.class</code>. If no such listeners exist, 
     * then an empty array will be returned.
     * @param <T> The type of {@code EventListener} being requested.
     * @param listenerType The type of listeners being requested. This should 
     * be an interface that descends from {@code EventListener}.
     * @return An array of the objects registered as the given listener type on 
     * this model, or an empty array if no such listeners have been added.
     * @see #getListDataListeners() 
     */
    public <T extends EventListener> T[] getListeners(Class<T> listenerType){
        return listenerList.getListeners(listenerType);
    }
    /**
     * This fires a ListDataEvent of the given type over the interval between 
     * {@code index0} and {@code index1}, inclusive. Note that {@code index0} 
     * does not need to be less than or equal to {@code index1}.
     * @param type The type of event to be fired. 
     * @param index0 One end of the interval.
     * @param index1 The other end of the interval.
     * @see #getListDataListeners() 
     * @see ListDataEvent
     * @see ListDataListener
     * @see #fireContentsChanged(int, int) 
     * @see #fireIntervalAdded(int, int) 
     * @see #fireIntervalRemoved(int, int) 
     */
    protected void fireListDataEvent(int type, int index0, int index1){
            // This creates the event to be fired.
        ListDataEvent evt = new ListDataEvent(this,type,index0,index1);
            // Go through the ListDataListeners
        for (ListDataListener l : listenerList.getListeners(ListDataListener.class)){
            if (l != null){     // If the current listener is not null
                switch(type){
                    case(ListDataEvent.INTERVAL_ADDED):     // If an interval was added
                        l.intervalAdded(evt);
                        break;
                    case(ListDataEvent.INTERVAL_REMOVED):   // If an interval was removed
                        l.intervalRemoved(evt);
                        break;
                    case(ListDataEvent.CONTENTS_CHANGED):   // If the contents changed
                        l.contentsChanged(evt);
                }
            }
        }
    }
    /**
     * This fires a ListDataEvent informing the listeners that the contents of 
     * the model have changed within the interval between {@code index0} and 
     * {@code index1}, inclusive. Note that {@code index0} does not need to be 
     * less than or equal to {@code index1}. This effectively calls {@link 
     * #fireListDataEvent fireListDataEvent} with the given interval and with 
     * {@link ListDataEvent#CONTENTS_CHANGED CONTENTS_CHANGED} as the {@code 
     * type} of event.
     * @param index0 One end of the interval.
     * @param index1 The other end of the interval.
     * @see #getListDataListeners() 
     * @see ListDataEvent
     * @see ListDataListener
     * @see #fireListDataEvent(int, int, int) 
     * @see #fireIntervalAdded(int, int) 
     * @see #fireIntervalRemoved(int, int) 
     * @see ListDataEvent#CONTENTS_CHANGED
     */
    protected void fireContentsChanged(int index0, int index1){
        fireListDataEvent(ListDataEvent.CONTENTS_CHANGED,index0,index1);
    }
    /**
     * This fires a ListDataEvent informing the listeners that elements have 
     * been added to the model within the interval between {@code index0} and 
     * {@code index1}, inclusive. Note that {@code index0} does not need to be 
     * less than or equal to {@code index1}. This effectively calls {@link 
     * #fireListDataEvent fireListDataEvent} with the given interval and with 
     * {@link ListDataEvent#INTERVAL_ADDED INTERVAL_ADDED} as the {@code type} 
     * of event.
     * @param index0 One end of the interval.
     * @param index1 The other end of the interval.
     * @see #getListDataListeners() 
     * @see ListDataEvent
     * @see ListDataListener
     * @see #fireListDataEvent(int, int, int) 
     * @see #fireContentsChanged(int, int) 
     * @see #fireIntervalRemoved(int, int) 
     * @see ListDataEvent#INTERVAL_ADDED
     */
    protected void fireIntervalAdded(int index0, int index1){
        fireListDataEvent(ListDataEvent.INTERVAL_ADDED,index0,index1);
    }
    /**
     * This fires a ListDataEvent informing the listeners that elements have 
     * been removed from the model that use to be within the interval between 
     * {@code index0} and {@code index1}, inclusive. Note that {@code index0} 
     * does not need to be less than or equal to {@code index1}. This 
     * effectively calls {@link #fireListDataEvent fireListDataEvent} with the 
     * given interval and with {@link ListDataEvent#INTERVAL_REMOVED 
     * INTERVAL_REMOVED} as the {@code type} of event.
     * @param index0 One end of the interval.
     * @param index1 The other end of the interval.
     * @see #getListDataListeners() 
     * @see ListDataEvent
     * @see ListDataListener
     * @see #fireListDataEvent(int, int, int) 
     * @see #fireContentsChanged(int, int) 
     * @see #fireIntervalAdded(int, int) 
     * @see ListDataEvent#INTERVAL_REMOVED
     */
    protected void fireIntervalRemoved(int index0, int index1){
        fireListDataEvent(ListDataEvent.INTERVAL_REMOVED,index0,index1);
    }
    /**
     * This checks to see if the given index is valid, and if not, this will 
     * throw an IndexOutOfBoundsException. The index is valid if the index is 
     * greater than or equal to zero, and the index is less than the size of 
     * this list. If the {@code add} parameter is true, then the index will 
     * also be valid if it is equal to the size of this list.
     * @param index The index to check.
     * @param add If an element is being added.
     * @throws IndexOutOfBoundsException If the index is not valid, and thus out 
     * of bounds.
     */
    private void checkIndex(int index, boolean add){
            // If the index is negative, greater than the size, or an element 
            // is not being added and the index is equal to the size
        if (index < 0 || index > size() || (!add && index == size()))
            throw new IndexOutOfBoundsException("Index out of bounds: "+index + 
                    " (Size: " + size() + ")");
    }
    /**
     * This checks to see if the given index is valid, and if not, this will 
     * throw an IndexOutOfBoundsException. The index is valid if the index is 
     * greater than or equal to zero, and the index is less than the size of 
     * this list.
     * @param index The index to check.
     * @throws IndexOutOfBoundsException If the index is not valid, and thus out 
     * of bounds.
     */
    private void checkIndex(int index){
        checkIndex(index,false);
    }
    /**
     * This checks to see if the {@code fromIndex} and {@code toIndex} are 
     * within range. The indexes are in range if they are within bounds and the 
     * {@code fromIndex} is less than or equal to the {@code toIndex}. If the 
     * range is out of bounds, then this will throw an 
     * IndexOutOfBoundsException.
     * @param fromIndex The index to start at.
     * @param toIndex The index to stop at, exclusive.
     * @throws IndexOutOfBoundsException If the range is out of bounds.
     */
    private void checkRange(int fromIndex, int toIndex){
        if (fromIndex < 0)          // If the start index is negative
            throw new IndexOutOfBoundsException("From Index out of bounds: " + 
                    fromIndex + " < 0");
        else if (toIndex > size())  // If the end index is greater than the size
            throw new IndexOutOfBoundsException("To Index out of bounds: " + 
                    toIndex + " > " + size());
            // If the start index is greater than the stop index
        else if (fromIndex > toIndex)   
            throw new IndexOutOfBoundsException("From Index > To Index: "+
                    fromIndex+" > "+toIndex);
    }
    /**
     * This returns the element at the specified index in this list. This method 
     * delegates to the {@link ListModel#getElementAt(int) getElementAt} method 
     * of the {@link #getListModel() underlying ListModel}.
     * @param index The index of the element to return.
     * @return The element at the specified index in this list.
     * @throws IndexOutOfBoundsException If the index is out of bounds. {@code 
     * (index < 0 || index >= size())}
     * @see ListModel#getElementAt(int) 
     * @see #getListModel() 
     */
    @Override
    public E get(int index) {
        checkIndex(index);
        return model.getElementAt(index);
    }
    /**
     * This returns the number of elements in this list. This method delegates 
     * to the {@link ListModel#getSize() getSize} method of the {@link 
     * #getListModel() underlying ListModel}.
     * @return The number of elements in this list.
     * @see ListModel#getSize() 
     * @see #getListModel() 
     */
    @Override
    public int size() {
        return model.getSize();
    }
    /**
     * This returns the string to use as the message for throwing unsupported 
     * operation exceptions. The string returned states that it is unknown if 
     * the underlying ListModel supports the given operation(s).
     * @param op The operation(s) that are (assumed to be) unsupported.
     * @return The message for the unsupported operation exception.
     */
    protected String unsupportedOperationMsg(String op){
        return "Support for "+op+" operations on the ListModel is unknown.";
    }
    /**
     * This method attempts to insert the given element into the ListModel at 
     * the given index. It is assumed that the given index is within range, and 
     * that the given ListModel is the {@link #extractListModel() extracted} 
     * underlying model for this ListModelList. If the model is not one that is 
     * known to support the add operation, then this throws an 
     * UnsupportedOperationException. <p>
     * 
     * The {@link #add(int, Object) add} method delegates the task of inserting 
     * elements to this method after range checking the index and extracting the 
     * ListModel. The {@link #addAll(ListModel, int, Collection) addAll} method 
     * also delegates the task of inserting the elements in its specified 
     * collection one by one if the ListModel is neither a {@link 
     * DefaultListModel}, a {@link DefaultComboBoxModel}, or a {@link List}.
     * 
     * @implSpec 
     * The default implementation only acknowledges {@link DefaultListModel 
     * DefaultListModels}, {@link MutableComboBoxModel MutableComboBoxModels}, 
     * and {@link List Lists} as being able to have elements inserted via their 
     * {@link DefaultListModel#add(int, Object) add}, {@link 
     * MutableComboBoxModel#insertElementAt(Object, int) insertElementAt}, and
     * {@link List#add(int, Object) add} methods respectively. 
     * 
     * @param model The underlying ListModel.
     * @param index The index to insert the element at (assumed to be between 
     * 0 and size(), inclusive).
     * @param element The element to insert into the model.
     * @throws UnsupportedOperationException If support for adding elements to 
     * the model is unknown.
     * @throws 
     * @see #add(int, Object) 
     * @see #extractListModel() 
     * @see DefaultListModel#add(int, Object) 
     * @see MutableComboBoxModel#insertElementAt(Object, int) 
     * @see List#add(int, Object) 
     */
    @SuppressWarnings("unchecked")
    protected void add(ListModel<? extends E> model, int index, E element){
        if (model instanceof List)     // If the model is a List
            ((List)model).add(index, element);
            // If the model is a DefaultListModel
        else if (model instanceof DefaultListModel)
            ((DefaultListModel)model).add(index, element);
            // If the model is a MutableComboBoxModel
        else if (model instanceof MutableComboBoxModel)
            ((MutableComboBoxModel)model).insertElementAt(element, index);
        else 
            throw new UnsupportedOperationException(unsupportedOperationMsg("add"));
    }
    /**
     * This inserts the specified element at the specified index in this list, 
     * shifting the element currently at that index (if any) and any subsequent 
     * elements to the right. <p>
     * 
     * Note that not all ListModels may support inserting elements. If the 
     * {@link #getListModel() underlying ListModel} is not one that is known to 
     * support inserting elements, then this will throw an 
     * UnsupportedOperationException.
     * 
     * @param index The index at which the specified element is to be inserted.
     * @param element The element to be inserted.
     * @throws IndexOutOfBoundsException If the index is out of bounds. {@code 
     * (index < 0 || index > size())}
     * @throws UnsupportedOperationException If the underlying ListModel is not 
     * known to support insertion operations.
     * @throws ClassCastException {@inheritDoc}
     * @throws NullPointerException {@inheritDoc}
     * @throws IllegalArgumentException {@inheritDoc}
     * @see #add(Object) 
     * @see #getListModel() 
     * @see DefaultListModel#add(int, Object) 
     * @see MutableComboBoxModel#insertElementAt(Object, int) 
     */
    @Override
    public void add(int index, E element){
        checkIndex(index,true);
        add(extractListModel(),index,element);
        modCount++;     // Increment the modification count
    }
    /**
     * This inserts the specified element at the specified index in this list, 
     * shifting the element currently at that index (if any) and any subsequent 
     * elements to the right. This method is identical to {@link 
     * #add(int, Object) add}. <p>
     * 
     * Note that not all ListModels may support inserting elements. If the 
     * {@link #getListModel() underlying ListModel} is not one that is known to 
     * support inserting elements, then this will throw an 
     * UnsupportedOperationException.
     * 
     * @param element The element to be inserted.
     * @param index The index at which the specified element is to be inserted.
     * @throws IndexOutOfBoundsException If the index is out of bounds. {@code 
     * (index < 0 || index > size())}
     * @throws UnsupportedOperationException If the underlying ListModel is not 
     * known to support insertion operations.
     * @see #add(Object) 
     * @see #add(int, Object) 
     * @see #addElement(Object) 
     * @see #getListModel() 
     * @see DefaultListModel#add(int, Object) 
     * @see MutableComboBoxModel#insertElementAt(Object, int) 
     */
    public void insertElementAt(E element, int index) {
        add(index,element);
    }
    /**
     * This appends the specified element to the end of this list. <p>
     * 
     * Note that not all ListModels may support adding elements. If the {@link 
     * #getListModel() underlying ListModel} is not one that is known to support 
     * adding elements, then this will throw an UnsupportedOperationException.
     * 
     * @param e The element to be appended to this list.
     * @return {@inheritDoc }
     * @throws UnsupportedOperationException If the underlying ListModel is not 
     * known to support add operations.
     * @see #add(int, Object) 
     * @see #getListModel() 
     * @see DefaultListModel#addElement(Object) 
     * @see MutableComboBoxModel#addElement(Object) 
     */
    @Override
    public boolean add(E e){
        return super.add(e);
    }
    /**
     * This appends the specified element to the end of this list. This method 
     * is identical to {@link #add(Object) add}, with the exception that this 
     * does not return anything. <p>
     * 
     * Note that not all ListModels may support adding elements. If the {@link 
     * #getListModel() underlying ListModel} is not one that is known to support 
     * adding elements, then this will throw an UnsupportedOperationException.
     * 
     * @param item The element to be appended to this list.
     * @throws UnsupportedOperationException If the underlying ListModel is not 
     * known to support add operations.
     * @throws UnsupportedOperationException If the underlying ListModel is not 
     * known to support add operations.
     * @see #add(Object) 
     * @see #add(int, Object)
     * @see #insertElementAt(Object, int) 
     * @see #getListModel() 
     * @see DefaultListModel#addElement(Object) 
     * @see MutableComboBoxModel#addElement(Object) 
     */
    public void addElement(E item) {
        add(item);
    }
    /**
     * This method attempts to insert the elements from the given collection 
     * into the ListModel starting at the given index. It is assumed that the 
     * given index is within range, the given collection is non-null, and that 
     * the given ListModel is the {@link #extractListModel() extracted} 
     * underlying model for this ListModelList. If the model is not one that is 
     * known to support the add operation, then this throws an 
     * UnsupportedOperationException if the given collection is nonempty. <p>
     * 
     * The {@link #addAll(int, Collection) addAll} method delegates the task of 
     * inserting the elements to this method after range checking the index, 
     * extracting the ListModel, and checking whether the collection is null.
     * 
     * @implSpec
     * The default implementation only acknowledges {@link DefaultListModel 
     * DefaultListModels}, {@link DefaultComboBoxModel DefaultComboBoxModels}, 
     * and {@link List Lists} as being able to have a collection of elements 
     * inserted via their {@link DefaultListModel#addAll(int, Collection) 
     * addAll}, {@link DefaultComboBoxModel#addAll(int, Collection) addAll}, and 
     * {@link List#addAll(int, Collection) addAll} methods respectively. If the 
     * ListModel is neither a DefaultListModel, a DefaultComboBoxModel, or a 
     * List, then this resorts to iterating through the given collection, and 
     * {@link #add(ListModel, int, Object) adding} the elements one by one.
     * 
     * @todo Look into modifying how ListDataEvents are fired, so as to 
     * concatenate the events fired when adding elements one by one into a 
     * single INTERVAL_ADDED event covering the entire range instead of 
     * individual events covering each element separately.
     * 
     * @param model The underlying ListModel.
     * @param index The index to insert the element at (assumed to be between 
     * 0 and size(), inclusive).
     * @param c The collection of elements to insert (assumed to be non-null).
     * @return Whether the list changed as a result of this method.
     * @throws UnsupportedOperationException If the underlying ListModel is not 
     * known to support insertion operations.
     * @see #addAll(int, Collection) 
     * @see #addAll(Collection) 
     * @see #add(ListModel, int, Object) 
     * @see #extractListModel() 
     * @see DefaultListModel#addAll(int, Collection) 
     * @see DefaultComboBoxModel#addAll(int, Collection) 
     * @see List#addAll(int, Collection) 
     */
    @SuppressWarnings("unchecked")
    protected boolean addAll(ListModel<? extends E> model, int index, 
            Collection<? extends E> c){
        if (model instanceof List)      // If the model is a List
            return ((List)model).addAll(index, c);
            // The easiest way to detect whether elements were added to the list
            // is by checking to see if the size increased (also for some reason 
            // DefaultListModel and DefaultComboBoxModel don't return whether 
            // there was a change).
        int oldSize = size();
            // If the model is a DefaultListModel
        if (model instanceof DefaultListModel)
            ((DefaultListModel)model).addAll(index, c);
            // If the model is a DefaultComboBoxModel
        else if (model instanceof DefaultComboBoxModel)
            ((DefaultComboBoxModel)model).addAll(index, c);
        else{
                // Decrement the mod count since we're resorting to invoking add
            modCount--;     // to add each element from the collection
            for (E e : c)   // Go through the given collection
                add(model,index++,e);
        }
        return size() != oldSize;
    }
    /**
     * This inserts all of the elements in the specified collection into this 
     * list, starting at the specified index, shifting the element currently at 
     * that index (if any) and any subsequent elements to the right. The 
     * elements will be inserted in the order that they are returned by the 
     * specified collection's iterator. Modifying the specified collection while 
     * this operation is in progress could result in undefined behavior. This 
     * implies that the behavior of this operation is undefined if the specified 
     * collection is this list and this list is nonempty. <p>
     * 
     * Note that not all ListModels may support inserting elements. If the 
     * {@link #getListModel() underlying ListModel} is not one that is known to 
     * support inserting elements, then this will throw an 
     * UnsupportedOperationException if the specified collection is nonempty.
     * 
     * @param index The index at which to insert the first element of the 
     * specified collection.
     * @param c The collection of elements to be added to this list.
     * @return {@inheritDoc }
     * @throws IndexOutOfBoundsException If the index is out of bounds. {@code 
     * (index < 0 || index > size())}
     * @throws NullPointerException If the specified collection is null.
     * @throws UnsupportedOperationException If the underlying ListModel is not 
     * known to support insertion operations.
     * @see #add(int, Object) 
     * @see #getListModel() 
     * @see DefaultListModel#addAll(int, Collection) 
     * @see DefaultComboBoxModel#addAll(int, Collection) 
     */
    @Override
    public boolean addAll(int index, Collection<? extends E> c){
        checkIndex(index,true);
        modCount++;     // Increment the modification count
        return addAll(extractListModel(),index,Objects.requireNonNull(c));
    }
    /**
     * This appends all the elements in the specified collection to the end of 
     * this list, in the order that they are returned by the specified 
     * collection's iterator. Modifying the specified collection while this 
     * operation is in progress could result in undefined behavior. This implies 
     * that the behavior of this operation is undefined if the specified 
     * collection is this list and this list is nonempty. <p>
     * 
     * Note that not all ListModels may support adding elements. If the {@link 
     * #getListModel() underlying ListModel} is not one that is known to support 
     * adding elements, then this will throw an UnsupportedOperationException 
     * if the specified collection is nonempty.
     * 
     * @param c The collection of elements to be added to this list.
     * @return {@inheritDoc }
     * @throws NullPointerException If the specified collection is null.
     * @throws UnsupportedOperationException If the underlying ListModel is not 
     * known to support add operations.
     * @see #add(Object) 
     * @see #getListModel() 
     * @see DefaultListModel#addAll(Collection) 
     * @see DefaultComboBoxModel#addAll(Collection) 
     */
    @Override
    public boolean addAll(Collection<? extends E> c){
        return addAll(size(),c);
    }
    /**
     * This method attempts to remove the element at the given index from the 
     * ListModel. It is assumed that the given index is within range, and that 
     * the given ListModel is the {@link #extractListModel() extracted} 
     * underlying model for this ListModelList. If the model is not one that is 
     * known to support the remove operation, then this throws an 
     * UnsupportedOperationException. <p>
     * 
     * The {@link #remove(int) remove} method delegates the task of removing 
     * elements to this method after range checking the index and extracting the 
     * ListModel. The {@link #removeRange(ListModel, int, int) removeRange} 
     * method also delegates the task of removing the elements in its specified 
     * range one by one if the model is not a {@link DefaultListModel}. The 
     * other {@link #remove(ListModel, Object) remove} method (the one that 
     * takes in an object) also delegates the task of removing the element after 
     * finding the index if the model is neither a DefaultListModel, a {@link 
     * MutableComboBoxModel}, or a {@link List}.
     * 
     * @implSpec
     * The default implementation only acknowledges {@link DefaultListModel 
     * DefaultListModels}, {@link MutableComboBoxModel MutableComboBoxModels}, 
     * and {@link List Lists} as being able to have elements removed via their 
     * {@link DefaultListModel#remove(int) remove}, {@link 
     * MutableComboBoxModel#removeElementAt(int) removeElementAt}, and {@link 
     * List#remove(int) remove} methods respectively. 
     * 
     * @param model The underlying ListModel.
     * @param index The index of the element to remove (assumed to be between 0 
     * and size(), exclusive).
     * @return The element previously stored at the specified index.
     * @throws UnsupportedOperationException If support for removing elements 
     * from the model is unknown.
     * @see #remove(int) 
     * @see #removeRange(ListModel, int, int) 
     * @see #remove(ListModel, Object) 
     * @see #extractListModel() 
     * @see DefaultListModel#remove(int) 
     * @see MutableComboBoxModel#removeElementAt(int) 
     * @see List#remove(int) 
     */
    @SuppressWarnings("unchecked")
    protected E remove(ListModel<? extends E> model, int index){
        if (model instanceof List)      // If the model is a List
            return ((List<? extends E>)model).remove(index);
            // If the model is a DefaultListModel
        else if (model instanceof DefaultListModel)
            return ((DefaultListModel<? extends E>)model).remove(index);
            // If the model is a MutableComboBoxModel
        else if (model instanceof MutableComboBoxModel){
                // Since the removeElementAt does not return the element 
                // removed, this stores the element before it is removed
            E value = get(index);
            ((MutableComboBoxModel)model).removeElementAt(index);
            return value;
        }
        else 
            throw new UnsupportedOperationException(unsupportedOperationMsg("remove"));
    }
    /**
     * This removes the element at the specified index from this list, shifting 
     * any subsequent elements to the left. <p>
     * 
     * Note that not all ListModels may support removing elements. If the 
     * {@link #getListModel() underlying ListModel} is not one that is known to 
     * support removing elements, then this will throw an 
     * UnsupportedOperationException.
     * 
     * @param index The index of the element to be removed.
     * @return The element previously stored at the specified index.
     * @throws IndexOutOfBoundsException If the index is out of bounds. {@code 
     * (index < 0 || index >= size())}
     * @throws UnsupportedOperationException If the underlying ListModel is not 
     * known to support removal operations.
     * @see #remove(Object) 
     * @see #getListModel() 
     * @see DefaultListModel#remove(int) 
     * @see MutableComboBoxModel#removeElementAt(int) 
     */
    @Override
    public E remove(int index) {
        checkIndex(index);
            // Get the value that was removed
        E value = remove(extractListModel(),index);
        modCount++;     // Increment the modification count
        return value;
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
     * @throws UnsupportedOperationException If the underlying ListModel is not 
     * known to support removal operations.
     * @see #remove(int) 
     * @see #remove(Object) 
     * @see #removeElement(Object) 
     * @see #getListModel() 
     * @see DefaultListModel#remove(int) 
     * @see MutableComboBoxModel#removeElementAt(int) 
     */
    public void removeElementAt(int index) {
        remove(index);
    }
    /**
     * This method attempts to remove the given element from the ListModel. It 
     * is assumed that the given ListModel is the {@link #extractListModel() 
     * extracted} underlying model for this ListModelList. If the model is not 
     * one that is known to support the remove operation, then this throws 
     * an UnsupportedOperationException. <p>
     * 
     * The {@link #remove(Object) remove} method delegates the task of removing 
     * elements to this method after extracting the ListModel.
     * 
     * @implSpec
     * The default implementation only acknowledges {@link DefaultListModel 
     * DefaultListModels}, {@link MutableComboBoxModel MutableComboBoxModels}, 
     * and {@link List Lists} as being able to have elements removed via their 
     * {@link DefaultListModel#removeElement(Object) removeElement}, {@link 
     * MutableComboBoxModel#removeElement(Object) removeElement}, and {@link 
     * List#remove(Object) remove} methods respectively. If the ListModel is 
     * neither a DefaultListModel, a MutableComboBoxModel, or a List, then this 
     * resorts to finding the {@link #indexOf(ListModel, Object) index of} the 
     * first instance of the given object, and if found, passes the index to 
     * {@link #remove(ListModel, int) remove}.
     * 
     * @param model The underlying ListModel.
     * @param o The object to be removed, if present.
     * @return True if this list contained the specified element.
     * @throws UnsupportedOperationException If support for removing elements 
     * from the model is unknown.
     * @see #remove(Object) 
     * @see #remove(ListModel, int) 
     * @see #indexOf(ListModel, Object) 
     * @see #extractListModel() 
     * @see DefaultListModel#removeElement(Object) 
     * @see MutableComboBoxModel#removeElement(Object) 
     * @see List#remove(Object) 
     */
    protected boolean remove(ListModel<? extends E> model, Object o){
        if (model instanceof List)      // If the model is a List
            return ((List)model).remove(o);
            // If the model is a DefaultListModel
        else if (model instanceof DefaultListModel)
            return ((DefaultListModel)model).removeElement(o);
            // If the model is a MutableComboBoxModel
        else if (model instanceof MutableComboBoxModel){
                // Since the remove method of MutableComboBoxModel does not 
                // return whether the element was originally in the model, it 
                // will need to be checked for externally, and since the size 
                // should decrease if an element is removed, this stores the 
                // size of the list before attempting to remove the element
            int oldSize = size();
            ((MutableComboBoxModel)model).removeElement(o);
            return size() != oldSize;
        }
            // Get the index of the element in the list
        int index = indexOf(model,o);
        if (index >= 0) // If the element is in the list
            remove(model,index);
        return index >= 0;
    }
    /**
     * This removes the first occurrence of the specified element from this 
     * list, if it is present. If this list does not contain the element, then 
     * no change will occur.<p>
     * 
     * Note that not all ListModels may support removing elements. If the {@link 
     * #getListModel() underlying ListModel} is not one that is known to support 
     * removing elements, then this will throw an UnsupportedOperationException.
     * 
     * @param o The object to be removed, if present.
     * @return {@inheritDoc }
     * @throws UnsupportedOperationException If the underlying ListModel is not 
     * known to support removal operations.
     * @see #remove(int) 
     * @see #getListModel() 
     * @see DefaultListModel#removeElement(Object) 
     * @see MutableComboBoxModel#removeElement(Object) 
     */
    @Override
    public boolean remove(Object o){
            // This gets whether an element was removed
        boolean removed = remove(extractListModel(),o);
        if (removed)    // If an element was removed
            modCount++; // Increment the modification count
        return removed;
    }
    /**
     * This removes the first occurrence of the specified element from this 
     * list, if it is present. If this list does not contain the element, then 
     * no change will occur. This method is identical to {@link 
     * #remove(Object) remove}, with the exception that this does not return 
     * anything. <p>
     * 
     * Note that not all ListModels may support removing elements. If the {@link 
     * #getListModel() underlying ListModel} is not one that is known to support 
     * removing elements, then this will throw an UnsupportedOperationException.
     * 
     * @param o The object to be removed, if present.
     * @throws UnsupportedOperationException If the underlying ListModel is not 
     * known to support removal operations.
     * @see #remove(Object) 
     * @see #remove(int) 
     * @see #removeElementAt(int) 
     * @see #getListModel() 
     * @see DefaultListModel#removeElement(Object) 
     * @see MutableComboBoxModel#removeElement(Object) 
     */
    public void removeElement(Object o) {
        remove(o);
    }
    /**
     * This attempts to remove all the elements whose index is between {@code 
     * fromIndex} and {@code toIndex}, exclusive, from the ListModel. It is 
     * assumed that the range is within bounds, and that the given ListModel is 
     * the {@link #extractListModel() extracted} underlying model for this 
     * ListModelList. If the model is not one that is known to support the 
     * remove operation, then this throws an UnsupportedOperationException. <p>
     * 
     * The {@link #removeRange(int, int) removeRange} method delegates the task 
     * of removing the elements in the specified range to this method after 
     * range checking the {@code fromIndex} and {@code toIndex} and extracting 
     * the ListModel.
     * 
     * @implSpec
     * The default implementation only acknowledges {@link DefaultListModel 
     * DefaultListModels} as being able to have a range of elements removed via 
     * their {@link DefaultListModel#removeRange removeRange} method. If the 
     * {@code ListModel} is not a {@code DefaultListModel} but does implement 
     * the {@code List} interface, then this creates a {@link List#subList 
     * sublist} of the model and invokes the {@code clear()} method on the 
     * sublist. If the ListModel is not a DefaultListModel or a List, then this 
     * resorts to iterating through the indexes in the range backwards and 
     * removing each element one by one via the {@link #remove(ListModel, int) 
     * remove} method.
     * 
     * @todo Look into modifying how ListDataEvents are fired, so as to 
     * concatenate the events fired when removing elements one by one into a 
     * single INTERVAL_REMOVED event covering the entire range instead of 
     * individual events covering each element separately.
     * 
     * @param model The underlying ListModel.
     * @param fromIndex The index to of the first element to be removed.
     * @param toIndex The index after the last element to be removed.
     * @throws UnsupportedOperationException If support for removing elements 
     * from the model is unknown.
     * @see #removeRange(int, int) 
     * @see #remove(int) 
     * @see #extractListModel() 
     * @see DefaultListModel#removeRange(int, int) 
     */
    protected void removeRange(ListModel<? extends E> model, int fromIndex, int toIndex){
            // If the model is a DefaultListModel
        if (model instanceof DefaultListModel)
                // For whatever reason, removeRange on DefaultListModels is 
                // inclusive of the toIndex
            ((DefaultListModel)model).removeRange(fromIndex, toIndex-1);
            // If the model is a List
        else if (model instanceof List)
            ((List)model).subList(fromIndex, toIndex).clear();
        else{
                // Decrement the mod count since we're resorting to removing the
            modCount--;     // elements manually
                // A for loop to go through the range backwards
            for (int i = toIndex - 1; i >= fromIndex; i--)
                remove(model,i);
        }
    }
    /**
     * This removes all of the elements whose index is between {@code fromIndex} 
     * and {@code toIndex}, exclusive, from this list, shifting any succeeding 
     * elements to the left. <p>
     * 
     * Note that not all ListModels may support removing elements. If the {@link 
     * #getListModel() underlying ListModel} is not one that is known to support 
     * removing elements, then this will throw an UnsupportedOperationException. 
     * 
     * @param fromIndex {@inheritDoc }
     * @param toIndex {@inheritDoc }
     * @throws IndexOutOfBoundsException If either the {@code fromIndex} or the 
     * {@code toIndex} are out of range or the {@code fromIndex} is greater than 
     * the {@code toIndex}.
     * @throws UnsupportedOperationException If the underlying ListModel is not 
     * known to support removal operations.
     * @see #remove(int) 
     * @see DefaultListModel#removeRange(int, int) 
     * @see #clear() 
     * @see #getListModel() 
     */
    @Override
    public void removeRange(int fromIndex, int toIndex){
        checkRange(fromIndex, toIndex);
        modCount++;     // Increment the modification count
        removeRange(extractListModel(),fromIndex,toIndex);
    }
    /**
     * This removes all the elements from this list. The list will be empty 
     * after this call returns. <p>
     * 
     * Note that not all ListModels may support removing elements. If the {@link 
     * #getListModel() underlying ListModel} is not one that is known to support 
     * removing elements, then this will throw an UnsupportedOperationException.
     * 
     * @throws UnsupportedOperationException If the underlying ListModel is not 
     * known to support removal operations.
     * @see #getListModel() 
     * @see #remove(int) 
     * @see DefaultListModel#clear() 
     * @see DefaultComboBoxModel#removeAllElements() 
     * @see #removeRange(int, int) 
     */
    @Override
    public void clear() {
        if (model instanceof List)      // If the model is a List
            ((List)model).clear();
            // If the model is a DefaultListModel
        else if (model instanceof DefaultListModel)
            ((DefaultListModel)model).clear();
            // If the model is a DefaultComboBoxModel
        else if (model instanceof DefaultComboBoxModel)
            ((DefaultComboBoxModel)model).removeAllElements();
        else{
            super.clear();
            return;
        }
        modCount++;     // Increment the modification count
    }
    /**
     * This removes all the elements from this list. The list will be empty 
     * after this call returns. This method is identical to {@link #clear() 
     * clear}. <p>
     * 
     * Note that not all ListModels may support removing elements. If the {@link 
     * #getListModel() underlying ListModel} is not one that is known to support 
     * removing elements, then this will throw an UnsupportedOperationException.
     * 
     * @throws UnsupportedOperationException If the underlying ListModel is not 
     * known to support removal operations.
     * @see #clear() 
     * @see #getListModel() 
     * @see #remove(int) 
     * @see #removeElementAt(int) 
     * @see DefaultListModel#clear() 
     * @see DefaultComboBoxModel#removeAllElements() 
     * @see #removeRange(int, int) 
     */
    public void removeAllElements(){
        clear();
    }
    /**
     * This method attempts to replace the element at the given index in the 
     * ListModel with the given element. It is assumed that the given index is 
     * within range, and that the given ListModel is the {@link 
     * #extractListModel() extracted} underlying model for this ListModelList. 
     * If the model is not one that is known to support add, remove, or set 
     * operations, then this throws an UnsupportedOperationException. <p>
     * 
     * The {@link #set(int, Object) set} method delegates the task of replacing 
     * elements to this method after range checking the index and extracting the 
     * ListModel.
     * 
     * @implSpec
     * The default implementation only acknowledges {@link DefaultListModel 
     * DefaultListModels} and {@link List Lists} to be able to have elements 
     * replaced via their {@link DefaultListModel#set(int, java.lang.Object) 
     * set} and {@link List#set(int, java.lang.Object) set} methods 
     * respectively. If the ListModel is not a DefaultListModel or a List, then 
     * this resorts to trying to {@link #remove(javax.swing.ListModel, int) 
     * remove} the element at the given index, and then {@link 
     * #add(javax.swing.ListModel, int, java.lang.Object) insert} the given 
     * element in is place. 
     * 
     * @todo Look into modifying how ListDataEvents are fired, so as to make 
     * this fire a single CONTENTS_CHANGED event instead of separate 
     * INTERVAL_REMOVED and INTERVAL_ADDED events when this has to resort to 
     * removing an element and adding one in its place.
     * 
     * @param model The underlying ListModel.
     * @param index The index of the element to replace (assumed to be between 0 
     * and size(), exclusive).
     * @param element The element to store at the specified index.
     * @return The element previously stored at the specified index.
     * @throws UnsupportedOperationException If support for adding, removing, 
     * or replacing elements into and from the model is unknown.
     * @see #set(int, java.lang.Object) 
     * @see #add(javax.swing.ListModel, int, java.lang.Object) 
     * @see #remove(javax.swing.ListModel, int) 
     * @see #extractListModel() 
     * @see DefaultListModel#set(int, java.lang.Object) 
     * @see List#set(int, java.lang.Object) 
     */
    @SuppressWarnings("unchecked")
    protected E set(ListModel<? extends E> model, int index, E element){
        if (model instanceof List)      // If the model is a list
            return (E) ((List)model).set(index, element);
            // If the model is a DefaultListModel
        else if (model instanceof DefaultListModel)
            return (E)((DefaultListModel)model).set(index, element);
        try{
            E value = remove(model,index);  // Remove the element at the index
            add(model,index,element);
            return value;
        }
        catch(UnsupportedOperationException ex){
            throw new UnsupportedOperationException(unsupportedOperationMsg(
                    "add, remove, or set"));
        }
    }
    /**
     * This replaces the element at the specified index in this list with the 
     * specified element. <p>
     * 
     * Note that not all ListModels natively support replacing elements. If the 
     * {@link #getListModel() underlying ListModel} does not support replacing 
     * elements, this will try and work around that limitation by {@link 
     * #remove(int) removing} the element at the specified index and {@link 
     * #add(int, java.lang.Object) inserting} the specified element in its 
     * place. If the underlying ListModel does not support insertion or removal 
     * operations, then this will throw an UnsupportedOperationException.
     * 
     * @param index The index of the element to replace.
     * @param element The element to be stored at the specified index.
     * @return The element previously stored at the specified index.
     * @throws UnsupportedOperationException If the underlying ListModel is not 
     * known to support insertion, removal, and replacing operations.
     * @throws IndexOutOfBoundsException If the index is out of bounds. {@code 
     * (index < 0 || index >= size())}
     * @see #getListModel() 
     * @see DefaultListModel#set(int, java.lang.Object) 
     * @see #add(int, java.lang.Object) 
     * @see #remove(int) 
     */
    @Override
    public E set(int index, E element){
        checkIndex(index);
        return set(extractListModel(),index,element);
    }
    /**
     * This returns the index of the first occurrence of the given element in 
     * the ListModel, or -1 if the ListModel does not contain the element. It 
     * is assumed that the given ListModel is the {@link #extractListModel() 
     * extracted} underlying model for this ListModelList. <p>
     * 
     * The {@link #indexOf(java.lang.Object) indexOf} method delegates the task 
     * of searching for elements to this method after extracting the ListModel.
     * 
     * @implSpec
     * This implementation first checks to see if the ListModel is either a 
     * {@link DefaultListModel}, a {@link DefaultComboBoxModel}, or a {@link 
     * List}, and if so, this delegates the task to its {@link 
     * DefaultListModel#indexOf(java.lang.Object) indexOf}, {@link 
     * DefaultComboBoxModel#getIndexOf(java.lang.Object) getIndexOf}, or {@link 
     * List#indexOf(java.lang.Object) indexOf} method respectively. If the 
     * ListModel is neither a DefaultListModel, a DefaultComboBoxModel, or a 
     * List, then this resorts to checking each index in this list, retrieving 
     * the element at that index using the {@link #get(int) get} method, and 
     * checking to see if that element matches the given object. If a match is 
     * found, then the index of the matching element is returned.
     * 
     * @param model The underlying ListModel.
     * @param o The object to seach for.
     * @return The index of the first occurrence of the specified element in 
     * the model, or -1 if not found.
     * @see #indexOf(java.lang.Object) 
     * @see #lastIndexOf(javax.swing.ListModel, java.lang.Object) 
     * @see #lastIndexOf(java.lang.Object) 
     * @see #contains(java.lang.Object) 
     * @see #extractListModel() 
     * @see DefaultListModel#indexOf(java.lang.Object) 
     * @see DefaultComboBoxModel#getIndexOf(java.lang.Object) 
     * @see List#indexOf(java.lang.Object) 
     */
    protected int indexOf(ListModel<? extends E> model, Object o){
        if (model instanceof List)              // If the model is a list
            return ((List)model).indexOf(o);
            // If the model is a DefaultListModel
        else if (model instanceof DefaultListModel)
            return ((DefaultListModel)model).indexOf(o);
            // If the model is a DefaultComboBoxModel
        else if (model instanceof DefaultComboBoxModel)
            return ((DefaultComboBoxModel)model).getIndexOf(o);
            // A for loop to search through the elements
        for (int i = 0; i < size(); i++){
            if (Objects.equals(get(i), o))      // If a match has been found
                return i;
        }
        return -1;
    }
    /**
     * {@inheritDoc }
     */
    @Override
    public int indexOf(Object o){
        return indexOf(extractListModel(),o);
    }
    /**
     * This returns the index of the last occurrence of the given element in 
     * the ListModel, or -1 if the ListModel does not contain the element. It 
     * is assumed that the given ListModel is the {@link #extractListModel() 
     * extracted} underlying model for this ListModelList. <p>
     * 
     * The {@link #lastIndexOf(java.lang.Object) lastIndexOf} method delegates 
     * the task of searching for elements to this method after extracting the 
     * ListModel.
     * 
     * @implSpec
     * This implementation first checks to see if the ListModel is either a 
     * {@link DefaultListModel} or a {@link List}, and if so, this delegates the 
     * task to its {@link DefaultListModel#lastIndexOf(java.lang.Object) 
     * lastIndexOf} or {@link List#lastIndexOf(java.lang.Object) lastIndexOf} 
     * method respectively. If the ListModel is not a DefaultListModel or a 
     * List, then this resorts to checking each index in this list backwards, 
     * retrieving the element at that index using the {@link #get(int) get} 
     * method, and checking to see if that element matches the given object. If 
     * a match is found, then the index of the matching element is returned.
     * 
     * @param model The underlying ListModel.
     * @param o The object to seach for.
     * @return The index of the last occurrence of the specified element in 
     * the model, or -1 if not found.
     * @see #lastIndexOf(java.lang.Object) 
     * @see #indexOf(javax.swing.ListModel, java.lang.Object) 
     * @see #indexOf(java.lang.Object) 
     * @see #contains(java.lang.Object) 
     * @see #extractListModel() 
     * @see DefaultListModel#lastIndexOf(java.lang.Object) 
     * @see List#lastIndexOf(java.lang.Object) 
     */
    protected int lastIndexOf(ListModel<? extends E> model, Object o){
        if (model instanceof List)              // If the model is a list
            return ((List)model).lastIndexOf(o);
            // If the model is a DefaultListModel
        else if (model instanceof DefaultListModel)
            return ((DefaultListModel)model).lastIndexOf(o);
            // A for loop to search through the elements backwards
        for (int i = size()-1; i >= 0; i--){
            if (Objects.equals(get(i), o))      // If a match has been found
                return i;
        }
        return -1;
    }
    /**
     * {@inheritDoc }
     */
    @Override
    public int lastIndexOf(Object o){
        return lastIndexOf(extractListModel(),o);
    }
    // TODO: Possibly override more of the methods in AbstractList
    /**
     * {@inheritDoc }
     */
    @Override
    public boolean contains(Object o) {
        if (model instanceof List)      // If the model is a list
            return ((List)model).contains(o);
            // If the model is a DefaultListModel
        else if (model instanceof DefaultListModel)
            return ((DefaultListModel)model).contains(o);
        else 
            return indexOf(o) >= 0;
    }
    /**
     * This compares the contents of this ListModelList with the contents of the 
     * given list, and returns true if and only if the given list is the same 
     * size as this ListModelList, and all corresponding pairs of elements 
     * between the list and this ListModelList are equal. 
     * @param list The list to compare the contents of.
     * @return Whether the list is equal to this ListModelList.
     * @see #equals(Object) 
     */
    public boolean equalsList(List<?> list){
        return super.equals(list);
    }
    /**
     * This compares this ListModelList with the given object to see if it 
     * matches this ListModelList. This checks to see if the given object is 
     * either a ListModel or a list. If the given object is a ListModel, then 
     * this checks to see if it is this ListModel (i.e. obj == this). If the 
     * object is a list but not a ListModel, then this will return true if and 
     * only if the list is the same size as this list and that all corresponding 
     * pairs of elements in the two lists are equal (i.e. for each pair of 
     * elements {@code e1} and {@code e2}, then {@code Objects.equals(e1, e2)} 
     * returns {@code true}). In other words, if the given object is a list but 
     * not a ListModel, then this will return true if both lists contain the 
     * same elements in the same order. This implementation is done in a way so 
     * as to attempt to strike a balance between ensuring that changing the 
     * model of a {@code JList} or other such component that uses a ListModel as 
     * its model will result in a {@code PropertyChangeEvent} being fired by the 
     * component while also complying with the definition of the {@code 
     * List.equals} method as much as possible. The {@link #equalsList 
     * equalsList} can be used to compare this ListModelList with another list 
     * for equality as defined by {@code List.equals} regardless of whether the 
     * other list implements the ListModel interface.
     * @param obj The object to be compared for equality with this 
     * ListModelList.
     * @return Whether the object is equal to this ListModelList.
     * @see #equalsList(List) 
     */
    @Override
    public boolean equals(Object obj){
            // If the object is a ListModel
        if (obj instanceof ListModel)
            return obj == this; // Return if it's this ListModel
            // If the object is a List (but not a ListModel)
        else if (obj instanceof List)
            return equalsList((List)obj);
        else
            return false;
    }
    /**
     * {@inheritDoc }
     */
    @Override
    public int hashCode(){
        return super.hashCode();
    }
    /**
     * This is a handler used to listen to the ListModel, redirecting 
     * ListDataEvents from the ListModle to refer to this ListModelList, and 
     * firing the ListDataListeners registered to this ListModelList.
     */
    private class Handler implements ListDataListener{
        @Override
        public void intervalAdded(ListDataEvent evt) {
            fireIntervalAdded(evt.getIndex0(),evt.getIndex1());
        }
        @Override
        public void intervalRemoved(ListDataEvent evt) {
            fireIntervalRemoved(evt.getIndex0(),evt.getIndex1());
        }
        @Override
        public void contentsChanged(ListDataEvent evt) {
            fireContentsChanged(evt.getIndex0(),evt.getIndex1());
        }
    }
}
