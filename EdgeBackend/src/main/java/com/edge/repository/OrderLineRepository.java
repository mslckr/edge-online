package com.edge.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edge.model.OrderLine;

public interface OrderLineRepository extends JpaRepository<OrderLine, Integer>{

}
