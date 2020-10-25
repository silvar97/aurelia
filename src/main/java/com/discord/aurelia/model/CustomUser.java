package com.discord.aurelia.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "custom_user")
public class CustomUser {

    @Id
    @Column(name = "id")
     private long userId;

    @OneToMany(mappedBy = "user")
    Set<Ban> bans = new HashSet<>();

    public CustomUser(long userId){
        this.userId= userId;
    }
    public CustomUser(){

    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public Set<Ban> getBans() {
        return bans;
    }

    public void setBans(Set<Ban> bans) {
        this.bans = bans;
    }

    
}
