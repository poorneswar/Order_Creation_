package SandwichShop;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ForgotPassword extends JFrame {

    private JTextField txtEmail;
    private JPanel contentPane;
    private JLabel lblEnterYourEmail;

    //creates the Forgot Password frame
    //creates the login frame
    MyWindowListener windowListener = new MyWindowListener();

    //creates new window that shows options for the user to pick to order
    public ForgotPassword() {
        setTitle("Fogot password"); 
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); //optional, what happens when the frame closes
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                windowListener.handleClosing();
            }
        });

        setBounds(100, 100, 400, 167); 
        contentPane = new JPanel(); 
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5)); // specifies added component's position within the panel
        setContentPane(contentPane); //Adding components to the Content Pane
        contentPane.setLayout(null); //sets the layout manager as null

        txtEmail = new JTextField(); // creates empty email text field 
        txtEmail.setBounds(206, 35, 120, 20); //Defines the text field size and location
        contentPane.add(txtEmail); // Adds the dreated email text field to the contentpane
        txtEmail.setColumns(10); // creates JTextField with default number of columns

        //resets the users password
        //asks user to create new password
        JButton btnRestorePassword = new JButton("Restore password"); //Creates a new Jbutton with default name Restore Password
        btnRestorePassword.addActionListener(new ActionListener() { //Adds onClick listener to the button 
            public void actionPerformed(ActionEvent arg0) { // method which is invoked when the Restore Password button is clicked
                if (!txtEmail.getText().isEmpty()) { //Checks whether onClick action finds the email text field empty or not
                    Pattern p = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"); // Rejex which checks for a valid email address
                    Matcher m = p.matcher(txtEmail.getText()); //Tries to match the input email to check whether it is a valid email coapturing all required aspects

                    if (m.find()) { // when mathcer finds the email valid proceed below
                        // Reading from the file which stores clients SignUp details
                        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("src//SandwichShop//users.txt")))) {
                            String line; // creating a srting line which stores the line read from the file
                            boolean flag = false; // creates a boolean variable and instantiating it as false
                            while ((line = reader.readLine()) != null) { // this checks that the string read from the file is not null the continues
                                String[] words = line.split(" "); // Splits the line into specific words and stores them into a string array
                                String email = txtEmail.getText(); // Assigns the input email address into a string
                                if (email.equals(words[2])) { //Match the email string to the third word wwhich is the stored email in the file given during signup 
                                    JOptionPane.showMessageDialog(null, "New password sent to E-mail: " + txtEmail.getText());  // prints the email to sent password to
                                    flag = true; 
                                }
                            }
                            if (flag == false) { 
                                JOptionPane.showMessageDialog(null, "Email does not exist in the system.");
                            }
                        } catch (IOException ex) {
                            Logger.getLogger(ForgotPassword.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "Enter correct E-mail, please.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Enter E-mail address, please!");
                }
            }
        });
        btnRestorePassword.setBounds(10, 95, 361, 23); 
        contentPane.add(btnRestorePassword); 

        lblEnterYourEmail = new JLabel("Enter your E-mail address"); 
        lblEnterYourEmail.setBounds(48, 38, 148, 14); 
        contentPane.add(lblEnterYourEmail); 
    }
}
