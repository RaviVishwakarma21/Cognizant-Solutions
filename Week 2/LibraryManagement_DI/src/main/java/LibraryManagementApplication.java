
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.library.service.BookService;

public class LibraryManagementApplication {
    public static void main(String[] args) {
        // Load the Spring XML application context
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        // Get the automatically wired BookService bean
        BookService service = context.getBean("bookService", BookService.class);
        
        // Verify dependency injection works by running the application
        service.runService();
    }
}