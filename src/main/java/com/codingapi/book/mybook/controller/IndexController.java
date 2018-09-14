package com.codingapi.book.mybook.controller;

import com.codingapi.book.mybook.service.GitService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author lorne
 * @date 2018/9/14
 * @description
 */
@Controller
@Slf4j
public class IndexController {

    @Autowired
    private GitService gitService;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String index(Model model){
        model.addAttribute("catalogs",gitService.loadCatalog());
        return "index";
    }



}
