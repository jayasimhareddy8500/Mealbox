package com.mealbox.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mealbox.entity.Vendor;

@Repository
public interface VendorRepository extends JpaRepository<Vendor, Integer> {

}
