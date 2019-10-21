package com.edge.mapper;

import org.springframework.stereotype.Component;


import com.edge.dto.ProviderDTO;
import com.edge.model.Provider;
@Component
public class ProviderMapper {

	public Provider toEntity(ProviderDTO dto) {
		Provider provider= new Provider();
		provider.setId(dto.getId());
		provider.setProv_name(dto.getProv_name());
		provider.setProv_addr(dto.getProv_addr());
		provider.setProv_link(dto.getProv_link());
		provider.setProv_logo(dto.getProv_logo());
		return provider;
	}
	
	public ProviderDTO toDto(Provider entity) {
		ProviderDTO dto= new ProviderDTO();
		dto.setId(entity.getId());
		dto.setProv_name(entity.getProv_name());
		dto.setProv_addr(entity.getProv_addr());
		dto.setProv_link(entity.getProv_link());
		dto.setProv_logo(entity.getProv_logo());
		return dto;
	}
}
