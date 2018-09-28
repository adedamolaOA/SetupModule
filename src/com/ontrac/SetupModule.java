/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ontrac;

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
    //Initialize Entity Manager Factory : SetupModulePU
    EntityManagerFactory emf =   Persistence.createEntityManagerFactory("SetupModulePU");
    
    /*
    Method to setup Property Areas
    */
    public static void setUpPropertyAreas(){
        
    }
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
   
    
}
