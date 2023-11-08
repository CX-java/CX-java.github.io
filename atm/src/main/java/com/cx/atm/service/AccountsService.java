package com.cx.atm.service;

import com.cx.atm.pojo.Account;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AccountsService {
    //List<Account> findAll();
    Account queryAccountByCardId(Integer cardId);
    //Account queryByName(String lastName);
   // Account findByAccountUserName(String userName,String password);
    Account LoginAtm(Integer cardId,  String passWord);
    Account RegisterAccount(Account account);
    Account WithdrawMoney( Integer cardId,double takemoney);
    Account deposit(Integer cardId, double putMoney);
    void transferAccount(Integer cardId,Integer transferId,String lastName,double money);
    boolean cancelAccount(Integer cardId);


}
