/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SandwichTests;

import SandwichShop.ReadCard;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author user
 */
public class ReadCardTest {

    /**
     * Test of main method, of class ReadCard.
     */
    @Test
    public void testMain() throws Exception {
        System.out.println("main");
        String[] args = null;
        ReadCard.main(args);

    }

    /**
     * Test of CONTROL_CODE method, of class ReadCard.
     */
    @Test
    public void testCONTROL_CODE() {
        System.out.println("CONTROL_CODE");
        int expResult = 0;
        int result = ReadCard.CONTROL_CODE();
        assertEquals(expResult, result);

    }

    /**
     * Test of hexStringToByteArray method, of class ReadCard.
     */
    @Test
    public void testHexStringToByteArray() {
        System.out.println("hexStringToByteArray");
        String s = "0";
        byte[] expResult = null;
        byte[] result = ReadCard.hexStringToByteArray(s);
        assertArrayEquals(expResult, result);

    }
    
}
