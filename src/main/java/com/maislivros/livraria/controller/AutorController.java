package com.maislivros.livraria.controller;

/**
 *
 * @author Rangel
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maislivros.livraria.entity.Autor;
import com.maislivros.livraria.service.AutorService;

@RestController // indica que é um controller
@RequestMapping(value = "/autor") // traça a rota do controller
public class AutorController {
	@Autowired // injeção de dependência, não precisa instanciar
	private AutorService service;
        
        //usado para rotas Get, em seguida a url e o parâmetro
        @GetMapping(value = "/boasVindas/{nome}") 
        public String boasVindas(@PathVariable String nome){
        //metodo publico, tipo de retorno, e o que entra para o metodo, 
            return "Seja bem vindo " + nome;
        }
	
	@PostMapping
	public ResponseEntity<Autor> create(@RequestBody Autor obj){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.create(obj));
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		
		service.delete(id);
		
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Autor> getId(@PathVariable Long id){
		return ResponseEntity.ok().body(service.getId(id));
	}
	
	@GetMapping
	public ResponseEntity<List<Autor>> getAll(){
		return ResponseEntity.ok().body(service.getAll());
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Autor> update(@PathVariable Long id, @RequestBody Autor obj){
		obj.setId(id);
		return ResponseEntity.ok().body(service.update(obj));
	}
}