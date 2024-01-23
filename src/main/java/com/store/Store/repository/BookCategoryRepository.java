package com.store.Store.repository;

import com.store.Store.models.BookCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookCategoryRepository extends JpaRepository<BookCategory,Integer> {
}
