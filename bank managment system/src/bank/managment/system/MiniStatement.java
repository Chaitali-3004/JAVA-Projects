
package bank.managment.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;

public class MiniStatement extends JFrame{
    
    MiniStatement(String pinnumber){
        
        setTitle("Mini Statement");
        
        setLayout(null);
        
        JLabel mini=new JLabel();
        mini.setBounds(20,140,400,200);
        add(mini);
        
        JLabel bank=new JLabel("Indian Bank");
        bank.setBounds(150,20,100,20);
        add(bank);
        
        JLabel card=new JLabel();
        card.setBounds(20,80,300,20);
        add(card);
        
        JLabel balance=new JLabel();
        balance.setBounds(20,400,300,20);
        add(balance);
        
        try{
            Conn con=new Conn();
            ResultSet rs=con.s.executeQuery("select * from login where pinnumber= '"+pinnumber+"'");
            while(rs.next()){
                card.setText("Card Number: "+rs.getString("cardnumber").substring(0,4)+"-XXXX-XXXX-"+rs.getString("cardnumber").substring(12));
            }
        }catch(Exception e){
            System.out.println(e);
        }
        
        try{
            Conn con=new Conn();
            int bal=0;
            ResultSet rs=con.s.executeQuery("select * from bank where pin= '"+pinnumber+"'");//"+pinnumber+"
            while(rs.next()){
                mini.setText(mini.getText()+"<html>"+ rs.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ rs.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ rs.getString("amount")+"<br><br><html>");
                if(rs.getString("type").equals("Deposit ")){
                    bal += Integer.parseInt(rs.getString("amount"));
                }else{
                    bal -= Integer.parseInt(rs.getString("amount"));
                }
            }
            balance.setText("Your Current Account balance is Rs. "+bal);
        }catch(Exception e){
            System.out.println(e);
        }
        
        
        setSize(400,600);
        getContentPane().setBackground(Color.WHITE);
        setLocation(20,20);
        setVisible(true);
    }
    
    public static void main(String args[]){
        new MiniStatement("");
    }
}
