package br.com.wcf.model.messages.project;

import br.com.wcf.model.messages.DefaultRestMessage;
import br.com.wcf.model.project.ProjetoModel;

public class ProjectRestMessage extends DefaultRestMessage {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7586382791762331881L;
	private ProjetoModel project;
	
	public ProjectRestMessage(ProjetoModel project) {
		super(DefaultRestMessageStatus.OK);
		this.project = project;
	}

	public ProjetoModel getProject() {
		return project;
	}

	public void setProject(ProjetoModel project) {
		this.project = project;
	}

}
