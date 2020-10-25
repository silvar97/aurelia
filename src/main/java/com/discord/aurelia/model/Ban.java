package com.discord.aurelia.model;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Ban {
    
    @EmbeddedId
    BanKey id;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    CustomUser user;

    @ManyToOne
    @MapsId("guildId")
    @JoinColumn(name = "guild_id")
    CustomGuild guild;

    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date date;

    public BanKey getId() {
        return id;
    }

    public void setId(BanKey id) {
        this.id = id;
    }

    public CustomUser getUser() {
        return user;
    }

    public void setUser(CustomUser user) {
        this.user = user;
    }

    public CustomGuild getGuild() {
        return guild;
    }

    public void setGuild(CustomGuild guild) {
        this.guild = guild;
    }

    public java.util.Date getDate() {
        return date;
    }

    public void setDate(java.util.Date date) {
        this.date = date;
    }

}


