/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.csupomona.cs356.iVote.libraries;
import java.util.LinkedList;
import java.util.List;

/**
 * Question serves a dual purpose of both holding the initial question
 * information and for store the vote data from the students. Most of the 
 * work for the program takes place here. The vote data is stored in a linked
 * list to allow easy searching and adding. Further the set() method is also
 * useful. 
 * 
 * Many of the methods in Question are protected to allow the teacher or other
 * admins to access and change the question while allowing student to only view
 * the question and submit votes
 */
public class Question {
    
    private String questionText;
    private String [][] answers;
    private final List<Vote> votes= new LinkedList();
    
    /**
     * Setter method to set text of the question that the class will see
     * @param questionText 
     */
    protected void writeQuestion(String questionText){
        this.questionText=questionText;
    }
    
    /**
     * Initializes array of answer choices, the array is divided into 2 columns
     * choices and text
     * the first column contains the allowed answer selections 
     * the second column contains the actual text associated with each
     *
     * @param count 
     */
    protected void makeAnswers(int count){
        answers= new String[count][2];
    }
    
    /**
     * This method sets the values of the answer array. It place each new 
     * option text pair into the array in order that it receive the pairs, 
     * assuming there is space left. If more pair are supplied than can be used
     * the extra pair are not inserted and are lost. 
     *
     * @param answerOption
     */
    protected void addAnswers(String answerOption, String answerText){
        int i =0;
        while( i <answers.length && answers[i][0]!= null){
            i++;
        }
        answers[i][0]=answerOption;
        answers[i][1]=answerText;
    }
    
    /**
     * This method checks to see if the newly received vote is from a student
     * that has already voted. If its a new student the vote is appended to the
     * end of the list. If the student has voted, the old vote is overwritten 
     * with the new one
     * @param add
     */
    public void newVote(Vote add){
        if( votes.isEmpty()){
            votes.add(add);
            return;
        }
        for(int i = 0; i<votes.size();i++){
            if(votes.get(i).getID()== add.getID()){
                votes.set(i, add);
                return;
            }
        } 
        votes.add(add);
    }
    
    /**
     * Prints out the question and the answer choices
     */
    public void printQuestion(){
        System.out.print(questionText);
        
        for(int i=0; i<answers.length; i++){
            System.out.print(answers[i][0]+")"+answers[i][1]+ '\t');
        }
        System.out.print('\n');
    }
    
    /**
     * Tallies the data from the list of votes. The data is then printed out in 
     * two ways. The first is the count of all the votes. The second is the 
     * count displayed in a bar ascii bar graph to allow for easy comparison of 
     * the totals 
     */
    public void printOut(){
        int[] results= new int[answers.length];
        
        //this section tallies the votes
        for(int i = 0; i<votes.size();i++){
            String current= votes.get(i).getChoice();
            
            for(int j=0; j<answers.length; j++){
                if(answers[j][0].equals(current))
                    results[j]++;
            }
        }
        
        //for loop prints out answer choice and number of votes
        for(int i=0; i<answers.length; i++){
            System.out.println(answers[i][0]+": " + results[i] );
        }
        
        
        //create an ascii bar graph of the vote tally
        for(int i=0; i<answers.length; i++){
            System.out.print('\n'+ answers[i][0]+"|" );
            
            for(int j=0; j<results[i]; j++){
                System.out.print('x');
            }
        }
    }
}
