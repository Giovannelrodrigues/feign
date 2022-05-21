package br.com.giovanne.cambioservice.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.giovanne.cambioservice.model.Cambio;
import br.com.giovanne.cambioservice.repository.CambioRepository;

@RestController
public class CambioController {
	
	@Autowired
	private CambioRepository repository;
	
	@GetMapping("/{amout}/{from}/{to}")
	public Cambio getCambio(@PathVariable("amout") BigDecimal amount, @PathVariable("from") String from, @PathVariable("to") String to) {
		Cambio cambio = repository.findByFromAndTo(from, to);
		if(cambio == null) throw new IllegalStateException("currency unsuported");
		BigDecimal conversionValue = cambio.getConversionFactor().multiply(amount);
		cambio.setConvertedValue(conversionValue.setScale(2, RoundingMode.CEILING));
		return cambio;
	}

}
