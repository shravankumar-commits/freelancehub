package com.freelancehub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.freelancehub.model.Bid;

public interface BidRepository extends JpaRepository<Bid, Long> {

}