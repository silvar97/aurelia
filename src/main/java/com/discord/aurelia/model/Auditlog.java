/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.discord.aurelia.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

/**
 *
 * @author Silvar
 */
@Entity
@Table(name = "auditlog")
@NamedQueries({
    @NamedQuery(name = "Auditlog.findAll", query = "SELECT a FROM Auditlog a")})
public class Auditlog implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "guild_id")
    private Long guildId;
    @Basic(optional = false)
    @Column(name = "channelId")
    private long channelId;
    @JoinColumn(name = "guild_id", referencedColumnName = "guild_id", insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private DbGuild dbGuild;

    public Auditlog() {
    }

    public Auditlog(Long guildId) {
        this.guildId = guildId;
    }

    public Auditlog(Long guildId, long channelId) {
        this.guildId = guildId;
        this.channelId = channelId;
    }

    public Long getGuildId() {
        return guildId;
    }

    public void setGuildId(Long guildId) {
        this.guildId = guildId;
    }

    public long getChannelId() {
        return channelId;
    }

    public void setChannelId(long channelId) {
        this.channelId = channelId;
    }

    public DbGuild getDbGuild() {
        return dbGuild;
    }

    public void setDbGuild(DbGuild dbGuild) {
        this.dbGuild = dbGuild;
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
        if (!(object instanceof Auditlog)) {
            return false;
        }
        Auditlog other = (Auditlog) object;
        if ((this.guildId == null && other.guildId != null) || (this.guildId != null && !this.guildId.equals(other.guildId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.discord.aurelia.model.Auditlog[ guildId=" + guildId + " ]";
    }
    
}
