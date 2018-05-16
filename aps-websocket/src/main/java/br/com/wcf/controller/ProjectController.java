package br.com.wcf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.wcf.bo.project.ProjetoBo;
import br.com.wcf.model.messages.DefaultRestMessage;
import br.com.wcf.model.project.ProjetoModel;

@RestController
@RequestMapping("/project")
public class ProjectController {
	
	@Autowired
	private ProjetoBo bo;
	
	@RequestMapping(method = RequestMethod.GET)
    public DefaultRestMessage findById(@RequestParam("id") Integer id) {
        return this.bo.findById(id);
    }
	
	@RequestMapping(method = RequestMethod.GET, path = "/owner")
    public DefaultRestMessage findByOwner(@RequestParam("id") Integer id) {
        return this.bo.findByIdUserInspectorOwner(id);
    }
	
	@RequestMapping(method = RequestMethod.POST)
    public DefaultRestMessage salvar(@RequestBody ProjetoModel proj) {
		return this.bo.guardar(proj);
    }
	
	@RequestMapping(method = RequestMethod.PUT)
    public DefaultRestMessage atualizar(@RequestBody ProjetoModel proj) {
		return this.bo.guardar(proj);
    }

}
