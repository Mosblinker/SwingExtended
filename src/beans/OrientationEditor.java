/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans;

/**
 * This is a PropertyEditor for selecting the orientation for something, either 
 * {@link javax.swing.SwingConstants#HORIZONTAL horizontal} or {@link 
 * javax.swing.SwingConstants#VERTICAL vertical}.
 * @author Milo Steier
 * @see javax.swing.SwingConstants
 * @see javax.swing.SwingConstants#HORIZONTAL
 * @see javax.swing.SwingConstants#VERTICAL
 */
public class OrientationEditor extends SwingConstantsPropertyEditor{
    /**
     * This constructs an OrientationEditor object.
     */
    public OrientationEditor(){
        super();
    }
    /**
     * This constructs an OrientationEditor object.
     * @param source The source used for event firing.
     */
    public OrientationEditor(Object source){
        super(source);
    }
    @Override
    public String[] getTags() {
        return new String[]{
            "HORIZONTAL",
            "VERTICAL"
        };
    }
    @Override
    public Object[] getValues() {
        return new Object[]{
            HORIZONTAL,
            VERTICAL
        };
    }

}
