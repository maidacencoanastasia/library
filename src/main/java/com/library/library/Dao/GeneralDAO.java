package com.library.library.Dao;

import java.util.List;

// общее поведения для всех DAO объектов
public interface GeneralDAO<T> {

    List<T> getAll();

    List<T> search(String... searchString);

    T get(long id); // получение объекта по id

    T save(T obj);// save - обновляет или добавляет объект (один метод на 2 действия)

    void delete(T object);

}