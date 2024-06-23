/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Beans/BeanInfo.java to edit this template
 */
package components;

import beans.BeanInfoIconFactory;
import beans.DialogBeanInfoIconFactory;
import java.beans.*;

/**
 * This is the beans info for JListSelector.
 * @author Milo Steier
 * @see JListSelector
 */
public class JListSelectorBeanInfo extends SimpleBeanInfo {

    // Bean descriptor//GEN-FIRST:BeanDescriptor
    /*lazy BeanDescriptor*/
    private static BeanDescriptor getBdescriptor(){
        BeanDescriptor beanDescriptor = new BeanDescriptor  ( components.JListSelector.class , null ); // NOI18N
        beanDescriptor.setShortDescription ( "This is a panel that can be used to select something in a list." );//GEN-HEADEREND:BeanDescriptor
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
    private static final int PROPERTY_ignoreRepaint = 69;
    private static final int PROPERTY_inheritsPopupMenu = 70;
    private static final int PROPERTY_inputContext = 71;
    private static final int PROPERTY_inputMap = 72;
    private static final int PROPERTY_inputMethodListeners = 73;
    private static final int PROPERTY_inputMethodRequests = 74;
    private static final int PROPERTY_inputVerifier = 75;
    private static final int PROPERTY_insets = 76;
    private static final int PROPERTY_keyListeners = 77;
    private static final int PROPERTY_lastVisibleIndex = 78;
    private static final int PROPERTY_layout = 79;
    private static final int PROPERTY_layoutOrientation = 80;
    private static final int PROPERTY_leadSelectionIndex = 81;
    private static final int PROPERTY_lightweight = 82;
    private static final int PROPERTY_list = 83;
    private static final int PROPERTY_listAutoscrolls = 84;
    private static final int PROPERTY_listBackground = 85;
    private static final int PROPERTY_listData = 86;
    private static final int PROPERTY_listDataListeners = 87;
    private static final int PROPERTY_listSelectionListeners = 88;
    private static final int PROPERTY_listTitle = 89;
    private static final int PROPERTY_locale = 90;
    private static final int PROPERTY_location = 91;
    private static final int PROPERTY_locationOnScreen = 92;
    private static final int PROPERTY_managingFocus = 93;
    private static final int PROPERTY_maximumSize = 94;
    private static final int PROPERTY_maximumSizeSet = 95;
    private static final int PROPERTY_maxSelectionIndex = 96;
    private static final int PROPERTY_minimumSize = 97;
    private static final int PROPERTY_minimumSizeSet = 98;
    private static final int PROPERTY_minSelectionIndex = 99;
    private static final int PROPERTY_mixingCutoutShape = 100;
    private static final int PROPERTY_model = 101;
    private static final int PROPERTY_modelList = 102;
    private static final int PROPERTY_mouseListeners = 103;
    private static final int PROPERTY_mouseMotionListeners = 104;
    private static final int PROPERTY_mousePosition = 105;
    private static final int PROPERTY_mouseWheelListeners = 106;
    private static final int PROPERTY_name = 107;
    private static final int PROPERTY_nextFocusableComponent = 108;
    private static final int PROPERTY_opaque = 109;
    private static final int PROPERTY_optimizedDrawingEnabled = 110;
    private static final int PROPERTY_paintingForPrint = 111;
    private static final int PROPERTY_paintingTile = 112;
    private static final int PROPERTY_parent = 113;
    private static final int PROPERTY_preferredSize = 114;
    private static final int PROPERTY_preferredSizeSet = 115;
    private static final int PROPERTY_propertyChangeListeners = 116;
    private static final int PROPERTY_prototypeCellValue = 117;
    private static final int PROPERTY_registeredKeyStrokes = 118;
    private static final int PROPERTY_requestFocusEnabled = 119;
    private static final int PROPERTY_rootPane = 120;
    private static final int PROPERTY_scrollPane = 121;
    private static final int PROPERTY_selectedIndex = 122;
    private static final int PROPERTY_selectedIndices = 123;
    private static final int PROPERTY_selectedItemsCount = 124;
    private static final int PROPERTY_selectedValue = 125;
    private static final int PROPERTY_selectedValuesList = 126;
    private static final int PROPERTY_selectionBackground = 127;
    private static final int PROPERTY_selectionEmpty = 128;
    private static final int PROPERTY_selectionForeground = 129;
    private static final int PROPERTY_selectionInterval = 130;
    private static final int PROPERTY_selectionMode = 131;
    private static final int PROPERTY_selectionModel = 132;
    private static final int PROPERTY_showing = 133;
    private static final int PROPERTY_sideAccessory = 134;
    private static final int PROPERTY_size = 135;
    private static final int PROPERTY_toolkit = 136;
    private static final int PROPERTY_toolTipText = 137;
    private static final int PROPERTY_topLevelAncestor = 138;
    private static final int PROPERTY_transferHandler = 139;
    private static final int PROPERTY_treeLock = 140;
    private static final int PROPERTY_UI = 141;
    private static final int PROPERTY_UIClassID = 142;
    private static final int PROPERTY_valid = 143;
    private static final int PROPERTY_validateRoot = 144;
    private static final int PROPERTY_valueIsAdjusting = 145;
    private static final int PROPERTY_verifyInputWhenFocusTarget = 146;
    private static final int PROPERTY_vetoableChangeListeners = 147;
    private static final int PROPERTY_visible = 148;
    private static final int PROPERTY_visibleRect = 149;
    private static final int PROPERTY_visibleRowCount = 150;
    private static final int PROPERTY_width = 151;
    private static final int PROPERTY_x = 152;
    private static final int PROPERTY_y = 153;

    // Property array 
    /*lazy PropertyDescriptor*/
    private static PropertyDescriptor[] getPdescriptor(){
        PropertyDescriptor[] properties = new PropertyDescriptor[154];
    
        try {
            properties[PROPERTY_acceptButton] = new PropertyDescriptor ( "acceptButton", components.JListSelector.class, "getAcceptButton", null ); // NOI18N
            properties[PROPERTY_acceptButton].setHidden ( true );
            properties[PROPERTY_acceptButtonMnemonic] = new PropertyDescriptor ( "acceptButtonMnemonic", components.JListSelector.class, "getAcceptButtonMnemonic", "setAcceptButtonMnemonic" ); // NOI18N
            properties[PROPERTY_acceptButtonMnemonic].setPreferred ( true );
            properties[PROPERTY_acceptButtonMnemonic].setShortDescription ( "The keyboard character mnemonic for the accept button." );
            properties[PROPERTY_acceptButtonMnemonic].setBound ( true );
            properties[PROPERTY_acceptButtonMnemonicSet] = new PropertyDescriptor ( "acceptButtonMnemonicSet", components.JListSelector.class, "isAcceptButtonMnemonicSet", null ); // NOI18N
            properties[PROPERTY_acceptButtonMnemonicSet].setHidden ( true );
            properties[PROPERTY_acceptButtonText] = new PropertyDescriptor ( "acceptButtonText", components.JListSelector.class, "getAcceptButtonText", "setAcceptButtonText" ); // NOI18N
            properties[PROPERTY_acceptButtonText].setPreferred ( true );
            properties[PROPERTY_acceptButtonText].setShortDescription ( "The text for the accept button." );
            properties[PROPERTY_acceptButtonText].setBound ( true );
            properties[PROPERTY_acceptButtonTextSet] = new PropertyDescriptor ( "acceptButtonTextSet", components.JListSelector.class, "isAcceptButtonTextSet", null ); // NOI18N
            properties[PROPERTY_acceptButtonTextSet].setHidden ( true );
            properties[PROPERTY_acceptButtonToolTipText] = new PropertyDescriptor ( "acceptButtonToolTipText", components.JListSelector.class, "getAcceptButtonToolTipText", "setAcceptButtonToolTipText" ); // NOI18N
            properties[PROPERTY_acceptButtonToolTipText].setPreferred ( true );
            properties[PROPERTY_acceptButtonToolTipText].setShortDescription ( "The tool tip text for the accept button." );
            properties[PROPERTY_acceptButtonToolTipText].setBound ( true );
            properties[PROPERTY_acceptButtonToolTipTextSet] = new PropertyDescriptor ( "acceptButtonToolTipTextSet", components.JListSelector.class, "isAcceptButtonToolTipTextSet", null ); // NOI18N
            properties[PROPERTY_acceptButtonToolTipTextSet].setHidden ( true );
            properties[PROPERTY_accessibleContext] = new PropertyDescriptor ( "accessibleContext", components.JListSelector.class, "getAccessibleContext", null ); // NOI18N
            properties[PROPERTY_accessibleContext].setHidden ( true );
            properties[PROPERTY_actionListeners] = new PropertyDescriptor ( "actionListeners", components.JListSelector.class, "getActionListeners", null ); // NOI18N
            properties[PROPERTY_actionListeners].setHidden ( true );
            properties[PROPERTY_actionMap] = new PropertyDescriptor ( "actionMap", components.JListSelector.class, "getActionMap", "setActionMap" ); // NOI18N
            properties[PROPERTY_actionMap].setHidden ( true );
            properties[PROPERTY_alignmentX] = new PropertyDescriptor ( "alignmentX", components.JListSelector.class, "getAlignmentX", "setAlignmentX" ); // NOI18N
            properties[PROPERTY_alignmentX].setShortDescription ( "The preferred horizontal alignment of the component." );
            properties[PROPERTY_alignmentY] = new PropertyDescriptor ( "alignmentY", components.JListSelector.class, "getAlignmentY", "setAlignmentY" ); // NOI18N
            properties[PROPERTY_alignmentY].setShortDescription ( "The preferred vertical alignment of the component." );
            properties[PROPERTY_ancestorListeners] = new PropertyDescriptor ( "ancestorListeners", components.JListSelector.class, "getAncestorListeners", null ); // NOI18N
            properties[PROPERTY_ancestorListeners].setHidden ( true );
            properties[PROPERTY_anchorSelectionIndex] = new PropertyDescriptor ( "anchorSelectionIndex", components.JListSelector.class, "getAnchorSelectionIndex", null ); // NOI18N
            properties[PROPERTY_autoscrolls] = new PropertyDescriptor ( "autoscrolls", components.JListSelector.class, "getAutoscrolls", "setAutoscrolls" ); // NOI18N
            properties[PROPERTY_autoscrolls].setShortDescription ( "Determines if this component automatically scrolls its contents when dragged." );
            properties[PROPERTY_background] = new PropertyDescriptor ( "background", components.JListSelector.class, "getBackground", "setBackground" ); // NOI18N
            properties[PROPERTY_background].setPreferred ( true );
            properties[PROPERTY_background].setShortDescription ( "The background color of the component." );
            properties[PROPERTY_background].setBound ( true );
            properties[PROPERTY_backgroundSet] = new PropertyDescriptor ( "backgroundSet", components.JListSelector.class, "isBackgroundSet", null ); // NOI18N
            properties[PROPERTY_backgroundSet].setHidden ( true );
            properties[PROPERTY_baselineResizeBehavior] = new PropertyDescriptor ( "baselineResizeBehavior", components.JListSelector.class, "getBaselineResizeBehavior", null ); // NOI18N
            properties[PROPERTY_baselineResizeBehavior].setExpert ( true );
            properties[PROPERTY_border] = new PropertyDescriptor ( "border", components.JListSelector.class, "getBorder", "setBorder" ); // NOI18N
            properties[PROPERTY_border].setShortDescription ( "The component's border." );
            properties[PROPERTY_border].setBound ( true );
            properties[PROPERTY_bottomAccessory] = new PropertyDescriptor ( "bottomAccessory", components.JListSelector.class, "getBottomAccessory", "setBottomAccessory" ); // NOI18N
            properties[PROPERTY_bottomAccessory].setPreferred ( true );
            properties[PROPERTY_bottomAccessory].setShortDescription ( "The accessory component to display at the bottom of the panel." );
            properties[PROPERTY_bottomAccessory].setBound ( true );
            properties[PROPERTY_bounds] = new PropertyDescriptor ( "bounds", components.JListSelector.class, "getBounds", "setBounds" ); // NOI18N
            properties[PROPERTY_bounds].setHidden ( true );
            properties[PROPERTY_cancelButton] = new PropertyDescriptor ( "cancelButton", components.JListSelector.class, "getCancelButton", null ); // NOI18N
            properties[PROPERTY_cancelButton].setHidden ( true );
            properties[PROPERTY_cancelButtonMnemonic] = new PropertyDescriptor ( "cancelButtonMnemonic", components.JListSelector.class, "getCancelButtonMnemonic", "setCancelButtonMnemonic" ); // NOI18N
            properties[PROPERTY_cancelButtonMnemonic].setShortDescription ( "The keyboard character mnemonic for the cancel button." );
            properties[PROPERTY_cancelButtonMnemonic].setBound ( true );
            properties[PROPERTY_cancelButtonMnemonicSet] = new PropertyDescriptor ( "cancelButtonMnemonicSet", components.JListSelector.class, "isCancelButtonMnemonicSet", null ); // NOI18N
            properties[PROPERTY_cancelButtonMnemonicSet].setHidden ( true );
            properties[PROPERTY_cancelButtonText] = new PropertyDescriptor ( "cancelButtonText", components.JListSelector.class, "getCancelButtonText", "setCancelButtonText" ); // NOI18N
            properties[PROPERTY_cancelButtonText].setShortDescription ( "The text for the cancel button." );
            properties[PROPERTY_cancelButtonText].setBound ( true );
            properties[PROPERTY_cancelButtonTextSet] = new PropertyDescriptor ( "cancelButtonTextSet", components.JListSelector.class, "isCancelButtonTextSet", null ); // NOI18N
            properties[PROPERTY_cancelButtonTextSet].setHidden ( true );
            properties[PROPERTY_cancelButtonToolTipText] = new PropertyDescriptor ( "cancelButtonToolTipText", components.JListSelector.class, "getCancelButtonToolTipText", "setCancelButtonToolTipText" ); // NOI18N
            properties[PROPERTY_cancelButtonToolTipText].setShortDescription ( "The tool tip text for the cancel button." );
            properties[PROPERTY_cancelButtonToolTipText].setBound ( true );
            properties[PROPERTY_cancelButtonToolTipTextSet] = new PropertyDescriptor ( "cancelButtonToolTipTextSet", components.JListSelector.class, "isCancelButtonToolTipTextSet", null ); // NOI18N
            properties[PROPERTY_cancelButtonToolTipTextSet].setHidden ( true );
            properties[PROPERTY_cellRenderer] = new PropertyDescriptor ( "cellRenderer", components.JListSelector.class, "getCellRenderer", "setCellRenderer" ); // NOI18N
            properties[PROPERTY_cellRenderer].setShortDescription ( "The component used to draw the cells in the list." );
            properties[PROPERTY_cellRenderer].setBound ( true );
            properties[PROPERTY_colorModel] = new PropertyDescriptor ( "colorModel", components.JListSelector.class, "getColorModel", null ); // NOI18N
            properties[PROPERTY_colorModel].setHidden ( true );
            properties[PROPERTY_component] = new IndexedPropertyDescriptor ( "component", components.JListSelector.class, null, null, "getComponent", null ); // NOI18N
            properties[PROPERTY_component].setHidden ( true );
            properties[PROPERTY_componentCount] = new PropertyDescriptor ( "componentCount", components.JListSelector.class, "getComponentCount", null ); // NOI18N
            properties[PROPERTY_componentCount].setHidden ( true );
            properties[PROPERTY_componentListeners] = new PropertyDescriptor ( "componentListeners", components.JListSelector.class, "getComponentListeners", null ); // NOI18N
            properties[PROPERTY_componentListeners].setHidden ( true );
            properties[PROPERTY_componentOrientation] = new PropertyDescriptor ( "componentOrientation", components.JListSelector.class, "getComponentOrientation", "setComponentOrientation" ); // NOI18N
            properties[PROPERTY_componentOrientation].setHidden ( true );
            properties[PROPERTY_componentPopupMenu] = new PropertyDescriptor ( "componentPopupMenu", components.JListSelector.class, "getComponentPopupMenu", "setComponentPopupMenu" ); // NOI18N
            properties[PROPERTY_componentPopupMenu].setShortDescription ( "The popup menu to show" );
            properties[PROPERTY_componentPopupMenu].setBound ( true );
            properties[PROPERTY_components] = new PropertyDescriptor ( "components", components.JListSelector.class, "getComponents", null ); // NOI18N
            properties[PROPERTY_components].setHidden ( true );
            properties[PROPERTY_containerListeners] = new PropertyDescriptor ( "containerListeners", components.JListSelector.class, "getContainerListeners", null ); // NOI18N
            properties[PROPERTY_containerListeners].setHidden ( true );
            properties[PROPERTY_controlButtonsAreShown] = new PropertyDescriptor ( "controlButtonsAreShown", components.JListSelector.class, "getControlButtonsAreShown", "setControlButtonsAreShown" ); // NOI18N
            properties[PROPERTY_controlButtonsAreShown].setShortDescription ( "Sets whether the control buttons are shown." );
            properties[PROPERTY_controlButtonsAreShown].setBound ( true );
            properties[PROPERTY_cursor] = new PropertyDescriptor ( "cursor", components.JListSelector.class, "getCursor", "setCursor" ); // NOI18N
            properties[PROPERTY_cursorSet] = new PropertyDescriptor ( "cursorSet", components.JListSelector.class, "isCursorSet", null ); // NOI18N
            properties[PROPERTY_cursorSet].setHidden ( true );
            properties[PROPERTY_debugGraphicsOptions] = new PropertyDescriptor ( "debugGraphicsOptions", components.JListSelector.class, "getDebugGraphicsOptions", "setDebugGraphicsOptions" ); // NOI18N
            properties[PROPERTY_debugGraphicsOptions].setShortDescription ( "Diagnostic options for graphics operations." );
            properties[PROPERTY_dialogTitle] = new PropertyDescriptor ( "dialogTitle", components.JListSelector.class, "getDialogTitle", "setDialogTitle" ); // NOI18N
            properties[PROPERTY_dialogTitle].setPreferred ( true );
            properties[PROPERTY_dialogTitle].setShortDescription ( "The title of the JListSelector dialog window." );
            properties[PROPERTY_dialogTitle].setBound ( true );
            properties[PROPERTY_displayable] = new PropertyDescriptor ( "displayable", components.JListSelector.class, "isDisplayable", null ); // NOI18N
            properties[PROPERTY_displayable].setHidden ( true );
            properties[PROPERTY_doubleBuffered] = new PropertyDescriptor ( "doubleBuffered", components.JListSelector.class, "isDoubleBuffered", "setDoubleBuffered" ); // NOI18N
            properties[PROPERTY_dropTarget] = new PropertyDescriptor ( "dropTarget", components.JListSelector.class, "getDropTarget", "setDropTarget" ); // NOI18N
            properties[PROPERTY_dropTarget].setHidden ( true );
            properties[PROPERTY_enabled] = new PropertyDescriptor ( "enabled", components.JListSelector.class, "isEnabled", "setEnabled" ); // NOI18N
            properties[PROPERTY_enabled].setShortDescription ( "The enabled state of the component." );
            properties[PROPERTY_enabled].setBound ( true );
            properties[PROPERTY_firstVisibleIndex] = new PropertyDescriptor ( "firstVisibleIndex", components.JListSelector.class, "getFirstVisibleIndex", null ); // NOI18N
            properties[PROPERTY_fixedCellHeight] = new PropertyDescriptor ( "fixedCellHeight", components.JListSelector.class, "getFixedCellHeight", "setFixedCellHeight" ); // NOI18N
            properties[PROPERTY_fixedCellHeight].setShortDescription ( "Sets a fixed cell height when this is greater than zero." );
            properties[PROPERTY_fixedCellHeight].setBound ( true );
            properties[PROPERTY_fixedCellWidth] = new PropertyDescriptor ( "fixedCellWidth", components.JListSelector.class, "getFixedCellWidth", "setFixedCellWidth" ); // NOI18N
            properties[PROPERTY_fixedCellWidth].setShortDescription ( "Sets a fixed cell width when this is greater than zero." );
            properties[PROPERTY_fixedCellWidth].setBound ( true );
            properties[PROPERTY_focusable] = new PropertyDescriptor ( "focusable", components.JListSelector.class, "isFocusable", "setFocusable" ); // NOI18N
            properties[PROPERTY_focusCycleRoot] = new PropertyDescriptor ( "focusCycleRoot", components.JListSelector.class, "isFocusCycleRoot", "setFocusCycleRoot" ); // NOI18N
            properties[PROPERTY_focusCycleRootAncestor] = new PropertyDescriptor ( "focusCycleRootAncestor", components.JListSelector.class, "getFocusCycleRootAncestor", null ); // NOI18N
            properties[PROPERTY_focusCycleRootAncestor].setHidden ( true );
            properties[PROPERTY_focusListeners] = new PropertyDescriptor ( "focusListeners", components.JListSelector.class, "getFocusListeners", null ); // NOI18N
            properties[PROPERTY_focusListeners].setHidden ( true );
            properties[PROPERTY_focusOwner] = new PropertyDescriptor ( "focusOwner", components.JListSelector.class, "isFocusOwner", null ); // NOI18N
            properties[PROPERTY_focusOwner].setHidden ( true );
            properties[PROPERTY_focusTraversable] = new PropertyDescriptor ( "focusTraversable", components.JListSelector.class, "isFocusTraversable", null ); // NOI18N
            properties[PROPERTY_focusTraversable].setHidden ( true );
            properties[PROPERTY_focusTraversalKeys] = new IndexedPropertyDescriptor ( "focusTraversalKeys", components.JListSelector.class, null, null, null, "setFocusTraversalKeys" ); // NOI18N
            properties[PROPERTY_focusTraversalKeys].setHidden ( true );
            properties[PROPERTY_focusTraversalKeysEnabled] = new PropertyDescriptor ( "focusTraversalKeysEnabled", components.JListSelector.class, "getFocusTraversalKeysEnabled", "setFocusTraversalKeysEnabled" ); // NOI18N
            properties[PROPERTY_focusTraversalKeysEnabled].setHidden ( true );
            properties[PROPERTY_focusTraversalPolicy] = new PropertyDescriptor ( "focusTraversalPolicy", components.JListSelector.class, "getFocusTraversalPolicy", "setFocusTraversalPolicy" ); // NOI18N
            properties[PROPERTY_focusTraversalPolicyProvider] = new PropertyDescriptor ( "focusTraversalPolicyProvider", components.JListSelector.class, "isFocusTraversalPolicyProvider", "setFocusTraversalPolicyProvider" ); // NOI18N
            properties[PROPERTY_focusTraversalPolicySet] = new PropertyDescriptor ( "focusTraversalPolicySet", components.JListSelector.class, "isFocusTraversalPolicySet", null ); // NOI18N
            properties[PROPERTY_focusTraversalPolicySet].setHidden ( true );
            properties[PROPERTY_font] = new PropertyDescriptor ( "font", components.JListSelector.class, "getFont", "setFont" ); // NOI18N
            properties[PROPERTY_font].setPreferred ( true );
            properties[PROPERTY_font].setShortDescription ( "The font for the component." );
            properties[PROPERTY_font].setBound ( true );
            properties[PROPERTY_fontSet] = new PropertyDescriptor ( "fontSet", components.JListSelector.class, "isFontSet", null ); // NOI18N
            properties[PROPERTY_fontSet].setHidden ( true );
            properties[PROPERTY_foreground] = new PropertyDescriptor ( "foreground", components.JListSelector.class, "getForeground", "setForeground" ); // NOI18N
            properties[PROPERTY_foreground].setPreferred ( true );
            properties[PROPERTY_foreground].setShortDescription ( "The foreground color of the component." );
            properties[PROPERTY_foreground].setBound ( true );
            properties[PROPERTY_foregroundSet] = new PropertyDescriptor ( "foregroundSet", components.JListSelector.class, "isForegroundSet", null ); // NOI18N
            properties[PROPERTY_foregroundSet].setHidden ( true );
            properties[PROPERTY_graphics] = new PropertyDescriptor ( "graphics", components.JListSelector.class, "getGraphics", null ); // NOI18N
            properties[PROPERTY_graphics].setHidden ( true );
            properties[PROPERTY_graphicsConfiguration] = new PropertyDescriptor ( "graphicsConfiguration", components.JListSelector.class, "getGraphicsConfiguration", null ); // NOI18N
            properties[PROPERTY_graphicsConfiguration].setHidden ( true );
            properties[PROPERTY_height] = new PropertyDescriptor ( "height", components.JListSelector.class, "getHeight", null ); // NOI18N
            properties[PROPERTY_height].setHidden ( true );
            properties[PROPERTY_hierarchyBoundsListeners] = new PropertyDescriptor ( "hierarchyBoundsListeners", components.JListSelector.class, "getHierarchyBoundsListeners", null ); // NOI18N
            properties[PROPERTY_hierarchyBoundsListeners].setHidden ( true );
            properties[PROPERTY_hierarchyListeners] = new PropertyDescriptor ( "hierarchyListeners", components.JListSelector.class, "getHierarchyListeners", null ); // NOI18N
            properties[PROPERTY_hierarchyListeners].setHidden ( true );
            properties[PROPERTY_ignoreRepaint] = new PropertyDescriptor ( "ignoreRepaint", components.JListSelector.class, "getIgnoreRepaint", "setIgnoreRepaint" ); // NOI18N
            properties[PROPERTY_ignoreRepaint].setHidden ( true );
            properties[PROPERTY_inheritsPopupMenu] = new PropertyDescriptor ( "inheritsPopupMenu", components.JListSelector.class, "getInheritsPopupMenu", "setInheritsPopupMenu" ); // NOI18N
            properties[PROPERTY_inheritsPopupMenu].setShortDescription ( "Whether or not the JPopupMenu is inherited" );
            properties[PROPERTY_inheritsPopupMenu].setBound ( true );
            properties[PROPERTY_inputContext] = new PropertyDescriptor ( "inputContext", components.JListSelector.class, "getInputContext", null ); // NOI18N
            properties[PROPERTY_inputContext].setHidden ( true );
            properties[PROPERTY_inputMap] = new PropertyDescriptor ( "inputMap", components.JListSelector.class, "getInputMap", null ); // NOI18N
            properties[PROPERTY_inputMap].setHidden ( true );
            properties[PROPERTY_inputMethodListeners] = new PropertyDescriptor ( "inputMethodListeners", components.JListSelector.class, "getInputMethodListeners", null ); // NOI18N
            properties[PROPERTY_inputMethodListeners].setHidden ( true );
            properties[PROPERTY_inputMethodRequests] = new PropertyDescriptor ( "inputMethodRequests", components.JListSelector.class, "getInputMethodRequests", null ); // NOI18N
            properties[PROPERTY_inputMethodRequests].setHidden ( true );
            properties[PROPERTY_inputVerifier] = new PropertyDescriptor ( "inputVerifier", components.JListSelector.class, "getInputVerifier", "setInputVerifier" ); // NOI18N
            properties[PROPERTY_inputVerifier].setShortDescription ( "The component's input verifier." );
            properties[PROPERTY_insets] = new PropertyDescriptor ( "insets", components.JListSelector.class, "getInsets", null ); // NOI18N
            properties[PROPERTY_insets].setExpert ( true );
            properties[PROPERTY_keyListeners] = new PropertyDescriptor ( "keyListeners", components.JListSelector.class, "getKeyListeners", null ); // NOI18N
            properties[PROPERTY_keyListeners].setHidden ( true );
            properties[PROPERTY_lastVisibleIndex] = new PropertyDescriptor ( "lastVisibleIndex", components.JListSelector.class, "getLastVisibleIndex", null ); // NOI18N
            properties[PROPERTY_layout] = new PropertyDescriptor ( "layout", components.JListSelector.class, "getLayout", "setLayout" ); // NOI18N
            properties[PROPERTY_layout].setHidden ( true );
            properties[PROPERTY_layoutOrientation] = new PropertyDescriptor ( "layoutOrientation", components.JListSelector.class, "getLayoutOrientation", "setLayoutOrientation" ); // NOI18N
            properties[PROPERTY_layoutOrientation].setShortDescription ( "Sets how the cells in the list are layed out." );
            properties[PROPERTY_layoutOrientation].setBound ( true );
            properties[PROPERTY_layoutOrientation].setPropertyEditorClass ( ListLayoutOrientationEditor.class );
            properties[PROPERTY_leadSelectionIndex] = new PropertyDescriptor ( "leadSelectionIndex", components.JListSelector.class, "getLeadSelectionIndex", null ); // NOI18N
            properties[PROPERTY_lightweight] = new PropertyDescriptor ( "lightweight", components.JListSelector.class, "isLightweight", null ); // NOI18N
            properties[PROPERTY_lightweight].setHidden ( true );
            properties[PROPERTY_list] = new PropertyDescriptor ( "list", components.JListSelector.class, "getList", null ); // NOI18N
            properties[PROPERTY_list].setHidden ( true );
            properties[PROPERTY_listAutoscrolls] = new PropertyDescriptor ( "listAutoscrolls", components.JListSelector.class, "getListAutoscrolls", "setListAutoscrolls" ); // NOI18N
            properties[PROPERTY_listAutoscrolls].setShortDescription ( "Determines if the internal list automatically scrolls its contents when dragged." );
            properties[PROPERTY_listBackground] = new PropertyDescriptor ( "listBackground", components.JListSelector.class, "getListBackground", "setListBackground" ); // NOI18N
            properties[PROPERTY_listBackground].setShortDescription ( "The background color of the list." );
            properties[PROPERTY_listBackground].setBound ( true );
            properties[PROPERTY_listData] = new PropertyDescriptor ( "listData", components.JListSelector.class, null, "setListData" ); // NOI18N
            properties[PROPERTY_listData].setHidden ( true );
            properties[PROPERTY_listDataListeners] = new PropertyDescriptor ( "listDataListeners", components.JListSelector.class, "getListDataListeners", null ); // NOI18N
            properties[PROPERTY_listDataListeners].setHidden ( true );
            properties[PROPERTY_listSelectionListeners] = new PropertyDescriptor ( "listSelectionListeners", components.JListSelector.class, "getListSelectionListeners", null ); // NOI18N
            properties[PROPERTY_listSelectionListeners].setHidden ( true );
            properties[PROPERTY_listTitle] = new PropertyDescriptor ( "listTitle", components.JListSelector.class, "getListTitle", "setListTitle" ); // NOI18N
            properties[PROPERTY_listTitle].setPreferred ( true );
            properties[PROPERTY_listTitle].setShortDescription ( "The title to display above the list." );
            properties[PROPERTY_listTitle].setBound ( true );
            properties[PROPERTY_locale] = new PropertyDescriptor ( "locale", components.JListSelector.class, "getLocale", "setLocale" ); // NOI18N
            properties[PROPERTY_locale].setHidden ( true );
            properties[PROPERTY_location] = new PropertyDescriptor ( "location", components.JListSelector.class, "getLocation", "setLocation" ); // NOI18N
            properties[PROPERTY_location].setHidden ( true );
            properties[PROPERTY_locationOnScreen] = new PropertyDescriptor ( "locationOnScreen", components.JListSelector.class, "getLocationOnScreen", null ); // NOI18N
            properties[PROPERTY_locationOnScreen].setHidden ( true );
            properties[PROPERTY_managingFocus] = new PropertyDescriptor ( "managingFocus", components.JListSelector.class, "isManagingFocus", null ); // NOI18N
            properties[PROPERTY_managingFocus].setHidden ( true );
            properties[PROPERTY_maximumSize] = new PropertyDescriptor ( "maximumSize", components.JListSelector.class, "getMaximumSize", "setMaximumSize" ); // NOI18N
            properties[PROPERTY_maximumSize].setShortDescription ( "The maximum size of the component." );
            properties[PROPERTY_maximumSize].setBound ( true );
            properties[PROPERTY_maximumSizeSet] = new PropertyDescriptor ( "maximumSizeSet", components.JListSelector.class, "isMaximumSizeSet", null ); // NOI18N
            properties[PROPERTY_maximumSizeSet].setHidden ( true );
            properties[PROPERTY_maxSelectionIndex] = new PropertyDescriptor ( "maxSelectionIndex", components.JListSelector.class, "getMaxSelectionIndex", null ); // NOI18N
            properties[PROPERTY_minimumSize] = new PropertyDescriptor ( "minimumSize", components.JListSelector.class, "getMinimumSize", "setMinimumSize" ); // NOI18N
            properties[PROPERTY_minimumSize].setShortDescription ( "The minimum size of the component." );
            properties[PROPERTY_minimumSize].setBound ( true );
            properties[PROPERTY_minimumSizeSet] = new PropertyDescriptor ( "minimumSizeSet", components.JListSelector.class, "isMinimumSizeSet", null ); // NOI18N
            properties[PROPERTY_minimumSizeSet].setHidden ( true );
            properties[PROPERTY_minSelectionIndex] = new PropertyDescriptor ( "minSelectionIndex", components.JListSelector.class, "getMinSelectionIndex", null ); // NOI18N
            properties[PROPERTY_mixingCutoutShape] = new PropertyDescriptor ( "mixingCutoutShape", components.JListSelector.class, null, "setMixingCutoutShape" ); // NOI18N
            properties[PROPERTY_mixingCutoutShape].setHidden ( true );
            properties[PROPERTY_model] = new PropertyDescriptor ( "model", components.JListSelector.class, "getModel", "setModel" ); // NOI18N
            properties[PROPERTY_model].setPreferred ( true );
            properties[PROPERTY_model].setShortDescription ( "The model used to contain the data to be in the list." );
            properties[PROPERTY_model].setBound ( true );
            properties[PROPERTY_modelList] = new PropertyDescriptor ( "modelList", components.JListSelector.class, "getModelList", null ); // NOI18N
            properties[PROPERTY_modelList].setHidden ( true );
            properties[PROPERTY_mouseListeners] = new PropertyDescriptor ( "mouseListeners", components.JListSelector.class, "getMouseListeners", null ); // NOI18N
            properties[PROPERTY_mouseListeners].setHidden ( true );
            properties[PROPERTY_mouseMotionListeners] = new PropertyDescriptor ( "mouseMotionListeners", components.JListSelector.class, "getMouseMotionListeners", null ); // NOI18N
            properties[PROPERTY_mouseMotionListeners].setHidden ( true );
            properties[PROPERTY_mousePosition] = new PropertyDescriptor ( "mousePosition", components.JListSelector.class, "getMousePosition", null ); // NOI18N
            properties[PROPERTY_mousePosition].setHidden ( true );
            properties[PROPERTY_mouseWheelListeners] = new PropertyDescriptor ( "mouseWheelListeners", components.JListSelector.class, "getMouseWheelListeners", null ); // NOI18N
            properties[PROPERTY_mouseWheelListeners].setHidden ( true );
            properties[PROPERTY_name] = new PropertyDescriptor ( "name", components.JListSelector.class, "getName", "setName" ); // NOI18N
            properties[PROPERTY_name].setBound ( true );
            properties[PROPERTY_nextFocusableComponent] = new PropertyDescriptor ( "nextFocusableComponent", components.JListSelector.class, "getNextFocusableComponent", "setNextFocusableComponent" ); // NOI18N
            properties[PROPERTY_opaque] = new PropertyDescriptor ( "opaque", components.JListSelector.class, "isOpaque", "setOpaque" ); // NOI18N
            properties[PROPERTY_opaque].setShortDescription ( "The component's opacity" );
            properties[PROPERTY_optimizedDrawingEnabled] = new PropertyDescriptor ( "optimizedDrawingEnabled", components.JListSelector.class, "isOptimizedDrawingEnabled", null ); // NOI18N
            properties[PROPERTY_optimizedDrawingEnabled].setHidden ( true );
            properties[PROPERTY_paintingForPrint] = new PropertyDescriptor ( "paintingForPrint", components.JListSelector.class, "isPaintingForPrint", null ); // NOI18N
            properties[PROPERTY_paintingTile] = new PropertyDescriptor ( "paintingTile", components.JListSelector.class, "isPaintingTile", null ); // NOI18N
            properties[PROPERTY_paintingTile].setHidden ( true );
            properties[PROPERTY_parent] = new PropertyDescriptor ( "parent", components.JListSelector.class, "getParent", null ); // NOI18N
            properties[PROPERTY_parent].setHidden ( true );
            properties[PROPERTY_preferredSize] = new PropertyDescriptor ( "preferredSize", components.JListSelector.class, "getPreferredSize", "setPreferredSize" ); // NOI18N
            properties[PROPERTY_preferredSize].setShortDescription ( "The preferred size of the component." );
            properties[PROPERTY_preferredSize].setBound ( true );
            properties[PROPERTY_preferredSizeSet] = new PropertyDescriptor ( "preferredSizeSet", components.JListSelector.class, "isPreferredSizeSet", null ); // NOI18N
            properties[PROPERTY_preferredSizeSet].setHidden ( true );
            properties[PROPERTY_propertyChangeListeners] = new PropertyDescriptor ( "propertyChangeListeners", components.JListSelector.class, "getPropertyChangeListeners", null ); // NOI18N
            properties[PROPERTY_propertyChangeListeners].setHidden ( true );
            properties[PROPERTY_prototypeCellValue] = new PropertyDescriptor ( "prototypeCellValue", components.JListSelector.class, "getPrototypeCellValue", "setPrototypeCellValue" ); // NOI18N
            properties[PROPERTY_prototypeCellValue].setShortDescription ( "The cell prototype value used to calculate the cell width and height." );
            properties[PROPERTY_prototypeCellValue].setBound ( true );
            properties[PROPERTY_registeredKeyStrokes] = new PropertyDescriptor ( "registeredKeyStrokes", components.JListSelector.class, "getRegisteredKeyStrokes", null ); // NOI18N
            properties[PROPERTY_registeredKeyStrokes].setHidden ( true );
            properties[PROPERTY_requestFocusEnabled] = new PropertyDescriptor ( "requestFocusEnabled", components.JListSelector.class, "isRequestFocusEnabled", "setRequestFocusEnabled" ); // NOI18N
            properties[PROPERTY_rootPane] = new PropertyDescriptor ( "rootPane", components.JListSelector.class, "getRootPane", null ); // NOI18N
            properties[PROPERTY_rootPane].setHidden ( true );
            properties[PROPERTY_scrollPane] = new PropertyDescriptor ( "scrollPane", components.JListSelector.class, "getScrollPane", null ); // NOI18N
            properties[PROPERTY_scrollPane].setHidden ( true );
            properties[PROPERTY_selectedIndex] = new PropertyDescriptor ( "selectedIndex", components.JListSelector.class, "getSelectedIndex", "setSelectedIndex" ); // NOI18N
            properties[PROPERTY_selectedIndex].setShortDescription ( "The index of the currently selected cell." );
            properties[PROPERTY_selectedIndices] = new PropertyDescriptor ( "selectedIndices", components.JListSelector.class, "getSelectedIndices", "setSelectedIndices" ); // NOI18N
            properties[PROPERTY_selectedItemsCount] = new PropertyDescriptor ( "selectedItemsCount", components.JListSelector.class, "getSelectedItemsCount", null ); // NOI18N
            properties[PROPERTY_selectedItemsCount].setHidden ( true );
            properties[PROPERTY_selectedValue] = new PropertyDescriptor ( "selectedValue", components.JListSelector.class, "getSelectedValue", null ); // NOI18N
            properties[PROPERTY_selectedValuesList] = new PropertyDescriptor ( "selectedValuesList", components.JListSelector.class, "getSelectedValuesList", null ); // NOI18N
            properties[PROPERTY_selectionBackground] = new PropertyDescriptor ( "selectionBackground", components.JListSelector.class, "getSelectionBackground", "setSelectionBackground" ); // NOI18N
            properties[PROPERTY_selectionBackground].setShortDescription ( "The background color of selected cells in the list." );
            properties[PROPERTY_selectionBackground].setBound ( true );
            properties[PROPERTY_selectionEmpty] = new PropertyDescriptor ( "selectionEmpty", components.JListSelector.class, "isSelectionEmpty", null ); // NOI18N
            properties[PROPERTY_selectionForeground] = new PropertyDescriptor ( "selectionForeground", components.JListSelector.class, "getSelectionForeground", "setSelectionForeground" ); // NOI18N
            properties[PROPERTY_selectionForeground].setShortDescription ( "The foreground color of selected cells." );
            properties[PROPERTY_selectionForeground].setBound ( true );
            properties[PROPERTY_selectionInterval] = new IndexedPropertyDescriptor ( "selectionInterval", components.JListSelector.class, null, null, null, "setSelectionInterval" ); // NOI18N
            properties[PROPERTY_selectionMode] = new PropertyDescriptor ( "selectionMode", components.JListSelector.class, "getSelectionMode", "setSelectionMode" ); // NOI18N
            properties[PROPERTY_selectionMode].setPreferred ( true );
            properties[PROPERTY_selectionMode].setShortDescription ( "The list selection mode." );
            properties[PROPERTY_selectionMode].setPropertyEditorClass ( ListSelectionModeEditor.class );
            properties[PROPERTY_selectionModel] = new PropertyDescriptor ( "selectionModel", components.JListSelector.class, "getSelectionModel", "setSelectionModel" ); // NOI18N
            properties[PROPERTY_selectionModel].setShortDescription ( "The list selection model which records which cells are selected." );
            properties[PROPERTY_selectionModel].setBound ( true );
            properties[PROPERTY_showing] = new PropertyDescriptor ( "showing", components.JListSelector.class, "isShowing", null ); // NOI18N
            properties[PROPERTY_showing].setHidden ( true );
            properties[PROPERTY_sideAccessory] = new PropertyDescriptor ( "sideAccessory", components.JListSelector.class, "getSideAccessory", "setSideAccessory" ); // NOI18N
            properties[PROPERTY_sideAccessory].setPreferred ( true );
            properties[PROPERTY_sideAccessory].setShortDescription ( "The accessory component to display to the right of the list." );
            properties[PROPERTY_sideAccessory].setBound ( true );
            properties[PROPERTY_size] = new PropertyDescriptor ( "size", components.JListSelector.class, "getSize", "setSize" ); // NOI18N
            properties[PROPERTY_size].setHidden ( true );
            properties[PROPERTY_toolkit] = new PropertyDescriptor ( "toolkit", components.JListSelector.class, "getToolkit", null ); // NOI18N
            properties[PROPERTY_toolkit].setHidden ( true );
            properties[PROPERTY_toolTipText] = new PropertyDescriptor ( "toolTipText", components.JListSelector.class, "getToolTipText", "setToolTipText" ); // NOI18N
            properties[PROPERTY_toolTipText].setPreferred ( true );
            properties[PROPERTY_toolTipText].setShortDescription ( "The text to display in a tool tip." );
            properties[PROPERTY_topLevelAncestor] = new PropertyDescriptor ( "topLevelAncestor", components.JListSelector.class, "getTopLevelAncestor", null ); // NOI18N
            properties[PROPERTY_topLevelAncestor].setHidden ( true );
            properties[PROPERTY_transferHandler] = new PropertyDescriptor ( "transferHandler", components.JListSelector.class, "getTransferHandler", "setTransferHandler" ); // NOI18N
            properties[PROPERTY_transferHandler].setHidden ( true );
            properties[PROPERTY_treeLock] = new PropertyDescriptor ( "treeLock", components.JListSelector.class, "getTreeLock", null ); // NOI18N
            properties[PROPERTY_treeLock].setHidden ( true );
            properties[PROPERTY_UI] = new PropertyDescriptor ( "UI", components.JListSelector.class, "getUI", "setUI" ); // NOI18N
            properties[PROPERTY_UI].setHidden ( true );
            properties[PROPERTY_UI].setShortDescription ( "The UI object that implements the Component's LookAndFeel." );
            properties[PROPERTY_UIClassID] = new PropertyDescriptor ( "UIClassID", components.JListSelector.class, "getUIClassID", null ); // NOI18N
            properties[PROPERTY_valid] = new PropertyDescriptor ( "valid", components.JListSelector.class, "isValid", null ); // NOI18N
            properties[PROPERTY_valid].setHidden ( true );
            properties[PROPERTY_validateRoot] = new PropertyDescriptor ( "validateRoot", components.JListSelector.class, "isValidateRoot", null ); // NOI18N
            properties[PROPERTY_validateRoot].setHidden ( true );
            properties[PROPERTY_valueIsAdjusting] = new PropertyDescriptor ( "valueIsAdjusting", components.JListSelector.class, "getValueIsAdjusting", "setValueIsAdjusting" ); // NOI18N
            properties[PROPERTY_verifyInputWhenFocusTarget] = new PropertyDescriptor ( "verifyInputWhenFocusTarget", components.JListSelector.class, "getVerifyInputWhenFocusTarget", "setVerifyInputWhenFocusTarget" ); // NOI18N
            properties[PROPERTY_verifyInputWhenFocusTarget].setShortDescription ( "Whether the Component verifies input before accepting focus." );
            properties[PROPERTY_vetoableChangeListeners] = new PropertyDescriptor ( "vetoableChangeListeners", components.JListSelector.class, "getVetoableChangeListeners", null ); // NOI18N
            properties[PROPERTY_vetoableChangeListeners].setHidden ( true );
            properties[PROPERTY_visible] = new PropertyDescriptor ( "visible", components.JListSelector.class, "isVisible", "setVisible" ); // NOI18N
            properties[PROPERTY_visible].setHidden ( true );
            properties[PROPERTY_visibleRect] = new PropertyDescriptor ( "visibleRect", components.JListSelector.class, "getVisibleRect", null ); // NOI18N
            properties[PROPERTY_visibleRect].setHidden ( true );
            properties[PROPERTY_visibleRowCount] = new PropertyDescriptor ( "visibleRowCount", components.JListSelector.class, "getVisibleRowCount", "setVisibleRowCount" ); // NOI18N
            properties[PROPERTY_visibleRowCount].setShortDescription ( "The preferred number of rows to display without requiring scrolling the list." );
            properties[PROPERTY_visibleRowCount].setBound ( true );
            properties[PROPERTY_width] = new PropertyDescriptor ( "width", components.JListSelector.class, "getWidth", null ); // NOI18N
            properties[PROPERTY_width].setHidden ( true );
            properties[PROPERTY_x] = new PropertyDescriptor ( "x", components.JListSelector.class, "getX", null ); // NOI18N
            properties[PROPERTY_x].setHidden ( true );
            properties[PROPERTY_y] = new PropertyDescriptor ( "y", components.JListSelector.class, "getY", null ); // NOI18N
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
            eventSets[EVENT_actionListener] = new EventSetDescriptor ( components.JListSelector.class, "actionListener", java.awt.event.ActionListener.class, new String[] {"actionPerformed"}, "addActionListener", "removeActionListener" ); // NOI18N
            eventSets[EVENT_ancestorListener] = new EventSetDescriptor ( components.JListSelector.class, "ancestorListener", javax.swing.event.AncestorListener.class, new String[] {"ancestorAdded", "ancestorRemoved", "ancestorMoved"}, "addAncestorListener", "removeAncestorListener" ); // NOI18N
            eventSets[EVENT_componentListener] = new EventSetDescriptor ( components.JListSelector.class, "componentListener", java.awt.event.ComponentListener.class, new String[] {"componentResized", "componentMoved", "componentShown", "componentHidden"}, "addComponentListener", "removeComponentListener" ); // NOI18N
            eventSets[EVENT_containerListener] = new EventSetDescriptor ( components.JListSelector.class, "containerListener", java.awt.event.ContainerListener.class, new String[] {"componentAdded", "componentRemoved"}, "addContainerListener", "removeContainerListener" ); // NOI18N
            eventSets[EVENT_focusListener] = new EventSetDescriptor ( components.JListSelector.class, "focusListener", java.awt.event.FocusListener.class, new String[] {"focusGained", "focusLost"}, "addFocusListener", "removeFocusListener" ); // NOI18N
            eventSets[EVENT_hierarchyBoundsListener] = new EventSetDescriptor ( components.JListSelector.class, "hierarchyBoundsListener", java.awt.event.HierarchyBoundsListener.class, new String[] {"ancestorMoved", "ancestorResized"}, "addHierarchyBoundsListener", "removeHierarchyBoundsListener" ); // NOI18N
            eventSets[EVENT_hierarchyListener] = new EventSetDescriptor ( components.JListSelector.class, "hierarchyListener", java.awt.event.HierarchyListener.class, new String[] {"hierarchyChanged"}, "addHierarchyListener", "removeHierarchyListener" ); // NOI18N
            eventSets[EVENT_inputMethodListener] = new EventSetDescriptor ( components.JListSelector.class, "inputMethodListener", java.awt.event.InputMethodListener.class, new String[] {"inputMethodTextChanged", "caretPositionChanged"}, "addInputMethodListener", "removeInputMethodListener" ); // NOI18N
            eventSets[EVENT_keyListener] = new EventSetDescriptor ( components.JListSelector.class, "keyListener", java.awt.event.KeyListener.class, new String[] {"keyTyped", "keyPressed", "keyReleased"}, "addKeyListener", "removeKeyListener" ); // NOI18N
            eventSets[EVENT_listDataListener] = new EventSetDescriptor ( components.JListSelector.class, "listDataListener", javax.swing.event.ListDataListener.class, new String[] {"intervalAdded", "intervalRemoved", "contentsChanged"}, "addListDataListener", "removeListDataListener" ); // NOI18N
            eventSets[EVENT_listSelectionListener] = new EventSetDescriptor ( components.JListSelector.class, "listSelectionListener", javax.swing.event.ListSelectionListener.class, new String[] {"valueChanged"}, "addListSelectionListener", "removeListSelectionListener" ); // NOI18N
            eventSets[EVENT_mouseListener] = new EventSetDescriptor ( components.JListSelector.class, "mouseListener", java.awt.event.MouseListener.class, new String[] {"mouseClicked", "mousePressed", "mouseReleased", "mouseEntered", "mouseExited"}, "addMouseListener", "removeMouseListener" ); // NOI18N
            eventSets[EVENT_mouseMotionListener] = new EventSetDescriptor ( components.JListSelector.class, "mouseMotionListener", java.awt.event.MouseMotionListener.class, new String[] {"mouseDragged", "mouseMoved"}, "addMouseMotionListener", "removeMouseMotionListener" ); // NOI18N
            eventSets[EVENT_mouseWheelListener] = new EventSetDescriptor ( components.JListSelector.class, "mouseWheelListener", java.awt.event.MouseWheelListener.class, new String[] {"mouseWheelMoved"}, "addMouseWheelListener", "removeMouseWheelListener" ); // NOI18N
            eventSets[EVENT_propertyChangeListener] = new EventSetDescriptor ( components.JListSelector.class, "propertyChangeListener", java.beans.PropertyChangeListener.class, new String[] {"propertyChange"}, "addPropertyChangeListener", "removePropertyChangeListener" ); // NOI18N
            eventSets[EVENT_vetoableChangeListener] = new EventSetDescriptor ( components.JListSelector.class, "vetoableChangeListener", java.beans.VetoableChangeListener.class, new String[] {"vetoableChange"}, "addVetoableChangeListener", "removeVetoableChangeListener" ); // NOI18N
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
     * This returns the image to use to represent JListSelectors.
     * @param iconKind The kind of icon to get.
     * @param resourceName The name for the resource to get the image from, or 
     * null.
     * @return The image representing a JListSelector, or null if no suitable 
     * icon is available.
     * @see #getIcon(int) 
     * @see beans.BeanInfoIconFactory
     * @see beans.BeanInfoIconFactory#createIconImage(int, java.lang.String, java.beans.SimpleBeanInfo) 
     */
    private java.awt.Image createIcon(int iconKind, String resourceName){
        if (iconFactory == null)    // If the icon factory is not initialized yet
            iconFactory = new JListSelectorIconFactory();
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
     * JListSelector.
     */
    public static class JListSelectorIconFactory extends DialogBeanInfoIconFactory{
        /**
         * These are the RGB values for the colors to use for the list part of 
         * the icon. The first value is the RGB value for the color to use for 
         * color icons and the second value is the RGB value for the color to 
         * use for monochrome icons.
         */
        static final int[][] LIST_COLOR_VALUES = {
            {0x6382BF, 0xBFC7CF, 0xD8D9DB, 0xA4BCCE, 0x8CAAC1},
            {0x919191, 0xC7C7C7, 0xDADADA, 0xB9B9B9, 0xA7A7A7}
        };
        /**
         * This stores the values to use to derive the line lengths for each of 
         * the four lines on the list that represent text.
         */
        static final int[] LINE_LENGTH_DIFFERENCES = {0, 3, 1, 6};
        /**
         * This stores the values to use to draw the decorations on the four 
         * lines on the list that represent text. Each two-dimensional array in 
         * this three-dimensional array corresponds to a line. The first array 
         * in each of the two-dimensional arrays represent the location on the 
         * line where the decoration should be, while the second array in each 
         * of the two-dimensional arrays represent the length for that 
         * decoration.
         */
        static final int[][][] LINE_DECORATION_VALUES = {
            {{4, 10, 15}, {2, 1, 2}},
            {{2, 6, 9, 13}, {1, 2, 2, 1}},
            {{1, 4, 6, 10, 14}, {2, 1, 1, 2, 1}},
            {{1, 5, 8}, {1, 2, 1}}
        };
        @Override
        protected boolean getButtonsArePainted() {
            return true;
        }
        /**
         * This returns the value to use as the width of the scroll bar next to 
         * the list.
         * @param scale The scale for the icon (1 for 16x16 icons, 2 for 32x32 
         * icons).
         * @return The width for the scroll bar.
         */
        protected int getScrollBarWidth(int scale){
            return (3*scale)-1;
        }
        /**
         * This returns the values to use for the decorations on the lines on 
         * the list that represent text. The line decorations are used to break 
         * up the lines on the list and add variety to them.This is in the form 
         * of a three-dimensional array, where each two-dimensional array 
         * represents a line. The first array in each of the two-dimensional 
         * arrays represent the location on the line where the decoration should 
         * be, while the second array in each of the two-dimensional arrays 
         * represent the length for that decoration. 
         * 
         * @return The three-dimensional array containing the values for the 
         * line decorations.
         */
        protected int[][][] getLineDecorationValues(){
            return LINE_DECORATION_VALUES;
        }
        /**
         * This paints a 3 x 2 arrow at the given location.
         * @param g The graphics context to paint to.
         * @param x The x-coordinate for the triangle.
         * @param y The y-coordinate for the triangle.
         * @param down Whether the arrow is pointing up or down (false for up, 
         * true for down).
         */
        protected void paintArrow(java.awt.Graphics2D g, int x, int y, 
                boolean down){
            g.drawLine(x+1, y, x+1, y+1);
            if (!down)  // If the arrow is pointing up
                y++;
            g.drawLine(x, y, x+2, y);
        }
        @Override
        protected void paintDialogContents(java.awt.Graphics2D g, int scale, 
                int colorMode, int x, int y, int w, int h) {
               // This is the rectangle used to paint many parts of the list
            java.awt.Rectangle rect = new java.awt.Rectangle(x,y,w,h);
                // Draw the outline around the list
            rect.grow(-1, -1);
            g.setPaint(createOutlineGradient(rect.y,(float)rect.getMaxY(),colorMode));
            g.fill(rect);
                // Draw the background of the list
            rect.grow(-1, -1);
            g.setPaint(createLightBlueFillGradient(rect.y,(float)rect.getMaxY(),colorMode));
                // Get the width for the scroll bar
            int scrollW = getScrollBarWidth(scale);
            rect.width -= (scrollW+1);
            g.fill(rect);
                // Draw the background of the scroll bar
            x += 3 + rect.width;
            y = rect.y;
            if (scale == 2){    // If this is a 32x32 icon
                    // There is enough space for a more detailed scroll bar with 
                    // sections for the up arrow, bar, and down arrow.
                for (int i = 0; i < 3; i++){
                    g.fillRect(x, y, scrollW, 4-(i%2));
                    y += 5-(i%2);
                }
            }
            else
                g.fillRect(x, y, scrollW, rect.height);
                // Draw the bar of the scroll bar
            g.setColor(new java.awt.Color(LIST_COLOR_VALUES[colorMode][0]));
            y = rect.y + scale + (3*(scale >> 1));
            g.drawLine(x, y, x+scrollW-1, y);
            if (scale == 1){    // If this is a 16x16 icon
                    // Draw two pixels at the top and bottom of the scroll bar 
                    // to represent the up and down arrows
                for (int i = 0; i < 2; i++){
                    g.setColor(new java.awt.Color(LIST_COLOR_VALUES[colorMode][1+i]));
                    g.drawLine(x, rect.y+(3*i), x+scrollW-1, rect.y+(3*i));
                }
            }
            else{   // Draw the selection background for the selected line for a 32x32 icon
                g.setPaint(createVerticalGradient(rect.y+3,rect.y+6,
                        LIST_COLOR_VALUES[colorMode][3],LIST_COLOR_VALUES[colorMode][4]));
                g.fillRect(rect.x, rect.y+3, rect.width, 3);
            }
                // Draw the lines on the list
            g.setColor(COMMON_INFO_ICON_COLORS[colorMode][1]);
            rect.grow(-1, -1);
            rect.width--;
            w = rect.x+rect.width;
            g.drawLine(rect.x, rect.y, w, rect.y);
            if (scale == 2){    // If this is a 32x32 icon
                    // Paint the up and down arrows for the scroll bar
                paintArrow(g,x+1,rect.y,false);
                paintArrow(g,x+1,rect.y+9,true);
                    // There is enough space for three more lines on the list.
                y = rect.y + 3;
                    // The next line to draw is the selected second line
                g.setColor(java.awt.Color.WHITE);
                    // A for loop to draw the remaining lines
                for (int i = 1; i < LINE_LENGTH_DIFFERENCES.length; i++, y+=3){
                    g.drawLine(rect.x, y, w-LINE_LENGTH_DIFFERENCES[i], y);
                        // The second line has now been drawn, go back to the 
                    if (i == 1) // regular line color
                        g.setColor(COMMON_INFO_ICON_COLORS[colorMode][1]);
                }
            }
                // Draw the line decorations
            g.setColor(COMMON_INFO_ICON_COLORS[colorMode][0]);
            if (scale == 1)    // If this is a 16x16 icon (there is only one line)
                g.drawLine(rect.x+1, rect.y, rect.x+rect.width-2, rect.y);
            else{
                y = rect.y;
                    // Get the line decoration values
                int[][][] decor = getLineDecorationValues();
                    // A for loop to draw the line decorations on the lines
                for (int i = 0; i < decor.length; i++, y+=3){
                    if (i == 1)     // The second line uses a different color
                        g.setColor(COMMON_INFO_ICON_COLORS[colorMode][2]);
                        // Go through the decorations for the line
                    for (int t = 0; t < decor[i][0].length; t++){
                            // Get the location for the decoration
                        int pos = rect.x+decor[i][0][t];
                        g.drawLine(pos, y, pos+decor[i][1][t]-1, y);
                    }
                    if (i == 1)     // Go back to the regular line decor color
                        g.setColor(COMMON_INFO_ICON_COLORS[colorMode][0]);
                }
            }
        }
    }
    /**
     * This is the PropertyEditor used to set the list selection mode for a 
     * JListSelector and similar components.
     */
    public static class ListSelectionModeEditor extends beans.EnumeratedPropertyEditor{
        @Override
        public String[] getTags() {
            return new String[]{
                "SINGLE",
                "SINGLE_INTERVAL",
                "MULTIPLE_INTERVAL"
            };
        }
        @Override
        public Object[] getValues() {
            return new Object[]{
                javax.swing.ListSelectionModel.SINGLE_SELECTION,
                javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION,
                javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION
            };
        }
        @Override
        public String getNameForValue(Object value){
            return "javax.swing.ListSelectionModel."+getTagForValue(value)+"_SELECTION";
        }
    }
    /**
     * This is the PropertyEditor used to set the list layout orientation for a 
     * JListSelector and similar components.
     */
    public static class ListLayoutOrientationEditor extends beans.EnumeratedPropertyEditor{
        @Override
        public String[] getTags() {
            return new String[]{
                "VERTICAL",
                "HORIZONTAL_WRAP",
                "VERTICAL_WRAP"
            };
        }
        @Override
        public Object[] getValues() {
            return new Object[]{
                javax.swing.JList.VERTICAL,
                javax.swing.JList.HORIZONTAL_WRAP,
                javax.swing.JList.VERTICAL_WRAP
            };
        }
        @Override
        public String getNameForValue(Object value){
            return "javax.swing.JList."+getTagForValue(value);
        }
    }
}
