package com.generation.salveraiz.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.generation.salveraiz.model.Tema;
import com.generation.salveraiz.repository.TemaRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/tema")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TemaController {
	@Autowired
	private TemaRepository temarepository;

	 @GetMapping
	    public ResponseEntity<List<Tema>> getAll(){
	        return ResponseEntity.ok(temarepository.findAll());
	    }
	 
	  @GetMapping("/{id}")
	    public ResponseEntity<Tema> getById(@PathVariable Long id){
	        return temarepository.findById(id)
	            .map(resposta -> ResponseEntity.ok(resposta))
	            .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	    }
	  
	  @GetMapping("/descricao/{descricao}")
	    public ResponseEntity<List<Tema>> getByTitle(@PathVariable 
	    String descricao){
	        return ResponseEntity.ok(temarepository
	            .findAllByDescricaoContainingIgnoreCase(descricao));
	    }
	  
	  @PostMapping
	    public ResponseEntity<Tema> post(@Valid @RequestBody Tema tema){
	        return ResponseEntity.status(HttpStatus.CREATED)
	                .body(temarepository.save(tema));
	  }
	  
	  @PutMapping
	    public ResponseEntity<Tema> put(@Valid @RequestBody Tema tema){
	        return temarepository.findById(tema.getId())
	            .map(resposta -> ResponseEntity.status(HttpStatus.CREATED)
	            .body(temarepository.save(tema)))
	            .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	    }
	  
	  @ResponseStatus(HttpStatus.NO_CONTENT)
	    @DeleteMapping("/{id}")
	    public void delete(@PathVariable Long id) {
	        Optional<Tema> tema = temarepository.findById(id);
	        
	        if(tema.isEmpty())
	            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
	        
	        temarepository.deleteById(id);              
	    }
}
