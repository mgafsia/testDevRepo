package com.mga.rest;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mga.model.User;
import com.mga.services.UserService;

@Controller
@RequestMapping("/api/users")
public class UserController {
  private final AtomicLong counter = new AtomicLong();
  @Autowired
  UserService userService;

  @ResponseBody
  @GetMapping("")
  public List<User> getAllUsers() {
     return this.userService.getAllUsers();
  }

  @GetMapping("/firstname/lastname/age")
  @ResponseBody
  public User createUser( @RequestParam(value = "firstname") String firstName,
                          @RequestParam(value = "lastname") String lastName,
                          @RequestParam(value = "age") int age) {

    User userT =  new User(counter.incrementAndGet(), firstName, lastName, age);
    return this.userService.addUser(userT);
  }

  @PostMapping(path = "", consumes = "application/json", produces = "application/json")
  @ResponseBody
  public User createUser(@RequestBody User user) {
    User userT = new User(counter.incrementAndGet(), user);

    return this.userService.addUser(userT);
  }
}
