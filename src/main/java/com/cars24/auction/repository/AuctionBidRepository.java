package com.cars24.auction.repository;

import com.cars24.auction.model.Auction;
import com.cars24.auction.model.AuctionBid;
import com.cars24.auction.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuctionBidRepository extends JpaRepository<AuctionBid, String> {




}
