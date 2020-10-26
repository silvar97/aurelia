package com.discord.aurelia.repository;

import com.discord.aurelia.model.User;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {
    
    
}
