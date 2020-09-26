package com.cars24.auction.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("auction")
public class AuctionController {


    @RequestMapping(value = "/",method = RequestMethod.GET)
    public ResponseEntity getRunningAuctions(@RequestParam String status) {


        return ResponseEntity
                .status(HttpStatus.FORBIDDEN)
                .body("test");
    }


    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity placeBid(){


        return ResponseEntity.status(HttpStatus.ACCEPTED).body("");

    }


}
