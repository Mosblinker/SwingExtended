/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Beans/BeanInfo.java to edit this template
 */
package components;

import beans.BeanInfoIconFactory;
import beans.DialogBeanInfoIconFactory;
import java.beans.*;

/**
 * This is the beans info for JColorSelector.
 * @author Milo Steier
 * @see JColorSelector
 */
public class JColorSelectorBeanInfo extends SimpleBeanInfo {

    // Bean descriptor//GEN-FIRST:BeanDescriptor
    /*lazy BeanDescriptor*/
    private static BeanDescriptor getBdescriptor(){
        BeanDescriptor beanDescriptor = new BeanDescriptor  ( components.JColorSelector.class , null ); // NOI18N
        beanDescriptor.setShortDescription ( "This is a panel that allows the manipulation and selection of colors." );//GEN-HEADEREND:BeanDescriptor
        // Here you can add code for customizing the BeanDescriptor.

        return beanDescriptor;     }//GEN-LAST:BeanDescriptor


    // Property identifiers//GEN-FIRST:Properties
    private static final int PROPERTY_acceptButton = 0;
    private static final int PROPERTY_acceptButtonMnemonic = 1;
    private static final int PROPERTY_acceptButtonMnemonicSet = 2;
    private static final int PROPERTY_acceptButtonText = 3;
    private static final int PROPERTY_acceptButtonTextSet = 4;
    private static final int PROPERTY_acceptButtonToolTipText = 5;
    private static final int PROPERTY_acceptButtonToolTipTextSet = 6;
    private static final int PROPERTY_accessibleContext = 7;
    private static final int PROPERTY_actionListeners = 8;
    private static final int PROPERTY_actionMap = 9;
    private static final int PROPERTY_alignmentX = 10;
    private static final int PROPERTY_alignmentY = 11;
    private static final int PROPERTY_ancestorListeners = 12;
    private static final int PROPERTY_autoscrolls = 13;
    private static final int PROPERTY_background = 14;
    private static final int PROPERTY_backgroundSet = 15;
    private static final int PROPERTY_baselineResizeBehavior = 16;
    private static final int PROPERTY_border = 17;
    private static final int PROPERTY_bottomAccessory = 18;
    private static final int PROPERTY_bounds = 19;
    private static final int PROPERTY_cancelButton = 20;
    private static final int PROPERTY_cancelButtonMnemonic = 21;
    private static final int PROPERTY_cancelButtonMnemonicSet = 22;
    private static final int PROPERTY_cancelButtonText = 23;
    private static final int PROPERTY_cancelButtonTextSet = 24;
    private static final int PROPERTY_cancelButtonToolTipText = 25;
    private static final int PROPERTY_cancelButtonToolTipTextSet = 26;
    private static final int PROPERTY_changeListeners = 27;
    private static final int PROPERTY_chooserPanels = 28;
    private static final int PROPERTY_clearButton = 29;
    private static final int PROPERTY_clearButtonMnemonic = 30;
    private static final int PROPERTY_clearButtonMnemonicSet = 31;
    private static final int PROPERTY_clearButtonShown = 32;
    private static final int PROPERTY_clearButtonText = 33;
    private static final int PROPERTY_clearButtonTextSet = 34;
    private static final int PROPERTY_clearButtonToolTipText = 35;
    private static final int PROPERTY_clearButtonToolTipTextSet = 36;
    private static final int PROPERTY_color = 37;
    private static final int PROPERTY_colorChooser = 38;
    private static final int PROPERTY_colorChooserTitle = 39;
    private static final int PROPERTY_colorModel = 40;
    private static final int PROPERTY_component = 41;
    private static final int PROPERTY_componentCount = 42;
    private static final int PROPERTY_componentListeners = 43;
    private static final int PROPERTY_componentOrientation = 44;
    private static final int PROPERTY_componentPopupMenu = 45;
    private static final int PROPERTY_components = 46;
    private static final int PROPERTY_containerListeners = 47;
    private static final int PROPERTY_controlButtonsAreShown = 48;
    private static final int PROPERTY_cursor = 49;
    private static final int PROPERTY_cursorSet = 50;
    private static final int PROPERTY_debugGraphicsOptions = 51;
    private static final int PROPERTY_dialogTitle = 52;
    private static final int PROPERTY_displayable = 53;
    private static final int PROPERTY_doubleBuffered = 54;
    private static final int PROPERTY_dropTarget = 55;
    private static final int PROPERTY_enabled = 56;
    private static final int PROPERTY_focusable = 57;
    private static final int PROPERTY_focusCycleRoot = 58;
    private static final int PROPERTY_focusCycleRootAncestor = 59;
    private static final int PROPERTY_focusListeners = 60;
    private static final int PROPERTY_focusOwner = 61;
    private static final int PROPERTY_focusTraversable = 62;
    private static final int PROPERTY_focusTraversalKeys = 63;
    private static final int PROPERTY_focusTraversalKeysEnabled = 64;
    private static final int PROPERTY_focusTraversalPolicy = 65;
    private static final int PROPERTY_focusTraversalPolicyProvider = 66;
    private static final int PROPERTY_focusTraversalPolicySet = 67;
    private static final int PROPERTY_font = 68;
    private static final int PROPERTY_fontSet = 69;
    private static final int PROPERTY_foreground = 70;
    private static final int PROPERTY_foregroundSet = 71;
    private static final int PROPERTY_graphics = 72;
    private static final int PROPERTY_graphicsConfiguration = 73;
    private static final int PROPERTY_height = 74;
    private static final int PROPERTY_hierarchyBoundsListeners = 75;
    private static final int PROPERTY_hierarchyListeners = 76;
    private static final int PROPERTY_ignoreRepaint = 77;
    private static final int PROPERTY_inheritsPopupMenu = 78;
    private static final int PROPERTY_initialColor = 79;
    private static final int PROPERTY_inputContext = 80;
    private static final int PROPERTY_inputMap = 81;
    private static final int PROPERTY_inputMethodListeners = 82;
    private static final int PROPERTY_inputMethodRequests = 83;
    private static final int PROPERTY_inputVerifier = 84;
    private static final int PROPERTY_insets = 85;
    private static final int PROPERTY_keyListeners = 86;
    private static final int PROPERTY_layout = 87;
    private static final int PROPERTY_lightweight = 88;
    private static final int PROPERTY_locale = 89;
    private static final int PROPERTY_location = 90;
    private static final int PROPERTY_locationOnScreen = 91;
    private static final int PROPERTY_managingFocus = 92;
    private static final int PROPERTY_maximumSize = 93;
    private static final int PROPERTY_maximumSizeSet = 94;
    private static final int PROPERTY_minimumSize = 95;
    private static final int PROPERTY_minimumSizeSet = 96;
    private static final int PROPERTY_mixingCutoutShape = 97;
    private static final int PROPERTY_mouseListeners = 98;
    private static final int PROPERTY_mouseMotionListeners = 99;
    private static final int PROPERTY_mousePosition = 100;
    private static final int PROPERTY_mouseWheelListeners = 101;
    private static final int PROPERTY_name = 102;
    private static final int PROPERTY_nextFocusableComponent = 103;
    private static final int PROPERTY_opaque = 104;
    private static final int PROPERTY_optimizedDrawingEnabled = 105;
    private static final int PROPERTY_paintingForPrint = 106;
    private static final int PROPERTY_paintingTile = 107;
    private static final int PROPERTY_parent = 108;
    private static final int PROPERTY_preferredSize = 109;
    private static final int PROPERTY_preferredSizeSet = 110;
    private static final int PROPERTY_previewPanel = 111;
    private static final int PROPERTY_propertyChangeListeners = 112;
    private static final int PROPERTY_registeredKeyStrokes = 113;
    private static final int PROPERTY_requestFocusEnabled = 114;
    private static final int PROPERTY_resetButton = 115;
    private static final int PROPERTY_resetButtonShown = 116;
    private static final int PROPERTY_rootPane = 117;
    private static final int PROPERTY_selectedColor = 118;
    private static final int PROPERTY_selectionModel = 119;
    private static final int PROPERTY_showing = 120;
    private static final int PROPERTY_size = 121;
    private static final int PROPERTY_toolkit = 122;
    private static final int PROPERTY_toolTipText = 123;
    private static final int PROPERTY_topLevelAncestor = 124;
    private static final int PROPERTY_transferHandler = 125;
    private static final int PROPERTY_treeLock = 126;
    private static final int PROPERTY_UI = 127;
    private static final int PROPERTY_UIClassID = 128;
    private static final int PROPERTY_valid = 129;
    private static final int PROPERTY_validateRoot = 130;
    private static final int PROPERTY_verifyInputWhenFocusTarget = 131;
    private static final int PROPERTY_vetoableChangeListeners = 132;
    private static final int PROPERTY_visible = 133;
    private static final int PROPERTY_visibleRect = 134;
    private static final int PROPERTY_width = 135;
    private static final int PROPERTY_x = 136;
    private static final int PROPERTY_y = 137;

