package com.zerek.bigevent.controller;

import com.zerek.bigevent.pojo.Article;
import com.zerek.bigevent.pojo.PageBean;
import com.zerek.bigevent.pojo.Result;
import com.zerek.bigevent.service.ArticleService;
import jakarta.annotation.Resource;
import jakarta.validation.constraints.Pattern;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/article")
public class ArticleController {
    @Resource
    private ArticleService articleService;

    @PostMapping
    public Result add(@RequestBody @Validated Article article) {
        articleService.add(article);
        return Result.success();
    }

    @GetMapping
    public Result<PageBean<Article>> list(Integer pageNum,
                                          Integer pageSize,
                                          @RequestParam(required = false) Integer categoryId,
                                          @RequestParam(required = false) @Pattern(regexp = "^(已发布|草稿)$") String state) {
        PageBean<Article> pb = articleService.list(pageNum, pageSize, categoryId, state);
        return Result.success(pb);
    }

    @PutMapping
    public Result update(@RequestBody @Validated Article article) {
        articleService.update(article);
        return Result.success();
    }

    @GetMapping("/detail")
    public Result<Article> getById(@RequestParam Integer id) {
        Article article = articleService.getById(id);
        return Result.success(article);
    }

    @DeleteMapping
    public Result removeById(@RequestParam Integer id) {
        articleService.removeById(id);
        return Result.success();
    }
}
