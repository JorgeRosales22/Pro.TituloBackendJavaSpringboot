package com.ComexUp.Aplicacion.persistence;

import com.ComexUp.Aplicacion.domain.dto.Voucher;
import com.ComexUp.Aplicacion.domain.repository.VoucherRepository;
import com.ComexUp.Aplicacion.persistence.Mapper.VoucherMapper;
import com.ComexUp.Aplicacion.persistence.crud.ComprobanteCrudRepository;
import com.ComexUp.Aplicacion.persistence.entity.Comprobante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ComprobanteRepository implements VoucherRepository {

    @Autowired
    private ComprobanteCrudRepository comprobanteCrudRepository;
    @Autowired
    private VoucherMapper voucherMapper;
    @Override
    public List<Voucher> getAll(){
        List<Comprobante> comprobantes =(List<Comprobante>) comprobanteCrudRepository.findAll();
        return voucherMapper.toVouchers(comprobantes);
    }
    @Override
    public Optional<List<Voucher>> getByUserId(int userId) {
        List<Comprobante> comprobantes = comprobanteCrudRepository.findByIdUsuario(userId);
        return Optional.of(voucherMapper.toVouchers(comprobantes));
    }
    @Override
    public Optional<List<Voucher>> getVoucher(int voucherId) {
        Optional<List<Comprobante>> comprobantes = comprobanteCrudRepository.findByIdComprobante(voucherId);
        return comprobantes.map(comp -> voucherMapper.toVouchers(comp));
    }
    @Override
    public Voucher save(Voucher voucher) {
        Comprobante comprobante = voucherMapper.toComprobante(voucher);
        return voucherMapper.toVoucher(comprobanteCrudRepository.save(comprobante));
    }
    @Override
    public void delete(int idComprobante){
        comprobanteCrudRepository.deleteById(idComprobante);
    }
}
