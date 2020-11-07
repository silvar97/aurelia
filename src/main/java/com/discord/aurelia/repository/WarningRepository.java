package com.discord.aurelia.repository;

import com.discord.aurelia.model.Warning;
import com.discord.aurelia.model.WarningPK;

import org.springframework.data.repository.CrudRepository;

public interface WarningRepository extends CrudRepository<Warning,WarningPK> {
    
}
