/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package event;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.*;
import java.util.*;
import javax.swing.*;
import static javax.swing.JFileChooser.*;

/**
 * This class listens to any changes in the file selection in a JFileChooser 
 * and can determine which file was selected.
 * @author Milo Steier
 */
public abstract class LeadFileSelectionListener implements PropertyChangeListener{
    /**
     * This identifies that the lead file selection has changed.
     */
    public static final String LEAD_FILE_SELECTION_CHANGED_PROPERTY = 
            "LeadFileSelectionChangedProperty";
    /**
     * This holds the lead file selection.
     */
    private File file;
    /**
     * This holds whether the lead file selection is actually selected.
     */
    private boolean sel;
    /**
     * This constructs a LeadFileSelectionListener.
     */
    public LeadFileSelectionListener(){
        file = null;
        sel = false;
    }
    /**
     * This gets the lead file selection. If only one file is selected, this 
     * returns the selected file. If there is no lead file selection, then this 
     * returns null.
     * @return The lead file selection, or null if there is no lead file 
     * selection.
     */
    public File getLeadFileSelection() {
            // If the file is actually selected, return it. Otherwise, return 
        return (sel) ? file : null; // null.
    }
    /**
     * This gets the JFileChooser that the property change originated from. If 
     * the property change did not originate from a JFileChooser, then this will
     * throw an IllegalArgumentException.
     * @param evt The PropertyChangeEvent that occurred.
     * @return The JFileChooser that the change originated from.
     * @throws IllegalArgumentException If the property change did not originate
     * from a JFileChooser.
     */
    protected JFileChooser getJFileChooser(PropertyChangeEvent evt) {
            // If the source is not a JFileChooser
        if (!(evt.getSource() instanceof JFileChooser))
            throw new IllegalArgumentException("The source of the property "
                    + "change must be a JFileChooser.");
        return (JFileChooser) evt.getSource();
    }
    /**
     * This processes the property change when the lead file selection has 
     * changed.
     * @param evt A PropertyChangeEvent stating the change that occurred.
     */
    public abstract void leadFileSelectionChange(PropertyChangeEvent evt);
    
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
            // This gets the JFileChooser that initiated the change
        JFileChooser source = getJFileChooser(evt);
        String prop = evt.getPropertyName();    // This gets the property name
            // If either the property name is null or there was no change
        if (prop==null||Objects.deepEquals(evt.getOldValue(),evt.getNewValue()))
            return;
        File prev = file;       // This holds the previous lead file selection.
            // This holds whether the previous lead file selection was actually selected.
        boolean prevSel = sel;  
        switch(prop){
            // If the user has changed the directory
            case DIRECTORY_CHANGED_PROPERTY:
                file = null;
                break;
            // If the user has selected a file
            case SELECTED_FILE_CHANGED_PROPERTY:
                    // If the file chooser has multiple file selection enabled,
                    // then this property change can be ignored
                if (source.isMultiSelectionEnabled())
                    return;
                sel = evt.getNewValue() != null;
                    // If a file was selected, get the newly selected file. 
                    // Otherwise, get the file no longer selected
                file = (File)((sel)?evt.getNewValue():evt.getOldValue());
                break;
            // If the user has selected multiple files
            case SELECTED_FILES_CHANGED_PROPERTY:
                // HACK: This is the main reason why this listener was necessary 
                // to make in the first place: To get arround the fact that 
                // JFileChooser does not have a way to get the lead selected 
                // file when multiple files can be and are selected. This is all 
                // just to get a good guess of what the lead selected file might 
                // be.
                    // This gets all the previously selected files
                File[] oldFiles = (File[]) evt.getOldValue();
                    // This gets all the currently selected files
                File[] newFiles = (File[]) evt.getNewValue();
                    // If there were no files previously selected
                if (oldFiles == null || oldFiles.length == 0)
                    oldFiles = new File[]{prev};
                    // If there are no files currently selected
                if (newFiles == null || newFiles.length == 0){
                    sel = false;
                }   // If only one file is currently selected
                else if (newFiles.length == 1){ 
                    file = newFiles[0];
                    sel = true;
                }
                else{
                        // Get the sorted version of the currently selected 
                    File[] newSorted = createSortedArray(newFiles); // files
                        // Get the sorted version of the previously selected
                    File[] oldSorted = createSortedArray(oldFiles); // files
                        // If the only change was the order of the selected 
                    if (Objects.deepEquals(newSorted, oldSorted))   // files
                        return;
                        // If the first selected file has changed
                    if (!Objects.equals(newFiles[0],oldFiles[0])){
                        file = newFiles[0];
                        sel = true;
                    }   // If the last selected file has changed
                    else if (!Objects.equals(newFiles[newFiles.length-1],
                            oldFiles[oldFiles.length-1])){
                        file = newFiles[newFiles.length-1];
                        sel = true;
                    }
                    else{   // If the files in the middle have changed
                            // This gets the amount of files that have changed
                        int lenDiff = Math.abs(newFiles.length - oldFiles.length);
                            // This gets the index of the first file that has changed
                        int misMatch = Arrays.mismatch(newFiles, oldFiles);
                        if (misMatch < 0)   // If there actually wasn't a change
                            return;
                            // Gets whether files were selected or unselected
                        sel = newFiles.length >= oldFiles.length;
                        file = newFiles[misMatch];
                            // If the length has changed by more than 1
                        if (lenDiff > 1){
                                // If files were selected and the last file to 
                                // not change was the file previously selected
                                // (i.e. the selection was top to bottom)
                            if (sel&&Objects.equals(newFiles[misMatch-1],prev))
                                file = newFiles[misMatch+lenDiff-1];
                                // If files were unselected and the first file 
                                // in the old files to be different was the file 
                                // previously selected (i.e. the selection was 
                                // bottom to top)
                            else if (!sel&&!Objects.equals(oldFiles[misMatch],prev))
                                file = newFiles[misMatch-1];
                            sel = true;
                        }
                    }
                }
                break;
            default:
                return;
        }
        sel = sel && file != null;
            // If the previous lead file selection was not actually selected
        if (!prevSel)      
            prev = null;
            // If there was a change in the lead file selection
        if (!Objects.equals(prev, getLeadFileSelection()))
            fireLeadFileSelectionChange(source,prev,getLeadFileSelection());
    }
    /**
     * This returns a sorted copy of the given array of files.
     * @param files The array of files to copy and sort.
     * @return A sorted copy of the given array, or null if the given array is 
     * null.
     */
    protected File[] createSortedArray(File[] files){
        if (files == null)      // If the array is null
            return null;
        files = Arrays.copyOf(files, files.length);
        Arrays.sort(files);
        return files;
    }
    /**
     * This is used to call the {@code leadFileSelectionChange()} method using 
     * the given source, previous lead file selection, and current lead file 
     * selection.
     * @param source The JFileChooser that the property change originated from.
     * @param oldValue The previous lead file selection, or null if no file was 
     * selected.
     * @param newValue The current lead file selection, or null if no file is 
     * selected.
     * @see #leadFileSelectionChange(java.beans.PropertyChangeEvent) 
     * @see #propertyChange(java.beans.PropertyChangeEvent) 
     */
    protected void fireLeadFileSelectionChange(JFileChooser source, 
            File oldValue, File newValue){
        leadFileSelectionChange(new PropertyChangeEvent(source, 
                LEAD_FILE_SELECTION_CHANGED_PROPERTY,oldValue,newValue));
    }
}
