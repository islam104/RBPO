package com.hrRecruting.demo.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/main")
public class MainController {
    @GetMapping("/health")
    public String healthCheck() {
        return "OK";
    }

    @PostMapping("/createPeople")
    public String create(@RequestParam int age, @RequestParam String name ) {
        return "people:" + age + " " + name;
    }


}
