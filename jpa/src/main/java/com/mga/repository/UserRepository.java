package com.mga.repository;

import org.springframework.data.repository.CrudRepository;
import com.mga.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
}
