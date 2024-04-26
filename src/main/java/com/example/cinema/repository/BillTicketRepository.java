package com.example.ThucTapLTS.repository;

import com.example.ThucTapLTS.entity.BillTicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillTicketRepository extends JpaRepository<BillTicketEntity, Integer> {
}
