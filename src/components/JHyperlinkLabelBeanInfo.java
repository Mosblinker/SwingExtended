/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Beans/BeanInfo.java to edit this template
 */
package components;

import beans.BeanInfoIconFactory;
import java.awt.Color;
import java.awt.Font;
import java.beans.*;

/**
 * This is the beans info for JHyperlinkLabel.
 * @author Mosblinker
 * @see JHyperlinkLabel
 */
public class JHyperlinkLabelBeanInfo extends SimpleBeanInfo {

    // Bean descriptor//GEN-FIRST:BeanDescriptor
    /*lazy BeanDescriptor*/
    private static BeanDescriptor getBdescriptor(){
        BeanDescriptor beanDescriptor = new BeanDescriptor  ( components.JHyperlinkLabel.class , null ); // NOI18N
        beanDescriptor.setShortDescription ( "A label used to display hyperlinks" );//GEN-HEADEREND:BeanDescriptor
        // Here you can add code for customizing the BeanDescriptor.

        return beanDescriptor;     }//GEN-LAST:BeanDescriptor


    // Property identifiers//GEN-FIRST:Properties
    private static final int PROPERTY_accessibleContext = 0;
    private static final int PROPERTY_actionMap = 1;
    private static final int PROPERTY_activatedHyperlinkColor = 2;
    private static final int PROPERTY_activatedHyperlinkColorSet = 3;
    private static final int PROPERTY_alignmentX = 4;
    private static final int PROPERTY_alignmentY = 5;
    private static final int PROPERTY_ancestorListeners = 6;
    private static final int PROPERTY_autoscrolls = 7;
    private static final int PROPERTY_background = 8;
    private static final int PROPERTY_backgroundSet = 9;
    private static final int PROPERTY_baselineResizeBehavior = 10;
    private static final int PROPERTY_border = 11;
    private static final int PROPERTY_bounds = 12;
    private static final int PROPERTY_colorModel = 13;
    private static final int PROPERTY_component = 14;
    private static final int PROPERTY_componentCount = 15;
    private static final int PROPERTY_componentListeners = 16;
    private static final int PROPERTY_componentOrientation = 17;
    private static final int PROPERTY_componentPopupMenu = 18;
    private static final int PROPERTY_components = 19;
    private static final int PROPERTY_containerListeners = 20;
    private static final int PROPERTY_cursor = 21;
    private static final int PROPERTY_cursorSet = 22;
    private static final int PROPERTY_debugGraphicsOptions = 23;
    private static final int PROPERTY_disabledIcon = 24;
    private static final int PROPERTY_displayable = 25;
    private static final int PROPERTY_displayedMnemonic = 26;
    private static final int PROPERTY_displayedMnemonicIndex = 27;
    private static final int PROPERTY_doubleBuffered = 28;
    private static final int PROPERTY_dropTarget = 29;
    private static final int PROPERTY_enabled = 30;
    private static final int PROPERTY_failureMessagesAreShown = 31;
    private static final int PROPERTY_focusable = 32;
    private static final int PROPERTY_focusCycleRoot = 33;
    private static final int PROPERTY_focusCycleRootAncestor = 34;
    private static final int PROPERTY_focusListeners = 35;
    private static final int PROPERTY_focusOwner = 36;
    private static final int PROPERTY_focusTraversable = 37;
    private static final int PROPERTY_focusTraversalKeys = 38;
    private static final int PROPERTY_focusTraversalKeysEnabled = 39;
    private static final int PROPERTY_focusTraversalPolicy = 40;
    private static final int PROPERTY_focusTraversalPolicyProvider = 41;
    private static final int PROPERTY_focusTraversalPolicySet = 42;
    private static final int PROPERTY_font = 43;
    private static final int PROPERTY_fontSet = 44;
    private static final int PROPERTY_foreground = 45;
    private static final int PROPERTY_foregroundSet = 46;
    private static final int PROPERTY_graphics = 47;
    private static final int PROPERTY_graphicsConfiguration = 48;
    private static final int PROPERTY_handCursor = 49;
    private static final int PROPERTY_handCursorSet = 50;
    private static final int PROPERTY_height = 51;
    private static final int PROPERTY_hierarchyBoundsListeners = 52;
    private static final int PROPERTY_hierarchyListeners = 53;
    private static final int PROPERTY_horizontalAlignment = 54;
    private static final int PROPERTY_horizontalTextPosition = 55;
    private static final int PROPERTY_icon = 56;
    private static final int PROPERTY_iconTextGap = 57;
    private static final int PROPERTY_ignoreRepaint = 58;
    private static final int PROPERTY_inheritsPopupMenu = 59;
    private static final int PROPERTY_inputContext = 60;
    private static final int PROPERTY_inputMap = 61;
    private static final int PROPERTY_inputMethodListeners = 62;
    private static final int PROPERTY_inputMethodRequests = 63;
    private static final int PROPERTY_inputVerifier = 64;
    private static final int PROPERTY_insets = 65;
    private static final int PROPERTY_keyListeners = 66;
    private static final int PROPERTY_labelFor = 67;
    private static final int PROPERTY_layout = 68;
    private static final int PROPERTY_lightweight = 69;
    private static final int PROPERTY_locale = 70;
    private static final int PROPERTY_location = 71;
    private static final int PROPERTY_locationOnScreen = 72;
    private static final int PROPERTY_managingFocus = 73;
    private static final int PROPERTY_maximumSize = 74;
    private static final int PROPERTY_maximumSizeSet = 75;
    private static final int PROPERTY_minimumSize = 76;
    private static final int PROPERTY_minimumSizeSet = 77;
    private static final int PROPERTY_mixingCutoutShape = 78;
    private static final int PROPERTY_mouseListeners = 79;
    private static final int PROPERTY_mouseMotionListeners = 80;
    private static final int PROPERTY_mousePosition = 81;
    private static final int PROPERTY_mouseWheelListeners = 82;
    private static final int PROPERTY_name = 83;
    private static final int PROPERTY_nextFocusableComponent = 84;
    private static final int PROPERTY_opaque = 85;
    private static final int PROPERTY_optimizedDrawingEnabled = 86;
    private static final int PROPERTY_paintingForPrint = 87;
    private static final int PROPERTY_paintingTile = 88;
    private static final int PROPERTY_parent = 89;
    private static final int PROPERTY_preferredSize = 90;
    private static final int PROPERTY_preferredSizeSet = 91;
    private static final int PROPERTY_propertyChangeListeners = 92;
    private static final int PROPERTY_registeredKeyStrokes = 93;
    private static final int PROPERTY_requestFocusEnabled = 94;
    private static final int PROPERTY_rootPane = 95;
    private static final int PROPERTY_showing = 96;
    private static final int PROPERTY_size = 97;
    private static final int PROPERTY_text = 98;
    private static final int PROPERTY_toolkit = 99;
    private static final int PROPERTY_toolTipText = 100;
    private static final int PROPERTY_toolTipTextSet = 101;
    private static final int PROPERTY_topLevelAncestor = 102;
    private static final int PROPERTY_transferHandler = 103;
    private static final int PROPERTY_treeLock = 104;
    private static final int PROPERTY_UI = 105;
    private static final int PROPERTY_UIClassID = 106;
    private static final int PROPERTY_unvisitedHyperlinkColor = 107;
    private static final int PROPERTY_unvisitedHyperlinkColorSet = 108;
    private static final int PROPERTY_URI = 109;
    private static final int PROPERTY_valid = 110;
    private static final int PROPERTY_validateRoot = 111;
    private static final int PROPERTY_verifyInputWhenFocusTarget = 112;
    private static final int PROPERTY_verticalAlignment = 113;
    private static final int PROPERTY_verticalTextPosition = 114;
    private static final int PROPERTY_vetoableChangeListeners = 115;
    private static final int PROPERTY_visible = 116;
    private static final int PROPERTY_visibleRect = 117;
    private static final int PROPERTY_visited = 118;
    private static final int PROPERTY_visitedHyperlinkColor = 119;
    private static final int PROPERTY_visitedHyperlinkColorSet = 120;
    private static final int PROPERTY_width = 121;
    private static final int PROPERTY_x = 122;
    private static final int PROPERTY_y = 123;

