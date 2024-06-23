/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package components;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.*;
import java.util.*;
import java.util.function.BiConsumer;
import javax.swing.*;
import javax.swing.text.Position;

/**
 * This is a panel that can be used to manipulate and alter a collection of data 
 * using a list, as well as providing the ability to pop up a dialog box to do 
 * it. 
 * @author Milo Steier
 * @param <E> The data type of the elements for the list.
 * @see JListSelector
 * @see javax.swing.JList
 * @see ListModelList
 */
public class JListManipulator<E> extends JListSelector<E> {
    /**
     * This identifies that the remove button has been set to be shown or 
     * hidden.
     */
    public static final String REMOVE_BUTTON_IS_SHOWN_PROPERTY_CHANGED = 
            "RemoveButttonIsShownPropertyChanged";
    /**
     * This identifies that the move buttons have been set to be shown or 
     * hidden.
     */
    public static final String MOVE_BUTTONS_ARE_SHOWN_PROPERTY_CHANGED = 
            "MoveButtonsAreShownPropertyChanged";
    /**
     * This identifies that the move to edge buttons have been set to be shown 
     * or hidden when the move buttons are shown. These are the buttons to move 
     * elements to the top or bottom of the list.
     */
    public static final String MOVE_TO_EDGE_BUTTONS_ARE_SHOWN_PROPERTY_CHANGED = 
            "MoveToEdgeButtonsAreShownPropertyChanged";
    /**
     * This identifies that the reverse button has been set to be shown or 
     * hidden.
     */
    public static final String REVERSE_BUTTON_IS_SHOWN_PROPERTY_CHANGED = 
            "ReverseButttonIsShownPropertyChanged";
    /**
     * This identifies that the reset button has been set to be shown or hidden.
     */
    public static final String RESET_BUTTON_IS_SHOWN_PROPERTY_CHANGED = 
            "ResetButttonIsShownPropertyChanged";
    /**
     * This identifies that a change has been made to whether the list buttons 
     * use icons or text to denote the action they perform.
     */
    public static final String ICONS_ARE_SHOWN_PROPERTY_CHANGED = 
            "IconsAreShownPropertyChanged";
    /**
     * This identifies that a change has been made to the amount by which 
     * selected items are moved in the list.
     */
    public static final String SHIFT_DISTANCE_PROPERTY_CHANGED = 
            "ShiftDistancePropertyChanged";
    /**
     * This is the instruction to move the selected items in the list, if any, 
     * backwards (towards the start of the list).
     */
    public static final String MOVE_SELECTION_BACKWARD ="MoveSelectionBackward";
    /**
     * This is the instruction to move the selected items in the list, if any, 
     * forwards (towards the end of the list).
     */
    public static final String MOVE_SELECTION_FORWARD = "MoveSelectionForward";
    /**
     * This is the instruction to move the selected items in the list, if any, 
     * to the start of the list.
     */
    public static final String MOVE_SELECTION_TO_START ="MoveSelectionToStart";
    /**
     * This is the instruction to move the selected items in the list, if any, 
     * to the end of the list.
     */
    public static final String MOVE_SELECTION_TO_END = "MoveSelectionToEnd";
    /**
     * This is the instruction to remove the selected items, if any, from the 
     * list.
     */
    public static final String REMOVE_SELECTION = "RemoveSelection";
    /**
     * This is the instruction to reverse the order in which the selected items, 
     * if any, appear in the list.
     */
    public static final String REVERSE_SELECTION_ORDER ="ReverseSelectionOrder";
    /**
     * This is the instruction to revert any changes made to the list model 
     * since the last time it was set or changes to it were accepted.
     */
    public static final String RESET_LIST_CONTENTS = "ResetListContents";
    /**
     * This is the first row in the side panel that is reserved for current or 
     * future use by {@code JListManipulator}. Subclasses are free to add 
     * additional components to the side panel before this row and after {@link 
     * #LAST_RESERVED_BUTTON_ROW}. However, the rows at {@link 
     * #SIDE_ACCESSORY_PANEL_ROW} and {@link #RESET_BUTTON_ROW} are also 
     * reserved by {@code JListManipulator} for the side accessory panel and 
     * reset button respectively.
     * @see #LAST_RESERVED_BUTTON_ROW
     * @see #SIDE_ACCESSORY_PANEL_ROW
     * @see #RESET_BUTTON_ROW
     */
    protected static final int FIRST_RESERVED_BUTTON_ROW = 96;
    /**
     * This is the row in the side panel where the add item button will be 
     * located once implemented.
     */
    protected static final int ADD_BUTTON_ROW = FIRST_RESERVED_BUTTON_ROW;
    /**
     * This is the row in the side panel where the edit item button will be 
     * located once implemented.
     */
    protected static final int EDIT_BUTTON_ROW = FIRST_RESERVED_BUTTON_ROW+1;
    /**
     * This is the row in the side panel where the move backwards button is 
     * located.
     */
    protected static final int MOVE_BACKWARD_BUTTON_ROW = 
            FIRST_RESERVED_BUTTON_ROW+2;
    /**
     * This is the row in the side panel where the move forwards button is 
     * located.
     */
    protected static final int MOVE_FORWARD_BUTTON_ROW = 
            FIRST_RESERVED_BUTTON_ROW+3;
    /**
     * This is the row in the side panel where the move to start button is 
     * located.
     */
    protected static final int MOVE_TO_START_BUTTON_ROW = 
            FIRST_RESERVED_BUTTON_ROW+4;
    /**
     * This is the row in the side panel where the move to end button is 
     * located.
     */
    protected static final int MOVE_TO_END_BUTTON_ROW = 
            FIRST_RESERVED_BUTTON_ROW+5;
    /**
     * This is the row in the side panel where the reverse button is located.
     */
    protected static final int REVERSE_BUTTON_ROW = FIRST_RESERVED_BUTTON_ROW+6;
    /**
     * This is the row in the side panel where the remove button is located.
     */
    protected static final int REMOVE_BUTTON_ROW = FIRST_RESERVED_BUTTON_ROW+7;
    /**
     * This is the last row in the side panel that is reserved for current or 
     * future use by {@code JListManipulator}, not including {@link 
     * #SIDE_ACCESSORY_PANEL_ROW} and {@link #RESET_BUTTON_ROW}. Subclasses are 
     * free to add additional components to the side panel before {@link 
     * #FIRST_RESERVED_BUTTON_ROW} and after this row, with the exception of 
     * {@code SIDE_ACCESSORY_PANEL_ROW} and {@code RESET_BUTTON_ROW}.
     * @see #LAST_RESERVED_BUTTON_ROW
     * @see #SIDE_ACCESSORY_PANEL_ROW
     * @see #RESET_BUTTON_ROW
     */
    protected static final int LAST_RESERVED_BUTTON_ROW = 
            FIRST_RESERVED_BUTTON_ROW+31;
    /**
     * This is the row in the side panel where the side accessory panel is 
     * located.
     */
    protected static final int SIDE_ACCESSORY_PANEL_ROW = 256;
    /**
     * This is the row in the side panel where the reset button is located.
     */
    protected static final int RESET_BUTTON_ROW = 511;
    