    // Property array 
    /*lazy PropertyDescriptor*/
    private static PropertyDescriptor[] getPdescriptor(){
        PropertyDescriptor[] properties = new PropertyDescriptor[138];
    
        try {
            properties[PROPERTY_acceptButton] = new PropertyDescriptor ( "acceptButton", components.JColorSelector.class, "getAcceptButton", null ); // NOI18N
            properties[PROPERTY_acceptButton].setHidden ( true );
            properties[PROPERTY_acceptButtonMnemonic] = new PropertyDescriptor ( "acceptButtonMnemonic", components.JColorSelector.class, "getAcceptButtonMnemonic", "setAcceptButtonMnemonic" ); // NOI18N
            properties[PROPERTY_acceptButtonMnemonic].setPreferred ( true );
            properties[PROPERTY_acceptButtonMnemonic].setShortDescription ( "The keyboard character mnemonic for the accept button." );
            properties[PROPERTY_acceptButtonMnemonic].setBound ( true );
            properties[PROPERTY_acceptButtonMnemonicSet] = new PropertyDescriptor ( "acceptButtonMnemonicSet", components.JColorSelector.class, "isAcceptButtonMnemonicSet", null ); // NOI18N
            properties[PROPERTY_acceptButtonMnemonicSet].setHidden ( true );
            properties[PROPERTY_acceptButtonText] = new PropertyDescriptor ( "acceptButtonText", components.JColorSelector.class, "getAcceptButtonText", "setAcceptButtonText" ); // NOI18N
            properties[PROPERTY_acceptButtonText].setPreferred ( true );
            properties[PROPERTY_acceptButtonText].setShortDescription ( "The text for the accept button." );
            properties[PROPERTY_acceptButtonText].setBound ( true );
            properties[PROPERTY_acceptButtonTextSet] = new PropertyDescriptor ( "acceptButtonTextSet", components.JColorSelector.class, "isAcceptButtonTextSet", null ); // NOI18N
            properties[PROPERTY_acceptButtonTextSet].setHidden ( true );
            properties[PROPERTY_acceptButtonToolTipText] = new PropertyDescriptor ( "acceptButtonToolTipText", components.JColorSelector.class, "getAcceptButtonToolTipText", "setAcceptButtonToolTipText" ); // NOI18N
            properties[PROPERTY_acceptButtonToolTipText].setPreferred ( true );
            properties[PROPERTY_acceptButtonToolTipText].setShortDescription ( "The tool tip text for the accept button." );
            properties[PROPERTY_acceptButtonToolTipText].setBound ( true );
            properties[PROPERTY_acceptButtonToolTipTextSet] = new PropertyDescriptor ( "acceptButtonToolTipTextSet", components.JColorSelector.class, "isAcceptButtonToolTipTextSet", null ); // NOI18N
            properties[PROPERTY_acceptButtonToolTipTextSet].setHidden ( true );
            properties[PROPERTY_accessibleContext] = new PropertyDescriptor ( "accessibleContext", components.JColorSelector.class, "getAccessibleContext", null ); // NOI18N
            properties[PROPERTY_accessibleContext].setHidden ( true );
            properties[PROPERTY_actionListeners] = new PropertyDescriptor ( "actionListeners", components.JColorSelector.class, "getActionListeners", null ); // NOI18N
            properties[PROPERTY_actionListeners].setHidden ( true );
            properties[PROPERTY_actionMap] = new PropertyDescriptor ( "actionMap", components.JColorSelector.class, "getActionMap", "setActionMap" ); // NOI18N
            properties[PROPERTY_actionMap].setHidden ( true );
            properties[PROPERTY_alignmentX] = new PropertyDescriptor ( "alignmentX", components.JColorSelector.class, "getAlignmentX", "setAlignmentX" ); // NOI18N
            properties[PROPERTY_alignmentX].setShortDescription ( "The preferred horizontal alignment of the component." );
            properties[PROPERTY_alignmentY] = new PropertyDescriptor ( "alignmentY", components.JColorSelector.class, "getAlignmentY", "setAlignmentY" ); // NOI18N
            properties[PROPERTY_alignmentY].setShortDescription ( "The preferred vertical alignment of the component." );
            properties[PROPERTY_ancestorListeners] = new PropertyDescriptor ( "ancestorListeners", components.JColorSelector.class, "getAncestorListeners", null ); // NOI18N
            properties[PROPERTY_ancestorListeners].setHidden ( true );
            properties[PROPERTY_autoscrolls] = new PropertyDescriptor ( "autoscrolls", components.JColorSelector.class, "getAutoscrolls", "setAutoscrolls" ); // NOI18N
            properties[PROPERTY_autoscrolls].setShortDescription ( "Determines if this component automatically scrolls its contents when dragged." );
            properties[PROPERTY_background] = new PropertyDescriptor ( "background", components.JColorSelector.class, "getBackground", "setBackground" ); // NOI18N
            properties[PROPERTY_background].setPreferred ( true );
            properties[PROPERTY_background].setShortDescription ( "The background color of the component." );
            properties[PROPERTY_background].setBound ( true );
            properties[PROPERTY_backgroundSet] = new PropertyDescriptor ( "backgroundSet", components.JColorSelector.class, "isBackgroundSet", null ); // NOI18N
            properties[PROPERTY_backgroundSet].setHidden ( true );
            properties[PROPERTY_baselineResizeBehavior] = new PropertyDescriptor ( "baselineResizeBehavior", components.JColorSelector.class, "getBaselineResizeBehavior", null ); // NOI18N
            properties[PROPERTY_baselineResizeBehavior].setExpert ( true );
            properties[PROPERTY_border] = new PropertyDescriptor ( "border", components.JColorSelector.class, "getBorder", "setBorder" ); // NOI18N
            properties[PROPERTY_border].setShortDescription ( "The component's border." );
            properties[PROPERTY_border].setBound ( true );
            properties[PROPERTY_bottomAccessory] = new PropertyDescriptor ( "bottomAccessory", components.JColorSelector.class, "getBottomAccessory", "setBottomAccessory" ); // NOI18N
            properties[PROPERTY_bottomAccessory].setPreferred ( true );
            properties[PROPERTY_bottomAccessory].setShortDescription ( "The accessory component to display at the bottom of the panel." );
            properties[PROPERTY_bottomAccessory].setBound ( true );
            properties[PROPERTY_bounds] = new PropertyDescriptor ( "bounds", components.JColorSelector.class, "getBounds", "setBounds" ); // NOI18N
            properties[PROPERTY_bounds].setHidden ( true );
            properties[PROPERTY_cancelButton] = new PropertyDescriptor ( "cancelButton", components.JColorSelector.class, "getCancelButton", null ); // NOI18N
            properties[PROPERTY_cancelButton].setHidden ( true );
            properties[PROPERTY_cancelButtonMnemonic] = new PropertyDescriptor ( "cancelButtonMnemonic", components.JColorSelector.class, "getCancelButtonMnemonic", "setCancelButtonMnemonic" ); // NOI18N
            properties[PROPERTY_cancelButtonMnemonic].setShortDescription ( "The keyboard character mnemonic for the cancel button." );
            properties[PROPERTY_cancelButtonMnemonic].setBound ( true );
            properties[PROPERTY_cancelButtonMnemonicSet] = new PropertyDescriptor ( "cancelButtonMnemonicSet", components.JColorSelector.class, "isCancelButtonMnemonicSet", null ); // NOI18N
            properties[PROPERTY_cancelButtonMnemonicSet].setHidden ( true );
            properties[PROPERTY_cancelButtonText] = new PropertyDescriptor ( "cancelButtonText", components.JColorSelector.class, "getCancelButtonText", "setCancelButtonText" ); // NOI18N
            properties[PROPERTY_cancelButtonText].setShortDescription ( "The text for the cancel button." );
            properties[PROPERTY_cancelButtonText].setBound ( true );
            properties[PROPERTY_cancelButtonTextSet] = new PropertyDescriptor ( "cancelButtonTextSet", components.JColorSelector.class, "isCancelButtonTextSet", null ); // NOI18N
            properties[PROPERTY_cancelButtonTextSet].setHidden ( true );
            properties[PROPERTY_cancelButtonToolTipText] = new PropertyDescriptor ( "cancelButtonToolTipText", components.JColorSelector.class, "getCancelButtonToolTipText", "setCancelButtonToolTipText" ); // NOI18N
            properties[PROPERTY_cancelButtonToolTipText].setShortDescription ( "The tool tip text for the cancel button." );
            properties[PROPERTY_cancelButtonToolTipText].setBound ( true );
            properties[PROPERTY_cancelButtonToolTipTextSet] = new PropertyDescriptor ( "cancelButtonToolTipTextSet", components.JColorSelector.class, "isCancelButtonToolTipTextSet", null ); // NOI18N
            properties[PROPERTY_cancelButtonToolTipTextSet].setHidden ( true );
            properties[PROPERTY_changeListeners] = new PropertyDescriptor ( "changeListeners", components.JColorSelector.class, "getChangeListeners", null ); // NOI18N
            properties[PROPERTY_changeListeners].setHidden ( true );
            properties[PROPERTY_chooserPanels] = new PropertyDescriptor ( "chooserPanels", components.JColorSelector.class, "getChooserPanels", "setChooserPanels" ); // NOI18N
            properties[PROPERTY_chooserPanels].setHidden ( true );
            properties[PROPERTY_chooserPanels].setShortDescription ( "An array of different color chooser panels." );
            properties[PROPERTY_chooserPanels].setBound ( true );
            properties[PROPERTY_clearButton] = new PropertyDescriptor ( "clearButton", components.JColorSelector.class, "getClearButton", null ); // NOI18N
            properties[PROPERTY_clearButton].setHidden ( true );
            properties[PROPERTY_clearButtonMnemonic] = new PropertyDescriptor ( "clearButtonMnemonic", components.JColorSelector.class, "getClearButtonMnemonic", "setClearButtonMnemonic" ); // NOI18N
            properties[PROPERTY_clearButtonMnemonic].setShortDescription ( "The keyboard character mnemonic for the clear button." );
            properties[PROPERTY_clearButtonMnemonic].setBound ( true );
            properties[PROPERTY_clearButtonMnemonicSet] = new PropertyDescriptor ( "clearButtonMnemonicSet", components.JColorSelector.class, "isClearButtonMnemonicSet", null ); // NOI18N
            properties[PROPERTY_clearButtonMnemonicSet].setHidden ( true );
            properties[PROPERTY_clearButtonShown] = new PropertyDescriptor ( "clearButtonShown", components.JColorSelector.class, "isClearButtonShown", "setClearButtonShown" ); // NOI18N
            properties[PROPERTY_clearButtonShown].setPreferred ( true );
            properties[PROPERTY_clearButtonShown].setShortDescription ( "Sets whether the clear button is shown." );
            properties[PROPERTY_clearButtonShown].setBound ( true );
            properties[PROPERTY_clearButtonText] = new PropertyDescriptor ( "clearButtonText", components.JColorSelector.class, "getClearButtonText", "setClearButtonText" ); // NOI18N
            properties[PROPERTY_clearButtonText].setShortDescription ( "The text for the clear button." );
            properties[PROPERTY_clearButtonText].setBound ( true );
            properties[PROPERTY_clearButtonTextSet] = new PropertyDescriptor ( "clearButtonTextSet", components.JColorSelector.class, "isClearButtonTextSet", null ); // NOI18N
            properties[PROPERTY_clearButtonTextSet].setHidden ( true );
            properties[PROPERTY_clearButtonToolTipText] = new PropertyDescriptor ( "clearButtonToolTipText", components.JColorSelector.class, "getClearButtonToolTipText", "setClearButtonToolTipText" ); // NOI18N
            properties[PROPERTY_clearButtonToolTipText].setShortDescription ( "The tool tip text for the clear button." );
            properties[PROPERTY_clearButtonToolTipText].setBound ( true );
            properties[PROPERTY_clearButtonToolTipTextSet] = new PropertyDescriptor ( "clearButtonToolTipTextSet", components.JColorSelector.class, "isClearButtonToolTipTextSet", null ); // NOI18N
            properties[PROPERTY_clearButtonToolTipTextSet].setHidden ( true );
            properties[PROPERTY_color] = new PropertyDescriptor ( "color", components.JColorSelector.class, "getColor", "setColor" ); // NOI18N
            properties[PROPERTY_color].setPreferred ( true );
            properties[PROPERTY_color].setShortDescription ( "The currently selected color." );
            properties[PROPERTY_colorChooser] = new PropertyDescriptor ( "colorChooser", components.JColorSelector.class, "getColorChooser", null ); // NOI18N
            properties[PROPERTY_colorChooser].setHidden ( true );
            properties[PROPERTY_colorChooserTitle] = new PropertyDescriptor ( "colorChooserTitle", components.JColorSelector.class, "getColorChooserTitle", "setColorChooserTitle" ); // NOI18N
            properties[PROPERTY_colorChooserTitle].setPreferred ( true );
            properties[PROPERTY_colorChooserTitle].setShortDescription ( "The title to display above the color chooser." );
            properties[PROPERTY_colorChooserTitle].setBound ( true );
            properties[PROPERTY_colorModel] = new PropertyDescriptor ( "colorModel", components.JColorSelector.class, "getColorModel", null ); // NOI18N
            properties[PROPERTY_colorModel].setHidden ( true );
            properties[PROPERTY_component] = new IndexedPropertyDescriptor ( "component", components.JColorSelector.class, null, null, "getComponent", null ); // NOI18N
            properties[PROPERTY_componentCount] = new PropertyDescriptor ( "componentCount", components.JColorSelector.class, "getComponentCount", null ); // NOI18N
            properties[PROPERTY_componentCount].setHidden ( true );
            properties[PROPERTY_componentListeners] = new PropertyDescriptor ( "componentListeners", components.JColorSelector.class, "getComponentListeners", null ); // NOI18N
            properties[PROPERTY_componentListeners].setHidden ( true );
            properties[PROPERTY_componentOrientation] = new PropertyDescriptor ( "componentOrientation", components.JColorSelector.class, "getComponentOrientation", "setComponentOrientation" ); // NOI18N
            properties[PROPERTY_componentOrientation].setHidden ( true );
            properties[PROPERTY_componentPopupMenu] = new PropertyDescriptor ( "componentPopupMenu", components.JColorSelector.class, "getComponentPopupMenu", "setComponentPopupMenu" ); // NOI18N
            properties[PROPERTY_componentPopupMenu].setShortDescription ( "The popup menu to show" );
            properties[PROPERTY_components] = new PropertyDescriptor ( "components", components.JColorSelector.class, "getComponents", null ); // NOI18N
            properties[PROPERTY_components].setHidden ( true );
            properties[PROPERTY_containerListeners] = new PropertyDescriptor ( "containerListeners", components.JColorSelector.class, "getContainerListeners", null ); // NOI18N
            properties[PROPERTY_containerListeners].setHidden ( true );
            properties[PROPERTY_controlButtonsAreShown] = new PropertyDescriptor ( "controlButtonsAreShown", components.JColorSelector.class, "getControlButtonsAreShown", "setControlButtonsAreShown" ); // NOI18N
            properties[PROPERTY_controlButtonsAreShown].setHidden ( true );
            properties[PROPERTY_controlButtonsAreShown].setShortDescription ( "Sets whether the control buttons are shown." );
            properties[PROPERTY_controlButtonsAreShown].setBound ( true );
            properties[PROPERTY_cursor] = new PropertyDescriptor ( "cursor", components.JColorSelector.class, "getCursor", "setCursor" ); // NOI18N
            properties[PROPERTY_cursorSet] = new PropertyDescriptor ( "cursorSet", components.JColorSelector.class, "isCursorSet", null ); // NOI18N
            properties[PROPERTY_cursorSet].setHidden ( true );
            properties[PROPERTY_debugGraphicsOptions] = new PropertyDescriptor ( "debugGraphicsOptions", components.JColorSelector.class, "getDebugGraphicsOptions", "setDebugGraphicsOptions" ); // NOI18N
            properties[PROPERTY_debugGraphicsOptions].setShortDescription ( "Diagnostic options for graphics operations." );
            properties[PROPERTY_dialogTitle] = new PropertyDescriptor ( "dialogTitle", components.JColorSelector.class, "getDialogTitle", "setDialogTitle" ); // NOI18N
            properties[PROPERTY_dialogTitle].setPreferred ( true );
            properties[PROPERTY_dialogTitle].setShortDescription ( "The title of the JColorSelector dialog window." );
            properties[PROPERTY_dialogTitle].setBound ( true );
            properties[PROPERTY_displayable] = new PropertyDescriptor ( "displayable", components.JColorSelector.class, "isDisplayable", null ); // NOI18N
            properties[PROPERTY_displayable].setHidden ( true );
            properties[PROPERTY_doubleBuffered] = new PropertyDescriptor ( "doubleBuffered", components.JColorSelector.class, "isDoubleBuffered", "setDoubleBuffered" ); // NOI18N
            properties[PROPERTY_dropTarget] = new PropertyDescriptor ( "dropTarget", components.JColorSelector.class, "getDropTarget", "setDropTarget" ); // NOI18N
            properties[PROPERTY_dropTarget].setHidden ( true );
            properties[PROPERTY_enabled] = new PropertyDescriptor ( "enabled", components.JColorSelector.class, "isEnabled", "setEnabled" ); // NOI18N
            properties[PROPERTY_enabled].setShortDescription ( "The enabled state of the component." );
            properties[PROPERTY_enabled].setBound ( true );
            properties[PROPERTY_focusable] = new PropertyDescriptor ( "focusable", components.JColorSelector.class, "isFocusable", "setFocusable" ); // NOI18N
            properties[PROPERTY_focusCycleRoot] = new PropertyDescriptor ( "focusCycleRoot", components.JColorSelector.class, "isFocusCycleRoot", "setFocusCycleRoot" ); // NOI18N
            properties[PROPERTY_focusCycleRootAncestor] = new PropertyDescriptor ( "focusCycleRootAncestor", components.JColorSelector.class, "getFocusCycleRootAncestor", null ); // NOI18N
            properties[PROPERTY_focusCycleRootAncestor].setHidden ( true );
            properties[PROPERTY_focusListeners] = new PropertyDescriptor ( "focusListeners", components.JColorSelector.class, "getFocusListeners", null ); // NOI18N
            properties[PROPERTY_focusListeners].setHidden ( true );
            properties[PROPERTY_focusOwner] = new PropertyDescriptor ( "focusOwner", components.JColorSelector.class, "isFocusOwner", null ); // NOI18N
            properties[PROPERTY_focusOwner].setHidden ( true );
            properties[PROPERTY_focusTraversable] = new PropertyDescriptor ( "focusTraversable", components.JColorSelector.class, "isFocusTraversable", null ); // NOI18N
            properties[PROPERTY_focusTraversable].setHidden ( true );
            properties[PROPERTY_focusTraversalKeys] = new IndexedPropertyDescriptor ( "focusTraversalKeys", components.JColorSelector.class, null, null, null, "setFocusTraversalKeys" ); // NOI18N
            properties[PROPERTY_focusTraversalKeysEnabled] = new PropertyDescriptor ( "focusTraversalKeysEnabled", components.JColorSelector.class, "getFocusTraversalKeysEnabled", "setFocusTraversalKeysEnabled" ); // NOI18N
            properties[PROPERTY_focusTraversalKeysEnabled].setHidden ( true );
            properties[PROPERTY_focusTraversalPolicy] = new PropertyDescriptor ( "focusTraversalPolicy", components.JColorSelector.class, "getFocusTraversalPolicy", "setFocusTraversalPolicy" ); // NOI18N
            properties[PROPERTY_focusTraversalPolicyProvider] = new PropertyDescriptor ( "focusTraversalPolicyProvider", components.JColorSelector.class, "isFocusTraversalPolicyProvider", "setFocusTraversalPolicyProvider" ); // NOI18N
            properties[PROPERTY_focusTraversalPolicySet] = new PropertyDescriptor ( "focusTraversalPolicySet", components.JColorSelector.class, "isFocusTraversalPolicySet", null ); // NOI18N
            properties[PROPERTY_focusTraversalPolicySet].setHidden ( true );
            properties[PROPERTY_font] = new PropertyDescriptor ( "font", components.JColorSelector.class, "getFont", "setFont" ); // NOI18N
            properties[PROPERTY_font].setPreferred ( true );
            properties[PROPERTY_font].setShortDescription ( "The font for the component." );
            properties[PROPERTY_font].setBound ( true );
            properties[PROPERTY_fontSet] = new PropertyDescriptor ( "fontSet", components.JColorSelector.class, "isFontSet", null ); // NOI18N
            properties[PROPERTY_fontSet].setHidden ( true );
            properties[PROPERTY_foreground] = new PropertyDescriptor ( "foreground", components.JColorSelector.class, "getForeground", "setForeground" ); // NOI18N
            properties[PROPERTY_foreground].setPreferred ( true );
            properties[PROPERTY_foreground].setShortDescription ( "The foreground color of the component." );
            properties[PROPERTY_foreground].setBound ( true );
            properties[PROPERTY_foregroundSet] = new PropertyDescriptor ( "foregroundSet", components.JColorSelector.class, "isForegroundSet", null ); // NOI18N
            properties[PROPERTY_foregroundSet].setHidden ( true );
            properties[PROPERTY_graphics] = new PropertyDescriptor ( "graphics", components.JColorSelector.class, "getGraphics", null ); // NOI18N
            properties[PROPERTY_graphics].setHidden ( true );
            properties[PROPERTY_graphicsConfiguration] = new PropertyDescriptor ( "graphicsConfiguration", components.JColorSelector.class, "getGraphicsConfiguration", null ); // NOI18N
            properties[PROPERTY_graphicsConfiguration].setHidden ( true );
            properties[PROPERTY_height] = new PropertyDescriptor ( "height", components.JColorSelector.class, "getHeight", null ); // NOI18N
            properties[PROPERTY_height].setHidden ( true );
            properties[PROPERTY_hierarchyBoundsListeners] = new PropertyDescriptor ( "hierarchyBoundsListeners", components.JColorSelector.class, "getHierarchyBoundsListeners", null ); // NOI18N
            properties[PROPERTY_hierarchyBoundsListeners].setHidden ( true );
            properties[PROPERTY_hierarchyListeners] = new PropertyDescriptor ( "hierarchyListeners", components.JColorSelector.class, "getHierarchyListeners", null ); // NOI18N
            properties[PROPERTY_hierarchyListeners].setHidden ( true );
            properties[PROPERTY_ignoreRepaint] = new PropertyDescriptor ( "ignoreRepaint", components.JColorSelector.class, "getIgnoreRepaint", "setIgnoreRepaint" ); // NOI18N
            properties[PROPERTY_ignoreRepaint].setHidden ( true );
            properties[PROPERTY_inheritsPopupMenu] = new PropertyDescriptor ( "inheritsPopupMenu", components.JColorSelector.class, "getInheritsPopupMenu", "setInheritsPopupMenu" ); // NOI18N
            properties[PROPERTY_inheritsPopupMenu].setShortDescription ( "Whether or not the JPopupMenu is inherited" );
            properties[PROPERTY_inheritsPopupMenu].setBound ( true );
            properties[PROPERTY_initialColor] = new PropertyDescriptor ( "initialColor", components.JColorSelector.class, "getInitialColor", "setInitialColor" ); // NOI18N
            properties[PROPERTY_initialColor].setBound ( true );
            properties[PROPERTY_inputContext] = new PropertyDescriptor ( "inputContext", components.JColorSelector.class, "getInputContext", null ); // NOI18N
            properties[PROPERTY_inputContext].setHidden ( true );
            properties[PROPERTY_inputMap] = new PropertyDescriptor ( "inputMap", components.JColorSelector.class, "getInputMap", null ); // NOI18N
            properties[PROPERTY_inputMap].setHidden ( true );
            properties[PROPERTY_inputMethodListeners] = new PropertyDescriptor ( "inputMethodListeners", components.JColorSelector.class, "getInputMethodListeners", null ); // NOI18N
            properties[PROPERTY_inputMethodListeners].setHidden ( true );
            properties[PROPERTY_inputMethodRequests] = new PropertyDescriptor ( "inputMethodRequests", components.JColorSelector.class, "getInputMethodRequests", null ); // NOI18N
            properties[PROPERTY_inputMethodRequests].setHidden ( true );
            properties[PROPERTY_inputVerifier] = new PropertyDescriptor ( "inputVerifier", components.JColorSelector.class, "getInputVerifier", "setInputVerifier" ); // NOI18N
            properties[PROPERTY_inputVerifier].setShortDescription ( "The component's input verifier." );
            properties[PROPERTY_insets] = new PropertyDescriptor ( "insets", components.JColorSelector.class, "getInsets", null ); // NOI18N
            properties[PROPERTY_insets].setExpert ( true );
            properties[PROPERTY_keyListeners] = new PropertyDescriptor ( "keyListeners", components.JColorSelector.class, "getKeyListeners", null ); // NOI18N
            properties[PROPERTY_keyListeners].setHidden ( true );
            properties[PROPERTY_layout] = new PropertyDescriptor ( "layout", components.JColorSelector.class, "getLayout", "setLayout" ); // NOI18N
            properties[PROPERTY_layout].setHidden ( true );
            properties[PROPERTY_lightweight] = new PropertyDescriptor ( "lightweight", components.JColorSelector.class, "isLightweight", null ); // NOI18N
            properties[PROPERTY_lightweight].setHidden ( true );
            properties[PROPERTY_locale] = new PropertyDescriptor ( "locale", components.JColorSelector.class, "getLocale", "setLocale" ); // NOI18N
            properties[PROPERTY_locale].setHidden ( true );
            properties[PROPERTY_location] = new PropertyDescriptor ( "location", components.JColorSelector.class, "getLocation", "setLocation" ); // NOI18N
            properties[PROPERTY_location].setHidden ( true );
            properties[PROPERTY_locationOnScreen] = new PropertyDescriptor ( "locationOnScreen", components.JColorSelector.class, "getLocationOnScreen", null ); // NOI18N
            properties[PROPERTY_locationOnScreen].setHidden ( true );
            properties[PROPERTY_managingFocus] = new PropertyDescriptor ( "managingFocus", components.JColorSelector.class, "isManagingFocus", null ); // NOI18N
            properties[PROPERTY_managingFocus].setHidden ( true );
            properties[PROPERTY_maximumSize] = new PropertyDescriptor ( "maximumSize", components.JColorSelector.class, "getMaximumSize", "setMaximumSize" ); // NOI18N
            properties[PROPERTY_maximumSize].setShortDescription ( "The maximum size of the component." );
            properties[PROPERTY_maximumSize].setBound ( true );
            properties[PROPERTY_maximumSizeSet] = new PropertyDescriptor ( "maximumSizeSet", components.JColorSelector.class, "isMaximumSizeSet", null ); // NOI18N
            properties[PROPERTY_maximumSizeSet].setHidden ( true );
            properties[PROPERTY_minimumSize] = new PropertyDescriptor ( "minimumSize", components.JColorSelector.class, "getMinimumSize", "setMinimumSize" ); // NOI18N
            properties[PROPERTY_minimumSize].setShortDescription ( "The minimum size of the component." );
            properties[PROPERTY_minimumSize].setBound ( true );
            properties[PROPERTY_minimumSizeSet] = new PropertyDescriptor ( "minimumSizeSet", components.JColorSelector.class, "isMinimumSizeSet", null ); // NOI18N
            properties[PROPERTY_minimumSizeSet].setHidden ( true );
            properties[PROPERTY_mixingCutoutShape] = new PropertyDescriptor ( "mixingCutoutShape", components.JColorSelector.class, null, "setMixingCutoutShape" ); // NOI18N
            properties[PROPERTY_mixingCutoutShape].setHidden ( true );
            properties[PROPERTY_mouseListeners] = new PropertyDescriptor ( "mouseListeners", components.JColorSelector.class, "getMouseListeners", null ); // NOI18N
            properties[PROPERTY_mouseListeners].setHidden ( true );
            properties[PROPERTY_mouseMotionListeners] = new PropertyDescriptor ( "mouseMotionListeners", components.JColorSelector.class, "getMouseMotionListeners", null ); // NOI18N
            properties[PROPERTY_mouseMotionListeners].setHidden ( true );
            properties[PROPERTY_mousePosition] = new PropertyDescriptor ( "mousePosition", components.JColorSelector.class, "getMousePosition", null ); // NOI18N
            properties[PROPERTY_mousePosition].setHidden ( true );
            properties[PROPERTY_mouseWheelListeners] = new PropertyDescriptor ( "mouseWheelListeners", components.JColorSelector.class, "getMouseWheelListeners", null ); // NOI18N
            properties[PROPERTY_mouseWheelListeners].setHidden ( true );
            properties[PROPERTY_name] = new PropertyDescriptor ( "name", components.JColorSelector.class, "getName", "setName" ); // NOI18N
            properties[PROPERTY_name].setBound ( true );
            properties[PROPERTY_nextFocusableComponent] = new PropertyDescriptor ( "nextFocusableComponent", components.JColorSelector.class, "getNextFocusableComponent", "setNextFocusableComponent" ); // NOI18N
            properties[PROPERTY_opaque] = new PropertyDescriptor ( "opaque", components.JColorSelector.class, "isOpaque", "setOpaque" ); // NOI18N
            properties[PROPERTY_opaque].setShortDescription ( "The component's opacity" );
            properties[PROPERTY_optimizedDrawingEnabled] = new PropertyDescriptor ( "optimizedDrawingEnabled", components.JColorSelector.class, "isOptimizedDrawingEnabled", null ); // NOI18N
            properties[PROPERTY_optimizedDrawingEnabled].setHidden ( true );
            properties[PROPERTY_paintingForPrint] = new PropertyDescriptor ( "paintingForPrint", components.JColorSelector.class, "isPaintingForPrint", null ); // NOI18N
            properties[PROPERTY_paintingTile] = new PropertyDescriptor ( "paintingTile", components.JColorSelector.class, "isPaintingTile", null ); // NOI18N
            properties[PROPERTY_paintingTile].setHidden ( true );
            properties[PROPERTY_parent] = new PropertyDescriptor ( "parent", components.JColorSelector.class, "getParent", null ); // NOI18N
            properties[PROPERTY_parent].setHidden ( true );
            properties[PROPERTY_preferredSize] = new PropertyDescriptor ( "preferredSize", components.JColorSelector.class, "getPreferredSize", "setPreferredSize" ); // NOI18N
            properties[PROPERTY_preferredSize].setShortDescription ( "The preferred size of the component." );
            properties[PROPERTY_preferredSize].setBound ( true );
            properties[PROPERTY_preferredSizeSet] = new PropertyDescriptor ( "preferredSizeSet", components.JColorSelector.class, "isPreferredSizeSet", null ); // NOI18N
            properties[PROPERTY_preferredSizeSet].setHidden ( true );
            properties[PROPERTY_previewPanel] = new PropertyDescriptor ( "previewPanel", components.JColorSelector.class, "getPreviewPanel", "setPreviewPanel" ); // NOI18N
            properties[PROPERTY_previewPanel].setHidden ( true );
            properties[PROPERTY_previewPanel].setShortDescription ( "The UI component which displays the current color." );
            properties[PROPERTY_previewPanel].setBound ( true );
            properties[PROPERTY_propertyChangeListeners] = new PropertyDescriptor ( "propertyChangeListeners", components.JColorSelector.class, "getPropertyChangeListeners", null ); // NOI18N
            properties[PROPERTY_propertyChangeListeners].setHidden ( true );
            properties[PROPERTY_registeredKeyStrokes] = new PropertyDescriptor ( "registeredKeyStrokes", components.JColorSelector.class, "getRegisteredKeyStrokes", null ); // NOI18N
            properties[PROPERTY_registeredKeyStrokes].setHidden ( true );
            properties[PROPERTY_requestFocusEnabled] = new PropertyDescriptor ( "requestFocusEnabled", components.JColorSelector.class, "isRequestFocusEnabled", "setRequestFocusEnabled" ); // NOI18N
            properties[PROPERTY_resetButton] = new PropertyDescriptor ( "resetButton", components.JColorSelector.class, "getResetButton", null ); // NOI18N
            properties[PROPERTY_resetButton].setHidden ( true );
            properties[PROPERTY_resetButtonShown] = new PropertyDescriptor ( "resetButtonShown", components.JColorSelector.class, "isResetButtonShown", "setResetButtonShown" ); // NOI18N
            properties[PROPERTY_resetButtonShown].setPreferred ( true );
            properties[PROPERTY_resetButtonShown].setShortDescription ( "Sets whether the reset button is shown." );
            properties[PROPERTY_resetButtonShown].setBound ( true );
            properties[PROPERTY_rootPane] = new PropertyDescriptor ( "rootPane", components.JColorSelector.class, "getRootPane", null ); // NOI18N
            properties[PROPERTY_rootPane].setHidden ( true );
            properties[PROPERTY_selectedColor] = new PropertyDescriptor ( "selectedColor", components.JColorSelector.class, "getSelectedColor", null ); // NOI18N
            properties[PROPERTY_selectedColor].setHidden ( true );
            properties[PROPERTY_selectedColor].setShortDescription ( "The color currently selected by the color chooser." );
            properties[PROPERTY_selectionModel] = new PropertyDescriptor ( "selectionModel", components.JColorSelector.class, "getSelectionModel", "setSelectionModel" ); // NOI18N
            properties[PROPERTY_selectionModel].setHidden ( true );
            properties[PROPERTY_selectionModel].setShortDescription ( "The model which contains the currently selected color." );
            properties[PROPERTY_selectionModel].setBound ( true );
            properties[PROPERTY_showing] = new PropertyDescriptor ( "showing", components.JColorSelector.class, "isShowing", null ); // NOI18N
            properties[PROPERTY_showing].setHidden ( true );
            properties[PROPERTY_size] = new PropertyDescriptor ( "size", components.JColorSelector.class, "getSize", "setSize" ); // NOI18N
            properties[PROPERTY_size].setHidden ( true );
            properties[PROPERTY_toolkit] = new PropertyDescriptor ( "toolkit", components.JColorSelector.class, "getToolkit", null ); // NOI18N
            properties[PROPERTY_toolkit].setHidden ( true );
            properties[PROPERTY_toolTipText] = new PropertyDescriptor ( "toolTipText", components.JColorSelector.class, "getToolTipText", "setToolTipText" ); // NOI18N
            properties[PROPERTY_toolTipText].setPreferred ( true );
            properties[PROPERTY_toolTipText].setShortDescription ( "The text to display in a tool tip." );
            properties[PROPERTY_topLevelAncestor] = new PropertyDescriptor ( "topLevelAncestor", components.JColorSelector.class, "getTopLevelAncestor", null ); // NOI18N
            properties[PROPERTY_topLevelAncestor].setHidden ( true );
            properties[PROPERTY_transferHandler] = new PropertyDescriptor ( "transferHandler", components.JColorSelector.class, "getTransferHandler", "setTransferHandler" ); // NOI18N
            properties[PROPERTY_transferHandler].setHidden ( true );
            properties[PROPERTY_treeLock] = new PropertyDescriptor ( "treeLock", components.JColorSelector.class, "getTreeLock", null ); // NOI18N
            properties[PROPERTY_treeLock].setHidden ( true );
            properties[PROPERTY_UI] = new PropertyDescriptor ( "UI", components.JColorSelector.class, "getUI", "setUI" ); // NOI18N
            properties[PROPERTY_UI].setHidden ( true );
            properties[PROPERTY_UI].setShortDescription ( "The UI object that implements the Component's LookAndFeel." );
            properties[PROPERTY_UIClassID] = new PropertyDescriptor ( "UIClassID", components.JColorSelector.class, "getUIClassID", null ); // NOI18N
            properties[PROPERTY_valid] = new PropertyDescriptor ( "valid", components.JColorSelector.class, "isValid", null ); // NOI18N
            properties[PROPERTY_valid].setHidden ( true );
            properties[PROPERTY_validateRoot] = new PropertyDescriptor ( "validateRoot", components.JColorSelector.class, "isValidateRoot", null ); // NOI18N
            properties[PROPERTY_validateRoot].setHidden ( true );
            properties[PROPERTY_verifyInputWhenFocusTarget] = new PropertyDescriptor ( "verifyInputWhenFocusTarget", components.JColorSelector.class, "getVerifyInputWhenFocusTarget", "setVerifyInputWhenFocusTarget" ); // NOI18N
            properties[PROPERTY_verifyInputWhenFocusTarget].setShortDescription ( "Whether the Component verifies input before accepting focus." );
            properties[PROPERTY_vetoableChangeListeners] = new PropertyDescriptor ( "vetoableChangeListeners", components.JColorSelector.class, "getVetoableChangeListeners", null ); // NOI18N
            properties[PROPERTY_vetoableChangeListeners].setHidden ( true );
            properties[PROPERTY_visible] = new PropertyDescriptor ( "visible", components.JColorSelector.class, "isVisible", "setVisible" ); // NOI18N
            properties[PROPERTY_visible].setHidden ( true );
            properties[PROPERTY_visibleRect] = new PropertyDescriptor ( "visibleRect", components.JColorSelector.class, "getVisibleRect", null ); // NOI18N
            properties[PROPERTY_visibleRect].setHidden ( true );
            properties[PROPERTY_width] = new PropertyDescriptor ( "width", components.JColorSelector.class, "getWidth", null ); // NOI18N
            properties[PROPERTY_width].setHidden ( true );
            properties[PROPERTY_x] = new PropertyDescriptor ( "x", components.JColorSelector.class, "getX", null ); // NOI18N
            properties[PROPERTY_x].setHidden ( true );
            properties[PROPERTY_y] = new PropertyDescriptor ( "y", components.JColorSelector.class, "getY", null ); // NOI18N
            properties[PROPERTY_y].setHidden ( true );
        }
        catch(IntrospectionException e) {
            e.printStackTrace();
        }//GEN-HEADEREND:Properties
        // Here you can add code for customizing the properties array.

        return properties;     }//GEN-LAST:Properties

