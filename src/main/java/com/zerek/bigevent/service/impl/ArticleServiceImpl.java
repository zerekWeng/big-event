package com.zerek.bigevent.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zerek.bigevent.pojo.Article;
import com.zerek.bigevent.pojo.PageBean;
import com.zerek.bigevent.service.ArticleService;
import com.zerek.bigevent.mapper.ArticleMapper;
import com.zerek.bigevent.utils.ThreadLocalUtil;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
* @author zerek
* @description 针对表【article】的数据库操作Service实现
* @createDate 2024-02-23 17:03:40
*/
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article>
    implements ArticleService{
    @Resource
    private ArticleMapper articleMapper;
    @Override
    public void add(Article article) {
        article.setCreateTime(LocalDateTime.now());
        article.setUpdateTime(LocalDateTime.now());
        Map<String, Object> map = ThreadLocalUtil.get();
        Integer userId = (Integer) map.get("id");
        article.setCreateUser(userId);
        articleMapper.add(article);
    }

    @Override
    public PageBean<Article> list(Integer pageNum, Integer pageSize, Integer categoryId, String state) {
        //1.create PageBean object
        PageBean<Article> pageBean = new PageBean<Article>();

        //2.start PageHelper
        PageHelper.startPage(pageNum, pageSize);

        //3.invoke mapper
        Map<String, Object> map = ThreadLocalUtil.get();
        Integer userId  = (Integer) map.get("id");
        Page<Article> page = (Page<Article>) articleMapper.list(userId, categoryId, state);

        // construct PageBean object
        pageBean.setTotal(page.getTotal());
        pageBean.setItems(page.getResult());
        return pageBean;
    }
}




