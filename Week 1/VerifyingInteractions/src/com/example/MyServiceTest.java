package com.example;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class MyServiceTest {

    // Flag tracker to record if the interaction happens
    private boolean wasGetDataCalled = false;

    @Test
    public void testVerifyInteraction() {
        // 1. Create a mock object that tracks calls
        ExternalApi mockApi = new ExternalApi() {
            @Override
            public String getData() {
                wasGetDataCalled = true; 
                return "Mock Data";
            }
        };

        // 2. Call the method that triggers the interaction
        MyService service = new MyService(mockApi);
        service.fetchData(); 

        // 3. Verify the interaction
        assertTrue(wasGetDataCalled, "Verification Failed: mockApi.getData() was never called.");
    }
}