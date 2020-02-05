package com.mealbox.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mealbox.constant.Constant;
import com.mealbox.dto.ItemCategoryDto;
import com.mealbox.dto.VendorListResponseDto;
import com.mealbox.service.VendorService;

/**
 * In this Rest controller we can handled the methods of get item list by
 * vendorId
 * 
 * @author Govindasamy.C
 * @since 05-02-2020
 * @version V1.1
 *
 */
@RestController
@RequestMapping("/vendors")
@CrossOrigin
public class VendorController {

	@Autowired
	VendorService vendorService;

	/**
	 * Get the all vendor item list based on the vendorId
	 * 
	 * @param vendorId - Id of the vendor
	 * @return return the status code and message along with the vendor item list
	 *         details.
	 * @author Govindasamy.C
	 * @since 05-02-2020
	 * 
	 */
	@GetMapping("/{vendorId}")
	public ResponseEntity<VendorListResponseDto> getItemListByVendorId(@PathVariable Integer vendorId) {
		List<ItemCategoryDto> itemCategorylist = vendorService.getItemListByVendorId(vendorId);
		VendorListResponseDto vendorListResponseDto = new VendorListResponseDto();
		if (itemCategorylist.isEmpty()) {
			vendorListResponseDto.setStatusCode(HttpStatus.NOT_FOUND.value());
			vendorListResponseDto.setMessage(Constant.NO_RECORDS_FOUND);
		} else {
			vendorListResponseDto.setStatusCode(HttpStatus.OK.value());
			vendorListResponseDto.setMessage(Constant.SUCCESS_MESSAGE);
		}
		return new ResponseEntity<>(vendorListResponseDto, HttpStatus.OK);
}