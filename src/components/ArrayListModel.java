/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package components;

import java.util.*;
import java.util.function.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 * 
 * @author Milo Steier
 * @param <E> The type of elements to be stored in this list.
 */
public class ArrayListModel<E> extends AbstractList<E> implements ListModel<E>{
    /**
     * The ArrayList used to store the elements for this list.
     */
    protected final ArrayList<E> list;
    /**
     * The list of EventListeners registered to this model.
     */
    protected EventListenerList listenerList;
    /**
     * This constructs an ArrayListModel that uses the given {@code ArrayList} 
     * as its internal list.
     * @param list The list to use to store the elements.
     */
    private ArrayListModel(ArrayList<E> list){
        this.list = list;
        listenerList = new EventListenerList();
    }
    /**
     * This constructs an empty ArrayListModel.
     */
    public ArrayListModel() {
        this(new ArrayList<>());
    }
    
    public ArrayListModel(int initialCapacity){
        this(new ArrayList<>(initialCapacity));
    }
    
    public ArrayListModel(Collection<? extends E> c){
        this(new ArrayList<>(c));
    }
    
    public ArrayListModel(E[] arr){
        this(Arrays.asList(arr));
    }
    @Override
    public E get(int index) {
        return list.get(index);
    }
    @Override
    public E getElementAt(int index) {
        return get(index);
    }
    @Override
    public int size() {
        return list.size();
    }
    @Override
    public int getSize() {
        return size();
    }
    @Override
    public void add(int index, E element){
            // Add the element to the list at the given index
        list.add(index, element);
        modCount++;         // Increment the modification count
            // Indicate that an element has been added to this list
        fireIntervalAdded(index,index);
    }
    @Override
    public boolean addAll(int index, Collection<? extends E> c){
            // Add all the elements in the given collection to this list and get 
            // if this list was modified as a result
        boolean modified = list.addAll(index, c);
            // If this list was modified
        if (modified){
            modCount++;     // Increment the modification count
                // Indicate that elements have been added to this list
            fireIntervalAdded(index,index+c.size()-1);
        }
        return modified;
    }
    @Override
    public boolean addAll(Collection<? extends E> c){
        return addAll(size(),c);
    }
    @Override
    public E set(int index, E element){
            // Set the value at the given index and get the old element
        E oldValue = list.set(index, element);
            // Indicate that the contents of this list have changed at the given 
            // index
        fireContentsChanged(index,index);
        return oldValue;
    }
    /**
     * This returns a sublist of the internal {@code list} that covers the range 
     * to be processed. If the range covers the whole of the internal list, then 
     * the internal list will be returned. This differs from {@link subList} in 
     * that this invokes the internal list's {@code subList} method instead of 
     * producing a sublist of this {@code ArrayListModel}. The returned list 
     * will not fire {@code ListDataEvent}s if altered in any way.
     * @param fromIndex The index to start at.
     * @param toIndex The index to stop at, exclusive.
     * @return A sublist of the internal list to be used.
     * @throws IndexOutOfBoundsException If the range is out of bounds.
     * @see #subList(int, int) 
     */
    private List<E> getRange(int fromIndex, int toIndex){
            // If the range covers the entire list
        if (fromIndex == 0 && toIndex == list.size())
            return list;
        else
            return list.subList(fromIndex, toIndex);
    }
    /**
     * This replaces each element of this list that lie within the range 
     * specified by {@code fromIndex} and {@code toIndex}, exclusive, with the 
     * result of applying the operator to that element. Any errors or runtime 
     * exceptions thrown by the operator will be relayed to the caller. For more 
     * information about replacing the elements in a list using an operator, 
     * refer to the documentation for the {@link List#replaceAll 
     * List.replaceAll} method. For more information about sublists, refer to 
     * the documentation for the {@link List#subList List.subList} method.
     * @param operator The operator to apply to each element in the sublist.
     * @param fromIndex The index to start at.
     * @param toIndex The index to stop at, exclusive.
     * @throws IndexOutOfBoundsException If the range is out of bounds.
     * @throws UnsupportedOperationException If this list is unmodifiable. 
     * Implementations may throw this exception if an element cannot be replaced 
     * or if modifications to this list are not supported in general.
     * @throws NullPointerException If the given operator is null or if the 
     * operator result is a null value and this list does not permit null 
     * elements (optional).
     * @see List#replaceAll(UnaryOperator) 
     * @see #replaceAll(UnaryOperator) 
     * @see List#subList(int, int) 
     */
    protected void replaceRange(UnaryOperator<E> operator, int fromIndex, 
            int toIndex){
            // Require the operator to be non-null
        Objects.requireNonNull(operator);
            // If the starting index is the same as the ending index or if this 
        if (fromIndex == toIndex || isEmpty())  // list is empty
            return;
            // Get the sublist to replace the elements in
        List<E> range = getRange(fromIndex, toIndex);
            // Get a copy of the sublist so that we can compare the two and see 
        List<E> copy = new ArrayList<>(range);  // what is different
            // Try-Catch-Finally to catch any errors that occur, forward the 
            // errors to the caller, and finish processing the changes made to 
            // the list
        try{    // Try to replace the elements in the sublist
            range.replaceAll(operator);
            // Catch any errors that were thrown
        } catch (Throwable ex){
                // Forward those errors to the caller
            throw ex;
        } finally {
                // Check for any elements that have changed and fire content 
                // changed events accordingly
            fireContentsChanged(fromIndex,toIndex,range,copy);
        }
    }
    @Override
    public void replaceAll(UnaryOperator<E> operator){
        replaceRange(operator,0,size());
    }
    @Override
    protected void removeRange(int fromIndex, int toIndex){
            // If the starting index is the same as the ending index or if this 
        if (fromIndex == toIndex || isEmpty())  // list is empty
            return;
            // Get the sublist over the elements to remove and clear it
        getRange(fromIndex, toIndex).clear();
        modCount++;     // Increment the modification count
            // Indicate that the elements in the given range have been removed
        fireIntervalRemoved(fromIndex,toIndex-1);
    }
    @Override
    public E remove(int index){
            // Remove the element at the given index
        E value = list.remove(index);
        modCount++;     // Increment the modification count
            // Indicate that the element at the given index has been removed
        fireIntervalRemoved(index,index);
        return value;
    }
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
    
