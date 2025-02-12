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
    /**
     * This returns the text component to which this stream writes its output 
     * to.
     * @return The text component that this writes its output to.
     */
    public JTextComponent getTextComponent(){
        return component;
    }
    /**
     * This returns the {@code StringWriter} that is used internally as a buffer 
     * for the output of this character stream.
     * @return The {@code StringWriter} holding the current buffer value.
     */
    public StringWriter getBuffer(){
        return buffer;
    }
    /**
     * This writes a single character.
     * @param c {@inheritDoc }
     */
    @Override
    public void write(int c){
        buffer.write(c);
    }
    /**
     * {@inheritDoc }
     * @param cbuf {@inheritDoc }
     */
    @Override
    public void write(char[] cbuf){
        try{
            buffer.write(cbuf);
        } catch (IOException ex) {}
    }
    /**
     * {@inheritDoc }
     * @param cbuf {@inheritDoc }
     * @param off {@inheritDoc }
     * @param len {@inheritDoc }
     * @throws IndexOutOfBoundsException If either {@code off} is negative, 
     * {@code len} is negative, or if {@code off + len} is either negative or 
     * greater than the length of the given array.
     */
    @Override
    public void write(char[] cbuf, int off, int len) {
        buffer.write(cbuf, off, len);
    }
    /**
     * {@inheritDoc }
     * @param str {@inheritDoc }
     */
    @Override
    public void write(String str){
        buffer.write(str);
    }
    /**
     * {@inheritDoc }
     * @param str The string to be written
     * @param off {@inheritDoc }
     * @param len {@inheritDoc }
     * @throws IndexOutOfBoundsException If either {@code off} is negative, 
     * {@code len} is negative, or if {@code off + len} is either negative or 
     * greater than the length of the given string.
     */
    @Override
    public void write(String str, int off, int len){
        buffer.write(str, off, len);
    }
    /**
     * {@inheritDoc }
     * @param csq {@inheritDoc }
     * @return {@inheritDoc }
     */
    @Override
    public JTextComponentWriter append(CharSequence csq){
        buffer.append(csq);
        return this;
    }
    /**
     * {@inheritDoc }
     * @param csq {@inheritDoc }
     * @param start {@inheritDoc }
     * @param end {@inheritDoc }
     * @return {@inheritDoc }
     * @throws IndexOutOfBoundsException If either {@code start} or {@code end} 
     * are negative, {@code start} is greater than {@code end}, or if {@code 
     * end} is greater than {@code csq.length()}.
     */
    @Override
    public JTextComponentWriter append(CharSequence csq, int start, int end){
        buffer.append(csq, start, end);
        return this;
    }
    /**
     * {@inheritDoc }
     * @param c {@inheritDoc }
     * @return {@inheritDoc }
     */
    @Override
    public JTextComponentWriter append(char c){
        buffer.append(c);
        return this;
    }
    /**
     * This flushes this stream, writing any characters in its buffer to the end 
     * of the {@link #getTextComponent() text component}. The buffer will be 
     * empty after this is called.
     * @see #getTextComponent() 
     * @see #getBuffer() 
     * @see JTextComponent#getText() 
     * @see JTextComponent#setText(String) 
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
     * This method has no effect, as closing a {@code JTextComponentWriter} has 
     * no effect. The methods in this class can be called after this stream has 
     * been closed without generating an {@code IOException}.
     * @throws IOException If an I/O error occurs. 
     */
    @Override
    public void close() throws IOException {
        buffer.close();
    }
    /**
     * This returns a String representation of this {@code 
     * JTextComponentWriter}. This method is primarily intended to be used only 
     * for debugging purposes, and the content and format of the returned String 
     * may vary between implementations.
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
