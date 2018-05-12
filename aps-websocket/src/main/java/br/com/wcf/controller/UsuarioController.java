package br.com.wcf.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
@RequestMapping("/user")
public class UsuarioController {

	@RequestMapping(method = RequestMethod.GET)
    public String test() throws JsonProcessingException {
        return "oi";
    }
}
