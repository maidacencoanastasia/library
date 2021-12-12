package com.library.library.Dao.impl;
import com.library.library.Dao.AuthorDao;
import com.library.library.domain.Author;
import com.library.library.spring.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


// сервисный уровень для работы с авторами
// API для реализованных бизнес процессов
// код должен обращаться только через Service (не к Repository напрямую)
@Service // сервисный Spring бин
@Transactional // методы помечаются как транзакционные (для запросов применяются настройки транзакций по-умолчанию, уровень изоляции и пр.)
public class AuthorService implements AuthorDao {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public List<Author> getAll() {
        return authorRepository.findAll();
    }

    public List<Author> getAll(Sort sort) {
        return authorRepository.findAll(sort);
    }

    @Override
    public Page<Author> getAll(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection) {
        return authorRepository.findAll(PageRequest.of(pageNumber, pageSize,  Sort.by(sortDirection, sortField)));
    }

    @Override
    public List<Author> search(String... searchString) {
        return authorRepository.findByFioContainingIgnoreCaseOrderByFio(searchString[0]);
    }

    @Override
    public Page<Author> search(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection, String... searchString) {
        return authorRepository.findByFioContainingIgnoreCaseOrderByFio(searchString[0], PageRequest.of(pageNumber, pageSize,  Sort.by(sortDirection, sortField)));
    }


    @Override
    public Author save(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public void delete(Author author) {
        authorRepository.delete(author);
    }

    @Override
    public Author get(long id) {
        return authorRepository.findById(id).orElse(null);
    }




}