    // EventSet identifiers//GEN-FIRST:Events
    private static final int EVENT_actionListener = 0;
    private static final int EVENT_ancestorListener = 1;
    private static final int EVENT_changeListener = 2;
    private static final int EVENT_componentListener = 3;
    private static final int EVENT_containerListener = 4;
    private static final int EVENT_focusListener = 5;
    private static final int EVENT_hierarchyBoundsListener = 6;
    private static final int EVENT_hierarchyListener = 7;
    private static final int EVENT_inputMethodListener = 8;
    private static final int EVENT_keyListener = 9;
    private static final int EVENT_mouseListener = 10;
    private static final int EVENT_mouseMotionListener = 11;
    private static final int EVENT_mouseWheelListener = 12;
    private static final int EVENT_propertyChangeListener = 13;
    private static final int EVENT_vetoableChangeListener = 14;

    // EventSet array
    /*lazy EventSetDescriptor*/
    private static EventSetDescriptor[] getEdescriptor(){
        EventSetDescriptor[] eventSets = new EventSetDescriptor[15];
    
        try {
            eventSets[EVENT_actionListener] = new EventSetDescriptor ( components.JColorSelector.class, "actionListener", java.awt.event.ActionListener.class, new String[] {"actionPerformed"}, "addActionListener", "removeActionListener" ); // NOI18N
            eventSets[EVENT_ancestorListener] = new EventSetDescriptor ( components.JColorSelector.class, "ancestorListener", javax.swing.event.AncestorListener.class, new String[] {"ancestorAdded", "ancestorRemoved", "ancestorMoved"}, "addAncestorListener", "removeAncestorListener" ); // NOI18N
            eventSets[EVENT_changeListener] = new EventSetDescriptor ( components.JColorSelector.class, "changeListener", javax.swing.event.ChangeListener.class, new String[] {"stateChanged"}, "addChangeListener", "removeChangeListener" ); // NOI18N
            eventSets[EVENT_componentListener] = new EventSetDescriptor ( components.JColorSelector.class, "componentListener", java.awt.event.ComponentListener.class, new String[] {"componentResized", "componentMoved", "componentShown", "componentHidden"}, "addComponentListener", "removeComponentListener" ); // NOI18N
            eventSets[EVENT_containerListener] = new EventSetDescriptor ( components.JColorSelector.class, "containerListener", java.awt.event.ContainerListener.class, new String[] {"componentAdded", "componentRemoved"}, "addContainerListener", "removeContainerListener" ); // NOI18N
            eventSets[EVENT_focusListener] = new EventSetDescriptor ( components.JColorSelector.class, "focusListener", java.awt.event.FocusListener.class, new String[] {"focusGained", "focusLost"}, "addFocusListener", "removeFocusListener" ); // NOI18N
            eventSets[EVENT_hierarchyBoundsListener] = new EventSetDescriptor ( components.JColorSelector.class, "hierarchyBoundsListener", java.awt.event.HierarchyBoundsListener.class, new String[] {"ancestorMoved", "ancestorResized"}, "addHierarchyBoundsListener", "removeHierarchyBoundsListener" ); // NOI18N
            eventSets[EVENT_hierarchyListener] = new EventSetDescriptor ( components.JColorSelector.class, "hierarchyListener", java.awt.event.HierarchyListener.class, new String[] {"hierarchyChanged"}, "addHierarchyListener", "removeHierarchyListener" ); // NOI18N
            eventSets[EVENT_inputMethodListener] = new EventSetDescriptor ( components.JColorSelector.class, "inputMethodListener", java.awt.event.InputMethodListener.class, new String[] {"inputMethodTextChanged", "caretPositionChanged"}, "addInputMethodListener", "removeInputMethodListener" ); // NOI18N
            eventSets[EVENT_keyListener] = new EventSetDescriptor ( components.JColorSelector.class, "keyListener", java.awt.event.KeyListener.class, new String[] {"keyTyped", "keyPressed", "keyReleased"}, "addKeyListener", "removeKeyListener" ); // NOI18N
            eventSets[EVENT_mouseListener] = new EventSetDescriptor ( components.JColorSelector.class, "mouseListener", java.awt.event.MouseListener.class, new String[] {"mouseClicked", "mousePressed", "mouseReleased", "mouseEntered", "mouseExited"}, "addMouseListener", "removeMouseListener" ); // NOI18N
            eventSets[EVENT_mouseMotionListener] = new EventSetDescriptor ( components.JColorSelector.class, "mouseMotionListener", java.awt.event.MouseMotionListener.class, new String[] {"mouseDragged", "mouseMoved"}, "addMouseMotionListener", "removeMouseMotionListener" ); // NOI18N
            eventSets[EVENT_mouseWheelListener] = new EventSetDescriptor ( components.JColorSelector.class, "mouseWheelListener", java.awt.event.MouseWheelListener.class, new String[] {"mouseWheelMoved"}, "addMouseWheelListener", "removeMouseWheelListener" ); // NOI18N
            eventSets[EVENT_propertyChangeListener] = new EventSetDescriptor ( components.JColorSelector.class, "propertyChangeListener", java.beans.PropertyChangeListener.class, new String[] {"propertyChange"}, "addPropertyChangeListener", "removePropertyChangeListener" ); // NOI18N
            eventSets[EVENT_vetoableChangeListener] = new EventSetDescriptor ( components.JColorSelector.class, "vetoableChangeListener", java.beans.VetoableChangeListener.class, new String[] {"vetoableChange"}, "addVetoableChangeListener", "removeVetoableChangeListener" ); // NOI18N
        }
        catch(IntrospectionException e) {
            e.printStackTrace();
        }//GEN-HEADEREND:Events
        // Here you can add code for customizing the event sets array.

        return eventSets;     }//GEN-LAST:Events

