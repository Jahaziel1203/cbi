package com.cbi.cbi.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "authentications")
public class Authentication extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	@NotEmpty
	@Column(name = "username", length = 50)
	private String username;

	@NotEmpty
	@Column(name = "password", length = 50)
	private String password;

	@OneToOne
	@JoinColumn(name = "idUser", referencedColumnName = "id", nullable = false)
	private User user;

	@OneToOne
	@JoinColumn(name = "idRol", referencedColumnName = "id", nullable = false)
	private Rol rol;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}
}