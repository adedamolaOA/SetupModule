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

import com.ontrac.entities.PropertyAreas;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Adedamola
 */
public class SetUpPropertyArea {

    EntityManagerFactory emf;

    public SetUpPropertyArea() {
        //Initialize Entity Manager Factory : SetupModulePU
        emf = Persistence.createEntityManagerFactory("SetupModulePU");
    }

    /*
    Method to create Property Areas
     */
    public List<Integer> create(int floor, int roomCount, List<Integer> numberSkip) {
        // Result Array
        List<Integer> results = new ArrayList<>();

        //Skip status set to false 
        boolean isSkipable = false;
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
                results.add(roomNumber);
            }else{
               //reset isSkipable value to false for the next loop
               isSkipable = false;
            }           
            
        }
        return results;

    }

    public List<PropertyAreas> get() {

        return null;

    }

}
