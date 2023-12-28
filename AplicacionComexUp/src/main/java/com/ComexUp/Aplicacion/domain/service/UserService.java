package com.ComexUp.Aplicacion.domain.service;

import com.ComexUp.Aplicacion.domain.dto.User;
import com.ComexUp.Aplicacion.domain.dto.UserResponseDTO;
import com.ComexUp.Aplicacion.domain.repository.UserRepository;
import com.ComexUp.Aplicacion.persistence.crud.UsuarioCrudRepository;
import com.ComexUp.Aplicacion.persistence.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UsuarioCrudRepository usuarioCrudRepository;

    public UserResponseDTO mapToResponseDTO(User user) {
        Usuario usuario = usuarioCrudRepository.findByEmail(user.getEmail());
        UserResponseDTO responseDTO = new UserResponseDTO();
        responseDTO.setUserId(usuario.getIdUsuario());
        responseDTO.setName(user.getName());
        responseDTO.setLastName(user.getLastName());
        responseDTO.setEmail(user.getEmail());
        responseDTO.setRol(user.getRol());
        return responseDTO;
    }

    public List<User> getAll(){
        return userRepository.getAll();
    }
    public User getUser(String email){
        return userRepository.getUser(email);
    }
    public String save(User user){
        return userRepository.save(user);
    }
    public Boolean delete(String email){
        return
            userRepository.delete(email);
    }
}
