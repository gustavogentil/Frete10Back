package com.gustavo.frete10.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gustavo.frete10.domain.Frete;

@Repository
public interface FreteRepository extends JpaRepository<Frete, Integer>{
	
	@Query("SELECT obj FROM Frete obj WHERE obj.status = 'Pendente'")
	List<Frete> findAllOpen();
	
	@Query("SELECT obj FROM Frete obj WHERE obj.status = 'Entregue'")
	List<Frete> findAllClose();
	
	

}
