package com.edge.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edge.dto.OrderDTO;
import com.edge.model.Order;
import com.edge.model.OrderLine;

public interface OrderRepository extends JpaRepository<Order, Long>{
	List<OrderDTO> findAllByOrderline(OrderLine orderLine);
}
