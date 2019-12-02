package br.com.exemplo.multiscriptbanco.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.exemplo.multiscriptbanco.service.ScriptService;
import br.com.exemplo.multiscriptbanco.view.Consulta;
import br.com.exemplo.multiscriptbanco.view.ScriptView;

@RestController
@RequestMapping("/script")
public class Script {
	
	@Autowired
	private ScriptService service;

    @PostMapping("executa")    
	public ResponseEntity<Consulta> executa(@RequestBody ScriptView script) throws SQLException {
    	return ResponseEntity.ok(service.executa(script));
	}
}
