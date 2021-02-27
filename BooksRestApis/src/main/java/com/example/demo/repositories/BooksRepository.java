package com.example.demo.repositories;

import com.example.demo.data.transfer.objects.BookDto;
import com.example.demo.domain.BookDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BooksRepository extends JpaRepository<BookDomain, Integer> {
    public BookDomain findById(int id);
}
