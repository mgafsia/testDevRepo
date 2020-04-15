package com.mga.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mga.model.User;
import com.mga.repository.UserRepository;

@Service
public class UserService {

  @Autowired
  UserRepository userRepository;

  public User addUser(User user) {
    return this.userRepository.save(user);
  }

  public List<User> getAllUsers() {
    return (List<User>)this.userRepository.findAll();
  }
}
