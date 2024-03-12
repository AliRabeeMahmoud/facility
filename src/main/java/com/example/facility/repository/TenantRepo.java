package com.example.facility.repository;

import com.example.facility.model.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
@Repository
public interface TenantRepo extends JpaRepository<Tenant, BigInteger> {
}
