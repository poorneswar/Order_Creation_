
package SandwichTests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.Integer.parseInt;
import javax.swing.JOptionPane;
import static org.junit.Assert.assertTrue;
import org.junit.Test;


public class OrderFileCreatedTests {


    

    /**
     * Test of orderDetails method, of class Checkout.
     */
    @Test
    public void OrderFileCreatedTests() throws Exception {
//        System.out.println("orderDetails");
//        String string = "$ 8.05";
//       ArrayList<String> orderDetails = new ArrayList<String>(Arrays.asList("Ranch $0.65","Tomato $0.45","Mayo $0.80")) ;
//       JTextField textField = new JTextField(string);
//        Checkout instance = new Checkout();
//        instance.string=(string);
//        instance.orderDetails = orderDetails;
//        instance.textField.setText(string);
//        instance.orderDetails();

        int i = 1;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("src//SandwichShop//orders_memory.txt")))) {
            String Lastline = "", line;
            while ((line = reader.readLine()) != null) { // this checks that the string read from the file is not null the continues
                Lastline = line;
            }
            int b = parseInt(Lastline);
            i = b;
            reader.close(); // Close the file   
        } catch (IOException e) {
            System.out.print("");
        }
        String path = "src//SandwichShop//CustomerOrder" + i + ".txt";
        File file = new File(path);
        if(file.exists()){
        JOptionPane.showMessageDialog(null,"Customer Record "+Integer.toString(i)+" Exists");
        }else{
            JOptionPane.showMessageDialog(null,"Customer Record "+Integer.toString(i)+" Doesn't Exist\n\nPlace an Order to create one");
        }
        
        assertTrue(file.exists());
    }

    
}
