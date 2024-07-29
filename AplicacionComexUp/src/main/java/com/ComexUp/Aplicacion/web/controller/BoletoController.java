package com.ComexUp.Aplicacion.web.controller;

import com.ComexUp.Aplicacion.domain.dto.Ticket;
import com.ComexUp.Aplicacion.domain.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import static com.ComexUp.Aplicacion.shared.contants.ConstantsPaths.TICKET_PATH;
import static com.ComexUp.Aplicacion.shared.contants.ConstantsProperties.*;

@RestController
@RequestMapping(value = TICKET_PATH)
public class BoletoController {

    @Autowired
    private TicketService ticketService;

    @GetMapping(value = GLOBAL_PATH)
    public ResponseEntity<List<Ticket>> getAll(){
        return new ResponseEntity<>(ticketService.getAll(), HttpStatus.OK);
    }
    @GetMapping(value = GET_BY_ID_PATH)
    public ResponseEntity<Ticket> getTicket(@PathVariable("id") int ticketId){
         Ticket ticket = ticketService.getTicket(ticketId);
        if (ticket != null){
            return new ResponseEntity<>(ticket, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping(value = GET_USER_TICKET_PATH)
    public ResponseEntity<List<Ticket>> getByUserId(@RequestParam String email) {
        List<Ticket> tickets = ticketService.getByUser(email);
        if(tickets != null) {
            if (!tickets.isEmpty()){
                return new ResponseEntity<>(tickets, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(tickets,HttpStatus.OK);
            }
        } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PatchMapping(value = SAVE_TICKET_PATH)
    public ResponseEntity<String> updateTicket(@RequestBody Ticket ticket) {
      try {
          if (ticket != null) {
               ticketService.save(ticket);
               return new ResponseEntity<>("Ticket editado", HttpStatus.CREATED);
          } else {
              return new ResponseEntity<>("Ticket no actualizdo", HttpStatus.NOT_ACCEPTABLE);
          }
      } catch (Exception e) {
               return new ResponseEntity<>("Error al procesar la solicitud", HttpStatus.INTERNAL_SERVER_ERROR);
            }
     }
    @PostMapping(value = SEND_TICKET_PATH)
    public ResponseEntity<String> save(@RequestBody Ticket ticket) {
        try {
            if (ticket != null) {
                ticketService.save(ticket);
                return new ResponseEntity<>("Ticket creado y enviado", HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>("Ticket no creado (nulo)", HttpStatus.NOT_ACCEPTABLE);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Error al procesar la solicitud", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping(value = DELETE_ID)
    public ResponseEntity delete(@PathVariable("id") int ticketId){
        if(ticketService.delete(ticketId)){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}