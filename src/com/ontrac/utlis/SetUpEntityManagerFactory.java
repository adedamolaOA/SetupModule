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
package com.ontrac.utlis;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Adedamola
 */
public class SetUpEntityManagerFactory {

    /**
     * @see get Method to select the DB connection parameter based on the
     * location
     * @param location
     * @return
     */
    private static EntityManagerFactory emf;

    public static EntityManagerFactory get(int location) {
        /*
        Switch between Peresistence using location selected by user from  main
         */

        switch (location) {
            case 1:
                // Location: Guzape
                emf = Persistence.createEntityManagerFactory("SetupModulePU");
                break;
            case 2:
                // Location: Area 11
                emf = Persistence.createEntityManagerFactory("SetupModulePU2");
                break;
            case 3:
                // Location: Enugu
                emf = Persistence.createEntityManagerFactory("SetupModulePU3");
                break;
            case 4:
                // Location: Ogidi
                emf = Persistence.createEntityManagerFactory("SetupModulePU4");
                break;
            default:
                emf = null;
                break;
        }

        return emf;
    }

    public static void close() {
        if (emf != null) {
            if (emf.isOpen()) {
                emf.close();
            }
        }
    }
}
