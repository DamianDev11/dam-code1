package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    
    JButton login,sign_up,clear;
    JTextField cardTextField;
    JPasswordField pinTextField;        //hide entered characters in pin textboxin cas
    
    Login(){
        
        setTitle("AUTOMATED TELLER MACHINE");
        
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("ICONS/logo.png"));
        Image i2=i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        
        ImageIcon i3= new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70, 10, 100, 100);
        add(label);
        
        JLabel text = new JLabel("WELCOME TO THE ATM");
        text.setFont(new Font("Osward",Font.BOLD,38));
        text.setBounds(200,40,600,40);      /*where to show text on frame*/
        add(text);
        
        JLabel card_no = new JLabel("Card no.");
        card_no.setFont(new Font("Raleway",Font.BOLD,28));
        card_no.setBounds(150,150,400,30);      /*where to show text on frame*/
        add(card_no);
        
        cardTextField = new JTextField();
        cardTextField.setBounds(300,150,230,30);
        cardTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(cardTextField);
        
        JLabel pin = new JLabel("PIN");
        pin.setFont(new Font("Raleway",Font.BOLD,28));
        pin.setBounds(150,220,250,30);      /*where to show text on frame*/
        add(pin);
        
        pinTextField = new JPasswordField();
        pinTextField.setBounds(300,220,230,30);
        pinTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(pinTextField);
        
        login = new JButton("SIGN IN");
        login.setBounds(300,300,100,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);      //for some action after button click
        add(login);
        
        clear = new JButton("CLEAR");
        clear.setBounds(430,300,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);      //for some action after button click
        add(clear );
        
        sign_up = new JButton("SIGN UP");
        sign_up.setBounds(300,350,230,30);
        sign_up.setBackground(Color.BLACK);
        sign_up.setForeground(Color.WHITE);
        sign_up.addActionListener(this);        //for some action after button click
        add(sign_up );
        
        getContentPane().setBackground(Color.WHITE);
        
        
        setSize(800,480);
        setVisible(true);           //to make frame visible
        setLocation(350,200);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==clear){
            cardTextField.setText("");      //clear texts in field after clicking on button
            pinTextField.setText("");       //"" 
            
        }else if(ae.getSource()==login){
            Conn conn = new Conn();
            String cardnumber = cardTextField.getText();
            String pinnumber = pinTextField.getText();
            String query = "select * from login where cardnumber = '"+cardnumber+"' and pin = '"+pinnumber+"'";
            try {
                ResultSet rs = conn.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null,"Incorrect Card Number or PIN");
                }
            } catch(Exception e){
                System.out.println(e);
            }
            
        }else if(ae.getSource()==sign_up){
            setVisible(false);                     //closes login screen after clicking on button
            new SignupTwo().setVisible(true);       //opens signup page
        }
        
    }
    
    
    public static void main(String args[]){
        new Login();
    }
    
}
