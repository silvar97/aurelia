package com.discord.aurelia.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="setting")

public class Setting implements Serializable {
	private static final long serialVersionUID = 1L;

    @Column(columnDefinition = "Integer default 3")
	private int maxWarnings;

    //bi-directional one-to-one association to Guild
	@OneToOne(cascade={CascadeType.ALL})
    @JoinColumn(name="guild_id")
    @MapsId
    private Guild guild;

    @Id
    private Long guild_id;

	public Setting() {
	}

    public Setting(Long guild_id) {
        this.guild_id = guild_id;
	}


	public int getMaxWarnings() {
		return this.maxWarnings;
	}

	public void setMaxWarnings(int maxWarnings) {
		this.maxWarnings = maxWarnings;
	}


	public Guild getGuild() {
		return this.guild;
	}

	public void setGuild(Guild guild) {
		this.guild = guild;
	}

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public Long getGuild_id() {
        return guild_id;
    }

    public void setGuild_id(Long guild_id) {
        this.guild_id = guild_id;
    }

}