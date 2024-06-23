/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package components;

import components.AbstractConfirmDialogPanel;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;
import java.util.Objects;
import javax.swing.JList;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * This is the base class for confirmation panels that display a list. 
 * @author Milo Steier
 * @param <E> The data type of the elements for the list.
 */
abstract class ListDataPanel<E> extends AbstractConfirmDialogPanel{
    /**
     * This identifies that the title displayed above the list has changed.
     */
    public static final String LIST_TITLE_PROPERTY_CHANGED = "ListTitlePropertyChanged";
    /**
     * This initializes the components of this list data panel.
     * @param model The model for the list (may be null).
     */
    private void initialize(ListModel<E> model){
        handler = new Handler();
        setBorder(javax.swing.BorderFactory.createEmptyBorder(11, 10, 11, 10));
        setMinimumSize(new java.awt.Dimension(480, 320));
        list = new javax.swing.JList<>();
        if (model != null){         // If the model is not null
            list.setModel(model);
            model.addListDataListener(handler);
        }
        list.setInheritsPopupMenu(true);
        list.addMouseListener(getDisabledComponentListener());
        list.addListSelectionListener(handler);
        list.addPropertyChangeListener(handler);
        scrollPane = new javax.swing.JScrollPane(list);
        scrollPane.setInheritsPopupMenu(true);
        scrollPane.addMouseListener(getDisabledComponentListener());
        scrollPane.addPropertyChangeListener(handler);
        add(scrollPane, java.awt.BorderLayout.CENTER);
        
        sidePanel = new javax.swing.JPanel();
        sidePanel.setInheritsPopupMenu(true);
        add(sidePanel, java.awt.BorderLayout.LINE_END);
        
        fullBottomPanel = new javax.swing.JPanel(new java.awt.BorderLayout(6, 0));
        fullBottomPanel.setInheritsPopupMenu(true);
        
        bottomPanel = new javax.swing.JPanel();
        bottomPanel.setInheritsPopupMenu(true);
        fullBottomPanel.add(bottomPanel,java.awt.BorderLayout.CENTER);
        
        controlPanel = new javax.swing.JPanel(new java.awt.GridLayout(1, 0, 6, 0));
        controlPanel.setInheritsPopupMenu(true);
        controlPanel.add(getAcceptButton());
        controlPanel.add(getCancelButton());
        fullBottomPanel.add(controlPanel, java.awt.BorderLayout.LINE_END);
        add(fullBottomPanel, java.awt.BorderLayout.PAGE_END);
        
        nameLabel = new javax.swing.JLabel();
        nameLabel.setInheritsPopupMenu(true);
        add(nameLabel, java.awt.BorderLayout.PAGE_START);
        nameLabel.setVisible(false);
    }
    
    public ListDataPanel(ListModel<E> model, String title){
        super(new java.awt.BorderLayout(10, 11), title);
        initialize(model);
    }
    
    public ListDataPanel(ListModel<E> model){
        this(model,null);
    }
    
    public ListDataPanel(String title){
        this(null, title);
    }
    
    public ListDataPanel(){
        this(null, null);
    }
    
    protected javax.swing.JPanel getSidePanel(){
        return sidePanel;
    }
    
    protected javax.swing.JPanel getFullBottomPanel(){
        return fullBottomPanel;
    }
    
    protected javax.swing.JPanel getBottomPanel(){
        return bottomPanel;
    }
    
    protected javax.swing.JPanel getControlPanel(){
        return controlPanel;
    }
    
    public final JList<E> getList(){
        return list;
    }
    
    public final javax.swing.JScrollPane getScrollPane(){
        return scrollPane;
    }
    
