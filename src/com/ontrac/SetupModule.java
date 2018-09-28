/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ontrac;

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
        // Start Property Area Setup
        List<Integer> skipList = new ArrayList<>();
        
        SetUpPropertyArea spa = new SetUpPropertyArea();
        
        spa.create(1200, 4, skipList);
        spa.create(1300, 4, skipList);
        //set skip value
        skipList.add(2);
        spa.create(2000, 4, skipList);
        //clear skip value after work is done
        skipList.clear();
        spa.create(2100, 10, skipList);
        spa.create(2200, 10, skipList);
        spa.create(2300, 10, skipList);
        spa.create(3100, 10, skipList);
        spa.create(3200, 10, skipList);
        spa.create(3300, 10, skipList);
        
        // Start Property Item Setup
        SetUpPropertyItems spi = new SetUpPropertyItems();
        spi.create();
        
        // Create Areas With No Items
        spa.create();
        
        spa.closeConnection();
        
        
    }
    
   
    
}
