package com.virtusa.inventory.invoice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

		RewardPoint point;
		if ((point = rewardPointService.save(rewardPoint)) != null){
			return ResponseEntity.ok(point);
		}else {
			return ResponseEntity.badRequest().build();
		}
	}


	//update the reward points
	@RequestMapping(value = "/rewardpoint/{id}", method = RequestMethod.PUT)
	public ResponseEntity<RewardPoint> update(@PathVariable Integer id,@RequestBody RewardPoint rewardPoint) {
		Optional<RewardPoint> optionalRewardPoint = rewardPointService.fetchById(id);
		if (!optionalRewardPoint.isPresent()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(rewardPointService.update(id,rewardPoint));
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

