/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 * This is a BeanInfoIconFactory for dialogs and dialog panels. This handles 
 * drawing the dialog portion of the icon. Please refer to the documentation for 
 * the {@link BeanInfoIconFactory} class for more information.
 * @author Milo Steier
 * @see BeanInfoIconFactory
 */
public abstract class DialogBeanInfoIconFactory extends BeanInfoIconFactory{
    /**
     * The color values to use for drawing the dialog. The first array contains 
     * the colors for color icons, and the second array contains the colors for 
     * monochrome icons. This array is subject to change, and some of the colors 
     * may be merged together or moved to the {@link #COMMON_INFO_ICON_COLORS} 
     * array.
     * @see #COMMON_INFO_ICON_COLORS
     */
    private static final int[][] COLOR_VALUES = {
        {0x8092A4B0, 0x7891A3, 0x596D7C, 0xBCCDDB, 0x9EB7CB, 0xF0F8FC, 0x6B8293, 0x8A939B, 
           0x5F666C, 0xDDE8F3, 0xC5D8EB, 0xC2D2DE},
        {0x80A1A1A1, 0x8D8D8D, 0x6A6A6A, 0xCDCDCD, 0xB4B4B4, 0xF6F6F6, 0x7F7F7F, 0x929292, 
           0x666666, 0xE8E8E8, 0xD8D8D8, 0xD0D0D0}
    };
    /**
     * This constructs a DialogBeanInfoIconFactory.
     */
    public DialogBeanInfoIconFactory(){ }
    /**
     * This returns whether the bottom buttons should be drawn on the icon.
     * @return true to draw the buttons for the icon, false otherwise.
     * @see #paintImage
     */
    protected abstract boolean getButtonsArePainted();
    /**
     * {@inheritDoc } This first renders the dialog box before drawing the 
     * {@link #paintDialogContents(java.awt.Graphics2D, int, int, int, int, int, int) 
     * contents} of the dialog. The value returned by {@link 
     * getButtonsArePainted() getButtonsArePainted} will determine if the dialog 
     * will have buttons at the bottom.
     * @param g {@inheritDoc }
     * @param scale {@inheritDoc }
     * @param colorMode {@inheritDoc }
     * @param w {@inheritDoc }
     * @param h {@inheritDoc }
     * @see #getScaleForImage
     * @see #getImageColorMode
     * @see #createIconImage
     * @see #getButtonsArePainted
     * @see #paintDialogContents
     */
    @Override
    protected void paintImage(Graphics2D g,int scale,int colorMode,int w,int h){
        int titleH = (3*scale)+(scale%2);   // The height of the title bar
        h -= titleH;
            // Draw transparent title bar background and shadow
        g.setColor(new Color(COLOR_VALUES[colorMode][0], true));
        g.fillRect(0, 0, w, titleH);
        g.setColor(SHADOW_COLOR);
        g.fillRect(0, titleH, w, h-1);
        g.fillRect(1, titleH, w-2, h);
            // Draw the title bar outline
        g.setPaint(createVerticalGradient(0,titleH,COLOR_VALUES[colorMode][1],COLOR_VALUES[colorMode][2]));
        g.fillRect(0, 1, w, titleH-1);
        g.fillRect(1, 0, w-2, titleH);
            // Draw the title bar background
        g.setPaint(createVerticalGradient(1,titleH-1,COLOR_VALUES[colorMode][3],COLOR_VALUES[colorMode][4]));
        g.fillRect(1, 1, w-2, titleH-2);
            // A for loop to draw the first two decorative dots on the title bar
        for (int i = 0; i < 2; i++){    
            g.setColor(new Color(COLOR_VALUES[colorMode][5+i]));
            g.fillRect(scale+i, scale+i, 1, 1);
        }   // A for loop to copy the decorative dots accross the title bar
        for (int x = 3; x < 15*scale; x+=3)
            g.copyArea(scale, scale, 2, 2, x, 0);
            // Draw the outline of the dialog
        h--;
        g.setPaint(createVerticalGradient(titleH,h+titleH,COLOR_VALUES[colorMode][7],COLOR_VALUES[colorMode][8]));
        g.fillRect(0, titleH, w, h-1);
        g.fillRect(1, titleH, w-2, h);
            // Draw the background of the dialog
        h--;
        g.setPaint(createLightBlueFillGradient(titleH,h+titleH-1,colorMode));
        g.fillRect(1, titleH, w-2, h);
        if (getButtonsArePainted()){    // If the buttons are to be painted
                // 32x32 icons have a button area that is 7 pixels tall and 
                // drawn in a gradient. 16x16 icons have a button area that is 2 
                // pixels tall and drawn in a solid color
            if (scale == 2)    // If this is a 32x32 icon
                g.setPaint(createVerticalGradient(24,30,COLOR_VALUES[colorMode][9],COLOR_VALUES[colorMode][10]));
            else
                g.setColor(new Color(COLOR_VALUES[colorMode][11]));
            g.fillRect(1, 12*scale, w-2, (3*scale)-(scale%2));
                // Draw the buttons
            g.setColor(new Color(COLOR_VALUES[colorMode][1]));
            if (scale == 2){    // If this is a 32x32 icon
                g.drawRect(12, 25, 7, 3);
                g.drawRect(21, 25, 7, 3);
                h-=7;
            }
            else{   // There's not enough room for proper rectangles, so use dots to 
                    // denote buttons in combination with the line above
                for (int x = 7; x < 15; x+=2)   
                    g.fillRect(x, 13, 1, 1);
                h-=2;
            }
            g.drawLine(1, (12*scale)-(scale>>1), w-2, (12*scale)-(scale>>1));
        }   // Draw the contents of the dialog
        paintDialogContents(g,scale,colorMode,1,titleH,w-2,h);
    }
    /**
     * This is used to render the contents of the dialog. This is called by 
     * {@link #paintImage(java.awt.Graphics2D, int, int, int, int) paintImage} 
     * after the dialog has been rendered. The graphics context, {@code scale}, 
     * and {@code colorMode} that were passed to {@code paintImage} are passed 
     * to this. 
     * @param g The graphics context to render to.
     * @param scale The scale for the icon (1 for 16x16 icons, 2 for 32x32 
     * icons).
     * @param colorMode The color mode for the icon (0 for color icons, 1 for 
     * monochrome icons).
     * @param x The x-coordinate for the top-left corner of the inner area of 
     * the dialog (typically 1).
     * @param y The y-coordinate for the top-left corner of the inner area of 
     * the dialog (typically equal to the height of the title bar).
     * @param w The width of the inner area of the dialog (typically {@code 
     * (16 * scale)-2}).
     * @param h The height of the inner area of the dialog.
     * @see #paintImage
     * @see #getScaleForImage
     * @see #getImageColorMode
     */
    protected abstract void paintDialogContents(Graphics2D g, int scale, 
            int colorMode, int x, int y, int w, int h);
}
