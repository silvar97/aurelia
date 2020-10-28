package com.discord.aurelia.repository;

import com.discord.aurelia.model.Guild;

import org.springframework.data.repository.CrudRepository;

public interface GuildRepository extends CrudRepository <Guild,Long> {
    
}
