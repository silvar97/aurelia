package com.discord.aurelia.repository;

import com.discord.aurelia.model.DbUser;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<DbUser,Long> {
    
    
}
