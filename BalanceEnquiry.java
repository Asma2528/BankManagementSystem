package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class BalanceEnquiry extends JFrame implements ActionListener{

     String pin=Login.getPinNo();
     int balance;
     JButton back;
     JLabel balL;
     
     public BalanceEnquiry()
    {
         // Frame Designing
        setLayout(null);
        setTitle("Welfare Bank - ATM - Transactions - Cash Withdrawal");
        setLocation(300,15);
        setSize(1000,780);
        
        // Adding Background Image
        ImageIcon bg1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image b1=bg1.getImage().getScaledInstance(1130, 790, Image.SCALE_DEFAULT);
        ImageIcon bg2=new ImageIcon(b1);
        JLabel l=new JLabel(bg2);
        l.setBounds(0,0,1000,780);
        add(l);
        
        // Adding bank logo
        ImageIcon i=new ImageIcon(ClassLoader.getSystemResource("icons/welfareBankLogo2.png"));
        Image i1=i.getImage().getScaledInstance(130, 50, Image.SCALE_DEFAULT);
        ImageIcon i2=new ImageIcon(i1);
        JLabel l1=new JLabel(i2);
        l1.setBounds(130,160,150,50);
        l.add(l1);
        Color c1 = new Color(18, 66, 112);
        
        // Code for fetching current account balance
        try
        {
            Conn conn=new Conn();
            String query="select * from bank where pinNo='"+pin+"'";
            ResultSet rs=conn.s.executeQuery(query); // used when there is no change to the database
            while(rs.next())
            {
                
                if(rs.getString("Transaction_type").equals("Deposit"))
                {
                    balance+=Integer.parseInt(rs.getString("amount"));
                }
                else
                {
                    balance-=Integer.parseInt(rs.getString("amount"));
                }
            }
        }
        catch(Exception e)
        {
           System.out.println(e);
        }
        
        balL = new JLabel("Your Current Account Balance is Rs. "+balance);
        balL.setFont(new Font("Arial", Font.BOLD, 18));
        balL.setForeground(Color.WHITE);
        balL.setBackground(new Color(0, 0, 0, 0));
        balL.setBounds(150, 240, 500, 20);
        l.add(balL);
        
        back=new JButton("Back");
        back.setBounds(285, 390, 150, 35);
        back.setFont(new Font("Arial", Font.BOLD, 15));
        back.addActionListener(this);
        l.add(back);
        
        setUndecorated(true);
        setVisible(true);
    }
     
    @Override
    public void actionPerformed(ActionEvent ae)
    {
     if(ae.getSource()==back)
         {
             setVisible(false);
             new Transactions();
         }   
    }
    
    public static void main(String args[]) {
         new BalanceEnquiry();
    }
}
