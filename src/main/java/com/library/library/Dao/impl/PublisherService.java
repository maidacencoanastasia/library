package com.library.library.Dao.impl;

import com.library.library.Dao.PublisherDao;
import com.library.library.domain.Publisher;
import com.library.library.spring.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
@Transactional
public class PublisherService implements PublisherDao {

    @Autowired
    private PublisherRepository publisherRepository;


    @Override
    public List<Publisher> getAll() {
        return publisherRepository.findAll();
    }

    public List<Publisher> getAll(Sort sort) {
        return publisherRepository.findAll(sort);
    }



    @Override
    public Page<Publisher> getAll(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection) {
        return publisherRepository.findAll( PageRequest.of(pageNumber, pageSize, Sort.by(sortDirection, sortField)));
    }


    @Override
    public List<Publisher> search(String... searchString) {
        return publisherRepository.findByNameContainingIgnoreCaseOrderByName(searchString[0]);
    }

    @Override
    public Page<Publisher> search(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection, String... searchString) {
        return publisherRepository.findByNameContainingIgnoreCaseOrderByName(searchString[0], PageRequest.of(pageNumber, pageSize, Sort.by(sortDirection, sortField)));
    }


    @Override
    public Publisher save(Publisher publisher) {
        return publisherRepository.save(publisher);
    }

    @Override
    public void delete(Publisher publisher){
        publisherRepository.delete(publisher);
    }

    @Override
    public Publisher get(long id) {
        return publisherRepository.findById(id).orElse(null);
    }




}
