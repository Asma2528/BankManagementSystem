package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener{
    
    JButton dep,pinChg,cashW,fastC,miniSt,balEn,exit;
          
    String applicationFormNo=SignUp1.getFormNo();
    public Transactions()
    {
       setLayout(null);
       setTitle("Welfare Bank - ATM - Transactions");
       setSize(1000,780);
       setLocation(300,15); 
       // Adding background image
       ImageIcon bg1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg")); 
       Image bgsize= bg1.getImage().getScaledInstance(1130, 790, Image.SCALE_DEFAULT);
       ImageIcon bg2 = new ImageIcon(bgsize);
       JLabel l = new JLabel(bg2);
       l.setBounds(0, 0, 1000, 780);
       add(l);
       
        //  Code for adding logo 
        ImageIcon ic1 = new ImageIcon(ClassLoader.getSystemResource("icons/welfareBankLogo2.png"));
        Image i1 = ic1.getImage().getScaledInstance(130, 50, Image.SCALE_DEFAULT);
        ImageIcon ic2 = new ImageIcon(i1);
        JLabel l1 = new JLabel(ic2);
        l1.setBounds(130, 155, 150, 50);
        l.add(l1);
        Color c1 = new Color(18, 66, 112);
        
        Label tr=new Label("Please select your transactions");
        tr.setFont(new Font("Arial", Font.BOLD, 18));
        tr.setForeground(Color.WHITE);
        tr.setBackground(new Color(0, 0, 0, 0));
        tr.setBounds(285, 170, 300, 20);
        l.add(tr);
         
        dep=new JButton("Deposit");
        dep.setBounds(170, 240, 170, 35);
        dep.setFont(new Font("Arial", Font.BOLD, 15));
        dep.addActionListener(this);
        l.add(dep);
        
        pinChg=new JButton("Pin Change");
        pinChg.setBounds(365, 240, 170, 35);
        pinChg.setFont(new Font("Arial", Font.BOLD, 15));
        pinChg.addActionListener(this);
        l.add(pinChg);
        
        
        cashW=new JButton("Cash Withdrawal");
        cashW.setBounds(170, 290, 170, 35);
        cashW.setFont(new Font("Arial", Font.BOLD, 15));
        cashW.addActionListener(this);
        l.add(cashW);
        
        fastC=new JButton("Fast Cash");
        fastC.setBounds(365, 290, 170, 35);
        fastC.setFont(new Font("Arial", Font.BOLD, 15));
        fastC.addActionListener(this);
        l.add(fastC);
        
        miniSt=new JButton("Mini Statement");
        miniSt.setBounds(170, 340, 170, 35);
        miniSt.setFont(new Font("Arial", Font.BOLD, 15));
        miniSt.addActionListener(this);
        l.add(miniSt);
        
        
        balEn=new JButton("Balance Enquiry"); 
        balEn.setBounds(365, 340, 170, 35);
        balEn.setFont(new Font("Arial", Font.BOLD, 15));
        balEn.addActionListener(this);
        l.add(balEn);
        
        exit=new JButton("Exit");
        exit.setBounds(285, 390, 170, 35);
        exit.setFont(new Font("Arial", Font.BOLD, 15));
        exit.addActionListener(this);
        l.add(exit);
        
        
        setUndecorated(true);
        setVisible(true);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        if (ae.getSource()==dep)
        {
            setVisible(false);
            new Deposit();
        }
        else if (ae.getSource()==pinChg)
        {
            setVisible(false);
            new PinChange();
        }
        else if (ae.getSource()==cashW)
        {
            setVisible(false);
            new Withdrawal();
        }
        else if (ae.getSource()==miniSt)
        {
            new MiniStatement();
        }
        else if(ae.getSource()==fastC)
        {
            setVisible(false);
            new FastCash();
        }
        else if (ae.getSource()==balEn)
        {
            setVisible(false);
            new BalanceEnquiry();
        }
          else if (ae.getSource()==exit)
        {
            System.exit(0);
        }
    }
   
    public static void main(String args[]) {
        new Transactions();
    }
}
