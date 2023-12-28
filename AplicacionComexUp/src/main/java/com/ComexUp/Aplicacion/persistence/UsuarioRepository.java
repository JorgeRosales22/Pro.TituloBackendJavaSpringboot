package com.ComexUp.Aplicacion.persistence;

import com.ComexUp.Aplicacion.domain.dto.User;
import com.ComexUp.Aplicacion.domain.repository.UserRepository;
import com.ComexUp.Aplicacion.persistence.Mapper.UserMapper;
import com.ComexUp.Aplicacion.persistence.crud.UsuarioCrudRepository;
import com.ComexUp.Aplicacion.persistence.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UsuarioRepository implements UserRepository {
    @Autowired
    private UsuarioCrudRepository usuarioCrudRepository;
    @Autowired
    private UserMapper userMapper;

    public static class ResultadoOperacion {
        private final boolean exitoso;
        private final String mensaje;

        public ResultadoOperacion(boolean exitoso, String mensaje) {
            this.exitoso = exitoso;
            this.mensaje = mensaje;
        }

        public boolean isExitoso() {
            return exitoso;
        }

        public String getMensaje() {
            return mensaje;
        }
    }

    @Override
    public List<User> getAll(){
        List<Usuario> usuarios= (List<Usuario>) usuarioCrudRepository.findAll();
        return userMapper.toUsers(usuarios);
    }
    @Override
    public User getUser(String email) {
        return userMapper.toUser(usuarioCrudRepository.findByEmail(email));
    }
    @Override
    public String save(User user) {
        if (user != null) {
            if (emailExists(user.getEmail())) {
                return "Correo Duplicado";
            }
            try {
                Usuario usuario = userMapper.toUsuario(user);
                usuarioCrudRepository.save(usuario);
                return "Usuario registrado con exito";
            } catch (DataIntegrityViolationException e) {
                e.printStackTrace();
                return "Error";
            }} else {
                return "Valor nulo";
            }
        }
    private boolean emailExists(String email) {
        return usuarioCrudRepository.existsByEmail(email);
    }

    @Override
    public boolean delete(String email ){
        try{
        usuarioCrudRepository.delete(usuarioCrudRepository.findByEmail(email));
        return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }
}
