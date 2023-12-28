package com.ComexUp.Aplicacion.persistence.crud;

import com.ComexUp.Aplicacion.persistence.entity.Comprobante;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ComprobanteCrudRepository extends CrudRepository<Comprobante, Integer> {
    List<Comprobante> findByIdUsuario(int idUsuario);

    Optional<List<Comprobante>> findByIdComprobante(int idComprobante);
}
