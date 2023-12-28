package com.ComexUp.Aplicacion.persistence.Mapper;

import com.ComexUp.Aplicacion.domain.dto.User;
import com.ComexUp.Aplicacion.persistence.entity.Usuario;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import java.util.List;

@Mapper(componentModel = "spring", uses = {TicketMapper.class})

public interface UserMapper {

    @Mappings({
            @Mapping(source = "nombre",target = "name"),
            @Mapping(source = "apellidos",target = "lastName"),
            @Mapping(source = "email",target = "email"),
            @Mapping(source = "password",target = "password"),
            @Mapping(source = "rol",target = "rol"),
    })
    User toUser(Usuario usuario);
    List<User> toUsers(List<Usuario> usuarios);

    @InheritInverseConfiguration
    @Mapping(target = "idUsuario", ignore = true)
    @Mapping(target = "boletos", ignore = true)
    @Mapping(target = "comprobantes", ignore = true)
     Usuario toUsuario(User user);
}
