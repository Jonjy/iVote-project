/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.csupomona.cs356.iVote;

import edu.csupomona.cs356.iVote.libraries.*;
import java.util.Scanner;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.IOException;
/**
 *
 * @author Jon
 */
public class IVote {

    /**
     * the project is divided into 2 packages. The first which contains the
     * main serves as the basis for what can become the student user interface,
     * a portal where they can vote and see the results of the questions. 
     * The second package contains most of the backend work. Its divided into 2
     * primary classes. Question contains all of the data about the question 
     * and the voting. Teacher serves as an access point to write and manipulate
     * the question. 
     * 
     * The interfaces used in the design are set up in a way that they could be
     * used in any voting/polling scenario. The implementation of those 
     * interfaces is designed to shift the use to a class room setting
     * @param args
     */
    public static void main(String[] args){
        Admin creater= new teacher();
        
        Question grade = creater.createQuestion();
        
        grade.printQuestion();
        
        studentAccess(grade);
        
        grade.printOut();
        
    }
    
    /**
    * This method simulates a portal where students can login to vote
    * in a more complete implementation the login id could be handled 
    * through various methods, like ip address or device information
    * For the current set up all logins are accepted, and the login id number
    * is used as the tracking method for the votes
     * @param question
    */
    public static void studentAccess(Question question){
        
        try{
            InputStream fis = new FileInputStream("votes.txt");
            Scanner input = new Scanner(fis);
        
            while(input.hasNext()){
                int id = input.nextInt();
                Voter current = new Student(id);
                String answerChoice = input.nextLine();
            
                question.newVote(current.Voting(answerChoice));
            }
        }
        catch(IOException x) {
            System.out.println("Error reading file");                   
        }
    }
    
}
