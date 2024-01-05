package bank.managment.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener{
    
    JButton hundread,five,thousand,twothousand,fivethousand,tenthousand,back;
    String pinnumber;
    
    FastCash(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text= new JLabel("SELECT WITHDRAWL AMOUNT");
        text.setBounds(215,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD,16));
        image.add(text);
        
        hundread=new JButton("Rs 100");
        hundread.setBounds(170,415,150,30);
        hundread.addActionListener(this);
        image.add(hundread);
        
        five=new JButton("Rs 500");
        five.setBounds(355,415,150,30);
        five.addActionListener(this);
        image.add(five);
        
        thousand=new JButton("Rs 1000");
        thousand.setBounds(170,450,150,30);
        thousand.addActionListener(this);
        image.add(thousand);
        
        twothousand=new JButton("Rs 2000");
        twothousand.setBounds(355,450,150,30);
        twothousand.addActionListener(this);
        image.add(twothousand);
        
        fivethousand=new JButton("Rs 5000");
        fivethousand.setBounds(170,485,150,30);
        fivethousand.addActionListener(this);
        image.add(fivethousand);
        
        tenthousand=new JButton("Rs 10000");
        tenthousand.setBounds(355,485,150,30);
        tenthousand.addActionListener(this);
        image.add(tenthousand);
        
        back=new JButton("BACK");
        back.setBounds(355,520,150,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.RED);
        back.addActionListener(this);
        image.add(back);
                
        setSize(900,900);
        setLocation(300,0);
//        setUndecorated(true);
        setVisible(true);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==back){
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }else {
            String amount=((JButton)ae.getSource()).getText().substring(3);
            Conn con=new Conn();
            try{
                ResultSet rs=con.s.executeQuery("select * from bank where pin= '"+pinnumber+"'");
                int balance=0;
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit ")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    }else{
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                
                if(ae.getSource() != back && balance<Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null,"Insufficiant Balance");
                    return;                    
                }
                
                Date date=new Date();
                String query="insert into bank values('"+pinnumber+"', '"+date+"', 'Withdrawl', '"+amount+"')";
                con.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs. "+amount+" Withdraw Successfully");
                
                setVisible(false);
                new Transaction(pinnumber).setVisible(true);
                
            }catch(Exception e){
                System.out.println(e);
            }
        }
    }
    
    public static void main(String args[]){
        new FastCash("");
    }
}