    // Property array 
    /*lazy PropertyDescriptor*/
    private static PropertyDescriptor[] getPdescriptor(){
        PropertyDescriptor[] properties = new PropertyDescriptor[124];
    
        try {
            properties[PROPERTY_accessibleContext] = new PropertyDescriptor ( "accessibleContext", components.JHyperlinkLabel.class, "getAccessibleContext", null ); // NOI18N
            properties[PROPERTY_accessibleContext].setHidden ( true );
            properties[PROPERTY_actionMap] = new PropertyDescriptor ( "actionMap", components.JHyperlinkLabel.class, "getActionMap", "setActionMap" ); // NOI18N
            properties[PROPERTY_actionMap].setHidden ( true );
            properties[PROPERTY_activatedHyperlinkColor] = new PropertyDescriptor ( "activatedHyperlinkColor", components.JHyperlinkLabel.class, "getActivatedHyperlinkColor", "setActivatedHyperlinkColor" ); // NOI18N
            properties[PROPERTY_activatedHyperlinkColor].setShortDescription ( "The color to use for the hyperlink when it is activated." );
            properties[PROPERTY_activatedHyperlinkColor].setBound ( true );
            properties[PROPERTY_activatedHyperlinkColorSet] = new PropertyDescriptor ( "activatedHyperlinkColorSet", components.JHyperlinkLabel.class, "isActivatedHyperlinkColorSet", null ); // NOI18N
            properties[PROPERTY_activatedHyperlinkColorSet].setHidden ( true );
            properties[PROPERTY_alignmentX] = new PropertyDescriptor ( "alignmentX", components.JHyperlinkLabel.class, "getAlignmentX", "setAlignmentX" ); // NOI18N
            properties[PROPERTY_alignmentX].setShortDescription ( "The preferred horizontal alignment of the component." );
            properties[PROPERTY_alignmentY] = new PropertyDescriptor ( "alignmentY", components.JHyperlinkLabel.class, "getAlignmentY", "setAlignmentY" ); // NOI18N
            properties[PROPERTY_alignmentY].setShortDescription ( "The preferred vertical alignment of the component." );
            properties[PROPERTY_ancestorListeners] = new PropertyDescriptor ( "ancestorListeners", components.JHyperlinkLabel.class, "getAncestorListeners", null ); // NOI18N
            properties[PROPERTY_ancestorListeners].setHidden ( true );
            properties[PROPERTY_autoscrolls] = new PropertyDescriptor ( "autoscrolls", components.JHyperlinkLabel.class, "getAutoscrolls", "setAutoscrolls" ); // NOI18N
            properties[PROPERTY_autoscrolls].setShortDescription ( "Determines if this component automatically scrolls its contents when dragged." );
            properties[PROPERTY_background] = new PropertyDescriptor ( "background", components.JHyperlinkLabel.class, "getBackground", "setBackground" ); // NOI18N
            properties[PROPERTY_background].setPreferred ( true );
            properties[PROPERTY_background].setShortDescription ( "The background color of the component." );
            properties[PROPERTY_background].setBound ( true );
            properties[PROPERTY_backgroundSet] = new PropertyDescriptor ( "backgroundSet", components.JHyperlinkLabel.class, "isBackgroundSet", null ); // NOI18N
            properties[PROPERTY_backgroundSet].setHidden ( true );
            properties[PROPERTY_baselineResizeBehavior] = new PropertyDescriptor ( "baselineResizeBehavior", components.JHyperlinkLabel.class, "getBaselineResizeBehavior", null ); // NOI18N
            properties[PROPERTY_baselineResizeBehavior].setExpert ( true );
            properties[PROPERTY_border] = new PropertyDescriptor ( "border", components.JHyperlinkLabel.class, "getBorder", "setBorder" ); // NOI18N
            properties[PROPERTY_border].setShortDescription ( "The component's border." );
            properties[PROPERTY_border].setBound ( true );
            properties[PROPERTY_bounds] = new PropertyDescriptor ( "bounds", components.JHyperlinkLabel.class, "getBounds", "setBounds" ); // NOI18N
            properties[PROPERTY_bounds].setHidden ( true );
            properties[PROPERTY_colorModel] = new PropertyDescriptor ( "colorModel", components.JHyperlinkLabel.class, "getColorModel", null ); // NOI18N
            properties[PROPERTY_colorModel].setHidden ( true );
            properties[PROPERTY_component] = new IndexedPropertyDescriptor ( "component", components.JHyperlinkLabel.class, null, null, "getComponent", null ); // NOI18N
            properties[PROPERTY_componentCount] = new PropertyDescriptor ( "componentCount", components.JHyperlinkLabel.class, "getComponentCount", null ); // NOI18N
            properties[PROPERTY_componentCount].setHidden ( true );
            properties[PROPERTY_componentListeners] = new PropertyDescriptor ( "componentListeners", components.JHyperlinkLabel.class, "getComponentListeners", null ); // NOI18N
            properties[PROPERTY_componentListeners].setHidden ( true );
            properties[PROPERTY_componentOrientation] = new PropertyDescriptor ( "componentOrientation", components.JHyperlinkLabel.class, "getComponentOrientation", "setComponentOrientation" ); // NOI18N
            properties[PROPERTY_componentOrientation].setHidden ( true );
            properties[PROPERTY_componentPopupMenu] = new PropertyDescriptor ( "componentPopupMenu", components.JHyperlinkLabel.class, "getComponentPopupMenu", "setComponentPopupMenu" ); // NOI18N
            properties[PROPERTY_componentPopupMenu].setShortDescription ( "The popup menu to show" );
            properties[PROPERTY_componentPopupMenu].setBound ( true );
            properties[PROPERTY_components] = new PropertyDescriptor ( "components", components.JHyperlinkLabel.class, "getComponents", null ); // NOI18N
            properties[PROPERTY_components].setHidden ( true );
            properties[PROPERTY_containerListeners] = new PropertyDescriptor ( "containerListeners", components.JHyperlinkLabel.class, "getContainerListeners", null ); // NOI18N
            properties[PROPERTY_containerListeners].setHidden ( true );
            properties[PROPERTY_cursor] = new PropertyDescriptor ( "cursor", components.JHyperlinkLabel.class, "getCursor", "setCursor" ); // NOI18N
            properties[PROPERTY_cursorSet] = new PropertyDescriptor ( "cursorSet", components.JHyperlinkLabel.class, "isCursorSet", null ); // NOI18N
            properties[PROPERTY_cursorSet].setHidden ( true );
            properties[PROPERTY_debugGraphicsOptions] = new PropertyDescriptor ( "debugGraphicsOptions", components.JHyperlinkLabel.class, "getDebugGraphicsOptions", "setDebugGraphicsOptions" ); // NOI18N
            properties[PROPERTY_debugGraphicsOptions].setShortDescription ( "Diagnostic options for graphics operations." );
            properties[PROPERTY_disabledIcon] = new PropertyDescriptor ( "disabledIcon", components.JHyperlinkLabel.class, "getDisabledIcon", "setDisabledIcon" ); // NOI18N
            properties[PROPERTY_disabledIcon].setShortDescription ( "The icon to display if the label is disabled." );
            properties[PROPERTY_displayable] = new PropertyDescriptor ( "displayable", components.JHyperlinkLabel.class, "isDisplayable", null ); // NOI18N
            properties[PROPERTY_displayable].setHidden ( true );
            properties[PROPERTY_displayedMnemonic] = new PropertyDescriptor ( "displayedMnemonic", components.JHyperlinkLabel.class, "getDisplayedMnemonic", null ); // NOI18N
            properties[PROPERTY_displayedMnemonic].setPreferred ( true );
            properties[PROPERTY_displayedMnemonic].setShortDescription ( "The mnemonic keycode." );
            properties[PROPERTY_displayedMnemonicIndex] = new PropertyDescriptor ( "displayedMnemonicIndex", components.JHyperlinkLabel.class, "getDisplayedMnemonicIndex", "setDisplayedMnemonicIndex" ); // NOI18N
            properties[PROPERTY_displayedMnemonicIndex].setShortDescription ( "The index into the String to draw the keyboard character mnemonic at" );
            properties[PROPERTY_doubleBuffered] = new PropertyDescriptor ( "doubleBuffered", components.JHyperlinkLabel.class, "isDoubleBuffered", "setDoubleBuffered" ); // NOI18N
            properties[PROPERTY_dropTarget] = new PropertyDescriptor ( "dropTarget", components.JHyperlinkLabel.class, "getDropTarget", "setDropTarget" ); // NOI18N
            properties[PROPERTY_dropTarget].setHidden ( true );
            properties[PROPERTY_enabled] = new PropertyDescriptor ( "enabled", components.JHyperlinkLabel.class, "isEnabled", "setEnabled" ); // NOI18N
            properties[PROPERTY_enabled].setShortDescription ( "The enabled state of the component." );
            properties[PROPERTY_enabled].setBound ( true );
            properties[PROPERTY_failureMessagesAreShown] = new PropertyDescriptor ( "failureMessagesAreShown", components.JHyperlinkLabel.class, "getFailureMessagesAreShown", "setFailureMessagesAreShown" ); // NOI18N
            properties[PROPERTY_failureMessagesAreShown].setShortDescription ( "Whether error messages will be shown to the user if and when this fails to open the hyperlink." );
            properties[PROPERTY_failureMessagesAreShown].setBound ( true );
            properties[PROPERTY_focusable] = new PropertyDescriptor ( "focusable", components.JHyperlinkLabel.class, "isFocusable", "setFocusable" ); // NOI18N
            properties[PROPERTY_focusCycleRoot] = new PropertyDescriptor ( "focusCycleRoot", components.JHyperlinkLabel.class, "isFocusCycleRoot", "setFocusCycleRoot" ); // NOI18N
            properties[PROPERTY_focusCycleRootAncestor] = new PropertyDescriptor ( "focusCycleRootAncestor", components.JHyperlinkLabel.class, "getFocusCycleRootAncestor", null ); // NOI18N
            properties[PROPERTY_focusCycleRootAncestor].setHidden ( true );
            properties[PROPERTY_focusListeners] = new PropertyDescriptor ( "focusListeners", components.JHyperlinkLabel.class, "getFocusListeners", null ); // NOI18N
            properties[PROPERTY_focusListeners].setHidden ( true );
            properties[PROPERTY_focusOwner] = new PropertyDescriptor ( "focusOwner", components.JHyperlinkLabel.class, "isFocusOwner", null ); // NOI18N
            properties[PROPERTY_focusOwner].setHidden ( true );
            properties[PROPERTY_focusTraversable] = new PropertyDescriptor ( "focusTraversable", components.JHyperlinkLabel.class, "isFocusTraversable", null ); // NOI18N
            properties[PROPERTY_focusTraversable].setHidden ( true );
            properties[PROPERTY_focusTraversalKeys] = new IndexedPropertyDescriptor ( "focusTraversalKeys", components.JHyperlinkLabel.class, null, null, null, "setFocusTraversalKeys" ); // NOI18N
            properties[PROPERTY_focusTraversalKeysEnabled] = new PropertyDescriptor ( "focusTraversalKeysEnabled", components.JHyperlinkLabel.class, "getFocusTraversalKeysEnabled", "setFocusTraversalKeysEnabled" ); // NOI18N
            properties[PROPERTY_focusTraversalKeysEnabled].setHidden ( true );
            properties[PROPERTY_focusTraversalPolicy] = new PropertyDescriptor ( "focusTraversalPolicy", components.JHyperlinkLabel.class, "getFocusTraversalPolicy", "setFocusTraversalPolicy" ); // NOI18N
            properties[PROPERTY_focusTraversalPolicyProvider] = new PropertyDescriptor ( "focusTraversalPolicyProvider", components.JHyperlinkLabel.class, "isFocusTraversalPolicyProvider", "setFocusTraversalPolicyProvider" ); // NOI18N
            properties[PROPERTY_focusTraversalPolicySet] = new PropertyDescriptor ( "focusTraversalPolicySet", components.JHyperlinkLabel.class, "isFocusTraversalPolicySet", null ); // NOI18N
            properties[PROPERTY_focusTraversalPolicySet].setHidden ( true );
            properties[PROPERTY_font] = new PropertyDescriptor ( "font", components.JHyperlinkLabel.class, "getFont", "setFont" ); // NOI18N
            properties[PROPERTY_font].setPreferred ( true );
            properties[PROPERTY_font].setShortDescription ( "The font for the component." );
            properties[PROPERTY_font].setBound ( true );
            properties[PROPERTY_fontSet] = new PropertyDescriptor ( "fontSet", components.JHyperlinkLabel.class, "isFontSet", null ); // NOI18N
            properties[PROPERTY_fontSet].setHidden ( true );
            properties[PROPERTY_foreground] = new PropertyDescriptor ( "foreground", components.JHyperlinkLabel.class, "getForeground", "setForeground" ); // NOI18N
            properties[PROPERTY_foreground].setPreferred ( true );
            properties[PROPERTY_foreground].setShortDescription ( "The foreground color of the component." );
            properties[PROPERTY_foreground].setBound ( true );
            properties[PROPERTY_foregroundSet] = new PropertyDescriptor ( "foregroundSet", components.JHyperlinkLabel.class, "isForegroundSet", null ); // NOI18N
            properties[PROPERTY_foregroundSet].setHidden ( true );
            properties[PROPERTY_graphics] = new PropertyDescriptor ( "graphics", components.JHyperlinkLabel.class, "getGraphics", null ); // NOI18N
            properties[PROPERTY_graphics].setHidden ( true );
            properties[PROPERTY_graphicsConfiguration] = new PropertyDescriptor ( "graphicsConfiguration", components.JHyperlinkLabel.class, "getGraphicsConfiguration", null ); // NOI18N
            properties[PROPERTY_graphicsConfiguration].setHidden ( true );
            properties[PROPERTY_handCursor] = new PropertyDescriptor ( "handCursor", components.JHyperlinkLabel.class, "getHandCursor", "setHandCursor" ); // NOI18N
            properties[PROPERTY_handCursorSet] = new PropertyDescriptor ( "handCursorSet", components.JHyperlinkLabel.class, "isHandCursorSet", null ); // NOI18N
            properties[PROPERTY_handCursorSet].setHidden ( true );
            properties[PROPERTY_height] = new PropertyDescriptor ( "height", components.JHyperlinkLabel.class, "getHeight", null ); // NOI18N
            properties[PROPERTY_height].setHidden ( true );
            properties[PROPERTY_hierarchyBoundsListeners] = new PropertyDescriptor ( "hierarchyBoundsListeners", components.JHyperlinkLabel.class, "getHierarchyBoundsListeners", null ); // NOI18N
            properties[PROPERTY_hierarchyBoundsListeners].setHidden ( true );
            properties[PROPERTY_hierarchyListeners] = new PropertyDescriptor ( "hierarchyListeners", components.JHyperlinkLabel.class, "getHierarchyListeners", null ); // NOI18N
            properties[PROPERTY_hierarchyListeners].setHidden ( true );
            properties[PROPERTY_horizontalAlignment] = new PropertyDescriptor ( "horizontalAlignment", components.JHyperlinkLabel.class, "getHorizontalAlignment", "setHorizontalAlignment" ); // NOI18N
            properties[PROPERTY_horizontalAlignment].setPreferred ( true );
            properties[PROPERTY_horizontalAlignment].setShortDescription ( "The alignment of the label's content along the X axis." );
            properties[PROPERTY_horizontalAlignment].setPropertyEditorClass ( beans.HorizontalAlignmentEditor.class );
            properties[PROPERTY_horizontalTextPosition] = new PropertyDescriptor ( "horizontalTextPosition", components.JHyperlinkLabel.class, "getHorizontalTextPosition", "setHorizontalTextPosition" ); // NOI18N
            properties[PROPERTY_horizontalTextPosition].setShortDescription ( "The horizontal position of the label's text, relative to its image." );
            properties[PROPERTY_horizontalTextPosition].setPropertyEditorClass ( beans.HorizontalAlignmentEditor.class );
            properties[PROPERTY_icon] = new PropertyDescriptor ( "icon", components.JHyperlinkLabel.class, "getIcon", "setIcon" ); // NOI18N
            properties[PROPERTY_icon].setPreferred ( true );
            properties[PROPERTY_icon].setShortDescription ( "The icon this component will display." );
            properties[PROPERTY_icon].setBound ( true );
            properties[PROPERTY_iconTextGap] = new PropertyDescriptor ( "iconTextGap", components.JHyperlinkLabel.class, "getIconTextGap", "setIconTextGap" ); // NOI18N
            properties[PROPERTY_iconTextGap].setShortDescription ( "If both the icon and text properties are set, this property defines the space between them." );
            properties[PROPERTY_iconTextGap].setBound ( true );
            properties[PROPERTY_ignoreRepaint] = new PropertyDescriptor ( "ignoreRepaint", components.JHyperlinkLabel.class, "getIgnoreRepaint", "setIgnoreRepaint" ); // NOI18N
            properties[PROPERTY_ignoreRepaint].setHidden ( true );
            properties[PROPERTY_inheritsPopupMenu] = new PropertyDescriptor ( "inheritsPopupMenu", components.JHyperlinkLabel.class, "getInheritsPopupMenu", "setInheritsPopupMenu" ); // NOI18N
            properties[PROPERTY_inheritsPopupMenu].setShortDescription ( "Whether or not the JPopupMenu is inherited" );
            properties[PROPERTY_inheritsPopupMenu].setBound ( true );
            properties[PROPERTY_inputContext] = new PropertyDescriptor ( "inputContext", components.JHyperlinkLabel.class, "getInputContext", null ); // NOI18N
            properties[PROPERTY_inputContext].setHidden ( true );
            properties[PROPERTY_inputMap] = new PropertyDescriptor ( "inputMap", components.JHyperlinkLabel.class, "getInputMap", null ); // NOI18N
            properties[PROPERTY_inputMap].setHidden ( true );
            properties[PROPERTY_inputMethodListeners] = new PropertyDescriptor ( "inputMethodListeners", components.JHyperlinkLabel.class, "getInputMethodListeners", null ); // NOI18N
            properties[PROPERTY_inputMethodListeners].setHidden ( true );
            properties[PROPERTY_inputMethodRequests] = new PropertyDescriptor ( "inputMethodRequests", components.JHyperlinkLabel.class, "getInputMethodRequests", null ); // NOI18N
            properties[PROPERTY_inputMethodRequests].setHidden ( true );
            properties[PROPERTY_inputVerifier] = new PropertyDescriptor ( "inputVerifier", components.JHyperlinkLabel.class, "getInputVerifier", "setInputVerifier" ); // NOI18N
            properties[PROPERTY_inputVerifier].setShortDescription ( "The component's input verifier." );
            properties[PROPERTY_insets] = new PropertyDescriptor ( "insets", components.JHyperlinkLabel.class, "getInsets", null ); // NOI18N
            properties[PROPERTY_insets].setExpert ( true );
            properties[PROPERTY_keyListeners] = new PropertyDescriptor ( "keyListeners", components.JHyperlinkLabel.class, "getKeyListeners", null ); // NOI18N
            properties[PROPERTY_keyListeners].setHidden ( true );
            properties[PROPERTY_labelFor] = new PropertyDescriptor ( "labelFor", components.JHyperlinkLabel.class, "getLabelFor", "setLabelFor" ); // NOI18N
            properties[PROPERTY_labelFor].setShortDescription ( "The component this is labelling." );
            properties[PROPERTY_layout] = new PropertyDescriptor ( "layout", components.JHyperlinkLabel.class, "getLayout", "setLayout" ); // NOI18N
            properties[PROPERTY_layout].setHidden ( true );
            properties[PROPERTY_lightweight] = new PropertyDescriptor ( "lightweight", components.JHyperlinkLabel.class, "isLightweight", null ); // NOI18N
            properties[PROPERTY_lightweight].setHidden ( true );
            properties[PROPERTY_locale] = new PropertyDescriptor ( "locale", components.JHyperlinkLabel.class, "getLocale", "setLocale" ); // NOI18N
            properties[PROPERTY_locale].setHidden ( true );
            properties[PROPERTY_location] = new PropertyDescriptor ( "location", components.JHyperlinkLabel.class, "getLocation", "setLocation" ); // NOI18N
            properties[PROPERTY_location].setHidden ( true );
            properties[PROPERTY_locationOnScreen] = new PropertyDescriptor ( "locationOnScreen", components.JHyperlinkLabel.class, "getLocationOnScreen", null ); // NOI18N
            properties[PROPERTY_locationOnScreen].setHidden ( true );
            properties[PROPERTY_managingFocus] = new PropertyDescriptor ( "managingFocus", components.JHyperlinkLabel.class, "isManagingFocus", null ); // NOI18N
            properties[PROPERTY_managingFocus].setHidden ( true );
            properties[PROPERTY_maximumSize] = new PropertyDescriptor ( "maximumSize", components.JHyperlinkLabel.class, "getMaximumSize", "setMaximumSize" ); // NOI18N
            properties[PROPERTY_maximumSize].setShortDescription ( "The maximum size of the component." );
            properties[PROPERTY_maximumSize].setBound ( true );
            properties[PROPERTY_maximumSizeSet] = new PropertyDescriptor ( "maximumSizeSet", components.JHyperlinkLabel.class, "isMaximumSizeSet", null ); // NOI18N
            properties[PROPERTY_maximumSizeSet].setHidden ( true );
            properties[PROPERTY_minimumSize] = new PropertyDescriptor ( "minimumSize", components.JHyperlinkLabel.class, "getMinimumSize", "setMinimumSize" ); // NOI18N
            properties[PROPERTY_minimumSize].setShortDescription ( "The minimum size of the component." );
            properties[PROPERTY_minimumSize].setBound ( true );
            properties[PROPERTY_minimumSizeSet] = new PropertyDescriptor ( "minimumSizeSet", components.JHyperlinkLabel.class, "isMinimumSizeSet", null ); // NOI18N
            properties[PROPERTY_minimumSizeSet].setHidden ( true );
            properties[PROPERTY_mixingCutoutShape] = new PropertyDescriptor ( "mixingCutoutShape", components.JHyperlinkLabel.class, null, "setMixingCutoutShape" ); // NOI18N
            properties[PROPERTY_mixingCutoutShape].setHidden ( true );
            properties[PROPERTY_mouseListeners] = new PropertyDescriptor ( "mouseListeners", components.JHyperlinkLabel.class, "getMouseListeners", null ); // NOI18N
            properties[PROPERTY_mouseListeners].setHidden ( true );
            properties[PROPERTY_mouseMotionListeners] = new PropertyDescriptor ( "mouseMotionListeners", components.JHyperlinkLabel.class, "getMouseMotionListeners", null ); // NOI18N
            properties[PROPERTY_mouseMotionListeners].setHidden ( true );
            properties[PROPERTY_mousePosition] = new PropertyDescriptor ( "mousePosition", components.JHyperlinkLabel.class, "getMousePosition", null ); // NOI18N
            properties[PROPERTY_mousePosition].setHidden ( true );
            properties[PROPERTY_mouseWheelListeners] = new PropertyDescriptor ( "mouseWheelListeners", components.JHyperlinkLabel.class, "getMouseWheelListeners", null ); // NOI18N
            properties[PROPERTY_mouseWheelListeners].setHidden ( true );
            properties[PROPERTY_name] = new PropertyDescriptor ( "name", components.JHyperlinkLabel.class, "getName", "setName" ); // NOI18N
            properties[PROPERTY_name].setBound ( true );
            properties[PROPERTY_nextFocusableComponent] = new PropertyDescriptor ( "nextFocusableComponent", components.JHyperlinkLabel.class, "getNextFocusableComponent", "setNextFocusableComponent" ); // NOI18N
            properties[PROPERTY_opaque] = new PropertyDescriptor ( "opaque", components.JHyperlinkLabel.class, "isOpaque", "setOpaque" ); // NOI18N
            properties[PROPERTY_opaque].setShortDescription ( "The component's opacity" );
            properties[PROPERTY_optimizedDrawingEnabled] = new PropertyDescriptor ( "optimizedDrawingEnabled", components.JHyperlinkLabel.class, "isOptimizedDrawingEnabled", null ); // NOI18N
            properties[PROPERTY_optimizedDrawingEnabled].setHidden ( true );
            properties[PROPERTY_paintingForPrint] = new PropertyDescriptor ( "paintingForPrint", components.JHyperlinkLabel.class, "isPaintingForPrint", null ); // NOI18N
            properties[PROPERTY_paintingTile] = new PropertyDescriptor ( "paintingTile", components.JHyperlinkLabel.class, "isPaintingTile", null ); // NOI18N
            properties[PROPERTY_paintingTile].setHidden ( true );
            properties[PROPERTY_parent] = new PropertyDescriptor ( "parent", components.JHyperlinkLabel.class, "getParent", null ); // NOI18N
            properties[PROPERTY_parent].setHidden ( true );
            properties[PROPERTY_preferredSize] = new PropertyDescriptor ( "preferredSize", components.JHyperlinkLabel.class, "getPreferredSize", "setPreferredSize" ); // NOI18N
            properties[PROPERTY_preferredSize].setShortDescription ( "The preferred size of the component." );
            properties[PROPERTY_preferredSize].setBound ( true );
            properties[PROPERTY_preferredSizeSet] = new PropertyDescriptor ( "preferredSizeSet", components.JHyperlinkLabel.class, "isPreferredSizeSet", null ); // NOI18N
            properties[PROPERTY_preferredSizeSet].setHidden ( true );
            properties[PROPERTY_propertyChangeListeners] = new PropertyDescriptor ( "propertyChangeListeners", components.JHyperlinkLabel.class, "getPropertyChangeListeners", null ); // NOI18N
            properties[PROPERTY_propertyChangeListeners].setHidden ( true );
            properties[PROPERTY_registeredKeyStrokes] = new PropertyDescriptor ( "registeredKeyStrokes", components.JHyperlinkLabel.class, "getRegisteredKeyStrokes", null ); // NOI18N
            properties[PROPERTY_registeredKeyStrokes].setHidden ( true );
            properties[PROPERTY_requestFocusEnabled] = new PropertyDescriptor ( "requestFocusEnabled", components.JHyperlinkLabel.class, "isRequestFocusEnabled", "setRequestFocusEnabled" ); // NOI18N
            properties[PROPERTY_rootPane] = new PropertyDescriptor ( "rootPane", components.JHyperlinkLabel.class, "getRootPane", null ); // NOI18N
            properties[PROPERTY_rootPane].setHidden ( true );
            properties[PROPERTY_selectedHyperlinkColor] = new PropertyDescriptor ( "selectedHyperlinkColor", components.JHyperlinkLabel.class, "getSelectedHyperlinkColor", "setSelectedHyperlinkColor" ); // NOI18N
            properties[PROPERTY_selectedHyperlinkColor].setShortDescription ( "The color to use for the hyperlink when it is selected." );
            properties[PROPERTY_selectedHyperlinkColor].setBound ( true );
            properties[PROPERTY_selectedHyperlinkColorSet] = new PropertyDescriptor ( "selectedHyperlinkColorSet", components.JHyperlinkLabel.class, "isSelectedHyperlinkColorSet", null ); // NOI18N
            properties[PROPERTY_selectedHyperlinkColorSet].setHidden ( true );
            properties[PROPERTY_showing] = new PropertyDescriptor ( "showing", components.JHyperlinkLabel.class, "isShowing", null ); // NOI18N
            properties[PROPERTY_showing].setHidden ( true );
            properties[PROPERTY_size] = new PropertyDescriptor ( "size", components.JHyperlinkLabel.class, "getSize", "setSize" ); // NOI18N
            properties[PROPERTY_size].setHidden ( true );
            properties[PROPERTY_text] = new PropertyDescriptor ( "text", components.JHyperlinkLabel.class, "getText", "setText" ); // NOI18N
            properties[PROPERTY_text].setPreferred ( true );
            properties[PROPERTY_text].setShortDescription ( "Defines the single line of text this component will display." );
            properties[PROPERTY_text].setBound ( true );
            properties[PROPERTY_toolkit] = new PropertyDescriptor ( "toolkit", components.JHyperlinkLabel.class, "getToolkit", null ); // NOI18N
            properties[PROPERTY_toolkit].setHidden ( true );
            properties[PROPERTY_toolTipText] = new PropertyDescriptor ( "toolTipText", components.JHyperlinkLabel.class, "getToolTipText", "setToolTipText" ); // NOI18N
            properties[PROPERTY_toolTipText].setPreferred ( true );
            properties[PROPERTY_toolTipText].setShortDescription ( "The text to display in a tool tip." );
            properties[PROPERTY_toolTipTextSet] = new PropertyDescriptor ( "toolTipTextSet", components.JHyperlinkLabel.class, "isToolTipTextSet", null ); // NOI18N
            properties[PROPERTY_toolTipTextSet].setHidden ( true );
            properties[PROPERTY_topLevelAncestor] = new PropertyDescriptor ( "topLevelAncestor", components.JHyperlinkLabel.class, "getTopLevelAncestor", null ); // NOI18N
            properties[PROPERTY_topLevelAncestor].setHidden ( true );
            properties[PROPERTY_transferHandler] = new PropertyDescriptor ( "transferHandler", components.JHyperlinkLabel.class, "getTransferHandler", "setTransferHandler" ); // NOI18N
            properties[PROPERTY_transferHandler].setHidden ( true );
            properties[PROPERTY_transferHandler].setShortDescription ( "Mechanism for transfer of data to and from the component" );
            properties[PROPERTY_treeLock] = new PropertyDescriptor ( "treeLock", components.JHyperlinkLabel.class, "getTreeLock", null ); // NOI18N
            properties[PROPERTY_treeLock].setHidden ( true );
            properties[PROPERTY_UI] = new PropertyDescriptor ( "UI", components.JHyperlinkLabel.class, "getUI", "setUI" ); // NOI18N
            properties[PROPERTY_UI].setHidden ( true );
            properties[PROPERTY_UI].setShortDescription ( "The UI object that implements the Component's LookAndFeel." );
            properties[PROPERTY_UIClassID] = new PropertyDescriptor ( "UIClassID", components.JHyperlinkLabel.class, "getUIClassID", null ); // NOI18N
            properties[PROPERTY_unvisitedHyperlinkColor] = new PropertyDescriptor ( "unvisitedHyperlinkColor", components.JHyperlinkLabel.class, "getUnvisitedHyperlinkColor", "setUnvisitedHyperlinkColor" ); // NOI18N
            properties[PROPERTY_unvisitedHyperlinkColor].setShortDescription ( "The color to use for hyperlinks that have not been visited yet." );
            properties[PROPERTY_unvisitedHyperlinkColor].setBound ( true );
            properties[PROPERTY_unvisitedHyperlinkColorSet] = new PropertyDescriptor ( "unvisitedHyperlinkColorSet", components.JHyperlinkLabel.class, "isUnvisitedHyperlinkColorSet", null ); // NOI18N
            properties[PROPERTY_unvisitedHyperlinkColorSet].setHidden ( true );
            properties[PROPERTY_URI] = new PropertyDescriptor ( "URI", components.JHyperlinkLabel.class, "getURI", "setURI" ); // NOI18N
            properties[PROPERTY_URI].setPreferred ( true );
            properties[PROPERTY_URI].setShortDescription ( "The URI of the hyperlink." );
            properties[PROPERTY_URI].setBound ( true );
            properties[PROPERTY_URI].setPropertyEditorClass ( beans.URIPropertyEditor.class );
            properties[PROPERTY_valid] = new PropertyDescriptor ( "valid", components.JHyperlinkLabel.class, "isValid", null ); // NOI18N
            properties[PROPERTY_valid].setHidden ( true );
            properties[PROPERTY_validateRoot] = new PropertyDescriptor ( "validateRoot", components.JHyperlinkLabel.class, "isValidateRoot", null ); // NOI18N
            properties[PROPERTY_validateRoot].setHidden ( true );
            properties[PROPERTY_verifyInputWhenFocusTarget] = new PropertyDescriptor ( "verifyInputWhenFocusTarget", components.JHyperlinkLabel.class, "getVerifyInputWhenFocusTarget", "setVerifyInputWhenFocusTarget" ); // NOI18N
            properties[PROPERTY_verifyInputWhenFocusTarget].setShortDescription ( "Whether the Component verifies input before accepting focus." );
            properties[PROPERTY_verticalAlignment] = new PropertyDescriptor ( "verticalAlignment", components.JHyperlinkLabel.class, "getVerticalAlignment", "setVerticalAlignment" ); // NOI18N
            properties[PROPERTY_verticalAlignment].setPreferred ( true );
            properties[PROPERTY_verticalAlignment].setShortDescription ( "The alignment of the label's contents along the Y axis." );
            properties[PROPERTY_verticalAlignment].setPropertyEditorClass ( beans.VerticalAlignmentEditor.class );
            properties[PROPERTY_verticalTextPosition] = new PropertyDescriptor ( "verticalTextPosition", components.JHyperlinkLabel.class, "getVerticalTextPosition", "setVerticalTextPosition" ); // NOI18N
            properties[PROPERTY_verticalTextPosition].setShortDescription ( "The vertical position of the text relative to it's image." );
            properties[PROPERTY_verticalTextPosition].setPropertyEditorClass ( beans.VerticalAlignmentEditor.class );
            properties[PROPERTY_vetoableChangeListeners] = new PropertyDescriptor ( "vetoableChangeListeners", components.JHyperlinkLabel.class, "getVetoableChangeListeners", null ); // NOI18N
            properties[PROPERTY_vetoableChangeListeners].setHidden ( true );
            properties[PROPERTY_visible] = new PropertyDescriptor ( "visible", components.JHyperlinkLabel.class, "isVisible", "setVisible" ); // NOI18N
            properties[PROPERTY_visible].setHidden ( true );
            properties[PROPERTY_visibleRect] = new PropertyDescriptor ( "visibleRect", components.JHyperlinkLabel.class, "getVisibleRect", null ); // NOI18N
            properties[PROPERTY_visibleRect].setHidden ( true );
            properties[PROPERTY_visited] = new PropertyDescriptor ( "visited", components.JHyperlinkLabel.class, "isVisited", "setVisited" ); // NOI18N
            properties[PROPERTY_visited].setPreferred ( true );
            properties[PROPERTY_visited].setShortDescription ( "This indicates whether the hyperlink has been visited." );
            properties[PROPERTY_visited].setBound ( true );
            properties[PROPERTY_visitedHyperlinkColor] = new PropertyDescriptor ( "visitedHyperlinkColor", components.JHyperlinkLabel.class, "getVisitedHyperlinkColor", "setVisitedHyperlinkColor" ); // NOI18N
            properties[PROPERTY_visitedHyperlinkColor].setShortDescription ( "The color to use for visited hyperlinks." );
            properties[PROPERTY_visitedHyperlinkColor].setBound ( true );
            properties[PROPERTY_visitedHyperlinkColorSet] = new PropertyDescriptor ( "visitedHyperlinkColorSet", components.JHyperlinkLabel.class, "isVisitedHyperlinkColorSet", null ); // NOI18N
            properties[PROPERTY_visitedHyperlinkColorSet].setHidden ( true );
            properties[PROPERTY_width] = new PropertyDescriptor ( "width", components.JHyperlinkLabel.class, "getWidth", null ); // NOI18N
            properties[PROPERTY_width].setHidden ( true );
            properties[PROPERTY_x] = new PropertyDescriptor ( "x", components.JHyperlinkLabel.class, "getX", null ); // NOI18N
            properties[PROPERTY_x].setHidden ( true );
            properties[PROPERTY_y] = new PropertyDescriptor ( "y", components.JHyperlinkLabel.class, "getY", null ); // NOI18N
            properties[PROPERTY_y].setHidden ( true );
        }
        catch(IntrospectionException e) {
            e.printStackTrace();
        }//GEN-HEADEREND:Properties
        // Here you can add code for customizing the properties array.

        return properties;     }//GEN-LAST:Properties

