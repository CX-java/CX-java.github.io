package com.cx.atm.service.impl;

import com.cx.atm.mapper.AccountsMapper;
import com.cx.atm.pojo.Account;
import com.cx.atm.service.AccountsService;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.security.auth.login.AccountNotFoundException;
import java.util.List;

@Slf4j
@Service
@JsonIgnoreProperties(ignoreUnknown = true)
public class AccountsServiceImpl implements AccountsService {

    @Autowired
    private AccountsMapper accountsMapper;

//    @Override
//    public List<Account> findAll() {
//        List<Account> accounts = accountsMapper.findAll();
//        for (Account account: accounts) {
//
//        }
//        accounts.add((Account) accounts);
//        return accounts;
//    }

    @Override
    public Account queryAccountByCardId(Integer cardId) {

        return accountsMapper.findByAccountId(cardId);
    }

    @Override
    public Account LoginAtm(Integer cardId, String passWord) {
        Account acc = accountsMapper.findByAccountId(cardId);
        log.info(acc.toString());
        if (acc == null || !acc.getCardId().equals(cardId)) {
            log.warn("账号有误");
            throw new IllegalArgumentException("账号有误");
        }
        if (!acc.getPassWord().equals(passWord)){
            log.error("密码不正确");
            throw new IllegalArgumentException("密码不正确");
        }
        return acc;
    }

    @Override
    public Account RegisterAccount(Account account) {
        accountsMapper.insertAccount(account);
        log.info("开户添加完成");
        return account;
    }

    @Override
    public Account WithdrawMoney(Integer cardId, double takemoney) {
        Account account = accountsMapper.findByAccountId(cardId);
        if (account == null) {
            log.warn("账号有误");
            return null;
        }
        if (takemoney <= 0) {
            log.error("取款金额必须大于0");
            return null;
        }
        if (account.getMoney() >= takemoney) {
            double updatedMoney = account.getMoney() - takemoney;
            account.setMoney(updatedMoney);
            log.info("此时的余额为:" + updatedMoney);
            accountsMapper.updateAccount(account);
        } else {
            log.error("余额不足");
            return null;
        }
        return account;
    }

    @Override
    public Account deposit(Integer cardId, double putMoney) {
        Account account = accountsMapper.findByAccountId(cardId);
        if (account == null) {
            throw new IllegalArgumentException("账号不存在");
        }
        if (putMoney <= 0) {
            throw new IllegalArgumentException("存款金额必须大于0");
        }
        double updatedMoney = account.getMoney() + putMoney;
        account.setMoney(updatedMoney);
        accountsMapper.updateAccount(account);
        return account;
     }

        //
//    @Override
//    public Account findByLastName(String lastName) {
//        return accountsMapper.findByLastName(lastName);
//    }
//    @Override
//    public Account findByAccountUserName(String userName, String passWord) {
//        if (StringUtils.isEmpty(userName)) {
//            throw new IllegalArgumentException("用户名不能为空");
//        }
//        if (StringUtils.isEmpty(passWord)) {
//            throw new IllegalArgumentException("密码不能为空");
//        }
//
//        Account account = accountsMapper.findByAccountUserName(userName);
//        if (account == null) {
//            throw new UserNotFoundException("用户不存在");
//        }
//
//        if (!passwordEncoder.matches(passWord, account.getPassWord())) {
//            throw new PasswordMismatchException("密码错误");
//        }
//
//        return account;
//    }

    @Override
    public void transferAccount(Integer cardId, Integer transferId, String lastName, double money) {
        // 实现转账业务逻辑
        Account account1 = accountsMapper.findByAccountId(cardId);
        Account account2 = accountsMapper.findByAccountId(transferId);
        if (account1 == null || account2 == null) {
            new IllegalArgumentException("转出账户不存在");
        }
        if (money <= 0) {
            throw new IllegalArgumentException("转账金额必须大于0");
        }
        if (account1.getMoney() < money) {
            throw new IllegalStateException("账户余额不足");
        }

        double updatedMoney1 = account1.getMoney() - money;
        account1.setMoney(updatedMoney1);
        accountsMapper.updateAccount(account1);

        double updatedMoney2 = account2.getMoney() + money;
        account2.setMoney(updatedMoney2);
        accountsMapper.updateAccount(account2);

        log.info("转账操作完成");
    }
    @Override
    public boolean cancelAccount(Integer cardId) {
        Account account = accountsMapper.findByAccountId(cardId);
        if (account == null) {
            return false; // 表示账户不存在，删除失败
        }
        if (account.getMoney() == 0) {
            accountsMapper.deleteAccount(cardId);
            log.info("账户已删除");
            return true;
        } else {
            return false;
        }
        }
    }
