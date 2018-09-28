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

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Adedamola
 */
public class SetUpPropertyAreaTest {
    
    public SetUpPropertyAreaTest() {
    }

    /**
     * Test of create method, of class SetUpPropertyArea.
     */
    @Test
    public void testCreate() {
        SetUpPropertyArea spa = new SetUpPropertyArea();
        //Test Case #1        
        /*List<Integer> test1 = spa.create(1200,4 ,new ArrayList<>(0));
        List<Integer> results = new ArrayList<>();
        results.add(1201);
        results.add(1202);
        results.add(1203);
        results.add(1204);
        
        assertEquals(test1, results);
        
        //Test Case #2 : the skip test {2001, 2003, 2004}
        List<Integer> skip = new ArrayList<>();
        skip.add(2);
        List<Integer> test2 = spa.create(1200,4 ,skip);
        List<Integer> results2 = new ArrayList<>();
        results2.add(1201);
        results2.add(1203);
        results2.add(1204);
        assertEquals(test2, results2);*/
        
    }

    /**
     * Test of get method, of class SetUpPropertyArea.
     */
    @Test
    public void testGet() {
    }
    
}
