package com.freelancehub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.freelancehub.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}