/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package components;

import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Objects;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.colorchooser.*;
import javax.swing.event.*;

/**
 * This is a panel that can be used to select a color using a color chooser, as 
 * well as providing the ability to pop up a dialog box to select a color. This 
 * is meant as a more flexible alternative to the JColorChooser's {@link 
 * JColorChooser#createDialog(Component, String, boolean, JColorChooser, 
 * ActionListener, ActionListener) create} and {@link 
 * JColorChooser#showDialog(Component, String, Color, boolean) show} {@link 
 * JColorChooser#showDialog(Component, String, Color)  dialog} methods. This 
 * also provides a clear button that can be used to set a color back to its 
 * default value, and both clear and reset buttons can be hidden.
 * @author Milo Steier
 * @see JColorChooser
 */
public class JColorSelector extends AbstractConfirmDialogPanel{
    /**
     * This identifies that the accessory component at the bottom has changed.
     */
    public static final String BOTTOM_ACCESSORY_PROPERTY_CHANGED = 
            "BottomAccessoryPropertyChanged";
    /**
     * This identifies that the reset button has been set to be shown or hidden.
     */
    public static final String RESET_BUTTON_IS_SHOWN_PROPERTY_CHANGED = 
            "ResetButtonIsShownPropertyChanged";
    /**
     * This identifies that the clear button has been set to be shown or hidden.
     */
    public static final String CLEAR_BUTTON_IS_SHOWN_PROPERTY_CHANGED = 
            "ClearButtonIsShownPropertyChanged";
    /**
     * This identifies that the text for the clear button has changed.
     */
    public static final String CLEAR_BUTTON_TEXT_PROPERTY_CHANGED = 
            "ClearButtonTextPropertyChanged";
    /**
     * This identifies that the mnemonic for the clear button has changed.
     */
    public static final String CLEAR_BUTTON_MNEMONIC_PROPERTY_CHANGED = 
            "ClearButtonMnemonicPropertyChanged";
    /**
     * This identifies that the tool tip text for the clear button has changed.
     */
    public static final String CLEAR_BUTTON_TOOL_TIP_TEXT_PROPERTY_CHANGED = 
            "ClearButtonToolTipTextPropertyChanged";
    /**
     * This identifies that the title displayed by the border around the color 
     * chooser has changed.
     */
    public static final String COLOR_CHOOSER_TITLE_PROPERTY_CHANGED = 
            "ColorChooserTitlePropertyChanged";
    /**
     * This identifies that the initial color has been changed.
     */
    public static final String INITIAL_COLOR_PROPERTY_CHANGED = 
            "InitialColorPropertyChanged";
    /**
     * This is the instruction to set the color to its default or null.
     */
    public static final String CLEAR_COLOR_SELECTED = "ClearColorSelected";
    /**
     * This is the instruction to reset the selected color to the most recently 
     * set initial color.
     */
    public static final String RESET_COLOR_SELECTED = "ResetColorSelected";
    /**
     * This is the value returned if the color should be set to its default 
     * value.
     */
    public static final int CLEAR_COLOR_OPTION = 2;
    /**
     * This constructs a control button and adds it to the control panel.
     * @param text The text for the button.
     * @param mnemonic The mnemonic for the button.
     * @param toolTip The tool tip text for the button.
     * @param command The action command for the button.
     * @param show Whether to initially show the button.
     * @return The control button that was created.
     */
    private JButton createControlButton(String text,int mnemonic,String toolTip,
            String command, boolean show){
            // The control button to return
        JButton button = new JButton(text);
        button.setMnemonic(mnemonic);
        button.setToolTipText(toolTip);
        button.setActionCommand(command);
        button.addActionListener(handler);
        button.addMouseListener(getDisabledComponentListener());
        if (show)  // If the button should be shown
            controlPanel.add(button);
        button.setVisible(show);
        return button;
    }
    /**
     * This initializes the components of this JColorSelector.
     * @param color The initial color for the color chooser.
     */
    private void initialize(Color color){
        setBorder(BorderFactory.createEmptyBorder(11, 10, 11, 10));
        handler = new Handler();
        colorChooser = new JColorChooser();
        isColorNull = color == null;
        if (!isColorNull)   // If the color is not null
            colorChooser.setColor(color);
        initial = colorChooser.getColor();
        colorChooser.addPropertyChangeListener(handler);
        colorChooser.getSelectionModel().addChangeListener(handler);
        colorChooser.addMouseListener(getDisabledComponentListener());
        colorChooser.setInheritsPopupMenu(true);
        
        colorPanel = new JPanel(new BorderLayout());
        colorPanel.setBorder(BorderFactory.createTitledBorder(""));
        colorPanel.addMouseListener(getDisabledComponentListener());
        colorPanel.setInheritsPopupMenu(true);
        colorPanel.add(colorChooser, BorderLayout.CENTER);
        add(colorPanel, BorderLayout.CENTER);
        
        bottomPanel = new JPanel(new BorderLayout(6, 0));
        bottomPanel.setInheritsPopupMenu(true);
        controlPanel = new JPanel(new GridLayout(1, 0, 6, 0));
        controlPanel.setInheritsPopupMenu(true);
        
        resetButton = createControlButton("Reset",KeyEvent.VK_R,
                "Reset to the initially selected color",RESET_COLOR_SELECTED,showReset);
        
        clearButton = createControlButton(getDefaultClearButtonText(),
                getDefaultClearButtonMnemonic(),getDefaultClearButtonToolTipText(),
                CLEAR_COLOR_SELECTED,showClear);
        
        controlPanel.add(acceptButton);
        controlPanel.add(cancelButton);
        
//        controlButtons = new JButton[]{resetButton,clearButton,acceptButton,cancelButton};
        
        bottomPanel.add(controlPanel, BorderLayout.LINE_END);
        add(bottomPanel, BorderLayout.PAGE_END);
    }
    /**
     * This constructs a JColorSelector with the given initial color and title 
     * for the dialog.
     * @param initialColor The initial color for the color chooser.
     * @param title The title for the dialog.
     */
    public JColorSelector(Color initialColor, String title){
        super(new BorderLayout(10, 11), title);
        initialize(initialColor);
    }
    /**
     * This constructs a JColorSelector with the given initial color.
     * @param initialColor The initial color for the color chooser.
     */
    public JColorSelector(Color initialColor){
        this(initialColor, null);
    }
    /**
     * This constructs a JColorSelector with the given red, green, blue, and 
     * alpha values for the initial color in the range (0 - 255), and the given 
     * title for the dialog. This is equivalent to calling {@code new }{@link 
     * JColorSelector#JColorSelector(Color, String) JColorSelector}{@code (new 
     * }{@link Color#Color(int, int, int, int) Color}{@code (r, g, b, a), 
     * title)}.
     * @param r The red component for the initial color (must be between 0 to 
     * 255, inclusive).
     * @param g The green component for the initial color (must be between 0 to 
     * 255, inclusive).
     * @param b The blue component for the initial color (must be between 0 to 
     * 255, inclusive).
     * @param a The alpha component for the initial color (must be between 0 to 
     * 255, inclusive).
     * @param title The title for the dialog.
     * @throws IllegalArgumentException If any of the red, green, blue, or alpha 
     * values are outside the range 0 to 255, inclusive.
     * @see Color#Color(int, int, int, int)
     */
    public JColorSelector(int r, int g, int b, int a, String title){
        this(new Color(r,g,b,a),title);
    }
    /**
     * This constructs a JColorSelector with the given red, green, blue, and 
     * alpha values for the initial color in the range (0 - 255). This is 
     * equivalent to calling {@code new }{@link 
     * JColorSelector#JColorSelector(Color) JColorSelector}{@code (new }{@link 
     * Color#Color(int, int, int, int) Color}{@code (r, g, b, a))}.
     * @param r The red component for the initial color (must be between 0 to 
     * 255, inclusive).
     * @param g The green component for the initial color (must be between 0 to 
     * 255, inclusive).
     * @param b The blue component for the initial color (must be between 0 to 
     * 255, inclusive).
     * @param a The alpha component for the initial color (must be between 0 to 
     * 255, inclusive).
     * @throws IllegalArgumentException If any of the red, green, blue, or alpha 
     * values are outside the range 0 to 255, inclusive.
     * @see Color#Color(int, int, int, int)
     */
    public JColorSelector(int r, int g, int b, int a){
        this(r,g,b,a,null);
    }
    /**
     * This constructs a JColorSelector with the given red, green, and blue 
     * values for the opaque initial color in the range (0 - 255), and the given 
     * title for the dialog. This is equivalent to calling {@code new }{@link 
     * JColorSelector#JColorSelector(Color, String) JColorSelector}{@code (new 
     * }{@link Color#Color(int, int, int) Color}{@code (r, g, b), title)}.
     * @param r The red component for the initial color (must be between 0 to 
     * 255, inclusive).
     * @param g The green component for the initial color (must be between 0 to 
     * 255, inclusive).
     * @param b The blue component for the initial color (must be between 0 to 
     * 255, inclusive).
     * @param title The title for the dialog.
     * @throws IllegalArgumentException If any of the red, green, or blue values 
     * are outside the range 0 to 255, inclusive.
     * @see Color#Color(int, int, int)
     */
    public JColorSelector(int r, int g, int b, String title){
        this(new Color(r,g,b),title);
    }
    /**
     * This constructs a JColorSelector with the given red, green, and blue 
     * values for the opaque initial color in the range (0 - 255). This is 
     * equivalent to calling {@code new }{@link 
     * JColorSelector#JColorSelector(Color) JColorSelector}{@code (new }{@link 
     * Color#Color(int, int, int) Color}{@code (r, g, b))}.
     * @param r The red component for the initial color (must be between 0 to 
     * 255, inclusive).
     * @param g The green component for the initial color (must be between 0 to 
     * 255, inclusive).
     * @param b The blue component for the initial color (must be between 0 to 
     * 255, inclusive).
     * @throws IllegalArgumentException If any of the red, green, or blue values 
     * are outside the range 0 to 255, inclusive.
     * @see Color#Color(int, int, int)
     */
    public JColorSelector(int r, int g, int b){
        this(r,g,b,null);
    }
    /**
     * This constructs a JColorSelector with the given RGBA value for the 
     * initial color and the given title for the dialog.  This is equivalent to 
     * calling {@code new }{@link JColorSelector#JColorSelector(Color, String) 
     * JColorSelector}{@code (new }{@link Color#Color(int, boolean) 
     * Color}{@code (rgba, hasAlpha), title)}.
     * @param rgba The combined RGBA components for the color.
     * @param hasAlpha Whether the alpha bits are valid and should be used.
     * @param title The title for the dialog.
     * @see Color#Color(int, boolean) 
     */
    public JColorSelector(int rgba, boolean hasAlpha, String title){
        this(new Color(rgba, hasAlpha),title);
    }
    /**
     * This constructs a JColorSelector with the given RGBA value for the 
     * initial color.  This is equivalent to calling {@code new }{@link 
     * JColorSelector#JColorSelector(Color) JColorSelector}{@code (new }{@link 
     * Color#Color(int, boolean) Color}{@code (rgba, hasAlpha))}.
     * @param rgba The combined RGBA components for the color.
     * @param hasAlpha Whether the alpha bits are valid and should be used.
     * @see Color#Color(int, boolean) 
     */
    public JColorSelector(int rgba, boolean hasAlpha){
        this(rgba,hasAlpha,null);
    }
    /**
     * This constructs a JColorSelector with the given RGB value for the opaque 
     * initial color and the given title for the dialog. This is equivalent to 
     * calling {@code new }{@link JColorSelector#JColorSelector(Color, String) 
     * JColorSelector}{@code (new }{@link Color#Color(int) Color}{@code (rgb), 
     * title)}.
     * @param rgb The combined RGB components for the color.
     * @param title The title for the dialog.
     * @see Color#Color(int) 
     */
    public JColorSelector(int rgb, String title){
        this(new Color(rgb),title);
    }
    /**
     * This constructs a JColorSelector with the given RGB value for the opaque 
     * initial color. This is equivalent to calling {@code new }{@link 
     * JColorSelector#JColorSelector(Color) JColorSelector}{@code (new }{@link 
     * Color#Color(int) Color}{@code (rgb))}.
     * @param rgb The combined RGB components for the color.
     * @see Color#Color(int) 
     */
    public JColorSelector(int rgb){
        this(rgb, false);
    }
    /**
     * This constructs a JColorSelector with the given title for the dialog and 
     * an initial color of white.
     * @param title The title for the dialog.
     */
    public JColorSelector(String title){
        this(Color.WHITE, title);
    }
    /**
     * This constructs a JColorSelector with an initial color of white.
     */
    public JColorSelector(){
        this((String)null);
    }
    /**
     * This returns the current initial color for the color chooser. This is the 
     * color that is set when the reset button is pressed or when the {@link 
     * #reset() reset} method is called.
     * @return The initial color for the color chooser.
     * @see #reset() 
     * @see #setColor(Color) 
     * @see #getColorChooser() 
     * @see #setInitialColor(Color) 
     */
    public Color getInitialColor(){
        return initial;
    }
    /**
     * This sets the current initial color to the given color. This is the color 
     * that is set when the reset button is pressed or when the {@link #reset() 
     * reset} method is called. Setting this value to null may result in 
     * undefined and unpredictable behavior.
     * @param color The color to use as the initial color.
     * @see #getInitialColor() 
     * @see #reset() 
     * @see #setColor(Color) 
     * @see #getColorChooser() 
     */
    public void setInitialColor(Color color){
        if (Objects.equals(initial, color)) // If the initial color would not change
            return;
        Color old = initial;                // Get the old initial color
        initial = color;
        firePropertyChange(INITIAL_COLOR_PROPERTY_CHANGED,old,color);
    }
    /**
     * This returns the currently selected color. The difference between this 
     * method and the {@link #getColor() getColor} method is that the {@code 
     * getColor} method will return null if the color has been set to a null 
     * value or has been {@link #clear() cleared}, whereas this will return the 
     * color currently selected by the color chooser.
     * @return The currently selected color from the color chooser.
     * @see #getColor() 
     * @see #setColor(Color) 
     * @see #getColorChooser() 
     * @see JColorChooser#getColor() 
     */
    public Color getSelectedColor(){
        return colorChooser.getColor();
    }
    /**
     * This sets the currently selected color to one with the given red, green, 
     * blue, and alpha values in the range (0 - 255). This will also set the 
     * initial color and fire a {@code ChangeEvent} if the new selected color is 
     * not the same as the previously selected color. This is equivalent to 
     * calling {@link #setColor(java.awt.Color) setColor}{@code (new }{@link 
     * Color#Color(int, int, int, int) Color}{@code (r, g, b, a))}.
     * @param r The red component for the color (must be between 0 to 255, 
     * inclusive).
     * @param g The green component for the color (must be between 0 to 255, 
     * inclusive).
     * @param b The blue component for the color (must be between 0 to 255, 
     * inclusive).
     * @param a The alpha component for the color (must be between 0 to 255, 
     * inclusive).
     * @throws IllegalArgumentException If any of the red, green, blue, or alpha 
     * values are outside the range 0 to 255, inclusive.
     * @see #getSelectedColor() 
     * @see #getColor() 
     * @see #setColor(java.awt.Color) 
     * @see #setColor(int, int, int) 
     * @see #setColor(int, boolean) 
     * @see #setColor(int) 
     * @see Color#Color(int, int, int, int)
     * @see JColorChooser#setColor(java.awt.Color) 
     */
    public void setColor(int r, int g, int b, int a){
        setColor(new Color(r,g,b,a));
    }
    /**
     * This sets the currently selected color to one with the given red, green, 
     * and blue values in the range (0 - 255). The alpha value will be 255. This 
     * will also set the initial color and fire a {@code ChangeEvent} if the new 
     * selected color is not the same as the previously selected color. This is 
     * equivalent to calling {@link #setColor(java.awt.Color) 
     * setColor}{@code (new }{@link Color#Color(int, int, int) Color}{@code (r, 
     * g, b))}.
     * @param r The red component for the color (must be between 0 to 255, 
     * inclusive).
     * @param g The green component for the color (must be between 0 to 255, 
     * inclusive).
     * @param b The blue component for the color (must be between 0 to 255, 
     * inclusive).
     * @throws IllegalArgumentException If any of the red, green, or blue values 
     * are outside the range 0 to 255, inclusive.
     * @see #getSelectedColor() 
     * @see #getColor() 
     * @see #setColor(java.awt.Color) 
     * @see #setColor(int, int, int, int) 
     * @see #setColor(int, boolean) 
     * @see #setColor(int) 
     * @see Color#Color(int, int, int)
     * @see JColorChooser#setColor(java.awt.Color) 
     */
    public void setColor(int r, int g, int b){
        setColor(new Color(r,g,b));
    }
    /**
     * This sets the currently selected color to one derived from the given 
     * RGBA value. The RGBA value consists of the alpha component in bits 24-31, 
     * the red component in bits 16-23, the green component in bits 8-15, and 
     * the blue component in bits 0-7. If {@code hasAlpha} is false, then the 
     * alpha component is set to 255. This will also set the initial color and 
     * fire a {@code ChangeEvent} if the new selected color is not the same as 
     * the previously selected color. This is equivalent to calling {@link 
     * #setColor(java.awt.Color) setColor}{@code (new }{@link 
     * Color#Color(int, boolean) Color}{@code (rgba, hasAlpha))}.
     * @param rgba The combined RGBA components for the color.
     * @param hasAlpha Whether the alpha bits are valid and should be used.
     * @see #getSelectedColor() 
     * @see #getColor() 
     * @see #setColor(java.awt.Color) 
     * @see #setColor(int, int, int, int) 
     * @see #setColor(int, int, int) 
     * @see #setColor(int) 
     * @see Color#Color(int, boolean)
     * @see JColorChooser#setColor(java.awt.Color) 
     */
    public void setColor(int rgba, boolean hasAlpha){
        setColor(new Color(rgba, hasAlpha));
    }
    /**
     * This sets the currently selected color to an opaque color derived from 
     * the given RGB value. The RGB value consists of the red component in bits 
     * 16-23, the green component in bits 8-15, and the blue component in bits 
     * 0-7. The alpha component will be 255. This will also set the initial 
     * color and fire a {@code ChangeEvent} if the new selected color is not the 
     * same as the previously selected color. This is equivalent to calling 
     * {@link #setColor(java.awt.Color) setColor}{@code (new }{@link 
     * Color#Color(int) Color}{@code (rgb))}.
     * @param rgb The combined RGB components for the color.
     * @see #getSelectedColor() 
     * @see #getColor() 
     * @see #setColor(java.awt.Color) 
     * @see #setColor(int, int, int, int) 
     * @see #setColor(int, int, int) 
     * @see #setColor(int, boolean) 
     * @see Color#Color(int)
     * @see JColorChooser#setColor(java.awt.Color) 
     */
    public void setColor(int rgb){
        setColor(rgb,false);
    }
    /**
     * This returns the currently set color, or null if no color is set. The 
     * difference between this and the {@link #getSelectedColor() 
     * getSelectedColor} method is that this method may return null if the color 
     * is set to null or has been {@link #clear() cleared}, whereas the {@code 
     * getSelectedColor} method will return the color selected by the color 
     * chooser. If the color has not been set to null and has not been cleared, 
     * then this will return the same color as {@code getSelectedColor}.
     * @return The currently set color, or null if no color is set.
     * @see #getSelectedColor() 
     * @see #setColor(java.awt.Color) 
     * @see #clear() 
     */
    public Color getColor(){
            // If the color should be null, return null. Otherwise, return the 
        return (isColorNull) ? null : getSelectedColor();   // selected color
    }
    /**
     * This sets the currently selected color. After this is called, {@link 
     * #getColor()} will return the given color. When given a non-null color, 
     * the initial and {@link #getSelectedColor() selected} colors will be set 
     * to the given color. If the given color is a different color to the 
     * previously set color, then this will fire a {@code ChangeEvent}. 
     * @param color The color to be selected in the color chooser, or null.
     * @see #getSelectedColor() 
     * @see #getColor() 
     * @see #setColor(int, int, int, int) 
     * @see #setColor(int, int, int) 
     * @see #setColor(int, boolean) 
     * @see #setColor(int) 
     * @see JColorChooser#setColor(java.awt.Color) 
     */
    public void setColor(Color color){
        if (Objects.equals(getColor(), color))  // If the colors are the same
            return;
        isColorNull = color == null;
        if (!isColorNull)                       // If the color is not null
            colorChooser.setColor(color);
        else
            fireStateChange();
    }
    /**
     * This sets the current preview panel. This delegates to the {@link 
     * JColorChooser#setPreviewPanel(javax.swing.JComponent) setPreviewPanel} 
     * method of the internal color chooser. Setting this to null will reset the 
     * preview panel back to the default preview panel.
     * @param preview The JComponent that displays the current color, or null.
     * @see #getPreviewPanel() 
     * @see JColorChooser#setPreviewPanel(javax.swing.JComponent)
     * @see #getColorChooser() 
     */
    public void setPreviewPanel(JComponent preview){
        colorChooser.setPreviewPanel(preview);
    }
    /**
     * This returns the preview panel that shows the selected color. This 
     * delegates to the {@link JColorChooser#getPreviewPanel() getPreviewPanel} 
     * method of the internal color chooser.
     * @return The preview panel used to show the selected color.
     * @see #setPreviewPanel(javax.swing.JComponent) 
     * @see JColorChooser#getPreviewPanel()
     * @see #getColorChooser() 
     */
    public JComponent getPreviewPanel(){
        return colorChooser.getPreviewPanel();
    }
    /**
     * This adds a color chooser panel to the color chooser. This delegates to 
     * the {@link JColorChooser#addChooserPanel(AbstractColorChooserPanel) 
     * addChooserPanel} method of the internal color chooser.
     * @param panel The AbstractColorChooserPanel to be added.
     * @see #removeChooserPanelAbstractColorChooserPanel) 
     * @see #getChooserPanels() 
     * @see #setChooserPanels(AbstractColorChooserPanel[]) 
     * @see JColorChooser#addChooserPanel(AbstractColorChooserPanel) 
     * @see #getColorChooser() 
     */
    public void addChooserPanel(AbstractColorChooserPanel panel) {
        colorChooser.addChooserPanel(panel);
    }
    /**
     * This removes the given color chooser panel from the color chooser. This 
     * delegates to the {@link JColorChooser#removeChooserPanel 
     * removeChooserPanel} method of the internal color chooser.
     * @param panel The AbstractColorChooserPanel to be removed.
     * @return The AbstractColorChooserPanel that was removed.
     * @throws IllegalArgumentException If the given panel is not in the list of 
     * known color chooser panels.
     * @see #addChooserPanel(AbstractColorChooserPanel) 
     * @see #getChooserPanels() 
     * @see #setChooserPanels(AbstractColorChooserPanel[]) 
     * @see JColorChooser#removeChooserPanel(AbstractColorChooserPanel) 
     * @see #getColorChooser() 
     */
    public AbstractColorChooserPanel removeChooserPanel(AbstractColorChooserPanel panel) {
        return colorChooser.removeChooserPanel(panel);
    }
    /**
     * This sets the color chooser panels used to choose color values to the 
     * color chooser panels in the given array. This delegates to the {@link 
     * JColorChooser#setChooserPanels(AbstractColorChooserPanel[]) 
     * setChooserPanels} method of the internal color chooser.
     * @param panels An array of AbstractColorChooserPanels.
     * @see #addChooserPanel(AbstractColorChooserPanel) 
     * @see #removeChooserPanel(AbstractColorChooserPanel) 
     * @see #getChooserPanels() 
     * @see JColorChooser#setChooserPanels(AbstractColorChooserPanel[]) 
     * @see #getColorChooser() 
     */
    public void setChooserPanels(AbstractColorChooserPanel[] panels) {
        colorChooser.setChooserPanels(panels);
    }
    /**
     * This returns an array containing the color chooser panels used to choose 
     * color values. This delegates to the {@link 
     * JColorChooser#getChooserPanels() getChooserPanels} method of the internal 
     * color chooser.
     * @return An array of AbstractColorChooserPanels.
     * @see #addChooserPanel(AbstractColorChooserPanel) 
     * @see #removeChooserPanel(AbstractColorChooserPanel) 
     * @see JColorChooser#getChooserPanels() 
     * @see #setChooserPanels(.AbstractColorChooserPanel[]) 
     * @see #getColorChooser() 
     */
    public AbstractColorChooserPanel[] getChooserPanels() {
        return colorChooser.getChooserPanels();
    }
    /**
     * This sets the model used to contain the selected color. This delegates to 
     * the {@link JColorChooser#setSelectionModel(ColorSelectionModel) 
     * setSelectionModel} method of the internal color chooser.
     * @param model The ColorSelectionModel to use (cannot be null).
     * @throws NullPointerException If the given selection model is null.
     * @see #getSelectionModel() 
     * @see JColorChooser#setSelectionModel(ColorSelectionModel) 
     * @see #getColorChooser() 
     */
    public void setSelectionModel(ColorSelectionModel model){
        colorChooser.setSelectionModel(Objects.requireNonNull(model,
                "Model cannot be null"));
    }
    /**
     * This returns the model used to handle color selections. This delegates to 
     * the {@link JColorChooser#getSelectionModel() getSelectionModel} method of 
     * the internal color chooser.
     * @return The ColorSelectionModel.
     * @see #setSelectionModel(ColorSelectionModel) 
     * @see JColorChooser#getSelectionModel()
     * @see #getColorChooser() 
     */
    public ColorSelectionModel getSelectionModel() {
        return colorChooser.getSelectionModel();
    }
    /**
     * This sets the border around the color chooser. The border is actually set 
     * on a panel that contains the color chooser.
     * @param border The border for the color chooser.
     * @see #setColorChooserBorder(java.lang.String) 
     * @see #setColorChooserTitle(java.lang.String) 
     * @see #getColorChooserBorder() 
     * @see #getColorChooserTitle() 
     * @see #getColorChooser() 
     */
    protected void setColorChooserBorder(Border border){
            // This returns the old border around the color chooser
        Border old = getColorChooserBorder();
            // If the new border is the same as the old one
        if (Objects.equals(old, border))    
            return;
        colorPanel.setBorder(border);
        firePropertyChange("colorChooserBorder",old,border);
    }
    /**
     * This sets the border around the color chooser to a titled border with the 
     * given title. This is called by {@link 
     * #setColorChooserTitle(java.lang.String) setColorChooserTitle} to set the 
     * border.
     * @param title The title for the border around the color chooser.
     * @see #setColorChooserBorder(javax.swing.border.Border) 
     * @see #getColorChooserBorder() 
     * @see #setColorChooserTitle(java.lang.String) 
     * @see #getColorChooserTitle() 
     * @see #getColorChooser() 
     */
    protected void setColorChooserBorder(String title){
        setColorChooserBorder(BorderFactory.createTitledBorder(title));
    }
    /**
     * This returns the border around the color chooser. That is to say, this 
     * returns the border set for the panel containing the color chooser.
     * @return The border around the color chooser.
     * @see #setColorChooserBorder(javax.swing.border.Border) 
     * @see #setColorChooserBorder(java.lang.String) 
     * @see #setColorChooserTitle(java.lang.String) 
     * @see #getColorChooserTitle() 
     * @see #getColorChooser() 
     */
    protected Border getColorChooserBorder(){
        return colorPanel.getBorder();
    }
    /**
     * This sets the title to be displayed on the border around the color 
     * chooser.
     * @param title The title for the color chooser.
     * @see #getColorChooserTitle() 
     * @see #getColorChooser() 
     */
    public void setColorChooserTitle(String title){
            // If the new title is the same as the old one
        if (Objects.equals(title, chooserTitle))    
            return;
        String old = chooserTitle;  // Get the old title
        chooserTitle = title;
        firePropertyChange(COLOR_CHOOSER_TITLE_PROPERTY_CHANGED,old,title);
        if (title == null)          // If the new title is null
            title = "";
            // If the new title is not empty (and not null) or the old title is 
            // not null and not empty
        if (!title.isEmpty() || (old != null && !old.isEmpty()))
            setColorChooserBorder(title);
    }
    /**
     * This returns the title displayed on the border around the color chooser.
     * @return The title for the color chooser.
     * @see #setColorChooserTitle(java.lang.String) 
     * @see #getColorChooser() 
     */
    public String getColorChooserTitle(){
        return chooserTitle;
    }
    /**
     * This sets the accessory component to display at the bottom next to the 
     * control buttons. The accessory component can be used to add additional 
     * controls such as a combo box to control which color is being set. <p>
     * 
     * Note: If there was a previous accessory, you should remove any listeners 
     * that the accessory may have added to this JColorSelector.
     * @param accessory The accessory component.
     * @see #getBottomAccessory() 
     */
    public void setBottomAccessory(JComponent accessory){
            // If the new accessory is the same as the old one
        if (accessory == this.accessory)    
            return;
        JComponent old = this.accessory;    // Get the old accessory
        this.accessory = accessory;
        firePropertyChange(BOTTOM_ACCESSORY_PROPERTY_CHANGED,old,accessory);
        if (old != null)        // If the old accessory was not null
            bottomPanel.remove(old);
        if (accessory != null)  // If the new accessory is not null
            bottomPanel.add(accessory,java.awt.BorderLayout.CENTER);
    }
    /**
     * This returns the accessory component displayed at the bottom of this 
     * panel next to the control buttons.
     * @return The accessory component, or null.
     * @see #setBottomAccessory(javax.swing.JComponent) 
     */
    public JComponent getBottomAccessory(){
        return accessory;
    }
    /**
     * This is used to set whether the given control button is shown. This is 
     * used to add or remove the button to or from the control panel, since the 
     * control panel uses a grid layout.
     * @param value Whether the given button should be visible.
     * @param button The button to show or hide.
     * @param index The position for the button, or -1 to append it to the end 
     * of the panel.
     */
    protected void setControlButtonIsShown(boolean value,JButton button,int index){
        button.setVisible(value);
        if (value)  // If the button should be shown
            controlPanel.add(button,index);
        else
            controlPanel.remove(button);
        controlPanel.revalidate();
    }
    /**
     * This sets whether the clear button will be shown by this panel. This 
     * property is false by default.
     * @param value Whether the clear button should be shown or not.
     * @see #isClearButtonShown() 
     * @see #setResetButtonShown(boolean) 
     * @see #isResetButtonShown() 
     * @see #getClearButton() 
     */
    public void setClearButtonShown(boolean value){
            // If the clear button will not have its visibility changed
        if (value == showClear) 
            return;
        showClear = value;
        firePropertyChange(CLEAR_BUTTON_IS_SHOWN_PROPERTY_CHANGED,!value,value);
            // The clear button should be to the left of the accept button. As 
            // such, if the reset button is showing, put the clear button in 
            // between the reset and accept button. Otherwise, put it at the start
        setControlButtonIsShown(value,clearButton,(isResetButtonShown())?1:0);
    }
    /**
     * This returns whether the clear button is shown by this panel.
     * @return Whether the clear button is shown.
     * @see #setClearButtonShown(boolean) 
     * @see #isResetButtonShown() 
     * @see #setResetButtonShown(boolean) 
     * @see #getClearButton() 
     */
    public boolean isClearButtonShown(){
        return showClear;
    }
    /**
     * This sets whether the reset button will be shown by this panel. This 
     * property is true by default.
     * @param value Whether the reset button should be shown or not.
     * @see #isResetButtonShown() 
     * @see #setClearButtonShown(boolean) 
     * @see #isClearButtonShown() 
     * @see #getResetButton() 
     */
    public void setResetButtonShown(boolean value){
            // If the reset button will not have its visibility changed
        if (value == showReset)
            return;
        showReset = value;
        firePropertyChange(RESET_BUTTON_IS_SHOWN_PROPERTY_CHANGED,!value,value);
        setControlButtonIsShown(value,resetButton,0);
    }
    /**
     * This returns whether the reset button is shown by this panel.
     * @return Whether the reset button is shown.
     * @see #setResetButtonShown(boolean) 
     * @see #isClearButtonShown() 
     * @see #setClearButtonShown(boolean) 
     * @see #getResetButton() 
     */
    public boolean isResetButtonShown(){
        return showReset;
    }
    /**
     * This returns the button used to reset the currently selected color back 
     * to the {@link #getInitialColor() initial color}.
     * @return The reset button.
     * @see #RESET_COLOR_SELECTED
     * @see #reset() 
     * @see #getInitialColor() 
     */
    public JButton getResetButton(){
        return resetButton;
    }
    /**
     * This returns the button used to specify that the color should be set to 
     * its default value.
     * @return The clear button.
     * @see #CLEAR_COLOR_SELECTED
     * @see #clear() 
     */
    public JButton getClearButton(){
        return clearButton;
    }
    /**
     * This returns the underlying color chooser used to select the colors.
     * @return The color chooser.
     */
    public JColorChooser getColorChooser(){
        return colorChooser;
    }
    /**
     * This resets the {@link #getSelectedColor() selected color} to the 
     * {@link #getInitialColor() initial color}. This method is called when the 
     * reset button is pressed, and will cause a {@code ChangeEvent} to be 
     * fired.
     * @see #accept() 
     * @see #getSelectedColor() 
     * @see #getInitialColor() 
     * @see #setInitialColor(java.awt.Color) 
     * @see #getColor() 
     * @see #setColor(java.awt.Color) 
     */
    public void reset(){
        setColor(getInitialColor());
    }
    /**
     * This clears the currently {@link #getColor() set color}, setting it to 
     * null to indicate that the color being set should be set to its default 
     * value. This method is called when the clear button is pressed, and will 
     * cause both a {@code ChangeEvent} and an action event with the {@link 
     * #CLEAR_COLOR_SELECTED} action command to be fired.
     * @see #CLEAR_COLOR_SELECTED
     * @see #getColor() 
     * @see #setColor(java.awt.Color) 
     */
    public void clear(){
        if (!isColorNull){      // If the color is not already null
            isColorNull = true;
            fireStateChange();
        }
        closeDialog(CLEAR_COLOR_SELECTED);
    }
    /**
     * {@inheritDoc } This has been overridden to also set the initial color to 
     * the currently {@link #getSelectedColor() selected color}.
     * @see #ACCEPT_SELECTED
     * @see #getSelectedColor() 
     */
    @Override
    public void accept(){
        setInitialColor(getSelectedColor());
        super.accept();
    }
    /**
     * {@inheritDoc } 
     * @param parent {@inheritDoc }
     * @return The return state of the panel. This will be either {@link 
     * #ACCEPT_OPTION}, {@link #CANCEL_OPTION}, {@link #CLEAR_COLOR_OPTION}, or 
     * {@link #ERROR_OPTION}, with the last being returned if an error occurred 
     * or if the dialog is dismissed.
     * @see #ACCEPT_OPTION
     * @see #CANCEL_OPTION
     * @see #CLEAR_COLOR_OPTION
     * @see #ERROR_OPTION
     * @see #showDialog(java.awt.Component, java.awt.Color) 
     * @see #getColor() 
     * @see #getSelectedColor() 
     */
    @Override
    public int showDialog(Component parent){
        return super.showDialog(parent);
    }
    /**
     * This pops up a dialog showing this panel. If the given initial color is 
     * not null, then the currently set initial color and the currently selected 
     * color will be set to the given color.
     * @param parent The parent component for the dialog (can be null).
     * @param initialColor The initial color set for the color chooser, or null.
     * @return The return state of the panel. This will be either {@link 
     * #ACCEPT_OPTION}, {@link #CANCEL_OPTION}, {@link #CLEAR_COLOR_OPTION}, or 
     * {@link #ERROR_OPTION}, with the last being returned if an error occurred 
     * or if the dialog is dismissed.
     * @see #ACCEPT_OPTION
     * @see #CANCEL_OPTION
     * @see #CLEAR_COLOR_OPTION
     * @see #ERROR_OPTION
     * @see #showDialog(java.awt.Component)
     * @see #setColor(java.awt.Color) 
     * @see #getColor() 
     * @see #getSelectedColor() 
     * @see #setInitialColor(java.awt.Color) 
     * @see #getInitialColor() 
     */
    public int showDialog(Component parent, Color initialColor){
            // If the dialog is not showing and the initial color is not null
        if (getDialog() == null && initialColor != null){
            setInitialColor(initialColor);
            setColor(initialColor);
        }
        return showDialog(parent);
    }
    @Override
    protected int getOptionForCommand(String command) {
            // If the clear color command was given
        if (CLEAR_COLOR_SELECTED.equals(command))
            return CLEAR_COLOR_OPTION;
        return super.getOptionForCommand(command);
    }
    @Override
    protected String getOptionString(int option) {
            // If the clear color option was selected
        if (option == CLEAR_COLOR_OPTION)
            return "CLEAR_COLOR_OPTION";
        return super.getOptionString(option);
    }
    @Override
    protected String getDefaultAcceptButtonToolTipText() {
        return "Use the selected color";
    }
    @Override
    protected String getDefaultCancelButtonToolTipText() {
        return "Abort the color selection dialog";
    }
    /**
     * This returns the default text to use for the clear button when no text 
     * has been set.
     * 
     * @implSpec This implementation returns the word "Clear".
     * 
     * @return The default text for the clear button.
     * @see #getClearButton() 
     * @see #isClearButtonTextSet() 
     * @see #getClearButtonText() 
     * @see #setClearButtonText(java.lang.String) 
     * @see #updateButtonText() 
     */
    protected String getDefaultClearButtonText(){
        return "Clear";
    }
    /**
     * This returns the default mnemonic keycode to use for the clear button 
     * when no mnemonic has been set. 
     * 
     * @implSpec This implementation returns the mnemonic keycode for the first 
     * character in the {@link #getClearButtonText() clear button's text} that 
     * does not result in a mnemonic that matches that for the accept or cancel 
     * buttons.
     * 
     * @return The default mnemonic keycode for the clear button.
     * @see #getClearButton() 
     * @see #isClearButtonMnemonicSet() 
     * @see #getClearButtonMnemonic() 
     * @see #setClearButtonMnemonic(int) 
     * @see #setClearButtonMnemonic(char) 
     * @see #getClearButtonText() 
     * @see #getCancelButtonMnemonic() 
     * @see #getAcceptButtonMnemonic() 
     * @see #updateButtonText() 
     */
    protected int getDefaultClearButtonMnemonic(){
            // Get the text for the clear button
        String text = getClearButtonText();
            // If the clear button text is null or empty
        if (text == null || text.isEmpty())
            return 0;
            // Get the mnemonic keycode for the accept button
        int acceptKey = getAcceptButtonMnemonic();
            // Get the mnemonic keycode for the cancel button
        int cancelKey = getCancelButtonMnemonic();
            // Go through the characters in the clear button's text
        for (char c : text.toCharArray()){
                // Get the mnemonic keycode for the current character
            int key = java.awt.event.KeyEvent.getExtendedKeyCodeForChar(c);
                // If the keycode does not match the accept or cancel mnemonics
            if (key != acceptKey && key != cancelKey)
                return key;
        }
        return 0;
    }
    /**
     * This returns the default tool tip text to use for the clear button when 
     * no tool tip text has been set.
     * @return The default tool tip text for the clear button.
     * @see #getClearButton() 
     * @see #isClearButtonToolTipTextSet() 
     * @see #getClearButtonToolTipText() 
     * @see #setClearButtonToolTipText(java.lang.String) 
     * @see #updateButtonText() 
     */
    protected String getDefaultClearButtonToolTipText(){
        return "Use the default color";
    }
    /**
     * {@inheritDoc } This has been overridden to include the {@link 
     * #getClearButton() clear} button.
     * @see #getAcceptButton()
     * @see #getCancelButton()
     * @see #getClearButton() 
     * @see javax.swing.JButton#setText(java.lang.String)
     * @see javax.swing.JButton#setMnemonic(int)
     * @see javax.swing.JButton#setToolTipText(java.lang.String)
     * @see #getAcceptButtonText() 
     * @see #getAcceptButtonMnemonic() 
     * @see #getAcceptButtonToolTipText() 
     * @see #getCancelButtonText() 
     * @see #getCancelButtonMnemonic() 
     * @see #getCancelButtonToolTipText() 
     * @see #getClearButtonText() 
     * @see #getClearButtonMnemonic() 
     * @see #getClearButtonToolTipText() 
     */
    @Override
    protected void updateButtonText(){
        super.updateButtonText();
        if (clearButton != null){  // If the clear button has been initialized
            clearButton.setText(getClearButtonText());
            clearButton.setMnemonic(getClearButtonMnemonic());
            clearButton.setToolTipText(getClearButtonToolTipText());
        }
    }
    /**
     * This returns whether the text for the clear button has been set to a 
     * non-null value.
     * @return Whether {@code setClearButtonText} has been invoked with a 
     * non-null value.
     * @see #setClearButtonText(java.lang.String) 
     * @see #getClearButtonText() 
     */
    public boolean isClearButtonTextSet(){
        return clearText != null;
    }
    /**
     * This returns the text for the clear button. If the text has been set to 
     * a null value, then this will return the default text for the clear 
     * button as determined by this panel.
     * @return The text for the clear button.
     * @see #isClearButtonTextSet() 
     * @see #setClearButtonText(java.lang.String) 
     */
    public String getClearButtonText(){
            // If the text is set, return it. Otherwise, return the default text.
        return (isClearButtonTextSet()) ? clearText:getDefaultClearButtonText();
    }
    /**
     * This sets the text for the clear button. If the text is null, then this 
     * panel will determine the text to use for the clear button. If a mnemonic 
     * has not been set for the clear button, then this panel will also 
     * determine the mnemonic to use for the clear button, which is typically 
     * the first character of the text for the clear button that does not match 
     * the mnemonic for the accept or cancel buttons.
     * @param text The text for the clear button, or null.
     * @see #isClearButtonTextSet() 
     * @see #getClearButtonText() 
     * @see #isClearButtonMnemonicSet() 
     * @see #getClearButtonMnemonic() 
     * @see #setClearButtonMnemonic(int) 
     * @see #setClearButtonMnemonic(char) 
     * @see #getAcceptButtonMnemonic() 
     * @see #getCancelButtonMnemonic() 
     */
    public void setClearButtonText(String text){
            // If the clear text will not change
        if (Objects.equals(text, clearText))
            return;
        String old = clearText;     // Get the old text
        clearText = text;
        clearButton.setText(getClearButtonText());
        clearButton.setMnemonic(getClearButtonMnemonic());
        firePropertyChange(CLEAR_BUTTON_TEXT_PROPERTY_CHANGED,old,text);
    }
    /**
     * This returns whether the mnemonic for the clear button has been set.
     * @return Whether {@code setClearButtonMnemonic} has been invoked.
     * @see #setClearButtonMnemonic(int) 
     * @see #setClearButtonMnemonic(char) 
     * @see #getClearButtonMnemonic() 
     */
    public boolean isClearButtonMnemonicSet(){
        return clearMnemonic != null;
    }
    /**
     * This sets the mnemonic for the clear button using a character.
     * @param mnemonic The character value for the mnemonic key for the clear 
     * button.
     * @see #isClearButtonMnemonicSet() 
     * @see #getClearButtonMnemonic() 
     * @see #setClearButtonMnemonic(int) 
     */
    public void setClearButtonMnemonic(char mnemonic){
        setClearButtonMnemonic((int)Character.toUpperCase(mnemonic));
    }
    /**
     * This returns the mnemonic for the clear button. If the mnemonic has not 
     * been set, then this will return the default mnemonic for the clear button 
     * as determined by this panel. The default mnemonic is typically the first 
     * character of the text for the clear button which does not result in a 
     * mnemonic that matches the mnemonic for the accept or cancel buttons.
     * @return The mnemonic for the clear button.
     * @see #isClearButtonMnemonicSet() 
     * @see #setClearButtonMnemonic(int) 
     * @see #setClearButtonMnemonic(char) 
     * @see #getClearButtonText() 
     * @see #getAcceptButtonMnemonic() 
     * @see #getCancelButtonMnemonic() 
     */
    public int getClearButtonMnemonic(){
        if (isClearButtonMnemonicSet()){    // If the mnemonic is set
            if (clearMnemonic == null)      // If the mnemonic is somehow null
                return 0;
            return clearMnemonic;
        }
        return getDefaultClearButtonMnemonic();
    }
    /**
     * This sets the mnemonic for the clear button using a numeric keycode. If 
     * the mnemonic is not set, then this panel will determine the mnemonic to 
     * use for the clear button, which will typically be the first character of 
     * the text for the clear button which does not result in a mnemonic that 
     * matches the mnemonic for the accept or cancel buttons.
     * @param mnemonic The integer value for the mnemonic key for the clear  
     * button.
     * @see #isClearButtonMnemonicSet() 
     * @see #getClearButtonMnemonic() 
     * @see #setClearButtonMnemonic(char) 
     * @see #getClearButtonText() 
     * @see #getAcceptButtonMnemonic() 
     * @see #getCancelButtonMnemonic() 
     */
    public void setClearButtonMnemonic(int mnemonic){
            // If the clear mnemonic will not change
        if (Objects.equals(clearMnemonic, mnemonic))
            return;
        Integer old = clearMnemonic;    // Get the old clear mnemonic
        clearMnemonic = mnemonic;
        clearButton.setMnemonic(getClearButtonMnemonic());
        firePropertyChange(CLEAR_BUTTON_MNEMONIC_PROPERTY_CHANGED,old,clearMnemonic);
    }
    /**
     * This returns whether the tool tip text for the clear button has been set 
     * to a non-null value.
     * @return Whether {@code setClearButtonToolTipText} has been invoked with a 
     * non-null value.
     * @see #setClearButtonToolTipText(java.lang.String) 
     * @see #getClearButtonToolTipText() 
     * @see #getClearButtonText() 
     */
    public boolean isClearButtonToolTipTextSet(){
        return clearToolTip != null;
    }
    /**
     * This returns the tool tip text for the clear button. If the tool tip text 
     * has been set to a null value, then this will return the default tool tip 
     * text for the clear button as determined by this panel.
     * @return The tool tip text for the clear button.
     * @see #isClearButtonToolTipTextSet() 
     * @see #setClearButtonToolTipText(java.lang.String) 
     * @see #getClearButtonText() 
     */
    public String getClearButtonToolTipText(){
            // If the tool tip text is set, return it. Otherwise, return the 
            // default tool tip text.
        return isClearButtonToolTipTextSet() ? clearToolTip : 
                getDefaultClearButtonToolTipText();
    }
    /**
     * This sets the tool tip text for the clear button. If the tool tip text is 
     * null, then this panel will determine the tool tip text to use for the 
     * clear button.
     * @param toolTipText The tool tip text for the clear button, or null.
     * @see #isClearButtonToolTipTextSet() 
     * @see #getClearButtonToolTipText() 
     * @see #getClearButtonText() 
     */
    public void setClearButtonToolTipText(String toolTipText){
            // If the clear tool tip text will not change
        if (Objects.equals(toolTipText, clearToolTip))
            return;
        String old = clearToolTip;     // Get the old clear tool tip text
        clearToolTip = toolTipText;
        clearButton.setToolTipText(getClearButtonToolTipText());
        firePropertyChange(CLEAR_BUTTON_TOOL_TIP_TEXT_PROPERTY_CHANGED,old,toolTipText);
    }
    /**
     * This adds the given {@code ChangeListener} to this panel.
     * @param l The listener to add.
     * @see #removeChangeListener(javax.swing.event.ChangeListener) 
     * @see #getChangeListeners() 
     */
    public void addChangeListener(ChangeListener l){
        if (l != null)          // If the listener is not null
            listenerList.add(ChangeListener.class, l);
    }
    /**
     * This removes the given {@code ChangeListener} from this panel.
     * @param l The listener to remove.
     * @see #addChangeListener(javax.swing.event.ChangeListener) 
     * @see #getChangeListeners() 
     */
    public void removeChangeListener(ChangeListener l){
        listenerList.remove(ChangeListener.class, l);
    }
    /**
     * This returns an array containing all the {@code ChangeListener}s that 
     * have been added to this panel.
     * @return An array containing the {@code ChangeListener}s that have been 
     * added, or an empty array if none have been added.
     * @see #addChangeListener(javax.swing.event.ChangeListener) 
     * @see #removeChangeListener(javax.swing.event.ChangeListener) 
     */
    public ChangeListener[] getChangeListeners(){
        return listenerList.getListeners(ChangeListener.class);
    }
    /**
     * This is used to notify the {@code ChangeListener}s that the selected 
     * color has changed.
     */
    protected void fireStateChange(){
            // This constructs the evet to fire
        ChangeEvent evt = new ChangeEvent(this);
            // A for loop to go through the change listeners
        for (ChangeListener l : listenerList.getListeners(ChangeListener.class)){
            if (l != null)  // If the listener is not null
                l.stateChanged(evt);
        }
    }
    @Override
    public void setFont(Font font){
        super.setFont(font);
        try{
            clearButton.setFont(font);
            resetButton.setFont(font);
            colorChooser.setFont(font);
            colorPanel.setFont(font);
            bottomPanel.setFont(font);
            controlPanel.setFont(font);
        }catch(NullPointerException ex){}
    }
    @Override
    public void setEnabled(boolean enabled){
        super.setEnabled(enabled);
        try{
            clearButton.setEnabled(enabled);
            resetButton.setEnabled(enabled);
            colorChooser.setEnabled(enabled);
        }catch(NullPointerException ex){}
    }
    @Override
    public void setForeground(Color fg){
        super.setForeground(fg);
        try{
            clearButton.setForeground(fg);
            resetButton.setForeground(fg);
            colorChooser.setForeground(fg);
            controlPanel.setForeground(fg);
            bottomPanel.setForeground(fg);
            colorPanel.setForeground(fg);
        } catch (NullPointerException ex) {}
    }
    @Override
    public void setBackground(Color bg){
        super.setBackground(bg);
        try{
            clearButton.setBackground(bg);
            resetButton.setBackground(bg);
            colorChooser.setBackground(bg);
            controlPanel.setBackground(bg);
            bottomPanel.setBackground(bg);
            colorPanel.setBackground(bg);
        } catch (NullPointerException ex) {}
    }
    /**
     * This returns a String representation of this JColorSelector. This method 
     * is primarily intended to be used only for debugging purposes, and the 
     * content and format of the returned String may vary between 
     * implementations.
     * @return A String representation of this JColorSelector.
     */
    @Override
    protected String paramString(){
        return super.paramString()+
                ",color="+Objects.toString(getColor(),"")+
                ",selectedColor="+Objects.toString(getSelectedColor(),"")+
                ",initialColor="+Objects.toString(getInitialColor(),"")+
                ",colorChooserTitle="+Objects.toString(getColorChooserTitle(),"")+
                ",colorChooser="+colorChooser;
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
            clearButton,acceptButton,cancelButton,resetButton,controlPanel
        };
    }
    /**
     * This is the title to display on the border for the color chooser.
     */
    private String chooserTitle = null;
    /**
     * This is the text set for the clear button if one has been set for it. If 
     * this is null, then the clear button will use the default clear button 
     * text.
     */
    private String clearText = null;
    /**
     * This is the mnemonic set for the clear button if one has been set for it. 
     * If this is null, then the clear button will use the default clear button 
     * mnemonic.
     */
    private Integer clearMnemonic = null;
    /**
     * This is the tool tip text set for the clear button if one has been set 
     * for it. If this is null, then the clear button will use the default clear 
     * button tool tip text.
     */
    private String clearToolTip = null;
    // TODO: Look into converting these booleans into a flag-controlled integer
    /**
     * This controls whether the reset button is shown.
     */
    private boolean showReset = true;
    /**
     * This controls whether the clear button is shown.
     */
    private boolean showClear = false;
    /**
     * This stores whether the currently selected color is actually suppose to 
     * be null.
     */
    private boolean isColorNull;
    /**
     * This stores the initial color set for the color chooser that is restored 
     * when the reset button is pressed.
     */
    private Color initial;
    /**
     * This is the handler used to listen to the color chooser, its selection 
     * model, and the buttons.
     */
    private Handler handler;
    /**
     * This is the accessory that appears at the bottom next to the control 
     * buttons.
     */
    private JComponent accessory = null;
    /**
     * This is the reset button used to reset the selected color back to the 
     * initial color.
     */
    protected JButton resetButton = null;
    /**
     * This is the clear button used to set the color to its default.
     */
    protected JButton clearButton = null;
