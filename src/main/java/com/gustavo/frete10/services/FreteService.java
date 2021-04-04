package com.gustavo.frete10.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gustavo.frete10.domain.Frete;
import com.gustavo.frete10.repositories.FreteRepository;

@Service
public class FreteService {
	
	@Autowired
	private FreteRepository repository;
	
	public Frete findById(Integer id) {
		Optional<Frete> obj = repository.findById(id);
		return obj.orElse(null);
	}

	public List<Frete> findAllOpen() {
		List<Frete> list = repository.findAllOpen();
		return list;
	}
	public List<Frete> findAllClose() {
		List<Frete> list = repository.findAllClose();
		return list;
	}
	
	public List<Frete> findAll() {
		List<Frete> list = repository.findAll();
		return list;
	}

	public void  delete(Integer id) {
		repository.deleteById(id);
	}

	public Frete create(Frete obj) {
		obj.setId(null);
		return repository.save(obj);
	}

	public Frete update(Integer id, Frete obj) {
		Frete newObj = findById(id);
		newObj.setDataOcorrencia(obj.getDataOcorrencia());
		newObj.setDescricao(obj.getDescricao());
		newObj.setDestino(obj.getDestino());
		newObj.setOcorrencia(obj.getOcorrencia());
		newObj.setOrigem(obj.getOrigem());
		newObj.setPeso(obj.getPeso());
		newObj.setStatus(obj.getStatus());
		newObj.setValor(obj.getValor());
		return repository.save(newObj);
	}

}
