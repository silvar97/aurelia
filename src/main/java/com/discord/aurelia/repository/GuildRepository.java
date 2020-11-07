package com.discord.aurelia.repository;

import com.discord.aurelia.model.DbGuild;

import org.springframework.data.repository.CrudRepository;

public interface GuildRepository extends CrudRepository <DbGuild,Long> {
 
}
