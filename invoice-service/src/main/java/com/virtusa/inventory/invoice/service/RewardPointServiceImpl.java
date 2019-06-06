package com.virtusa.inventory.invoice.service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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


		List<RewardPoint> rewardPoints = rewardPointRepository.findAll();
		if (rewardPoints.stream().noneMatch(point -> point.getValue().equals(rewardPoint.getValue()))) {
			return rewardPointRepository.save(rewardPoint);
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
//	@Override
//	public List<RewardPoint> fetchByRewardValue(Double value) {
//		return rewardPointRepository.findByValue(value);
//	}
//
	@Override
	public RewardPoint update(Integer id, RewardPoint rewardPoint) {

		List<RewardPoint> rewardPoints = rewardPointRepository.findAll();

		if (rewardPoints.stream().anyMatch(point -> point.getValue().equals(rewardPoint.getValue()))) {
			RewardPoint point = new RewardPoint();
			point.setId(id);
			point.setValue(rewardPoint.getValue());
			point.setPoint(rewardPoint.getPoint());

			return rewardPointRepository.save(point);
		} else {
			return null;
		}

	}

	@Override
	public void delete(Integer id) {
		rewardPointRepository.deleteById(id);
	}

	@Override
	public Double getRewardPoint(BigDecimal amount) {

		List<RewardPoint> rewardPoints = rewardPointRepository.findAll();

		//BigDecimal total = new BigDecimal(2500);
		RewardPoint point = new RewardPoint();

		rewardPoints = rewardPoints.stream()
				.sorted(Comparator.comparing(RewardPoint::getValue))
				.filter(p -> amount.compareTo(BigDecimal.valueOf(p.getValue())) >= 0)
				.collect(Collectors.toList());

		point = rewardPoints.get(rewardPoints.size() - 1);


//        List<Integer> points = new ArrayList<>();
//        pointList.forEach(System.out::println);

//        reward.entrySet().stream()
//                .filter(p -> p.getValue().intValue() > total.intValue())
//                .peek(v-> points.add(v.getKey()))
//                .findFirst()
//                .get();
		return point.getPoint();
		//.getPoint());

	}
}


