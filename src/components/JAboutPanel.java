/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package components;

import java.awt.BorderLayout;
import javax.swing.*;

/**
 * This is a panel that can be used to display information about a program.
 * @author Mosblinker
 */
public class JAboutPanel extends AbstractDialogPanel{
    
    public static final int CLOSE_OPTION = 0;
    
    public static final String CLOSE_SELECTED = "CloseSelected";
    
    private void initialize(){
        
    }
    
    public JAboutPanel(){
        super(new BorderLayout(18, 7));
        initialize();
    }

    @Override
    protected String getDialogClosingCommand() {
        return CLOSE_SELECTED;
    }
    @Override
    protected int getOptionForCommand(String command) {
        if (command != null){           // If the command is not null
            switch(command){
                case(CLOSE_SELECTED):   // If the command is the close command
                    return CLOSE_OPTION;
            }
        }
        return ERROR_OPTION;
    }
    @Override
    protected String getOptionString(int option) {
        switch(option){
            case(CLOSE_OPTION):             // If this is the close option
                return "CLOSE_OPTION";
            default:
                return null;
        }
    }
}