    public String getListTitle(){
        return nameLabel.getText();
    }
    /**
     * 
     * @param title 
     */
    public void setListTitle(String title){
        String old = getListTitle();    // Get the old title
        if (Objects.equals(old, title)) // If the new title matches the old title
            return;
        nameLabel.setText(title);
        nameLabel.setVisible(title != null && !title.isEmpty());
        firePropertyChange(LIST_TITLE_PROPERTY_CHANGED,old,title);
    }
    /**
     * This returns the current selection model for the list. This is the model 
     * responsible for maintaining the selection state of the list. This 
     * delegates to the {@link JList#getSelectionModel() getSelectionModel} 
     * method of the internal JList.
     * @return The ListSelectionModel that maintains the list's selections.
     * @see #setSelectionModel(javax.swing.ListSelectionModel) 
     * @see JList#getSelectionModel()
     */
    public ListSelectionModel getSelectionModel(){
        return getList().getSelectionModel();
    }
    /**
     * This sets the selection model for the list. The selection model is 
     * responsible for handling the task of making single selections, as well as 
     * both continuous and non-continuous selections. This delegates to the 
     * {@link JList#setSelectionModel(javax.swing.ListSelectionModel) 
     * setSelectionModel} method of the internal JList.
     * @param model The ListSelectionModel to use (cannot be null).
     * @throws NullPointerException If the given selection model is null.
     * @see #getSelectionModel() 
     * @see JList#setSelectionModel(javax.swing.ListSelectionModel)
     */
    public void setSelectionModel(ListSelectionModel model){
        getList().setSelectionModel(Objects.requireNonNull(model,"Selection model cannot be null"));
    }
    /**
     * This returns the current selection mode for the list. This delegates to 
     * the {@link JList#getSelectionMode() getSelectionMode} method of the 
     * internal JList. 
     * @return The current selection mode for the list.
     * @see JList#getSelectionMode()
     * @see #setSelectionMode(int) 
     * @see JList#setSelectionMode(int)
     * @see ListSelectionModel#SINGLE_SELECTION
     * @see ListSelectionModel#SINGLE_INTERVAL_SELECTION
     * @see ListSelectionModel#MULTIPLE_INTERVAL_SELECTION
     */
    public int getSelectionMode(){
        return getList().getSelectionMode();
    }
    /**
     * This sets the selection mode for the list. This delegates to the {@link 
     * JList#setSelectionMode(int) setSelectionMode} method of the internal 
     * JList. Refer to the documentation for {@link JList#setSelectionMode(int)
     * setSelectionMode} for more information on accepted selection modes.
     * @param mode The selection mode. This should be one of the following : 
     *      {@link ListSelectionModel#SINGLE_SELECTION SINGLE_SELECTION}, 
     *      {@link ListSelectionModel#SINGLE_INTERVAL_SELECTION SINGLE_INTERVAL_SELECTION}, or 
     *      {@link ListSelectionModel#MULTIPLE_INTERVAL_SELECTION MULTIPLE_INTERVAL_SELECTION}.
     * @throws IllegalArgumentException If the given selection mode is not a 
     * valid selection mode.
     * @see JList#setSelectionMode(int)
     * @see ListSelectionModel#SINGLE_SELECTION
     * @see ListSelectionModel#SINGLE_INTERVAL_SELECTION
     * @see ListSelectionModel#MULTIPLE_INTERVAL_SELECTION
     * @see #getSelectionMode() 
     */
    public void setSelectionMode(int mode){
        getList().setSelectionMode(mode);
    }
    /**
     * This returns whether nothing is currently selected. This delegates to the 
     * {@link JList#isSelectionEmpty() isSelectionEmpty} method of the internal 
     * JList.
     * @return true if nothing is selected, otherwise false.
     * @see #clearSelection() 
     * @see JList#isSelectionEmpty()
     */
    public boolean isSelectionEmpty(){
        return getList().isSelectionEmpty();
    }
    /**
     * This clears the selection. This delegates to the {@link 
     * JList#clearSelection() clearSelection} method of the internal JList.
     * @see #isSelectionEmpty() 
     * @see JList#clearSelection()
     */
    public void clearSelection(){
        getList().clearSelection();
    }
    /**
     * This returns the number of items that are currently selected. This 
     * delegates to the {@link ListSelectionModel#getSelectedItemsCount() 
     * getSelectedItemsCount} method of the internal JList's {@link 
     * #getSelectionModel() selection model}.
     * @return The amount of selected items, or 0 if no items are selected.
     * @see #getSelectionModel() 
     * @see ListSelectionModel#getSelectedItemsCount()
     */
    public int getSelectedItemsCount(){
        return getSelectionModel().getSelectedItemsCount();
    }
    /**
     * This returns the anchor selection index. This delegates to the {@link 
     * JList#getAnchorSelectionIndex() getAnchorSelectionIndex} method of the 
     * internal JList.
     * @return The anchor selection index.
     * @see JList#getAnchorSelectionIndex()
     */
    public int getAnchorSelectionIndex(){
        return getList().getAnchorSelectionIndex();
    }
    /**
     * This returns the lead selection index. This delegates to the {@link 
     * JList#getLeadSelectionIndex() getLeadSelectionIndex} method of the 
     * internal JList.
     * @return The lead selection index.
     * @see JList#getLeadSelectionIndex()
     */
    public int getLeadSelectionIndex(){
        return getList().getLeadSelectionIndex();
    }
    /**
     * This returns the index of the selected cell with the smallest index, or 
     * -1 if the selection is empty. This delegates to the {@link 
     * JList#getMinSelectionIndex() getMinSelectionIndex} method of the internal 
     * JList.
     * @return The smallest selected cell index, or -1 if nothing is selected.
     * @see JList#getMinSelectionIndex()
     */
    public int getMinSelectionIndex(){
        return getList().getMinSelectionIndex();
    }
    /**
     * This returns the index of the selected cell with the largest index, or 
     * -1 if the selection is empty. This delegates to the {@link 
     * JList#getMaxSelectionIndex() getMaxSelectionIndex} method of the internal 
     * JList.
     * @return The largest selected cell index, or -1 if nothing is selected.
     * @see JList#getMaxSelectionIndex()
     */
    public int getMaxSelectionIndex(){
        return getList().getMaxSelectionIndex();
    }
    /**
     * This returns whether the given index is selected. This delegates to the 
     * {@link JList#isSelectedIndex(int) isSelectedIndex} method of the internal 
     * JList.
     * @param index The index to check to see if it is selected.
     * @return true if the given index is selected, otherwise false.
     * @see #setSelectedIndex(int) 
     * @see JList#isSelectedIndex(int)
     */
    public boolean isSelectedIndex(int index){
        return getList().isSelectedIndex(index);
    }
    /**
     * This returns the smallest selected cell index, which is the selection 
     * when only a single item is selected in the list. This delegates to the 
     * {@link JList#getSelectedIndex() getSelectedIndex} method of the internal 
     * JList.
     * @return The smallest selected cell index, or -1 if nothing is selected.
     * @see #getMinSelectionIndex() 
     * @see JList#getSelectedIndex()
     * @see #setSelectedIndex(int) 
     */
    public int getSelectedIndex(){
        return getList().getSelectedIndex();
    }
    /**
     * This selects a single cell. This will do nothing if the given index is 
     * greater than or equal to the model's size. This delegates to the {@link 
     * JList#setSelectedIndex(int) setSelectedIndex} method of the internal 
     * JList.
     * @param index The index of the cell to select.
     * @see #isSelectedIndex(int) 
     * @see JList#setSelectedIndex(int)
     */
    public void setSelectedIndex(int index){
        getList().setSelectedIndex(index);
    }
    /**
     * This returns the value for the smallest selected cell index, which is the 
     * selected value when only a single item is selected in the list. This 
     * delegates to the {@link JList#getSelectedValue() getSelectedValue} method 
     * of the internal JList.
     * @return The first selected value, or null if nothing is selected.
     * @see #getSelectedIndex() 
     * @see #getMinSelectionIndex() 
     * @see #getModel() 
     * @see JList#getSelectedValue()
     */
    public E getSelectedValue(){
        return getList().getSelectedValue();
    }
    /**
     * This selects the given value in the list. If the given object is null, 
     * then the selection is cleared. This delegates to the {@link 
     * JList#setSelectedValue(java.lang.Object, boolean) setSelectedValue} 
     * method of the internal JList.
     * @param value The object to select, or null to clear the selection.
     * @param shouldScroll true if the list should scroll to display the 
     * selected object if it exists, otherwise false.
     * @see JList#setSelectedValue(java.lang.Object, boolean)
     */
    public void setSelectedValue(Object value, boolean shouldScroll){
        getList().setSelectedValue(value, shouldScroll);
    }
    /**
     * This returns an array of all of the selected indices, in increasing 
     * order. This delegates to the {@link JList#getSelectedIndices() 
     * getSelectedIndices} method of the internal JList.
     * @return An array containing all of the selected indices, in increasing 
     * order, or an empty array if nothing is selected.
     * @see #setSelectedIndices(int[]) 
     * @see JList#getSelectedIndices() 
     */
    public int[] getSelectedIndices(){
        return getList().getSelectedIndices();
    }
    /**
     * This changes the selection to be the set of indices in specified in the 
     * given array. Indexes that are greater than or equal to the model size are 
     * ignored. This delegates to the {@link JList#setSelectedIndices(int[]) 
     * setSelectedIndices} method of the internal JList.
     * @param indices An array containing the indices of the cells to select 
     * (cannot be null).
     * @throws NullPointerException If the given array is null.
     * @see #getSelectedIndices() 
     * @see #isSelectedIndex(int) 
     * @see JList#setSelectedIndices(int[])
     */
    public void setSelectedIndices(int[] indices){
        getList().setSelectedIndices(indices);
    }
    /**
     * This returns a list of all the selected items, in increasing order based 
     * off their indices in the list. This delegates to the {@link 
     * JList#getSelectedValuesList() getSelectedValuesList} method of the 
     * internal JList.
     * @return A list containing the selected items, or an empty list if nothing 
     * is selected.
     * @see #isSelectedIndex(int) 
     * @see #getModel() 
     * @see JList#getSelectedValuesList()
     */
    public List<E> getSelectedValuesList(){
        return getList().getSelectedValuesList();
    }
    /**
     * This selects the specified interval. Both the {@code anchor} and {@code 
     * lead} indices are included, and the {@code anchor} doesn't have to be 
     * less than or equal to the {@code lead}. This delegates to the {@link 
     * JList#setSelectionInterval(int, int) setSelectionInterval} method of the 
     * internal JList.
     * @param anchor The first index to select.
     * @param lead The last index to select.
     * @see #addSelectionInterval(int, int) 
     * @see #removeSelectionInterval(int, int) 
     * @see JList#setSelectionInterval(int, int)
     */
    public void setSelectionInterval(int anchor, int lead){
        getList().setSelectionInterval(anchor, lead);
    }
    /**
     * This sets the selection to be the union of the specified interval with 
     * the current selection. Both the {@code anchor} and {@code lead} indices 
     * are included, and the {@code anchor} doesn't have to be less than or 
     * equal to the {@code lead}. This delegates to the {@link 
     * JList#addSelectionInterval(int, int) addSelectionInterval} method of the 
     * internal JList.
     * @param anchor The first index to add to the selection.
     * @param lead The last index to add to the selection.
     * @see #setSelectionInterval(int, int) 
     * @see #removeSelectionInterval(int, int) 
     * @see JList#addSelectionInterval(int, int)
     */
    public void addSelectionInterval(int anchor, int lead){
        getList().addSelectionInterval(anchor, lead);
    }
    /**
     * This sets the selection to be the difference of the specified interval 
     * and the current selection. Both the {@code index0} and {@code index1} 
     * indices are removed, and the {@code index0} doesn't have to be less than 
     * or equal to the {@code index1}. This delegates to the {@link 
     * JList#removeSelectionInterval(int, int) removeSelectionInterval} method 
     * of the internal JList.
     * @param index0 The first index to remove from the selection.
     * @param index1 The last index to remove from the selection.
     * @see #setSelectionInterval(int, int) 
     * @see #addSelectionInterval(int, int) 
     * @see JList#removeSelectionInterval(int, int)
     */
    public void removeSelectionInterval(int index0, int index1){
        getList().removeSelectionInterval(index0, index1);
    }
    /**
     * This returns whether the selection is undergoing a series of changes. 
     * This delegates to the {@link JList#getValueIsAdjusting() 
     * getValueIsAdjusting} method of the internal JList.
     * @return Whether the selection is undergoing a series of changes.
     * @see #setValueIsAdjusting(boolean) 
     * @see JList#getValueIsAdjusting() 
     */
    public boolean getValueIsAdjusting(){
        return getList().getValueIsAdjusting();
    }
    /**
     * This sets whether the selection is undergoing a series of changes. When 
     * true, upcoming changes to the selection should be considered part of a 
     * single change. This allows listeners to update only when a change has 
     * been finalized as opposed to handling all of the intermediate values. <p>
     * 
     * You may want to use this directly if you are making a series of changes 
     * that should be considered part of a single change. <p>
     * 
     * This delegates to the {@link JList#setValueIsAdjusting(boolean) 
     * setValueIsAdjusting} method of the internal JList.
     * @param value Whether the selection is undergoing a series of changes.
     * @see #getValueIsAdjusting() 
     * @see JList#setValueIsAdjusting(boolean)
     */
    public void setValueIsAdjusting(boolean value){
        getList().setValueIsAdjusting(value);
    }
    /**
     * This returns the color used to draw the foreground of selected items. 
     * This delegates to the {@link JList#getSelectionForeground() 
     * getSelectionForeground} method of the internal JList.
     * @return The foreground color of selected items.
     * @see JList#getSelectionForeground() 
     * @see #setSelectionForeground(java.awt.Color) 
     * @see #getSelectionBackground() 
     */
    public java.awt.Color getSelectionForeground(){
        return getList().getSelectionForeground();
    }
    /**
     * This sets the color to use to draw the foreground of selected items. This 
     * delegates to the {@link JList#setSelectionForeground(java.awt.Color) 
     * setSelectionForeground} method of the internal JList.
     * @param fg The foreground color for selected items in the list.
     * @see JList#setSelectionForeground(java.awt.Color) 
     * @see #getSelectionForeground() 
     * @see #setSelectionBackground(java.awt.Color) 
     */
    public void setSelectionForeground(java.awt.Color fg){
        getList().setSelectionForeground(fg);
    }
    /**
     * This returns the color used to draw the background of selected items. 
     * This delegates to the {@link JList#getSelectionBackground() 
     * getSelectionBackground} method of the internal JList.
     * @return The background color of selected items.
     * @see JList#getSelectionBackground() 
     * @see #setSelectionBackground(java.awt.Color) 
     * @see #getSelectionForeground() 
     */
    public java.awt.Color getSelectionBackground(){
        return getList().getSelectionBackground();
    }
    /**
     * This sets the color to use to draw the background of selected items. This 
     * delegates to the {@link JList#setSelectionBackground(java.awt.Color) 
     * setSelectionBackground} method of the internal JList.
     * @param bg The background color for selected items in the list.
     * @see JList#setSelectionBackground(java.awt.Color) 
     * @see #getSelectionBackground() 
     * @see #setSelectionForeground(java.awt.Color) 
     */
    public void setSelectionBackground(java.awt.Color bg){
        getList().setSelectionBackground(bg);
    }
    /**
     * This returns the data model that holds the list of items displayed by the 
     * list. This delegates to the {@link JList#getModel() getModel} method of 
     * the internal JList.
     * @return The ListModel that provides the list of items.
     * @see JList#getModel() 
     */
    public ListModel<E> getModel(){
        return getList().getModel();
    }
    /**
     * This sets the model that represents the contents of the list. This will 
     * also notify the property change listeners and clear the list's selection.
     * This delegates to the {@link JList#setModel(javax.swing.ListModel) 
     * setModel} method of the internal JList.
     * @param model The ListModel that provides the list of items (cannot be 
     * null).
     * @throws NullPointerException If the given model is null.
     * @see JList#setModel(javax.swing.ListModel) 
     * @see #getModel() 
     * @see #clearSelection() 
     */
    protected void setModel(ListModel<E> model){
        getList().setModel(Objects.requireNonNull(model, "Model cannot be null"));
    }
    /**
     * This returns the so called "prototypical" cell value, which is a value 
     * used to calculate a fixed width and height for the cells in the list. 
     * This delegates to the {@link JList#getPrototypeCellValue() 
     * getPrototypeCellValue} method of the internal JList.
     * @return The prototypical cell value, or null if there is no such value.
     * @see JList#getPrototypeCellValue()
     * @see #setPrototypeCellValue(java.lang.Object) 
     */
    public E getPrototypeCellValue(){
        return getList().getPrototypeCellValue();
    }
    /**
     * This sets the "prototypical" cell value used to calculate a fixed width 
     * and height for the cells in the list. This is useful when the list is too 
     * long to calculate each cell's width and height individually and there is 
     * a single cell value that is known to occupy as much space as any of the 
     * other values. Refer to the documentation for the {@link 
     * JList#setPrototypeCellValue(java.lang.Object) setPrototypeCellValue} 
     * method of JList for more information, as this method delegates to the 
     * {@code setPrototypeCellValue} method of the internal JList.
     * @param value The value on which to base the fixed cell width and height.
     * @see JList#setPrototypeCellValue(java.lang.Object)
     * @see #getPrototypeCellValue() 
     * @see #setFixedCellWidth(int) 
     * @see #setFixedCellHeight(int) 
     */
    public void setPrototypeCellValue(E value){
        getList().setPrototypeCellValue(value);
    }
    /**
     * This returns the fixed value to use for the width of the cells in the 
     * list. If this is -1, then the cell widths are computed using the cell 
     * renderer for each element in the list. This delegates to the {@link 
     * JList#getFixedCellWidth() getFixedCellWidth} method of the internal 
     * JList.
     * @return The fixed cell width, or -1 if the cell width is not a fixed 
     * value.
     * @see JList#getFixedCellWidth()
     * @see #setFixedCellWidth(int) 
     * @see #getFixedCellHeight() 
     */
    public int getFixedCellWidth(){
        return getList().getFixedCellWidth();
    }
    /**
     * This sets a fixed value to be used for the width of every cell in the 
     * list. If this is -1, then the cell widths are computed using the cell 
     * renderer for each element in the list. This delegates to the {@link 
     * JList#setFixedCellWidth(int) setFixedCellWidth} method of the internal 
     * JList.
     * @param width The width to be used for all the cells in the list, or -1 if 
     * the cell width is not a fixed value.
     * @see JList#setFixedCellWidth(int)
     * @see #getFixedCellWidth() 
     * @see #setFixedCellHeight(int) 
     * @see #setPrototypeCellValue(java.lang.Object) 
     */
    public void setFixedCellWidth(int width){
        getList().setFixedCellWidth(width);
    }
    /**
     * This returns the fixed value to use for the height of the cells in the 
     * list. If this is -1, then the cell height are computed using the cell 
     * renderer for each element in the list. This delegates to the {@link 
     * JList#getFixedCellHeight() getFixedCellHeight} method of the internal 
     * JList.
     * @return The fixed cell height, or -1 if the cell height is not a fixed 
     * value.
     * @see JList#getFixedCellHeight()
     * @see #setFixedCellHeight(int) 
     * @see #getFixedCellWidth() 
     */
    public int getFixedCellHeight(){
        return getList().getFixedCellHeight();
    }
    /**
     * This sets a fixed value to be used for the height of every cell in the 
     * list. If this is -1, then the cell height are computed using the cell 
     * renderer for each element in the list. This delegates to the {@link 
     * JList#setFixedCellHeight(int) setFixedCellHeight} method of the internal 
     * JList.
     * @param height The height to be used for all the cells in the list, or -1 
     * if the cell height is not a fixed value.
     * @see JList#setFixedCellHeight(int)
     * @see #getFixedCellHeight() 
     * @see #setFixedCellWidth(int) 
     * @see #setPrototypeCellValue(java.lang.Object) 
     */
    public void setFixedCellHeight(int height){
        getList().setFixedCellHeight(height);
    }
    /**
     * This returns the object responsible for rendering the items in the list. 
     * This delegates to the {@link JList#getCellRenderer() getCellRenderer} 
     * method of the internal JList.
     * @return The renderer used to render the list cells.
     * @see JList#getCellRenderer()
     * @see #setCellRenderer(javax.swing.ListCellRenderer) 
     */
    public javax.swing.ListCellRenderer<? super E> getCellRenderer(){
        return getList().getCellRenderer();
    }
    /**
     * This sets the object used to render each cell in the list. Refer to the 
     * documentation for the {@link 
     * JList#setCellRenderer(javax.swing.ListCellRenderer) setCellRenderer}
     * method of JList for more information, as this method delegates to the 
     * {@code setCellRenderer} method of the internal JList.
     * @param renderer The renderer to use to render the list cells.
     * @see JList#setCellRenderer(javax.swing.ListCellRenderer)
     * @see #getCellRenderer() 
     */
    public void setCellRenderer(javax.swing.ListCellRenderer<? super E> renderer){
        getList().setCellRenderer(renderer);
    }
    /**
     * This returns the visible row count for the list. Refer to the 
     * documentation for the {@link JList#setVisibleRowCount(int) 
     * setVisibleRowCount} method of JList for more information. This delegates 
     * to the {@link JList#getVisibleRowCount() getVisibleRowCount} method of 
     * the internal JList.
     * @return The preferred number of rows to display without requiring 
     * scrolling.
     * @see JList#getVisibleRowCount()
     * @see JList#setVisibleRowCount(int) 
     * @see #setVisibleRowCount(int) 
     */
    public int getVisibleRowCount(){
        return getList().getVisibleRowCount();
    }
    /**
     * This sets the visible row count for the list. This can have different 
     * meanings depending on the layout orientation of the list. As such, refer 
     * to the documentation for the {@link JList#setVisibleRowCount(int) 
     * setVisibleRowCount} method of JList for more information, as this method 
     * delegates to the {@code setVisibleRowCount} method of the internal JList.
     * @param visibleRowCount The preferred number of rows to display without 
     * requiring scrolling.
     * @see JList#setVisibleRowCount(int) 
     * @see #getVisibleRowCount() 
     * @see #setLayoutOrientation(int) 
     * @see JList#setLayoutOrientation(int) 
     */
    public void setVisibleRowCount(int visibleRowCount){
        getList().setVisibleRowCount(visibleRowCount);
    }
    /**
     * This returns the layout orientation for the list. Refer to the 
     * documentation for the {@link JList#getLayoutOrientation() 
     * getLayoutOrientation} method of JList for more information, as this 
     * method delegates to the {@code getLayoutOrientation} method of the 
     * internal JList.
     * @return The layout orientation of the list.
     * @see JList#getLayoutOrientation() 
     * @see JList#VERTICAL
     * @see JList#HORIZONTAL_WRAP
     * @see JList#VERTICAL_WRAP
     * @see #setLayoutOrientation(int) 
     * @see JList#setLayoutOrientation(int) 
     */
    public int getLayoutOrientation(){
        return getList().getLayoutOrientation();
    }
    /**
     * This sets the way in which the cells in the list are layed out. Refer to 
     * the documentation for the {@link JList#setLayoutOrientation(int) 
     * setLayoutOrientation} method of JList for more information, as this 
     * method delegates to the {@code setLayoutOrientation} method of the 
     * internal JList.
     * @param layoutOrientation The new layout orientation. This should be one 
     * of the following constants defined in {@code JList}: 
     *      {@link JList#VERTICAL VERTICAL}, 
     *      {@link JList#HORIZONTAL_WRAP HORIZONTAL_WRAP}, or 
     *      {@link JList#VERTICAL_WRAP VERTICAL_WRAP}.
     * @see JList#setLayoutOrientation(int) 
     * @see JList#VERTICAL
     * @see JList#HORIZONTAL_WRAP
     * @see JList#VERTICAL_WRAP
     * @see #getLayoutOrientation() 
     * @see #setVisibleRowCount(int) 
     */
    public void setLayoutOrientation(int layoutOrientation){
        getList().setLayoutOrientation(layoutOrientation);
    }
    /**
     * This returns the smallest list index that is currently visible, or -1 if 
     * nothing is visible or the list is empty. In a left-to-right orientation, 
     * the first visible cell is found closest to the list's upper-left corner, 
     * while in a right-to-left orientation it is found closest to the 
     * upper-right corner. Note that the returned cell may be only partially 
     * visible. This delegates to the {@link JList#getFirstVisibleIndex() 
     * getFirstVisibleIndex} method of the internal JList.
     * @return The index of the first visible cell in the list.
     * @see JList#getFirstVisibleIndex()
     * @see #getLastVisibleIndex() 
     */
    public int getFirstVisibleIndex(){
        return getList().getFirstVisibleIndex();
    }
    /**
     * This returns the largest list index that is currently visible, or -1 if 
     * nothing is visible or the list is empty. Note that the returned cell may 
     * be only partially visible. This delegates to the {@link 
     * JList#getLastVisibleIndex() getLastVisibleIndex} method of the internal 
     * JList.
     * @return The index of the last visible cell in the list.
     * @see JList#getLastVisibleIndex()
     * @see #getFirstVisibleIndex() 
     */
    public int getLastVisibleIndex(){
        return getList().getLastVisibleIndex();
    }
    /**
     * This scrolls the list to make the specified cell completely visible. <p>
     * If the given index is outside the list's range of cells, then this method 
     * will do nothing. This delegates to the {@link 
     * JList#ensureIndexIsVisible(int) ensureIndexIsVisible} method of the 
     * internal JList.
     * @param index The index of the cell to make visible.
     * @see JList#ensureIndexIsVisible(int)
     */
    public void ensureIndexIsVisible(int index){
        getList().ensureIndexIsVisible(index);
    }
    
