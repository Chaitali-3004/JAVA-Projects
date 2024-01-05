package bank.managment.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    
    JButton login, clear, signup,back;
    JTextField cardTextField;
    JPasswordField PinField;
    
    Login(){
        
        setTitle("AUTOMATED TELLER MACHINE");
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(100, 30, 100,100);
        add(label);
        
        JLabel text= new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward", Font.BOLD, 38));
        text.setBounds(250, 60, 400, 40);
        add(text);
        
        JLabel cardno= new JLabel("Card No.: ");
        cardno.setFont(new Font("Raleway", Font.BOLD, 28));
        cardno.setBounds(150, 170, 200, 40);
        add(cardno);
        
        cardTextField= new JTextField();
        cardTextField.setBounds(300,170,250,40);
        cardTextField.setFont(new Font("Arial", Font.BOLD,14 ));
        add(cardTextField);
        
        JLabel pin= new JLabel("PIN: ");
        pin.setFont(new Font("Raleway", Font.BOLD, 28));
        pin.setBounds(150, 240, 300, 40);
        add(pin);
        
        PinField= new JPasswordField();
        PinField.setBounds(300,240,250,40);
        PinField.setFont(new Font("Arial", Font.BOLD,14 ));
        add(PinField);
        
        login=new JButton("SIGN IN");
        login.setBounds(300, 330, 100, 40);
//        login.setBackground(Color.black);
//        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);
        
        clear=new JButton("CLEAR");
        clear.setBounds(450, 330, 100, 40);
        clear.addActionListener(this);
        add(clear);
        
        signup=new JButton("SIGN UP");
        signup.setBounds(300, 400, 100, 40);
        signup.addActionListener(this);
        add(signup);
        
        back=new JButton("BACK");
        back.setBounds(450, 400, 100, 40);
        back.addActionListener(this);
        add(back);

        getContentPane().setBackground(Color.GRAY);
        
        setSize(800,480);
        setVisible(true);
        setLocation(350,200);
  
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==clear){  
            cardTextField.setText("");
            PinField.setText("");
        }else if(ae.getSource()==login){
            Conn conn=new Conn();
            String cardnumber=cardTextField.getText();
            String pinnumber=PinField.getText();
            String query="select * from login where cardnumber= '"+cardnumber+"' and pinnumber='"+pinnumber+"'";
            try{
                ResultSet rs= conn.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Transaction(pinnumber).setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Incorrect Card number or PIN");
                }
                
            }catch (Exception e){
                System.out.println(e);
            }
            
        }else if(ae.getSource()==signup){
            setVisible(false);
            new SignupOne().setVisible(true);
        }else if(ae.getSource()==back){
            System.exit(0);
        }
    }
    
    public static void main(String args[]){
        new Login();
    }   
}
