package com.phat_store_mvc.services;

import java.util.List;

public interface DataService<E> {
    List<E> getAll();

    E getById(Integer id);

    E save(E e);

    E update(Integer id, String name);

//    E update(E e);

    boolean deleteById(Integer id);

}
