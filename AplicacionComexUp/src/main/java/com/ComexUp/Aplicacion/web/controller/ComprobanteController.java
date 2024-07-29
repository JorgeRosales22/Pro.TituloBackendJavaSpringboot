package com.ComexUp.Aplicacion.web.controller;

import com.ComexUp.Aplicacion.domain.dto.Voucher;
import com.ComexUp.Aplicacion.domain.service.VoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import static com.ComexUp.Aplicacion.shared.contants.ConstantsPaths.VOUCHER_PATH;
import static com.ComexUp.Aplicacion.shared.contants.ConstantsProperties.*;

@RestController
@RequestMapping(value = VOUCHER_PATH)
public class ComprobanteController {

    @Autowired
    private VoucherService voucherService;

    @GetMapping(value = GLOBAL_PATH)
    public ResponseEntity<List<Voucher>> getAll(){
        return new ResponseEntity<>(voucherService.getAll(), HttpStatus.OK);
    }
    @GetMapping(value = GET_BY_ID_PATH)
    public ResponseEntity<List<Voucher>> getVoucher(@PathVariable("id") int voucherId){
        return voucherService.getVoucher(voucherId).map(vouchers -> new ResponseEntity<>(vouchers,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @GetMapping(value = GET_VOUCHER_BY_ID_PATH)
    public ResponseEntity<List<Voucher>> getByUserId(@PathVariable("id") int userId){
        return voucherService.getByUserId(userId).map(vouchers -> new ResponseEntity<>(vouchers, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PostMapping()
    public ResponseEntity<Voucher> save(@RequestBody Voucher voucher){
        return new ResponseEntity<>(voucherService.save(voucher),HttpStatus.CREATED);
    }
    @DeleteMapping(value = DELETE_ID)
    public ResponseEntity delete(int voucherId){
        if(voucherService.delete(voucherId)){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
