package com.cx.atm.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cx.atm.pojo.Account;
import com.cx.atm.pojo.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService extends Service {
    public List<User> findAll();
    public User findById(int id);
    public void saveuser(User user);
    public void deleteuser(int id);
    public void updateuser(User user);
    public User findByName(String name);

}
