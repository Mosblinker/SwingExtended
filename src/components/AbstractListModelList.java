/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package components;

import java.util.*;
import javax.swing.ListModel;
import javax.swing.event.*;

/**
 * This is an abstract implementation of a {@code List} that implements the 
 * {@code ListModel} interface.
 * @author Milo Steier
 * @param <E> The type of elements to be stored in this list.
 */
public abstract class AbstractListModelList<E> extends AbstractList<E> 
        implements List<E>, ListModel<E>{
    /**
     * The list of EventListeners registered to this model.
     */
    protected EventListenerList listenerList;
    /**
     * Implicit constructor for AbstractListModelList.
     */
    protected AbstractListModelList(){
        listenerList = new EventListenerList();
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
     * {@inheritDoc }
     * 
     * @implSpec This implementation calls {@code addAll(size(), c)}. <p>
     * 
     * Note that this implementation throws an {@code 
     * UnsupportedOperationException} if {@link #addAll(int, Collection) 
     * addAll(int, Collection)} throws an {@code UnsupportedOperationException}, 
     * such as if {@link #add(int, Object) add(int, E)} has not been overridden.
     * 
     * @param c {@inheritDoc }
     * @return {@inheritDoc }
     * @throws NullPointerException {@inheritDoc }
     * @throws UnsupportedOperationException {@inheritDoc }
     * @throws IllegalArgumentException {@inheritDoc }
     * @throws ClassCastException {@inheritDoc }
     * @see #add(Object) 
     * @see #add(int, Object) 
     * @see #addAll(int, Collection) 
     */
    @Override
    public boolean addAll(Collection<? extends E> c){
        return addAll(size(),c);
    }
    /**
     * {@inheritDoc }
     * 
     * @implSpec This implementation is equivalent to calling {@code 
     * remove(indexOf(o))}.  <p>
     * 
     * Note that this implementation throws an {@code 
     * UnsupportedOperationException} unless {@link #remove(int) remove(int)} 
     * has been overridden.
     * 
     * @param o {@inheritDoc }
     * @return {@inheritDoc }
     * @throws NullPointerException {@inheritDoc }
     * @throws UnsupportedOperationException {@inheritDoc }
     * @throws ClassCastException {@inheritDoc }
     * @see #remove(int) 
     * @see #indexOf(Object) 
     */
    @Override
    public boolean remove(Object o){
            // Get the first index of the element to be removed
        int index = indexOf(o);
            // If the element was not found in this list (the index is negative)
        if (index < 0)
            return false;
            // Remove the first instance of the given element
        remove(index);
        return true;
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
     * This adds a {@code ListDataListener} to this model that will be notified 
     * when the structure of this list is modified.
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
     * This removes a {@code ListDataListener} from this model.
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
     * registered to this model.
     * @return An array containing the {@code ListDataListener}s that have been 
     * added, or an empty array if no listeners have been added.
     * @see #addListDataListener(ListDataListener) 
     * @see #removeListDataListener(ListDataListener) 
     */
    public ListDataListener[] getListDataListeners(){
        return listenerList.getListeners(ListDataListener.class);
    }
    /**
     * This fires a {@code ListDataEvent} of the given type over the interval 
     * between {@code index0} and {@code index1}, inclusive. Note that {@code 
     * index0} does not need to be less than or equal to {@code index1}.
     * @param type The type of event to be fired. 
     * @param index0 One end of the interval.
     * @param index1 The other end of the interval.
     * @see #getListDataListeners() 
     * @see ListDataEvent
     * @see ListDataListener
     * @see #fireIntervalAdded(int, int) 
     * @see #fireIntervalRemoved(int, int) 
     * @see #fireContentsChanged(int, int) 
     */
    protected void fireListDataEvent(int type, int index0, int index1){
            // This creates the event to be fired.
        ListDataEvent evt = new ListDataEvent(this,type,index0,index1);
            // Go through the ListDataListeners
        for (ListDataListener l : getListDataListeners()){
            if (l != null){     // If the current listener is not null
                switch(type){
                        // If an interval was added
                    case(ListDataEvent.INTERVAL_ADDED):
                        l.intervalAdded(evt);
                        break;
                        // If an interval was removed
                    case(ListDataEvent.INTERVAL_REMOVED):
                        l.intervalRemoved(evt);
                        break;
                        // If the contents changed
                    case(ListDataEvent.CONTENTS_CHANGED):
                        l.contentsChanged(evt);
                }
            }
        }
    }
    /**
     * This fires a {@code ListDataEvent} informing the listeners that elements 
     * have been added to the model within the interval between {@code index0} 
     * and {@code index1}, inclusive. Note that {@code index0} does not need to 
     * be less than or equal to {@code index1}. This effectively calls {@link 
     * #fireListDataEvent fireListDataEvent} with the given interval and with 
     * {@link ListDataEvent#INTERVAL_ADDED INTERVAL_ADDED} as the {@code type} 
     * of event.
     * @param index0 One end of the interval.
     * @param index1 The other end of the interval.
     * @see #getListDataListeners() 
     * @see ListDataEvent
     * @see ListDataListener
     * @see #fireListDataEvent(int, int, int) 
     * @see #fireIntervalRemoved(int, int) 
     * @see #fireContentsChanged(int, int) 
     * @see ListDataEvent#INTERVAL_ADDED
     */
    protected void fireIntervalAdded(int index0, int index1){
        fireListDataEvent(ListDataEvent.INTERVAL_ADDED,index0,index1);
    }
    /**
     * This fires a {@code ListDataEvent} informing the listeners that elements 
     * have been removed from the model that use to be within the interval 
     * between {@code index0} and {@code index1}, inclusive. Note that {@code 
     * index0} does not need to be less than or equal to {@code index1}. This 
     * effectively calls {@link #fireListDataEvent fireListDataEvent} with the 
     * given interval and with {@link ListDataEvent#INTERVAL_REMOVED 
     * INTERVAL_REMOVED} as the {@code type} of event.
     * @param index0 One end of the interval.
     * @param index1 The other end of the interval.
     * @see #getListDataListeners() 
     * @see ListDataEvent
     * @see ListDataListener
     * @see #fireListDataEvent(int, int, int) 
     * @see #fireIntervalAdded(int, int) 
     * @see #fireContentsChanged(int, int) 
     * @see ListDataEvent#INTERVAL_REMOVED
     */
    protected void fireIntervalRemoved(int index0, int index1){
        fireListDataEvent(ListDataEvent.INTERVAL_REMOVED,index0,index1);
    }
    /**
     * This fires a {@code ListDataEvent} informing the listeners that the 
     * contents of the model have changed within the interval between {@code 
     * index0} and {@code index1}, inclusive. Note that {@code index0} does not 
     * need to be less than or equal to {@code index1}. This effectively calls 
     * {@link #fireListDataEvent fireListDataEvent} with the given interval and 
     * with {@link ListDataEvent#CONTENTS_CHANGED CONTENTS_CHANGED} as the 
     * {@code type} of event.
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
     * This checks to see if the {@code fromIndex} and {@code toIndex} are 
     * within range. The indexes are in range if they are within bounds and the 
     * {@code fromIndex} is less than or equal to the {@code toIndex}. If the 
     * range is out of bounds, then this will throw an 
     * IndexOutOfBoundsException.
     * @param fromIndex The index to start at.
     * @param toIndex The index to stop at, exclusive.
     * @throws IndexOutOfBoundsException If the range is out of bounds.
     */
    protected static void checkRange(int fromIndex, int toIndex, int size){
        if (fromIndex < 0)          // If the start index is negative
            throw new IndexOutOfBoundsException("From Index out of bounds: " + 
                    fromIndex + " < 0");
        else if (toIndex > size)    // If the end index is greater than the size
            throw new IndexOutOfBoundsException("To Index out of bounds: " + 
                    toIndex + " > " + size);
            // If the start index is greater than the stop index
        else if (fromIndex > toIndex)   
            throw new IndexOutOfBoundsException("From Index > To Index: "+
                    fromIndex+" > "+toIndex);
    }
}
