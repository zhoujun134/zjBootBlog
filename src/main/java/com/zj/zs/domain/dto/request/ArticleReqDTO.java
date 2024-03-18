package com.zj.zs.domain.dto.request;

import lombok.Data;

/**
 * @ClassName ArticleReqDTO
 * @Author zj
 * @Description
 * @Date 2024/3/17 17:45
 * @Version v1.0
 **/
@Data
public class ArticleReqDTO {

    private int pageNumber = 1;

    private int pageSize = 10;
}