//    /**
//     * This is an array containing the control buttons. This is primarily used 
//     * to keep them in order relative to each other.
//     */
//    private JButton[] controlButtons;
    /**
     * This is the panel that contains the control buttons, including the reset 
     * and clear buttons.
     */
    protected JPanel controlPanel;
    /**
     * This is the panel at the bottom of this panel used to contain the control 
     * panel and the bottom accessory.
     */
    protected JPanel bottomPanel;
    /**
     * This is the panel used to contain the color chooser, so as to show a 
     * border around it.
     */
    protected JPanel colorPanel;
    /**
     * This is the color chooser used to select colors.
     */
    protected JColorChooser colorChooser;
    /**
     * This is used to handle listening to the reset and clear buttons and call 
     * their corresponding action methods, along with listening to changes to 
     * the selected color and changes to some of the color chooser's properties. 
     */
    private class Handler
            implements ActionListener, ChangeListener, PropertyChangeListener{
        @Override
        public void actionPerformed(ActionEvent evt) {
                // Get the action command for the action event
            String command = evt.getActionCommand();
            if (command == null)            // If no action command was given
                return;
            switch(command){
                case(CLEAR_COLOR_SELECTED): // If the clear action command was given
                    setCloseEvent(evt);
                    clear();
                    return;
                case(RESET_COLOR_SELECTED): // If the reset action command was given
                    reset();
            }
        }
        @Override
        public void stateChanged(ChangeEvent evt) {
            isColorNull = false;
            fireStateChange();
        }
        @Override
        public void propertyChange(PropertyChangeEvent evt) {
                // If the property name is null or the old value is the same as the new one
            if (evt.getPropertyName() == null || evt.getOldValue() == evt.getNewValue())
                return;
            if (evt.getSource() == colorChooser){   // If the source is the color chooser
                switch(evt.getPropertyName()){
                        // If either the selectiom model, preview panel, or 
                        // chooser panels have changed
                    case(JColorChooser.SELECTION_MODEL_PROPERTY):
                        if (evt.getOldValue() != null)  // If the old model is not null
                            ((ColorSelectionModel)evt.getOldValue()).removeChangeListener(this);
                        if (evt.getNewValue() != null)  // If the new model is not null
                            ((ColorSelectionModel)evt.getNewValue()).addChangeListener(this);
                    case(JColorChooser.PREVIEW_PANEL_PROPERTY):
                    case(JColorChooser.CHOOSER_PANELS_PROPERTY):
                        firePropertyChange(evt.getPropertyName(),evt.getOldValue(),evt.getNewValue());
                        return;
                    case("enabled"):    // If the color chooser has been enabled or disabled
                        colorPanel.setEnabled(colorChooser.isEnabled());
                        return;
                    case("font"):       // If the color chooser font has changed
                        colorPanel.setFont(colorChooser.getFont());
                }
            }
        }
    }
}
