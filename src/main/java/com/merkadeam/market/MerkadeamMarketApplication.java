package com.merkadeam.market;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Merkadea", version = "2.0", description = "Merkadea Informatio"))
public class MerkadeamMarketApplication {

	public static void main(String[] args) {
		SpringApplication.run(MerkadeamMarketApplication.class, args);
	}

}
