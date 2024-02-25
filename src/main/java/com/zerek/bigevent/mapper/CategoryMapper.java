package com.zerek.bigevent.mapper;

import com.zerek.bigevent.pojo.Category;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
* @author zerek
* @description 针对表【category】的数据库操作Mapper
* @createDate 2024-02-23 17:05:30
* @Entity com.zerek.bigevent.pojo.Category
*/
public interface CategoryMapper extends BaseMapper<Category> {

    @Insert("insert into category(category_name, category_alias, create_user, create_time, update_time)" +
            "values(#{categoryName}, #{categoryAlias}, #{createUser}, #{createTime}, #{updateTime})")
    void add(Category category);

    @Select("select * from category where create_user=#{userId}")
    List<Category> list(Integer userId);

    @Select(("select * from category where id=#{id}"))
    Category findById(Integer id);

    @Update("update category set category_name=#{categoryName}, category_alias=#{categoryAlias}, update_time=#{updateTime} where id=#{id}")
    void update(Category category);

    @Delete("delete from category where id=#{categoryId}")
    void delete(Integer categoryId);
}




