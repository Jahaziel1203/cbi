package com.cbi.cbi.models.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "users")
public class User extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	@NotEmpty
	@Column(name = "name", length = 50)
	private String name;

	@NotEmpty
	@Column(name = "lastname", length = 50)
	private String lastname;

	@Column(name = "mother_lastname", length = 50)
	private String mother_lastname;

	@OneToOne(mappedBy = "user", cascade = {CascadeType.MERGE, CascadeType.REMOVE})
	private Authentication authentication;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getMother_lastname() {
		return mother_lastname;
	}

	public void setMother_lastname(String mother_lastname) {
		this.mother_lastname = mother_lastname;
	}

	public Authentication getAuthentication() {
		return authentication;
	}

	public void setAuthentication(Authentication authentication) {
		this.authentication = authentication;
	}
}
