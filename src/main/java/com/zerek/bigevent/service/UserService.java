package com.zerek.bigevent.service;

import com.zerek.bigevent.mapper.UserMapper;
import com.zerek.bigevent.pojo.User;
import com.baomidou.mybatisplus.extension.service.IService;
import jakarta.annotation.Resource;

/**
* @author zerek
* @description 针对表【user(用户表)】的数据库操作Service
* @createDate 2024-02-23 17:05:30
*/
public interface UserService extends IService<User> {
    User findByUsername(String username);
    void register(String username, String password);

    void update(User user);

    void updateAvatar(String avatarUrl);

    void updatePwd(String newPwd);
}
