package br.com.quon.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.quon.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {}