package SandwichShop;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

//This class has the window listener which controls window closing event whe the close button is clicked and display a close confirmation window
public class MyWindowListener extends JFrame{

    public MyWindowListener() {
        
    addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                handleClosing();
            }
        });
    }
    public void handleClosing() {
        if (true) {
            int answer = showWarningMessage();
             
            switch (answer) {
                case JOptionPane.YES_OPTION:
                    System.out.println("Quit");
                    System.exit(0);
                    break;
                     
                case JOptionPane.NO_OPTION:
                    break;
                     
                case JOptionPane.CANCEL_OPTION:
                    System.out.println("Don't Quit");
                    break;
            }
        } else {
            dispose();
        }      
    }
     
    private int showWarningMessage() {
        String[] buttonLabels = new String[] {"Yes", "Cancel"};
        String defaultOption = buttonLabels[0];
        Icon icon = null;
         
        return JOptionPane.showOptionDialog(this,
                "Are you sure to close this window?",
                "Warning",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.WARNING_MESSAGE,
                icon,
                buttonLabels,
                defaultOption);    
    }
 
    }