    // Flag Definitions for controlling what buttons are shown
    /**
     * This constructs a button to be used to manipulate the contents of the 
     * list in some way.
     * @param text  The text for the button.
     * @param mnemonicIndex The index in the text for the mnemonic for the 
     * button.
     * @param toolTip The tool tip text for the button.
     * @param command The action command for the button.
     * @return A button to be used to manipulate the list.
     */
    private JButton createListButton(String text,int mnemonicIndex, 
            String toolTip, String command){
            // This constructs the button to return
        JButton button = new JButton(text);
        button.setMnemonic(text.charAt(mnemonicIndex));
        button.setToolTipText(toolTip);
        button.setActionCommand(command);
        button.addActionListener(handler);
        button.addMouseListener(getDisabledComponentListener());
        return button;
    }
    /**
     * This constructs a button to be used to move selected items in the list. 
     * @param dir The String representation of the direction that the items will 
     * be moved in, used for the text of the button.
     * @param mnemonicIndex The index in the direction text for the mnemonic 
     * for the button. This is the index in {@code dir}.
     * @param toolTipDir The String representation of the direction that the 
     * items will be moved in, used for the text for the tool tip of the button.
     * @param command The action command for the button.
     * @return A button to be used to move selected items in the list.
     * @see #createListButton 
     * @see #createMoveButton(String, String) 
     */
    private JButton createMoveButton(String dir, int mnemonicIndex, 
            String toolTipDir, String command){
        return createListButton("Move "+dir,mnemonicIndex+5,
                "Move the currently selected items "+toolTipDir+" the list",
                command);
    }
    /**
     * This constructs a button to be used to move selected items in the list. 
     * This is equivalent to calling {@link #createMoveButton(String, int, 
     * String, String) createMoveButton}{@code (dir, 0, dir.toLowerCase()+" in", 
     * command)}.
     * @param dir The String representation of the direction that the items will 
     * be moved in.
     * @param command The action command for the button.
     * @return A button to be used to move selected items in the list.
     * @see #createListButton 
     * @see #createMoveButton(String, int, String, String) 
     */
    private JButton createMoveButton(String dir, String command){
        return createMoveButton(dir,0,dir.toLowerCase()+" in",command);
    }
    /**
     * This adds the given component to the side panel at cell {@code (0, y)}, 
     * along with setting whether the component is initially {@code visible}. 
     * <p>
     * 
     * If the component is to be placed at the {@link #SIDE_ACCESSORY_PANEL_ROW 
     * row for the side accessory panel}, then the component will be anchored to 
     * the center and will have a horizontal and vertical weight of 0.9. If the 
     * component is to be placed above the side accessory panel, then it will 
     * have an inset from the bottom of 7 and will be anchored towards the start 
     * (top) of the page. If the component is to be placed below the side 
     * accessory panel, then it will have an inset from the top of 7 and will be 
     * anchored toward the end (bottom) of the page. All components will be 
     * allowed to expand horizontally, but only the side accessory panel will be 
     * allowed to expand vertically as well. <p>
     * 
     * It is recommended for subclasses that add additional components to avoid 
     * using the rows in between {@link #FIRST_RESERVED_BUTTON_ROW} and {@link 
     * #LAST_RESERVED_BUTTON_ROW}, inclusive, and to avoid using the rows for 
     * the {@link #SIDE_ACCESSORY_PANEL_ROW side accessory panel} and the {@link 
     * #RESET_BUTTON_ROW reset button}, as these rows are considered to be 
     * reserved for current or future use by {@code JListManipulator}.
     * 
     * @param c The component to add to the side panel. 
     * @param y The row at which the component will be placed along the side 
     * panel.
     * @param visible Whether the component should be visible initially.
     * @see #FIRST_RESERVED_BUTTON_ROW
     * @see #ADD_BUTTON_ROW
     * @see #EDIT_BUTTON_ROW
     * @see #MOVE_BACKWARD_BUTTON_ROW
     * @see #MOVE_FORWARD_BUTTON_ROW
     * @see #REVERSE_BUTTON_ROW
     * @see #REMOVE_BUTTON_ROW
     * @see #LAST_RESERVED_BUTTON_ROW
     * @see #SIDE_ACCESSORY_PANEL_ROW
     * @see #RESET_BUTTON_ROW
     */
    protected void addSideComponent(Component c,int y,boolean visible){
           // This is the constraints object to use to place the component
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = y;
        constraints.fill = GridBagConstraints.HORIZONTAL;
            // If the component is to be placed above the side accessory panel
        if (y < SIDE_ACCESSORY_PANEL_ROW){
            constraints.insets = new Insets(0, 0, 7, 0);
            constraints.anchor = GridBagConstraints.PAGE_START;
        }   // If the component is to be placed below the side accessory panel
        else if (y > SIDE_ACCESSORY_PANEL_ROW){
            constraints.insets = new Insets(7, 0, 0, 0);
            constraints.anchor = GridBagConstraints.PAGE_END;
        }
        else{
            constraints.weighty = 0.9;
            constraints.weightx = 0.9;
            constraints.fill = GridBagConstraints.BOTH;
        }
        sidePanel.add(c,constraints);
        c.setVisible(visible);
    }
    /**
     * This initializes the components of this list manipulator. If the given 
     * model is not null, then it is used as the model for the JList. If the 
     * given model is null but the given list is not, then a model is created 
     * based on the given list. If both the model and list are null, then an 
     * empty ListModelList will be created and used for the model of the JList.
     * @param model The model for the list (may be null).
     * @param c A list containing the contents for the list model if the given 
     * model is null (may be null).
     */
    private void initialize(ListModel<E> model, List<? extends E> c){
        if (model != null)      // If the model is not null
            setModel(model);
        else if (c != null)     // If the list is not null
            setListData(c);
        else
            setModel(new ListModelList<>());
        handler = new Handler();
        sidePanel.setLayout(new GridBagLayout());
        
        // TODO: Add the code that sets up the add button
//        addButton = createListButton("Add",0,"Add an item","Add");
//        addSideComponent(addButton,ADD_BUTTON_ROW_POSITION,true);
        
        // TODO: Add the code that sets up the edit button
//        editButton = createListButton("Edit",0,"Edit an item","Edit");
//        addSideComponent(editButton,EDIT_BUTTON_ROW_POSITION,true);
        
            // Create and add the move backwards button
        backwardButton = createMoveButton("Up",MOVE_SELECTION_BACKWARD);
        addSideComponent(backwardButton,MOVE_BACKWARD_BUTTON_ROW,showMove);
        
            // Create and add the move forwards button
        forwardButton = createMoveButton("Down",MOVE_SELECTION_FORWARD);
        addSideComponent(forwardButton,MOVE_FORWARD_BUTTON_ROW,showMove);
        
            // Create and add the move to start button
        moveToStartButton = createMoveButton("To Top", 3, "to the top of",
                MOVE_SELECTION_TO_START);
        addSideComponent(moveToStartButton,MOVE_TO_START_BUTTON_ROW,
                getEdgeButtonsAreShown());
        
            // Create and add the move to end button
        moveToEndButton = createMoveButton("To Bottom", 3, "to the bottom of",
                MOVE_SELECTION_TO_END);
        addSideComponent(moveToEndButton,MOVE_TO_END_BUTTON_ROW,
                getEdgeButtonsAreShown());
        
            // Create and add the reverse button
        reverseButton = createListButton("Reverse",2,
                "Reverse the order of the currently selected items",
                REVERSE_SELECTION_ORDER);
        addSideComponent(reverseButton,REVERSE_BUTTON_ROW,showReverse);
        
            // Create and add the remove button
        removeButton = createListButton("Remove",0,
                "Remove the currently selected items",REMOVE_SELECTION);
        addSideComponent(removeButton,REMOVE_BUTTON_ROW,showRemove);
        
            // Create and add the reset button
        resetButton = createListButton("Reset",2,"Undo all changes to the list",
                RESET_LIST_CONTENTS);
        addSideComponent(resetButton,RESET_BUTTON_ROW,showReset);
        
            // Create and add the panel used to contain the side accessory
        sideAccessoryPanel = new JPanel(new BorderLayout());
        sideAccessoryPanel.setInheritsPopupMenu(true);
        sideAccessoryPanel.addContainerListener(getVisibilityListener());
        sideAccessoryFiller = new Box.Filler(
                new Dimension(0, 0), 
                new Dimension(0, 0), 
                new Dimension(0, 32767));
        sideAccessoryPanel.add(sideAccessoryFiller,BorderLayout.LINE_START);
        addSideComponent(sideAccessoryPanel,SIDE_ACCESSORY_PANEL_ROW,true);
        
        updateListButtonsEnabled();
    }
    /**
     * This constructs a JListManipulator with the given model for the JList, 
     * list of contents for the JList, and title for the dialog. This delegates 
     * the task of initializing the list manipulator to {@link #initialize 
     * initialize}.
     * @param model The model for the JList (may be null).
     * @param c The contents of the model for the JList if {@code model} is null 
     * (may be null).
     * @param title The title for the dialog.
     * @see #initialize 
     */
    private JListManipulator(ListModel<E>model,List<? extends E>c,String title){
        super(title);
        initialize(model,c);
    }
    /**
     * This constructs a JListManipulator with the given model and title for the 
     * dialog. If the given model is null, then an empty {@link ListModelList 
     * ListModelList} will be created and used instead.
     * @param model The model for the list, or null.
     * @param title The title for the dialog.
     */
    public JListManipulator(ListModel<E> model, String title){
        this(model,null,title);
    }
    /**
     * This constructs a JListManipulator with the given model. If the given 
     * model is null, then an empty {@link ListModelList ListModelList} will be 
     * created and used instead.
     * @param model The model for the list, or null.
     */
    public JListManipulator(ListModel<E> model){
        this(model,null);
    }
    /**
     * This constructs a JListManipulator with the given model and title for the 
     * dialog. If the given model is null, then an empty ListModelList will be 
     * created and used instead.
     * @param model The model for the list, or null.
     * @param title The title for the dialog.
     */
    public JListManipulator(ListModelList<E> model, String title){
        this(model,null,title);
    }
    /**
     * This constructs a JListManipulator with the given model. If the given 
     * model is null, then an empty ListModelList will be created and used 
     * instead.
     * @param model The model for the list, or null.
     */
    public JListManipulator(ListModelList<E> model){
        this(model,null);
    }
    /**
     * This constructs a JListManipulator with the given list of elements for 
     * the list and the title for the dialog. This constructor constructs a 
     * {@link ListModelList ListModelList} from the given list. If the given 
     * list is null, then the created ListModelList will be empty.
     * @param c The list of elements to be loaded into the list model, or null.
     * @param title The title for the dialog.
     * @see ListModelList
     * @see ListModelList#ListModelList(Collection) 
     */
    public JListManipulator(List<? extends E> c, String title){
        this(null,c,title);
    }
    /**
     * This constructs a JListManipulator with the given list of elements for 
     * the list. This constructor constructs a {@link ListModelList 
     * ListModelList} from the given list. If the given list is null, then the 
     * created ListModelList will be empty.
     * @param c The list of elements to be loaded into the list model, or null.
     * @see ListModelList
     * @see ListModelList#ListModelList(Collection) 
     */
    public JListManipulator(List<? extends E> c){
        this(c,null);
    }
    /**
     * This constructs a JListManipulator with the given array of elements for 
     * the list and the title for the dialog. This constructor constructs a 
     * {@link ListModelList ListModelList} from the given array. If the given 
     * array is null, then the created ListModelList will be empty.
     * @param arr The array of elements to be loaded into the list model, or 
     * null.
     * @param title The title for the dialog.
     * @see ListModelList
     * @see ListModelList#ListModelList(Object[]) 
     */
    public JListManipulator(E[] arr, String title){
            // If the array is not null, turn it into a list. Otherwise, use 
        this((arr!=null)?Arrays.asList(arr):null,title);  // null.
    }
    /**
     * This constructs a JListManipulator with the given array of elements for 
     * the list. This constructor constructs a {@link ListModelList 
     * ListModelList} from the given array. If the given array is null, then the 
     * created ListModelList will be empty.
     * @param arr The array of elements to be loaded into the list model, or 
     * null.
     * @see ListModelList
     * @see ListModelList#ListModelList(Object[]) 
     */
    public JListManipulator(E[] arr){
        this(arr,null);
    }
    /**
     * This constructs a JListManipulator with an empty {@link ListModelList 
     * ListModelList} and the given title for the dialog.
     * @param title The title for the dialog.
     */
    public JListManipulator(String title){
        this(null, null, title);
    }
    /**
     * This constructs a JListManipulator with an empty {@link ListModelList 
     * ListModelList}.
     */
    public JListManipulator(){
        this((String)null);
    }
    /**
     * {@inheritDoc } This has been overridden to allow the side panel to be 
     * hidden when the only visible component in the side panel is the side 
     * accessory panel, and that the only visible component in the side 
     * accessory panel is a filler component.
     * @param c {@inheritDoc }
     * @see #getVisibleComponents(java.awt.Container) 
     * @see #containsVisibleComponents(java.awt.Container) 
     * @see #updateParentVisibility(java.awt.Component) 
     */
    @Override
    protected void updateContainerVisibility(Container c){
        if (c == sidePanel){    // If the container is the side panel
                // Get all the visible components in the side panel
            Component[] arr = getVisibleComponents(sidePanel);
                // If there is only one component visible in the side panel and 
                // it's the side accessory panel
            if (arr != null && arr.length == 1 && arr[0] == sideAccessoryPanel){
                    //Get all the visible components in the side accessory panel
                arr = getVisibleComponents(sideAccessoryPanel);
                    // Make the side panel visible if there are 2 or more 
                    // visible components in the side accessory panel or if 
                    // there is one visible component and it's not the filler 
                    // component
                sidePanel.setVisible(arr != null && arr.length > 0 && 
                        (arr.length != 1 || arr[0] != sideAccessoryFiller));
            }
            else
                sidePanel.setVisible(arr != null && arr.length > 0);
        }
        else
            super.updateContainerVisibility(c);
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
        return "Accept changes to the list";
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
        return "Abort changes to the list";
    }
    /**
     * This returns the button used to move any selected items in the list 
     * towards the start of the list.
     * @return The button used to move selected items backwards.
     * @see #MOVE_SELECTION_BACKWARD
     * @see #moveSelectionBackward(int) 
     * @see #moveSelectionBackward() 
     */
    public JButton getMoveBackwardButton(){
        return backwardButton;
    }
    /**
     * This returns the button used to move any selected items in the list 
     * towards the end of the list.
     * @return The button used to move selected items forwards.
     * @see #MOVE_SELECTION_FORWARD
     * @see #moveSelectionForward(int) 
     * @see #moveSelectionForward() 
     */
    public JButton getMoveForwardButton(){
        return forwardButton;
    }
    /**
     * This returns the button used to move any selected items in the list to 
     * the start of the list.
     * @return The button used to move selected items to the start of the list.
     * @see #MOVE_SELECTION_TO_START
     * @see #moveSelectionToStart() 
     */
    public JButton getMoveToStartButton(){
        return moveToStartButton;
    }
    /**
     * This returns the button used to move any selected items in the list to 
     * the end of the list.
     * @return The button used to move selected items to the end of the list.
     * @see #MOVE_SELECTION_TO_END
     * @see #moveSelectionToEnd() 
     */
    public JButton getMoveToEndButton(){
        return moveToEndButton;
    }
    /**
     * This returns the button used to remove selected items from the list.
     * @return The remove button.
     * @see #REMOVE_SELECTION
     * @see #removeSelection() 
     */
    public JButton getRemoveButton(){
        return removeButton;
    }
    /**
     * This returns the button used to reverse the order of the selected items 
     * in the list.
     * @return The reverse button.
     * @see #REVERSE_SELECTION_ORDER
     * @see #reverseSelection 
     */
    public JButton getReverseButton(){
        return reverseButton;
    }
    /**
     * This returns the button used to revert any changes to the contents of the 
     * list model since the last time it was set or changes to it were {@link 
     * #accept() accepted}.
     * @return The reset button.
     * @see #RESET_LIST_CONTENTS
     * @see #reset() 
     */
    public JButton getResetButton(){
        return resetButton;
    }
    @Override
    public void setForeground(java.awt.Color fg){
        super.setForeground(fg);
        try{
            removeButton.setForeground(fg);
            backwardButton.setForeground(fg);
            forwardButton.setForeground(fg);
            reverseButton.setForeground(fg);
            resetButton.setForeground(fg);
            moveToStartButton.setForeground(fg);
            moveToEndButton.setForeground(fg);
        }catch(NullPointerException ex){}
        if (addButton != null)      // If the add button has been initialized
            addButton.setForeground(fg);
        if (editButton != null)     // If the edit button has been initialized
            editButton.setForeground(fg);
    }
    @Override
    public void setBackground(java.awt.Color bg){
        super.setBackground(bg);
        try{
            removeButton.setBackground(bg);
            backwardButton.setBackground(bg);
            forwardButton.setBackground(bg);
            reverseButton.setBackground(bg);
            resetButton.setBackground(bg);
            moveToStartButton.setBackground(bg);
            moveToEndButton.setBackground(bg);
        }catch(NullPointerException ex){}
        if (addButton != null)      // If the add button has been initialized
            addButton.setBackground(bg);
        if (editButton != null)     // If the edit button has been initialized
            editButton.setBackground(bg);
    }
    /**
     * This sets whether the remove button will be shown by this panel. This 
     * property is true by default.
     * @param value Whether the remove button should be shown or not.
     * @see #getRemoveButtonIsShown 
     * @see #setMoveButtonsAreShown 
     * @see #getMoveButtonsAreShown 
     * @see #setMoveToEdgeButtonsAreShown 
     * @see #getMoveToEdgeButtonsAreShown 
     * @see #setReverseButtonIsShown 
     * @see #getReverseButtonIsShown 
     * @see #setResetButtonIsShown 
     * @see #getResetButtonIsShown 
     * @see #getRemoveButton 
     */
    public void setRemoveButtonIsShown(boolean value){
        if (value == showRemove)    // If no change will occur
            return;
        showRemove = value;
        firePropertyChange(REMOVE_BUTTON_IS_SHOWN_PROPERTY_CHANGED,!value,value);
        removeButton.setVisible(value);
    }
    /**
     * This returns whether the remove button is shown by this panel.
     * @return Whether the remove button is shown.
     * @see #setRemoveButtonIsShown 
     * @see #setMoveButtonsAreShown 
     * @see #getMoveButtonsAreShown 
     * @see #setMoveToEdgeButtonsAreShown 
     * @see #getMoveToEdgeButtonsAreShown 
     * @see #setReverseButtonIsShown 
     * @see #getReverseButtonIsShown 
     * @see #setResetButtonIsShown 
     * @see #getResetButtonIsShown 
     * @see #getRemoveButton 
     */
    public boolean getRemoveButtonIsShown(){
        return showRemove;
    }
    /**
     * This sets whether the reverse button will be shown by this panel. This 
     * property is true by default.
     * @param value Whether the reverse button should be shown or not.
     * @see #getReverseButtonIsShown 
     * @see #setMoveButtonsAreShown 
     * @see #getMoveButtonsAreShown 
     * @see #setMoveToEdgeButtonsAreShown 
     * @see #getMoveToEdgeButtonsAreShown 
     * @see #setRemoveButtonIsShown 
     * @see #getRemoveButtonIsShown 
     * @see #setResetButtonIsShown 
     * @see #getResetButtonIsShown 
     * @see #getReverseButton 
     */
    public void setReverseButtonIsShown(boolean value){
        if (value == showReverse)       // If no change will occur
            return;
        showReverse = value;
        firePropertyChange(REVERSE_BUTTON_IS_SHOWN_PROPERTY_CHANGED,!value,value);
        reverseButton.setVisible(value);
    }
    /**
     * This returns whether the reverse button is shown by this panel.
     * @return Whether the reverse button is shown.
     * @see #setReverseButtonIsShown 
     * @see #setMoveButtonsAreShown 
     * @see #getMoveButtonsAreShown 
     * @see #setMoveToEdgeButtonsAreShown 
     * @see #getMoveToEdgeButtonsAreShown 
     * @see #setRemoveButtonIsShown 
     * @see #getRemoveButtonIsShown 
     * @see #setResetButtonIsShown 
     * @see #getResetButtonIsShown 
     * @see #getReverseButton 
     */
    public boolean getReverseButtonIsShown(){
        return showReverse;
    }
    /**
     * This returns whether the move to edge buttons are to be shown. These are 
     * the buttons used to move stuff to the top or to the bottom of the list. 
     * These buttons are only shown when the move buttons are shown and when 
     * the move to edge buttons are specifically set to be shown. This method is 
     * equivalent to {@link #getMoveButtonsAreShown() } {@code && } {@link 
     * #getMoveToEdgeButtonsAreShown() }.
     * @return {@link #getMoveButtonsAreShown() } {@code && } {@link 
     * #getMoveToEdgeButtonsAreShown() }.
     * @see #getMoveToStartButton() 
     * @see #getMoveToEndButton() 
     * @see #getMoveButtonsAreShown 
     * @see #setMoveButtonsAreShown 
     * @see #getMoveToEdgeButtonsAreShown 
     * @see #setMoveToEdgeButtonsAreShown 
     */
    protected boolean getEdgeButtonsAreShown(){
        return showMove && showEdge;
    }
    /**
     * This updates whether the move to edge buttons are shown.
     * @see #getEdgeButtonsAreShown() 
     * @see #getMoveToStartButton() 
     * @see #getMoveToEndButton() 
     * @see #getMoveButtonsAreShown 
     * @see #setMoveButtonsAreShown 
     * @see #getMoveToEdgeButtonsAreShown 
     * @see #setMoveToEdgeButtonsAreShown 
     */
    private void updateEdgeButtonsAreShown(){
        moveToStartButton.setVisible(getEdgeButtonsAreShown());
        moveToEndButton.setVisible(getEdgeButtonsAreShown());
    }
    /**
     * This sets whether the move buttons will be shown by this panel. That is 
     * to say, this sets whether the move forward and move backward buttons are 
     * shown. This will also set whether the move to start and move to end 
     * buttons are visible if {@link #getMoveToEdgeButtonsAreShown } is set to 
     * true. This property is true by default.
     * @param value Whether the move buttons should be shown or not.
     * @see #getMoveButtonsAreShown 
     * @see #setMoveToEdgeButtonsAreShown 
     * @see #getMoveToEdgeButtonsAreShown 
     * @see #setRemoveButtonIsShown 
     * @see #getRemoveButtonIsShown 
     * @see #setReverseButtonIsShown 
     * @see #getReverseButtonIsShown 
     * @see #setResetButtonIsShown 
     * @see #getResetButtonIsShown 
     * @see #getMoveBackwardButton 
     * @see #getMoveForwardButton 
     * @see #getMoveToStartButton 
     * @see #getMoveToEndButton 
     */
    public void setMoveButtonsAreShown(boolean value){
        if (value == showMove)    // If no change will occur
            return;
        showMove = value;
        firePropertyChange(MOVE_BUTTONS_ARE_SHOWN_PROPERTY_CHANGED,!value,value);
        backwardButton.setVisible(value);
        forwardButton.setVisible(value);
        updateEdgeButtonsAreShown();
    }
    /**
     * This returns whether the move buttons are shown by this panel. That is to 
     * say, this returns whether the move forward and move backward buttons are 
     * shown. This will also return whether the move to start and move to end 
     * buttons are visible when {@link #getMoveToEdgeButtonsAreShown } is set to 
     * true.
     * @return Whether the move buttons are shown.
     * @see #setMoveButtonsAreShown 
     * @see #setMoveToEdgeButtonsAreShown 
     * @see #getMoveToEdgeButtonsAreShown 
     * @see #setRemoveButtonIsShown 
     * @see #getRemoveButtonIsShown 
     * @see #setReverseButtonIsShown 
     * @see #getReverseButtonIsShown 
     * @see #setResetButtonIsShown 
     * @see #getResetButtonIsShown 
     * @see #getMoveBackwardButton 
     * @see #getMoveForwardButton 
     * @see #getMoveToStartButton 
     * @see #getMoveToEndButton 
     */
    public boolean getMoveButtonsAreShown(){
        return showMove;
    }
    /**
     * This sets whether the move to edge buttons will be shown by this panel. 
     * That is to say, this sets whether the move to start and move to end 
     * buttons are shown when {@link #getMoveButtonsAreShown() move buttons are 
     * shown}. This property is true by default. 
     * @param value Whether the move buttons should be shown or not.
     * @see #setMoveButtonsAreShown 
     * @see #getMoveButtonsAreShown 
     * @see #getMoveToEdgeButtonsAreShown 
     * @see #setRemoveButtonIsShown 
     * @see #getRemoveButtonIsShown 
     * @see #setReverseButtonIsShown 
     * @see #getReverseButtonIsShown 
     * @see #setResetButtonIsShown 
     * @see #getResetButtonIsShown 
     * @see #getMoveToStartButton 
     * @see #getMoveToEndButton 
     */
    public void setMoveToEdgeButtonsAreShown(boolean value){
        if (value == showEdge)    // If no change will occur
            return;
        showEdge = value;
        firePropertyChange(MOVE_TO_EDGE_BUTTONS_ARE_SHOWN_PROPERTY_CHANGED,
                !value,value);
        updateEdgeButtonsAreShown();
    }
    /**
     * This returns whether the move to edge buttons are shown by this panel. 
     * That is to say, this returns whether the move to start and move to end 
     * buttons are shown when {@link #getMoveButtonsAreShown() move buttons are 
     * shown}.
     * @return Whether the move buttons are shown.
     * @see #setMoveButtonsAreShown 
     * @see #getMoveButtonsAreShown 
     * @see #setMoveToEdgeButtonsAreShown 
     * @see #setRemoveButtonIsShown 
     * @see #getRemoveButtonIsShown 
     * @see #setReverseButtonIsShown 
     * @see #getReverseButtonIsShown 
     * @see #setResetButtonIsShown 
     * @see #getResetButtonIsShown 
     * @see #getMoveToStartButton 
     * @see #getMoveToEndButton 
     */
    public boolean getMoveToEdgeButtonsAreShown(){
        return showEdge;
    }
    /**
     * This sets whether the reset button will be shown by this panel. This 
     * property is true by default.
     * @param value Whether the reset button should be shown or not.
     * @see #getResetButtonIsShown 
     * @see #setMoveButtonsAreShown 
     * @see #getMoveButtonsAreShown 
     * @see #setMoveToEdgeButtonsAreShown 
     * @see #getMoveToEdgeButtonsAreShown 
     * @see #setRemoveButtonIsShown 
     * @see #getRemoveButtonIsShown 
     * @see #setReverseButtonIsShown 
     * @see #getReverseButtonIsShown 
     * @see #getResetButton 
     */
    public void setResetButtonIsShown(boolean value){
        if (value == showReset)    // If no change will occur
            return;
        showReset = value;
        firePropertyChange(RESET_BUTTON_IS_SHOWN_PROPERTY_CHANGED,!value,value);
        resetButton.setVisible(value);
    }
    /**
     * This returns whether the reset button is shown by this panel.
     * @return Whether the reset button is shown.
     * @see #setResetButtonIsShown 
     * @see #setMoveButtonsAreShown 
     * @see #getMoveButtonsAreShown 
     * @see #setMoveToEdgeButtonsAreShown 
     * @see #getMoveToEdgeButtonsAreShown 
     * @see #setRemoveButtonIsShown 
     * @see #getRemoveButtonIsShown 
     * @see #setReverseButtonIsShown 
     * @see #getReverseButtonIsShown 
     * @see #getResetButton 
     */
    public boolean getResetButtonIsShown(){
        return showReset;
    }
    /**
     * This sets whether list buttons should prefer using icons to denote the 
     * action they perform as opposed to using text. If this is set to true, 
     * then buttons will use icons instead of text unless no appropriate icon is 
     * available. If this is set to false, then text is used for all buttons. 
     * This property is false by default.
     * 
     * @implSpec Icons are currently unimplemented as of yet, and thus setting 
     * this property effectively does nothing currently. However, this can still 
     * be used to indicate whether icons should be used once the feature has 
     * been implemented.
     * 
     * @param value Whether icons should be favored over text when it comes to 
     * denoting the action performed by a button.
     * @see #getIconsAreShown() 
     */
    public void setIconsAreShown(boolean value){
        if (value == useIcons)    // If no change will occur
            return;
        useIcons = value;
        firePropertyChange(ICONS_ARE_SHOWN_PROPERTY_CHANGED,!value,value);
        // TODO: Implement the icon handling
    }
    /**
     * This returns whether list buttons should prefer using icons as opposed to 
     * text to denote the action they perform. If this returns true, then 
     * buttons will use icons instead of text unless no appropriate icon is 
     * available. If this returns false, then text is used for all buttons. 
     * 
     * @implSpec Icons are currently unimplemented as of yet. As such, this 
     * indicates whether icons should be favored once the feature is 
     * implemented.
     * 
     * @return Whether icons will be favored over text when it comes to denoting 
     * the action performed by a button.
     * @see #setIconsAreShown(boolean) 
     */
    public boolean getIconsAreShown(){
        return useIcons;
    }
    /**
     * This sets the initial contents of the list model to the given list of 
     * elements. This is used to repopulate the model when it is being {@link 
     * #reset() reset}. This only sets what the model will be populated with 
     * when reset, not the actual contents currently in the model. If the given 
     * list is null, then a new, empty list will be used instead.
     * @param c The list containing the initial contents of the model.
     * @see #setInitialData() 
     * @see #getInitialData() 
     * @see #setModel(javax.swing.ListModel) 
     * @see #setListData(java.util.List) 
     * @see #setListData(Object[]) 
     * @see #reset() 
     */
    protected void setInitialData(List<? extends E> c){
            // If the list is not null, store it. Otherwise, create an empty 
        data = (c != null) ? c : new ArrayList<>();   // list.
    }
    /**
     * This sets the initial contents of the list model to the current contents 
     * of the model. This is used to repopulate the model when it is being 
     * {@link #reset() reset}. This is equivalent to calling {@link 
     * #setInitialData(java.util.List) setInitialData}{@code (}{@link 
     * #getListData() getListData()}{@code )}.
     * @see #setInitialData(java.util.List) 
     * @see #getListData() 
     * @see #getInitialData() 
     * @see #setModel(javax.swing.ListModel) 
     * @see #setListData(java.util.List) 
     * @see #setListData(Object[]) 
     * @see #reset() 
     */
    protected void setInitialData(){
        setInitialData(getListData());
    }
    /**
     * This returns the initial contents of the list model. This list is used to 
     * repopulate the model when it is being {@link #reset() reset}. This should 
     * never return null. 
     * @return The initial contents of the list model.
     * @see #setInitialData(java.util.List) 
     * @see #setInitialData() 
     * @see #setModel(javax.swing.ListModel) 
     * @see #setListData(java.util.List) 
     * @see #setListData(Object[]) 
     * @see #reset() 
     */
    protected List<? extends E> getInitialData(){
        return data;
    }
    /**
     * {@inheritDoc } <p>
     * 
     * While technically any implementation of ListModel can be used, it is 
     * recommended to only use ListModels that are known by {@link ListModelList 
     * ListModelList} to be a modifiable implementation of ListModel or a 
     * ListModelList that can modify its ListModel. Issues may occur if the 
     * ListModel is immutable or not known to be modifiable by ListModelList.
     * 
     * @param model {@inheritDoc }
     * @throws NullPointerException {@inheritDoc }
     * @see javax.swing.JList#setModel(javax.swing.ListModel) 
     * @see #getModel() 
     * @see #clearSelection() 
     * @see #getList() 
     * @see ListModelList
     */
    @Override
    public void setModel(ListModel<E> model){
        super.setModel(model);
        setInitialData();
    }
    /**
     * {@inheritDoc }
     * @see JList#getModel() 
     * @see #getModelList() 
     * @see #getList() 
     */
    @Override
    public ListModel<E> getModel(){
        return super.getModel();
    }
    /**
     * This constructs a {@link ListModelList ListModelList} from the given list 
     * of items, and then calls {@link #setModel(javax.swing.ListModel) 
     * setModel} with this model. If the given list is null, then the created 
     * ListModelList will be empty.
     * 
     * @param c The list of items to display in the list (may be null).
     * @see #setModel(javax.swing.ListModel) 
     * @see ListModelList
     * @see ListModelList#ListModelList(java.util.Collection) 
     * @see #getListData() 
     */
    @Override
    public void setListData(List<? extends E> c){
        if (c == null)  // If the list is null, create an empty ListModelList
            setModel(new ListModelList<>());
        else
            super.setListData(c);
    }
    /**
     * This constructs a {@link ListModelList ListModelList} from the given 
     * array of items, and then calls {@link #setModel(javax.swing.ListModel) 
     * setModel} with this model. If the given array is null, then the created 
     * ListModelList will be empty.
     * @param arr The array of items to display in the list (may be null).
     * @see #setModel(javax.swing.ListModel) 
     * @see ListModelList
     * @see ListModelList#ListModelList(Object[]) 
     * @see #getListData() 
     */
    @Override
    public void setListData(E[] arr){
            // If the array is not null, create a list from it. Otherwise, use 
        setListData((arr!=null)?Arrays.asList(arr):null); // null
    }
    /**
     * This returns the amount by which selected items will be shifted over in 
     * the list when attempting to move them with no distance specified. That is 
     * to say, this is the value added to or subtracted from the indexes of the 
     * selected items when they are being moved forward or backward.
     * @return The default distance by which to move selected items in the list.
     * @see #setShiftDistance(int) 
     * @see #moveSelection(javax.swing.text.Position.Bias, int) 
     * @see #moveSelection(javax.swing.text.Position.Bias) 
     * @see #moveSelectionForward(int) 
     * @see #moveSelectionForward() 
     * @see #moveSelectionBackward(int) 
     * @see #moveSelectionBackward() 
     */
    public int getShiftDistance(){
        return shiftAmount;
    }
    /**
     * This sets the amount by which selected items are shifted over in the list 
     * when attempting to move them when no distance has been specified. That is 
     * to say, this sets the value added to or subtracted from the indexes of 
     * the selected items when they are being moved forward or backward. This 
     * property is 1 by default.
     * @param distance The distance by which to move selected items in the list 
     * (cannot be less than 1).
     * @throws IllegalArgumentException If the distance is less than 1.
     * @see #getShiftDistance() 
     * @see #moveSelection(javax.swing.text.Position.Bias, int) 
     * @see #moveSelection(javax.swing.text.Position.Bias) 
     * @see #moveSelectionForward(int) 
     * @see #moveSelectionForward() 
     * @see #moveSelectionBackward(int) 
     * @see #moveSelectionBackward() 
     */
    public void setShiftDistance(int distance){
        if (distance < 1)                   // If the distance is less than 1
            throw new IllegalArgumentException(
                    "Shift distance cannot be less than 1 ("+distance +" < 1)");
            // If the new distance is equal to the old distance
        else if (distance == shiftAmount)   
            return;
        int old = shiftAmount;  // Get the old distance
        shiftAmount = distance;
        firePropertyChange(SHIFT_DISTANCE_PROPERTY_CHANGED,old,distance);
    }
    /**
     * This finds and returns the index in the given array which forms an 
     * interval with the given {@code index} where each subsequent element is 
     * equal to the previous element plus 1. The interval is inclusive of the 
     * returned index and {@code index}. The {@code inc} value determines which 
     * direction to search the array in. If {@code inc} is {@code 1}, then the 
     * indexes after the given {@code index} are searched. If {@code inc} is 
     * {@code -1}, then the indexes before {@code index} are searched.
     * @param indexes The array to find the index for the other end of the 
     * interval.
     * @param index The index to start searching from. This is assumed to be one 
     * end of the interval.
     * @param inc The direction in which to search the array in (must be either 
     * 1 to search for indexes after {@code index} or -1 to search for indexes 
     * before {@code index}). This serves as the increment value for the search.
     * @return The index in the array that forms an interval with {@code index}.
     * @throws IllegalArgumentException If the increment is neither 1 or -1.
     * @see #removeElements(int[], components.ListModelList) 
     * @see #moveElements(int[], Position.Bias, int, components.ListModelList) 
     */
    protected int getIntervalIndex(int[] indexes, int index, int inc){
        if (Math.abs(inc) != 1) // If the increment is not 1 or -1
            throw new IllegalArgumentException("Increment must be 1 or -1");
        int value;  // This gets the value at the current index in the array
        do{
            value = indexes[index];
            index += inc;
        }   // While the index to check is within the array and the value at the 
            // index is equal to the value at the previous index plus the 
            // increment (i.e. if the value at the current index is the result 
            // of incrementing the value at the previous index, then this index 
            // is part of the interval)
        while(index >= 0 && index < indexes.length&&value+inc==indexes[index]);
            // Subtract the increment to get the last index in the interval
        return index - inc;
    }
    /**
     * This is used to perform an action on the selected items in the list using 
     * the given {@code BiConsumer}. If either the {@link #isSelectionEmpty 
     * selection is empty}, the list model is empty, or the given {@code 
     * BiConsumer} is null, then this will do nothing. Otherwise, this will set 
     * the selection to be {@link #setValueIsAdjusting adjusting}, {@link 
     * #clearSelection clear the selection}, invoke the given {@code BiConsumer} 
     * on the array of {@link #getSelectedIndices selected indexes} and the 
     * {@link #getModelList list model list}, and, finally, restore whether the 
     * list's selection was being adjusted.
     * @param action The {@code BiConsumer} to use to perform the action on the 
     * selected items in the list. This will be provided an array of selected 
     * indexes and the list model as a {@code ListModelList}.
     * @see #isSelectionEmpty 
     * @see #getModelList 
     * @see #getSelectedIndices 
     * @see #getValueIsAdjusting 
     * @see #setValueIsAdjusting 
     * @see #clearSelection 
     */
    private void performListAction(BiConsumer<int[],? super ListModelList<E>> action){
            // If either the selection or model is empty, or if the action is null
        if (isSelectionEmpty() || getModelList().isEmpty() || action == null) 
            return;
            // Get the currently selected indexes
        int[] indexes = getSelectedIndices();
            // Get whether the list's selection was being adjusted, so that we 
            // can restore this after we are done
        boolean isAdjusting = getValueIsAdjusting();
        setValueIsAdjusting(true);  // Set the selection to be adjusting
        clearSelection();           // Clear the selection
            // Perform the action on the list
        action.accept(indexes, getModelList());
            // Restore whether the selection being adjusted
        setValueIsAdjusting(isAdjusting);   
    }
    /**
     * This removes the elements at the indexes in the given array from the 
     * given model. After this is called, all the elements in the model with an 
     * index that was in the given array will be removed.
     * @param indexes The indexes of the elements to be removed from the model.
     * @param model The model to remove the elements from.
     * @see #getModelList() 
     * @see #removeSelection() 
     * @see ListModelList#remove(int) 
     * @see ListModelList#clear() 
     * @see ListModelList#removeRange(int, int) 
     * @see #getIntervalIndex(int[], int, int) 
     */
    protected void removeElements(int[] indexes, ListModelList<E> model){
            // If all the elements are to be removed
        if (indexes.length == model.size()) 
            model.clear();
        else{
            int start;  // This stores the start of the interval to be removed
                // A for loop to remove the intervals within the array of 
                // indexes. This loop goes through the array backwards
            for (int index = indexes.length-1; index >= 0; index = start-1){
                    // Find the start of the current interval
                start = getIntervalIndex(indexes, index, -1);
                model.removeRange(indexes[start], indexes[index]+1);
            }
        }
    }
    /**
     * This removes the currently selected items from the list. If nothing is 
     * selected, then this will do nothing. This method is called when the 
     * remove button is pressed.
     * @see #REMOVE_SELECTION
     * @see #getModelList() 
     * @see #isSelectionEmpty() 
     * @see #getSelectedIndices() 
     * @see #getSelectedValuesList() 
     * @see ListModelList#remove(int) 
     * @see ListModelList#clear() 
     * @see ListModelList#removeRange(int, int) 
     */
    public void removeSelection(){
        performListAction((int[] indexes, ListModelList<E> model) -> {
                // Remove the selected indexes from the model
            removeElements(indexes,model);  
        });
    }
    /**
     * This checks to see if the given distance and direction to see if they are 
     * valid. That is to say, this checks to see if the direction is not null 
     * and that the distance is greater than or equal to 1. This will throw an 
     * exception if either of them are invalid.
     * @param direction The direction to check (either {@link 
     * Position.Bias#Forward Forward} or {@link Position.Bias#Backward 
     * Backward}).
     * @param distance The distance to check (must be greater than or equal to 
     * 1).
     * @throws NullPointerException If the direction is null.
     * @throws IllegalArgumentException If the distance is less than 1.
     * @see #moveElements(int[], Position.Bias, int, components.ListModelList) 
     * @see #moveSelection(javax.swing.text.Position.Bias, int) 
     */
    protected void checkMoveDirectionAndDistance(Position.Bias direction,
            int distance){
        Objects.requireNonNull(direction, "Direction cannot be null");
        if (distance <= 0)  // If the distance is less than or equal to 0
            throw new IllegalArgumentException(
                    "Distance cannot be less than 1 (" + distance + " < 1)");
    }
    /**
     * This moves the elements in the given model at the given indexes in the 
     * given direction by the given distance. The moved elements will be 
     * selected after this is called.
     * @param indexes The indexes of the elements that should be moved.
     * @param direction The direction in which to move the elements (either 
     * {@link Position.Bias#Forward Forward} or {@link Position.Bias#Backward 
     * Backward}).
     * @param distance The distance to move the elements (cannot be less than 
     * 1).
     * @param model The model to move the elements around in.
     * @throws NullPointerException If the direction is null.
     * @throws IllegalArgumentException If the distance is less than 1.
     * @see #getModelList() 
     * @see #moveSelection(javax.swing.text.Position.Bias, int) 
     * @see #moveSelection(javax.swing.text.Position.Bias) 
     * @see #moveElementsToBoundary(int[], javax.swing.text.Position.Bias, components.ListModelList) 
     * @see #moveSelectionToBoundary(javax.swing.text.Position.Bias) 
     * @see #getShiftDistance() 
     * @see #getIntervalIndex(int[], int, int) 
     */
    protected void moveElements(int[] indexes, Position.Bias direction,
            int distance, ListModelList<E> model){
            // Check the direction and distance
        checkMoveDirectionAndDistance(direction,distance);
            // This gets whether the elements are being moved backwards
        boolean backward = direction == Position.Bias.Backward;
            // This gets the increment to use for moving to the next interval
        int inc = (backward) ? 1 : -1;
            // This stores the index for one of the ends of the interval 
        int index1 = (backward) ? -1 : model.size();   // currently being moved
            // A for loop to traverse the indexes so as to move them. The loop 
            // starts at the start of the array when this is shifting the items 
            // backward, and starts at the end of the array when this is 
            // shifting the items forward.
        for (int i = (indexes.length+inc)%(indexes.length+1); i >= 0 && 
                i < indexes.length; i+=inc){
                // This gets the index for one of the ends of the interval 
            int index0 = indexes[i]; // that is currently being moved
                // This gets the amount of items to be moved out of the way. 
                // This first gets the amount of items in the gap between this 
                // interval and the previous interval. After which, this is 
                // compared to the target shift distance to get the smaller of 
            int d = Math.min(distance,Math.abs(index0-index1)-1);   // the two.
                // Find the index of the other end of the interval
            i = getIntervalIndex(indexes,i,inc);
            index1 = indexes[i];
                // This gets the starting index for the sublist
            int start = Math.min(index0, index1);
                // This gets the ending index for the sublist. This is offset by 
                // 1 since the end needs to be inclusive of the larger index
            int end = Math.max(index0, index1)+1;
                // If we are moving the elements up in the list
            if (backward)
                    // We will need to include the elements before the interval 
                start -= d; // so that they can be moved to after the interval
            else    // We will need to include the elements after the interval 
                end += d;   // so that they can be moved to before the interval
                // This is the distance for which the interval will be shifted. 
                // This has the opposite sign to the increment used for the loop 
                // (positive values move the elements backwards, negative values 
            int off = d * -1 * inc;     // move them forwards)
                // Rotate the elements in the sublist, so as to shift the 
                // interval to the desired location
            Collections.rotate(model.subList(start, end), off);
            index1 += off;
                // Reselect the now shifted interval
            list.addSelectionInterval(index0+off, index1);
        }
    }
    /**
     * This moves the currently selected items in the list in the given 
     * direction by the given distance.
     * @param direction The direction in which to move the selection (either 
     * {@link Position.Bias#Forward Forward} or {@link Position.Bias#Backward 
     * Backward}).
     * @param distance The distance to move the selection (cannot be less than 
     * 1).
     * @throws NullPointerException If the direction is null.
     * @throws IllegalArgumentException If the distance is less than 1.
     * @see #getModelList() 
     * @see #isSelectionEmpty() 
     * @see #getSelectedIndices() 
     * @see #getSelectedValuesList() 
     * @see #getShiftDistance() 
     * @see #setShiftDistance(int) 
     * @see #moveSelection(javax.swing.text.Position.Bias) 
     * @see #moveSelectionForward(int) 
     * @see #moveSelectionForward() 
     * @see #moveSelectionBackward(int) 
     * @see #moveSelectionBackward() 
     * @see #moveSelectionToBoundary(javax.swing.text.Position.Bias) 
     * @see #moveSelectionToStart() 
     * @see #moveSelectionToEnd() 
     */
    public void moveSelection(Position.Bias direction, int distance){
            // Check the direction and distance
        checkMoveDirectionAndDistance(direction,distance);
        performListAction((int[] indexes, ListModelList<E> model) -> {
                // Move the selected items in the model
            moveElements(indexes,direction,distance,model);  
        });
    }
    /**
     * This moves the currently selected items in the list in the given 
     * direction by the currently set {@link #getShiftDistance() shift 
     * distance}. This is equivalent to calling {@link 
     * #moveSelection(javax.swing.text.Position.Bias, int) 
     * moveSelection}{@code (direction, }{@link #getShiftDistance() 
     * getShiftDistance()}{@code )}.
     * @param direction The direction in which to move the selection (either 
     * {@link Position.Bias#Forward Forward} or {@link Position.Bias#Backward 
     * Backward}).
     * @throws NullPointerException If the direction is null.
     * @see #getModelList() 
     * @see #isSelectionEmpty() 
     * @see #getSelectedIndices() 
     * @see #getSelectedValuesList() 
     * @see #getShiftDistance() 
     * @see #setShiftDistance(int) 
     * @see #moveSelection(javax.swing.text.Position.Bias, int) 
     * @see #moveSelectionForward(int) 
     * @see #moveSelectionForward() 
     * @see #moveSelectionBackward(int) 
     * @see #moveSelectionBackward() 
     * @see #moveSelectionToBoundary(javax.swing.text.Position.Bias) 
     * @see #moveSelectionToStart() 
     * @see #moveSelectionToEnd() 
     */
    public void moveSelection(Position.Bias direction){
        moveSelection(direction,getShiftDistance());
    }
    /**
     * This moves the currently selected items in the list backwards (towards 
     * the start of the list) by the given distance. This is equivalent to 
     * calling {@link #moveSelection(javax.swing.text.Position.Bias, int) 
     * moveSelection}{@code (}{@link Position.Bias#Backward 
     * Position.Bias.Backward}{@code , distance)}.
     * @param distance The distance to move the selection (cannot be less than 
     * 1).
     * @throws IllegalArgumentException If the distance is less than 1.
     * @see #getModelList() 
     * @see #isSelectionEmpty() 
     * @see #getSelectedIndices() 
     * @see #getSelectedValuesList() 
     * @see #getShiftDistance() 
     * @see #setShiftDistance(int) 
     * @see #moveSelection(javax.swing.text.Position.Bias, int) 
     * @see #moveSelection(javax.swing.text.Position.Bias) 
     * @see #moveSelectionForward(int) 
     * @see #moveSelectionForward() 
     * @see #moveSelectionBackward() 
     * @see #moveSelectionToBoundary(javax.swing.text.Position.Bias) 
     * @see #moveSelectionToStart() 
     * @see #moveSelectionToEnd() 
     */
    public void moveSelectionBackward(int distance){
        moveSelection(Position.Bias.Backward, distance);
    }
    /**
     * This moves the currently selected items in the list backwards (towards 
     * the start of the list) by the currently set {@link #getShiftDistance() 
     * shift distance}. This is equivalent to calling {@link 
     * #moveSelection(javax.swing.text.Position.Bias) 
     * moveSelection}{@code (}{@link Position.Bias#Backward 
     * Position.Bias.Backward}{@code )}. This method is called when the move 
     * backward button is pressed.
     * @see #MOVE_SELECTION_BACKWARD
     * @see #getModelList() 
     * @see #isSelectionEmpty() 
     * @see #getSelectedIndices() 
     * @see #getSelectedValuesList() 
     * @see #getShiftDistance() 
     * @see #setShiftDistance(int) 
     * @see #moveSelection(javax.swing.text.Position.Bias, int) 
     * @see #moveSelection(javax.swing.text.Position.Bias) 
     * @see #moveSelectionForward(int) 
     * @see #moveSelectionForward() 
     * @see #moveSelectionBackward(int) 
     * @see #moveSelectionToBoundary(javax.swing.text.Position.Bias) 
     * @see #moveSelectionToStart() 
     * @see #moveSelectionToEnd() 
     */
    public void moveSelectionBackward(){
        moveSelection(Position.Bias.Backward);
    }
    /**
     * This moves the currently selected items in the list forwards (towards the 
     * end of the list) by the given distance. This is equivalent to calling 
     * {@link #moveSelection(javax.swing.text.Position.Bias, int) 
     * moveSelection}{@code (}{@link Position.Bias#Forward 
     * Position.Bias.Forward}{@code , distance)}.
     * @param distance The distance to move the selection (cannot be less than 
     * 1).
     * @throws IllegalArgumentException If the distance is less than 1.
     * @see #getModelList() 
     * @see #isSelectionEmpty() 
     * @see #getSelectedIndices() 
     * @see #getSelectedValuesList() 
     * @see #getShiftDistance() 
     * @see #setShiftDistance(int) 
     * @see #moveSelection(javax.swing.text.Position.Bias, int) 
     * @see #moveSelection(javax.swing.text.Position.Bias) 
     * @see #moveSelectionForward() 
     * @see #moveSelectionBackward(int) 
     * @see #moveSelectionBackward() 
     * @see #moveSelectionToBoundary(javax.swing.text.Position.Bias) 
     * @see #moveSelectionToStart() 
     * @see #moveSelectionToEnd() 
     */
    public void moveSelectionForward(int distance){
        moveSelection(Position.Bias.Forward, distance);
    }
    /**
     * This moves the currently selected items in the list forwards (towards the 
     * end of the list) by the currently set {@link #getShiftDistance() shift 
     * distance}. This is equivalent to calling {@link 
     * #moveSelection(javax.swing.text.Position.Bias) 
     * moveSelection}{@code (}{@link Position.Bias#Forward 
     * Position.Bias.Forward}{@code )}. This method is called when the move 
     * forward button is pressed.
     * @see #MOVE_SELECTION_FORWARD
     * @see #getModelList() 
     * @see #isSelectionEmpty() 
     * @see #getSelectedIndices() 
     * @see #getSelectedValuesList() 
     * @see #getShiftDistance() 
     * @see #setShiftDistance(int) 
     * @see #moveSelection(javax.swing.text.Position.Bias, int) 
     * @see #moveSelection(javax.swing.text.Position.Bias) 
     * @see #moveSelectionForward(int) 
     * @see #moveSelectionBackward(int) 
     * @see #moveSelectionBackward() 
     * @see #moveSelectionToBoundary(javax.swing.text.Position.Bias) 
     * @see #moveSelectionToStart() 
     * @see #moveSelectionToEnd() 
     */
    public void moveSelectionForward(){
        moveSelection(Position.Bias.Forward);
    }
    /**
     * This moves the elements in the given model at the given indexes to the 
     * boundaries of the model in the given direction. If the direction is 
     * {@link Position.Bias#Forward Forward}, then the elements will be moved 
     * to the end of the model. If the direction is {@link 
     * Position.Bias#Backward Backward}, then the elements will be moved to the 
     * start of the model. The moved elements will be selected after this is 
     * called.
     * 
     * @todo Make this more efficient. Currently this removes the elements and 
     * adds them back into the model.
     * 
     * @param indexes The indexes of the elements that should be moved.
     * @param direction The direction in which to move the elements (either 
     * {@link Position.Bias#Forward Forward} or {@link Position.Bias#Backward 
     * Backward}).
     * @param model The model to move the elements around in.
     * @throws NullPointerException If the direction is null.
     * @see #getModelList() 
     * @see #moveElements(int[], javax.swing.text.Position.Bias, int, components.ListModelList) 
     * @see #moveSelection(javax.swing.text.Position.Bias, int) 
     * @see #moveSelection(javax.swing.text.Position.Bias) 
     * @see #moveSelectionToBoundary(javax.swing.text.Position.Bias) 
     * @see #getIntervalIndex(int[], int, int) 
     */
    protected void moveElementsToBoundary(int[] indexes,Position.Bias direction,
            ListModelList<E> model){
            // Ensure the direction is not null
        Objects.requireNonNull(direction, "Direction cannot be null");
            // This gets the list of elements to be moved
        List<E> elements = new ArrayList<>();
            // A for loop to go through the indexes backwards, so as to add the 
            // elements to the list of elements being moved and to remove the 
            // indexes from the model.
        for (int i = indexes.length-1; i >= 0; i--){
                // Get the start of the current interval
            int start = getIntervalIndex(indexes,i,-1);
                // Add the range of elements to the list of elements
            elements.addAll(0, model.subList(indexes[start], indexes[i]+1));
                // Remove the elements from the range
            model.removeRange(indexes[start], indexes[i]+1);
            i = start;
        }   // Get the index at which to insert the moved elements. If we are 
            // moving the elements backwards, then they will be inserted at the 
            // start of the list. Otherwise, they will be inserted at the end 
            // of the list
        int offset = (direction == Position.Bias.Backward) ? 0 : model.size();
        model.addAll(offset, elements);
        setSelectionInterval(offset,offset+elements.size()-1);
            // Ensure the first or last index is visible, depending on whether 
            // we are moving the elements forwards or backwards
        ensureIndexIsVisible((direction == Position.Bias.Backward) ? 0 : 
                model.size()-1);
    }
    /**
     * This moves the currently selected items in the list to the start or end 
     * of the list, depending on the given direction. If the direction is {@link 
     * Position.Bias#Backward Backward}, then the selected items will be moved 
     * to the start of the list. If the direction is {@link 
     * Position.Bias#Forward Forward}, then the selected items will be moved to 
     * the end of the list.
     * @param direction The direction in which to move the selection (either 
     * {@link Position.Bias#Forward Forward} or {@link Position.Bias#Backward 
     * Backward}).
     * @throws NullPointerException If the direction is null.
     * @see #getModelList() 
     * @see #isSelectionEmpty() 
     * @see #getSelectedIndices() 
     * @see #getSelectedValuesList() 
     * @see #moveSelection(javax.swing.text.Position.Bias, int) 
     * @see #moveSelection(javax.swing.text.Position.Bias) 
     * @see #moveSelectionForward(int) 
     * @see #moveSelectionForward() 
     * @see #moveSelectionBackward(int) 
     * @see #moveSelectionBackward() 
     * @see #moveSelectionToStart() 
     * @see #moveSelectionToEnd() 
     */
    public void moveSelectionToBoundary(Position.Bias direction){
        Objects.requireNonNull(direction, "Direction cannot be null");
        performListAction((int[] indexes, ListModelList<E> model) -> {
                // Move the selected items in the model
            moveElementsToBoundary(indexes,direction,model);  
        });
    }
    /**
     * This moves the currently selected items in the list to the start of the 
     * list. This is equivalent to calling {@link 
     * #moveSelectionToBoundary(javax.swing.text.Position.Bias) 
     * moveSelectionToBoundary}{@code (}{@link Position.Bias#Backward 
     * Position.Bias.Backward}{@code )}. 
     * @see #MOVE_SELECTION_TO_START
     * @see #getModelList() 
     * @see #isSelectionEmpty() 
     * @see #getSelectedIndices() 
     * @see #getSelectedValuesList() 
     * @see #moveSelection(javax.swing.text.Position.Bias, int) 
     * @see #moveSelection(javax.swing.text.Position.Bias) 
     * @see #moveSelectionForward(int) 
     * @see #moveSelectionForward() 
     * @see #moveSelectionBackward(int) 
     * @see #moveSelectionBackward() 
     * @see #moveSelectionToBoundary(javax.swing.text.Position.Bias) 
     * @see #moveSelectionToEnd() 
     */
    public void moveSelectionToStart(){
        moveSelectionToBoundary(Position.Bias.Backward);
    }
    /**
     * This moves the currently selected items in the list to the end of the 
     * list. This is equivalent to calling {@link 
     * #moveSelectionToBoundary(javax.swing.text.Position.Bias) 
     * moveSelectionToBoundary}{@code (}{@link Position.Bias#Forward 
     * Position.Bias.Forward}{@code )}. 
     * @see #MOVE_SELECTION_TO_END
     * @see #getModelList() 
     * @see #isSelectionEmpty() 
     * @see #getSelectedIndices() 
     * @see #getSelectedValuesList() 
     * @see #moveSelection(javax.swing.text.Position.Bias, int) 
     * @see #moveSelection(javax.swing.text.Position.Bias) 
     * @see #moveSelectionForward(int) 
     * @see #moveSelectionForward() 
     * @see #moveSelectionBackward(int) 
     * @see #moveSelectionBackward() 
     * @see #moveSelectionToBoundary(javax.swing.text.Position.Bias) 
     * @see #moveSelectionToStart() 
     */
    public void moveSelectionToEnd(){
        moveSelectionToBoundary(Position.Bias.Forward);
    }
    /**
     * This reverses the order in which the elements at the indexes in the given 
     * array will appear in the model.
     * @param indexes The indexes of the elements to be reversed.
     * @param model The model to reverse the order of the elements in.
     * @see #getModelList
     * @see #reverseSelection 
     * @see Collections#reverse 
     */
    protected void reverseElements(int[] indexes, ListModelList<E> model){
            // This gets the list to reverse the order of the elements in
        List<E> tempList;
            // If the order of the entire list is to be reversed
        if (indexes.length == model.size()) 
            tempList = model;
        else    // Create a list view of the selected items in the model
            tempList = new AbstractList<>(){
                @Override
                public E get(int index) {
                    return model.get(indexes[index]);
                }
                @Override
                public E set(int index, E element){
                    return model.set(indexes[index], element);
                }
                @Override
                public int size() {
                    return indexes.length;
                }
            };
        Collections.reverse(tempList);// Reverse the order of the selected items
        setSelectedIndices(indexes);
    }
    /**
     * This reverses the order in which  the currently selected items appear in 
     * the list. If less than two items are selected, then this will do nothing. 
     * This method is called when the reverse button is pressed.
     * @see #REVERSE_SELECTION_ORDER
     * @see #getModelList 
     * @see #isSelectionEmpty 
     * @see #getSelectedItemsCount 
     * @see #getSelectedIndices 
     * @see #getSelectedValuesList 
     * @see Collections#reverse 
     */
    public void reverseSelection(){
            // If there are less than two items selected in the list
        if (getSelectedItemsCount() < 2)
            return;
        performListAction((int[] indexes, ListModelList<E> model) -> {
                // Reverse the order the selected items in the model
            reverseElements(indexes,model);  
        });
    }
    /**
     * This resets the contents of the {@link #getModelList() list} {@link 
     * #getModel() model}. That is to say that this reverts any changes to the 
     * list model that have been made since the last time it was set or changes 
     * made to it were {@link #accept() accepted}. 
     * 
     * @todo Improve how the list model is reset, so as to avoid removing and 
     * re-adding elements that did not change.
     * 
     * @see #RESET_LIST_CONTENTS
     * @see #accept() 
     * @see #setModel(javax.swing.ListModel) 
     * @see #getModel() 
     * @see #getModelList() 
     */
    public void reset(){
            // Get the model as a ListModelList
        ListModelList<E> model = getModelList();
        model.clear();      // Empty the model
            // Get the list containing the initial contents for the model
        List<? extends E> initial = getInitialData();
            // If the initial contents list is not null and not empty
        if (initial != null && !initial.isEmpty())
            model.addAll(initial);
//            // If the list is null or empty
//        if (data == null || data.isEmpty()){
//            model.clear();
//            return;
//        }
//            // A for loop to go through the lists 
//        for (int index = 0; index < model.size() && index<data.size();index++){
//            if (model.get(index) != data.get(index))
//                model.set(index, data.get(index));
//        }
//        if (model.size() > data.size())
//            model.removeRange(data.size(), model.size());
//        else if (model.size() < data.size())
//            model.addAll(data.subList(model.size(), data.size()));
    }
//    /**
//     * {@inheritDoc } 
//     * @see #ACCEPT_SELECTED
//     */
    @Override
    public void accept(){
        setInitialData();
        super.accept();
    }
    @Override
    public void setFont(java.awt.Font font){
        super.setFont(font);
        try{
            removeButton.setFont(font);
            forwardButton.setFont(font);
            backwardButton.setFont(font);
            reverseButton.setFont(font);
            resetButton.setFont(font);
            moveToStartButton.setFont(font);
            moveToEndButton.setFont(font);
        }catch(NullPointerException ex) {}
        if (addButton != null)      // If the add button has been initialized
            addButton.setFont(font);
        if (editButton != null)     // If the edit button has been initialized
            editButton.setFont(font);
    }
    @Override
    public void setEnabled(boolean enabled){
        super.setEnabled(enabled);
        try{
            updateListButtonsEnabled();
        }catch(NullPointerException ex) {}
    }
    /**
     * This returns a String representation of this JListManipulator. This 
     * method is primarily intended to be used only for debugging purposes, and 
     * the content and format of the returned String may vary between 
     * implementations.
     * @return A String representation of this JListManipulator.
     */
    @Override
    protected String paramString(){
        return super.paramString()+
                ",shiftDistance="+shiftAmount+
                ",moveButtonsShown="+showMove+
                ",removeButtonShown="+showRemove+
                ",reverseButtonShown="+showReverse+
                ",resetButtonShown="+showReset+
                ",iconsShown="+useIcons;
    }
    /**
     * This is the handler used to listen to the buttons and perform their 
     * actions.
     */
    private Handler handler;
    /**
     * This is the initial contents of the list that is being manipulated. This 
     * is used when the contents of the list is {@link #reset() reset}, with the 
     * contents of the list filled with the data in this list.
     */
    private List<? extends E> data;
    // TODO: Look into converting these booleans into a flag-controlled integer
    
//    private int showFlags 
    /**
     * This controls whether the remove button is to be shown.
     */
    private boolean showRemove = true;
    /**
     * This controls whether the move buttons are to be shown.
     */
    private boolean showMove = true;
    /**
     * This controls whether the move to edge buttons ({@code moveToStart} and 
     * {@code moveToEnd} are to be shown.
     */
    private boolean showEdge = true;
    /**
     * This controls whether the reverse button is to be shown.
     */
    private boolean showReverse = true;
    /**
     * This controls whether the reset button is to be shown.
     */
    private boolean showReset = true;
    /**
     * This controls whether the list buttons use icons or text to denote what 
     * the button does.
     */
    private boolean useIcons = false;
    /**
     * This is the amount by which to shift the selected items in the list 
     * forward or backward.
     */
    private int shiftAmount = 1;
    /**
     * This is the filler component used to fill the side accessory panel when 
     * there is no side accessory, so as to prevent layout issues with the side 
     * panel.
     */
    private Box.Filler sideAccessoryFiller;
    /**
     * This is the button used to remove selected items from the list.
     */
    protected JButton removeButton;
    /**
     * This is the button used to shift selected items backward in the list.
     */
    protected JButton backwardButton;
    /**
     * This is the button used to shift selected items forward in the list.
     */
    protected JButton forwardButton;
    /**
     * This is the button used to shift selected items to the start of the list.
     */
    protected JButton moveToStartButton;
    /**
     * This is the button used to shift selected items to the end of the list.
     */
    protected JButton moveToEndButton;
    /**
     * This is the button used to reverse the order of the selected items in the 
     * list.
     */
    protected JButton reverseButton;
    /**
     * This is the button used to add items to the list (currently unused).
     */
    // TODO: Implement the add button
    protected JButton addButton = null;
    /**
     * This is the button used to edit items in the list (currently unused).
     */
    // TODO: Implement the edit button
    protected JButton editButton = null;
    /**
     * This is the button used to reset the list contents back to a previous 
     * state.
     */
    protected JButton resetButton;
    /**
     * {@inheritDoc }
     * 
     * @implSpec This implementation returns true if this panel is enabled.
     * 
     * @return {@inheritDoc }
     * @see #getAcceptButton() 
     * @see #isEnabled() 
     * @see #updateAcceptEnabled() 
     */
    @Override
    protected boolean isAcceptEnabled(){
        return isEnabled();
    }
    /**
     * This returns whether the currently selected items can be shifted based 
     * off whether this panel is enabled, the selection is not empty, and 
     * whether the selection falls entirely within and fills a dead zone where 
     * the selected items cannot be moved. The dead zone is denoted by the given 
     * {@code min} and {@code max-1} indexes, and is assumed that if the {@link 
     * #getMinSelectionIndex first} and {@link #getMaxSelectionIndex last} 
     * selected indexes are equal to {@code min} and {@code max-1}, 
     * respectively, then the selection is continuous and cannot be moved due to 
     * the selection reaching a dead end.
     * @param min The smallest index in the dead zone.
     * @param max The index after the largest index in the dead zone.
     * @return Whether the selection can be moved.
     * @see #getMoveForwardButton 
     * @see #getMoveBackwardButton 
     * @see #isEnabled 
     * @see #isSelectionEmpty 
     * @see #getMinSelectionIndex 
     * @see #getMaxSelectionIndex 
     * @see #getSelectedItemsCount 
     * @see #getModel 
     */
    private boolean canMoveSelection(int min, int max){
            // The selection can be moved if the panel is enabled, the selection 
            // is not empty, and the selection is not in a dead zone
        return isEnabled() && !isSelectionEmpty() && 
                (getMinSelectionIndex() != min || 
                getMaxSelectionIndex() != max-1);
    }
    /**
     * This updates whether the list buttons are enabled based off the current 
     * selection and whether this panel is enabled. 
     * 
     * @implSpec The remove button is only enabled when this panel is enabled 
     * and the selection is not empty. The move buttons are enabled when the 
     * remove button is enabled and when any of the currently selected items 
     * can be shifted in the direction that corresponds to that move button. The 
     * reverse button is enabled when the remove button is enabled and there are 
     * at least two items selected in the list. The reset button is enabled when 
     * this panel is enabled.
     * 
     * @see #getRemoveButton 
     * @see #getMoveForwardButton 
     * @see #getMoveBackwardButton 
     * @see #getReverseButton 
     * @see #getResetButton 
     * @see #isEnabled 
     * @see #isSelectionEmpty 
     * @see #getSelectedItemsCount 
     * @see #isAcceptEnabled 
     * @see #updateAcceptEnabled 
     */
    protected void updateListButtonsEnabled(){
            // Remove button is enabled if the panel is enabled and the 
            // selection is not empty
        removeButton.setEnabled(isEnabled() && !isSelectionEmpty());
            // This gets the amount of items that are selected
        int len = getSelectedItemsCount();
            // Move backwards button is enabled if the selection can be moved 
            // backwards in the list
        backwardButton.setEnabled(canMoveSelection(0,len));
        moveToStartButton.setEnabled(backwardButton.isEnabled());
            // Move forwards button is enabled if the selection can be moved 
            // forwards in the list
        forwardButton.setEnabled(canMoveSelection(getModel().getSize()-len,
                getModel().getSize()));
        moveToEndButton.setEnabled(forwardButton.isEnabled());
            // Reverse button is enabled if the remove button is enabled and 
            // there are at least two elements selected
        reverseButton.setEnabled(removeButton.isEnabled() && len > 1);
            // Reset button is enabled if the panel is enabled
        resetButton.setEnabled(isEnabled());
    }
    @Override
    protected void fireSelectionChanged(int firstIndex, int lastIndex, 
            boolean isAdjusting){
        updateListButtonsEnabled();
        super.fireSelectionChanged(firstIndex, lastIndex, isAdjusting);
    }
    /**
     * This is the handler used to listen to the list buttons and perform their 
     * respective actions.
     */
    private class Handler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent evt) {
                // Get the action command for the action event
            String command = evt.getActionCommand();
            if (command == null)                // If no action command was given
                return;
            switch(command){
                case(MOVE_SELECTION_BACKWARD):  // If the move backward command was given
                    moveSelectionBackward();
                        // If the source is the move backward button
                    if (evt.getSource() == backwardButton)
                        backwardButton.requestFocus();
                    return;
                case(MOVE_SELECTION_FORWARD):   // If the move forward command was given
                    moveSelectionForward();
                        // If the source is the move forward button
                    if (evt.getSource() == forwardButton)
                        forwardButton.requestFocus();
                    return;
                case(REMOVE_SELECTION):         // If the remove command was given
                    removeSelection();
                    return;
                case(RESET_LIST_CONTENTS):      // If the reset command was given
                    reset();
                    return;
                case(REVERSE_SELECTION_ORDER):  // If the reverse command was given
                    reverseSelection();
                    return;
                case(MOVE_SELECTION_TO_START):  // If the move to start command was given
                    moveSelectionToStart();
                    return;
                case(MOVE_SELECTION_TO_END):    // If the move to end command was given
                    moveSelectionToEnd();
                // TODO: Implement the add and edit button handling
            }
        }
    }
}
