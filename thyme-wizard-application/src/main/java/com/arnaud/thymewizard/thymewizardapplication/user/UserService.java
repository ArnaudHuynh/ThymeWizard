package com.arnaud.thymewizard.thymewizardapplication.user;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

// end::getAllUsers[]
public interface UserService {
    User createUser(CreateUserParameters parameters);
    // tag::getAllUsers[]
    Page<User> getUsers(Pageable pageable);
    // end::getAllUsers[]

    User editUser(UserId userId, EditUserParameters parameter);

    public Optional<User> getUser(UserId userId);
}
