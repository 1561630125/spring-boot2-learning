package com.battcn.repository.impl;

import com.battcn.entity.User;
import com.battcn.mapper.UserMapper;
import com.battcn.repository.UserRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * description
 *
 * @author faming.yang@hand-china.com 2022-10-07 18:25
 */
@Repository
public class UserRepositoryImpl implements UserRepository {
    @Autowired
    UserMapper userMapper;

    @Override
    @Transactional
    public Integer insertUser() {
        User user = new User();
        user.setUsername(RandomStringUtils.randomAlphanumeric(5));
        user.setPassword(RandomStringUtils.randomAlphanumeric(10));
        return userMapper.insert(user);
    }
}
