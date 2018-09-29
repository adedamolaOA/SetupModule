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

import com.ontrac.locations.Area11;
import com.ontrac.locations.Guzape;
import java.io.IOException;

/**
 *
 * @author Adedamola
 */
public class MainProcessor {
    
    //Get User Input using System.in making sure it is of type int
    public static int selection() {
        int num = 0;

        try {
            int input;
            while ((input = System.in.read()) != '\n') {
                if (input >= '0' && input <= '9') {
                    num *= 10;
                    num += input - '0';
                } else {
                    break;
                }
            }
            
        } catch (IOException io) {

        }
        
        return num;
    }
    
    // Display welcome information of the application
    public static void info(){
        System.out.println("=====================================================================");
        System.out.println("=============== IntliPMS Maintenance Property Setup =================");
        System.out.println("======================== Version 1.0.6 ==============================");
        System.out.println("=====================================================================\n");
        System.out.println("Select the location to setup (Enter the corresponding number)");
        System.out.println("1. Residency Guazpe");
        System.out.println("2. Residency Area 11");
        System.out.println("3. Residency Enugu");
        System.out.println("4. Residency Ogidi");
        System.out.println("5. Exit Application");
    }
    
    //Processes the selection from the user input to run the selected process
    public static void processSelection(){
        int sel = selection();
        switch (sel) {
            case 0:
                System.out.println("Please enter a vaild option");
                processSelection();
                break;
            case 1:
                Guzape.setup(sel);
                break;
            case 2:
                Area11.setup(sel);
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                System.exit(-1);
                break;
            default:
                break;
        }
    }
}
