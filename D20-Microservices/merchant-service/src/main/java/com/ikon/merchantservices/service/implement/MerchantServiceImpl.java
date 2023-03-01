package com.ikon.merchantservices.service.implement;

import com.ikon.merchantservices.entity.Merchant;
import com.ikon.merchantservices.repository.MerchantRepository;
import com.ikon.merchantservices.service.MerchantService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class MerchantServiceImpl implements MerchantService {
    private final MerchantRepository merchantRepository;

    @Override
    public List<Merchant> getAllMerchant() {
        return merchantRepository.findAll();
    }

    @Override
    public List<Merchant> getMerchantById(Long id) {
        List<Merchant> data = new ArrayList<>();
        data.add(merchantRepository.findById(id).get());
        return data;
    }

    @Override
    public List<Merchant> createMerchant(Merchant merchant) {
        List<Merchant> data = new ArrayList<>();
        data.add(merchantRepository.save(merchant));
        return data;
    }

    @Override
    public List<Merchant> updateMerchantById(Merchant merchant, Long id) {
        List<Merchant> data = new ArrayList<>();
        Merchant findMerchant = merchantRepository.findById(id).get();
        findMerchant.setName(merchant.getName());
        findMerchant.setYear(merchant.getYear());
        findMerchant.setAddress(merchant.getAddress());
        data.add(merchantRepository.save(findMerchant));
        return data;
    }

    @Override
    public void deleteMerchantById(Long id) {
        merchantRepository.deleteById(id);
    }
}