    // Method information will be obtained from introspection.//GEN-FIRST:Methods
    private static MethodDescriptor[] methods = null;
    private static MethodDescriptor[] getMdescriptor(){//GEN-HEADEREND:Methods
        // Here you can add code for customizing the methods array.

        return methods;     }//GEN-LAST:Methods

    private static java.awt.Image iconColor16 = null;//GEN-BEGIN:IconsDef
    private static java.awt.Image iconColor32 = null;
    private static java.awt.Image iconMono16 = null;
    private static java.awt.Image iconMono32 = null;//GEN-END:IconsDef
    private static String iconNameC16 = null;//GEN-BEGIN:Icons
    private static String iconNameC32 = null;
    private static String iconNameM16 = null;
    private static String iconNameM32 = null;//GEN-END:Icons
    /**
     * This stores the BeanInfoIconFactory used to generate icons. This is 
     * initialized the first time it is used.
     */
    private static BeanInfoIconFactory iconFactory = null;
    
    private static final int defaultPropertyIndex = -1;//GEN-BEGIN:Idx
    private static final int defaultEventIndex = -1;//GEN-END:Idx


//GEN-FIRST:Superclass
    // Here you can add code for customizing the Superclass BeanInfo.

//GEN-LAST:Superclass
    /**
     * Gets the bean's <code>BeanDescriptor</code>s.
     *
     * @return BeanDescriptor describing the editable properties of this bean.
     * May return null if the information should be obtained by automatic
     * analysis.
     */
    @Override
    public BeanDescriptor getBeanDescriptor() {
        return getBdescriptor();
    }

