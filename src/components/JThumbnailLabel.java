/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package components;

import icons.*;
import java.awt.*;
import java.awt.geom.*;
import java.util.Map;
import java.util.Objects;
import javax.swing.*;
import javax.swing.border.*;

/**
 * This is a label that displays a thumbnail of an image or icon. This is 
 * capable of scaling the image/icon so that it fits within the label, or so as 
 * to make the image/icon fill the label. The thumbnail being displayed can 
 * have a border put around it separate from the border for the label which 
 * surrounds the thumbnail instead of the label. This also provides the ability 
 * to put an overlay over the thumbnail using a {@link javax.swing.Painter 
 * Painter} object. The generic type for the Painter object should be 
 * JThumbnailLabel or any of its superclasses. <p>
 * 
 * To distinguish between the thumbnail of the image or icon and the painted 
 * region containing the thumbnail, thumbnail border, and thumbnail overlay, 
 * they will be referred to as the thumbnail and the thumbnail region, 
 * respectively. The thumbnail overlay is the last thing rendered within the 
 * thumbnail region, and can paint over the thumbnail border if set. However, 
 * the thumbnail overlay is limited to painting within the bounds of the 
 * thumbnail region. 
 * 
 * @author Milo Steier
 */
public class JThumbnailLabel extends JLabel{
    /**
     * This identifies that the scaling mode has changed.
     */
    public static final String IMAGE_SCALE_MODE_PROPERTY_CHANGED = 
            "ImageScaleModePropertyChanged";
    /**
     * This identifies that the thumbnail overlay has changed.
     */
    public static final String THUMBNAIL_OVERLAY_PROPERTY_CHANGED = 
            "ThumbnailOverlayPropertyChanged";
    /**
     * This identifies that the border around the thumbnail has changed.
     */
    public static final String THUMBNAIL_BORDER_PROPERTY_CHANGED = 
            "ThumbnailBorderPropertyChanged";
    /**
     * This is the scaling mode that indicates that images will not be scaled, 
     * and will instead be drawn to its actual size, or at least as much as will 
     * fit in the label.
     * @see #MAINTAIN_ASPECT_RATIO
     * @see #ALWAYS_SCALE_IMAGE
     * @see #ONLY_SCALE_TO_FIT
     * @see #ALWAYS_SCALE_IGNORE_ASPECT_RATIO
     * @see #ALWAYS_SCALE_MAINTAIN_ASPECT_RATIO
     */
    public static final int NO_SCALING_APPLIED = 0x00;
    /**
     * This is a flag for the scaling mode for indicating that the aspect ratio 
     * of the image being scaled should be maintained as much as possible.
     * @see #ALWAYS_SCALE_IMAGE
     * @see #NO_SCALING_APPLIED
     * @see #ONLY_SCALE_TO_FIT
     * @see #ALWAYS_SCALE_IGNORE_ASPECT_RATIO
     * @see #ALWAYS_SCALE_MAINTAIN_ASPECT_RATIO
     */
    public static final int MAINTAIN_ASPECT_RATIO = 0x01;
    /**
     * This is a flag for the scaling mode for indicating that the image should 
     * always be scaled, even if it already fits.
     * @see #MAINTAIN_ASPECT_RATIO
     * @see #NO_SCALING_APPLIED
     * @see #ONLY_SCALE_TO_FIT
     * @see #ALWAYS_SCALE_IGNORE_ASPECT_RATIO
     * @see #ALWAYS_SCALE_MAINTAIN_ASPECT_RATIO
     */
    public static final int ALWAYS_SCALE_IMAGE = 0x02;
    /**
     * This is the scaling mode that indicates that images should only be 
     * scaled to fit the label. The aspect ratio of the image is maintained, 
     * and if the image would fit within the label without scaling, then the 
     * image will not be scaled.
     * @see #MAINTAIN_ASPECT_RATIO
     * @see #ALWAYS_SCALE_IMAGE
     * @see #NO_SCALING_APPLIED
     * @see #ALWAYS_SCALE_IGNORE_ASPECT_RATIO
     * @see #ALWAYS_SCALE_MAINTAIN_ASPECT_RATIO
     */
    public static final int ONLY_SCALE_TO_FIT = MAINTAIN_ASPECT_RATIO;
    /**
     * This is the scaling mode that indicates that images should always be 
     * scaled and the aspect ratio of the image should be maintained.
     * @see #MAINTAIN_ASPECT_RATIO
     * @see #ALWAYS_SCALE_IMAGE
     * @see #NO_SCALING_APPLIED
     * @see #ONLY_SCALE_TO_FIT
     * @see #ALWAYS_SCALE_IGNORE_ASPECT_RATIO
     */
    public static final int ALWAYS_SCALE_MAINTAIN_ASPECT_RATIO = 
            ALWAYS_SCALE_IMAGE | MAINTAIN_ASPECT_RATIO;
    /**
     * This is the scaling mode that indicates that images should always be 
     * scaled and the aspect ratio of the image should be ignored. The image 
     * will be scaled to fit the aspect ratio of the label.
     * @see #MAINTAIN_ASPECT_RATIO
     * @see #ALWAYS_SCALE_IMAGE
     * @see #NO_SCALING_APPLIED
     * @see #ONLY_SCALE_TO_FIT
     * @see #ALWAYS_SCALE_MAINTAIN_ASPECT_RATIO
     */
    public static final int ALWAYS_SCALE_IGNORE_ASPECT_RATIO = ALWAYS_SCALE_IMAGE;
    /**
     * This is the icon control flag indicating that the label is currently 
     * being painted and needs the thumbnail icon.
     * @see #paintComponent(java.awt.Graphics) 
     */
    protected static final int BEING_PAINTED_CONTROL_FLAG = 0x01;
    /**
     * This is the icon control flag indicating that the label is checking to 
     * see if it needs to repaint due to an update to the image.
     * @see #imageUpdate(java.awt.Image, int, int, int, int, int) 
     */
    protected static final int UPDATING_IMAGE_CONTROL_FLAG = 0x02;
    /**
     * This is the icon control flag indicating that the icon is currently in 
     * the process of being painted.
     * @see #isPaintingThumbnail() 
     */
    protected static final int IS_PAINTING_ICON_CONTROL_FLAG = 0x04;
    /**
     * This stores the scaling mode for the thumbnail. 
     */
    private int scaleMode = -1;
//    /**
//     * This stores whether this uses Thumbnailator to scale the thumbnail in 
//     * order to improve the thumbnail quality.
//     */
//    private boolean useThumbnailator = true;
    /**
     * This stores a map of rendering hints used to render the thumbnail.
     */
    private RenderingHints hintMap;
    /**
     * This is the Dimension object used to calculate and store the maximum 
     * possible size for the thumbnail image.
     */
    private Dimension maxImageSize = null;
    /**
     * This is the Rectangle object used to store the inner area of this label 
     * when calculating the origin for the thumbnail icon.
     */
    private Rectangle innerArea = null;
    /**
     * This is the Rectangle object used to calculate and store the origin for 
     * the thumbnail icon.
     */
    private Rectangle iconRect = null;
    /**
     * This is the Rectangle object used to get the origin for the text when 
     * calculating the origin for the thumbnail icon.
     */
    private Rectangle textRect = null;
    /**
     * This is the icon used as the thumbnail.
     */
    private Icon thumbnail;
    /**
     * This stores whether the disabled icon has been set.
     */
    private boolean isDisabledIconSet = false;
    /**
     * This stores the disabled version of the thumbnail icon.
     */
    private DisabledIcon disabledIcon;
    /**
     * This stores flags used to control which icon is being returned, along 
     * with controlling other things related to the thumbnail icon.
     */
    private volatile int iconControlFlags = 0x0;
    /**
     * This is the border for the thumbnail.
     */
    private Border imgBorder = null;
    /**
     * This is the overlay for the thumbnail.
     */
    private Painter<? super JThumbnailLabel> overlay = null;
    /**
     * This stores the bounds for the thumbnail icon when it is being painted.
     */
    private Rectangle iconBounds = null;
    /**
     * This stores the bounds for the thumbnail when it is being painted.
     */
    private Rectangle thumbnailBounds = null;
    /**
     * This initializes some of the properties of this JThumbnailLabel to their 
     * default values.
     * @param scaleMode The mode for how the image will be scaled.
     */
    private void initialize(int scaleMode){
        setVerticalTextPosition(SwingConstants.BOTTOM);
        setHorizontalTextPosition(SwingConstants.CENTER);
        thumbnail = null;
        disabledIcon = null;
        hintMap = new RenderingHints(RenderingHints.KEY_INTERPOLATION, 
                RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        hintMap.put(RenderingHints.KEY_ALPHA_INTERPOLATION, 
                RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        hintMap.put(RenderingHints.KEY_ANTIALIASING, 
                RenderingHints.VALUE_ANTIALIAS_ON);
        hintMap.put(RenderingHints.KEY_RESOLUTION_VARIANT, 
                RenderingHints.VALUE_RESOLUTION_VARIANT_SIZE_FIT);
        hintMap.put(RenderingHints.KEY_RENDERING, 
                RenderingHints.VALUE_RENDER_QUALITY);
        hintMap.put(RenderingHints.KEY_DITHERING, 
                RenderingHints.VALUE_DITHER_ENABLE);
        hintMap.put(RenderingHints.KEY_COLOR_RENDERING, 
                RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        setImageScaleMode(scaleMode);
    }
    /**
     * This constructs a JThumbnailLabel with the given icon, scaling mode, and 
     * horizontal alignment. The label is centered vertically in its display 
     * area.
     * @param icon The icon to be displayed by this label.
     * @param scaleMode The mode for how images will be scaled. This should be 
     * one of the following: 
     *      {@link NO_SCALING_APPLIED}, 
     *      {@link ONLY_SCALE_TO_FIT}, 
     *      {@link ALWAYS_SCALE_IGNORE_ASPECT_RATIO}, or 
     *      {@link ALWAYS_SCALE_MAINTAIN_ASPECT_RATIO}.
     * @param horizontalAlignment The horizontal alignment for the contents of 
     * this label. This should be one of the following constants defined in 
     * {@code SwingConstants}: 
     *      {@code LEFT}, 
     *      {@code CENTER},
     *      {@code RIGHT},
     *      {@code LEADING}, or
     *      {@code TRAILING}.
     */
    public JThumbnailLabel(Icon icon, int scaleMode, int horizontalAlignment){
        super(icon, horizontalAlignment);
        initialize(scaleMode);
    }
    /**
     * This constructs a JThumbnailLabel with the given icon and scaling mode. 
     * The label is centered horizontally and vertically in its display area.
     * @param icon The icon to be displayed by this label.
     * @param scaleMode The mode for how images will be scaled. This should be 
     * one of the following: 
     *      {@link NO_SCALING_APPLIED}, 
     *      {@link ONLY_SCALE_TO_FIT}, 
     *      {@link ALWAYS_SCALE_IGNORE_ASPECT_RATIO}, or 
     *      {@link ALWAYS_SCALE_MAINTAIN_ASPECT_RATIO}.
     */
    public JThumbnailLabel(Icon icon, int scaleMode){
        this(icon,scaleMode,SwingConstants.CENTER);
    }
    /**
     * This constructs a JThumbnailLabel with the given icon. The label is 
     * centered horizontally and vertically in its display area, and the icon 
     * is only scaled if it would otherwise not fit within the label.
     * @param icon The icon to be displayed by this label.
     */
    public JThumbnailLabel(Icon icon){
        this(icon,ONLY_SCALE_TO_FIT);
    }
    /**
     * This constructs a JThumbnailLabel with the given image, scaling mode, and 
     * horizontal alignment. The label is centered vertically in its display 
     * area.
     * @param image The image to be displayed by this label.
     * @param scaleMode The mode for how images will be scaled. This should be 
     * one of the following: 
     *      {@link NO_SCALING_APPLIED}, 
     *      {@link ONLY_SCALE_TO_FIT}, 
     *      {@link ALWAYS_SCALE_IGNORE_ASPECT_RATIO}, or 
     *      {@link ALWAYS_SCALE_MAINTAIN_ASPECT_RATIO}.
     * @param horizontalAlignment The horizontal alignment for the contents of 
     * this label. This should be one of the following constants defined in 
     * {@code SwingConstants}: 
     *      {@code LEFT}, 
     *      {@code CENTER},
     *      {@code RIGHT},
     *      {@code LEADING}, or
     *      {@code TRAILING}.
     */
    public JThumbnailLabel(Image image, int scaleMode, int horizontalAlignment){
        this((image!=null)?new ImageIcon(image):null,scaleMode,horizontalAlignment);
    }
    /**
     * This constructs a JThumbnailLabel with the given image and scaling mode. 
     * The label is centered horizontally and vertically in its display area.
     * @param image The image to be displayed by this label.
     * @param scaleMode The mode for how images will be scaled. This should be 
     * one of the following: 
     *      {@link NO_SCALING_APPLIED}, 
     *      {@link ONLY_SCALE_TO_FIT}, 
     *      {@link ALWAYS_SCALE_IGNORE_ASPECT_RATIO}, or 
     *      {@link ALWAYS_SCALE_MAINTAIN_ASPECT_RATIO}.
     */
    public JThumbnailLabel(Image image, int scaleMode){
        this(image,scaleMode,SwingConstants.CENTER);
    }
    /**
     * This constructs a JThumbnailLabel with the given image. The label is 
     * centered horizontally and vertically in its display area, and the image 
     * is only scaled if it would otherwise not fit within the label.
     * @param image The image to be displayed by this label.
     */
    public JThumbnailLabel(Image image){
        this(image,ONLY_SCALE_TO_FIT);
    }
    /**
     * This constructs a JThumbnailLabel with no icon or image. The label is 
     * centered horizontally and vertically in its display area, and the icon, 
     * once set, is only scaled if it would otherwise not fit within the label.
     */
    public JThumbnailLabel(){
        this((Icon)null);
    }
    /**
     * This returns the minimum size for this label. If the minimum size has 
     * been set to a non-null value, then that is what is returned. Otherwise, 
     * this will return a minimum size of 0 x 0.
     * @return {@inheritDoc }
     * @see #setMinimumSize
     */
    @Override
    public Dimension getMinimumSize(){
            // Return the minimum size if set, otherwise return 0x0
        return (isMinimumSizeSet()) ? super.getMinimumSize() : new Dimension();
    }
    /**
     * This sets the minimum size of this label. Any subsequent call to {@code 
     * getMinimumSize} will return this value instead of a minimum size of 0 x 
     * 0. Setting the minimum size to null will reset it.
     * @param minimumSize {@inheritDoc }
     * @see #getMinimumSize
     */
    @Override
    public void setMinimumSize(Dimension minimumSize){
        super.setMinimumSize(minimumSize);
    }
    /**
     * This returns the maximum size for this label. If the maximum size has 
     * been set to a non-null value, then that is what is returned. Otherwise, 
     * this will return a maximum size of {@link Integer#MAX_VALUE} x {@link 
     * Integer#MAX_VALUE}.
     * @return {@inheritDoc }
     * @see #setMaximumSize
     */
    @Override
    public Dimension getMaximumSize(){
            // Return the maximum size if set, otherwise return the largest 
            // dimension possible
        return (isMaximumSizeSet()) ? super.getMaximumSize() : 
                new Dimension(Integer.MAX_VALUE,Integer.MAX_VALUE);
    }
    /**
     * This sets the maximum size of this label. Any subsequent call to {@code 
     * getMaximumSize} will return this value instead of a maximum size of 
     * {@link Integer#MAX_VALUE} x {@link Integer#MAX_VALUE}. Setting the 
     * maximum size to null will reset it.
     * @param maximumSize {@inheritDoc }
     * @see #getMaximumSize
     */
    @Override
    public void setMaximumSize(Dimension maximumSize){
        super.setMaximumSize(maximumSize);
    }
    @Override
    public Dimension getPreferredSize(){
            // This gets the preferred size for this label
        Dimension dim = super.getPreferredSize();
            // If the preferred size is not set, the thumbnail icon is not null, 
            // and either this label is enabled or there is no disabled icon set
        if (!isPreferredSizeSet() && getThumbnailIcon() != null && 
                (isEnabled() || !isDisabledIconSet)){
            Insets in = getThumbnailInsets();   // This gets the insets for the thumbnail
            if (in != null){    // If the insets for the thumbnail is not null
                dim.width += in.left + in.right;
                dim.height += in.top + in.bottom;
            }
        }
        return dim;
    }
    /**
     * {@inheritDoc }
     * @param alignment  The horizontal alignment for the contents of 
     * this label. This should be one of the following constants defined in 
     * {@code SwingConstants}: 
     *      {@code LEFT}, 
     *      {@code CENTER} (the default),
     *      {@code RIGHT},
     *      {@code LEADING}, or
     *      {@code TRAILING}.
     * @see SwingConstants
     * @see #getHorizontalAlignment
     */
    @Override
    public void setHorizontalAlignment(int alignment){
        super.setHorizontalAlignment(alignment);
    }
    /**
     * This sets the vertical position of the label's text, relative to its 
     * icon.
     * @param textPosition The vertical position for the text. This should be 
     * one of the following constants defined in {@code SwingConstants}: 
     *      {@code TOP}, 
     *      {@code CENTER}, or
     *      {@code BOTTOM} (the default).
     * @see SwingConstants
     * @see #getVerticalTextPosition
     */
    @Override
    public void setVerticalTextPosition(int textPosition) {
        super.setVerticalTextPosition(textPosition);
    }
    /**
     * {@inheritDoc }
     * @param textPosition The horizontal position for the text. This should be 
     * one of the following constants defined in {@code SwingConstants}: 
     *      {@code LEFT}, 
     *      {@code CENTER} (the default),
     *      {@code RIGHT},
     *      {@code LEADING}, or
     *      {@code TRAILING}.
     * @see SwingConstants
     */
    @Override
    public void setHorizontalTextPosition(int textPosition) {
        super.setHorizontalTextPosition(textPosition);
    }
    /**
     * {@inheritDoc }
     * @param isOpaque {@inheritDoc }
     * @see #isOpaque
     */
    @Override
    public void setOpaque(boolean isOpaque){
        boolean old = isOpaque();   // Get if this was opaque before
        super.setOpaque(isOpaque);
        if (old != isOpaque)        // If the opacity property changed
            repaint();
    }
    /**
     * {@inheritDoc }
     * @param img {@inheritDoc }
     * @param infoFlags {@inheritDoc }
     * @param x {@inheritDoc }
     * @param y {@inheritDoc }
     * @param w {@inheritDoc }
     * @param h {@inheritDoc }
     * @return {@inheritDoc }
     * @see java.awt.image.ImageObserver
     * @see java.awt.Component#imageUpdate(java.awt.Image, int, int, int, int, int) 
     */
    @Override
    public boolean imageUpdate(Image img, int infoFlags, int x, int y, int w, int h){
        // HACK: Since the ThumbnailIcon and DisabledThumbnailIcon aren't 
        // ImageIcons, and not the ones set internally at that, this would 
        // return false and do nothing if it were to check the image being 
        // updated. So, instead give it the original icons to check
        setIconControlFlag(UPDATING_IMAGE_CONTROL_FLAG,true);
            // Get the result for the imageUpdate function so that it can be returned
        boolean update = super.imageUpdate(img, infoFlags, x, y, w, h);
        setIconControlFlag(UPDATING_IMAGE_CONTROL_FLAG,false);
        return update;
    }
//    @Override
//    public void repaint(long tm, int x, int y, int width, int height){
//        setIconControlFlag(UPDATING_IMAGE_CONTROL_FLAG,false);
//        super.repaint(tm, x, y, width, height);
//    }
    /**
     * {@inheritDoc } <p>
     * 
     * This has been overridden to set some of the {@link #getIconControlFlags() 
     * icon control flags} to have the UI delegate render the {@link 
     * #getThumbnailIcon() thumbnail icon} instead of the {@link 
     * #getDisplayedIcon() actual icon}, and to have it render the {@link 
     * #getDisabledThumbnailIcon() disabled thumbnail icon} instead of the 
     * {@link #getDisabledDisplayedIcon() actual disabled icon} if no disabled 
     * icon was set.
     * 
     * @param g {@inheritDoc }
     * @see #paint 
     * @see javax.swing.plaf.ComponentUI
     * @see #getIcon 
     * @see #getThumbnailIcon 
     * @see #getDisplayedIcon 
     * @see #getDisabledIcon 
     * @see #getDisabledThumbnailIcon 
     * @see #getDisabledDisplayedIcon 
     * @see #getIconControlFlags 
     * @see #isIconControlFlagSet 
     * @see #setIconControlFlag 
     * @see #toggleIconControlFlag 
     * @see #isPaintingThumbnail 
     * @see #isThumbnailReturned 
     * @see #BEING_PAINTED_CONTROL_FLAG
     * @see #UPDATING_IMAGE_CONTROL_FLAG
     * @see #IS_PAINTING_ICON_CONTROL_FLAG
     */
    @Override
    protected void paintComponent(java.awt.Graphics g){
        // HACK: This is tricking the UI delegate into painting the thumbnail 
        // instead of the actual icon
        setIconControlFlag(BEING_PAINTED_CONTROL_FLAG,true);
        setIconControlFlag(UPDATING_IMAGE_CONTROL_FLAG,false);
        super.paintComponent(g);
            // The flag for whether the icon is currently being painted should 
            // already be cleared, but just in case something broke while 
            // painting the thumbnail icon
        setIconControlFlag(BEING_PAINTED_CONTROL_FLAG|
                IS_PAINTING_ICON_CONTROL_FLAG,false);
    }
    /**
     * {@inheritDoc }
     * @param icon {@inheritDoc }
     * @see #setVerticalTextPosition 
     * @see #setHorizontalTextPosition 
     * @see #getIcon 
     */
    @Override
    public void setIcon(Icon icon){
            // If the given icon is a ThumbnailIcon
        while (icon instanceof ThumbnailIcon)
            icon = ((ThumbnailIcon)icon).getLabel().getDisplayedIcon();
        super.setIcon(icon);
    }
    /**
     * {@inheritDoc }
     * @return {@inheritDoc }
     * @see #setIcon 
     */
    @Override
    public Icon getIcon(){
            // If we need the thumbnail icon, return it, otherwise return the 
            // actual icon
        return (isThumbnailReturned()) ? getThumbnailIcon():getDisplayedIcon();
    }
    /**
     * This returns the icon that is actually set and being displayed.
     * @return The icon for the label.
     * @see #getIcon 
     * @see #getThumbnailIcon 
     * @see #isIconSet 
     */
    protected Icon getDisplayedIcon(){
        return super.getIcon();
    }
    /**
     * This returns the thumbnail icon.
     * @return The thumbnail icon, or null if no icon is has been set.
     * @see #getIcon 
     * @see #getDisplayedIcon 
     * @see #isIconSet 
     * @see #isThumbnailReturned 
     */
    protected Icon getThumbnailIcon(){
        if (isIconSet()){           // If an icon has been set
            if (thumbnail == null)  // If the thumbnail icon has not been initialized yet
                thumbnail = new ThumbnailIcon();
            return thumbnail;
        }
        return null;
    }
    /**
     * This returns an integer storing the flags used to control aspects of the 
     * {@link #getThumbnailIcon() thumbnail icon}, such as when {@link 
     * #getIcon() getIcon} should return the thumbnail icon instead of the 
     * {@link #getDisplayedIcon() displayed icon}.
     * @return The control flags for the thumbnail icon.
     * @see #isPaintingThumbnail 
     * @see #isThumbnailReturned 
     * @see #paintComponent 
     * @see #getIcon 
     * @see #getThumbnailIcon 
     * @see #getDisplayedIcon 
     * @see #getDisabledIcon 
     * @see #getDisabledDisplayedIcon 
     * @see #getDisabledThumbnailIcon 
     * @see #isIconControlFlagSet 
     * @see #setIconControlFlag 
     * @see #toggleIconControlFlag 
     * @see #BEING_PAINTED_CONTROL_FLAG
     * @see #UPDATING_IMAGE_CONTROL_FLAG
     * @see #IS_PAINTING_ICON_CONTROL_FLAG
     */
    protected final synchronized int getIconControlFlags(){
        return iconControlFlags;
    }
    /**
     * This sets the given icon control flag to the given value.
     * @param flag The icon control flag to set or clear.
     * @param value Whether the flag is to be set or cleared.
     * @see #getIconControlFlags 
     * @see #toggleIconControlFlag 
     * @see #isIconControlFlagSet 
     * @see #BEING_PAINTED_CONTROL_FLAG
     * @see #UPDATING_IMAGE_CONTROL_FLAG
     * @see #IS_PAINTING_ICON_CONTROL_FLAG
     */
    protected final synchronized void setIconControlFlag(int flag, boolean value){
        if (value)                      // If the flag should be set
            iconControlFlags |= flag;
        else
            iconControlFlags &= ~flag;
    }
    /**
     * This toggles the given icon control flag. This is equivalent to calling 
     * {@link #setIconControlFlag(int, boolean) setIconControlFlag}{@code (icon, 
     * !}{@link #isIconControlFlagSet(int) isIconControlFlagSet}{@code (flag))}.
     * @param flag The icon control flag to be toggled.
     * @see #getIconControlFlags 
     * @see #setIconControlFlag 
     * @see #isIconControlFlagSet 
     * @see #BEING_PAINTED_CONTROL_FLAG
     * @see #UPDATING_IMAGE_CONTROL_FLAG
     * @see #IS_PAINTING_ICON_CONTROL_FLAG
     */
    protected final synchronized void toggleIconControlFlag(int flag){
        setIconControlFlag(flag,!isIconControlFlagSet(flag));
    }
    /**
     * This returns whether the given icon control flag is set.
     * @param flag The icon control flag to check.
     * @return Whether the given icon control flag is set.
     * @see #getIconControlFlags 
     * @see #setIconControlFlag 
     * @see #toggleIconControlFlag 
     * @see #BEING_PAINTED_CONTROL_FLAG
     * @see #UPDATING_IMAGE_CONTROL_FLAG
     * @see #IS_PAINTING_ICON_CONTROL_FLAG
     */
    protected final synchronized boolean isIconControlFlagSet(int flag){
        return (iconControlFlags & flag) == flag;
    }
    /**
     * This returns whether the {@link #getThumbnailIcon() thumbnail icon} is 
     * currently being painted. This is used so that things like the thumbnail 
     * overlay can get access to the {@link #getDisplayedIcon() displayed icon} 
     * while being painted. This is also used to improve the efficiency of the 
     * painting code by storing the size and location for the thumbnail and its 
     * icon when they are being painted, so that these don't have to be 
     * calculated on the fly each time they are requested while painting the 
     * thumbnail.
     * @return Whether this is currently in the process of painting the 
     * thumbnail icon.
     * @see #isThumbnailReturned 
     * @see #paintThumbnailRegion 
     * @see #paintComponent 
     * @see #getIcon 
     * @see #getThumbnailIcon 
     * @see #getDisplayedIcon 
     * @see #getIconControlFlags 
     * @see #isIconControlFlagSet 
     * @see #IS_PAINTING_ICON_CONTROL_FLAG
     */
    protected synchronized boolean isPaintingThumbnail(){
        return isIconControlFlagSet(IS_PAINTING_ICON_CONTROL_FLAG);
    }
    /**
     * This returns whether {@link #getIcon()} will return the {@link 
     * #getThumbnailIcon() thumbnail icon} or the {@link #getDisplayedIcon() 
     * displayed icon}. This is used so that when this label goes to paint the 
     * icon, it gets the thumbnail icon instead of the actual icon, allowing for 
     * the thumbnail icon to be painted instead. This is also used by {@link 
     * #getDisabledIcon()} to determine if it should return the {@link 
     * #getDisabledThumbnailIcon() disabled thumbnail icon} or the {@link 
     * #getDisabledDisplayedIcon() set displayed disabled icon} if there is one. 
     * @return Whether the thumbnail icon should be returned by {@code 
     * getIcon()}.
     * @see #paintComponent 
     * @see #getIcon 
     * @see #getDisplayedIcon 
     * @see #getThumbnailIcon 
     * @see #getDisabledIcon 
     * @see #getDisabledDisplayedIcon 
     * @see #getDisabledThumbnailIcon 
     * @see #isPaintingThumbnail 
     * @see #getIconControlFlags 
     * @see #isIconControlFlagSet 
     * @see #setIconControlFlag 
     * @see #toggleIconControlFlag 
     * @see #BEING_PAINTED_CONTROL_FLAG
     * @see #UPDATING_IMAGE_CONTROL_FLAG
     * @see #IS_PAINTING_ICON_CONTROL_FLAG
     */
    protected synchronized boolean isThumbnailReturned(){
        return iconControlFlags == BEING_PAINTED_CONTROL_FLAG;
    }
    /**
     * {@inheritDoc }
     * @param disabledIcon {@inheritDoc }
     * @see #getDisabledIcon 
     * @see #setEnabled 
     */
    @Override
    public void setDisabledIcon(Icon disabledIcon){
            // If given a DisabledThumbnailIcon for the disabled icon.
        if (disabledIcon instanceof DisabledThumbnailIcon)
            disabledIcon = null;
        isDisabledIconSet = disabledIcon != null;
        super.setDisabledIcon(disabledIcon);
    }
    /**
     * This returns the icon used by the label when it's disabled. If no 
     * disabled icon has been set, then the disabled icon will be derived from 
     * the thumbnail and this will return null.
     * @return {@inheritDoc }
     * @see #setDisabledIcon 
     */
    @Override
    public Icon getDisabledIcon(){
            // This returns the displayed disabled icon if one is set
        Icon icon = getDisabledDisplayedIcon();
            // If the thumbnail is being returned and there is no disabled icon 
        return (isThumbnailReturned() && icon == null) ? // set
                getDisabledThumbnailIcon() : icon;
    }
    /**
     * This returns the disabled icon if one is set. If no disabled icon is set, 
     * then this returns null.
     * @return The disabled icon if one is set.
     * @see #getDisabledIcon() 
     * @see #getDisabledThumbnailIcon() 
     */
    protected Icon getDisabledDisplayedIcon(){
            // If a disabled icon is set, return it. If not, return null.
        return (isDisabledIconSet) ? super.getDisabledIcon() : null;
    }
    /**
     * This returns the disabled version of the {@link #getThumbnailIcon() 
     * thumbnail icon}. This is used when the {@link #getDisabledDisplayedIcon() 
     * disabled icon} is not set.
     * @return The disabled version of the thumbnail icon, or null if no icon 
     * is has been set.
     * @see #getThumbnailIcon()
     * @see #isIconSet() 
     * @see #getDisabledIcon() 
     * @see #getDisabledDisplayedIcon() 
     * @see #isThumbnailReturned() 
     */
    protected Icon getDisabledThumbnailIcon(){
            // Get the thumbnail icon, or null if no icon is displayed
        Icon icon = getThumbnailIcon();
        if (icon == null)   // If there is no icon displayed
            return null;
            // If no disabled icon has been constructed for the thumbnail icon 
            // or the disabled icon is no longer for the current thumbnail icon
        else if (disabledIcon == null || !disabledIcon.getIcon().equals(icon)){
            disabledIcon = new DisabledThumbnailIcon();
        }
        return disabledIcon;
    }
    /**
     * This sets the image that will be displayed by this label. This is 
     * equivalent to calling {@link #setIcon(javax.swing.Icon) 
     * setIcon}{@code ((image != null) ? new }
     * {@link ImageIcon#ImageIcon(java.awt.Image) ImageIcon(image)}
     * {@code : null)}. As such, the default value for this is null.
     * @param image The image to be displayed by this label.
     * @see #setIcon(javax.swing.Icon) 
     * @see ImageIcon
     * @see #getIcon() 
     * @see #getImage() 
     */
    public void setImage(Image image){
        Image old = getImage(); // Get the current image
            // If either no icon is set and the image is null or there is an 
            // icon with an image set and that image is the same as the new image
        if ((getDisplayedIcon() == null && image == null) || 
                (old != null && old.equals(image)))
            return;
            // If the image is not null, create a new ImageIcon with it and set  
            // the icon to that. Otherwise, set the icon to null
        setIcon((image != null) ? new ImageIcon(image) : null);
    }
    /**
     * This returns the image currently being displayed by this label. If no 
     * {@link #getIcon() icon} is set or the icon is not an {@link ImageIcon}, 
     * then this returns null. This is equivalent to checking if the icon is an 
     * ImageIcon, and if so then calling {@code ((ImageIcon)getIcon).}{@link 
     * ImageIcon#getImage() getImage()}.
     * @return The image being displayed by this label, or null if the icon is 
     * either not set or is not an ImageIcon.
     * @see #getIcon() 
     * @see ImageIcon
     * @see ImageIcon#getImage() 
     * @see #setIcon(javax.swing.Icon) 
     * @see #setImage(java.awt.Image) 
     */
    public Image getImage(){
            // If the displayed icon is an ImageIcon, return its image. If not, 
        return (getDisplayedIcon() instanceof ImageIcon) ? // return null
                ((ImageIcon)getDisplayedIcon()).getImage() : null;
    }
    /**
     * This returns the width of the image or icon that this label displays. 
     * This delegates to the {@link Icon#getIconWidth() getIconWidth} method of 
     * the {@link #getIcon() icon} if it's set.
     * @return The width of the icon, or -1 if no icon is set.
     * @see #getIcon() 
     * @see Icon#getIconWidth() 
     * @see #getImageHeight() 
     * @see #getImageSize() 
     * @see #getImageSize(java.awt.Dimension) 
     */
    public int getImageWidth(){
            // If there's an icon, return its width. Otherwise, return -1.
        return (isIconSet()) ? getDisplayedIcon().getIconWidth() : -1;
    }
    /**
     * This returns the height of the image or icon that this label displays. 
     * This delegates to the {@link Icon#getIconHeight() getIconHeight} method 
     * of the {@link #getIcon() icon} if it's set.
     * @return The height of the icon, or -1 if no icon is set.
     * @see #getIcon() 
     * @see Icon#getIconHeight() 
     * @see #getImageWidth() 
     * @see #getImageSize() 
     * @see #getImageSize(java.awt.Dimension) 
     */
    public int getImageHeight(){
            // If there's an icon, return its height. Otherwise, return -1.
        return (isIconSet()) ? getDisplayedIcon().getIconHeight() : -1;
    }
    /**
     * This stores the width and height of the image or icon into the given 
     * Dimension object. If the given Dimension object is null, then a new 
     * Dimension object will be returned. This version is useful as to avoid 
     * creating a new Dimension object.
     * @param dim The Dimension object to return with the dimensions of the 
     * icon, if set, or null.
     * @return The Dimension object holding the dimensions of the icon.
     * @see #getImageWidth() 
     * @see #getImageHeight() 
     * @see #getImageSize() 
     * @see #getIcon() 
     * @see Icon#getIconWidth() 
     * @see Icon#getIconHeight() 
     */
    public Dimension getImageSize(Dimension dim){
        if (dim == null)    // If the dimension object is null
            return new Dimension(getImageWidth(),getImageHeight());
        dim.setSize(getImageWidth(), getImageHeight());
        return dim;
    }
    /**
     * This returns a Dimension object containing the width and height of the 
     * image or icon that this label displays.
     * @return The Dimension object holding the dimensions of the icon.
     * @see #getImageWidth() 
     * @see #getImageHeight() 
     * @see #getImageSize(java.awt.Dimension) 
     * @see #getIcon() 
     * @see Icon#getIconWidth() 
     * @see Icon#getIconHeight() 
     */
    public Dimension getImageSize(){
        return getImageSize(null);
    }
    /**
     * This checks whether the image scaling mode is valid or not and throws an 
     * IllegalArgumentException accordingly.
     * @param mode The proposed new image scaling mode.
     * @throws IllegalArgumentException if the image scaling mode is invalid.
     * @see #setImageScaleMode(int) 
     * @see #NO_SCALING_APPLIED
     * @see #ONLY_SCALE_TO_FIT
     * @see #ALWAYS_SCALE_IGNORE_ASPECT_RATIO
     * @see #ALWAYS_SCALE_MAINTAIN_ASPECT_RATIO
     * @see #MAINTAIN_ASPECT_RATIO
     * @see #ALWAYS_SCALE_IMAGE
     */
    protected void checkImageScaleMode(int mode){
            // If the mode is less than the minimum scaling mode or greater than the maximum scaling mode
        if (mode < NO_SCALING_APPLIED || mode > (ALWAYS_SCALE_IMAGE | MAINTAIN_ASPECT_RATIO))
            throw new IllegalArgumentException("Invalid mode for scaling images: " + mode);
    }
    /**
     * This sets the scaling mode for this label. The scaling mode is used to 
     * determine how the image or icon will be scaled, if at all. The scaling 
     * mode uses the {@link #MAINTAIN_ASPECT_RATIO} flag and the {@link 
     * #ALWAYS_SCALE_IMAGE} flag to determine the scaling behavior of this 
     * label. The default value for this is {@link ONLY_SCALE_TO_FIT}.
     * @param mode The mode for how images will be scaled. This should be one 
     * of the following: 
     *      {@link NO_SCALING_APPLIED}, 
     *      {@link ONLY_SCALE_TO_FIT}, 
     *      {@link ALWAYS_SCALE_IGNORE_ASPECT_RATIO}, or 
     *      {@link ALWAYS_SCALE_MAINTAIN_ASPECT_RATIO}.
     * 
     * @throws IllegalArgumentException If the scaling mode is invalid.
     * @see #setAspectRatioMaintained(boolean) 
     * @see #setImageAlwaysScaled(boolean) 
     * @see #getImageScaleMode() 
     * @see #isImageAlwaysScaled() 
     * @see #isAspectRatioMaintained() 
     * @see #MAINTAIN_ASPECT_RATIO
     * @see #ALWAYS_SCALE_IMAGE
     * @see #NO_SCALING_APPLIED
     * @see #ONLY_SCALE_TO_FIT
     * @see #ALWAYS_SCALE_IGNORE_ASPECT_RATIO
     * @see #ALWAYS_SCALE_MAINTAIN_ASPECT_RATIO
     */
    public void setImageScaleMode(int mode){
        if (mode == scaleMode)      // If the new scaling mode is the same as the old one
            return;
        checkImageScaleMode(mode);
        int old = scaleMode;        // Stores the old scaling mode
        scaleMode = mode;
        firePropertyChange(IMAGE_SCALE_MODE_PROPERTY_CHANGED, old, mode);
        if (isIconSet())            // If an icon is set
            revalidate();
        repaintIfDisplayingIcon();
    }
    /**
     * This returns the current scaling mode for this label. The default value 
     * for this is {@link ONLY_SCALE_TO_FIT}.
     * @return The mode for how images will be scaled. This will be one of the 
     * following: 
     *      {@link NO_SCALING_APPLIED}, 
     *      {@link ONLY_SCALE_TO_FIT}, 
     *      {@link ALWAYS_SCALE_IGNORE_ASPECT_RATIO}, or 
     *      {@link ALWAYS_SCALE_MAINTAIN_ASPECT_RATIO}.
     * 
     * @see #setImageScaleMode(int) 
     * @see #setAspectRatioMaintained(boolean) 
     * @see #setImageAlwaysScaled(boolean) 
     * @see #isImageAlwaysScaled() 
     * @see #isAspectRatioMaintained() 
     * @see #MAINTAIN_ASPECT_RATIO
     * @see #ALWAYS_SCALE_IMAGE
     * @see #NO_SCALING_APPLIED
     * @see #ONLY_SCALE_TO_FIT
     * @see #ALWAYS_SCALE_IGNORE_ASPECT_RATIO
     * @see #ALWAYS_SCALE_MAINTAIN_ASPECT_RATIO
     */
    public int getImageScaleMode(){
        return scaleMode;
    }
    /**
     * This sets the flag for the scaling mode to the given value.
     * @param flag The flag to set or clear.
     * @param value Whether the flag is to be set or cleared.
     * @throws IllegalArgumentException If the scaling mode would become invalid 
     * because of setting the flag (i.e. if the flag is not a valid flag). 
     * @see #MAINTAIN_ASPECT_RATIO
     * @see #ALWAYS_SCALE_IMAGE
     * @see #getScaleFlag(int) 
     * @see #getImageScaleMode() 
     * @see #setImageScaleMode(int) 
     * @see #checkImageScaleMode(int) 
     * @see #isAspectRatioMaintained() 
     * @see #isImageAlwaysScaled() 
     * @see #setAspectRatioMaintained(boolean) 
     * @see #setImageAlwaysScaled(boolean) 
     */
    protected void setScaleFlag(int flag, boolean value){
            // If the flag is already set or cleared
        if (value == getScaleFlag(flag))
            return;
        int mode = getImageScaleMode(); // This gets the current scaling mode
            // If the flag should be set, set it. Otherwise clear it.
        setImageScaleMode((value)?(mode|flag):(mode&~flag));
    }
    /**
     * This sets whether the image or icon's aspect ratio is maintained when 
     * it gets scaled. If this is true and the {@link #isImageAlwaysScaled() 
     * image is not always scaled}, then the image will {@link 
     * #ONLY_SCALE_TO_FIT only be scaled to fit} the label if it doesn't already 
     * fit. This is equivalent to setting or clearing the {@link 
     * MAINTAIN_ASPECT_RATIO} flag for the {@link #getImageScaleMode() scaling 
     * mode}. The default value for this is true.
     * @param value Whether the aspect ratio is to be maintained.
     * @see #isAspectRatioMaintained()
     * @see #MAINTAIN_ASPECT_RATIO
     * @see #ALWAYS_SCALE_IMAGE
     * @see #NO_SCALING_APPLIED
     * @see #ONLY_SCALE_TO_FIT
     * @see #ALWAYS_SCALE_IGNORE_ASPECT_RATIO
     * @see #ALWAYS_SCALE_MAINTAIN_ASPECT_RATIO
     * @see #setImageScaleMode(int) 
     * @see #getImageScaleMode() 
     * @see #setImageAlwaysScaled(boolean) 
     * @see #isImageAlwaysScaled() 
     */
    public void setAspectRatioMaintained(boolean value){
        setScaleFlag(MAINTAIN_ASPECT_RATIO,value);
    }
    /**
     * This sets whether the image or icon is always scaled regardless of 
     * whether it would fit within this label without scaling. This is 
     * equivalent to setting or clearing the {@link #ALWAYS_SCALE_IMAGE } flag 
     * for the {@link #getImageScaleMode() scaling mode}. The default value for 
     * this is false.
     * @param value Whether the icon is always scaled.
     * @see #isImageAlwaysScaled() 
     * @see #ALWAYS_SCALE_IMAGE
     * @see #MAINTAIN_ASPECT_RATIO
     * @see #NO_SCALING_APPLIED
     * @see #ONLY_SCALE_TO_FIT
     * @see #ALWAYS_SCALE_IGNORE_ASPECT_RATIO
     * @see #ALWAYS_SCALE_MAINTAIN_ASPECT_RATIO
     * @see #setImageScaleMode(int) 
     * @see #getImageScaleMode() 
     * @see #setAspectRatioMaintained(boolean) 
     * @see #isAspectRatioMaintained() 
     */
    public void setImageAlwaysScaled(boolean value){
        setScaleFlag(ALWAYS_SCALE_IMAGE,value);
    }
    /**
     * This returns whether the given flag is set for the scaling mode.
     * @param flag The flag to check for.
     * @return Whether the given flag is set.
     * @see #MAINTAIN_ASPECT_RATIO
     * @see #ALWAYS_SCALE_IMAGE
     * @see #setScaleFlag(int, boolean) 
     * @see #getImageScaleMode() 
     * @see #setImageScaleMode(int) 
     * @see #isAspectRatioMaintained() 
     * @see #isImageAlwaysScaled() 
     * @see #setAspectRatioMaintained(boolean) 
     * @see #setImageAlwaysScaled(boolean) 
     */
    protected boolean getScaleFlag(int flag){
        return (getImageScaleMode() & flag) == flag;
    }
    /**
     * This returns whether the image or icon's aspect ratio is maintained when 
     * it gets scaled. If this is true and the {@link #isImageAlwaysScaled() 
     * image is not always scaled}, then the image will {@link 
     * #ONLY_SCALE_TO_FIT only be scaled to fit} the label if it doesn't already 
     * fit. The default value for this is true.
     * @return Whether the aspect ratio is maintained.
     * @see #setAspectRatioMaintained(boolean) 
     * @see #MAINTAIN_ASPECT_RATIO
     * @see #ALWAYS_SCALE_IMAGE
     * @see #NO_SCALING_APPLIED
     * @see #ONLY_SCALE_TO_FIT
     * @see #ALWAYS_SCALE_IGNORE_ASPECT_RATIO
     * @see #ALWAYS_SCALE_MAINTAIN_ASPECT_RATIO
     * @see #setImageScaleMode(int) 
     * @see #getImageScaleMode() 
     * @see #setImageAlwaysScaled(boolean) 
     * @see #isImageAlwaysScaled() 
     */
    public boolean isAspectRatioMaintained(){
        return getScaleFlag(MAINTAIN_ASPECT_RATIO);
    }
    /**
     * This returns whether the image or icon is always scaled regardless of 
     * whether it would fit within this label without scaling. The default 
     * value for this is false.
     * @return Whether the icon is always scaled.
     * @see #setImageAlwaysScaled(boolean) 
     * @see #ALWAYS_SCALE_IMAGE
     * @see #MAINTAIN_ASPECT_RATIO
     * @see #NO_SCALING_APPLIED
     * @see #ONLY_SCALE_TO_FIT
     * @see #ALWAYS_SCALE_IGNORE_ASPECT_RATIO
     * @see #ALWAYS_SCALE_MAINTAIN_ASPECT_RATIO
     * @see #setImageScaleMode(int) 
     * @see #getImageScaleMode() 
     * @see #setAspectRatioMaintained(boolean) 
     * @see #isAspectRatioMaintained() 
     */
    public boolean isImageAlwaysScaled(){
        return getScaleFlag(ALWAYS_SCALE_IMAGE);
    }
    /**
     * This returns whether this label has an icon set.
     * @return Whether {@link #getDisplayedIcon()} does not return null.
     * @see #getDisplayedIcon() 
     * @see #setIcon(javax.swing.Icon) 
     */
    protected boolean isIconSet(){
        return getDisplayedIcon() != null;
    }
    /**
     * This repaints the label if an {@link #isIconSet() icon is set}.
     * @see #isIconSet() 
     * @see #getDisplayedIcon() 
     * @see #setIcon(javax.swing.Icon) 
     * @see #repaint() 
     */
    protected void repaintIfDisplayingIcon(){
        if (isIconSet())     // If an icon is set
            repaint();
    }
    /**
     * This repaints the region of this label that contains the thumbnail if 
     * this label is showing and has an icon set. Only the region currently 
     * containing the thumbnail is repainted. As such, visual artifacts may 
     * appear if the thumbnail has changed size or location since the last time 
     * this label was painted. This effectively checks to see if an icon is set, 
     * and if so, then this calls {@link #repaint(int, int, int, int) repaint} 
     * with the thumbnail region's {@link #getThumbnailRegionX() x}, {@link 
     * #getThumbnailRegionY() y}, {@link #getThumbnailRegionWidth() width}, and 
     * {@link #getThumbnailRegionHeight() height}. 
     * @see #getIcon() 
     * @see #repaint() 
     * @see #repaint(int, int, int, int) 
     * @see #repaint(java.awt.Rectangle) 
     * @see #getThumbnailRegionBounds() 
     * @see #getThumbnailRegionX() 
     * @see #getThumbnailRegionY() 
     * @see #getThumbnailRegionWidth() 
     * @see #getThumbnailRegionHeight() 
     */
    public void repaintThumbnail(){
        if (isIconSet())     // If an icon is set
            repaint(getThumbnailRegionX()-1,getThumbnailRegionY()-1,
                    getThumbnailRegionWidth()+2,getThumbnailRegionHeight()+2);
    }
    /**
     * This sets the value of a single preference for the rendering algorithms 
     * used to render the thumbnail.
     * 
     * These hints include controls for the rendering quality and the 
     * time/quality trade-off when rendering. Refer to the {@link 
     * RenderingHints} class for the definitions for some common keys and 
     * values.
     * @param key The key of the hint to set (cannot be null).
     * @param value The value indicating the preference for the hint, or null to 
     * clear the currently set preference.
     * @see #getRenderingHint(java.awt.RenderingHints.Key) 
     * @see RenderingHints
     */
    public void setRenderingHint(RenderingHints.Key key, Object value){
            // If the hint is already set to the given value
        if (Objects.equals(getRenderingHint(key),value))
            return;
        if (value == null)  // If the value is getting set to null
            hintMap.remove(key);
        else
            hintMap.put(key, value);
        repaintIfDisplayingIcon();
    }
    /**
     * This returns the value of a single preference for the rendering 
     * algorithms used to render the thumbnail.
     * 
     * These hints include controls for the rendering quality and the 
     * time/quality trade-off when rendering. Refer to the {@link 
     * RenderingHints} class for the definitions for some common keys and 
     * values.
     * @param key The key of the hint to get (cannot be null).
     * @return An object representing the value for the specified hint, or null 
     * if no value has been set for the specified hint.
     * @see #setRenderingHint(java.awt.RenderingHints.Key, java.lang.Object) 
     * @see RenderingHints
     */
    public Object getRenderingHint(RenderingHints.Key key){
        return hintMap.get(Objects.requireNonNull(key,"Rendering hint key cannot be null"));
    }
    /**
     * This checks to see if the given hint map is either null or contains a 
     * null key, and if so, then this throws a NullPointerException.
     * @param hints The hint map to check.
     */
    private void checkHintMap(Map<?,?> hints){
        if (hints == null)      // If the hint map is null
            throw new NullPointerException("Rendering hint map cannot be null");
        else if (hints.containsKey(null))   // If the hint map contains a null key
            throw new NullPointerException("Rendering hint key cannot be null");
    }
    /**
     * This sets the value for multiple preferences for the rendering 
     * algorithms used to render the thumbnail based off the given map. Only the 
     * rendering hints that are present in the given map will be modified, and 
     * all other rendering hints are left unchanged.
     * 
     * These hints include controls for the rendering quality and the 
     * time/quality trade-off when rendering. Refer to the {@link 
     * RenderingHints} class for the definitions for some common keys and 
     * values.
     * @param hints The map containing the rendering hints to be set (cannot be 
     * null and cannot contain a null key).
     * @see #getRenderingHints() 
     * @see #setRenderingHints(java.util.Map) 
     * @see RenderingHints
     */
    public void addRenderingHints(Map<?,?> hints){
        checkHintMap(hints);
        hintMap.putAll(hints);
        repaintIfDisplayingIcon();
    }
    /**
     * This replaces the values for all the preferences for the rendering 
     * algorithms used to render the thumbnail. All existing values for the 
     * rendering hints are discarded and the new set of rendering hints is 
     * initialized using the given map of rendering hints.
     * 
     * These hints include controls for the rendering quality and the 
     * time/quality trade-off when rendering. Refer to the {@link 
     * RenderingHints} class for the definitions for some common keys and 
     * values.
     * @param hints The map containing the rendering hints to be set (cannot be 
     * null and cannot contain a null key).
     * @see #getRenderingHints() 
     * @see #addRenderingHints(java.util.Map) 
     * @see RenderingHints
     */
    public void setRenderingHints(Map<?,?> hints){
        checkHintMap(hints);
        hintMap.clear();
        addRenderingHints(hints);
    }
    /**
     * This returns a map containing all the currently set preferences for the 
     * rendering algorithms used to render the thumbnail.
     * 
     * These hints include controls for the rendering quality and the 
     * time/quality trade-off when rendering. Refer to the {@link 
     * RenderingHints} class for the definitions for some common keys and 
     * values.
     * @return A copy of the RenderingHints object used to store the rendering 
     * hints.
     * @see #setRenderingHints(java.util.Map) 
     * @see #addRenderingHints(java.util.Map) 
     * @see RenderingHints
     */
    public RenderingHints getRenderingHints(){
        return (RenderingHints) hintMap.clone();
    }
    /**
     * This returns the border for the thumbnail.
     * @return The border object for the thumbnail, or null if no border is set.
     * @see #setThumbnailBorder(javax.swing.border.Border) 
     */
    public Border getThumbnailBorder(){
        return imgBorder;
    }
    /**
     * This sets the border for the thumbnail. This is separate from the border 
     * for the label, with this border being rendered around the thumbnail only 
     * instead of being rendered around the label. The Border object is 
     * responsible for defining the insets for the thumbnail separate from the 
     * insets of the label and for optionally rendering any border decorations 
     * within the bounds of those insets. Compound borders can be used to nest 
     * multiple borders around the thumbnail. <p>
     * The thumbnail overlay is allowed to render over the border. This is so 
     * that a border can be used to allow the thumbnail overlay to draw outside 
     * the bounds of the actual thumbnail of the image or icon.
     * @param border The border for the thumbnail.
     * @see #getThumbnailBorder() 
     * @see #setThumbnailOverlay(javax.swing.Painter) 
     * @see #getThumbnailOverlay() 
     * @see Border
     * @see javax.swing.border.CompoundBorder
     * @see #setBorder(javax.swing.border.Border) 
     * @see #getBorder() 
     */
    public void setThumbnailBorder(Border border){
            // If the new border is the same as the old one
        if (Objects.equals(imgBorder, border))
            return;
        Border old = imgBorder; // Stores the old border
        imgBorder = border;
        firePropertyChange(THUMBNAIL_BORDER_PROPERTY_CHANGED,old,border);
            // If either border is null or the new border has different insets 
            // to the old one
        if (old == null || border == null || 
                !border.getBorderInsets(this).equals(old.getBorderInsets(this)))
            revalidate();
        repaintIfDisplayingIcon();
    }
    /**
     * This returns an Insets object containing the insets from the thumbnail 
     * border if it's set. This will attempt to reuse the given Insets object if 
     * possible, but there is no guarantee that the returned Insets object is 
     * the same one that was given. All existing values in the given Insets 
     * object will be overwritten. If the given Insets object is null, then a 
     * new Insets object will be returned.
     * @param insets The Insets object to be reused, if possible.
     * @return The Insets object storing the insets for the thumbnail border, or 
     * null.
     * @see #getThumbnailBorder() 
     * @see #setThumbnailBorder(javax.swing.border.Border) 
     * @see #getThumbnailInsets() 
     */
    public Insets getThumbnailInsets(Insets insets){
        if (insets == null) // If the insets object is null
            insets = new Insets(0, 0, 0, 0);
            // Get the thumbnail border
        Border border = getThumbnailBorder();
            // If the thumbnail border is an AbstractBorder
        if (border instanceof AbstractBorder)
            return ((AbstractBorder)border).getBorderInsets(this, insets);
        else if (border != null)    // If the border is not null
            return border.getBorderInsets(this);
        else{
            insets.set(0, 0, 0, 0);
            return insets;
        }
    }
    /**
     * This returns an Insets object containing the insets from the thumbnail 
     * border if it's set. If no thumbnail border is set, then this returns 
     * an Insets object containing all zeros.
     * @return The Insets object storing the insets for the thumbnail border.
     * @see #getThumbnailBorder() 
     * @see #setThumbnailBorder(javax.swing.border.Border) 
     * @see #getThumbnailInsets(java.awt.Insets) 
     */
    public Insets getThumbnailInsets(){
        return getThumbnailInsets(null);
    }
    /**
     * This returns the Painter object used to render the overlay for the 
     * thumbnail. 
     * @return The Painter object used to render the thumbnail overlay, or null 
     * if no thumbnail overlay is set.
     * @see #setThumbnailOverlay(javax.swing.Painter) 
     */
    public Painter<? super JThumbnailLabel> getThumbnailOverlay(){
        return overlay;
    }
    /**
     * This sets the Painter object used to render the overlay for the 
     * thumbnail. The thumbnail overlay is used to render graphics over the 
     * thumbnail. This can be used to, for example, render grid lines over the 
     * thumbnail which aligns to the coordinate space of the image or icon with 
     * reasonable accuracy. Another possible use for this is to render an 
     * outline around a part of the thumbnail. <p>
     * 
     * When the overlay is being rendered, it is not scaled like the image or 
     * icon, nor is it bounded by the thumbnail border. Instead, the overlay is 
     * rendered unscaled and over the thumbnail border. This is so that the 
     * overlay is rendered in such a way that things like line thickness are not 
     * affected by the size of the thumbnail, as well as providing the ability 
     * to render parts of the overlay beyond the bounds of the actual thumbnail 
     * of the image or icon if a border is set. <p>
     * 
     * JThumbnailLabel provides multiple methods to assist with converting to 
     * and from the thumbnail coordinate space. These include methods to get the 
     * {@link #getScaleX() x} and {@link #getScaleY() y} coordinate scaling 
     * factors, methods for converting points, dimensions, and rectangles to and 
     * from the thumbnail coordinate space, and a method to get a {@link 
     * #getThumbnailTransform() transformation} for the thumbnail.
     * @param overlay The Painter object to use to render the thumbnail overlay.
     * @see #getThumbnailOverlay() 
     * @see #setThumbnailBorder(javax.swing.border.Border) 
     * @see #getThumbnailBorder() 
     * @see #getIcon() 
     * @see #setIcon(javax.swing.Icon) 
     * @see #getImage() 
     * @see #setImage(java.awt.Image) 
     */
    public void setThumbnailOverlay(Painter<? super JThumbnailLabel> overlay){
            // If the new overlay is the same as the old one
        if (Objects.equals(this.overlay, overlay))
            return;
        Painter old = this.overlay; // Get the old overlay
        this.overlay = overlay;
        firePropertyChange(THUMBNAIL_OVERLAY_PROPERTY_CHANGED,old,overlay);
        repaintIfDisplayingIcon();
    }
    /**
     * This returns whether this will scale the image or icon based off the 
     * currently set scaling mode, the given image width and height, and the 
     * given maximum width and height. <p>
     * 
     * If you override this method in a subclass, please keep in mind that it is 
     * assumed that the order in which the width and height are given in is 
     * interchangeable, as long as the image width and height are given in the 
     * same order as the maximum width and height. In other words, calling 
     * {@code willScaleImage(imgWidth, imgHeight, width, height)} is the same as 
     * calling {@code willScaleImage(imgHeight, imgWidth, height, width)}.
     * @param imgWidth The image width.
     * @param imgHeight The image height.
     * @param width The maximum width.
     * @param height The maximum height.
     * @return Whether the image will be scaled.
     * @see #getImageWidth() 
     * @see #getImageHeight() 
     * @see #calculateMaxImageSize() 
     * @see #calculateThumbnailValue(int, int, int, int) 
     * @see #setImageScaleMode(int) 
     * @see #getImageScaleMode() 
     * @see #isAspectRatioMaintained() 
     * @see #isImageAlwaysScaled() 
     * @see #setAspectRatioMaintained(boolean) 
     * @see #setImageAlwaysScaled(boolean) 
     */
    protected boolean willScaleImage(int imgWidth, int imgHeight, int width, int height){
            // If either the image width or height are less than or equal to zero.
        if (imgWidth <= 0 || imgHeight <= 0)    
            return false;
        if (isImageAlwaysScaled()){ // If the image is always scaled
                // If the image width is the same as the maximum width
            boolean matchWidth = imgWidth == width;
                // If the image height is the same as the maximum height
            boolean matchHeight = imgHeight == height;
                // If the aspect ratio is maintained, then return whether both 
                // the widths and heights don't match. Otherwise, return whether 
                // either the widths or the heights don't match.
            return !((isAspectRatioMaintained()) ? 
                    (matchWidth || matchHeight) : (matchWidth && matchHeight));
        }
            // Return whether the aspect ratio is maintained and that either the 
            // image width is larger than the maximum width or the image height 
            // is larger than the maximum height
        return isAspectRatioMaintained() && (imgWidth>width||imgHeight>height);
    }
    /**
     * This is used to scale values, and rounds the scaled value. <p>
     * The default implementation is equivalent to calling {@code 
     * (int)}{@link Math#round(double) Math.round}{@code (value * scale)}.
     * @param value The value to scale.
     * @param scale The scaling value to use.
     * @return The value multiplied by the scaling value and rounded.
     * @see Math#round(double) 
     * @see #willScaleImage(int, int, int, int) 
     * @see #calculateThumbnailValue(int, int, int, int) 
     * @see #scaleValueX(int) 
     * @see #scaleValueY(int) 
     */
    protected int scaleValue(int value, double scale){
        return (int)Math.round(value * scale);
    }
    /**
     * This is used to scale values by the reciprocal of the given scaling 
     * value, and rounds the scaled value. This is equivalent to calling {@link 
     * #scaleValue(int, double) scaleValue(value, 1/scale)}.
     * @param value The value to scale.
     * @param scale The scaling value to use the reciprocal of. (If this is 
     * zero, then a zero will be used instead)
     * @return The value multiplied by the reciprocal of the scaling value and 
     * rounded.
     * @see #scaleValue(int, double) 
     * @see #scaleValueInverseX(int) 
     * @see #scaleValueInverseY(int) 
     */
    protected int inverseScaleValue(int value, double scale){
        if (scale != 0)         // If the scale value is not zero, since we 
            scale = 1/scale;    // can't divide by zero
        return scaleValue(value,scale);
    }
    /**
     * This resets the given rectangle. If the given rectangle is null, then 
     * this will initialize it, assuming that the provided rectangle is the one 
     * that will receive the returned rectangle.
     * @param rect The rectangle to reset, or null to initialize it.
     * @return The given rectangle, now reset, or a new rectangle if the given 
     * rectangle is null.
     */
    private Rectangle resetRectangle(Rectangle rect){
        if (rect == null)   // If the rectangle is null
            return new Rectangle();
        rect.setBounds(0, 0, 0, 0);
        return rect;
    }
    /**
     * This returns the {@code FontMetrics} for the currently set {@code Font} 
     * for this label. This is equivalent to calling {@link 
     * #getFontMetrics(java.awt.Font) getFontMetrics}{@code (}{@link 
     * #getFont() getFont()}{@code )}. This will return null if {@code getFont} 
     * returns null.
     * @return The font metrics for the currently set font.
     * @see #getFontMetrics(java.awt.Font) 
     * @see #getFont() 
     */
    public FontMetrics getFontMetrics(){
        Font font = getFont();  // Get the currently set font
            // If the font is not null, use it to get the font metrics. 
            // Otherwise, return null.
        return (font != null) ? getFontMetrics(font) : null;
    }
    /**
     * This is used to calculate the rectangle for the thumbnail icon. This is 
     * mainly used to get the location for the thumbnail icon's origin. This 
     * delegates the task to {@link SwingUtilities#layoutCompoundLabel}, using 
     * the properties for this label and providing it with the {@link 
     * #getThumbnailIcon() thumbnail icon}. This then returns the rectangle as 
     * for {@code iconR} for {@code SwingUtilities.layoutCompoundLabel}.
     * @return The Rectangle for the thumbnail icon.
     * @see #getThumbnailIcon() 
     * @see SwingUtilities#layoutCompoundLabel
     * @see #getText() 
     * @see #getFontMetrics() 
     * @see #getVerticalAlignment() 
     * @see #getHorizontalAlignment() 
     * @see #getVerticalTextPosition() 
     * @see #getHorizontalTextPosition() 
     * @see #getIconTextGap() 
     * @see #getSize() 
     * @see SwingUtilities#calculateInnerArea
     */
    protected synchronized Rectangle calculateThumbnailRectangle(){
            // HACK: layoutCompoundLabel is being used to get the thumbnail 
            // rectangle, so that the thumbnail's origin can be retrieved
        innerArea = SwingUtilities.calculateInnerArea(this, innerArea);
        iconRect = resetRectangle(iconRect);
        textRect = resetRectangle(textRect);
        SwingUtilities.layoutCompoundLabel(this, getFontMetrics(), getText(), getThumbnailIcon(),
                getVerticalAlignment(), getHorizontalAlignment(), getVerticalTextPosition(),
                getHorizontalTextPosition(), innerArea, iconRect, textRect, getIconTextGap());
        return iconRect;
    }
    /**
     * This is used to calculate the maximum size for the thumbnail, storing 
     * the results into the given Dimensions object. If the given Dimensions 
     * object is null, then a new Dimensions object will be returned. This is 
     * useful as to avoid having to create a new Dimensions object to perform 
     * these calculations. <p>
     * 
     * The maximum size for the thumbnail is calculated by first subtracting the 
     * label's insets and the thumbnail insets from the label's size. 
     * Afterwards, this checks to see if the label has text and that the font 
     * metrics for the label's font is not null. If this is the case, then the 
     * position for the text is checked. If the text is not horizontally 
     * centered, then the width of the text and the icon text gap is subtracted 
     * from the maximum width. If the text is horizontally centered but not 
     * vertically centered, then the font's height and the icon text gap is 
     * subtracted from the maximum height. If the label does not have any text, 
     * the font metrics for the label's font is null, or the text is both 
     * horizontally and vertically centered, then the text will not affect the 
     * maximum thumbnail size. The maximum size is then range checked to ensure 
     * that the maximum width and height are never less than zero. If either 
     * the maximum width or height are negative, then they will be set to zero. 
     * 
     * @param dim The Dimensions object to return with the maximum size for the 
     * thumbnail, or null.
     * @return The Dimensions object storing the maximum size for the thumbnail.
     * @see #calculateMaxImageSize() 
     * @see #calculateThumbnailValue(int, int, int, int) 
     * @see #getThumbnailWidth() 
     * @see #getThumbnailHeight() 
     * @see #getWidth() 
     * @see #getHeight() 
     * @see #getSize() 
     * @see #getSize(java.awt.Dimension) 
     * @see #getInsets() 
     * @see #getThumbnailInsets() 
     * @see #getText() 
     * @see #getFont() 
     * @see #getFontMetrics(java.awt.Font) 
     * @see #getFontMetrics() 
     * @see #getHorizontalTextPosition() 
     * @see #getVerticalTextPosition() 
     * @see #getIconTextGap() 
     * @see java.awt.FontMetrics#stringWidth(java.lang.String) 
     * @see java.awt.FontMetrics#getHeight() 
     * @see SwingConstants#CENTER
     */
    protected synchronized Dimension calculateMaxImageSize(Dimension dim){
        dim = getSize(dim);
            // A for loop to subtract the insets for this label and the thumbnail
        for (Insets in : new Insets[]{getInsets(),getThumbnailInsets()}){
            if (in != null){    // If the current inset is not null
                dim.width -= (in.left + in.right);
                dim.height -= (in.top + in.bottom);
            }
        }
        String text = getText();    // Gets the text for the label
        FontMetrics metrics = getFontMetrics();     // Gets the font metrics
            // If this label has text and the font metrics for the font is not null
        if (text != null && !text.isEmpty() && metrics != null){
                // If the text is not horizontally centered
            if (getHorizontalTextPosition() != SwingConstants.CENTER){
                dim.width -= (SwingUtilities.computeStringWidth(metrics, text)+
                        getIconTextGap());
            }   // If the text is not vertically centered
            else if (getVerticalTextPosition() != SwingConstants.CENTER){
                dim.height -= (metrics.getHeight() + getIconTextGap());
            }
        }
        dim.width = Math.max(dim.width, 0);
        dim.height = Math.max(dim.height, 0);
        return dim;
    }
    /**
     * This calculates and returns the maximum size for the thumbnail. This 
     * delegates to the {@link #calculateMaxImageSize(java.awt.Dimension) 
     * calculateMaxImageSize(Dimension)} method, providing it with a Dimension 
     * object used solely for getting the maximum thumbnail size. As such, 
     * the returned Dimension object should only be used to retrieve and store 
     * the maximum thumbnail size. 
     * @return The maximum size for the thumbnail.
     * @see #calculateMaxImageSize(java.awt.Dimension) 
     */
    private synchronized Dimension calculateMaxImageSize(){
        maxImageSize = calculateMaxImageSize(maxImageSize);
        return maxImageSize;
    }
    /**
     * This gets the scaling value for the given values. This is equivalent to 
     * dividing {@code thumbnailValue} by {@code value}. If either of these 
     * values less than or equal to zero, then this just returns zero.
     * @param thumbnailValue The numerator for the scaling value.
     * @param value The denominator for the scaling value.
     * @return The scaling value for the given values, or zero if either value 
     * is less than or equal to zero.
     * @see #calculateThumbnailValue(int, int, int, int) 
     * @see #getScaleX() 
     * @see #getScaleY() 
     * @see #paintThumbnail(java.awt.Graphics2D, int, int, int, int) 
     */
    private double getScale(int thumbnailValue, int value){
            // If either the thumbnail value or the image value is less than or 
        if (thumbnailValue <= 0 || value <= 0)  // equal to zero
            return 0;
        return thumbnailValue / ((double)value);
    }
    /**
     * This calculates the scaled width or height for the thumbnail. Whether 
     * this returns the width or the height is dependent on the order in which 
     * the values are given in, with the first two parameters corresponding to 
     * the scaled value to return and the last two parameters corresponding to 
     * the value not being returned. In other words, the first two parameters 
     * determine whether this returns the width or height. To get the width, 
     * the first two values should be the image width and the maximum width, 
     * and the last two values should be the image height and the maximum 
     * height. To get the height, the first two values should be the image 
     * height and the maximum height, and the last two values should be the 
     * image width and the maximum width.
     * 
     * @param value1 The value to scale. (Image width to get the width, image 
     * height to get the height)
     * @param maxValue1 The maximum value for the value to scale. (Maximum 
     * thumbnail width to get the width, maximum thumbnail height to get the 
     * height)
     * @param value2 The second value. (Image height to get the width, image 
     * width to get the height)
     * @param maxValue2 The maximum value for the second value. (Maximum 
     * thumbnail height to get the width, maximum thumbnail width to get the 
     * height)
     * @return The thumbnail version of {@code value1}.
     * @see #getThumbnailWidth() 
     * @see #getThumbnailHeight() 
     * @see #willScaleImage(int, int, int, int) 
     * @see #isAspectRatioMaintained() 
     * @see #scaleValue(int, double) 
     * @see #calculateMaxImageSize(java.awt.Dimension) 
     */
    protected int calculateThumbnailValue(int value1, int maxValue1, int value2, 
            int maxValue2){
        int rv = value1;         // This gets the value to return
            // If the image/icon is to be scaled
        if (willScaleImage(value1,value2,maxValue1,maxValue2)){  
            rv = maxValue1;  
                // If the aspect ratio is to be maintained
            if (isAspectRatioMaintained())
                rv = Math.min(rv, scaleValue(value1,getScale(maxValue2,value2)));
        }
        return Math.max(rv, 0);
    }
    /**
     * This returns the width for the thumbnail of the currently set image or 
     * icon.
     * @return The width for the thumbnail, or -1 if no icon is set.
     * @see #getThumbnailHeight() 
     * @see #getThumbnailSize() 
     * @see #getThumbnailSize(java.awt.Dimension) 
     * @see #getThumbnailBounds() 
     * @see #getThumbnailBounds(java.awt.Rectangle) 
     * @see #getScaleX() 
     * @see #getThumbnailRegionWidth() 
     * @see #getThumbnailRegionSize() 
     * @see #getThumbnailRegionSize(java.awt.Dimension) 
     * @see #getIcon() 
     * @see #setIcon(javax.swing.Icon) 
     * @see #getImage() 
     * @see #setImage(java.awt.Image) 
     * @see #getImageWidth() 
     * @see #getImageHeight() 
     * @see #getThumbnailBorder() 
     * @see #setThumbnailBorder(javax.swing.border.Border) 
     * @see #getThumbnailInsets() 
     * @see #getThumbnailInsets(java.awt.Insets) 
     * @see #getImageScaleMode() 
     * @see #setImageScaleMode(int) 
     * @see #isAspectRatioMaintained() 
     * @see #setAspectRatioMaintained(boolean) 
     * @see #isImageAlwaysScaled() 
     * @see #setImageAlwaysScaled(boolean) 
     * @see #getWidth() 
     */
    public int getThumbnailWidth(){
        if (!isIconSet())    // If no icon has been set
            return -1;
            // If we are currently painting the thumbnail and the thumbnail 
            // bounds is not null
        else if (isPaintingThumbnail() && thumbnailBounds != null)
            return thumbnailBounds.width;
            // Get the maximum size for the thumbnail
        Dimension maxSize = calculateMaxImageSize();    
        return calculateThumbnailValue(getImageWidth(),
                maxSize.width,getImageHeight(),maxSize.height);
    }
    /**
     * This returns the height for the thumbnail of the currently set image or 
     * icon.
     * @return The height for the thumbnail, or -1 if no icon is set.
     * @see #getThumbnailWidth() 
     * @see #getThumbnailSize() 
     * @see #getThumbnailSize(java.awt.Dimension) 
     * @see #getThumbnailBounds() 
     * @see #getThumbnailBounds(java.awt.Rectangle) 
     * @see #getScaleY() 
     * @see #getThumbnailRegionHeight() 
     * @see #getThumbnailRegionSize() 
     * @see #getThumbnailRegionSize(java.awt.Dimension) 
     * @see #getIcon() 
     * @see #setIcon(javax.swing.Icon) 
     * @see #getImage() 
     * @see #setImage(java.awt.Image) 
     * @see #getImageWidth() 
     * @see #getImageHeight() 
     * @see #getThumbnailBorder() 
     * @see #setThumbnailBorder(javax.swing.border.Border) 
     * @see #getThumbnailInsets() 
     * @see #getThumbnailInsets(java.awt.Insets) 
     * @see #getImageScaleMode() 
     * @see #setImageScaleMode(int) 
     * @see #isAspectRatioMaintained() 
     * @see #setAspectRatioMaintained(boolean) 
     * @see #isImageAlwaysScaled() 
     * @see #setImageAlwaysScaled(boolean) 
     * @see #getHeight() 
     */
    public int getThumbnailHeight(){
        if (!isIconSet())    // If no icon has been set
            return -1;
            // If we are currently painting the thumbnail and the thumbnail 
            // bounds is not null
        else if (isPaintingThumbnail() && thumbnailBounds != null)
            return thumbnailBounds.height;
            // Get the maximum size for the thumbnail
        Dimension maxSize = calculateMaxImageSize();    
        return calculateThumbnailValue(getImageHeight(),
                maxSize.height,getImageWidth(),maxSize.width);
    }
    /**
     * This stores the width and height of the thumbnail into the given 
     * Dimension object. If the given Dimension object is null, then a new 
     * Dimension object will be returned. This version is useful as to avoid 
     * creating a new Dimension object.
     * @param dim The Dimension object to return with the dimensions of the 
     * thumbnail, if an image or icon is set, or null.
     * @return The Dimension object holding the dimensions of the thumbnail.
     * @see #getThumbnailWidth() 
     * @see #getThumbnailHeight() 
     * @see #getThumbnailSize() 
     * @see #getThumbnailBounds() 
     * @see #getThumbnailBounds(java.awt.Rectangle) 
     * @see #getScaleX() 
     * @see #getScaleY() 
     * @see #getThumbnailRegionWidth() 
     * @see #getThumbnailRegionHeight() 
     * @see #getThumbnailRegionSize() 
     * @see #getThumbnailRegionSize(java.awt.Dimension) 
     * @see #getIcon() 
     * @see #setIcon(javax.swing.Icon) 
     * @see #getImage() 
     * @see #setImage(java.awt.Image) 
     * @see #getImageWidth() 
     * @see #getImageHeight() 
     * @see #getImageSize() 
     * @see #getImageSize(java.awt.Dimension) 
     * @see #getThumbnailBorder() 
     * @see #setThumbnailBorder(javax.swing.border.Border) 
     * @see #getThumbnailInsets() 
     * @see #getThumbnailInsets(java.awt.Insets) 
     * @see #getImageScaleMode() 
     * @see #setImageScaleMode(int) 
     * @see #isAspectRatioMaintained() 
     * @see #setAspectRatioMaintained(boolean) 
     * @see #isImageAlwaysScaled() 
     * @see #setImageAlwaysScaled(boolean) 
     * @see #getWidth() 
     * @see #getHeight() 
     * @see #getSize() 
     * @see #getSize(java.awt.Dimension) 
     */
    public Dimension getThumbnailSize(Dimension dim){
        if (dim == null)    // If the dimension object is null
            return new Dimension(getThumbnailWidth(),getThumbnailHeight());
        dim.setSize(getThumbnailWidth(),getThumbnailHeight());
        return dim;
    }
    /**
     * This returns a Dimension object containing the width and height of the 
     * thumbnail of the currently set image or icon.
     * @return The Dimension object holding the dimensions of the thumbnail.
     * @see #getThumbnailWidth() 
     * @see #getThumbnailHeight() 
     * @see #getThumbnailSize(java.awt.Dimension) 
     * @see #getThumbnailBounds() 
     * @see #getThumbnailBounds(java.awt.Rectangle) 
     * @see #getScaleX() 
     * @see #getScaleY() 
     * @see #getThumbnailRegionWidth() 
     * @see #getThumbnailRegionHeight() 
     * @see #getThumbnailRegionSize() 
     * @see #getThumbnailRegionSize(java.awt.Dimension) 
     * @see #getIcon() 
     * @see #setIcon(javax.swing.Icon) 
     * @see #getImage() 
     * @see #setImage(java.awt.Image) 
     * @see #getImageWidth() 
     * @see #getImageHeight() 
     * @see #getImageSize() 
     * @see #getImageSize(java.awt.Dimension) 
     * @see #getThumbnailBorder() 
     * @see #setThumbnailBorder(javax.swing.border.Border) 
     * @see #getThumbnailInsets() 
     * @see #getThumbnailInsets(java.awt.Insets) 
     * @see #getImageScaleMode() 
     * @see #setImageScaleMode(int) 
     * @see #isAspectRatioMaintained() 
     * @see #setAspectRatioMaintained(boolean) 
     * @see #isImageAlwaysScaled() 
     * @see #setImageAlwaysScaled(boolean) 
     * @see #getWidth() 
     * @see #getHeight() 
     * @see #getSize() 
     * @see #getSize(java.awt.Dimension) 
     */
    public Dimension getThumbnailSize(){
        return getThumbnailSize(null);
    }
    /**
     * This returns the x coordinate for the thumbnail within the thumbnail 
     * region. That is to say, this returns the x coordinate of the top-left 
     * corner of the thumbnail of the currently set image or icon relative to 
     * the origin of the area in which the thumbnail is painted in. To get the 
     * x coordinate for the thumbnail relative to the label's origin, add {@link 
     * #getThumbnailRegionX()} to the returned value.
     * @return The x coordinate for the top-left corner of the thumbnail, or -1 
     * if no icon is set.
     * @see #getThumbnailY() 
     * @see #getThumbnailLocation() 
     * @see #getThumbnailLocation(java.awt.Point) 
     * @see #getThumbnailBounds() 
     * @see #getThumbnailBounds(java.awt.Rectangle) 
     * @see #getThumbnailRegionX() 
     * @see #getThumbnailRegionLocation() 
     * @see #getThumbnailRegionLocation(java.awt.Point) 
     * @see #getIcon() 
     * @see #setIcon(javax.swing.Icon) 
     * @see #getImage() 
     * @see #setImage(java.awt.Image) 
     * @see #getThumbnailBorder() 
     * @see #setThumbnailBorder(javax.swing.border.Border) 
     * @see #getThumbnailInsets() 
     * @see #getThumbnailInsets(java.awt.Insets) 
     */
    public int getThumbnailX(){
        if (!isIconSet())    // If no icon has been set
            return -1;
            // If we are currently painting the thumbnail and the thumbnail 
            // bounds is not null
        else if (isPaintingThumbnail() && thumbnailBounds != null)
            return thumbnailBounds.x;
        Insets in = getThumbnailInsets();   // Get the thumbnail insets
            // If the thumbnail insets is not null, return the left inset. 
        return (in != null) ? in.left : 0;  // Otherwise, return zero
    }
    /**
     * This returns the y coordinate for the thumbnail within the thumbnail 
     * region. That is to say, this returns the y coordinate of the top-left 
     * corner of the thumbnail of the currently set image or icon relative to 
     * the origin of the area in which the thumbnail is painted in. To get the 
     * y coordinate for the thumbnail relative to the label's origin, add {@link 
     * #getThumbnailRegionY()} to the returned value.
     * @return The y coordinate for the top-left corner of the thumbnail, or -1 
     * if no icon is set.
     * @see #getThumbnailX() 
     * @see #getThumbnailLocation() 
     * @see #getThumbnailLocation(java.awt.Point) 
     * @see #getThumbnailBounds() 
     * @see #getThumbnailBounds(java.awt.Rectangle) 
     * @see #getThumbnailRegionY() 
     * @see #getThumbnailRegionLocation() 
     * @see #getThumbnailRegionLocation(java.awt.Point) 
     * @see #getIcon() 
     * @see #setIcon(javax.swing.Icon) 
     * @see #getImage() 
     * @see #setImage(java.awt.Image) 
     * @see #getThumbnailBorder() 
     * @see #setThumbnailBorder(javax.swing.border.Border) 
     * @see #getThumbnailInsets() 
     * @see #getThumbnailInsets(java.awt.Insets) 
     */
    public int getThumbnailY(){
        if (!isIconSet())    // If no icon has been set
            return -1;
            // If we are currently painting the thumbnail and the thumbnail 
            // bounds is not null
        else if (isPaintingThumbnail() && thumbnailBounds != null)
            return thumbnailBounds.y;
        Insets in = getThumbnailInsets();   // Get the thumbnail insets
            // If the thumbnail insets is not null, return the top inset. 
        return (in != null) ? in.top : 0;   // Otherwise, return zero
    }
    /**
     * This stores the x and y coordinates for the top-left corner of the 
     * thumbnail into the given Point object. The location will be relative to 
     * the origin of the thumbnail region. If the given Point object is null, 
     * then a new Point object will be returned. This version is useful as to 
     * avoid creating a new Point object.
     * @param point The Point object to return with the origin of the thumbnail, 
     * if an image or icon is set, or null.
     * @return The Point object holding the origin of the thumbnail.
     * @see #getThumbnailX() 
     * @see #getThumbnailY() 
     * @see #getThumbnailLocation() 
     * @see #getThumbnailBounds() 
     * @see #getThumbnailBounds(java.awt.Rectangle) 
     * @see #getThumbnailRegionX() 
     * @see #getThumbnailRegionY() 
     * @see #getThumbnailRegionLocation() 
     * @see #getThumbnailRegionLocation(java.awt.Point) 
     * @see #getIcon() 
     * @see #setIcon(javax.swing.Icon) 
     * @see #getImage() 
     * @see #setImage(java.awt.Image) 
     * @see #getThumbnailBorder() 
     * @see #setThumbnailBorder(javax.swing.border.Border) 
     * @see #getThumbnailInsets() 
     * @see #getThumbnailInsets(java.awt.Insets) 
     */
    public Point getThumbnailLocation(Point point){
        if (point == null)    // If the point object is null
            return new Point(getThumbnailX(),getThumbnailY());
        point.setLocation(getThumbnailX(),getThumbnailY());
        return point;
    }
    /**
     * This returns a Point object containing the x and y coordinates for the 
     * top-left corner of the thumbnail of the currently set image or icon. The 
     * location will be relative to the origin of the thumbnail region.
     * @return The Point object holding the origin of the thumbnail.
     * @see #getThumbnailX() 
     * @see #getThumbnailY() 
     * @see #getThumbnailLocation(java.awt.Point) 
     * @see #getThumbnailBounds() 
     * @see #getThumbnailBounds(java.awt.Rectangle) 
     * @see #getThumbnailRegionX() 
     * @see #getThumbnailRegionY() 
     * @see #getThumbnailRegionLocation() 
     * @see #getThumbnailRegionLocation(java.awt.Point) 
     * @see #getIcon() 
     * @see #setIcon(javax.swing.Icon) 
     * @see #getImage() 
     * @see #setImage(java.awt.Image) 
     * @see #getThumbnailBorder() 
     * @see #setThumbnailBorder(javax.swing.border.Border) 
     * @see #getThumbnailInsets() 
     * @see #getThumbnailInsets(java.awt.Insets) 
     */
    public Point getThumbnailLocation(){
        return getThumbnailLocation(null);
    }
    /**
     * This stores the bounds for the thumbnail into the given Rectangle object. 
     * The bounds for the thumbnail specify the thumbnail's width, height, and 
     * location relative to the origin of the thumbnail region. If the given 
     * Rectangle object is null, then a new Rectangle object will be returned. 
     * This version is useful as to avoid creating a new Rectangle object.
     * @param rect The Rectangle object to return with the bounds of the 
     * thumbnail, if an image or icon is set, or null.
     * @return The Rectangle object holding the bounds of the thumbnail.
     * @see #getThumbnailWidth() 
     * @see #getThumbnailHeight() 
     * @see #getThumbnailSize() 
     * @see #getThumbnailSize(java.awt.Dimension) 
     * @see #getThumbnailX() 
     * @see #getThumbnailY() 
     * @see #getThumbnailLocation() 
     * @see #getThumbnailLocation(java.awt.Point) 
     * @see #getThumbnailBounds() 
     * @see #getScaleX() 
     * @see #getScaleY() 
     * @see #getThumbnailRegionWidth() 
     * @see #getThumbnailRegionHeight() 
     * @see #getThumbnailRegionSize() 
     * @see #getThumbnailRegionSize(java.awt.Dimension) 
     * @see #getThumbnailRegionX() 
     * @see #getThumbnailRegionY() 
     * @see #getThumbnailRegionLocation() 
     * @see #getThumbnailRegionLocation(java.awt.Point) 
     * @see #getThumbnailRegionBounds() 
     * @see #getThumbnailRegionBounds(java.awt.Rectangle) 
     * @see #getIcon() 
     * @see #setIcon(javax.swing.Icon) 
     * @see #getImage() 
     * @see #setImage(java.awt.Image) 
     * @see #getImageWidth() 
     * @see #getImageHeight() 
     * @see #getImageSize() 
     * @see #getImageSize(java.awt.Dimension) 
     * @see #getThumbnailBorder() 
     * @see #setThumbnailBorder(javax.swing.border.Border) 
     * @see #getThumbnailInsets() 
     * @see #getThumbnailInsets(java.awt.Insets) 
     * @see #getImageScaleMode() 
     * @see #setImageScaleMode(int) 
     * @see #isAspectRatioMaintained() 
     * @see #setAspectRatioMaintained(boolean) 
     * @see #isImageAlwaysScaled() 
     * @see #setImageAlwaysScaled(boolean) 
     * @see #getWidth() 
     * @see #getHeight() 
     * @see #getSize() 
     * @see #getSize(java.awt.Dimension) 
     */
    public Rectangle getThumbnailBounds(Rectangle rect){
        if (rect == null)    // If the rectangle object is null
            rect = new Rectangle();
        rect.setLocation(getThumbnailX(),getThumbnailY());
        rect.setSize(getThumbnailWidth(),getThumbnailHeight());
        return rect;
    }
    /**
     * This returns a Rectangle object containing the bounds for the thumbnail 
     * of the currently set image or icon. The bounds for the thumbnail specify 
     * the thumbnail's width, height, and location relative to the origin of the 
     * thumbnail region.
     * @return The Rectangle object holding the bounds of the thumbnail.
     * @see #getThumbnailWidth() 
     * @see #getThumbnailHeight() 
     * @see #getThumbnailSize() 
     * @see #getThumbnailSize(java.awt.Dimension) 
     * @see #getThumbnailX() 
     * @see #getThumbnailY() 
     * @see #getThumbnailLocation() 
     * @see #getThumbnailLocation(java.awt.Point) 
     * @see #getThumbnailBounds(java.awt.Rectangle) 
     * @see #getScaleX() 
     * @see #getScaleY() 
     * @see #getThumbnailRegionWidth() 
     * @see #getThumbnailRegionHeight() 
     * @see #getThumbnailRegionSize() 
     * @see #getThumbnailRegionSize(java.awt.Dimension) 
     * @see #getThumbnailRegionX() 
     * @see #getThumbnailRegionY() 
     * @see #getThumbnailRegionLocation() 
     * @see #getThumbnailRegionLocation(java.awt.Point) 
     * @see #getThumbnailRegionBounds() 
     * @see #getThumbnailRegionBounds(java.awt.Rectangle) 
     * @see #getIcon() 
     * @see #setIcon(javax.swing.Icon) 
     * @see #getImage() 
     * @see #setImage(java.awt.Image) 
     * @see #getImageWidth() 
     * @see #getImageHeight() 
     * @see #getImageSize() 
     * @see #getImageSize(java.awt.Dimension) 
     * @see #getThumbnailBorder() 
     * @see #setThumbnailBorder(javax.swing.border.Border) 
     * @see #getThumbnailInsets() 
     * @see #getThumbnailInsets(java.awt.Insets) 
     * @see #getImageScaleMode() 
     * @see #setImageScaleMode(int) 
     * @see #isAspectRatioMaintained() 
     * @see #setAspectRatioMaintained(boolean) 
     * @see #isImageAlwaysScaled() 
     * @see #setImageAlwaysScaled(boolean) 
     * @see #getWidth() 
     * @see #getHeight() 
     * @see #getSize() 
     * @see #getSize(java.awt.Dimension) 
     */
    public Rectangle getThumbnailBounds(){
        return getThumbnailBounds(null);
    }
    /**
     * This returns the width of the painted region containing the thumbnail, 
     * the thumbnail border, and the thumbnail overlay.
     * @return The width of the thumbnail region, or -1 if no icon is set.
     * @see #getThumbnailRegionHeight() 
     * @see #getThumbnailRegionSize() 
     * @see #getThumbnailRegionSize(java.awt.Dimension) 
     * @see #getThumbnailRegionBounds() 
     * @see #getThumbnailRegionBounds(java.awt.Rectangle) 
     * @see #getThumbnailWidth() 
     * @see #getThumbnailSize() 
     * @see #getThumbnailSize(java.awt.Dimension) 
     * @see #getScaleX() 
     * @see #getIcon() 
     * @see #setIcon(javax.swing.Icon) 
     * @see #getImage() 
     * @see #setImage(java.awt.Image) 
     * @see #getImageWidth() 
     * @see #getImageHeight() 
     * @see #getThumbnailBorder() 
     * @see #setThumbnailBorder(javax.swing.border.Border) 
     * @see #getThumbnailInsets() 
     * @see #getThumbnailInsets(java.awt.Insets) 
     * @see #getImageScaleMode() 
     * @see #setImageScaleMode(int) 
     * @see #isAspectRatioMaintained() 
     * @see #setAspectRatioMaintained(boolean) 
     * @see #isImageAlwaysScaled() 
     * @see #setImageAlwaysScaled(boolean) 
     * @see #getWidth() 
     */
    public int getThumbnailRegionWidth(){
        if (!isIconSet())    // If no icon has been set
            return -1;
            // If we are currently painting the thumbnail and the icon bounds is 
        else if (isPaintingThumbnail() && iconBounds != null)    // not null
            return iconBounds.width;
        int width = getThumbnailWidth();    // Get the thumbnail width
        Insets in = getThumbnailInsets();   // Get the thumbnail insets
            // If either the thumbnail width is less than or equal to zero or 
        if (width <= 0 || in == null)      // the thumbnail insets is null
            return width;
        return width + in.left + in.right;
    }
    /**
     * This returns the height of the painted region containing the thumbnail, 
     * the thumbnail border, and the thumbnail overlay.
     * @return The height of the thumbnail region, or -1 if no icon is set.
     * @see #getThumbnailRegionWidth() 
     * @see #getThumbnailRegionSize() 
     * @see #getThumbnailRegionSize(java.awt.Dimension) 
     * @see #getThumbnailRegionBounds() 
     * @see #getThumbnailRegionBounds(java.awt.Rectangle) 
     * @see #getThumbnailHeight() 
     * @see #getThumbnailSize() 
     * @see #getThumbnailSize(java.awt.Dimension) 
     * @see #getScaleY() 
     * @see #getIcon() 
     * @see #setIcon(javax.swing.Icon) 
     * @see #getImage() 
     * @see #setImage(java.awt.Image) 
     * @see #getImageWidth() 
     * @see #getImageHeight() 
     * @see #getThumbnailBorder() 
     * @see #setThumbnailBorder(javax.swing.border.Border) 
     * @see #getThumbnailInsets() 
     * @see #getThumbnailInsets(java.awt.Insets) 
     * @see #getImageScaleMode() 
     * @see #setImageScaleMode(int) 
     * @see #isAspectRatioMaintained() 
     * @see #setAspectRatioMaintained(boolean) 
     * @see #isImageAlwaysScaled() 
     * @see #setImageAlwaysScaled(boolean) 
     * @see #getHeight() 
     */
    public int getThumbnailRegionHeight(){
        if (!isIconSet())    // If no icon has been set
            return -1;
            // If we are currently painting the thumbnail and the icon bounds is 
        else if (isPaintingThumbnail() && iconBounds != null)    // not null
            return iconBounds.height;
        int height = getThumbnailHeight();  // Get the thumbnail height
        Insets in = getThumbnailInsets();   // Get the thumbnail insets
            // If either the thumbnail height is less than or equal to zero or 
        if (height <= 0 || in == null)      // the thumbnail insets is null
            return height;
        return height + in.top + in.bottom;
    }
    /**
     * This stores the width and height of the thumbnail region into the given 
     * Dimension object. If the given Dimension object is null, then a new 
     * Dimension object will be returned. This version is useful as to avoid 
     * creating a new Dimension object.
     * @param dim The Dimension object to return with the dimensions of the 
     * thumbnail region, if an image or icon is set, or null.
     * @return The Dimension object holding the dimensions of the thumbnail 
     * region.
     * @see #getThumbnailRegionWidth() 
     * @see #getThumbnailRegionHeight() 
     * @see #getThumbnailRegionSize() 
     * @see #getThumbnailRegionBounds() 
     * @see #getThumbnailRegionBounds(java.awt.Rectangle) 
     * @see #getThumbnailWidth() 
     * @see #getThumbnailHeight() 
     * @see #getThumbnailSize() 
     * @see #getThumbnailSize(java.awt.Dimension) 
     * @see #getScaleX() 
     * @see #getScaleY() 
     * @see #getIcon() 
     * @see #setIcon(javax.swing.Icon) 
     * @see #getImage() 
     * @see #setImage(java.awt.Image) 
     * @see #getImageWidth() 
     * @see #getImageHeight() 
     * @see #getImageSize() 
     * @see #getImageSize(java.awt.Dimension) 
     * @see #getThumbnailBorder() 
     * @see #setThumbnailBorder(javax.swing.border.Border) 
     * @see #getThumbnailInsets() 
     * @see #getThumbnailInsets(java.awt.Insets) 
     * @see #getImageScaleMode() 
     * @see #setImageScaleMode(int) 
     * @see #isAspectRatioMaintained() 
     * @see #setAspectRatioMaintained(boolean) 
     * @see #isImageAlwaysScaled() 
     * @see #setImageAlwaysScaled(boolean) 
     * @see #getWidth() 
     * @see #getHeight() 
     * @see #getSize() 
     * @see #getSize(java.awt.Dimension) 
     */
    public Dimension getThumbnailRegionSize(Dimension dim){
        if (dim == null)    // If the dimension object is null
            return new Dimension(getThumbnailRegionWidth(),getThumbnailRegionHeight());
        dim.setSize(getThumbnailRegionWidth(),getThumbnailRegionHeight());
        return dim;
    }
    /**
     * This returns a Dimension object containing the width and height of the 
     * painted region containing the thumbnail, the thumbnail border, and the 
     * thumbnail overlay.
     * @return The Dimension object holding the dimensions of the thumbnail 
     * region.
     * @see #getThumbnailRegionWidth() 
     * @see #getThumbnailRegionHeight() 
     * @see #getThumbnailRegionSize(java.awt.Dimension) 
     * @see #getThumbnailRegionBounds() 
     * @see #getThumbnailRegionBounds(java.awt.Rectangle) 
     * @see #getThumbnailWidth() 
     * @see #getThumbnailHeight() 
     * @see #getThumbnailSize() 
     * @see #getThumbnailSize(java.awt.Dimension) 
     * @see #getScaleX() 
     * @see #getScaleY() 
     * @see #getIcon() 
     * @see #setIcon(javax.swing.Icon) 
     * @see #getImage() 
     * @see #setImage(java.awt.Image) 
     * @see #getImageWidth() 
     * @see #getImageHeight() 
     * @see #getImageSize() 
     * @see #getImageSize(java.awt.Dimension) 
     * @see #getThumbnailBorder() 
     * @see #setThumbnailBorder(javax.swing.border.Border) 
     * @see #getThumbnailInsets() 
     * @see #getThumbnailInsets(java.awt.Insets) 
     * @see #getImageScaleMode() 
     * @see #setImageScaleMode(int) 
     * @see #isAspectRatioMaintained() 
     * @see #setAspectRatioMaintained(boolean) 
     * @see #isImageAlwaysScaled() 
     * @see #setImageAlwaysScaled(boolean) 
     * @see #getWidth() 
     * @see #getHeight() 
     * @see #getSize() 
     * @see #getSize(java.awt.Dimension) 
     */
    public Dimension getThumbnailRegionSize(){
        return getThumbnailRegionSize(null);
    }
    /**
     * This returns the x coordinate for the painted region containing the 
     * thumbnail, the thumbnail border, and the thumbnail overlay. That is to 
     * say, this returns the x coordinate of the top-left corner of the 
     * thumbnail region relative to the coordinate space of this label.
     * @return The x coordinate for the top-left corner of the thumbnail region, 
     * or -1 if no icon is set.
     * @see #getThumbnailRegionY() 
     * @see #getThumbnailRegionLocation() 
     * @see #getThumbnailRegionLocation(java.awt.Point) 
     * @see #getThumbnailRegionBounds() 
     * @see #getThumbnailRegionBounds(java.awt.Rectangle) 
     * @see #getThumbnailX() 
     * @see #getThumbnailLocation() 
     * @see #getThumbnailLocation(java.awt.Point) 
     * @see #getIcon() 
     * @see #setIcon(javax.swing.Icon) 
     * @see #getImage() 
     * @see #setImage(java.awt.Image) 
     * @see #getThumbnailBorder() 
     * @see #setThumbnailBorder(javax.swing.border.Border) 
     * @see #getThumbnailInsets() 
     * @see #getThumbnailInsets(java.awt.Insets) 
     */
    public int getThumbnailRegionX(){
        if (!isIconSet())    // If no icon has been set
            return -1;
            // If we are currently painting the thumbnail and the icon bounds is 
        else if (isPaintingThumbnail() && iconBounds != null)    // not null
            return iconBounds.x;
        return calculateThumbnailRectangle().x;
    }
    /**
     * This returns the y coordinate for the painted region containing the 
     * thumbnail, the thumbnail border, and the thumbnail overlay. That is to 
     * say, this returns the y coordinate of the top-left corner of the 
     * thumbnail region relative to the coordinate space of this label.
     * @return The y coordinate for the top-left corner of the thumbnail region, 
     * or -1 if no icon is set.
     * @see #getThumbnailRegionX() 
     * @see #getThumbnailRegionLocation() 
     * @see #getThumbnailRegionLocation(java.awt.Point) 
     * @see #getThumbnailRegionBounds() 
     * @see #getThumbnailRegionBounds(java.awt.Rectangle) 
     * @see #getThumbnailY() 
     * @see #getThumbnailLocation() 
     * @see #getThumbnailLocation(java.awt.Point) 
     * @see #getIcon() 
     * @see #setIcon(javax.swing.Icon) 
     * @see #getImage() 
     * @see #setImage(java.awt.Image) 
     * @see #getThumbnailBorder() 
     * @see #setThumbnailBorder(javax.swing.border.Border) 
     * @see #getThumbnailInsets() 
     * @see #getThumbnailInsets(java.awt.Insets) 
     */
    public int getThumbnailRegionY(){
        if (!isIconSet())    // If no icon has been set
            return -1;
            // If we are currently painting the thumbnail and the icon bounds is 
        else if (isPaintingThumbnail() && iconBounds != null)    // not null
            return iconBounds.y;
        return calculateThumbnailRectangle().y;
    }
    /**
     * This stores the x and y coordinates for the top-left corner of the 
     * thumbnail region into the given Point object. The location will be 
     * relative to the coordinate space of this label. If the given Point object 
     * is null, then a new Point object will be returned. This version is useful 
     * as to avoid creating a new Point object.
     * @param point The Point object to return with the origin of the thumbnail 
     * region, if an image or icon is set, or null.
     * @return The Point object holding the origin of the thumbnail region.
     * @see #getThumbnailRegionX() 
     * @see #getThumbnailRegionY() 
     * @see #getThumbnailRegionLocation() 
     * @see #getThumbnailRegionBounds() 
     * @see #getThumbnailRegionBounds(java.awt.Rectangle) 
     * @see #getThumbnailX() 
     * @see #getThumbnailY() 
     * @see #getThumbnailLocation() 
     * @see #getThumbnailLocation(java.awt.Point) 
     * @see #getIcon() 
     * @see #setIcon(javax.swing.Icon) 
     * @see #getImage() 
     * @see #setImage(java.awt.Image) 
     * @see #getThumbnailBorder() 
     * @see #setThumbnailBorder(javax.swing.border.Border) 
     * @see #getThumbnailInsets() 
     * @see #getThumbnailInsets(java.awt.Insets) 
     */
    public Point getThumbnailRegionLocation(Point point){
        if (point == null)    // If the point object is null
            return new Point(getThumbnailRegionX(),getThumbnailRegionY());
        point.setLocation(getThumbnailRegionX(), getThumbnailRegionY());
        return point;
    }
    /**
     * This returns a Point object containing the x and y coordinates for the 
     * top-left corner of the painted region containing the thumbnail, the 
     * thumbnail border, and the thumbnail overlay. The location will be 
     * relative to the coordinate space of this label.
     * @return The Point object holding the origin of the thumbnail region.
     * @see #getThumbnailRegionX() 
     * @see #getThumbnailRegionY() 
     * @see #getThumbnailRegionLocation(java.awt.Point) 
     * @see #getThumbnailRegionBounds() 
     * @see #getThumbnailRegionBounds(java.awt.Rectangle) 
     * @see #getThumbnailX() 
     * @see #getThumbnailY() 
     * @see #getThumbnailLocation() 
     * @see #getThumbnailLocation(java.awt.Point) 
     * @see #getIcon() 
     * @see #setIcon(javax.swing.Icon) 
     * @see #getImage() 
     * @see #setImage(java.awt.Image) 
     * @see #getThumbnailBorder() 
     * @see #setThumbnailBorder(javax.swing.border.Border) 
     * @see #getThumbnailInsets() 
     * @see #getThumbnailInsets(java.awt.Insets) 
     */
    public Point getThumbnailRegionLocation(){
        return getThumbnailRegionLocation(null);
    }
    /**
     * This stores the bounds for the thumbnail region into the given Rectangle 
     * object. The bounds for the thumbnail region specify the width, height, 
     * and location of the painted region containing the thumbnail, the 
     * thumbnail border, and the thumbnail overlay. If the given Rectangle 
     * object is null, then a new Rectangle object will be returned. This 
     * version is useful as to avoid creating a new Rectangle object.
     * @param rect The Rectangle object to return with the bounds of the 
     * thumbnail region, if an image or icon is set, or null.
     * @return The Rectangle object holding the bounds of the thumbnail region.
     * @see #getThumbnailRegionWidth() 
     * @see #getThumbnailRegionHeight() 
     * @see #getThumbnailRegionSize() 
     * @see #getThumbnailRegionSize(java.awt.Dimension) 
     * @see #getThumbnailRegionX() 
     * @see #getThumbnailRegionY() 
     * @see #getThumbnailRegionLocation() 
     * @see #getThumbnailRegionLocation(java.awt.Point) 
     * @see #getThumbnailRegionBounds() 
     * @see #getScaleX() 
     * @see #getScaleY() 
     * @see #getThumbnailWidth() 
     * @see #getThumbnailHeight() 
     * @see #getThumbnailSize() 
     * @see #getThumbnailSize(java.awt.Dimension) 
     * @see #getThumbnailX() 
     * @see #getThumbnailY() 
     * @see #getThumbnailLocation() 
     * @see #getThumbnailLocation(java.awt.Point) 
     * @see #getThumbnailBounds() 
     * @see #getThumbnailBounds(java.awt.Rectangle) 
     * @see #getIcon() 
     * @see #setIcon(javax.swing.Icon) 
     * @see #getImage() 
     * @see #setImage(java.awt.Image) 
     * @see #getImageWidth() 
     * @see #getImageHeight() 
     * @see #getImageSize() 
     * @see #getImageSize(java.awt.Dimension) 
     * @see #getThumbnailBorder() 
     * @see #setThumbnailBorder(javax.swing.border.Border) 
     * @see #getThumbnailInsets() 
     * @see #getThumbnailInsets(java.awt.Insets) 
     * @see #getImageScaleMode() 
     * @see #setImageScaleMode(int) 
     * @see #isAspectRatioMaintained() 
     * @see #setAspectRatioMaintained(boolean) 
     * @see #isImageAlwaysScaled() 
     * @see #setImageAlwaysScaled(boolean) 
     * @see #getWidth() 
     * @see #getHeight() 
     * @see #getSize() 
     * @see #getSize(java.awt.Dimension) 
     */
    public Rectangle getThumbnailRegionBounds(Rectangle rect){
        if (rect == null)    // If the rectangle object is null
            rect = new Rectangle();
        rect.setLocation(getThumbnailRegionX(),getThumbnailRegionY());
        rect.setSize(getThumbnailRegionWidth(),getThumbnailRegionHeight());
        return rect;
    }
    /**
     * This returns a Rectangle object containing the bounds for the thumbnail 
     * region. The bounds for the thumbnail region specify the width, height, 
     * and location of the painted region containing the thumbnail, the 
     * thumbnail border, and the thumbnail overlay.
     * @return The Rectangle object holding the bounds of the thumbnail region.
     * @see #getThumbnailRegionWidth() 
     * @see #getThumbnailRegionHeight() 
     * @see #getThumbnailRegionSize() 
     * @see #getThumbnailRegionSize(java.awt.Dimension) 
     * @see #getThumbnailRegionX() 
     * @see #getThumbnailRegionY() 
     * @see #getThumbnailRegionLocation() 
     * @see #getThumbnailRegionLocation(java.awt.Point) 
     * @see #getThumbnailRegionBounds(java.awt.Rectangle) 
     * @see #getScaleX() 
     * @see #getScaleY() 
     * @see #getThumbnailWidth() 
     * @see #getThumbnailHeight() 
     * @see #getThumbnailSize() 
     * @see #getThumbnailSize(java.awt.Dimension) 
     * @see #getThumbnailX() 
     * @see #getThumbnailY() 
     * @see #getThumbnailLocation() 
     * @see #getThumbnailLocation(java.awt.Point) 
     * @see #getThumbnailBounds() 
     * @see #getThumbnailBounds(java.awt.Rectangle) 
     * @see #getIcon() 
     * @see #setIcon(javax.swing.Icon) 
     * @see #getImage() 
     * @see #setImage(java.awt.Image) 
     * @see #getImageWidth() 
     * @see #getImageHeight() 
     * @see #getImageSize() 
     * @see #getImageSize(java.awt.Dimension) 
     * @see #getThumbnailBorder() 
     * @see #setThumbnailBorder(javax.swing.border.Border) 
     * @see #getThumbnailInsets() 
     * @see #getThumbnailInsets(java.awt.Insets) 
     * @see #getImageScaleMode() 
     * @see #setImageScaleMode(int) 
     * @see #isAspectRatioMaintained() 
     * @see #setAspectRatioMaintained(boolean) 
     * @see #isImageAlwaysScaled() 
     * @see #setImageAlwaysScaled(boolean) 
     * @see #getWidth() 
     * @see #getHeight() 
     * @see #getSize() 
     * @see #getSize(java.awt.Dimension) 
     */
    public Rectangle getThumbnailRegionBounds(){
        return getThumbnailRegionBounds(null);
    }
    /**
     * This checks to see if the thumbnail region contains the given (x, y) 
     * coordinates, relative to this label's coordinate space.
     * @param x The x coordinate to check.
     * @param y The y coordinate to check.
     * @return Whether the thumbnail region contains the given coordinates.
     * @see #thumbnailContains(java.awt.Point) 
     * @see #contains(int, int) 
     * @see #getThumbnailRegionX() 
     * @see #getThumbnailRegionY() 
     * @see #getThumbnailRegionWidth() 
     * @see #getThumbnailRegionHeight() 
     * @see #getThumbnailRegionBounds() 
     * @see #getThumbnailRegionBounds(java.awt.Rectangle) 
     * @see Rectangle#contains(int, int) 
     */
    public boolean thumbnailContains(int x, int y){
            // If this has an icon set and the x and y are contained within this 
        if (isIconSet() && contains(x, y)){  // label
                // If we aren't painting the thumbnail or the icon bounds is 
                // null (this is to hopefully avoid unnecessarily setting the 
                // contents of iconBounds to itself)
            if (!isPaintingThumbnail() || iconBounds == null)
                    // iconBounds should not be in use right now, and even if it 
                    // was, its purpose is to store the bounds of the thumbnail 
                iconBounds = getThumbnailRegionBounds(iconBounds);  // icon
            return iconBounds.contains(x, y);
        }
        return false;
    }
    /**
     * This checks to see if the thumbnail region contains the given Point, 
     * relative to this label's coordinate space.
     * @param point The Point to check for (cannot be null).
     * @return Whether the thumbnail region contains the given Point.
     * @throws NullPointerException If the given Point is null.
     * @see #thumbnailContains(int, int) 
     * @see #contains(java.awt.Point) 
     * @see #getThumbnailRegionX() 
     * @see #getThumbnailRegionY() 
     * @see #getThumbnailRegionWidth() 
     * @see #getThumbnailRegionHeight() 
     * @see #getThumbnailRegionBounds() 
     * @see #getThumbnailRegionBounds(java.awt.Rectangle) 
     * @see Rectangle#contains(java.awt.Point) 
     */
    public boolean thumbnailContains(Point point){
        if (point == null)    // If the point object is null
            throw new NullPointerException("The Point to check cannot be null");
        return thumbnailContains(point.x,point.y);
    }
    /**
     * This converts the given point (x, y) in this label's coordinate system 
     * into the thumbnail region's coordinate system.
     * @param x The x coordinate of the point.
     * @param y The y coordinate of the point.
     * @return The converted point, now in the thumbnail region's coordinate 
     * system.
     * @see #convertPointToThumbnailRegion(java.awt.Point) 
     * @see #convertRectangleToThumbnailRegion(java.awt.Rectangle) 
     * @see #convertPointFromThumbnailRegion(int, int) 
     * @see #convertPointFromThumbnailRegion(java.awt.Point) 
     * @see #convertRectangleFromThumbnailRegion(java.awt.Rectangle) 
     * @see #getThumbnailRegionX() 
     * @see #getThumbnailRegionY() 
     * @see #getThumbnailRegionLocation() 
     * @see #getThumbnailRegionLocation(java.awt.Point) 
     */
    public Point convertPointToThumbnailRegion(int x, int y){
        return new Point(x-getThumbnailRegionX(),y-getThumbnailRegionY());
    }
    /**
     * This converts the given point in this label's coordinate system into the 
     * thumbnail region's coordinate system.
     * @param point The point to convert (cannot be null).
     * @return The converted point, now in the thumbnail region's coordinate 
     * system.
     * @throws NullPointerException If the given Point is null.
     * @see #convertPointToThumbnailRegion(int, int) 
     * @see #convertRectangleToThumbnailRegion(java.awt.Rectangle) 
     * @see #convertPointFromThumbnailRegion(int, int) 
     * @see #convertPointFromThumbnailRegion(java.awt.Point) 
     * @see #convertRectangleFromThumbnailRegion(java.awt.Rectangle) 
     * @see #getThumbnailRegionX() 
     * @see #getThumbnailRegionY() 
     * @see #getThumbnailRegionLocation() 
     * @see #getThumbnailRegionLocation(java.awt.Point) 
     */
    public Point convertPointToThumbnailRegion(Point point){
        if (point == null)    // If the point object is null
            throw new NullPointerException("The Point to convert cannot be null");
        return convertPointToThumbnailRegion(point.x,point.y);
    }
    /**
     * This converts the given rectangle in this label's coordinate system into 
     * the thumbnail region's coordinate system.
     * @param rect The rectangle to convert (cannot be null).
     * @return The converted rectangle, now in the thumbnail region's coordinate 
     * system.
     * @throws NullPointerException If the given Rectangle is null.
     * @see #convertPointToThumbnailRegion(int, int) 
     * @see #convertPointToThumbnailRegion(java.awt.Point) 
     * @see #convertPointFromThumbnailRegion(int, int) 
     * @see #convertPointFromThumbnailRegion(java.awt.Point) 
     * @see #convertRectangleFromThumbnailRegion(java.awt.Rectangle) 
     * @see #getThumbnailRegionX() 
     * @see #getThumbnailRegionY() 
     * @see #getThumbnailRegionLocation() 
     * @see #getThumbnailRegionLocation(java.awt.Point) 
     * @see #getThumbnailRegionBounds() 
     * @see #getThumbnailRegionBounds(java.awt.Rectangle) 
     */
    public Rectangle convertRectangleToThumbnailRegion(Rectangle rect){
        if (rect == null)    // If the rectangle object is null
            throw new NullPointerException("The Rectangle to convert cannot be null");
        return new Rectangle(convertPointToThumbnailRegion(rect.getLocation()),rect.getSize());
    }
    /**
     * This converts the given point (x, y) in the thumbnail region's coordinate
     * system into this label's coordinate system.
     * @param x The x coordinate of the point.
     * @param y The y coordinate of the point.
     * @return The converted point, now in the label's coordinate system.
     * @see #convertPointFromThumbnailRegion(java.awt.Point) 
     * @see #convertRectangleFromThumbnailRegion(java.awt.Rectangle) 
     * @see #convertPointToThumbnailRegion(int, int) 
     * @see #convertPointToThumbnailRegion(java.awt.Point) 
     * @see #convertRectangleToThumbnailRegion(java.awt.Rectangle) 
     * @see #getThumbnailRegionX() 
     * @see #getThumbnailRegionY() 
     * @see #getThumbnailRegionLocation() 
     * @see #getThumbnailRegionLocation(java.awt.Point) 
     */
    public Point convertPointFromThumbnailRegion(int x, int y){
        return new Point(x+getThumbnailRegionX(),y+getThumbnailRegionY());
    }
    /**
     * This converts the given point in the thumbnail region's coordinate
     * system into this label's coordinate system.
     * @param point The point to convert (cannot be null).
     * @return The converted point, now in the label's coordinate system.
     * @throws NullPointerException If the given Point is null.
     * @see #convertPointFromThumbnailRegion(int, int) 
     * @see #convertRectangleFromThumbnailRegion(java.awt.Rectangle) 
     * @see #convertPointToThumbnailRegion(int, int) 
     * @see #convertPointToThumbnailRegion(java.awt.Point) 
     * @see #convertRectangleToThumbnailRegion(java.awt.Rectangle) 
     * @see #getThumbnailRegionX() 
     * @see #getThumbnailRegionY() 
     * @see #getThumbnailRegionLocation() 
     * @see #getThumbnailRegionLocation(java.awt.Point) 
     */
    public Point convertPointFromThumbnailRegion(Point point){
        if (point == null)    // If the point object is null
            throw new NullPointerException("The Point to convert cannot be null");
        return convertPointFromThumbnailRegion(point.x,point.y);
    }
    /**
     * This converts the given rectangle in the thumbnail region's coordinate
     * system into this label's coordinate system.
     * @param rect The rectangle to convert (cannot be null).
     * @return The converted rectangle, now in the label's coordinate system.
     * @throws NullPointerException If the given Rectangle is null.
     * @see #convertPointFromThumbnailRegion(int, int) 
     * @see #convertPointFromThumbnailRegion(java.awt.Point) 
     * @see #convertPointToThumbnailRegion(int, int) 
     * @see #convertPointToThumbnailRegion(java.awt.Point) 
     * @see #convertRectangleToThumbnailRegion(java.awt.Rectangle) 
     * @see #getThumbnailRegionX() 
     * @see #getThumbnailRegionY() 
     * @see #getThumbnailRegionLocation() 
     * @see #getThumbnailRegionLocation(java.awt.Point) 
     * @see #getThumbnailRegionBounds() 
     * @see #getThumbnailRegionBounds(java.awt.Rectangle) 
     */
    public Rectangle convertRectangleFromThumbnailRegion(Rectangle rect){
        if (rect == null)    // If the rectangle object is null
            throw new NullPointerException("The Rectangle to convert cannot be null");
        return new Rectangle(convertPointFromThumbnailRegion(rect.getLocation()),rect.getSize());
    }
    /**
     * This converts the given point in the label's coordinate system into the 
     * thumbnail region's coordinate space if it is not null and the thumbnail 
     * region contains the point. If either the point is null or not contained 
     * within the thumbnail region, then this returns null.
     * @param point The point to convert.
     * @return The converted point, or null if the given point is null or not 
     * within the thumbnail region.
     * @see #thumbnailContains(java.awt.Point) 
     * @see #convertPointToThumbnailRegion(java.awt.Point) 
     * @see #getMousePositionInThumbnailRegion() 
     * @see #getMousePositionInThumbnailRegion(boolean) 
     */
    private Point getPointInThumbnailOrNull(Point point){   
            // If either the point is null or not contained in the thumbnail 
        if (point == null || !thumbnailContains(point))     // region
            return null;
        return convertPointToThumbnailRegion(point);
    }
    /**
     * This returns the position of the mouse pointer in the thumbnail region's 
     * coordinate space if the thumbnail region is directly under the mouse 
     * pointer, otherwise returns null. <p>
     * This delegates to the {@link #getMousePosition()} method of this label, 
     * and converts the returned Point into the thumbnail region's coordinate 
     * space if the returned point is not null and is located within the the 
     * thumbnail region.
     * @return The mouse coordinates relative to the thumbnail region, or null.
     * @see #getMousePositionInThumbnailRegion(boolean) 
     * @see #getMousePosition() 
     * @see #thumbnailContains(java.awt.Point) 
     * @see #convertPointToThumbnailRegion(java.awt.Point) 
     */
    public Point getMousePositionInThumbnailRegion(){
        return getPointInThumbnailOrNull(getMousePosition());
    }
    /**
     * This returns the position of the mouse pointer in the thumbnail region's 
     * coordinate space if the thumbnail region is directly under the mouse 
     * pointer, otherwise returns null. This is similar to {@link 
     * #getMousePositionInThumbnailRegion()} in that it can take the label's 
     * children into account. If {@code allowChildren} is false, then this will 
     * return a non-null value only if the mouse pointer is directly over the 
     * thumbnail region of this label and not above any parts obscured by any 
     * child components. Otherwise, this will return a non-null value if the 
     * mouse pointer is above the thumbnail region regardless of whether it is 
     * directly above this label or any of its descendents. <p>
     * This delegates to the {@link #getMousePosition(boolean) 
     * getMousePosition(allowsChildren}} method of this label, and converts the 
     * returned Point into the thumbnail region's coordinate space if the 
     * returned point is not null and is located within the the thumbnail 
     * region.
     * @param allowChildren Whether child components should be taken into 
     * account.
     * @return The mouse coordinates relative to the thumbnail region, or null.
     * @see #getMousePositionInThumbnailRegion() 
     * @see #getMousePosition(boolean) 
     * @see #thumbnailContains(java.awt.Point) 
     * @see #convertPointToThumbnailRegion(java.awt.Point) 
     */
    public Point getMousePositionInThumbnailRegion(boolean allowChildren){
        return getPointInThumbnailOrNull(getMousePosition(allowChildren));
    }
    /**
     * This returns the value used to scale the width of the currently set image 
     * or icon into the thumbnail width. This is equivalent to dividing the 
     * {@link #getThumbnailWidth() thumbnail width} by the {@link 
     * #getImageWidth() image or icon width}.
     * @return The x-coordinate scaling factor, or zero if no icon is set.
     * @see #getScaleY() 
     * @see #scaleValueX(int) 
     * @see #scaleValueInverseX(int) 
     * @see #getThumbnailWidth() 
     * @see #getImageWidth() 
     * @see Icon#getIconWidth() 
     * @see #getIcon() 
     * @see #setIcon(javax.swing.Icon) 
     * @see #getImage() 
     * @see #setImage(java.awt.Image) 
     * @see #getThumbnailBorder() 
     * @see #setThumbnailBorder(javax.swing.border.Border) 
     * @see #getImageScaleMode() 
     * @see #setImageScaleMode(int) 
     * @see #isAspectRatioMaintained() 
     * @see #setAspectRatioMaintained(boolean) 
     * @see #isImageAlwaysScaled() 
     * @see #setImageAlwaysScaled(boolean) 
     */
    public double getScaleX(){
        return getScale(getThumbnailWidth(),getImageWidth());
    }
    /**
     * This returns the value used to scale the height of the currently set 
     * image or icon into the thumbnail height. This is equivalent to dividing 
     * the {@link #getThumbnailHeight() thumbnail height} by the {@link 
     * #getImageHeight() image or icon height}.
     * @return The y-coordinate scaling factor, or zero if no icon is set.
     * @see #getScaleX() 
     * @see #scaleValueY(int) 
     * @see #scaleValueInverseY(int) 
     * @see #getThumbnailHeight() 
     * @see #getImageHeight() 
     * @see Icon#getIconHeight() 
     * @see #getIcon() 
     * @see #setIcon(javax.swing.Icon) 
     * @see #getImage() 
     * @see #setImage(java.awt.Image) 
     * @see #getThumbnailBorder() 
     * @see #setThumbnailBorder(javax.swing.border.Border) 
     * @see #getImageScaleMode() 
     * @see #setImageScaleMode(int) 
     * @see #isAspectRatioMaintained() 
     * @see #setAspectRatioMaintained(boolean) 
     * @see #isImageAlwaysScaled() 
     * @see #setImageAlwaysScaled(boolean) 
     */
    public double getScaleY(){
        return getScale(getThumbnailHeight(),getImageHeight());
    }
    /**
     * This scales the given value based off the {@link #getScaleX() 
     * x-coordinate scaling factor}. 
     * @param value The value to scale.
     * @return The scaled value, rounded to the nearest integer, or zero if no 
     * icon is set.
     * @see #getScaleX() 
     * @see #scaleValueInverseX(int) 
     * @see #scaleValueY(int) 
     * @see #getIcon() 
     * @see #setIcon(javax.swing.Icon) 
     */
    public int scaleValueX(int value){
        return scaleValue(value,getScaleX());
    }
    /**
     * This scales the given value based off the {@link #getScaleY() 
     * y-coordinate scaling factor}. 
     * @param value The value to scale.
     * @return The scaled value, rounded to the nearest integer, or zero if no 
     * icon is set.
     * @see #getScaleY() 
     * @see #scaleValueInverseY(int) 
     * @see #scaleValueX(int) 
     * @see #getIcon() 
     * @see #setIcon(javax.swing.Icon) 
     */
    public int scaleValueY(int value){
        return scaleValue(value,getScaleY());
    }
    /**
     * This scales the given value based off the reciprocal of the {@link 
     * #getScaleX() x-coordinate scaling factor}. 
     * @param value The value to scale.
     * @return The scaled value, rounded to the nearest integer, or zero if no 
     * icon is set.
     * @see #getScaleX() 
     * @see #scaleValueX(int) 
     * @see #scaleValueInverseY(int) 
     * @see #getIcon() 
     * @see #setIcon(javax.swing.Icon) 
     */
    public int scaleValueInverseX(int value){
        return inverseScaleValue(value,getScaleX());
    }
    /**
     * This scales the given value based off the reciprocal of the {@link 
     * #getScaleY() y-coordinate scaling factor}. 
     * @param value The value to scale.
     * @return The scaled value, rounded to the nearest integer, or zero if no 
     * icon is set.
     * @see #getScaleY() 
     * @see #scaleValueY(int) 
     * @see #scaleValueInverseX(int) 
     * @see #getIcon() 
     * @see #setIcon(javax.swing.Icon) 
     */
    public int scaleValueInverseY(int value){
        return inverseScaleValue(value,getScaleY());
    }
    /**
     * This converts the given point (x, y) in the thumbnail region's coordinate 
     * space into the currently set image or icon's coordinate space.
     * @param x The x coordinate of the point.
     * @param y The y coordinate of the point.
     * @return The converted point, now in the icon's coordinate system.
     * @see #convertPointToImage(java.awt.Point) 
     * @see #convertDimensionToImage(int, int) 
     * @see #convertDimensionToImage(java.awt.Dimension) 
     * @see #convertRectangleToImage(int, int, int, int) 
     * @see #convertRectangleToImage(java.awt.Rectangle) 
     * @see #convertPointFromImage(int, int) 
     * @see #convertPointFromImage(java.awt.Point) 
     * @see #convertDimensionFromImage(int, int) 
     * @see #convertDimensionFromImage(java.awt.Dimension) 
     * @see #convertRectangleFromImage(int, int, int, int) 
     * @see #convertRectangleFromImage(java.awt.Rectangle) 
     * @see #getThumbnailTransform() 
     * @see #getScaleX() 
     * @see #getScaleY() 
     * @see #scaleValueX(int) 
     * @see #scaleValueY(int) 
     * @see #scaleValueInverseX(int) 
     * @see #scaleValueInverseY(int) 
     * @see #getThumbnailX() 
     * @see #getThumbnailY() 
     * @see #getThumbnailWidth() 
     * @see #getThumbnailHeight() 
     * @see #getIcon() 
     * @see #setIcon(javax.swing.Icon) 
     * @see #getImage() 
     * @see #setImage(java.awt.Image) 
     * @see #getImageWidth() 
     * @see #getImageHeight() 
     * @see #getImageScaleMode() 
     * @see #setImageScaleMode(int) 
     * @see #isAspectRatioMaintained() 
     * @see #setAspectRatioMaintained(boolean) 
     * @see #isImageAlwaysScaled() 
     * @see #setImageAlwaysScaled(boolean) 
     */
    public Point convertPointToImage(int x, int y){
        return new Point(scaleValueInverseX(x-getThumbnailX()),
                scaleValueInverseY(y-getThumbnailY()));
    }
    /**
     * This converts the given point in the thumbnail region's coordinate space 
     * into the currently set image or icon's coordinate space.
     * @param point The point to convert (cannot be null).
     * @return The converted point, now in the icon's coordinate system.
     * @throws NullPointerException If the given Point is null.
     * @see #convertPointToImage(int, int) 
     * @see #convertDimensionToImage(int, int) 
     * @see #convertDimensionToImage(java.awt.Dimension) 
     * @see #convertRectangleToImage(int, int, int, int) 
     * @see #convertRectangleToImage(java.awt.Rectangle) 
     * @see #convertPointFromImage(int, int) 
     * @see #convertPointFromImage(java.awt.Point) 
     * @see #convertDimensionFromImage(int, int) 
     * @see #convertDimensionFromImage(java.awt.Dimension) 
     * @see #convertRectangleFromImage(int, int, int, int) 
     * @see #convertRectangleFromImage(java.awt.Rectangle) 
     * @see #getThumbnailTransform() 
     * @see #getScaleX() 
     * @see #getScaleY() 
     * @see #scaleValueX(int) 
     * @see #scaleValueY(int) 
     * @see #scaleValueInverseX(int) 
     * @see #scaleValueInverseY(int) 
     * @see #getThumbnailX() 
     * @see #getThumbnailY() 
     * @see #getThumbnailWidth() 
     * @see #getThumbnailHeight() 
     * @see #getIcon() 
     * @see #setIcon(javax.swing.Icon) 
     * @see #getImage() 
     * @see #setImage(java.awt.Image) 
     * @see #getImageWidth() 
     * @see #getImageHeight() 
     * @see #getImageScaleMode() 
     * @see #setImageScaleMode(int) 
     * @see #isAspectRatioMaintained() 
     * @see #setAspectRatioMaintained(boolean) 
     * @see #isImageAlwaysScaled() 
     * @see #setImageAlwaysScaled(boolean) 
     */
    public Point convertPointToImage(Point point){
        if (point == null)    // If the point object is null
            throw new NullPointerException("The Point to convert cannot be null");
        return convertPointToImage(point.x,point.y);
    }
    /**
     * This converts the given width and height from the thumbnail region's 
     * coordinate space into the currently set image or icon's coordinate space. 
     * @param width The width to convert.
     * @param height The height to convert.
     * @return The scaled width and height, now in the icon's coordinate system.
     * @see #convertPointToImage(int, int) 
     * @see #convertPointToImage(java.awt.Point) 
     * @see #convertDimensionToImage(java.awt.Dimension) 
     * @see #convertRectangleToImage(int, int, int, int) 
     * @see #convertRectangleToImage(java.awt.Rectangle) 
     * @see #convertPointFromImage(int, int) 
     * @see #convertPointFromImage(java.awt.Point) 
     * @see #convertDimensionFromImage(int, int) 
     * @see #convertDimensionFromImage(java.awt.Dimension) 
     * @see #convertRectangleFromImage(int, int, int, int) 
     * @see #convertRectangleFromImage(java.awt.Rectangle) 
     * @see #getThumbnailTransform() 
     * @see #getScaleX() 
     * @see #getScaleY() 
     * @see #scaleValueX(int) 
     * @see #scaleValueY(int) 
     * @see #scaleValueInverseX(int) 
     * @see #scaleValueInverseY(int) 
     * @see #getThumbnailX() 
     * @see #getThumbnailY() 
     * @see #getThumbnailWidth() 
     * @see #getThumbnailHeight() 
     * @see #getIcon() 
     * @see #setIcon(javax.swing.Icon) 
     * @see #getImage() 
     * @see #setImage(java.awt.Image) 
     * @see #getImageWidth() 
     * @see #getImageHeight() 
     * @see #getImageScaleMode() 
     * @see #setImageScaleMode(int) 
     * @see #isAspectRatioMaintained() 
     * @see #setAspectRatioMaintained(boolean) 
     * @see #isImageAlwaysScaled() 
     * @see #setImageAlwaysScaled(boolean) 
     */
    public Dimension convertDimensionToImage(int width, int height){
        return new Dimension(scaleValueInverseX(width),scaleValueInverseY(height));
    }
    /**
     * This converts the given dimension from the thumbnail region's coordinate 
     * space into the currently set image or icon's coordinate space.
     * @param dim The dimension to convert (cannot be null).
     * @return The converted dimension, now in the icon's coordinate system.
     * @throws NullPointerException If the given Dimension is null.
     * @see #convertPointToImage(int, int) 
     * @see #convertPointToImage(java.awt.Point) 
     * @see #convertDimensionToImage(int, int) 
     * @see #convertRectangleToImage(int, int, int, int) 
     * @see #convertRectangleToImage(java.awt.Rectangle) 
     * @see #convertPointFromImage(int, int) 
     * @see #convertPointFromImage(java.awt.Point) 
     * @see #convertDimensionFromImage(int, int) 
     * @see #convertDimensionFromImage(java.awt.Dimension) 
     * @see #convertRectangleFromImage(int, int, int, int) 
     * @see #convertRectangleFromImage(java.awt.Rectangle) 
     * @see #getThumbnailTransform() 
     * @see #getScaleX() 
     * @see #getScaleY() 
     * @see #scaleValueX(int) 
     * @see #scaleValueY(int) 
     * @see #scaleValueInverseX(int) 
     * @see #scaleValueInverseY(int) 
     * @see #getThumbnailX() 
     * @see #getThumbnailY() 
     * @see #getThumbnailWidth() 
     * @see #getThumbnailHeight() 
     * @see #getIcon() 
     * @see #setIcon(javax.swing.Icon) 
     * @see #getImage() 
     * @see #setImage(java.awt.Image) 
     * @see #getImageWidth() 
     * @see #getImageHeight() 
     * @see #getImageScaleMode() 
     * @see #setImageScaleMode(int) 
     * @see #isAspectRatioMaintained() 
     * @see #setAspectRatioMaintained(boolean) 
     * @see #isImageAlwaysScaled() 
     * @see #setImageAlwaysScaled(boolean) 
     */
    public Dimension convertDimensionToImage(Dimension dim){
        if (dim == null)    // If the dimension object is null
            throw new NullPointerException("The Dimension to convert cannot be null");
        return convertDimensionToImage(dim.width,dim.height);
    }
    /**
     * This converts the rectangle at the given point (x, y) and with the given 
     * width and height in the thumbnail region's coordinate space into the 
     * currently set image or icon's coordinate space.
     * @param x The x coordinate of the point.
     * @param y The y coordinate of the point.
     * @param width The width to convert.
     * @param height The height to convert.
     * @return The converted rectangle, now in the icon's coordinate system.
     * @see #convertPointToImage(int, int) 
     * @see #convertPointToImage(java.awt.Point) 
     * @see #convertDimensionToImage(int, int) 
     * @see #convertDimensionToImage(java.awt.Dimension) 
     * @see #convertRectangleToImage(java.awt.Rectangle) 
     * @see #convertPointFromImage(java.awt.Point) 
     * @see #convertDimensionFromImage(int, int) 
     * @see #convertDimensionFromImage(java.awt.Dimension) 
     * @see #convertRectangleFromImage(java.awt.Rectangle) 
     * @see #convertRectangleFromImage(int, int, int, int) 
     * @see #getThumbnailTransform() 
     * @see #getScaleX() 
     * @see #getScaleY() 
     * @see #scaleValueX(int) 
     * @see #scaleValueY(int) 
     * @see #scaleValueInverseX(int) 
     * @see #scaleValueInverseY(int) 
     * @see #getThumbnailX() 
     * @see #getThumbnailY() 
     * @see #getThumbnailWidth() 
     * @see #getThumbnailHeight() 
     * @see #getIcon() 
     * @see #setIcon(javax.swing.Icon) 
     * @see #getImage() 
     * @see #setImage(java.awt.Image) 
     * @see #getImageWidth() 
     * @see #getImageHeight() 
     * @see #getImageScaleMode() 
     * @see #setImageScaleMode(int) 
     * @see #isAspectRatioMaintained() 
     * @see #setAspectRatioMaintained(boolean) 
     * @see #isImageAlwaysScaled() 
     * @see #setImageAlwaysScaled(boolean) 
     */
    public Rectangle convertRectangleToImage(int x, int y, int width, int height){
        return new Rectangle(convertPointToImage(x,y),convertDimensionToImage(width,height));
    }
    /**
     * This converts the given rectangle in the thumbnail region's coordinate 
     * space into the currently set image or icon's coordinate space.
     * @param rect The rectangle to convert (cannot be null).
     * @return The converted rectangle, now in the icon's coordinate system.
     * @throws NullPointerException If the given Rectangle is null.
     * @see #convertPointToImage(int, int) 
     * @see #convertPointToImage(java.awt.Point) 
     * @see #convertDimensionToImage(int, int) 
     * @see #convertDimensionToImage(java.awt.Dimension) 
     * @see #convertRectangleToImage(int, int, int, int) 
     * @see #convertPointFromImage(java.awt.Point) 
     * @see #convertDimensionFromImage(int, int) 
     * @see #convertDimensionFromImage(java.awt.Dimension) 
     * @see #convertRectangleFromImage(int, int, int, int) 
     * @see #convertRectangleFromImage(java.awt.Rectangle) 
     * @see #getThumbnailTransform() 
     * @see #getScaleX() 
     * @see #getScaleY() 
     * @see #scaleValueX(int) 
     * @see #scaleValueY(int) 
     * @see #scaleValueInverseX(int) 
     * @see #scaleValueInverseY(int) 
     * @see #getThumbnailX() 
     * @see #getThumbnailY() 
     * @see #getThumbnailWidth() 
     * @see #getThumbnailHeight() 
     * @see #getIcon() 
     * @see #setIcon(javax.swing.Icon) 
     * @see #getImage() 
     * @see #setImage(java.awt.Image) 
     * @see #getImageWidth() 
     * @see #getImageHeight() 
     * @see #getImageScaleMode() 
     * @see #setImageScaleMode(int) 
     * @see #isAspectRatioMaintained() 
     * @see #setAspectRatioMaintained(boolean) 
     * @see #isImageAlwaysScaled() 
     * @see #setImageAlwaysScaled(boolean) 
     */
    public Rectangle convertRectangleToImage(Rectangle rect){
        if (rect == null)    // If the rectangle object is null
            throw new NullPointerException("The Rectangle to convert cannot be null");
        return new Rectangle(convertPointToImage(rect.getLocation()), 
                convertDimensionToImage(rect.getSize()));
    }
    /**
     * This converts the given point (x, y) in the currently set image or icon's 
     * coordinate space into the thumbnail region's coordinate space. 
     * @param x The x coordinate of the point.
     * @param y The y coordinate of the point.
     * @return The converted point, now in the thumbnail region's coordinate 
     * system.
     * @see #convertPointFromImage(java.awt.Point) 
     * @see #convertDimensionFromImage(int, int) 
     * @see #convertDimensionFromImage(java.awt.Dimension) 
     * @see #convertRectangleFromImage(int, int, int, int) 
     * @see #convertRectangleFromImage(java.awt.Rectangle) 
     * @see #convertPointToImage(int, int) 
     * @see #convertPointToImage(java.awt.Point) 
     * @see #convertDimensionToImage(int, int) 
     * @see #convertDimensionToImage(java.awt.Dimension) 
     * @see #convertRectangleToImage(int, int, int, int) 
     * @see #convertRectangleToImage(java.awt.Rectangle) 
     * @see #getThumbnailTransform() 
     * @see #getScaleX() 
     * @see #getScaleY() 
     * @see #scaleValueX(int) 
     * @see #scaleValueY(int) 
     * @see #getThumbnailX() 
     * @see #getThumbnailY() 
     * @see #getThumbnailWidth() 
     * @see #getThumbnailHeight() 
     * @see #getIcon() 
     * @see #setIcon(javax.swing.Icon) 
     * @see #getImage() 
     * @see #setImage(java.awt.Image) 
     * @see #getImageWidth() 
     * @see #getImageHeight() 
     * @see #getImageScaleMode() 
     * @see #setImageScaleMode(int) 
     * @see #isAspectRatioMaintained() 
     * @see #setAspectRatioMaintained(boolean) 
     * @see #isImageAlwaysScaled() 
     * @see #setImageAlwaysScaled(boolean) 
     */
    public Point convertPointFromImage(int x, int y){
        return new Point(scaleValueX(x)+getThumbnailX(),scaleValueY(y)+getThumbnailY());
    }
    /**
     * This converts the given point in the currently set image or icon's 
     * coordinate space into the thumbnail region's coordinate space. 
     * @param point The point to convert (cannot be null).
     * @return The converted point, now in the thumbnail region's coordinate 
     * system.
     * @throws NullPointerException If the given Point is null.
     * @see #convertPointFromImage(int, int) 
     * @see #convertDimensionFromImage(int, int) 
     * @see #convertDimensionFromImage(java.awt.Dimension) 
     * @see #convertRectangleFromImage(int, int, int, int) 
     * @see #convertRectangleFromImage(java.awt.Rectangle) 
     * @see #convertPointToImage(int, int) 
     * @see #convertPointToImage(java.awt.Point) 
     * @see #convertDimensionToImage(int, int) 
     * @see #convertDimensionToImage(java.awt.Dimension) 
     * @see #convertRectangleToImage(int, int, int, int) 
     * @see #convertRectangleToImage(java.awt.Rectangle) 
     * @see #getThumbnailTransform() 
     * @see #getScaleX() 
     * @see #getScaleY() 
     * @see #scaleValueX(int) 
     * @see #scaleValueY(int) 
     * @see #getThumbnailX() 
     * @see #getThumbnailY() 
     * @see #getThumbnailWidth() 
     * @see #getThumbnailHeight() 
     * @see #getIcon() 
     * @see #setIcon(javax.swing.Icon) 
     * @see #getImage() 
     * @see #setImage(java.awt.Image) 
     * @see #getImageWidth() 
     * @see #getImageHeight() 
     * @see #getImageScaleMode() 
     * @see #setImageScaleMode(int) 
     * @see #isAspectRatioMaintained() 
     * @see #setAspectRatioMaintained(boolean) 
     * @see #isImageAlwaysScaled() 
     * @see #setImageAlwaysScaled(boolean) 
     */
    public Point convertPointFromImage(Point point){
        if (point == null)    // If the point object is null
            throw new NullPointerException("The Point to convert cannot be null");
        return convertPointFromImage(point.x,point.y);
    }
    /**
     * This converts the given width and height from the currently set image or 
     * icon's coordinate space into the thumbnail region's coordinate space. 
     * That is to say, this converts the given width and height into the 
     * thumbnail region's coordinate space by scaling them.
     * @param width The width to convert.
     * @param height The height to convert.
     * @return The scaled width and height, now in the thumbnail region's 
     * coordinate system.
     * @see #convertPointFromImage(int, int) 
     * @see #convertPointFromImage(java.awt.Point) 
     * @see #convertDimensionFromImage(java.awt.Dimension) 
     * @see #convertRectangleFromImage(int, int, int, int) 
     * @see #convertRectangleFromImage(java.awt.Rectangle) 
     * @see #convertPointToImage(int, int) 
     * @see #convertPointToImage(java.awt.Point) 
     * @see #convertDimensionToImage(int, int) 
     * @see #convertDimensionToImage(java.awt.Dimension) 
     * @see #convertRectangleToImage(int, int, int, int) 
     * @see #convertRectangleToImage(java.awt.Rectangle) 
     * @see #getThumbnailTransform() 
     * @see #getScaleX() 
     * @see #getScaleY() 
     * @see #scaleValueX(int) 
     * @see #scaleValueY(int) 
     * @see #getThumbnailX() 
     * @see #getThumbnailY() 
     * @see #getThumbnailWidth() 
     * @see #getThumbnailHeight() 
     * @see #getIcon() 
     * @see #setIcon(javax.swing.Icon) 
     * @see #getImage() 
     * @see #setImage(java.awt.Image) 
     * @see #getImageWidth() 
     * @see #getImageHeight() 
     * @see #getImageScaleMode() 
     * @see #setImageScaleMode(int) 
     * @see #isAspectRatioMaintained() 
     * @see #setAspectRatioMaintained(boolean) 
     * @see #isImageAlwaysScaled() 
     * @see #setImageAlwaysScaled(boolean) 
     */
    public Dimension convertDimensionFromImage(int width, int height){
        return new Dimension(scaleValueX(width),scaleValueY(height));
    }
    /**
     * This converts the given dimension from the currently set image or icon's 
     * coordinate space into the thumbnail region's coordinate space. That is to 
     * say, this converts the given dimension into the thumbnail region's 
     * coordinate space by scaling the width and the height.
     * @param dim The dimension to convert (cannot be null).
     * @return The converted dimension, now in the thumbnail region's coordinate 
     * system.
     * @throws NullPointerException If the given Dimension is null.
     * @see #convertPointFromImage(int, int) 
     * @see #convertPointFromImage(java.awt.Point) 
     * @see #convertDimensionFromImage(int, int) 
     * @see #convertRectangleFromImage(int, int, int, int) 
     * @see #convertRectangleFromImage(java.awt.Rectangle) 
     * @see #convertPointToImage(int, int) 
     * @see #convertPointToImage(java.awt.Point) 
     * @see #convertDimensionToImage(int, int) 
     * @see #convertDimensionToImage(java.awt.Dimension) 
     * @see #convertRectangleToImage(int, int, int, int) 
     * @see #convertRectangleToImage(java.awt.Rectangle) 
     * @see #getThumbnailTransform() 
     * @see #getScaleX() 
     * @see #getScaleY() 
     * @see #scaleValueX(int) 
     * @see #scaleValueY(int) 
     * @see #getThumbnailX() 
     * @see #getThumbnailY() 
     * @see #getThumbnailWidth() 
     * @see #getThumbnailHeight() 
     * @see #getIcon() 
     * @see #setIcon(javax.swing.Icon) 
     * @see #getImage() 
     * @see #setImage(java.awt.Image) 
     * @see #getImageWidth() 
     * @see #getImageHeight() 
     * @see #getImageScaleMode() 
     * @see #setImageScaleMode(int) 
     * @see #isAspectRatioMaintained() 
     * @see #setAspectRatioMaintained(boolean) 
     * @see #isImageAlwaysScaled() 
     * @see #setImageAlwaysScaled(boolean) 
     */
    public Dimension convertDimensionFromImage(Dimension dim){
        if (dim == null)    // If the dimension object is null
            throw new NullPointerException("The Dimension to convert cannot be null");
        return convertDimensionFromImage(dim.width,dim.height);
    }
    /**
     * This converts the rectangle at the given point (x, y) and with the given 
     * width and height in the currently set image or icon's coordinate space 
     * into the thumbnail region's coordinate space. 
     * @param x The x coordinate of the point.
     * @param y The y coordinate of the point.
     * @param width The width to convert.
     * @param height The height to convert.
     * @return The converted rectangle, now in the thumbnail region's coordinate 
     * system.
     * @see #convertPointFromImage(java.awt.Point) 
     * @see #convertDimensionFromImage(int, int) 
     * @see #convertDimensionFromImage(java.awt.Dimension) 
     * @see #convertRectangleFromImage(java.awt.Rectangle) 
     * @see #convertPointToImage(int, int) 
     * @see #convertPointToImage(java.awt.Point) 
     * @see #convertDimensionToImage(int, int) 
     * @see #convertDimensionToImage(java.awt.Dimension) 
     * @see #convertRectangleToImage(int, int, int, int) 
     * @see #convertRectangleToImage(java.awt.Rectangle) 
     * @see #getThumbnailTransform() 
     * @see #getScaleX() 
     * @see #getScaleY() 
     * @see #scaleValueX(int) 
     * @see #scaleValueY(int) 
     * @see #getThumbnailX() 
     * @see #getThumbnailY() 
     * @see #getThumbnailWidth() 
     * @see #getThumbnailHeight() 
     * @see #getIcon() 
     * @see #setIcon(javax.swing.Icon) 
     * @see #getImage() 
     * @see #setImage(java.awt.Image) 
     * @see #getImageWidth() 
     * @see #getImageHeight() 
     * @see #getImageScaleMode() 
     * @see #setImageScaleMode(int) 
     * @see #isAspectRatioMaintained() 
     * @see #setAspectRatioMaintained(boolean) 
     * @see #isImageAlwaysScaled() 
     * @see #setImageAlwaysScaled(boolean) 
     */
    public Rectangle convertRectangleFromImage(int x, int y, int width, int height){
        return new Rectangle(convertPointFromImage(x,y),
                convertDimensionFromImage(width,height));
    }
    /**
     * This converts the given rectangle in the currently set image or icon's 
     * coordinate space into the thumbnail region's coordinate space. 
     * @param rect The rectangle to convert (cannot be null).
     * @return The converted rectangle, now in the thumbnail region's coordinate 
     * system.
     * @throws NullPointerException If the given Rectangle is null.
     * @see #convertPointFromImage(java.awt.Point) 
     * @see #convertDimensionFromImage(int, int) 
     * @see #convertDimensionFromImage(java.awt.Dimension) 
     * @see #convertRectangleFromImage(int, int, int, int) 
     * @see #convertPointToImage(int, int) 
     * @see #convertPointToImage(java.awt.Point) 
     * @see #convertDimensionToImage(int, int) 
     * @see #convertDimensionToImage(java.awt.Dimension) 
     * @see #convertRectangleToImage(int, int, int, int) 
     * @see #convertRectangleToImage(java.awt.Rectangle) 
     * @see #getThumbnailTransform() 
     * @see #getScaleX() 
     * @see #getScaleY() 
     * @see #scaleValueX(int) 
     * @see #scaleValueY(int) 
     * @see #getThumbnailX() 
     * @see #getThumbnailY() 
     * @see #getThumbnailWidth() 
     * @see #getThumbnailHeight() 
     * @see #getIcon() 
     * @see #setIcon(javax.swing.Icon) 
     * @see #getImage() 
     * @see #setImage(java.awt.Image) 
     * @see #getImageWidth() 
     * @see #getImageHeight() 
     * @see #getImageScaleMode() 
     * @see #setImageScaleMode(int) 
     * @see #isAspectRatioMaintained() 
     * @see #setAspectRatioMaintained(boolean) 
     * @see #isImageAlwaysScaled() 
     * @see #setImageAlwaysScaled(boolean) 
     */
    public Rectangle convertRectangleFromImage(Rectangle rect){
        if (rect == null)    // If the rectangle object is null
            throw new NullPointerException("The Rectangle to convert cannot be null");
        return new Rectangle(convertPointFromImage(rect.getLocation()), 
                convertDimensionFromImage(rect.getSize()));
    }
    /**
     * 
     * @param tx
     * @return 
     */
    public AffineTransform applyThumbnailRegionTransform(AffineTransform tx){
            // If no icon is set
        if (!isIconSet())
                // If the given transform is not null, return it unmodified. 
                // Otherwise, return the identity tranformation
            return (tx != null) ? tx : new AffineTransform();
            // If the given tranform is null
        if (tx == null)
            return AffineTransform.getTranslateInstance(getThumbnailRegionX(), 
                    getThumbnailRegionY());
        tx.translate(getThumbnailRegionX(), getThumbnailRegionY());
        return tx;
    }
    /**
     * 
     * @param tx
     * @return 
     */
    public AffineTransform getThumbnailRegionTransform(AffineTransform tx){
            // If the given transform is not null
        if (tx != null)
                // Reset it to the identity transformation
            tx.setToIdentity();
        return applyThumbnailRegionTransform(tx);
    }
    /**
     * 
     * @return 
     */
    public AffineTransform getThumbnailRegionTransform(){
        return getThumbnailRegionTransform(null);
    }
    /**
     * This returns a Transform that maps the image or icon's coordinate space 
     * to the thumbnail region's coordinate space. That is to say, the returned 
     * Transform maps coordinates on the image or icon to the coordinates on the 
     * scaled image or icon. 
     * @return An AffineTransform representing the transformations applied to 
     * the image or icon to get the thumbnail, or null if no icon is set.
     * @see #getIcon() 
     * @see #setIcon(javax.swing.Icon) 
     * @see #getImage() 
     * @see #setImage(java.awt.Image) 
     * @see #getImageWidth() 
     * @see #getImageHeight() 
     * @see #getImageScaleMode() 
     * @see #setImageScaleMode(int) 
     * @see #isAspectRatioMaintained() 
     * @see #setAspectRatioMaintained(boolean) 
     * @see #isImageAlwaysScaled() 
     * @see #setImageAlwaysScaled(boolean) 
     * @see #getThumbnailBorder() 
     * @see #setThumbnailBorder(javax.swing.border.Border) 
     * @see #getThumbnailX() 
     * @see #getThumbnailY() 
     * @see #getThumbnailWidth() 
     * @see #getThumbnailHeight() 
     * @see #getScaleX() 
     * @see #getScaleY() 
     */
    public AffineTransform getThumbnailTransform(){
            // If this has an icon set, create an AffineTransform that 
            // corresponds to the thumbnail image. Otherwise, return null.
        return (isIconSet()) ? new AffineTransform(
                getScaleX(),0,0,getScaleY(),
                getThumbnailX(),getThumbnailY()) : null;
    }
    
    
    
    /**
     * This is used to paint the thumbnail region. <p>
     * 
     * This method delegates the tasks of painting the thumbnail region to three 
     * methods: {@link #paintThumbnail paintThumbnail}, {@link 
     * #paintThumbnailBorder paintThumbnailBorder}, and {@link 
     * #paintThumbnailOverlay paintThumbnailOverlay}. They're are called in that 
     * order, so as to ensure that the thumbnail overlay is allowed to paint 
     * over the thumbnail and the thumbnail border. The {@link 
     * #configureRenderingGraphics configureRenderingGraphics} method will have 
     * already configured the graphics context in preparation to paint the 
     * thumbnail by the time this this method is called.
     * 
     * @param g The graphics context to use to render the thumbnail region.
     * @param x The x-coordinate for the top-left corner of the thumbnail 
     * region.
     * @param y The y-coordinate for the top-left corner of the thumbnail 
     * region.
     * @param width The width for the thumbnail region.
     * @param height The height for the thumbnail region.
     * @see #configureRenderingGraphics 
     * @see #paintThumbnail 
     * @see #paintThumbnailBorder 
     * @see #paintThumbnailOverlay 
     */
    protected void paintThumbnailRegion(Graphics2D g,int x,int y,int width,
            int height){
        paintThumbnail(g,x+getThumbnailX(),y+getThumbnailY(),
                getThumbnailWidth(),getThumbnailHeight());
        paintThumbnailBorder(g,x,y,width,height);
        paintThumbnailOverlay(g,x,y,width,height);
    }
    /**
     * This is used to configure the graphics context used to render the 
     * thumbnail. It's assumed that the returned graphics context is the same as 
     * the given graphics context, or at least that the returned graphics 
     * context references the given graphics context in some way.
     * 
     * @todo Look into using the 
     * <a href="https://github.com/coobird/thumbnailator">Thumbnailator 
     * library</a> to scale images so as to improve their rendering quality. It 
     * might also be possible to create a Graphics2D wrapper that uses 
     * Thumbnailator when drawing a scaled image.
     * 
     * @param g The graphics context to configure.
     * @return The given graphics context, now configured for rendering the 
     * thumbnail.
     */
    protected Graphics2D configureRenderingGraphics(Graphics2D g){
        g.addRenderingHints(hintMap);
//        g = new ThumbnailGraphics2D(g);
        return g;
    }
    /**
     * This is used to paint the thumbnail of the currently set image or icon. 
     * If the icon is not null, then this will make a copy of the given 
     * Graphics2D object and applies a scaling transformation to scale the icon 
     * being painted. Afterwards, this delegates to the icon's paintIcon method, 
     * passing it the scaled copy of the given Graphics2D object.
     * @param g The graphics context to use to render the icon.
     * @param x The x-coordinate for the top-left corner of the icon.
     * @param y The y-coordinate for the top-left corner of the icon.
     * @param width The width for the scaled icon.
     * @param height The height for the scaled icon.
     * @see #getIcon() 
     * @see #getImage() 
     * @see Icon#paintIcon
     * @see #getScaleX() 
     * @see #getScaleY() 
     * @see #paintThumbnailRegion
     * @see #getImageWidth() 
     * @see #getImageHeight() 
     * @see Icon#getIconWidth() 
     * @see Icon#getIconHeight() 
     * @see #getThumbnailWidth() 
     * @see #getThumbnailHeight() 
     * @see #getThumbnailTransform() 
     */
    protected void paintThumbnail(Graphics2D g, int x, int y, int width, int height){
        Icon icon = getDisplayedIcon(); // This gets the icon currently being displayed
            // If the icon is not null and its width and height are greater than zero
        if (icon != null && icon.getIconWidth() > 0 && icon.getIconHeight() > 0){  
            g = (Graphics2D) g.create();//x, y, width, height);
            g.translate(x, y);
            g.scale(getScale(width,icon.getIconWidth()), 
                    getScale(height,icon.getIconHeight()));
            icon.paintIcon(this, g, 0, 0);
            g.dispose();
        }
    }
    /**
     * This is used to paint the thumbnail border. If the thumbnail border is 
     * not null, then this delegates to the thumbnail border's paintBorder 
     * method. This passes a copy of the given Graphics2D object to the 
     * thumbnail border to protect the rest of the paint code from changes made 
     * to the Graphics2D object by the thumbnail border.
     * @param g The graphics context to use to render the border.
     * @param x The x-coordinate for the top-left corner of the border.
     * @param y The y-coordinate for the top-left corner of the border.
     * @param width The width for the border.
     * @param height The height for the border.
     * @see #getThumbnailBorder 
     * @see Border#paintBorder 
     * @see #paintThumbnailRegion 
     */
    protected void paintThumbnailBorder(Graphics2D g, int x, int y, int width, int height){
            // This gets the thumbnail border
        Border border = getThumbnailBorder();
        if (border != null){ // If there is a border set
            g = (Graphics2D) g.create();
            border.paintBorder(this, g, x, y, width, height);
            g.dispose();
        }
    }
    /**
     * This is used to paint the thumbnail overlay. If the thumbnail overlay is 
     * not null, then this delegates to the thumbnail overlay's paint method. 
     * This passes a copy of the given Graphics2D object to the thumbnail 
     * overlay to protect the rest of the paint code from changes made to the 
     * Graphics2D object by the thumbnail overlay.
     * @param g The graphics context to use to render the overlay.
     * @param x The x-coordinate for the top-left corner of the overlay.
     * @param y The y-coordinate for the top-left corner of the overlay.
     * @param width The width for the overlay.
     * @param height The height for the overlay.
     * @see #getThumbnailOverlay 
     * @see Painter#paint 
     * @see #paintThumbnailRegion 
     */
    protected void paintThumbnailOverlay(Graphics2D g, int x, int y, int width, int height){
            // This gets the overlay to paint over the thumbnail
        Painter<? super JThumbnailLabel> o = getThumbnailOverlay();
        if (o != null){    // If there is an overlay set
            g = (Graphics2D) g.create();//x, y, width, height);
            g.translate(x, y);
            o.paint(g, this, width, height);
            g.dispose();
        }
    }
    /**
     * This returns the String representation of the scaling mode.
     * @param mode The current scaling mode.
     * @return The String representation of the scaling mode, or null if the 
     * mode is an unknown scaling mode.
     */
    protected String getImageScaleModeString(int mode){
        switch(mode){
            case(NO_SCALING_APPLIED):                   // If no scaling is applied
                return "NO_SCALING_APPLIED";
            case(ONLY_SCALE_TO_FIT):                    // If the image is only scaled to fit
                return "ONLY_SCALE_TO_FIT";
            case(ALWAYS_SCALE_MAINTAIN_ASPECT_RATIO):   // If the image is always scaled and aspect ratio maintained
                return "ALWAYS_SCALE_MAINTAIN_ASPECT_RATIO";
            case(ALWAYS_SCALE_IGNORE_ASPECT_RATIO):     // If the image is always scaled and aspect ratio is ignored
                return "ALWAYS_SCALE_IGNORE_ASPECT_RATIO";
        }
        return null;
    }
    /**
     * This returns a String representation of the flags set for the scaling 
     * mode of this JThumbnailLabel.
     * @return A String stating the flags for the scaling mode.
     */
    protected String getScaleFlagString(){
        return ",maintainsAspectRatio="+isAspectRatioMaintained() + 
                ",alwaysScalesImage="+isImageAlwaysScaled();
    }
    /**
     * This returns a String representation of this JThumbnailLabel. This method 
     * is primarily intended to be used only for debugging purposes, and the 
     * content and format of the returned String may vary between 
     * implementations.
     * @return A String representation of this JThumbnailLabel.
     */
    @Override
    protected String paramString(){
        return super.paramString()+
                ",imageScaleMode=" + Objects.toString(getImageScaleModeString(
                        getImageScaleMode()),
                        "unknown scaling mode ("+getImageScaleMode()+")") + 
                 getScaleFlagString() + 
                ",thumbnailBounds="+getThumbnailRegionX()+","+getThumbnailRegionY()+","+
                getThumbnailRegionWidth()+"x"+getThumbnailRegionHeight() + 
                ",thumbnailBorder="+Objects.toString(getThumbnailBorder(), "")+
                ",thumbnailOverlay="+Objects.toString(getThumbnailOverlay(),"")+ 
                ",xScale="+getScaleX() + 
                ",yScale="+getScaleY();
    }
    // HACK: The ThumbnailIcon and DisabledThumbnailIcon are primarily used to 
    // trick the label's UI into laying out and painting the thumbnail as 
    // opposed to having to implement calculating the location of the text and 
    // stuff
    /**
     * This is an icon used by JThumbnailLabel to render the thumbnail, along 
     * with its border and overlay. The main rendering is done by {@link 
     * #paintThumbnailRegion paintThumbnailRegion}, and the width and height of 
     * this icon are provided by {@link #getThumbnailRegionWidth} and {@link 
     * #getThumbnailRegionHeight} respectively.
     * @see JThumbnailLabel
     * @see #configureRenderingGraphics
     * @see #paintThumbnailRegion 
     * @see #getThumbnailRegionWidth 
     * @see #getThumbnailRegionHeight 
     */
    private class ThumbnailIcon implements Icon2D{
        /**
         * This returns the parent JThumbnailLabel that created this 
         * ThumbnailIcon.
         * @return The parent JThumbnailLabel.
         */
        public JThumbnailLabel getLabel(){
            return JThumbnailLabel.this;
        }
        @Override
        public void paintIcon2D(Component c, Graphics2D g, int x, int y) {
            int width = getIconWidth();     // Get the thumbnail width
            int height = getIconHeight();   // Get the thumbnail height
                // If the label does not have an icon set or either the width or 
                // height are less than or equal to zero
            if (!getLabel().isIconSet()){
                return;
            }
            if (iconBounds == null)   // If the icon bounds has not been initialized
                iconBounds = new Rectangle(x, y, width, height);
            else
                iconBounds.setBounds(x, y, width, height);
            thumbnailBounds = getThumbnailBounds(thumbnailBounds);
            setIconControlFlag(IS_PAINTING_ICON_CONTROL_FLAG,true);
            
            g = configureRenderingGraphics(g);
            paintThumbnailRegion(g, x, y, width, height);
            
            setIconControlFlag(IS_PAINTING_ICON_CONTROL_FLAG,false);
        }
        /**
         * This returns the width of the thumbnail. This delegates to the 
         * {@link #getThumbnailRegionWidth()} method of the parent {@link 
         * #getLabel() JThumbnailLabel}.
         * @return The width of the thumbnail.
         * @see #getLabel() 
         * @see #getThumbnailRegionWidth() 
         */
        @Override
        public synchronized int getIconWidth() {
            return getThumbnailRegionWidth();
        }
        /**
         * This returns the height of the thumbnail. This delegates to the 
         * {@link #getThumbnailRegionHeight()} method of the parent {@link 
         * #getLabel() JThumbnailLabel}.
         * @return The height of the thumbnail.
         * @see #getLabel() 
         * @see #getThumbnailRegionHeight() 
         */
        @Override
        public synchronized int getIconHeight() {
            return getThumbnailRegionHeight();
        }
    }
    /**
     * This is a DisabledIcon for the {@link #getThumbnailIcon() thumbnail 
     * icon}, so as to allow for the graphics context used to render the 
     * disabled icon to be {@link #configureRenderingGraphics configured} like 
     * the thumbnail icon.
     * @see #getThumbnailIcon 
     * @see #configureRenderingGraphics 
     */
    private class DisabledThumbnailIcon extends DisabledIcon{
        /**
         * This constructs a DisabledThumbnailIcon with this label's {@link 
         * #getThumbnailIcon() thumbnail icon}.
         */
        private DisabledThumbnailIcon(){
            super(getThumbnailIcon());
        }
        @Override
        public void paintIcon(Component c, Graphics g,int x,int y){
            g = g.create();
                // If the graphics context is a Graphics2D object
            if (g instanceof Graphics2D)
                g = configureRenderingGraphics((Graphics2D)g);
            if (g == null)  // If the graphics context is null
                return;
            super.paintIcon(c, g, x, y);
            g.dispose();
        }
        /**
         * This returns the parent JThumbnailLabel that created this 
         * DisabledThumbnailIcon.
         * @return The parent JThumbnailLabel.
         */
        public JThumbnailLabel getLabel(){
            return JThumbnailLabel.this;
        }
    }
}
