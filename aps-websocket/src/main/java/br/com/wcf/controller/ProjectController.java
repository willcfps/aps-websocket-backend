package br.com.wcf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import br.com.wcf.bo.project.ProjetoBo;
import br.com.wcf.model.messages.DefaultRestMessage;

@RestController
@RequestMapping("/project")
public class ProjectController {
	
	@Autowired
	private ProjetoBo bo;
	
	@RequestMapping(method = RequestMethod.GET)
    public DefaultRestMessage getProjectById(@RequestParam("id") Integer id) throws JsonProcessingException {
        return this.bo.findById(id);
    }

}
