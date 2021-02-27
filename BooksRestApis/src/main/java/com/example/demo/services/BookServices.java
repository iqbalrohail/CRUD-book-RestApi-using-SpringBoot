package com.example.demo.services;

import com.example.demo.data.transfer.objects.BookDto;
import com.example.demo.domain.BookDomain;
import com.example.demo.repositories.BooksRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookServices {
    @Autowired
    private BooksRepository booksRepository;

    @Autowired
    private ObjectMapper objectMapper;

    public ResponseEntity<BookDto> createBook(BookDto bookDto) {
        try {
             booksRepository.saveAndFlush(mapDtoObjectToDomain(bookDto));
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    public ResponseEntity<BookDto> deleteBook(int id) {
        try
        {
            BookDomain bookDomain = booksRepository.findById(id);
            booksRepository.delete(bookDomain);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }catch (Exception e)
        {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    public ResponseEntity<BookDto> updateBook(BookDto bookDto, int id) {
        bookDto.setId(id);
       booksRepository.saveAndFlush(mapDtoObjectToDomain(bookDto));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    public ResponseEntity<BookDto> showById(int id) {
        BookDomain bookDomain = booksRepository.findById(id);
        BookDto bookDto = mapDomainObjectToDto(bookDomain);
        if (bookDto == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.of(Optional.of(bookDto));
    }

    private BookDomain mapDtoObjectToDomain(BookDto bookDto) {
        return objectMapper.convertValue(bookDto, BookDomain.class);
    }

    private BookDto mapDomainObjectToDto(BookDomain bookDomain) {
        return objectMapper.convertValue(bookDomain, BookDto.class);
    }

}

