package com.freelancehub.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.freelancehub.model.Bid;
import com.freelancehub.repository.BidRepository;
import com.freelancehub.model.Project;
import com.freelancehub.repository.ProjectRepository;
import com.freelancehub.model.User;
import com.freelancehub.repository.UserRepository;
@Service
public class BidService {

    @Autowired
    private BidRepository bidRepository;
    
    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private UserRepository userRepository;
    public List<Bid> getAllBids() {
        return bidRepository.findAll();
    }

    public Bid addBid(Bid bid)
    {
    	System.out.println("Project = " + bid.getProject());
    	System.out.println("User = " + bid.getUser());
    	Long projectId = bid.getProject().getId();

        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new RuntimeException("Project not found"));

        Long userId = bid.getUser().getId();

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        bid.setProject(project);
        bid.setUser(user);

        return bidRepository.save(bid);
    }

    public Bid getBidById(Long id) {
        return bidRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bid not found"));
    }

    public void deleteBid(Long id) {
        bidRepository.deleteById(id);
    }
    public List<Bid> getBidsByUserId(Long userId)
    {
        return bidRepository.findByUserId(userId);
    }

    public List<Bid> getBidsByProjectId(Long projectId)
    {
        return bidRepository.findByProjectId(projectId);
    }
}