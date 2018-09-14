package com.codingapi.book.mybook.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author lorne
 * @date 2018/9/14
 * @description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Catalog {

    private String title;
    private String path;

    private List<Catalog> list;

    public Catalog(String title, String path) {
        this.title = title;
        this.path = path;
    }

    private boolean hasNoValue(){
        return title ==null;
    }

    public boolean hasNull(){
        if(list!=null&&list.size()>0) {
            for (Catalog node : list) {
                if (node.hasNoValue()) {
                    return true;
                }
            }
        }else{
            return true;
        }
        return false;
    }
}
