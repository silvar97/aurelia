package com.discord.aurelia.Service;

import com.discord.aurelia.dao.WarningDao;
import com.discord.aurelia.dao.WarningDaoServiceImpl;
import com.discord.aurelia.model.Warning;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Service
@Order(2)
public class WarningService {
    
@Autowired
private WarningDao warningDao;


public void addWarning(Warning warning){
    warningDao.addWarning(warning);
}
public Warning getWarning(Warning warning){
    return warningDao.getWarning(warning).get();
}

}
