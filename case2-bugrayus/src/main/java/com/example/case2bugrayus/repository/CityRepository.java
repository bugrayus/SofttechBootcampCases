package com.example.case2bugrayus.repository;

import com.example.case2bugrayus.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Long> {
}
