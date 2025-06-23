/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package components;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.datatransfer.Clipboard;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.net.URI;
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
    
    public static final String UPDATE_CHECK_SELECTED = "CheckForUpdatesSelected";
    
    public static final String OPEN_LICENSE_SELECTED = "OpenLicenseSelected";
    
    public static final String OPEN_WEBSITE_SELECTED = "OpenWebsiteSelected";
    
    public static final String COPY_WEBSITE_SELECTED = "CopyWebsiteSelected";
    
    public static final String PROGRAM_ICON_PROPERTY_CHANGED = 
            "ProgramIconPropertyChanged";
    
    public static final String PROGRAM_NAME_PROPERTY_CHANGED = 
            "ProgramNamePropertyChanged";
    
    public static final String PROGRAM_VERSION_PROPERTY_CHANGED = 
            "ProgramVersionPropertyChanged";
    
    public static final String PROGRAM_COPYRIGHT_START_YEAR_PROPERTY_CHANGED = 
            "ProgramCopyrightStartYearPropertyChanged";
    
    public static final String PROGRAM_COPYRIGHT_END_YEAR_PROPERTY_CHANGED = 
            "ProgramCopyrightEndYearPropertyChanged";
    
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
    /**
     * This is the text that appears before the program version on the program 
     * version label.
     */
    private static final String VERSION_TEST_PREFIX = "Version ";
    /**
     * This is a template for the text to display for the copyright.
     */
    private static final String COPYRIGHT_TEXT_TEMPLATE = "Copyright © %s";
    
    private Integer crStartYear = null;
    private Integer crEndYear = null;
    private String version = null;
    private Map<Component,Component> fillerMap = new HashMap<>();
    private Map<Component,String> propNameMap = new HashMap<>();
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
    protected JButton licenseButton;
    protected JPopupMenu websitePopup;
    protected JMenuItem websiteOpenItem;
    protected JMenuItem websiteCopyItem;
    
    private Border createCreditBorder(){
        TitledBorder border = BorderFactory.createTitledBorder("Credits");
        border.setTitleColor(getForeground());
        border.setTitleFont(getFont());
        return border;
    }
    
    private Box.Filler createFiller(Component comp, int minWidth, int minHeigth, 
            int maxWidth, int maxHeight){
            // Create a filler object
        Box.Filler filler = new Box.Filler(new Dimension(minWidth, minHeigth), 
                new Dimension(minWidth, minHeigth), 
                new Dimension(maxWidth, maxHeight));
        if (comp != null){
                // Add the component and filler object to the filler map
            fillerMap.put(comp, filler);
        }
        return filler;
    }
    
    private void initializeDetailsLabel(JLabel label, Handler handler){
        label.addPropertyChangeListener(handler);
        label.addComponentListener(handler);
        label.setForeground(null);
        label.setBackground(null);
            // Center the label's alignment
        label.setAlignmentX(0.5f);
            // Add the label to the details panel
        detailsPanel.add(label);
            // Add a filler object to the details panel
        detailsPanel.add(createFiller(label,0,7,32767,7));
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
        iconLabel.setForeground(null);
        iconLabel.setBackground(null);
        propNameMap.put(iconLabel, PROGRAM_ICON_PROPERTY_CHANGED);
        iconLabel.addPropertyChangeListener("icon", handler);
            // Put the icon label on the left side of the panel
        add(iconLabel, BorderLayout.LINE_START);
            // Hide the icon label for now
        iconLabel.setVisible(false);
            // Create a details panel to display the labels and stuff
        detailsPanel = new JPanel();
        detailsPanel.setForeground(null);
        detailsPanel.setBackground(null);
        detailsPanel.setLayout(new BoxLayout(detailsPanel, BoxLayout.Y_AXIS));
            // Put the details panel in the center of the panel
        add(detailsPanel, BorderLayout.CENTER);
            // Create and add the program name label
        nameLabel = new JLabel();
        nameLabel.setFont(deriveFont(Font.BOLD,9));
        initializeDetailsLabel(nameLabel,handler);
        propNameMap.put(nameLabel, PROGRAM_NAME_PROPERTY_CHANGED);
            // Create and add the version label
        versionLabel = new JLabel();
        versionLabel.setFont(deriveFont(Font.BOLD|Font.ITALIC,5));
        initializeDetailsLabel(versionLabel,handler);
        versionLabel.setVisible(false);
            // Create and add the copyright label
        copyrightLabel = new JLabel();
        initializeDetailsLabel(copyrightLabel,handler);
        copyrightLabel.setVisible(false);
            // Create and add the website label
        websiteLabel = new JHyperlinkLabel();
        initializeDetailsLabel(websiteLabel,handler);
        propNameMap.put(websiteLabel, PROGRAM_WEBSITE_TEXT_PROPERTY_CHANGED);
        websiteLabel.setVisible(false);
            // Create a popup menu for the website label
        websitePopup = new JPopupMenu();
            // Create a menu item for opening the link
        websiteOpenItem = new JMenuItem("Open Link");
        websiteOpenItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, 0));
        websiteOpenItem.setActionCommand(OPEN_WEBSITE_SELECTED);
        websiteOpenItem.addActionListener(handler);
        websiteOpenItem.setEnabled(false);
            // Add the open menu item to the popup menu for the website label
        websitePopup.add(websiteOpenItem);
            // Create a menu item for copying the link
        websiteCopyItem = new JMenuItem("Copy Link");
        websiteCopyItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, 0));
        websiteCopyItem.setActionCommand(COPY_WEBSITE_SELECTED);
        websiteCopyItem.addActionListener(handler);
        websiteCopyItem.setEnabled(false);
            // Add the copy menu item to the popup menu for the website label
        websitePopup.add(websiteCopyItem);
            // Set the popup menu for the website label
        websiteLabel.setComponentPopupMenu(websitePopup);
            // Create the credits panel
        creditsPanel = new JPanel(new BorderLayout());
        creditsPanel.setBorder(createCreditBorder());
        creditsPanel.setForeground(null);
        creditsPanel.setBackground(null);
            // Add the credits panel to the details panel
        detailsPanel.add(creditsPanel);
        
        creditsTextPane = new JTextPane();
        creditsTextPane.setEditable(false);
        creditsTextPane.addPropertyChangeListener(handler);
        creditsScrollPane = new JScrollPane(creditsTextPane);
        creditsScrollPane.setForeground(null);
        creditsScrollPane.setBackground(null);
        creditsPanel.add(creditsScrollPane, BorderLayout.CENTER);
        
            // Create the bottom panel
        bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setForeground(null);
        bottomPanel.setBackground(null);
            // Create the button panel
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        buttonPanel.setForeground(null);
        buttonPanel.setBackground(null);
        
        updateButton = new JButton("Check For Updates");
        updateButton.setActionCommand(UPDATE_CHECK_SELECTED);
        updateButton.addActionListener(handler);
        updateButton.addComponentListener(handler);
        updateButton.setForeground(null);
        buttonPanel.add(updateButton);
        buttonPanel.add(createFiller(updateButton,6,0,6,32767));
        updateButton.setVisible(false);
        
        licenseButton = new JButton("License");
        licenseButton.setActionCommand(OPEN_LICENSE_SELECTED);
        licenseButton.addActionListener(handler);
        licenseButton.addComponentListener(handler);
        licenseButton.setForeground(null);
        buttonPanel.add(licenseButton);
        buttonPanel.add(createFiller(licenseButton,6,0,6,32767));
        licenseButton.setVisible(false);
        
        closeButton = new JButton("OK");
        closeButton.setActionCommand(CLOSE_SELECTED);
        closeButton.addActionListener(handler);
        closeButton.setForeground(null);
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
    
    public Icon getProgramIcon(){
        return iconLabel.getIcon();
    }
    
    public void setProgramIcon(Icon icon){
        iconLabel.setIcon(icon);
    }
    
    public String getProgramName(){
        return nameLabel.getText();
    }
    
    public void setProgramName(String name){
        nameLabel.setText(name);
    }
    
    public String getProgramVersion(){
        return version;
    }
    
    public void setProgramVersion(String version){
        if (Objects.equals(this.version, version))
            return;
        String old = this.version;
        this.version = version;
        firePropertyChange(PROGRAM_VERSION_PROPERTY_CHANGED,old,version);
        versionLabel.setText((version!= null)?VERSION_TEST_PREFIX+version:null);
    }
    
    public Integer getCopyrightStartYear(){
        return crStartYear;
    }
    
    public void setCopyrightStartYear(Integer year){
        if (Objects.equals(crStartYear, year))
            return;
        Integer old = crStartYear;
        crStartYear = year;
        firePropertyChange(PROGRAM_COPYRIGHT_START_YEAR_PROPERTY_CHANGED,old,year);
        updateCopyrightText();
    }
    
    protected int getCurrentYear(){
        return new java.util.GregorianCalendar().get(java.util.Calendar.YEAR);
    }
    
    public int getCopyrightEndYear(){
        if (crEndYear == null)
            return getCurrentYear();
        return crEndYear;
    }
    
    public void setCopyrightEndYear(Integer year){
        if (Objects.equals(crEndYear, year))
            return;
        Integer old = crEndYear;
        crEndYear = year;
        firePropertyChange(PROGRAM_COPYRIGHT_END_YEAR_PROPERTY_CHANGED,old,year);
        updateCopyrightText();
    }
    
    public boolean isCopyrightEndYearSet(){
        return crEndYear != null;
    }
    
    public void setCopyrightYear(Integer startYear, Integer endYear){
        setCopyrightStartYear(startYear);
        setCopyrightEndYear(endYear);
    }
    
    public void setCopyrightYear(Integer startYear){
        setCopyrightYear(startYear,null);
    }
    
    protected String getCopyrightText(int startYear, int endYear){
        String yearText = Integer.toString(Math.min(startYear, endYear));
        if (startYear != endYear)
            yearText += "-"+Math.max(startYear, endYear);
        return String.format(COPYRIGHT_TEXT_TEMPLATE, yearText);
    }
    
    protected void updateCopyrightText(){
        Integer start = getCopyrightStartYear();
        if (start != null)
            copyrightLabel.setText(getCopyrightText(start,getCopyrightEndYear()));
        else
            copyrightLabel.setText(null);
    }
    
    public String getProgramWebsiteText(){
        return websiteLabel.getText();
    }
    
    public void setProgramWebsiteText(String text){
        websiteLabel.setText(text);
    }
    
    public URI getProgramWebsiteURI(){
        return websiteLabel.getURI();
    }
    
    public void setProgramWebsiteURI(URI uri){
        websiteLabel.setURI(uri);
    }
    
    public void setProgramWebsite(String text, URI uri){
        setProgramWebsiteText(text);
        setProgramWebsiteURI(uri);
    }
    
    public void openProgramWebsite(){
        websiteLabel.openHyperlink();
    }
    
    public void copyProgramWebsite(Clipboard clipboard){
        websiteLabel.copyHyperlink(clipboard);
    }
    
    public void copyProgramWebsite(){
        websiteLabel.copyHyperlink();
    }
    
    public boolean isProgramWebsiteVisited(){
        return websiteLabel.isVisited();
    }
    
    public void setProgramWebsiteVisited(boolean value){
        websiteLabel.setVisited(value);
    }
    
    public Color getUnvisitedHyperlinkColor(){
        return websiteLabel.getUnvisitedHyperlinkColor();
    }
    
    public void setUnvisitedHyperlinkColor(Color color){
        websiteLabel.setUnvisitedHyperlinkColor(color);
    }
    
    public Color getVisitedHyperlinkColor(){
        return websiteLabel.getVisitedHyperlinkColor();
    }
    
    public void setVisitedHyperlinkColor(Color color){
        websiteLabel.setVisitedHyperlinkColor(color);
    }
    
    public Color getSelectedHyperlinkColor(){
        return websiteLabel.getSelectedHyperlinkColor();
    }
    
    public void setSelectedHyperlinkColor(Color color){
        websiteLabel.setSelectedHyperlinkColor(color);
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
    
    // TODO: Add credit methods
    
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
    
    private void updateWebsiteMenuItems(){
        websiteOpenItem.setEnabled(isEnabled() && websiteLabel.getURI() != null);
        websiteCopyItem.setEnabled(websiteOpenItem.isEnabled());
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
            creditsPanel.setBorder(createCreditBorder());
            licenseButton.setFont(font);
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
    @Override
    public void setForeground(Color fg){
        super.setForeground(fg);
        fg = getForeground();
        try{
            creditsPanel.setBorder(createCreditBorder());
            creditsTextPane.setForeground(fg);
        } catch (NullPointerException ex){ }
    }
    @Override
    public void setBackground(Color bg){
        super.setBackground(bg);
        bg = getBackground();
        try{
            closeButton.setBackground(bg);
            updateButton.setBackground(bg);
            licenseButton.setBackground(bg);
        } catch (NullPointerException ex){ }
    }
    @Override
    public Dimension getMinimumSize(){
        return (isMinimumSizeSet())?super.getMinimumSize():new Dimension(640,480);
    }
    @Override
    protected String paramString(){
        return super.paramString();
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
    
    private class Handler extends ComponentAdapter implements 
            PropertyChangeListener, ActionListener{
        @Override
        public void propertyChange(PropertyChangeEvent evt) {
            if (evt.getPropertyName() == null || !(evt.getSource() instanceof Component))
                return;
            Component c = (Component) evt.getSource();
            String fwdPropEvt = propNameMap.get(c);
            switch(evt.getPropertyName()){
                case("icon"):
                    if (c == iconLabel)
                        iconLabel.setVisible(iconLabel.getIcon() != null);
                    if (fwdPropEvt != null)
                        firePropertyChange(fwdPropEvt,evt.getOldValue(),evt.getNewValue());
                    break;
                case("text"):
                    if (c instanceof JLabel && c != nameLabel){
                        String text = ((JLabel)c).getText();
                        c.setVisible(text != null && !text.isEmpty());
                    }
                    if (fwdPropEvt != null)
                        firePropertyChange(fwdPropEvt,evt.getOldValue(),evt.getNewValue());
                    break;
                case(JHyperlinkLabel.URI_PROPERTY_CHANGED):
                    updateWebsiteMenuItems();
                    firePropertyChange(PROGRAM_WEBSITE_URI_PROPERTY_CHANGED,
                            evt.getOldValue(),evt.getNewValue());
                    break;
                case(JHyperlinkLabel.HYPERLINK_VISITED_PROPERTY_CHANGED):
                    firePropertyChange(PROGRAM_WEBSITE_VISITED_PROPERTY_CHANGED,
                            evt.getOldValue(),evt.getNewValue());
                    break;
                case(JHyperlinkLabel.FAILURE_MESSAGES_SHOWN_PROPERTY_CHANGED):
                case(JHyperlinkLabel.UNVISITED_HYPERLINK_COLOR_PROPERTY_CHANGED):
                case(JHyperlinkLabel.VISITED_HYPERLINK_COLOR_PROPERTY_CHANGED):
                case(JHyperlinkLabel.SELECTED_HYPERLINK_COLOR_PROPERTY_CHANGED):
                    firePropertyChange(evt.getPropertyName(),evt.getOldValue(),
                            evt.getNewValue());
                    break;
                case("document"):
                    if (c == creditsTextPane)
                        firePropertyChange(CREDITS_DOCUMENT_PROPERTY_CHANGED,
                                evt.getOldValue(),evt.getNewValue());
                    break;
                case("editorKit"):
                    if (c == creditsTextPane)
                        firePropertyChange(CREDITS_EDITOR_KIT_PROPERTY_CHANGED,
                                evt.getOldValue(),evt.getNewValue());
            }
        }
        @Override
        public void actionPerformed(ActionEvent evt) {
            if (evt.getActionCommand() == null)
                return;
            switch(evt.getActionCommand()){
                case(OPEN_WEBSITE_SELECTED):
                    openProgramWebsite();
                    break;
                case(COPY_WEBSITE_SELECTED):
                    copyProgramWebsite();
                    break;
                case(CLOSE_SELECTED):
                case(UPDATE_CHECK_SELECTED):
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
}
