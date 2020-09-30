package com.cars24.auction.service;

import com.cars24.auction.model.*;
import com.cars24.auction.model.request.AuctionStatus;
import com.cars24.auction.model.response.BidStatusResponse;
import com.cars24.auction.repository.AuctionBidRepository;
import com.cars24.auction.repository.AuctionRepository;
import com.cars24.auction.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class AuctionServiceImpl  implements  AuctionService{

    @Autowired
    AuctionRepository auctionRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    AuctionBidRepository auctionBidRepository;

    @Override
    public Auction getByItemCode(String itemCode) {
        return auctionRepository.findById(itemCode).get();
    }

    @Override
    public Page<Auction> getAllRunningAuctionData(AuctionStatus auctionStatus, int pageIndex, int pageSize) {
        PageRequest pageRequest=PageRequest.of(pageIndex, pageSize);
        return auctionRepository.findAuctionByStatusEquals(auctionStatus,pageRequest);
    }

    public synchronized BidStatusResponse placeBid(String itemCode, Long userId, Double bidAmount){
        Auction auction = getByItemCode(itemCode);
        User user = userRepository.getByUserId(userId);

        AuctionBid auctionBid = new AuctionBid();
        auctionBid.setUserID(user);
        auctionBid.setBidAmount(bidAmount);
        auctionBid.setItemCode(auction);

        BidStatusResponse bidStatusResponse;

        if(auction.getStatus().equals(AuctionStatus.OVER) || (auction.getLastBid()+auction.getStepRate()>bidAmount)){
            bidStatusResponse = BidStatusResponse.REJECTED;
            auctionBid.setBidResponse(bidStatusResponse);
        }
        else{
            bidStatusResponse = BidStatusResponse.ACCEPTED;
            auctionBid.setBidResponse(bidStatusResponse);
            auction.setLastBid(bidAmount);
            auctionRepository.save(auction);
        }
        auctionBidRepository.save(auctionBid);
        return bidStatusResponse;
    }

}
