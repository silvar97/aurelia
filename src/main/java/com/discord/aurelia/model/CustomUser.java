package com.discord.aurelia.model;

import discord4j.core.GatewayDiscordClient;
import discord4j.core.object.entity.User;
import discord4j.discordjson.json.UserData;

public class CustomUser extends User {

    

    public CustomUser(GatewayDiscordClient gateway, UserData data) {
        super(gateway, data);
        // TODO Auto-generated constructor stub
    }
    
}
