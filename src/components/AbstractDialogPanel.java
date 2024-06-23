/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package components;

import event.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Objects;
import javax.swing.*;

/**
 * This is a panel that provides the basic framework for a panel that can pop up 
 * a dialog box.
 * @author Milo Steier
 */
public abstract class AbstractDialogPanel extends JPanel{
    /**
     * The key in the action map for the action performed when the escape key 
     * is pressed.
     */
    protected static final String ESCAPE_PRESSED = "EscapePressed";
    /**
     * This is the value returned if an error occurred.
     */
    public static final int ERROR_OPTION = -1;
    /**
     * This identifies that the title for the dialog has changed.
     */
    public static final String DIALOG_TITLE_PROPERTY_CHANGED = 
            "DialogTitlePropertyChanged";
    /**
     * This identifies that the dialog for this panel is closing.
     */
    public static final String DIALOG_IS_CLOSING_PROPERTY = 
            "PanelDialogIsClosingProperty";
    /**
     * This initializes some of the things for this AbstractDialogPanel, such as 
     * the title and the escape action.
     * @param title The title for the dialog.
     */
    private void initialize(String title){
        this.title = title;
            // This gets the action to use for when escape is pressed
        Action escAction = createEscapePressedAction();
        if (escAction != null){     // If there is an action for the escape key
            getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).
                    put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE,0),
                            ESCAPE_PRESSED);
            getActionMap().put(ESCAPE_PRESSED, escAction);
        }
    }
    /**
     * This constructs an AbstractDialogPanel with the specified layout manager, 
     * buffering strategy, and title for the dialog.
     * @param layout The layout manager to use.
     * @param isDoubleBuffered Whether this panel uses double-buffering to 
     * achieve fast, flicker-free updates at the expense of using additional 
     * memory space.
     * @param title The title for the dialog.
     */
    public AbstractDialogPanel(LayoutManager layout, boolean isDoubleBuffered, 
            String title){
        super(layout,isDoubleBuffered);
        initialize(title);
    }
    /**
     * This constructs an AbstractDialogPanel with the specified layout manager 
     * and buffering strategy.
     * @param layout The layout manager to use.
     * @param isDoubleBuffered Whether this panel uses double-buffering to 
     * achieve fast, flicker-free updates at the expense of using additional 
     * memory space.
     */
    public AbstractDialogPanel(LayoutManager layout, boolean isDoubleBuffered){
        this(layout,isDoubleBuffered,null);
    }
    /**
     * This constructs an AbstractDialogPanel with the specified layout manager 
     * and title for the dialog.
     * @param layout The layout manager to use.
     * @param title The title for the dialog.
     */
    public AbstractDialogPanel(LayoutManager layout, String title){
        super(layout);
        initialize(title);
    }
    /**
     * This constructs an AbstractDialogPanel with the specified layout manager.
     * @param layout The layout manager to use.
     */
    public AbstractDialogPanel(LayoutManager layout){
        this(layout,null);
    }
    /**
     * This constructs an AbstractDialogPanel with a flow layout and the given 
     * buffering strategy and title for the dialog.
     * @param isDoubleBuffered Whether this panel uses double-buffering to 
     * achieve fast, flicker-free updates at the expense of using additional 
     * memory space.
     * @param title The title for the dialog.
     */
    public AbstractDialogPanel(boolean isDoubleBuffered, String title){
        super(isDoubleBuffered);
        initialize(title);
    }
    /**
     * This constructs an AbstractDialogPanel with a flow layout and the given 
     * buffering strategy.
     * @param isDoubleBuffered Whether this panel uses double-buffering to 
     * achieve fast, flicker-free updates at the expense of using additional 
     * memory space.
     */
    public AbstractDialogPanel(boolean isDoubleBuffered){
        this(isDoubleBuffered,null);
    }
    /**
     * This constructs an AbstractDialogPanel that is double buffered with a 
     * flow layout and the given title for the dialog.
     * @param title The title for the dialog.
     */
    public AbstractDialogPanel(String title){
        super();
        initialize(title);
    }
    /**
     * This constructs an AbstractDialogPanel that is double buffered with a 
     * flow layout.
     */
    public AbstractDialogPanel(){
        this((String)null);
    }
    /**
     * This is used in the constructor to construct the Action used for when the 
     * escape key is pressed. The default implementation returns an 
     * AbstractAction with {@link ESCAPE_PRESSED} as the action name, the 
     * String returned by {@link #getEscapePressedCommand() 
     * getEscapePressedCommand} as the action command (if it returns a non-null 
     * value), and that will invoke the {@link 
     * #escapeActionPerformed(ActionEvent) escapeActionPerformed} method when 
     * the escape key is pressed.
     * @return The Action to use for when the escape key is pressed, or null if 
     * no action is to be performed for the escape key.
     * @see javax.swing.AbstractAction
     * @see #ESCAPE_PRESSED
     * @see #getEscapePressedCommand() 
     * @see #escapeActionPerformed(ActionEvent) 
     * @see #getEscapePressedAction() 
     */
    protected Action createEscapePressedAction(){
        Action action = new AbstractAction(ESCAPE_PRESSED) {
            @Override
            public void actionPerformed(ActionEvent evt) {
                escapeActionPerformed(evt);
            }
        };  // Get the action command to give to the escape action
        String command = getEscapePressedCommand();
            // If the escape action should have a specific action command
        if (command != null)
            action.putValue(Action.ACTION_COMMAND_KEY, command);
        return action;
    }
    /**
     * This is the method invoked when the escape key is pressed.
     * 
     * @implSpec This implementation invokes {@link #closeDialog(ActionEvent) 
     * closeDialog} with the given ActionEvent.
     * 
     * @param evt The event to be processed.
     * @see #getEscapePressedAction() 
     */
    protected void escapeActionPerformed(ActionEvent evt){
        closeDialog(evt);
    }
    /**
     * This returns the action command to give to the Action invoked when the 
     * escape key is pressed when it is being initialized. This is called by 
     * {@link #createEscapePressedAction() createEscapePressedAction} while 
     * initializing the escape key Action.
     * 
     * @implSpec This implementation returns the value returned by the {@link 
     * #getDialogClosingCommand() getDialogClosingCommand} method.
     * 
     * @return The action command for the escape key Action, or null if the 
     * escape key Action should use its name as the action command.
     * @see #createEscapePressedAction() 
     * @see #getEscapePressedAction() 
     * @see #getDialogClosingCommand() 
     * @see #getOptionForCommand(String) 
     */
    protected String getEscapePressedCommand(){
        return getDialogClosingCommand();
    }
    /**
     * This returns the Action that is bound to the escape key. This is 
     * equivalent to calling {@link #getActionMap() getActionMap()}{@link 
     * ActionMap#get(Object) .get}{@code (}{@link #ESCAPE_PRESSED}{@code )}.
     * @return The Action bound to the escape key, or null if no Action is bound 
     * to the escape key.
     * @see #getActionMap() 
     * @see ActionMap#get(Object)
     * @see #ESCAPE_PRESSED
     */
    protected Action getEscapePressedAction(){
        return getActionMap().get(ESCAPE_PRESSED);
    }
    /**
     * This is used to construct the WindowListener used to listen to the dialog 
     * window. This is invoked the first time {@link #getDialogWindowListener() 
     * getDialogWindowListener} is invoked so as to initialize the 
     * WindowListener for the dialog.
     * @return The WindowListener to use to listen to the dialog.
     * @see #getDialogWindowListener() 
     * @see #getDialogClosingCommand() 
     * @see #getDialog() 
     */
    protected WindowListener createDialogWindowListener(){
        return new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent evt) {
                returnValue = getOptionForCommand(getDialogClosingCommand());
            }
        };
    }
    /**
     * This returns the WindowListener used to listen to the dialog window.
     * @return The WindowListener used to listen to the dialog.
     * @see #createDialogWindowListener() 
     * @see #getDialogClosingCommand() 
     * @see #getDialog() 
     * @see #createDialog(Component) 
     */
    protected WindowListener getDialogWindowListener(){
            // If the window listener is not initialized yet
        if (windowListener == null){    
            windowListener = createDialogWindowListener();
        }
        return windowListener;
    }
    /**
     * This returns the action command to use when the dialog is closing. This 
     * determines what value will be returned when the dialog window is closed.
     * @return The action command for when the dialog is closed.
     * @see #getDialogWindowListener() 
     * @see #getOptionForCommand(String) 
     */
    protected abstract String getDialogClosingCommand();
    /**
     * This returns the title for the dialog.
     * @return The title for the dialog.
     * @see #setDialogTitle(String) 
     */
    public String getDialogTitle(){
        return title;
    }
    /**
     * This sets the title for the dialog.
     * @param title The title for the dialog.
     * @see #getDialogTitle() 
     */
    public void setDialogTitle(String title){
            // If the new title is the same as the old title.
        if (Objects.equals(title, this.title))  
            return;
        String old = this.title;    // Get the old title
        this.title = title;
        firePropertyChange(DIALOG_TITLE_PROPERTY_CHANGED,old,title);
        if (dialog != null)         // If the dialog is currently open
            dialog.setTitle(title);
    }
    /**
     * This returns the dialog currently being used to display this panel. If 
     * this panel is not showing a dialog, then this returns null.
     * @return The dialog displaying this panel, or null if no dialog is open.
     * @see #showDialog(Component) 
     * @see #createDialog(Component) 
     * @see #closeDialog(ActionEvent, String) 
     * @see #closeDialog(ActionEvent) 
     * @see #closeDialog(String) 
     * @see #getOption() 
     */
    protected JDialog getDialog(){
        return dialog;
    }
    /**
     * This returns the return state for the dialog.
     * @return The return state for the dialog.
     * @see #getDialog() 
     * @see #showDialog(Component) 
     * @see #closeDialog(ActionEvent, String) 
     * @see #closeDialog(ActionEvent) 
     * @see #closeDialog(String) 
     * @see #getOptionForCommand(String) 
     * @see #getOptionString(int) 
     */
    protected int getOption(){
        return returnValue;
    }
    /**
     * This returns the first {@code Frame} or {@code Dialog} ancestor of the 
     * given component, or the {@link JOptionPane#getRootFrame() root frame} if 
     * the given component is not contained inside a {@code Frame} or a {@code 
     * Dialog}.
     * @param c The component to get the {@code Window} ancestor of.
     * @return The first {@code Frame} or {@code Dialog} ancestor of the 
     * component, or the root frame if the component is null or not contained 
     * inside a {@code Window}.
     * @see SwingUtilities#getWindowAncestor
     * @see JOptionPane#getRootFrame()
     * @see #getDialogForComponent
     */
    protected Window getWindowForComponent(Component c){
            // While the component is not null and is neither a Frame or a Dialog
        while (c != null && !(c instanceof Frame || c instanceof Dialog)){
                // Get the window ancestor of the component
            Window temp = SwingUtilities.getWindowAncestor(c);
                // If the window is not the component, then use the window for 
                // component. Otherwise, if somehow the window ancestor of the 
                // component is itself, use the component's parent for the 
                // component to prevent an infinite loop
            c = (temp != c) ? temp : c.getParent();
        }   // If a Frame or Dialog was found, return it. Otherwise, return the 
            // root frame
        return (c!=null) ? (Window) c : JOptionPane.getRootFrame();
    }
    /**
     * This constructs and returns a modeless {@code JDialog} in the {@code 
     * parent}'s frame. If the {@code parent} is null or does not have a {@code 
     * Frame} or {@code Dialog} ancestor, then the returned dialog will be in 
     * the {@link JOptionPane#getRootFrame() root frame}. This uses {@link 
     * #getWindowForComponent(Component) getWindowForComponent} to get the frame 
     * for the {@code JDialog} from the {@code parent}.
     * @param parent The parent of the dialog, or null.
     * @param title The title for the dialog, or null.
     * @return The {@code JDialog} with the given parent.
     * @see #getWindowForComponent(Component) 
     * @see JOptionPane#getRootFrame()
     * @see #createDialog(Component) 
     */
    protected JDialog getDialogForComponent(Component parent, String title){
            // Get the window for the dialog
        Window window = getWindowForComponent(parent);
            // If the window is neither a Frame nor a Dialog
        if (!(window instanceof Frame || window instanceof Dialog))
            window = JOptionPane.getRootFrame();
        return new JDialog(window,title);
    }
    /**
     * This creates and returns a {@code JDialog} wrapping this centered on the 
     * {@code parent} in the {@code parent}'s frame. The {@code JDialog} is 
     * constructed using the {@link #getDialogForComponent(Component, String) 
     * getDialogForComponent} method.
     * @param parent The parent of the dialog, or null.
     * @return A {@code JDialog} that contains and is displaying this panel.
     * @see #getDialogForComponent(Component, String) 
     * @see #getDialogTitle() 
     * @see #getDialog() 
     * @see #showDialog(Component) 
     * @see #getDialogWindowListener() 
     */
    protected JDialog createDialog(Component parent){
            // Construct a dialog to show the panel
        JDialog dialog = getDialogForComponent(parent,getDialogTitle());
        dialog.setModal(true);
        dialog.setComponentOrientation(this.getComponentOrientation());
        
        dialog.getContentPane().setLayout(new BorderLayout());
        dialog.getContentPane().add(this, BorderLayout.CENTER);
            // Sets the minimum size to itself so that it counts as the minimum 
        dialog.setMinimumSize(dialog.getMinimumSize()); // size having been set
        
        dialog.pack();
        dialog.setLocationRelativeTo(parent);
        dialog.addWindowListener(getDialogWindowListener());
        
        return dialog;
    }
    /**
     * This pops up a dialog showing this panel.
     * @param parent The parent component for the dialog (can be null).
     * @return The return state of the panel. This will return {@link 
     * #ERROR_OPTION} if an error occurred or if the dialog is dismissed.
     * @see #ERROR_OPTION
     */
    public int showDialog(Component parent){
        if (dialog != null)     // If the dialog is already showing
            return ERROR_OPTION;
        returnValue = ERROR_OPTION;
        dialog = createDialog(parent);
        setupDialog(dialog);
        dialog.setVisible(true);
        firePropertyChange(DIALOG_IS_CLOSING_PROPERTY,dialog,null);
            // Remove all the components just in case
        dialog.getContentPane().removeAll();
        dialog.dispose();
        dialog = null;
        return getOption();
    }
    /**
     * This sets up the panel before the dialog is shown. This is invoked on the 
     * dialog in {@link #showDialog(Component) showDialog} after the dialog is 
     * constructed but before the dialog is shown. Override this method if the 
     * panel requires any additional setup before the dialog is shown.
     * @param dialog The dialog to set up.
     * @see #showDialog(Component) 
     * @see #createDialog(Component) 
     * @see #getDialog() 
     */
    protected void setupDialog(JDialog dialog){};
    /**
     * This sets the {@code ActionEvent} to be fired the next time {@link 
     * #closeDialog(ActionEvent, String) closeDialog} is invoked without a 
     * non-null {@code ActionEvent}. This will reset back to null once the 
     * event has been fired.
     * @param evt The {@code ActionEvent} to fire the next time the dialog is 
     * closed, or null to clear this.
     * @see #getCloseEvent() 
     * @see #closeDialog(ActionEvent, String) 
     * @see #closeDialog(ActionEvent) 
     * @see #closeDialog(String) 
     */
    protected void setCloseEvent(ActionEvent evt){
        event = evt;
    }
    /**
     * This returns the {@code ActionEvent} that will fired the next time {@link 
     * #closeDialog(ActionEvent, String) closeDialog} is invoked without a 
     * non-null {@code ActionEvent}. This will reset to null once the event has 
     * been fired.
     * @return The {@code ActionEvent} to fire the next time the dialog is 
     * closed, or null if no event is set.
     * @see #setCloseEvent(ActionEvent) 
     * @see #closeDialog(ActionEvent, String) 
     * @see #closeDialog(ActionEvent) 
     * @see #closeDialog(String) 
     */
    protected ActionEvent getCloseEvent(){
        return event;
    }
    /**
     * This closes the dialog if one is open. This will also cause an action 
     * event to be fired based off either the given {@code ActionEvent}, the 
     * currently set {@link #getCloseEvent() close ActionEvent} or the given 
     * action command. If the given {@code ActionEvent} is null, then it will be 
     * substituted with the close {@code ActionEvent} if one is set, after which 
     * the close {@code ActionEvent} will be reset to null. If the given action 
     * command is not null, then the action event that is fired will have the 
     * given action command. Otherwise, the action command for the event will be 
     * retrieved from the {@code ActionEvent} if it is not null.
     * @param evt The {@code ActionEvent} that triggered the dialog to close, or 
     * null.
     * @param command The action command for the action event to fire if the 
     * {@code ActionEvent} is null.
     * @see #getOptionForCommand(String) 
     * @see #getDialog() 
     * @see #fireActionPerformed(ActionEvent) 
     * @see #fireActionPerformed(String, long, int) 
     * @see #fireActionPerformed(String) 
     * @see #setCloseEvent(ActionEvent) 
     * @see #getCloseEvent() 
     * @see #closeDialog(ActionEvent) 
     * @see #closeDialog(String) 
     */
    protected void closeDialog(ActionEvent evt, String command){
        if (evt == null){       // If the given action event is null
            evt = getCloseEvent();
            setCloseEvent(null);
        }   // If the action event is not null but the action command is
        if (evt != null && command == null) 
            command = evt.getActionCommand();
        returnValue = getOptionForCommand(command);
        if (dialog != null)     // If a dialog is currently being displayed.
            dialog.setVisible(false);
        if (evt == null)        // If the action event is null
            fireActionPerformed(command);
        else
            fireActionPerformed(command,evt.getWhen(),evt.getModifiers());
    }
    /**
     * This closes the dialog if one is open. This will also cause an action 
     * event to be fired that is equivalent to the given {@code ActionEvent} if 
     * it is not null, with the only exception being that the source of the 
     * event is this panel. If the given {@code ActionEvent} is null, then it 
     * will be substituted with the {@link #getCloseEvent() close ActionEvent} 
     * if one is available. This is equivalent to calling {@link 
     * #closeDialog(ActionEvent, String) closeDialog}{@code (evt, null)}.
     * @param evt The {@code ActionEvent} that triggered the dialog to close, or 
     * null.
     * @see #getOptionForCommand(String) 
     * @see ActionEvent#getActionCommand() 
     * @see #getDialog() 
     * @see #fireActionPerformed(ActionEvent) 
     * @see #setCloseEvent(ActionEvent) 
     * @see #getCloseEvent() 
     * @see #closeDialog(ActionEvent, String) 
     * @see #closeDialog(String) 
     */
    protected void closeDialog(ActionEvent evt){
        closeDialog(evt,null);
    }
    /**
     * This closes the dialog if one is open. This will also cause an action 
     * event to be fired with the given action command. This is equivalent to 
     * calling {@link #closeDialog(ActionEvent, String) 
     * closeDialog}{@code (null, command)}.
     * @param command The action command for the action event to fire.
     * @see #getOptionForCommand(String) 
     * @see #getDialog() 
     * @see #fireActionPerformed(String) 
     * @see #setCloseEvent(ActionEvent) 
     * @see #getCloseEvent() 
     * @see #closeDialog(ActionEvent, String) 
     * @see #closeDialog(ActionEvent) 
     */
    protected void closeDialog(String command){
        closeDialog(null,command);
    }
    /**
     * This returns the return state that is associated with the given action 
     * command.
     * @param command The action command for the return state.
     * @return The return state for the action command.
     * @see #getOption() 
     * @see #getOptionString(int) 
     * @see #closeDialog(ActionEvent, String) 
     * @see #closeDialog(ActionEvent) 
     * @see #closeDialog(String) 
     */
    protected abstract int getOptionForCommand(String command);
    /**
     * This returns the mouse listener used to cause disabled components to 
     * provide error feedback to the user when they are pressed.
     * @return The mouse listener used to make disabled components provide 
     * error feedback when pressed.
     */
    protected MouseListener getDisabledComponentListener(){
            // If the disabled component mouse listener has not been initialized 
        if (disabledListener == null)   // yet
            disabledListener = new DisabledComponentMouseListener();
        return disabledListener;
    }
    /**
     * This adds the given {@code ActionListener} to this panel.
     * @param l The listener to add.
     * @see #removeActionListener(ActionListener) 
     * @see #getActionListeners() 
     */
    public void addActionListener(ActionListener l){
        if (l != null)          // If the listener is not null
            listenerList.add(ActionListener.class, l);
    }
    /**
     * This removes the given {@code ActionListener} from this panel.
     * @param l The listener to remove.
     * @see #addActionListener(ActionListener) 
     * @see #getActionListeners() 
     */
    public void removeActionListener(ActionListener l){
        listenerList.remove(ActionListener.class, l);
    }
    /**
     * This returns an array containing all the {@code ActionListener}s that 
     * have been added to this panel.
     * @return An array containing the {@code ActionListener}s that have been 
     * added, or an empty array if none have been added.
     * @see #addActionListener(ActionListener) 
     * @see #removeActionListener(ActionListener) 
     */
    public ActionListener[] getActionListeners(){
        return listenerList.getListeners(ActionListener.class);
    }
    /**
     * This notifies all the {@code ActionListener}s that have been added to 
     * this panel if the given {@code ActionEvent} is not null. If the source 
     * of the given {@code ActionEvent} is not this panel, then the {@code 
     * ActionEvent} will be redirected to have this panel as its source.
     * @param evt The {@code ActionEvent} to fire.
     * @see #addActionListener(ActionListener) 
     * @see #removeActionListener(ActionListener) 
     * @see #getActionListeners() 
     * @see #fireActionPerformed(String, long, int) 
     * @see #fireActionPerformed(String) 
     */
    protected void fireActionPerformed(ActionEvent evt){
        if (evt == null)    // If the event is null
            return;
            // If the event's source is not this component
        else if (evt.getSource() != this){
            evt = new ActionEvent(this, evt.getID(), evt.getActionCommand(),
                    evt.getWhen(),evt.getModifiers());
        }
            // A for loop to go through the action listeners
        for (ActionListener l : listenerList.getListeners(ActionListener.class)){
            if (l != null)  // If the listener is not null
                l.actionPerformed(evt);
        }
    }
    /**
     * This notifies all the {@code ActionListener}s that have been added to 
     * this panel of the given action command if the action command is not null. 
     * @param command The action command for the action event to fire.
     * @param when The time at which the event occurred.
     * @param modifiers The modifier keys that were down during the event. Zero 
     * indicates that no known modifiers were passed.
     * @see #addActionListener(ActionListener) 
     * @see #removeActionListener(ActionListener) 
     * @see #getActionListeners() 
     * @see #fireActionPerformed(ActionEvent) 
     * @see #fireActionPerformed(String) 
     */
    protected void fireActionPerformed(String command, long when, int modifiers){
        if (command == null)    // If the action command is null.
            return;
        fireActionPerformed(new ActionEvent(this,ActionEvent.ACTION_PERFORMED,
                command,when,modifiers));
    }
    /**
     * This notifies all the {@code ActionListener}s that have been added to 
     * this panel of the given action command if the action command is not null. 
     * @param command The action command for the action event to fire.
     * @see #addActionListener(ActionListener) 
     * @see #removeActionListener(ActionListener) 
     * @see #getActionListeners() 
     * @see #fireActionPerformed(ActionEvent) 
     * @see #fireActionPerformed(String, long, int) 
     */
    protected void fireActionPerformed(String command){
        fireActionPerformed(command,System.currentTimeMillis(),0);
    }
    /**
     * This returns the String representation of the given dialog option. If 
     * this returns null and the dialog option is not the {@link #ERROR_OPTION}, 
     * then no String will be displayed for the given dialog option.
     * @param option The dialog option to get the String for.
     * @return The String stating the given dialog option, or null if no String 
     * is available for the given option.
     * @see #getOption() 
     * @see #getOptionForCommand(String) 
     */
    protected abstract String getOptionString(int option);
    /**
     * This returns a String representation of this AbstractDialogPanel. This 
     * method is primarily intended to be used only for debugging purposes, and 
     * the content and format of the returned String may vary between 
     * implementations.
     * @return A String representation of this AbstractDialogPanel.
     */
    @Override
    protected String paramString(){
            // Get the String for the option
        String optStr = getOptionString(getOption());
            // If the string is null, but the option is the error option
        if (optStr == null && getOption() == ERROR_OPTION)
            optStr = "ERROR_OPTION";
        return super.paramString()+
                ",dialogTitle="+Objects.toString(getDialogTitle(), "")+
                ",dialogOption="+Objects.toString(optStr, "");
    }
    /**
     * This is the title for the dialog.
     */
    private String title;
    // TODO: Make the dialog more customizable, so as to make this panel more 
    // vercitile
//    /**
//     * This stores whether the dialog is resizable or not.
//     */
//    private boolean resizable = true;
//    /**
//     * This stores whether the dialog should be always on top or not.
//     */
//    private boolean alwaysOnTop = false;
//    /**
//     * This stores the modality type for the dialog.
//     */
//    private Dialog.ModalityType modalType = java.awt.Dialog.DEFAULT_MODALITY_TYPE;
//    private Dialog.ModalExclusionType exclusionType
    /**
     * This is the dialog being used to display this panel.
     */
    private JDialog dialog = null;
    /**
     * This is the WindowListener used for listening the dialog. This is 
     * initialized the first time it is requested.
     */
    private WindowListener windowListener = null;
    /**
     * This is used to provide error feedback to the user when this is disabled. 
     * This is initialized the first time it is requested.
     */
    private DisabledComponentMouseListener disabledListener = null;
    /**
     * This is the value returned when the dialog is closed.
     */
    private int returnValue = ERROR_OPTION;
    /**
     * This is an ActionEvent that can be queued up to be fired the next time 
     * the dialog is closed without providing an ActionEvent.
     */
    private ActionEvent event = null;
}
