
package bank.managment.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;

public class BalanceEnquiry extends JFrame implements ActionListener{
    JButton back;
    String pinnumber;
    BalanceEnquiry(String pinnumber){
        this.pinnumber=pinnumber;
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        back=new JButton("Back");
        back.setBounds(355,485,150,30);
        back.addActionListener(this);
        image.add(back);
        
        Conn con=new Conn();
        int balance=0;
        try{
            ResultSet rs=con.s.executeQuery("select * from bank where pin= '"+pinnumber+"'");
            while(rs.next()){
                if(rs.getString("type").equals("Deposit ")){
                    balance += Integer.parseInt(rs.getString("amount"));
                }else{
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }            
        }catch(Exception e){
            System.out.println(e);
        }
            
        JLabel text= new JLabel("Your current Account balance is Rs. "+balance);
        text.setBounds(170,300,400,30);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD,16));
        image.add(text);   
        
        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Transaction(pinnumber).setVisible(true);
    }
    
    public static void main(String args[]){
        new BalanceEnquiry("");
    }
    
}
