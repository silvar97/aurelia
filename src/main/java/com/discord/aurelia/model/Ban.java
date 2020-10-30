package com.discord.aurelia.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "ban",schema = "aurelia")
public class Ban {

    @EmbeddedId
    private BanKey banKey;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @MapsId("guildId")
    @JoinColumn(name = "guild_id")
    private Guild guild;

    @Column(name = "date")
    private LocalDateTime date;
    

    public Ban() {

    }

    public Ban(BanKey banKey, User user, Guild guild) {
        this.banKey = banKey;
        this.user = user;
        this.guild = guild;
    }

    public BanKey getBanKey() {
        return banKey;
    }

    public void setBanKey(BanKey banKey) {
        this.banKey = banKey;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Guild getGuild() {
        return guild;
    }

    public void setGuild(Guild guild) {
        this.guild = guild;
    }

    @Override
    public String toString() {
        return "Ban [banKey=" + banKey + ", guild=" + guild + ", user=" + user + "]";
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }


}
