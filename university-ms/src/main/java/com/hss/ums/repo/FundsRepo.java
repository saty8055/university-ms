package com.hss.ums.repo;

import com.hss.ums.entity.Funds;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FundsRepo extends JpaRepository<Funds, String> {
}
