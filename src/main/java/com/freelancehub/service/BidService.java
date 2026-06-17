package com.freelancehub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.freelancehub.model.Bid;
import com.freelancehub.repository.BidRepository;
import com.freelancehub.model.Project;
import com.freelancehub.repository.ProjectRepository;

@Service
public class BidService {

    @Autowired
    private BidRepository bidRepository;
    
    @Autowired
    private ProjectRepository projectRepository;
    
    public List<Bid> getAllBids() {
        return bidRepository.findAll();
    }

    public Bid addBid(Bid bid)
    {
        Long projectId = bid.getProject().getId();

        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new RuntimeException("Project not found"));

        bid.setProject(project);

        return bidRepository.save(bid);
    }

    public Bid getBidById(Long id) {
        return bidRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bid not found"));
    }

    public void deleteBid(Long id) {
        bidRepository.deleteById(id);
    }
}