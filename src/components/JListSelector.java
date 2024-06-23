/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package components;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 * This is a panel that can be used to select elements in a list, as well as 
 * providing the ability to pop up a dialog box to select the elements.
 * @author Milo Steier
 * @param <E> The data type of the elements for the list.
 * @see JListManipulator
 * @see JList
 */
public class JListSelector<E> extends AbstractConfirmDialogPanel{
    /**
     * This identifies that the text displayed above the list has changed.
     */
    public static final String LIST_TITLE_PROPERTY_CHANGED = 
            "ListTitlePropertyChanged";
    /**
     * This identifies that the accessory component to the side of the list has 
     * changed.
     */
    public static final String SIDE_ACCESSORY_PROPERTY_CHANGED = 
            "SideAccessoryPropertyChanged";
    /**
     * This identifies that the accessory component under the list has changed.
     */
    public static final String BOTTOM_ACCESSORY_PROPERTY_CHANGED = 
            "BottomAccessoryPropertyChanged";
    /**
     * This constructs a panel that has a border layout with the given 
     * horizontal and vertical gap, and that is placed in the given parent 
     * container using the given constraints. This is used to create the side 
     * and bottom panels, along with the panels used to contain the accessories.
     * @param parent The parent for the panel.
     * @param constraints The constraints to use for placing the panel.
     * @param hgap The horizontal gap for the panel's border layout.
     * @param vgap The vertical gap for the panel's border layout.
     * @return The panel that was created.
     */
    private JPanel createPanel(Container parent, Object constraints, int hgap, 
            int vgap){
            // This creates a panel with a border layout with the given 
            // horizontal and vertical gap
        JPanel panel = new JPanel(new BorderLayout(hgap, vgap));
        panel.setInheritsPopupMenu(true);
        panel.addContainerListener(visHandler);
        parent.add(panel, constraints);
        return panel;
    }
    /**
     * This constructs a panel used to contain and display an accessory. The 
     * panel is added to the center of the given parent container.
     * @param parent The parent for the panel.
     * @return The panel that was created.
     * @see #createPanel 
     */
    private JPanel createAccessoryPanel(Container parent){
        return createPanel(parent,BorderLayout.CENTER,0,0);
    }
    /**
     * This initializes the components of this list selector.
     * @param model The model for the list (may be null).
     */
    private void initialize(ListModel<E> model){
        handler = new Handler();
        visHandler = new ParentVisibilityHandler();
        setBorder(BorderFactory.createEmptyBorder(11, 10, 11, 10));
        setMinimumSize(new Dimension(480, 320));
        setPreferredSize(new Dimension(480, 320));
        list = new JList<>();
        if (model != null){         // If the model is not null
            list.setModel(model);
            model.addListDataListener(handler);
            if (model instanceof ListModelList) // If the model is a ListModelList
                modelList = (ListModelList<E>) model;
        }
        list.setInheritsPopupMenu(true);
        list.addMouseListener(getDisabledComponentListener());
        list.addListSelectionListener(handler);
        list.addPropertyChangeListener(handler);
        scrollPane = new JScrollPane(list);
        scrollPane.setInheritsPopupMenu(true);
        scrollPane.addMouseListener(getDisabledComponentListener());
        scrollPane.addPropertyChangeListener(handler);
        add(scrollPane, BorderLayout.CENTER);
        
        sidePanel = createPanel(this,BorderLayout.LINE_END,0,7);
        sidePanel.setVisible(false);
        
        bottomPanel = createPanel(this,BorderLayout.PAGE_END,6,0);
        controlPanel = new JPanel(new GridLayout(1, 0, 6, 0));
        controlPanel.setInheritsPopupMenu(true);
        controlPanel.add(acceptButton);
        controlPanel.add(cancelButton);
        bottomPanel.add(controlPanel, BorderLayout.LINE_END);
        
        nameLabel = new JLabel();
        nameLabel.setLabelFor(list);
        nameLabel.setInheritsPopupMenu(true);
        add(nameLabel, BorderLayout.PAGE_START);
        nameLabel.setVisible(false);
        updateAcceptEnabled();
    }
    /**
     * This constructs a {@code JListSelector} with the given model and title 
     * for the dialog. If the given model is null, then an empty, read-only 
     * model will be created and used instead.
     * @param model The model for the list, or null.
     * @param title The title for the dialog.
     */
    public JListSelector(ListModel<E> model, String title){
        super(new BorderLayout(10, 11), title);
        initialize(model);
    }
    /**
     * This constructs a {@code JListSelector} with the given model. If the 
     * given model is null, then an empty, read-only model will be created and 
     * used instead.
     * @param model The model for the list, or null.
     */
    public JListSelector(ListModel<E> model){
        this(model,null);
    }
    /**
     * This constructs a {@code JListSelector} with the given model and title 
     * for the dialog. If the given model is null, then an empty, read-only 
     * model will be created and used instead.
     * @param model The model for the list, or null.
     * @param title The title for the dialog.
     */
    public JListSelector(ListModelList<E> model, String title){
        this((ListModel<E>)model,title);
    }
    /**
     * This constructs a {@code JListSelector} with the given model. If the 
     * given model is null, then an empty, read-only model will be created and 
     * used instead.
     * @param model The model for the list, or null.
     */
    public JListSelector(ListModelList<E> model){
        this(model,null);
    }
    /**
     * This constructs a {@code JListSelector} with the given list of elements 
     * for the list and the title for the dialog. This constructor constructs a 
     * {@link ListModelList ListModelList} from the given list and uses that for 
     * the model. <p>
     * 
     * Attempts to pass a {@code null} value to this method will result in an 
     * exception being thrown. The created model does not reference the given 
     * list directly, and as such, any attempt to modify the list after creating 
     * this {@code JListSelector} will not affect the model.
     * 
     * @param c The list of elements to be loaded into the list model (cannot be 
     * null).
     * @param title The title for the dialog.
     * @throws NullPointerException If the list of elements is null.
     * @see ListModelList
     * @see ListModelList#ListModelList(Collection) 
     */
    public JListSelector(List<? extends E> c, String title){
        this(new ListModelList<E>(c),title);
    }
    /**
     * This constructs a {@code JListSelector} with the given list of elements 
     * for the list. This constructor constructs a {@link ListModelList 
     * ListModelList} from the given list and uses that for the model. <p>
     * 
     * Attempts to pass a {@code null} value to this method will result in an 
     * exception being thrown. The created model does not reference the given 
     * list directly, and as such, any attempt to modify the list after creating 
     * this {@code JListSelector} will not affect the model.
     * 
     * @param c The list of elements to be loaded into the list model (cannot be 
     * null).
     * @throws NullPointerException If the list of elements is null.
     * @see ListModelList
     * @see ListModelList#ListModelList(Collection) 
     */
    public JListSelector(List<? extends E> c){
        this(c,null);
    }
    /**
     * This constructs a {@code JListSelector} with the given array of elements 
     * for the list and the title for the dialog. This constructor constructs a 
     * {@link ListModelList ListModelList} from the given array. <p>
     * 
     * Attempts to pass a {@code null} value to this method will result in an 
     * exception being thrown. The created model does not reference the given 
     * array directly, and as such, any attempt to modify the array after 
     * creating this {@code JListSelector} will not affect the model.
     * 
     * @param arr The array of elements to be loaded into the list model (cannot 
     * be null).
     * @param title The title for the dialog.
     * @throws NullPointerException If the array of elements is null.
     * @see ListModelList
     * @see ListModelList#ListModelList(Object[]) 
     */
    public JListSelector(E[] arr, String title){
        this(new ListModelList<E>(arr),title);
    }
    /**
     * This constructs a {@code JListSelector} with the given array of elements 
     * for the list. This constructor constructs a {@link ListModelList 
     * ListModelList} from the given array. <p>
     * 
     * Attempts to pass a {@code null} value to this method will result in an 
     * exception being thrown. The created model does not reference the given 
     * array directly, and as such, any attempt to modify the array after 
     * creating this {@code JListSelector} will not affect the model.
     * 
     * @param arr The array of elements to be loaded into the list model (cannot 
     * be null).
     * @throws NullPointerException If the array of elements is null.
     * @see ListModelList
     * @see ListModelList#ListModelList(Object[]) 
     */
    public JListSelector(E[] arr){
        this(arr,null);
    }
    /**
     * This constructs a {@code JListSelector} with an empty, read-only model 
     * and the given title for the dialog.
     * @param title The title for the dialog.
     */
    public JListSelector(String title){
        this((ListModel<E>)null, title);
    }
    /**
     * This constructs a {@code JListSelector} with an empty, read-only model.
     */
    public JListSelector(){
        this((String)null);
    }
    /**
     * {@inheritDoc }
     * @see #getAcceptButton 
     * @see #isAcceptButtonToolTipTextSet 
     * @see #getAcceptButtonToolTipText 
     * @see #setAcceptButtonToolTipText 
     * @see #updateButtonText 
     */
    @Override
    protected String getDefaultAcceptButtonToolTipText() {
        return "Approve the current selection";
    }
    /**
     * {@inheritDoc }
     * @see #getCancelButton 
     * @see #isCancelButtonToolTipTextSet 
     * @see #getCancelButtonToolTipText 
     * @see #setCancelButtonToolTipText 
     * @see #updateButtonText 
     */
    @Override
    protected String getDefaultCancelButtonToolTipText() {
        return "Abort the selection dialog";
    }
    /**
     * This returns the internal {@code JList} used to display a list of data.
     * @return The {@code JList} used to display a list of data.
     */
    public JList<E> getList(){
        return list;
    }
    /**
     * This returns the scroll pane used to scroll the list of data.
     * @return The scroll pane for the internal {@code JList}.
     * @see #getList() 
     */
    public JScrollPane getScrollPane(){
        return scrollPane;
    }
    /**
     * This returns the text displayed above the list.
     * @return The text displayed above the list.
     * @see #setListTitle(java.lang.String) 
     */
    public String getListTitle(){
        return nameLabel.getText();
    }
    /**
     * This sets the text to display above the list.
     * @param text The text to display above the list.
     * @see #getListTitle() 
     */
    public void setListTitle(String text){
        String old = getListTitle();    // Get the old title
        if (Objects.equals(old, text)) // If the new title matches the old title
            return;
        nameLabel.setText(text);
        nameLabel.setVisible(text != null && !text.isEmpty());
        firePropertyChange(LIST_TITLE_PROPERTY_CHANGED,old,text);
    }
    /**
     * This returns an array of components that are visible in the given 
     * container.
     * @param c The container to get the visible components from.
     * @return An array of components from the given container that are visible, 
     * or an empty array if the container is empty or has no visible components.
     * @see #containsVisibleComponents 
     * @see Component#isVisible 
     */
    protected Component[] getVisibleComponents(Container c){
            // A list to get the visible components in the container
        ArrayList<Component> compList = new ArrayList<>(
                Arrays.asList(c.getComponents()));
            // Remove any component that is either null or not visible
        compList.removeIf((Component t) -> t == null || !t.isVisible());
        return compList.toArray(Component[]::new);
    }
    /**
     * This goes through the components in the given container and returns 
     * whether there is at least one component that is visible. If the container 
     * is empty or no components in the container are visible, then this returns 
     * false.
     * @param c The container to check.
     * @return Whether the container contains at least one visible component.
     * @see Component#isVisible 
     * @see #getVisibleComponents 
     * @see #updateContainerVisibility 
     * @see #updateParentVisibility 
     */
    protected boolean containsVisibleComponents(Container c){
            // Go through the components in the container
        for (int i = 0; i < c.getComponentCount(); i++){
                // Get the component at the current index
            Component temp = c.getComponent(i);
                // If the component is non-null and visible
            if (temp != null && temp.isVisible())   
                return true;
        }
        return false;
    }
    /**
     * This updates the visibility of the given container based off whether any 
     * of the components in the container are visible. This effectively 
     * calls {@link #containsVisibleComponents containsVisibleComponents} with 
     * the given container and sets the container's visibility based of the 
     * value returned.
     * @param c The container to update the visibility of.
     * @see #containsVisibleComponents 
     * @see #updateParentVisibility 
     */
    protected void updateContainerVisibility(Container c){
        c.setVisible(containsVisibleComponents(c));
    }
    /**
     * This updates the visibility of the parent of the given component. This 
     * effectively calls {@link #updateContainerVisibility 
     * updateContainerVisibility} with the parent of the given component.
     * @param c The component to update the parent's visibility.
     * @see #updateContainerVisibility 
     * @see #containsVisibleComponents 
     * @see Component#getParent 
     */
    protected void updateParentVisibility(Component c){
            // If neither the component or its parent are null.
        if (c == null || c.getParent() == null)
            return;
        updateContainerVisibility(c.getParent());
    }
    /**
     * This updates the panel used to display an accessory to no longer display 
     * the old accessory and display the new accessory instead. The new 
     * accessory is added to the center of the panel.
     * @param oldAccessory The old accessory that will no longer be displayed, 
     * or null.
     * @param newAccessory The new accessory that will be displayed, or null.
     * @param panel The panel displaying the accessory.
     * @see #setSideAccessory 
     * @see #setBottomAccessory 
     */
    protected void updateAccessoryPanel(JComponent oldAccessory, 
            JComponent newAccessory, JPanel panel){
        if (oldAccessory != null)       // If the old accessory is not null
            panel.remove(oldAccessory);
        if (newAccessory != null)       // If the new accessory is not null
            panel.add(newAccessory,BorderLayout.CENTER);
        panel.revalidate();
        panel.repaint();
//        if (panel.getParent() != null)  // If the panel has a parent
//            panel.getParent().revalidate();
    }
    /**
     * This sets the accessory component to display to the right of the list 
     * above the control panel. The accessory components can be used to add 
     * additional controls such as a button to add items to the list. <p>
     * 
     * Note: If there was a previous accessory, you should remove any listeners 
     * that the accessory may have added to this {@code JListSelector}.
     * 
     * @param accessory The side accessory component.
     * @see #getSideAccessory 
     * @see #setBottomAccessory 
     * @see #getBottomAccessory 
     */
    public void setSideAccessory(JComponent accessory){
            // If the side accessory would not be changed
        if (accessory == sideAccessory)
            return;
        JComponent old = sideAccessory;     // Get the old side accessory
        sideAccessory = accessory;
        firePropertyChange(SIDE_ACCESSORY_PROPERTY_CHANGED,old,accessory);
            // If the side accessory panel is not initialized
        if (sideAccessoryPanel == null)
            sideAccessoryPanel = createAccessoryPanel(sidePanel);
        updateAccessoryPanel(old,accessory,sideAccessoryPanel);
    }
    /**
     * This returns the accessory component displayed to the right of the list 
     * above the control panel.
     * @return The side accessory component, or null.
     * @see #setSideAccessory 
     * @see #getBottomAccessory 
     * @see #setBottomAccessory 
     */
    public JComponent getSideAccessory(){
        return sideAccessory;
    }
    /**
     * This sets the accessory component to display at the bottom next to the 
     * control buttons. The accessory components can be used to add additional 
     * controls such as a button to add items to the list. <p>
     * 
     * Note: If there was a previous accessory, you should remove any listeners 
     * that the accessory may have added to this {@code JListSelector}.
     * 
     * @param accessory The bottom accessory component.
     * @see #getBottomAccessory 
     * @see #setSideAccessory 
     * @see #getSideAccessory 
     */
    public void setBottomAccessory(JComponent accessory){
            // If the bottom accessory would not be changed
        if (accessory == bottomAccessory)   
            return;
        JComponent old = bottomAccessory;   // Get the old bottom accessory
        bottomAccessory = accessory;
        firePropertyChange(BOTTOM_ACCESSORY_PROPERTY_CHANGED,old,accessory);
            // If the bottom accessory panel is not initialized
        if (bottomAccessoryPanel == null)
            bottomAccessoryPanel = createAccessoryPanel(bottomPanel);
        updateAccessoryPanel(old,accessory,bottomAccessoryPanel);
    }
    /**
     * This returns the accessory component displayed at the bottom of this 
     * panel next to the control buttons.
     * @return The bottom accessory component, or null.
     * @see #setBottomAccessory 
     * @see #getSideAccessory 
     * @see #setSideAccessory 
     */
    public JComponent getBottomAccessory(){
        return bottomAccessory;
    }
    @Override
    public void setForeground(Color fg){
        super.setForeground(fg);
        try{
            scrollPane.setForeground(fg);
            sidePanel.setForeground(fg);
            bottomPanel.setForeground(fg);
            sideAccessoryPanel.setForeground(fg);
            bottomAccessoryPanel.setForeground(fg);
            controlPanel.setForeground(fg);
            nameLabel.setForeground(fg);
            list.setForeground(fg);
        }catch(NullPointerException ex){}
    }
    @Override
    public void setBackground(Color bg){
        super.setBackground(bg);
        try{
            scrollPane.setBackground(bg);
            sidePanel.setBackground(bg);
            bottomPanel.setBackground(bg);
            sideAccessoryPanel.setBackground(bg);
            bottomAccessoryPanel.setBackground(bg);
            controlPanel.setBackground(bg);
            nameLabel.setBackground(bg);
        }catch(NullPointerException ex){}
    }
    // TODO: Implement changing the list's foreground, with it falling back onto 
    // the panel's foreground when not set
//    public boolean isListForegroundSet(){
//        
//    }
//    
//    public Color getListForeground(){
//        return getList().getForeground();
//    }
//    
//    public void setListForeground(Color fg)
    /**
     * This returns the background color of the list.
     * @return The background color of the list.
     * @see #setListBackground 
     * @see #getBackground 
     * @see #setBackground 
     * @see #getList 
     */
    public Color getListBackground(){
        return list.getBackground();
    }
    /**
     * This sets the background color of the list. 
     * @param bg The background color for the list.
     * @see #getListBackground 
     * @see #setBackground 
     * @see #getBackground 
     * @see #getList 
     */
    public void setListBackground(Color bg){
        list.setBackground(bg);
    }
    /**
     * This returns whether the list is set to scroll automatically when its 
     * contents are dragged. This delegates to the {@link JList#getAutoscrolls 
     * getAutoscrolls} method of the internal {@code JList}.
     * @return Whether the list will scroll automatically when its contents are 
     * dragged.
     * @see JList#getAutoscrolls 
     * @see #setListAutoscrolls 
     * @see #getAutoscrolls 
     * @see #setAutoscrolls 
     * @see #getList 
     */
    public boolean getListAutoscrolls(){
        return list.getAutoscrolls();
    }
    /**
     * This sets whether the list is set to scroll automatically when its 
     * contents are dragged. This delegates to the {@link JList#setAutoscrolls 
     * setAutoscrolls} method of the internal {@code JList}.
     * @param autoscrolls Whether the list will scroll automatically when its 
     * contents are dragged.
     * @see JList#setAutoscrolls 
     * @see #getListAutoscrolls 
     * @see #getAutoscrolls 
     * @see #setAutoscrolls 
     * @see #getList 
     */
    public void setListAutoscrolls(boolean autoscrolls){
        list.setAutoscrolls(autoscrolls);
    }
    /**
     * This returns the current selection model for the list. This is the model 
     * responsible for maintaining the selection state of the list. This 
     * delegates to the {@link JList#getSelectionModel getSelectionModel} method 
     * of the internal {@code JList}.
     * @return The ListSelectionModel that maintains the list's selections.
     * @see #setSelectionModel 
     * @see JList#getSelectionModel 
     * @see #getList 
     */
    public ListSelectionModel getSelectionModel(){
        return list.getSelectionModel();
    }
    /**
     * This sets the selection model for the list. The selection model is 
     * responsible for handling the task of making single selections, as well as 
     * both continuous and non-continuous selections. This delegates to the 
     * {@link JList#setSelectionModel setSelectionModel} method of the internal 
     * {@code JList}.
     * @param model The ListSelectionModel to use (cannot be null).
     * @throws NullPointerException If the given selection model is null.
     * @see #getSelectionModel 
     * @see JList#setSelectionModel 
     * @see #getList 
     */
    public void setSelectionModel(ListSelectionModel model){
        list.setSelectionModel(Objects.requireNonNull(model,"Selection model cannot be null"));
        updateAcceptEnabled();
    }
    /**
     * This returns the current selection mode for the list. This delegates to 
     * the {@link JList#getSelectionMode() getSelectionMode} method of the 
     * internal {@code JList}. 
     * @return The current selection mode for the list.
     * @see JList#getSelectionMode()
     * @see #setSelectionMode(int) 
     * @see JList#setSelectionMode(int)
     * @see ListSelectionModel#SINGLE_SELECTION
     * @see ListSelectionModel#SINGLE_INTERVAL_SELECTION
     * @see ListSelectionModel#MULTIPLE_INTERVAL_SELECTION
     * @see #getList() 
     */
    public int getSelectionMode(){
        return list.getSelectionMode();
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
     * @see #getList() 
     */
    public void setSelectionMode(int mode){
        list.setSelectionMode(mode);
        updateAcceptEnabled();
    }
    /**
     * This returns whether nothing is currently selected. This delegates to the 
     * {@link JList#isSelectionEmpty() isSelectionEmpty} method of the internal 
     * JList.
     * @return true if nothing is selected, otherwise false.
     * @see #clearSelection() 
     * @see JList#isSelectionEmpty()
     * @see #getList() 
     */
    public boolean isSelectionEmpty(){
        return list.isSelectionEmpty();
    }
    /**
     * This clears the selection. This delegates to the {@link 
     * JList#clearSelection() clearSelection} method of the internal JList.
     * @see #isSelectionEmpty() 
     * @see JList#clearSelection()
     * @see #getList() 
     */
    public void clearSelection(){
        list.clearSelection();
    }
    /**
     * This returns the number of items that are currently selected. This 
     * delegates to the {@link ListSelectionModel#getSelectedItemsCount() 
     * getSelectedItemsCount} method of the internal JList's {@link 
     * #getSelectionModel() selection model}.
     * @return The amount of selected items, or 0 if no items are selected.
     * @see #getSelectionModel() 
     * @see ListSelectionModel#getSelectedItemsCount()
     * @see #getList() 
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
     * @see #getList() 
     */
    public int getAnchorSelectionIndex(){
        return list.getAnchorSelectionIndex();
    }
    /**
     * This returns the lead selection index. This delegates to the {@link 
     * JList#getLeadSelectionIndex() getLeadSelectionIndex} method of the 
     * internal JList.
     * @return The lead selection index.
     * @see JList#getLeadSelectionIndex()
     * @see #getList() 
     */
    public int getLeadSelectionIndex(){
        return list.getLeadSelectionIndex();
    }
    /**
     * This returns the index of the selected cell with the smallest index, or 
     * -1 if the selection is empty. This delegates to the {@link 
     * JList#getMinSelectionIndex() getMinSelectionIndex} method of the internal 
     * JList.
     * @return The smallest selected cell index, or -1 if nothing is selected.
     * @see JList#getMinSelectionIndex()
     * @see #getList() 
     */
    public int getMinSelectionIndex(){
        return list.getMinSelectionIndex();
    }
    /**
     * This returns the index of the selected cell with the largest index, or 
     * -1 if the selection is empty. This delegates to the {@link 
     * JList#getMaxSelectionIndex() getMaxSelectionIndex} method of the internal 
     * JList.
     * @return The largest selected cell index, or -1 if nothing is selected.
     * @see JList#getMaxSelectionIndex()
     * @see #getList() 
     */
    public int getMaxSelectionIndex(){
        return list.getMaxSelectionIndex();
    }
    /**
     * This returns whether the given index is selected. This delegates to the 
     * {@link JList#isSelectedIndex(int) isSelectedIndex} method of the internal 
     * JList.
     * @param index The index to check to see if it is selected.
     * @return true if the given index is selected, otherwise false.
     * @see #setSelectedIndex(int) 
     * @see JList#isSelectedIndex(int)
     * @see #getList() 
     */
    public boolean isSelectedIndex(int index){
        return list.isSelectedIndex(index);
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
     * @see #getList() 
     */
    public int getSelectedIndex(){
        return list.getSelectedIndex();
    }
    /**
     * This selects a single cell. This will do nothing if the given index is 
     * greater than or equal to the model's size. This delegates to the {@link 
     * JList#setSelectedIndex(int) setSelectedIndex} method of the internal 
     * JList.
     * @param index The index of the cell to select.
     * @see #isSelectedIndex(int) 
     * @see JList#setSelectedIndex(int)
     * @see #getList() 
     */
    public void setSelectedIndex(int index){
        list.setSelectedIndex(index);
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
     * @see #getList() 
     */
    public E getSelectedValue(){
        return list.getSelectedValue();
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
     * @see #getList() 
     */
    public void setSelectedValue(Object value, boolean shouldScroll){
        list.setSelectedValue(value, shouldScroll);
    }
    /**
     * This returns an array of all of the selected indices, in increasing 
     * order. This delegates to the {@link JList#getSelectedIndices() 
     * getSelectedIndices} method of the internal JList.
     * @return An array containing all of the selected indices, in increasing 
     * order, or an empty array if nothing is selected.
     * @see #setSelectedIndices(int[]) 
     * @see JList#getSelectedIndices() 
     * @see #getList() 
     */
    public int[] getSelectedIndices(){
        return list.getSelectedIndices();
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
     * @see #getList() 
     */
    public void setSelectedIndices(int[] indices){
        list.setSelectedIndices(indices);
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
     * @see #getList() 
     */
    public List<E> getSelectedValuesList(){
        return list.getSelectedValuesList();
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
     * @see #getList() 
     */
    public void setSelectionInterval(int anchor, int lead){
        list.setSelectionInterval(anchor, lead);
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
     * @see #getList() 
     */
    public void addSelectionInterval(int anchor, int lead){
        list.addSelectionInterval(anchor, lead);
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
     * @see #getList() 
     */
    public void removeSelectionInterval(int index0, int index1){
        list.removeSelectionInterval(index0, index1);
    }
    /**
     * This returns whether the selection is undergoing a series of changes. 
     * This delegates to the {@link JList#getValueIsAdjusting() 
     * getValueIsAdjusting} method of the internal JList.
     * @return Whether the selection is undergoing a series of changes.
     * @see #setValueIsAdjusting(boolean) 
     * @see JList#getValueIsAdjusting() 
     * @see #getList() 
     */
    public boolean getValueIsAdjusting(){
        return list.getValueIsAdjusting();
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
     * @see #getList() 
     */
    public void setValueIsAdjusting(boolean value){
        list.setValueIsAdjusting(value);
    }
    /**
     * This returns the color used to draw the foreground of selected items. 
     * This delegates to the {@link JList#getSelectionForeground 
     * getSelectionForeground} method of the internal JList.
     * @return The foreground color of selected items.
     * @see JList#getSelectionForeground 
     * @see #setSelectionForeground 
     * @see #getSelectionBackground 
     * @see #getList 
     */
    public Color getSelectionForeground(){
        return list.getSelectionForeground();
    }
    /**
     * This sets the color to use to draw the foreground of selected items. This 
     * delegates to the {@link JList#setSelectionForeground 
     * setSelectionForeground} method of the internal JList.
     * @param fg The foreground color for selected items in the list.
     * @see JList#setSelectionForeground 
     * @see #getSelectionForeground 
     * @see #setSelectionBackground 
     * @see #getList 
     */
    public void setSelectionForeground(Color fg){
        list.setSelectionForeground(fg);
    }
    /**
     * This returns the color used to draw the background of selected items. 
     * This delegates to the {@link JList#getSelectionBackground 
     * getSelectionBackground} method of the internal JList.
     * @return The background color of selected items.
     * @see JList#getSelectionBackground 
     * @see #setSelectionBackground 
     * @see #getSelectionForeground 
     * @see #getList 
     */
    public Color getSelectionBackground(){
        return list.getSelectionBackground();
    }
    /**
     * This sets the color to use to draw the background of selected items. This 
     * delegates to the {@link JList#setSelectionBackground 
     * setSelectionBackground} method of the internal JList.
     * @param bg The background color for selected items in the list.
     * @see JList#setSelectionBackground 
     * @see #getSelectionBackground 
     * @see #setSelectionForeground 
     * @see #getList 
     */
    public void setSelectionBackground(Color bg){
        list.setSelectionBackground(bg);
    }
    /**
     * This returns the data model that holds the list of items displayed by the 
     * list. This delegates to the {@link JList#getModel() getModel} method of 
     * the internal JList.
     * @return The ListModel that provides the list of items.
     * @see JList#getModel() 
     * @see #getModelList() 
     * @see #getList() 
     */
    public ListModel<E> getModel(){
        return list.getModel();
    }
    /**
     * This returns the given model as a {@code ListModelList}. This method is 
     * used by {@link #getModelList getModelList} to get the {@link #getModel 
     * model} as a {@code ListModelList}, and is mostly intended as a way to 
     * avoid wrapping a {@code ListModelList} in another {@code ListModelList}.
     * @param model The ListModel to get as a ListModelList.
     * @return The given ListModel as a ListModelList.
     * @see #getModel() 
     * @see #getModelList() 
     */
    protected ListModelList<E> getModelAsList(ListModel<E> model){
            // If the given model is already a ListModelList
        if (model instanceof ListModelList)    
            return (ListModelList<E>) model;
        else if (model != null) // If the given model is not null
            return new ListModelList<>(model);
        else
            return null;
    }
    /**
     * This returns the {@link #getModel() list data model} as a ListModelList. 
     * If the model is already a ListModelList, then it is returned. Otherwise, 
     * a ListModelList will be created with the list model.
     * @return The ListModel as a ListModelList.
     * @see #getModel() 
     * @see ListModelList
     * @see #getListData() 
     */
    public ListModelList<E> getModelList(){
            // If the model list has not been initialized yet
        if (modelList == null)
            modelList = getModelAsList(getModel());
        return modelList;
    }
    /**
     * This updates this panel to reflect a change in the list model. This also 
     * handles notifying any list data listeners about the change in the list 
     * model by calling {@link #fireContentsChanged fireContentsChanged} with an 
     * interval covering the span of the larger model.
     * @param oldModel The old list model.
     * @param newModel The new list model.
     * @see #getModel 
     * @see #setModel 
     * @see #fireContentsChanged 
     * @see #getModelList 
     */
    protected void updateModel(ListModel<E> oldModel, ListModel<E> newModel){
        int size = 0;           // Get the size of the larger model
        if (oldModel != null){  // If the old model is not null
            oldModel.removeListDataListener(handler);
            size = oldModel.getSize();
        }
        if (newModel != null){  // If the new model is not null
            newModel.addListDataListener(handler);
            size = Math.max(size, newModel.getSize());
        }
        fireContentsChanged(0,Math.max(size-1,0));
            // If the new model is a ListModelList, get it as a ListModelList.
            // Otherwise, the ListModelList be null until it is first requested
        modelList = (newModel instanceof ListModelList) ? (ListModelList<E>) 
                newModel : null;
    }
    /**
     * This sets the model that represents the contents of the list. This will 
     * also notify any property change listeners and list data listeners 
     * registered to this panel and clear the list's selection. This delegates 
     * to the {@link JList#setModel setModel} method of the internal JList.
     * @param model The ListModel that provides the list of items (cannot be 
     * null).
     * @throws NullPointerException If the given model is null.
     * @see JList#setModel 
     * @see #getModel 
     * @see #clearSelection 
     * @see #getList 
     */
    public void setModel(ListModel<E> model){
        list.setModel(Objects.requireNonNull(model,"Model cannot be null"));
    }
    /**
     * This constructs a {@link ListModelList ListModelList} from the given 
     * array of items, and then calls {@link #setModel setModel} with this 
     * model. <p>
     * 
     * Attempts to pass a {@code null} value to this method will result in an 
     * exception being thrown. The created model does not reference the given 
     * array directly, and as such, any attempt to modify the array after 
     * invoking this method will not affect the model.
     * 
     * @param arr The array of items to display in the list (cannot be null).
     * @throws NullPointerException If the given array is null.
     * @see #setModel 
     * @see ListModelList
     * @see ListModelList#ListModelList(Object[]) 
     * @see #getListData 
     */
    public void setListData(E[] arr){
        setListData(Arrays.asList(arr));
    }
    /**
     * This returns the contents of the list model in a list. <p>
     * 
     * The returned list will be "safe" in that no references to the list will 
     * be maintained by this panel. (In other words, this method must allocate a 
     * new list). The caller is thus free to modify the returned list. 
     * @return A list containing the contents of the list.
     * @see #getModel 
     * @see #getModelList 
     */
    @SuppressWarnings("unchecked")
    public List<E> getListData(){
        ListModelList<E> model = getModelList();    // Get the ListModelList
            // If the model is not null, create a new list from it. Otherwise, 
            // return null
        return (model != null) ? new ArrayList<>(model) : null;
    }
    /**
     * This constructs a {@link ListModelList ListModelList} from the given list 
     * of items, and then calls {@link #setModel setModel} with this model. <p>
     * 
     * Attempts to pass a {@code null} value to this method will result in an 
     * exception being thrown. The created model does not reference the given 
     * list directly, and as such, any attempt to modify the list after invoking 
     * this method will not affect the model.
     * 
     * @param c The list of items to display in the list (cannot be null).
     * @throws NullPointerException If the given list is null.
     * @see #setModel 
     * @see ListModelList
     * @see ListModelList#ListModelList(Collection) 
     * @see #getListData 
     */
    public void setListData(List<? extends E> c){
        setModel(new ListModelList<>(c));
    }
    /**
     * This returns the so called "prototypical" cell value, which is a value 
     * used to calculate a fixed width and height for the cells in the list. 
     * This delegates to the {@link JList#getPrototypeCellValue 
     * getPrototypeCellValue} method of the internal JList.
     * @return The prototypical cell value, or null if there is no such value.
     * @see JList#getPrototypeCellValue 
     * @see #setPrototypeCellValue 
     * @see #getList 
     */
    public E getPrototypeCellValue(){
        return list.getPrototypeCellValue();
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
     * @see #getList() 
     */
    public void setPrototypeCellValue(E value){
        list.setPrototypeCellValue(value);
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
     * @see #getList() 
     */
    public int getFixedCellWidth(){
        return list.getFixedCellWidth();
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
     * @see #getList() 
     */
    public void setFixedCellWidth(int width){
        list.setFixedCellWidth(width);
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
     * @see #getList() 
     */
    public int getFixedCellHeight(){
        return list.getFixedCellHeight();
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
     * @see #getList() 
     */
    public void setFixedCellHeight(int height){
        list.setFixedCellHeight(height);
    }
    /**
     * This returns the object responsible for rendering the items in the list. 
     * This delegates to the {@link JList#getCellRenderer getCellRenderer} 
     * method of the internal JList.
     * @return The renderer used to render the list cells.
     * @see JList#getCellRenderer 
     * @see #setCellRenderer 
     * @see #getList 
     */
    public ListCellRenderer<? super E> getCellRenderer(){
        return list.getCellRenderer();
    }
    /**
     * This sets the object used to render each cell in the list. Refer to the 
     * documentation for the {@link JList#setCellRenderer setCellRenderer} 
     * method of JList for more information, as this method delegates to the 
     * {@code setCellRenderer} method of the internal JList.
     * @param renderer The renderer to use to render the list cells.
     * @see JList#setCellRenderer 
     * @see #getCellRenderer 
     * @see #getList 
     */
    public void setCellRenderer(ListCellRenderer<? super E> renderer){
        list.setCellRenderer(renderer);
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
     * @see #getList() 
     */
    public int getVisibleRowCount(){
        return list.getVisibleRowCount();
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
     * @see #getList() 
     */
    public void setVisibleRowCount(int visibleRowCount){
        list.setVisibleRowCount(visibleRowCount);
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
     * @see #getList() 
     */
    public int getLayoutOrientation(){
        return list.getLayoutOrientation();
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
     * @see #getList() 
     */
    public void setLayoutOrientation(int layoutOrientation){
        list.setLayoutOrientation(layoutOrientation);
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
     * @see #getList() 
     */
    public int getFirstVisibleIndex(){
        return list.getFirstVisibleIndex();
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
     * @see #getList() 
     */
    public int getLastVisibleIndex(){
        return list.getLastVisibleIndex();
    }
    /**
     * This scrolls the list to make the specified cell completely visible. <p>
     * If the given index is outside the list's range of cells, then this method 
     * will do nothing. This delegates to the {@link 
     * JList#ensureIndexIsVisible(int) ensureIndexIsVisible} method of the 
     * internal JList.
     * @param index The index of the cell to make visible.
     * @see JList#ensureIndexIsVisible(int)
     * @see #getList() 
     */
    public void ensureIndexIsVisible(int index){
        list.ensureIndexIsVisible(index);
    }
    
    // TODO: Implement the rest of the JList cover methods
    
    /**
     * This adds the given {@code ListSelectionListener} to this panel.
     * @param l The listener to add.
     * @see #removeListSelectionListener 
     * @see #getListSelectionListeners 
     */
    public void addListSelectionListener(ListSelectionListener l){
        if (l != null)      // If the listener is not null
            listenerList.add(ListSelectionListener.class, l);
    }
    /**
     * This removes the given {@code ListSelectionListener} from this panel.
     * @param l The listener to remove.
     * @see #addListSelectionListener 
     * @see #getListSelectionListeners 
     */
    public void removeListSelectionListener(ListSelectionListener l){
        listenerList.remove(ListSelectionListener.class, l);
    }
    /**
     * This returns an array containing all the {@code ListSelectionListener}s 
     * that have been added to this panel.
     * @return An array containing the {@code ListSelectionListener}s that have 
     * been added, or an empty array if none have been added.
     * @see #addListSelectionListener 
     * @see #removeListSelectionListener 
     */
    public ListSelectionListener[] getListSelectionListeners(){
        return listenerList.getListeners(ListSelectionListener.class);
    }
    /**
     * This adds the given {@code ListDataListener} to this panel.
     * @param l The listener to add.
     * @see #removeListDataListener 
     * @see #getListDataListeners 
     */
    public void addListDataListener(ListDataListener l){
        if (l != null)      // If the listener is not null
            listenerList.add(ListDataListener.class, l);
    }
    /**
     * This removes the given {@code ListDataListener} from this panel.
     * @param l The listener to remove.
     * @see #addListDataListener 
     * @see #getListDataListeners 
     */
    public void removeListDataListener(ListDataListener l){
        listenerList.remove(ListDataListener.class, l);
    }
    /**
     * This returns an array containing all the {@code ListDataListeners}s that 
     * have been added to this panel.
     * @return An array containing the {@code ListDataListeners}s that have been 
     * added, or an empty array if none have been added.
     * @see #addListDataListener 
     * @see #removeListDataListener 
     */
    public ListDataListener[] getListDataListeners(){
        return listenerList.getListeners(ListDataListener.class);
    }
    /**
     * This pops up a dialog showing this panel. This will also set the model 
     * for the list. This is equivalent to calling {@link #setModel setModel} 
     * before calling {@link #showDialog(Component) showDialog}.
     * @param parent The parent component for the dialog (can be null).
     * @param model The model for the list (cannot be null).
     * @return The return state of the panel. This will be either {@link 
     * #ACCEPT_OPTION}, {@link #CANCEL_OPTION}, or {@link #ERROR_OPTION}, with 
     * the last being returned if an error occurred or if the dialog is 
     * dismissed.
     * @throws NullPointerException If the given model is null.
     * @see #ACCEPT_OPTION
     * @see #CANCEL_OPTION
     * @see #ERROR_OPTION
     * @see #showDialog(Component) 
     * @see #showDialog(Component, List) 
     * @see #showDialog(Component, Object[]) 
     * @see #setModel 
     */
    public int showDialog(Component parent, ListModel<E> model){
        if (getDialog() == null)    // If the dialog is not showing
            setModel(model);
        return showDialog(parent);
    }
    /**
     * This pops up a dialog showing this panel. This will also set the model 
     * for the list to a {@link ListModelList ListModelList} constructed based 
     * off the given list. This is equivalent to calling {@link 
     * #setListData(List) setListData} before calling {@link 
     * #showDialog(Component) showDialog}.
     * @param parent The parent component for the dialog (can be null).
     * @param c The list of items to display in the list (cannot be null).
     * @return The return state of the panel. This will be either {@link 
     * #ACCEPT_OPTION}, {@link #CANCEL_OPTION}, or {@link #ERROR_OPTION}, with 
     * the last being returned if an error occurred or if the dialog is 
     * dismissed.
     * @throws NullPointerException If the given list is null.
     * @see #ACCEPT_OPTION
     * @see #CANCEL_OPTION
     * @see #ERROR_OPTION
     * @see #showDialog(Component) 
     * @see #showDialog(Component, ListModel) 
     * @see #showDialog(Component, Object[]) 
     * @see #setListData(List) 
     * @see #setModel 
     * @see ListModelList
     */
    public int showDialog(Component parent, List<? extends E> c){
        if (getDialog() == null)    // If the dialog is not showing
            setListData(c);
        return showDialog(parent);
    }
    /**
     * This pops up a dialog showing this panel. This will also set the model 
     * for the list to a {@link ListModelList ListModelList} constructed based 
     * off the given array. This is equivalent to calling {@link 
     * #setListData(Object[]) setListData} before calling {@link 
     * #showDialog(Component) showDialog}.
     * @param parent The parent component for the dialog (can be null).
     * @param arr The array of items to display in the list (cannot be null).
     * @return The return state of the panel. This will be either {@link 
     * #ACCEPT_OPTION}, {@link #CANCEL_OPTION}, or {@link #ERROR_OPTION}, with 
     * the last being returned if an error occurred or if the dialog is 
     * dismissed.
     * @throws NullPointerException If the given array is null.
     * @see #ACCEPT_OPTION
     * @see #CANCEL_OPTION
     * @see #ERROR_OPTION
     * @see #showDialog(Component) 
     * @see #showDialog(Component, ListModel) 
     * @see #showDialog(Component, List) 
     * @see #setListData(Object[]) 
     * @see #setListData(List) 
     * @see #setModel 
     * @see ListModelList
     */
    public int showDialog(Component parent, E[] arr){
        if (getDialog() == null)    // If the dialog is not showing
            setListData(arr);
        return showDialog(parent);
    }
    @Override
    public void setFont(java.awt.Font font){
        super.setFont(font);
        try{
            list.setFont(font);
            scrollPane.setFont(font);
            bottomPanel.setFont(font);
            sidePanel.setFont(font);
            bottomAccessoryPanel.setFont(font);
            sideAccessoryPanel.setFont(font);
            controlPanel.setFont(font);
            nameLabel.setFont(font);
        }catch(NullPointerException ex){}
    }
    @Override
    public void setEnabled(boolean enabled){
        super.setEnabled(enabled);
        try{
            list.setEnabled(enabled);
        }catch(NullPointerException ex){}
    }
    /**
     * This returns a String representation of this JListSelector. This method 
     * is primarily intended to be used only for debugging purposes, and the 
     * content and format of the returned String may vary between 
     * implementations.
     * @return A String representation of this JListSelector.
     */
    @Override
    protected String paramString(){
        return super.paramString()+
                ",listTitle="+Objects.toString(getListTitle(), "")+
                ",list="+list;
    }
//    /**
//     * {@inheritDoc } This has been overridden to return false so as to not 
//     * allow the controls to be hidden.
//     * @return false
//     * @see #setControlsAreVisible(boolean) 
//     * @see #getControls() 
//     * @see #setControlButtonsAreShown(boolean) 
//     * @see #getControlButtonsAreShown() 
//     */
//    @Override
//    protected boolean getControlsCanBeHidden(){
//        return false;
//    }
    /**
     * {@inheritDoc }
     * @see #setControlsAreVisible 
     * @see #setControlButtonsAreShown 
     * @see #getControlButtonsAreShown 
     * @see #getControlsCanBeHidden 
     */
    @Override
    protected Component[] getControls(){
        return new Component[]{
            controlPanel
        };
    }
    /**
     * This returns a listener used to update the visibility of a container 
     * based off the visibility of its child components. The listener adds the 
     * {@link #getChildVisibilityListener child visibility listener} to any 
     * component added to the container and removes it from components removed 
     * from the container.
     * @return The listener used to update the visibility of a container.
     * @see #getChildVisibilityListener 
     * @see #containsVisibleComponents 
     * @see #updateContainerVisibility 
     * @see #updateParentVisibility 
     */
    protected ContainerListener getVisibilityListener(){
        return visHandler;
    }
    /**
     * This returns a listener used to update the visibility of the parent of a 
     * component based off the visibility of the component and its sibling 
     * components. This listener invokes {@link #updateParentVisibility 
     * updateParentVisibility} with the component when the component is either 
     * shown or hidden.
     * @return The listener used to update the visibility of the parent of a 
     * component when the components visibility changes.
     * @see #getVisibilityListener 
     * @see #containsVisibleComponents 
     * @see #updateContainerVisibility 
     * @see #updateParentVisibility 
     */
    protected ComponentListener getChildVisibilityListener(){
        return visHandler;
    }
    /**
     * This is the handler used to update the visibility of containers when 
     * their child components are shown or hidden.
     */
    private ParentVisibilityHandler visHandler;
    /**
     * This is the handler used to listen to the list, its models, and the 
     * scroll pane.
     */
    private Handler handler;
    /**
     * This is the label used to display a title above the list of items.
     */
    protected JLabel nameLabel;
    /**
     * This is the scroll pane for the list used to scroll the list of items.
     */
    protected JScrollPane scrollPane;
//    /**
//     * This stores whether the list has a separate foreground set for it.
//     */
//    private boolean listFGSet = false;
    /**
     * This is the list used to display a list of items.
     */
    protected JList<E> list;
    /**
     * This stores a ListModelList version of the list's model. This is 
     * initialized when {@link #getModelList() } is called, and is set to null 
     * if the {@link #setModel model} is set to a non-{@code ListModelList} 
     * {@code ListModel}.
     */
    protected ListModelList<E> modelList = null;
    /**
     * This is the panel to the right of the list that is used to contain the 
     * side accessory.
     */
    protected JPanel sidePanel;
    /**
     * This is the panel at the bottom of this panel used to contain the control 
     * panel and the bottom accessory.
     */
    protected JPanel bottomPanel;
    /**
     * This is the panel that contains the control buttons.
     */
    protected JPanel controlPanel;
    /**
     * This is the panel used to contain the side accessory within the side 
     * panel. This is initialized the first time the side accessory is set to a 
     * non-null value.
     */
    protected JPanel sideAccessoryPanel = null;
    /**
     * This is the panel used to contain the bottom accessory within the bottom 
     * panel. This is initialized the first time the bottom accessory is set to 
     * a non-null value.
     */
    protected JPanel bottomAccessoryPanel = null;
    /**
     * This is the accessory that appears to the side of the list.
     */
    private JComponent sideAccessory = null;
    /**
     * This is the accessory that appears at the bottom next to the control 
     * buttons.
     */
    private JComponent bottomAccessory = null;
    /**
     * {@inheritDoc }
     * 
     * @implSpec This implementation returns true if this panel is enabled, the 
     * internal JList and its model are not null, the selection is not empty, 
     * and the list model is not empty.
     * 
     * @return {@inheritDoc }
     * @see #getAcceptButton() 
     * @see #isEnabled() 
     * @see #updateAcceptEnabled() 
     * @see #getList() 
     * @see #getModel() 
     * @see #isSelectionEmpty() 
     * @see ListModel#getSize() 
     */
    @Override
    protected boolean isAcceptEnabled(){
        return super.isAcceptEnabled()&&list!=null&&getModel()!=null&&
                !isSelectionEmpty()&&getModel().getSize()>0;
    }
    /**
     * This is invoked when a change to the list's selection has occurred. This 
     * will notify any {@code ListSelectionListener}s that have been added of 
     * the changes to the selection, using this {@code JListSelector} as the 
     * source of the {@code ListSelectionEvent} provided to the listeners. 
     * 
     * @param firstIndex The first index in the range, expected to be {@code <= 
     * lastIndex}.
     * @param lastIndex The last index in the range, expected to be {@code >= 
     * firstIndex}.
     * @param isAdjusting Whether this is one in a series of multiple events, 
     * where changes are still being made to the selection.
     * @see #addListSelectionListener 
     * @see #removeListSelectionListener 
     * @see #getListSelectionListeners 
     * @see ListSelectionEvent
     * @see #updateAcceptEnabled 
     */
    protected void fireSelectionChanged(int firstIndex, int lastIndex, 
            boolean isAdjusting){
        updateAcceptEnabled();
            // This is the event to be fired
        ListSelectionEvent evt=new ListSelectionEvent(this,firstIndex,lastIndex,
                isAdjusting);
            // A for loop to go through the list selection listeners
        for (ListSelectionListener l : listenerList.getListeners(
                ListSelectionListener.class)){
            if (l != null)      // If the listener is not null
                l.valueChanged(evt);
        }
    }
    /**
     * This fires a ListDataEvent of the given type over the interval between 
     * {@code index0} and {@code index1}, inclusive. Note that {@code index0} 
     * does not need to be less than or equal to {@code index1}.
     * @param type The type of event to be fired. 
     * @param index0 One end of the interval.
     * @param index1 The other end of the interval.
     * @see #getListDataListeners 
     * @see ListDataEvent
     * @see ListDataListener
     * @see #fireContentsChanged 
     * @see #fireIntervalAdded 
     * @see #fireIntervalRemoved 
     */
    private void fireListDataEvent(int type, int index0, int index1){
        updateAcceptEnabled();
            // This is the event to be fired
        ListDataEvent evt = new ListDataEvent(this,type,index0,index1);
            // A for loop to go through the list data listeners
        for (ListDataListener l : listenerList.getListeners(
                ListDataListener.class)){
            if (l != null){         // If the listener is not null
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
     * This is invoked when elements have been inserted to the list's model. 
     * This will notify any {@code ListDataListener}s that have been added of 
     * the changes to the model, using this {@code JListSelector} as the source 
     * of the {@code ListDataEvent} provided to the listeners. The elements that 
     * have been added will be within the interval between {@code index0} and 
     * {@code index1}, inclusive. Note that {@code index0} does not need to be 
     * less than or equal to {@code index1}. 
     * @param index0 One end of the interval.
     * @param index1 The other end of the interval.
     * @see #addListDataListener 
     * @see #removeListDataListener 
     * @see #getListDataListeners 
     * @see ListDataEvent
     * @see #updateAcceptEnabled 
     * @see #fireIntervalRemoved 
     * @see #fireContentsChanged 
     */
    protected void fireIntervalAdded(int index0, int index1){
        fireListDataEvent(ListDataEvent.INTERVAL_ADDED,index0,index1);
    }
    /**
     * This is invoked when elements have been removed from the list's model. 
     * This will notify any {@code ListDataListener}s that have been added of 
     * the changes to the model, using this {@code JListSelector} as the source 
     * of the {@code ListDataEvent} provided to the listeners. The elements that 
     * have been removed will be the elements that were within the interval 
     * between {@code index0} and {@code index1}, inclusive. Note that {@code 
     * index0} does not need to be less than or equal to {@code index1}. 
     * @param index0 One end of the interval.
     * @param index1 The other end of the interval.
     * @see #addListDataListener 
     * @see #removeListDataListener 
     * @see #getListDataListeners 
     * @see ListDataEvent
     * @see #updateAcceptEnabled 
     * @see #fireIntervalAdded 
     * @see #fireContentsChanged 
     */
    protected void fireIntervalRemoved(int index0, int index1){
        fireListDataEvent(ListDataEvent.INTERVAL_REMOVED,index0,index1);
    }
    /**
     * This is invoked when the elements within the interval between {@code 
     * index0} and {@code index1}, inclusive, in the list's model have changed. 
     * This will notify any {@code ListDataListener}s that have been added of 
     * the changes to the model, using this {@code JListSelector} as the source 
     * of the {@code ListDataEvent} provided to the listeners. Note that {@code 
     * index0} does not need to be less than or equal to {@code index1}. 
     * @param index0 One end of the interval.
     * @param index1 The other end of the interval.
     * @see #addListDataListener 
     * @see #removeListDataListener 
     * @see #getListDataListeners 
     * @see ListDataEvent
     * @see #updateAcceptEnabled 
     * @see #fireIntervalAdded 
     * @see #fireIntervalRemoved 
     */
    protected void fireContentsChanged(int index0, int index1){
        fireListDataEvent(ListDataEvent.CONTENTS_CHANGED,index0,index1);
    }
    /**
     * This is invoked when a property is changed in the list before the 
     * {@code PropertyChangeListener}s registered to this panel are notified.
     * @param evt The {@code PropertyChangeEvent} to be processed.
     */
    protected void listPropertyChange(PropertyChangeEvent evt) { }
    /**
     * This is a handler class that handles changes to the list selection, list 
     * data, and properties of the list or scroll pane. This will forward some 
     * property changes made to the list and/or scroll pane to the {@code 
     * PropertyChangeListener}s registered to this {@code JListSelector}.
     */
    private class Handler implements PropertyChangeListener, ListSelectionListener, 
            ListDataListener{
        @Override
        @SuppressWarnings("unchecked")
        public void propertyChange(PropertyChangeEvent evt) {
                // Get the name of the property that changed
            String propertyName = evt.getPropertyName();
                // If the property name is null or the old value is the same as the new one
            if (propertyName == null || evt.getOldValue() == evt.getNewValue())
                return;
            if (evt.getSource() == list){           // If the source is the list
                listPropertyChange(evt);
                    // If the list foreground or background changed
                if (propertyName.equals("foreground") || 
                        propertyName.equals("background")){
                        // TODO: Handle the change to the list's foreground
//                    if (propertyName.equals("foreground")){ // If the foreground changed
//                        if (!listFGSet && !Objects.equals(getListForeground(), getForeground()))
//                            listFGSet = true;
//                    }
                    propertyName = "list"+propertyName.toUpperCase().charAt(0)+propertyName.substring(1);
                }
                switch(propertyName){
                    case("model"):                      // If the model has changed
                        updateModel((ListModel)evt.getOldValue(),(ListModel)evt.getNewValue());
                        // Changes to these properties will be forwarded to the 
                        // panel's change listeners
                    
                    case("listForeground"):
                    case("listBackground"):
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
                        firePropertyChange(propertyName,evt.getOldValue(),evt.getNewValue());
                }
            }
        }
        @Override
        public void valueChanged(ListSelectionEvent evt) {
            fireSelectionChanged(evt.getFirstIndex(),evt.getLastIndex(),evt.getValueIsAdjusting());
        }
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
    /**
     * This is a handler used to update the visibility of containers based off 
     * their child component's visibility.
     */
    private class ParentVisibilityHandler extends ComponentAdapter implements 
            ContainerListener{
        @Override
        public void componentShown(ComponentEvent evt){
            updateParentVisibility(evt.getComponent());
        }
        @Override
        public void componentHidden(ComponentEvent evt){
            updateParentVisibility(evt.getComponent());
        }
        @Override
        public void componentAdded(ContainerEvent evt) {
            evt.getChild().addComponentListener(this);
            updateContainerVisibility(evt.getContainer());
        }
        @Override
        public void componentRemoved(ContainerEvent evt) {
            evt.getChild().removeComponentListener(this);
            updateContainerVisibility(evt.getContainer());
        }
    }
}
