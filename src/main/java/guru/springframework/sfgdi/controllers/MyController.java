package guru.springframework.sfgdi.controllers;

import guru.springframework.sfgdi.services.GreetingService;
import org.springframework.stereotype.Controller;

@Controller
public class MyController {

    private final GreetingService greetingService;

    // Remember @Autowired is optional here since it is Constructor based DI
    public MyController(GreetingService greetingService) { // We can skip @Qualifer in the param GreetingService because one candidate is marked as @Primary
        this.greetingService = greetingService;
    }

    public String sayHello(){
        return greetingService.sayGreeting();
    }
}
