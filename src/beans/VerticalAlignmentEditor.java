/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans;

/**
 * This is a PropertyEditor for selecting the vertical alignment to use.
 * @author Milo Steier
 */
public class VerticalAlignmentEditor extends SwingConstantsPropertyEditor{
    /**
     * This constructs a VerticalAlignmentEditor object.
     */
    public VerticalAlignmentEditor(){
        super();
    }
    /**
     * This constructs a VerticalAlignmentEditor object.
     * @param source The source used for event firing.
     */
    public VerticalAlignmentEditor(Object source){
        super(source);
    }
    @Override
    public String[] getTags() {
        return new String[]{
            "TOP",
            "CENTER",
            "BOTTOM"
        };
    }
    @Override
    public Object[] getValues() {
        return new Object[]{
            javax.swing.SwingConstants.TOP,
            javax.swing.SwingConstants.CENTER,
            javax.swing.SwingConstants.BOTTOM
        };
    }
}
