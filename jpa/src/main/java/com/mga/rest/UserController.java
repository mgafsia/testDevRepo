package com.mga.rest;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mga.model.User;

@Controller
@RequestMapping("/api/users")
public class UserController {
  private final AtomicLong counter = new AtomicLong();

  @ResponseBody
  @GetMapping("")
  public User getUser() {
     return new User(counter.getAndIncrement(), "test", "test01", 20);
  }

  @GetMapping("/firstname/lastname/age")
  @ResponseBody
  public User createUser( @RequestParam(value = "firstname") String firstName,
                          @RequestParam(value = "lastname") String lastName,
                          @RequestParam(value = "age") int age) {

      return new User(counter.incrementAndGet(), firstName, lastName, age);
  }

  @PostMapping(path = "", consumes = "application/json", produces = "application/json")
  @ResponseBody
  public User createUser(@RequestBody User user) {
    return new User(counter.incrementAndGet(), user);
  }
}
