package com.ComexUp.Aplicacion.web.controller;

import com.ComexUp.Aplicacion.domain.dto.Ticket;
import com.ComexUp.Aplicacion.domain.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/boleto")
public class BoletoController {

    @Autowired
    private TicketService ticketService;

    @GetMapping("/all")
    public ResponseEntity<List<Ticket>> getAll(){
        return new ResponseEntity<>(ticketService.getAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Ticket> getTicket(@PathVariable("id") int ticketId){
         Ticket ticket = ticketService.getTicket(ticketId);
        if (ticket != null){
            return new ResponseEntity<>(ticket, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping("/ticket")
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
    @PatchMapping("/editar")
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
    @PostMapping("/send-message")
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
    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") int ticketId){
        if(ticketService.delete(ticketId)){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}