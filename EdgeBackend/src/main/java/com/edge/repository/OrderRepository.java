package com.edge.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edge.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{
	List<Order> findAllByOrderline_id(int orderLine_id);
}
