package com.discord.aurelia.repository;

import com.discord.aurelia.model.Ban;
import com.discord.aurelia.model.BanKey;
import com.discord.aurelia.model.CustomGuild;
import com.discord.aurelia.model.CustomUser;

import org.springframework.data.repository.CrudRepository;

public interface BanRepository extends CrudRepository<Ban,BanKey> {
    
    
}
