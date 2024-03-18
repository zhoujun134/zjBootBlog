package com.zj.zs.dao.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zj.zs.dao.ArticleManager;
import com.zj.zs.dao.mapper.ArticleMapper;
import com.zj.zs.domain.entity.ArticleDO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ClassName ArticleManagerImpl
 * @Author zj
 * @Description
 * @Date 2024/3/17 17:23
 * @Version v1.0
 **/
@Slf4j
@Component
public class ArticleManagerImpl extends ServiceImpl<ArticleMapper, ArticleDO> implements ArticleManager {

    @Override
    public Page<ArticleDO> pageList(int pageNumber, int pageSize) {
        Page<ArticleDO> page = new Page<>(pageNumber, pageSize);
        return this.page(page);
    }
}
