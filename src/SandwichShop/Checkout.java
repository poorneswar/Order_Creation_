package SandwichShop;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.smartcardio.CardException;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Checkout {

    public JFrame frmPersonalInfo;
    private JButton btnOk;
    private JButton btnReturn;
    public JTextField textField;
    private JLabel lblHowDoYou;
    private JRadioButton rdbtnCash;
    private JRadioButton rdbtnNewRadioButton;
    public ArrayList<String> orderDetails;
    public String string;

    //This is the main class       
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Checkout window = new Checkout(); // Launch the Checkout class 
                    window.frmPersonalInfo.setVisible(true); // set it to visible
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Checkout() { 
        initialize(); 
    }

    
    private void initialize() {
        frmPersonalInfo = new JFrame(); // Creating checkout frame
        frmPersonalInfo.setTitle("Payment"); // set the tittle for the JFrame
        frmPersonalInfo.setBounds(100, 100, 500, 296); //Explicitly defining the frame size and also frame location
        
        frmPersonalInfo.addWindowListener(new WindowAdapter() { // add listener to the close window button and show confirmation dialog whether to close the window
            public void windowClosing(WindowEvent we) {
                int result = JOptionPane.showConfirmDialog(frmPersonalInfo,
                        "Do you want to Exit ?", "Exit Confirmation : ",
                        JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION) {
                    frmPersonalInfo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                } else if (result == JOptionPane.NO_OPTION) {
                    frmPersonalInfo.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                }
            }
        });
        frmPersonalInfo.getContentPane().setLayout(null); //sets the layout manager as null

        btnReturn = new JButton("Return"); // Creates button with default value Return
        btnReturn.addActionListener(new ActionListener() { // Adds onClick listener to the button
            public void actionPerformed(ActionEvent e) { // method called after onClick
                EventQueue.invokeLater(new Runnable() { //include a thread to the method
                    public void run() { // method to run the thread
                        try {
                            DeliveryService window = new DeliveryService(); // Launch the Delivery service window and setting it to be visible
                            window.setVisible(true);
                            window.textField_value = string;
                            window.textField.setText("$ " + string);
                            Checkout window1 = new Checkout();
                            window1.frmPersonalInfo.setVisible(false); // Set the Checkout window to be invisible
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
        btnReturn.setBounds(62, 215, 135, 23);
        frmPersonalInfo.getContentPane().add(btnReturn);

        JLabel lblTotalCost = new JLabel("Total cost");
        lblTotalCost.setBounds(230, 100, 69, 20);
        frmPersonalInfo.getContentPane().add(lblTotalCost);

        textField = new JTextField();
        textField.setEditable(false);
        textField.setBounds(305, 100, 49, 20);
        frmPersonalInfo.getContentPane().add(textField);
        textField.setColumns(10);

        lblHowDoYou = new JLabel("How do you want to pay?");
        lblHowDoYou.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblHowDoYou.setBounds(163, 11, 215, 34);
        frmPersonalInfo.getContentPane().add(lblHowDoYou);

        rdbtnCash = new JRadioButton("Cash");  // create radio button and give it default value
        rdbtnCash.setBounds(44, 76, 109, 23); // set the size and location of the button
        frmPersonalInfo.getContentPane().add(rdbtnCash); // add the button to the content pane 

        rdbtnNewRadioButton = new JRadioButton("Visa/Master Card");  // create radio button and give it default value Visa/Master Card
        rdbtnNewRadioButton.setBounds(44, 127, 135, 23); // set the size and location of the button
        frmPersonalInfo.getContentPane().add(rdbtnNewRadioButton); // add the button to the content pane 

        ButtonGroup groupButton = new ButtonGroup(); // create ButtonGroup and add the radioButtons
        groupButton.add(rdbtnNewRadioButton);
        groupButton.add(rdbtnCash);

        btnOk = new JButton("Pay"); // create a button with default value Pay
        btnOk.addActionListener(new ActionListener() { // add onClick listener to the button
            public void actionPerformed(ActionEvent e) { // method invoked after button click
                if (rdbtnNewRadioButton.isSelected()) {
                    int result = JOptionPane.showConfirmDialog(
                            null,
                            "Would you like use credit card?",
                            "Confirm Order",
                            JOptionPane.YES_NO_CANCEL_OPTION);
                    switch (result) {
                        case JOptionPane.YES_OPTION:
                            try {
                                orderDetails();
                            } catch (UnsupportedEncodingException ex) {
                                Logger.getLogger(Checkout.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            JOptionPane.showInputDialog(null, "Enter your password please", "Confirm payment",
                                    JOptionPane.PLAIN_MESSAGE, null, null, null);
                            JOptionPane.showMessageDialog(null, "Check your console output to read card data.");
                            //reading card data

                            ReadCard cardData = new ReadCard();
                            try {
                                cardData.main(null);

                            } catch (CardException ex) {
                                Logger.getLogger(Checkout.class.getName()).log(Level.SEVERE, null, ex);
                            }

                            break;
                        case JOptionPane.NO_OPTION:
                            JOptionPane.showMessageDialog(null, "You should pay in cash " + textField.getText());
                             {
                                try {
                                    orderDetails();
                                } catch (UnsupportedEncodingException ex) {
                                    Logger.getLogger(Checkout.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                            System.exit(0);
                        case JOptionPane.CANCEL_OPTION:
                            break;
                        default:
                            break;
                    }
                } else if (rdbtnCash.isSelected()) {
                    try {
                        orderDetails();
                    } catch (UnsupportedEncodingException ex) {
                        Logger.getLogger(Checkout.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    JOptionPane.showMessageDialog(null, "Thank for shopping with us");
                    System.exit(0);
                } else {
                    JOptionPane.showMessageDialog(null, "Please select payment option!");

                }
            }
        });
        btnOk.setBounds(294, 215, 142, 23);
        frmPersonalInfo.getContentPane().add(btnOk);
    }

    public void orderDetails() throws UnsupportedEncodingException {
        FileWriter fw; // create variable for the FileWriter which writes to the orders_memory
        FileWriter fw1; // create variable for the FileWriter which writes to the orders_memory
        int i = 1;
                Login user = new Login();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("src//SandwichShop//orders_memory.txt")))) {
            String Lastline = "", line;
            while ((line = reader.readLine()) != null) { // this checks that the string read from the file is not null then continues
                Lastline = line;
            }
            int b = parseInt(Lastline);
            i = b;
            reader.close(); // Close the file   
        } catch (IOException e) {
            System.out.print("");
        }

        try {
            fw = new FileWriter("src//SandwichShop//orders_memory.txt", true);       

            String path = "src//SandwichShop//CustomerOrder" + i + ".txt";
            File file = new File(path);
            if (file.createNewFile()) {
                System.out.println("File created succesfully");
                fw1 = new FileWriter(path, true); 
                fw1.write("Customer Name: "+user.userName+ "\nOrdered Items\n" + orderDetails.toString() +"\nOrder Cost: $"+string+"\nTotal Cost " + textField.getText());
                fw1.close();
                fw.write(i + "\n"); 
            } else {

                path = "src//SandwichShop//CustomerOrder" + (i + 1) + ".txt";
                file = new File(path);
                file.createNewFile();
                System.out.println("New file " + Integer.toString(i + 1) + " Was created");
                fw1 = new FileWriter(path, true); 
                fw1.write("Customer Name: "+user.userName+ "\nOrdered Items\n" + orderDetails.toString() +"\nOrder Cost: $"+string + "\nTotal Cost " + textField.getText());
                fw1.close();
                fw.write((i + 1) + "\n"); 

            }
            fw.close(); 

        } catch (IOException ex) {
            Logger.getLogger(Checkout.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
