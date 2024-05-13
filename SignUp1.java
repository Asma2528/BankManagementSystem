package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;


public class SignUp1 extends JFrame implements ActionListener {

    static String applicationFormNo;
    long formNo;
    JButton next,loginGB;
    JTextField nameText, fnameText, mnameText, addressText, emailText, cityText, stateText, pincodeText;
    ButtonGroup genderGroup, mstatusGroup;
    JRadioButton maleRButton, femaleRButton, singleRButton, marriedRButton, otherRButton;
    JDateChooser dobChooser;
    JLabel applicationFormNoL;

    SignUp1() {
        setLayout(null);
        setTitle("Welfare Bank - Sign Up - Personal Details");
        setLocation(400, 30);
        setSize(760, 780);
        Color c = new Color(160, 203, 244);
        getContentPane().setBackground(c);

        //  Code for adding logo 
        ImageIcon ic1 = new ImageIcon(ClassLoader.getSystemResource("icons/welfareBankLogo2.png"));
        Image i1 = ic1.getImage().getScaledInstance(200, 90, Image.SCALE_DEFAULT);
        ImageIcon ic2 = new ImageIcon(i1);
        JLabel l1 = new JLabel(ic2);
        l1.setBounds(100, 10, 200, 90);

        Color c1 = new Color(18, 66, 112);

        Random r = new Random();
        formNo = Math.abs((r.nextInt()) / 9000);

        JLabel pd = new JLabel("Personal Details");
        pd.setBounds(350, 48, 600, 32);
        pd.setFont(new Font("Futura Md BT", Font.BOLD, 35)); //creating Anonymous object of font class.

        applicationFormNoL = new JLabel("Application Form No: " + formNo);
        applicationFormNoL.setFont(new Font("Albertus Extra Bold", Font.BOLD, 27));
        applicationFormNoL.setBounds(230, 120, 600, 30);

        JLabel name = new JLabel("Name: ");
        name.setFont(new Font("Arial", Font.BOLD, 22));
        name.setBounds(60, 175, 300, 25);

        nameText = new JTextField();
        nameText.setFont(new Font("Arial", Font.BOLD, 20));
        nameText.setBounds(280, 175, 400, 32);

        JLabel fname = new JLabel("Father's Name: ");
        fname.setFont(new Font("Arial", Font.BOLD, 22));
        fname.setBounds(60, 220, 200, 25);

        fnameText = new JTextField();
        fnameText.setFont(new Font("Arial", Font.BOLD, 20));
        fnameText.setBounds(280, 220, 400, 32);

        JLabel mname = new JLabel("Mother's Name: ");
        mname.setFont(new Font("Arial", Font.BOLD, 22));
        mname.setBounds(60, 265, 200, 25);

        mnameText = new JTextField();
        mnameText.setFont(new Font("Arial", Font.BOLD, 20));
        mnameText.setBounds(280, 265, 400, 32);

        JLabel dob = new JLabel("Date Of Birth: ");
        dob.setFont(new Font("Arial", Font.BOLD, 22));
        dob.setBounds(60, 310, 200, 25);

        dobChooser = new JDateChooser();
        dobChooser.setFont(new Font("Arial", Font.BOLD, 15));
        dobChooser.setForeground(Color.BLACK);
        dobChooser.setBounds(280, 310, 400, 30);

        JLabel gender = new JLabel("Gender: ");
        gender.setFont(new Font("Arial", Font.BOLD, 22));
        gender.setBounds(60, 355, 200, 25);

        maleRButton = new JRadioButton("Male");
        maleRButton.setBackground(c);
        maleRButton.setBounds(280, 355, 150, 30);

        femaleRButton = new JRadioButton("Female");
        femaleRButton.setBackground(c);
        femaleRButton.setBounds(430, 355, 150, 30);

        genderGroup = new ButtonGroup();
        genderGroup.add(maleRButton);
        genderGroup.add(femaleRButton);

        JLabel email = new JLabel("Email: ");
        email.setFont(new Font("Arial", Font.BOLD, 22));
        email.setBounds(60, 400, 200, 25);

        emailText = new JTextField();
        emailText.setFont(new Font("Arial", Font.BOLD, 20));
        emailText.setBounds(280, 400, 400, 32);

        JLabel mstatus = new JLabel("Marital Status: ");
        mstatus.setFont(new Font("Arial", Font.BOLD, 22));
        mstatus.setBounds(60, 445, 200, 25);

        singleRButton = new JRadioButton("Single");
        singleRButton.setBackground(c);
        singleRButton.setBounds(280, 445, 150, 30);

        marriedRButton = new JRadioButton("Married");
        marriedRButton.setBackground(c);
        marriedRButton.setBounds(430, 445, 150, 30);

        otherRButton = new JRadioButton("Other");
        otherRButton.setBackground(c);
        otherRButton.setBounds(580, 445, 150, 30);

        mstatusGroup = new ButtonGroup();
        mstatusGroup.add(singleRButton);
        mstatusGroup.add(marriedRButton);
        mstatusGroup.add(otherRButton);

        JLabel address = new JLabel("Address: ");
        address.setFont(new Font("Arial", Font.BOLD, 22));
        address.setBounds(60, 490, 200, 25);

        addressText = new JTextField();
        addressText.setFont(new Font("Arial", Font.BOLD, 20));
        addressText.setBounds(280, 490, 400, 32);

        JLabel city = new JLabel("City: ");
        city.setFont(new Font("Arial", Font.BOLD, 22));
        city.setBounds(60, 535, 200, 25);

        cityText = new JTextField();
        cityText.setFont(new Font("Arial", Font.BOLD, 20));
        cityText.setBounds(280, 535, 400, 32);

        JLabel state = new JLabel("State: ");
        state.setFont(new Font("Arial", Font.BOLD, 22));
        state.setBounds(60, 580, 200, 25);

        stateText = new JTextField();
        stateText.setFont(new Font("Arial", Font.BOLD, 20));
        stateText.setBounds(280, 580, 400, 32);

        JLabel pincode = new JLabel("Pincode: ");
        pincode.setFont(new Font("Arial", Font.BOLD, 22));
        pincode.setBounds(60, 625, 200, 25);

        pincodeText = new JTextField();
        pincodeText.setFont(new Font("Arial", Font.BOLD, 20));
        pincodeText.setBounds(280, 625, 400, 32);

        loginGB=new JButton("LOGIN");
        loginGB.setBounds(450,680,110,35);
        loginGB.setBackground(c1);
        loginGB.setForeground(Color.WHITE);
        loginGB.setFont(new Font("Arial",Font.BOLD,15));
        loginGB.addActionListener(this);
        
        next = new JButton("NEXT");
        next.setBounds(580, 680, 100, 35);
        next.setBackground(c1);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Arial", Font.BOLD, 15));
        next.addActionListener(this);

        add(l1);
        add(pd);
        add(applicationFormNoL);
        add(name);
        add(nameText);
        add(fname);
        add(fnameText);
        add(mname);
        add(mnameText);
        add(dob);
        add(dobChooser);
        add(gender);
        add(maleRButton);
        add(femaleRButton);
        add(email);
        add(emailText);
        add(mstatus);
        add(singleRButton);
        add(marriedRButton);
        add(otherRButton);
        add(address);
        add(addressText);
        add(city);
        add(cityText);
        add(state);
        add(stateText);
        add(pincode);
        add(pincodeText);
        add(loginGB);
        add(next);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == loginGB)
        {
            setVisible(false);
            new Login().setVisible(true);
        }
        if (ae.getSource() == next) {
            applicationFormNo = "" + formNo; // " " + data - for conversion into string
            String firstname = nameText.getText();
            String fathername = fnameText.getText();
            String mothername = mnameText.getText();

            String dob = ((JTextField) dobChooser.getDateEditor().getUiComponent()).getText();

            String gender = null;
            if (maleRButton.isSelected()) {
                gender = maleRButton.getText();
            } else if (femaleRButton.isSelected()) {
                gender = femaleRButton.getText();
            }

            String email = addressText.getText();

            String marital_status = null;
            if (singleRButton.isSelected()) {
                marital_status = singleRButton.getText();
            } else if (marriedRButton.isSelected()) {
                marital_status = marriedRButton.getText();
            } else {
                marital_status = otherRButton.getText();
            }

            String address = addressText.getText();
            String city = stateText.getText();
            String state = cityText.getText();
            String pincode = pincodeText.getText();


 if(firstname.isEmpty()
    || fathername.isEmpty()
    || mothername.isEmpty()
    || gender == null || gender.isEmpty()
    || dob.isEmpty()
    || email.isEmpty()
    || marital_status == null || marital_status.isEmpty()
    || address.isEmpty()
    || city.isEmpty()
    || state.isEmpty()
    || pincode.isEmpty() 
            )
            {
                JOptionPane.showMessageDialog(null, "Please fill all the fields and check if entered fields are correct");
            }
        else {
            try {
//                conn1 - to create a connection
                Conn conn1 = new Conn();
                String query1 = "insert into signUp values('" + applicationFormNo + "','" + firstname + "','" + fathername + "','" + mothername + "','" + dob + "','" + gender + "','" + email + "','" + marital_status + "','" + address + "','" + city + "','" + state + "','" + pincode + "')";

                conn1.s.executeUpdate(query1); // DML command
                
                JOptionPane.showMessageDialog(null, "Data submitted successfully!");
                setVisible(false);
                new SignUp2();
               
            } catch (Exception e) {
                System.out.println(e);
                e.printStackTrace();
            }
        }
    }
}

    public static String getFormNo()
    {
        return applicationFormNo;
    }
    
public static void main(String args[]) {
        new SignUp1();
    }
}
