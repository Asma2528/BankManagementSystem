package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class PinChange extends JFrame implements ActionListener {

    JButton back, chg;
    JPasswordField epin, npin, cnpin;

    public PinChange() {
        // Frame Designing
        setLayout(null);
        setTitle("Welfare Bank - ATM - Transactions - Pin Change");
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

        Label tr = new Label("Change Your Pin");
        tr.setFont(new Font("Arial", Font.BOLD, 20));
        tr.setForeground(Color.WHITE);
        tr.setBackground(new Color(0, 0, 0, 0));
        tr.setBounds(310, 180, 170, 30);
        l.add(tr);

        Label tr1 = new Label("Enter existing pin: ");
        tr1.setFont(new Font("Arial", Font.BOLD, 18));
        tr1.setForeground(Color.WHITE);
        tr1.setBackground(new Color(0, 0, 0, 0));
        tr1.setBounds(150, 230, 170, 20);
        l.add(tr1);

        epin = new JPasswordField();
        epin.setFont(new Font("Arial", Font.BOLD, 20));
        epin.setBounds(340, 230, 130, 30);
        add(epin);

        JLabel tr2 = new JLabel("Enter new pin: ");
        tr2.setFont(new Font("Arial", Font.BOLD, 18));
        tr2.setForeground(Color.WHITE);
        tr2.setBackground(new Color(0, 0, 0, 0));
        tr2.setBounds(150, 280, 170, 20);
        l.add(tr2);

        npin = new JPasswordField();
        npin.setFont(new Font("Arial", Font.BOLD, 20));
        npin.setBounds(340, 280, 130, 30);
        add(npin);

        JLabel tr3 = new JLabel("Confirm new pin: ");
        tr3.setFont(new Font("Arial", Font.BOLD, 18));
        tr3.setForeground(Color.WHITE);
        tr3.setBackground(new Color(0, 0, 0, 0));
        tr3.setBounds(150, 330, 250, 20);
        l.add(tr3);

        cnpin = new JPasswordField();
        cnpin.setFont(new Font("Arial", Font.BOLD, 20));
        cnpin.setBounds(340, 330, 130, 30);
        add(cnpin);

        back = new JButton("Back");
        back.setBounds(200, 390, 150, 35);
        back.setFont(new Font("Arial", Font.BOLD, 17));
        back.addActionListener(this);
        l.add(back);

        chg = new JButton("Change");
        chg.setBounds(365, 390, 150, 35);
        chg.setFont(new Font("Arial", Font.BOLD, 17));
        chg.addActionListener(this);
        l.add(chg);

        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back) {
            setVisible(false);
            new Transactions();
        } else if (ae.getSource() == chg) {
            try {
                String epinNo = epin.getText();
                String npinNo = npin.getText();
                String cnpinNo = cnpin.getText();

                Conn conn = new Conn();
                ResultSet rs = conn.s.executeQuery("select * from Login");
                boolean check = false;
                while (rs.next()) {
                    if (rs.getString("pinNo").equals(epinNo)) //checking if entered pin is equal to pin number (stored in database)
                    {
                        check = true;
                    }
                }
                if (!check) {
                    JOptionPane.showMessageDialog(null, "Please enter correct existing pin number");
                } else {
                    if (npinNo.length() != 4) {
                        JOptionPane.showMessageDialog(null, "Please enter 4 digit number");
                    } else if (npinNo.equals(cnpinNo)) {
                        conn.s.executeUpdate("update signUp3 set pinNo='" + cnpinNo + "' where pinNo='" + epinNo + "'");
                        conn.s.executeUpdate("update bank set pinNo='" + cnpinNo + "' where pinNo='" + epinNo + "'");
                        conn.s.executeUpdate("update login set pinNo='" + cnpinNo + "' where pinNo='" + epinNo + "'");
                        JOptionPane.showMessageDialog(null, "Pin changed Successfully!");
                        setVisible(false);
                        new Login();
                    } else {
                        JOptionPane.showMessageDialog(null, "New pin and Confirmation does not match!");
                    }
                }

            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public static void main(String args[]) {
        new PinChange();
    }
}
