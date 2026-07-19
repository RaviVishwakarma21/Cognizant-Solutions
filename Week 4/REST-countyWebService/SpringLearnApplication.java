package com.cognizant.springlearn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class SpringLearnApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringLearnApplication.class, args);
    }
}

// 1. COUNTRY BLUEPRINT CLASS
class Country {
    private String code;
    private String name;

    public Country() {}

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}

// 2. REST CONTROLLER
@RestController
class CountryController {

    @RequestMapping(value = "/country", method = RequestMethod.GET)
    public Country getCountryIndia() {
        // Load the XML configuration context
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        
        // Fetch the configured India bean
        Country india = context.getBean("country", Country.class);
        
        // Returning the raw Java object directly
        return india;
    }
}