package com.cars24.auction.model;



import com.cars24.auction.model.request.AuctionStatus;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "auction")
public class Auction {

    @Id
    private String itemCode;

    private Double minBasePrice;

    private Double stepRate;

    private AuctionStatus status;

    private Double lastBid;

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public Double getMinBasePrice() {
        return minBasePrice;
    }

    public void setMinBasePrice(Double minBasePrice) {
        this.minBasePrice = minBasePrice;
    }

    public Double getStepRate() {
        return stepRate;
    }

    public void setStepRate(Double stepRate) {
        this.stepRate = stepRate;
    }

    public AuctionStatus getStatus() {
        return status;
    }

    public void setStatus(AuctionStatus status) {
        this.status = status;
    }

    public Double getLastBid() {
        return lastBid;
    }

    public void setLastBid(Double lastBid) {
        this.lastBid = lastBid;
    }
}


