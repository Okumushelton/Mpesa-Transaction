package com.example.transaction.dtos;

import lombok.Data;

@Data

public class MpesaCheckoutResponse {

        private String merchantRequestID;
        private String checkoutRequestID;
        private String responseCode;
        private String responseDescription;
        private String customerMessage;

}
