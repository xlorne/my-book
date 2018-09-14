package com.codingapi.book.mybook.helper;

import com.codingapi.book.mybook.config.MyBookConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author lorne
 * @date 2018/9/14
 * @description
 */
@Component
public class AdminHelper {

    @Autowired
    private MyBookConfig bookConfig;

    public boolean hasAccess(String token){
        return bookConfig.getRefreshToken().equals(token);
    }

}
