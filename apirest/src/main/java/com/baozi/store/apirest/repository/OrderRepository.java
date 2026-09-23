package com.baozi.store.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.baozi.store.apirest.model.Order;

@Repository
public interface OrderRepository extends JpaRepository <Order, Long> {

}
