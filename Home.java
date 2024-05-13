package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

public class Home extends JFrame implements ActionListener{

    public Home() {
        setLayout(null);
        setTitle("Welfare Bank - Home");
        setSize(800, 600);
        setLocation(340, 100);

        // Adding background image
        ImageIcon bg1 = new ImageIcon(ClassLoader.getSystemResource("icons/banking1.jpg"));
        Image bgsize = bg1.getImage().getScaledInstance(1130, 790, Image.SCALE_DEFAULT);
        ImageIcon bg2 = new ImageIcon(bgsize);

// Create a JLabel with a transparent background
        JLabel l = new JLabel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g.create();

                // Set the transparency level (0.5f is 50% transparent, you can adjust this)
                float alpha = 0.8f;
                g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));

                // Draw the image
                g2.drawImage(bg2.getImage(), 0, 0, getWidth(), getHeight(), this);
                g2.dispose();
            }
        };

        l.setBounds(0, 0, 1000, 780);
        add(l);
        Color c1 = new Color(12, 63, 112);
        Color c2 = new Color(3, 25, 45);

        // Code for adding logo 
        ImageIcon ic1 = new ImageIcon(ClassLoader.getSystemResource("icons/welfareBankLogo2.png"));
        Image i1 = ic1.getImage().getScaledInstance(130, 50, Image.SCALE_DEFAULT);
        ImageIcon ic2 = new ImageIcon(i1);
        JLabel l1 = new JLabel(ic2);
        l1.setBounds(130, 155, 150, 50);
//        l.add(l1);

        JLabel heading = new JLabel("WELCOME ");
        heading.setFont(new Font("BastamanBold", Font.BOLD, 54));
        heading.setForeground(c2);
        heading.setBackground(new Color(0, 0, 0, 0));
        heading.setBounds(250, 120, 500, 52);
        heading.setOpaque(true);
        l.add(heading);

        JLabel heading2 = new JLabel("TO");
        heading2.setFont(new Font("BastamanBold", Font.BOLD, 54));
        heading2.setForeground(c2);
        heading2.setBackground(new Color(0, 0, 0, 0));
        heading2.setBounds(360, 190, 500, 52);
        heading2.setOpaque(true);
        l.add(heading2);

        JLabel heading3 = new JLabel("WELFARE BANK");
        heading3.setFont(new Font("BastamanBold", Font.BOLD, 54));
        heading3.setForeground(c2);
        heading3.setBackground(new Color(0, 0, 0, 0));
        heading3.setBounds(200, 250, 500, 52);
        heading3.setOpaque(true);
        l.add(heading3);

        JMenuBar mb = new JMenuBar();

        // Login
        JMenu LoginM = new JMenu("Login");
        LoginM.setForeground(c1);
        LoginM.setFont(new Font("Calibri", Font.BOLD, 20));
        mb.add(LoginM);
        LoginM.addMenuListener(new MenuListener() {
    @Override
    public void menuSelected(MenuEvent e) {
        Login loginWindow = new Login();
        loginWindow.requestFocus(); 
    }
@Override
    public void menuDeselected(MenuEvent e) {

    }

    @Override
    public void menuCanceled(MenuEvent e) {
       
    }

});

        // SignUp
        JMenu SignUpM = new JMenu("Sign Up");
        SignUpM.setForeground(c1);
        SignUpM.setFont(new Font("Calibri", Font.BOLD, 20));
        mb.add(SignUpM);
    SignUpM.addMenuListener(new MenuListener() {
    @Override
    public void menuSelected(MenuEvent e) {
        SignUp1 signWindow = new SignUp1();
        signWindow.requestFocus(); 
    }
@Override
    public void menuDeselected(MenuEvent e) {
        
    }

    @Override
    public void menuCanceled(MenuEvent e) {
       
    }

});

        // Utility
        JMenu UtilityM = new JMenu("Utility");
        UtilityM.setForeground(c1);
        UtilityM.setFont(new Font("Calibri", Font.BOLD, 20));
        mb.add(UtilityM);

        JMenuItem notepad = new JMenuItem("Notepad");
        notepad.setBackground(Color.WHITE);
        notepad.setForeground(c1);
        notepad.setFont(new Font("Calibri", Font.BOLD, 18));
        notepad.addActionListener(this);
        UtilityM.add(notepad);

        JMenuItem calc = new JMenuItem("Calculator");
        calc.setBackground(Color.WHITE);
        calc.setForeground(c1);
        calc.setFont(new Font("Calibri", Font.BOLD, 18));
        calc.addActionListener(this);
        UtilityM.add(calc);

        // Exit
        JMenu ExitM = new JMenu("Exit");
        ExitM.setForeground(c1);
        ExitM.setFont(new Font("Calibri", Font.BOLD, 20));
        mb.add(ExitM);
        ExitM.addMenuListener(new MenuListener() {
    @Override
    public void menuSelected(MenuEvent e) {
        System.exit(0); 
    }
@Override
    public void menuDeselected(MenuEvent e) {

    }

    @Override
    public void menuCanceled(MenuEvent e) {
       
    }

});
        
        setJMenuBar(mb);
        
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String msg = ae.getActionCommand();

        if (msg.equals("Calculator")) {
            try {
                ProcessBuilder processBuilder = new ProcessBuilder("C:\\Windows\\System32\\calc.exe");
                processBuilder.start();
            } catch (Exception e) {
                System.out.println(e);
            }
        } else if (msg.equals("Notepad")) {
            try {
                ProcessBuilder processBuilder = new ProcessBuilder("C:\\Windows\\System32\\notepad.exe");
                processBuilder.start();

            } catch (Exception e) {
                System.out.println(e);
            }
        } 
       

    }

    public static void main(String args[]) {
        new Home();
    }
}
