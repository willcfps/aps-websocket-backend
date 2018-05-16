package br.com.wcf.bo.project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.wcf.bo.DefaultBo;
import br.com.wcf.jpa.repository.ProjetoRepository;
import br.com.wcf.model.messages.DefaultRestMessage;
import br.com.wcf.model.messages.project.ProjectRestMessage;
import br.com.wcf.model.project.ProjetoModel;

@Component
public class ProjetoBo extends DefaultBo {

	private static final String DEFAULT_NOT_FOUND = "Nao encontrado.";

	@Autowired
	private ProjetoRepository dao;

	private DefaultRestMessage successFind(ProjetoModel p) {
		return new ProjectRestMessage(p);
	}

	private DefaultRestMessage successFind(List<ProjetoModel> list) {
		return new ProjectRestMessage(list);
	}
	
	public DefaultRestMessage guardar(ProjetoModel p) {
		return this.successFind(this.dao.guardarProjeto(p));
	}

	public DefaultRestMessage findById(Integer id) {

		if (id == null) {
			return this.error(DEFAULT_NOT_FOUND);
		}

		try {
			return this.successFind(this.dao.findById(id));
		} catch (Exception e) {
			return this.error(DEFAULT_NOT_FOUND);
		}

	}

	public DefaultRestMessage findByIdUserInspectorOwner(Integer id) {
		if (id == null) {
			return this.error(DEFAULT_NOT_FOUND);
		}

		try {
			return this.successFind(this.dao.getAllByIdUserInspectorOwner(id));
		} catch (Exception e) {
			return this.error(DEFAULT_NOT_FOUND);
		}
	}
}
