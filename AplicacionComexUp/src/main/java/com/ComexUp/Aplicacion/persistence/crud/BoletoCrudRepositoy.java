package com.ComexUp.Aplicacion.persistence.crud;

import com.ComexUp.Aplicacion.persistence.entity.Boleto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface BoletoCrudRepositoy extends CrudRepository<Boleto, Integer> {
        //Consultas a la BD
    List<Boleto> findByIdUsuario(int idUsuario);
    Boleto findById(int idTicket);




}
