/*
 * The MIT License
 *
 * Copyright 2018 Adedamola.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.ontrac;

import com.ontrac.controller.PropertyAreasJpaController;
import com.ontrac.controller.exceptions.PreexistingEntityException;
import com.ontrac.entities.PropertyAreas;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Adedamola
 */
public class SetUpPropertyArea {

    EntityManagerFactory emf;
    final static String USER = "Administrator";
    final static String HOTEL_ID = "GPA003";
    PropertyAreasJpaController propertyAreaJPA;
    public SetUpPropertyArea() {
        //Initialize Entity Manager Factory : SetupModulePU
        emf = Persistence.createEntityManagerFactory("SetupModulePU");
        propertyAreaJPA = new PropertyAreasJpaController(emf);
    }

    /*
    Method to create Property Areas
     */
    
    public boolean create(int floor, int roomCount, List<Integer> numberSkip) {
        // Result Array for JTestUNIT 
        //List<Integer> results = new ArrayList<>();

        //Skip status set to false 
        boolean isSkipable = false;

        //transaction state
        boolean transactionState = false;

        //Call Property Area Jpa Controller
        
        for (int i = 1; i < roomCount + 1; i++) {

            //Check if current value of i is can be skiped from a list of number skips
            for (int skip : numberSkip) {
                if (skip == i) {
                    isSkipable = true;
                    break;
                }
            }
            if (!isSkipable) {
                int roomNumber = floor + i;
                PropertyAreas pArea = new PropertyAreas();
                pArea.setAreadesc("Rooms");
                pArea.setAreaname(String.valueOf(roomNumber));
                pArea.setCreatedBy(USER);
                pArea.setDateCreated(new Date());
                pArea.setDateUpdated(new Date());
                pArea.setHotelId("GPA003");
                pArea.setReplicationStatus(false);
                pArea.setUpdatedBy(USER);
                try {
                    propertyAreaJPA.create(pArea);
                    transactionState = true;
                } catch (Exception e) {
                    System.out.println("Error Occured: "+e.getMessage());
                    
                }

            } else {
                //reset isSkipable value to false for the next loop
                isSkipable = false;
            }

        }
        
        //Return result for JUnit Test
        //return results;
        
        return transactionState;

    }

    // Return all list of property Areas
    public List<PropertyAreas> get() {
        
        return propertyAreaJPA.findPropertyAreasEntities();

    }
    
    //Closing Entity Manager Factory
    public void closeConnection(){
        emf.close();
    }

}
