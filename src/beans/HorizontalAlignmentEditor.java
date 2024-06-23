/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans;

/**
 * This is a PropertyEditor for selecting the horizontal alignment to use.
 * @author Milo Steier
 */
public class HorizontalAlignmentEditor extends SwingConstantsPropertyEditor{
    /**
     * This constructs a HorizontalAlignmentEditor object.
     */
    public HorizontalAlignmentEditor(){
        super();
    }
    /**
     * This constructs a HorizontalAlignmentEditor object.
     * @param source The source used for event firing.
     */
    public HorizontalAlignmentEditor(Object source){
        super(source);
    }
    @Override
    public String[] getTags() {
        return new String[]{
            "LEFT",
            "CENTER",
            "RIGHT",
            "LEADING",
            "TRAILING"
        };
    }
    @Override
    public Object[] getValues() {
        return new Object[]{
            LEFT,
            CENTER,
            RIGHT,
            LEADING,
            TRAILING
        };
    }
}