package com.codingapi.book.mybook.helper;

import com.codingapi.book.mybook.config.MyBookConfig;
import com.codingapi.book.mybook.model.Book;
import com.codingapi.book.mybook.model.Catalog;
import com.codingapi.book.mybook.utils.MyFileUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lorne
 * @date 2018/9/14
 * @description
 */
@Component
@Slf4j
public class BookGitHelper {

    @Autowired
    private MyBookConfig myBookConfig;

    @Autowired
    private GitHelper gitHelper;


    private boolean gitHasExist(){
        File file = new File(myBookConfig.getGitSavePath());
        return file.exists();
    }



    public void hadReady() {
        if(!gitHasExist()){
            gitHelper.download();
        }
    }

    public Catalog loadCatalog(){
        hadReady();
        String path = "/";
        return loadCatalogTree(path);
    }


    private String[] fileList(String path) {
        File file = new File(myBookConfig.getGitSavePath()+path);
        return file.list();
    }

    private String getGitTitle(String filePath) {
        File file = new File(myBookConfig.getGitSavePath()+filePath);
        String line =  MyFileUtils.readOneLine(file);
        line = line.replaceAll("#","");
        line = line.trim();
        return line;
    }


    private Catalog loadCatalogTree(String path){
        Catalog catalog = new Catalog();
        catalog.setPath(path);
        List<Catalog> catalogs = new ArrayList<>();
        String[] files = fileList(path);
        for(String file:files){
            //过滤.git
            if(file.toLowerCase().endsWith(".git")) {
                continue;
            }
            //加入md文件
            if(file.toLowerCase().endsWith("md")) {
                String title = getGitTitle(path+file);
                catalogs.add(new Catalog(title,file));
            }else {
                File directoryFile = new File(myBookConfig.getGitSavePath()+ path+file);
                if (directoryFile.isDirectory()) {
                    Catalog node = loadCatalogTree(path+file+"/");
                    if(!node.hasNull()) {
                        catalogs.add(node);
                    }
                }
            }
        }
        catalog.setList(catalogs);
        return catalog;
    }

    public Book getIndexBook() {
        Book book = getContentBook("index.md");
        if("no data".equals(book.getContent())){
            book = getContentBook("readme.md");
        }
        if("no data".equals(book.getContent())){
            book = getContentBook("README.md");
        }
        return book;
    }



    public Book getContentBook(String path){
        Book book = new Book();
        book.setContent("no data");
        book.setTitle("book");

        File indexFile = new File(myBookConfig.getGitSavePath()+"/"+ path);
        if(indexFile.exists()){
            try {
                String content =  FileUtils.readFileToString(indexFile,"utf8");
                book.setContent(content);
                book.setTitle(getContentTitle("/"+path));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return book;
    }


    private String getContentTitle(String path){
        File indexFile = new File(myBookConfig.getGitSavePath()+"/"+ path);
        if(indexFile.exists()){
            String title = MyFileUtils.readOneLine(indexFile);
            if(title!=null){
                title = title.replaceAll("#","");
                title = title.trim();
            }
            return title;
        }
        return "no data";
    }
}
