package com.arnaud.thymewizard.thymewizardapplication.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface UserRepository extends PagingAndSortingRepository<User, UserId>, UserRepositoryCustom {
}