    // Insert the rest of the JList cover methods here
    
    /**
     * This adds the given {@code ListSelectionListener} to this panel.
     * @param l The listener to add.
     * @see #removeListSelectionListener(javax.swing.event.ListSelectionListener) 
     * @see #getListSelectionListeners() 
     */
    public void addListSelectionListener(ListSelectionListener l){
        if (l != null)      // If the listener is not null
            listenerList.add(ListSelectionListener.class, l);
    }
    /**
     * This removes the given {@code ListSelectionListener} from this panel.
     * @param l The listener to remove.
     * @see #addListSelectionListener(javax.swing.event.ListSelectionListener) 
     * @see #getListSelectionListeners() 
     */
    public void removeListSelectionListener(ListSelectionListener l){
        listenerList.remove(ListSelectionListener.class, l);
    }
    /**
     * This returns an array containing all the {@code ListSelectionListener}s 
     * that have been added to this panel.
     * @return An array containing the ListSelectionListeners that have been 
     * added, or an empty array if none have been added.
     * @see #addListSelectionListener(javax.swing.event.ListSelectionListener) 
     * @see #removeListSelectionListener(javax.swing.event.ListSelectionListener) 
     */
    public ListSelectionListener[] getListSelectionListeners(){
        return listenerList.getListeners(ListSelectionListener.class);
    }
    /**
     * This adds the given {@code ListDataListener} to this panel.
     * @param l The listener to add.
     * @see #removeListDataListener(javax.swing.event.ListDataListener) 
     * @see #getListDataListeners() 
     */
    public void addListDataListener(ListDataListener l){
        if (l != null)      // If the listener is not null
            listenerList.add(ListDataListener.class, l);
    }
    /**
     * This removes the given {@code ListDataListener} from this panel.
     * @param l The listener to remove.
     * @see #addListDataListener(javax.swing.event.ListDataListener) 
     * @see #getListDataListeners() 
     */
    public void removeListDataListener(ListDataListener l){
        listenerList.remove(ListDataListener.class, l);
    }
    /**
     * This returns an array containing all the {@code ListDataListeners}s that 
     * have been added to this panel.
     * @return An array containing the ListDataListeners that have been added, 
     * or an empty array if none have been added.
     * @see #addListDataListener(javax.swing.event.ListDataListener) 
     * @see #removeListDataListener(javax.swing.event.ListDataListener) 
     */
    public ListDataListener[] getListDataListeners(){
        return listenerList.getListeners(ListDataListener.class);
    }
    @Override
    public void setFont(java.awt.Font font){
        super.setFont(font);
        try{
            getList().setFont(font);
            getScrollPane().setFont(font);
        }catch(NullPointerException ex){}
    }
    @Override
    public void setEnabled(boolean enabled){
        super.setEnabled(enabled);
        try{
            getList().setEnabled(enabled);
        }catch(NullPointerException ex){}
    }
    @Override
    protected String paramString(){
            // Get the text for the list title
        String listTitleStr = getListTitle();
        return super.paramString()+
                    // If the list title is not null, use it
                ",listTitle="+((listTitleStr!=null)?listTitleStr:"")+
                ",list="+getList();
    }
    /**
     * {@inheritDoc } This has been overridden to return false so as to not 
     * allow the controls to be hidden.
     * @return false
     * @see #setControlsAreVisible(boolean) 
     * @see #getControls() 
     * @see #setControlButtonsAreShown(boolean) 
     * @see #getControlButtonsAreShown() 
     */
    @Override
    protected boolean getControlsCanBeHidden(){
        return false;
    }
    @Override
    protected java.awt.Component[] getControls(){
        return new java.awt.Component[]{
            getAcceptButton(),getCancelButton(),getControlPanel()
        };
    }
    /**
     * This is the handler used to listen to the list, its models, and the 
     * scroll pane.
     */
    private Handler handler;
    /**
     * This is the label used to display a title above the list of items.
     */
    private javax.swing.JLabel nameLabel;
    /**
     * This is the scroll pane used to scroll the list of items.
     */
    private javax.swing.JScrollPane scrollPane;
    /**
     * This is the list used to display a list of items.
     */
    private JList<E> list;
    /**
     * This is the panel on the right side of this panel used to contain some 
     * side accessory.
     */
    private javax.swing.JPanel sidePanel;
    /**
     * This is the panel at the bottom of this panel used to contain the control 
     * panel and the bottom accessory panel.
     */
    private javax.swing.JPanel fullBottomPanel;
    /**
     * This is the panel at the bottom of this panel used to contain some bottom 
     * accessory.
     */
    private javax.swing.JPanel bottomPanel;
    /**
     * This is the panel that contains the control buttons.
     */
    private javax.swing.JPanel controlPanel;
    /**
     * This is invoked when a change to the selection on the list occurs.
     * @param evt The ListSelectionEvent to be processed.
     * @see ListSelectionListener#valueChanged(javax.swing.event.ListSelectionEvent) 
     */
    protected void listSelectionChanged(ListSelectionEvent evt){ }
    /**
     * This is invoked when elements are added to the list model.
     * @param evt The ListDataEvent to be processed.
     * @see ListDataListener#intervalAdded(javax.swing.event.ListDataEvent) 
     */
    protected void listDataIntervalAdded(ListDataEvent evt){ }
    /**
     * This is invoked when elements are removed from the list model.
     * @param evt The ListDataEvent to be processed.
     * @see ListDataListener#intervalRemoved(javax.swing.event.ListDataEvent) 
     */
    protected void listDataIntervalRemoved(ListDataEvent evt){ }
    /**
     * This is invoked when the contents of the list model are changed.
     * @param evt The ListDataEvent to be processed.
     * @see ListDataListener#contentsChanged(javax.swing.event.ListDataEvent) 
     */
    protected void listDataContentsChanged(ListDataEvent evt){ }
    /**
     * This is invoked when a property is changed in the list before the 
     * PropertyChangeListeners registered to this panel are notified.
     * @param evt The PropertyChangeEvent to be processed.
     */
    protected void listPropertyChange(PropertyChangeEvent evt) { }
    /**
     * This redirects the given ListDataEvent to refer to this panel as the 
     * source of the event.
     * @param evt The ListDataEvent to redirect.
     * @return The redirected ListDataEvent, or null if the given ListDataEvent 
     * is null.
     */
    private ListDataEvent redirectEvent(ListDataEvent evt){
            // If the event is not null, redirect it to show this as the source.
        return (evt != null) ? new ListDataEvent(this,evt.getType(),
                evt.getIndex0(),evt.getIndex1()) : null;
    }
    /**
     * This is a handler class that handles changes to the list selection, list 
     * data, and properties of the list or scroll pane. This will forward some 
     * property changes made to the list and/or scroll pane to the 
     * PropertyChangeListeners registered to this ListDataPanel.
     */
    private class Handler implements PropertyChangeListener, ListSelectionListener, 
            ListDataListener{
        @Override
        public void propertyChange(PropertyChangeEvent evt) {
                // If the property name is null or the old value is the same as the new one
            if (evt.getPropertyName() == null || evt.getOldValue() == evt.getNewValue())
                return;
            if (evt.getSource() == getList()){          // If the source is the list
                listPropertyChange(evt);
                switch(evt.getPropertyName()){
                    case("model"):                      // If the model has changed
                        if (evt.getOldValue() != null)  // If the old model is not null
                            ((ListModel)evt.getOldValue()).removeListDataListener(this);
                        if (evt.getNewValue() != null)  // If the new model is not null
                            ((ListModel)evt.getNewValue()).addListDataListener(this);
                        // Changes to these properties will be forwarded to the 
                        // panel's change listeners
                    
                    case("selectionBackground"):
                    case("selectionForeground"):
                    case("fixedCellWidth"):
                    case("fixedCellHeight"):
                    case("prototypeCellValue"):
                    case("visibleRowCount"):
                    case("layoutOrientation"):
                    case("cellRenderer"):
                    case("selectionModel"):
                            // Forward these changes to the property change listeners
                        firePropertyChange(evt.getPropertyName(),evt.getOldValue(),evt.getNewValue());
                }
            }
        }
        @Override
        public void valueChanged(ListSelectionEvent evt) {
            listSelectionChanged(evt);
            if (evt != null)    // If the event is not null
                    // Redirect the event to point to this as the source
                evt = new ListSelectionEvent(ListDataPanel.this,evt.getFirstIndex(),
                        evt.getLastIndex(),evt.getValueIsAdjusting());
                // A for loop to go through the list selection listeners
            for (ListSelectionListener l : listenerList.getListeners(ListSelectionListener.class)){
                if (l != null)      // If the listener is not null
                    l.valueChanged(evt);
            }
        }
        @Override
        public void intervalAdded(ListDataEvent evt) {
            listDataIntervalAdded(evt);
            evt = redirectEvent(evt);
                // A for loop to go through the list data listeners
            for (ListDataListener l : listenerList.getListeners(ListDataListener.class)){
                if (l != null)      // If the listener is not null
                    l.intervalAdded(evt);
            }
        }
        @Override
        public void intervalRemoved(ListDataEvent evt) {
            listDataIntervalRemoved(evt);
            evt = redirectEvent(evt);
                // A for loop to go through the list data listeners
            for (ListDataListener l : listenerList.getListeners(ListDataListener.class)){
                if (l != null)      // If the listener is not null
                    l.intervalRemoved(evt);
            }
        }
        @Override
        public void contentsChanged(ListDataEvent evt) {
            listDataContentsChanged(evt);
            evt = redirectEvent(evt);
                // A for loop to go through the list data listeners
            for (ListDataListener l : listenerList.getListeners(ListDataListener.class)){
                if (l != null)      // If the listener is not null
                    l.contentsChanged(evt);
            }
        }
    }
}
