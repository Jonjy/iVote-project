/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.csupomona.cs356.iVote.libraries;

/**
 * A Vote object consists of a selected answer, the voter id and the getter 
 * methods to retrieve these fields. The fields of the vote object cannot be 
 * changed once set. When a student changes their vote the whole object is 
 * overwritten. 
 * 
 */
public class Vote {
    private int id;
    private String choice;
    
    public Vote(int id, String choice){
        this.id=id;
        this.choice=choice;
    }
    
    protected int getID(){
        return id;
    }
    protected String getChoice(){
        return choice;
    }
      
}
