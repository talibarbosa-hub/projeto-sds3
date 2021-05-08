package com.devsuperior.dsvendas.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsvendas.dto.SaleDTO;
import com.devsuperior.dsvendas.dto.SaleSuccessDTO;
import com.devsuperior.dsvendas.dto.SaleSumDTO;
import com.devsuperior.dsvendas.entities.Sale;
import com.devsuperior.dsvendas.repositories.SaleRepository;
import com.devsuperior.dsvendas.repositories.SellerRepository;

@Service	// Componente do sistema para ser injetado em outros componentes
public class SaleService {
	@Autowired		// instacia injetada automaticamente	
	private SaleRepository repository;		
	
	@Autowired 
	private  SellerRepository sellerRepository;

	@Transactional(readOnly = true)	// garantir de que toda operação seja resolvida no service, e o readOnly garante que não ocorra locking no BD
	public Page<SaleDTO> findAll(Pageable pageable){	// Atributo para busca paginada 
		sellerRepository.findAll();		//  vendedores ficam em memoria antes de buscar as vendas evita de ficar buscando no BD por cada vendedor 
		Page<Sale> result = repository.findAll(pageable);
		return result.map(x -> new SaleDTO(x));	// 
		
	}
	
	@Transactional(readOnly = true)
	public List<SaleSumDTO> amountGroupedBySeller(){
		return repository.amountGroupedBySeller();
		
	}
	
	@Transactional(readOnly = true)
	public List<SaleSuccessDTO> successGroupedBySeller(){
		return repository.successGroupedBySeller();
		
	}
	
}
