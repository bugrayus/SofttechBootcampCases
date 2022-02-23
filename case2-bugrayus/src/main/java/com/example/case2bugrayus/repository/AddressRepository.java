package com.example.case2bugrayus.repository;

import com.example.case2bugrayus.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
