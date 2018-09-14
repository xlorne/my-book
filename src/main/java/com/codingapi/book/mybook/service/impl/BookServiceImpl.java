package com.codingapi.book.mybook.service.impl;

import com.codingapi.book.mybook.helper.AdminHelper;
import com.codingapi.book.mybook.helper.BookGitHelper;
import com.codingapi.book.mybook.helper.GitHelper;
import com.codingapi.book.mybook.model.Catalog;
import com.codingapi.book.mybook.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lorne
 * @date 2018/9/14
 * @description
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private GitHelper gitHelper;

    @Autowired
    private BookGitHelper bookGitHelper;

    @Autowired
    private AdminHelper adminHelper;

    @Override
    public Catalog loadCatalog() {
        return bookGitHelper.loadCatalog();
    }

    @Override
    public boolean refresh(String token) {
        if(adminHelper.hasAccess(token)) {
            gitHelper.pull();
            return true;
        }else{
            return false;
        }
    }
}
