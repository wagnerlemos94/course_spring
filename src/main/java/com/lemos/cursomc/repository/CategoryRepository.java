package com.lemos.cursomc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lemos.cursomc.domain.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
