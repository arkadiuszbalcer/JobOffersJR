package com.junioroffers.domain.loginandregister;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface LoginRepository{

    User save(User user);


    Optional<User> findByUsername(String username);
}
