package br.com.wcf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.wcf.bo.UsuarioBo;
import br.com.wcf.model.messages.DefaultRestMessage;
import br.com.wcf.model.user.inspector.InspetorModel;

@RestController
@RequestMapping("/users")
public class UsuarioController {
	
	@Autowired
	private UsuarioBo bo;

	@RequestMapping(method = RequestMethod.GET)
    public DefaultRestMessage get(@RequestParam("id") String id) {
		
		if (id == null || id.equals("EMPTY")) {
			return this.bo.getAllInspectors();
		}
        
		return this.bo.findById(id);
    }
	
	@RequestMapping(method = RequestMethod.GET, path = "/profiles")
    public DefaultRestMessage getProfiles() {
		return this.bo.getAllProfiles();
    }
	
	@RequestMapping(method = RequestMethod.GET, path = "/user")
    public DefaultRestMessage getInspectorByIdUser(@RequestParam("id") Integer id) {
		return this.bo.findInspectorByIdUser(id);
    }
	
	@RequestMapping(method = RequestMethod.POST)
    public DefaultRestMessage salvar(@RequestBody InspetorModel insp) {
		return this.bo.guardar(insp);
    }
	
	@RequestMapping(method = RequestMethod.PUT)
    public DefaultRestMessage atualizar(@RequestBody InspetorModel insp) {
		return this.bo.guardar(insp);
    }
	
	
}
