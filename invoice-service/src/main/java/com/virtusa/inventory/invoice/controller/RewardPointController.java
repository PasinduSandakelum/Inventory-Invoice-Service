package com.virtusa.inventory.invoice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.inventory.invoice.model.RewardPoint;
import com.virtusa.inventory.invoice.service.RewardPointService;

@RestController
@RequestMapping(value = "imscloud")
public class RewardPointController {
	
	@Autowired
	RewardPointService rewardPointService;
	
	
	@RequestMapping(value = "/rewardpoint",method = RequestMethod.POST)
	public RewardPoint Save(@RequestBody RewardPoint rewardPoint) {
		
		boolean match = false;
		
		List<RewardPoint> rewardPoints = rewardPointService.fetchAllRewardPoint();
		
		for (RewardPoint rewardPoint2 : rewardPoints) {
			
		}
		
		if (match) {
			
		} else {

		}
		
		
		
		return rewardPointService.save(rewardPoint);
	}
}
