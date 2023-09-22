package com.amnil.microserviceuserservice.repository;

import com.amnil.microserviceuserservice.enitity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {

}
