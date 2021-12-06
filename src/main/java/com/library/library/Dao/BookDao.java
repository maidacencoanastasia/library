package com.library.library.Dao;


import com.library.library.domain.Book;

import java.util.List;

// описывает специфичное поведение для работы с книгами
public interface BookDao extends GeneralDAO<Book>{

    // поиск топоовых книг
    List<Book> findTopBooks(int limit);

}