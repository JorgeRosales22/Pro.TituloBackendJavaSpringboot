package com.ComexUp.Aplicacion.domain.repository;

import com.ComexUp.Aplicacion.domain.dto.Voucher;

import java.util.List;
import java.util.Optional;

public interface VoucherRepository {
    List<Voucher> getAll();
    Optional<List<Voucher>> getByUserId(int userId);
    Optional<List<Voucher>> getVoucher(int voucherId);
    Voucher save(Voucher voucher);
    void delete (int voucherId);

}
