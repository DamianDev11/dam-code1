
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignupThree extends JFrame implements ActionListener {
    
    JTextField pan,aadhar;
    JButton next;
    JRadioButton syes,sno,eyes,eno;
    JComboBox religion,category,occupation,education,income; //including function globally and not using for each parameter
    String formno;
    
    SignupThree(String formno){
        this.formno = formno;
        
        setLayout(null);        // to place text in appropriate position on frame or else it will place text on top
        
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");

        
        JLabel additionalDetails = new JLabel("Page no. 2 : Additional Details" );
        additionalDetails.setFont(new Font("Raleway",Font.BOLD,22));
        additionalDetails.setBounds(290, 80, 400, 30);
        add(additionalDetails);
        
        JLabel name = new JLabel("Religion : " );
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(100, 140, 100, 30);
        add(name);
        
        String valReligion[]={"HINDU","MUSLIM","CHRISTIAN","SIKH","OTHERS"};
        religion = new JComboBox(valReligion);        //create a dropbox function
        religion.setBounds(300, 140, 400, 30);
        religion.setBackground(Color.WHITE);
        add(religion);
        
        JLabel fname = new JLabel("Category : " );
        fname.setFont(new Font("Raleway",Font.BOLD,20));
        fname.setBounds(100, 190, 200, 30);
        add(fname);
        
        String valcategory[]={"GENERAL","ST","SC","OBC","OTHERS"};
        category = new JComboBox(valcategory);
        category.setBounds(300, 190, 400, 30);
        category.setBackground(Color.WHITE);
        add(category);
        
        JLabel dob = new JLabel("Income : " );
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        dob.setBounds(100, 240, 200, 30);
        add(dob);
        
        String incomecateogory[]={"NILL","< 1,50,000","< 2,50,000","< 5,00,000","upto 10,00,000"};
        income = new JComboBox(incomecateogory);
        income.setBounds(300, 240, 400, 30);
        income.setBackground(Color.WHITE);
        add(income);
        
        JLabel gender = new JLabel("Educational" );
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        gender.setBounds(100, 295, 200, 30);
        add(gender);
        
        
        JLabel email = new JLabel("Qualification : " );
        email.setFont(new Font("Raleway",Font.BOLD,20));
        email.setBounds(100, 320, 200, 30);
        add(email);
        
        String educationValues[]={"Non-Graduate","Graduate","Post-Graduate","Doctorate","Others"};
        education = new JComboBox(educationValues);
        education.setBounds(300, 315, 400, 30);
        education.setBackground(Color.WHITE);
        add(education);
        
        JLabel marital = new JLabel("Occupation : " );
        marital.setFont(new Font("Raleway",Font.BOLD,20));
        marital.setBounds(100, 390, 200, 30);
        add(marital);
        
        String occupationValues[]={"Salaried","Self-employed","Businessman","Student","Retired","Others"};
        occupation = new JComboBox(occupationValues);
        occupation.setBounds(300, 390, 400, 30);
        occupation.setBackground(Color.WHITE);
        add(occupation); 
        
        JLabel address = new JLabel("PAN Number : " );
        address.setFont(new Font("Raleway",Font.BOLD,20));
        address.setBounds(100, 440, 200, 30);
        add(address);
        
        pan= new JTextField();
        pan.setFont(new Font("Raleway",Font.BOLD,14));
        pan.setBounds(300, 440, 400, 30);
        add(pan);
        
        JLabel city = new JLabel("Aadhar Number : " );
        city.setFont(new Font("Raleway",Font.BOLD,20));
        city.setBounds(100, 490, 200, 30);
        add(city);
        
        aadhar= new JTextField();
        aadhar.setFont(new Font("Raleway",Font.BOLD,14));
        aadhar.setBounds(300, 490, 400, 30);
        add(aadhar);
        
        JLabel State = new JLabel("Senior Citizen : " );
        State.setFont(new Font("Raleway",Font.BOLD,20));
        State.setBounds(100, 540, 200, 30);
        add(State);
        
        syes = new JRadioButton("Yes");
        syes.setBounds(300, 540, 100, 30);
        syes.setBackground(Color.WHITE);
        add(syes);
        
        sno = new JRadioButton("No");
        sno.setBounds(450, 540, 100, 30);
        sno.setBackground(Color.WHITE);
        add(sno);
        
        ButtonGroup maritalgroup = new ButtonGroup();
        maritalgroup.add(syes);
        maritalgroup.add(sno);
        
        JLabel pincode = new JLabel("Existing account ? " );
        pincode.setFont(new Font("Raleway",Font.BOLD,20));
        pincode.setBounds(100, 590  , 200, 30);
        add(pincode);
        
        eyes = new JRadioButton("Yes");
        eyes.setBounds(300, 590, 100, 30);
        eyes.setBackground(Color.WHITE);
        add(eyes);
        
        eno = new JRadioButton("No");
        eno.setBounds(450, 590, 100, 30);
        eno.setBackground(Color.WHITE);
        add(eno);
        
        ButtonGroup existgroup = new ButtonGroup();
        existgroup.add(eyes);
        existgroup.add(eno);
        
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(620,660,80,30);
        next.addActionListener(this);
        add(next);
        
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(850,800);       //create frame or window
        setLocation(350,10);            
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){    //enter value into dbs action
        String sreligion = (String)religion.getSelectedItem();      //to take dropdown options as string
        String scategory = (String)category.getSelectedItem();
        String sincome = (String)income.getSelectedItem();
        String seducation=(String)education.getSelectedItem();
        String soccupation=(String)occupation.getSelectedItem();
        String seniorcitizen = null;
        if(syes.isSelected()){
            seniorcitizen = "Yes";
        }else if(sno.isSelected()){
            seniorcitizen="No";
        }
        
        String existingaccount = null;
        if(eyes.isSelected()){
            existingaccount = "Yes";
        }else if(eno.isSelected()){
            existingaccount = "No";
        }
        
        String span= pan.getText();
        String saadhar= aadhar.getText();//to pull string directly from text fields
        
        try {
                Conn c = new Conn();
                String query = "insert into signupthree values('"+formno+"', '"+sreligion+"', '"+scategory+"', '"+sincome+"', '"+seducation+"', '"+soccupation+"', '"+span+"', '"+saadhar+"', '"+seniorcitizen+"', '"+existingaccount+"')"; 
                c.s.executeUpdate(query);
                
           //signup3 object     
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public static void main(String args[]){
        new SignupThree("");
    }
    
}
