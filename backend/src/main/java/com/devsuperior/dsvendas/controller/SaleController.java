package com.devsuperior.dsvendas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsvendas.dto.SaleDTO;
import com.devsuperior.dsvendas.dto.SaleSuccessDTO;
import com.devsuperior.dsvendas.dto.SaleSumDTO;
import com.devsuperior.dsvendas.service.SaleService;

@RestController		//Indica que a classe é um controlador Rest
@RequestMapping(value = "/sales")		// Indica qual o caminho do recurso web
public class SaleController {
	
	@Autowired
	private  SaleService service;
	
	@GetMapping	
	
	public ResponseEntity<Page<SaleDTO>> findAll(Pageable peageble){	// Busca paginada
		Page<SaleDTO> list = service.findAll(peageble);
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(value ="/amount-by-seller")
		
		public ResponseEntity<List<SaleSumDTO>> amountGroupedBySeller(){	// Busca com total por vendedor
		List<SaleSumDTO> list = service.amountGroupedBySeller();
			return ResponseEntity.ok(list);
		}
	
	@GetMapping(value ="/success-by-seller")
	
	public ResponseEntity<List<SaleSuccessDTO>> successGroupedBySeller(){	// Busca com taxa de sucesso,  visita x vendas 
		List<SaleSuccessDTO> list = service.successGroupedBySeller();
		return ResponseEntity.ok(list);
	}
	
	
}
