package com.virtusa.inventory.invoice.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import com.virtusa.inventory.invoice.model.RewardPoint;


public interface RewardPointService {

	//save the rewardPoints
	RewardPoint save(RewardPoint rewardPoint);

	//fetch all rewardPoints 
	List<RewardPoint> fetchAllRewardPoint();

	//fetch reward point relevant to the id
	Optional<RewardPoint> fetchById(Integer id);

	//fetch by reward value
//	List<RewardPoint> fetchByRewardValue(Double value);

	//update the reward point
	RewardPoint update(Integer id, RewardPoint rewardPoint);

	//delete the reward point
	void delete(Integer id);

	Double getRewardPoint(BigDecimal total);

}