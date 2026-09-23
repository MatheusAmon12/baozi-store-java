package com.baozi.store.apirest.repository;

import org.springframework.stereotype.Repository;

import com.baozi.store.apirest.model.Client;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ClientRepository extends JpaRepository <Client, Long> {

}
