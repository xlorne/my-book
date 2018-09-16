package com.codingapi.book.mybook.controller;

import com.codingapi.book.mybook.service.BookService;
import com.codingapi.book.mybook.service.MarkdownService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author lorne
 * @date 2018/9/14
 * @description
 */
@Controller
@Slf4j
public class IndexController {

    @Autowired
    private BookService gitService;

    @Autowired
    private MarkdownService markdownService;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String index(Model model){
        model.addAttribute("catalogs",gitService.loadCatalog());
        model.addAttribute("index",markdownService.loadIndexBook());
        log.info("index");
        return "index";
    }


    @RequestMapping(value = "/view/{path}/{file}",method = RequestMethod.GET)
    public String view(Model model,@PathVariable("path") String path,@PathVariable("file") String file){
        model.addAttribute("catalogs",gitService.loadCatalog());
        model.addAttribute("index",markdownService.loadView(path+"/"+file));
        return "index";
    }


    @RequestMapping(value = "/view/{file}",method = RequestMethod.GET)
    public String view(Model model,@PathVariable("file") String file){
        model.addAttribute("catalogs",gitService.loadCatalog());
        model.addAttribute("index",markdownService.loadView(file));
        return "index";
    }

}
