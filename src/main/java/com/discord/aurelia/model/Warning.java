package com.discord.aurelia.model;

import discord4j.core.object.entity.Guild;
import discord4j.core.object.entity.User;

public class Warning {

    private User user;
    private int currentWarnings;
    private int maxWarnings;
    private Guild guild;

    public User getUser() {
        return user;
    }

    public Warning(User user,Guild guild, int currentWarnings, int maxWarnings) {
        this.user = user;
        this.guild= guild;
        this.currentWarnings = currentWarnings;
        this.maxWarnings = maxWarnings;
    }
    public Warning(User user,Guild guild){
        
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getCurrentWarnings() {
        return currentWarnings;
    }

    public void setCurrentWarnings(int currentWarnings) {
        this.currentWarnings = currentWarnings;
    }

    public int getMaxWarnings() {
        return maxWarnings;
    }

    public void setMaxWarnings(int maxWarnings) {
        this.maxWarnings = maxWarnings;
    }

    public Guild getGuild() {
        return guild;
    }

    public void setGuild(Guild guild) {
        this.guild = guild;
    }

}
