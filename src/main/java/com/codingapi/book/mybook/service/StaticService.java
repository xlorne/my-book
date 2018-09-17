package com.codingapi.book.mybook.service;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;

/**
 * @author lorne
 * @date 2018/9/17
 * @description
 */
public interface StaticService {

    ResponseEntity<InputStreamResource> loadStream(String file,String w,String h);
}
