package com.leanimg.BookStore.repository;

import com.leanimg.BookStore.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Long> {
}
