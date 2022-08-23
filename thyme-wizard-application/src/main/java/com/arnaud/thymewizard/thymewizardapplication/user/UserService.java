package com.arnaud.thymewizard.thymewizardapplication.user;

import com.google.common.collect.ImmutableSet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

// end::getAllUsers[]
public interface UserService {
    User createUser(CreateUserParameters parameters);
    // tag::getAllUsers[]
    Page<User> getUsers(Pageable pageable);
    // end::getAllUsers[]
}
