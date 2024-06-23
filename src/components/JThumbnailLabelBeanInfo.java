/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Beans/BeanInfo.java to edit this template
 */
package components;

import beans.BeanInfoIconFactory;
import java.beans.*;

/**
 * This is the beans info for JThumbnailLabel.
 * @author Milo Steier
 * @see JThumbnailLabel
 */
public class JThumbnailLabelBeanInfo extends SimpleBeanInfo {

    // Bean descriptor//GEN-FIRST:BeanDescriptor
    /*lazy BeanDescriptor*/
    private static BeanDescriptor getBdescriptor(){
        BeanDescriptor beanDescriptor = new BeanDescriptor  ( components.JThumbnailLabel.class , null ); // NOI18N
        beanDescriptor.setShortDescription ( "A label used to display thumbnails of images and icons" );//GEN-HEADEREND:BeanDescriptor
        // Here you can add code for customizing the BeanDescriptor.
        
        return beanDescriptor;     }//GEN-LAST:BeanDescriptor


    // Property identifiers//GEN-FIRST:Properties
    private static final int PROPERTY_accessibleContext = 0;
    private static final int PROPERTY_actionMap = 1;
    private static final int PROPERTY_alignmentX = 2;
    private static final int PROPERTY_alignmentY = 3;
    private static final int PROPERTY_ancestorListeners = 4;
    private static final int PROPERTY_aspectRatioMaintained = 5;
    private static final int PROPERTY_autoscrolls = 6;
    private static final int PROPERTY_background = 7;
    private static final int PROPERTY_backgroundSet = 8;
    private static final int PROPERTY_baselineResizeBehavior = 9;
    private static final int PROPERTY_border = 10;
    private static final int PROPERTY_bounds = 11;
    private static final int PROPERTY_colorModel = 12;
    private static final int PROPERTY_component = 13;
    private static final int PROPERTY_componentCount = 14;
    private static final int PROPERTY_componentListeners = 15;
    private static final int PROPERTY_componentOrientation = 16;
    private static final int PROPERTY_componentPopupMenu = 17;
    private static final int PROPERTY_components = 18;
    private static final int PROPERTY_containerListeners = 19;
    private static final int PROPERTY_cursor = 20;
    private static final int PROPERTY_cursorSet = 21;
    private static final int PROPERTY_debugGraphicsOptions = 22;
    private static final int PROPERTY_disabledIcon = 23;
    private static final int PROPERTY_displayable = 24;
    private static final int PROPERTY_displayedMnemonic = 25;
    private static final int PROPERTY_displayedMnemonicIndex = 26;
    private static final int PROPERTY_doubleBuffered = 27;
    private static final int PROPERTY_dropTarget = 28;
    private static final int PROPERTY_enabled = 29;
    private static final int PROPERTY_focusable = 30;
    private static final int PROPERTY_focusCycleRoot = 31;
    private static final int PROPERTY_focusCycleRootAncestor = 32;
    private static final int PROPERTY_focusListeners = 33;
    private static final int PROPERTY_focusOwner = 34;
    private static final int PROPERTY_focusTraversable = 35;
    private static final int PROPERTY_focusTraversalKeys = 36;
    private static final int PROPERTY_focusTraversalKeysEnabled = 37;
    private static final int PROPERTY_focusTraversalPolicy = 38;
    private static final int PROPERTY_focusTraversalPolicyProvider = 39;
    private static final int PROPERTY_focusTraversalPolicySet = 40;
    private static final int PROPERTY_font = 41;
    private static final int PROPERTY_fontMetrics = 42;
    private static final int PROPERTY_fontSet = 43;
    private static final int PROPERTY_foreground = 44;
    private static final int PROPERTY_foregroundSet = 45;
    private static final int PROPERTY_graphics = 46;
    private static final int PROPERTY_graphicsConfiguration = 47;
    private static final int PROPERTY_height = 48;
    private static final int PROPERTY_hierarchyBoundsListeners = 49;
    private static final int PROPERTY_hierarchyListeners = 50;
    private static final int PROPERTY_horizontalAlignment = 51;
    private static final int PROPERTY_horizontalTextPosition = 52;
    private static final int PROPERTY_icon = 53;
    private static final int PROPERTY_iconTextGap = 54;
    private static final int PROPERTY_ignoreRepaint = 55;
    private static final int PROPERTY_image = 56;
    private static final int PROPERTY_imageAlwaysScaled = 57;
    private static final int PROPERTY_imageHeight = 58;
    private static final int PROPERTY_imageScaleMode = 59;
    private static final int PROPERTY_imageSize = 60;
    private static final int PROPERTY_imageWidth = 61;
    private static final int PROPERTY_inheritsPopupMenu = 62;
    private static final int PROPERTY_inputContext = 63;
    private static final int PROPERTY_inputMap = 64;
    private static final int PROPERTY_inputMethodListeners = 65;
    private static final int PROPERTY_inputMethodRequests = 66;
    private static final int PROPERTY_inputVerifier = 67;
    private static final int PROPERTY_insets = 68;
    private static final int PROPERTY_keyListeners = 69;
    private static final int PROPERTY_labelFor = 70;
    private static final int PROPERTY_layout = 71;
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
    private static final int PROPERTY_mousePositionInThumbnailRegion = 85;
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
    private static final int PROPERTY_renderingHints = 98;
    private static final int PROPERTY_requestFocusEnabled = 99;
    private static final int PROPERTY_rootPane = 100;
    private static final int PROPERTY_scaleX = 101;
    private static final int PROPERTY_scaleY = 102;
    private static final int PROPERTY_showing = 103;
    private static final int PROPERTY_size = 104;
    private static final int PROPERTY_text = 105;
    private static final int PROPERTY_thumbnailBorder = 106;
    private static final int PROPERTY_thumbnailBounds = 107;
    private static final int PROPERTY_thumbnailHeight = 108;
    private static final int PROPERTY_thumbnailInsets = 109;
    private static final int PROPERTY_thumbnailLocation = 110;
    private static final int PROPERTY_thumbnailOverlay = 111;
    private static final int PROPERTY_thumbnailRegionBounds = 112;
    private static final int PROPERTY_thumbnailRegionHeight = 113;
    private static final int PROPERTY_thumbnailRegionLocation = 114;
    private static final int PROPERTY_thumbnailRegionSize = 115;
    private static final int PROPERTY_thumbnailRegionWidth = 116;
    private static final int PROPERTY_thumbnailRegionX = 117;
    private static final int PROPERTY_thumbnailRegionY = 118;
    private static final int PROPERTY_thumbnailSize = 119;
    private static final int PROPERTY_thumbnailTransform = 120;
    private static final int PROPERTY_thumbnailWidth = 121;
    private static final int PROPERTY_thumbnailX = 122;
    private static final int PROPERTY_thumbnailY = 123;
    private static final int PROPERTY_toolkit = 124;
    private static final int PROPERTY_toolTipText = 125;
    private static final int PROPERTY_topLevelAncestor = 126;
    private static final int PROPERTY_transferHandler = 127;
    private static final int PROPERTY_treeLock = 128;
    private static final int PROPERTY_UI = 129;
    private static final int PROPERTY_UIClassID = 130;
    private static final int PROPERTY_valid = 131;
    private static final int PROPERTY_validateRoot = 132;
    private static final int PROPERTY_verifyInputWhenFocusTarget = 133;
    private static final int PROPERTY_verticalAlignment = 134;
    private static final int PROPERTY_verticalTextPosition = 135;
    private static final int PROPERTY_vetoableChangeListeners = 136;
    private static final int PROPERTY_visible = 137;
    private static final int PROPERTY_visibleRect = 138;
    private static final int PROPERTY_width = 139;
    private static final int PROPERTY_x = 140;
    private static final int PROPERTY_y = 141;

