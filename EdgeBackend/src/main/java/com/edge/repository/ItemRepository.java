package com.edge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edge.dto.ItemDTO;
import com.edge.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer>{

	ItemDTO findById(Long id);
	
	void deleteById(Long id);
}