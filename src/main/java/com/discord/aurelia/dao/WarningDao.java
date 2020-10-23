package com.discord.aurelia.dao;

import java.util.Optional;

import com.discord.aurelia.model.Warning;


public interface WarningDao {
    
    public void addWarning(Warning warning);
    public Warning getWarning(Warning warning);
    public void removeWarning(Warning warning);
    public boolean contains(Warning warning);

}
