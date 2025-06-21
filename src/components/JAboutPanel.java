/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package components;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 * This is a panel that can be used to display information about a program.
 * @author Mosblinker
 */
public class JAboutPanel extends AbstractDialogPanel{
    
    public static final int CLOSE_OPTION = 0;
    
    public static final String CLOSE_SELECTED = "CloseSelected";
    
    public static final String UPDATE_CHECK_SELECTED = "CheckForUpdatesSelected";
    
    public static final String OPEN_WEBSITE_SELECTED = "OpenWebsiteSelected";
    
    public static final String COPY_WEBSITE_SELECTED = "CopyWebsiteSelected";
    
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
    
    private String websiteURL = null;
    private String websiteText = null;
    protected JThumbnailLabel iconLabel;
    protected JLabel nameLabel;
    protected JLabel versionLabel;
    protected JLabel copyrightLabel;
    protected JLabel websiteLabel;
    protected JPanel creditsPanel;
    protected JScrollPane creditsScrollPane;
    protected JTextPane creditsTextPane;
    protected JButton closeButton;
    protected JButton updateButton;
    protected JPopupMenu websitePopup;
    protected JMenuItem websiteOpenItem;
    protected JMenuItem websiteCopyItem;
    
    private class Handler implements PropertyChangeListener, DocumentListener, 
            ActionListener{
        @Override
        public void propertyChange(PropertyChangeEvent evt) {
            
        }
        @Override
        public void insertUpdate(DocumentEvent evt) {
            
        }
        @Override
        public void removeUpdate(DocumentEvent evt) {
            
        }
        @Override
        public void changedUpdate(DocumentEvent evt) {
            
        }
        @Override
        public void actionPerformed(ActionEvent evt) {
            
        }
    }
}
