package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    JButton loginB, signUp, clear;
    JTextField cardNoText;
    JPasswordField pinNoText;
    static String ecardNo, epinNo;

    Login() {

//  Code for the frame modifications      
        setLayout(null); // to use custom layout and not any defined layout. By default it uses border layout so to remove that we have used this function.  
        setTitle(" Welfare Bank - ATM Login"); //sets the title of the frame
        setSize(650, 500); // sets the dimensions of the frame
        setLocation(400, 180); // sets the location where the frame will be opened on our screen. By default it opens on the top left corner
        Color c = new Color(160, 203, 244);
        getContentPane().setBackground(c); // to set the background colour of the frame

//  Code for adding logo 
        ImageIcon ic1 = new ImageIcon(ClassLoader.getSystemResource("icons/welfareBankLogo2.png"));
        // As we are getting image from system we will use getSystemResource function from the ClassLoader class. 
        // getImage - to get the image
        // getScaledInstance - to set the width and height
        Image i1 = ic1.getImage().getScaledInstance(200, 90, Image.SCALE_DEFAULT);
        // JLabel l1=new JLabel(i1); // we cannot place an Image class object inside JFrame to solve this we will create an object of ImageIcon class.
        ImageIcon ic2 = new ImageIcon(i1);
        JLabel l1 = new JLabel(ic2);
        l1.setBounds(60, 10, 200, 90); // x - starting distance, y - top distance, width, height - width and height of image

        // adding heading
        JLabel heading = new JLabel("Welcome To ATM");
        heading.setFont(new Font("Futura Md BT", Font.BOLD, 32));
        heading.setBounds(280, 42, 410, 30); // As we are using our own custom frame. we need to specify location of each object to be displayed on the frame.

        JLabel cardNo = new JLabel("Card Number:");
        cardNo.setFont(new Font("Albertus Extra Bold", Font.BOLD, 20));
        cardNo.setBounds(110, 140, 200, 30);

        cardNoText = new JTextField();
        cardNoText.setBounds(280, 140, 250, 32);
        cardNoText.setFont(new Font("Albertus Extra Bold", Font.BOLD, 20));

        JLabel pinNo = new JLabel("Pin Number:");
        pinNo.setFont(new Font("Albertus Extra Bold", Font.BOLD, 20));
        pinNo.setBounds(110, 200, 200, 30);

        pinNoText = new JPasswordField();
        pinNoText.setBounds(280, 200, 250, 32);
        pinNoText.setFont(new Font("Albertus Extra Bold", Font.BOLD, 20));

        Color c1 = new Color(18, 66, 112);

        signUp = new JButton("SIGN UP");
        signUp.setBounds(280, 310, 120, 35);
        signUp.setBackground(c1);
        signUp.setForeground(Color.WHITE);
        signUp.setFont(new Font("Arial", Font.BOLD, 15));
        signUp.addActionListener(this); // on clicking the button actionPerformed function will be invoked

        clear = new JButton("CLEAR");
        clear.setBounds(410, 310, 120, 35);
        clear.setBackground(c1);
        clear.setForeground(Color.WHITE);
        clear.setFont(new Font("Arial", Font.BOLD, 15));
        clear.addActionListener(this);

        loginB = new JButton("LOGIN");
        loginB.setBounds(280, 260, 250, 35);
        loginB.setBackground(c1);
        loginB.setForeground(Color.WHITE);
        loginB.setFont(new Font("Arial", Font.BOLD, 15));
        loginB.addActionListener(this);

        // To place the object on the frame
        add(l1);
        add(heading);
        add(cardNo);
        add(cardNoText);
        add(pinNo);
        add(pinNoText);
        add(loginB);
        add(signUp);
        add(clear);

        setVisible(true); // By default frame is invisible. To make it visible we use this function.
    }

    @Override
    public void actionPerformed(ActionEvent ae) // ActionEvent helps us to know on which component has been action has been performed
    {
        if (ae.getSource() == clear) // to get source of ae object
        {
            cardNoText.setText("");
            pinNoText.setText("");
        } else if (ae.getSource() == signUp) {
            setVisible(false);
            new SignUp1().setVisible(true);
        } else if (ae.getSource() == loginB) {
//     String epinNo=pinNoText.getText(); //for passwords this method is deprecated that is why it is cancelling it
            epinNo = pinNoText.getText();
            ecardNo = cardNoText.getText();
            Conn conn = new Conn();
            try {
                boolean check = false;
                ResultSet rs = conn.s.executeQuery("select * from signUp3 where pinNo ='" + epinNo + "'");
                while (rs.next()) {
                    if (rs.getString("pinNo").equals(epinNo) && rs.getString("cardNo").equals(ecardNo)) {
                        check = true;
                        setVisible(false);
                        new Transactions();
                    }
                }
                if (!check) {
                    JOptionPane.showMessageDialog(null, "Please enter correct pin number or card number");
                }

            } catch (Exception e) {
                System.out.println(e);
            }
        }

    }

    static public String getCardNo() {
        return ecardNo;
    }

    static public String getPinNo() {
        return epinNo;
    }

    public static void main(String args[]) {

        // Creates an Anonymous object of the class. Thus as soon as we run our code we will be able to
        // see the frame. It will call the Login constructor.
        new Login();
    }
}
