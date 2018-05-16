package br.com.wcf.model.messages.project;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import br.com.wcf.model.messages.DefaultRestMessage;
import br.com.wcf.model.project.ProjetoModel;

@JsonInclude(value = Include.NON_NULL)
public class ProjectRestMessage extends DefaultRestMessage {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7586382791762331881L;
	private ProjetoModel project;
	private List<ProjetoModel> projects;

	public ProjectRestMessage(ProjetoModel project) {
		super(DefaultRestMessageStatus.OK);
		this.project = project;
	}

	public ProjectRestMessage(List<ProjetoModel> projects) {
		super(DefaultRestMessageStatus.OK);
		this.projects = projects;
	}

	public ProjetoModel getProject() {
		return project;
	}

	public void setProject(ProjetoModel project) {
		this.project = project;
	}

	public List<ProjetoModel> getProjects() {
		return projects;
	}

	public void setProjects(List<ProjetoModel> projects) {
		this.projects = projects;
	}

}
