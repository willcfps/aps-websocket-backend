package br.com.wcf.model.messages;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import br.com.wcf.model.user.inspector.InspetorModel;

@JsonInclude(value = Include.NON_NULL)
public class UserRestMessage extends DefaultRestMessage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 92235347888281779L;
	private InspetorModel user;
	private List<InspetorModel> users;
	
	public UserRestMessage(InspetorModel user) {
		super(DefaultRestMessageStatus.OK);
		this.user = user;
	}
	
	public UserRestMessage(List<InspetorModel> users) {
		super(DefaultRestMessageStatus.OK);
		this.users = users;
	}

	public InspetorModel getUser() {
		return user;
	}

	public void setUser(InspetorModel user) {
		this.user = user;
	}

	public List<InspetorModel> getUsers() {
		return users;
	}

	public void setUsers(List<InspetorModel> users) {
		this.users = users;
	}
	
	
}