    private boolean batchRemove(Predicate<? super E> filter, Collection<?> c, 
            boolean retain, int fromIndex, int toIndex){
            // If both the filter and the collection are null (at least one must 
        if (filter == null && c == null)    // not be null)
            throw new NullPointerException();
            // If the starting index is the same as the ending index or if this 
        if (fromIndex == toIndex || isEmpty())  // list is empty
            return false;
            // Get the current size of this list
        int size = size();
            // This stores the starting index for the current interval of 
        int startIndex = -1;        // removed elements
            // This stores the size of the current interval of elements that 
        int intervalSize = 0;       // have been removed from the list
            // Get a list iterator to go through the internal list
        ListIterator<E> itr = list.listIterator(fromIndex);
            // Try-Catch-Finally to catch any errors that occur, forward the 
            // errors to the caller, and finish processing the changes made to 
            // the list
        try{    // Go through the elements in the range to be removed from, 
                // starting from the first element in the iterator, and ending 
                // at the end of the range or at the end of the iterator
            for (int i = 0; i < toIndex - fromIndex && itr.hasNext(); i++){
                    // This gets if the current element is a match for either 
                boolean match;  // the filter or an element in the collection
                    // If a filter was given
                if (filter != null)
                        // Test to see if the current element matches the filter
                    match = filter.test(itr.next());
                else    // Test to see if the current element is in the given 
                        // collection
                    match = c.contains(itr.next());
                    // If either the element is a match for the 
                    // filter/collection and matching elements should be removed 
                    // or if the element is not a match and only matching 
                    // elements should be retained
                if (match != retain){
                        // If the interval size is currently zero (there is 
                        // currently no interval)
                    if (intervalSize == 0)
                            // This is the start of the interval, so set the 
                            // starting index to the index of the element that 
                            // was just checked
                        startIndex = itr.previousIndex();
                        // Increment the interval size
                    intervalSize++;
                        // Remove the element from the list
                    itr.remove();
                    // If the element is not to be removed and there was an 
                    // interval of removed elements in progress (this marks the 
                    // end of the interval)
                } else if (intervalSize > 0){
                        // Indicate that the interval has been removed
                    fireIntervalRemoved(startIndex,startIndex+intervalSize-1);
                        // Reset the interval size to zero
                    intervalSize = 0;
                }
            }
            // Catch any errors that were thrown
        } catch (Throwable ex){
                // Forward those errors to the caller
            throw ex;
        } finally {
                // Add any elements that were removed to the modification count
            modCount += size - size();
                // If there is an interval that was removed that the listeners 
            if (intervalSize > 0)   // have yet to be notified of
                    // Indicate that an interval of elements has been removed
                fireIntervalRemoved(startIndex,startIndex+intervalSize-1);
        }
        return size != size();
    }
    
