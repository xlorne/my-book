package com.codingapi.book.mybook.controller;

import com.codingapi.book.mybook.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lorne
 * @date 2018/9/14
 * @description
 */
@Slf4j
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private BookService gitService;

    @GetMapping("/refresh")
    public String refresh(@RequestParam("token") String token){
        return gitService.refresh(token)?"success":"fail";
    }

}
