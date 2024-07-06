package com.ericqiu.twitch.hello;

import net.datafaker.Faker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// note: important thing here is the @ to tell spring that it is a controller
@RestController
public class HelloController {
    //similarly, the @ here is what's really important, function name is not
    @GetMapping("/hello")
    public Person sayHello(@RequestParam(required = false) String name) {
        Faker faker = new Faker();;
        if (name == null) {
            name = "Guest";
        }
        String company = faker.company().name();
        String street = faker.address().streetAddress();
        String city = faker.address().city();
        String state = faker.address().state();
        String bookTitle = faker.book().title();
        String bookAuthor = faker.book().author();
        // This demonstrates the ability to automatically convert java classes to .json format
        return new Person(
            name,
            company,
            new Address(street, city, state, null),
            new Book(bookTitle, bookAuthor)
        );
    }
}
