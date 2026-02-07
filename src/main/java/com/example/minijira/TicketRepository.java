package com.example.minijira;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository 
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    List<Ticket> findByPriority(String priority);
    List<Ticket> findByStatus(String status);
}
