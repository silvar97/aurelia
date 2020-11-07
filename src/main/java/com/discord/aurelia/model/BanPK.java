/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.discord.aurelia.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Silvar
 */
@Embeddable
public class BanPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "user_id")
    private long userId;
    @Basic(optional = false)
    @Column(name = "guild_id")
    private long guildId;

    public BanPK() {
    }

    public BanPK(long userId, long guildId) {
        this.userId = userId;
        this.guildId = guildId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getGuildId() {
        return guildId;
    }

    public void setGuildId(long guildId) {
        this.guildId = guildId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) userId;
        hash += (int) guildId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BanPK)) {
            return false;
        }
        BanPK other = (BanPK) object;
        if (this.userId != other.userId) {
            return false;
        }
        if (this.guildId != other.guildId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.discord.aurelia.model.BanPK[ userId=" + userId + ", guildId=" + guildId + " ]";
    }
    
}
