package br.com.giovanne.bookservice.controller;

import java.util.HashMap;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.giovanne.bookservice.model.Book;
import br.com.giovanne.bookservice.proxy.CambioProxy;
import br.com.giovanne.bookservice.repository.BookRepository;

@RestController
public class BookController {
	
	@Autowired
	private CambioProxy cambioProxy;
	
	@Autowired
	private BookRepository repository;
	
	@GetMapping("/{id}/{currency}")
	public Book find(@PathVariable("id") Long id, @PathVariable("currency") String currency) {
		Optional<Book> optBook = repository.findById(id);
		Book book = optBook.orElseThrow(() -> new IllegalStateException("book not found"));
		HashMap<String, String> params = new HashMap<>();
		params.put("amount", book.getPrice().toString());
		params.put("from", "USD");
		params.put("to", currency);
		book.setCurrency(currency);
		book.setPrice(cambioProxy.getCambio(book.getPrice(), "USD", currency).getConvertedValue());
		return book;
	}
}
