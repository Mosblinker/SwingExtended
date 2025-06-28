/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package components;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.datatransfer.Clipboard;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.EditorKit;
import javax.swing.text.StyledDocument;

/**
 * This is a panel that can be used to display information about a program.
 * @author Mosblinker
 */
public class JAboutPanel extends JPanel{
    
    public static final String CLOSE_SELECTED = "CloseSelected";
    
    public static final String UPDATE_SELECTED = "UpdateSelected";
    
    public static final String OPEN_LICENSE_SELECTED = "OpenLicenseSelected";
    
    public static final String OPEN_WEBSITE_SELECTED = "OpenWebsiteSelected";
    
    public static final String COPY_WEBSITE_SELECTED = "CopyWebsiteSelected";
    
    public static final String PROGRAM_ICON_PROPERTY_CHANGED = 
            "ProgramIconPropertyChanged";
    
    public static final String PROGRAM_NAME_PROPERTY_CHANGED = 
            "ProgramNamePropertyChanged";
    
    public static final String PROGRAM_VERSION_PROPERTY_CHANGED = 
            "ProgramVersionPropertyChanged";
    
    public static final String PROGRAM_COPYRIGHT_PROPERTY_CHANGED = 
            "ProgramCopyrightPropertyChanged";
    
    public static final String PROGRAM_WEBSITE_URI_PROPERTY_CHANGED = 
            "ProgramWebsitePropertyChanged";
    
    public static final String PROGRAM_WEBSITE_TEXT_PROPERTY_CHANGED = 
            "ProgramWebsiteTextPropertyChanged";
    
    public static final String PROGRAM_WEBSITE_VISITED_PROPERTY_CHANGED = 
            "ProgramWebsiteVisitedPropertyChanged";
    
    public static final String CREDITS_DOCUMENT_PROPERTY_CHANGED = 
            "CreditsDocumentPropertyChanged";
    
    public static final String CREDITS_EDITOR_KIT_PROPERTY_CHANGED = 
            "CreditsEditorKitPropertyChanged";
    
    public static final String UPDATE_BUTTON_TEXT_PROPERTY_CHANGED = 
            "UpdateTextPropertyChanged";
    
    public static final String UPDATE_BUTTON_TOOL_TIP_TEXT_PROPERTY_CHANGED = 
            "UpdateButtonToolTipTextProperyChanged";
    
    public static final String CLOSE_BUTTON_TEXT_PROPERTY_CHANGED = 
            "CloseButtonTextPropertyChanged";
    /**
     * This identifies that the accessory component under the details has 
     * changed.
     */
    public static final String BOTTOM_ACCESSORY_PROPERTY_CHANGED = 
            "BottomAccessoryPropertyChanged";
    
    public static final String UPDATE_BUTTON_IS_SHOWN_PROPERTY_CHANGED = 
            "UpdateButtonIsShownPropertyChanged";
    
