package com.ikon.merchantservices.service;

import com.ikon.merchantservices.entity.Merchant;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MerchantService {
    List<Merchant> getAllMerchant();

    List<Merchant> getMerchantById(Long id);

    List<Merchant> createMerchant(Merchant merchant);

    List<Merchant> updateMerchantById(Merchant merchant, Long id);

    void deleteMerchantById(Long id);
}
