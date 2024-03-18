package com.zj.zs.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zj.zs.converter.ArticleConverter;
import com.zj.zs.dao.ArticleManager;
import com.zj.zs.domain.dto.article.ArticleDTO;
import com.zj.zs.domain.dto.page.ZsPageDTO;
import com.zj.zs.domain.entity.ArticleDO;
import com.zj.zs.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName ArticleServiceImpl
 * @Author zj
 * @Description
 * @Date 2024/3/17 17:31
 * @Version v1.0
 **/
@Slf4j
@Service
public class ArticleServiceImpl implements ArticleService {

    @Resource
    private ArticleManager articleManager;
    @Resource
    private ArticleConverter articleConverter;

    @Override
    public ZsPageDTO<ArticleDTO> page(int pageNumber, int pageSize) {
        final Page<ArticleDO> articleDOPage = articleManager.pageList(pageNumber, pageSize);
        IPage<ArticleDTO> resultPage =
                articleDOPage.convert(articleDO -> articleConverter.toArticleDTO(articleDO));
        return new ZsPageDTO<>(resultPage.getCurrent(), resultPage.getTotal(), resultPage.getRecords());
    }
}
