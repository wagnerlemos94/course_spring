package com.lemos.cursomc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lemos.cursomc.domain.City;

@Repository
public interface CityRepository extends JpaRepository<City, Integer>{

}
