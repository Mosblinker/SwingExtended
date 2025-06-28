/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Beans/BeanInfo.java to edit this template
 */
package components;

import java.beans.*;

/**
 * This is the beans info for JAboutPanel.
 * @author Mosblinker
 * @see JAboutPanel
 */
public class JAboutPanelBeanInfo extends SimpleBeanInfo {

    // Bean descriptor//GEN-FIRST:BeanDescriptor
    /*lazy BeanDescriptor*/
    private static BeanDescriptor getBdescriptor(){
        BeanDescriptor beanDescriptor = new BeanDescriptor  ( components.JAboutPanel.class , null ); // NOI18N
        beanDescriptor.setShortDescription ( "This is a panel to display information about a program." );//GEN-HEADEREND:BeanDescriptor
        // Here you can add code for customizing the BeanDescriptor.

        return beanDescriptor;     }//GEN-LAST:BeanDescriptor


    // Property identifiers//GEN-FIRST:Properties
    private static final int PROPERTY_accessibleContext = 0;
    private static final int PROPERTY_actionListeners = 1;
    private static final int PROPERTY_actionMap = 2;
    private static final int PROPERTY_alignmentX = 3;
    private static final int PROPERTY_alignmentY = 4;
    private static final int PROPERTY_ancestorListeners = 5;
    private static final int PROPERTY_autoscrolls = 6;
    private static final int PROPERTY_background = 7;
    private static final int PROPERTY_backgroundSet = 8;
    private static final int PROPERTY_baselineResizeBehavior = 9;
    private static final int PROPERTY_border = 10;
    private static final int PROPERTY_bottomAccessory = 11;
    private static final int PROPERTY_bounds = 12;
    private static final int PROPERTY_closeButton = 13;
    private static final int PROPERTY_closeButtonText = 14;
    private static final int PROPERTY_closeButtonTextSet = 15;
    private static final int PROPERTY_colorModel = 16;
    private static final int PROPERTY_component = 17;
    private static final int PROPERTY_componentCount = 18;
    private static final int PROPERTY_componentListeners = 19;
    private static final int PROPERTY_componentOrientation = 20;
    private static final int PROPERTY_componentPopupMenu = 21;
    private static final int PROPERTY_components = 22;
    private static final int PROPERTY_containerListeners = 23;
    private static final int PROPERTY_controlButtonsAreShown = 24;
    private static final int PROPERTY_creditsDocument = 25;
    private static final int PROPERTY_creditsEditorKit = 26;
    private static final int PROPERTY_creditsInheritsPopupMenu = 27;
    private static final int PROPERTY_creditsPopupMenu = 28;
    private static final int PROPERTY_creditsScrollPane = 29;
    private static final int PROPERTY_creditsText = 30;
    private static final int PROPERTY_creditsTextPane = 31;
    private static final int PROPERTY_cursor = 32;
    private static final int PROPERTY_cursorSet = 33;
    private static final int PROPERTY_debugGraphicsOptions = 34;
    private static final int PROPERTY_displayable = 35;
    private static final int PROPERTY_doubleBuffered = 36;
    private static final int PROPERTY_dropTarget = 37;
    private static final int PROPERTY_enabled = 38;
    private static final int PROPERTY_failureMessagesAreShown = 39;
    private static final int PROPERTY_focusable = 40;
    private static final int PROPERTY_focusCycleRoot = 41;
    private static final int PROPERTY_focusCycleRootAncestor = 42;
    private static final int PROPERTY_focusListeners = 43;
    private static final int PROPERTY_focusOwner = 44;
    private static final int PROPERTY_focusTraversable = 45;
    private static final int PROPERTY_focusTraversalKeys = 46;
    private static final int PROPERTY_focusTraversalKeysEnabled = 47;
    private static final int PROPERTY_focusTraversalPolicy = 48;
    private static final int PROPERTY_focusTraversalPolicyProvider = 49;
    private static final int PROPERTY_focusTraversalPolicySet = 50;
    private static final int PROPERTY_font = 51;
    private static final int PROPERTY_fontSet = 52;
    private static final int PROPERTY_foreground = 53;
    private static final int PROPERTY_foregroundSet = 54;
    private static final int PROPERTY_graphics = 55;
    private static final int PROPERTY_graphicsConfiguration = 56;
    private static final int PROPERTY_height = 57;
    private static final int PROPERTY_hierarchyBoundsListeners = 58;
    private static final int PROPERTY_hierarchyListeners = 59;
    private static final int PROPERTY_ignoreRepaint = 60;
    private static final int PROPERTY_inheritsPopupMenu = 61;
    private static final int PROPERTY_inputContext = 62;
    private static final int PROPERTY_inputMap = 63;
    private static final int PROPERTY_inputMethodListeners = 64;
    private static final int PROPERTY_inputMethodRequests = 65;
    private static final int PROPERTY_inputVerifier = 66;
    private static final int PROPERTY_insets = 67;
    private static final int PROPERTY_keyListeners = 68;
    private static final int PROPERTY_layout = 69;
    private static final int PROPERTY_licenseButton = 70;
    private static final int PROPERTY_licenseButtonIsShown = 71;
    private static final int PROPERTY_lightweight = 72;
    private static final int PROPERTY_locale = 73;
    private static final int PROPERTY_location = 74;
    private static final int PROPERTY_locationOnScreen = 75;
    private static final int PROPERTY_managingFocus = 76;
    private static final int PROPERTY_maximumSize = 77;
    private static final int PROPERTY_maximumSizeSet = 78;
    private static final int PROPERTY_minimumSize = 79;
    private static final int PROPERTY_minimumSizeSet = 80;
    private static final int PROPERTY_mixingCutoutShape = 81;
    private static final int PROPERTY_mouseListeners = 82;
    private static final int PROPERTY_mouseMotionListeners = 83;
    private static final int PROPERTY_mousePosition = 84;
    private static final int PROPERTY_mouseWheelListeners = 85;
    private static final int PROPERTY_name = 86;
    private static final int PROPERTY_nextFocusableComponent = 87;
    private static final int PROPERTY_opaque = 88;
    private static final int PROPERTY_optimizedDrawingEnabled = 89;
    private static final int PROPERTY_paintingForPrint = 90;
    private static final int PROPERTY_paintingTile = 91;
    private static final int PROPERTY_parent = 92;
    private static final int PROPERTY_preferredSize = 93;
    private static final int PROPERTY_preferredSizeSet = 94;
    private static final int PROPERTY_programCopyright = 95;
    private static final int PROPERTY_programCopyrightLabel = 96;
    private static final int PROPERTY_programIcon = 97;
    private static final int PROPERTY_programIconLabel = 98;
    private static final int PROPERTY_programName = 99;
    private static final int PROPERTY_programNameLabel = 100;
    private static final int PROPERTY_programVersion = 101;
    private static final int PROPERTY_programVersionLabel = 102;
    private static final int PROPERTY_programWebsiteLabel = 103;
    private static final int PROPERTY_programWebsiteText = 104;
    private static final int PROPERTY_programWebsiteURI = 105;
    private static final int PROPERTY_programWebsiteVisited = 106;
    private static final int PROPERTY_propertyChangeListeners = 107;
    private static final int PROPERTY_registeredKeyStrokes = 108;
    private static final int PROPERTY_requestFocusEnabled = 109;
    private static final int PROPERTY_rootPane = 110;
    private static final int PROPERTY_selectedHyperlinkColor = 111;
    private static final int PROPERTY_selectedHyperlinkColorSet = 112;
    private static final int PROPERTY_showing = 113;
    private static final int PROPERTY_size = 114;
    private static final int PROPERTY_toolkit = 115;
    private static final int PROPERTY_toolTipText = 116;
    private static final int PROPERTY_topLevelAncestor = 117;
    private static final int PROPERTY_transferHandler = 118;
    private static final int PROPERTY_treeLock = 119;
    private static final int PROPERTY_UI = 120;
    private static final int PROPERTY_UIClassID = 121;
    private static final int PROPERTY_unvisitedHyperlinkColor = 122;
    private static final int PROPERTY_unvisitedHyperlinkColorSet = 123;
    private static final int PROPERTY_updateButton = 124;
    private static final int PROPERTY_updateButtonIsShown = 125;
    private static final int PROPERTY_updateButtonText = 126;
    private static final int PROPERTY_updateButtonTextSet = 127;
    private static final int PROPERTY_updateButtonToolTipText = 128;
    private static final int PROPERTY_updateButtonToolTipTextSet = 129;
    private static final int PROPERTY_valid = 130;
    private static final int PROPERTY_validateRoot = 131;
    private static final int PROPERTY_verifyInputWhenFocusTarget = 132;
    private static final int PROPERTY_vetoableChangeListeners = 133;
    private static final int PROPERTY_visible = 134;
    private static final int PROPERTY_visibleRect = 135;
    private static final int PROPERTY_visitedHyperlinkColor = 136;
    private static final int PROPERTY_visitedHyperlinkColorSet = 137;
    private static final int PROPERTY_websiteCopyMenuItem = 138;
    private static final int PROPERTY_websiteOpenMenuItem = 139;
    private static final int PROPERTY_websitePopup = 140;
    private static final int PROPERTY_width = 141;
    private static final int PROPERTY_x = 142;
    private static final int PROPERTY_y = 143;

