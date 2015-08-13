/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.csupomona.cs356.iVote.libraries;

import java.io.*;
import java.util.Scanner;

/**
 * The teacher class exists to serve as an interface to allow a teacher or ta
 * to design the question. For this simulation implementation of the voting
 * system this is automated by a read file. In an actual implementation this 
 * would serve as the base for a user interface.
 * 
 */
public class teacher implements Admin {
    
    @Override
    public Question createQuestion(){
        Question grade = new Question();
        try{
            InputStream fis = new FileInputStream("inputs.txt");
            Scanner input = new Scanner(fis);
            String text = input.nextLine();
            grade.writeQuestion(text);
        
            int answerCount = input.nextInt();
        
            grade.makeAnswers(answerCount);
        
            for(int i = 0; i< answerCount; i++){
                String answerOption= input.nextLine();
                text=input.nextLine();
            
                grade.addAnswers(answerOption, text);              
            }
        }
        catch(IOException x) {
            System.out.println("Error reading file");                   
        }
        return grade;
    }
}
