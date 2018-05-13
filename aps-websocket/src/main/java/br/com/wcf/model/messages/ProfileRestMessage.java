package br.com.wcf.model.messages;

import java.util.List;

import br.com.wcf.model.user.PerfilUsuarioModel;

public class ProfileRestMessage extends DefaultRestMessage {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4936397664807501154L;
	private List<PerfilUsuarioModel> profiles;

	public ProfileRestMessage(List<PerfilUsuarioModel> profiles) {
		super(DefaultRestMessageStatus.OK);
		this.profiles = profiles;
	}

	public List<PerfilUsuarioModel> getProfiles() {
		return profiles;
	}

	public void setProfiles(List<PerfilUsuarioModel> profiles) {
		this.profiles = profiles;
	}
}
