package com.codingapi.book.mybook.controller;

import com.codingapi.book.mybook.service.StaticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lorne
 * @date 2018/9/16
 * @description
 */
@Controller
@RequestMapping("/static")
public class StaticController {

    @Autowired
    private StaticService staticService;

    @RequestMapping("/{file}")
    public ResponseEntity<InputStreamResource> index(@PathVariable("file") String file){
        return staticService.loadStream(file);
    }

    @RequestMapping("/{path}/{file}")
    public ResponseEntity<InputStreamResource> index(@PathVariable("path") String path,
                                                     @PathVariable("file") String file){
        return staticService.loadStream(path+"/"+file);
    }

    @RequestMapping("/{path1}/{path2}/{file}")
    public ResponseEntity<InputStreamResource> index(@PathVariable("path1") String path1,
                                                     @PathVariable("path2") String path2,
                                                     @PathVariable("file") String file){
        return staticService.loadStream(path1+"/"+path2+"/"+file);
    }

    @RequestMapping("/{path1}/{path2}/{path3}/{file}")
    public ResponseEntity<InputStreamResource> index(@PathVariable("path1") String path1,
                                                     @PathVariable("path2") String path2,
                                                     @PathVariable("path3") String path3,
                                                     @PathVariable("file") String file){
        return staticService.loadStream(path1+"/"+path2+"/"+path3+"/"+file);
    }

}
