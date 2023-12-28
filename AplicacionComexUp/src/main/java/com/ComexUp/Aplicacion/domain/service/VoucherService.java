package com.ComexUp.Aplicacion.domain.service;

import com.ComexUp.Aplicacion.domain.dto.Voucher;
import com.ComexUp.Aplicacion.domain.repository.VoucherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VoucherService {
    @Autowired
    private VoucherRepository voucherRepository;

    public List<Voucher> getAll(){
        return voucherRepository.getAll();
    }
    public Optional<List<Voucher>> getByUserId(int userId){
        return voucherRepository.getByUserId(userId);
    }
    public Optional<List<Voucher>> getVoucher(int voucherId){
        return voucherRepository.getVoucher(voucherId);
    }
    public Voucher save(Voucher voucher){
        return voucherRepository.save(voucher);
    }
    public Boolean delete(int voucherId){
        return getVoucher(voucherId).map(voucher -> {
            voucherRepository.delete(voucherId);
            return true;
        }).orElse(false);
    }
}
