package com.example;

import static org.junit.Assert.assertEquals;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {

    private Calculator calc;

    // 1. SETUP FIXTURE: This runs automatically BEFORE every single test method
    @Before
    public void setUp() {
        System.out.println("--- Setup: Initializing a fresh calculator instance ---");
        calc = new Calculator(); 
    }

    // 2. AAA PATTERN TEST CASES
    @Test
    public void testAdd() {
        // Arrange (Set up data)
        int a = 10;
        int b = 5;
        
        // Act (Execute target method)
        int result = calc.add(a, b);
        
        // Assert (Verify the output)
        assertEquals(15, result);
    }

    @Test
    public void testSubtract() {
        // Arrange
        int a = 20;
        int b = 8;
        
        // Act
        int result = calc.subtract(a, b);
        
        // Assert
        assertEquals(12, result);
    }

    // 3. TEARDOWN FIXTURE: This runs automatically AFTER every single test method
    @After
    public void tearDown() {
        System.out.println("--- Teardown: Resetting and cleaning up resources ---");
        calc = null;
    }
}