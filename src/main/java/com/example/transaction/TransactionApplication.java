package com.example.transaction;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TransactionApplication {

	public static void main(String[] args) {

		SpringApplication.run(TransactionApplication.class, args);
	}
	
	@Bean
	public OkHttpClient getOkHttpClient(){
		return new OkHttpClient();
	}

	@Bean
	public ObjectMapper getObjectMapper(){

		return new ObjectMapper();
	}

}
