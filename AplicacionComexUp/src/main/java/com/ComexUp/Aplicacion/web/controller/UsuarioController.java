package com.ComexUp.Aplicacion.web.controller;

import com.ComexUp.Aplicacion.domain.dto.User;
import com.ComexUp.Aplicacion.domain.dto.UserResponseDTO;
import com.ComexUp.Aplicacion.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.nio.charset.StandardCharsets;
import java.util.List;

import static com.ComexUp.Aplicacion.shared.contants.ConstantsPaths.USER_PATH;
import static com.ComexUp.Aplicacion.shared.contants.ConstantsProperties.*;

@RestController
@RequestMapping(value = USER_PATH)
public class UsuarioController {
    @Autowired
    private UserService userService;

    @GetMapping(value = GLOBAL_PATH)
    public ResponseEntity<List<User>> getAll() {
        return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
    }

    @PostMapping(value = LOGIN_PATH)
    public ResponseEntity<UserResponseDTO> loginUser(@RequestParam String email, @RequestParam String password) {
        User user = userService.getUser(email);
        if (user != null) {
            UserResponseDTO userResponseDTO = userService.mapToResponseDTO(user);
            String hashedPasswordInput = hashPasswordSHA256(password);
            if (hashedPasswordInput.equals(user.getPassword())) {
                return new ResponseEntity<>(userResponseDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public static String hashPasswordSHA256(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(password.getBytes(StandardCharsets.UTF_8));
            StringBuilder hexHash = new StringBuilder();
            for (byte b : hashBytes) {
                hexHash.append(String.format("%02X", b));
            }
            return hexHash.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error al calcular el hash de la contraseña", e);
        }
    }

    @PostMapping(value = REGISTER_PATH)
    public ResponseEntity<String> save(@RequestBody User user) {
        if (user != null) {
            String hashedPasswordInput = hashPasswordSHA256(user.getPassword());
            user.setPassword(hashedPasswordInput);
            String usuario = userService.save(user);
            return new ResponseEntity<>(usuario, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping(DELETE_USER)
    public ResponseEntity delete(@RequestParam String email) {
        User user = userService.getUser(email);
        if (email != null) {
            if (userService.delete(email)) {
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
