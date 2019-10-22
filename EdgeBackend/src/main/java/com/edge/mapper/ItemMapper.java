package com.edge.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.edge.dto.ItemDTO;
import com.edge.model.Item;

@Component
public class ItemMapper {

	@Autowired
	ProviderMapper providerMapper;
	
	public Item toEntity(ItemDTO dto) {
		Item item= new Item();
		item.setId(dto.getId());
		item.setItem_name(dto.getItem_name());
		item.setItem_cat(dto.getItem_cat());
		item.setItem_img(dto.getItem_img());
		item.setItem_rating(dto.getItem_rating());
		item.setItem_price(dto.getItem_price());
		item.setItem_stock(dto.getItem_stock());
		item.setProvider(providerMapper.toEntity(dto.getProvider()));
		return item;
	}
	
	public ItemDTO toDto(Item entity) {
		ItemDTO dto=new ItemDTO();
		dto.setId(entity.getId());
		dto.setItem_name(entity.getItem_name());
		dto.setItem_cat(entity.getItem_cat());
		dto.setItem_img(entity.getItem_img());
		dto.setItem_rating(entity.getItem_rating());
		dto.setItem_price(entity.getItem_price());
		dto.setItem_stock(entity.getItem_stock());
		dto.setProvider(providerMapper.toDto(entity.getProvider()));
		return dto;
	}
}
