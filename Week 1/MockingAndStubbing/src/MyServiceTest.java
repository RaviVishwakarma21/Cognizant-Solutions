import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class MyServiceTest {

    @Test
    public void testExternalApi() {
        // 1. Create a mock object for the external API inside Eclipse
        ExternalApi mockApi = (ExternalApi) java.lang.reflect.Proxy.newProxyInstance(
            ExternalApi.class.getClassLoader(),
            new Class<?>[] { ExternalApi.class },
            (proxy, method, args) -> {
                if (method.getName().equals("getData")) {
                    // 2. Stub the method to return the predefined value
                    return "Mock Data";
                }
                return null;
            }
        );

        // 3. Run the test case using the mock object
        MyService service = new MyService(mockApi);
        String result = service.fetchData();
        
        // Assert that the values match
        assertEquals("Mock Data", result);
    }
}