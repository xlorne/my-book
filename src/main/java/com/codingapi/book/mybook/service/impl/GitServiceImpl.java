package com.codingapi.book.mybook.service.impl;

import com.codingapi.book.mybook.helper.GitHelper;
import com.codingapi.book.mybook.model.Catalog;
import com.codingapi.book.mybook.service.GitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lorne
 * @date 2018/9/14
 * @description
 */
@Service
public class GitServiceImpl implements GitService {

    @Autowired
    private GitHelper gitHelper;

    @Override
    public Catalog loadCatalog() {
        return gitHelper.loadCatalog();
    }
}
