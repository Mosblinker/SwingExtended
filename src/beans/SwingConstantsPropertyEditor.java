/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans;

/**
 * This is an EnumeratedPropertyEditor that implements SwingConstants. This is 
 * provided for ease of creating EnumeratedPropertyEditors that use 
 * SwingConstants.
 * @author Milo Steier
 */
public abstract class SwingConstantsPropertyEditor extends EnumeratedPropertyEditor 
        implements javax.swing.SwingConstants{
    /**
     * This constructs a SwingConstantsPropertyEditor object.
     */
    public SwingConstantsPropertyEditor(){
        super();
    }
    /**
     * This constructs a SwingConstantsPropertyEditor object.
     * @param source The source used for event firing.
     */
    public SwingConstantsPropertyEditor(Object source){
        super(source);
    }
    @Override
    public String getNameForValue(Object value){
        return "javax.swing.SwingConstants."+getTagForValue(value);
    }
}
