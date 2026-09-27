package com.example.BookApplication.Service;

import com.example.BookApplication.Entity.Book;
import com.example.BookApplication.Respository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    @Transactional
    public Book addBook(Book book) {
        bookRepository.findBookByTitle("book");
        return bookRepository.save(book);
    }

    public Book getBookByName(String name){
        return bookRepository.findBookByTitle(name);

    }

    public Book updateBook(Book book) {
        return bookRepository.save(book); // or we can use update method as well and create a separate update method in repository
    }

    public void deleteBook(Integer id) {
        bookRepository.deleteById(id);
    }

    public Book getBookById(Integer bookId) {

        return null;
    }
}
