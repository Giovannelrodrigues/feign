package br.com.giovanne.bookservice.proxy;

import java.math.BigDecimal;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.giovanne.bookservice.response.Cambio;

@FeignClient(name = "cambio-service", url = "localhost:8000/cambio-service")
public interface CambioProxy {
	
	@GetMapping("{amount}/{from}/{to}")
	public Cambio getCambio(@PathVariable("amount") BigDecimal amount, @PathVariable("from") String from, @PathVariable("to") String to);
	
	
}
