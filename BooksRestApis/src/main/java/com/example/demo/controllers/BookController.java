package com.example.demo.controllers;


import com.example.demo.data.transfer.objects.BookDto;
import com.example.demo.services.BookServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookServices bookServices;

    @PostMapping("/add")
    public ResponseEntity<BookDto> createBook(@RequestBody BookDto bookDto) {
        return bookServices.createBook(bookDto);
    }

    @GetMapping("/show/{id}")
    public ResponseEntity<BookDto> showById(@PathVariable("id") int id) {
        return bookServices.showById(id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<BookDto> deleteBook(@PathVariable("id") int id) {
        return bookServices.deleteBook(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<BookDto> updateBook(@RequestBody BookDto bookDto, @PathVariable("id") int id) {
        return bookServices.updateBook(bookDto, id);

    }
}
