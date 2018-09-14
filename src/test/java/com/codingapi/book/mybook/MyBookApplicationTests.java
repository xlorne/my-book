package com.codingapi.book.mybook;

import com.alibaba.fastjson.JSON;
import com.codingapi.book.mybook.model.Book;
import com.codingapi.book.mybook.model.Catalog;
import com.codingapi.book.mybook.service.BookService;
import com.codingapi.book.mybook.service.MarkdownService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class MyBookApplicationTests {


    @Autowired
    private BookService gitService;

    @Autowired
    private MarkdownService markdownService;

    @Test
    public void contextLoads() {
        Catalog catalog =  gitService.loadCatalog();
        Book indexBook = markdownService.loadIndexBook();
        log.info("catalog-tree->{},index-content->{}",JSON.toJSONString(catalog),JSON.toJSONString(indexBook));
    }

}
