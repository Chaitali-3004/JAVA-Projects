package bank.managment.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener{
    
    JPasswordField pinfeild,repinfeild;
    JButton change, back;
    String pinnumber;
    
    PinChange(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text= new JLabel("Change your PIN");
        text.setBounds(250,300,500,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD,16));
        image.add(text);
        
        JLabel pintext= new JLabel("New PIN:");
        pintext.setBounds(165,350,180,25);
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("System", Font.BOLD,16));
        image.add(pintext);
        
        pinfeild= new JPasswordField();
        pinfeild.setBounds(330,350,180,25);
        pinfeild.setFont(new Font("Arial", Font.BOLD,22 ));
        add(pinfeild);
        
        JLabel repintext= new JLabel("Re-enter New PIN:");
        repintext.setBounds(165,390,180,25);
        repintext.setForeground(Color.WHITE);
        repintext.setFont(new Font("System", Font.BOLD,16));
        image.add(repintext);
        
        repinfeild= new JPasswordField();
        repinfeild.setBounds(330,390,180,25);
        repinfeild.setFont(new Font("Arial", Font.BOLD,22 ));
        add(repinfeild);
        
        change=new JButton("CHANGE");
        change.setBounds(355,485,150,30);
        change.addActionListener(this);
        image.add(change);
        
        back=new JButton("BACK");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);
        
        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==change){
            try{
                String npin=pinfeild.getText();
                String rpin=repinfeild.getText();
                
                if(!npin.equals(rpin)){
                    JOptionPane.showMessageDialog(null,"Entered PIN does not match");
                    return; 
                }
                
                if(npin.equals("")){
                    JOptionPane.showMessageDialog(null,"Please enter the new PIN");
                    return; 
                }
                
                if(rpin.equals("")){
                    JOptionPane.showMessageDialog(null,"Please re-enter the new PIN");
                    return; 
                }
                
                Conn con=new Conn();
                String query1="update bank set pin ='"+rpin+"' where pin= '"+pinnumber+"'";
                String query2="update login set pinnumber ='"+rpin+"' where pinnumber= '"+pinnumber+"'";
                String query3="update signupthree set pinnumber ='"+rpin+"' where pinnumber= '"+pinnumber+"'";

                con.s.executeUpdate(query1);
                con.s.executeUpdate(query2);
                con.s.executeUpdate(query3);
                
                JOptionPane.showMessageDialog(null,"PIN changed successfully");
                
                setVisible(false);
                new Transaction(rpin).setVisible(true);
                
            }catch(Exception e){
                System.out.println(e);
            }
        }else{
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }
    }
    
    public static void main(String args[]){
        new PinChange("").setVisible(true);
    }
}
