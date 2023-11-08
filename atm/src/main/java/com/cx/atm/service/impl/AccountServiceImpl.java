//package com.cx.atm.service.impl;
//
//import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
//import com.baomidou.mybatisplus.core.metadata.IPage;
//import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
//import com.cx.atm.mapper.AccountMapper;
//import com.cx.atm.pojo.Account;
//import com.cx.atm.service.AccountService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class AccountServiceImpl implements AccountService {
//    @Autowired
//    private AccountMapper accountMapper;
//
//    @Override
//    public List<Account> findAll() {
//        return accountMapper.findAll();
//    }
//
//    @Override
//    public List<Account> getAllAccountsByPage(int currentPage, int pageSize) {
//        return accountMapper.getAllAccountsByPage(currentPage, pageSize);
//    }
//
//    @Override
//    public Account findByAccountId(Integer userId) {
//        return accountMapper.findByAccountId(userId);
//    }
//
//    @Override
//    public Account addAccount(Account account) {
//        accountMapper.addAccount(account);
//        return account;
//    }
//
//    @Override
//    public void deleteAccount(int aid) {
//        accountMapper.deleteAccount(aid);
//    }
//
//    @Override
//    public void updateAccount(Account account) {
//        accountMapper.updateAccount(account);
//    }
//
////    @Override
////    public IPage<Account> getPage(int currentPage, int pageSize) {
////        IPage<Account> page = new Page(currentPage, pageSize);
////        accountMapper.selectPage(page, null);
////        return page;
////    }
//    @Override
//    public IPage<Account> getPage(int currentPage, int pageSize,Account account) {
//        IPage<Account> page = new Page<>(currentPage, pageSize);
//        LambdaQueryWrapper<Account> lqw = new LambdaQueryWrapper<>();
//        accountMapper.selectPage(page, lqw);
//        return page;
//    }
//}
