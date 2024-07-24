package com.example.transaction.service;

import com.example.transaction.dtos.AccessTokenResponse;
import com.example.transaction.dtos.MpesaCheckoutResponse;

public interface MpesaService {
    AccessTokenResponse getAccessToken();
    MpesaCheckoutResponse initiateCheckout(String phoneNumber, Double amount);
}
