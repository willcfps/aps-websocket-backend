package br.com.wcf.bo.login;

import java.util.Base64;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.wcf.bo.DefaultBo;
import br.com.wcf.config.UsersSession;
import br.com.wcf.jpa.repository.ProjetoRepository;
import br.com.wcf.jpa.repository.UsuarioRepository;
import br.com.wcf.model.messages.DefaultRestMessage;
import br.com.wcf.model.messages.DefaultRestMessage.DefaultRestMessageStatus;
import br.com.wcf.model.messages.login.LoginRestMessage;
import br.com.wcf.model.user.UsuarioModel;

@Component
public class LoginBo extends DefaultBo {

	@Autowired
	private UsersSession session;
	@Autowired
	private UsuarioRepository dao;
	@Autowired
	private ProjetoRepository pDao;

	private DefaultRestMessage accept(UsuarioModel u) {
		u.setSession(Base64.getEncoder().encodeToString(new Date().toString().getBytes()));
		session.set(u.getSession(), u.getUsername());
		this.dao.guardarUsuario(u);

		LoginRestMessage msg = new LoginRestMessage();
		msg.setStatus(DefaultRestMessageStatus.OK);
		msg.setShortMessage(u.getSession());
		msg.setProfileId(u.getProfile().getId());
		msg.setProfileWeight(u.getProfile().getWeight());
		msg.setUserId(u.getId());
		msg.setProjects(pDao.getAllInspectorOwner(u));
		msg.getProjects().addAll(pDao.getAllInpectorParticipant(u));

		return msg;
	}

	public DefaultRestMessage login(UsuarioModel u) {
		List<UsuarioModel> list = this.dao.getAllUsuarios();

		if (list == null || list.isEmpty()) {
			return this.unauthorized();
		}

		for (UsuarioModel u1 : list) {
			if (u1.getUsername().equals(u.getUsername()) && u1.getPassword().equals(u.getPassword())) {
				return this.accept(u1);
			}
		}

		return this.unauthorized();
	}

}
