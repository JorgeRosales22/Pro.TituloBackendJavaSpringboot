package com.ComexUp.Aplicacion.persistence.Mapper;

import com.ComexUp.Aplicacion.domain.dto.Ticket;
import com.ComexUp.Aplicacion.persistence.entity.Boleto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface TicketMapper {
    @Mappings({
            @Mapping(source = "idTicket",target = "ticketId"),
            @Mapping(source = "idUsuario",target = "userId"),
            @Mapping(source = "estado",target = "state"),
            @Mapping(source = "titulo",target = "title"),
            @Mapping(source = "content",target = "content"),
            @Mapping(source = "fecha",target = "createdAt"),
            @Mapping(source = "destinatario",target = "destiny"),
    })
    Ticket toTicket(Boleto boleto);
    List<Ticket> toTickets(List<Boleto> boletos);
    @InheritInverseConfiguration
    @Mapping(target = "usuario", ignore = true)
    Boleto toBoleto(Ticket ticket);
}
