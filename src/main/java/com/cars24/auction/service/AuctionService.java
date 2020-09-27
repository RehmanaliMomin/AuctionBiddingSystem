package com.cars24.auction.service;

import com.cars24.auction.model.Auction;
import com.cars24.auction.model.request.AuctionStatus;
import com.cars24.auction.model.response.BidStatusResponse;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public interface AuctionService {

    Auction getByItemCode(String itemCode);

    Page<Auction> getAllRunningAuctionData(AuctionStatus auctionStatus, int pageIndex, int pageSize);

    BidStatusResponse placeBid(String itemCode, Long userId, Double bidAmount);

}
