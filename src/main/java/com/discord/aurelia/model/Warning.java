/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.discord.aurelia.model;

import java.io.Serializable;

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

/**
 *
 * @author Silvar
 */
@Entity
@Table(name = "warning")
@NamedQueries({
    @NamedQuery(name = "Warning.findAll", query = "SELECT w FROM Warning w")})
public class Warning implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected WarningPK warningPK;
    @Column(name = "current_warnings")
    private Integer currentWarnings;
    @Column(name = "max_warnings")
    private Integer maxWarnings;
    @JoinColumn(name = "guild_id", referencedColumnName = "guild_id", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private DbGuild dbGuild;
    @JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY,cascade =CascadeType.ALL)
    private DbUser dbUser;

    public Warning() {
    }

    public Warning(WarningPK warningPK) {
        this.warningPK = warningPK;
    }

    public Warning(long guildId, long userId) {
        this.warningPK = new WarningPK(guildId, userId);
    }

    public WarningPK getWarningPK() {
        return warningPK;
    }

    public void setWarningPK(WarningPK warningPK) {
        this.warningPK = warningPK;
    }

    public Integer getCurrentWarnings() {
        return currentWarnings;
    }

    public void setCurrentWarnings(Integer currentWarnings) {
        this.currentWarnings = currentWarnings;
    }

    public Integer getMaxWarnings() {
        return maxWarnings;
    }

    public void setMaxWarnings(Integer maxWarnings) {
        this.maxWarnings = maxWarnings;
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
        hash += (warningPK != null ? warningPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Warning)) {
            return false;
        }
        Warning other = (Warning) object;
        if ((this.warningPK == null && other.warningPK != null) || (this.warningPK != null && !this.warningPK.equals(other.warningPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.discord.aurelia.model.Warning[ warningPK=" + warningPK + " ]";
    }
    
}
