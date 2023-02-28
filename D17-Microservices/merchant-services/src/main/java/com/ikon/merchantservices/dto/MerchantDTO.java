package com.ikon.merchantservices.dto;


import com.ikon.merchantservices.entity.Merchant;
import lombok.Data;

import java.util.List;

@Data
public class MerchantDTO extends ResponseDTO{
    private List<Merchant> data;
}
