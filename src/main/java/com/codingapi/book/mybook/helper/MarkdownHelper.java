package com.codingapi.book.mybook.helper;

import com.vladsch.flexmark.ast.Document;
import com.vladsch.flexmark.ext.footnotes.FootnoteExtension;
import com.vladsch.flexmark.ext.tables.TablesExtension;
import com.vladsch.flexmark.ext.toc.TocExtension;
import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.parser.ParserEmulationProfile;
import com.vladsch.flexmark.util.options.MutableDataSet;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author lorne
 * @date 2018/9/13
 * @description
 */
@Component
public class MarkdownHelper {

    public String parseMarkdownString(String markdown){
        MutableDataSet options = new MutableDataSet();
        options.setFrom(ParserEmulationProfile.MARKDOWN);
        options.set(Parser.EXTENSIONS,
                Arrays.asList(
                        //表格支出
                        TablesExtension.create(),
                        //Toc支持
                        TocExtension.create(),
                        //脚本
                        FootnoteExtension.create()
                ));
        Parser parser = Parser.builder(options).build();
        HtmlRenderer renderer = HtmlRenderer.builder(options).build();
        Document document = parser.parse(markdown);
        return renderer.render(document);
    }

}
