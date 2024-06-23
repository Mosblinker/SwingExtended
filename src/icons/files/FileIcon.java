/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package icons.files;

import java.awt.*;
import java.awt.geom.*;

/**
 * This is an icon that can be used to represent a file. This icon can be one of 
 * two sizes, 16x20 and 48x64. The smaller of the two is the default size and 
 * is intended for things like JFileChoosers, while the larger is intended for 
 * situations where a larger file icon is more desirable.
 * @author Milo Steier
 */
public class FileIcon extends AbstractFileIcon{
    /**
     * The color for the first two lines on the file representing the data in 
     * a file.
     */
    protected static final Color FILE_HEADER_COLOR = new Color(0x0084D7);
    /**
     * The color for most of the lines on the file representing the data in 
     * a file.
     */
    protected static final Color FILE_LINE_COLOR = new Color(0x6B6B6B);
    /**
     * This stores the polygon used to render the file, or at the very least, 
     * render its background.
     */
    private Polygon filePolygon;
    /**
     * This stores the path used to render the outline around the file.
     */
    private Path2D fileOutline;
    /**
     * This constructs a FileIcon. The icon will be 16x20.
     */
    public FileIcon(){
        this(false);
    }
    /**
     * This constructs a FileIcon. The size of the icon is dependent on the 
     * given value. If the given value is true, then this icon will be 48x64. 
     * If the given value is false, then this icon will be 16x20.
     * @param isLarge Whether the icon should be large (true for a 48x64 icon, 
     * false for a 16x20 icon).
     */
    public FileIcon(boolean isLarge){
        super(isLarge);
        initialize();
    }
    /**
     * This initializes the file {@link #getFilePolygon() polygon} and {@link 
     * #getFileOutline() outline}.
     * @see #getIconWidth() 
     * @see #getIconHeight() 
     * @see #getFileFlapSize() 
     * @see #isLargeIcon() 
     * @see #getFilePolygon() 
     * @see #getFileOutline() 
     */
    protected final void initialize(){
        int width = getIconWidth()-1;   // Get the width for the file
        int height = getIconHeight()-1; // Get the height for the file
        int flap = getFileFlapSize();   // Get the size for the file flap
        filePolygon = new Polygon(
                new int[]{0, 0, width, width, width-flap},  // x-coordinates
                new int[]{0, height, height, flap, 0}, 5    // y-coordinates
        );
        fileOutline = new Path2D.Double(filePolygon);
        fileOutline.moveTo(filePolygon.xpoints[filePolygon.npoints-1], 
                filePolygon.ypoints[filePolygon.npoints-1]+0.5);
            // A for loop to add the two lines that complete the flap outline
        for (int f = 0; f < 2; f++){
            fileOutline.lineTo(filePolygon.xpoints[filePolygon.npoints-1-f]-(0.5*f), 
                    filePolygon.ypoints[filePolygon.npoints-2]);
        }
    }
    /**
     * This returns the polygon used to render the file.
     * @return The file polygon.
     * @see #getFileOutline() 
     * @see #getIconWidth() 
     * @see #getIconHeight() 
     * @see #getFileFlapSize() 
     * @see #isLargeIcon() 
     */
    protected final Polygon getFilePolygon(){
        return filePolygon;
    }
    /**
     * This returns the path used to render the outline of the file. This also 
     * includes the outline for the file flap.
     * @return The file outline.
     * @see #getFilePolygon() 
     * @see #getIconWidth() 
     * @see #getIconHeight() 
     * @see #getFileFlapSize() 
     * @see #isLargeIcon() 
     */
    protected final Path2D getFileOutline(){
        return fileOutline;
    }
    @Override
    public void paintIcon2D(Component c, Graphics2D g, int x, int y) {
        g.translate(x, y);
            // Paint the file polygon and outline
        paintOpaqueShape(g,fileOutline,filePolygon,Color.BLACK,Color.WHITE);
        g.setColor(FILE_HEADER_COLOR);
            // A for loop to draw the file lines (8 for small icons, 9 for large icons)
        for (int l = 0; l < 8 || (isLargeIcon() && l < 9); l++){
            drawFileLine(g,l);
            if (l == 1)     // If we have drawn two lines
                g.setColor(FILE_LINE_COLOR);
        }
    }
    /**
     * This is used to draw the lines on the file that represent data in a file. 
     * The first three lines are drawn shorter due to the flap.
     * @param g The graphics context to render to.
     * @param l The number representing which line to draw.
     * @see #getFileFlapSize() 
     * @see #isLargeIcon() 
     * @see #getIconWidth() 
     */
    protected void drawFileLine(Graphics g, int l){
            // The amount to subtract from the length of the file line (the 
            // first 3 lines are shorter due to the flap)
        int f = (l < 3) ? getFileFlapSize() : 0;
        if (isLargeIcon())  // If this is a large icon
            g.fillRect(5, 7+(6*l), getIconWidth()-10-f, 2);
        else
            g.fillRect(2, 2*(l+1), getIconWidth()-4-f, 1);
    }
    /**
     * This returns the width and height for the file flap.
     * @return 18 if this is a large icon, 5 for small icons.
     * @see #isLargeIcon() 
     */
    protected int getFileFlapSize(){
            // If this is a large icon, return 18. Otherwise, return 5.
        return (isLargeIcon()) ? 18 : 5;
    }
}
