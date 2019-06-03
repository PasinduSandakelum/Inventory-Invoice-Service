package com.virtusa.inventory.invoice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.virtusa.inventory.invoice.model.RewardPoint;
import com.virtusa.inventory.invoice.service.RewardPointService;

@RestController
@RequestMapping(value = "/imscloud")
public class RewardPointController {

	@Autowired
	RewardPointService rewardPointService;


	//save reward points
	@RequestMapping(value = "/rewardpoint", method = RequestMethod.POST)
	public ResponseEntity<RewardPoint> save(@RequestBody RewardPoint rewardPoint) {

		boolean match = false;
		List<RewardPoint> rewardPoints = rewardPointService.fetchAllRewardPoint();

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
				return ResponseEntity.ok(rewardPointService.save(rewardPoint));
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

	//fetch all reward points
	@RequestMapping(value = "/rewardpoint", method = RequestMethod.GET)
	public List<RewardPoint> fetchAll() {
		return rewardPointService.fetchAllRewardPoint();

	}

	//fetch reward points for a given id
	@RequestMapping(value = "/rewardpoint/{id}", method = RequestMethod.GET)
	public ResponseEntity<Optional<RewardPoint>> fetchOne(@PathVariable Integer id) {

		Optional<RewardPoint> optional =  rewardPointService.fetchById(id);

		if(optional.isPresent()) {
			return ResponseEntity.ok(optional);
		}else {
			return null;
		}

	}

	//fetch rewad point for a rlevant given value
	@RequestMapping(value = "/rewardpoint/value", method = RequestMethod.GET)
	public List<RewardPoint> fetchByValue(Double rewardValue) {
		return rewardPointService.fetchByRewardValue(rewardValue);

	}



}

