import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.library.service.BookService;

public class MainApplication {
    public static void main(String[] args) {
        // 1. Load the Spring Application Context from the XML file
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        // 2. Retrieve the BookService bean managed by Spring
        BookService service = context.getBean("bookService", BookService.class);
        
        // 3. Test the backend configuration
        service.runService();
    }
}