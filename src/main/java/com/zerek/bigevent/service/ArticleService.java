package com.zerek.bigevent.service;

import com.zerek.bigevent.pojo.Article;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zerek.bigevent.pojo.PageBean;

/**
* @author zerek
* @description 针对表【article】的数据库操作Service
* @createDate 2024-02-23 17:03:40
*/
public interface ArticleService extends IService<Article> {

    void add(Article article);

    PageBean<Article> list(Integer pageNum, Integer pageSize, Integer categoryId, String state);
}
