package com.example.transaction.service;

import com.example.transaction.config.MpesaConfiguration;
import com.example.transaction.controller.TransactionController;
import com.example.transaction.dtos.AccessTokenResponse;
import com.example.transaction.dtos.MpesaCheckoutResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class MpesaServiceImpl implements MpesaService{

    Logger logger = LoggerFactory.getLogger(MpesaServiceImpl.class);

    private final MpesaConfiguration mpesaConfiguration;
    private final OkHttpClient okHttpClient;
    private final ObjectMapper objectMapper;

    public MpesaServiceImpl(MpesaConfiguration mpesaConfiguration, OkHttpClient okHttpClient, ObjectMapper objectMapper) {
        this.mpesaConfiguration = mpesaConfiguration;
        this.okHttpClient = okHttpClient;
        this.objectMapper = objectMapper;
    }


    @Override
    public AccessTokenResponse getAccessToken() {

//        Get the Base64 represantation of the consumer secrect and consumer key
        String encodedCredentials = HyperUtility.toBase64String(String.format())

        return null;
    }

    @Override
    public MpesaCheckoutResponse initiateCheckout(String phoneNumber, Double amount) {

        logger.info("Initiating Daraja Checkout");


        return null;
    }
}
