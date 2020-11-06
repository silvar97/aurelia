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
public class MutePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "db_guild_guild_id")
    private long dbGuildGuildId;
    @Basic(optional = false)
    @Column(name = "db_user_id")
    private long dbUserId;

    public MutePK() {
    }

    public MutePK(long dbGuildGuildId, long dbUserId) {
        this.dbGuildGuildId = dbGuildGuildId;
        this.dbUserId = dbUserId;
    }

    public long getDbGuildGuildId() {
        return dbGuildGuildId;
    }

    public void setDbGuildGuildId(long dbGuildGuildId) {
        this.dbGuildGuildId = dbGuildGuildId;
    }

    public long getDbUserId() {
        return dbUserId;
    }

    public void setDbUserId(long dbUserId) {
        this.dbUserId = dbUserId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) dbGuildGuildId;
        hash += (int) dbUserId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MutePK)) {
            return false;
        }
        MutePK other = (MutePK) object;
        if (this.dbGuildGuildId != other.dbGuildGuildId) {
            return false;
        }
        if (this.dbUserId != other.dbUserId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.discord.aurelia.model.MutePK[ dbGuildGuildId=" + dbGuildGuildId + ", dbUserId=" + dbUserId + " ]";
    }
    
}
