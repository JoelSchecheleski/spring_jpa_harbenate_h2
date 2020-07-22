package com.uppertools.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uppertools.curso.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
