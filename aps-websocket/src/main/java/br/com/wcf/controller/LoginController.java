package br.com.wcf.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import br.com.wcf.bo.login.LoginBo;
import br.com.wcf.config.UsersSession;
import br.com.wcf.model.messages.DefaultRestMessage;
import br.com.wcf.model.user.UsuarioModel;

@RestController
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private UsersSession session;
	@Autowired
	private LoginBo bo;
	
	@RequestMapping(method = RequestMethod.POST)
    public DefaultRestMessage greeting(@RequestBody UsuarioModel user) throws JsonProcessingException {
        return this.bo.login(user);
    }
	
	@RequestMapping(method = RequestMethod.GET)
    public Map<String, String> test() throws JsonProcessingException {
        return this.session.getAll();
    }

}
