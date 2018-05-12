package br.com.wcf.model.user.inspector;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import br.com.wcf.model.user.UsuarioModel;

@Entity
public class InspetorModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8162191854709077027L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String name;
	
	@OneToOne
	private UsuarioModel user;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public UsuarioModel getUser() {
		return user;
	}

	public void setUser(UsuarioModel user) {
		this.user = user;
	}

}
