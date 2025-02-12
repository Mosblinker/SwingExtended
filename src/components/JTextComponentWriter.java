/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package components;

import java.io.*;
import javax.swing.text.JTextComponent;

/**
 * This is a character stream that collects its output in a string buffer, which 
 * can then be used to write the output to a {@code JTextComponent}. <p>
 * 
 * When a {@code JTextComponentWriter} is flushed, the contents of its buffer 
 * will be appended to its text component, after which the buffer will be 
 * cleared. <p>
 * 
 * Closing a {@code JTextComponentWriter} has no effect, similar to how closing 
 * a {@code StringWriter} has no effect. The methods in this class can be called 
 * after this stream is closed without generating an {@code IOException}.
 * @author Milo Steier
 * @see JTextComponent
 * @see StringWriter
 */
public class JTextComponentWriter extends Writer{
    /**
     * This is the text component to write to.
     */
    private final JTextComponent component;
    /**
     * This is the StringWriter to use as a buffer for the output.
     */
    private final StringWriter buffer;
    /**
     * This constructs a {@code JTextComponentWriter} that will write its output 
     * to the given text component.
     * @param component The text component to write the output to (cannot be 
     * null).
     * @throws NullPointerException If the given text component is null.
     */
    public JTextComponentWriter(JTextComponent component){
            // If the given text component is null
        if (component == null)
            throw new NullPointerException();
        this.component = component;
        buffer = new StringWriter();
    }
    
    public JTextComponent getTextComponent(){
        return component;
    }
    
    public StringWriter getBuffer(){
        return buffer;
    }
    
    @Override
    public void write(int c){
        buffer.write(c);
    }
    @Override
    public void write(char[] cbuf){
        try{
            buffer.write(cbuf);
        } catch (IOException ex) {}
    }
    @Override
    public void write(char[] cbuf, int off, int len) {
        buffer.write(cbuf, off, len);
    }
    @Override
    public void write(String str){
        buffer.write(str);
    }
    @Override
    public void write(String str, int off, int len){
        buffer.write(str, off, len);
    }
    @Override
    public JTextComponentWriter append(CharSequence csq){
        buffer.append(csq);
        return this;
    }
    @Override
    public JTextComponentWriter append(CharSequence csq, int start, int end){
        buffer.append(csq, start, end);
        return this;
    }
    @Override
    public JTextComponentWriter append(char c){
        buffer.append(c);
        return this;
    }
    /**
     * {@inheritDoc }
     */
    @Override
    public void flush() {
            // Flush the buffer StringWriter
        buffer.flush();
            // Get the buffer's current length
        int length = buffer.getBuffer().length();
            // If the buffer is not empty
        if (length != 0){
                // Append the text in the buffer to the component's text
            component.setText(component.getText()+buffer.toString());
                // Clear the buffer
            buffer.getBuffer().delete(0, length);
        }
    }
    /**
     * {@inheritDoc }
     * @throws IOException {@inheritDoc }
     */
    @Override
    public void close() throws IOException {
        buffer.close();
    }
    /**
     * This returns a String representation of this {@code 
     * JTextComponentWriter}. 
     * This method is primarily intended to be used only for debugging purposes, 
     * and the content and format of the returned String may vary between 
     * implementations.
     * @return A String representation of this {@code JTextComponentWriter}.
     */
    protected String paramString(){
        return "component="+getTextComponent()+
                ",buffer=\""+buffer.toString()+"\"";
    }
    /**
     * This returns a string representation of this writer and its values.
     * @return A string representation of this writer and its values.
     */
    @Override
    public String toString(){
        return getClass().getName()+"["+paramString()+"]";
    }
}
