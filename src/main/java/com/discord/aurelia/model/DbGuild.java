/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.discord.aurelia.model;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Silvar
 */
@Entity
@Table(name = "db_guild")
@NamedQueries({
    @NamedQuery(name = "DbGuild.findAll", query = "SELECT d FROM DbGuild d")})
public class DbGuild implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "guild_id")
    private Long guildId;
    @JoinColumn(name = "owner_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY,cascade=CascadeType.ALL)
    private DbUser ownerId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dbGuild", fetch = FetchType.LAZY)
    private Set<Warning> warningSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dbGuild", fetch = FetchType.LAZY)
    private Set<Mute> muteSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dbGuild", fetch = FetchType.LAZY)
    private Set<Ban> banSet;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "dbGuild", fetch = FetchType.LAZY)
    private Setting setting;

    public DbGuild() {
    }

    public DbGuild(Long guildId) {
        this.guildId = guildId;
    }

    public Long getGuildId() {
        return guildId;
    }

    public void setGuildId(Long guildId) {
        this.guildId = guildId;
    }

    public DbUser getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(DbUser ownerId) {
        this.ownerId = ownerId;
    }

    public Set<Warning> getWarningSet() {
        return warningSet;
    }

    public void setWarningSet(Set<Warning> warningSet) {
        this.warningSet = warningSet;
    }

    public Set<Mute> getMuteSet() {
        return muteSet;
    }

    public void setMuteSet(Set<Mute> muteSet) {
        this.muteSet = muteSet;
    }

    public Set<Ban> getBanSet() {
        return banSet;
    }

    public void setBanSet(Set<Ban> banSet) {
        this.banSet = banSet;
    }

    public Setting getSetting() {
        return setting;
    }

    public void setSetting(Setting setting) {
        this.setting = setting;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (guildId != null ? guildId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DbGuild)) {
            return false;
        }
        DbGuild other = (DbGuild) object;
        if ((this.guildId == null && other.guildId != null) || (this.guildId != null && !this.guildId.equals(other.guildId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.discord.aurelia.model.DbGuild[ guildId=" + guildId + " ]";
    }
    
}
