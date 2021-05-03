/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SandwichTests;

import SandwichShop.DeliveryService;
import org.junit.Test;

/**
 *
 * @author user
 */
public class DeliveryServiceTest {
    
    /**
     * Test of main method, of class DeliveryService.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        DeliveryService.main(args);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of proceed_to_checkout method, of class DeliveryService.
     */
    @Test
    public void testProceed_to_checkout() {
        System.out.println("proceed_to_checkout");
        String amount = "9.06";
        DeliveryService instance = new DeliveryService();
        instance.proceed_to_checkout(amount);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
