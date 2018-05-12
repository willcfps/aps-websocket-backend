package br.com.wcf.model.user;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@JsonInclude(value = Include.NON_NULL)
public class UsuarioModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7793145802716163368L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String username;
	private String password;
	private String session;

	@ManyToOne(optional = false)
	@JoinColumn(name = "ID_PERFIL")
	private PerfilUsuarioModel profile;

	public UsuarioModel(String username) {
		super();
		this.username = username;
	}

	public UsuarioModel() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public PerfilUsuarioModel getProfile() {
		return profile;
	}

	public void setProfile(PerfilUsuarioModel profile) {
		this.profile = profile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSession() {
		return session;
	}

	public void setSession(String session) {
		this.session = session;
	}

}
