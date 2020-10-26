package com.discord.aurelia.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "user",schema = "aurelia")
public class User {
    
    @Id
    @Column(name = "user_id",unique = true)
    private Long userId;

    
    @OneToMany(mappedBy = "user")
    private Set<Ban> bans = new HashSet<>();
    
    public User(){

    }
    public User(Long userId){
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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
