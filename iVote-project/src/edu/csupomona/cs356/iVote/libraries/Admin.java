/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.csupomona.cs356.iVote.libraries;

/**
 * Admin is the designated interface for any class that has access to create 
 * questions. Its the highest level of access for running the program
 * 
 */
public interface Admin {
    
    Question createQuestion();
}
