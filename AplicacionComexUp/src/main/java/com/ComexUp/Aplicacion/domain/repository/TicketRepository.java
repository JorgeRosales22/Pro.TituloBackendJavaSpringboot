package com.ComexUp.Aplicacion.domain.repository;

import com.ComexUp.Aplicacion.domain.dto.Ticket;

import java.util.List;

public interface TicketRepository {

    List<Ticket> getAll();
    List<Ticket> getByUser(String email);
    Ticket getTicket(int ticketId);
    String save(Ticket ticket);
    void delete (int ticketId);

}
