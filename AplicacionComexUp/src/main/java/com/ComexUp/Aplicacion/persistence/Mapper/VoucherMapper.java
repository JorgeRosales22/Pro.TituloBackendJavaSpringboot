package com.ComexUp.Aplicacion.persistence.Mapper;

import com.ComexUp.Aplicacion.domain.dto.Voucher;
import com.ComexUp.Aplicacion.persistence.entity.Comprobante;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface VoucherMapper {
    @Mappings({
            @Mapping(source = "idComprobante", target = "voucherId"),
            @Mapping(source = "idUsuario", target = "userId"),
            @Mapping(source = "infoComprobante", target = "voucherInfo"),
            @Mapping(source = "usuario", target = "user"),
    })
    Voucher toVoucher(Comprobante comprobante);
    List<Voucher> toVouchers(List<Comprobante> comprobantes);

    @InheritInverseConfiguration
    Comprobante toComprobante(Voucher voucher);
}