    // Property array 
    /*lazy PropertyDescriptor*/
    private static PropertyDescriptor[] getPdescriptor(){
        PropertyDescriptor[] properties = new PropertyDescriptor[144];
    
        try {
            properties[PROPERTY_accessibleContext] = new PropertyDescriptor ( "accessibleContext", components.JAboutPanel.class, "getAccessibleContext", null ); // NOI18N
            properties[PROPERTY_accessibleContext].setHidden ( true );
            properties[PROPERTY_actionListeners] = new PropertyDescriptor ( "actionListeners", components.JAboutPanel.class, "getActionListeners", null ); // NOI18N
            properties[PROPERTY_actionListeners].setHidden ( true );
            properties[PROPERTY_actionMap] = new PropertyDescriptor ( "actionMap", components.JAboutPanel.class, "getActionMap", "setActionMap" ); // NOI18N
            properties[PROPERTY_actionMap].setHidden ( true );
            properties[PROPERTY_alignmentX] = new PropertyDescriptor ( "alignmentX", components.JAboutPanel.class, "getAlignmentX", "setAlignmentX" ); // NOI18N
            properties[PROPERTY_alignmentX].setShortDescription ( "The preferred horizontal alignment of the component." );
            properties[PROPERTY_alignmentY] = new PropertyDescriptor ( "alignmentY", components.JAboutPanel.class, "getAlignmentY", "setAlignmentY" ); // NOI18N
            properties[PROPERTY_alignmentY].setShortDescription ( "The preferred vertical alignment of the component." );
            properties[PROPERTY_ancestorListeners] = new PropertyDescriptor ( "ancestorListeners", components.JAboutPanel.class, "getAncestorListeners", null ); // NOI18N
            properties[PROPERTY_ancestorListeners].setHidden ( true );
            properties[PROPERTY_autoscrolls] = new PropertyDescriptor ( "autoscrolls", components.JAboutPanel.class, "getAutoscrolls", "setAutoscrolls" ); // NOI18N
            properties[PROPERTY_autoscrolls].setShortDescription ( "Determines if this component automatically scrolls its contents when dragged." );
            properties[PROPERTY_background] = new PropertyDescriptor ( "background", components.JAboutPanel.class, "getBackground", "setBackground" ); // NOI18N
            properties[PROPERTY_background].setPreferred ( true );
            properties[PROPERTY_background].setShortDescription ( "The background color of the component." );
            properties[PROPERTY_background].setBound ( true );
            properties[PROPERTY_backgroundSet] = new PropertyDescriptor ( "backgroundSet", components.JAboutPanel.class, "isBackgroundSet", null ); // NOI18N
            properties[PROPERTY_backgroundSet].setHidden ( true );
            properties[PROPERTY_baselineResizeBehavior] = new PropertyDescriptor ( "baselineResizeBehavior", components.JAboutPanel.class, "getBaselineResizeBehavior", null ); // NOI18N
            properties[PROPERTY_baselineResizeBehavior].setExpert ( true );
            properties[PROPERTY_border] = new PropertyDescriptor ( "border", components.JAboutPanel.class, "getBorder", "setBorder" ); // NOI18N
            properties[PROPERTY_border].setShortDescription ( "The component's border." );
            properties[PROPERTY_border].setBound ( true );
            properties[PROPERTY_bottomAccessory] = new PropertyDescriptor ( "bottomAccessory", components.JAboutPanel.class, "getBottomAccessory", "setBottomAccessory" ); // NOI18N
            properties[PROPERTY_bottomAccessory].setPreferred ( true );
            properties[PROPERTY_bottomAccessory].setShortDescription ( "The accessory component to display at the bottom of the panel." );
            properties[PROPERTY_bottomAccessory].setBound ( true );
            properties[PROPERTY_bounds] = new PropertyDescriptor ( "bounds", components.JAboutPanel.class, "getBounds", "setBounds" ); // NOI18N
            properties[PROPERTY_bounds].setHidden ( true );
            properties[PROPERTY_closeButton] = new PropertyDescriptor ( "closeButton", components.JAboutPanel.class, "getCloseButton", null ); // NOI18N
            properties[PROPERTY_closeButtonText] = new PropertyDescriptor ( "closeButtonText", components.JAboutPanel.class, "getCloseButtonText", "setCloseButtonText" ); // NOI18N
            properties[PROPERTY_closeButtonTextSet] = new PropertyDescriptor ( "closeButtonTextSet", components.JAboutPanel.class, "isCloseButtonTextSet", null ); // NOI18N
            properties[PROPERTY_colorModel] = new PropertyDescriptor ( "colorModel", components.JAboutPanel.class, "getColorModel", null ); // NOI18N
            properties[PROPERTY_colorModel].setHidden ( true );
            properties[PROPERTY_component] = new IndexedPropertyDescriptor ( "component", components.JAboutPanel.class, null, null, "getComponent", null ); // NOI18N
            properties[PROPERTY_componentCount] = new PropertyDescriptor ( "componentCount", components.JAboutPanel.class, "getComponentCount", null ); // NOI18N
            properties[PROPERTY_componentCount].setHidden ( true );
            properties[PROPERTY_componentListeners] = new PropertyDescriptor ( "componentListeners", components.JAboutPanel.class, "getComponentListeners", null ); // NOI18N
            properties[PROPERTY_componentListeners].setHidden ( true );
            properties[PROPERTY_componentOrientation] = new PropertyDescriptor ( "componentOrientation", components.JAboutPanel.class, "getComponentOrientation", "setComponentOrientation" ); // NOI18N
            properties[PROPERTY_componentOrientation].setHidden ( true );
            properties[PROPERTY_componentPopupMenu] = new PropertyDescriptor ( "componentPopupMenu", components.JAboutPanel.class, "getComponentPopupMenu", "setComponentPopupMenu" ); // NOI18N
            properties[PROPERTY_componentPopupMenu].setShortDescription ( "The popup menu to show" );
            properties[PROPERTY_componentPopupMenu].setBound ( true );
            properties[PROPERTY_components] = new PropertyDescriptor ( "components", components.JAboutPanel.class, "getComponents", null ); // NOI18N
            properties[PROPERTY_components].setHidden ( true );
            properties[PROPERTY_containerListeners] = new PropertyDescriptor ( "containerListeners", components.JAboutPanel.class, "getContainerListeners", null ); // NOI18N
            properties[PROPERTY_containerListeners].setHidden ( true );
            properties[PROPERTY_controlButtonsAreShown] = new PropertyDescriptor ( "controlButtonsAreShown", components.JAboutPanel.class, "getControlButtonsAreShown", "setControlButtonsAreShown" ); // NOI18N
            properties[PROPERTY_controlButtonsAreShown].setShortDescription ( "Sets whether the control buttons are shown." );
            properties[PROPERTY_controlButtonsAreShown].setBound ( true );
            properties[PROPERTY_creditsDocument] = new PropertyDescriptor ( "creditsDocument", components.JAboutPanel.class, "getCreditsDocument", "setCreditsDocument" ); // NOI18N
            properties[PROPERTY_creditsEditorKit] = new PropertyDescriptor ( "creditsEditorKit", components.JAboutPanel.class, "getCreditsEditorKit", "setCreditsEditorKit" ); // NOI18N
            properties[PROPERTY_creditsInheritsPopupMenu] = new PropertyDescriptor ( "creditsInheritsPopupMenu", components.JAboutPanel.class, "getCreditsInheritsPopupMenu", "setCreditsInheritsPopupMenu" ); // NOI18N
            properties[PROPERTY_creditsPopupMenu] = new PropertyDescriptor ( "creditsPopupMenu", components.JAboutPanel.class, "getCreditsPopupMenu", "setCreditsPopupMenu" ); // NOI18N
            properties[PROPERTY_creditsScrollPane] = new PropertyDescriptor ( "creditsScrollPane", components.JAboutPanel.class, "getCreditsScrollPane", null ); // NOI18N
            properties[PROPERTY_creditsText] = new PropertyDescriptor ( "creditsText", components.JAboutPanel.class, "getCreditsText", "setCreditsText" ); // NOI18N
            properties[PROPERTY_creditsTextPane] = new PropertyDescriptor ( "creditsTextPane", components.JAboutPanel.class, "getCreditsTextPane", null ); // NOI18N
            properties[PROPERTY_cursor] = new PropertyDescriptor ( "cursor", components.JAboutPanel.class, "getCursor", "setCursor" ); // NOI18N
            properties[PROPERTY_cursorSet] = new PropertyDescriptor ( "cursorSet", components.JAboutPanel.class, "isCursorSet", null ); // NOI18N
            properties[PROPERTY_cursorSet].setHidden ( true );
            properties[PROPERTY_debugGraphicsOptions] = new PropertyDescriptor ( "debugGraphicsOptions", components.JAboutPanel.class, "getDebugGraphicsOptions", "setDebugGraphicsOptions" ); // NOI18N
            properties[PROPERTY_debugGraphicsOptions].setShortDescription ( "Diagnostic options for graphics operations." );
            properties[PROPERTY_displayable] = new PropertyDescriptor ( "displayable", components.JAboutPanel.class, "isDisplayable", null ); // NOI18N
            properties[PROPERTY_displayable].setHidden ( true );
            properties[PROPERTY_doubleBuffered] = new PropertyDescriptor ( "doubleBuffered", components.JAboutPanel.class, "isDoubleBuffered", "setDoubleBuffered" ); // NOI18N
            properties[PROPERTY_dropTarget] = new PropertyDescriptor ( "dropTarget", components.JAboutPanel.class, "getDropTarget", "setDropTarget" ); // NOI18N
            properties[PROPERTY_dropTarget].setHidden ( true );
            properties[PROPERTY_enabled] = new PropertyDescriptor ( "enabled", components.JAboutPanel.class, "isEnabled", "setEnabled" ); // NOI18N
            properties[PROPERTY_enabled].setShortDescription ( "The enabled state of the component." );
            properties[PROPERTY_enabled].setBound ( true );
            properties[PROPERTY_failureMessagesAreShown] = new PropertyDescriptor ( "failureMessagesAreShown", components.JAboutPanel.class, "getFailureMessagesAreShown", "setFailureMessagesAreShown" ); // NOI18N
            properties[PROPERTY_failureMessagesAreShown].setShortDescription ( "Whether error messages will be shown to the user if and when this fails to open the hyperlink." );
            properties[PROPERTY_focusable] = new PropertyDescriptor ( "focusable", components.JAboutPanel.class, "isFocusable", "setFocusable" ); // NOI18N
            properties[PROPERTY_focusCycleRoot] = new PropertyDescriptor ( "focusCycleRoot", components.JAboutPanel.class, "isFocusCycleRoot", "setFocusCycleRoot" ); // NOI18N
            properties[PROPERTY_focusCycleRootAncestor] = new PropertyDescriptor ( "focusCycleRootAncestor", components.JAboutPanel.class, "getFocusCycleRootAncestor", null ); // NOI18N
            properties[PROPERTY_focusCycleRootAncestor].setHidden ( true );
            properties[PROPERTY_focusListeners] = new PropertyDescriptor ( "focusListeners", components.JAboutPanel.class, "getFocusListeners", null ); // NOI18N
            properties[PROPERTY_focusListeners].setHidden ( true );
            properties[PROPERTY_focusOwner] = new PropertyDescriptor ( "focusOwner", components.JAboutPanel.class, "isFocusOwner", null ); // NOI18N
            properties[PROPERTY_focusOwner].setHidden ( true );
            properties[PROPERTY_focusTraversable] = new PropertyDescriptor ( "focusTraversable", components.JAboutPanel.class, "isFocusTraversable", null ); // NOI18N
            properties[PROPERTY_focusTraversable].setHidden ( true );
            properties[PROPERTY_focusTraversalKeys] = new IndexedPropertyDescriptor ( "focusTraversalKeys", components.JAboutPanel.class, null, null, null, "setFocusTraversalKeys" ); // NOI18N
            properties[PROPERTY_focusTraversalKeysEnabled] = new PropertyDescriptor ( "focusTraversalKeysEnabled", components.JAboutPanel.class, "getFocusTraversalKeysEnabled", "setFocusTraversalKeysEnabled" ); // NOI18N
            properties[PROPERTY_focusTraversalKeysEnabled].setHidden ( true );
            properties[PROPERTY_focusTraversalPolicy] = new PropertyDescriptor ( "focusTraversalPolicy", components.JAboutPanel.class, "getFocusTraversalPolicy", "setFocusTraversalPolicy" ); // NOI18N
            properties[PROPERTY_focusTraversalPolicyProvider] = new PropertyDescriptor ( "focusTraversalPolicyProvider", components.JAboutPanel.class, "isFocusTraversalPolicyProvider", "setFocusTraversalPolicyProvider" ); // NOI18N
            properties[PROPERTY_focusTraversalPolicySet] = new PropertyDescriptor ( "focusTraversalPolicySet", components.JAboutPanel.class, "isFocusTraversalPolicySet", null ); // NOI18N
            properties[PROPERTY_focusTraversalPolicySet].setHidden ( true );
            properties[PROPERTY_font] = new PropertyDescriptor ( "font", components.JAboutPanel.class, "getFont", "setFont" ); // NOI18N
            properties[PROPERTY_font].setPreferred ( true );
            properties[PROPERTY_font].setShortDescription ( "The font for the component." );
            properties[PROPERTY_font].setBound ( true );
            properties[PROPERTY_fontSet] = new PropertyDescriptor ( "fontSet", components.JAboutPanel.class, "isFontSet", null ); // NOI18N
            properties[PROPERTY_fontSet].setHidden ( true );
            properties[PROPERTY_foreground] = new PropertyDescriptor ( "foreground", components.JAboutPanel.class, "getForeground", "setForeground" ); // NOI18N
            properties[PROPERTY_foreground].setPreferred ( true );
            properties[PROPERTY_foreground].setShortDescription ( "The foreground color of the component." );
            properties[PROPERTY_foreground].setBound ( true );
            properties[PROPERTY_foregroundSet] = new PropertyDescriptor ( "foregroundSet", components.JAboutPanel.class, "isForegroundSet", null ); // NOI18N
            properties[PROPERTY_foregroundSet].setHidden ( true );
            properties[PROPERTY_graphics] = new PropertyDescriptor ( "graphics", components.JAboutPanel.class, "getGraphics", null ); // NOI18N
            properties[PROPERTY_graphics].setHidden ( true );
            properties[PROPERTY_graphicsConfiguration] = new PropertyDescriptor ( "graphicsConfiguration", components.JAboutPanel.class, "getGraphicsConfiguration", null ); // NOI18N
            properties[PROPERTY_graphicsConfiguration].setHidden ( true );
            properties[PROPERTY_height] = new PropertyDescriptor ( "height", components.JAboutPanel.class, "getHeight", null ); // NOI18N
            properties[PROPERTY_height].setHidden ( true );
            properties[PROPERTY_hierarchyBoundsListeners] = new PropertyDescriptor ( "hierarchyBoundsListeners", components.JAboutPanel.class, "getHierarchyBoundsListeners", null ); // NOI18N
            properties[PROPERTY_hierarchyBoundsListeners].setHidden ( true );
            properties[PROPERTY_hierarchyListeners] = new PropertyDescriptor ( "hierarchyListeners", components.JAboutPanel.class, "getHierarchyListeners", null ); // NOI18N
            properties[PROPERTY_hierarchyListeners].setHidden ( true );
            properties[PROPERTY_ignoreRepaint] = new PropertyDescriptor ( "ignoreRepaint", components.JAboutPanel.class, "getIgnoreRepaint", "setIgnoreRepaint" ); // NOI18N
            properties[PROPERTY_ignoreRepaint].setHidden ( true );
            properties[PROPERTY_inheritsPopupMenu] = new PropertyDescriptor ( "inheritsPopupMenu", components.JAboutPanel.class, "getInheritsPopupMenu", "setInheritsPopupMenu" ); // NOI18N
            properties[PROPERTY_inheritsPopupMenu].setShortDescription ( "Whether or not the JPopupMenu is inherited" );
            properties[PROPERTY_inheritsPopupMenu].setBound ( true );
            properties[PROPERTY_inputContext] = new PropertyDescriptor ( "inputContext", components.JAboutPanel.class, "getInputContext", null ); // NOI18N
            properties[PROPERTY_inputContext].setHidden ( true );
            properties[PROPERTY_inputMap] = new PropertyDescriptor ( "inputMap", components.JAboutPanel.class, "getInputMap", null ); // NOI18N
            properties[PROPERTY_inputMap].setHidden ( true );
            properties[PROPERTY_inputMethodListeners] = new PropertyDescriptor ( "inputMethodListeners", components.JAboutPanel.class, "getInputMethodListeners", null ); // NOI18N
            properties[PROPERTY_inputMethodListeners].setHidden ( true );
            properties[PROPERTY_inputMethodRequests] = new PropertyDescriptor ( "inputMethodRequests", components.JAboutPanel.class, "getInputMethodRequests", null ); // NOI18N
            properties[PROPERTY_inputMethodRequests].setHidden ( true );
            properties[PROPERTY_inputVerifier] = new PropertyDescriptor ( "inputVerifier", components.JAboutPanel.class, "getInputVerifier", "setInputVerifier" ); // NOI18N
            properties[PROPERTY_inputVerifier].setShortDescription ( "The component's input verifier." );
            properties[PROPERTY_insets] = new PropertyDescriptor ( "insets", components.JAboutPanel.class, "getInsets", null ); // NOI18N
            properties[PROPERTY_insets].setExpert ( true );
            properties[PROPERTY_keyListeners] = new PropertyDescriptor ( "keyListeners", components.JAboutPanel.class, "getKeyListeners", null ); // NOI18N
            properties[PROPERTY_keyListeners].setHidden ( true );
            properties[PROPERTY_layout] = new PropertyDescriptor ( "layout", components.JAboutPanel.class, "getLayout", "setLayout" ); // NOI18N
            properties[PROPERTY_layout].setHidden ( true );
            properties[PROPERTY_licenseButton] = new PropertyDescriptor ( "licenseButton", components.JAboutPanel.class, "getLicenseButton", null ); // NOI18N
            properties[PROPERTY_licenseButtonIsShown] = new PropertyDescriptor ( "licenseButtonIsShown", components.JAboutPanel.class, "getLicenseButtonIsShown", "setLicenseButtonIsShown" ); // NOI18N
            properties[PROPERTY_lightweight] = new PropertyDescriptor ( "lightweight", components.JAboutPanel.class, "isLightweight", null ); // NOI18N
            properties[PROPERTY_lightweight].setHidden ( true );
            properties[PROPERTY_locale] = new PropertyDescriptor ( "locale", components.JAboutPanel.class, "getLocale", "setLocale" ); // NOI18N
            properties[PROPERTY_locale].setHidden ( true );
            properties[PROPERTY_location] = new PropertyDescriptor ( "location", components.JAboutPanel.class, "getLocation", "setLocation" ); // NOI18N
            properties[PROPERTY_location].setHidden ( true );
            properties[PROPERTY_locationOnScreen] = new PropertyDescriptor ( "locationOnScreen", components.JAboutPanel.class, "getLocationOnScreen", null ); // NOI18N
            properties[PROPERTY_locationOnScreen].setHidden ( true );
            properties[PROPERTY_managingFocus] = new PropertyDescriptor ( "managingFocus", components.JAboutPanel.class, "isManagingFocus", null ); // NOI18N
            properties[PROPERTY_managingFocus].setHidden ( true );
            properties[PROPERTY_maximumSize] = new PropertyDescriptor ( "maximumSize", components.JAboutPanel.class, "getMaximumSize", "setMaximumSize" ); // NOI18N
            properties[PROPERTY_maximumSize].setShortDescription ( "The maximum size of the component." );
            properties[PROPERTY_maximumSize].setBound ( true );
            properties[PROPERTY_maximumSizeSet] = new PropertyDescriptor ( "maximumSizeSet", components.JAboutPanel.class, "isMaximumSizeSet", null ); // NOI18N
            properties[PROPERTY_maximumSizeSet].setHidden ( true );
            properties[PROPERTY_minimumSize] = new PropertyDescriptor ( "minimumSize", components.JAboutPanel.class, "getMinimumSize", "setMinimumSize" ); // NOI18N
            properties[PROPERTY_minimumSize].setShortDescription ( "The minimum size of the component." );
            properties[PROPERTY_minimumSize].setBound ( true );
            properties[PROPERTY_minimumSizeSet] = new PropertyDescriptor ( "minimumSizeSet", components.JAboutPanel.class, "isMinimumSizeSet", null ); // NOI18N
            properties[PROPERTY_minimumSizeSet].setHidden ( true );
            properties[PROPERTY_mixingCutoutShape] = new PropertyDescriptor ( "mixingCutoutShape", components.JAboutPanel.class, null, "setMixingCutoutShape" ); // NOI18N
            properties[PROPERTY_mixingCutoutShape].setHidden ( true );
            properties[PROPERTY_mouseListeners] = new PropertyDescriptor ( "mouseListeners", components.JAboutPanel.class, "getMouseListeners", null ); // NOI18N
            properties[PROPERTY_mouseListeners].setHidden ( true );
            properties[PROPERTY_mouseMotionListeners] = new PropertyDescriptor ( "mouseMotionListeners", components.JAboutPanel.class, "getMouseMotionListeners", null ); // NOI18N
            properties[PROPERTY_mouseMotionListeners].setHidden ( true );
            properties[PROPERTY_mousePosition] = new PropertyDescriptor ( "mousePosition", components.JAboutPanel.class, "getMousePosition", null ); // NOI18N
            properties[PROPERTY_mousePosition].setHidden ( true );
            properties[PROPERTY_mouseWheelListeners] = new PropertyDescriptor ( "mouseWheelListeners", components.JAboutPanel.class, "getMouseWheelListeners", null ); // NOI18N
            properties[PROPERTY_mouseWheelListeners].setHidden ( true );
            properties[PROPERTY_name] = new PropertyDescriptor ( "name", components.JAboutPanel.class, "getName", "setName" ); // NOI18N
            properties[PROPERTY_name].setBound ( true );
            properties[PROPERTY_nextFocusableComponent] = new PropertyDescriptor ( "nextFocusableComponent", components.JAboutPanel.class, "getNextFocusableComponent", "setNextFocusableComponent" ); // NOI18N
            properties[PROPERTY_opaque] = new PropertyDescriptor ( "opaque", components.JAboutPanel.class, "isOpaque", "setOpaque" ); // NOI18N
            properties[PROPERTY_opaque].setShortDescription ( "The component's opacity" );
            properties[PROPERTY_optimizedDrawingEnabled] = new PropertyDescriptor ( "optimizedDrawingEnabled", components.JAboutPanel.class, "isOptimizedDrawingEnabled", null ); // NOI18N
            properties[PROPERTY_optimizedDrawingEnabled].setHidden ( true );
            properties[PROPERTY_paintingForPrint] = new PropertyDescriptor ( "paintingForPrint", components.JAboutPanel.class, "isPaintingForPrint", null ); // NOI18N
            properties[PROPERTY_paintingTile] = new PropertyDescriptor ( "paintingTile", components.JAboutPanel.class, "isPaintingTile", null ); // NOI18N
            properties[PROPERTY_paintingTile].setHidden ( true );
            properties[PROPERTY_parent] = new PropertyDescriptor ( "parent", components.JAboutPanel.class, "getParent", null ); // NOI18N
            properties[PROPERTY_parent].setHidden ( true );
            properties[PROPERTY_preferredSize] = new PropertyDescriptor ( "preferredSize", components.JAboutPanel.class, "getPreferredSize", "setPreferredSize" ); // NOI18N
            properties[PROPERTY_preferredSize].setShortDescription ( "The preferred size of the component." );
            properties[PROPERTY_preferredSize].setBound ( true );
            properties[PROPERTY_preferredSizeSet] = new PropertyDescriptor ( "preferredSizeSet", components.JAboutPanel.class, "isPreferredSizeSet", null ); // NOI18N
            properties[PROPERTY_preferredSizeSet].setHidden ( true );
            properties[PROPERTY_programCopyright] = new PropertyDescriptor ( "programCopyright", components.JAboutPanel.class, "getProgramCopyright", "setProgramCopyright" ); // NOI18N
            properties[PROPERTY_programCopyrightLabel] = new PropertyDescriptor ( "programCopyrightLabel", components.JAboutPanel.class, "getProgramCopyrightLabel", null ); // NOI18N
            properties[PROPERTY_programIcon] = new PropertyDescriptor ( "programIcon", components.JAboutPanel.class, "getProgramIcon", "setProgramIcon" ); // NOI18N
            properties[PROPERTY_programIconLabel] = new PropertyDescriptor ( "programIconLabel", components.JAboutPanel.class, "getProgramIconLabel", null ); // NOI18N
            properties[PROPERTY_programName] = new PropertyDescriptor ( "programName", components.JAboutPanel.class, "getProgramName", "setProgramName" ); // NOI18N
            properties[PROPERTY_programNameLabel] = new PropertyDescriptor ( "programNameLabel", components.JAboutPanel.class, "getProgramNameLabel", null ); // NOI18N
            properties[PROPERTY_programVersion] = new PropertyDescriptor ( "programVersion", components.JAboutPanel.class, "getProgramVersion", "setProgramVersion" ); // NOI18N
            properties[PROPERTY_programVersionLabel] = new PropertyDescriptor ( "programVersionLabel", components.JAboutPanel.class, "getProgramVersionLabel", null ); // NOI18N
            properties[PROPERTY_programWebsiteLabel] = new PropertyDescriptor ( "programWebsiteLabel", components.JAboutPanel.class, "getProgramWebsiteLabel", null ); // NOI18N
            properties[PROPERTY_programWebsiteText] = new PropertyDescriptor ( "programWebsiteText", components.JAboutPanel.class, "getProgramWebsiteText", "setProgramWebsiteText" ); // NOI18N
            properties[PROPERTY_programWebsiteURI] = new PropertyDescriptor ( "programWebsiteURI", components.JAboutPanel.class, "getProgramWebsiteURI", "setProgramWebsiteURI" ); // NOI18N
            properties[PROPERTY_programWebsiteURI].setPreferred ( true );
            properties[PROPERTY_programWebsiteURI].setShortDescription ( "The URI of the hyperlink." );
            properties[PROPERTY_programWebsiteURI].setBound ( true );
            properties[PROPERTY_programWebsiteURI].setPropertyEditorClass ( beans.URIPropertyEditor.class );
            properties[PROPERTY_programWebsiteVisited] = new PropertyDescriptor ( "programWebsiteVisited", components.JAboutPanel.class, "isProgramWebsiteVisited", "setProgramWebsiteVisited" ); // NOI18N
            properties[PROPERTY_propertyChangeListeners] = new PropertyDescriptor ( "propertyChangeListeners", components.JAboutPanel.class, "getPropertyChangeListeners", null ); // NOI18N
            properties[PROPERTY_propertyChangeListeners].setHidden ( true );
            properties[PROPERTY_registeredKeyStrokes] = new PropertyDescriptor ( "registeredKeyStrokes", components.JAboutPanel.class, "getRegisteredKeyStrokes", null ); // NOI18N
            properties[PROPERTY_registeredKeyStrokes].setHidden ( true );
            properties[PROPERTY_requestFocusEnabled] = new PropertyDescriptor ( "requestFocusEnabled", components.JAboutPanel.class, "isRequestFocusEnabled", "setRequestFocusEnabled" ); // NOI18N
            properties[PROPERTY_rootPane] = new PropertyDescriptor ( "rootPane", components.JAboutPanel.class, "getRootPane", null ); // NOI18N
            properties[PROPERTY_rootPane].setHidden ( true );
            properties[PROPERTY_selectedHyperlinkColor] = new PropertyDescriptor ( "selectedHyperlinkColor", components.JAboutPanel.class, "getSelectedHyperlinkColor", "setSelectedHyperlinkColor" ); // NOI18N
            properties[PROPERTY_selectedHyperlinkColor].setShortDescription ( "The color to use for the hyperlink when it is selected." );
            properties[PROPERTY_selectedHyperlinkColor].setBound ( true );
            properties[PROPERTY_selectedHyperlinkColorSet] = new PropertyDescriptor ( "selectedHyperlinkColorSet", components.JAboutPanel.class, "isSelectedHyperlinkColorSet", null ); // NOI18N
            properties[PROPERTY_selectedHyperlinkColorSet].setHidden ( true );
            properties[PROPERTY_showing] = new PropertyDescriptor ( "showing", components.JAboutPanel.class, "isShowing", null ); // NOI18N
            properties[PROPERTY_showing].setHidden ( true );
            properties[PROPERTY_size] = new PropertyDescriptor ( "size", components.JAboutPanel.class, "getSize", "setSize" ); // NOI18N
            properties[PROPERTY_size].setHidden ( true );
            properties[PROPERTY_toolkit] = new PropertyDescriptor ( "toolkit", components.JAboutPanel.class, "getToolkit", null ); // NOI18N
            properties[PROPERTY_toolkit].setHidden ( true );
            properties[PROPERTY_toolTipText] = new PropertyDescriptor ( "toolTipText", components.JAboutPanel.class, "getToolTipText", "setToolTipText" ); // NOI18N
            properties[PROPERTY_toolTipText].setPreferred ( true );
            properties[PROPERTY_toolTipText].setShortDescription ( "The text to display in a tool tip." );
            properties[PROPERTY_topLevelAncestor] = new PropertyDescriptor ( "topLevelAncestor", components.JAboutPanel.class, "getTopLevelAncestor", null ); // NOI18N
            properties[PROPERTY_topLevelAncestor].setHidden ( true );
            properties[PROPERTY_transferHandler] = new PropertyDescriptor ( "transferHandler", components.JAboutPanel.class, "getTransferHandler", "setTransferHandler" ); // NOI18N
            properties[PROPERTY_transferHandler].setHidden ( true );
            properties[PROPERTY_transferHandler].setShortDescription ( "Mechanism for transfer of data to and from the component" );
            properties[PROPERTY_treeLock] = new PropertyDescriptor ( "treeLock", components.JAboutPanel.class, "getTreeLock", null ); // NOI18N
            properties[PROPERTY_treeLock].setHidden ( true );
            properties[PROPERTY_UI] = new PropertyDescriptor ( "UI", components.JAboutPanel.class, "getUI", "setUI" ); // NOI18N
            properties[PROPERTY_UI].setHidden ( true );
            properties[PROPERTY_UI].setShortDescription ( "The UI object that implements the Component's LookAndFeel." );
            properties[PROPERTY_UIClassID] = new PropertyDescriptor ( "UIClassID", components.JAboutPanel.class, "getUIClassID", null ); // NOI18N
            properties[PROPERTY_unvisitedHyperlinkColor] = new PropertyDescriptor ( "unvisitedHyperlinkColor", components.JAboutPanel.class, "getUnvisitedHyperlinkColor", "setUnvisitedHyperlinkColor" ); // NOI18N
            properties[PROPERTY_unvisitedHyperlinkColor].setShortDescription ( "The color to use for hyperlinks that have not been visited yet." );
            properties[PROPERTY_unvisitedHyperlinkColor].setBound ( true );
            properties[PROPERTY_unvisitedHyperlinkColorSet] = new PropertyDescriptor ( "unvisitedHyperlinkColorSet", components.JAboutPanel.class, "isUnvisitedHyperlinkColorSet", null ); // NOI18N
            properties[PROPERTY_unvisitedHyperlinkColorSet].setHidden ( true );
            properties[PROPERTY_updateButton] = new PropertyDescriptor ( "updateButton", components.JAboutPanel.class, "getUpdateButton", null ); // NOI18N
            properties[PROPERTY_updateButtonIsShown] = new PropertyDescriptor ( "updateButtonIsShown", components.JAboutPanel.class, "getUpdateButtonIsShown", "setUpdateButtonIsShown" ); // NOI18N
            properties[PROPERTY_updateButtonText] = new PropertyDescriptor ( "updateButtonText", components.JAboutPanel.class, "getUpdateButtonText", "setUpdateButtonText" ); // NOI18N
            properties[PROPERTY_updateButtonTextSet] = new PropertyDescriptor ( "updateButtonTextSet", components.JAboutPanel.class, "isUpdateButtonTextSet", null ); // NOI18N
            properties[PROPERTY_updateButtonToolTipText] = new PropertyDescriptor ( "updateButtonToolTipText", components.JAboutPanel.class, "getUpdateButtonToolTipText", "setUpdateButtonToolTipText" ); // NOI18N
            properties[PROPERTY_updateButtonToolTipTextSet] = new PropertyDescriptor ( "updateButtonToolTipTextSet", components.JAboutPanel.class, "isUpdateButtonToolTipTextSet", null ); // NOI18N
            properties[PROPERTY_valid] = new PropertyDescriptor ( "valid", components.JAboutPanel.class, "isValid", null ); // NOI18N
            properties[PROPERTY_valid].setHidden ( true );
            properties[PROPERTY_validateRoot] = new PropertyDescriptor ( "validateRoot", components.JAboutPanel.class, "isValidateRoot", null ); // NOI18N
            properties[PROPERTY_validateRoot].setHidden ( true );
            properties[PROPERTY_verifyInputWhenFocusTarget] = new PropertyDescriptor ( "verifyInputWhenFocusTarget", components.JAboutPanel.class, "getVerifyInputWhenFocusTarget", "setVerifyInputWhenFocusTarget" ); // NOI18N
            properties[PROPERTY_verifyInputWhenFocusTarget].setShortDescription ( "Whether the Component verifies input before accepting focus." );
            properties[PROPERTY_vetoableChangeListeners] = new PropertyDescriptor ( "vetoableChangeListeners", components.JAboutPanel.class, "getVetoableChangeListeners", null ); // NOI18N
            properties[PROPERTY_vetoableChangeListeners].setHidden ( true );
            properties[PROPERTY_visible] = new PropertyDescriptor ( "visible", components.JAboutPanel.class, "isVisible", "setVisible" ); // NOI18N
            properties[PROPERTY_visible].setHidden ( true );
            properties[PROPERTY_visibleRect] = new PropertyDescriptor ( "visibleRect", components.JAboutPanel.class, "getVisibleRect", null ); // NOI18N
            properties[PROPERTY_visibleRect].setHidden ( true );
            properties[PROPERTY_visitedHyperlinkColor] = new PropertyDescriptor ( "visitedHyperlinkColor", components.JAboutPanel.class, "getVisitedHyperlinkColor", "setVisitedHyperlinkColor" ); // NOI18N
            properties[PROPERTY_visitedHyperlinkColor].setShortDescription ( "The color to use for visited hyperlinks." );
            properties[PROPERTY_visitedHyperlinkColor].setBound ( true );
            properties[PROPERTY_visitedHyperlinkColorSet] = new PropertyDescriptor ( "visitedHyperlinkColorSet", components.JAboutPanel.class, "isVisitedHyperlinkColorSet", null ); // NOI18N
            properties[PROPERTY_visitedHyperlinkColorSet].setHidden ( true );
            properties[PROPERTY_websiteCopyMenuItem] = new PropertyDescriptor ( "websiteCopyMenuItem", components.JAboutPanel.class, "getWebsiteCopyMenuItem", null ); // NOI18N
            properties[PROPERTY_websiteOpenMenuItem] = new PropertyDescriptor ( "websiteOpenMenuItem", components.JAboutPanel.class, "getWebsiteOpenMenuItem", null ); // NOI18N
            properties[PROPERTY_websitePopup] = new PropertyDescriptor ( "websitePopup", components.JAboutPanel.class, "getWebsitePopup", null ); // NOI18N
            properties[PROPERTY_width] = new PropertyDescriptor ( "width", components.JAboutPanel.class, "getWidth", null ); // NOI18N
            properties[PROPERTY_width].setHidden ( true );
            properties[PROPERTY_x] = new PropertyDescriptor ( "x", components.JAboutPanel.class, "getX", null ); // NOI18N
            properties[PROPERTY_x].setHidden ( true );
            properties[PROPERTY_y] = new PropertyDescriptor ( "y", components.JAboutPanel.class, "getY", null ); // NOI18N
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
            eventSets[EVENT_actionListener] = new EventSetDescriptor ( components.JAboutPanel.class, "actionListener", java.awt.event.ActionListener.class, new String[] {"actionPerformed"}, "addActionListener", "removeActionListener" ); // NOI18N
            eventSets[EVENT_ancestorListener] = new EventSetDescriptor ( components.JAboutPanel.class, "ancestorListener", javax.swing.event.AncestorListener.class, new String[] {"ancestorAdded", "ancestorRemoved", "ancestorMoved"}, "addAncestorListener", "removeAncestorListener" ); // NOI18N
            eventSets[EVENT_componentListener] = new EventSetDescriptor ( components.JAboutPanel.class, "componentListener", java.awt.event.ComponentListener.class, new String[] {"componentResized", "componentMoved", "componentShown", "componentHidden"}, "addComponentListener", "removeComponentListener" ); // NOI18N
            eventSets[EVENT_containerListener] = new EventSetDescriptor ( components.JAboutPanel.class, "containerListener", java.awt.event.ContainerListener.class, new String[] {"componentAdded", "componentRemoved"}, "addContainerListener", "removeContainerListener" ); // NOI18N
            eventSets[EVENT_focusListener] = new EventSetDescriptor ( components.JAboutPanel.class, "focusListener", java.awt.event.FocusListener.class, new String[] {"focusGained", "focusLost"}, "addFocusListener", "removeFocusListener" ); // NOI18N
            eventSets[EVENT_hierarchyBoundsListener] = new EventSetDescriptor ( components.JAboutPanel.class, "hierarchyBoundsListener", java.awt.event.HierarchyBoundsListener.class, new String[] {"ancestorMoved", "ancestorResized"}, "addHierarchyBoundsListener", "removeHierarchyBoundsListener" ); // NOI18N
            eventSets[EVENT_hierarchyListener] = new EventSetDescriptor ( components.JAboutPanel.class, "hierarchyListener", java.awt.event.HierarchyListener.class, new String[] {"hierarchyChanged"}, "addHierarchyListener", "removeHierarchyListener" ); // NOI18N
            eventSets[EVENT_inputMethodListener] = new EventSetDescriptor ( components.JAboutPanel.class, "inputMethodListener", java.awt.event.InputMethodListener.class, new String[] {"inputMethodTextChanged", "caretPositionChanged"}, "addInputMethodListener", "removeInputMethodListener" ); // NOI18N
            eventSets[EVENT_keyListener] = new EventSetDescriptor ( components.JAboutPanel.class, "keyListener", java.awt.event.KeyListener.class, new String[] {"keyTyped", "keyPressed", "keyReleased"}, "addKeyListener", "removeKeyListener" ); // NOI18N
            eventSets[EVENT_mouseListener] = new EventSetDescriptor ( components.JAboutPanel.class, "mouseListener", java.awt.event.MouseListener.class, new String[] {"mouseClicked", "mousePressed", "mouseReleased", "mouseEntered", "mouseExited"}, "addMouseListener", "removeMouseListener" ); // NOI18N
            eventSets[EVENT_mouseMotionListener] = new EventSetDescriptor ( components.JAboutPanel.class, "mouseMotionListener", java.awt.event.MouseMotionListener.class, new String[] {"mouseDragged", "mouseMoved"}, "addMouseMotionListener", "removeMouseMotionListener" ); // NOI18N
            eventSets[EVENT_mouseWheelListener] = new EventSetDescriptor ( components.JAboutPanel.class, "mouseWheelListener", java.awt.event.MouseWheelListener.class, new String[] {"mouseWheelMoved"}, "addMouseWheelListener", "removeMouseWheelListener" ); // NOI18N
            eventSets[EVENT_propertyChangeListener] = new EventSetDescriptor ( components.JAboutPanel.class, "propertyChangeListener", java.beans.PropertyChangeListener.class, new String[] {"propertyChange"}, "addPropertyChangeListener", "removePropertyChangeListener" ); // NOI18N
            eventSets[EVENT_vetoableChangeListener] = new EventSetDescriptor ( components.JAboutPanel.class, "vetoableChangeListener", java.beans.VetoableChangeListener.class, new String[] {"vetoableChange"}, "addVetoableChangeListener", "removeVetoableChangeListener" ); // NOI18N
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
