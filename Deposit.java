package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date; // error as util and sql both contains sql class

public class Deposit extends JFrame implements ActionListener {

    Date dt = new Date();
    String date1 = "" + dt;
    JButton back, depBT, clear;
    JTextField amountT;
    JPasswordField pinT;
    String opin, epin; //opin- original pin & epin - entered pin

    public Deposit() {
        // Frame Designing
        setLayout(null);
        setTitle("Welfare Bank - ATM - Transactions - Deposit");
        setSize(1000, 780);
        setLocation(300, 15);

        // Adding Background Image
        ImageIcon bg = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image bgi = bg.getImage().getScaledInstance(1130, 790, Image.SCALE_DEFAULT);
        ImageIcon bg1 = new ImageIcon(bgi);
        JLabel l = new JLabel(bg1);
        l.setBounds(0, 0, 1000, 780);
        add(l);

        // Adding bank logo
        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("icons/welfareBankLogo2.png"));
        Image i1 = i.getImage().getScaledInstance(130, 50, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i1);
        JLabel l1 = new JLabel(i2);
        l1.setBounds(130, 160, 150, 50);
        l.add(l1);
        Color c1 = new Color(18, 66, 112);

        Label tr1 = new Label("Enter pin: ");
        tr1.setFont(new Font("Arial", Font.BOLD, 18));
        tr1.setForeground(Color.WHITE);
        tr1.setBackground(new Color(0, 0, 0, 0));
        tr1.setBounds(150, 220, 100, 20);
        l.add(tr1);

        pinT = new JPasswordField();
        pinT.setFont(new Font("Arial", Font.BOLD, 20));
        pinT.setBounds(150, 250, 150, 30);
        add(pinT);

        JLabel tr = new JLabel("Enter the amount you want to Deposit: ");
        tr.setFont(new Font("Arial", Font.BOLD, 18));
        tr.setForeground(Color.WHITE);
        tr.setBackground(new Color(0, 0, 0, 0));
        tr.setBounds(150, 300, 400, 20);
        l.add(tr);

        amountT = new JTextField();
        amountT.setFont(new Font("Arial", Font.BOLD, 20));
        amountT.setBounds(150, 330, 300, 30);
        add(amountT);

        clear = new JButton("Clear");
        clear.setBounds(275, 390, 100, 35);
        clear.setFont(new Font("Arial", Font.BOLD, 18));
        clear.addActionListener(this);
        l.add(clear);

        depBT = new JButton("Deposit");
        depBT.setBounds(400, 390, 120, 35);
        depBT.setFont(new Font("Arial", Font.BOLD, 18));
        depBT.addActionListener(this);
        l.add(depBT);

        back = new JButton("Back");
        back.setBounds(150, 390, 100, 35);
        back.setFont(new Font("Arial", Font.BOLD, 18));
        back.addActionListener(this);
        l.add(back);

        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back) {
            setVisible(false);
            new Transactions();
        } else if (ae.getSource() == clear) {
            pinT.setText("");
            amountT.setText("");
        } else if (ae.getSource() == depBT) {
            String epin = pinT.getText();
            String amount = amountT.getText();
            String cardN = Login.getCardNo();
            Conn conn = new Conn();
            try {
                boolean check1 = false;
                ResultSet rs0 = conn.s.executeQuery("select * from signUp3 where pinNo ='" + epin + "'");
                while (rs0.next()) {
                    if (rs0.getString("pinNo").equals(epin)) {
                        check1 = true;
                    }
                }

                if (!check1) {
                    JOptionPane.showMessageDialog(null, "Please enter correct pin number");

                } else {
                    boolean check = false;
                    ResultSet rs = conn.s.executeQuery("select * from SignUp3 where pinNo ='" + epin + "'");
                    while (rs.next()) {
                        if (rs.getString("pinNo").equals(epin)) {
                            check = true;
                            conn.s.executeUpdate("insert into bank values('" + date1 + "','" + cardN + "','" + epin + "','Deposit','" + amount + "')");
                            JOptionPane.showMessageDialog(null, "Amount Deposited Successfully!");
                            setVisible(false);
                            new Transactions();
                        }
                    }
                    if (!check) {
                        JOptionPane.showMessageDialog(null, "Please enter correct pin number");
                    }
               

                }
            } catch (Exception e) {
                System.out.println(e);
            }
            finally {
    // Close Statement
    if (conn.s != null) {
        try {
            conn.s.close();
        } catch (SQLException e) {
            // Handle exception if closing fails
            e.printStackTrace();
        }
    }

    // Close Connection
    if (conn.c != null) {
        try {
            conn.c.close();
        } catch (SQLException e) {
            // Handle exception if closing fails
            e.printStackTrace();
        }
    }
}
        }
    }

    public static void main(String args[]) {
        new Deposit();
    }
}
