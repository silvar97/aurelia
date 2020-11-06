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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Silvar
 */
@Entity
@Table(name = "db_user")
@NamedQueries({
    @NamedQuery(name = "DbUser.findAll", query = "SELECT d FROM DbUser d")})
public class DbUser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ownerId", fetch = FetchType.LAZY)
    private Set<DbGuild> dbGuildSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dbUser", fetch = FetchType.LAZY)
    private Set<Warning> warningSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dbUser", fetch = FetchType.LAZY)
    private Set<Mute> muteSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dbUser", fetch = FetchType.LAZY)
    private Set<Ban> banSet;

    public DbUser() {
    }

    public DbUser(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<DbGuild> getDbGuildSet() {
        return dbGuildSet;
    }

    public void setDbGuildSet(Set<DbGuild> dbGuildSet) {
        this.dbGuildSet = dbGuildSet;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DbUser)) {
            return false;
        }
        DbUser other = (DbUser) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.discord.aurelia.model.DbUser[ id=" + id + " ]";
    }
    
}
