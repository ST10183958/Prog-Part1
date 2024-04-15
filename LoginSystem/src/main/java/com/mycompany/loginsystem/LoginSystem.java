
package com.mycompany.loginsystem;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import static javax.swing.JOptionPane.showMessageDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;  



public class LoginSystem extends JPanel{ 

    public static void main(String[] args) {
        
        JFrame f=new JFrame();
        JTextField AccountName;
        
        JLabel MainText;
        
        MainText = new JLabel("Enter Details");
        MainText.setBounds(150,1,500,30);
        f.add(MainText);
        

        
        // Username //
        JLabel AccountNameLabel = new JLabel("Username:");
        AccountNameLabel.setBounds(10,100, 200,30); 
        f.add(AccountNameLabel);
        
        
        AccountName = new JTextField( 16);
        AccountName.setBounds(100,100, 200,30); 
        f.add(AccountName);
        // Username //
        
        // Password //
        JLabel PasswordLabel = new JLabel("Password:");
        PasswordLabel.setBounds(10,150, 200,30); 
        f.add(PasswordLabel);
        
        JTextField Password;
        Password = new JTextField( 16);
        Password.setBounds(100,150, 200,30); 
        f.add(Password);
        // Username //
        
        // Buttons //
        JButton SignInButton=new JButton("Sign In");
        SignInButton.setBounds(20,200,100, 40);
        f.add(SignInButton);
        
        JButton SignUpButton=new JButton("Sign Up");
        SignUpButton.setBounds(120,200,100, 40);
        f.add(SignUpButton);
        // Buttons //
        
        // Sign up Event //
        SignInButton.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){
               
                // Username //
                String AccountInput1 = AccountName.getText();
                boolean AccountInput2 = UsernameVerification(AccountInput1);
                
                // Password //
                String PasswordInput1 = Password.getText();
                boolean PasswordInput2 = PasswordVerification(PasswordInput1);
                
                if(AccountInput2==true && PasswordInput2==true) {
                    LoginSuccessful();
            }
            }  
        });  
        // Sign up Event //
        
        f.setSize(400,500);
        f.setLayout(null);
        f.setVisible(true);
    }
    
    
    // Verifying if requirements for username are met //
     public static boolean UsernameVerification(String AccountInput) {
         boolean SizeMet = false;
         boolean UnderscoreMet = false;
         boolean finalOutput = false;
         
         if(AccountInput.length() > 5) {
             SizeMet = false;
         } else{
             SizeMet = true;
         }
         
         if(AccountInput.contains("_")) {
             UnderscoreMet = true;
         } else {
             UnderscoreMet = false;
         }
         
         if(SizeMet == true && UnderscoreMet==true) {
             finalOutput = true;
         } 
         if(SizeMet == false && UnderscoreMet == false){
             finalOutput = false;
             UsernameConditionsAlert(SizeMet,UnderscoreMet);
         }else {
             
         }
          //UsernameConditionsAlert();
         return finalOutput;
     }
     // Verifying if requirements for username are met //

     // Verifying if requirements for username are met //
     public static boolean PasswordVerification(String PasswordInput) {
        boolean PasswordCondition = false;
        boolean PasswordSize = false;
        boolean CapitalLetter = false;
        boolean HasNumber = false;
        boolean HasSpecialCharacter = false;
        boolean AllConditionsMet = false;
        
        boolean[] expected = { false, false, false, false, false };
        
        // Password length //
        if(PasswordInput.length() > 8) {
            PasswordSize = true;
        }if(PasswordInput.length() < 8) {
            PasswordSize = false;           
        }
        
        if(PasswordSize == true) {
           // PasswordCondition = "Password accepted";
        }if(PasswordSize == false) {
           // PasswordCondition = "Password Denied";
        }
        // Password length //
  
        
       // Contains a capital letter //
       CapitalLetter = hasCapitalLetter(PasswordInput);
       
       if(CapitalLetter == true) {
          // PasswordCondition = "Password has capital letter";
       }if(CapitalLetter == false) {
          // PasswordCondition = "Password does not have capital letter";
       }
       
       // Contains a capital letter //
       
       // Function to detect if password has an integer // 
        for (char c : PasswordInput.toCharArray()) {
            if (Character.isDigit(c)) {
                HasNumber = true;
                break;
            }
        }
       
       // Function to detect if password has an integer // 
       
       
       // Function to detect if password has a special character // 
        if (PasswordInput.matches(".*[^a-zA-Z0-9 ].*")) {
            HasSpecialCharacter = true;
        } else {
            HasSpecialCharacter = false;
        }
       // Function to detect if password has a special character // 
     
       if(PasswordSize==true && CapitalLetter==true && HasNumber==true && HasSpecialCharacter==true) {
           PasswordCondition = true;
       }else{
           PasswordCondition = false;
           PasswordConditionsAlert(PasswordSize,CapitalLetter,HasNumber,HasSpecialCharacter);
       }
       
        
        return PasswordCondition;
     }
     
     
    // Method to loop through String to detect if there is a capital letter // 
    public static boolean hasCapitalLetter(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (Character.isUpperCase(str.charAt(i))) {
                return true;
            }
        }
        return false;
    }
    // Method to loop through String to detect if there is a capital letter // 

     // Verifying if requirements for username are met //
    
    // Username Alert box //
    public static void UsernameConditionsAlert(boolean SizeMet, boolean UnderscoreMet) {
        JFrame f=new JFrame();
        
        JLabel Title;
        JLabel  SizeMetLabel;
        JLabel UnderscoreMetLabel;

        Title = new JLabel("Username conditions not met");
        Title.setBounds(10,80, 500,30);
        Title.setFont(new Font("Serif", Font.PLAIN, 25));
        f.add(Title);
        
        SizeMetLabel = new JLabel("Username is longer than 5 characters");
        SizeMetLabel.setBounds(10,200, 500,30);
        SizeMetLabel.setFont(new Font("Serif", Font.PLAIN, 15));
        f.add(SizeMetLabel);
        
        UnderscoreMetLabel = new JLabel("The Username does not contain an underscore");
        UnderscoreMetLabel.setBounds(10,220, 500,30);
        UnderscoreMetLabel.setFont(new Font("Serif", Font.PLAIN, 15));
        f.add(UnderscoreMetLabel);
        
        
        JButton CloseButton=new JButton("Close");  
        CloseButton.setBounds(100,340,95,30);  
        f.add(CloseButton);  
        
        CloseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
               f.dispose();
            }
        });

        if(SizeMet == true) {
            SizeMetLabel.setText("Username size is accepted");
        }
        if(UnderscoreMet == true) {
            SizeMetLabel.setText("Username contains an underscore");
        }
 
        
        f.setSize(400,500);
        f.setLayout(null);
        f.setVisible(true);
    }
    // Username Alert box //
    
    // Password alert box //
    public static void PasswordConditionsAlert(boolean PasswordSize,boolean CapitalLetter, boolean HasNumber, boolean HasSpecialCharacter) {
        JFrame f=new JFrame();
        
        JLabel Title;
        JLabel PasswordSizeLabel;
        JLabel CapitalLetterLabel;
        JLabel HasNumberLabel;
        JLabel HasSpecialCharacterLabel;
        Title = new JLabel("Password conditions not met");
        Title.setBounds(10,80, 500,30);
        Title.setFont(new Font("Serif", Font.PLAIN, 25));
        f.add(Title);
        
        PasswordSizeLabel = new JLabel("Password size is to small");
        PasswordSizeLabel.setBounds(10,200, 500,30);
        PasswordSizeLabel.setFont(new Font("Serif", Font.PLAIN, 15));
        f.add(PasswordSizeLabel);
        
        CapitalLetterLabel = new JLabel("Password does not have a capital letter");
        CapitalLetterLabel.setBounds(10,220, 500,30);
        CapitalLetterLabel.setFont(new Font("Serif", Font.PLAIN, 15));
        f.add(CapitalLetterLabel);
        
        HasNumberLabel = new JLabel("Password Does not have an integer");
        HasNumberLabel.setBounds(10,240, 500,30);
        HasNumberLabel.setFont(new Font("Serif", Font.PLAIN, 15));
        f.add(HasNumberLabel);
        
        HasSpecialCharacterLabel = new JLabel("Password doess not have a special character");
        HasSpecialCharacterLabel.setBounds(10,260, 500,30);
        HasSpecialCharacterLabel.setFont(new Font("Serif", Font.PLAIN, 15));
        f.add(HasSpecialCharacterLabel);
        
        
        JButton CloseButton=new JButton("Close");  
        CloseButton.setBounds(100,340,95,30);  
        f.add(CloseButton); 
        
        CloseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
               f.dispose();
            }
        });
        

        if(PasswordSize == true) {
            PasswordSizeLabel.setText("Password Size is accepted");
        }
        
        if(CapitalLetter == true) {
            CapitalLetterLabel.setText("Password has Capital letter");
        }
                
        if(HasNumber == true) {
            HasNumberLabel.setText("Password has an integer");
        }
                        
         if(HasSpecialCharacter == true) {
            HasSpecialCharacterLabel.setText("Password has a special character");
        }
        
        
        f.setSize(400,500);
        f.setLayout(null);
        f.setVisible(true);
    }
    // Password alert box //
    
    
    public static void LoginSuccessful() {
        JFrame f=new JFrame();
        
        JLabel Msg;  
        Msg=new JLabel("you have been signed in");  
        Msg.setBounds(50,50, 500,30); 
        Msg.setFont(new Font("Serif", Font.PLAIN, 20));
        f.add(Msg);
        
        f.setSize(400,500);
        f.setLayout(null);
        f.setVisible(true);
    }
    
}
