package com.cx.atm.controller;

import com.cx.atm.pojo.Account;
import com.cx.atm.service.AccountsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/accounts")
@CrossOrigin
public class AccountsController {

    @Autowired
    private AccountsService accountsService;

//    @GetMapping
//    public List<Account> findAll() {
//        log.info("查询到所有账户信息");
//        return accountsService.findAll();
//    }

    @PostMapping("/register")
    public Account registerAccount(@Validated @RequestBody Account account) {
        accountsService.RegisterAccount(account);
        log.info("开户添加完成");
        return account;
    }

    @PostMapping("/login")
    public Account loginAtm(@Validated @RequestBody Account account) {
        Account acc = accountsService.LoginAtm(account.getCardId(), account.getPassWord());
        log.info("登录成功：{}", acc);
        return acc;
    }

    @GetMapping("/{cardId}")
    public Account queryAccountByCardId(@PathVariable("cardId") Integer cardId) {
        if (cardId != null) {
            log.info("账户ID: " + cardId);
        }
        return accountsService.queryAccountByCardId(cardId);
    }

    @PostMapping("/savemoney/{cardId}/{putMoney}")
    public ResponseEntity<Object> saveMoney(@PathVariable("cardId") Integer cardId, @PathVariable("putMoney") Double putMoney) {
        Account isUpdated = accountsService.deposit(cardId, putMoney);
        if (isUpdated==null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("更新账户失败");
        }
        Account updatedAccount = accountsService.queryAccountByCardId(cardId);
        log.info("此时的余额为: " + updatedAccount.getMoney());
        return ResponseEntity.ok(updatedAccount);
    }

    @PostMapping("/takemoney/{cardId}/{MoneyInput}")
    public ResponseEntity<Object> takeMoney(
            @PathVariable("cardId") Integer cardId,
            @PathVariable("MoneyInput") double takemoney) {
        Account updatedAccount = accountsService.WithdrawMoney(cardId, takemoney);
        return ResponseEntity.ok(updatedAccount);
    }

    @PostMapping("/transfermoney/{cardId}/{transferId}/{transferLastName}/{transferMoney}")
    public ResponseEntity<String> transferMoney(@PathVariable("cardId") Integer cardId, @PathVariable("transferId")
            Integer transferId, @PathVariable("transferLastName") String lastName, @PathVariable("transferMoney") double money) {
        try {
            accountsService.transferAccount(cardId, transferId, lastName, money);
            return ResponseEntity.ok("转账成功");
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (IllegalStateException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.FORBIDDEN);
        } catch (Exception e) {
            return new ResponseEntity<>("转账失败", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/deleteaccount/{cardId}")
    public ResponseEntity<String> deleteAccount(@PathVariable("cardId") Integer cardId) {
        boolean deletionResult = accountsService.cancelAccount(cardId);
        if (deletionResult) {
            return ResponseEntity.ok("账户删除成功");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("账户不存在或账户余额不为0，删除失败");
        }
    }

}
