/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.csupomona.cs356.iVote;

import edu.csupomona.cs356.iVote.libraries.Vote;
/**
 * voter serves as an interface for any class that can create votes. The 
 * required method is a system to create said vote. If unlike student, voter 
 * has no designation for ids for alteration to anonymous voting
 * 
 */
public interface Voter {
    
    Vote Voting(String answer);
   
    
}
