package com.discord.aurelia.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "guild",schema = "aurelia")
public class Guild {
    

    @Id
    @Column(name = "guild_id",unique = true)
    private Long guildId;
    @OneToMany(mappedBy = "guild")
    Set<Ban> bans = new HashSet<>();
    @OneToMany(mappedBy = "guild",cascade = CascadeType.ALL)
    private Set<Warning> warnings = new HashSet<>();
    
    @OneToOne(mappedBy="guild", cascade={CascadeType.ALL})
    private Setting setting;

    @Column(name="setting_id")
	private Long settingId;

 

    @Column(name = "owner_id")
    private Long ownerId;

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

    public Set<Warning> getWarnings() {
        return warnings;
    }

    public void setWarnings(Set<Warning> warnings) {
        this.warnings = warnings;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

   
    
}
