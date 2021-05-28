package com.lemos.cursomc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lemos.cursomc.domain.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer>{

}
