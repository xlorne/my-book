package com.codingapi.book.mybook.service.impl;

import com.codingapi.book.mybook.config.MyBookConfig;
import com.codingapi.book.mybook.service.StaticService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.File;

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
    public ResponseEntity<InputStreamResource> loadStream(String filePath) {
        String staticFilePath = myBookConfig.getGitSavePath()+"/static/"+filePath;
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
}
