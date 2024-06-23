/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Beans/BeanInfo.java to edit this template
 */
package components;

import java.beans.*;

/**
 * This is the beans info for AbstractConfirmDialogPanel.
 * @author Milo Steier
 * @see AbstractConfirmDialogPanel
 */
public class AbstractConfirmDialogPanelBeanInfo extends SimpleBeanInfo {

    // Bean descriptor//GEN-FIRST:BeanDescriptor
    /*lazy BeanDescriptor*/
    private static BeanDescriptor getBdescriptor(){
        BeanDescriptor beanDescriptor = new BeanDescriptor  ( components.AbstractConfirmDialogPanel.class , null ); // NOI18N
        beanDescriptor.setShortDescription ( "This is a panel with the basic framework for opening a confirmation dialog box with this panel." );//GEN-HEADEREND:BeanDescriptor
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
    private static final int PROPERTY_bounds = 18;
    private static final int PROPERTY_cancelButton = 19;
    private static final int PROPERTY_cancelButtonMnemonic = 20;
    private static final int PROPERTY_cancelButtonMnemonicSet = 21;
    private static final int PROPERTY_cancelButtonText = 22;
    private static final int PROPERTY_cancelButtonTextSet = 23;
    private static final int PROPERTY_cancelButtonToolTipText = 24;
    private static final int PROPERTY_cancelButtonToolTipTextSet = 25;
    private static final int PROPERTY_colorModel = 26;
    private static final int PROPERTY_component = 27;
    private static final int PROPERTY_componentCount = 28;
    private static final int PROPERTY_componentListeners = 29;
    private static final int PROPERTY_componentOrientation = 30;
    private static final int PROPERTY_componentPopupMenu = 31;
    private static final int PROPERTY_components = 32;
    private static final int PROPERTY_containerListeners = 33;
    private static final int PROPERTY_controlButtonsAreShown = 34;
    private static final int PROPERTY_cursor = 35;
    private static final int PROPERTY_cursorSet = 36;
    private static final int PROPERTY_debugGraphicsOptions = 37;
    private static final int PROPERTY_dialogTitle = 38;
    private static final int PROPERTY_displayable = 39;
    private static final int PROPERTY_doubleBuffered = 40;
    private static final int PROPERTY_dropTarget = 41;
    private static final int PROPERTY_enabled = 42;
    private static final int PROPERTY_focusable = 43;
    private static final int PROPERTY_focusCycleRoot = 44;
    private static final int PROPERTY_focusCycleRootAncestor = 45;
    private static final int PROPERTY_focusListeners = 46;
    private static final int PROPERTY_focusOwner = 47;
    private static final int PROPERTY_focusTraversable = 48;
    private static final int PROPERTY_focusTraversalKeys = 49;
    private static final int PROPERTY_focusTraversalKeysEnabled = 50;
    private static final int PROPERTY_focusTraversalPolicy = 51;
    private static final int PROPERTY_focusTraversalPolicyProvider = 52;
    private static final int PROPERTY_focusTraversalPolicySet = 53;
    private static final int PROPERTY_font = 54;
    private static final int PROPERTY_fontSet = 55;
    private static final int PROPERTY_foreground = 56;
    private static final int PROPERTY_foregroundSet = 57;
    private static final int PROPERTY_graphics = 58;
    private static final int PROPERTY_graphicsConfiguration = 59;
    private static final int PROPERTY_height = 60;
    private static final int PROPERTY_hierarchyBoundsListeners = 61;
    private static final int PROPERTY_hierarchyListeners = 62;
    private static final int PROPERTY_ignoreRepaint = 63;
    private static final int PROPERTY_inheritsPopupMenu = 64;
    private static final int PROPERTY_inputContext = 65;
    private static final int PROPERTY_inputMap = 66;
    private static final int PROPERTY_inputMethodListeners = 67;
    private static final int PROPERTY_inputMethodRequests = 68;
    private static final int PROPERTY_inputVerifier = 69;
    private static final int PROPERTY_insets = 70;
    private static final int PROPERTY_keyListeners = 71;
    private static final int PROPERTY_layout = 72;
    private static final int PROPERTY_lightweight = 73;
    private static final int PROPERTY_locale = 74;
    private static final int PROPERTY_location = 75;
    private static final int PROPERTY_locationOnScreen = 76;
    private static final int PROPERTY_managingFocus = 77;
    private static final int PROPERTY_maximumSize = 78;
    private static final int PROPERTY_maximumSizeSet = 79;
    private static final int PROPERTY_minimumSize = 80;
    private static final int PROPERTY_minimumSizeSet = 81;
    private static final int PROPERTY_mixingCutoutShape = 82;
    private static final int PROPERTY_mouseListeners = 83;
    private static final int PROPERTY_mouseMotionListeners = 84;
    private static final int PROPERTY_mousePosition = 85;
    private static final int PROPERTY_mouseWheelListeners = 86;
    private static final int PROPERTY_name = 87;
    private static final int PROPERTY_nextFocusableComponent = 88;
    private static final int PROPERTY_opaque = 89;
    private static final int PROPERTY_optimizedDrawingEnabled = 90;
    private static final int PROPERTY_paintingForPrint = 91;
    private static final int PROPERTY_paintingTile = 92;
    private static final int PROPERTY_parent = 93;
    private static final int PROPERTY_preferredSize = 94;
    private static final int PROPERTY_preferredSizeSet = 95;
    private static final int PROPERTY_propertyChangeListeners = 96;
    private static final int PROPERTY_registeredKeyStrokes = 97;
    private static final int PROPERTY_requestFocusEnabled = 98;
    private static final int PROPERTY_rootPane = 99;
    private static final int PROPERTY_showing = 100;
    private static final int PROPERTY_size = 101;
    private static final int PROPERTY_toolkit = 102;
    private static final int PROPERTY_toolTipText = 103;
    private static final int PROPERTY_topLevelAncestor = 104;
    private static final int PROPERTY_transferHandler = 105;
    private static final int PROPERTY_treeLock = 106;
    private static final int PROPERTY_UI = 107;
    private static final int PROPERTY_UIClassID = 108;
    private static final int PROPERTY_valid = 109;
    private static final int PROPERTY_validateRoot = 110;
    private static final int PROPERTY_verifyInputWhenFocusTarget = 111;
    private static final int PROPERTY_vetoableChangeListeners = 112;
    private static final int PROPERTY_visible = 113;
    private static final int PROPERTY_visibleRect = 114;
    private static final int PROPERTY_width = 115;
    private static final int PROPERTY_x = 116;
    private static final int PROPERTY_y = 117;

    // Property array 
    /*lazy PropertyDescriptor*/
    private static PropertyDescriptor[] getPdescriptor(){
        PropertyDescriptor[] properties = new PropertyDescriptor[118];
    
        try {
            properties[PROPERTY_acceptButton] = new PropertyDescriptor ( "acceptButton", components.AbstractConfirmDialogPanel.class, "getAcceptButton", null ); // NOI18N
            properties[PROPERTY_acceptButton].setHidden ( true );
            properties[PROPERTY_acceptButtonMnemonic] = new PropertyDescriptor ( "acceptButtonMnemonic", components.AbstractConfirmDialogPanel.class, null, "setAcceptButtonMnemonic" ); // NOI18N
            properties[PROPERTY_acceptButtonMnemonic].setPreferred ( true );
            properties[PROPERTY_acceptButtonMnemonic].setShortDescription ( "The keyboard character mnemonic for the accept button." );
            properties[PROPERTY_acceptButtonMnemonicSet] = new PropertyDescriptor ( "acceptButtonMnemonicSet", components.AbstractConfirmDialogPanel.class, "isAcceptButtonMnemonicSet", null ); // NOI18N
            properties[PROPERTY_acceptButtonMnemonicSet].setHidden ( true );
            properties[PROPERTY_acceptButtonText] = new PropertyDescriptor ( "acceptButtonText", components.AbstractConfirmDialogPanel.class, "getAcceptButtonText", "setAcceptButtonText" ); // NOI18N
            properties[PROPERTY_acceptButtonText].setPreferred ( true );
            properties[PROPERTY_acceptButtonText].setShortDescription ( "The text for the accept button." );
            properties[PROPERTY_acceptButtonTextSet] = new PropertyDescriptor ( "acceptButtonTextSet", components.AbstractConfirmDialogPanel.class, "isAcceptButtonTextSet", null ); // NOI18N
            properties[PROPERTY_acceptButtonTextSet].setHidden ( true );
            properties[PROPERTY_acceptButtonToolTipText] = new PropertyDescriptor ( "acceptButtonToolTipText", components.AbstractConfirmDialogPanel.class, "getAcceptButtonToolTipText", "setAcceptButtonToolTipText" ); // NOI18N
            properties[PROPERTY_acceptButtonToolTipText].setPreferred ( true );
            properties[PROPERTY_acceptButtonToolTipText].setShortDescription ( "The tool tip text for the accept button." );
            properties[PROPERTY_acceptButtonToolTipTextSet] = new PropertyDescriptor ( "acceptButtonToolTipTextSet", components.AbstractConfirmDialogPanel.class, "isAcceptButtonToolTipTextSet", null ); // NOI18N
            properties[PROPERTY_acceptButtonToolTipTextSet].setHidden ( true );
            properties[PROPERTY_accessibleContext] = new PropertyDescriptor ( "accessibleContext", components.AbstractConfirmDialogPanel.class, "getAccessibleContext", null ); // NOI18N
            properties[PROPERTY_accessibleContext].setHidden ( true );
            properties[PROPERTY_actionListeners] = new PropertyDescriptor ( "actionListeners", components.AbstractConfirmDialogPanel.class, "getActionListeners", null ); // NOI18N
            properties[PROPERTY_actionListeners].setHidden ( true );
            properties[PROPERTY_actionMap] = new PropertyDescriptor ( "actionMap", components.AbstractConfirmDialogPanel.class, "getActionMap", "setActionMap" ); // NOI18N
            properties[PROPERTY_actionMap].setHidden ( true );
            properties[PROPERTY_alignmentX] = new PropertyDescriptor ( "alignmentX", components.AbstractConfirmDialogPanel.class, "getAlignmentX", "setAlignmentX" ); // NOI18N
            properties[PROPERTY_alignmentX].setShortDescription ( "The preferred horizontal alignment of the component." );
            properties[PROPERTY_alignmentY] = new PropertyDescriptor ( "alignmentY", components.AbstractConfirmDialogPanel.class, "getAlignmentY", "setAlignmentY" ); // NOI18N
            properties[PROPERTY_alignmentY].setShortDescription ( "The preferred vertical alignment of the component." );
            properties[PROPERTY_ancestorListeners] = new PropertyDescriptor ( "ancestorListeners", components.AbstractConfirmDialogPanel.class, "getAncestorListeners", null ); // NOI18N
            properties[PROPERTY_ancestorListeners].setHidden ( true );
            properties[PROPERTY_autoscrolls] = new PropertyDescriptor ( "autoscrolls", components.AbstractConfirmDialogPanel.class, "getAutoscrolls", "setAutoscrolls" ); // NOI18N
            properties[PROPERTY_autoscrolls].setShortDescription ( "Determines if this component automatically scrolls its contents when dragged." );
            properties[PROPERTY_background] = new PropertyDescriptor ( "background", components.AbstractConfirmDialogPanel.class, "getBackground", "setBackground" ); // NOI18N
            properties[PROPERTY_background].setPreferred ( true );
            properties[PROPERTY_background].setShortDescription ( "The background color of the component." );
            properties[PROPERTY_backgroundSet] = new PropertyDescriptor ( "backgroundSet", components.AbstractConfirmDialogPanel.class, "isBackgroundSet", null ); // NOI18N
            properties[PROPERTY_backgroundSet].setHidden ( true );
            properties[PROPERTY_baselineResizeBehavior] = new PropertyDescriptor ( "baselineResizeBehavior", components.AbstractConfirmDialogPanel.class, "getBaselineResizeBehavior", null ); // NOI18N
            properties[PROPERTY_baselineResizeBehavior].setExpert ( true );
            properties[PROPERTY_border] = new PropertyDescriptor ( "border", components.AbstractConfirmDialogPanel.class, "getBorder", "setBorder" ); // NOI18N
            properties[PROPERTY_border].setPreferred ( true );
            properties[PROPERTY_border].setShortDescription ( "The component's border." );
            properties[PROPERTY_bounds] = new PropertyDescriptor ( "bounds", components.AbstractConfirmDialogPanel.class, "getBounds", "setBounds" ); // NOI18N
            properties[PROPERTY_bounds].setHidden ( true );
            properties[PROPERTY_cancelButton] = new PropertyDescriptor ( "cancelButton", components.AbstractConfirmDialogPanel.class, "getCancelButton", null ); // NOI18N
            properties[PROPERTY_cancelButton].setHidden ( true );
            properties[PROPERTY_cancelButtonMnemonic] = new PropertyDescriptor ( "cancelButtonMnemonic", components.AbstractConfirmDialogPanel.class, null, "setCancelButtonMnemonic" ); // NOI18N
            properties[PROPERTY_cancelButtonMnemonic].setShortDescription ( "The keyboard character mnemonic for the cancel button." );
            properties[PROPERTY_cancelButtonMnemonicSet] = new PropertyDescriptor ( "cancelButtonMnemonicSet", components.AbstractConfirmDialogPanel.class, "isCancelButtonMnemonicSet", null ); // NOI18N
            properties[PROPERTY_cancelButtonMnemonicSet].setHidden ( true );
            properties[PROPERTY_cancelButtonText] = new PropertyDescriptor ( "cancelButtonText", components.AbstractConfirmDialogPanel.class, "getCancelButtonText", "setCancelButtonText" ); // NOI18N
            properties[PROPERTY_cancelButtonText].setShortDescription ( "The text for the cancel button." );
            properties[PROPERTY_cancelButtonTextSet] = new PropertyDescriptor ( "cancelButtonTextSet", components.AbstractConfirmDialogPanel.class, "isCancelButtonTextSet", null ); // NOI18N
            properties[PROPERTY_cancelButtonTextSet].setHidden ( true );
            properties[PROPERTY_cancelButtonToolTipText] = new PropertyDescriptor ( "cancelButtonToolTipText", components.AbstractConfirmDialogPanel.class, "getCancelButtonToolTipText", "setCancelButtonToolTipText" ); // NOI18N
            properties[PROPERTY_cancelButtonToolTipText].setShortDescription ( "The tool tip text for the cancel button." );
            properties[PROPERTY_cancelButtonToolTipTextSet] = new PropertyDescriptor ( "cancelButtonToolTipTextSet", components.AbstractConfirmDialogPanel.class, "isCancelButtonToolTipTextSet", null ); // NOI18N
            properties[PROPERTY_cancelButtonToolTipTextSet].setHidden ( true );
            properties[PROPERTY_colorModel] = new PropertyDescriptor ( "colorModel", components.AbstractConfirmDialogPanel.class, "getColorModel", null ); // NOI18N
            properties[PROPERTY_colorModel].setHidden ( true );
            properties[PROPERTY_component] = new IndexedPropertyDescriptor ( "component", components.AbstractConfirmDialogPanel.class, null, null, "getComponent", null ); // NOI18N
            properties[PROPERTY_component].setHidden ( true );
            properties[PROPERTY_componentCount] = new PropertyDescriptor ( "componentCount", components.AbstractConfirmDialogPanel.class, "getComponentCount", null ); // NOI18N
            properties[PROPERTY_componentCount].setHidden ( true );
            properties[PROPERTY_componentListeners] = new PropertyDescriptor ( "componentListeners", components.AbstractConfirmDialogPanel.class, "getComponentListeners", null ); // NOI18N
            properties[PROPERTY_componentListeners].setHidden ( true );
            properties[PROPERTY_componentOrientation] = new PropertyDescriptor ( "componentOrientation", components.AbstractConfirmDialogPanel.class, "getComponentOrientation", "setComponentOrientation" ); // NOI18N
            properties[PROPERTY_componentOrientation].setHidden ( true );
            properties[PROPERTY_componentPopupMenu] = new PropertyDescriptor ( "componentPopupMenu", components.AbstractConfirmDialogPanel.class, "getComponentPopupMenu", "setComponentPopupMenu" ); // NOI18N
            properties[PROPERTY_componentPopupMenu].setShortDescription ( "The popup menu to show" );
            properties[PROPERTY_components] = new PropertyDescriptor ( "components", components.AbstractConfirmDialogPanel.class, "getComponents", null ); // NOI18N
            properties[PROPERTY_components].setHidden ( true );
            properties[PROPERTY_containerListeners] = new PropertyDescriptor ( "containerListeners", components.AbstractConfirmDialogPanel.class, "getContainerListeners", null ); // NOI18N
            properties[PROPERTY_containerListeners].setHidden ( true );
            properties[PROPERTY_controlButtonsAreShown] = new PropertyDescriptor ( "controlButtonsAreShown", components.AbstractConfirmDialogPanel.class, "getControlButtonsAreShown", "setControlButtonsAreShown" ); // NOI18N
            properties[PROPERTY_controlButtonsAreShown].setShortDescription ( "Sets whether the control buttons are shown." );
            properties[PROPERTY_cursor] = new PropertyDescriptor ( "cursor", components.AbstractConfirmDialogPanel.class, "getCursor", "setCursor" ); // NOI18N
            properties[PROPERTY_cursorSet] = new PropertyDescriptor ( "cursorSet", components.AbstractConfirmDialogPanel.class, "isCursorSet", null ); // NOI18N
            properties[PROPERTY_cursorSet].setHidden ( true );
            properties[PROPERTY_debugGraphicsOptions] = new PropertyDescriptor ( "debugGraphicsOptions", components.AbstractConfirmDialogPanel.class, "getDebugGraphicsOptions", "setDebugGraphicsOptions" ); // NOI18N
            properties[PROPERTY_debugGraphicsOptions].setShortDescription ( "Diagnostic options for graphics operations." );
            properties[PROPERTY_dialogTitle] = new PropertyDescriptor ( "dialogTitle", components.AbstractConfirmDialogPanel.class, "getDialogTitle", "setDialogTitle" ); // NOI18N
            properties[PROPERTY_dialogTitle].setPreferred ( true );
            properties[PROPERTY_dialogTitle].setShortDescription ( "The title of the JListSelector dialog window." );
            properties[PROPERTY_displayable] = new PropertyDescriptor ( "displayable", components.AbstractConfirmDialogPanel.class, "isDisplayable", null ); // NOI18N
            properties[PROPERTY_displayable].setHidden ( true );
            properties[PROPERTY_doubleBuffered] = new PropertyDescriptor ( "doubleBuffered", components.AbstractConfirmDialogPanel.class, "isDoubleBuffered", "setDoubleBuffered" ); // NOI18N
            properties[PROPERTY_dropTarget] = new PropertyDescriptor ( "dropTarget", components.AbstractConfirmDialogPanel.class, "getDropTarget", "setDropTarget" ); // NOI18N
            properties[PROPERTY_dropTarget].setHidden ( true );
            properties[PROPERTY_enabled] = new PropertyDescriptor ( "enabled", components.AbstractConfirmDialogPanel.class, "isEnabled", "setEnabled" ); // NOI18N
            properties[PROPERTY_enabled].setShortDescription ( "The enabled state of the component." );
            properties[PROPERTY_focusable] = new PropertyDescriptor ( "focusable", components.AbstractConfirmDialogPanel.class, "isFocusable", "setFocusable" ); // NOI18N
            properties[PROPERTY_focusCycleRoot] = new PropertyDescriptor ( "focusCycleRoot", components.AbstractConfirmDialogPanel.class, "isFocusCycleRoot", "setFocusCycleRoot" ); // NOI18N
            properties[PROPERTY_focusCycleRoot].setHidden ( true );
            properties[PROPERTY_focusCycleRootAncestor] = new PropertyDescriptor ( "focusCycleRootAncestor", components.AbstractConfirmDialogPanel.class, "getFocusCycleRootAncestor", null ); // NOI18N
            properties[PROPERTY_focusCycleRootAncestor].setHidden ( true );
            properties[PROPERTY_focusListeners] = new PropertyDescriptor ( "focusListeners", components.AbstractConfirmDialogPanel.class, "getFocusListeners", null ); // NOI18N
            properties[PROPERTY_focusListeners].setHidden ( true );
            properties[PROPERTY_focusOwner] = new PropertyDescriptor ( "focusOwner", components.AbstractConfirmDialogPanel.class, "isFocusOwner", null ); // NOI18N
            properties[PROPERTY_focusOwner].setHidden ( true );
            properties[PROPERTY_focusTraversable] = new PropertyDescriptor ( "focusTraversable", components.AbstractConfirmDialogPanel.class, "isFocusTraversable", null ); // NOI18N
            properties[PROPERTY_focusTraversable].setHidden ( true );
            properties[PROPERTY_focusTraversalKeys] = new IndexedPropertyDescriptor ( "focusTraversalKeys", components.AbstractConfirmDialogPanel.class, null, null, null, "setFocusTraversalKeys" ); // NOI18N
            properties[PROPERTY_focusTraversalKeys].setHidden ( true );
            properties[PROPERTY_focusTraversalKeysEnabled] = new PropertyDescriptor ( "focusTraversalKeysEnabled", components.AbstractConfirmDialogPanel.class, "getFocusTraversalKeysEnabled", "setFocusTraversalKeysEnabled" ); // NOI18N
            properties[PROPERTY_focusTraversalKeysEnabled].setHidden ( true );
            properties[PROPERTY_focusTraversalPolicy] = new PropertyDescriptor ( "focusTraversalPolicy", components.AbstractConfirmDialogPanel.class, "getFocusTraversalPolicy", "setFocusTraversalPolicy" ); // NOI18N
            properties[PROPERTY_focusTraversalPolicyProvider] = new PropertyDescriptor ( "focusTraversalPolicyProvider", components.AbstractConfirmDialogPanel.class, "isFocusTraversalPolicyProvider", "setFocusTraversalPolicyProvider" ); // NOI18N
            properties[PROPERTY_focusTraversalPolicySet] = new PropertyDescriptor ( "focusTraversalPolicySet", components.AbstractConfirmDialogPanel.class, "isFocusTraversalPolicySet", null ); // NOI18N
            properties[PROPERTY_focusTraversalPolicySet].setHidden ( true );
            properties[PROPERTY_font] = new PropertyDescriptor ( "font", components.AbstractConfirmDialogPanel.class, "getFont", "setFont" ); // NOI18N
            properties[PROPERTY_font].setPreferred ( true );
            properties[PROPERTY_font].setShortDescription ( "The font for the component." );
            properties[PROPERTY_fontSet] = new PropertyDescriptor ( "fontSet", components.AbstractConfirmDialogPanel.class, "isFontSet", null ); // NOI18N
            properties[PROPERTY_fontSet].setHidden ( true );
            properties[PROPERTY_foreground] = new PropertyDescriptor ( "foreground", components.AbstractConfirmDialogPanel.class, "getForeground", "setForeground" ); // NOI18N
            properties[PROPERTY_foreground].setPreferred ( true );
            properties[PROPERTY_foreground].setShortDescription ( "The foreground color of the component." );
            properties[PROPERTY_foregroundSet] = new PropertyDescriptor ( "foregroundSet", components.AbstractConfirmDialogPanel.class, "isForegroundSet", null ); // NOI18N
            properties[PROPERTY_foregroundSet].setHidden ( true );
            properties[PROPERTY_graphics] = new PropertyDescriptor ( "graphics", components.AbstractConfirmDialogPanel.class, "getGraphics", null ); // NOI18N
            properties[PROPERTY_graphics].setHidden ( true );
            properties[PROPERTY_graphicsConfiguration] = new PropertyDescriptor ( "graphicsConfiguration", components.AbstractConfirmDialogPanel.class, "getGraphicsConfiguration", null ); // NOI18N
            properties[PROPERTY_graphicsConfiguration].setHidden ( true );
            properties[PROPERTY_height] = new PropertyDescriptor ( "height", components.AbstractConfirmDialogPanel.class, "getHeight", null ); // NOI18N
            properties[PROPERTY_height].setHidden ( true );
            properties[PROPERTY_hierarchyBoundsListeners] = new PropertyDescriptor ( "hierarchyBoundsListeners", components.AbstractConfirmDialogPanel.class, "getHierarchyBoundsListeners", null ); // NOI18N
            properties[PROPERTY_hierarchyBoundsListeners].setHidden ( true );
            properties[PROPERTY_hierarchyListeners] = new PropertyDescriptor ( "hierarchyListeners", components.AbstractConfirmDialogPanel.class, "getHierarchyListeners", null ); // NOI18N
            properties[PROPERTY_hierarchyListeners].setHidden ( true );
            properties[PROPERTY_ignoreRepaint] = new PropertyDescriptor ( "ignoreRepaint", components.AbstractConfirmDialogPanel.class, "getIgnoreRepaint", "setIgnoreRepaint" ); // NOI18N
            properties[PROPERTY_ignoreRepaint].setHidden ( true );
            properties[PROPERTY_inheritsPopupMenu] = new PropertyDescriptor ( "inheritsPopupMenu", components.AbstractConfirmDialogPanel.class, "getInheritsPopupMenu", "setInheritsPopupMenu" ); // NOI18N
            properties[PROPERTY_inheritsPopupMenu].setShortDescription ( "Whether or not the JPopupMenu is inherited" );
            properties[PROPERTY_inputContext] = new PropertyDescriptor ( "inputContext", components.AbstractConfirmDialogPanel.class, "getInputContext", null ); // NOI18N
            properties[PROPERTY_inputContext].setHidden ( true );
            properties[PROPERTY_inputMap] = new PropertyDescriptor ( "inputMap", components.AbstractConfirmDialogPanel.class, "getInputMap", null ); // NOI18N
            properties[PROPERTY_inputMap].setHidden ( true );
            properties[PROPERTY_inputMethodListeners] = new PropertyDescriptor ( "inputMethodListeners", components.AbstractConfirmDialogPanel.class, "getInputMethodListeners", null ); // NOI18N
            properties[PROPERTY_inputMethodListeners].setHidden ( true );
            properties[PROPERTY_inputMethodRequests] = new PropertyDescriptor ( "inputMethodRequests", components.AbstractConfirmDialogPanel.class, "getInputMethodRequests", null ); // NOI18N
            properties[PROPERTY_inputMethodRequests].setHidden ( true );
            properties[PROPERTY_inputVerifier] = new PropertyDescriptor ( "inputVerifier", components.AbstractConfirmDialogPanel.class, "getInputVerifier", "setInputVerifier" ); // NOI18N
            properties[PROPERTY_inputVerifier].setShortDescription ( "The component's input verifier." );
            properties[PROPERTY_insets] = new PropertyDescriptor ( "insets", components.AbstractConfirmDialogPanel.class, "getInsets", null ); // NOI18N
            properties[PROPERTY_insets].setExpert ( true );
            properties[PROPERTY_keyListeners] = new PropertyDescriptor ( "keyListeners", components.AbstractConfirmDialogPanel.class, "getKeyListeners", null ); // NOI18N
            properties[PROPERTY_keyListeners].setHidden ( true );
            properties[PROPERTY_layout] = new PropertyDescriptor ( "layout", components.AbstractConfirmDialogPanel.class, "getLayout", "setLayout" ); // NOI18N
            properties[PROPERTY_layout].setHidden ( true );
            properties[PROPERTY_lightweight] = new PropertyDescriptor ( "lightweight", components.AbstractConfirmDialogPanel.class, "isLightweight", null ); // NOI18N
            properties[PROPERTY_lightweight].setHidden ( true );
            properties[PROPERTY_locale] = new PropertyDescriptor ( "locale", components.AbstractConfirmDialogPanel.class, "getLocale", "setLocale" ); // NOI18N
            properties[PROPERTY_locale].setHidden ( true );
            properties[PROPERTY_location] = new PropertyDescriptor ( "location", components.AbstractConfirmDialogPanel.class, "getLocation", "setLocation" ); // NOI18N
            properties[PROPERTY_location].setHidden ( true );
            properties[PROPERTY_locationOnScreen] = new PropertyDescriptor ( "locationOnScreen", components.AbstractConfirmDialogPanel.class, "getLocationOnScreen", null ); // NOI18N
            properties[PROPERTY_locationOnScreen].setHidden ( true );
            properties[PROPERTY_managingFocus] = new PropertyDescriptor ( "managingFocus", components.AbstractConfirmDialogPanel.class, "isManagingFocus", null ); // NOI18N
            properties[PROPERTY_managingFocus].setHidden ( true );
            properties[PROPERTY_maximumSize] = new PropertyDescriptor ( "maximumSize", components.AbstractConfirmDialogPanel.class, "getMaximumSize", "setMaximumSize" ); // NOI18N
            properties[PROPERTY_maximumSize].setShortDescription ( "The maximum size of the component." );
            properties[PROPERTY_maximumSizeSet] = new PropertyDescriptor ( "maximumSizeSet", components.AbstractConfirmDialogPanel.class, "isMaximumSizeSet", null ); // NOI18N
            properties[PROPERTY_maximumSizeSet].setHidden ( true );
            properties[PROPERTY_minimumSize] = new PropertyDescriptor ( "minimumSize", components.AbstractConfirmDialogPanel.class, "getMinimumSize", "setMinimumSize" ); // NOI18N
            properties[PROPERTY_minimumSize].setShortDescription ( "The minimum size of the component." );
            properties[PROPERTY_minimumSizeSet] = new PropertyDescriptor ( "minimumSizeSet", components.AbstractConfirmDialogPanel.class, "isMinimumSizeSet", null ); // NOI18N
            properties[PROPERTY_minimumSizeSet].setHidden ( true );
            properties[PROPERTY_mixingCutoutShape] = new PropertyDescriptor ( "mixingCutoutShape", components.AbstractConfirmDialogPanel.class, null, "setMixingCutoutShape" ); // NOI18N
            properties[PROPERTY_mixingCutoutShape].setHidden ( true );
            properties[PROPERTY_mouseListeners] = new PropertyDescriptor ( "mouseListeners", components.AbstractConfirmDialogPanel.class, "getMouseListeners", null ); // NOI18N
            properties[PROPERTY_mouseListeners].setHidden ( true );
            properties[PROPERTY_mouseMotionListeners] = new PropertyDescriptor ( "mouseMotionListeners", components.AbstractConfirmDialogPanel.class, "getMouseMotionListeners", null ); // NOI18N
            properties[PROPERTY_mouseMotionListeners].setHidden ( true );
            properties[PROPERTY_mousePosition] = new PropertyDescriptor ( "mousePosition", components.AbstractConfirmDialogPanel.class, "getMousePosition", null ); // NOI18N
            properties[PROPERTY_mousePosition].setHidden ( true );
            properties[PROPERTY_mouseWheelListeners] = new PropertyDescriptor ( "mouseWheelListeners", components.AbstractConfirmDialogPanel.class, "getMouseWheelListeners", null ); // NOI18N
            properties[PROPERTY_mouseWheelListeners].setHidden ( true );
            properties[PROPERTY_name] = new PropertyDescriptor ( "name", components.AbstractConfirmDialogPanel.class, "getName", "setName" ); // NOI18N
            properties[PROPERTY_nextFocusableComponent] = new PropertyDescriptor ( "nextFocusableComponent", components.AbstractConfirmDialogPanel.class, "getNextFocusableComponent", "setNextFocusableComponent" ); // NOI18N
            properties[PROPERTY_opaque] = new PropertyDescriptor ( "opaque", components.AbstractConfirmDialogPanel.class, "isOpaque", "setOpaque" ); // NOI18N
            properties[PROPERTY_opaque].setShortDescription ( "The component's opacity" );
            properties[PROPERTY_optimizedDrawingEnabled] = new PropertyDescriptor ( "optimizedDrawingEnabled", components.AbstractConfirmDialogPanel.class, "isOptimizedDrawingEnabled", null ); // NOI18N
            properties[PROPERTY_optimizedDrawingEnabled].setHidden ( true );
            properties[PROPERTY_paintingForPrint] = new PropertyDescriptor ( "paintingForPrint", components.AbstractConfirmDialogPanel.class, "isPaintingForPrint", null ); // NOI18N
            properties[PROPERTY_paintingTile] = new PropertyDescriptor ( "paintingTile", components.AbstractConfirmDialogPanel.class, "isPaintingTile", null ); // NOI18N
            properties[PROPERTY_paintingTile].setHidden ( true );
            properties[PROPERTY_parent] = new PropertyDescriptor ( "parent", components.AbstractConfirmDialogPanel.class, "getParent", null ); // NOI18N
            properties[PROPERTY_parent].setHidden ( true );
            properties[PROPERTY_preferredSize] = new PropertyDescriptor ( "preferredSize", components.AbstractConfirmDialogPanel.class, "getPreferredSize", "setPreferredSize" ); // NOI18N
            properties[PROPERTY_preferredSize].setShortDescription ( "The preferred size of the component." );
            properties[PROPERTY_preferredSizeSet] = new PropertyDescriptor ( "preferredSizeSet", components.AbstractConfirmDialogPanel.class, "isPreferredSizeSet", null ); // NOI18N
            properties[PROPERTY_preferredSizeSet].setHidden ( true );
            properties[PROPERTY_propertyChangeListeners] = new PropertyDescriptor ( "propertyChangeListeners", components.AbstractConfirmDialogPanel.class, "getPropertyChangeListeners", null ); // NOI18N
            properties[PROPERTY_propertyChangeListeners].setHidden ( true );
            properties[PROPERTY_registeredKeyStrokes] = new PropertyDescriptor ( "registeredKeyStrokes", components.AbstractConfirmDialogPanel.class, "getRegisteredKeyStrokes", null ); // NOI18N
            properties[PROPERTY_registeredKeyStrokes].setHidden ( true );
            properties[PROPERTY_requestFocusEnabled] = new PropertyDescriptor ( "requestFocusEnabled", components.AbstractConfirmDialogPanel.class, "isRequestFocusEnabled", "setRequestFocusEnabled" ); // NOI18N
            properties[PROPERTY_rootPane] = new PropertyDescriptor ( "rootPane", components.AbstractConfirmDialogPanel.class, "getRootPane", null ); // NOI18N
            properties[PROPERTY_rootPane].setHidden ( true );
            properties[PROPERTY_showing] = new PropertyDescriptor ( "showing", components.AbstractConfirmDialogPanel.class, "isShowing", null ); // NOI18N
            properties[PROPERTY_showing].setHidden ( true );
            properties[PROPERTY_size] = new PropertyDescriptor ( "size", components.AbstractConfirmDialogPanel.class, "getSize", "setSize" ); // NOI18N
            properties[PROPERTY_size].setHidden ( true );
            properties[PROPERTY_toolkit] = new PropertyDescriptor ( "toolkit", components.AbstractConfirmDialogPanel.class, "getToolkit", null ); // NOI18N
            properties[PROPERTY_toolkit].setHidden ( true );
            properties[PROPERTY_toolTipText] = new PropertyDescriptor ( "toolTipText", components.AbstractConfirmDialogPanel.class, "getToolTipText", "setToolTipText" ); // NOI18N
            properties[PROPERTY_toolTipText].setPreferred ( true );
            properties[PROPERTY_toolTipText].setShortDescription ( "The text to display in a tool tip." );
            properties[PROPERTY_topLevelAncestor] = new PropertyDescriptor ( "topLevelAncestor", components.AbstractConfirmDialogPanel.class, "getTopLevelAncestor", null ); // NOI18N
            properties[PROPERTY_topLevelAncestor].setHidden ( true );
            properties[PROPERTY_transferHandler] = new PropertyDescriptor ( "transferHandler", components.AbstractConfirmDialogPanel.class, "getTransferHandler", "setTransferHandler" ); // NOI18N
            properties[PROPERTY_transferHandler].setHidden ( true );
            properties[PROPERTY_treeLock] = new PropertyDescriptor ( "treeLock", components.AbstractConfirmDialogPanel.class, "getTreeLock", null ); // NOI18N
            properties[PROPERTY_treeLock].setHidden ( true );
            properties[PROPERTY_UI] = new PropertyDescriptor ( "UI", components.AbstractConfirmDialogPanel.class, "getUI", "setUI" ); // NOI18N
            properties[PROPERTY_UI].setHidden ( true );
            properties[PROPERTY_UI].setShortDescription ( "The UI object that implements the Component's LookAndFeel." );
            properties[PROPERTY_UIClassID] = new PropertyDescriptor ( "UIClassID", components.AbstractConfirmDialogPanel.class, "getUIClassID", null ); // NOI18N
            properties[PROPERTY_valid] = new PropertyDescriptor ( "valid", components.AbstractConfirmDialogPanel.class, "isValid", null ); // NOI18N
            properties[PROPERTY_valid].setHidden ( true );
            properties[PROPERTY_validateRoot] = new PropertyDescriptor ( "validateRoot", components.AbstractConfirmDialogPanel.class, "isValidateRoot", null ); // NOI18N
            properties[PROPERTY_validateRoot].setHidden ( true );
            properties[PROPERTY_verifyInputWhenFocusTarget] = new PropertyDescriptor ( "verifyInputWhenFocusTarget", components.AbstractConfirmDialogPanel.class, "getVerifyInputWhenFocusTarget", "setVerifyInputWhenFocusTarget" ); // NOI18N
            properties[PROPERTY_verifyInputWhenFocusTarget].setShortDescription ( "Whether the Component verifies input before accepting focus." );
            properties[PROPERTY_vetoableChangeListeners] = new PropertyDescriptor ( "vetoableChangeListeners", components.AbstractConfirmDialogPanel.class, "getVetoableChangeListeners", null ); // NOI18N
            properties[PROPERTY_vetoableChangeListeners].setHidden ( true );
            properties[PROPERTY_visible] = new PropertyDescriptor ( "visible", components.AbstractConfirmDialogPanel.class, "isVisible", "setVisible" ); // NOI18N
            properties[PROPERTY_visible].setHidden ( true );
            properties[PROPERTY_visibleRect] = new PropertyDescriptor ( "visibleRect", components.AbstractConfirmDialogPanel.class, "getVisibleRect", null ); // NOI18N
            properties[PROPERTY_visibleRect].setHidden ( true );
            properties[PROPERTY_width] = new PropertyDescriptor ( "width", components.AbstractConfirmDialogPanel.class, "getWidth", null ); // NOI18N
            properties[PROPERTY_width].setHidden ( true );
            properties[PROPERTY_x] = new PropertyDescriptor ( "x", components.AbstractConfirmDialogPanel.class, "getX", null ); // NOI18N
            properties[PROPERTY_x].setHidden ( true );
            properties[PROPERTY_y] = new PropertyDescriptor ( "y", components.AbstractConfirmDialogPanel.class, "getY", null ); // NOI18N
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
    private static final int EVENT_componentListener = 2;
    private static final int EVENT_containerListener = 3;
    private static final int EVENT_focusListener = 4;
    private static final int EVENT_hierarchyBoundsListener = 5;
    private static final int EVENT_hierarchyListener = 6;
    private static final int EVENT_inputMethodListener = 7;
    private static final int EVENT_keyListener = 8;
    private static final int EVENT_mouseListener = 9;
    private static final int EVENT_mouseMotionListener = 10;
    private static final int EVENT_mouseWheelListener = 11;
    private static final int EVENT_propertyChangeListener = 12;
    private static final int EVENT_vetoableChangeListener = 13;

    // EventSet array
    /*lazy EventSetDescriptor*/
    private static EventSetDescriptor[] getEdescriptor(){
        EventSetDescriptor[] eventSets = new EventSetDescriptor[14];
    
        try {
            eventSets[EVENT_actionListener] = new EventSetDescriptor ( components.AbstractConfirmDialogPanel.class, "actionListener", java.awt.event.ActionListener.class, new String[] {"actionPerformed"}, "addActionListener", "removeActionListener" ); // NOI18N
            eventSets[EVENT_ancestorListener] = new EventSetDescriptor ( components.AbstractConfirmDialogPanel.class, "ancestorListener", javax.swing.event.AncestorListener.class, new String[] {"ancestorAdded", "ancestorRemoved", "ancestorMoved"}, "addAncestorListener", "removeAncestorListener" ); // NOI18N
            eventSets[EVENT_componentListener] = new EventSetDescriptor ( components.AbstractConfirmDialogPanel.class, "componentListener", java.awt.event.ComponentListener.class, new String[] {"componentResized", "componentMoved", "componentShown", "componentHidden"}, "addComponentListener", "removeComponentListener" ); // NOI18N
            eventSets[EVENT_containerListener] = new EventSetDescriptor ( components.AbstractConfirmDialogPanel.class, "containerListener", java.awt.event.ContainerListener.class, new String[] {"componentAdded", "componentRemoved"}, "addContainerListener", "removeContainerListener" ); // NOI18N
            eventSets[EVENT_focusListener] = new EventSetDescriptor ( components.AbstractConfirmDialogPanel.class, "focusListener", java.awt.event.FocusListener.class, new String[] {"focusGained", "focusLost"}, "addFocusListener", "removeFocusListener" ); // NOI18N
            eventSets[EVENT_hierarchyBoundsListener] = new EventSetDescriptor ( components.AbstractConfirmDialogPanel.class, "hierarchyBoundsListener", java.awt.event.HierarchyBoundsListener.class, new String[] {"ancestorMoved", "ancestorResized"}, "addHierarchyBoundsListener", "removeHierarchyBoundsListener" ); // NOI18N
            eventSets[EVENT_hierarchyListener] = new EventSetDescriptor ( components.AbstractConfirmDialogPanel.class, "hierarchyListener", java.awt.event.HierarchyListener.class, new String[] {"hierarchyChanged"}, "addHierarchyListener", "removeHierarchyListener" ); // NOI18N
            eventSets[EVENT_inputMethodListener] = new EventSetDescriptor ( components.AbstractConfirmDialogPanel.class, "inputMethodListener", java.awt.event.InputMethodListener.class, new String[] {"inputMethodTextChanged", "caretPositionChanged"}, "addInputMethodListener", "removeInputMethodListener" ); // NOI18N
            eventSets[EVENT_keyListener] = new EventSetDescriptor ( components.AbstractConfirmDialogPanel.class, "keyListener", java.awt.event.KeyListener.class, new String[] {"keyTyped", "keyPressed", "keyReleased"}, "addKeyListener", "removeKeyListener" ); // NOI18N
            eventSets[EVENT_mouseListener] = new EventSetDescriptor ( components.AbstractConfirmDialogPanel.class, "mouseListener", java.awt.event.MouseListener.class, new String[] {"mouseClicked", "mousePressed", "mouseReleased", "mouseEntered", "mouseExited"}, "addMouseListener", "removeMouseListener" ); // NOI18N
            eventSets[EVENT_mouseMotionListener] = new EventSetDescriptor ( components.AbstractConfirmDialogPanel.class, "mouseMotionListener", java.awt.event.MouseMotionListener.class, new String[] {"mouseDragged", "mouseMoved"}, "addMouseMotionListener", "removeMouseMotionListener" ); // NOI18N
            eventSets[EVENT_mouseWheelListener] = new EventSetDescriptor ( components.AbstractConfirmDialogPanel.class, "mouseWheelListener", java.awt.event.MouseWheelListener.class, new String[] {"mouseWheelMoved"}, "addMouseWheelListener", "removeMouseWheelListener" ); // NOI18N
            eventSets[EVENT_propertyChangeListener] = new EventSetDescriptor ( components.AbstractConfirmDialogPanel.class, "propertyChangeListener", java.beans.PropertyChangeListener.class, new String[] {"propertyChange"}, "addPropertyChangeListener", "removePropertyChangeListener" ); // NOI18N
            eventSets[EVENT_vetoableChangeListener] = new EventSetDescriptor ( components.AbstractConfirmDialogPanel.class, "vetoableChangeListener", java.beans.VetoableChangeListener.class, new String[] {"vetoableChange"}, "addVetoableChangeListener", "removeVetoableChangeListener" ); // NOI18N
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
            case ICON_COLOR_16x16:
                if (iconNameC16 == null) {
                    return null;
                } else {
                    if (iconColor16 == null) {
                        iconColor16 = loadImage(iconNameC16);
                    }
                    return iconColor16;
                }
            case ICON_COLOR_32x32:
                if (iconNameC32 == null) {
                    return null;
                } else {
                    if (iconColor32 == null) {
                        iconColor32 = loadImage(iconNameC32);
                    }
                    return iconColor32;
                }
            case ICON_MONO_16x16:
                if (iconNameM16 == null) {
                    return null;
                } else {
                    if (iconMono16 == null) {
                        iconMono16 = loadImage(iconNameM16);
                    }
                    return iconMono16;
                }
            case ICON_MONO_32x32:
                if (iconNameM32 == null) {
                    return null;
                } else {
                    if (iconMono32 == null) {
                        iconMono32 = loadImage(iconNameM32);
                    }
                    return iconMono32;
                }
            default:
                return null;
        }
    }
    
}
