package com.freelancehub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.freelancehub.model.Bid;
import com.freelancehub.service.BidService;

@RestController
public class BidController {

    @Autowired
    private BidService bidService;

    @GetMapping("/bids")
    public List<Bid> getAllBids() {
        return bidService.getAllBids();
    }

    @PostMapping("/bids")
    public Bid addBid(@RequestBody Bid bid) {
        return bidService.addBid(bid);
    }

    @GetMapping("/bids/{id}")
    public Bid getBidById(@PathVariable Long id) {
        return bidService.getBidById(id);
    }

    @DeleteMapping("/bids/{id}")
    public String deleteBid(@PathVariable Long id) {
        bidService.deleteBid(id);
        return "Bid deleted successfully";
    }
}