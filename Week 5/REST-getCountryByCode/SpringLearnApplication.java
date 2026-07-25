package com.cognizant.springlearn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

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

// 2. COUNTRY SERVICE LAYER
@Service
class CountryService {
    
    public Country getCountry(String code) {
        // Load the context configuration
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        
        // Extract all declared Country beans out of the XML context registry
        List<Country> countryList = new ArrayList<>();
        countryList.add(context.getBean("us", Country.class));
        countryList.add(context.getBean("de", Country.class));
        countryList.add(context.getBean("in", Country.class));
        countryList.add(context.getBean("jp", Country.class));

        // Use a case-insensitive Lambda expression filter to scan the collection
        return countryList.stream()
                .filter(country -> country.getCode().equalsIgnoreCase(code))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Country not found"));
    }
}

// 3. REST CONTROLLER LAYER
@RestController
class CountryController {

    private final CountryService countryService;

    // Dependency injection via constructor
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    // Mapping dynamic segments via Path Variables
    @GetMapping("/countries/{code}")
    public Country getCountry(@PathVariable String code) {
        return countryService.getCountry(code);
    }
}