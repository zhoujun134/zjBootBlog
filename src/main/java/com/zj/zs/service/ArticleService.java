package com.zj.zs.service;

import com.zj.zs.domain.dto.article.ArticleDTO;
import com.zj.zs.domain.dto.page.ZsPageDTO;

/**
 * @ClassName ArticleService
 * @Author zj
 * @Description
 * @Date 2024/3/17 17:31
 * @Version v1.0
 **/
public interface ArticleService {

    ZsPageDTO<ArticleDTO> page(int pageNumber, int pageSize);
}
