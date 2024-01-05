
package bank.managment.system;

import java.sql.*;

public class Conn {
    
    Connection c;
    Statement s;
    
    public Conn(){
        try {
//            Class.forName(com.mysql.cj.jdbc.Driver); // No need to register this now cause the java itself can pick it

            c= DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem", "root", "toor123");
            s=c.createStatement();
            
        }catch(Exception e) {
            System.out.println(e);
        }
    }
}


/*
package bank.managment.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Deposit {
    
    
    
    public static void main(String args[]){
        new Deposit();
    }
}
*/

/*
try{

}catch(Exception e){
    System.out.println(e);
}
*/