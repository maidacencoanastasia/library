package com.library.library.Dao;


import com.library.library.domain.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.List;

// описывает специфичное поведение для работы с книгами
public interface BookDao extends GeneralDAO<Book>{

    // поиск топовых книг
    List<Book> findTopBooks(int limit);

    // получение контента по id
    byte[] getContent(long id);

    // постраничный вывод книг определенного жанра
    Page<Book> findByGenre(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection, long genreId);


}