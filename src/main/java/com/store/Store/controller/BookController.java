package com.store.Store.controller;

import com.store.Store.models.Book;
import com.store.Store.models.BookCategory;
import com.store.Store.repository.BookCategoryRepository;
import com.store.Store.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Book")
public class BookController {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private BookCategoryRepository bookCategoryRepository;
    @GetMapping("/getAll")
    public List<Book> getAll(){
        List<Book> b = bookRepository.findAll();
        return b;
    }

    @PostMapping("/add")
    public Book add(@RequestBody Book book){
        if (book.getDescription()!=null && book.getTitle()!=null){
            Book b = bookRepository.save(book);
            return b;
        }return null;
    }

    @PutMapping("/update/{id}")
    public Book update(@PathVariable int id,@RequestBody Book book){
        Book b = bookRepository.findById(id).orElse(null);
        if(book.getDescription()!=null && book.getTitle()!=null){
            b.setDescription(book.getDescription());
            b.setTitle(book.getTitle());
            bookRepository.save(b);
            return b;
        }return null;
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        Book b = bookRepository.findById(id).orElse(null);
        if (b!=null){
            bookRepository.delete(b);
            return "delete successfully";
        }return "not found";
    }

    @PutMapping("/UpdateCategory/{id}")
    public String updateCategory(@PathVariable int id, @RequestParam int categoriId ){
        Book b = bookRepository.findById(id).orElse(null);
        if (b!=null){
            BookCategory c = bookCategoryRepository.findById(categoriId).orElse(null);
            if(c!=null) {
                b.setBookCategory(c);
                bookRepository.save(b);
                return "update .....";
            }
            return "category ko tồn tại";
        }return "fail";
    }
}
