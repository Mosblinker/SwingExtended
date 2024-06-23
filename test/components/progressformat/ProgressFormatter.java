/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package components.progressformat;

import javax.swing.*;

/**
 *
 * @author Milo Steier
 */
public interface ProgressFormatter {
    
    public String format(BoundedRangeModel model);
    
    public default String format (JProgressBar progressBar){
        return format(progressBar.getModel());
    }
    
    
    
}
