package br.com.fiap.webmarket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@Controller
@EnableCaching
@OpenAPIDefinition (
	info = @Info(
		title = "WebMarket",
		version = "1.0.0",
		description = "API do app de MarketPlace"
	)
)
public class WebmarketApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebmarketApplication.class, args);
	}

	@RequestMapping
	@ResponseBody
	public String Login() {
		return "WebMarket";
	}

}
