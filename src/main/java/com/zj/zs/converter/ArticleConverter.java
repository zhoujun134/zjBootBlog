package com.zj.zs.converter;

import com.zj.zs.domain.dto.article.ArticleDTO;
import com.zj.zs.domain.dto.page.ZsPageDTO;
import com.zj.zs.domain.entity.ArticleDO;
import org.mapstruct.Mapper;

/**
 * @ClassName ArticleConverter
 * @Author zj
 * @Description
 * @Date 2024/3/17 17:38
 * @Version v1.0
 **/
@Mapper(componentModel="spring")
public interface ArticleConverter {

    ArticleDTO toArticleDTO(ArticleDO articleDO);

}
