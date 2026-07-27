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
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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

        //Long userId = bid.getUser().getId();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String email = authentication.getName();

        //System.out.println("Logged in Freelancer : " + email);
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
        System.out.println("Project ID = " + project.getId());
        System.out.println("User ID = " + user.getId());
        System.out.println("Already Exists = " +
                bidRepository.existsByProjectAndUser(project, user));
        if(bidRepository.existsByProjectAndUser(project, user)) 
        {
        	//return bid;
        	throw new RuntimeException("you have already placed a bid on this project.");
        }
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