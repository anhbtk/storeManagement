package com.store.Store.controller;

import com.store.Store.models.Book;
import com.store.Store.models.BookCategory;
import com.store.Store.repository.BookCategoryRepository;
import com.store.Store.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/BookCategory")
public class BookCategoryController {
    @Autowired
    private BookCategoryRepository bookCategoryRepository;
    @Autowired
    private BookRepository bookRepository;
    @GetMapping("/getAll")
    public List<BookCategory> getAll(){
        List<BookCategory> l = bookCategoryRepository.findAll();
        return l;
    }

    @PostMapping("/add")
    public BookCategory add(@RequestBody BookCategory bookCategory){
        if (bookCategory.getName()!=null){
            BookCategory b = bookCategoryRepository.save(bookCategory);
            return b;
        }return null;
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        BookCategory b = bookCategoryRepository.findById(id).orElse(null);
        if (b!=null){
            List<Book> list =  new ArrayList<>(b.getBooks());

            bookRepository.deleteAll(list);
            bookCategoryRepository.delete(b);
            return "delete....";
        }return "not....";
    }


}
