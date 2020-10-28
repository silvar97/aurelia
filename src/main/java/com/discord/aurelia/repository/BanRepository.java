package com.discord.aurelia.repository;

import com.discord.aurelia.model.Ban;
import com.discord.aurelia.model.BanKey;

import org.springframework.data.repository.CrudRepository;

public interface BanRepository extends CrudRepository<Ban,BanKey> {
    
}
