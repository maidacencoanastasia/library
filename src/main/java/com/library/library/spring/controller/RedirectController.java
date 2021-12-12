package com.library.library.spring.controller;

import com.library.library.Dao.impl.AuthorService;
import com.library.library.domain.Author;
import com.library.library.domain.Book;
import com.library.library.spring.repository.AuthorRepository;
import com.library.library.spring.repository.BookRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.data.domain.Page;

import java.util.Date;

@Controller
@Log
public class RedirectController {

    @Autowired
    private AuthorService authorService;


    // при запуске проекта - первый запрос попадает сюда
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String baseUrlRedirect(HttpServletRequest request, HttpServletResponse httpServletResponse) {

        Page<Author> authors = authorService.getAll(0, 10, "fio", Sort.Direction.DESC);

        Author a = new Author();
        a.setFio("тестовый автор");
        a.setBirthday(new Date(1454284800000L));


        Author newAuthor = authorService.save(a);

        return "ok";
    }

}