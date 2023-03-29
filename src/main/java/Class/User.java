/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Class;

import java.io.Serializable;

public class User implements Serializable {
    private String username;
    private String fullName;
    private String password;
    private String gender;
    private String dateOfBirth;
    private String email;
//    private String publicKey;
//    private String hashOfCertificate;
//    private boolean validatorStatus;

    // Constructor
    public User(String username, String fullName, String password, String gender, String dateOfBirth, String email) {
        this.username = username;
        this.fullName = fullName;
        this.password = password;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
//        this.publicKey = publicKey;
//        this.hashOfCertificate = hashOfCertificate;
//        this.validatorStatus = validatorStatus;
    }

    // Add getters and setters for each field here
    // ...
    
    public String getUsername(){
        return username;
    }
    
    public String getFullName(){
        return fullName;
    }
    
    public String getPassword(){
        return password;
    }
    
    public String getGender(){
        return gender;
    }
    
    public String getDoB(){
        return dateOfBirth;
    }
    
    public String getEmail(){
        return email;
    }
    
    @Override
    public String toString() {
        return username + "|" + fullName + "|" + password + "|" + gender + "|" + dateOfBirth + "|" + email;
    }
}

