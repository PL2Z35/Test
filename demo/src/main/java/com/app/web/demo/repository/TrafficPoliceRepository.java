package com.app.web.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.app.web.demo.entity.TrafficPolice;

@Repository
public interface TrafficPoliceRepository extends JpaRepository<TrafficPolice,Long>{
    
}