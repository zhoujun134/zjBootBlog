package com.zj.zs.converter;

import com.zj.zs.domain.dto.article.ArticleDTO;
import com.zj.zs.domain.entity.ArticleDO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-17T22:04:49+0800",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
@Component
public class ArticleConverterImpl implements ArticleConverter {

    @Override
    public ArticleDTO toArticleDTO(ArticleDO articleDO) {
        if ( articleDO == null ) {
            return null;
        }

        ArticleDTO articleDTO = new ArticleDTO();

        articleDTO.setId( articleDO.getId() );
        articleDTO.setTitle( articleDO.getTitle() );
        articleDTO.setArticleAbstract( articleDO.getArticleAbstract() );
        articleDTO.setContent( articleDO.getContent() );
        articleDTO.setCreateTime( articleDO.getCreateTime() );

        return articleDTO;
    }
}
