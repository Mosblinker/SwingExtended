/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package event;

import java.awt.event.*;
import javax.swing.*;

/**
 * This provides a convenient method of having a component to provide error 
 * feedback if a mouse button is pressed on a disabled component. This does not 
 * prevent the component from receiving and processing the mouse button press, 
 * nor does this care which button was pressed. All this does is tell the 
 * current look and feel to provide error feedback if a mouse button is pressed
 * on a component while that component is not enabled.
 * @author Milo Steier
 */
public class DisabledComponentMouseListener extends MouseAdapter{
    /**
     * This is invoked when a mouse button is pressed on a component, and if 
     * that component is not enabled, this will cause the current look and feel
     * to provide error feedback to the user.
     * @param e The MouseEvent being processed.
     * @see java.awt.Component#isEnabled() 
     * @see UIManager#getLookAndFeel() 
     * @see LookAndFeel#provideErrorFeedback(java.awt.Component) 
     */
    @Override
    public void mousePressed(MouseEvent e){
            // If there is a component and that component is not enabled
        if (e.getComponent() != null && !e.getComponent().isEnabled())
            UIManager.getLookAndFeel().provideErrorFeedback(e.getComponent());
    }
}
