/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Class;

import java.io.Serializable;

/**
 *
 * @author putubgs
 */
public class Completion implements Serializable {
    private String credentialID;
    private String studentName;
    private String courseName;
    private String dateofCompletion;
    private String passingGrade;
    private String grade;
    private String approval;

    // Constructor
    public Completion(String credentialID, String studentName, String courseName, String dateofCompletion, String passingGrade, String grade, String approval) {
        this.credentialID = credentialID;
        this.studentName = studentName;
        this.courseName = courseName;
        this.dateofCompletion = dateofCompletion;
        this.passingGrade = passingGrade;
        this.grade = grade;
        this.approval = approval;
    }

    public String getCredentialID(){
        return credentialID;
    }
    
    public String getStudentName(){
        return studentName;
    }
    
    public String getCourseName(){
        return courseName;
    }
    
    public String getDateofCompletion(){
        return dateofCompletion;
    }
    
    public String getPassingGrade(){
        return passingGrade;
    }
    
    public String getGrade(){
        return grade;
    }
    
    public String getApproval(){
        return approval;
    }
    
    @Override
    public String toString() {
        return credentialID + "|" + studentName + "|" + courseName + "|" + dateofCompletion + "|" + passingGrade + "|" + grade + "|" + approval;
    }
}