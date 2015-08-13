/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.csupomona.cs356.iVote;
import edu.csupomona.cs356.iVote.libraries.Vote;

/**
 *
 * student is an implementation of the voter interface. Student stores the id of 
 * the current active student. The Voting method then creates a Vote object out 
 * an input answer and the students id.
 */
public class Student implements Voter{
    private int id;
    
    Student(int id){
       this.id=id;
    }
    
    @Override
    public Vote Voting (String answer){
        return new Vote(id, answer);
    }
    
}
