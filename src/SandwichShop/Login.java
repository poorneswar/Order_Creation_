package SandwichShop;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Login extends JFrame {

    private JTextField txtLogin;
    private JPanel contentPane;
    private JPasswordField passwordField;
    public static String userName;

    //creates the login frame
    MyWindowListener windowListener = new MyWindowListener();

    //creates new window that shows options for the user to pick to order
    public Login() {
        setTitle("Login"); //sets its title name which appears on top the frame
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); //optional, what happens when the frame closes
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                windowListener.handleClosing();
            }
        });

        setBounds(100, 100, 420, 140); //Explicitly defining the frame size and also frame location
        contentPane = new JPanel(); // Creating a new jpanel
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5)); // specifies added component's position within the panel
        setContentPane(contentPane); //Adding components to the Content Pane
        contentPane.setLayout(null); //sets the layout manager as null

        JLabel lblUsername = new JLabel("Username"); // Cteate a label with default value Username
        lblUsername.setBounds(10, 15, 62, 14); //Set its size and location
        contentPane.add(lblUsername); // Add the label to the Content Pane

        JLabel lblPassword = new JLabel("Password"); // Create a label with default value Username
        lblPassword.setBounds(161, 15, 68, 14); //Set its size and location
        contentPane.add(lblPassword); // Add the label to the Content Pane

        txtLogin = new JTextField(); // creates empty Login text field
        txtLogin.setBounds(71, 12, 80, 20); //Defines the text field size and location
        contentPane.add(txtLogin); // Adds the dreated email text field to the contentpane
        txtLogin.setColumns(10); // creates JTextField with default number of columns

        passwordField = new JPasswordField(); // create empty password field
        passwordField.setToolTipText(""); // shows nothing when you hover curser over the password field
        passwordField.setBounds(221, 12, 80, 20); // Defines the password field size and location
        contentPane.add(passwordField); // Adds the password field to the Content Pane

        //accesses users.txt to match user and password
        JButton btnNewButton = new JButton("Login"); // Creates Login button and gives it default name Login
        btnNewButton.addActionListener(new ActionListener() { // Adds onClick listener to the button
            public void actionPerformed(ActionEvent arg0) { // method called when the button is clicked
                //catch for empty unfilled textfields
                if (!txtLogin.getText().isEmpty() || !passwordField.getText().isEmpty()) {
                    userName = txtLogin.getText();
                    String userPassword = passwordField.getText();
                    // Reading from the file which stores clients SignUp details
                    try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("src//SandwichShop//users.txt")))) {
                        String line; // creating a srting line which stores the line read from the file
                        boolean flag = false; // creates a boolean variable and instantiating it as false
                        while ((line = reader.readLine()) != null) { // this checks that the string read from the file is not null the continues
                            String[] words = line.split(" "); // Splits the line into specific words and stores them into a string array

                            if (userName.equals(words[0]) && userPassword.equals(words[1])) { // Match username and password to the username and password stored in the file
                                //if((userName + " " + userPassword).equals(line)) {
                                JOptionPane.showMessageDialog(null, "Welcome, " + userName + "!"); // when true prints the username of the user
                                flag = true; // assign true to boolean variable flag
                                try {
                                    Order order = new Order(); // Create an instance of the Order class and set it to visible
                                    order.setVisible(true);
                                    Login lg = new Login();
                                    lg.setVisible(false);

                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                }
                            }
                        }
                        if (flag == false) { // when flag is false the user is prompted to enter correct login details
                            JOptionPane.showMessageDialog(null, "Enter correct E-mail and Password!");
                        }
                        reader.close(); // Close the file
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Enter User name and Password, please!");
                }
            }
        });
        btnNewButton.setBounds(313, 11, 68, 23); // Sets the size and location for the login button
        contentPane.add(btnNewButton); // adds the button to the content proviiider

        JButton btnFogot = new JButton("Fogot password?"); //Create a button assigns it the value Fogot password?
        btnFogot.addActionListener(new ActionListener() { // Adds onClick listener to the button
            public void actionPerformed(ActionEvent e) { // method called after onClick
                try {
                    ForgotPassword fogotPassword = new ForgotPassword(); // create an instance of the Fogot password class
                    fogotPassword.setVisible(true);  // makes the class visible
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        btnFogot.setBounds(42, 59, 133, 23); // sets button size and location
        contentPane.add(btnFogot); // Adds the button to the content pane

        JButton btnSignUp = new JButton("Sign Up"); //Create a button assigns it the value Sign Up
        btnSignUp.addActionListener(new ActionListener() { // Adds onClick listener to the button
            public void actionPerformed(ActionEvent arg0) { // method called after onClick
                try {
                    Register register = new Register();// create an instance of the Register class
                    register.setVisible(true); // make the class visible
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        btnSignUp.setBounds(217, 59, 133, 23); // sets button size and location
        contentPane.add(btnSignUp); // Adds the button to the content pane
    }
}
