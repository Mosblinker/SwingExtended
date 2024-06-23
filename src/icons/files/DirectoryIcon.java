/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package icons.files;

import java.awt.*;

/**
 * This is an icon that can be used to represent a directory. This icon can be 
 * one of two sizes, 16x20 and 48x64. The smaller of the two is the default size 
 * and is intended for things like JFileChoosers, while the larger is intended 
 * for situations where a larger directory icon is more desirable.
 * @author Milo Steier
 */
public class DirectoryIcon extends AbstractFileIcon{
    /**
     * The color for the inner back part of the folder.
     */
    protected static final Color INNER_FOLDER_COLOR = new Color(0xF2D06D);
    /**
     * The color for the outline of the inner back part of the folder.
     */
    protected static final Color INNER_FOLDER_OUTLINE = new Color(0xB0964F);
    /**
     * The color for the outer front part of the folder.
     */
    protected static final Color OUTER_FOLDER_COLOR = new Color(0xFFE89F);
    /**
     * The color for the outline of the outer front part of the folder.
     */
    protected static final Color OUTER_FOLDER_OUTLINE = new Color(0xD1B35E);
    /**
     * This stores the amount of points in both the inner and outer polygons.
     */
    private static final int N_POINTS = 6;
    /**
     * This stores the polygon used to render the inner portion of the folder.
     */
    private Polygon innerFolder;
    /**
     * This stores the polygon used to render the outer portion of the folder.
     */
    private Polygon outerFolder;
    /**
     * This constructs a DirectoryIcon. The icon will be 16x20.
     */
    public DirectoryIcon(){
        this(false);
    }
    /**
     * This constructs a DirectoryIcon. The size of the icon is dependent on the 
     * given value. If the given value is true, then this icon will be 48x64. 
     * If the given value is false, then this icon will be 16x20.
     * @param isLarge Whether the icon should be large (true for a 48x64 icon, 
     * false for a 16x20 icon).
     */
    public DirectoryIcon(boolean isLarge){
        super(isLarge);
        initialize();
    }
    /**
     * This initializes the polygons for the {@link #getInnerFolderPolygon() 
     * inner} and {@link #getOuterFolderPolygon() outer} portions of the folder.
     * @see #getInnerFolderPolygon() 
     * @see #getOuterFolderPolygon() 
     * @see #isLargeIcon() 
     * @see #getIconWidth() 
     * @see #getIconHeight() 
     * @see #getFolderTabWidth() 
     * @see #getFolderTabHeight() 
     * @see #getHeightAdjustment() 
     */
    protected final void initialize(){
        int width = getIconWidth()-1;           // Get the width for the folder
        int height = getIconHeight()-1;         // Get the height for the folder
        int tabWidth = getFolderTabWidth();     // Get the width for the folder tab
        int hAdjust = getHeightAdjustment();    // Get the height adjustment
            // A two dimensional array to contain the x-coordinates of the polygons
        int[][] xPoints = new int[2][N_POINTS];
            // A two dimensional array to contain the y-coordinates of the polygons
        int[][] yPoints = new int[xPoints.length][N_POINTS];
            // Go through the array of x-coordinate arrays and set the first and 
        for (int[] x : xPoints) {       // fifth values
            x[0] = 0;
            x[4] = width - tabWidth;
        }
        xPoints[0][2] = width;
        xPoints[1][2] = xPoints[1][4] - tabWidth;
            // Go through the array of x-coordinate arrays and copy the even 
        for (int[] x : xPoints){    // indexes into the next odd index (Each 
                // x-coordinate should appear twice in a row)
            for (int i = 1; i < x.length; i+=2){
                x[i] = x[i-1];
            }
        }   // An array containing the values to add to the 2nd, 3rd, and 4th 
            // y-coordinate to get the 3rd, 4th, and 5th y-coordinate respectively
            // (The first value is substituted for the 6th y-coordinate for the 
            // respective polygon)
        int[] tempArr = new int[]{0, tabWidth-getFolderTabHeight(),-1*tabWidth};
            // A for loop to set the y-coordinates of each polygon
        for (int i = 0; i < yPoints.length; i++){
            yPoints[i][0] = 0;
            yPoints[i][1] = height - hAdjust;
            yPoints[i][5] = hAdjust * i;
            tempArr[0] = yPoints[i][5];
                // A for loop to derive the 3rd, 4th, and 5th y-coordinates from 
                // the 2nd, 3rd, and 4th y-coordinates, respectively
            for (int t = 0; t < tempArr.length; t++){
                yPoints[i][2+t] = yPoints[i][1+t] + tempArr[t];
            }
        }
        innerFolder = new Polygon(xPoints[0],yPoints[0],N_POINTS);
        outerFolder = new Polygon(xPoints[1],yPoints[1],N_POINTS);
    }
    /**
     * This returns the polygon used to render the inner portion of the folder.
     * @return The inner folder polygon.
     * @see #getOuterFolderPolygon() 
     * @see #getIconWidth() 
     * @see #getIconHeight() 
     * @see #getFolderTabWidth() 
     * @see #getFolderTabHeight() 
     * @see #getHeightAdjustment() 
     * @see #isLargeIcon() 
     */
    protected final Polygon getInnerFolderPolygon(){
        return innerFolder;
    }
    /**
     * This returns the polygon used to render the outer portion of the folder.
     * @return The outer folder polygon.
     * @see #getInnerFolderPolygon() 
     * @see #getIconWidth() 
     * @see #getIconHeight() 
     * @see #getFolderTabWidth() 
     * @see #getFolderTabHeight() 
     * @see #getHeightAdjustment() 
     * @see #isLargeIcon() 
     */
    protected final Polygon getOuterFolderPolygon(){
        return outerFolder;
    }
    @Override
    public void paintIcon2D(Component c, Graphics2D g, int x, int y) {
        g.translate(x, y);
            // Draw the inner portion of the folder
        paintOpaqueShape(g, innerFolder, INNER_FOLDER_OUTLINE, INNER_FOLDER_COLOR);
            // Draw the outer portion of the folder
        paintOpaqueShape(g, outerFolder, OUTER_FOLDER_OUTLINE, OUTER_FOLDER_COLOR);
    }
    /**
     * This returns the width of the tab for the folder.
     * @return 9 if this is a large icon, 2 for small icons.
     * @see #isLargeIcon() 
     * @see #getFolderTabHeight() 
     */
    protected int getFolderTabWidth(){
            // If this is a large icon, return 9. Otherwise, return 3.
        return (isLargeIcon()) ? 9 : 3;
    }
    /**
     * This returns the height of the tab for the folder.
     * @return 24 if this is a large icon, 7 for small icons.
     * @see #isLargeIcon() 
     * @see #getFolderTabWidth() 
     */
    protected int getFolderTabHeight(){
            // If this is a large icon, return 24. Otherwise, return 7.
        return (isLargeIcon()) ? 24 : 7;
    }
    /**
     * This returns the amount by which both parts of the folder is shorter than 
     * the height of the icon.
     * @return 8 if this is a large icon, 2 for small icons.
     * @see #isLargeIcon() 
     * @see #getIconHeight() 
     */
    protected int getHeightAdjustment(){
            // If this is a large icon, return 8. Otherwise, return 2.
        return (isLargeIcon()) ? 8 : 2;
    }
}
