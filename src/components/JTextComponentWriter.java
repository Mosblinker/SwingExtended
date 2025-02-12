/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package components;

import java.io.*;
import java.util.Objects;
import javax.swing.text.JTextComponent;

/**
 * This is a character stream that collects its output in a string buffer, which 
 * can then be used to write the output to a {@code JTextComponent}.
 * @author Mosblinker
 */
public class JTextComponentWriter extends Writer{
    
    private final JTextComponent component;
    
    private final StringWriter buffer;
    
    public JTextComponentWriter(JTextComponent component){
        this.component = Objects.requireNonNull(component);
        buffer = new StringWriter();
    }
    
    public JTextComponent getTextComponent(){
        return component;
    }
    
    protected StringWriter getBuffer(){
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
        component.setText(component.getText()+buffer.toString());
        buffer.getBuffer().delete(0, buffer.getBuffer().length());
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
