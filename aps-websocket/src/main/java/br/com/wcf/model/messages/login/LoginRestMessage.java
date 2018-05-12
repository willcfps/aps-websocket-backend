package br.com.wcf.model.messages.login;

import java.util.List;

import br.com.wcf.model.messages.DefaultRestMessage;

public class LoginRestMessage extends DefaultRestMessage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3946858487267801797L;
	private Integer userId;
	private Integer profileId;
	private Integer profileWeight;
	private List<LoginProjectsRestMessage> projects;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getProfileId() {
		return profileId;
	}

	public void setProfileId(Integer profileId) {
		this.profileId = profileId;
	}

	public Integer getProfileWeight() {
		return profileWeight;
	}

	public void setProfileWeight(Integer profileWeight) {
		this.profileWeight = profileWeight;
	}

	public List<LoginProjectsRestMessage> getProjects() {
		return projects;
	}

	public void setProjects(List<LoginProjectsRestMessage> projects) {
		this.projects = projects;
	}

}
