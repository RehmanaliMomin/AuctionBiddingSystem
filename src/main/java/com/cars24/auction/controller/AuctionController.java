package com.cars24.auction.controller;


import com.cars24.auction.model.Auction;
import com.cars24.auction.model.request.AuctionStatus;
import com.cars24.auction.model.request.PlaceBidRequest;
import com.cars24.auction.model.response.BidStatusResponse;
import com.cars24.auction.model.response.Response;
import com.cars24.auction.service.AuctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("auction")
public class AuctionController {

    @Autowired
    AuctionService auctionService;

    @RequestMapping(value = "",method = RequestMethod.GET)
    public ResponseEntity getRunningAuctions(@RequestParam AuctionStatus status,int pageIndex) {
        Response responseObject = new Response();
        try{
            Page<Auction> auctionPage = auctionService.getAllRunningAuctionData(status,pageIndex,5);
            responseObject.setStatus(true);
            responseObject.setResponseObject(auctionPage);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(responseObject);
        }
        catch (Exception e){
            responseObject.setMessage(e.getMessage());
            responseObject.setStatus(false);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseObject);
        }
    }


    @RequestMapping(value = "/{itemCode}/bid", method = RequestMethod.POST)
    public ResponseEntity placeBid(@PathVariable String itemCode, @RequestBody PlaceBidRequest placeBidRequest){

        Response responseObject = new Response();
        HttpStatus httpStatus;
        try{
            BidStatusResponse response = auctionService.placeBid(itemCode,placeBidRequest.getUserId(),placeBidRequest.getBidAmount());

            if(response.equals(BidStatusResponse.ACCEPTED)){
                httpStatus = HttpStatus.ACCEPTED;
            }
            else if(response.equals(BidStatusResponse.REJECTED)){
                httpStatus = HttpStatus.NOT_ACCEPTABLE;
            }
            else{
                httpStatus = HttpStatus.NOT_FOUND;
            }
            responseObject.setStatus(true);
            responseObject.setResponseObject(response);
            return ResponseEntity.status(httpStatus).body(responseObject);
        }
        catch (Exception e){
            responseObject.setMessage(e.getMessage());
            responseObject.setStatus(false);
            httpStatus =  HttpStatus.INTERNAL_SERVER_ERROR;
            return ResponseEntity.status(httpStatus).body(responseObject);
        }

    }
}
