/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Beans/BeanInfo.java to edit this template
 */
package components;

import beans.BeanInfoIconFactory;
import java.beans.*;

/**
 * This is the beans info for JListManipulator.
 * @author Milo Steier
 * @see JListManipulator
 */
public class JListManipulatorBeanInfo extends SimpleBeanInfo {

    // Bean descriptor//GEN-FIRST:BeanDescriptor
    /*lazy BeanDescriptor*/
    private static BeanDescriptor getBdescriptor(){
        BeanDescriptor beanDescriptor = new BeanDescriptor  ( components.JListManipulator.class , null ); // NOI18N
        beanDescriptor.setShortDescription ( "This is a panel that can be used to manipulate items in a list." );//GEN-HEADEREND:BeanDescriptor
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
    private static final int PROPERTY_anchorSelectionIndex = 13;
    private static final int PROPERTY_autoscrolls = 14;
    private static final int PROPERTY_background = 15;
    private static final int PROPERTY_backgroundSet = 16;
    private static final int PROPERTY_baselineResizeBehavior = 17;
    private static final int PROPERTY_border = 18;
    private static final int PROPERTY_bottomAccessory = 19;
    private static final int PROPERTY_bounds = 20;
    private static final int PROPERTY_cancelButton = 21;
    private static final int PROPERTY_cancelButtonMnemonic = 22;
    private static final int PROPERTY_cancelButtonMnemonicSet = 23;
    private static final int PROPERTY_cancelButtonText = 24;
    private static final int PROPERTY_cancelButtonTextSet = 25;
    private static final int PROPERTY_cancelButtonToolTipText = 26;
    private static final int PROPERTY_cancelButtonToolTipTextSet = 27;
    private static final int PROPERTY_cellRenderer = 28;
    private static final int PROPERTY_colorModel = 29;
    private static final int PROPERTY_component = 30;
    private static final int PROPERTY_componentCount = 31;
    private static final int PROPERTY_componentListeners = 32;
    private static final int PROPERTY_componentOrientation = 33;
    private static final int PROPERTY_componentPopupMenu = 34;
    private static final int PROPERTY_components = 35;
    private static final int PROPERTY_containerListeners = 36;
    private static final int PROPERTY_controlButtonsAreShown = 37;
    private static final int PROPERTY_cursor = 38;
    private static final int PROPERTY_cursorSet = 39;
    private static final int PROPERTY_debugGraphicsOptions = 40;
    private static final int PROPERTY_dialogTitle = 41;
    private static final int PROPERTY_displayable = 42;
    private static final int PROPERTY_doubleBuffered = 43;
    private static final int PROPERTY_dropTarget = 44;
    private static final int PROPERTY_enabled = 45;
    private static final int PROPERTY_firstVisibleIndex = 46;
    private static final int PROPERTY_fixedCellHeight = 47;
    private static final int PROPERTY_fixedCellWidth = 48;
    private static final int PROPERTY_focusable = 49;
    private static final int PROPERTY_focusCycleRoot = 50;
    private static final int PROPERTY_focusCycleRootAncestor = 51;
    private static final int PROPERTY_focusListeners = 52;
    private static final int PROPERTY_focusOwner = 53;
    private static final int PROPERTY_focusTraversable = 54;
    private static final int PROPERTY_focusTraversalKeys = 55;
    private static final int PROPERTY_focusTraversalKeysEnabled = 56;
    private static final int PROPERTY_focusTraversalPolicy = 57;
    private static final int PROPERTY_focusTraversalPolicyProvider = 58;
    private static final int PROPERTY_focusTraversalPolicySet = 59;
    private static final int PROPERTY_font = 60;
    private static final int PROPERTY_fontSet = 61;
    private static final int PROPERTY_foreground = 62;
    private static final int PROPERTY_foregroundSet = 63;
    private static final int PROPERTY_graphics = 64;
    private static final int PROPERTY_graphicsConfiguration = 65;
    private static final int PROPERTY_height = 66;
    private static final int PROPERTY_hierarchyBoundsListeners = 67;
    private static final int PROPERTY_hierarchyListeners = 68;
    private static final int PROPERTY_iconsAreShown = 69;
    private static final int PROPERTY_ignoreRepaint = 70;
    private static final int PROPERTY_inheritsPopupMenu = 71;
    private static final int PROPERTY_inputContext = 72;
    private static final int PROPERTY_inputMap = 73;
    private static final int PROPERTY_inputMethodListeners = 74;
    private static final int PROPERTY_inputMethodRequests = 75;
    private static final int PROPERTY_inputVerifier = 76;
    private static final int PROPERTY_insets = 77;
    private static final int PROPERTY_keyListeners = 78;
    private static final int PROPERTY_lastVisibleIndex = 79;
    private static final int PROPERTY_layout = 80;
    private static final int PROPERTY_layoutOrientation = 81;
    private static final int PROPERTY_leadSelectionIndex = 82;
    private static final int PROPERTY_lightweight = 83;
    private static final int PROPERTY_list = 84;
    private static final int PROPERTY_listAutoscrolls = 85;
    private static final int PROPERTY_listBackground = 86;
    private static final int PROPERTY_listData = 87;
    private static final int PROPERTY_listDataListeners = 88;
    private static final int PROPERTY_listSelectionListeners = 89;
    private static final int PROPERTY_listTitle = 90;
    private static final int PROPERTY_locale = 91;
    private static final int PROPERTY_location = 92;
    private static final int PROPERTY_locationOnScreen = 93;
    private static final int PROPERTY_managingFocus = 94;
    private static final int PROPERTY_maximumSize = 95;
    private static final int PROPERTY_maximumSizeSet = 96;
    private static final int PROPERTY_maxSelectionIndex = 97;
    private static final int PROPERTY_minimumSize = 98;
    private static final int PROPERTY_minimumSizeSet = 99;
    private static final int PROPERTY_minSelectionIndex = 100;
    private static final int PROPERTY_mixingCutoutShape = 101;
    private static final int PROPERTY_model = 102;
    private static final int PROPERTY_modelList = 103;
    private static final int PROPERTY_mouseListeners = 104;
    private static final int PROPERTY_mouseMotionListeners = 105;
    private static final int PROPERTY_mousePosition = 106;
    private static final int PROPERTY_mouseWheelListeners = 107;
    private static final int PROPERTY_moveBackwardButton = 108;
    private static final int PROPERTY_moveButtonsAreShown = 109;
    private static final int PROPERTY_moveForwardButton = 110;
    private static final int PROPERTY_name = 111;
    private static final int PROPERTY_nextFocusableComponent = 112;
    private static final int PROPERTY_opaque = 113;
    private static final int PROPERTY_optimizedDrawingEnabled = 114;
    private static final int PROPERTY_paintingForPrint = 115;
    private static final int PROPERTY_paintingTile = 116;
    private static final int PROPERTY_parent = 117;
    private static final int PROPERTY_preferredSize = 118;
    private static final int PROPERTY_preferredSizeSet = 119;
    private static final int PROPERTY_propertyChangeListeners = 120;
    private static final int PROPERTY_prototypeCellValue = 121;
    private static final int PROPERTY_registeredKeyStrokes = 122;
    private static final int PROPERTY_removeButton = 123;
    private static final int PROPERTY_removeButtonIsShown = 124;
    private static final int PROPERTY_requestFocusEnabled = 125;
    private static final int PROPERTY_resetButton = 126;
    private static final int PROPERTY_resetButtonIsShown = 127;
    private static final int PROPERTY_reverseButton = 128;
    private static final int PROPERTY_reverseButtonIsShown = 129;
    private static final int PROPERTY_rootPane = 130;
    private static final int PROPERTY_scrollPane = 131;
    private static final int PROPERTY_selectedIndex = 132;
    private static final int PROPERTY_selectedIndices = 133;
    private static final int PROPERTY_selectedItemsCount = 134;
    private static final int PROPERTY_selectedValue = 135;
    private static final int PROPERTY_selectedValuesList = 136;
    private static final int PROPERTY_selectionBackground = 137;
    private static final int PROPERTY_selectionEmpty = 138;
    private static final int PROPERTY_selectionForeground = 139;
    private static final int PROPERTY_selectionInterval = 140;
    private static final int PROPERTY_selectionMode = 141;
    private static final int PROPERTY_selectionModel = 142;
    private static final int PROPERTY_shiftDistance = 143;
    private static final int PROPERTY_showing = 144;
    private static final int PROPERTY_sideAccessory = 145;
    private static final int PROPERTY_size = 146;
    private static final int PROPERTY_toolkit = 147;
    private static final int PROPERTY_toolTipText = 148;
    private static final int PROPERTY_topLevelAncestor = 149;
    private static final int PROPERTY_transferHandler = 150;
    private static final int PROPERTY_treeLock = 151;
    private static final int PROPERTY_UI = 152;
    private static final int PROPERTY_UIClassID = 153;
    private static final int PROPERTY_valid = 154;
    private static final int PROPERTY_validateRoot = 155;
    private static final int PROPERTY_valueIsAdjusting = 156;
    private static final int PROPERTY_verifyInputWhenFocusTarget = 157;
    private static final int PROPERTY_vetoableChangeListeners = 158;
    private static final int PROPERTY_visible = 159;
    private static final int PROPERTY_visibleRect = 160;
    private static final int PROPERTY_visibleRowCount = 161;
    private static final int PROPERTY_width = 162;
    private static final int PROPERTY_x = 163;
    private static final int PROPERTY_y = 164;

    // Property array 
    /*lazy PropertyDescriptor*/
    private static PropertyDescriptor[] getPdescriptor(){
        PropertyDescriptor[] properties = new PropertyDescriptor[165];
    
        try {
            properties[PROPERTY_acceptButton] = new PropertyDescriptor ( "acceptButton", components.JListManipulator.class, "getAcceptButton", null ); // NOI18N
            properties[PROPERTY_acceptButton].setHidden ( true );
            properties[PROPERTY_acceptButtonMnemonic] = new PropertyDescriptor ( "acceptButtonMnemonic", components.JListManipulator.class, "getAcceptButtonMnemonic", "setAcceptButtonMnemonic" ); // NOI18N
            properties[PROPERTY_acceptButtonMnemonic].setPreferred ( true );
            properties[PROPERTY_acceptButtonMnemonic].setShortDescription ( "The keyboard character mnemonic for the accept button." );
            properties[PROPERTY_acceptButtonMnemonic].setBound ( true );
            properties[PROPERTY_acceptButtonMnemonicSet] = new PropertyDescriptor ( "acceptButtonMnemonicSet", components.JListManipulator.class, "isAcceptButtonMnemonicSet", null ); // NOI18N
            properties[PROPERTY_acceptButtonMnemonicSet].setHidden ( true );
            properties[PROPERTY_acceptButtonText] = new PropertyDescriptor ( "acceptButtonText", components.JListManipulator.class, "getAcceptButtonText", "setAcceptButtonText" ); // NOI18N
            properties[PROPERTY_acceptButtonText].setPreferred ( true );
            properties[PROPERTY_acceptButtonText].setShortDescription ( "The text for the accept button." );
            properties[PROPERTY_acceptButtonText].setBound ( true );
            properties[PROPERTY_acceptButtonTextSet] = new PropertyDescriptor ( "acceptButtonTextSet", components.JListManipulator.class, "isAcceptButtonTextSet", null ); // NOI18N
            properties[PROPERTY_acceptButtonTextSet].setHidden ( true );
            properties[PROPERTY_acceptButtonToolTipText] = new PropertyDescriptor ( "acceptButtonToolTipText", components.JListManipulator.class, "getAcceptButtonToolTipText", "setAcceptButtonToolTipText" ); // NOI18N
            properties[PROPERTY_acceptButtonToolTipText].setPreferred ( true );
            properties[PROPERTY_acceptButtonToolTipText].setShortDescription ( "The tool tip text for the accept button." );
            properties[PROPERTY_acceptButtonToolTipText].setBound ( true );
            properties[PROPERTY_acceptButtonToolTipTextSet] = new PropertyDescriptor ( "acceptButtonToolTipTextSet", components.JListManipulator.class, "isAcceptButtonToolTipTextSet", null ); // NOI18N
            properties[PROPERTY_acceptButtonToolTipTextSet].setHidden ( true );
            properties[PROPERTY_accessibleContext] = new PropertyDescriptor ( "accessibleContext", components.JListManipulator.class, "getAccessibleContext", null ); // NOI18N
            properties[PROPERTY_accessibleContext].setHidden ( true );
            properties[PROPERTY_actionListeners] = new PropertyDescriptor ( "actionListeners", components.JListManipulator.class, "getActionListeners", null ); // NOI18N
            properties[PROPERTY_actionListeners].setHidden ( true );
            properties[PROPERTY_actionMap] = new PropertyDescriptor ( "actionMap", components.JListManipulator.class, "getActionMap", "setActionMap" ); // NOI18N
            properties[PROPERTY_actionMap].setHidden ( true );
            properties[PROPERTY_alignmentX] = new PropertyDescriptor ( "alignmentX", components.JListManipulator.class, "getAlignmentX", "setAlignmentX" ); // NOI18N
            properties[PROPERTY_alignmentX].setShortDescription ( "The preferred horizontal alignment of the component." );
            properties[PROPERTY_alignmentY] = new PropertyDescriptor ( "alignmentY", components.JListManipulator.class, "getAlignmentY", "setAlignmentY" ); // NOI18N
            properties[PROPERTY_alignmentY].setShortDescription ( "The preferred vertical alignment of the component." );
            properties[PROPERTY_ancestorListeners] = new PropertyDescriptor ( "ancestorListeners", components.JListManipulator.class, "getAncestorListeners", null ); // NOI18N
            properties[PROPERTY_ancestorListeners].setHidden ( true );
            properties[PROPERTY_anchorSelectionIndex] = new PropertyDescriptor ( "anchorSelectionIndex", components.JListManipulator.class, "getAnchorSelectionIndex", null ); // NOI18N
            properties[PROPERTY_autoscrolls] = new PropertyDescriptor ( "autoscrolls", components.JListManipulator.class, "getAutoscrolls", "setAutoscrolls" ); // NOI18N
            properties[PROPERTY_autoscrolls].setShortDescription ( "Determines if this component automatically scrolls its contents when dragged." );
            properties[PROPERTY_background] = new PropertyDescriptor ( "background", components.JListManipulator.class, "getBackground", "setBackground" ); // NOI18N
            properties[PROPERTY_background].setPreferred ( true );
            properties[PROPERTY_background].setShortDescription ( "The background color of the component." );
            properties[PROPERTY_background].setBound ( true );
            properties[PROPERTY_backgroundSet] = new PropertyDescriptor ( "backgroundSet", components.JListManipulator.class, "isBackgroundSet", null ); // NOI18N
            properties[PROPERTY_backgroundSet].setHidden ( true );
            properties[PROPERTY_baselineResizeBehavior] = new PropertyDescriptor ( "baselineResizeBehavior", components.JListManipulator.class, "getBaselineResizeBehavior", null ); // NOI18N
            properties[PROPERTY_baselineResizeBehavior].setHidden ( true );
            properties[PROPERTY_border] = new PropertyDescriptor ( "border", components.JListManipulator.class, "getBorder", "setBorder" ); // NOI18N
            properties[PROPERTY_border].setShortDescription ( "The component's border." );
            properties[PROPERTY_border].setBound ( true );
            properties[PROPERTY_bottomAccessory] = new PropertyDescriptor ( "bottomAccessory", components.JListManipulator.class, "getBottomAccessory", "setBottomAccessory" ); // NOI18N
            properties[PROPERTY_bottomAccessory].setPreferred ( true );
            properties[PROPERTY_bottomAccessory].setShortDescription ( "The accessory component to display at the bottom of the panel." );
            properties[PROPERTY_bottomAccessory].setBound ( true );
            properties[PROPERTY_bounds] = new PropertyDescriptor ( "bounds", components.JListManipulator.class, "getBounds", "setBounds" ); // NOI18N
            properties[PROPERTY_bounds].setHidden ( true );
            properties[PROPERTY_cancelButton] = new PropertyDescriptor ( "cancelButton", components.JListManipulator.class, "getCancelButton", null ); // NOI18N
            properties[PROPERTY_cancelButton].setHidden ( true );
            properties[PROPERTY_cancelButtonMnemonic] = new PropertyDescriptor ( "cancelButtonMnemonic", components.JListManipulator.class, "getCancelButtonMnemonic", "setCancelButtonMnemonic" ); // NOI18N
            properties[PROPERTY_cancelButtonMnemonic].setShortDescription ( "The keyboard character mnemonic for the cancel button." );
            properties[PROPERTY_cancelButtonMnemonic].setBound ( true );
            properties[PROPERTY_cancelButtonMnemonicSet] = new PropertyDescriptor ( "cancelButtonMnemonicSet", components.JListManipulator.class, "isCancelButtonMnemonicSet", null ); // NOI18N
            properties[PROPERTY_cancelButtonMnemonicSet].setHidden ( true );
            properties[PROPERTY_cancelButtonText] = new PropertyDescriptor ( "cancelButtonText", components.JListManipulator.class, "getCancelButtonText", "setCancelButtonText" ); // NOI18N
            properties[PROPERTY_cancelButtonText].setShortDescription ( "The text for the cancel button." );
            properties[PROPERTY_cancelButtonText].setBound ( true );
            properties[PROPERTY_cancelButtonTextSet] = new PropertyDescriptor ( "cancelButtonTextSet", components.JListManipulator.class, "isCancelButtonTextSet", null ); // NOI18N
            properties[PROPERTY_cancelButtonTextSet].setHidden ( true );
            properties[PROPERTY_cancelButtonToolTipText] = new PropertyDescriptor ( "cancelButtonToolTipText", components.JListManipulator.class, "getCancelButtonToolTipText", "setCancelButtonToolTipText" ); // NOI18N
            properties[PROPERTY_cancelButtonToolTipText].setShortDescription ( "The tool tip text for the cancel button." );
            properties[PROPERTY_cancelButtonToolTipText].setBound ( true );
            properties[PROPERTY_cancelButtonToolTipTextSet] = new PropertyDescriptor ( "cancelButtonToolTipTextSet", components.JListManipulator.class, "isCancelButtonToolTipTextSet", null ); // NOI18N
            properties[PROPERTY_cancelButtonToolTipTextSet].setHidden ( true );
            properties[PROPERTY_cellRenderer] = new PropertyDescriptor ( "cellRenderer", components.JListManipulator.class, "getCellRenderer", "setCellRenderer" ); // NOI18N
            properties[PROPERTY_cellRenderer].setShortDescription ( "The component used to draw the cells in the list." );
            properties[PROPERTY_cellRenderer].setBound ( true );
            properties[PROPERTY_colorModel] = new PropertyDescriptor ( "colorModel", components.JListManipulator.class, "getColorModel", null ); // NOI18N
            properties[PROPERTY_colorModel].setHidden ( true );
            properties[PROPERTY_component] = new IndexedPropertyDescriptor ( "component", components.JListManipulator.class, null, null, "getComponent", null ); // NOI18N
            properties[PROPERTY_component].setHidden ( true );
            properties[PROPERTY_componentCount] = new PropertyDescriptor ( "componentCount", components.JListManipulator.class, "getComponentCount", null ); // NOI18N
            properties[PROPERTY_componentCount].setHidden ( true );
            properties[PROPERTY_componentListeners] = new PropertyDescriptor ( "componentListeners", components.JListManipulator.class, "getComponentListeners", null ); // NOI18N
            properties[PROPERTY_componentListeners].setHidden ( true );
            properties[PROPERTY_componentOrientation] = new PropertyDescriptor ( "componentOrientation", components.JListManipulator.class, "getComponentOrientation", "setComponentOrientation" ); // NOI18N
            properties[PROPERTY_componentOrientation].setHidden ( true );
            properties[PROPERTY_componentPopupMenu] = new PropertyDescriptor ( "componentPopupMenu", components.JListManipulator.class, "getComponentPopupMenu", "setComponentPopupMenu" ); // NOI18N
            properties[PROPERTY_componentPopupMenu].setShortDescription ( "The popup menu to show" );
            properties[PROPERTY_componentPopupMenu].setBound ( true );
            properties[PROPERTY_components] = new PropertyDescriptor ( "components", components.JListManipulator.class, "getComponents", null ); // NOI18N
            properties[PROPERTY_components].setHidden ( true );
            properties[PROPERTY_containerListeners] = new PropertyDescriptor ( "containerListeners", components.JListManipulator.class, "getContainerListeners", null ); // NOI18N
            properties[PROPERTY_containerListeners].setHidden ( true );
            properties[PROPERTY_controlButtonsAreShown] = new PropertyDescriptor ( "controlButtonsAreShown", components.JListManipulator.class, "getControlButtonsAreShown", "setControlButtonsAreShown" ); // NOI18N
            properties[PROPERTY_controlButtonsAreShown].setShortDescription ( "Sets whether the control buttons are shown." );
            properties[PROPERTY_controlButtonsAreShown].setBound ( true );
            properties[PROPERTY_cursor] = new PropertyDescriptor ( "cursor", components.JListManipulator.class, "getCursor", "setCursor" ); // NOI18N
            properties[PROPERTY_cursorSet] = new PropertyDescriptor ( "cursorSet", components.JListManipulator.class, "isCursorSet", null ); // NOI18N
            properties[PROPERTY_cursorSet].setHidden ( true );
            properties[PROPERTY_debugGraphicsOptions] = new PropertyDescriptor ( "debugGraphicsOptions", components.JListManipulator.class, "getDebugGraphicsOptions", "setDebugGraphicsOptions" ); // NOI18N
            properties[PROPERTY_debugGraphicsOptions].setShortDescription ( "Diagnostic options for graphics operations." );
            properties[PROPERTY_dialogTitle] = new PropertyDescriptor ( "dialogTitle", components.JListManipulator.class, "getDialogTitle", "setDialogTitle" ); // NOI18N
            properties[PROPERTY_dialogTitle].setPreferred ( true );
            properties[PROPERTY_dialogTitle].setShortDescription ( "The title of the JListManipulator dialog window." );
            properties[PROPERTY_dialogTitle].setBound ( true );
            properties[PROPERTY_displayable] = new PropertyDescriptor ( "displayable", components.JListManipulator.class, "isDisplayable", null ); // NOI18N
            properties[PROPERTY_displayable].setHidden ( true );
            properties[PROPERTY_doubleBuffered] = new PropertyDescriptor ( "doubleBuffered", components.JListManipulator.class, "isDoubleBuffered", "setDoubleBuffered" ); // NOI18N
            properties[PROPERTY_dropTarget] = new PropertyDescriptor ( "dropTarget", components.JListManipulator.class, "getDropTarget", "setDropTarget" ); // NOI18N
            properties[PROPERTY_dropTarget].setHidden ( true );
            properties[PROPERTY_enabled] = new PropertyDescriptor ( "enabled", components.JListManipulator.class, "isEnabled", "setEnabled" ); // NOI18N
            properties[PROPERTY_enabled].setShortDescription ( "The enabled state of the component." );
            properties[PROPERTY_enabled].setBound ( true );
            properties[PROPERTY_firstVisibleIndex] = new PropertyDescriptor ( "firstVisibleIndex", components.JListManipulator.class, "getFirstVisibleIndex", null ); // NOI18N
            properties[PROPERTY_fixedCellHeight] = new PropertyDescriptor ( "fixedCellHeight", components.JListManipulator.class, "getFixedCellHeight", "setFixedCellHeight" ); // NOI18N
            properties[PROPERTY_fixedCellHeight].setShortDescription ( "Sets a fixed cell height when this is greater than zero." );
            properties[PROPERTY_fixedCellHeight].setBound ( true );
            properties[PROPERTY_fixedCellWidth] = new PropertyDescriptor ( "fixedCellWidth", components.JListManipulator.class, "getFixedCellWidth", "setFixedCellWidth" ); // NOI18N
            properties[PROPERTY_fixedCellWidth].setShortDescription ( "Sets a fixed cell width when this is greater than zero." );
            properties[PROPERTY_fixedCellWidth].setBound ( true );
            properties[PROPERTY_focusable] = new PropertyDescriptor ( "focusable", components.JListManipulator.class, "isFocusable", "setFocusable" ); // NOI18N
            properties[PROPERTY_focusCycleRoot] = new PropertyDescriptor ( "focusCycleRoot", components.JListManipulator.class, "isFocusCycleRoot", "setFocusCycleRoot" ); // NOI18N
            properties[PROPERTY_focusCycleRootAncestor] = new PropertyDescriptor ( "focusCycleRootAncestor", components.JListManipulator.class, "getFocusCycleRootAncestor", null ); // NOI18N
            properties[PROPERTY_focusCycleRootAncestor].setHidden ( true );
            properties[PROPERTY_focusListeners] = new PropertyDescriptor ( "focusListeners", components.JListManipulator.class, "getFocusListeners", null ); // NOI18N
            properties[PROPERTY_focusListeners].setHidden ( true );
            properties[PROPERTY_focusOwner] = new PropertyDescriptor ( "focusOwner", components.JListManipulator.class, "isFocusOwner", null ); // NOI18N
            properties[PROPERTY_focusOwner].setHidden ( true );
            properties[PROPERTY_focusTraversable] = new PropertyDescriptor ( "focusTraversable", components.JListManipulator.class, "isFocusTraversable", null ); // NOI18N
            properties[PROPERTY_focusTraversable].setHidden ( true );
            properties[PROPERTY_focusTraversalKeys] = new IndexedPropertyDescriptor ( "focusTraversalKeys", components.JListManipulator.class, null, null, null, "setFocusTraversalKeys" ); // NOI18N
            properties[PROPERTY_focusTraversalKeys].setHidden ( true );
            properties[PROPERTY_focusTraversalKeysEnabled] = new PropertyDescriptor ( "focusTraversalKeysEnabled", components.JListManipulator.class, "getFocusTraversalKeysEnabled", "setFocusTraversalKeysEnabled" ); // NOI18N
            properties[PROPERTY_focusTraversalKeysEnabled].setHidden ( true );
            properties[PROPERTY_focusTraversalPolicy] = new PropertyDescriptor ( "focusTraversalPolicy", components.JListManipulator.class, "getFocusTraversalPolicy", "setFocusTraversalPolicy" ); // NOI18N
            properties[PROPERTY_focusTraversalPolicyProvider] = new PropertyDescriptor ( "focusTraversalPolicyProvider", components.JListManipulator.class, "isFocusTraversalPolicyProvider", "setFocusTraversalPolicyProvider" ); // NOI18N
            properties[PROPERTY_focusTraversalPolicySet] = new PropertyDescriptor ( "focusTraversalPolicySet", components.JListManipulator.class, "isFocusTraversalPolicySet", null ); // NOI18N
            properties[PROPERTY_focusTraversalPolicySet].setHidden ( true );
            properties[PROPERTY_font] = new PropertyDescriptor ( "font", components.JListManipulator.class, "getFont", "setFont" ); // NOI18N
            properties[PROPERTY_font].setPreferred ( true );
            properties[PROPERTY_font].setShortDescription ( "The font for the component." );
            properties[PROPERTY_font].setBound ( true );
            properties[PROPERTY_fontSet] = new PropertyDescriptor ( "fontSet", components.JListManipulator.class, "isFontSet", null ); // NOI18N
            properties[PROPERTY_fontSet].setHidden ( true );
            properties[PROPERTY_foreground] = new PropertyDescriptor ( "foreground", components.JListManipulator.class, "getForeground", "setForeground" ); // NOI18N
            properties[PROPERTY_foreground].setPreferred ( true );
            properties[PROPERTY_foreground].setShortDescription ( "The foreground color of the component." );
            properties[PROPERTY_foreground].setBound ( true );
            properties[PROPERTY_foregroundSet] = new PropertyDescriptor ( "foregroundSet", components.JListManipulator.class, "isForegroundSet", null ); // NOI18N
            properties[PROPERTY_foregroundSet].setHidden ( true );
            properties[PROPERTY_graphics] = new PropertyDescriptor ( "graphics", components.JListManipulator.class, "getGraphics", null ); // NOI18N
            properties[PROPERTY_graphics].setHidden ( true );
            properties[PROPERTY_graphicsConfiguration] = new PropertyDescriptor ( "graphicsConfiguration", components.JListManipulator.class, "getGraphicsConfiguration", null ); // NOI18N
            properties[PROPERTY_graphicsConfiguration].setHidden ( true );
            properties[PROPERTY_height] = new PropertyDescriptor ( "height", components.JListManipulator.class, "getHeight", null ); // NOI18N
            properties[PROPERTY_height].setHidden ( true );
            properties[PROPERTY_hierarchyBoundsListeners] = new PropertyDescriptor ( "hierarchyBoundsListeners", components.JListManipulator.class, "getHierarchyBoundsListeners", null ); // NOI18N
            properties[PROPERTY_hierarchyBoundsListeners].setHidden ( true );
            properties[PROPERTY_hierarchyListeners] = new PropertyDescriptor ( "hierarchyListeners", components.JListManipulator.class, "getHierarchyListeners", null ); // NOI18N
            properties[PROPERTY_hierarchyListeners].setHidden ( true );
            properties[PROPERTY_iconsAreShown] = new PropertyDescriptor ( "iconsAreShown", components.JListManipulator.class, "getIconsAreShown", "setIconsAreShown" ); // NOI18N
            properties[PROPERTY_iconsAreShown].setPreferred ( true );
            properties[PROPERTY_iconsAreShown].setShortDescription ( "Sets whether using icons should be favored over using text to denote an action." );
            properties[PROPERTY_iconsAreShown].setBound ( true );
            properties[PROPERTY_ignoreRepaint] = new PropertyDescriptor ( "ignoreRepaint", components.JListManipulator.class, "getIgnoreRepaint", "setIgnoreRepaint" ); // NOI18N
            properties[PROPERTY_ignoreRepaint].setHidden ( true );
            properties[PROPERTY_inheritsPopupMenu] = new PropertyDescriptor ( "inheritsPopupMenu", components.JListManipulator.class, "getInheritsPopupMenu", "setInheritsPopupMenu" ); // NOI18N
            properties[PROPERTY_inheritsPopupMenu].setShortDescription ( "Whether or not the JPopupMenu is inherited" );
            properties[PROPERTY_inheritsPopupMenu].setBound ( true );
            properties[PROPERTY_inputContext] = new PropertyDescriptor ( "inputContext", components.JListManipulator.class, "getInputContext", null ); // NOI18N
            properties[PROPERTY_inputContext].setHidden ( true );
            properties[PROPERTY_inputMap] = new PropertyDescriptor ( "inputMap", components.JListManipulator.class, "getInputMap", null ); // NOI18N
            properties[PROPERTY_inputMap].setHidden ( true );
            properties[PROPERTY_inputMethodListeners] = new PropertyDescriptor ( "inputMethodListeners", components.JListManipulator.class, "getInputMethodListeners", null ); // NOI18N
            properties[PROPERTY_inputMethodListeners].setHidden ( true );
            properties[PROPERTY_inputMethodRequests] = new PropertyDescriptor ( "inputMethodRequests", components.JListManipulator.class, "getInputMethodRequests", null ); // NOI18N
            properties[PROPERTY_inputMethodRequests].setHidden ( true );
            properties[PROPERTY_inputVerifier] = new PropertyDescriptor ( "inputVerifier", components.JListManipulator.class, "getInputVerifier", "setInputVerifier" ); // NOI18N
            properties[PROPERTY_inputVerifier].setShortDescription ( "The component's input verifier." );
            properties[PROPERTY_insets] = new PropertyDescriptor ( "insets", components.JListManipulator.class, "getInsets", null ); // NOI18N
            properties[PROPERTY_insets].setExpert ( true );
            properties[PROPERTY_keyListeners] = new PropertyDescriptor ( "keyListeners", components.JListManipulator.class, "getKeyListeners", null ); // NOI18N
            properties[PROPERTY_keyListeners].setHidden ( true );
            properties[PROPERTY_lastVisibleIndex] = new PropertyDescriptor ( "lastVisibleIndex", components.JListManipulator.class, "getLastVisibleIndex", null ); // NOI18N
            properties[PROPERTY_layout] = new PropertyDescriptor ( "layout", components.JListManipulator.class, "getLayout", "setLayout" ); // NOI18N
            properties[PROPERTY_layout].setHidden ( true );
            properties[PROPERTY_layoutOrientation] = new PropertyDescriptor ( "layoutOrientation", components.JListManipulator.class, "getLayoutOrientation", "setLayoutOrientation" ); // NOI18N
            properties[PROPERTY_layoutOrientation].setShortDescription ( "Sets how the cells in the list are layed out." );
            properties[PROPERTY_layoutOrientation].setBound ( true );
            properties[PROPERTY_layoutOrientation].setPropertyEditorClass ( components.JListSelectorBeanInfo.ListLayoutOrientationEditor.class );
            properties[PROPERTY_leadSelectionIndex] = new PropertyDescriptor ( "leadSelectionIndex", components.JListManipulator.class, "getLeadSelectionIndex", null ); // NOI18N
            properties[PROPERTY_lightweight] = new PropertyDescriptor ( "lightweight", components.JListManipulator.class, "isLightweight", null ); // NOI18N
            properties[PROPERTY_lightweight].setHidden ( true );
            properties[PROPERTY_list] = new PropertyDescriptor ( "list", components.JListManipulator.class, "getList", null ); // NOI18N
            properties[PROPERTY_list].setHidden ( true );
            properties[PROPERTY_listAutoscrolls] = new PropertyDescriptor ( "listAutoscrolls", components.JListManipulator.class, "getListAutoscrolls", "setListAutoscrolls" ); // NOI18N
            properties[PROPERTY_listAutoscrolls].setShortDescription ( "Determines if the internal list automatically scrolls its contents when dragged." );
            properties[PROPERTY_listBackground] = new PropertyDescriptor ( "listBackground", components.JListManipulator.class, "getListBackground", "setListBackground" ); // NOI18N
            properties[PROPERTY_listBackground].setShortDescription ( "The background color of the list." );
            properties[PROPERTY_listBackground].setBound ( true );
            properties[PROPERTY_listData] = new PropertyDescriptor ( "listData", components.JListManipulator.class, null, "setListData" ); // NOI18N
            properties[PROPERTY_listData].setHidden ( true );
            properties[PROPERTY_listDataListeners] = new PropertyDescriptor ( "listDataListeners", components.JListManipulator.class, "getListDataListeners", null ); // NOI18N
            properties[PROPERTY_listDataListeners].setHidden ( true );
            properties[PROPERTY_listSelectionListeners] = new PropertyDescriptor ( "listSelectionListeners", components.JListManipulator.class, "getListSelectionListeners", null ); // NOI18N
            properties[PROPERTY_listSelectionListeners].setHidden ( true );
            properties[PROPERTY_listTitle] = new PropertyDescriptor ( "listTitle", components.JListManipulator.class, "getListTitle", "setListTitle" ); // NOI18N
            properties[PROPERTY_listTitle].setPreferred ( true );
            properties[PROPERTY_listTitle].setShortDescription ( "The title to display above the list." );
            properties[PROPERTY_listTitle].setBound ( true );
            properties[PROPERTY_locale] = new PropertyDescriptor ( "locale", components.JListManipulator.class, "getLocale", "setLocale" ); // NOI18N
            properties[PROPERTY_locale].setHidden ( true );
            properties[PROPERTY_location] = new PropertyDescriptor ( "location", components.JListManipulator.class, "getLocation", "setLocation" ); // NOI18N
            properties[PROPERTY_location].setHidden ( true );
            properties[PROPERTY_locationOnScreen] = new PropertyDescriptor ( "locationOnScreen", components.JListManipulator.class, "getLocationOnScreen", null ); // NOI18N
            properties[PROPERTY_locationOnScreen].setHidden ( true );
            properties[PROPERTY_managingFocus] = new PropertyDescriptor ( "managingFocus", components.JListManipulator.class, "isManagingFocus", null ); // NOI18N
            properties[PROPERTY_managingFocus].setHidden ( true );
            properties[PROPERTY_maximumSize] = new PropertyDescriptor ( "maximumSize", components.JListManipulator.class, "getMaximumSize", "setMaximumSize" ); // NOI18N
            properties[PROPERTY_maximumSize].setShortDescription ( "The maximum size of the component." );
            properties[PROPERTY_maximumSize].setBound ( true );
            properties[PROPERTY_maximumSizeSet] = new PropertyDescriptor ( "maximumSizeSet", components.JListManipulator.class, "isMaximumSizeSet", null ); // NOI18N
            properties[PROPERTY_maximumSizeSet].setHidden ( true );
            properties[PROPERTY_maxSelectionIndex] = new PropertyDescriptor ( "maxSelectionIndex", components.JListManipulator.class, "getMaxSelectionIndex", null ); // NOI18N
            properties[PROPERTY_minimumSize] = new PropertyDescriptor ( "minimumSize", components.JListManipulator.class, "getMinimumSize", "setMinimumSize" ); // NOI18N
            properties[PROPERTY_minimumSize].setShortDescription ( "The minimum size of the component." );
            properties[PROPERTY_minimumSize].setBound ( true );
            properties[PROPERTY_minimumSizeSet] = new PropertyDescriptor ( "minimumSizeSet", components.JListManipulator.class, "isMinimumSizeSet", null ); // NOI18N
            properties[PROPERTY_minimumSizeSet].setHidden ( true );
            properties[PROPERTY_minSelectionIndex] = new PropertyDescriptor ( "minSelectionIndex", components.JListManipulator.class, "getMinSelectionIndex", null ); // NOI18N
            properties[PROPERTY_mixingCutoutShape] = new PropertyDescriptor ( "mixingCutoutShape", components.JListManipulator.class, null, "setMixingCutoutShape" ); // NOI18N
            properties[PROPERTY_mixingCutoutShape].setHidden ( true );
            properties[PROPERTY_model] = new PropertyDescriptor ( "model", components.JListManipulator.class, "getModel", "setModel" ); // NOI18N
            properties[PROPERTY_model].setPreferred ( true );
            properties[PROPERTY_model].setShortDescription ( "The model used to contain the data to be in the list." );
            properties[PROPERTY_model].setBound ( true );
            properties[PROPERTY_modelList] = new PropertyDescriptor ( "modelList", components.JListManipulator.class, "getModelList", null ); // NOI18N
            properties[PROPERTY_modelList].setHidden ( true );
            properties[PROPERTY_mouseListeners] = new PropertyDescriptor ( "mouseListeners", components.JListManipulator.class, "getMouseListeners", null ); // NOI18N
            properties[PROPERTY_mouseListeners].setHidden ( true );
            properties[PROPERTY_mouseMotionListeners] = new PropertyDescriptor ( "mouseMotionListeners", components.JListManipulator.class, "getMouseMotionListeners", null ); // NOI18N
            properties[PROPERTY_mouseMotionListeners].setHidden ( true );
            properties[PROPERTY_mousePosition] = new PropertyDescriptor ( "mousePosition", components.JListManipulator.class, "getMousePosition", null ); // NOI18N
            properties[PROPERTY_mousePosition].setHidden ( true );
            properties[PROPERTY_mouseWheelListeners] = new PropertyDescriptor ( "mouseWheelListeners", components.JListManipulator.class, "getMouseWheelListeners", null ); // NOI18N
            properties[PROPERTY_mouseWheelListeners].setHidden ( true );
            properties[PROPERTY_moveBackwardButton] = new PropertyDescriptor ( "moveBackwardButton", components.JListManipulator.class, "getMoveBackwardButton", null ); // NOI18N
            properties[PROPERTY_moveBackwardButton].setHidden ( true );
            properties[PROPERTY_moveButtonsAreShown] = new PropertyDescriptor ( "moveButtonsAreShown", components.JListManipulator.class, "getMoveButtonsAreShown", "setMoveButtonsAreShown" ); // NOI18N
            properties[PROPERTY_moveButtonsAreShown].setPreferred ( true );
            properties[PROPERTY_moveButtonsAreShown].setShortDescription ( "Sets whether the move forward and move backward buttons should be shown." );
            properties[PROPERTY_moveButtonsAreShown].setBound ( true );
            properties[PROPERTY_moveForwardButton] = new PropertyDescriptor ( "moveForwardButton", components.JListManipulator.class, "getMoveForwardButton", null ); // NOI18N
            properties[PROPERTY_moveForwardButton].setHidden ( true );
            properties[PROPERTY_name] = new PropertyDescriptor ( "name", components.JListManipulator.class, "getName", "setName" ); // NOI18N
            properties[PROPERTY_name].setBound ( true );
            properties[PROPERTY_nextFocusableComponent] = new PropertyDescriptor ( "nextFocusableComponent", components.JListManipulator.class, "getNextFocusableComponent", "setNextFocusableComponent" ); // NOI18N
            properties[PROPERTY_opaque] = new PropertyDescriptor ( "opaque", components.JListManipulator.class, "isOpaque", "setOpaque" ); // NOI18N
            properties[PROPERTY_opaque].setShortDescription ( "The component's opacity" );
            properties[PROPERTY_optimizedDrawingEnabled] = new PropertyDescriptor ( "optimizedDrawingEnabled", components.JListManipulator.class, "isOptimizedDrawingEnabled", null ); // NOI18N
            properties[PROPERTY_optimizedDrawingEnabled].setHidden ( true );
            properties[PROPERTY_paintingForPrint] = new PropertyDescriptor ( "paintingForPrint", components.JListManipulator.class, "isPaintingForPrint", null ); // NOI18N
            properties[PROPERTY_paintingTile] = new PropertyDescriptor ( "paintingTile", components.JListManipulator.class, "isPaintingTile", null ); // NOI18N
            properties[PROPERTY_paintingTile].setHidden ( true );
            properties[PROPERTY_parent] = new PropertyDescriptor ( "parent", components.JListManipulator.class, "getParent", null ); // NOI18N
            properties[PROPERTY_parent].setHidden ( true );
            properties[PROPERTY_preferredSize] = new PropertyDescriptor ( "preferredSize", components.JListManipulator.class, "getPreferredSize", "setPreferredSize" ); // NOI18N
            properties[PROPERTY_preferredSize].setShortDescription ( "The preferred size of the component." );
            properties[PROPERTY_preferredSize].setBound ( true );
            properties[PROPERTY_preferredSizeSet] = new PropertyDescriptor ( "preferredSizeSet", components.JListManipulator.class, "isPreferredSizeSet", null ); // NOI18N
            properties[PROPERTY_preferredSizeSet].setHidden ( true );
            properties[PROPERTY_propertyChangeListeners] = new PropertyDescriptor ( "propertyChangeListeners", components.JListManipulator.class, "getPropertyChangeListeners", null ); // NOI18N
            properties[PROPERTY_propertyChangeListeners].setHidden ( true );
            properties[PROPERTY_prototypeCellValue] = new PropertyDescriptor ( "prototypeCellValue", components.JListManipulator.class, "getPrototypeCellValue", "setPrototypeCellValue" ); // NOI18N
            properties[PROPERTY_prototypeCellValue].setShortDescription ( "The cell prototype value used to calculate the cell width and height." );
            properties[PROPERTY_prototypeCellValue].setBound ( true );
            properties[PROPERTY_registeredKeyStrokes] = new PropertyDescriptor ( "registeredKeyStrokes", components.JListManipulator.class, "getRegisteredKeyStrokes", null ); // NOI18N
            properties[PROPERTY_registeredKeyStrokes].setHidden ( true );
            properties[PROPERTY_removeButton] = new PropertyDescriptor ( "removeButton", components.JListManipulator.class, "getRemoveButton", null ); // NOI18N
            properties[PROPERTY_removeButton].setHidden ( true );
            properties[PROPERTY_removeButtonIsShown] = new PropertyDescriptor ( "removeButtonIsShown", components.JListManipulator.class, "getRemoveButtonIsShown", "setRemoveButtonIsShown" ); // NOI18N
            properties[PROPERTY_removeButtonIsShown].setPreferred ( true );
            properties[PROPERTY_removeButtonIsShown].setShortDescription ( "Sets whether the remove button should be shown." );
            properties[PROPERTY_removeButtonIsShown].setBound ( true );
            properties[PROPERTY_requestFocusEnabled] = new PropertyDescriptor ( "requestFocusEnabled", components.JListManipulator.class, "isRequestFocusEnabled", "setRequestFocusEnabled" ); // NOI18N
            properties[PROPERTY_resetButton] = new PropertyDescriptor ( "resetButton", components.JListManipulator.class, "getResetButton", null ); // NOI18N
            properties[PROPERTY_resetButton].setHidden ( true );
            properties[PROPERTY_resetButtonIsShown] = new PropertyDescriptor ( "resetButtonIsShown", components.JListManipulator.class, "getResetButtonIsShown", "setResetButtonIsShown" ); // NOI18N
            properties[PROPERTY_resetButtonIsShown].setPreferred ( true );
            properties[PROPERTY_resetButtonIsShown].setShortDescription ( "Sets whether the reset button should be shown." );
            properties[PROPERTY_resetButtonIsShown].setBound ( true );
            properties[PROPERTY_reverseButton] = new PropertyDescriptor ( "reverseButton", components.JListManipulator.class, "getReverseButton", null ); // NOI18N
            properties[PROPERTY_reverseButton].setHidden ( true );
            properties[PROPERTY_reverseButtonIsShown] = new PropertyDescriptor ( "reverseButtonIsShown", components.JListManipulator.class, "getReverseButtonIsShown", "setReverseButtonIsShown" ); // NOI18N
            properties[PROPERTY_reverseButtonIsShown].setPreferred ( true );
            properties[PROPERTY_reverseButtonIsShown].setShortDescription ( "Sets whether the reverse button should be shown." );
            properties[PROPERTY_reverseButtonIsShown].setBound ( true );
            properties[PROPERTY_rootPane] = new PropertyDescriptor ( "rootPane", components.JListManipulator.class, "getRootPane", null ); // NOI18N
            properties[PROPERTY_rootPane].setHidden ( true );
            properties[PROPERTY_scrollPane] = new PropertyDescriptor ( "scrollPane", components.JListManipulator.class, "getScrollPane", null ); // NOI18N
            properties[PROPERTY_scrollPane].setHidden ( true );
            properties[PROPERTY_selectedIndex] = new PropertyDescriptor ( "selectedIndex", components.JListManipulator.class, "getSelectedIndex", "setSelectedIndex" ); // NOI18N
            properties[PROPERTY_selectedIndex].setShortDescription ( "The index of the currently selected cell." );
            properties[PROPERTY_selectedIndices] = new PropertyDescriptor ( "selectedIndices", components.JListManipulator.class, "getSelectedIndices", "setSelectedIndices" ); // NOI18N
            properties[PROPERTY_selectedItemsCount] = new PropertyDescriptor ( "selectedItemsCount", components.JListManipulator.class, "getSelectedItemsCount", null ); // NOI18N
            properties[PROPERTY_selectedItemsCount].setHidden ( true );
            properties[PROPERTY_selectedValue] = new PropertyDescriptor ( "selectedValue", components.JListManipulator.class, "getSelectedValue", null ); // NOI18N
            properties[PROPERTY_selectedValuesList] = new PropertyDescriptor ( "selectedValuesList", components.JListManipulator.class, "getSelectedValuesList", null ); // NOI18N
            properties[PROPERTY_selectionBackground] = new PropertyDescriptor ( "selectionBackground", components.JListManipulator.class, "getSelectionBackground", "setSelectionBackground" ); // NOI18N
            properties[PROPERTY_selectionBackground].setShortDescription ( "The background color of selected cells in the list." );
            properties[PROPERTY_selectionBackground].setBound ( true );
            properties[PROPERTY_selectionEmpty] = new PropertyDescriptor ( "selectionEmpty", components.JListManipulator.class, "isSelectionEmpty", null ); // NOI18N
            properties[PROPERTY_selectionForeground] = new PropertyDescriptor ( "selectionForeground", components.JListManipulator.class, "getSelectionForeground", "setSelectionForeground" ); // NOI18N
            properties[PROPERTY_selectionForeground].setShortDescription ( "The foreground color of selected cells." );
            properties[PROPERTY_selectionForeground].setBound ( true );
            properties[PROPERTY_selectionInterval] = new IndexedPropertyDescriptor ( "selectionInterval", components.JListManipulator.class, null, null, null, "setSelectionInterval" ); // NOI18N
            properties[PROPERTY_selectionMode] = new PropertyDescriptor ( "selectionMode", components.JListManipulator.class, "getSelectionMode", "setSelectionMode" ); // NOI18N
            properties[PROPERTY_selectionMode].setPreferred ( true );
            properties[PROPERTY_selectionMode].setShortDescription ( "The list selection mode." );
            properties[PROPERTY_selectionMode].setPropertyEditorClass ( components.JListSelectorBeanInfo.ListSelectionModeEditor.class );
            properties[PROPERTY_selectionModel] = new PropertyDescriptor ( "selectionModel", components.JListManipulator.class, "getSelectionModel", "setSelectionModel" ); // NOI18N
            properties[PROPERTY_selectionModel].setShortDescription ( "The list selection model which records which cells are selected." );
            properties[PROPERTY_selectionModel].setBound ( true );
            properties[PROPERTY_shiftDistance] = new PropertyDescriptor ( "shiftDistance", components.JListManipulator.class, "getShiftDistance", "setShiftDistance" ); // NOI18N
            properties[PROPERTY_shiftDistance].setShortDescription ( "The amount by which selected items are moved when moving backwards or forwards." );
            properties[PROPERTY_shiftDistance].setBound ( true );
            properties[PROPERTY_showing] = new PropertyDescriptor ( "showing", components.JListManipulator.class, "isShowing", null ); // NOI18N
            properties[PROPERTY_showing].setHidden ( true );
            properties[PROPERTY_sideAccessory] = new PropertyDescriptor ( "sideAccessory", components.JListManipulator.class, "getSideAccessory", "setSideAccessory" ); // NOI18N
            properties[PROPERTY_sideAccessory].setPreferred ( true );
            properties[PROPERTY_sideAccessory].setShortDescription ( "The accessory component to display to the right of the list." );
            properties[PROPERTY_sideAccessory].setBound ( true );
            properties[PROPERTY_size] = new PropertyDescriptor ( "size", components.JListManipulator.class, "getSize", "setSize" ); // NOI18N
            properties[PROPERTY_size].setHidden ( true );
            properties[PROPERTY_toolkit] = new PropertyDescriptor ( "toolkit", components.JListManipulator.class, "getToolkit", null ); // NOI18N
            properties[PROPERTY_toolkit].setHidden ( true );
            properties[PROPERTY_toolTipText] = new PropertyDescriptor ( "toolTipText", components.JListManipulator.class, "getToolTipText", "setToolTipText" ); // NOI18N
            properties[PROPERTY_toolTipText].setPreferred ( true );
            properties[PROPERTY_toolTipText].setShortDescription ( "The text to display in a tool tip." );
            properties[PROPERTY_topLevelAncestor] = new PropertyDescriptor ( "topLevelAncestor", components.JListManipulator.class, "getTopLevelAncestor", null ); // NOI18N
            properties[PROPERTY_topLevelAncestor].setHidden ( true );
            properties[PROPERTY_transferHandler] = new PropertyDescriptor ( "transferHandler", components.JListManipulator.class, "getTransferHandler", "setTransferHandler" ); // NOI18N
            properties[PROPERTY_transferHandler].setHidden ( true );
            properties[PROPERTY_treeLock] = new PropertyDescriptor ( "treeLock", components.JListManipulator.class, "getTreeLock", null ); // NOI18N
            properties[PROPERTY_treeLock].setHidden ( true );
            properties[PROPERTY_UI] = new PropertyDescriptor ( "UI", components.JListManipulator.class, "getUI", "setUI" ); // NOI18N
            properties[PROPERTY_UI].setHidden ( true );
            properties[PROPERTY_UI].setShortDescription ( "The UI object that implements the Component's LookAndFeel." );
            properties[PROPERTY_UIClassID] = new PropertyDescriptor ( "UIClassID", components.JListManipulator.class, "getUIClassID", null ); // NOI18N
            properties[PROPERTY_valid] = new PropertyDescriptor ( "valid", components.JListManipulator.class, "isValid", null ); // NOI18N
            properties[PROPERTY_valid].setHidden ( true );
            properties[PROPERTY_validateRoot] = new PropertyDescriptor ( "validateRoot", components.JListManipulator.class, "isValidateRoot", null ); // NOI18N
            properties[PROPERTY_validateRoot].setHidden ( true );
            properties[PROPERTY_valueIsAdjusting] = new PropertyDescriptor ( "valueIsAdjusting", components.JListManipulator.class, "getValueIsAdjusting", "setValueIsAdjusting" ); // NOI18N
            properties[PROPERTY_verifyInputWhenFocusTarget] = new PropertyDescriptor ( "verifyInputWhenFocusTarget", components.JListManipulator.class, "getVerifyInputWhenFocusTarget", "setVerifyInputWhenFocusTarget" ); // NOI18N
            properties[PROPERTY_verifyInputWhenFocusTarget].setShortDescription ( "Whether the Component verifies input before accepting focus." );
            properties[PROPERTY_vetoableChangeListeners] = new PropertyDescriptor ( "vetoableChangeListeners", components.JListManipulator.class, "getVetoableChangeListeners", null ); // NOI18N
            properties[PROPERTY_vetoableChangeListeners].setHidden ( true );
            properties[PROPERTY_visible] = new PropertyDescriptor ( "visible", components.JListManipulator.class, "isVisible", "setVisible" ); // NOI18N
            properties[PROPERTY_visible].setHidden ( true );
            properties[PROPERTY_visibleRect] = new PropertyDescriptor ( "visibleRect", components.JListManipulator.class, "getVisibleRect", null ); // NOI18N
            properties[PROPERTY_visibleRect].setHidden ( true );
            properties[PROPERTY_visibleRowCount] = new PropertyDescriptor ( "visibleRowCount", components.JListManipulator.class, "getVisibleRowCount", "setVisibleRowCount" ); // NOI18N
            properties[PROPERTY_visibleRowCount].setShortDescription ( "The preferred number of rows to display without requiring scrolling the list." );
            properties[PROPERTY_visibleRowCount].setBound ( true );
            properties[PROPERTY_width] = new PropertyDescriptor ( "width", components.JListManipulator.class, "getWidth", null ); // NOI18N
            properties[PROPERTY_width].setHidden ( true );
            properties[PROPERTY_x] = new PropertyDescriptor ( "x", components.JListManipulator.class, "getX", null ); // NOI18N
            properties[PROPERTY_x].setHidden ( true );
            properties[PROPERTY_y] = new PropertyDescriptor ( "y", components.JListManipulator.class, "getY", null ); // NOI18N
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
    private static final int EVENT_listDataListener = 9;
    private static final int EVENT_listSelectionListener = 10;
    private static final int EVENT_mouseListener = 11;
    private static final int EVENT_mouseMotionListener = 12;
    private static final int EVENT_mouseWheelListener = 13;
    private static final int EVENT_propertyChangeListener = 14;
    private static final int EVENT_vetoableChangeListener = 15;

    // EventSet array
    /*lazy EventSetDescriptor*/
    private static EventSetDescriptor[] getEdescriptor(){
        EventSetDescriptor[] eventSets = new EventSetDescriptor[16];
    
        try {
            eventSets[EVENT_actionListener] = new EventSetDescriptor ( components.JListManipulator.class, "actionListener", java.awt.event.ActionListener.class, new String[] {"actionPerformed"}, "addActionListener", "removeActionListener" ); // NOI18N
            eventSets[EVENT_ancestorListener] = new EventSetDescriptor ( components.JListManipulator.class, "ancestorListener", javax.swing.event.AncestorListener.class, new String[] {"ancestorAdded", "ancestorRemoved", "ancestorMoved"}, "addAncestorListener", "removeAncestorListener" ); // NOI18N
            eventSets[EVENT_componentListener] = new EventSetDescriptor ( components.JListManipulator.class, "componentListener", java.awt.event.ComponentListener.class, new String[] {"componentResized", "componentMoved", "componentShown", "componentHidden"}, "addComponentListener", "removeComponentListener" ); // NOI18N
            eventSets[EVENT_containerListener] = new EventSetDescriptor ( components.JListManipulator.class, "containerListener", java.awt.event.ContainerListener.class, new String[] {"componentAdded", "componentRemoved"}, "addContainerListener", "removeContainerListener" ); // NOI18N
            eventSets[EVENT_focusListener] = new EventSetDescriptor ( components.JListManipulator.class, "focusListener", java.awt.event.FocusListener.class, new String[] {"focusGained", "focusLost"}, "addFocusListener", "removeFocusListener" ); // NOI18N
            eventSets[EVENT_hierarchyBoundsListener] = new EventSetDescriptor ( components.JListManipulator.class, "hierarchyBoundsListener", java.awt.event.HierarchyBoundsListener.class, new String[] {"ancestorMoved", "ancestorResized"}, "addHierarchyBoundsListener", "removeHierarchyBoundsListener" ); // NOI18N
            eventSets[EVENT_hierarchyListener] = new EventSetDescriptor ( components.JListManipulator.class, "hierarchyListener", java.awt.event.HierarchyListener.class, new String[] {"hierarchyChanged"}, "addHierarchyListener", "removeHierarchyListener" ); // NOI18N
            eventSets[EVENT_inputMethodListener] = new EventSetDescriptor ( components.JListManipulator.class, "inputMethodListener", java.awt.event.InputMethodListener.class, new String[] {"inputMethodTextChanged", "caretPositionChanged"}, "addInputMethodListener", "removeInputMethodListener" ); // NOI18N
            eventSets[EVENT_keyListener] = new EventSetDescriptor ( components.JListManipulator.class, "keyListener", java.awt.event.KeyListener.class, new String[] {"keyTyped", "keyPressed", "keyReleased"}, "addKeyListener", "removeKeyListener" ); // NOI18N
            eventSets[EVENT_listDataListener] = new EventSetDescriptor ( components.JListManipulator.class, "listDataListener", javax.swing.event.ListDataListener.class, new String[] {"intervalAdded", "intervalRemoved", "contentsChanged"}, "addListDataListener", "removeListDataListener" ); // NOI18N
            eventSets[EVENT_listSelectionListener] = new EventSetDescriptor ( components.JListManipulator.class, "listSelectionListener", javax.swing.event.ListSelectionListener.class, new String[] {"valueChanged"}, "addListSelectionListener", "removeListSelectionListener" ); // NOI18N
            eventSets[EVENT_mouseListener] = new EventSetDescriptor ( components.JListManipulator.class, "mouseListener", java.awt.event.MouseListener.class, new String[] {"mouseClicked", "mousePressed", "mouseReleased", "mouseEntered", "mouseExited"}, "addMouseListener", "removeMouseListener" ); // NOI18N
            eventSets[EVENT_mouseMotionListener] = new EventSetDescriptor ( components.JListManipulator.class, "mouseMotionListener", java.awt.event.MouseMotionListener.class, new String[] {"mouseDragged", "mouseMoved"}, "addMouseMotionListener", "removeMouseMotionListener" ); // NOI18N
            eventSets[EVENT_mouseWheelListener] = new EventSetDescriptor ( components.JListManipulator.class, "mouseWheelListener", java.awt.event.MouseWheelListener.class, new String[] {"mouseWheelMoved"}, "addMouseWheelListener", "removeMouseWheelListener" ); // NOI18N
            eventSets[EVENT_propertyChangeListener] = new EventSetDescriptor ( components.JListManipulator.class, "propertyChangeListener", java.beans.PropertyChangeListener.class, new String[] {"propertyChange"}, "addPropertyChangeListener", "removePropertyChangeListener" ); // NOI18N
            eventSets[EVENT_vetoableChangeListener] = new EventSetDescriptor ( components.JListManipulator.class, "vetoableChangeListener", java.beans.VetoableChangeListener.class, new String[] {"vetoableChange"}, "addVetoableChangeListener", "removeVetoableChangeListener" ); // NOI18N
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
     * This returns the image to use to represent JListManipulators.
     * @param iconKind The kind of icon to get.
     * @param resourceName The name for the resource to get the image from, or 
     * null.
     * @return The image representing a JListManipulator, or null if no suitable 
     * icon is available.
     * @see #getIcon(int) 
     * @see beans.BeanInfoIconFactory
     * @see beans.BeanInfoIconFactory#createIconImage(int, java.lang.String, java.beans.SimpleBeanInfo) 
     */
    private java.awt.Image createIcon(int iconKind, String resourceName){
        if (iconFactory == null)    // If the icon factory is not initialized yet
            iconFactory = new JListManipulatorIconFactory();
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
     * JListManipulator.
     */
    private static class JListManipulatorIconFactory extends 
            JListSelectorBeanInfo.JListSelectorIconFactory{
        /**
         * This stores the colors used for the remove button. The first value 
         * is the color to use for color icons and the second value is the color 
         * to use for monochrome icons.
         */
        static final java.awt.Color[] REMOVE_BUTTON_COLOR = {java.awt.Color.RED,
            java.awt.Color.GRAY};
        /**
         * This stores the values to use to draw the decorations on the four 
         * lines on the list that represent text. Each two-dimensional array in 
         * this three-dimensional array corresponds to a line. The first array 
         * in each of the two-dimensional arrays represent the location on the 
         * line where the decoration should be, while the second array in each 
         * of the two-dimensional arrays represent the length for that 
         * decoration. <p>
         * This an altered version of the {@link #LINE_DECORATION_VALUES} values 
         * used to account for the shorter lines due to the buttons.
         */
        static final int[][][] MANIPULATOR_LINE_DECORATION_VALUES = {
            {{4, 8, 11}, {2, 1, 2}},
            {{2, 4, 7, 9}, {1, 2, 1, 1}},
            {{1, 4, 6, 8, 11}, {2, 1, 1, 2, 1}},
            {{1, 4, 7}, {1, 2, 1}}
        };
        @Override
        protected int[][][] getLineDecorationValues(){
            return MANIPULATOR_LINE_DECORATION_VALUES;
        }
        @Override
        protected int getScrollBarWidth(int scale){
            return super.getScrollBarWidth(scale) - (scale%2);
        }
        @Override
        protected void paintDialogContents(java.awt.Graphics2D g, int scale, 
                int colorMode, int x, int y, int w, int h) {
                // This gets the width to use for the list, so as to accomodate 
            int listW = w-(2*scale);    // for the side buttons
            super.paintDialogContents(g, scale, colorMode, x, y, listW, h);
                // Draw the arrow buttons
            g.setColor(COMMON_INFO_ICON_COLORS[colorMode][1]);
            x += listW;
            y += scale;
                // A for loop to draw the two arrows
            for (int i = 0; i < 2; i++){
                if (scale == 2){    // If this is a 32x32 icon
                        // There's enough room for the arrows, so draw them
                    paintArrow(g, x, y, i != 0);
                    y+=5;
                }
                else{   // Draw dots to represent the arrows
                    g.fillRect(x, y, 1, 1);
                    y+=2;
                }
            }   // Draw the remove button
            g.setColor(REMOVE_BUTTON_COLOR[colorMode]);
            if (scale == 2){    // If this is a 32x32 icon
                    // There's enough room for the x
                g.drawLine(x, y, x+2, y+2);
                g.drawLine(x, y+2, x+2, y);
            }
            else{
                g.fillRect(x, y, 1, 1);
            }
        }
    }
}
