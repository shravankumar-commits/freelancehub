package com.freelancehub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.freelancehub.model.Bid;
import java.util.List;
import com.freelancehub.model.Project;
import com.freelancehub.model.User;
public interface BidRepository extends JpaRepository<Bid, Long> {
	  List<Bid> findByUserId(Long userId);

	    List<Bid> findByProjectId(Long projectId);
	    boolean existsByProjectAndUser(Project project,User user);
}