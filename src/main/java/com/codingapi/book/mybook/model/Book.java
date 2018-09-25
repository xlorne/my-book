package com.codingapi.book.mybook.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lorne
 * @date 2018/9/14
 * @description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    private String path;

    private String title;

    private String content;


}
