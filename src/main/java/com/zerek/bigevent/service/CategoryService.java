package com.zerek.bigevent.service;

import com.zerek.bigevent.pojo.Category;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author zerek
* @description 针对表【category】的数据库操作Service
* @createDate 2024-02-23 17:05:30
*/
public interface CategoryService extends IService<Category> {

    void add(Category category);

    List<Category> list();

    Category findById(Integer id);

    void update(Category category);

    void delete(Integer categoryId);
}
