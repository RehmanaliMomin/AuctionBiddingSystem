package com.cars24.auction.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table(name = "auctionBid", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "auctionBidId"
        })
})

public class AuctionBid {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long auctionBidId;

    private String itemCode;

    private Long userID;

    private Double bidAmount;

    private Double bidResponse;

    public Long getAuctionBidId() {
        return auctionBidId;
    }

    public void setAuctionBidId(Long auctionBidId) {
        this.auctionBidId = auctionBidId;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public Double getBidAmount() {
        return bidAmount;
    }

    public void setBidAmount(Double bidAmount) {
        this.bidAmount = bidAmount;
    }

    public Double getBidResponse() {
        return bidResponse;
    }

    public void setBidResponse(Double bidResponse) {
        this.bidResponse = bidResponse;
    }
}
