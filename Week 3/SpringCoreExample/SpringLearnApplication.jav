import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

class Country {
    private String code;
    private String name;

    public Country() {
        System.out.println("[DEBUG] Inside Country Constructor.");
    }

    public String getCode() {
        System.out.println("[DEBUG] Inside getCode() method.");
        return code;
    }

    public void setCode(String code) {
        System.out.println("[DEBUG] Inside setCode() method. Setting code to: " + code);
        this.code = code;
    }

    public String getName() {
        System.out.println("[DEBUG] Inside getName() method.");
        return name;
    }

    public void setName(String name) {
        System.out.println("[DEBUG] Inside setName() method. Setting name to: " + name);
        this.name = name;
    }

    @Override
    public String toString() {
        return "Country [code=" + code + ", name=" + name + "]";
    }
}

public class SpringLearnApplication {
    public static void displayCountry() {
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        Country country = context.getBean("country", Country.class);
        System.out.println("[DEBUG] Country : " + country.toString());
    }

    public static void main(String[] args) {
        displayCountry();
    }
}