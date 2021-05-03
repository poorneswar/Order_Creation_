package SandwichShop;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author Poorneswar
 */
public class DeliveryService extends JFrame {

    private JButton btnOk;
    private JButton btnReturn;
    public JTextField textField;
    private JLabel lblHowDoYou;
    private JRadioButton rdbtnCash;
    private JRadioButton rdbtnNewRadioButton;
    public String textField_value;
    public ArrayList<String> orderDetails;

    MyWindowListener windowListener = new MyWindowListener();
    String deliveryfee;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    DeliveryService window = new DeliveryService(); // Launch the Checkout class 
                    window.setVisible(true); // set it to visible
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public DeliveryService() { // Method containing the checkout functionality
        setTitle("Delivery Service"); // set the tittle for the JFrame
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); //optional, what happens when the frame closes
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                windowListener.handleClosing();
            }
        });
        setBounds(100, 100, 500, 296); //Explicitly defining the frame size and also frame location

        getContentPane().setLayout(null); //sets the layout manager as null

        btnReturn = new JButton("Return to Orders"); // Creates button with default value Return
        btnReturn.addActionListener(new ActionListener() { // Adds onClick listener to the button
            public void actionPerformed(ActionEvent e) { // method called after onClick
                EventQueue.invokeLater(new Runnable() { //include a thread to the method
                    public void run() { // method to run the thread
                        try {
                            Order window = new Order(); // Launch the Order window and setting it to be visible
                            window.setVisible(true); // 
                            DeliveryService window1 = new DeliveryService();
                            window1.setVisible(false); // Set the Checkout window to be invisible
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
        btnReturn.setBounds(62, 215, 135, 23);
        getContentPane().add(btnReturn);

        JLabel lblTotalCost = new JLabel("Total cost");
        lblTotalCost.setBounds(230, 100, 69, 20);
        getContentPane().add(lblTotalCost);

        textField = new JTextField();
        textField.setEditable(false);
        textField.setBounds(305, 100, 49, 20);
        getContentPane().add(textField);
        textField.setColumns(10);

        lblHowDoYou = new JLabel("Do You Want To Include Delivery Service ");
        lblHowDoYou.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblHowDoYou.setBounds(80, 11, 320, 34);
        getContentPane().add(lblHowDoYou);

        rdbtnCash = new JRadioButton("No");  // create radio button and give it default value
        rdbtnCash.setBounds(44, 76, 109, 23); // set the size and location of the button
        getContentPane().add(rdbtnCash); // add the button to the content pane
        rdbtnCash.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                float totalCost = Float.valueOf(textField_value);
                deliveryfee = Float.toString(totalCost);
                textField.setText("$ " + deliveryfee);
            }
        });

        rdbtnNewRadioButton = new JRadioButton("Yes Include");  // create radio button and give it default value Visa/Master Card
        rdbtnNewRadioButton.setBounds(44, 127, 135, 23); // set the size and location of the button
        getContentPane().add(rdbtnNewRadioButton); // add the button to the content pane 
        rdbtnNewRadioButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                float totalCost = (float) (Float.valueOf(textField_value) + 12.09);
                deliveryfee = Float.toString(totalCost);
                textField.setText("$ " + deliveryfee);
            }
        });

        ButtonGroup groupButton = new ButtonGroup(); // create ButtonGroup and add the radioButtons
        groupButton.add(rdbtnNewRadioButton);
        groupButton.add(rdbtnCash);

        btnOk = new JButton("Continue To Payment"); // create a button with default value Pay
        btnOk.addActionListener(new ActionListener() { // add onClick listener to the button
            public void actionPerformed(ActionEvent e) { // method invoked after button click
                if (rdbtnNewRadioButton.isSelected()) {
                    float totalCost = (float) (Float.valueOf(textField_value) + 12.09);
                    deliveryfee = Float.toString(totalCost);
                    textField.setText("$ " + deliveryfee);
                    proceed_to_checkout(deliveryfee);
                } else if (rdbtnCash.isSelected()) {
                    float totalCost = Float.valueOf(textField_value);
                    deliveryfee = Float.toString(totalCost);
                    textField.setText("$ " + deliveryfee);
                    proceed_to_checkout(textField_value);
                } else {
                    JOptionPane.showMessageDialog(null, "Please Select an Option to Proceed");

                }
            }
        });
        btnOk.setBounds(294, 215, 142, 23);
        getContentPane().add(btnOk);
    }

    public void proceed_to_checkout(String amount) {
        Checkout checkout = new Checkout();
        // launch Checkout class by instantiating it
        checkout.frmPersonalInfo.setVisible(true); // make the Checkout class visible
        float totalCost = Float.valueOf(amount);
        checkout.textField.setText("$ " + Float.toString(totalCost));
        checkout.string = textField_value;
        checkout.orderDetails = orderDetails;
    }
}
