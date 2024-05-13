package bank.management.system;

import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.Date; 
// date class ambigous error as it is available in both sql as well as util package -
// thus, we need to explicitly specify that we want to use Date class of util package
import java.util.*;

public class MiniStatement extends JFrame implements ActionListener {

    JButton print;
    String cardNo = Login.getCardNo();
    int balance;
    String pin=Login.getPinNo();
    JLabel balL;
    Conn conn=new Conn();
    DefaultTableModel tab;
    JTable jt;
    
    public MiniStatement() {
        // Frame Designing
         setLayout(null);
//setLayout(new FlowLayout());

        setTitle("Welfare Bank - ATM - Transactions - Mini Statement");
        setLocation(300, 15);
        setSize(675, 795);
        getContentPane().setBackground(Color.WHITE); 

        // Adding bank logo
        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("icons/welfareBankLogo2.png"));
        Image i1 = i.getImage().getScaledInstance(130, 50, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i1);
        JLabel l1 = new JLabel(i2);
        l1.setBounds(1, 1, 300, 150);
        add(l1);
        Color c1 = new Color(18, 66, 112);

        Label h = new Label("WELFARE BANK");
        h.setFont(new Font("Roboto Slab", Font.BOLD, 37));
        h.setBounds(310, 60, 500, 40);
        add(h);

        Label tr = new Label("Mini Statement");
        tr.setFont(new Font("Arial", Font.BOLD, 25));
        tr.setBounds(260, 145, 300, 32);
        add(tr);

        Date d = new Date();
        // current date
        Label dt = new Label("Date: " + d);
        dt.setFont(new Font("Arial",Font.BOLD, 20));
        dt.setBounds(40, 200, 600, 20);
        add(dt);

        // card number
        Label cn = new Label("Card Number: " + cardNo);
        cn.setFont(new Font("Arial", Font.BOLD, 20));
        cn.setBounds(40, 230, 330, 20);
        add(cn);

        // To display transactions

        
        
        try
        {
            tab = new DefaultTableModel();  
            tab.addColumn("Transaction Date");
            tab.addColumn("Transaction Type");
            tab.addColumn("Amount");
            jt=new JTable(tab);
            jt.setRowHeight(20);
            jt.setBounds(40,270,550,380);
            jt.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
            jt.setBackground(Color.WHITE);
            JScrollPane sp=new JScrollPane(jt);
            sp.setBounds(40,270,550,380);
            // Set the background color for the JScrollPane's viewport
             sp.getViewport().setBackground(Color.WHITE);
            add(sp);
            
            String query1="select * from bank where pinNo='"+pin+"'";
            ResultSet rs1=conn.s.executeQuery(query1); 
            tab.setRowCount(0);
            while(rs1.next())
            {
                String transactionDate = rs1.getString("Transaction_date");
                String transactionType = rs1.getString("Transaction_type");
                String amount = rs1.getString("amount");

                // Add the data to the table model
                Vector<String> rows = new Vector<>();
                rows.add(transactionDate);
                rows.add(transactionType);
                rows.add(amount);
                
                tab.addRow(rows);
                repaint();
            }
 
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
        // To display available balance
            try
        {
           
            String query2="select * from bank where pinNo='"+pin+"'";
            ResultSet rs2=conn.s.executeQuery(query2); // used when there is no change to the database
            while(rs2.next())
            {
                
                if(rs2.getString("Transaction_type").equals("Deposit"))
                {
                    balance+=Integer.parseInt(rs2.getString("amount"));
                }
                else
                {
                    balance-=Integer.parseInt(rs2.getString("amount"));
                }
            }
        }
        catch(Exception e)
        {
           System.out.println(e);
        }
        
        balL = new JLabel("Available Balance Rs. "+balance);
        balL.setFont(new Font("Arial", Font.BOLD, 20));
        balL.setBounds(40, 660, 500, 20);
        add(balL);
        
        // date, transaction type, amount
        print = new JButton(" PRINT ");
        print.setBounds(290, 690, 150, 35);
        print.setFont(new Font("Arial", Font.BOLD, 17));
        print.setBackground(c1);
        print.setForeground(Color.WHITE);
        print.addActionListener(this);
        add(print);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == print) {
             try {
                jt.print();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
    

    public static void main(String args[]) {
        new MiniStatement();
    }
}
