/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.discord.aurelia.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Silvar
 */
@Entity
@Table(name = "ban")
@NamedQueries({
    @NamedQuery(name = "Ban.findAll", query = "SELECT b FROM Ban b")})
public class Ban implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected BanPK banPK;
    @Basic(optional = false)
    @Column(name = "ban_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date banTime;
    @JoinColumn(name = "guild_id", referencedColumnName = "guild_id", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private DbGuild dbGuild;
    @JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private DbUser dbUser;

    public Ban() {
    }

    public Ban(BanPK banPK) {
        this.banPK = banPK;
    }

    public Ban(BanPK banPK, Date banTime) {
        this.banPK = banPK;
        this.banTime = banTime;
    }

    public Ban(long userId, long guildId) {
        this.banPK = new BanPK(userId, guildId);
    }

    public BanPK getBanPK() {
        return banPK;
    }

    public void setBanPK(BanPK banPK) {
        this.banPK = banPK;
    }

    public Date getBanTime() {
        return banTime;
    }

    public void setBanTime(Date banTime) {
        this.banTime = banTime;
    }

    public DbGuild getDbGuild() {
        return dbGuild;
    }

    public void setDbGuild(DbGuild dbGuild) {
        this.dbGuild = dbGuild;
    }

    public DbUser getDbUser() {
        return dbUser;
    }

    public void setDbUser(DbUser dbUser) {
        this.dbUser = dbUser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (banPK != null ? banPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ban)) {
            return false;
        }
        Ban other = (Ban) object;
        if ((this.banPK == null && other.banPK != null) || (this.banPK != null && !this.banPK.equals(other.banPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.discord.aurelia.model.Ban[ banPK=" + banPK + " ]";
    }
    
}
