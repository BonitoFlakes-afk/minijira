package com.example.minijira;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TicketService {
    private final TicketRepository repository;

    public TicketService(TicketRepository repository) {
        this.repository=repository;
    }

    public List<Ticket> getAllTickets() {
        return repository.findAll();
    }

    public Ticket createTicket(Ticket ticket) {
        return repository.save(ticket);
    }

    public Ticket updateTicket(Long id, Ticket updatedData) {
        //find out if the ticket actually exists in the database, if not throw an exception
        Ticket existingTicket = repository.findById(id)
        .orElseThrow(() -> new RuntimeException("No ticket found with id: " + id));

        //update only if the fields are not null 
        if(updatedData.getTitle() != null) {
            existingTicket.setTitle(updatedData.getTitle());
        }

        if(updatedData.getDescription() != null) {
            existingTicket.setDescription(updatedData.getDescription());
        }

        if(updatedData.getStatus() != null) {
            existingTicket.setStatus(updatedData.getStatus());
        }
        //save the updated ticket back into the database
        return repository.save(existingTicket);
    }

    public void deleteTicket(Long id) {
        repository.deleteById(id);
    }

    public List<Ticket> getTicketsByStatus(String status) {
        return repository.findByStatus(status);
    }

    public List<Ticket> getTicketsByPriority(String priority) {
        return repository.findByPriority(priority);
    }
}
