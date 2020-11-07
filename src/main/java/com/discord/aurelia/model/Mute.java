/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.discord.aurelia.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
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
@Table(name = "mute")
@NamedQueries({
    @NamedQuery(name = "Mute.findAll", query = "SELECT m FROM Mute m")})
public class Mute implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MutePK mutePK;
    @Basic(optional = false)
    @Column(name = "mute_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date muteTime;
    @JoinColumn(name = "db_guild_guild_id", referencedColumnName = "guild_id", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private DbGuild dbGuild;
    @JoinColumn(name = "db_user_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private DbUser dbUser;

    public Mute() {
    }

    public Mute(MutePK mutePK) {
        this.mutePK = mutePK;
    }

    public Mute(MutePK mutePK, Date muteTime) {
        this.mutePK = mutePK;
        this.muteTime = muteTime;
    }

    public Mute(long dbGuildGuildId, long dbUserId) {
        this.mutePK = new MutePK(dbGuildGuildId, dbUserId);
    }

    public MutePK getMutePK() {
        return mutePK;
    }

    public void setMutePK(MutePK mutePK) {
        this.mutePK = mutePK;
    }

    public Date getMuteTime() {
        return muteTime;
    }

    public void setMuteTime(Date muteTime) {
        this.muteTime = muteTime;
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
        hash += (mutePK != null ? mutePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mute)) {
            return false;
        }
        Mute other = (Mute) object;
        if ((this.mutePK == null && other.mutePK != null) || (this.mutePK != null && !this.mutePK.equals(other.mutePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.discord.aurelia.model.Mute[ mutePK=" + mutePK + " ]";
    }
    
}
