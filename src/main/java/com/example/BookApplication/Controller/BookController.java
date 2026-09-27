package com.example.BookApplication.Controller;

import com.example.BookApplication.Entity.Book;
import com.example.BookApplication.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book/v1")
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    @GetMapping("/getBook/{bookName}")
    public ResponseEntity<Book> getBookByName(@PathVariable("bookName")String name){
        final Book bookByName = bookService.getBookByName(name);
        return ResponseEntity.ok(bookByName);
    }

    @GetMapping("/getBook/{bookId}")
    public ResponseEntity<Book> getBookById(@PathVariable("bookId")Integer bookId){
        final Book bookById = bookService.getBookById(bookId);
        return ResponseEntity.ok(bookById);
    }

    @PostMapping("/addBook")
    public ResponseEntity<Book> addBook(@RequestBody Book book){
        Book savedBook = bookService.addBook(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBook);

    }



    @PutMapping("/updateBook")
    public ResponseEntity<Book> updateBook(@RequestBody Book book){
        Book updatedBookBook = bookService.updateBook(book);
        return ResponseEntity.ok(updatedBookBook);
    }

    @DeleteMapping("/deleteBook/{id}")
    public ResponseEntity<Book> deleteBook(@PathVariable("id")Integer id){
        bookService.deleteBook(id);
        return ResponseEntity.ok().build();
    }
}
