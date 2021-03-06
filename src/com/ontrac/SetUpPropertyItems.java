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
import com.ontrac.controller.PropertyItemJpaController;
import com.ontrac.entities.PropertyAreas;
import com.ontrac.entities.PropertyItem;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Adedamola
 */
public class SetUpPropertyItems {

    EntityManagerFactory emf;
    final static String USER = "Administrator";
    final static String HOTEL_ID = "GPA003";
    final static String[] ROOM_ITEMS = {"TV", "WC", "Sink", "Fridge", "AC", "Bed", "Bathroom", "Bedroom", "light"};
    PropertyItemJpaController propertyItemJPA;

    public SetUpPropertyItems() {
        //Initialize Entity Manager Factory : SetupModulePU and Property Item JPA Controller
        emf = Persistence.createEntityManagerFactory("SetupModulePU");
        propertyItemJPA = new PropertyItemJpaController(emf);
    }

    public boolean create() {
        boolean transcationState = false;
        List<PropertyAreas> propertyAreas = new PropertyAreasJpaController(emf).findPropertyAreasEntities();
        for (PropertyAreas p : propertyAreas) {
            for (String item : ROOM_ITEMS) {
                PropertyItem pItems = new PropertyItem();
                pItems.setArea(String.valueOf(p.getAreaid()));
                pItems.setCreatedBy(USER);
                pItems.setDateCreated(new Date());
                pItems.setDateUpdated(new Date());
                pItems.setHotelId(HOTEL_ID);
                pItems.setItemDesc("Room "+item);
                pItems.setItemName(item);
                pItems.setReplicationStatus(false);
                pItems.setUpdatedBy(USER);
                
                try{
                   propertyItemJPA.create(pItems);
                   transcationState = true;
                }catch(Exception e){
                     System.out.println("Error Occured: "+e.getMessage());
                }
                
            }

        }

        return transcationState;
    }

}
