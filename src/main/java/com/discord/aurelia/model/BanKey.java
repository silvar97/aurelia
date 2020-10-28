package com.discord.aurelia.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class BanKey implements Serializable{
    
    /**
     *
     */
    private static final long serialVersionUID = -62271743383918658L;
    
    @Column(name = "user_id")
private Long userId;
@Column(name = "guild_id")
private Long guildId;

public BanKey(){

}

public BanKey(Long userId, Long guildId) {
    this.userId = userId;
    this.guildId = guildId;
}
public Long getUserId() {
    return userId;
}

public void setUserId(Long userId) {
    this.userId = userId;
}

public Long getGuildId() {
    return guildId;
}

public void setGuildId(Long guildId) {
    this.guildId = guildId;
}

@Override
public String toString() {
    return "BanKey [guildId=" + guildId + ", userId=" + userId + "]";
}

@Override
public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((guildId == null) ? 0 : guildId.hashCode());
    result = prime * result + ((userId == null) ? 0 : userId.hashCode());
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
    BanKey other = (BanKey) obj;
    if (guildId == null) {
        if (other.guildId != null)
            return false;
    } else if (!guildId.equals(other.guildId))
        return false;
    if (userId == null) {
        if (other.userId != null)
            return false;
    } else if (!userId.equals(other.userId))
        return false;
    return true;
}



}
