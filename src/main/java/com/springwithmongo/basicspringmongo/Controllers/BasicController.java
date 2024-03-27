package com.springwithmongo.basicspringmongo.Controllers;

import com.springwithmongo.basicspringmongo.Entities.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class BasicController {
    private static final String template = "Welcome, %s!";
    private final AtomicLong atomicInteger = new AtomicLong();
    @GetMapping("/teste")
    public Greeting greeting (@RequestParam(name = "name", defaultValue = "World") String name){
        return new Greeting( atomicInteger.incrementAndGet(), String.format(template,name));
    }


}