    // EventSet identifiers//GEN-FIRST:Events
    private static final int EVENT_ancestorListener = 0;
    private static final int EVENT_componentListener = 1;
    private static final int EVENT_containerListener = 2;
    private static final int EVENT_focusListener = 3;
    private static final int EVENT_hierarchyBoundsListener = 4;
    private static final int EVENT_hierarchyListener = 5;
    private static final int EVENT_inputMethodListener = 6;
    private static final int EVENT_keyListener = 7;
    private static final int EVENT_mouseListener = 8;
    private static final int EVENT_mouseMotionListener = 9;
    private static final int EVENT_mouseWheelListener = 10;
    private static final int EVENT_propertyChangeListener = 11;
    private static final int EVENT_vetoableChangeListener = 12;

    // EventSet array
    /*lazy EventSetDescriptor*/
    private static EventSetDescriptor[] getEdescriptor(){
        EventSetDescriptor[] eventSets = new EventSetDescriptor[13];
    
        try {
            eventSets[EVENT_ancestorListener] = new EventSetDescriptor ( components.JHyperlinkLabel.class, "ancestorListener", javax.swing.event.AncestorListener.class, new String[] {"ancestorAdded", "ancestorRemoved", "ancestorMoved"}, "addAncestorListener", "removeAncestorListener" ); // NOI18N
            eventSets[EVENT_componentListener] = new EventSetDescriptor ( components.JHyperlinkLabel.class, "componentListener", java.awt.event.ComponentListener.class, new String[] {"componentResized", "componentMoved", "componentShown", "componentHidden"}, "addComponentListener", "removeComponentListener" ); // NOI18N
            eventSets[EVENT_containerListener] = new EventSetDescriptor ( components.JHyperlinkLabel.class, "containerListener", java.awt.event.ContainerListener.class, new String[] {"componentAdded", "componentRemoved"}, "addContainerListener", "removeContainerListener" ); // NOI18N
            eventSets[EVENT_focusListener] = new EventSetDescriptor ( components.JHyperlinkLabel.class, "focusListener", java.awt.event.FocusListener.class, new String[] {"focusGained", "focusLost"}, "addFocusListener", "removeFocusListener" ); // NOI18N
            eventSets[EVENT_hierarchyBoundsListener] = new EventSetDescriptor ( components.JHyperlinkLabel.class, "hierarchyBoundsListener", java.awt.event.HierarchyBoundsListener.class, new String[] {"ancestorMoved", "ancestorResized"}, "addHierarchyBoundsListener", "removeHierarchyBoundsListener" ); // NOI18N
            eventSets[EVENT_hierarchyListener] = new EventSetDescriptor ( components.JHyperlinkLabel.class, "hierarchyListener", java.awt.event.HierarchyListener.class, new String[] {"hierarchyChanged"}, "addHierarchyListener", "removeHierarchyListener" ); // NOI18N
            eventSets[EVENT_inputMethodListener] = new EventSetDescriptor ( components.JHyperlinkLabel.class, "inputMethodListener", java.awt.event.InputMethodListener.class, new String[] {"inputMethodTextChanged", "caretPositionChanged"}, "addInputMethodListener", "removeInputMethodListener" ); // NOI18N
            eventSets[EVENT_keyListener] = new EventSetDescriptor ( components.JHyperlinkLabel.class, "keyListener", java.awt.event.KeyListener.class, new String[] {"keyTyped", "keyPressed", "keyReleased"}, "addKeyListener", "removeKeyListener" ); // NOI18N
            eventSets[EVENT_mouseListener] = new EventSetDescriptor ( components.JHyperlinkLabel.class, "mouseListener", java.awt.event.MouseListener.class, new String[] {"mouseClicked", "mousePressed", "mouseReleased", "mouseEntered", "mouseExited"}, "addMouseListener", "removeMouseListener" ); // NOI18N
            eventSets[EVENT_mouseMotionListener] = new EventSetDescriptor ( components.JHyperlinkLabel.class, "mouseMotionListener", java.awt.event.MouseMotionListener.class, new String[] {"mouseDragged", "mouseMoved"}, "addMouseMotionListener", "removeMouseMotionListener" ); // NOI18N
            eventSets[EVENT_mouseWheelListener] = new EventSetDescriptor ( components.JHyperlinkLabel.class, "mouseWheelListener", java.awt.event.MouseWheelListener.class, new String[] {"mouseWheelMoved"}, "addMouseWheelListener", "removeMouseWheelListener" ); // NOI18N
            eventSets[EVENT_propertyChangeListener] = new EventSetDescriptor ( components.JHyperlinkLabel.class, "propertyChangeListener", java.beans.PropertyChangeListener.class, new String[] {"propertyChange"}, "addPropertyChangeListener", "removePropertyChangeListener" ); // NOI18N
            eventSets[EVENT_vetoableChangeListener] = new EventSetDescriptor ( components.JHyperlinkLabel.class, "vetoableChangeListener", java.beans.VetoableChangeListener.class, new String[] {"vetoableChange"}, "addVetoableChangeListener", "removeVetoableChangeListener" ); // NOI18N
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
    /**
     * This stores the BeanInfoIconFactory used to generate icons. This is 
     * initialized the first time it is used.
     */
    private static BeanInfoIconFactory iconFactory = null;

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
     * This returns the image to use to represent JHyperlinkLabels.
     * @param iconKind The kind of icon to get.
     * @param resourceName The name for the resource to get the image from, or 
     * null.
     * @return The image representing a JHyperlinkLabels, or null if no suitable 
     * icon is available.
     * @see #getIcon(int) 
     * @see beans.BeanInfoIconFactory
     * @see beans.BeanInfoIconFactory#createIconImage(int, java.lang.String, java.beans.SimpleBeanInfo) 
     */
    private java.awt.Image createIcon(int iconKind, String resourceName){
        if (iconFactory == null)    // If the icon factory is not initialized yet
            iconFactory = new JHyperlinkLabelIconFactory();
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
     * JHyperlinkLabel.
     */
    private static class JHyperlinkLabelIconFactory extends BeanInfoIconFactory{
        /**
         * This creates an array of grayscale colors from the given array of 
         * colors, using the standard luminance equation.
         * @param colors The colors to use.
         * @return A grayscale version of the colors.
         */
        private static Color[] toGrayscale(Color[] colors){
                // This is an array to get the grayscale colors
            Color[] values = new Color[colors.length];
                // Go through the colors
            for (int i = 0; i < colors.length; i++){
                    // Use the standard luminance equation to get the value for 
                    // this color
                float value = (float)(0.2126 * (colors[i].getRed()/255.0) + 
                        0.7152 * (colors[i].getGreen()/255.0) + 
                        0.0722 * (colors[i].getBlue()/255.0));
                values[i] = new Color(value, value, value, colors[i].getAlpha()/255.0f);
            }
            return values;
        }
        /**
         * This stores the colors to use for an image representing 
         * JHyperlinkLabel with a color icon.
         */
        private static final Color[] ICON_COLOR_VALUES_COLOR_ONLY = {
            JHyperlinkLabel.UNVISITED_HYPERLINK_COLOR,
            JHyperlinkLabel.VISITED_HYPERLINK_COLOR
        };
        /**
         * This stores the colors to use for an image representing 
         * JHyperlinkLabel. The first array contains the colors to use for a 
         * color icon and the second array contains the colors to use for a 
         * monochrome icon.
         */
        public static final Color[][] ICON_COLOR_VALUES = {
            ICON_COLOR_VALUES_COLOR_ONLY,
            toGrayscale(ICON_COLOR_VALUES_COLOR_ONLY)
        };
        /**
         * This is the text displayed by the label.
         */
        public static final String LABEL_TEXT = "link";
        /**
         * This is the font for the text to display. This is initially null and 
         * is initialized the first time it's used.
         */
        private static Font font = null;
        /**
         * This returns a gradient to use to paint the text.
         * @param scale The scale for the icon (1 for 16x16 icons, 2 for 32x32 
         * icons).
         * @param colorMode The color mode for the icon (0 for color icons, 1 
         * for monochrome icons).
         * @return The gradient for the text.
         */
        protected java.awt.Paint getGradient(int scale, int colorMode){
            return new java.awt.GradientPaint(
                    0,5*scale,ICON_COLOR_VALUES[colorMode][0],
                    0,16*scale,ICON_COLOR_VALUES[colorMode][1]);
        }
        /**
         * This paints the string "label" at the given position with the 
         * given paint.
         * @param g The graphics context to render to.
         * @param x The x-coordinate to paint the text at.
         * @param y The y-coordinate to paint the text at.
         * @param paint The paint to use to paint the text
         */
        private void paintText(java.awt.Graphics2D g, int x, int y, java.awt.Paint paint){
                // Set the paint to use
            g.setPaint(paint);
                // Draw the text one pixel before the x-coordinate to make the 
                // text thicker
            g.drawString(LABEL_TEXT, x-1, y);
                // Draw the text
            g.drawString(LABEL_TEXT, x, y);
        }
        /**
         * This paints the text for the icon.
         * @param g The graphics context to render to.
         * @param colorMode The color mode for the icon (0 for color icons, 1 
         * for monochrome icons).
         */
        private void paintText(java.awt.Graphics2D g, int colorMode){
                // Set the antiasing to be true
            g.setRenderingHint(java.awt.RenderingHints.KEY_ANTIALIASING, 
                    java.awt.RenderingHints.VALUE_ANTIALIAS_ON);
                // If the font has not been initialized yet
            if (font == null)
                font = new Font(Font.SANS_SERIF,Font.PLAIN,16);
                // Set the font to use
            g.setFont(font);
                // Draw the text shadow
            paintText(g,5,23,BeanInfoIconFactory.SHADOW_COLOR);
                // Draw the text
            paintText(g,5,22,getGradient(2,colorMode));
        }
        /**
         * This draws the underline for the text.
         * @param g The graphics context to render to.
         * @param scale The scale for the icon (1 for 16x16 icons, 2 for 32x32 
         * icons).
         * @param y The base y-coordinate for the line.
         * @param w The width of the image.
         */
        private void paintUnderline(java.awt.Graphics2D g,int scale, int y, int w){
            g.drawLine((int)(2.5*scale), y,  w-(2*scale)-1, y);
        }
        @Override
        protected void paintImage(java.awt.Graphics2D g,int scale,int colorMode,
                int w, int h) {
                // If the icon is 16x16
            if (scale == 1){
                    // An image to draw the 32x32 version of the text to
                java.awt.image.BufferedImage img = new java.awt.image.BufferedImage(32,32,
                        java.awt.image.BufferedImage.TYPE_INT_ARGB);
                    // Get the graphics context for the image
                java.awt.Graphics2D imgG = img.createGraphics();
                    // Draw the text to the image
                paintText(imgG,colorMode);
                imgG.dispose();
                    // Set the graphics rendering to use bicubic interpolation
                g.setRenderingHint(java.awt.RenderingHints.KEY_INTERPOLATION, 
                            java.awt.RenderingHints.VALUE_INTERPOLATION_BICUBIC);
                    // Scale down the text to 16x16
                g.drawImage(img, 0, 0, w, h, null);
                    // Set the paint to the gradient with the proper scale
                g.setPaint(getGradient(scale,colorMode));
            } else
                    // Paint the text (the gradient should have been applied by 
                    // the end of this method
                paintText(g,colorMode);
                // Draw the main underline
            paintUnderline(g,scale,(int)(11.5*scale)+(scale%2),w);
                // Draw the shadow for the underline
            g.setColor(SHADOW_COLOR);
            paintUnderline(g,scale,(int)(12*scale)+(scale%2),w);
        }
    }
}
