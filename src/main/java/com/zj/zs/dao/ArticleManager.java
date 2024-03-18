package com.zj.zs.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zj.zs.domain.entity.ArticleDO;
import com.zj.zs.domain.entity.UserDO;

import java.util.List;

/**
 * @ClassName ArticleManager
 * @Author zj
 * @Description
 * @Date 2024/3/17 17:22
 * @Version v1.0
 **/
public interface ArticleManager extends IService<ArticleDO> {

    Page<ArticleDO> pageList(int pageNumber, int pageSize);
}
