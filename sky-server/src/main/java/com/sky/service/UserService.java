package com.sky.service;

import com.sky.dto.UserLoginDTO;
import com.sky.entity.User;

public interface UserService {

    /**
     * 微信login实现
     * @param userLoginDTO
     * @return
     */
     User wxLogin(UserLoginDTO userLoginDTO);
}
