package com.ComexUp.Aplicacion.domain.service;

import com.ComexUp.Aplicacion.domain.dto.Ticket;
import com.ComexUp.Aplicacion.domain.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    public List<Ticket> getAll(){
        return ticketRepository.getAll();
    }

    public Ticket getTicket(int ticketId){
        return ticketRepository.getTicket(ticketId);
    }
    public List<Ticket> getByUser(String email){
        return ticketRepository.getByUser(email);
    }
    public String updateTicket(Ticket ticket){
        return ticketRepository.save(ticket);
    }

    public String save(Ticket ticket){
        return ticketRepository.save(ticket);
    }
    public Boolean delete(int ticketId){
        ticketRepository.delete(ticketId);
        return true;
        }
    }
