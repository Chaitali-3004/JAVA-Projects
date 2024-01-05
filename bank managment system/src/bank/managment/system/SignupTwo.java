
package bank.managment.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener{
    
//    long random;
    JTextField panTextField,adhaarTextField;
    JRadioButton syes,sno,eyes,eno;
    JButton next;
    JComboBox riligon,category,income,education,occupation;
    String formno;
    
    SignupTwo(String formno){    
        this.formno=formno;
        
        setLayout(null);        
        
        setTitle("New Account Application Form - Page 2");
        
        JLabel additionalDetails= new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionalDetails.setBounds(290,80,400,30);
        add(additionalDetails);
        
        JLabel riligons= new JLabel("Riligion: ");
        riligons.setFont(new Font("Raleway", Font.BOLD, 22));
        riligons.setBounds(100,140,100,30);
        add(riligons);
        
        String valReligion[]={"Hindu","Muslim","Sikh","Christian", "Indian", "Other"};
        riligon=new JComboBox(valReligion);
        riligon.setBounds(300,140,400,30);
        riligon.setBackground(Color.WHITE);
        add(riligon);
        
        JLabel categories= new JLabel("Category: ");
        categories.setFont(new Font("Raleway", Font.BOLD, 22));
        categories.setBounds(100,190,200,30);
        add(categories);
        
        String valCategory[]={"General","OBC","SC", "ST", "Other"};
        category=new JComboBox(valCategory);
        category.setBounds(300,190,400,30);
        category.setBackground(Color.WHITE);
        add(category);
        
        JLabel incomes=  new JLabel("Income: ");
        incomes.setFont(new Font("Raleway", Font.BOLD, 22));
        incomes.setBounds(100,240,200,30);
        add(incomes);
        
        String incomeCategory[]={"Null","< 1,50,000","< 3,00,000", "< 5,00,000", "Upto 8,00,000", "> 8,00,000"};
        income=new JComboBox(incomeCategory);
        income.setBounds(300,240,400,30);
        income.setBackground(Color.WHITE);
        add(income);
        
        JLabel eQualification=  new JLabel("Educational: ");
        eQualification.setFont(new Font("Raleway", Font.BOLD, 22));
        eQualification.setBounds(100,290,200,30);
        add(eQualification);
        
        JLabel eQualification1=  new JLabel("Qualification: ");
        eQualification1.setFont(new Font("Raleway", Font.BOLD, 22));
        eQualification1.setBounds(100,315,200,30);
        add(eQualification1);
        
        String educationValues[]={"Non-Graduation","Graduate","Post-Graduate", "Doctrate", "Artist" ,"Others"};
        education=new JComboBox(educationValues);
        education.setBounds(300,315,400,30);
        education.setBackground(Color.WHITE);
        add(education);
        
        JLabel occu=  new JLabel("Occupation: ");
        occu.setFont(new Font("Raleway", Font.BOLD, 22));
        occu.setBounds(100,390,200,30);
        add(occu);
        
        String ocupationValues[]={"Salaried","Self-Employeed","Bussiness", "Student", "Retired" ,"Others"};
        occupation=new JComboBox(ocupationValues);
        occupation.setBounds(300,390,400,30);
        occupation.setBackground(Color.WHITE);
        add(occupation);
           
        JLabel pan=  new JLabel("PAN Number: ");
        pan.setFont(new Font("Raleway", Font.BOLD, 22));
        pan.setBounds(100,440,200,30);
        add(pan);
        
        panTextField= new JTextField();
        panTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        panTextField.setBounds(300,440,400,30);
        add(panTextField);
        
        JLabel adhaar=  new JLabel("Adhaar Number: ");
        adhaar.setFont(new Font("Raleway", Font.BOLD, 22));
        adhaar.setBounds(100,490,200,30);
        add(adhaar);
        
        adhaarTextField= new JTextField();
        adhaarTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        adhaarTextField.setBounds(300,490,400,30);
        add(adhaarTextField);
        
        JLabel state=  new JLabel("Senior Citizen: ");
        state.setFont(new Font("Raleway", Font.BOLD, 22));
        state.setBounds(100,540,200,30);
        add(state);
        
        syes=new JRadioButton("Yes");
        syes.setBounds(300,540,100,30);
        syes.setBackground(Color.WHITE);
        add(syes);
        
        sno=new JRadioButton("No");
        sno.setBounds(450,540,100,30);
        sno.setBackground(Color.WHITE);
        add(sno);
        
        ButtonGroup seniorgroup=new ButtonGroup();
        seniorgroup.add(syes);
        seniorgroup.add(sno);
        
        JLabel eaccount=  new JLabel("Existing Account: ");
        eaccount.setFont(new Font("Raleway", Font.BOLD, 22));
        eaccount.setBounds(100,590,200,30);
        add(eaccount);
        
        eyes=new JRadioButton("Yes");
        eyes.setBounds(300,590,100,30);
        eyes.setBackground(Color.WHITE);
        add(eyes);
        
        eno=new JRadioButton("No");
        eno.setBounds(450,590,100,30);
        eno.setBackground(Color.WHITE);
        add(eno);
        
        ButtonGroup existgroup=new ButtonGroup();
        existgroup.add(eyes);
        existgroup.add(eno);
        
        next= new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620,660,80,30);
        next.addActionListener(this);
        add(next);
        
        getContentPane().setBackground(Color.WHITE);
      
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        
        String sreligion=(String) riligon.getSelectedItem();
        String scategory=(String) category.getSelectedItem();
        String sincome=(String) income.getSelectedItem();
        String seducation=(String) education.getSelectedItem();
        String soccupation=(String) occupation.getSelectedItem();
        String seniorcitizen=null;
        if(syes.isSelected()){
            seniorcitizen="Yes";
        }else if(sno.isSelected()){
            seniorcitizen="No";
        }
        
        String existaccount=null;
        if(eyes.isSelected()){
            existaccount="Yes";
        }else if(eno.isSelected()){
            existaccount="No";
        }
        String span=panTextField.getText();
        String sadhaar=adhaarTextField.getText();
        
        try{
            Conn c= new Conn();
            String query= "insert into signuptwo values('"+formno +"', '" +sreligion +"', '"+scategory +"', '"+sincome +"', '"+seducation +"', '"+soccupation +"', '"+span +"', '"+sadhaar +"', '"+seniorcitizen +"', '"+existaccount + "' )" ;
            c.s.executeUpdate(query); 
            
            setVisible(false);
            new SignupThree(formno).setVisible(true);
            
        } catch(Exception e){
            System.out.println(e);
        }  
    }
    
    public static void main(String args[]){
        new SignupTwo("");
    }
}
