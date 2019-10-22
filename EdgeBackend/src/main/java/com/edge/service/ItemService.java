package com.edge.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edge.dto.ItemDTO;
import com.edge.dto.ProviderDTO;
import com.edge.mapper.ItemMapper;
import com.edge.mapper.ProviderMapper;
import com.edge.model.Provider;
import com.edge.repository.ItemRepository;
import com.edge.repository.ProviderRepository;

@Service
public class ItemService {
	
	@Autowired
	ItemRepository itemRepository;
	
	@Autowired
	ProviderRepository providerRepository;
	
	@Autowired
	ItemMapper itemMapper;
	
	@Autowired
	ProviderMapper providerMapper;

	//find all the items that meet the filter conditions
	public List<ItemDTO> findAllFilterable (String searchTerm, String itemCat, String provName, Boolean inStockOnly){
		List<ItemDTO> list= null;
		//convert all the items to itemDTO
		list= itemRepository.findAll().stream().map(i -> itemMapper.toDto(i)).collect(Collectors.toList());
		
		//filter all the items based on the search options
		return list.stream()
			.filter(i ->(searchTerm == null || searchTerm.equals("") || i.getItem_name().toLowerCase().startsWith(searchTerm.toLowerCase())))
			.filter(i ->(itemCat == null || itemCat.equals("") || i.getItem_cat().equals(itemCat)))
			.filter(i ->(provName == null || provName.equals("") || i.getProvider().getProv_name().equalsIgnoreCase(provName)))
			.filter(i->(inStockOnly == null || inStockOnly == false || i.getItem_stock() > 0))
			.collect(Collectors.toList());
		
	}
	
	//find item by id 
	public ItemDTO findOne (Long id) {
		return itemMapper.toDto(itemRepository.findById(id));
	}
	
	//create new item
	public ItemDTO save (ItemDTO item) {
		itemRepository.save(itemMapper.toEntity(item));
		return item;
	}
	
	//update item
	public ItemDTO update (ItemDTO item, Long id) {
		return itemMapper.toDto( itemRepository.save(itemMapper.toEntity(item)));
	}
	
	//delete item by id
	public void delete(Long id) {
		itemRepository.deleteById(id);
	}
	
	//find all the providers
	public List<ProviderDTO> findAllProviders(){
		List<Provider> list=providerRepository.findAll();
		return list.stream().map(p -> providerMapper.toDto(p)).collect(Collectors.toList());
	}

}
