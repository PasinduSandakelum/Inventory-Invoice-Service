package com.virtusa.inventory.invoice.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.virtusa.inventory.invoice.model.RewardPoint;
import java.lang.Double;
import java.util.List;

public interface RewardPointRepository extends JpaRepository<RewardPoint, Integer>{
	
	List<RewardPoint> findByValue(Double value);
}
