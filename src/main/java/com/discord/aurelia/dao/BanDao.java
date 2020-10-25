package com.discord.aurelia.dao;

import com.discord.aurelia.model.Ban;

public interface BanDao {
    
    public void addBan(Ban ban);
    public Ban getBan(Ban ban);
    public boolean containsBan (Ban ban);
    public void removeBan (Ban ban);



}
