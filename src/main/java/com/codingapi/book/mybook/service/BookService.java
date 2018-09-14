package com.codingapi.book.mybook.service;

import com.codingapi.book.mybook.model.Catalog;

/**
 * @author lorne
 * @date 2018/9/14
 * @description
 */
public interface BookService {

    Catalog loadCatalog();


    boolean refresh(String token);
}
