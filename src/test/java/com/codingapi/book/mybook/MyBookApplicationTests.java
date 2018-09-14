package com.codingapi.book.mybook;

import com.alibaba.fastjson.JSON;
import com.codingapi.book.mybook.helper.GitHelper;
import com.codingapi.book.mybook.model.Catalog;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyBookApplicationTests {


    @Autowired
    private GitHelper gitHelper;

    @Test
    public void contextLoads() {
        Catalog res =  gitHelper.loadCatalog();
        String json = JSON.toJSONString(res);
        System.out.println(json);
    }

}
