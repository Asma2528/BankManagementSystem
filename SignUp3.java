package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class SignUp3 extends JFrame implements ActionListener {

    String applicationFormNo=SignUp1.getFormNo();
    static String cardNo,pinNo;
    JRadioButton savingAccRB,currentAccRB,FixedAccRB,recurringAccRB;
    ButtonGroup accTypeGrp;
    JLabel cardNoR,pinNoR;
    JCheckBox agreeC,atmC,internetBankingC,mobileBankingC,emailSmsC,ChequeC,EStatementC;
    JButton Submit,Cancel;
    

    SignUp3() {
        setLayout(null);
        setTitle("Welfare Bank - Sign Up - Account Details");
        setLocation(400, 15);
        setSize(700, 800);
        Color c = new Color(160, 203, 244);
        getContentPane().setBackground(c);

        //  Code for adding logo 
        ImageIcon ic1 = new ImageIcon(ClassLoader.getSystemResource("icons/welfareBankLogo2.png"));
        Image i1 = ic1.getImage().getScaledInstance(200, 90, Image.SCALE_DEFAULT);
        ImageIcon ic2 = new ImageIcon(i1);
        JLabel l1 = new JLabel(ic2);
        l1.setBounds(80, 10, 200, 90);
        add(l1);
        Color c1 = new Color(18, 66, 112);

       
        JLabel ad = new JLabel("Account Details");
        ad.setBounds(320, 45, 600, 32);
        ad.setFont(new Font("Futura Md BT", Font.BOLD, 35)); //creating Anonymous object of font class.
        add(ad);
        
        JLabel applicationFormNoL = new JLabel("Application Form No: " + applicationFormNo);
        applicationFormNoL.setFont(new Font("Albertus Extra Bold", Font.BOLD, 27));
        applicationFormNoL.setBounds(200, 120, 600, 30);
        add(applicationFormNoL);
           
        JLabel accTypeL =new JLabel("Account Type: ");
        accTypeL.setFont(new Font("Arial", Font.BOLD, 21));
        accTypeL.setBounds(60, 175, 300, 23);
        add(accTypeL);
         
        savingAccRB = new JRadioButton("Saving Account");
        savingAccRB.setBackground(c);
        savingAccRB.setBounds(60, 220, 250, 30);
        savingAccRB.setFont(new Font("Arial",Font.BOLD,15));
        add(savingAccRB);
        
        currentAccRB = new JRadioButton("Current Account");
        currentAccRB.setBackground(c);
        currentAccRB.setBounds(60, 270, 250, 30);
        currentAccRB.setFont(new Font("Arial",Font.BOLD,15));
        add(currentAccRB);
        
        FixedAccRB = new JRadioButton("Fixed Deposit Account");
        FixedAccRB.setBackground(c);
        FixedAccRB.setBounds(340, 220, 250, 30);
        FixedAccRB.setFont(new Font("Arial",Font.BOLD,15));
        add(FixedAccRB);
        
        recurringAccRB = new JRadioButton("Recurring Deposit Account");
        recurringAccRB.setBackground(c);
        recurringAccRB.setBounds(340, 270, 250, 30);
        recurringAccRB.setFont(new Font("Arial",Font.BOLD,15));
        add(recurringAccRB);
        
        accTypeGrp = new ButtonGroup();
        accTypeGrp.add(savingAccRB);
        accTypeGrp.add(currentAccRB);
        accTypeGrp.add(FixedAccRB);
        accTypeGrp.add(recurringAccRB);
         
        JLabel cardNoL =new JLabel("Card Number: ");
        cardNoL.setFont(new Font("Arial", Font.BOLD, 21));
        cardNoL.setBounds(60, 340, 300, 23);
        add(cardNoL);
        
        JLabel cardNoInfoL =new JLabel("Your 16-Digit Card Number ");
        cardNoInfoL.setFont(new Font("Arial", Font.BOLD, 12));
        cardNoInfoL.setBounds(60, 365, 300, 12);
        add(cardNoInfoL);
        
        cardNoR = new JLabel("XXXX-XXXX-XXXX-4358");
        cardNoR.setFont(new Font("Arial", Font.BOLD, 21));
        cardNoR.setBounds(340, 340, 250, 30);
        add(cardNoR);
        
        
        JLabel pinNoL =new JLabel("PIN: ");
        pinNoL.setFont(new Font("Arial", Font.BOLD, 21));
        pinNoL.setBounds(60, 420, 300, 23);
        add(pinNoL);
        
        JLabel pinNoInfoL =new JLabel("Your 4-Digit PIN");
        pinNoInfoL.setFont(new Font("Arial", Font.BOLD, 12));
        pinNoInfoL.setBounds(60, 445, 300, 12);
        add(pinNoInfoL);
        
        pinNoR = new JLabel("XXXX");
        pinNoR.setFont(new Font("Arial", Font.BOLD, 21));
        pinNoR.setBounds(340, 420, 100, 30);
        add(pinNoR);
        
        JLabel servicesRequiredL =new JLabel("Services Required: ");
        servicesRequiredL.setFont(new Font("Arial", Font.BOLD, 21));
        servicesRequiredL.setBounds(60, 490, 300, 23);
        add(servicesRequiredL);
        
        atmC=new JCheckBox("ATM Card");
        atmC.setBackground(c);
        atmC.setBounds(60, 530, 200, 30);
        atmC.setFont(new Font("Arial",Font.BOLD,15));
        add(atmC);
        
        internetBankingC=new JCheckBox("Internet Banking");
        internetBankingC.setBackground(c);
        internetBankingC.setBounds(340, 530, 200, 30);
        internetBankingC.setFont(new Font("Arial",Font.BOLD,15));
        add(internetBankingC);
        
        mobileBankingC=new JCheckBox("Mobile Banking");
        mobileBankingC.setBackground(c);
        mobileBankingC.setBounds(60, 570, 200, 30);
        mobileBankingC.setFont(new Font("Arial",Font.BOLD,15));
        add(mobileBankingC);
        
        emailSmsC=new JCheckBox("Email & SMS Alerts");
        emailSmsC.setBackground(c);
        emailSmsC.setBounds(340, 570, 200, 30);
        emailSmsC.setFont(new Font("Arial",Font.BOLD,15));
        add(emailSmsC);
        
        ChequeC=new JCheckBox("Cheque Book");
        ChequeC.setBackground(c);
        ChequeC.setBounds(60, 610, 200, 30);
        ChequeC.setFont(new Font("Arial",Font.BOLD,15));
        add(ChequeC);
        
        EStatementC=new JCheckBox("E-Statement");
        EStatementC.setBackground(c);
        EStatementC.setBounds(340, 610, 200, 30);
        EStatementC.setFont(new Font("Arial",Font.BOLD,15));
        add(EStatementC);    
          
        agreeC=new JCheckBox("I hereby declare that the entered details are correct and to the best of my knowledge");
        agreeC.setBackground(c);
        agreeC.setBounds(60, 665, 650, 15);
        agreeC.setFont(new Font("Arial",Font.BOLD,13));
        add(agreeC);
        
                
        Cancel=new JButton("CANCEL");
        Cancel.setBounds(350, 700, 100, 35);
        Cancel.setBackground(c1);
        Cancel.setForeground(Color.WHITE);
        Cancel.setFont(new Font("Arial", Font.BOLD, 15));
        Cancel.addActionListener(this);
        add(Cancel);
        
        Submit=new JButton("SUBMIT");
        Submit.setBounds(480,700,110,35);
        Submit.setBackground(c1);
        Submit.setForeground(Color.WHITE);
        Submit.setFont(new Font("Arial",Font.BOLD,15));
        Submit.addActionListener(this);
        add(Submit);
        
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==Cancel)
        {
            int confirmationToExit=JOptionPane.showConfirmDialog(null,"Are you sure you want to"
                    + " exit? All your entered data will be lost!","Confirmation to exit",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
            
            if(confirmationToExit==JOptionPane.YES_OPTION)
                {
                    try
                {
                Conn c3=new Conn();
                String query3="Delete from signUp where formNo='"+applicationFormNo+"' LIMIT 1";
                c3.s.executeUpdate(query3);
                String query4="Delete from signUp2 where formNo='"+applicationFormNo+"' LIMIT 1";
                c3.s.executeUpdate(query4);
                setVisible(false);
                }
                    catch(Exception e)
                {
                System.out.println(e);
                }
            }  
        }
        else if (ae.getSource()==Submit)
        {
          if (agreeC.isSelected())
          {
                  Random ran = new Random(); //Generates a random number
                  long cn = (ran.nextLong() % 90000000L) + 6388936000000000L; // making it a 16 digit number
                  long pn = (ran.nextLong() % 9000L) + 1000L; // making it a 4 digit number
                  cardNo= "" + Math.abs(cn);
                  pinNo = "" + Math.abs(pn);
                  
                String accType=null;
                if (savingAccRB.isSelected())
                {
                    accType=savingAccRB.getText();
                }
                else if (currentAccRB.isSelected())
                {
                    accType=currentAccRB.getText();
                }
                else if (FixedAccRB.isSelected())
                {
                    accType=FixedAccRB.getText();
                }
                else if (recurringAccRB.isSelected())
                {
                    accType=recurringAccRB.getText();
                }
                
                String services="";
                if(atmC.isSelected())
                {
                    services=services+atmC.getText();
                }
                if(internetBankingC.isSelected())
                {
                    services=services+" "+internetBankingC.getText();
                }
                if(mobileBankingC.isSelected())
                {
                    services=services+" "+mobileBankingC.getText();
                }
                if(emailSmsC.isSelected())
                {
                    services=services+" "+emailSmsC.getText();
                }
                if(ChequeC.isSelected())
                {
                    services=services+" "+ChequeC.getText();
                }
                if(EStatementC.isSelected())
                {
                    services=services+" "+EStatementC.getText();
                }
                
                int confirmationToSubmit=JOptionPane.showConfirmDialog(null,"Are you sure you want to"
                        + " submit? ","Confirmation to Submit",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
            

                if(confirmationToSubmit==JOptionPane.YES_OPTION)
                    {
                            try
                        {
                        Conn c3=new Conn();
                        String query3="insert into signUp3 values('"+applicationFormNo+"','"+accType+"','"+cardNo+"','"+pinNo+"','"+services+"')";
                        c3.s.executeUpdate(query3);
                        String query4="insert into login values('"+applicationFormNo+"','"+cardNo+"','"+pinNo+"')";
                        c3.s.executeUpdate(query4);
                        JOptionPane.showMessageDialog(null, "Your Sign Up Form is submitted succesfully. Your Card Number is " +cardNo+" and Your pin number is "+pinNo);
                        setVisible(false);
                        new Login();
                        }
                        catch(Exception e)
                        {
                        System.out.println(e);
                        }
                    }
          }
          else
          {
              JOptionPane.showMessageDialog(null, "Please agree to the terms");
          }
        }

    }
    
    public static String getcardNo()
    {
        return cardNo;
    }
       
    public static String getpinNo()
    {
        return pinNo;
    }
              
    public static void main(String args[]) {
        new SignUp3();
    }
}
