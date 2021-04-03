package com.gustavo.frete10.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gustavo.frete10.domain.Frete;
import com.gustavo.frete10.services.FreteService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/frete")
public class FreteResource {
	
	@Autowired
	private FreteService service;
		
	@GetMapping(value = "/{id}")
	public ResponseEntity<Frete> findById(@PathVariable Integer id){
		Frete obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping(value = "/pendente")
	public ResponseEntity<List<Frete>> listOpen(){
		List<Frete> list = service.findAllOpen();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/entregue")
	public ResponseEntity<List<Frete>> listClose(){
		List<Frete> list = service.findAllClose();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping
	public ResponseEntity<List<Frete>> listAll(){
		List<Frete> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping
	public ResponseEntity<Frete> create(@RequestBody Frete obj){
		obj = service.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Frete> update(@PathVariable Integer id, @RequestBody Frete obj){
		Frete newObj = service.update(id, obj);
		return ResponseEntity.ok().body(newObj);		
		
	}

}
