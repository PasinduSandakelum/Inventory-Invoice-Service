package com.virtusa.inventory.invoice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.inventory.invoice.model.Discount;
import com.virtusa.inventory.invoice.service.DiscountService;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/imscloud")

public class DiscountConroller {
}