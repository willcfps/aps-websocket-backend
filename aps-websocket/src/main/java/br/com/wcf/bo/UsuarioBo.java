package br.com.wcf.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.wcf.jpa.repository.UsuarioRepository;
import br.com.wcf.model.messages.DefaultRestMessage;
import br.com.wcf.model.messages.ProfileRestMessage;
import br.com.wcf.model.messages.UserRestMessage;
import br.com.wcf.model.user.PerfilUsuarioModel;
import br.com.wcf.model.user.inspector.InspetorModel;

@Component
public class UsuarioBo extends DefaultBo {
	
	@Autowired
	private UsuarioRepository dao;
	
	private DefaultRestMessage defaultAllMessage(List<InspetorModel> u) {
		return new UserRestMessage(u);
	}
	
	private DefaultRestMessage defaultAllMessage(InspetorModel u) {
		return new UserRestMessage(u);
	}
	
	private DefaultRestMessage defaultAllProfiles(List<PerfilUsuarioModel> u) {
		return new ProfileRestMessage(u);
	}
	
	public DefaultRestMessage getAllProfiles() {
		return this.defaultAllProfiles(this.dao.getAllPerfil());
	}
	
	public DefaultRestMessage getAllInspectors() {
		try {
			return this.defaultAllMessage(this.dao.getAllInspetor());
		} catch (Exception e) {
			return this.error();
		}
	}
	
	public DefaultRestMessage findById(String id) {
		try {
			
			if (id.isEmpty()) {
				return this.error("ID nao informado.");
			}
			
			Integer aux = Integer.parseInt(id);
			return this.defaultAllMessage(this.dao.findInspetorById(aux));
		} catch (Exception e) {
			return this.error();
		}
	}
	
	public DefaultRestMessage findInspectorByIdUser(Integer id) {
		try {
			
			if (id == null) {
				return this.error("ID nao informado.");
			}
			
			return this.defaultAllMessage(this.dao.findInspectorByIdUser(id));
		} catch (Exception e) {
			return this.error();
		}
	}
	
	public DefaultRestMessage guardar(InspetorModel insp) {
		return defaultAllMessage(this.dao.guardarInspetor(insp));
	}

}
