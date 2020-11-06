package com.discord.aurelia.repository;

import com.discord.aurelia.model.Setting;

import org.springframework.data.repository.CrudRepository;

public interface SettingRepository  extends CrudRepository<Setting,Long>{
    
}
