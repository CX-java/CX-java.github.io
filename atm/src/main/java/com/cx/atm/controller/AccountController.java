//package com.cx.atm.controller;
//
//import com.baomidou.mybatisplus.core.metadata.IPage;
//import com.cx.atm.controller.utils.R;
//import com.cx.atm.pojo.Account;
//import com.cx.atm.service.AccountService;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.http.ResponseEntity;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@Slf4j
//@RestController
//@RequestMapping("/accounts")
//public class AccountController {
//    private AccountService accountService;
//
//    public AccountController(AccountService accountService) {
//        this.accountService = accountService;
//    }
//    @GetMapping
//    public List<Account> findAll() {
//        log.info("查询到account");
//        return accountService.findAll();
//    }
//    @GetMapping("{currentPage}/{pageSize}")
////    public ResponseEntity<List<Account>> getAllAccountsByPage(
////            @PathVariable int currentPage, @PathVariable int pageSize){
////        List<Account> accounts = accountService.getAllAccountsByPage(currentPage, pageSize);
////        log.info("当前页: {}，每页大小: {}", currentPage, pageSize);
////        return ResponseEntity.ok(accounts);
////    }
////    public IPage<Account> getPage(@PathVariable int currentPage, @PathVariable int pageSize) {
////        return accountService.getPage(currentPage, pageSize);
////    }
//    public R getPage(@PathVariable int currentPage, @PathVariable int pageSize, Account account) {
//        IPage<Account> page = accountService.getPage(currentPage, pageSize, account);
//        // 如果当前页面值大于总页码值，那么重新执行查询操作，使用最大页码值作为当前页码值
//        if (currentPage > page.getPages()) {
//            page = accountService.getPage((int) page.getPages(), pageSize, account);
//        }
//        log.info(account.toString());
//        return new R(true, page);
//    }
//    @GetMapping("/{userId}")
//    public Account findByAccountId(@PathVariable("userId") Integer userId) {
//        log.info("账户ID: " + userId);
//        return accountService.findByAccountId(userId);
//    }
//    @PostMapping("/add")
//    public Account addAccount(@Validated @RequestBody Account account) {
//        accountService.addAccount(account);
//        log.info("账户添加完成");
//        return account;
//    }
////    @PutMapping("/{userId}")
////    public ResponseEntity<Account> updateAccount(
////            @PathVariable("userId") Integer userId,
////            @Validated @RequestBody Account account) {
////        if (accountService.findByAccountId(userId) == null) {
////            return ResponseEntity.notFound().build();
////        } else {
////            account.setUserId(userId);
////            accountService.updateAccount(account);
////            log.info("账户更新成功");
////            return ResponseEntity.noContent().build();
////        }
////    }
//    @DeleteMapping("/{userId}")
//    public ResponseEntity<Account> deleteAccount(@PathVariable("userId") Integer userId) {
//        if (accountService.findByAccountId(userId) == null) {
//            return ResponseEntity.notFound().build();
//        } else {
//            accountService.deleteAccount(userId);
//            log.info("账户已删除");
//            return ResponseEntity.noContent().build();
//        }
//    }
//}
