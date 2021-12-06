package com.library.library.spring.repository;


import com.library.library.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// при получении списка книг - контент для каждой книги - пустой. Только когда пользователь нажимает на чтение книги - делаем запрос в БД на получение контента (по требованию)
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {


}