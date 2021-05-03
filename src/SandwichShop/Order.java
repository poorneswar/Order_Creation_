package SandwichShop;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class Order extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    private JTextField textFieldsearch;
    private JButton btnSearch;
    private double sum;
    protected Object frame;

   protected JComboBox combobox;

    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Order frame = new Order(); // Launch the order method
                    frame.setVisible(true); // set it to visible
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
   public MyWindowListener windowListener = new MyWindowListener();

    //creates new window that shows options for the user to pick to order
    public Order() {
        setTitle("Order");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); //optional, what happens when the frame closes
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                windowListener.handleClosing();
            }
        });

        setBounds(100, 100, 688, 567);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        ArrayList<Double> total = new ArrayList<Double>();
        ArrayList<String> textLines = new ArrayList<String>();

        JButton btnExit = new JButton("Exit"); // create exit button
        JTextArea textArea = new JTextArea(1, 5); // create text area where the selected items will be displayed

        JLabel lblBread_1 = new JLabel(""); // create the label for the first item under bread category
        lblBread_1.setBounds(26, 47, 50, 50);// set size and location of the label
        contentPane.add(lblBread_1); // Add the label to the content pane

        JLabel lblBread_2 = new JLabel(""); // create the label for the second item under bread category
        lblBread_2.setBounds(151, 47, 50, 50); // set size and location of the label
        contentPane.add(lblBread_2); // Add the label to the content pane

        JLabel lblBread_3 = new JLabel(""); // create the label for the third item under bread category
        lblBread_3.setBounds(283, 47, 50, 50); // set size and location of the label
        contentPane.add(lblBread_3); // Add the label to the content pane

        JLabel labelBeef_1 = new JLabel(""); // create the label for the first item under Beef category
        labelBeef_1.setBounds(16, 155, 50, 50); // set size and location of the label
        contentPane.add(labelBeef_1); // Add the label to the content pane

        JLabel labelBeef_2 = new JLabel("");
        labelBeef_2.setBounds(151, 155, 50, 50);
        contentPane.add(labelBeef_2);

        JLabel labelBeef_3 = new JLabel("");
        labelBeef_3.setBounds(272, 155, 50, 50);
        contentPane.add(labelBeef_3);

        JLabel labelCucamber = new JLabel("");
        labelCucamber.setBounds(42, 261, 50, 50);
        contentPane.add(labelCucamber);

        JLabel labelTomato = new JLabel("");
        labelTomato.setBounds(151, 261, 50, 50);
        contentPane.add(labelTomato);

        JLabel labelOnion = new JLabel("");
        labelOnion.setBounds(272, 261, 61, 50);
        contentPane.add(labelOnion);

        JLabel labelMoyo = new JLabel("");
        labelMoyo.setBounds(26, 363, 50, 50);
        contentPane.add(labelMoyo);

        JLabel labelRanch = new JLabel("");
        labelRanch.setBounds(151, 363, 50, 50);
        contentPane.add(labelRanch);

        JLabel labelChili = new JLabel("");
        labelChili.setBounds(260, 363, 73, 50);
        contentPane.add(labelChili);

        JLabel labelOrange = new JLabel("");
        labelOrange.setBounds(42, 464, 50, 50);
        contentPane.add(labelOrange);

        JLabel labelMilk = new JLabel("");
        labelMilk.setBounds(151, 468, 50, 50);
        contentPane.add(labelMilk);

        JLabel labelCocaCola = new JLabel("");
        labelCocaCola.setBounds(283, 468, 50, 50);
        contentPane.add(labelCocaCola);

        //adds pictures underneath each option
        //adds a price value to each item
        //adds items and prices to ordered item list
        JCheckBox baguette = new JCheckBox("Baguette $0.59"); // Creates Checkbox with value Baguette
        baguette.addActionListener(new ActionListener() { // Adds onClick listener to the checkbox
            public void actionPerformed(ActionEvent e) { // method called onClick
                if (baguette.isSelected()) { // when the check box is selected
                    lblBread_1.setIcon(new ImageIcon("src\\img\\baguette.jpg")); // Display image icon below the selected checkbox
                    textArea.append(baguette.getText() + "\n"); // append the name and cost of the selected item to the textArea
                    total.add(0.59); // write the total cost to the total array
                    textLines.add(baguette.getText()); // Add item name and cost to the array

                    sum = 0; // initialize sum
                    for (int i = 0; i < total.size(); i++) { // find the total cost
                        sum += total.get(i);
                    }
                    textField.setText(String.format(Locale.ENGLISH, "%.2f", sum)); // Write the total cost on the textField
                } else if (!baguette.isSelected()) { // when the checkbox is unchecked
                    lblBread_1.setIcon(new ImageIcon("")); // display nothing in the image icon
                    total.remove(total.indexOf(0.59)); // remove the cost of the item from the array containing selected item costs
                    textArea.setText(textArea.getText().replaceAll("Baguette \\$0.59\\n", "")); // Replace the text area to be null

                    sum = Double.parseDouble(textField.getText()) - 0.59; // deduct the cost of the item from the total sum(cost)
                    textField.setText(String.format(Locale.ENGLISH, "%.2f", sum)); // Write the total cost on the textField
                }
            }
        });// The same idea applies to all the other items 

        JCheckBox roundBun = new JCheckBox("Round bun $0.69");
        roundBun.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (roundBun.isSelected()) {
                    lblBread_2.setIcon(new ImageIcon("src\\img\\big_bun.jpg"));
                    textArea.append(roundBun.getText() + "\n");
                    total.add(0.69);
                    textLines.add(roundBun.getText());

                    sum = 0;
                    for (int i = 0; i < total.size(); i++) {
                        sum += total.get(i);
                    }
                    textField.setText(String.format(Locale.ENGLISH, "%.2f", sum));

                } else if (!roundBun.isSelected()) {
                    lblBread_2.setIcon(new ImageIcon(""));
                    total.remove(total.indexOf(0.69));
                    textArea.setText(textArea.getText().replaceAll("Round bun \\$0.69\\n", ""));

                    sum = Double.parseDouble(textField.getText()) - 0.69;
                    textField.setText(String.format(Locale.ENGLISH, "%.2f", sum));
                }
            }
        });
        JCheckBox squareBun = new JCheckBox("Square bun $0.79");
        squareBun.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (squareBun.isSelected()) {
                    lblBread_3.setIcon(new ImageIcon("src\\img\\square_bun.jpg"));
                    textArea.append(squareBun.getText() + "\n");
                    total.add(0.79);
                    textLines.add(squareBun.getText());

                    sum = 0;
                    for (int i = 0; i < total.size(); i++) {
                        sum += total.get(i);
                    }
                    textField.setText(String.format(Locale.ENGLISH, "%.2f", sum));

                } else if (!squareBun.isSelected()) {
                    lblBread_3.setIcon(new ImageIcon(""));
                    total.remove(total.indexOf(0.79));
                    textArea.setText(textArea.getText().replaceAll("Square bun \\$0.79\\n", ""));

                    sum = Double.parseDouble(textField.getText()) - 0.79;
                    textField.setText(String.format(Locale.ENGLISH, "%.2f", sum));
                }
            }
        });

        JCheckBox chckbxPork = new JCheckBox("Pork $0.99");
        chckbxPork.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (chckbxPork.isSelected()) {
                    labelBeef_1.setIcon(new ImageIcon("src\\img\\pork.jpg"));
                    textArea.append(chckbxPork.getText() + "\n");
                    total.add(0.79);
                    textLines.add(chckbxPork.getText());

                    sum = 0;
                    for (int i = 0; i < total.size(); i++) {
                        sum += total.get(i);
                    }
                    textField.setText(String.format(Locale.ENGLISH, "%.2f", sum));

                } else if (!chckbxPork.isSelected()) {
                    labelBeef_1.setIcon(new ImageIcon(""));
                    total.remove(total.indexOf(0.79));
                    textArea.setText(textArea.getText().replaceAll("Pork \\$0.99\\n", ""));

                    sum = Double.parseDouble(textField.getText()) - 0.99;
                    textField.setText(String.format(Locale.ENGLISH, "%.2f", sum));
                }
            }
        });
        chckbxPork.setBounds(6, 123, 112, 25);
        contentPane.add(chckbxPork);

        JCheckBox chckbxChicken = new JCheckBox("Chicken $0.69");
        chckbxChicken.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (chckbxChicken.isSelected()) {
                    labelBeef_2.setIcon(new ImageIcon("src\\img\\chicken.jpg"));
                    textArea.append(chckbxChicken.getText() + "\n");
                    total.add(0.79);
                    textLines.add(chckbxChicken.getText());

                    sum = 0;
                    for (int i = 0; i < total.size(); i++) {
                        sum += total.get(i);
                    }
                    textField.setText(String.format(Locale.ENGLISH, "%.2f", sum));

                } else if (!chckbxChicken.isSelected()) {
                    labelBeef_2.setIcon(new ImageIcon(""));
                    total.remove(total.indexOf(0.79));
                    textArea.setText(textArea.getText().replaceAll("Chicken \\$0.69\\n", ""));

                    sum = Double.parseDouble(textField.getText()) - 0.69;
                    textField.setText(String.format(Locale.ENGLISH, "%.2f", sum));
                }
            }
        });
        chckbxChicken.setBounds(124, 123, 124, 25);
        contentPane.add(chckbxChicken);

        JCheckBox chckbxBeef = new JCheckBox("Beef $0.89");
        chckbxBeef.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (chckbxBeef.isSelected()) {
                    labelBeef_3.setIcon(new ImageIcon("src\\img\\beef.jpg"));
                    textArea.append(chckbxBeef.getText() + "\n");
                    total.add(0.89);
                    textLines.add(chckbxBeef.getText());

                    sum = 0;
                    for (int i = 0; i < total.size(); i++) {
                        sum += total.get(i);
                    }
                    textField.setText(String.format(Locale.ENGLISH, "%.2f", sum));

                } else if (!chckbxBeef.isSelected()) {
                    labelBeef_3.setIcon(new ImageIcon(""));
                    total.remove(total.indexOf(0.89));
                    textArea.setText(textArea.getText().replaceAll("Beef \\$0.89\\n", ""));

                    sum = Double.parseDouble(textField.getText()) - 0.89;
                    textField.setText(String.format(Locale.ENGLISH, "%.2f", sum));
                }
            }
        });
        chckbxBeef.setBounds(250, 123, 124, 25);
        contentPane.add(chckbxBeef);

        baguette.setBounds(6, 26, 112, 25);
        contentPane.add(baguette);

        roundBun.setBounds(120, 26, 124, 25);
        contentPane.add(roundBun);

        squareBun.setBounds(250, 26, 124, 25);
        contentPane.add(squareBun);

        JCheckBox chckbxCucamber = new JCheckBox("Cucamber $0.35");
        chckbxCucamber.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (chckbxCucamber.isSelected()) {
                    labelCucamber.setIcon(new ImageIcon("src\\img\\cucamber.jpg"));
                    textArea.append(chckbxCucamber.getText() + "\n");
                    total.add(0.35);
                    textLines.add(chckbxCucamber.getText());

                    sum = 0;
                    for (int i = 0; i < total.size(); i++) {
                        sum += total.get(i);
                    }
                    textField.setText(String.format(Locale.ENGLISH, "%.2f", sum));

                } else if (!chckbxCucamber.isSelected()) {
                    labelCucamber.setIcon(new ImageIcon(""));
                    total.remove(total.indexOf(0.35));
                    textArea.setText(textArea.getText().replaceAll("Cucamber \\$0.35\\n", ""));

                    sum = Double.parseDouble(textField.getText()) - 0.35;
                    textField.setText(String.format(Locale.ENGLISH, "%.2f", sum));
                }
            }
        });
        chckbxCucamber.setBounds(6, 231, 125, 23);
        contentPane.add(chckbxCucamber);

        JCheckBox chckbxTomato = new JCheckBox("Tomato $0.45");
        chckbxTomato.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (chckbxTomato.isSelected()) {
                    labelTomato.setIcon(new ImageIcon("src\\img\\tomato.jpg"));
                    textArea.append(chckbxTomato.getText() + "\n");
                    total.add(0.45);
                    textLines.add(chckbxTomato.getText());

                    sum = 0;
                    for (int i = 0; i < total.size(); i++) {
                        sum += total.get(i);
                    }
                    textField.setText(String.format(Locale.ENGLISH, "%.2f", sum));

                } else if (!chckbxTomato.isSelected()) {
                    labelTomato.setIcon(new ImageIcon(""));
                    total.remove(total.indexOf(0.45));
                    textArea.setText(textArea.getText().replaceAll("Tomato \\$0.45\\n", ""));

                    sum = Double.parseDouble(textField.getText()) - 0.45;
                    textField.setText(String.format(Locale.ENGLISH, "%.2f", sum));
                }
            }
        });
        chckbxTomato.setBounds(133, 231, 115, 23);
        contentPane.add(chckbxTomato);

        JCheckBox chckbxOnion = new JCheckBox("Onion $0.25");
        chckbxOnion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (chckbxOnion.isSelected()) {
                    labelOnion.setIcon(new ImageIcon("src\\img\\onion.jpg"));
                    textArea.append(chckbxOnion.getText() + "\n");
                    total.add(0.25);
                    textLines.add(chckbxOnion.getText());

                    sum = 0;
                    for (int i = 0; i < total.size(); i++) {
                        sum += total.get(i);
                    }
                    textField.setText(String.format(Locale.ENGLISH, "%.2f", sum));

                } else if (!chckbxOnion.isSelected()) {
                    labelOnion.setIcon(new ImageIcon(""));
                    total.remove(total.indexOf(0.25));
                    textArea.setText(textArea.getText().replaceAll("Onion \\$0.25\\n", ""));

                    sum = Double.parseDouble(textField.getText()) - 0.25;
                    textField.setText(String.format(Locale.ENGLISH, "%.2f", sum));
                }
            }
        });
        chckbxOnion.setBounds(250, 231, 106, 23);
        contentPane.add(chckbxOnion);

        JCheckBox chckbxMayo = new JCheckBox("Mayo $0.80");
        chckbxMayo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (chckbxMayo.isSelected()) {
                    labelMoyo.setIcon(new ImageIcon("src\\img\\mayo.jpg"));
                    textArea.append(chckbxMayo.getText() + "\n");
                    total.add(0.80);
                    textLines.add(chckbxMayo.getText());

                    sum = 0;
                    for (int i = 0; i < total.size(); i++) {
                        sum += total.get(i);
                    }
                    textField.setText(String.format(Locale.ENGLISH, "%.2f", sum));

                } else if (!chckbxMayo.isSelected()) {
                    labelMoyo.setIcon(new ImageIcon(""));
                    total.remove(total.indexOf(0.80));
                    textArea.setText(textArea.getText().replaceAll("Mayo \\$0.80\\n", ""));

                    sum = Double.parseDouble(textField.getText()) - 0.80;
                    textField.setText(String.format(Locale.ENGLISH, "%.2f", sum));
                }
            }
        });
        chckbxMayo.setBounds(6, 333, 97, 23);
        contentPane.add(chckbxMayo);

        JCheckBox chckbxRanch = new JCheckBox("Ranch $0.65");
        chckbxRanch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (chckbxRanch.isSelected()) {
                    labelRanch.setIcon(new ImageIcon("src\\img\\ranch.jpg"));
                    textArea.append(chckbxRanch.getText() + "\n");
                    total.add(0.65);
                    textLines.add(chckbxRanch.getText());

                    sum = 0;
                    for (int i = 0; i < total.size(); i++) {
                        sum += total.get(i);
                    }
                    textField.setText(String.format(Locale.ENGLISH, "%.2f", sum));

                } else if (!chckbxRanch.isSelected()) {
                    labelRanch.setIcon(new ImageIcon(""));
                    total.remove(total.indexOf(0.65));
                    textArea.setText(textArea.getText().replaceAll("Ranch \\$0.65\\n", ""));

                    sum = Double.parseDouble(textField.getText()) - 0.65;
                    textField.setText(String.format(Locale.ENGLISH, "%.2f", sum));
                }
            }
        });
        chckbxRanch.setBounds(133, 333, 97, 23);
        contentPane.add(chckbxRanch);

        JCheckBox chckbxChili = new JCheckBox("Chili $0.75");
        chckbxChili.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (chckbxChili.isSelected()) {
                    labelChili.setIcon(new ImageIcon("src\\img\\chili.jpg"));
                    textArea.append(chckbxChili.getText() + "\n");
                    total.add(0.75);
                    textLines.add(chckbxChili.getText());

                    sum = 0;
                    for (int i = 0; i < total.size(); i++) {
                        sum += total.get(i);
                    }
                    textField.setText(String.format(Locale.ENGLISH, "%.2f", sum));

                } else if (!chckbxChili.isSelected()) {
                    labelChili.setIcon(new ImageIcon(""));
                    total.remove(total.indexOf(0.75));
                    textArea.setText(textArea.getText().replaceAll("Chili \\$0.75\\n", ""));

                    sum = Double.parseDouble(textField.getText()) - 0.75;
                    textField.setText(String.format(Locale.ENGLISH, "%.2f", sum));
                }
            }
        });
        chckbxChili.setBounds(250, 333, 97, 23);
        contentPane.add(chckbxChili);

        JCheckBox chckbxOrange = new JCheckBox("Orange $1.15");
        chckbxOrange.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (chckbxOrange.isSelected()) {
                    labelOrange.setIcon(new ImageIcon("src\\img\\juice.jpg"));
                    textArea.append(chckbxOrange.getText() + "\n");
                    total.add(1.15);
                    textLines.add(chckbxOrange.getText());

                    sum = 0;
                    for (int i = 0; i < total.size(); i++) {
                        sum += total.get(i);
                    }
                    textField.setText(String.format(Locale.ENGLISH, "%.2f", sum));

                } else if (!chckbxOrange.isSelected()) {
                    labelOrange.setIcon(new ImageIcon(""));
                    total.remove(total.indexOf(1.15));
                    textArea.setText(textArea.getText().replaceAll("Orange \\$1.15\\n", ""));

                    sum = Double.parseDouble(textField.getText()) - 1.15;
                    textField.setText(String.format(Locale.ENGLISH, "%.2f", sum));
                }
            }
        });
        chckbxOrange.setBounds(16, 438, 115, 23);
        contentPane.add(chckbxOrange);

        JCheckBox chckbxMilk = new JCheckBox("Milk $1.35");
        chckbxMilk.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (chckbxMilk.isSelected()) {
                    labelMilk.setIcon(new ImageIcon("src\\img\\milk.jpg"));
                    textArea.append(chckbxMilk.getText() + "\n");
                    total.add(1.35);
                    textLines.add(chckbxMilk.getText());

                    sum = 0;
                    for (int i = 0; i < total.size(); i++) {
                        sum += total.get(i);
                    }
                    textField.setText(String.format(Locale.ENGLISH, "%.2f", sum));

                } else if (!chckbxMilk.isSelected()) {
                    labelMilk.setIcon(new ImageIcon(""));
                    total.remove(total.indexOf(1.35));
                    textArea.setText(textArea.getText().replaceAll("Milk \\$1.35\\n", ""));

                    sum = Double.parseDouble(textField.getText()) - 1.35;
                    textField.setText(String.format(Locale.ENGLISH, "%.2f", sum));
                }
            }
        });
        chckbxMilk.setBounds(133, 438, 97, 23);
        contentPane.add(chckbxMilk);

        JCheckBox chckbxCocaCola = new JCheckBox("Coca Cola $0.99");
        chckbxCocaCola.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (chckbxCocaCola.isSelected()) {
                    labelCocaCola.setIcon(new ImageIcon("src\\img\\coca_cola.jpg"));
                    textArea.append(chckbxCocaCola.getText() + "\n");
                    total.add(0.99);
                    textLines.add(chckbxCocaCola.getText());

                    sum = 0;
                    for (int i = 0; i < total.size(); i++) {
                        sum += total.get(i);
                    }
                    textField.setText(String.format(Locale.ENGLISH, "%.2f", sum));

                } else if (!chckbxCocaCola.isSelected()) {
                    labelCocaCola.setIcon(new ImageIcon(""));
                    total.remove(total.indexOf(0.99));
                    textArea.setText(textArea.getText().replaceAll("Coca Cola \\$0.99\\n", ""));

                    sum = Double.parseDouble(textField.getText()) - 0.99;
                    textField.setText(String.format(Locale.ENGLISH, "%.2f", sum));
                }
            }
        });
        chckbxCocaCola.setBounds(250, 438, 124, 23);
        contentPane.add(chckbxCocaCola);
        
        textFieldsearch = new JTextField();
        textFieldsearch.setEditable(true);
        textFieldsearch.setBounds(535, 5, 50, 20);
        contentPane.add(textFieldsearch);
        textFieldsearch.setColumns(10);
        
        // Shows notification on closing the system
