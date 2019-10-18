package com.edge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edge.repository.ItemRepository;
import com.edge.repository.ProviderRepository;

@Service
public class ItemService {
	
	@Autowired
	ItemRepository itemRepository;
	
	@Autowired
	ProviderRepository providerRepository;
	
	@Autowired
	
	
	
	List<ItemDTO> findAllFilterable (String searchTerm, String itemCat, String provName, Boolean inStockOnly){
		return 
	}


}
