package com.zj.zs.markdown;

import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.ast.Node;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * @ClassName MarkdownTest
 * @Author zj
 * @Description markdown 文件测试
 * @Date 2024/3/17 16:00
 * @Version v1.0
 **/
public class MarkdownTest {

    public static void main(String[] args) throws IOException {

        List<String> lines = Files.readAllLines(Path.of("/Users/zj/IdeaProjects/zjBootBlog/README.md"));
        String content = String.join("", lines);
        Parser parser = Parser.builder()
                .build();
        Node document = parser.parse(content);

        HtmlRenderer renderer = HtmlRenderer.builder().build();
        // "<p>This is <em>Sparta</em></p>\n"
        System.out.println(renderer.render(document));
    }
}
