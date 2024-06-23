/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package components;

import components.ListModelList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Objects;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;

/**
 *
 * @author Milo Steier
 * @param <E>
 */
public class JRearrangeListPanel1<E> extends ListDataPanel<E>{
    
    public static final String ACCESSORY_PROPERTY_CHANGED = "AccessoryPropertyChanged";
    
    public static final String REMOVE_BUTTON_IS_SHOWN_PROPERTY_CHANGED = "RemoveButttonIsShownPropertyChanged";
    
    public static final String MOVE_BUTTONS_ARE_SHOWN_PROPERTY_CHANGED = "MoveButtonsAreShownPropertyChanged";
    
    public static final String ICONS_ARE_SHOWN_PROPERTY_CHANGED = "IconsAreShownPropertyChanged";
    
    
    
    private JButton createMoveButton(String dir){
        JButton button = new JButton("Move " + dir);
        button.setMnemonic(dir.charAt(0));
        button.setToolTipText("Move the currently selected elements "+dir);
        button.addActionListener(handler);
        button.setVisible(showMove);
        button.addMouseListener(getDisabledComponentListener());
        return button;
    }
    
    private void addListButton(JButton button, int y){
        java.awt.GridBagConstraints constraints = new java.awt.GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = y;
        constraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        constraints.insets = new java.awt.Insets(0, 0, 7, 0);
        buttonPanel.add(button,constraints);
    }
    
    private void initialize(ListModelList<E> model){
        this.model = model;
        handler = new Handler();
        buttonPanel = new JPanel(new java.awt.GridBagLayout());
        buttonPanel.setInheritsPopupMenu(true);
        
        // Code setting up an add button goes here
        
        // Code setting up an edit button goes here
        
        upButton = createMoveButton("Up");
        downButton = createMoveButton("Down");
        addListButton(upButton,2);
        addListButton(downButton,3);
        
        removeButton = new JButton("Remove");
        removeButton.setMnemonic('R');
        removeButton.setToolTipText("Remove the currently selected items");
        removeButton.addActionListener(handler);
        removeButton.addMouseListener(getDisabledComponentListener());
        addListButton(removeButton,4);
        removeButton.setVisible(showRemove);
        
        getSidePanel().setLayout(new java.awt.BorderLayout());
        getSidePanel().add(buttonPanel, java.awt.BorderLayout.PAGE_START);
        buttonPanel.setVisible(containsVisibleComponents(buttonPanel));
        getSidePanel().setVisible(containsVisibleComponents(getSidePanel()));
        
        resetButton = new JButton("Reset");
        resetButton.setMnemonic('S');
        
        resetButton.addActionListener(handler);
        resetButton.addMouseListener(getDisabledComponentListener());
        getBottomPanel().setLayout(new javax.swing.BoxLayout(getBottomPanel(),javax.swing.BoxLayout.X_AXIS));
        getBottomPanel().add(resetButton);
        
        
    }
    
    protected JRearrangeListPanel1(ListModelList<E> model, String title){
        super(Objects.requireNonNull(model, "Model cannot be null"),title);
        initialize(model);
    }
    
    public JRearrangeListPanel1(String title){
        this(new ListModelList<>(), title);
    }
    
    public JRearrangeListPanel1(){
        this(null);
    }

    @Override
    protected String getDefaultAcceptButtonToolTipText() {
        return "Accept changes to the list";
    }

    @Override
    protected String getDefaultCancelButtonToolTipText() {
        return "Abort changes to the list";
    }
    
    protected JButton getAddButton(){
        return null;
    }
    
    protected JButton getEditButton(){
        return null;
    }
    
    protected JButton getUpButton(){
        return upButton;
    }
    
    protected JButton getDownButton(){
        return downButton;
    }
    
    protected JButton getRemoveButton(){
        return removeButton;
    }
    
    protected JButton getResetButton(){
        return resetButton;
    }
    
    protected JPanel getButtonPanel(){
        return buttonPanel;
    }
    
    protected boolean containsVisibleComponents(java.awt.Container c){
        if (c.getComponentCount() <= 0)
            return false;
        for (java.awt.Component temp : c.getComponents()){
            if (temp != null && temp.isVisible())
                return true;
        }
        return false;
    }
    
    protected void setListButtonVisible(boolean value, JButton button){
        button.setVisible(value);
        getButtonPanel().setVisible(containsVisibleComponents(getButtonPanel()));
        getSidePanel().setVisible(containsVisibleComponents(getSidePanel()));
    }
    
    public void setRemoveButtonIsShown(boolean value){
        if (value == showRemove)
            return;
        showRemove = value;
        firePropertyChange(REMOVE_BUTTON_IS_SHOWN_PROPERTY_CHANGED,!value,value);
        setListButtonVisible(value,getRemoveButton());
    }
    
