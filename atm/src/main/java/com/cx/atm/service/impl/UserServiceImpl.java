package com.cx.atm.service.impl;

import com.cx.atm.mapper.UserMapper;
import com.cx.atm.pojo.User;
import com.cx.atm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.annotation.Annotation;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    @Override
    public User findById(int id) {
        return userMapper.findById(id);
    }

    @Override
    public void saveuser(User user) {
        userMapper.saveuser(user);
    }

    @Override
    public void deleteuser(int id) {
        userMapper.deleteuser(id);
    }
    @Override
    public void updateuser(User user) {
        userMapper.updateuser(user);
    }


    @Override
    public User findByName(String name) {
        return userMapper.findByName(name);
    }

    @Override
    public String value() {
        return null;
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }
}
