package com.virtusa.inventory.invoice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.inventory.invoice.model.RewardPoint;
import com.virtusa.inventory.invoice.repository.RewardPointRepository;
import org.springframework.stereotype.Service;

/**
 * @author user
 *
 */
@Service
public class RewardPointServiceImpl implements RewardPointService {
	
	@Autowired
	RewardPointRepository rewardPointRepository;
	
	
	//save the rewardPoints
	/* (non-Javadoc)
	 * @see com.virtusa.inventory.invoiceservice.service.RewardPointService#save(com.virtusa.inventory.invoiceservice.model.RewardPoint)
	 */
	@Override
	public RewardPoint save(RewardPoint rewardPoint) {

		//return rewardPointRepository.save(rewardPoint);

		boolean match = false;
		List<RewardPoint> rewardPoints = rewardPointRepository.findAll();

		for (RewardPoint point : rewardPoints) {
			if (point.getValue().equals(rewardPoint.getValue())) {
				match = true;
				break;
			} else {
				match = false;
			}
		}
		if (rewardPoint.getValue() != null) {
			if (match == false) {
				return rewardPointRepository.save(rewardPoint);
			} else {
				return null;
			}
		} else {
			return null;
		}

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
	
	@Override
	public RewardPoint update(Integer id, RewardPoint rewardPoint){
//		return rewardPointRepository.save(rewardPoint);

		System.out.println("calling service update");


		boolean match = false;
		List<RewardPoint> rewardPoints = rewardPointRepository.findAll();

		for (RewardPoint point : rewardPoints) {
			if (point.getValue().equals(rewardPoint.getValue())) {
				match = true;
				break;
			} else {
				match = false;
			}
		}
		if (rewardPoint.getValue() != null) {
			if (match == true) {

				System.out.println("awaaaa");
				RewardPoint point = new RewardPoint();
				point.setId(id);
				point.setValue(rewardPoint.getValue());
				point.setPoint(rewardPoint.getPoint());
				return rewardPointRepository.save(point);
			} else {
				return null;
			}
		} else {
			return null;
		}

	}


}

