/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package components;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.HashMap;
import java.util.Map;
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
    
    private JLabel createDetailsLabel(Handler handler, boolean visible){
            // Create the label to use
        JLabel label = new JLabel();
        label.addPropertyChangeListener("text",handler);
        label.addComponentListener(handler);
            // Center the label's alignment
        label.setAlignmentX(0.5f);
            // Add the label to the details panel
        detailsPanel.add(label);
            // Create a filler object to go under the label
        Box.Filler filler = new Box.Filler(new Dimension(0, 7), 
                new Dimension(0, 7), new Dimension(32767, 7));
            // Add the label and filler object to the filler map
        fillerMap.put(label, filler);
            // Add the filler object to the details panel
        detailsPanel.add(filler);
        label.setVisible(visible);
        return label;
    }
    
    private void initialize(){
            // A handler to listen to the components
        Handler handler = new Handler();
            // Create the icon label
        iconLabel = new JThumbnailLabel();
        iconLabel.setImageAlwaysScaled(true);
        iconLabel.setVerticalAlignment(SwingConstants.TOP);
        iconLabel.addPropertyChangeListener("icon", handler);
            // Put the icon label on the left side of the panel
        add(iconLabel, BorderLayout.LINE_START);
            // Hide the icon label for now
        iconLabel.setVisible(false);
            // Create a details panel to display the labels and stuff
        detailsPanel = new JPanel();
        detailsPanel.setLayout(new BoxLayout(detailsPanel, BoxLayout.Y_AXIS));
            // Put the details panel in the center of the panel
        add(detailsPanel, BorderLayout.CENTER);
            // Create and add the program name label
        nameLabel = createDetailsLabel(handler,true);
        nameLabel.setFont(deriveFont(Font.BOLD,9));
            // Create and add the version label
        versionLabel = createDetailsLabel(handler,false);
        versionLabel.setFont(deriveFont(Font.BOLD|Font.ITALIC,5));
            // Create and add the copyright label
        copyrightLabel = createDetailsLabel(handler,false);
            // Create and add the website label
        websiteLabel = createDetailsLabel(handler,false);
        
            // TODO: Set up website popup menu and website label clicking code
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
    /**
     * 
     * @param relStyle
     * @param relSize
     * @return 
     */
    protected Font deriveFont(int relStyle, float relSize){
        Font font = getFont();
        if (font == null)
            font = new Font(Font.SANS_SERIF,Font.PLAIN,0);
        return font.deriveFont(font.getStyle() | relStyle, font.getSize2D() + relSize);
    }
    /**
     * 
     * @param evt 
     */
    protected void updateFillerVisibility(ComponentEvent evt){
            // Get the filler next to the component
        Component filler = fillerMap.get(evt.getComponent());
            // If the component has a filler component next to it
        if (filler != null)
            filler.setVisible(evt.getComponent().isVisible());
    }
    
    private String websiteURL = null;
    private String websiteText = null;
    private Map<Component,Component> fillerMap = new HashMap<>();
    protected JThumbnailLabel iconLabel;
    protected JPanel detailsPanel;
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
    
    private class Handler extends ComponentAdapter implements 
            PropertyChangeListener, DocumentListener, ActionListener{
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
        @Override
        public void componentHidden(ComponentEvent evt) {
            updateFillerVisibility(evt);
        }
        @Override
        public void componentShown(ComponentEvent evt) {
            updateFillerVisibility(evt);
        }
    }
}
