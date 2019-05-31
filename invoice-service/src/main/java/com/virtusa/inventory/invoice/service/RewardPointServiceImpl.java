package com.virtusa.inventory.invoice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.virtusa.inventory.invoice.model.RewardPoint;
import com.virtusa.inventory.invoice.repository.RewardPointRepository;

/**
 * @author user
 *
 */
public class RewardPointServiceImpl implements RewardPointService {
	
	@Autowired
	RewardPointRepository rewardPointRepository;
	
	
	//save the rewardPoints
	/* (non-Javadoc)
	 * @see com.virtusa.inventory.invoiceservice.service.RewardPointService#save(com.virtusa.inventory.invoiceservice.model.RewardPoint)
	 */
	@Override
	public RewardPoint save(RewardPoint rewardPoint) {
		return rewardPointRepository.save(rewardPoint); 	
	}
	
	//fetch all rewardPoints 
	/* (non-Javadoc)
	 * @see com.virtusa.inventory.invoiceservice.service.RewardPointService#fetchAllRewardPoint()
	 */
	@Override
	public List<RewardPoint> fetchAllRewardPoint() {
		return rewardPointRepository.findAll();
	}
	
	//fetch reward point relevant to the id
	/* (non-Javadoc)
	 * @see com.virtusa.inventory.invoiceservice.service.RewardPointService#fetchById(java.lang.Integer)
	 */
	@Override
	public Optional<RewardPoint> fetchById(Integer id) {
		return rewardPointRepository.findById(id);
	}
	
	//fetch by reward value
	/* (non-Javadoc)
	 * @see com.virtusa.inventory.invoiceservice.service.RewardPointService#fetchByRewardValue(java.lang.Double)
	 */
	@Override
	public List<RewardPoint> fetchByRewardValue(Double value) {
		return rewardPointRepository.findByValue(value);
	}
	
}
