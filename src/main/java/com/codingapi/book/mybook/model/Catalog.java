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

    private String name;
    private String path;

    private List<Catalog> list;

    public Catalog(String name, String path) {
        this.name = name;
        this.path = path;
    }

    private boolean hasNoValue(){
        return name==null&&path==null;
    }

    public boolean hasNull(){
        if(hasNoValue()) {
            if(list!=null&&list.size()>1) {
                for (Catalog node : list) {
                    if (node.hasNoValue()) {
                        return true;
                    }
                }
            }else{
                return true;
            }
        }
        return false;
    }
}
