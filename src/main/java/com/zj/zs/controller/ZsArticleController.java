package com.zj.zs.controller;

import cn.dev33.satoken.stp.SaTokenInfo;
import com.zj.zs.domain.Result;
import com.zj.zs.domain.dto.article.ArticleDTO;
import com.zj.zs.domain.dto.page.ZsPageDTO;
import com.zj.zs.domain.dto.request.ArticleReqDTO;
import com.zj.zs.domain.dto.request.LoginUserReqDTO;
import com.zj.zs.service.ArticleService;
import com.zj.zs.utils.JsonUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @ClassName ZsArticleController
 * @Author zj
 * @Description
 * @Date 2024/3/17 17:43
 * @Version v1.0
 **/
@RestController
@RequestMapping("/api/article")
@AllArgsConstructor
@Slf4j
public class ZsArticleController {

    private ArticleService articleService;


    @PostMapping("/list")
    public Result<ZsPageDTO<ArticleDTO>> list(@RequestBody @Valid ArticleReqDTO request) {
        log.info("ZsArticleController######list: request={}", JsonUtils.toString(request));
        ZsPageDTO<ArticleDTO> result = articleService.page(request.getPageNumber(),
                request.getPageSize());
        return Result.ok(result);
    }
}
