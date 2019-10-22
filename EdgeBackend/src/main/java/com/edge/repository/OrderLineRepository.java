package com.edge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edge.model.OrderLine;

@Repository
public interface OrderLineRepository extends JpaRepository<OrderLine, Integer>{

}
