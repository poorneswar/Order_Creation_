/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SandwichTests;

import SandwichShop.MyWindowListener;
import SandwichShop.Order;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import org.junit.Test;

/**
 *
 * @author user
 */
public class MyWindowListenerTest {
    
    
    /**
     * Test of handleClosing method, of class MyWindowListener.
     */
    @Test
    public void testHandleClosing() {
        System.out.println("handleClosing");
        MyWindowListener instance = new MyWindowListener();
        instance.handleClosing();
        MyWindowListener windowListener = new MyWindowListener();
Order order = new Order();
    //creates new window that shows options for the user to pick to order
     order.windowListener.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                windowListener.handleClosing();
            }
        });
        
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
