/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package graphics;

import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.awt.geom.AffineTransform;
import java.awt.image.*;
import java.awt.image.renderable.RenderableImage;
import java.io.IOException;
import java.text.AttributedCharacterIterator;
import java.util.Map;
import java.util.Objects;
import net.coobird.thumbnailator.Thumbnails;

/**
 *
 * @author Milo Steier
 */
public class ThumbnailGraphics2D extends Graphics2D{
    
    protected final Graphics2D graphics;
    
    public ThumbnailGraphics2D(Graphics2D graphics){
        this.graphics = Objects.requireNonNull(graphics);
    }
    
//    protected BufferedImage toBufferedImage(Image image){
//        
//    }
    @Override
    public void draw(Shape s) {
        graphics.draw(s);
    }
    @Override
    public boolean drawImage(Image img, AffineTransform xform, ImageObserver obs) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    @Override
    public void drawImage(BufferedImage img, BufferedImageOp op, int x, int y) {
        graphics.drawImage(img, op, x, y);
    }
    @Override
    public void drawRenderedImage(RenderedImage img, AffineTransform xform) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    @Override
    public void drawRenderableImage(RenderableImage img, AffineTransform xform) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public void drawString(String str, int x, int y) {
        graphics.drawString(str, x, y);
    }
    @Override
    public void drawString(String str, float x, float y) {
        graphics.drawString(str, x, y);
    }
    @Override
    public void drawString(AttributedCharacterIterator iterator, int x, int y) {
        graphics.drawString(iterator, x, y);
    }
    @Override
    public void drawString(AttributedCharacterIterator iterator, float x, float y) {
        graphics.drawString(iterator, x, y);
    }
    @Override
    public void drawGlyphVector(GlyphVector g, float x, float y) {
        graphics.drawGlyphVector(g, x, y);
    }
    @Override
    public void fill(Shape s) {
        graphics.fill(s);
    }
    @Override
    public boolean hit(Rectangle rect, Shape s, boolean onStroke) {
        return graphics.hit(rect, s, onStroke);
    }
    @Override
    public GraphicsConfiguration getDeviceConfiguration() {
        return graphics.getDeviceConfiguration();
    }
    @Override
    public void setComposite(Composite comp) {
        graphics.setComposite(comp);
    }
    @Override
    public void setPaint(Paint paint) {
        graphics.setPaint(paint);
    }
    @Override
    public void setStroke(Stroke s) {
        graphics.setStroke(s);
    }
    @Override
    public void setRenderingHint(RenderingHints.Key hintKey, Object hintValue) {
        graphics.setRenderingHint(hintKey, hintValue);
    }
    @Override
    public Object getRenderingHint(RenderingHints.Key hintKey) {
        return graphics.getRenderingHint(hintKey);
    }
    @Override
    public void setRenderingHints(Map<?, ?> hints) {
        graphics.setRenderingHints(hints);
    }
    @Override
    public void addRenderingHints(Map<?, ?> hints) {
        graphics.addRenderingHints(hints);
    }
    @Override
    public RenderingHints getRenderingHints() {
        return graphics.getRenderingHints();
    }
    @Override
    public void translate(int x, int y) {
        graphics.translate(x, y);
    }
    @Override
    public void translate(double tx, double ty) {
        graphics.translate(tx, ty);
    }
    @Override
    public void rotate(double theta) {
        graphics.rotate(theta);
    }
    @Override
    public void rotate(double theta, double x, double y) {
        graphics.rotate(theta, x, y);
    }
    @Override
    public void scale(double sx, double sy) {
        graphics.scale(sx, sy);
    }
    @Override
    public void shear(double shx, double shy) {
        graphics.shear(shx, shy);
    }
    @Override
    public void transform(AffineTransform Tx) {
        graphics.transform(Tx);
    }
    @Override
    public void setTransform(AffineTransform Tx) {
        graphics.setTransform(Tx);
    }
    @Override
    public AffineTransform getTransform() {
        return graphics.getTransform();
    }
    @Override
    public Paint getPaint() {
        return graphics.getPaint();
    }
    @Override
    public Composite getComposite() {
        return graphics.getComposite();
    }
    @Override
    public void setBackground(Color color) {
        graphics.setBackground(color);
    }
    @Override
    public Color getBackground() {
        return graphics.getBackground();
    }
    @Override
    public Stroke getStroke() {
        return graphics.getStroke();
    }
    @Override
    public void clip(Shape s) {
        graphics.clip(s);
    }
    @Override
    public FontRenderContext getFontRenderContext() {
        return graphics.getFontRenderContext();
    }
    @Override
    public Graphics2D create() {
        return new ThumbnailGraphics2D((Graphics2D)graphics.create());
    }
    @Override
    public Color getColor() {
        return graphics.getColor();
    }
    @Override
    public void setColor(Color c) {
        graphics.setColor(c);
    }
    @Override
    public void setPaintMode() {
        graphics.setPaintMode();
    }
    @Override
    public void setXORMode(Color c1) {
        graphics.setXORMode(c1);
    }
    @Override
    public Font getFont() {
        return graphics.getFont();
    }
    @Override
    public void setFont(Font font) {
        graphics.setFont(font);
    }
    @Override
    public FontMetrics getFontMetrics(Font f) {
        return graphics.getFontMetrics();
    }
    @Override
    public Rectangle getClipBounds() {
        return graphics.getClipBounds();
    }
    @Override
    public void clipRect(int x, int y, int width, int height) {
        graphics.clearRect(x, y, width, height);
    }
    @Override
    public void setClip(int x, int y, int width, int height) {
        graphics.setClip(x, y, width, height);
    }
    @Override
    public Shape getClip() {
        return graphics.getClip();
    }
    @Override
    public void setClip(Shape clip) {
        graphics.setClip(clip);
    }
    @Override
    public void copyArea(int x, int y, int width, int height, int dx, int dy) {
        graphics.copyArea(x, y, width, height, dx, dy);
    }
    @Override
    public void drawLine(int x1, int y1, int x2, int y2) {
        graphics.drawLine(x1, y1, x2, y2);
    }
    @Override
    public void fillRect(int x, int y, int width, int height) {
        graphics.fillRect(x, y, width, height);
    }
    @Override
    public void clearRect(int x, int y, int width, int height) {
        graphics.clearRect(x, y, width, height);
    }
    @Override
    public void drawRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight) {
        graphics.drawRoundRect(x, y, width, height, arcWidth, arcHeight);
    }
    @Override
    public void fillRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight) {
        graphics.fillRoundRect(x, y, width, height, arcWidth, arcHeight);
    }
    @Override
    public void drawOval(int x, int y, int width, int height) {
        graphics.drawOval(x, y, width, height);
    }
    @Override
    public void fillOval(int x, int y, int width, int height) {
        graphics.fillOval(x, y, width, height);
    }
    @Override
    public void drawArc(int x, int y, int width, int height, int startAngle, int arcAngle) {
        graphics.drawArc(x, y, width, height, startAngle, arcAngle);
    }
    @Override
    public void fillArc(int x, int y, int width, int height, int startAngle, int arcAngle) {
        graphics.fillArc(x, y, width, height, startAngle, arcAngle);
    }
    @Override
    public void drawPolyline(int[] xPoints, int[] yPoints, int nPoints) {
        graphics.drawPolyline(xPoints, yPoints, nPoints);
    }
    @Override
    public void drawPolygon(int[] xPoints, int[] yPoints, int nPoints) {
        graphics.drawPolygon(xPoints, yPoints, nPoints);
    }
    @Override
    public void fillPolygon(int[] xPoints, int[] yPoints, int nPoints) {
        graphics.fillPolygon(xPoints, yPoints, nPoints);
    }
    @Override
    public boolean drawImage(Image img, int x, int y, ImageObserver observer) {
        return graphics.drawImage(img, x, y, observer);
    }
    @Override
    public boolean drawImage(Image img, int x, int y, Color bgcolor, ImageObserver observer) {
        return graphics.drawImage(img, x, y, bgcolor, observer);
    }
    
    protected Image scaleImage(Image img, int width, int height){
        if (img instanceof BufferedImage){
            try{
                img = Thumbnails.of((BufferedImage)img).size(width, height).asBufferedImage();
            } catch (IOException ex) {}
        }
        return img;
    }
    @Override
    public boolean drawImage(Image img, int x, int y, int width, int height, ImageObserver observer) {
        return graphics.drawImage(scaleImage(img,width,height), x, y, width, height, observer);
    }
    @Override
    public boolean drawImage(Image img, int x, int y, int width, int height, Color bgcolor, ImageObserver observer) {
        return graphics.drawImage(scaleImage(img,width,height), x, y, width, height, bgcolor, observer);
    }
    @Override
    public boolean drawImage(Image img, int dx1, int dy1, int dx2, int dy2, int sx1, int sy1, int sx2, int sy2, ImageObserver observer) {
        return graphics.drawImage(img, dx1, dy1, dx2, dy2, sx1, sy1, sx2, sy2, observer);
    }
    @Override
    public boolean drawImage(Image img, int dx1, int dy1, int dx2, int dy2, int sx1, int sy1, int sx2, int sy2, Color bgcolor, ImageObserver observer) {
        return graphics.drawImage(img, dx1, dy1, dx2, dy2, sx1, sy1, sx2, sy2, bgcolor, observer);
    }
    @Override
    public void dispose() {
        graphics.dispose();
    }
}
