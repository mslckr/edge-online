package com.edge.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.edge.dto.ItemDTO;
import com.edge.dto.ProviderDTO;
import com.edge.service.ItemService;

@RestController
@RequestMapping("/api")
public class ItemController {

	@Autowired
	private ItemService itemService;
	
	@GetMapping("/items")
	public List<ItemDTO> getAllItems(@RequestParam(name= "name", required = false) String searchTerm,
			@RequestParam(name= "category", required = false) String itemCat,@RequestParam(name= "provider", required = false) String provName,
			@RequestParam(name= "inStockOnly", required = false)Boolean inStockOnly){
		return itemService.findAllFilterable(searchTerm, itemCat, provName, inStockOnly);
	}
	
	@GetMapping("/items/{id}")
	private ResponseEntity<ItemDTO> getAllItems(@PathVariable long id){
		ItemDTO item=itemService.findOne(id);
		return ResponseEntity.ok(item);
	}
	
	@PostMapping("/items")
	private ResponseEntity<ItemDTO> addItem(@RequestBody @Valid ItemDTO item) throws URISyntaxException {
		ItemDTO r= itemService.save(item); 
		return ResponseEntity.created(new URI("/api/items/" + r.getId())).body(r);
	}
	
	@PutMapping("/items/{id}")
	private ResponseEntity<ItemDTO> updateItem(@RequestBody ItemDTO item){
		ItemDTO r= itemService.save(item);
		return ResponseEntity.ok().body(r);
	}
	
	@DeleteMapping("/items/{id}")
	private ResponseEntity<ItemDTO> deleteItem(long id){
		itemService.delete(id);
		return ResponseEntity.ok().build();
	}
	@GetMapping("/providers")
	private ResponseEntity<List<ProviderDTO>> getAllProviders(){
		List<ProviderDTO> r=itemService.findAllProviders();
		return ResponseEntity.ok().body(r);
	}
}