    public boolean getRemoveButtonIsShown(){
        return showRemove;
    }
    
    public void setMoveButtonsAreShown(boolean value){
        if (value == showMove)
            return;
        showMove = value;
        firePropertyChange(MOVE_BUTTONS_ARE_SHOWN_PROPERTY_CHANGED,!value,value);
        getUpButton().setVisible(value);
        setListButtonVisible(value,getDownButton());
    }
    
    public boolean getMoveButtonsAreShown(){
        return showMove;
    }
    
    public void setIconsAreShown(boolean value){
        if (value == useIcons)
            return;
        useIcons = value;
        firePropertyChange(ICONS_ARE_SHOWN_PROPERTY_CHANGED,!value,value);
        // Insert icon handling code here
    }
    
    public boolean getIconsAreShown(){
        return useIcons;
    }
    
    public void setAccessory(javax.swing.JComponent accessory){
        if (accessory == this.accessory)
            return;
        javax.swing.JComponent old = this.accessory;
        this.accessory = accessory;
        firePropertyChange(ACCESSORY_PROPERTY_CHANGED,old,accessory);
        if (old != null)
            getSidePanel().remove(old);
        if (accessory != null)
            getSidePanel().add(accessory,java.awt.BorderLayout.CENTER);
        getSidePanel().setVisible(containsVisibleComponents(getSidePanel()));
    }
    
    public javax.swing.JComponent getAccessory(){
        return accessory;
    }
    
    protected int getRangeEndIndex(int[] indexes, int startIndex){
        for (int index = startIndex; index+1 < indexes.length; index++){
            if (indexes[index]+1 != indexes[index+1])
                return index;
        }
        return indexes.length-1;
    }
    
    protected int getRangeStartIndex(int[] indexes, int endIndex){
        for (int index = endIndex; index > 0; index--){
            if (indexes[index]-1 != indexes[index-1])
                return index;
        }
        return 0;
    }
    
    protected void removeElementsFromList(int[] indexes){
        if (indexes == null || indexes.length == 0)
            return;
        setValueIsAdjusting(true);
        if (indexes.length == model.size())
            model.clear();
        else{
            clearSelection();
            int start;
            for (int index = indexes.length-1; index >= 0; index = start-1){
                start = getRangeStartIndex(indexes, index);
                model.removeRange(start, index+1);
            }
        }
        setValueIsAdjusting(false);
    }
    
    protected void moveElementsInList(int[] indexes, int dir){
        if (dir == 0 || indexes == null || indexes.length == 0 || 
                indexes.length == model.size())
            return;
        setValueIsAdjusting(true);
        clearSelection();
        int off = Math.abs(dir);
        ArrayDeque<E> moveQueue = new ArrayDeque<>(off);
        dir = (dir < 0) ? -1 : 1;
        int endIndex;
        int end = (dir < 0) ? -1 : model.size();
        for (int index = (indexes.length-dir)%(indexes.length+1); 
                index >= 0 && index < indexes.length; index = endIndex-dir){
            int start = indexes[index];
            int d;
            if (dir < 0){
                d = start - end;
                endIndex = getRangeEndIndex(indexes,index);
            }
            else{
                d = end - start;
                endIndex = getRangeStartIndex(indexes,index);
            }
            end = indexes[endIndex];
            d = Math.min(off, d-1);
            for (int i = 0; i < d; i++){
                moveQueue.add(model.remove(start-((dir<0)?d:-1)));
            }
            model.addAll(end-((moveQueue.size()+dir)%(moveQueue.size()+1)), moveQueue);
            end += moveQueue.size()*dir;
            addSelectionInterval(start+(moveQueue.size()*dir), end);
            moveQueue.clear();
        }
        setValueIsAdjusting(false);
    }
    
    
    
    private Handler handler;
    private ListModelList<E> model;
    private List<? extends E> data;
    private boolean showRemove = true;
    private boolean showMove = true;
    private boolean useIcons = false;
    private JPanel buttonPanel;
    private JButton removeButton;
    private JButton upButton;
    private JButton downButton;
    private JButton resetButton;
    private JComponent accessory = null;
    
    private void setMoveButtonEnabled(JButton button, int min, int max){
        button.setEnabled(!isSelectionEmpty() && (getMinSelectionIndex() != min || 
                getMaxSelectionIndex() != max));
    }
    
    @Override
    protected void listSelectionChanged(ListSelectionEvent evt){
        if (!evt.getValueIsAdjusting()){    // If changes are not currently being made
            getRemoveButton().setEnabled(!isSelectionEmpty());
            int len = getSelectedItemsCount();
            setMoveButtonEnabled(getUpButton(),0,len-1);
            setMoveButtonEnabled(getDownButton(),model.size()-len,model.size()-1);
        }
    }
    
    private class Handler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent evt) {
            
        }
    }
}
