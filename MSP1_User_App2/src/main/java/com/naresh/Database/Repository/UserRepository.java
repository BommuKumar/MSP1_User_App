package com.naresh.Database.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.naresh.Database.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	
	Optional<User> findByName(String userName);
}
