package br.com.wcf.model.messages.login;

import java.io.Serializable;

public class LoginProjectsRestMessage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8418431883906729960L;
	private Integer projectId;
	private String projectName;
	
	public LoginProjectsRestMessage() {
		// TODO Auto-generated constructor stub
	}
	
	public LoginProjectsRestMessage(Integer projectId, String projectName) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}
}
