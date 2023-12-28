package com.ComexUp.Aplicacion.persistence.crud;

import com.ComexUp.Aplicacion.persistence.entity.Usuario;
import org.springframework.data.repository.CrudRepository;


public interface UsuarioCrudRepository extends CrudRepository<Usuario, Integer> {
   Usuario findByEmail(String email);
   int findById(int idUsuario);
    boolean existsByEmail(String email);

}
