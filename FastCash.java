package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.*;

public class FastCash extends JFrame implements ActionListener {

    JButton rs100, rs500, rs1000, rs2000, rs5000, rs10000, back;
    String Wamount;
    String epin = Login.getPinNo();
    Date dt = new Date();
    String date1 = "" + dt;

    public FastCash() {
        // Frame Designing
        setLayout(null);
        setTitle("Welfare Bank - ATM - Transactions - Fast Cash");
        setLocation(300, 15);
        setSize(1000, 780);

        // Adding Background Image
        ImageIcon bg1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image b1 = bg1.getImage().getScaledInstance(1130, 790, Image.SCALE_DEFAULT);
        ImageIcon bg2 = new ImageIcon(b1);
        JLabel l = new JLabel(bg2);
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

        Label tr = new Label("Select Withdrawal Amount:");
        tr.setFont(new Font("Arial", Font.BOLD, 18));
        tr.setForeground(Color.WHITE);
        tr.setBackground(new Color(0, 0, 0, 0));
        tr.setBounds(285, 180, 300, 20);
        l.add(tr);

        rs100 = new JButton("Rs. 100");
        rs100.setBounds(170, 240, 150, 35);
        rs100.setFont(new Font("Arial", Font.BOLD, 15));
        rs100.addActionListener(this);
        l.add(rs100);

        rs500 = new JButton("Rs. 500");
        rs500.setBounds(365, 240, 150, 35);
        rs500.setFont(new Font("Arial", Font.BOLD, 15));
        rs500.addActionListener(this);
        l.add(rs500);

        rs1000 = new JButton("Rs. 1000");
        rs1000.setBounds(170, 290, 150, 35);
        rs1000.setFont(new Font("Arial", Font.BOLD, 15));
        rs1000.addActionListener(this);
        l.add(rs1000);

        rs2000 = new JButton("Rs. 2000");
        rs2000.setBounds(365, 290, 150, 35);
        rs2000.setFont(new Font("Arial", Font.BOLD, 15));
        rs2000.addActionListener(this);
        l.add(rs2000);

        rs5000 = new JButton("Rs. 5000");
        rs5000.setBounds(170, 340, 150, 35);
        rs5000.setFont(new Font("Arial", Font.BOLD, 15));
        rs5000.addActionListener(this);
        l.add(rs5000);

        rs10000 = new JButton("Rs. 10000");
        rs10000.setBounds(365, 340, 150, 35);
        rs10000.setFont(new Font("Arial", Font.BOLD, 15));
        rs10000.addActionListener(this);
        l.add(rs10000);

        back = new JButton("Back");
        back.setBounds(285, 390, 150, 35);
        back.setFont(new Font("Arial", Font.BOLD, 15));
        back.addActionListener(this);
        l.add(back);

        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        String cardN = Login.getCardNo();
        Conn conn = new Conn();

        if (ae.getSource() == rs100) {
            Wamount = "100";
        } else if (ae.getSource() == rs500) {
            Wamount = "500";
        } else if (ae.getSource() == rs1000) {
            Wamount = "1000";
        } else if (ae.getSource() == rs2000) {
            Wamount = "2000";
        } else if (ae.getSource() == rs5000) {
            Wamount = "5000";
        } else if (ae.getSource() == rs10000) {
            Wamount = "10000";
        } else if (ae.getSource() == back) {
            setVisible(false);
            new Transactions();
        }

        if (!(Wamount.equals(""))) {
            try {
                if (Integer.parseInt(Wamount) > 10000) {
                    JOptionPane.showMessageDialog(null, "Cannot withdraw more than Rs. 10,000");
                } else {
                    ResultSet rs1 = conn.s.executeQuery("select * from bank where pinNo ='" + epin + "'");
                    int balance = 0;
                    while (rs1.next()) {
                        if (rs1.getString("Transaction_type").equals("Deposit")) {
                            balance += Integer.parseInt(rs1.getString("amount")); // to convert string value into integer value
                        } else {
                            balance -= Integer.parseInt(rs1.getString("amount"));
                        }
                    }

                    if (balance < (Integer.parseInt(Wamount))) {
                        JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    } else {
                        conn.s.executeUpdate("insert into bank values('" + date1 + "','" + cardN + "','" + epin + "','Withdraw','" + Wamount + "')");
                        JOptionPane.showMessageDialog(null, "Rs." + Wamount + " Amount Debited Successfully!");
                        setVisible(false);
                        new Transactions();
                    }
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public static void main(String args[]) {
        new FastCash();
    }
}
