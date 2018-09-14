package com.codingapi.book.mybook.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author lorne
 * @date 2018/9/14
 * @description
 */
@Data
@ConfigurationProperties(prefix = "codingapi.mybook")
@Component
public class MyBookConfig {

    /**
     * git url
     */
    private String gitUrl;


    /**
     * git account username
     */
    private String gitUserName;


    /**
     * git account password
     */
    private String gitPassword;


    /**
     * git branch
     */
    private String gitBranch;


    /**
     * local save path
     */
    private String gitSavePath;





}