    public static final String LICENSE_BUTTON_IS_SHWON_PROPERTY_CHANGED = 
            "LicenseButtonIsShownPropertyChanged";
    /**
     * This identifies that the buttons have been set to be shown or hidden.
     */
    public static final String CONTROL_BUTTONS_ARE_SHOWN_PROPERTY_CHANGED = 
            "ControlButtonsAreShownPropertyChanged";
    /**
     * This is the text that appears before the program version on the program 
     * version label.
     */
    private static final String VERSION_TEST_PREFIX = "Version ";
    /**
     * This is the copyright character.
     * @see #COPYRIGHT_CHARACTER_STRING
     */
    public static final char COPYRIGHT_CHARACTER = '©';
    /**
     * This is a string containing the copyright character.
     * @see #COPYRIGHT_CHARACTER
     */
    public static final String COPYRIGHT_CHARACTER_STRING = ""+COPYRIGHT_CHARACTER;
    /**
     * This is the text that appears before the copyright on the copyright 
     * label.
     */
    private static final String COPYRIGHT_TEXT_PREFIX = "Copyright "+
            COPYRIGHT_CHARACTER+" ";
    /**
     * The flag controlling whether the control buttons are shown.
     */
    protected static final int SHOW_CONTROL_BUTTONS_FLAG = 0x01;
    /**
     * The flag controlling whether the update button is shown.
     */
    protected static final int SHOW_UPDATE_BUTTON_FLAG = 0x02;
    /**
     * The flag controlling whether the license button is shown.
     */
    protected static final int SHOW_LICENSE_BUTTON_FLAG = 0x04;
    /**
     * This stores a bunch of flags that control properties of this panel.
     */
    private int flags = SHOW_CONTROL_BUTTONS_FLAG;
    /**
     * This is the program's version.
     */
    private String version = null;
    /**
     * This is the program's copyright.
     */
    private String copyright = null;
    /**
     * This is the text set for the update button if one has been set for it. If 
     * this is null, then the update button will use the default update button 
     * text.
     */
    private String updateText = null;
    /**
     * This is the tool tip text set for the update button if one has been set 
     * for it. If  this is null, then the update button will use the default 
     * update button tool tip text.
     */
    private String updateToolTip = null;
    /**
     * This is the text set for the close button if one has been set for it. If 
     * this is null, then the close button will use the default close button 
     * text.
     */
    private String closeText = null;
    /**
     * This is a map that maps the components to filler components that are 
     * hidden along with those components.
     */
    private Map<Component,Component> fillerMap = new HashMap<>();
    /**
     * This is a map that maps components to property names for an event that's 
     * fired when a property changes for those components.
     */
    private Map<Component,String> propNameMap = new HashMap<>();
    /**
     * This is the thumbnail label used to display the icon for the program.
     */
    protected JThumbnailLabel iconLabel;
    /**
     * This is the panel containing the details label and credits components.
     */
    protected JPanel detailsPanel;
    /**
     * This is the label used to display the program's name.
     */
    protected JLabel nameLabel;
    /**
     * This is the label used to display the program's version.
     */
    protected JLabel versionLabel;
    /**
     * This is the label used to display the program's copyright information.
     */
    protected JLabel copyrightLabel;
    /**
     * This is the hyperlink label used to display the program's website.
     */
    protected JHyperlinkLabel websiteLabel;
    /**
     * This is the panel containing the credits components.
     */
    protected JPanel creditsPanel;
    /**
     * This is the scroll pane for the credits text pane.
     */
    protected JScrollPane creditsScrollPane;
    /**
     * This is the text pane used to display the credits for the program.
     */
    protected JTextPane creditsTextPane;
    /**
     * This is the panel used to contain the bottom components on this panel.
     */
    protected JPanel bottomPanel;
    /**
     * This is the panel used to contain the bottom accessory within the bottom 
     * panel. This is initialized the first time the bottom accessory is set to 
     * a non-null value.
     */
    protected JPanel bottomAccessoryPanel = null;
    /**
     * This is the panel used to contain the buttons for this panel.
     */
    protected JPanel buttonPanel;
    /**
     * This is the button used to close the dialog.
     */
    protected JButton closeButton;
    /**
     * This is the button used to check for updates for the program.
     */
    protected JButton updateButton;
    /**
     * This is the button used to display the license for the program.
     */
    protected JButton licenseButton;
    /**
     * This is the popup menu for the program website label.
     */
    protected JPopupMenu websitePopup;
    /**
     * This is the menu item for opening the program website.
     */
    protected JMenuItem websiteOpenItem;
    /**
     * This is the menu item for copying the program website to the clipboard.
     */
    protected JMenuItem websiteCopyItem;
    /**
     * This is the accessory that appears at the bottom next to the buttons.
     */
    private JComponent bottomAccessory = null;
    /**
     * This is the handler used to update the visibility of containers when 
     * their child components are shown or hidden.
     */
    private ParentVisibilityHandler visHandler;
    /**
     * This creates the border for the credits panel.
     * @return The border for the credits panel.
     */
    private Border createCreditBorder(){
            // Create the title border for the credits panel.
        TitledBorder border = BorderFactory.createTitledBorder("Credits");
        border.setTitleColor(getForeground());
        border.setTitleFont(getFont());
        return border;
    }
    /**
     * This creates a filler object to go after the given component.
     * @param comp The component to associate with this filler object, or null.
     * @param minWidth The minimum width for this filler.
     * @param minHeigth The minimum height for this filler.
     * @param maxWidth The maximum width for this filler.
     * @param maxHeight The maximum height for this filler.
     * @return The filler object that was created.
     */
    private Box.Filler createFiller(Component comp, int minWidth, int minHeigth, 
            int maxWidth, int maxHeight){
            // Create a filler object
        Box.Filler filler = new Box.Filler(new Dimension(minWidth, minHeigth), 
                new Dimension(minWidth, minHeigth), 
                new Dimension(maxWidth, maxHeight));
        filler.setInheritsPopupMenu(true);
            // If a component was provided
        if (comp != null)
                // Add the component and filler object to the filler map
            fillerMap.put(comp, filler);
        return filler;
    }
    /**
     * This initializes the given details label and adds it to the details 
     * panel.
     * @param label The label to initialize.
     * @param handler The handler to listen to the label.
     */
    private void initializeDetailsLabel(JLabel label, Handler handler){
        label.addPropertyChangeListener(handler);
        label.addComponentListener(handler);
            // If the label is not a hyperlink label
        if (!(label instanceof JHyperlinkLabel))
            label.setInheritsPopupMenu(true);
            // Set the colors to null to inherit them from the parent
        label.setForeground(null);
        label.setBackground(null);
            // Center the label's alignment
        label.setAlignmentX(0.5f);
            // Add the label to the details panel
        detailsPanel.add(label);
            // Add a filler object to the details panel
        detailsPanel.add(createFiller(label,0,7,32767,7));
    }
    /**
     * This initializes the components of this about panel.
     */
    private void initialize(){
            // A panel to contain all the components
        JPanel panel = new JPanel(new BorderLayout(18, 7));
        panel.setBorder(BorderFactory.createEmptyBorder(7, 6, 7, 6));
            // A handler to listen to the components
        Handler handler = new Handler();
            // A handler to listen to changes to the visibility of components
        visHandler = new ParentVisibilityHandler();
            // Create the icon label
        iconLabel = new JThumbnailLabel();
        iconLabel.setImageAlwaysScaled(true);
        iconLabel.setVerticalAlignment(SwingConstants.TOP);
        iconLabel.setInheritsPopupMenu(true);
            // Set the width to 128
        iconLabel.setMinimumSize(new Dimension(128,iconLabel.getMinimumSize().height));
        iconLabel.setPreferredSize(new Dimension(128,iconLabel.getPreferredSize().height));
            // Set the colors to null to inherit them from the parent
        iconLabel.setForeground(null);
        iconLabel.setBackground(null);
            // Assign the icon label the program icon property
        propNameMap.put(iconLabel, PROGRAM_ICON_PROPERTY_CHANGED);
        iconLabel.addPropertyChangeListener("icon", handler);
            // Put the icon label on the left side of the panel
        panel.add(iconLabel, BorderLayout.LINE_START);
            // Hide the icon label
        iconLabel.setVisible(false);
            // Create a details panel to display the labels and stuff
        detailsPanel = new JPanel();
        detailsPanel.setInheritsPopupMenu(true);
            // Set the detail panel's layout to a box layout
        detailsPanel.setLayout(new BoxLayout(detailsPanel, BoxLayout.Y_AXIS));
                    // Set the colors to null to inherit them from the parent
        detailsPanel.setForeground(null);
        detailsPanel.setBackground(null);
            // Put the details panel in the center of the panel
        panel.add(detailsPanel, BorderLayout.CENTER);
            // Create the program name label
        nameLabel = new JLabel();
        nameLabel.setFont(deriveFont(Font.BOLD,9));
            // Initialize and add the program name label
        initializeDetailsLabel(nameLabel,handler);
            // Assign the name label the program name property
        propNameMap.put(nameLabel, PROGRAM_NAME_PROPERTY_CHANGED);
            // Create the version label
        versionLabel = new JLabel();
        versionLabel.setFont(deriveFont(Font.BOLD|Font.ITALIC,5));
            // Initialize and add the program version label
        initializeDetailsLabel(versionLabel,handler);
            // Hide the version label
        versionLabel.setVisible(false);
            // Create the copyright label
        copyrightLabel = new JLabel();
            // Initialize and add the program copyright label
        initializeDetailsLabel(copyrightLabel,handler);
            // Hide the copyright label
        copyrightLabel.setVisible(false);
            // Create and add the website label
        websiteLabel = new JHyperlinkLabel();
            // Initialize and add the program website label
        initializeDetailsLabel(websiteLabel,handler);
            // Assign the website label the program website text property
        propNameMap.put(websiteLabel, PROGRAM_WEBSITE_TEXT_PROPERTY_CHANGED);
            // Hide the website label
        websiteLabel.setVisible(false);
            // Create a popup menu for the website label
        websitePopup = new JPopupMenu();
            // Create a menu item for opening the link
        websiteOpenItem = new JMenuItem("Open Link");
        websiteOpenItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, 0));
        websiteOpenItem.setActionCommand(OPEN_WEBSITE_SELECTED);
        websiteOpenItem.addActionListener(handler);
            // Disable the open menu item
        websiteOpenItem.setEnabled(false);
            // Add the open menu item to the popup menu for the website label
        websitePopup.add(websiteOpenItem);
            // Create a menu item for copying the link
        websiteCopyItem = new JMenuItem("Copy Link");
        websiteCopyItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, 0));
        websiteCopyItem.setActionCommand(COPY_WEBSITE_SELECTED);
        websiteCopyItem.addActionListener(handler);
            // Disable the copy menu item
        websiteCopyItem.setEnabled(false);
            // Add the copy menu item to the popup menu for the website label
        websitePopup.add(websiteCopyItem);
            // Set the popup menu for the website label
        websiteLabel.setComponentPopupMenu(websitePopup);
            // Create the credits panel
        creditsPanel = new JPanel(new BorderLayout());
        creditsPanel.setInheritsPopupMenu(true);
            // Set the border for the credits panel
        creditsPanel.setBorder(createCreditBorder());
            // Set the colors to null to inherit them from the parent
        creditsPanel.setForeground(null);
        creditsPanel.setBackground(null);
            // Add the credits panel to the details panel
        detailsPanel.add(creditsPanel);
            // Create the text pane to display the credits
        creditsTextPane = new JTextPane();
            // The credits text pane is not editable
        creditsTextPane.setEditable(false);
        creditsTextPane.addPropertyChangeListener(handler);
            // Create the scroll pane to scroll the credits text pane
        creditsScrollPane = new JScrollPane(creditsTextPane);
            // Set the colors to null to inherit them from the parent
        creditsScrollPane.setForeground(null);
        creditsScrollPane.setBackground(null);
            // Add the credits scroll pane to the credits panel
        creditsPanel.add(creditsScrollPane, BorderLayout.CENTER);
            // Create the bottom panel
        bottomPanel = new JPanel(new BorderLayout(6,0));
        bottomPanel.setInheritsPopupMenu(true);
        bottomPanel.addContainerListener(visHandler);
            // Set the colors to null to inherit them from the parent
        bottomPanel.setForeground(null);
        bottomPanel.setBackground(null);
            // Create the button panel
        buttonPanel = new JPanel();
        buttonPanel.setInheritsPopupMenu(true);
        buttonPanel.addContainerListener(visHandler);
            // Set the button panel's layout
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
            // Set the colors to null to inherit them from the parent
        buttonPanel.setForeground(null);
        buttonPanel.setBackground(null);
            // Create a button to check for updates
        updateButton = new JButton(getUpdateButtonText());
        updateButton.setActionCommand(UPDATE_SELECTED);
        updateButton.setToolTipText(getUpdateButtonToolTipText());
        updateButton.addActionListener(handler);
        updateButton.addComponentListener(handler);
        updateButton.setInheritsPopupMenu(true);
            // Set the button foreground to null to inherit it from the parent
        updateButton.setForeground(null);
            // Add the update button to the button panel
        buttonPanel.add(updateButton);
            // Add a filler object after the update button
        buttonPanel.add(createFiller(updateButton,6,0,6,32767));
            // Hide the update button
        updateButton.setVisible(false);
            // Create a button to display the program license
        licenseButton = new JButton("License");
        licenseButton.setActionCommand(OPEN_LICENSE_SELECTED);
        licenseButton.addActionListener(handler);
        licenseButton.addComponentListener(handler);
        licenseButton.setInheritsPopupMenu(true);
            // Set the button foreground to null to inherit it from the parent
        licenseButton.setForeground(null);
            // Add the license button to the button panel
        buttonPanel.add(licenseButton);
            // Add a filler object after the license button
        buttonPanel.add(createFiller(licenseButton,6,0,6,32767));
            // Hide the license button
        licenseButton.setVisible(false);
            // Create a button to close the dialog
        closeButton = new JButton(getCloseButtonText());
        closeButton.setActionCommand(CLOSE_SELECTED);
        closeButton.addActionListener(handler);
        closeButton.setInheritsPopupMenu(true);
            // Set the button foreground to null to inherit it from the parent
        closeButton.setForeground(null);
            // Add the close button to the button panel
        buttonPanel.add(closeButton);
            // Add the button panel to the bottom panel
        bottomPanel.add(buttonPanel, BorderLayout.LINE_END);
            // Add the bottom panel to the panel
        panel.add(bottomPanel, BorderLayout.PAGE_END);
            // Add the panel to this panel
        add(panel, BorderLayout.CENTER);
    }
    
    public JAboutPanel(){
        super(new BorderLayout(0, 0));
        initialize();
    }
    /**
     * This returns the icon being displayed for the program.
     * @return The icon displayed for the program.
     * @see #setProgramIcon(javax.swing.Icon) 
     */
    public Icon getProgramIcon(){
        return iconLabel.getIcon();
    }
    /**
     * This sets the icon to display for the program.
     * @param icon The icon to display for the program, or null.
     * @see #getProgramIcon() 
     */
    public void setProgramIcon(Icon icon){
        iconLabel.setIcon(icon);
    }
    /**
     * This returns the name of the program.
     * @return The program name.
     * @see #setProgramName(java.lang.String) 
     */
    public String getProgramName(){
        return nameLabel.getText();
    }
    /**
     * This sets the name of the program. The default value for this is null.
     * @param name The program name, or null.
     * @see #getProgramName() 
     */
    public void setProgramName(String name){
        nameLabel.setText(name);
    }
    /**
     * This returns the version of the program.
     * @return The program version, or null.
     * @see #setProgramVersion(java.lang.String) 
     */
    public String getProgramVersion(){
        return version;
    }
    /**
     * This sets the version of the program. The version of the program is 
     * displayed by the panel with the word "Version" before it. The default 
     * value for this is null.
     * @param version The program version, or null.
     * @see #getProgramVersion() 
     */
    public void setProgramVersion(String version){
            // If the version would not change
        if (Objects.equals(this.version, version))
            return;
            // Get the old program version
        String old = this.version;
        this.version = version;
        firePropertyChange(PROGRAM_VERSION_PROPERTY_CHANGED,old,version);
            // Update the text for the version label to display the version if 
            // not null
        versionLabel.setText((version!= null)?VERSION_TEST_PREFIX+version:null);
    }
    /**
     * This returns the copyright text for the program.
     * @return The copyright text for the program, or null.
     * @see #setProgramCopyright(java.lang.String) 
     */
    public String getProgramCopyright(){
        return copyright;
    }
    /**
     * This sets the copyright text for the program. The copyright text is 
     * displayed by the panel with the text "Copyright &copy;" before it. The 
     * default value for this is null.
     * @param copyright The copyright text for the program, or null.
     * @see #getProgramCopyright() 
     * @see #COPYRIGHT_CHARACTER
     * @see #COPYRIGHT_CHARACTER_STRING
     */
    public void setProgramCopyright(String copyright){
            // If the copyright would not change
        if (Objects.equals(this.copyright, copyright))
            return;
            // Get the old program copyright
        String old = this.copyright;
        this.copyright = copyright;
        firePropertyChange(PROGRAM_COPYRIGHT_PROPERTY_CHANGED,old,copyright);
            // Update the text for the copyright label to display the copyright 
            // if not null
        copyrightLabel.setText((copyright!=null)?COPYRIGHT_TEXT_PREFIX+copyright:
                null);
    }
    /**
     * This returns the text to display for the link to the program's website.
     * @return The text to display for the link to the program's website, or 
     * null.
     * @see #setProgramWebsiteText(java.lang.String) 
     * @see #getProgramWebsiteURI() 
     * @see #setProgramWebsiteURI(java.net.URI) 
     * @see #setProgramWebsite(java.lang.String, java.net.URI) 
     */
    public String getProgramWebsiteText(){
        return websiteLabel.getText();
    }
    /**
     * This sets the text to display for the link to the program's website. The 
     * default value for this is null.
     * @param text The text to display for the link to the program's website, or 
     * null.
     * @see #getProgramWebsiteText() 
     * @see #getProgramWebsiteURI() 
     * @see #setProgramWebsiteURI(java.net.URI) 
     * @see #setProgramWebsite(java.lang.String, java.net.URI) 
     */
    public void setProgramWebsiteText(String text){
        websiteLabel.setText(text);
    }
    /**
     * This returns the URI for the link to the program's website. The link to 
     * the program's website is only displayed if the text has been set for the 
     * link using the {@link #setProgramWebsiteText setProgramWebsiteText}.
     * @return The URI for the link to the program, or null.
     * @see #setProgramWebsiteURI(java.net.URI) 
     * @see #openProgramWebsite() 
     * @see #copyProgramWebsite(java.awt.datatransfer.Clipboard) 
     * @see #copyProgramWebsite() 
     * @see #getProgramWebsiteText() 
     * @see #setProgramWebsiteText(java.lang.String) 
     * @see #setProgramWebsite(java.lang.String, java.net.URI) 
     * @see #isProgramWebsiteVisited() 
     * @see #setProgramWebsiteVisited(boolean) 
     * @see JHyperlinkLabel#getURI() 
     */
    public URI getProgramWebsiteURI(){
        return websiteLabel.getURI();
    }
    /**
     * This sets the the URI for the link to the program's website. The link to 
     * the program's website is only displayed if the text has been set for the 
     * link using the {@link #setProgramWebsiteText setProgramWebsiteText}. This 
     * will also make the program website to be unvisited. The default value for 
     * this is null.
     * @param uri The URI for the link to the program's website, or null.
     * @see #getProgramWebsiteURI() 
     * @see #openProgramWebsite() 
     * @see #copyProgramWebsite(java.awt.datatransfer.Clipboard) 
     * @see #copyProgramWebsite() 
     * @see #getProgramWebsiteText() 
     * @see #setProgramWebsiteText(java.lang.String) 
     * @see #setProgramWebsite(java.lang.String, java.net.URI) 
     * @see #isProgramWebsiteVisited() 
     * @see #setProgramWebsiteVisited(boolean) 
     * @see JHyperlinkLabel#setURI(java.net.URI) 
     */
    public void setProgramWebsiteURI(URI uri){
        websiteLabel.setURI(uri);
    }
    /**
     * This sets the text and URI for the link to the program website. This is 
     * equivalent to calling both {@link #setProgramWebsiteText(java.lang.String) 
     * setProgramWebsiteText} and {@link #setProgramWebsiteURI(java.net.URI) 
     * setProgramWebsiteURI}. 
     * @param text The text to display for the link to the program's website.
     * @param uri The URI for the link to the program's website.
     * @see #setProgramWebsiteText(java.lang.String) 
     * @see #setProgramWebsiteURI(java.net.URI) 
     * @see #getProgramWebsiteText() 
     * @see #getProgramWebsiteURI() 
     * @see #isProgramWebsiteVisited() 
     * @see #setProgramWebsiteVisited(boolean) 
     * @see #openProgramWebsite() 
     * @see #copyProgramWebsite(java.awt.datatransfer.Clipboard) 
     * @see #copyProgramWebsite() 
     */
    public void setProgramWebsite(String text, URI uri){
        setProgramWebsiteText(text);
        setProgramWebsiteURI(uri);
    }
    /**
     * This opens the program website in the user's default browser. If this 
     * fails to open the browser, then this will display an error message to the 
     * user if {@link #getFailureMessagesAreShown() failure messages are to be 
     * shown}.
     * @throws IllegalStateException If the program website URI is not set.
     * @see #copyProgramWebsite(java.awt.datatransfer.Clipboard) 
     * @see #copyProgramWebsite() 
     * @see #getProgramWebsiteURI() 
     * @see #setProgramWebsiteURI(java.net.URI) 
     * @see #getFailureMessagesAreShown() 
     * @see #setFailureMessagesAreShown(boolean)
     * @see JHyperlinkLabel#openHyperlink() 
     */
    public void openProgramWebsite(){
        websiteLabel.openHyperlink();
    }
    /**
     * This copies the program website to the given clipboard.
     * @param clipboard The clipboard to copy the program website to.
     * @throws IllegalStateException If the program website URI is not set.
     * @see #copyProgramWebsite() 
     * @see #openProgramWebsite() 
     * @see #getProgramWebsiteURI() 
     * @see #setProgramWebsiteURI(java.net.URI) 
     * @see JHyperlinkLabel#copyHyperlink(java.awt.datatransfer.Clipboard) 
     */
    public void copyProgramWebsite(Clipboard clipboard){
        websiteLabel.copyHyperlink(clipboard);
    }
    /**
     * This copies the program website to the system clipboard.
     * @throws IllegalStateException If the program website URI is not set.
     * @see #openProgramWebsite() 
     * @see #copyProgramWebsite(java.awt.datatransfer.Clipboard) 
     * @see #getToolkit() 
     * @see Toolkit#getSystemClipboard() 
     * @see #getProgramWebsiteURI() 
     * @see #setProgramWebsiteURI(java.net.URI) 
     * @see JHyperlinkLabel#copyHyperlink() 
     */
    public void copyProgramWebsite(){
        websiteLabel.copyHyperlink();
    }
    /**
     * This returns whether the program website has been visited yet.
     * @return Whether the program website has been visited yet.
     * @see #setProgramWebsiteVisited(boolean) 
     * @see #getProgramWebsiteURI() 
     * @see #setProgramWebsiteURI(java.net.URI) 
     * @see JHyperlinkLabel#isVisited() 
     */
    public boolean isProgramWebsiteVisited(){
        return websiteLabel.isVisited();
    }
    /**
     * This sets whether the program website has been visited yet. The default 
     * for this value is {@code false}.
     * @param value Whether the program website has been visited yet.
     * @see #isProgramWebsiteVisited() 
     * @see #getProgramWebsiteURI() 
     * @see #setProgramWebsiteURI(java.net.URI) 
     * @see JHyperlinkLabel#setVisited(boolean) 
     */
    public void setProgramWebsiteVisited(boolean value){
        websiteLabel.setVisited(value);
    }
    
    public String getCreditsText(int offset, int length) throws BadLocationException{
        return creditsTextPane.getText(offset, length);
    }
    
    public String getCreditsText(){
        return creditsTextPane.getText();
    }
    
    public void setCreditsText(String text){
        creditsTextPane.setText(text);
    }
    
    public StyledDocument getCreditsDocument(){
        return creditsTextPane.getStyledDocument();
    }
    
    public void setCreditsDocument(StyledDocument doc){
        creditsTextPane.setStyledDocument(doc);
    }
    
    public EditorKit getCreditsEditorKit(){
        return creditsTextPane.getEditorKit();
    }
    
    public EditorKit getCreditsEditorKitForContentType(String type){
        return creditsTextPane.getEditorKitForContentType(type);
    }
    
    public void setCreditsEditorKit(EditorKit kit){
        creditsTextPane.setEditorKit(kit);
    }
    
    public void setCreditsEditorKitForContentType(String type, EditorKit kit){
        creditsTextPane.setEditorKitForContentType(type, kit);
    }
    
    public JPopupMenu getCreditsPopupMenu(){
        return creditsTextPane.getComponentPopupMenu();
    }
    
    public void setCreditsPopupMenu(JPopupMenu popup){
        creditsTextPane.setComponentPopupMenu(popup);
    }
    
    public boolean getCreditsInheritsPopupMenu(){
        return creditsTextPane.getInheritsPopupMenu();
    }
    
    public void setCreditsInheritsPopupMenu(boolean value){
        creditsTextPane.setInheritsPopupMenu(value);
    }
    
    // TODO: Add more credit methods
    
    /**
     * This returns the color to use as the foreground color of the text for 
     * hyperlinks when there's a hyperlink set and that hyperlink has not been 
     * visited yet.
     * @return The color for unvisited hyperlinks. If no color has been set for 
     * unvisited hyperlinks, then {@link 
     * JHyperlinkLabel#UNVISITED_HYPERLINK_COLOR} is returned.
     * @see #setUnvisitedHyperlinkColor(java.awt.Color) 
     * @see #isUnvisitedHyperlinkColorSet() 
     * @see #getVisitedHyperlinkColor() 
     * @see #setVisitedHyperlinkColor(java.awt.Color) 
     * @see #isProgramWebsiteVisited() 
     * @see #setProgramWebsiteVisited(boolean) 
     * @see #getProgramWebsiteURI() 
     * @see #setProgramWebsiteURI(java.net.URI) 
     * @see JHyperlinkLabel#UNVISITED_HYPERLINK_COLOR
     * @see JHyperlinkLabel#getUnvisitedHyperlinkColor() 
     */
    public Color getUnvisitedHyperlinkColor(){
        return websiteLabel.getUnvisitedHyperlinkColor();
    }
    /**
     * This sets the color to use as the foreground color of the text for 
     * hyperlinks when there's a hyperlink set and that hyperlink has not been
     * visited yet.
     * @param color The color for unvisited hyperlinks. If this is null, then 
     * {@link JHyperlinkLabel#UNVISITED_HYPERLINK_COLOR 
     * UNVISITED_HYPERLINK_COLOR} will be used instead.
     * @see #getUnvisitedHyperlinkColor() 
     * @see #isUnvisitedHyperlinkColorSet() 
     * @see #getVisitedHyperlinkColor() 
     * @see #setVisitedHyperlinkColor(java.awt.Color) 
     * @see #isProgramWebsiteVisited() 
     * @see #setProgramWebsiteVisited(boolean) 
     * @see #getProgramWebsiteURI() 
     * @see #setProgramWebsiteURI(java.net.URI) 
     * @see JHyperlinkLabel#UNVISITED_HYPERLINK_COLOR
     * @see JHyperlinkLabel#setUnvisitedHyperlinkColor(java.awt.Color) 
     */
    public void setUnvisitedHyperlinkColor(Color color){
        websiteLabel.setUnvisitedHyperlinkColor(color);
    }
    /**
     * This returns whether a color for unvisited hyperlinks has been explicitly 
     * set for this component.
     * @return {@code true} if the unvisited hyperlink color has been explicitly 
     * set for this component; {@code false} otherwise.
     * @see #getUnvisitedHyperlinkColor() 
     * @see #setUnvisitedHyperlinkColor(java.awt.Color) 
     * @see #isProgramWebsiteVisited() 
     * @see #setProgramWebsiteVisited(boolean) 
     * @see #getProgramWebsiteURI() 
     * @see #setProgramWebsiteURI(java.net.URI) 
     * @see JHyperlinkLabel#UNVISITED_HYPERLINK_COLOR
     * @see JHyperlinkLabel#isUnvisitedHyperlinkColorSet() 
     */
    public boolean isUnvisitedHyperlinkColorSet(){
        return websiteLabel.isUnvisitedHyperlinkColorSet();
    }
    /**
     * This returns the color to use as the foreground color of the text for 
     * hyperlinks when there's a hyperlink set and that hyperlink has been 
     * visited.
     * @return The color for visited hyperlinks. If no color has been set for 
     * visited hyperlinks, then {@link JHyperlinkLabel#VISITED_HYPERLINK_COLOR 
     * VISITED_HYPERLINK_COLOR} is returned.
     * @see #setVisitedHyperlinkColor(java.awt.Color) 
     * @see #isVisitedHyperlinkColorSet() 
     * @see #getUnvisitedHyperlinkColor() 
     * @see #setUnvisitedHyperlinkColor(java.awt.Color) 
     * @see #isProgramWebsiteVisited() 
     * @see #setProgramWebsiteVisited(boolean) 
     * @see #getProgramWebsiteURI() 
     * @see #setProgramWebsiteURI(java.net.URI) 
     * @see JHyperlinkLabel#VISITED_HYPERLINK_COLOR
     * @see JHyperlinkLabel#getVisitedHyperlinkColor() 
     */
    public Color getVisitedHyperlinkColor(){
        return websiteLabel.getVisitedHyperlinkColor();
    }
    /**
     * This sets the color to use as the foreground color of the text for 
     * hyperlinks when there's a hyperlink set and that hyperlink has been 
     * visited.
     * @param color The color for visited hyperlinks. If this is null, then 
     * {@link JHyperlinkLabel#VISITED_HYPERLINK_COLOR VISITED_HYPERLINK_COLOR} 
     * will be used instead.
     * @see #getVisitedHyperlinkColor() 
     * @see #isVisitedHyperlinkColorSet() 
     * @see #getUnvisitedHyperlinkColor() 
     * @see #setUnvisitedHyperlinkColor(java.awt.Color) 
     * @see #isProgramWebsiteVisited() 
     * @see #setProgramWebsiteVisited(boolean) 
     * @see #getProgramWebsiteURI() 
     * @see #setProgramWebsiteURI(java.net.URI) 
     * @see JHyperlinkLabel#VISITED_HYPERLINK_COLOR
     * @see JHyperlinkLabel#setVisitedHyperlinkColor(java.awt.Color) 
     */
    public void setVisitedHyperlinkColor(Color color){
        websiteLabel.setVisitedHyperlinkColor(color);
    }
    /**
     * This returns whether a color for visited hyperlinks has been explicitly 
     * set for this component.
     * @return {@code true} if the visited hyperlink color has been explicitly 
     * set for this component; {@code false} otherwise.
     * @see #getVisitedHyperlinkColor() 
     * @see #setVisitedHyperlinkColor(java.awt.Color) 
     * @see #isProgramWebsiteVisited() 
     * @see #setProgramWebsiteVisited(boolean) 
     * @see #getProgramWebsiteURI() 
     * @see #setProgramWebsiteURI(java.net.URI) 
     * @see JHyperlinkLabel#VISITED_HYPERLINK_COLOR
     * @see JHyperlinkLabel#isVisitedHyperlinkColorSet() 
     */
    public boolean isVisitedHyperlinkColorSet(){
        return websiteLabel.isVisitedHyperlinkColorSet();
    }
    /**
     * This returns the color to use as the foreground color of the text for 
     * hyperlinks when there's a hyperlink set and the label is being clicked 
     * on.
     * @return The color for selected hyperlinks. If no color has been set for 
     * selected hyperlinks, then {@link 
     * JHyperlinkLabel#ACTIVATED_HYPERLINK_COLOR ACTIVATED_HYPERLINK_COLOR} is 
     * returned.
     * @see #setSelectedHyperlinkColor(java.awt.Color) 
     * @see #isSelectedHyperlinkColorSet() 
     * @see #getProgramWebsiteURI() 
     * @see #setProgramWebsiteURI(java.net.URI) 
     * @see JHyperlinkLabel#ACTIVATED_HYPERLINK_COLOR
     * @see JHyperlinkLabel#getSelectedHyperlinkColor() 
     */
    public Color getSelectedHyperlinkColor(){
        return websiteLabel.getSelectedHyperlinkColor();
    }
    /**
     * This sets the color to use as the foreground color of the text for 
     * hyperlinks when there's a hyperlink set and the label is being clicked 
     * on.
     * @param color The color for selected hyperlinks. If this is null, then 
     * {@link JHyperlinkLabel#ACTIVATED_HYPERLINK_COLOR 
     * ACTIVATED_HYPERLINK_COLOR} will be used instead.
     * @see #getSelectedHyperlinkColor
     * @see #isSelectedHyperlinkColorSet() 
     * @see #getProgramWebsiteURI() 
     * @see #setProgramWebsiteURI(java.net.URI) 
     * @see JHyperlinkLabel#ACTIVATED_HYPERLINK_COLOR
     * @see JHyperlinkLabel#setSelectedHyperlinkColor(java.awt.Color) 
     */
    public void setSelectedHyperlinkColor(Color color){
        websiteLabel.setSelectedHyperlinkColor(color);
    }
    /**
     * This returns whether a color for selected hyperlinks has been explicitly 
     * set for this component.
     * @return {@code true} if the selected hyperlink color has been explicitly 
     * set for this component; {@code false} otherwise.
     * @see #getSelectedHyperlinkColor() 
     * @see #setSelectedHyperlinkColor(java.awt.Color) 
     * @see #getProgramWebsiteURI() 
     * @see #setProgramWebsiteURI(java.net.URI) 
     * @see JHyperlinkLabel#ACTIVATED_HYPERLINK_COLOR
     * @see JHyperlinkLabel#isSelectedHyperlinkColorSet() 
     */
    public boolean isSelectedHyperlinkColorSet(){
        return websiteLabel.isSelectedHyperlinkColorSet();
    }
    /**
     * This returns whether the user will be notified with a message dialog when 
     * the hyperlink fails to open.
     * @return {@code true} if a message dialog will be displayed if the 
     * hyperlink fails to open, {@code false} otherwise.
     * @see #setFailureMessagesAreShown(boolean) 
     * @see #openProgramWebsite() 
     * @see JHyperlinkLabel#getFailureMessagesAreShown() 
     */
    public boolean getFailureMessagesAreShown(){
        return websiteLabel.getFailureMessagesAreShown();
    }
    /**
     * This sets whether the user will be notified with a message dialog when 
     * the hyperlink fails to open. The default for this value is {@code true}.
     * @param value {@code true} if a message dialog will be displayed if the 
     * hyperlink fails to open, {@code false} otherwise.
     * @see #getFailureMessagesAreShown() 
     * @see #openProgramWebsite() 
     * @see JHyperlinkLabel#setFailureMessagesAreShown(boolean) 
     */
    public void setFailureMessagesAreShown(boolean value){
        websiteLabel.setFailureMessagesAreShown(value);
    }
    
    public void setCloseButtonText(String text){
            // If the close text would not change
        if (Objects.equals(text, closeText))
            return;
            // Get the old close text
        String old = closeText;
        closeText = text;
            // Update the close button text
        closeButton.setText(getCloseButtonText());
        firePropertyChange(CLOSE_BUTTON_TEXT_PROPERTY_CHANGED,old,closeText);
    }
    
    public String getCloseButtonText(){
            // If the close text is null
        if (closeText == null)
            return "OK";
        return closeText;
    }
    
    public boolean isCloseButtonTextSet(){
        return closeText != null;
    }
    
    public void setUpdateButtonToolTipText(String text){
            // If the update tool tip text would not change
        if (Objects.equals(text, updateToolTip))
            return;
            // Get the old update tool tip text
        String old = updateToolTip;
        updateToolTip = text;
            // Update the update button tool tip text
        updateButton.setToolTipText(getUpdateButtonToolTipText());
        firePropertyChange(UPDATE_BUTTON_TOOL_TIP_TEXT_PROPERTY_CHANGED,old,text);
    }
    
    public String getUpdateButtonToolTipText(){
            // If the update tool tip text is null
        if (updateToolTip == null)
            return "Check to see if this program has an update available.";
        return updateToolTip;
    }
    
    public boolean isUpdateButtonToolTipTextSet(){
        return updateToolTip != null;
    }
    
    public void setUpdateButtonText(String text){
            // If the update text would not change
        if (Objects.equals(text, updateText))
            return;
            // Get the old update text
        String old = updateText;
        updateText = text;
            // Update the update button text
        updateButton.setText(getUpdateButtonText());
        firePropertyChange(UPDATE_BUTTON_TEXT_PROPERTY_CHANGED,old,updateText);
    }
    
    public String getUpdateButtonText(){
            // If the update text is not set
        if (updateText == null)
            return "Check For Updates";
        return updateText;
    }
    
    public boolean isUpdateButtonTextSet(){
        return updateText != null;
    }
    
    public JThumbnailLabel getProgramIconLabel(){
        return iconLabel;
    }
    
    public JLabel getProgramNameLabel(){
        return nameLabel;
    }
    
    public JLabel getProgramVersionLabel(){
        return versionLabel;
    }
    
    public JLabel getProgramCopyrightLabel(){
        return copyrightLabel;
    }
    
    public JHyperlinkLabel getProgramWebsiteLabel(){
        return websiteLabel;
    }
    
    public JScrollPane getCreditsScrollPane(){
        return creditsScrollPane;
    }
    
    public JTextPane getCreditsTextPane(){
        return creditsTextPane;
    }
    
    protected Component getFillerComponentFor(Component c){
        return fillerMap.get(c);
    }
    
    public JButton getLicenseButton(){
        return licenseButton;
    }
    
    public JButton getUpdateButton(){
        return updateButton;
    }
    
    public JButton getCloseButton(){
        return closeButton;
    }
    
    public JPopupMenu getWebsitePopup(){
        return websitePopup;
    }
    
    public JMenuItem getWebsiteOpenMenuItem(){
        return websiteOpenItem;
    }
    
    public JMenuItem getWebsiteCopyMenuItem(){
        return websiteCopyItem;
    }
    /**
     * This sets the accessory component to display at the bottom next to the 
     * buttons. The accessory components can be used to add additional controls 
     * such as a button to show tips for the program. <p>
     * 
     * Note: If there was a previous accessory, you should remove any listeners 
     * that the accessory may have added to this {@code JAboutPanel}.
     * 
     * @param accessory The bottom accessory component.
     * @see #getBottomAccessory 
     */
    public void setBottomAccessory(JComponent accessory){
            // If the bottom accessory would not be changed
        if (accessory == bottomAccessory)   
            return;
        JComponent old = bottomAccessory;   // Get the old bottom accessory
        bottomAccessory = accessory;
        firePropertyChange(BOTTOM_ACCESSORY_PROPERTY_CHANGED,old,accessory);
            // If the bottom accessory panel is not initialized
        if (bottomAccessoryPanel == null){
                // Create the bottom accessory panel with a border layout
            bottomAccessoryPanel = new JPanel(new BorderLayout(0,0));
            bottomAccessoryPanel.setInheritsPopupMenu(true);
            bottomAccessoryPanel.addContainerListener(visHandler);
                // Set the colors to null to inherit them from the parent
            bottomAccessoryPanel.setForeground(null);
            bottomAccessoryPanel.setBackground(null);
            bottomPanel.add(bottomAccessoryPanel,BorderLayout.CENTER);
        }
        if (old != null)            // If the old accessory is not null
            bottomAccessoryPanel.remove(old);
        if (accessory != null)      // If the new accessory is not null
            bottomAccessoryPanel.add(accessory,BorderLayout.CENTER);
        bottomAccessoryPanel.revalidate();
        bottomAccessoryPanel.repaint();
    }
    /**
     * This returns the accessory component displayed at the bottom of this 
     * panel next to the buttons.
     * @return The bottom accessory component, or null.
     * @see #setBottomAccessory 
     */
    public JComponent getBottomAccessory(){
        return bottomAccessory;
    }
    /**
     * This returns whether the given flag is set on the flags for this panel.
     * @param flag The flag to check for.
     * @return Whether the given flag is set for this panel.
     * @see #setFlag(int, boolean) 
     * @see #setFlag(int, boolean, java.lang.String) 
     */
    protected boolean getFlag(int flag){
        return (flags & flag) == flag;
    }
    /**
     * This sets or clears the given flag for this panel based off the given 
     * value.
     * @param flag The flag to set or clear.
     * @param value {@code true} if the flag should be set, {@code false} if the 
     * flag should be cleared.
     * @return Whether the flags changed as a result of this method.
     * @see #getFlag(int) 
     * @see #setFlag(int, boolean, java.lang.String) 
     */
    protected boolean setFlag(int flag, boolean value){
            // Get the current value for the flags
        int old = flags;
            // If the given value is true, set the flag. Otherwise clear the 
        flags = (value) ? (flags | flag) : (flags & ~flag); // flag
        return old != flags;
    }
    /**
     * This sets or clears the given flag for this panel based off the given 
     * value. This will also fire a property change with the given property 
     * name.
     * @param flag The flag to set or clear.
     * @param value {@code true} if the flag should be set, {@code false} if the 
     * flag should be cleared.
     * @param propName The property name of the property being changed.
     * @return Whether the flags changed as a result of this method.
     * @see #getFlag(int) 
     * @see #setFlag(int, boolean) 
     */
    protected boolean setFlag(int flag, boolean value, String propName){
            // Set or clear the flag and get whether there was a change
        boolean change = setFlag(flag,value);
            // If the flag changed as a result
        if (change)
            firePropertyChange(propName,!value,value);
        return change;
    }
    
    public void setUpdateButtonIsShown(boolean value){
        setFlag(SHOW_UPDATE_BUTTON_FLAG,value,
                UPDATE_BUTTON_IS_SHOWN_PROPERTY_CHANGED);
        updateButton.setVisible(value);
    }
    
    public boolean getUpdateButtonIsShown(){
        return getFlag(SHOW_UPDATE_BUTTON_FLAG);
    }
    
    public void setLicenseButtonIsShown(boolean value){
        setFlag(SHOW_LICENSE_BUTTON_FLAG,value,
                LICENSE_BUTTON_IS_SHWON_PROPERTY_CHANGED);
        licenseButton.setVisible(value);
    }
    
    public boolean getLicenseButtonIsShown(){
        return getFlag(SHOW_LICENSE_BUTTON_FLAG);
    }
    
    public void setControlButtonsAreShown(boolean value){
        setFlag(SHOW_CONTROL_BUTTONS_FLAG,value,
                CONTROL_BUTTONS_ARE_SHOWN_PROPERTY_CHANGED);
        buttonPanel.setVisible(value);
    }
    
    public boolean getControlButtonsAreShown(){
        return getFlag(SHOW_CONTROL_BUTTONS_FLAG);
    }
    /**
     * {@inheritDoc }
     * @param enabled {@inheritDoc }
     */
    @Override
    public void setEnabled(boolean enabled){
        super.setEnabled(enabled);
        try{
//            websiteLabel.setEnabled(enabled);
            updateWebsiteMenuItems();
            updateButton.setEnabled(enabled);
            licenseButton.setEnabled(enabled);
        } catch (NullPointerException ex){}
    }
    /**
     * This updates whether the website menu items are enabled or disabled.
     */
    private void updateWebsiteMenuItems(){
        websiteOpenItem.setEnabled(isEnabled() && websiteLabel.getURI() != null);
        websiteCopyItem.setEnabled(websiteOpenItem.isEnabled());
    }
    /**
     * {@inheritDoc }
     * @param font {@inheritDoc }
     * @see #getFont() 
     */
    @Override
    public void setFont(Font font){
        super.setFont(font);
            // Get the actual font of the component
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
            creditsPanel.setBorder(createCreditBorder());
            licenseButton.setFont(font);
        } catch (NullPointerException ex) {}
    }
    /**
     * This derives a font from the panel's font.
     * @param relStyle The style changes to apply to the font.
     * @param relSize The difference between the target font and the panel's 
     * font.
     * @return The derived font.
     * @see #getFont() 
     */
    private Font deriveFont(int relStyle, float relSize){
            // Get the font for the label
        Font font = getFont();
            // If the font is somehow still null
        if (font == null)
            font = new Font(Font.SANS_SERIF,Font.PLAIN,0);
        return font.deriveFont(font.getStyle() | relStyle, 
                font.getSize2D() + relSize);
    }
    /**
     * {@inheritDoc }
     * @param fg {@inheritDoc }
     * @see #getForeground() 
     */
    @Override
    public void setForeground(Color fg){
        super.setForeground(fg);
            // Get the actual foreground
        fg = getForeground();
        try{
            creditsPanel.setBorder(createCreditBorder());
            creditsTextPane.setForeground(fg);
        } catch (NullPointerException ex){ }
    }
    /**
     * {@inheritDoc }
     * @param bg {@inheritDoc }
     * @see #getBackground() 
     * @see #setOpaque(boolean) 
     */
    @Override
    public void setBackground(Color bg){
        super.setBackground(bg);
            // Get the actual background
        bg = getBackground();
        try{
            closeButton.setBackground(bg);
            updateButton.setBackground(bg);
            licenseButton.setBackground(bg);
        } catch (NullPointerException ex){ }
    }
    /**
     * This returns the minimum size for this component. If the minimum size has 
     * been set to a non-null value, then that is what is returned. Otherwise, 
     * this will return a minimum size of 640 x 480.
     * @return {@inheritDoc }
     * @see #setMinimumSize
     */
    @Override
    public Dimension getMinimumSize(){
            // If the minimum size is set, return it. Otherwise, return 640x480
        return (isMinimumSizeSet())?super.getMinimumSize():new Dimension(640,480);
    }
    /**
     * This returns a String representation of this JAboutPanel. This method is 
     * primarily intended to be used only for debugging purposes, and the 
     * content and format of the returned String may vary between 
     * implementations.
     * @return A String representation of this JAboutPanel.
     */
    @Override
    protected String paramString(){
        return super.paramString()+
                    // State the unvisited hyperlink color if it's set
                ",unvisitedHyperlinkColor="+((isUnvisitedHyperlinkColorSet())?
                    getUnvisitedHyperlinkColor():"")+
                    // State the visited hyperlink color if it's set
                ",visitedHyperlinkColor="+((isVisitedHyperlinkColorSet())?
                    getVisitedHyperlinkColor():"")+
                    // State the selected hyperlink color if it's set
                ",selectedHyperlinkColor="+((isSelectedHyperlinkColorSet())?
                    getSelectedHyperlinkColor():"")+
                ",programIcon="+Objects.toString(getProgramIcon(),"")+
                ",programName="+Objects.toString(getProgramName(),"")+
                ",programVersion="+Objects.toString(getProgramVersion(),"")+
                ",programCopyright="+Objects.toString(getProgramCopyright(),"")+
                ",programWebsiteText="+Objects.toString(getProgramWebsiteText(),"")+
                ",programWebsiteURI="+Objects.toString(getProgramWebsiteURI(),"")+
                    // State if the program website has been visited
                ((isProgramWebsiteVisited())?",programWebsiteVisited":"");
    }
    /**
     * This adds the given {@code ActionListener} to this panel.
     * @param l The listener to add.
     * @see #removeActionListener(ActionListener) 
     * @see #getActionListeners() 
     */
    public void addActionListener(ActionListener l){
        if (l != null)          // If the listener is not null
            listenerList.add(ActionListener.class, l);
    }
    /**
     * This removes the given {@code ActionListener} from this panel.
     * @param l The listener to remove.
     * @see #addActionListener(ActionListener) 
     * @see #getActionListeners() 
     */
    public void removeActionListener(ActionListener l){
        listenerList.remove(ActionListener.class, l);
    }
    /**
     * This returns an array containing all the {@code ActionListener}s that 
     * have been added to this panel.
     * @return An array containing the {@code ActionListener}s that have been 
     * added, or an empty array if none have been added.
     * @see #addActionListener(ActionListener) 
     * @see #removeActionListener(ActionListener) 
     */
    public ActionListener[] getActionListeners(){
        return listenerList.getListeners(ActionListener.class);
    }
    /**
     * This notifies all the {@code ActionListener}s that have been added to 
     * this panel if the given {@code ActionEvent} is not null. If the source 
     * of the given {@code ActionEvent} is not this panel, then the {@code 
     * ActionEvent} will be redirected to have this panel as its source.
     * @param evt The {@code ActionEvent} to fire.
     * @see #addActionListener(ActionListener) 
     * @see #removeActionListener(ActionListener) 
     * @see #getActionListeners() 
     * @see #fireActionPerformed(String, long, int) 
     * @see #fireActionPerformed(String) 
     */
    protected void fireActionPerformed(ActionEvent evt){
        if (evt == null)    // If the event is null
            return;
            // If the event's source is not this component
        else if (evt.getSource() != this){
            evt = new ActionEvent(this, evt.getID(), evt.getActionCommand(),
                    evt.getWhen(),evt.getModifiers());
        }
            // A for loop to go through the action listeners
        for (ActionListener l : listenerList.getListeners(ActionListener.class)){
            if (l != null)  // If the listener is not null
                l.actionPerformed(evt);
        }
    }
    /**
     * This notifies all the {@code ActionListener}s that have been added to 
     * this panel of the given action command if the action command is not null. 
     * @param command The action command for the action event to fire.
     * @param when The time at which the event occurred.
     * @param modifiers The modifier keys that were down during the event. Zero 
     * indicates that no known modifiers were passed.
     * @see #addActionListener(ActionListener) 
     * @see #removeActionListener(ActionListener) 
     * @see #getActionListeners() 
     * @see #fireActionPerformed(ActionEvent) 
     * @see #fireActionPerformed(String) 
     */
    protected void fireActionPerformed(String command, long when, int modifiers){
        if (command == null)    // If the action command is null.
            return;
        fireActionPerformed(new ActionEvent(this,ActionEvent.ACTION_PERFORMED,
                command,when,modifiers));
    }
    /**
     * This notifies all the {@code ActionListener}s that have been added to 
     * this panel of the given action command if the action command is not null. 
     * @param command The action command for the action event to fire.
     * @see #addActionListener(ActionListener) 
     * @see #removeActionListener(ActionListener) 
     * @see #getActionListeners() 
     * @see #fireActionPerformed(ActionEvent) 
     * @see #fireActionPerformed(String, long, int) 
     */
    protected void fireActionPerformed(String command){
        fireActionPerformed(command,System.currentTimeMillis(),0);
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
    /**
     * This returns an array of components that are visible in the given 
     * container.
     * @param c The container to get the visible components from.
     * @return An array of components from the given container that are visible, 
     * or an empty array if the container is empty or has no visible components.
     * @see #containsVisibleComponents 
     * @see Component#isVisible 
     */
    protected Component[] getVisibleComponents(Container c){
            // A list to get the visible components in the container
        ArrayList<Component> compList = new ArrayList<>(
                Arrays.asList(c.getComponents()));
            // Remove any component that is either null or not visible
        compList.removeIf((Component t) -> t == null || !t.isVisible());
        return compList.toArray(Component[]::new);
    }
    /**
     * This goes through the components in the given container and returns 
     * whether there is at least one component that is visible. If the container 
     * is empty or no components in the container are visible, then this returns 
     * false.
     * @param c The container to check.
     * @return Whether the container contains at least one visible component.
     * @see Component#isVisible 
     * @see #getVisibleComponents 
     * @see #updateContainerVisibility 
     * @see #updateParentVisibility 
     */
    protected boolean containsVisibleComponents(Container c){
            // Go through the components in the container
        for (int i = 0; i < c.getComponentCount(); i++){
                // Get the component at the current index
            Component temp = c.getComponent(i);
                // If the component is non-null and visible
            if (temp != null && temp.isVisible())   
                return true;
        }
        return false;
    }
    /**
     * This updates the visibility of the given container based off whether any 
     * of the components in the container are visible. This effectively 
     * calls {@link #containsVisibleComponents containsVisibleComponents} with 
     * the given container and sets the container's visibility based of the 
     * value returned.
     * @param c The container to update the visibility of.
     * @see #containsVisibleComponents 
     * @see #updateParentVisibility 
     */
    protected void updateContainerVisibility(Container c){
        c.setVisible(containsVisibleComponents(c));
    }
    /**
     * This updates the visibility of the parent of the given component. This 
     * effectively calls {@link #updateContainerVisibility 
     * updateContainerVisibility} with the parent of the given component.
     * @param c The component to update the parent's visibility.
     * @see #updateContainerVisibility 
     * @see #containsVisibleComponents 
     * @see Component#getParent 
     */
    protected void updateParentVisibility(Component c){
            // If neither the component or its parent are null.
        if (c == null || c.getParent() == null)
            return;
        updateContainerVisibility(c.getParent());
    }
    /**
     * This returns a listener used to update the visibility of a container 
     * based off the visibility of its child components. The listener adds the 
     * {@link #getChildVisibilityListener child visibility listener} to any 
     * component added to the container and removes it from components removed 
     * from the container.
     * @return The listener used to update the visibility of a container.
     * @see #getChildVisibilityListener 
     * @see #containsVisibleComponents 
     * @see #updateContainerVisibility 
     * @see #updateParentVisibility 
     */
    protected ContainerListener getVisibilityListener(){
        return visHandler;
    }
    /**
     * This returns a listener used to update the visibility of the parent of a 
     * component based off the visibility of the component and its sibling 
     * components. This listener invokes {@link #updateParentVisibility 
     * updateParentVisibility} with the component when the component is either 
     * shown or hidden.
     * @return The listener used to update the visibility of the parent of a 
     * component when the components visibility changes.
     * @see #getVisibilityListener 
     * @see #containsVisibleComponents 
     * @see #updateContainerVisibility 
     * @see #updateParentVisibility 
     */
    protected ComponentListener getChildVisibilityListener(){
        return visHandler;
    }
    /**
     * This is a handler class to listen to components for this panel.
     */
    private class Handler extends ComponentAdapter implements 
            PropertyChangeListener, ActionListener{
        @Override
        public void propertyChange(PropertyChangeEvent evt) {
                // If the property name is null or the source isn't a component
            if (evt.getPropertyName() == null || !(evt.getSource() instanceof Component))
                return;
                // Get the component source
            Component c = (Component) evt.getSource();
                // Get the property name to use for a forwarded event (typically 
                // used if it's a label)
            String fwdPropEvt = propNameMap.get(c);
                // Determine what to do depending on the property name
            switch(evt.getPropertyName()){
                    // If the icon changed for a label
                case("icon"):
                        // If the icon label's icon changed
                    if (c == iconLabel)
                            // Update whether the icon label is visible
                        iconLabel.setVisible(iconLabel.getIcon() != null);
                        // If the change should be forwarded to the listeners
                    if (fwdPropEvt != null)
                        firePropertyChange(fwdPropEvt,evt.getOldValue(),evt.getNewValue());
                    break;
                    // If the text changed
                case("text"):
                        // If a label's text changed and it's not the name label
                    if (c instanceof JLabel && c != nameLabel){
                            // Get the label's text
                        String text = ((JLabel)c).getText();
                            // Update wether the label is visible
                        c.setVisible(text != null && !text.isEmpty());
                    }   // If the change should be forwarded to the listeners
                    if (fwdPropEvt != null)
                        firePropertyChange(fwdPropEvt,evt.getOldValue(),evt.getNewValue());
                    break;
                    // If the URI for the website label changed
                case(JHyperlinkLabel.URI_PROPERTY_CHANGED):
                        // Update the website menu items
                    updateWebsiteMenuItems();
                    firePropertyChange(PROGRAM_WEBSITE_URI_PROPERTY_CHANGED,
                            evt.getOldValue(),evt.getNewValue());
                    break;
                    // If the website has been visited or unvisited
                case(JHyperlinkLabel.HYPERLINK_VISITED_PROPERTY_CHANGED):
                    firePropertyChange(PROGRAM_WEBSITE_VISITED_PROPERTY_CHANGED,
                            evt.getOldValue(),evt.getNewValue());
                    break;
                    // If the failure message, unvisited color, visited color, 
                    // or selected color changed
                case(JHyperlinkLabel.FAILURE_MESSAGES_SHOWN_PROPERTY_CHANGED):
                case(JHyperlinkLabel.UNVISITED_HYPERLINK_COLOR_PROPERTY_CHANGED):
                case(JHyperlinkLabel.VISITED_HYPERLINK_COLOR_PROPERTY_CHANGED):
                case(JHyperlinkLabel.ACTIVATED_HYPERLINK_COLOR_PROPERTY_CHANGED):
                    firePropertyChange(evt.getPropertyName(),evt.getOldValue(),
                            evt.getNewValue());
                    break;
                    // If the document changed
                case("document"):
                        // If the document for the credit text panel changed
                    if (c == creditsTextPane)
                        firePropertyChange(CREDITS_DOCUMENT_PROPERTY_CHANGED,
                                evt.getOldValue(),evt.getNewValue());
                    break;
                    // If the editor kit changed
                case("editorKit"):
                        // If the editor kit for the credit text panel changed
                    if (c == creditsTextPane)
                        firePropertyChange(CREDITS_EDITOR_KIT_PROPERTY_CHANGED,
                                evt.getOldValue(),evt.getNewValue());
                    // If whether the component inherits popup menus has changed
                case("inheritsPopupMenu"):
                        // If the value for the credit text panel changed
                    if (c == creditsTextPane)
                        creditsScrollPane.setInheritsPopupMenu(
                                creditsTextPane.getInheritsPopupMenu());
                    // If the popup menu has changed
                case("componentPopupMenu"):
                        // If the popup menu for the credit text panel changed
                    if (c == creditsTextPane)
                            // Add the word "credits" to the start of the name 
                            // and capitalize the first letter. 
                            // inheritsPopupMenu -> creditsInheritsPopupMenu
                            // componentPopupMenu -> creditsComponentPopupMenu
                        firePropertyChange("credits"+
                                evt.getPropertyName().substring(0, 1).toUpperCase() +
                                evt.getPropertyName().substring(1),
                                evt.getOldValue(),evt.getNewValue());
            }
        }
        @Override
        public void actionPerformed(ActionEvent evt) {
                // If the action command is null
            if (evt.getActionCommand() == null)
                return;
                // Determine the action to perform for the action command
            switch(evt.getActionCommand()){
                    // If the website should be opened
                case(OPEN_WEBSITE_SELECTED):
                        // Open the website
                    openProgramWebsite();
                    break;
                    // If the website should be copied
                case(COPY_WEBSITE_SELECTED):
                        // Copy the website to the clipboard
                    copyProgramWebsite();
                    break;
                    // If the close button, update button, or the license button 
                    // were pressed
                case(CLOSE_SELECTED):
                case(UPDATE_SELECTED):
                case(OPEN_LICENSE_SELECTED):
                    fireActionPerformed(evt);
            }
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
    /**
     * This is a handler used to update the visibility of containers based off 
     * their child component's visibility.
     */
    private class ParentVisibilityHandler extends ComponentAdapter implements 
            ContainerListener{
        @Override
        public void componentShown(ComponentEvent evt){
            updateParentVisibility(evt.getComponent());
        }
        @Override
        public void componentHidden(ComponentEvent evt){
            updateParentVisibility(evt.getComponent());
        }
        @Override
        public void componentAdded(ContainerEvent evt) {
            evt.getChild().addComponentListener(this);
            updateContainerVisibility(evt.getContainer());
        }
        @Override
        public void componentRemoved(ContainerEvent evt) {
            evt.getChild().removeComponentListener(this);
            updateContainerVisibility(evt.getContainer());
        }
    }
}
