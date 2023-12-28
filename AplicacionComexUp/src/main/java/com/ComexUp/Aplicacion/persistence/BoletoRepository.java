package com.ComexUp.Aplicacion.persistence;

import com.ComexUp.Aplicacion.domain.dto.Ticket;
import com.ComexUp.Aplicacion.domain.repository.TicketRepository;
import com.ComexUp.Aplicacion.persistence.Mapper.TicketMapper;
import com.ComexUp.Aplicacion.persistence.crud.BoletoCrudRepositoy;
import com.ComexUp.Aplicacion.persistence.crud.UsuarioCrudRepository;
import com.ComexUp.Aplicacion.persistence.entity.Boleto;
import com.ComexUp.Aplicacion.persistence.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BoletoRepository implements TicketRepository {
    @Autowired
    private BoletoCrudRepositoy boletoCrudRepositoy;
    @Autowired
    private TicketMapper ticketMapper;
    @Autowired
    private UsuarioCrudRepository usuarioCrudRepository;

    @Override
    public List<Ticket> getAll(){
        List<Boleto> boletos = (List<Boleto>) boletoCrudRepositoy.findAll();
        return ticketMapper.toTickets(boletos);
    }
    @Override
    public List<Ticket> getByUser(String email) {
        Usuario usuario = usuarioCrudRepository.findByEmail(email);
        if (usuario != null){
            int userdId = usuario.getIdUsuario();
            List<Boleto> boletos = boletoCrudRepositoy.findByIdUsuario(userdId);

            if(boletos != null || !boletos.isEmpty()){
                return ticketMapper.toTickets(boletos);
            }else {
                List<Ticket> tickets = new ArrayList<>();
                return tickets;
            }
        }
        return null;
    }

    @Override
    public Ticket getTicket(int ticketId) {
        Ticket ticket = ticketMapper.toTicket(boletoCrudRepositoy.findById(ticketId));
        return ticket ;
    }
    @Override
    public String save(Ticket ticket) {
        try {
            if (ticket != null) {
                Boleto boleto = ticketMapper.toBoleto(ticket);
                ticketMapper.toTicket(boletoCrudRepositoy.save(boleto));
                return "Ticket Creado con éxito";
            }
            return "Valor nulo";
        } catch (DataIntegrityViolationException e) {

            return "Error de integridad en la base de datos";
        } catch (RuntimeException e) {
            System.out.println(e);
            return "Error en la operación de base de datos";
        }
    }
    @Override
    public void delete(int idTicket){
        boletoCrudRepositoy.deleteById(idTicket);
    }

    // public ZonedDateTime formaterDate( String date) {
    //   try {
    //        String dateString = date.replaceAll("GMT", ""); // Eliminar 'GMT'
    //        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE MMM dd yyyy HH:mm:ss XXX");
    //         ZonedDateTime dateTime = ZonedDateTime.parse(dateString, formatter);
    //        System.out.println(dateTime);
    //          return dateTime;
    //    } catch (DateTimeParseException e) {
    //         e.printStackTrace();
    //    }
    //    return null
    //  }

}

