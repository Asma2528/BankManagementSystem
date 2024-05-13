package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.Date;

public class Withdrawal extends JFrame implements ActionListener{

    JLabel l;
    Date dt=new Date();
    String date1=""+dt;
    JButton back,depBT,clear;
    JTextField amountT;
    JPasswordField pinT;
    String opin,epin; //opin- original pin & epin - entered pin
    
    public Withdrawal()
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
        
         Label tr1=new Label("Enter pin: ");
        tr1.setFont(new Font("Arial", Font.BOLD, 18));
        tr1.setForeground(Color.WHITE);
        tr1.setBackground(new Color(0, 0, 0, 0));
        tr1.setBounds(150, 220, 100, 20);
        l.add(tr1);
             
        pinT = new JPasswordField();
        pinT.setFont(new Font("Arial", Font.BOLD, 20));
        pinT.setBounds(150, 250, 150, 30);
        add(pinT);
        
        JLabel tr=new JLabel("Enter the amount you want to Withdraw: ");
        tr.setFont(new Font("Arial", Font.BOLD, 18));
        tr.setForeground(Color.WHITE);
        tr.setBackground(new Color(0, 0, 0, 0));
        tr.setBounds(150, 300, 400, 20);
        l.add(tr);
            
        JLabel t=new JLabel("Maximum withdrawal is Rs.10,000");
        t.setFont(new Font("Arial", Font.BOLD, 12));
        t.setForeground(Color.WHITE);
        t.setBackground(new Color(0, 0, 0, 0));
        t.setBounds(150, 350, 400, 20);
        l.add(t);
        
        
        amountT = new JTextField();
        amountT.setFont(new Font("Arial", Font.BOLD, 20));
        amountT.setBounds(150, 320, 300, 30);
        add(amountT);


        clear=new JButton("Clear");
        clear.setBounds(275, 400, 100, 35);
        clear.setFont(new Font("Arial", Font.BOLD, 18));
        clear.addActionListener(this);
        l.add(clear); 
        
        depBT=new JButton("Withdraw");
        depBT.setBounds(400, 400, 120, 35);
        depBT.setFont(new Font("Arial", Font.BOLD, 18));
        depBT.addActionListener(this);
        l.add(depBT);   
        
        back=new JButton("Back");
        back.setBounds(150, 400, 100, 35);
        back.setFont(new Font("Arial", Font.BOLD, 18));
        back.addActionListener(this);
        l.add(back);      
               
               
        
        setUndecorated(true);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        if (ae.getSource()==back)
        {
            setVisible(false);
            new Transactions();
        }
        else if (ae.getSource()==clear)
        {
            pinT.setText("");
            amountT.setText("");
        }
        else if (ae.getSource()==depBT)
        {
            String epin=pinT.getText();
            String Wamount=amountT.getText();
            String cardN=Login.getCardNo();
            Conn conn=new Conn();
            try
            {
                boolean check1=false;
                ResultSet rs0= conn.s.executeQuery("select * from signUp3 where pinNo ='"+epin+"'");
                    while(rs0.next())
                    {
                       if(rs0.getString("pinNo").equals(epin))
                       {
                           check1=true;
                       }
                    }
                      if(!check1)
                        {
                            JOptionPane.showMessageDialog(null, "Please enter correct pin number");
                        }
              if(check1)
              {
                if (Integer.parseInt(Wamount)>10000)
                {
                    JOptionPane.showMessageDialog(null, "Cannot withdraw more than Rs. 10,000");
                }
                else
                {   
                boolean check=false;
                ResultSet rs= conn.s.executeQuery("select * from SignUp3 where pinNo ='"+epin+"'");
                    while(rs.next())
                    {
                        // Checking if authenticated user is trying to withdraw the amount
                       if(rs.getString("pinNo").equals(epin))
                       {
                           check=true;
                       }
                    }
                    rs0.close();
                      if(!check)
                        {
                            JOptionPane.showMessageDialog(null, "Please enter correct pin number");
                        }
                      else
                      {
                           ResultSet rs1=conn.s.executeQuery("select * from bank where pinNo ='"+epin+"'");
                           int balance=0;
                           while(rs1.next())
                           {
                             if(rs1.getString("Transaction_type").equals("Deposit"))
                             {
                               balance+=Integer.parseInt(rs1.getString("amount")); // to convert string value into integer value
                             }
                             else
                             {
                               balance-=Integer.parseInt(rs1.getString("amount"));
                             }
                           }
                          
                           if(balance < (Integer.parseInt(Wamount)))
                           {
                               JOptionPane.showMessageDialog(null,"Insufficient Balance");
                           }
                          else
                           {
                           conn.s.executeUpdate("insert into bank values('"+date1+"','"+cardN+"','"+epin+"','Withdraw','"+Wamount+"')");                         
                           JOptionPane.showMessageDialog(null, "Rs."+Wamount+" Amount Debited Successfully!");
                           setVisible(false); 
                           new Transactions();
                           }
                      }
                }
                }
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
          
        }
    }
    
    public static void main(String args[]) {
             new Withdrawal();
    }
}
