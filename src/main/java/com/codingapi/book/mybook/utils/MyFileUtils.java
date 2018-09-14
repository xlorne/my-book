package com.codingapi.book.mybook.utils;

import org.apache.commons.io.Charsets;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author lorne
 * @date 2018/9/14
 * @description
 */
public class MyFileUtils {

    public static String readOneLine(File file)  {
        try (InputStream input = FileUtils.openInputStream(file)) {
            final InputStreamReader streamReader = new InputStreamReader(input, Charsets.toCharset(Charsets.toCharset("utf8")));
            final BufferedReader reader = IOUtils.toBufferedReader(streamReader);
            return reader.readLine();
        }catch (Exception e){
            e.printStackTrace();
            return "no data";
        }
    }
}
