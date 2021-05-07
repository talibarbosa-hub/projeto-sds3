package com.devsuperior.dsvendas.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.dsvendas.dto.SellerDTO;
import com.devsuperior.dsvendas.entities.Seller;
import com.devsuperior.dsvendas.repositories.SellerRepository;

@Service	// Componente do sistema para ser injetado em outros componentes
public class SellerService {
	@Autowired		// instacia injetada automaticamente	
	private SellerRepository repository;		
	

	public List<SellerDTO> findAll(){	// repository retorna uma lista de entidades, converter a lista de Seller para SellerDTO
		List<Seller> result = repository.findAll();
		return result.stream().map(x -> new SellerDTO(x)).collect(Collectors.toList());	// 
		
	}
	
}
