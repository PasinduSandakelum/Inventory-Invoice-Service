package com.virtusa.inventory.invoiceservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * @author user
 *
 */

@Entity
public class RewardPoint {
	
	/**
	 * @id unique value for point reward. 
	 *
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	
	/**
	 * @value value that use to get the relevant point.
	 *
	 */
	@NotNull
	Double value;
	
	/**
	 * @point relevant point precentage to the  price value
	 *
	 */
	
	@NotNull
	Double point;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public Double getPoint() {
		return point;
	}

	public void setPoint(Double point) {
		this.point = point;
	}
	
	
	

}
