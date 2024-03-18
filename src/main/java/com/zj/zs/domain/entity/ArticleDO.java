package com.zj.zs.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @ClassName ArticleDO
 * @Author zj
 * @Description
 * @Date 2024/3/17 17:12
 * @Version v1.0
 **/
@Data
@TableName("zs_article")
public class ArticleDO {
    @TableId(type = IdType.AUTO)
    private Long id;

    private String title;

    @TableField(value = "abstract")
    private String articleAbstract;

    private String content;

    private LocalDateTime createTime;

}
