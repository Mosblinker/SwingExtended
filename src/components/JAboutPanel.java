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
public class JAboutPanel extends JPanel{
    
    public static final String CLOSE_SELECTED = "CloseSelected";
    
    public static final String UPDATE_CHECK_SELECTED = "CheckForUpdatesSelected";
    
    public static final String OPEN_WEBSITE_SELECTED = "OpenWebsiteSelected";
    
    public static final String COPY_WEBSITE_SELECTED = "CopyWebsiteSelected";
    
    private void initializeDetailsLabel(JLabel label, Handler handler, 
            boolean visible){
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
    }
    
    private void initialize(){
            // A handler to listen to the components
        Handler handler = new Handler();
            // Create the icon label
        iconLabel = new JThumbnailLabel();
        iconLabel.setImageAlwaysScaled(true);
        iconLabel.setVerticalAlignment(SwingConstants.TOP);
        iconLabel.setMinimumSize(new Dimension(128,iconLabel.getMinimumSize().height));
        iconLabel.setPreferredSize(new Dimension(128,iconLabel.getPreferredSize().height));
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
        nameLabel = new JLabel();
        nameLabel.setFont(deriveFont(Font.BOLD,9));
        initializeDetailsLabel(nameLabel,handler,true);
            // Create and add the version label
        versionLabel = new JLabel();
        versionLabel.setFont(deriveFont(Font.BOLD|Font.ITALIC,5));
        initializeDetailsLabel(versionLabel,handler,false);
            // Create and add the copyright label
        copyrightLabel = new JLabel();
        initializeDetailsLabel(versionLabel,handler,false);
            // Create and add the website label
        websiteLabel = new JHyperlinkLabel();
        initializeDetailsLabel(websiteLabel,handler,false);
            // Create a popup menu for the website label
        websitePopup = new JPopupMenu();
            // Create a menu item for opening the link
        websiteOpenItem = new JMenuItem("Open Link");
        websiteOpenItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, 0));
        websiteOpenItem.setActionCommand(OPEN_WEBSITE_SELECTED);
        websiteOpenItem.addActionListener(handler);
            // Add the open menu item to the popup menu for the website label
        websitePopup.add(websiteOpenItem);
            // Create a menu item for copying the link
        websiteCopyItem = new JMenuItem("Copy Link");
        websiteCopyItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, 0));
        websiteCopyItem.setActionCommand(COPY_WEBSITE_SELECTED);
        websiteCopyItem.addActionListener(handler);
            // Add the copy menu item to the popup menu for the website label
        websitePopup.add(websiteCopyItem);
            // Set the popup menu for the website label
        websiteLabel.setComponentPopupMenu(websitePopup);
            // Create the credits panel
        creditsPanel = new JPanel(new BorderLayout());
        creditsPanel.setBorder(BorderFactory.createTitledBorder("Credits"));
            // Add the credits panel to the details panel
        detailsPanel.add(creditsPanel);
        
        creditsTextPane = new JTextPane();
        creditsTextPane.setEditable(false);
        creditsScrollPane = new JScrollPane(creditsTextPane);
        creditsPanel.add(creditsScrollPane, BorderLayout.CENTER);
        
            // Create the bottom panel
        bottomPanel = new JPanel(new BorderLayout());
            // Create the button panel
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        
        updateButton = new JButton("Check For Updates");
        updateButton.setActionCommand(UPDATE_CHECK_SELECTED);
        updateButton.addActionListener(handler);
        updateButton.addComponentListener(handler);
        buttonPanel.add(updateButton);
            // Create a filler object to go after the button
        Box.Filler filler = new Box.Filler(new Dimension(6, 0), 
                new Dimension(6, 0), new Dimension(6, 32767));
        buttonPanel.add(filler);
        fillerMap.put(updateButton, filler);
        closeButton = new JButton("OK");
        closeButton.setActionCommand(CLOSE_SELECTED);
        closeButton.addActionListener(handler);
        buttonPanel.add(closeButton);
        
            // Add the button panel to the bottom panel
        bottomPanel.add(buttonPanel, BorderLayout.LINE_END);
            // Add the bottom panel to this panel
        add(bottomPanel, BorderLayout.PAGE_END);
    }
    
    public JAboutPanel(){
        super(new BorderLayout(18, 7));
        initialize();
    }
    
    @Override
    public void setFont(Font font){
        super.setFont(font);
        font = getFont();
        try{
            iconLabel.setFont(font);
            nameLabel.setFont(deriveFont(Font.BOLD,9));
            versionLabel.setFont(deriveFont(Font.BOLD|Font.ITALIC,5));
            copyrightLabel.setFont(font);
            websiteLabel.setFont(font);
            creditsTextPane.setFont(font);
            updateButton.setFont(font);
            closeButton.setFont(font);
        } catch (NullPointerException ex) {}
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
    
    private Map<Component,Component> fillerMap = new HashMap<>();
    protected JThumbnailLabel iconLabel;
    protected JPanel detailsPanel;
    protected JLabel nameLabel;
    protected JLabel versionLabel;
    protected JLabel copyrightLabel;
    protected JHyperlinkLabel websiteLabel;
    protected JPanel creditsPanel;
    protected JScrollPane creditsScrollPane;
    protected JTextPane creditsTextPane;
    protected JPanel bottomPanel;
    protected JPanel buttonPanel;
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