    protected boolean removeIf(Predicate<? super E> filter, int fromIndex, int toIndex){
            // Check if the filter is null, and use the batch remove method to 
            // remove elements that match the filter
        return batchRemove(Objects.requireNonNull(filter), null, false, 
                fromIndex, toIndex);
    }
    @Override
    public boolean removeIf(Predicate<? super E> filter){
        return removeIf(filter, 0, size());
    }
    
    protected boolean batchRemove(Collection<?> c, boolean retain, 
            int fromIndex, int toIndex){
            // Check if the collection is null
        Objects.requireNonNull(c);
            // If the collection is this list or the internal list
        if (c == this || c == list){
                // If the list is empty or this is to retain the elements in the 
            if (isEmpty() || retain)    // list (i.e. no change should occur)
                return false;
                // Remove all the elements from this list
            clear();
            return true;
        }   // Batch remove the elements from this list using the collection
        return batchRemove(null,c,retain,fromIndex,toIndex);
    }
    @Override
    public boolean removeAll(Collection<?> c){
        return batchRemove(c,false, 0, size());
    }
    @Override
    public boolean retainAll(Collection<?> c){
        return batchRemove(c,true, 0, size());
    }
    @Override
    public boolean contains(Object o){
        return list.contains(o);
    }
    @Override
    public boolean containsAll(Collection<?> c){
        return list.containsAll(c);
    }
    @Override
    public int indexOf(Object o){
        return list.indexOf(o);
    }
    @Override
    public int lastIndexOf(Object o){
        return list.lastIndexOf(o);
    }
    /**
     * This sorts the elements in this list within the range specified by {@code 
     * fromIndex} and {@code toIndex}, exclusive, according to the order induced 
     * by the given {@link Comparator}. If the given comparator is null then all 
     * elements in this list in the given range must implement the {@link 
     * Comparable} interface and the elements' natural ordering will be used. 
     * For more information about sorting lists, refer to the documentation for 
     * the {@link List#sort(Comparator) List.sort} method. For more information 
     * about sublists, refer to the documentation for the {@link List#subList 
     * List.subList} method.
     * @param c The {@code Comparator} to use to compare list elements, or null. 
     * A null value indicates that the natural ordering of the elements should 
     * be used.
     * @param fromIndex The index to start at.
     * @param toIndex The index to stop at, exclusive.
     * @throws IndexOutOfBoundsException If the range is out of bounds.
     * @throws UnsupportedOperationException If this list is unmodifiable. 
     * Implementations may throw this exception if an element cannot be set or 
     * if modifications to this list are not supported in general.
     * @throws IllegalArgumentException If the given comparator is found to 
     * violate the Comparator contract (optional).
     * @throws ClassCastException If this list contains elements that are not 
     * mutually comparable using the given comparator.
     * @see List#sort(Comparator) 
     * @see #sort(Comparator) 
     * @see List#subList(int, int) 
     */
    protected void sort(Comparator<? super E> c, int fromIndex, int toIndex){
            // If the starting index is the same as the ending index or if this 
        if (fromIndex == toIndex || isEmpty())  // list is empty
            return;
            // Get the sublist to sort
        List<E> range = getRange(fromIndex, toIndex);
            // Get a copy of the sublist so that we can compare the two and see 
        List<E> copy = new ArrayList<>(range);  // what is different
            // Sort the sublist
        range.sort(c);
            // Check for any elements that have changed and fire content changed 
            // events accordingly
        fireContentsChanged(fromIndex,toIndex,range,copy);
    }
    @Override
    public void sort(Comparator<? super E> c){
        sort(c,0,size());
    }
    @Override
    public Object[] toArray(){
        return list.toArray();
    }
    @Override
    public <T> T[] toArray(T[] a){
        return list.toArray(a);
    }
    @Override
    public Iterator<E> iterator(){
        return listIterator();
    }
    @Override
    public List<E> subList(int fromIndex, int toIndex){
            // Check the given range to see if it is within bounds
        checkRange(fromIndex,toIndex,list.size());
            // Return a sublist of this list over the given range
        return new SubList<>(this,fromIndex,toIndex);
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
     * This checks for any elements that have changed in the given sublist of 
     * the internal list using the given unmodified copy of the sublist to 
     * detect changes, and fires {@code ListDataEvent}s that cover the ranges of 
     * elements that were altered.
     * 
     * @todo Possibly make this method also check for removed or added elements 
     * by checking the sizes of the two lists. This may not be necessary, 
     * though.
     * 
     * @param fromIndex The index that the sublist starts at.
     * @param toIndex The index that the sublist stops at, exclusive.
     * @param list The sublist of the internal list that was altered.
     * @param unchanged An unchanged copy of the sublist from before any 
     * operations were performed on it.
     * @return Whether the given list was altered.
     * @see #fireContentsChanged(int, int) 
     */
    private boolean fireContentsChanged(int fromIndex, int toIndex,
            List<E> list, List<E> unchanged){
            // This will get whether the contents of the list has been altered
        boolean modified = false;
            // This gets the starting index for the range that changed
        int start = -1;
            // Go through the elements that were sorted
        for (int i = 0; i < list.size(); i++){
                // Check if the element at the current index was changed
            boolean match = Objects.equals(list.get(i), unchanged.get(i));
                // If the current element has changed and the range has not 
                // started yet
            if (start < 0 && !match){
                    // This is the start of the range of the changed contents
                start = i;
                    // The contents of the list have been modified
                modified = true;
            }   // If we are currently in a section that has changed and a 
                // matching element has been found
            else if (start >= 0 && match){
                    // This marks the end of the current range of changed 
                    // contents. Fire a contents change event indicating that 
                    // all elements between the start index and the previous 
                    // index have changed
                fireContentsChanged(fromIndex+start, fromIndex+i-1);
                    // Reset the starting index to -1
                start = -1;
            }
        }   // If the starting index for the range that changed is not negative 
            // and is within the sublist that was sorted (i.e. if everything 
            // starting from the starting index to the end of the sublist has 
            // changed)
        if (start >= 0 && start < list.size())
                // Fire a contents change event indicating that the rest of the 
                // elements in the sublist have changed
            fireContentsChanged(fromIndex+start, toIndex-1);
        if (modified)           // If the list was modified
            modCount++;         // Increment the modification count
        return modified;
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
    private static void checkRange(int fromIndex, int toIndex, int size){
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
    
    // TODO: Custom subList which overrides the removeIf, removeAll, replaceAll, 
    // retainAll, and sort methods of the subList to fire ListDataEvents over 
    // intervals instead of individual indexes
    
    private static class SubList<E> extends AbstractList<E>{
        /**
         * The root ArrayListModel for this branch of SubLists. This is the 
         * ArrayListModel that either this SubList or its parent were created 
         * by.
         */
        private final ArrayListModel<E> root;
        /**
         * The parent SubList for this SubList, or null.
         */
        private final SubList<E> parent;
        /**
         * The offset into the root ArrayListModel for the first element in this 
         * SubList.
         */
        private final int offset;
        /**
         * The size of this SubList.
         */
        private int size;
        
        private SubList(ArrayListModel<E> root, int fromIndex, int toIndex){
            this.root = root;
            this.parent = null;
            this.offset = fromIndex;
            this.size = toIndex - fromIndex;
            this.modCount = root.modCount;
        }
        
        private SubList(SubList<E> parent, int fromIndex, int toIndex){
            this.root = parent.root;
            this.parent = parent;
            this.offset = parent.offset + fromIndex;
            this.size = toIndex - fromIndex;
            this.modCount = parent.modCount;
        }
        @Override
        public E get(int index) {
            Objects.checkIndex(index, size);
            checkForComodification();
            return root.get(offset+index);
        }
        @Override
        public int size() {
            checkForComodification();
            return size;
        }
        @Override
        public E set(int index, E element){
            Objects.checkIndex(index, size);
            checkForComodification();
            return root.set(offset+index, element);
        }
        @Override
        public void replaceAll(UnaryOperator<E> operator){
            checkForComodification();
            root.replaceRange(operator, offset, offset+size);
            updateSizeAndModCount(0);
        }
        @Override
        public void add(int index, E element){
            Objects.checkIndex(index, size+1);
            checkForComodification();
            root.add(offset+index, element);
            updateSizeAndModCount(1);
        }
        @Override
        public boolean addAll(int index, Collection<? extends E> c){
            Objects.checkIndex(index, size+1);
            if (c.isEmpty())
                return false;
            int cSize = c.size();
            checkForComodification();
            root.addAll(offset+index, c);
            updateSizeAndModCount(cSize);
            return true;
        }
        @Override
        public boolean addAll(Collection<? extends E> c){
            return addAll(size,c);
        }
        @Override
        public E remove(int index){
            Objects.checkIndex(index, size);
            checkForComodification();
            E value = root.remove(offset+index);
            updateSizeAndModCount(-1);
            return value;
        }
        @Override
        public boolean remove(Object o){
            int index = indexOf(o);
            if (index < 0)
                return false;
            remove(index);
            return true;
        }
        @Override
        protected void removeRange(int fromIndex, int toIndex){
            checkForComodification();
            root.removeRange(offset+fromIndex, offset+toIndex);
            updateSizeAndModCount(fromIndex-toIndex);
        }
        @Override
        public boolean removeIf(Predicate<? super E> filter){
            checkForComodification();
            int temp = root.size();
            boolean modified = root.removeIf(filter, offset, offset+size);
            updateSizeAndModCount(temp - root.size());
            return modified;
        }
        
        protected boolean batchRemove(Collection<?> c, boolean retain){
            checkForComodification();
            int temp = root.size();
            boolean modified = root.batchRemove(c, retain, offset, offset+size);
            updateSizeAndModCount(temp - root.size());
            return modified;
        }
        @Override
        public boolean removeAll(Collection<?> c){
            return batchRemove(c,false);
        }
        @Override
        public boolean retainAll(Collection<?> c){
            return batchRemove(c,true);
        }
        @Override
        public Iterator<E> iterator(){
            return listIterator();
        }
        @Override
        public ListIterator<E> listIterator(int index) {
            checkForComodification();
            Objects.checkIndex(index, size+1);
            return new ListIterator<E>() {
                private final ListIterator<E> itr = root.listIterator(offset+index);
                @Override
                public boolean hasNext() {
                    return nextIndex() < size;
                }
                @Override
                public E next() {
                    if (!hasNext())
                        throw new NoSuchElementException();
                    checkForComodification();
                    return itr.next();
                }
                @Override
                public boolean hasPrevious() {
                    return previousIndex() >= 0;
                }
                @Override
                public E previous() {
                    if (!hasPrevious())
                        throw new NoSuchElementException();
                    checkForComodification();
                    return itr.previous();
                }
                @Override
                public int nextIndex() {
                    return itr.nextIndex()-offset;
                }
                @Override
                public int previousIndex() {
                    return itr.previousIndex()-offset;
                }
                @Override
                public void remove() {
                    checkForComodification();
                    itr.remove();
                    updateSizeAndModCount(-1);
                }
                @Override
                public void set(E e) {
                    checkForComodification();
                    itr.set(e);
                }
                @Override
                public void add(E e) {
                    checkForComodification();
                    itr.add(e);
                    updateSizeAndModCount(1);
                }
            };
        }
        @Override
        public List<E> subList(int fromIndex, int toIndex){
            checkRange(fromIndex,toIndex,size);
            return new SubList<>(this,fromIndex,toIndex);
        }
        
        private void checkForComodification() {
            if (root.modCount != this.modCount)
                throw new ConcurrentModificationException();
        }
        
        private void updateSizeAndModCount(int change) {
            for(SubList<E> temp = this; temp != null; temp = temp.parent){
                temp.size += change;
                temp.modCount = root.modCount;
            }
        }
    }
}
