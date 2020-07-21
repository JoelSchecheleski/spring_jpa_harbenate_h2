package com.uppertools.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uppertools.curso.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