//        btnSearch.addActionListener(new ActionListener() { // Add listener to the exit button
//            JFrame frame = new JFrame();  // create a JFrame to display the notification
//
//            public void actionPerformed(ActionEvent arg0) { // method called when the button is clicked
//    
//                if (JOptionPane.showConfirmDialog(frame,
//                        "Are you sure to close this window?", "Really Closing?",
//                        JOptionPane.YES_NO_OPTION,
//                        JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) { // prompts the user to choose whether to continue exiting or remain in the order window
//                    System.exit(0); // when user selects Yes then application is terminated else remains on the Oeder window
//
//                }
//            }
//        });
//        
//        btnSearch.setBounds(570, 5, 91, 23);
//        contentPane.add(btnSearch);

        textArea.setBounds(435, 62, 231, 401);
        contentPane.add(textArea);

        // Shows notification on closing the system
        btnExit.addActionListener(new ActionListener() { // Add listener to the exit button
            JFrame frame = new JFrame();  // create a JFrame to display the notification

            public void actionPerformed(ActionEvent arg0) { // method called when the button is clicked

                if (JOptionPane.showConfirmDialog(frame,
                        "Are you sure to close this window?", "Really Closing?",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) { // prompts the user to choose whether to continue exiting or remain in the order window
                    System.exit(0); // when user selects Yes then application is terminated else remains on the Oeder window

                }
            }
        });
        btnExit.setBounds(575, 495, 91, 23);
        contentPane.add(btnExit);

        textField = new JTextField();
        textField.setEditable(false);
        textField.setBounds(537, 464, 45, 20);
        contentPane.add(textField);
        textField.setColumns(10);

        //adds total price of all items selected to a text field
        JLabel lblTotalPrice = new JLabel("Total cost:");
        lblTotalPrice.setBounds(445, 467, 62, 14);
        contentPane.add(lblTotalPrice);

        JButton btnConfirmActivities = new JButton("Confirm"); // Creates button with default value Confirm
        btnConfirmActivities.addActionListener(new ActionListener() { // Adds onClick listener to the button
            public void actionPerformed(ActionEvent e) { // method to be called on click
                EventQueue.invokeLater(new Runnable() { // include a thread to the method 
                    public void run() { // method to run the thread
                        try {
//                            Checkout checkout = new Checkout(); // launch Checkout class by instantiating it
//                            checkout.frmPersonalInfo.setVisible(true); // make the Checkout class visible
//                            checkout.textField.setText("$ " + textField.getText()); //set incformation to be displayed on the textField of the Checkout window
//                            checkout.orderDetails = textLines;
                            DeliveryService deliveryService = new DeliveryService(); // launch Checkout class by instantiating it
                            deliveryService.setVisible(true); // make the DeliveryService class visible
                            deliveryService.textField_value = textField.getText();
                            deliveryService.textField.setText("$ " + textField.getText()); //set incformation to be displayed on the textField of the Checkout window
                            deliveryService.orderDetails = textLines;

                        } catch (Exception e3) {

                            e3.printStackTrace();
                        }
                    }
                });

            }
        });
        btnConfirmActivities.setBounds(435, 495, 100, 23);
        contentPane.add(btnConfirmActivities);

        JLabel lblOrderedItem = new JLabel("Ordered Item");
        lblOrderedItem.setBounds(518, 35, 88, 14);
        contentPane.add(lblOrderedItem);

        JLabel label = new JLabel("$");
        label.setBounds(517, 467, 15, 14);
        contentPane.add(label);

        JLabel lblBread = new JLabel("Bread");
        lblBread.setBounds(155, 5, 46, 14);
        contentPane.add(lblBread);

        JLabel lblMeat = new JLabel("Meat");
        lblMeat.setBounds(161, 98, 46, 14);
        contentPane.add(lblMeat);

        JLabel lblVeggies = new JLabel("Veggies");
        lblVeggies.setBounds(161, 203, 46, 14);
        contentPane.add(lblVeggies);

        JLabel lblSauce = new JLabel("Sauce");
        lblSauce.setBounds(161, 315, 46, 14);
        contentPane.add(lblSauce);

        JLabel lblSidesdrinksdesserts = new JLabel("Drinks/Desserts");
        lblSidesdrinksdesserts.setBounds(140, 417, 100, 14);
        contentPane.add(lblSidesdrinksdesserts);
    }
}
