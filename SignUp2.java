package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class SignUp2 extends JFrame implements ActionListener {

    JLabel headingL,religionL,categoryL,incomeL,educationQL,occupationL,panNoL,adhaarNoL,seniorCL,existingAL;
    JRadioButton syesRB, snoRB,eyesRB,enoRB;
    ButtonGroup sb1,eb1; // For grouping senior citizen and existing account details radio button.
    JTextField panNoText, adhaarNoText;
    JComboBox religionCB, categoryCB,incomeCB,educationQCB,occupationCB;
    JButton next2;
    String applicationFormNo=SignUp1.getFormNo();
    
    SignUp2()
    {
        // Code for Frame designing
        setLayout(null);
        setTitle("Welfare Bank - Sign Up - Additional Details");
        setLocation(400, 30);
        setSize(760, 780);
        Color c = new Color(160, 203, 244);
        getContentPane().setBackground(c);
        
        //  Code for adding logo 
        ImageIcon ic1=new ImageIcon(ClassLoader.getSystemResource("icons/welfareBankLogo2.png"));
        Image i1 = ic1.getImage().getScaledInstance(200, 90, Image.SCALE_DEFAULT);
        ImageIcon ic2 = new ImageIcon(i1);
        JLabel l1 = new JLabel(ic2);
        l1.setBounds(100, 10, 200, 90);
        
        Color c1 = new Color(18, 66, 112);
        
        headingL = new JLabel("Additional Details");
        headingL.setBounds(350, 48, 600, 32);
        headingL.setFont(new Font("Futura Md BT", Font.BOLD, 35)); //creating Anonymous object of font class.

        JLabel applicationFormNoL = new JLabel("Application Form No: " + applicationFormNo );
        applicationFormNoL.setFont(new Font("Albertus Extra Bold", Font.BOLD, 27));
        applicationFormNoL.setBounds(230, 120, 600, 30);
        
        religionL =new JLabel("Religion: ");
        religionL.setFont(new Font("Arial", Font.BOLD, 22));
        religionL.setBounds(60, 175, 300, 25);
        
        
        String religionArray[]={"Hindu","Muslim","Christian","Sikh","Buddhism","Parsi","Others"};
        religionCB = new JComboBox(religionArray);
        religionCB.setFont(new Font("Arial", Font.BOLD, 20));
        religionCB.setBackground(Color.WHITE);
        religionCB.setBounds(280, 175, 400, 32);

        // To set the color of the selected combo box
        religionCB.setRenderer(new DefaultListCellRenderer() {
        @Override
        public void paint(Graphics g) {
            setBackground(Color.WHITE);
            super.paint(g);
        }
    });
        
        categoryL = new JLabel("Category: ");
        categoryL .setFont(new Font("Arial", Font.BOLD, 22));
        categoryL .setBounds(60, 220, 200, 25);

        String categoryArray[]={"General","ST","SC","OBC","Others"};
        categoryCB = new JComboBox(categoryArray);
        categoryCB.setFont(new Font("Arial", Font.BOLD, 20));
        categoryCB.setBackground(Color.WHITE);
        categoryCB.setBounds(280, 220, 400, 32);

        // To set the color of the selected combo box
        categoryCB.setRenderer(new DefaultListCellRenderer() {
        @Override
        public void paint(Graphics g) {
            setBackground(Color.WHITE);
            super.paint(g);
        }
    });
        
        incomeL = new JLabel("Income: ");
        incomeL.setFont(new Font("Arial", Font.BOLD, 22));
        incomeL.setBounds(60, 265, 200, 25);

        String incomeArray[]={"No income","< 1,50,000","< 2,50,000","< 5,00,000","< 10,00,000","Above 10,00,000"};
        incomeCB = new JComboBox(incomeArray);
        incomeCB.setFont(new Font("Arial", Font.BOLD, 20));
        incomeCB.setBackground(Color.WHITE);
        incomeCB.setBounds(280, 265, 400, 32);

        // To set the color of the selected combo box
        incomeCB.setRenderer(new DefaultListCellRenderer() {
        @Override
        public void paint(Graphics g) {
            setBackground(Color.WHITE);
            super.paint(g);
        }
    });
        
        educationQL = new JLabel("Educational ");
        educationQL.setFont(new Font("Arial", Font.BOLD, 22));
        educationQL.setBounds(60, 310, 200, 25);
        
        JLabel educationQL2 = new JLabel("Qualification: ");
        educationQL2.setFont(new Font("Arial", Font.BOLD, 22));
        educationQL2.setBounds(60, 340, 200, 25);
        
        
        String educationQArray[]={"Non-Graduate","Graduate","Post-Graduate","Doctrate","Others"};
        educationQCB = new JComboBox(educationQArray);
        educationQCB.setFont(new Font("Arial", Font.BOLD, 20));
        educationQCB.setBackground(Color.WHITE);
        educationQCB.setBounds(280, 315, 400, 28);


        // To set the color of the selected combo box
        educationQCB.setRenderer(new DefaultListCellRenderer() {
        @Override
        public void paint(Graphics g) {
            setBackground(Color.WHITE);
            super.paint(g);
        }
    });
        
        occupationL = new JLabel("Occupation: ");
        occupationL.setFont(new Font("Arial", Font.BOLD, 22));
        occupationL.setBounds(60, 400, 200, 25);

        String occupationArray[]={"Salaried","Self-Employed","Business","Student","Retired","Others"};
        occupationCB = new JComboBox(occupationArray);
        occupationCB.setFont(new Font("Arial", Font.BOLD, 20));
        occupationCB.setBackground(Color.WHITE);
        occupationCB.setBounds(280, 400, 400, 32);

        // To set the color of the selected combo box
        occupationCB.setRenderer(new DefaultListCellRenderer() {
        @Override
        public void paint(Graphics g) {
            setBackground(Color.WHITE);
            super.paint(g);
        }
    });
        
        panNoL = new JLabel("PAN Number: ");
        panNoL.setFont(new Font("Arial", Font.BOLD, 22));
        panNoL.setBounds(60, 445, 200, 25);

        panNoText = new JTextField();
        panNoText.setFont(new Font("Arial", Font.BOLD, 22));
        panNoText.setBounds(280, 445, 400, 30);


        adhaarNoL = new JLabel("Adhaar Number: ");
        adhaarNoL.setFont(new Font("Arial", Font.BOLD, 22));
        adhaarNoL.setBounds(60, 490, 200, 25);

        adhaarNoText = new JTextField();
        adhaarNoText.setFont(new Font("Arial", Font.BOLD, 20));
        adhaarNoText.setBounds(280, 490, 400, 32);

        seniorCL = new JLabel("Senior Citizen: ");
        seniorCL.setFont(new Font("Arial", Font.BOLD, 22));
        seniorCL.setBounds(60, 535, 200, 25);
        
        syesRB = new JRadioButton("Yes");
        syesRB.setBackground(c);
        syesRB.setBounds(280, 535, 100, 30);

        snoRB = new JRadioButton("No");
        snoRB.setBackground(c);
        snoRB.setBounds(430, 535, 100, 30);

        sb1 = new ButtonGroup();
        sb1.add(syesRB);
        sb1.add(snoRB);
        
        existingAL = new JLabel("Existing Account: ");
        existingAL.setFont(new Font("Arial", Font.BOLD, 22));
        existingAL.setBounds(60, 580, 200, 25);
        
        eyesRB = new JRadioButton("Yes");
        eyesRB.setBackground(c);
        eyesRB.setBounds(280, 580, 100, 30);

        enoRB = new JRadioButton("No");
        enoRB.setBackground(c);
        enoRB.setBounds(430, 580, 100, 30);

        eb1 = new ButtonGroup();
        eb1 .add(eyesRB);
        eb1 .add(enoRB);
        
        next2=new JButton("NEXT");
        next2.setBounds(580, 610, 100, 35);
        next2.setBackground(c1);
        next2.setForeground(Color.WHITE);
        next2.setFont(new Font("Arial", Font.BOLD, 15));
        next2.addActionListener(this);
        
  
        add(l1);
        add(headingL);
        add(applicationFormNoL);
        add(religionL);
        add(religionCB);
        add(categoryL);
        add(categoryCB);
        add(incomeL);
        add(incomeCB);
        add(educationQL);
        add(educationQL2);
        add(educationQCB);
        add(occupationL);
        add(occupationCB);
        add(panNoL);
        add(panNoText);
        add(adhaarNoL);
        add(adhaarNoText);
        add(seniorCL);
        add(syesRB);
        add(snoRB);
        add(existingAL);
        add(eyesRB);
        add(enoRB);
        add(next2);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae)
    {   
        if(ae.getSource()==next2)
        {
            String religion,category,income,eduacationQualification,occupation,panNo,adhaarNo;
            String seniorCitizen=null;
            String existingAccount=null;
            religion=""+religionCB.getSelectedItem();
            category=""+categoryCB.getSelectedItem();
            income=""+incomeCB.getSelectedItem();
            eduacationQualification=""+educationQCB.getSelectedItem();
            occupation=""+occupationCB.getSelectedItem();
            panNo=""+panNoText.getText();
            adhaarNo=""+adhaarNoText.getText();
            if(syesRB.isSelected())
            {
                seniorCitizen=syesRB.getText();
            }
            else if(snoRB.isSelected())
            {
                seniorCitizen=snoRB.getText();
            }
            
              if(eyesRB.isSelected())
            {
                existingAccount=eyesRB.getText();
            }
            else if(enoRB.isSelected())
            {
                existingAccount=enoRB.getText();
            }
              
        if(adhaarNo.length()<12 || adhaarNo.length()>12)
                 {
                      JOptionPane.showMessageDialog(null, "Please enter a valid adhaar number");    
                 }
       else if(panNo.length()<10 || panNo.length()>10)
              {
                  JOptionPane.showMessageDialog(null, "Please enter a valid PAN number");    

              }
        else  if (religion.isEmpty()
                    || category.isEmpty()
                    || income.isEmpty()
                    || seniorCitizen == null || seniorCitizen.isEmpty()
                    || eduacationQualification.isEmpty()
                    || occupation.isEmpty()
                    || existingAccount == null || existingAccount.isEmpty()
                    || panNo.isEmpty()
                    || adhaarNo.isEmpty())
                {
                    JOptionPane.showMessageDialog(null, "Please fill all the fields");
                }
                else
                {
                    if (applicationFormNo==null)   
                    {
                          JOptionPane.showMessageDialog(null, "Please fill Personal Details");
                    }
                    else
                    {
                        try
                        {
                             Conn conn2=new Conn();
                             String query2 = "insert into signUp2 values('" + applicationFormNo + "','" + religion + "','" + category + "','" + income + "','" + eduacationQualification + "','" + occupation + "','" + panNo + "','" + adhaarNo + "','" + seniorCitizen + "','" + existingAccount + "')";
                             conn2.s.executeUpdate(query2);
                
                            JOptionPane.showMessageDialog(null, "Data submitted successfully!");
                            setVisible(false);
                            new SignUp3();
                        }
                        catch(Exception e)
                        {
                                System.out.println(e);
                        }
                    }
                } 
            }
        }
    

    public static void main(String args[])
    {   
        new SignUp2();
    }
}
