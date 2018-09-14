package com.codingapi.book.mybook.service.impl;

import com.codingapi.book.mybook.helper.BookGitHelper;
import com.codingapi.book.mybook.helper.MarkdownHelper;
import com.codingapi.book.mybook.model.Book;
import com.codingapi.book.mybook.service.MarkdownService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lorne
 * @date 2018/9/14
 * @description
 */
@Service
public class MarkdownServiceImpl implements MarkdownService {

    @Autowired
    private MarkdownHelper markdownHelper;

    @Autowired
    private BookGitHelper gitHelper;


    @Override
    public Book loadView(String path) {
        Book book = gitHelper.getContentBook(path);
        book.setContent(markdownHelper.parseMarkdownString(book.getContent()));
        return book;
    }


    @Override
    public Book loadIndexBook() {
        Book book = gitHelper.getIndexBook();
        book.setContent(markdownHelper.parseMarkdownString(book.getContent()));
        return book;
    }
}
