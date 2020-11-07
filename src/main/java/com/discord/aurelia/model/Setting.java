/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.discord.aurelia.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Silvar
 */
@Entity
@Table(name = "setting")
@NamedQueries({
    @NamedQuery(name = "Setting.findAll", query = "SELECT s FROM Setting s")})
public class Setting implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "guild_id")
    private Long guildId;
    @Basic(optional = false)
    @Column(name = "max_warnings")
    private int maxWarnings;
    @JoinColumn(name = "guild_id", referencedColumnName = "guild_id", insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private DbGuild dbGuild;

    public Setting() {
    }

    public Setting(Long guildId) {
        this.guildId = guildId;
    }

    public Setting(Long guildId, int maxWarnings) {
        this.guildId = guildId;
        this.maxWarnings = maxWarnings;
    }

    public Long getGuildId() {
        return guildId;
    }

    public void setGuildId(Long guildId) {
        this.guildId = guildId;
    }

    public int getMaxWarnings() {
        return maxWarnings;
    }

    public void setMaxWarnings(int maxWarnings) {
        this.maxWarnings = maxWarnings;
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
        if (!(object instanceof Setting)) {
            return false;
        }
        Setting other = (Setting) object;
        if ((this.guildId == null && other.guildId != null) || (this.guildId != null && !this.guildId.equals(other.guildId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.discord.aurelia.model.Setting[ guildId=" + guildId + " ]";
    }
    
}
