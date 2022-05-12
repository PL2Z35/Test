package com.app.web.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.app.web.demo.entity.Highway;

@Repository
public interface HighwayRepository extends JpaRepository<Highway,Integer>{
    
}