    /**
     * Gets the bean's <code>PropertyDescriptor</code>s.
     *
     * @return An array of PropertyDescriptors describing the editable
     * properties supported by this bean. May return null if the information
     * should be obtained by automatic analysis.
     * <p>
     * If a property is indexed, then its entry in the result array will belong
     * to the IndexedPropertyDescriptor subclass of PropertyDescriptor. A client
     * of getPropertyDescriptors can use "instanceof" to check if a given
     * PropertyDescriptor is an IndexedPropertyDescriptor.
     */
    @Override
    public PropertyDescriptor[] getPropertyDescriptors() {
        return getPdescriptor();
    }

    /**
     * Gets the bean's <code>EventSetDescriptor</code>s.
     *
     * @return An array of EventSetDescriptors describing the kinds of events
     * fired by this bean. May return null if the information should be obtained
     * by automatic analysis.
     */
    @Override
    public EventSetDescriptor[] getEventSetDescriptors() {
        return getEdescriptor();
    }

    /**
     * Gets the bean's <code>MethodDescriptor</code>s.
     *
     * @return An array of MethodDescriptors describing the methods implemented
     * by this bean. May return null if the information should be obtained by
     * automatic analysis.
     */
    @Override
    public MethodDescriptor[] getMethodDescriptors() {
        return getMdescriptor();
    }

