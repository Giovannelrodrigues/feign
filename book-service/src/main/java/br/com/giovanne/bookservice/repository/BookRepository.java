package br.com.giovanne.bookservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.giovanne.bookservice.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
