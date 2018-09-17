package com.codingapi.book.mybook.service.impl;

import com.codingapi.book.mybook.config.MyBookConfig;
import com.codingapi.book.mybook.service.StaticService;
import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnails;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

/**
 * @author lorne
 * @date 2018/9/17
 * @description
 */
@Service
@Slf4j
public class StaticServiceImpl implements StaticService {

    @Autowired
    private MyBookConfig myBookConfig;

    @Override
    public ResponseEntity<InputStreamResource> loadStream(String filePath,String w,String h) {
        String staticFilePath = createNewFile(filePath,w,h);
        try {
            ResponseEntity<InputStreamResource> resourceResponseEntity = ResponseEntity
                    .ok()
                    .contentType(MediaType.parseMediaType("application/octet-stream"))
                    .body(new InputStreamResource(FileUtils.openInputStream(new File(staticFilePath))));
            return resourceResponseEntity;
        }catch (Exception e) {
            log.error(e.getLocalizedMessage(),e);
            return null;
        }
    }

    private String createNewFile(String filePath,String w,String h){
        String path = myBookConfig.getGitSavePath()+"/static/"+filePath;
        String extension = FilenameUtils.getExtension(path);
        int width = 0 ;
        int heigh = 0;
        try{
           width = Integer.parseInt(w);
        }catch (Exception e){}
        try{
            heigh = Integer.parseInt(h);
        }catch (Exception e){}

        if(width==0){
            width = heigh;
        }
        if(heigh==0){
            heigh = width;
        }
        if(width==0&&heigh==0){
            return path;
        }
        if(extension.equalsIgnoreCase("jpg")
                ||extension.equalsIgnoreCase("png")
                ||extension.equalsIgnoreCase(".gif")
                ||extension.equalsIgnoreCase("jpeg")) {
            String baseName = FilenameUtils.getBaseName(path);
            File newFile = new File(String.format("/%s%s_%dx%d.%s", FilenameUtils.getPath(path), baseName, width, heigh, extension));
            try {
                if(!newFile.exists()) {
                    newFile.createNewFile();
                    Thumbnails.of(path).size(width, heigh).toFile(newFile);
                }
                return newFile.getPath();
            } catch (IOException e) {
                log.error(e.getLocalizedMessage(),e);
            }
        }

        return path;
    }
}
