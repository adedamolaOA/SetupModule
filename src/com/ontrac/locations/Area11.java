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
package com.ontrac.locations;

import com.ontrac.actions.SetUpPropertyArea;
import com.ontrac.actions.SetUpPropertyItems;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Adedamola
 */
public class Area11 {
    public static void setup(int location) {
        // Start Property Area Setup
        String hotelId="GPA003";
        List<Integer> skipList = new ArrayList<>();

        SetUpPropertyArea spa = new SetUpPropertyArea(location);

        spa.create(hotelId,1200, 4, skipList);
        spa.create(hotelId,1300, 4, skipList);
        
        //set skip value
        skipList.add(2);
        spa.create(hotelId,2000, 4, skipList);
        //clear skip value after work is done
        
        skipList.clear();
        spa.create(hotelId,2100, 10, skipList);
        spa.create(hotelId,2200, 10, skipList);
        spa.create(hotelId,2300, 10, skipList);
        spa.create(hotelId,3100, 10, skipList);
        spa.create(hotelId,3200, 10, skipList);
        spa.create(hotelId,3300, 10, skipList);

        // Start Property Item Setup for Rooms
        SetUpPropertyItems spi = new SetUpPropertyItems(location);
        spi.create(hotelId);

        // Create Other Areas With No Items
        spa.create(hotelId);

        
    }
}
