package com.ikon.merchantservices.controller;

import com.ikon.merchantservices.dto.MerchantDTO;
import com.ikon.merchantservices.dto.ResponseDTO;
import com.ikon.merchantservices.entity.Merchant;
import com.ikon.merchantservices.service.MerchantService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/api/merchants")
@AllArgsConstructor
public class MerchantController {
    private final MerchantService merchantService;

    @GetMapping
    public ResponseEntity<MerchantDTO> getAllMerchant(){
        List<Merchant> allData = merchantService.getAllMerchant();

        MerchantDTO response = new MerchantDTO();
        response.setCode(200);
        response.setStatus("success");
        response.setData(allData);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MerchantDTO> getMerchantById(@PathVariable Long id){
        List<Merchant> data = merchantService.getMerchantById(id);

        MerchantDTO response = new MerchantDTO();
        response.setCode(200);
        response.setStatus("success");
        response.setData(data);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MerchantDTO> createMerchant(@RequestBody Merchant merchant){
        List<Merchant> data = merchantService.createMerchant(merchant);

        MerchantDTO response = new MerchantDTO();
        response.setCode(201);
        response.setStatus("created");
        response.setData(data);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping ("/{id}")
    public ResponseEntity<MerchantDTO> updateMerchantById(@RequestBody Merchant merchant, @PathVariable Long id){
        List<Merchant> data = merchantService.updateMerchantById(merchant, id);

        MerchantDTO response = new MerchantDTO();
        response.setCode(201);
        response.setStatus("updated");
        response.setData(data);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDTO> deleteMerchantById(@PathVariable Long id){
        merchantService.deleteMerchantById(id);

        ResponseDTO response = new ResponseDTO();
        response.setCode(201);
        response.setStatus("deleted");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

}
