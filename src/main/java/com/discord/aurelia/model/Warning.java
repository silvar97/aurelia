package com.discord.aurelia.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;


@Entity
@Table(name = "warning")
public class Warning {

    @EmbeddedId
    private WarningKey warningKey;

    @ManyToOne(cascade = CascadeType.MERGE)
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(cascade = CascadeType.MERGE)
    @MapsId("guildId")
    @JoinColumn(name = "guild_id")
    private Guild guild;

    @Column(name = "current_warnings")
    private int currentWarnings;
    @Column(name = "max_warnings")
    private int maxWarnings;

    public Warning(){

    }

    public Warning(WarningKey warningKey, User user, Guild guild, int currentWarnings, int maxWarnings) {
        this.warningKey = warningKey;
        this.user = user;
        this.guild = guild;
        this.currentWarnings = currentWarnings;
        this.maxWarnings = maxWarnings;
    }

    public WarningKey getWarningKey() {
        return warningKey;
    }

    public void setWarningKey(WarningKey warningKey) {
        this.warningKey = warningKey;
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

    @Override
    public String toString() {
        return "Warning [currentWarnings=" + currentWarnings + ", guild=" + guild + ", maxWarnings=" + maxWarnings
                + ", user=" + user + ", warningKey=" + warningKey + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + currentWarnings;
        result = prime * result + ((guild == null) ? 0 : guild.hashCode());
        result = prime * result + maxWarnings;
        result = prime * result + ((user == null) ? 0 : user.hashCode());
        result = prime * result + ((warningKey == null) ? 0 : warningKey.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Warning other = (Warning) obj;
        if (currentWarnings != other.currentWarnings)
            return false;
        if (guild == null) {
            if (other.guild != null)
                return false;
        } else if (!guild.equals(other.guild))
            return false;
        if (maxWarnings != other.maxWarnings)
            return false;
        if (user == null) {
            if (other.user != null)
                return false;
        } else if (!user.equals(other.user))
            return false;
        if (warningKey == null) {
            if (other.warningKey != null)
                return false;
        } else if (!warningKey.equals(other.warningKey))
            return false;
        return true;
    }

}
