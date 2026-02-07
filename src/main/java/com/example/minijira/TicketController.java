package com.example.minijira;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;



@RestController 
@RequestMapping("/tickets")
public class TicketController {
    
    private final TicketService service;
    private final ProjectService projectservice; 
    public TicketController(TicketService service, ProjectService projectservice){
        this.service=service; 
        this.projectservice= projectservice;
    }

    // @PostMapping
    // public Ticket createTicket(@RequestBody Ticket ticket) {
    //     return service.createTicket(ticket);
    // }

    //The handshake between Ticket and Project
    @PostMapping("project/{projectId}")
    public Ticket createTicketForProject(@PathVariable Long projectId, @RequestBody Ticket ticket) {
        Project project = projectservice.getProjectById(projectId);
        ticket.setProject(project);
        return service.createTicket(ticket);
    }

    @GetMapping
    public List<Ticket>getAll() {
        return service.getAllTickets();
    }

    @PutMapping("/{id}")
    public Ticket updateTicket(@PathVariable Long id, @RequestBody Ticket ticket) {
        return service.updateTicket(id, ticket);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteTicket(id);
    }

   @GetMapping("/status/{status}")    
    public List<Ticket> getTicketsByStatus(@PathVariable String status) {
        return service.getTicketsByStatus(status);
    }

    @GetMapping("/priority/{priority}")    
    public List<Ticket> getTicketsByPriority(@PathVariable String priority) {
        return service.getTicketsByPriority(priority);
    }
    
}
