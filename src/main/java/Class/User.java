/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Class;

import java.io.Serializable;

public class User implements Serializable {
    private String ID;
    private String username;
    private String fullName;
    private String password;
    private String gender;
    private String dateOfBirth;
    private String email;
    private int blockIndex;

    // Constructor
    public User(String ID, String username, String fullName, String password, String gender, String dateOfBirth, String email) {
        this.ID = ID;
        this.username = username;
        this.fullName = fullName;
        this.password = password;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
    }

    // Add getters and setters for each field here
    // ...
    
    public String getID(){
        return ID;
    }
    
    public void setID(String ID) {
        this.ID = ID;
    }
    
    public String getUsername(){
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getFullName(){
        return fullName;
    }
    
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    
    public String getPassword(){
        return password;
    }
    
    public void setPasword(String password) {
        this.password = password;
    }
    
    public String getGender(){
        return gender;
    }
    
    public void setGender(String gender) {
        this.gender = gender;
    }
    
    public String getDoB(){
        return dateOfBirth;
    }
    
    public void setDoB(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    
    public String getEmail(){
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    @Override
    public String toString() {
        return ID + "|" + username + "|" + fullName + "|" + password + "|" + gender + "|" + dateOfBirth + "|" + email;
    }
}