    /**
     * A bean may have a "default" property that is the property that will
     * mostly commonly be initially chosen for update by human's who are
     * customizing the bean.
     *
     * @return Index of default property in the PropertyDescriptor array
     * returned by getPropertyDescriptors.
     * <P>
     * Returns -1 if there is no default property.
     */
    @Override
    public int getDefaultPropertyIndex() {
        return defaultPropertyIndex;
    }

    /**
     * A bean may have a "default" event that is the event that will mostly
     * commonly be used by human's when using the bean.
     *
     * @return Index of default event in the EventSetDescriptor array returned
     * by getEventSetDescriptors.
     * <P>
     * Returns -1 if there is no default event.
     */
    @Override
    public int getDefaultEventIndex() {
        return defaultEventIndex;
    }
    /**
     * This returns the image to use to represent JColorSelector.
     * @param iconKind The kind of icon to get.
     * @param resourceName The name for the resource to get the image from, or 
     * null.
     * @return The image representing a JColorSelector, or null if no suitable 
     * icon is available.
     * @see #getIcon(int) 
     * @see beans.BeanInfoIconFactory
     * @see beans.BeanInfoIconFactory#createIconImage(int, java.lang.String, java.beans.SimpleBeanInfo) 
     */
    private java.awt.Image createIcon(int iconKind, String resourceName){
        if (iconFactory == null)    // If the icon factory is not initialized yet
            iconFactory = new JColorSelectorIconFactory();
        return iconFactory.createIconImage(iconKind, resourceName, this);
    }
    /**
     * This method returns an image object that can be used to represent the
     * bean in toolboxes, toolbars, etc. Icon images will typically be GIFs, but
     * may in future include other formats.
     * <p>
     * Beans aren't required to provide icons and may return null from this
     * method.
     * <p>
     * There are four possible flavors of icons (16x16 color, 32x32 color, 16x16
     * mono, 32x32 mono). If a bean choses to only support a single icon we
     * recommend supporting 16x16 color.
     * <p>
     * We recommend that icons have a "transparent" background so they can be
     * rendered onto an existing background.
     *
     * @param iconKind The kind of icon requested. This should be one of the
     * constant values ICON_COLOR_16x16, ICON_COLOR_32x32, ICON_MONO_16x16, or
     * ICON_MONO_32x32.
     * @return An image object representing the requested icon. May return null
     * if no suitable icon is available.
     */
    @Override
    public java.awt.Image getIcon(int iconKind) {
        switch (iconKind) {
            case ICON_COLOR_16x16:              // 16x16 color icon
                if (iconColor16 == null)        // If the icon was not loaded yet
                    iconColor16 = createIcon(iconKind, iconNameC16);
                return iconColor16;
            case ICON_COLOR_32x32:              // 32x32 color icon
                if (iconColor32 == null)        // If the icon was not loaded yet
                    iconColor32 = createIcon(iconKind, iconNameC32);
                return iconColor32;
            case ICON_MONO_16x16:               // 16x16 monochrome icon
                if (iconMono16 == null)         // If the icon was not loaded yet
                    iconMono16 = createIcon(iconKind, iconNameM16);
                return iconMono16;
            case ICON_MONO_32x32:               // 32x32 monochrome icon
                if (iconMono32 == null)         // If the icon was not loaded yet
                    iconMono32 = createIcon(iconKind, iconNameM32);
                return iconMono32;
            default:
                return null;
        }
    }
    /**
     * This is the BeanInfoIconFactory used to create icons to represent 
     * JColorSelector.
     */
    private static class JColorSelectorIconFactory extends DialogBeanInfoIconFactory{
        /**
         * This stores the RGB values for the colors to use for the hue 
         * gradient for the image representing JColorSelector. The first array 
         * contains the colors to use for a color icon and the second array 
         * contains the colors to use for a monochrome icon.
         */
        public static final int[][] HUE_GRADIENT_VALUES = {
            {0xFF0000, 0xFFFF00, 0x00FF00, 0x00FFFF, 0x0000FF, 0xFF00FF},
            {0x828282, 0xF8F8F8, 0xDCDCDC, 0xE4E4E4, 0x464646, 0x919191}
        };
        /**
         * This stores the colors to use for the hue gradient for the image 
         * representing JColorSelector. The first array contains the colors to 
         * use for a color icon and the second array contains the colors to use 
         * for a monochrome icon. These arrays are initialized the first time 
         * they are requested and they are the length of their respective RGB 
         * value arrays plus 1.
         * @see #HUE_GRADIENT_VALUES
         * @see #HUE_GRADIENT_FRACTIONS
         */
        private static final java.awt.Color[][] HUE_GRADIENT_COLORS = new java.awt.Color[HUE_GRADIENT_VALUES.length][];
        /**
         * This contains the color distribution for the hue gradient. The colors 
         * are evenly distributed. The first array contains the distribution to 
         * use for a color icon and the second array contains the distribution 
         * to use for a monochrome icon. These arrays are initialized the first 
         * time they are requested and they are the same length as their 
         * respective color arrays.
         * @see #HUE_GRADIENT_COLORS
         */
        private static final float[][] HUE_GRADIENT_FRACTIONS = new float[HUE_GRADIENT_VALUES.length][];
        @Override
        protected boolean getButtonsArePainted() {
            return true;
        }
        @Override
        protected void paintDialogContents(java.awt.Graphics2D g, int scale, 
                int colorMode, int x, int y, int w, int h) {
                // This is the rectangle used to paint the color chooser gradient
            java.awt.Rectangle rect = new java.awt.Rectangle(x,y,w,h);
            rect.grow(-1, -1);
                // Draw the outline around the color chooser gradient
            g.setPaint(createOutlineGradient(rect.y,(float)rect.getMaxY(),colorMode));
            g.fill(rect);
            if (scale == 2){    // If this is a 32x32 icon
                    // We have enough room to show a background around the color 
                rect.grow(-1, -1);    // chooser gradient
                g.setPaint(createLightGrayFillGradient(rect.y,(float)rect.getMaxY()));
                g.fill(rect);
            }   // If the color array for the hue gradient to use is not initialized yet
            if (HUE_GRADIENT_COLORS[colorMode] == null){
                    // Get the array of color values to use
                int[] arr = HUE_GRADIENT_VALUES[colorMode];
                HUE_GRADIENT_COLORS[colorMode] = new java.awt.Color[arr.length+1];
                HUE_GRADIENT_FRACTIONS[colorMode] = new float[HUE_GRADIENT_COLORS[colorMode].length];
                float d = arr.length;   // Get the denominator for the fractions
                    // A for loop to create the colors and fractions 
                for (int i = 0; i < HUE_GRADIENT_COLORS[colorMode].length; i++){
                    HUE_GRADIENT_COLORS[colorMode][i] = new java.awt.Color(arr[i%arr.length]);
                    HUE_GRADIENT_FRACTIONS[colorMode][i] = i / d;
                }
            }
            rect.grow(-1, -1);
                // Draw the hue part of the color chooser gradient
            g.setPaint(new java.awt.LinearGradientPaint(rect.x,0,(float)rect.getMaxX(),
                    0,HUE_GRADIENT_FRACTIONS[colorMode],HUE_GRADIENT_COLORS[colorMode]));
            g.fill(rect);
                // Draw the saturation part of the color chooser gradient
            g.setPaint(createVerticalGradient(rect.y,(float)rect.getMaxY()+1,TRANSPARENT_COLOR,java.awt.Color.GRAY));
            g.fill(rect);
        }
    }
}
