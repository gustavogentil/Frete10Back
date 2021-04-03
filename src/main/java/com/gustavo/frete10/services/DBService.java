package com.gustavo.frete10.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gustavo.frete10.domain.Frete;
import com.gustavo.frete10.repositories.FreteRepository;

@Service
public class DBService {
	
	@Autowired
	private FreteRepository freteRepository;

	
	public void instanciaBaseDeDados() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Frete f1 = new Frete(null, "Fardos | Acucar","Sao Goncalo - RJ", "Sao Paulo - SP", 1500, 14500, sdf.parse("25/04/2021"), false, "Em rota");
		Frete f2 = new Frete(null, "Peças Automotivas","Cajamar - SP", "Porto Alegra - RS", 5500, 5000, sdf.parse("23/04/2021"), true, "concluido");
		Frete f3 = new Frete(null, "Papel Higienico","Arujá - SP", "Uberlândia - SP", 500, 1500, sdf.parse("25/03/2021"), true,"entrega concluida, pneu furado no dia 20/03. concerto do radiador no dia 18/03");
		Frete f4 = new Frete(null, "Garrafa | Caixaria","Sao Goncalo - RJ", "Sao Paulo - SP", 1500, 9850, sdf.parse("01/02/2021"), true,"sem ocorrencias, entregue no prazo");
		Frete f5 = new Frete(null, "Material Quimico","Guarulhos - SP", "Aparecida de Goiânia - GO", 3500, 20000, sdf.parse("25/01/2021"), true, "sem ocorrencias");
		
		freteRepository.saveAll(Arrays.asList(f1, f2, f3, f4, f5));
	}

}
