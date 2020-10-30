package com.discord.aurelia.repository;

import com.discord.aurelia.model.Setting;

import org.springframework.data.repository.CrudRepository;

public interface SettingRepo extends CrudRepository<Setting,Long> {
    
}
