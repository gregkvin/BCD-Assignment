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
public class Course implements Serializable {
    private String ID;
    private String courseName;
    private String passingGrade;
    private String explanation;
    private String question;
    private String answer1;
    private String answer2;
    private String answer3;
    private String answer4;

    // Constructor
    public Course(String ID, String courseName, String passingGrade, String explanation, String question, String answer1, String answer2, String answer3, String answer4) {
        this.ID = ID;
        this.courseName = courseName;
        this.passingGrade = passingGrade;
        this.explanation = explanation;
        this.question = question;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.answer4 = answer4;
    }

    public String getID(){
        return ID;
    }
    
    public String getCourseName(){
        return courseName;
    }
    
    public String getPassingGrade(){
        return passingGrade;
    }
    
    public String getExplanation(){
        return explanation;
    }
    
    public String getQuestion(){
        return question;
    }
    
    public String getAnswer1(){
        return answer1;
    }
    
    public String getAnswer2(){
        return answer2;
    }
    
    public String getAnswer3(){
        return answer3;
    }
    
    public String getAnswer4(){
        return answer4;
    }
    
    @Override
    public String toString() {
        return ID + "|" + courseName + "|" + passingGrade + "|" + explanation + "|" +  question + "|" + answer1 + "|" + answer2 + "|" + answer3 + "|" + answer4;
    }
}