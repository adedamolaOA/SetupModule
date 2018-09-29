/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ontrac;

import com.ontrac.locations.Area11;
import com.ontrac.locations.Guzape;
import com.ontrac.utlis.MainProcessor;
import com.ontrac.utlis.SetUpEntityManagerFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Adedamola
 */
public class SetupModule {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Load Display Information from MainProcess class
        MainProcessor.info();
        
        //Retrive user input and process selected action from MainProcess class
        MainProcessor.processSelection();
        
        // Close all open connections
        SetUpEntityManagerFactory.close();

    } 
    

}
