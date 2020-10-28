package com.discord.aurelia.model;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "guild",schema = "aurelia")
public class Guild {
    

    @Id
    @Column(name = "guild_id",unique = true)
    private Long guildId;

    @OneToMany(mappedBy = "guild")
    Set<Ban> bans = new HashSet<>();
    

    public Guild(){
        
    }

    public Guild(Long guildId){
        this.guildId = guildId;
    }

    public Long getGuildId() {
        return guildId;
    }

    public void setGuildId(Long guildId) {
        this.guildId = guildId;
    }
    public Set<Ban> getBans() {
        return bans;
    }

    public void setBans(Set<Ban> bans) {
        this.bans = bans;
    }
    public void addBan(Ban ban){
        bans.add(ban);
    }
    
}
