package com.cars24.auction.repository;
import com.cars24.auction.model.Auction;
import com.cars24.auction.model.request.AuctionStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuctionRepository extends JpaRepository<Auction, String>{

     public Page<Auction> findAuctionByStatusEquals(AuctionStatus auctionStatus, Pageable pageable);

}
