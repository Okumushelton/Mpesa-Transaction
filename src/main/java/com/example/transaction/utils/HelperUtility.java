package com.example.transaction.utils;

import lombok.extern.slf4j.Slf4j;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Slf4j
public class HelperUtility {

    //This helper utility Converts any string that is passed into a base64 character

    public static String toBase64String(String value){
        byte[] data = value.getBytes(StandardCharsets.ISO_8859_1);
        return Base64.getEncoder().toString();
    }
}
