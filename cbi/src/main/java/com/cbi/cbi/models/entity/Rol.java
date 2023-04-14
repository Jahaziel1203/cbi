package com.cbi.cbi.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "roles")
public class Rol extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	@NotEmpty
	@Column(name = "name", length = 50)
	private String name;

	@NotEmpty
	@Column(name = "description", length = 50)
	private String description;

	@OneToOne(mappedBy = "rol")
	private Authentication authentication;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Authentication getAuthentication() {
		return authentication;
	}

	public void setAuthentication(Authentication authentication) {
		this.authentication = authentication;
	}
}