package com.cars24.auction.model;

import com.cars24.auction.model.response.BidStatusResponse;

import javax.persistence.*;


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


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "itemCode", nullable = false, referencedColumnName = "itemCode")
    private Auction itemCode;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userID", nullable = false, referencedColumnName = "userID")
    private User userID;

    private Double bidAmount;

    private BidStatusResponse bidResponse;

    public Long getAuctionBidId() {
        return auctionBidId;
    }

    public void setAuctionBidId(Long auctionBidId) {
        this.auctionBidId = auctionBidId;
    }

    public Double getBidAmount() {
        return bidAmount;
    }

    public void setBidAmount(Double bidAmount) {
        this.bidAmount = bidAmount;
    }

    public BidStatusResponse getBidResponse() {
        return bidResponse;
    }

    public void setBidResponse(BidStatusResponse bidResponse) {
        this.bidResponse = bidResponse;
    }

    public Auction getItemCode() {
        return itemCode;
    }

    public void setItemCode(Auction itemCode) {
        this.itemCode = itemCode;
    }

    public User getUserID() {
        return userID;
    }

    public void setUserID(User userID) {
        this.userID = userID;
    }
}
