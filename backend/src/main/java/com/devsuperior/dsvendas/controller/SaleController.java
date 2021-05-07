package com.devsuperior.dsvendas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsvendas.dto.SaleDTO;
import com.devsuperior.dsvendas.service.SaleService;

@RestController		//Indica que a classe é um controlador Rest
@RequestMapping(value = "/sales")		// Indica qual o caminho do recurso web
public class SaleController {
	
	@Autowired
	private  SaleService service;
	
	@GetMapping	
	
	public ResponseEntity<Page<SaleDTO>> findAll(Pageable peageble){	// Busca paginada das vendas
		Page<SaleDTO> list = service.findAll(peageble);
		return ResponseEntity.ok(list);
	}

}
