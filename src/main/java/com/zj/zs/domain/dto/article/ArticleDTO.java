package com.zj.zs.domain.dto.article;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @ClassName ArticleDTO
 * @Author zj
 * @Description
 * @Date 2024/3/17 17:33
 * @Version v1.0
 **/
@Data
public class ArticleDTO {

    private Long id;

    private String title;

    private String articleAbstract;

    private String content;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
}
