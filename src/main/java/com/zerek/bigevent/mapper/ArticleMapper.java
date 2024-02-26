package com.zerek.bigevent.mapper;

import com.zerek.bigevent.pojo.Article;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
* @author zerek
* @description 针对表【article】的数据库操作Mapper
* @createDate 2024-02-23 17:03:40
* @Entity com.zerek.bigevent.pojo.Article
*/


public interface ArticleMapper extends BaseMapper<Article> {
    @Insert("insert into article(title, content, cover_img, state, category_id, create_user, create_time, update_time)" +
            "values(#{title}, #{content}, #{coverImg}, #{state}, #{categoryId}, #{createUser}, #{updateTime}, #{updateTime})")
    void add(Article article);

    List<Article> list(@Param("userId") Integer userId,
                       @Param("categoryId") Integer categoryId,
                       @Param("state") String state);

    @Update("update article set title=#{title}, content=#{content}, cover_img=#{coverImg}, state=#{state}, category_id=#{categoryId} where id = #{id}")
    void update(Article article);
}




