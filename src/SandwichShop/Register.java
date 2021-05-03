package SandwichShop;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Register extends JFrame {

    private JTextField txtLogin;
    private JTextField txtEmail;
    private JPanel contentPane;
    private JPasswordField passwordField;
    private JPasswordField confirmPasswordField;

    //creates the register frame
    MyWindowListener windowListener = new MyWindowListener();

    //creates new window that shows options for the user to pick to order
    public Register() {
        setTitle("Register"); //sets its title name which appears on top the frame
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); //optional, what happens when the frame closes
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                windowListener.handleClosing();
            }
        });

        setBounds(150, 150, 400, 200); //Explicitly defining the frame size and also frame location
        contentPane = new JPanel(); // Creating a new jpanel
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5)); // specifies added component's position within the panel
        setContentPane(contentPane); //Adding components to the Content Pane
        contentPane.setLayout(null); //sets the layout manager as null

        JLabel lblUsername = new JLabel("Username"); // Creates a label with default value Username
        lblUsername.setBounds(91, 14, 66, 14); // sets the label size and location
        contentPane.add(lblUsername); // Adds the label to the content pane

        JLabel lblEmail = new JLabel("Email"); // Creates a label with default value Email
        lblEmail.setBounds(91, 39, 66, 14); // sets the label size and location
        contentPane.add(lblEmail); // Adds the label to the content pane

        JLabel lblPassword = new JLabel("Password"); // Creates a label with default value Password
        lblPassword.setBounds(91, 64, 66, 14); // sets the label size and location
        contentPane.add(lblPassword); // Adds the label to the content pane

        txtLogin = new JTextField(); // creates empty Login text field
        txtLogin.setBounds(179, 11, 120, 20); //Defines the text field size and location
        contentPane.add(txtLogin); // Adds the dreated email text field to the contentpane
        txtLogin.setColumns(10); // creates JTextField with default number of columns

        txtEmail = new JTextField();// creates empty email text field  
        txtEmail.setBounds(179, 36, 120, 20); //Defines the text field size and location
        contentPane.add(txtEmail); // Adds the dreated email text field to the contentpane
        txtLogin.setColumns(10); // creates JTextField with default number of columns

        passwordField = new JPasswordField(); // create empty password field
        passwordField.setToolTipText(""); // shows nothing when you hover curser over the password field
        passwordField.setBounds(179, 61, 120, 20); // Defines the password field size and location
        contentPane.add(passwordField); // Adds the password field to the Content Pane

        JLabel lblConfirmPassword = new JLabel("Confirm Password"); // Creates a label with default value Confirm Password
        lblConfirmPassword.setBounds(65, 95, 108, 14); // sets the label size and location
        contentPane.add(lblConfirmPassword); // Adds the label to the content pane

        // add new user and password to txt file  
        JButton btnSignUp = new JButton("Sign Up"); // Creates Sign Up button and gives it default name Sign Up
        btnSignUp.addActionListener(new ActionListener() {//Adds onClick listener to the button
            public void actionPerformed(ActionEvent arg0) { // method called when the button is clicked

                FileWriter fw; // create variable for the FileWriter which writes to the file
                //catch for empty unfilled textfields
                if (!txtLogin.getText().isEmpty() || !passwordField.getText().isEmpty() || !confirmPasswordField.getText().isEmpty() || !txtEmail.getText().isEmpty()) {
                    if (passwordField.getText().equals(confirmPasswordField.getText())) {
                        Pattern p = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"); // Rejex which checks for a valid email address
                        Matcher m = p.matcher(txtEmail.getText()); //Tries to match the input email to check whether it is a valid email coapturing all required aspects

                        if (m.find()) { // when mathcer finds the email valid proceed below
                            try {
                                fw = new FileWriter("src//SandwichShop//users.txt", true); // Assign the FileWriter fw to a file
                                fw.write(txtLogin.getText() + " " + passwordField.getText() + " " + txtEmail.getText() + " \r\n"); // Write user details to the file
                                fw.close(); //close the FileWriter
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }
                            JOptionPane.showMessageDialog(null, "Registration completed successfully!");
                        } else {
                            JOptionPane.showMessageDialog(null, "Enter correct E-mail, please.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "\"Password\" field and \"Confirm Password\" field not match");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "One or more fields are empty!");
                }
            }
        });
        btnSignUp.setBounds(16, 125, 350, 23); // set size and location of the Sign Up button
        contentPane.add(btnSignUp); // Add the button to the content pane

        confirmPasswordField = new JPasswordField(); // create confirmPassword field
        confirmPasswordField.setToolTipText(""); // shows nothing when you hover curser over the password field
        confirmPasswordField.setBounds(179, 92, 120, 20); // set size and location of the password field
        contentPane.add(confirmPasswordField); // add the confirm password field to the content pane
    }
}
