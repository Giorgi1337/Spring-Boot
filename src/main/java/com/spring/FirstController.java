package com.spring;

import org.springframework.web.bind.annotation.*;

@RestController

public class FirstController {

  //  @GetMapping("/hi")
    public String sayHello() {
        return "First";
    }

    @PostMapping("/post")
    public String post(@RequestBody String message) {
        return "Request accepted and message is : " + message;
    }

    @PostMapping("/post-order")
    public String post(@RequestBody Order order) {
        return "Request accepted and order is : " + order.toString();
    }

   // @GetMapping("/hi/{user-name}")
    public String PathVar(@PathVariable("user-name") String userName) {
        return "My value = " + userName;
    }

    @GetMapping("/hi")
    public String paramVar(
            @RequestParam ("user-name") String userName,
            @RequestParam ("last-name") String lastName
    ) {
        return "The use name is : " + userName + "and the last name : " + lastName;
    }
}
