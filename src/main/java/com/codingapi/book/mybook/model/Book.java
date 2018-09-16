package com.codingapi.book.mybook.model;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lorne
 * @date 2018/9/14
 * @description
 */
@Data
@NoArgsConstructor
public class Book {

    private String path;

    private String title;

    private String content;

    public Book(String path, String title,String content) {
        this.title = title;
        this.path = path.toLowerCase();
        this.content =content;
    }


    public void setPath(String path){
        this.path = path;
        this.path = this.path.toLowerCase();
    }

}
