package com.codingapi.book.mybook.service;

import com.codingapi.book.mybook.model.Book;

/**
 * @author lorne
 * @date 2018/9/14
 * @description
 */
public interface MarkdownService {


    Book loadView(String path);

    Book loadIndexBook();
}