    // Property array 
    /*lazy PropertyDescriptor*/
    private static PropertyDescriptor[] getPdescriptor(){
        PropertyDescriptor[] properties = new PropertyDescriptor[142];
    
        try {
            properties[PROPERTY_accessibleContext] = new PropertyDescriptor ( "accessibleContext", components.JThumbnailLabel.class, "getAccessibleContext", null ); // NOI18N
            properties[PROPERTY_accessibleContext].setHidden ( true );
            properties[PROPERTY_actionMap] = new PropertyDescriptor ( "actionMap", components.JThumbnailLabel.class, "getActionMap", "setActionMap" ); // NOI18N
            properties[PROPERTY_actionMap].setHidden ( true );
            properties[PROPERTY_alignmentX] = new PropertyDescriptor ( "alignmentX", components.JThumbnailLabel.class, "getAlignmentX", "setAlignmentX" ); // NOI18N
            properties[PROPERTY_alignmentX].setShortDescription ( "The preferred horizontal alignment of the component." );
            properties[PROPERTY_alignmentY] = new PropertyDescriptor ( "alignmentY", components.JThumbnailLabel.class, "getAlignmentY", "setAlignmentY" ); // NOI18N
            properties[PROPERTY_alignmentY].setShortDescription ( "The preferred vertical alignment of the component." );
            properties[PROPERTY_ancestorListeners] = new PropertyDescriptor ( "ancestorListeners", components.JThumbnailLabel.class, "getAncestorListeners", null ); // NOI18N
            properties[PROPERTY_ancestorListeners].setHidden ( true );
            properties[PROPERTY_aspectRatioMaintained] = new PropertyDescriptor ( "aspectRatioMaintained", components.JThumbnailLabel.class, "isAspectRatioMaintained", "setAspectRatioMaintained" ); // NOI18N
            properties[PROPERTY_aspectRatioMaintained].setShortDescription ( "Whether the aspect ratio is maintained when the image or icon is scaled." );
            properties[PROPERTY_autoscrolls] = new PropertyDescriptor ( "autoscrolls", components.JThumbnailLabel.class, "getAutoscrolls", "setAutoscrolls" ); // NOI18N
            properties[PROPERTY_autoscrolls].setShortDescription ( "Determines if this component automatically scrolls its contents when dragged." );
            properties[PROPERTY_background] = new PropertyDescriptor ( "background", components.JThumbnailLabel.class, "getBackground", "setBackground" ); // NOI18N
            properties[PROPERTY_background].setPreferred ( true );
            properties[PROPERTY_background].setShortDescription ( "The background color of the component." );
            properties[PROPERTY_background].setBound ( true );
            properties[PROPERTY_backgroundSet] = new PropertyDescriptor ( "backgroundSet", components.JThumbnailLabel.class, "isBackgroundSet", null ); // NOI18N
            properties[PROPERTY_backgroundSet].setHidden ( true );
            properties[PROPERTY_baselineResizeBehavior] = new PropertyDescriptor ( "baselineResizeBehavior", components.JThumbnailLabel.class, "getBaselineResizeBehavior", null ); // NOI18N
            properties[PROPERTY_baselineResizeBehavior].setExpert ( true );
            properties[PROPERTY_border] = new PropertyDescriptor ( "border", components.JThumbnailLabel.class, "getBorder", "setBorder" ); // NOI18N
            properties[PROPERTY_border].setShortDescription ( "The component's border." );
            properties[PROPERTY_border].setBound ( true );
            properties[PROPERTY_bounds] = new PropertyDescriptor ( "bounds", components.JThumbnailLabel.class, "getBounds", "setBounds" ); // NOI18N
            properties[PROPERTY_bounds].setHidden ( true );
            properties[PROPERTY_colorModel] = new PropertyDescriptor ( "colorModel", components.JThumbnailLabel.class, "getColorModel", null ); // NOI18N
            properties[PROPERTY_colorModel].setHidden ( true );
            properties[PROPERTY_component] = new IndexedPropertyDescriptor ( "component", components.JThumbnailLabel.class, null, null, "getComponent", null ); // NOI18N
            properties[PROPERTY_componentCount] = new PropertyDescriptor ( "componentCount", components.JThumbnailLabel.class, "getComponentCount", null ); // NOI18N
            properties[PROPERTY_componentCount].setHidden ( true );
            properties[PROPERTY_componentListeners] = new PropertyDescriptor ( "componentListeners", components.JThumbnailLabel.class, "getComponentListeners", null ); // NOI18N
            properties[PROPERTY_componentListeners].setHidden ( true );
            properties[PROPERTY_componentOrientation] = new PropertyDescriptor ( "componentOrientation", components.JThumbnailLabel.class, "getComponentOrientation", "setComponentOrientation" ); // NOI18N
            properties[PROPERTY_componentOrientation].setHidden ( true );
            properties[PROPERTY_componentPopupMenu] = new PropertyDescriptor ( "componentPopupMenu", components.JThumbnailLabel.class, "getComponentPopupMenu", "setComponentPopupMenu" ); // NOI18N
            properties[PROPERTY_componentPopupMenu].setShortDescription ( "The popup menu to show" );
            properties[PROPERTY_componentPopupMenu].setBound ( true );
            properties[PROPERTY_components] = new PropertyDescriptor ( "components", components.JThumbnailLabel.class, "getComponents", null ); // NOI18N
            properties[PROPERTY_components].setHidden ( true );
            properties[PROPERTY_containerListeners] = new PropertyDescriptor ( "containerListeners", components.JThumbnailLabel.class, "getContainerListeners", null ); // NOI18N
            properties[PROPERTY_containerListeners].setHidden ( true );
            properties[PROPERTY_cursor] = new PropertyDescriptor ( "cursor", components.JThumbnailLabel.class, "getCursor", "setCursor" ); // NOI18N
            properties[PROPERTY_cursorSet] = new PropertyDescriptor ( "cursorSet", components.JThumbnailLabel.class, "isCursorSet", null ); // NOI18N
            properties[PROPERTY_cursorSet].setHidden ( true );
            properties[PROPERTY_debugGraphicsOptions] = new PropertyDescriptor ( "debugGraphicsOptions", components.JThumbnailLabel.class, "getDebugGraphicsOptions", "setDebugGraphicsOptions" ); // NOI18N
            properties[PROPERTY_debugGraphicsOptions].setShortDescription ( "Diagnostic options for graphics operations." );
            properties[PROPERTY_disabledIcon] = new PropertyDescriptor ( "disabledIcon", components.JThumbnailLabel.class, "getDisabledIcon", "setDisabledIcon" ); // NOI18N
            properties[PROPERTY_disabledIcon].setShortDescription ( "The icon to display if the label is disabled." );
            properties[PROPERTY_displayable] = new PropertyDescriptor ( "displayable", components.JThumbnailLabel.class, "isDisplayable", null ); // NOI18N
            properties[PROPERTY_displayable].setHidden ( true );
            properties[PROPERTY_displayedMnemonic] = new PropertyDescriptor ( "displayedMnemonic", components.JThumbnailLabel.class, "getDisplayedMnemonic", null ); // NOI18N
            properties[PROPERTY_displayedMnemonic].setPreferred ( true );
            properties[PROPERTY_displayedMnemonic].setShortDescription ( "The mnemonic keycode." );
            properties[PROPERTY_displayedMnemonicIndex] = new PropertyDescriptor ( "displayedMnemonicIndex", components.JThumbnailLabel.class, "getDisplayedMnemonicIndex", "setDisplayedMnemonicIndex" ); // NOI18N
            properties[PROPERTY_displayedMnemonicIndex].setShortDescription ( "The index into the String to draw the keyboard character mnemonic at" );
            properties[PROPERTY_doubleBuffered] = new PropertyDescriptor ( "doubleBuffered", components.JThumbnailLabel.class, "isDoubleBuffered", "setDoubleBuffered" ); // NOI18N
            properties[PROPERTY_dropTarget] = new PropertyDescriptor ( "dropTarget", components.JThumbnailLabel.class, "getDropTarget", "setDropTarget" ); // NOI18N
            properties[PROPERTY_dropTarget].setHidden ( true );
            properties[PROPERTY_enabled] = new PropertyDescriptor ( "enabled", components.JThumbnailLabel.class, "isEnabled", "setEnabled" ); // NOI18N
            properties[PROPERTY_enabled].setShortDescription ( "The enabled state of the component." );
            properties[PROPERTY_enabled].setBound ( true );
            properties[PROPERTY_focusable] = new PropertyDescriptor ( "focusable", components.JThumbnailLabel.class, "isFocusable", "setFocusable" ); // NOI18N
            properties[PROPERTY_focusCycleRoot] = new PropertyDescriptor ( "focusCycleRoot", components.JThumbnailLabel.class, "isFocusCycleRoot", "setFocusCycleRoot" ); // NOI18N
            properties[PROPERTY_focusCycleRootAncestor] = new PropertyDescriptor ( "focusCycleRootAncestor", components.JThumbnailLabel.class, "getFocusCycleRootAncestor", null ); // NOI18N
            properties[PROPERTY_focusCycleRootAncestor].setHidden ( true );
            properties[PROPERTY_focusListeners] = new PropertyDescriptor ( "focusListeners", components.JThumbnailLabel.class, "getFocusListeners", null ); // NOI18N
            properties[PROPERTY_focusListeners].setHidden ( true );
            properties[PROPERTY_focusOwner] = new PropertyDescriptor ( "focusOwner", components.JThumbnailLabel.class, "isFocusOwner", null ); // NOI18N
            properties[PROPERTY_focusOwner].setHidden ( true );
            properties[PROPERTY_focusTraversable] = new PropertyDescriptor ( "focusTraversable", components.JThumbnailLabel.class, "isFocusTraversable", null ); // NOI18N
            properties[PROPERTY_focusTraversable].setHidden ( true );
            properties[PROPERTY_focusTraversalKeys] = new IndexedPropertyDescriptor ( "focusTraversalKeys", components.JThumbnailLabel.class, null, null, null, "setFocusTraversalKeys" ); // NOI18N
            properties[PROPERTY_focusTraversalKeysEnabled] = new PropertyDescriptor ( "focusTraversalKeysEnabled", components.JThumbnailLabel.class, "getFocusTraversalKeysEnabled", "setFocusTraversalKeysEnabled" ); // NOI18N
            properties[PROPERTY_focusTraversalKeysEnabled].setHidden ( true );
            properties[PROPERTY_focusTraversalPolicy] = new PropertyDescriptor ( "focusTraversalPolicy", components.JThumbnailLabel.class, "getFocusTraversalPolicy", "setFocusTraversalPolicy" ); // NOI18N
            properties[PROPERTY_focusTraversalPolicyProvider] = new PropertyDescriptor ( "focusTraversalPolicyProvider", components.JThumbnailLabel.class, "isFocusTraversalPolicyProvider", "setFocusTraversalPolicyProvider" ); // NOI18N
            properties[PROPERTY_focusTraversalPolicySet] = new PropertyDescriptor ( "focusTraversalPolicySet", components.JThumbnailLabel.class, "isFocusTraversalPolicySet", null ); // NOI18N
            properties[PROPERTY_focusTraversalPolicySet].setHidden ( true );
            properties[PROPERTY_font] = new PropertyDescriptor ( "font", components.JThumbnailLabel.class, "getFont", "setFont" ); // NOI18N
            properties[PROPERTY_font].setPreferred ( true );
            properties[PROPERTY_font].setShortDescription ( "The font for the component." );
            properties[PROPERTY_font].setBound ( true );
            properties[PROPERTY_fontMetrics] = new PropertyDescriptor ( "fontMetrics", components.JThumbnailLabel.class, "getFontMetrics", null ); // NOI18N
            properties[PROPERTY_fontMetrics].setHidden ( true );
            properties[PROPERTY_fontMetrics].setShortDescription ( "The font metrics for the currently set font" );
            properties[PROPERTY_fontSet] = new PropertyDescriptor ( "fontSet", components.JThumbnailLabel.class, "isFontSet", null ); // NOI18N
            properties[PROPERTY_fontSet].setHidden ( true );
            properties[PROPERTY_foreground] = new PropertyDescriptor ( "foreground", components.JThumbnailLabel.class, "getForeground", "setForeground" ); // NOI18N
            properties[PROPERTY_foreground].setPreferred ( true );
            properties[PROPERTY_foreground].setShortDescription ( "The foreground color of the component." );
            properties[PROPERTY_foreground].setBound ( true );
            properties[PROPERTY_foregroundSet] = new PropertyDescriptor ( "foregroundSet", components.JThumbnailLabel.class, "isForegroundSet", null ); // NOI18N
            properties[PROPERTY_foregroundSet].setHidden ( true );
            properties[PROPERTY_graphics] = new PropertyDescriptor ( "graphics", components.JThumbnailLabel.class, "getGraphics", null ); // NOI18N
            properties[PROPERTY_graphics].setHidden ( true );
            properties[PROPERTY_graphicsConfiguration] = new PropertyDescriptor ( "graphicsConfiguration", components.JThumbnailLabel.class, "getGraphicsConfiguration", null ); // NOI18N
            properties[PROPERTY_graphicsConfiguration].setHidden ( true );
            properties[PROPERTY_height] = new PropertyDescriptor ( "height", components.JThumbnailLabel.class, "getHeight", null ); // NOI18N
            properties[PROPERTY_height].setHidden ( true );
            properties[PROPERTY_hierarchyBoundsListeners] = new PropertyDescriptor ( "hierarchyBoundsListeners", components.JThumbnailLabel.class, "getHierarchyBoundsListeners", null ); // NOI18N
            properties[PROPERTY_hierarchyBoundsListeners].setHidden ( true );
            properties[PROPERTY_hierarchyListeners] = new PropertyDescriptor ( "hierarchyListeners", components.JThumbnailLabel.class, "getHierarchyListeners", null ); // NOI18N
            properties[PROPERTY_hierarchyListeners].setHidden ( true );
            properties[PROPERTY_horizontalAlignment] = new PropertyDescriptor ( "horizontalAlignment", components.JThumbnailLabel.class, "getHorizontalAlignment", "setHorizontalAlignment" ); // NOI18N
            properties[PROPERTY_horizontalAlignment].setPreferred ( true );
            properties[PROPERTY_horizontalAlignment].setShortDescription ( "The alignment of the label's content along the X axis." );
            properties[PROPERTY_horizontalAlignment].setPropertyEditorClass ( beans.HorizontalAlignmentEditor.class );
            properties[PROPERTY_horizontalTextPosition] = new PropertyDescriptor ( "horizontalTextPosition", components.JThumbnailLabel.class, "getHorizontalTextPosition", "setHorizontalTextPosition" ); // NOI18N
            properties[PROPERTY_horizontalTextPosition].setPreferred ( true );
            properties[PROPERTY_horizontalTextPosition].setShortDescription ( "The horizontal position of the label's text, relative to its image." );
            properties[PROPERTY_horizontalTextPosition].setPropertyEditorClass ( beans.HorizontalAlignmentEditor.class );
            properties[PROPERTY_icon] = new PropertyDescriptor ( "icon", components.JThumbnailLabel.class, "getIcon", "setIcon" ); // NOI18N
            properties[PROPERTY_icon].setPreferred ( true );
            properties[PROPERTY_icon].setShortDescription ( "The icon this component will display." );
            properties[PROPERTY_icon].setBound ( true );
            properties[PROPERTY_iconTextGap] = new PropertyDescriptor ( "iconTextGap", components.JThumbnailLabel.class, "getIconTextGap", "setIconTextGap" ); // NOI18N
            properties[PROPERTY_iconTextGap].setShortDescription ( "If both the icon and text properties are set, this property defines the space between them." );
            properties[PROPERTY_iconTextGap].setBound ( true );
            properties[PROPERTY_ignoreRepaint] = new PropertyDescriptor ( "ignoreRepaint", components.JThumbnailLabel.class, "getIgnoreRepaint", "setIgnoreRepaint" ); // NOI18N
            properties[PROPERTY_ignoreRepaint].setHidden ( true );
            properties[PROPERTY_image] = new PropertyDescriptor ( "image", components.JThumbnailLabel.class, "getImage", "setImage" ); // NOI18N
            properties[PROPERTY_image].setShortDescription ( "The image this component will display." );
            properties[PROPERTY_imageAlwaysScaled] = new PropertyDescriptor ( "imageAlwaysScaled", components.JThumbnailLabel.class, "isImageAlwaysScaled", "setImageAlwaysScaled" ); // NOI18N
            properties[PROPERTY_imageAlwaysScaled].setShortDescription ( "Whether the image is always scaled." );
            properties[PROPERTY_imageHeight] = new PropertyDescriptor ( "imageHeight", components.JThumbnailLabel.class, "getImageHeight", null ); // NOI18N
            properties[PROPERTY_imageHeight].setHidden ( true );
            properties[PROPERTY_imageScaleMode] = new PropertyDescriptor ( "imageScaleMode", components.JThumbnailLabel.class, "getImageScaleMode", "setImageScaleMode" ); // NOI18N
            properties[PROPERTY_imageScaleMode].setPreferred ( true );
            properties[PROPERTY_imageScaleMode].setShortDescription ( "The mode for scaling the image or icon." );
            properties[PROPERTY_imageScaleMode].setBound ( true );
            properties[PROPERTY_imageScaleMode].setPropertyEditorClass ( ImageScaleModeEditor.class );
            properties[PROPERTY_imageSize] = new PropertyDescriptor ( "imageSize", components.JThumbnailLabel.class, "getImageSize", null ); // NOI18N
            properties[PROPERTY_imageSize].setHidden ( true );
            properties[PROPERTY_imageWidth] = new PropertyDescriptor ( "imageWidth", components.JThumbnailLabel.class, "getImageWidth", null ); // NOI18N
            properties[PROPERTY_imageWidth].setHidden ( true );
            properties[PROPERTY_inheritsPopupMenu] = new PropertyDescriptor ( "inheritsPopupMenu", components.JThumbnailLabel.class, "getInheritsPopupMenu", "setInheritsPopupMenu" ); // NOI18N
            properties[PROPERTY_inheritsPopupMenu].setShortDescription ( "Whether or not the JPopupMenu is inherited" );
            properties[PROPERTY_inheritsPopupMenu].setBound ( true );
            properties[PROPERTY_inputContext] = new PropertyDescriptor ( "inputContext", components.JThumbnailLabel.class, "getInputContext", null ); // NOI18N
            properties[PROPERTY_inputContext].setHidden ( true );
            properties[PROPERTY_inputMap] = new PropertyDescriptor ( "inputMap", components.JThumbnailLabel.class, "getInputMap", null ); // NOI18N
            properties[PROPERTY_inputMap].setHidden ( true );
            properties[PROPERTY_inputMethodListeners] = new PropertyDescriptor ( "inputMethodListeners", components.JThumbnailLabel.class, "getInputMethodListeners", null ); // NOI18N
            properties[PROPERTY_inputMethodListeners].setHidden ( true );
            properties[PROPERTY_inputMethodRequests] = new PropertyDescriptor ( "inputMethodRequests", components.JThumbnailLabel.class, "getInputMethodRequests", null ); // NOI18N
            properties[PROPERTY_inputMethodRequests].setHidden ( true );
            properties[PROPERTY_inputVerifier] = new PropertyDescriptor ( "inputVerifier", components.JThumbnailLabel.class, "getInputVerifier", "setInputVerifier" ); // NOI18N
            properties[PROPERTY_inputVerifier].setShortDescription ( "The component's input verifier." );
            properties[PROPERTY_insets] = new PropertyDescriptor ( "insets", components.JThumbnailLabel.class, "getInsets", null ); // NOI18N
            properties[PROPERTY_insets].setExpert ( true );
            properties[PROPERTY_keyListeners] = new PropertyDescriptor ( "keyListeners", components.JThumbnailLabel.class, "getKeyListeners", null ); // NOI18N
            properties[PROPERTY_keyListeners].setHidden ( true );
            properties[PROPERTY_labelFor] = new PropertyDescriptor ( "labelFor", components.JThumbnailLabel.class, "getLabelFor", "setLabelFor" ); // NOI18N
            properties[PROPERTY_labelFor].setShortDescription ( "The component this is labelling." );
            properties[PROPERTY_layout] = new PropertyDescriptor ( "layout", components.JThumbnailLabel.class, "getLayout", "setLayout" ); // NOI18N
            properties[PROPERTY_layout].setHidden ( true );
            properties[PROPERTY_lightweight] = new PropertyDescriptor ( "lightweight", components.JThumbnailLabel.class, "isLightweight", null ); // NOI18N
            properties[PROPERTY_lightweight].setHidden ( true );
            properties[PROPERTY_locale] = new PropertyDescriptor ( "locale", components.JThumbnailLabel.class, "getLocale", "setLocale" ); // NOI18N
            properties[PROPERTY_locale].setHidden ( true );
            properties[PROPERTY_location] = new PropertyDescriptor ( "location", components.JThumbnailLabel.class, "getLocation", "setLocation" ); // NOI18N
            properties[PROPERTY_location].setHidden ( true );
            properties[PROPERTY_locationOnScreen] = new PropertyDescriptor ( "locationOnScreen", components.JThumbnailLabel.class, "getLocationOnScreen", null ); // NOI18N
            properties[PROPERTY_locationOnScreen].setHidden ( true );
            properties[PROPERTY_managingFocus] = new PropertyDescriptor ( "managingFocus", components.JThumbnailLabel.class, "isManagingFocus", null ); // NOI18N
            properties[PROPERTY_managingFocus].setHidden ( true );
            properties[PROPERTY_maximumSize] = new PropertyDescriptor ( "maximumSize", components.JThumbnailLabel.class, "getMaximumSize", "setMaximumSize" ); // NOI18N
            properties[PROPERTY_maximumSize].setShortDescription ( "The maximum size of the component." );
            properties[PROPERTY_maximumSize].setBound ( true );
            properties[PROPERTY_maximumSizeSet] = new PropertyDescriptor ( "maximumSizeSet", components.JThumbnailLabel.class, "isMaximumSizeSet", null ); // NOI18N
            properties[PROPERTY_maximumSizeSet].setHidden ( true );
            properties[PROPERTY_minimumSize] = new PropertyDescriptor ( "minimumSize", components.JThumbnailLabel.class, "getMinimumSize", "setMinimumSize" ); // NOI18N
            properties[PROPERTY_minimumSize].setShortDescription ( "The minimum size of the component." );
            properties[PROPERTY_minimumSize].setBound ( true );
            properties[PROPERTY_minimumSizeSet] = new PropertyDescriptor ( "minimumSizeSet", components.JThumbnailLabel.class, "isMinimumSizeSet", null ); // NOI18N
            properties[PROPERTY_minimumSizeSet].setHidden ( true );
            properties[PROPERTY_mixingCutoutShape] = new PropertyDescriptor ( "mixingCutoutShape", components.JThumbnailLabel.class, null, "setMixingCutoutShape" ); // NOI18N
            properties[PROPERTY_mixingCutoutShape].setHidden ( true );
            properties[PROPERTY_mouseListeners] = new PropertyDescriptor ( "mouseListeners", components.JThumbnailLabel.class, "getMouseListeners", null ); // NOI18N
            properties[PROPERTY_mouseListeners].setHidden ( true );
            properties[PROPERTY_mouseMotionListeners] = new PropertyDescriptor ( "mouseMotionListeners", components.JThumbnailLabel.class, "getMouseMotionListeners", null ); // NOI18N
            properties[PROPERTY_mouseMotionListeners].setHidden ( true );
            properties[PROPERTY_mousePosition] = new PropertyDescriptor ( "mousePosition", components.JThumbnailLabel.class, "getMousePosition", null ); // NOI18N
            properties[PROPERTY_mousePosition].setHidden ( true );
            properties[PROPERTY_mousePositionInThumbnailRegion] = new PropertyDescriptor ( "mousePositionInThumbnailRegion", components.JThumbnailLabel.class, "getMousePositionInThumbnailRegion", null ); // NOI18N
            properties[PROPERTY_mousePositionInThumbnailRegion].setHidden ( true );
            properties[PROPERTY_mouseWheelListeners] = new PropertyDescriptor ( "mouseWheelListeners", components.JThumbnailLabel.class, "getMouseWheelListeners", null ); // NOI18N
            properties[PROPERTY_mouseWheelListeners].setHidden ( true );
            properties[PROPERTY_name] = new PropertyDescriptor ( "name", components.JThumbnailLabel.class, "getName", "setName" ); // NOI18N
            properties[PROPERTY_name].setBound ( true );
            properties[PROPERTY_nextFocusableComponent] = new PropertyDescriptor ( "nextFocusableComponent", components.JThumbnailLabel.class, "getNextFocusableComponent", "setNextFocusableComponent" ); // NOI18N
            properties[PROPERTY_opaque] = new PropertyDescriptor ( "opaque", components.JThumbnailLabel.class, "isOpaque", "setOpaque" ); // NOI18N
            properties[PROPERTY_opaque].setShortDescription ( "The component's opacity" );
            properties[PROPERTY_optimizedDrawingEnabled] = new PropertyDescriptor ( "optimizedDrawingEnabled", components.JThumbnailLabel.class, "isOptimizedDrawingEnabled", null ); // NOI18N
            properties[PROPERTY_optimizedDrawingEnabled].setHidden ( true );
            properties[PROPERTY_paintingForPrint] = new PropertyDescriptor ( "paintingForPrint", components.JThumbnailLabel.class, "isPaintingForPrint", null ); // NOI18N
            properties[PROPERTY_paintingTile] = new PropertyDescriptor ( "paintingTile", components.JThumbnailLabel.class, "isPaintingTile", null ); // NOI18N
            properties[PROPERTY_paintingTile].setHidden ( true );
            properties[PROPERTY_parent] = new PropertyDescriptor ( "parent", components.JThumbnailLabel.class, "getParent", null ); // NOI18N
            properties[PROPERTY_parent].setHidden ( true );
            properties[PROPERTY_preferredSize] = new PropertyDescriptor ( "preferredSize", components.JThumbnailLabel.class, "getPreferredSize", "setPreferredSize" ); // NOI18N
            properties[PROPERTY_preferredSize].setShortDescription ( "The preferred size of the component." );
            properties[PROPERTY_preferredSize].setBound ( true );
            properties[PROPERTY_preferredSizeSet] = new PropertyDescriptor ( "preferredSizeSet", components.JThumbnailLabel.class, "isPreferredSizeSet", null ); // NOI18N
            properties[PROPERTY_preferredSizeSet].setHidden ( true );
            properties[PROPERTY_propertyChangeListeners] = new PropertyDescriptor ( "propertyChangeListeners", components.JThumbnailLabel.class, "getPropertyChangeListeners", null ); // NOI18N
            properties[PROPERTY_propertyChangeListeners].setHidden ( true );
            properties[PROPERTY_registeredKeyStrokes] = new PropertyDescriptor ( "registeredKeyStrokes", components.JThumbnailLabel.class, "getRegisteredKeyStrokes", null ); // NOI18N
            properties[PROPERTY_registeredKeyStrokes].setHidden ( true );
            properties[PROPERTY_renderingHints] = new PropertyDescriptor ( "renderingHints", components.JThumbnailLabel.class, "getRenderingHints", null ); // NOI18N
            properties[PROPERTY_renderingHints].setExpert ( true );
            properties[PROPERTY_renderingHints].setShortDescription ( "The rendering hints to use for rendering the thumbnail." );
            properties[PROPERTY_requestFocusEnabled] = new PropertyDescriptor ( "requestFocusEnabled", components.JThumbnailLabel.class, "isRequestFocusEnabled", "setRequestFocusEnabled" ); // NOI18N
            properties[PROPERTY_rootPane] = new PropertyDescriptor ( "rootPane", components.JThumbnailLabel.class, "getRootPane", null ); // NOI18N
            properties[PROPERTY_rootPane].setHidden ( true );
            properties[PROPERTY_scaleX] = new PropertyDescriptor ( "scaleX", components.JThumbnailLabel.class, "getScaleX", null ); // NOI18N
            properties[PROPERTY_scaleX].setHidden ( true );
            properties[PROPERTY_scaleX].setShortDescription ( "The x-coordinate scaling factor." );
            properties[PROPERTY_scaleY] = new PropertyDescriptor ( "scaleY", components.JThumbnailLabel.class, "getScaleY", null ); // NOI18N
            properties[PROPERTY_scaleY].setHidden ( true );
            properties[PROPERTY_scaleY].setShortDescription ( "The y-coordinate scaling factor." );
            properties[PROPERTY_showing] = new PropertyDescriptor ( "showing", components.JThumbnailLabel.class, "isShowing", null ); // NOI18N
            properties[PROPERTY_showing].setHidden ( true );
            properties[PROPERTY_size] = new PropertyDescriptor ( "size", components.JThumbnailLabel.class, "getSize", "setSize" ); // NOI18N
            properties[PROPERTY_size].setHidden ( true );
            properties[PROPERTY_text] = new PropertyDescriptor ( "text", components.JThumbnailLabel.class, "getText", "setText" ); // NOI18N
            properties[PROPERTY_text].setPreferred ( true );
            properties[PROPERTY_text].setShortDescription ( "Defines the single line of text this component will display." );
            properties[PROPERTY_text].setBound ( true );
            properties[PROPERTY_thumbnailBorder] = new PropertyDescriptor ( "thumbnailBorder", components.JThumbnailLabel.class, "getThumbnailBorder", "setThumbnailBorder" ); // NOI18N
            properties[PROPERTY_thumbnailBorder].setShortDescription ( "The thumbnail's border." );
            properties[PROPERTY_thumbnailBorder].setBound ( true );
            properties[PROPERTY_thumbnailBounds] = new PropertyDescriptor ( "thumbnailBounds", components.JThumbnailLabel.class, "getThumbnailBounds", null ); // NOI18N
            properties[PROPERTY_thumbnailBounds].setHidden ( true );
            properties[PROPERTY_thumbnailHeight] = new PropertyDescriptor ( "thumbnailHeight", components.JThumbnailLabel.class, "getThumbnailHeight", null ); // NOI18N
            properties[PROPERTY_thumbnailHeight].setHidden ( true );
            properties[PROPERTY_thumbnailInsets] = new PropertyDescriptor ( "thumbnailInsets", components.JThumbnailLabel.class, "getThumbnailInsets", null ); // NOI18N
            properties[PROPERTY_thumbnailInsets].setExpert ( true );
            properties[PROPERTY_thumbnailLocation] = new PropertyDescriptor ( "thumbnailLocation", components.JThumbnailLabel.class, "getThumbnailLocation", null ); // NOI18N
            properties[PROPERTY_thumbnailLocation].setHidden ( true );
            properties[PROPERTY_thumbnailOverlay] = new PropertyDescriptor ( "thumbnailOverlay", components.JThumbnailLabel.class, "getThumbnailOverlay", "setThumbnailOverlay" ); // NOI18N
            properties[PROPERTY_thumbnailOverlay].setShortDescription ( "The overlay over the thumbnail." );
            properties[PROPERTY_thumbnailOverlay].setBound ( true );
            properties[PROPERTY_thumbnailRegionBounds] = new PropertyDescriptor ( "thumbnailRegionBounds", components.JThumbnailLabel.class, "getThumbnailRegionBounds", null ); // NOI18N
            properties[PROPERTY_thumbnailRegionBounds].setHidden ( true );
            properties[PROPERTY_thumbnailRegionHeight] = new PropertyDescriptor ( "thumbnailRegionHeight", components.JThumbnailLabel.class, "getThumbnailRegionHeight", null ); // NOI18N
            properties[PROPERTY_thumbnailRegionHeight].setHidden ( true );
            properties[PROPERTY_thumbnailRegionLocation] = new PropertyDescriptor ( "thumbnailRegionLocation", components.JThumbnailLabel.class, "getThumbnailRegionLocation", null ); // NOI18N
            properties[PROPERTY_thumbnailRegionLocation].setHidden ( true );
            properties[PROPERTY_thumbnailRegionSize] = new PropertyDescriptor ( "thumbnailRegionSize", components.JThumbnailLabel.class, "getThumbnailRegionSize", null ); // NOI18N
            properties[PROPERTY_thumbnailRegionSize].setHidden ( true );
            properties[PROPERTY_thumbnailRegionWidth] = new PropertyDescriptor ( "thumbnailRegionWidth", components.JThumbnailLabel.class, "getThumbnailRegionWidth", null ); // NOI18N
            properties[PROPERTY_thumbnailRegionWidth].setHidden ( true );
            properties[PROPERTY_thumbnailRegionX] = new PropertyDescriptor ( "thumbnailRegionX", components.JThumbnailLabel.class, "getThumbnailRegionX", null ); // NOI18N
            properties[PROPERTY_thumbnailRegionX].setHidden ( true );
            properties[PROPERTY_thumbnailRegionY] = new PropertyDescriptor ( "thumbnailRegionY", components.JThumbnailLabel.class, "getThumbnailRegionY", null ); // NOI18N
            properties[PROPERTY_thumbnailRegionY].setHidden ( true );
            properties[PROPERTY_thumbnailSize] = new PropertyDescriptor ( "thumbnailSize", components.JThumbnailLabel.class, "getThumbnailSize", null ); // NOI18N
            properties[PROPERTY_thumbnailSize].setHidden ( true );
            properties[PROPERTY_thumbnailTransform] = new PropertyDescriptor ( "thumbnailTransform", components.JThumbnailLabel.class, "getThumbnailTransform", null ); // NOI18N
            properties[PROPERTY_thumbnailTransform].setHidden ( true );
            properties[PROPERTY_thumbnailWidth] = new PropertyDescriptor ( "thumbnailWidth", components.JThumbnailLabel.class, "getThumbnailWidth", null ); // NOI18N
            properties[PROPERTY_thumbnailWidth].setHidden ( true );
            properties[PROPERTY_thumbnailX] = new PropertyDescriptor ( "thumbnailX", components.JThumbnailLabel.class, "getThumbnailX", null ); // NOI18N
            properties[PROPERTY_thumbnailX].setHidden ( true );
            properties[PROPERTY_thumbnailY] = new PropertyDescriptor ( "thumbnailY", components.JThumbnailLabel.class, "getThumbnailY", null ); // NOI18N
            properties[PROPERTY_thumbnailY].setHidden ( true );
            properties[PROPERTY_toolkit] = new PropertyDescriptor ( "toolkit", components.JThumbnailLabel.class, "getToolkit", null ); // NOI18N
            properties[PROPERTY_toolkit].setHidden ( true );
            properties[PROPERTY_toolTipText] = new PropertyDescriptor ( "toolTipText", components.JThumbnailLabel.class, "getToolTipText", "setToolTipText" ); // NOI18N
            properties[PROPERTY_toolTipText].setPreferred ( true );
            properties[PROPERTY_toolTipText].setShortDescription ( "The text to display in a tool tip." );
            properties[PROPERTY_topLevelAncestor] = new PropertyDescriptor ( "topLevelAncestor", components.JThumbnailLabel.class, "getTopLevelAncestor", null ); // NOI18N
            properties[PROPERTY_topLevelAncestor].setHidden ( true );
            properties[PROPERTY_transferHandler] = new PropertyDescriptor ( "transferHandler", components.JThumbnailLabel.class, "getTransferHandler", "setTransferHandler" ); // NOI18N
            properties[PROPERTY_transferHandler].setHidden ( true );
            properties[PROPERTY_transferHandler].setShortDescription ( "Mechanism for transfer of data to and from the component" );
            properties[PROPERTY_treeLock] = new PropertyDescriptor ( "treeLock", components.JThumbnailLabel.class, "getTreeLock", null ); // NOI18N
            properties[PROPERTY_treeLock].setHidden ( true );
            properties[PROPERTY_UI] = new PropertyDescriptor ( "UI", components.JThumbnailLabel.class, "getUI", "setUI" ); // NOI18N
            properties[PROPERTY_UI].setHidden ( true );
            properties[PROPERTY_UI].setShortDescription ( "The UI object that implements the Component's LookAndFeel." );
            properties[PROPERTY_UIClassID] = new PropertyDescriptor ( "UIClassID", components.JThumbnailLabel.class, "getUIClassID", null ); // NOI18N
            properties[PROPERTY_valid] = new PropertyDescriptor ( "valid", components.JThumbnailLabel.class, "isValid", null ); // NOI18N
            properties[PROPERTY_valid].setHidden ( true );
            properties[PROPERTY_validateRoot] = new PropertyDescriptor ( "validateRoot", components.JThumbnailLabel.class, "isValidateRoot", null ); // NOI18N
            properties[PROPERTY_validateRoot].setHidden ( true );
            properties[PROPERTY_verifyInputWhenFocusTarget] = new PropertyDescriptor ( "verifyInputWhenFocusTarget", components.JThumbnailLabel.class, "getVerifyInputWhenFocusTarget", "setVerifyInputWhenFocusTarget" ); // NOI18N
            properties[PROPERTY_verifyInputWhenFocusTarget].setShortDescription ( "Whether the Component verifies input before accepting focus." );
            properties[PROPERTY_verticalAlignment] = new PropertyDescriptor ( "verticalAlignment", components.JThumbnailLabel.class, "getVerticalAlignment", "setVerticalAlignment" ); // NOI18N
            properties[PROPERTY_verticalAlignment].setPreferred ( true );
            properties[PROPERTY_verticalAlignment].setShortDescription ( "The alignment of the label's contents along the Y axis." );
            properties[PROPERTY_verticalAlignment].setPropertyEditorClass ( beans.VerticalAlignmentEditor.class );
            properties[PROPERTY_verticalTextPosition] = new PropertyDescriptor ( "verticalTextPosition", components.JThumbnailLabel.class, "getVerticalTextPosition", "setVerticalTextPosition" ); // NOI18N
            properties[PROPERTY_verticalTextPosition].setPreferred ( true );
            properties[PROPERTY_verticalTextPosition].setShortDescription ( "The vertical position of the text relative to it's image." );
            properties[PROPERTY_verticalTextPosition].setPropertyEditorClass ( beans.VerticalAlignmentEditor.class );
            properties[PROPERTY_vetoableChangeListeners] = new PropertyDescriptor ( "vetoableChangeListeners", components.JThumbnailLabel.class, "getVetoableChangeListeners", null ); // NOI18N
            properties[PROPERTY_vetoableChangeListeners].setHidden ( true );
            properties[PROPERTY_visible] = new PropertyDescriptor ( "visible", components.JThumbnailLabel.class, "isVisible", "setVisible" ); // NOI18N
            properties[PROPERTY_visible].setHidden ( true );
            properties[PROPERTY_visibleRect] = new PropertyDescriptor ( "visibleRect", components.JThumbnailLabel.class, "getVisibleRect", null ); // NOI18N
            properties[PROPERTY_visibleRect].setHidden ( true );
            properties[PROPERTY_width] = new PropertyDescriptor ( "width", components.JThumbnailLabel.class, "getWidth", null ); // NOI18N
            properties[PROPERTY_width].setHidden ( true );
            properties[PROPERTY_x] = new PropertyDescriptor ( "x", components.JThumbnailLabel.class, "getX", null ); // NOI18N
            properties[PROPERTY_x].setHidden ( true );
            properties[PROPERTY_y] = new PropertyDescriptor ( "y", components.JThumbnailLabel.class, "getY", null ); // NOI18N
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
            eventSets[EVENT_ancestorListener] = new EventSetDescriptor ( components.JThumbnailLabel.class, "ancestorListener", javax.swing.event.AncestorListener.class, new String[] {"ancestorAdded", "ancestorRemoved", "ancestorMoved"}, "addAncestorListener", "removeAncestorListener" ); // NOI18N
            eventSets[EVENT_componentListener] = new EventSetDescriptor ( components.JThumbnailLabel.class, "componentListener", java.awt.event.ComponentListener.class, new String[] {"componentResized", "componentMoved", "componentShown", "componentHidden"}, "addComponentListener", "removeComponentListener" ); // NOI18N
            eventSets[EVENT_containerListener] = new EventSetDescriptor ( components.JThumbnailLabel.class, "containerListener", java.awt.event.ContainerListener.class, new String[] {"componentAdded", "componentRemoved"}, "addContainerListener", "removeContainerListener" ); // NOI18N
            eventSets[EVENT_focusListener] = new EventSetDescriptor ( components.JThumbnailLabel.class, "focusListener", java.awt.event.FocusListener.class, new String[] {"focusGained", "focusLost"}, "addFocusListener", "removeFocusListener" ); // NOI18N
            eventSets[EVENT_hierarchyBoundsListener] = new EventSetDescriptor ( components.JThumbnailLabel.class, "hierarchyBoundsListener", java.awt.event.HierarchyBoundsListener.class, new String[] {"ancestorMoved", "ancestorResized"}, "addHierarchyBoundsListener", "removeHierarchyBoundsListener" ); // NOI18N
            eventSets[EVENT_hierarchyListener] = new EventSetDescriptor ( components.JThumbnailLabel.class, "hierarchyListener", java.awt.event.HierarchyListener.class, new String[] {"hierarchyChanged"}, "addHierarchyListener", "removeHierarchyListener" ); // NOI18N
            eventSets[EVENT_inputMethodListener] = new EventSetDescriptor ( components.JThumbnailLabel.class, "inputMethodListener", java.awt.event.InputMethodListener.class, new String[] {"inputMethodTextChanged", "caretPositionChanged"}, "addInputMethodListener", "removeInputMethodListener" ); // NOI18N
            eventSets[EVENT_keyListener] = new EventSetDescriptor ( components.JThumbnailLabel.class, "keyListener", java.awt.event.KeyListener.class, new String[] {"keyTyped", "keyPressed", "keyReleased"}, "addKeyListener", "removeKeyListener" ); // NOI18N
            eventSets[EVENT_mouseListener] = new EventSetDescriptor ( components.JThumbnailLabel.class, "mouseListener", java.awt.event.MouseListener.class, new String[] {"mouseClicked", "mousePressed", "mouseReleased", "mouseEntered", "mouseExited"}, "addMouseListener", "removeMouseListener" ); // NOI18N
            eventSets[EVENT_mouseMotionListener] = new EventSetDescriptor ( components.JThumbnailLabel.class, "mouseMotionListener", java.awt.event.MouseMotionListener.class, new String[] {"mouseDragged", "mouseMoved"}, "addMouseMotionListener", "removeMouseMotionListener" ); // NOI18N
            eventSets[EVENT_mouseWheelListener] = new EventSetDescriptor ( components.JThumbnailLabel.class, "mouseWheelListener", java.awt.event.MouseWheelListener.class, new String[] {"mouseWheelMoved"}, "addMouseWheelListener", "removeMouseWheelListener" ); // NOI18N
            eventSets[EVENT_propertyChangeListener] = new EventSetDescriptor ( components.JThumbnailLabel.class, "propertyChangeListener", java.beans.PropertyChangeListener.class, new String[] {"propertyChange"}, "addPropertyChangeListener", "removePropertyChangeListener" ); // NOI18N
            eventSets[EVENT_vetoableChangeListener] = new EventSetDescriptor ( components.JThumbnailLabel.class, "vetoableChangeListener", java.beans.VetoableChangeListener.class, new String[] {"vetoableChange"}, "addVetoableChangeListener", "removeVetoableChangeListener" ); // NOI18N
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
     * This returns the image to use to represent JThumbnailLabels.
     * @param iconKind The kind of icon to get.
     * @param resourceName The name for the resource to get the image from, or 
     * null.
     * @return The image representing a JThumbnailLabel, or null if no suitable 
     * icon is available.
     * @see #getIcon(int) 
     * @see beans.BeanInfoIconFactory
     * @see beans.BeanInfoIconFactory#createIconImage(int, java.lang.String, java.beans.SimpleBeanInfo) 
     */
    private java.awt.Image createIcon(int iconKind, String resourceName){
        if (iconFactory == null)    // If the icon factory is not initialized yet
            iconFactory = new JThumbnailLabelIconFactory();
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
     * JThumbnailLabel.
     */
    private static class JThumbnailLabelIconFactory extends BeanInfoIconFactory{
        /**
         * This stores the RGB values for the colors to use for an image 
         * representing JThumbnailLabel. The first array contains the colors to 
         * use for a color icon and the second array contains the colors to use 
         * for a monochrome icon.
         */
        public static final int[][] ICON_COLOR_VALUES = {
            {0xEEF4F9, 0x8BE5BB, 0x6AD082, 0xBDD6EA},
            {0xF4F4F4, 0xB9B9B9, 0x949494, 0xD4D4D4}
        };
        @Override
        protected void paintImage(java.awt.Graphics2D g,int scale,int colorMode,
                int w, int h) {
                // Draw the shadow
            g.setColor(BeanInfoIconFactory.SHADOW_COLOR);
            g.fillRect(0, 0, w, h);
                // Draw the outline in a gradiant
            h--;
            g.setPaint(BeanInfoIconFactory.createOutlineGradient(0, h, colorMode));
            g.fillRect(0, 0, w, h);
                // Clip to render internal image
            w-=2;
            h-=2;
            g.clipRect(1, 1, w, h);
                // Draw the image background
            g.setColor(new java.awt.Color(ICON_COLOR_VALUES[colorMode][0]));
            g.fillRect(1, 1, w, h);
                // Draw the light green scenery
            g.setColor(new java.awt.Color(ICON_COLOR_VALUES[colorMode][1]));
            g.fillRect(1, (5*scale)-(scale >> 1), 5*scale, 9*scale);
            g.fillOval(-8*scale, 4*scale, 20*scale, 11*scale);
            g.fillRect(scale, (7*scale)+(scale >> 1), 12*scale, 7*scale);
            g.fillRect(1, 8*scale, (14*scale)+(scale >> 1), 6*scale);
            if (scale == 2) // If this is a 32x32 icon
                g.fillRect(1, 17, w, 12);
                // Draw the dark green scenery
            g.setColor(new java.awt.Color(ICON_COLOR_VALUES[colorMode][2]));
            if (scale == 2) // If this is a 32x32 icon
                g.fillOval(-14, 13, 28, 17);
            else
                g.fillOval(-8, 7, 15, 11);
                // Draw the water
            g.setColor(new java.awt.Color(ICON_COLOR_VALUES[colorMode][3]));
            g.fillRect(1, (10*scale)+(scale >> 1), w, (4*scale)+(scale >> 1));
        }
    }
    /**
     * This is the PropertyEditor used to set the image scale mode for a 
     * JThumbnailLabel.
     */
    public static class ImageScaleModeEditor extends beans.EnumeratedPropertyEditor{
        @Override
        public String[] getTags(){
            return new String[]{
                "NO_SCALING_APPLIED",
                "ONLY_SCALE_TO_FIT",
                "ALWAYS_SCALE_IGNORE_ASPECT_RATIO",
                "ALWAYS_SCALE_MAINTAIN_ASPECT_RATIO"
            };
        }
        @Override
        public Object[] getValues() {
            return new Object[]{
                JThumbnailLabel.NO_SCALING_APPLIED,
                JThumbnailLabel.ONLY_SCALE_TO_FIT,
                JThumbnailLabel.ALWAYS_SCALE_IGNORE_ASPECT_RATIO,
                JThumbnailLabel.ALWAYS_SCALE_MAINTAIN_ASPECT_RATIO
            };
        }
        @Override
        public String getNameForValue(Object value){
            return JThumbnailLabel.class.getName()+"."+getTagForValue(value);
        }
    }
}
