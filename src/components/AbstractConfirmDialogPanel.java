/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package components;

import java.awt.*;
import java.awt.event.*;
import java.util.Objects;
import javax.swing.*;

/**
 * This is a panel that provides the basic framework for a panel that can pop up 
 * a dialog box to confirm something.
 * @author Milo Steier
 */
public abstract class AbstractConfirmDialogPanel extends AbstractDialogPanel{
    /**
     * This is the value returned if confirmation has been given.
     */
    public static final int ACCEPT_OPTION = 1;
    /**
     * This is the value returned if cancelled.
     */
    public static final int CANCEL_OPTION = 0;
    /**
     * This is the instruction to accept/confirm the action.
     */
    public static final String ACCEPT_SELECTED = "AcceptSelected";
    /**
     * This is the instruction to cancel the action.
     */
    public static final String CANCEL_SELECTED = "CancelSelected";
    /**
     * This identifies that the text for the accept button has changed.
     */
    public static final String ACCEPT_BUTTON_TEXT_PROPERTY_CHANGED = 
            "AcceptButtonTextPropertyChanged";
    /**
     * This identifies that the mnemonic for the accept button has changed.
     */
    public static final String ACCEPT_BUTTON_MNEMONIC_PROPERTY_CHANGED = 
            "AcceptButtonMnemonicPropertyChanged";
    /**
     * This identifies that the tool tip text for the accept button has changed.
     */
    public static final String ACCEPT_BUTTON_TOOL_TIP_TEXT_PROPERTY_CHANGED = 
            "AcceptButtonToolTipTextPropertyChanged";
    /**
     * This identifies that the text for the cancel button has changed.
     */
    public static final String CANCEL_BUTTON_TEXT_PROPERTY_CHANGED = 
            "CancelButtonTextPropertyChanged";
    /**
     * This identifies that the mnemonic for the cancel button has changed.
     */
    public static final String CANCEL_BUTTON_MNEMONIC_PROPERTY_CHANGED = 
            "CancelButtonMnemonicPropertyChanged";
    /**
     * This identifies that the tool tip text for the cancel button has changed.
     */
    public static final String CANCEL_BUTTON_TOOL_TIP_TEXT_PROPERTY_CHANGED = 
            "CancelButtonToolTipTextPropertyChanged";
    /**
     * This identifies that the control buttons have been set to be shown or 
     * hidden.
     */
    public static final String CONTROL_BUTTONS_ARE_SHOWN_PROPERTY_CHANGED = 
            "ControlButtonsAreShownPropertyChanged";
    /**
     * This constructs and returns a button to be used as one of the control 
     * buttons.
     * @param command The action command for the button.
     * @param handler The handler to use to listen to the button.
     * @return A button to use for the control buttons.
     */
    private JButton createButton(String command, Handler handler){
            // This is the button to return.
        JButton button = new JButton();
        button.setActionCommand(command);
        button.addActionListener(handler);
        button.addMouseListener(getDisabledComponentListener());
        return button;
    }
    /**
     * This initializes the control buttons for this AbstractConfirmDialogPanel.
     */
    private void initialize(){
        Handler handler = new Handler();
        acceptButton = createButton(ACCEPT_SELECTED,handler);
        cancelButton = createButton(CANCEL_SELECTED,handler);
        updateButtonText();
        updateAcceptEnabled();
    }
    /**
     * This constructs an AbstractConfirmDialogPanel with the specified layout 
     * manager, buffering strategy, and title for the dialog.
     * @param layout The layout manager to use.
     * @param isDoubleBuffered Whether this panel uses double-buffering to 
     * achieve fast, flicker-free updates at the expense of using additional 
     * memory space.
     * @param title The title for the dialog.
     */
    public AbstractConfirmDialogPanel(LayoutManager layout, 
            boolean isDoubleBuffered, String title){
        super(layout,isDoubleBuffered,title);
        initialize();
    }
    /**
     * This constructs an AbstractConfirmDialogPanel with the specified layout 
     * manager and buffering strategy.
     * @param layout The layout manager to use.
     * @param isDoubleBuffered Whether this panel uses double-buffering to 
     * achieve fast, flicker-free updates at the expense of using additional 
     * memory space.
     */
    public AbstractConfirmDialogPanel(LayoutManager layout, boolean isDoubleBuffered){
        super(layout,isDoubleBuffered);
        initialize();
    }
    /**
     * This constructs an AbstractConfirmDialogPanel with the specified layout 
     * manager and title for the dialog.
     * @param layout The layout manager to use.
     * @param title The title for the dialog.
     */
    public AbstractConfirmDialogPanel(LayoutManager layout, String title){
        super(layout,title);
        initialize();
    }
    /**
     * This constructs an AbstractConfirmDialogPanel with the specified layout 
     * manager.
     * @param layout The layout manager to use.
     */
    public AbstractConfirmDialogPanel(LayoutManager layout){
        super(layout);
        initialize();
    }
    /**
     * This constructs an AbstractConfirmDialogPanel with a flow layout and the 
     * given buffering strategy and title for the dialog.
     * @param isDoubleBuffered Whether this panel uses double-buffering to 
     * achieve fast, flicker-free updates at the expense of using additional 
     * memory space.
     * @param title The title for the dialog.
     */
    public AbstractConfirmDialogPanel(boolean isDoubleBuffered, String title){
        super(isDoubleBuffered,title);
        initialize();
    }
    /**
     * This constructs an AbstractConfirmDialogPanel with a flow layout and the 
     * given buffering strategy.
     * @param isDoubleBuffered Whether this panel uses double-buffering to 
     * achieve fast, flicker-free updates at the expense of using additional 
     * memory space.
     */
    public AbstractConfirmDialogPanel(boolean isDoubleBuffered){
        super(isDoubleBuffered);
        initialize();
    }
    /**
     * This constructs an AbstractConfirmDialogPanel that is double buffered 
     * with a flow layout and the given title for the dialog.
     * @param title The title for the dialog.
     */
    public AbstractConfirmDialogPanel(String title){
        super(title);
        initialize();
    }
    /**
     * This constructs an AbstractConfirmDialogPanel that is double buffered 
     * with a flow layout.
     */
    public AbstractConfirmDialogPanel(){
        super();
        initialize();
    }
    /**
     * This returns the mnemonic to use for the given text. If the text is null 
     * or empty, then this returns zero. Otherwise, this returns the key code 
     * for the first character in the given text.
     * @param text The text to get the mnemonic from.
     * @return The key code first character in the text, or zero if the text is 
     * null or empty.
     */
    private int getDefaultMnemonic(String text){
        if (text == null || text.isEmpty()) // If the text is null or empty
            return 0;
        return KeyEvent.getExtendedKeyCodeForChar(text.charAt(0));
    }
    /**
     * This returns the default text to use for the accept button when no text 
     * has been set.
     * 
     * @implSpec This implementation returns the word "OK".
     * 
     * @return The default text for the accept button.
     * @see #getAcceptButton() 
     * @see #isAcceptButtonTextSet() 
     * @see #getAcceptButtonText() 
     * @see #setAcceptButtonText(String) 
     * @see #updateButtonText() 
     */
    protected String getDefaultAcceptButtonText(){
        return "OK";
    }
    /**
     * This returns the default mnemonic keycode to use for the accept button 
     * when no mnemonic has been set.
     * 
     * @implSpec This implementation returns the mnemonic keycode for the first 
     * character of the {@link #getAcceptButtonText() accept button's text}.
     * 
     * @return The default mnemonic keycode for the accept button.
     * @see #getAcceptButton() 
     * @see #isAcceptButtonMnemonicSet() 
     * @see #getAcceptButtonMnemonic() 
     * @see #setAcceptButtonMnemonic(int) 
     * @see #setAcceptButtonMnemonic(char) 
     * @see #getAcceptButtonText() 
     * @see #updateButtonText() 
     */
    protected int getDefaultAcceptButtonMnemonic(){
        return getDefaultMnemonic(getAcceptButtonText());
    }
    /**
     * This returns the default tool tip text to use for the accept button when 
     * no tool tip text has been set.
     * @return The default tool tip text for the accept button.
     * @see #getAcceptButton 
     * @see #isAcceptButtonToolTipTextSet 
     * @see #getAcceptButtonToolTipText 
     * @see #setAcceptButtonToolTipText 
     * @see #updateButtonText 
     */
    protected abstract String getDefaultAcceptButtonToolTipText();
    /**
     * This returns the default text to use for the cancel button when no text 
     * has been set.
     * 
     * @implSpec This implementation returns the word "Cancel".
     * 
     * @return The default text for the cancel button.
     * @see #getCancelButton() 
     * @see #isCancelButtonTextSet() 
     * @see #getCancelButtonText() 
     * @see #setCancelButtonText(String) 
     * @see #updateButtonText() 
     */
    protected String getDefaultCancelButtonText(){
        return "Cancel";
    }
    /**
     * This returns the default mnemonic keycode to use for the cancel button 
     * when no mnemonic has been set.
     * 
     * @implSpec This implementation returns the mnemonic keycode for the first 
     * character of the {@link #getCancelButtonText() cancel button's text}.
     * 
     * @return The default mnemonic keycode for the cancel button.
     * @see #getCancelButton() 
     * @see #isCancelButtonMnemonicSet() 
     * @see #getCancelButtonMnemonic() 
     * @see #setCancelButtonMnemonic(int) 
     * @see #setCancelButtonMnemonic(char) 
     * @see #getCancelButtonText() 
     * @see #updateButtonText() 
     */
    protected int getDefaultCancelButtonMnemonic(){
        return getDefaultMnemonic(getCancelButtonText());
    }
    /**
     * This returns the default tool tip text to use for the cancel button when 
     * no tool tip text has been set.
     * @return The default tool tip text for the cancel button.
     * @see #getCancelButton 
     * @see #isCancelButtonToolTipTextSet 
     * @see #getCancelButtonToolTipText 
     * @see #setCancelButtonToolTipText 
     * @see #updateButtonText 
     */
    protected abstract String getDefaultCancelButtonToolTipText();
    /**
     * This method is used to update the text, mnemonic, and tool tip text of 
     * the {@link #getAcceptButton() accept} and {@link #getCancelButton() 
     * cancel} buttons all at once. This is so that if a panel has more than one 
     * default text, mnemonic, or tool tip text for either button, then calling 
     * this method will ensure that the buttons will reflect any changes. <p>
     * 
     * This method effectively calls each button's {@link 
     * JButton#setText(String) setText}, {@link JButton#setMnemonic(int) 
     * setMnemonic}, and {@link JButton#setToolTipText(String) setToolTipText} 
     * methods with the methods to get the button's text, mnemonic, and tool tip 
     * text provided by this panel.
     * @see #getAcceptButton()
     * @see #getCancelButton()
     * @see JButton#setText(String)
     * @see JButton#setMnemonic(int)
     * @see JButton#setToolTipText(String)
     * @see #getAcceptButtonText() 
     * @see #getAcceptButtonMnemonic() 
     * @see #getAcceptButtonToolTipText() 
     * @see #getCancelButtonText() 
     * @see #getCancelButtonMnemonic() 
     * @see #getCancelButtonToolTipText() 
     */
    protected void updateButtonText(){
        acceptButton.setText(getAcceptButtonText());
        acceptButton.setMnemonic(getAcceptButtonMnemonic());
        acceptButton.setToolTipText(getAcceptButtonToolTipText());
        cancelButton.setText(getCancelButtonText());
        cancelButton.setMnemonic(getCancelButtonMnemonic());
        cancelButton.setToolTipText(getCancelButtonToolTipText());
    }
    /**
     * This returns whether the text for the accept button has been set to a 
     * non-null value.
     * @return Whether {@code setAcceptButtonText} has been invoked with a 
     * non-null value.
     * @see #setAcceptButtonText(String) 
     * @see #getAcceptButtonText() 
     */
    public boolean isAcceptButtonTextSet(){
        return acceptText != null;
    }
    /**
     * This returns the text for the accept button. If the text has been set to 
     * a null value, then this will return the default text for the accept 
     * button as determined by this panel.
     * @return The text for the accept button.
     * @see #isAcceptButtonTextSet() 
     * @see #setAcceptButtonText(String) 
     */
    public String getAcceptButtonText(){
            // If the text is set, return it. Otherwise, return the default text.
        return isAcceptButtonTextSet()?acceptText:getDefaultAcceptButtonText();
    }
    /**
     * This sets the text for the accept button. If the text is null, then this 
     * panel will determine the text to use for the accept button. If a mnemonic 
     * has not been set for the accept button, then this panel will also 
     * determine the mnemonic to use for the accept button, which is typically 
     * the first character of the text for the accept button.
     * @param text The text for the accept button, or null.
     * @see #isAcceptButtonTextSet() 
     * @see #getAcceptButtonText() 
     * @see #isAcceptButtonMnemonicSet() 
     * @see #getAcceptButtonMnemonic() 
     * @see #setAcceptButtonMnemonic(int) 
     * @see #setAcceptButtonMnemonic(char) 
     */
    public void setAcceptButtonText(String text){
            // If the accept text will not change
        if (Objects.equals(text, acceptText))
            return;
        String old = acceptText;    // Get the old text
        acceptText = text;
        acceptButton.setText(getAcceptButtonText());
        acceptButton.setMnemonic(getAcceptButtonMnemonic());
        firePropertyChange(ACCEPT_BUTTON_TEXT_PROPERTY_CHANGED,old,text);
    }
    /**
     * This determines which mnemonic to return depending on whether the 
     * mnemonic is set and non-null.
     * @param isSet Whether the mnemonic claims to be set.
     * @param mnemonic The mnemonic that has been set.
     * @param defaultMnemonic The mnemonic to fall back on if the mnemonic is 
     * not set.
     * @return {@code mnemonic} if it is set and non-null, {@code 
     * defaultMnemonic} if it is not set, and zero if it is set and null.
     * @see #isAcceptButtonMnemonicSet() 
     * @see #isCancelButtonMnemonicSet() 
     * @see #getAcceptButtonMnemonic() 
     * @see #getCancelButtonMnemonic() 
     * @see #getDefaultAcceptButtonMnemonic() 
     * @see #getDefaultCancelButtonMnemonic() 
     */
    private int getMnemonic(boolean isSet, Integer mnemonic, int defaultMnemonic){
            // If the mnemonic is set and non-null, return it. If it is set but 
            // null, return zero. Otherwise, return the default mnemonic
        return (isSet) ? ((mnemonic!=null)? mnemonic : 0) : defaultMnemonic;
    }
    /**
     * This returns whether the mnemonic for the accept button has been set.
     * @return Whether {@code setAcceptButtonMnemonic} has been invoked.
     * @see #setAcceptButtonMnemonic(int) 
     * @see #setAcceptButtonMnemonic(char) 
     * @see #getAcceptButtonMnemonic() 
     */
    public boolean isAcceptButtonMnemonicSet(){
        return acceptMnemonic != null;
    }
    /**
     * This sets the mnemonic for the accept button using a character.
     * @param mnemonic The character value for the mnemonic key for the accept 
     * button.
     * @see #isAcceptButtonMnemonicSet() 
     * @see #getAcceptButtonMnemonic() 
     * @see #setAcceptButtonMnemonic(int) 
     */
    public void setAcceptButtonMnemonic(char mnemonic){
        setAcceptButtonMnemonic((int)Character.toUpperCase(mnemonic));
    }
    /**
     * This returns the mnemonic for the accept button. If the mnemonic has not 
     * been set, then this will return the default mnemonic for the accept 
     * button as determined by this panel. The default mnemonic is typically the 
     * first character of the text for the accept button.
     * @return The mnemonic for the accept button.
     * @see #isAcceptButtonMnemonicSet() 
     * @see #setAcceptButtonMnemonic(int) 
     * @see #setAcceptButtonMnemonic(char) 
     * @see #getAcceptButtonText() 
     */
    public int getAcceptButtonMnemonic(){
        return getMnemonic(isAcceptButtonMnemonicSet(),acceptMnemonic,
                getDefaultAcceptButtonMnemonic());
    }
    /**
     * This sets the mnemonic for the accept button using a numeric keycode. If 
     * the mnemonic has not been set, then this panel will determine the 
     * mnemonic to use for the accept button, which will typically be the first 
     * character of the text for the accept button.
     * @param mnemonic The integer value for the mnemonic key for the accept 
     * button.
     * @see #isAcceptButtonMnemonicSet() 
     * @see #getAcceptButtonMnemonic() 
     * @see #setAcceptButtonMnemonic(char) 
     * @see #getAcceptButtonText() 
     */
    public void setAcceptButtonMnemonic(int mnemonic){
            // If the accept mnemonic will not change
        if (Objects.equals(acceptMnemonic, mnemonic))
            return;
        Integer old = acceptMnemonic;   // Get the old accept mnemonic
        acceptMnemonic = mnemonic;
        acceptButton.setMnemonic(getAcceptButtonMnemonic());
        firePropertyChange(ACCEPT_BUTTON_MNEMONIC_PROPERTY_CHANGED,old,acceptMnemonic);
    }
    /**
     * This returns whether the tool tip text for the accept button has been set 
     * to a non-null value.
     * @return Whether {@code setAcceptButtonToolTipText} has been invoked with 
     * a non-null value.
     * @see #setAcceptButtonToolTipText(String) 
     * @see #getAcceptButtonToolTipText() 
     * @see #getAcceptButtonText() 
     */
    public boolean isAcceptButtonToolTipTextSet(){
        return acceptToolTip != null;
    }
    /**
     * This returns the tool tip text for the accept button. If the tool tip 
     * text has been set to a null value, then this will return the default tool 
     * tip text for the accept button as determined by this panel.
     * @return The tool tip text for the accept button.
     * @see #isAcceptButtonToolTipTextSet() 
     * @see #setAcceptButtonToolTipText(String) 
     * @see #getAcceptButtonText() 
     */
    public String getAcceptButtonToolTipText(){
            // If the tool tip text is set, return it. Otherwise, return the 
            // default tool tip text.
        return isAcceptButtonToolTipTextSet() ? acceptToolTip : 
                getDefaultAcceptButtonToolTipText();
    }
    /**
     * This sets the tool tip text for the accept button. If the tool tip text 
     * is null, then this panel will determine the tool tip text to use for the 
     * accept button.
     * @param toolTipText The tool tip text for the accept button, or null.
     * @see #isAcceptButtonToolTipTextSet() 
     * @see #getAcceptButtonToolTipText() 
     * @see #getAcceptButtonText() 
     */
    public void setAcceptButtonToolTipText(String toolTipText){
            // If the accept tool tip text will not change
        if (Objects.equals(toolTipText, acceptToolTip))
            return;
        String old = acceptToolTip;     // Get the old accept tool tip text
        acceptToolTip = toolTipText;
        acceptButton.setToolTipText(getAcceptButtonToolTipText());
        firePropertyChange(ACCEPT_BUTTON_TOOL_TIP_TEXT_PROPERTY_CHANGED,old,toolTipText);
    }
    /**
     * This returns whether the text for the cancel button has been set to a 
     * non-null value.
     * @return Whether {@code setCancelButtonText} has been invoked with a 
     * non-null value.
     * @see #setCancelButtonText(String) 
     * @see #getCancelButtonText() 
     */
    public boolean isCancelButtonTextSet(){
        return cancelText != null;
    }
    /**
     * This returns the text for the cancel button. If the text has been set to 
     * a null value, then this will return the default text for the cancel 
     * button as determined by this panel.
     * @return The text for the cancel button.
     * @see #isCancelButtonTextSet() 
     * @see #setCancelButtonText(String) 
     */
    public String getCancelButtonText(){
            // If the text is set, return it. Otherwise, return the default text.
        return isCancelButtonTextSet()?cancelText:getDefaultCancelButtonText();
    }
    /**
     * This sets the text for the cancel button. If the text is null, then this 
     * panel will determine the text to use for the cancel button. If a mnemonic 
     * has not been set for the cancel button, then this panel will also 
     * determine the mnemonic to use for the cancel button, which is typically 
     * the first character of the text for the cancel button.
     * @param text The text for the cancel button, or null.
     * @see #isCancelButtonTextSet() 
     * @see #getCancelButtonText() 
     * @see #isCancelButtonMnemonicSet() 
     * @see #getCancelButtonMnemonic() 
     * @see #setCancelButtonMnemonic(int) 
     * @see #setCancelButtonMnemonic(char) 
     */
    public void setCancelButtonText(String text){
            // If the cancel text will not change
        if (Objects.equals(text, cancelText))
            return;
        String old = cancelText;    // Get the old cancel text
        cancelText = text;
        cancelButton.setText(getCancelButtonText());
        cancelButton.setMnemonic(getCancelButtonMnemonic());
        firePropertyChange(CANCEL_BUTTON_TEXT_PROPERTY_CHANGED,old,text);
    }
    /**
     * This returns whether the mnemonic for the cancel button has been set.
     * @return Whether {@code setCancelButtonMnemonic} has been invoked.
     * @see #setCancelButtonMnemonic(int) 
     * @see #setCancelButtonMnemonic(char) 
     * @see #getCancelButtonMnemonic() 
     */
    public boolean isCancelButtonMnemonicSet(){
        return cancelMnemonic != null;
    }
    /**
     * This sets the mnemonic for the cancel button using a character.
     * @param mnemonic The character value for the mnemonic key for the cancel 
     * button.
     * @see #isCancelButtonMnemonicSet() 
     * @see #getCancelButtonMnemonic() 
     * @see #setCancelButtonMnemonic(int) 
     */
    public void setCancelButtonMnemonic(char mnemonic){
        setCancelButtonMnemonic((int)Character.toUpperCase(mnemonic));
    }
    /**
     * This returns the mnemonic for the cancel button. If the mnemonic has not 
     * been set, then this will return the default mnemonic for the cancel 
     * button as determined by this panel. The default mnemonic is typically the 
     * first character of the text for the cancel button.
     * @return The mnemonic for the cancel button.
     * @see #isCancelButtonMnemonicSet() 
     * @see #setCancelButtonMnemonic(int) 
     * @see #setCancelButtonMnemonic(char) 
     * @see #getCancelButtonText() 
     */
    public int getCancelButtonMnemonic(){
        return getMnemonic(isCancelButtonMnemonicSet(),cancelMnemonic,
                getDefaultCancelButtonMnemonic());
    }
    /**
     * This sets the mnemonic for the cancel button using a numeric keycode. If 
     * the mnemonic is not set, then this panel will determine the mnemonic to 
     * use for the cancel button, which will typically be the first character of 
     * the text for the cancel button.
     * @param mnemonic The integer value for the mnemonic key for the cancel 
     * button.
     * @see #isCancelButtonMnemonicSet() 
     * @see #getCancelButtonMnemonic() 
     * @see #setCancelButtonMnemonic(char) 
     * @see #getCancelButtonText() 
     */
    public void setCancelButtonMnemonic(int mnemonic){
            // If the cancel mnemonic will not change
        if (Objects.equals(cancelMnemonic, mnemonic))
            return;
        Integer old = cancelMnemonic;   // Get the old cancel mnemonic
        cancelMnemonic = mnemonic;
        cancelButton.setMnemonic(getCancelButtonMnemonic());
        firePropertyChange(CANCEL_BUTTON_MNEMONIC_PROPERTY_CHANGED,old,cancelMnemonic);
    }
    /**
     * This returns whether the tool tip text for the cancel button has been set 
     * to a non-null value.
     * @return Whether {@code setCancelButtonToolTipText} has been invoked with 
     * a non-null value.
     * @see #setCancelButtonToolTipText(String) 
     * @see #getCancelButtonToolTipText() 
     * @see #getCancelButtonText() 
     */
    public boolean isCancelButtonToolTipTextSet(){
        return cancelToolTip != null;
    }
    /**
     * This returns the tool tip text for the cancel button. If the tool tip 
     * text has been set to a null value, then this will return the default tool 
     * tip text for the cancel button as determined by this panel.
     * @return The tool tip text for the cancel button.
     * @see #isCancelButtonToolTipTextSet() 
     * @see #setCancelButtonToolTipText(String) 
     * @see #getCancelButtonText() 
     */
    public String getCancelButtonToolTipText(){
            // If the tool tip text is set, return it. Otherwise, return the 
            // default tool tip text.
        return isCancelButtonToolTipTextSet() ? cancelToolTip : 
                getDefaultCancelButtonToolTipText();
    }
    /**
     * This sets the tool tip text for the cancel button. If the tool tip text 
     * is null, then this panel will determine the tool tip text to use for the 
     * cancel button.
     * @param toolTipText The tool tip text for the cancel button, or null.
     * @see #isCancelButtonToolTipTextSet() 
     * @see #getCancelButtonToolTipText() 
     * @see #getCancelButtonText() 
     */
    public void setCancelButtonToolTipText(String toolTipText){
            // If the cancel tool tip text will not change
        if (Objects.equals(toolTipText, cancelToolTip))
            return;
        String old = cancelToolTip;     // Get the old cancel tool tip text
        cancelToolTip = toolTipText;
        cancelButton.setToolTipText(getCancelButtonToolTipText());
        firePropertyChange(CANCEL_BUTTON_TOOL_TIP_TEXT_PROPERTY_CHANGED,old,toolTipText);
    }
    /**
     * This returns the button used to accept the action that this panel 
     * performs.
     * @return The accept button.
     * @see #ACCEPT_SELECTED
     * @see #accept() 
     */
    public javax.swing.JButton getAcceptButton(){
        return acceptButton;
    }
    /**
     * This returns the button used to cancel the action that this panel 
     * performs.
     * @return The cancel button.
     * @see #CANCEL_SELECTED
     * @see #cancel() 
     */
    public javax.swing.JButton getCancelButton(){
        return cancelButton;
    }
    /**
     * This is the method invoked when the accept button is pressed. This can 
     * also be called by the programmer. This method will also cause an action 
     * event to fire with the {@link ACCEPT_SELECTED} action command. 
     * @see #ACCEPT_SELECTED
     */
    public void accept(){
        closeDialog(ACCEPT_SELECTED);
    }
    /**
     * This is the method invoked when the accept button is pressed. This 
     * version allows for an optional {@code ActionEvent} to be provided. This 
     * method will also cause an action event to fire with the {@link 
     * ACCEPT_SELECTED} action command. 
     * @param evt The action event to be processed, or null.
     * @see #ACCEPT_SELECTED
     * @see #accept() 
     * @see #getAcceptButton() 
     */
    protected void accept(ActionEvent evt){
        setCloseEvent(evt);
        accept();
    }
    /**
     * This is the method invoked when the cancel button is pressed. This can 
     * also be called by the programmer. This method will also cause an action 
     * event to fire with the {@link CANCEL_SELECTED} action command. 
     * @see #CANCEL_SELECTED
     */
    public void cancel(){
        closeDialog(CANCEL_SELECTED);
    }
    /**
     * This is the method invoked when the cancel button is pressed. This 
     * version allows for an optional {@code ActionEvent} to be provided. This 
     * method will also cause an action event to fire with the {@link 
     * CANCEL_SELECTED} action command. 
     * @param evt The action event to be processed, or null.
     * @see #CANCEL_SELECTED
     * @see #cancel() 
     * @see #getCancelButton() 
     */
    protected void cancel(ActionEvent evt){
        setCloseEvent(evt);
        cancel();
    }
    /**
     * This is the method invoked when the escape key is pressed. This has been 
     * overridden to invoke {@link #cancel(ActionEvent) cancel}.
     * @param evt {@inheritDoc }
     * @see #getEscapePressedAction() 
     * @see #cancel(ActionEvent) 
     * @see #cancel() 
     * @see #CANCEL_SELECTED
     */
    @Override
    protected void escapeActionPerformed(ActionEvent evt){
        cancel(evt);
    }
    /**
     * {@inheritDoc }
     * 
     * @implSpec This implementation returns {@link #CANCEL_SELECTED}.
     * 
     * @return {@inheritDoc }
     * @see #getDialogWindowListener() 
     * @see #getOptionForCommand(String) 
     * @see #CANCEL_SELECTED
     * @see #CANCEL_OPTION
     */
    @Override
    protected String getDialogClosingCommand() {
        return CANCEL_SELECTED;
    }
    /**
     * {@inheritDoc }
     * @param command {@inheritDoc }
     * @return {@inheritDoc }
     * @see #getOption() 
     * @see #getOptionString(int) 
     * @see #closeDialog(ActionEvent, String) 
     * @see #closeDialog(ActionEvent) 
     * @see #closeDialog(String) 
     */
    @Override
    protected int getOptionForCommand(String command) {
        if (command != null){           // If the command is not null
            switch(command){
                case(ACCEPT_SELECTED):  // If the command is the accept command
                    return ACCEPT_OPTION;
                case(CANCEL_SELECTED):  // If the command is the cancel command
                    return CANCEL_OPTION;
            }
        }
        return ERROR_OPTION;
    }
    /**
     * {@inheritDoc }
     * @param option {@inheritDoc }
     * @return {@inheritDoc }
     * @see #getOption() 
     * @see #getOptionForCommand(String) 
     */
    @Override
    protected String getOptionString(int option) {
        switch(option){
            case(ACCEPT_OPTION):            // If this is the accept option
                return "ACCEPT_OPTION";
            case(CANCEL_OPTION):            // If this is the cancel option
                return "CANCEL_OPTION";
            default:
                return null;
        }
    }
    /**
     * {@inheritDoc }
     * @param parent {@inheritDoc }
     * @return {@inheritDoc }
     * @see #getDialogForComponent(Component, String) 
     * @see #getDialogTitle() 
     * @see #getDialog() 
     * @see #showDialog(Component) 
     * @see #getDialogWindowListener() 
     */
    @Override
    protected JDialog createDialog(Component parent){
            // Create the dialog
        JDialog dialog = super.createDialog(parent);
        getRootPane().setDefaultButton(acceptButton);
        return dialog;
    }
    /**
     * {@inheritDoc }
     * @param parent {@inheritDoc }
     * @return The return state of the panel. This will be either {@link 
     * #ACCEPT_OPTION}, {@link #CANCEL_OPTION}, or {@link #ERROR_OPTION}, with 
     * the last being returned if an error occurred or if the dialog is 
     * dismissed.
     * @see #ACCEPT_OPTION
     * @see #CANCEL_OPTION
     * @see #ERROR_OPTION
     */
    @Override
    public int showDialog(Component parent){
        return super.showDialog(parent);
    }
    /**
     * This returns whether the control buttons (the accept and cancel buttons) 
     * are shown by this panel. Some panels may ignore this and always show the 
     * control buttons, while other panels may show or hide additional 
     * components depending on this value.
     * @return Whether the control buttons are shown.
     * @see #setControlButtonsAreShown(boolean) 
     */
    public boolean getControlButtonsAreShown(){
        return showControls;
    }
    /**
     * This sets whether the accept and cancel buttons will be shown by this 
     * panel. This property is true by default. Some panels may ignore this 
     * value and always show these buttons. Some panels may show or hide 
     * additional components depending on whether these buttons are shown.
     * @param value Whether the control buttons should be shown or not.
     * @see #getControlButtonsAreShown() 
     * @see #CONTROL_BUTTONS_ARE_SHOWN_PROPERTY_CHANGED
     */
    public void setControlButtonsAreShown(boolean value){
            // If the controls will not have their visibility changed
        if (value == showControls)                      
            return;
        showControls = value;
        firePropertyChange(CONTROL_BUTTONS_ARE_SHOWN_PROPERTY_CHANGED,!value,value);
        setControlsAreVisible(value);
    }
    /**
     * This returns an array containing the control buttons and related 
     * components that will be shown or hidden depending on whether the {@link 
     * #getControlButtonsAreShown() control buttons are shown}.
     * @return An array containing the control components.
     * @see #setControlsAreVisible(boolean) 
     * @see #setControlButtonsAreShown(boolean) 
     * @see #getControlButtonsAreShown() 
     * @see #getControlsCanBeHidden() 
     */
    protected Component[] getControls(){
        return new Component[]{acceptButton,cancelButton};
    }
    /**
     * This returns whether the {@link #getControls() controls} can be hidden. 
     * 
     * @implSpec This implementation returns true.
     * 
     * @return Whether the controls can be hidden.
     * @see #setControlsAreVisible(boolean) 
     * @see #getControls() 
     * @see #setControlButtonsAreShown(boolean) 
     * @see #getControlButtonsAreShown() 
     */
    protected boolean getControlsCanBeHidden(){
        return true;
    }
    /**
     * This shows or hides the {@link #getControls() controls} depending on the 
     * given value. This is called by {@link #setControlButtonsAreShown(boolean) 
     * setControlButtonsAreShown} to show or hide the controls. If the controls 
     * should always be visible, then the {@link #getControlsCanBeHidden() 
     * getControlsCanBeHidden} method should be overridden to return false.
     * @param value Whether the controls should be visible.
     * @see #getControls() 
     * @see #getControlsCanBeHidden() 
     * @see #setControlButtonsAreShown(boolean) 
     * @see #getControlButtonsAreShown() 
     */
    protected void setControlsAreVisible(boolean value){
            // If the controls are attempting to be hidden but are not able to 
        if (!value && !getControlsCanBeHidden())
            return;
            // A for loop to go through the controls
        for (java.awt.Component c : getControls()){
            if (c != null)  // If the control component is not null
                c.setVisible(value);
        }
    }
    @Override
    public void setFont(Font font){
        super.setFont(font);
        try{
            acceptButton.setFont(font);
            cancelButton.setFont(font);
        }catch(NullPointerException ex){}
    }
    /**
     * This returns whether the accept button should be enabled. This is invoked 
     * by the {@link #updateAcceptEnabled() } method to get whether the accept 
     * button should be enabled. 
     * 
     * @implSpec This implementation returns {@link #isEnabled() }.
     * 
     * @return Whether the accept button should be enabled.
     * @see #getAcceptButton() 
     * @see #updateAcceptEnabled() 
     * @see #isEnabled() 
     */
    protected boolean isAcceptEnabled(){
        return isEnabled();
    }
    /**
     * This updates whether the accept button is enabled. This sets whether the 
     * accept button is enabled based off the value returned by {@link 
     * #isAcceptEnabled() }. 
     * @see #getAcceptButton() 
     * @see #isAcceptEnabled() 
     * @see #setEnabled(boolean) 
     */
    protected void updateAcceptEnabled(){
            // If the accept button has been initialized
        if (acceptButton != null)  
            acceptButton.setEnabled(isAcceptEnabled());
    }
    /**
     * {@inheritDoc }
     * @param enabled {@inheritDoc }
     * @see #isEnabled 
     * @see #isLightweight 
     */
    @Override
    public void setEnabled(boolean enabled){
        super.setEnabled(enabled);
        updateAcceptEnabled();
    }
    /**
     * {@inheritDoc }
     * @param fg {@inheritDoc }
     * @see #getForeground 
     */
    @Override
    public void setForeground(Color fg){
        super.setForeground(fg);
        try{
            acceptButton.setForeground(fg);
            cancelButton.setForeground(fg);
        } catch (NullPointerException ex) {}
    }
    /**
     * {@inheritDoc }
     * @param bg {@inheritDoc }
     * @see #getBackground 
     */
    @Override
    public void setBackground(Color bg){
        super.setBackground(bg);
        try{
            acceptButton.setBackground(bg);
            cancelButton.setBackground(bg);
        } catch (NullPointerException ex) {}
    }
    /**
     * This returns a String representation of this AbstractConfirmDialogPanel. 
     * This method is primarily intended to be used only for debugging purposes, 
     * and the content and format of the returned String may vary between 
     * implementations.
     * @return A String representation of this AbstractConfirmDialogPanel.
     */
    @Override
    protected String paramString(){
        return super.paramString() + ",acceptButtonText="+
                    // If there is text set for the accept button, use it
                ((isAcceptButtonTextSet()) ? getAcceptButtonText() : "");
    }
    /**
     * This controls whether the control buttons are shown.
     */
    private boolean showControls = true;
    /**
     * This is the text set for the accept button if one has been set for it. If 
     * this is null, then the accept button will use the default accept button 
     * text.
     */
    private String acceptText = null;
    /**
     * This is the mnemonic set for the accept button if one has been set for 
     * it. If this is null, then the accept button will use the default accept 
     * button mnemonic.
     */
    private Integer acceptMnemonic = null;
    /**
     * This is the tool tip text set for the accept button if one has been set 
     * for it. If this is null, then the accept button will use the default 
     * accept button tool tip text.
     */
    private String acceptToolTip = null;
    /**
     * This is the button used to accept or confirm stuff.
     */
    protected JButton acceptButton;
    /**
     * This is the text set for the cancel button if one has been set for it. If 
     * this is null, then the cancel button will use the default cancel button 
     * text.
     */
    private String cancelText = null;
    /**
     * This is the mnemonic set for the cancel button if one has been set for 
     * it. If this is null, then the cancel button will use the default cancel 
     * button mnemonic.
     */
    private Integer cancelMnemonic = null;
    /**
     * This is the tool tip text set for the cancel button if one has been set 
     * for it. If this is null, then the cancel button will use the default 
     * cancel button tool tip text.
     */
    private String cancelToolTip = null;
    /**
     * This is the button used to cancel stuff.
     */
    protected JButton cancelButton;
    /**
     * This is used to handle listening to the accept and cancel buttons so as 
     * to call their corresponding action methods.
     */
    private class Handler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent evt) {
                // Get the action command for the action event
            String command = evt.getActionCommand();
            if (command == null)        // If no action command was given
                return;
            switch(command){
                case(ACCEPT_SELECTED):  // If the accept action command was given
                    accept(evt);
                    return;
                case(CANCEL_SELECTED):  // If the cancel action command was given
                    cancel(evt);
            }
        }
    }
}
