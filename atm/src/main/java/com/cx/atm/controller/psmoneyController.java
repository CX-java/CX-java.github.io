//package com.cx.atm.controller;
//
//import com.cx.atm.pojo.Account;
//import com.cx.atm.service.AccountService;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.*;
//
//@Slf4j
//@RestController
//@RequestMapping("/psmoney")
//public class psmoneyController {
//    private AccountService accountService;
//
////    @PostMapping
////    public ResponseEntity<Account> addAccountMoney(@Validated @RequestBody Account balance) {
////        accountService.addAccountMoney(balance);
////        log.info("AccountMoney added");
////        return ResponseEntity.status(HttpStatus.CREATED).build();
////    }
////
////    @PutMapping("/{user_id}")
////    public ResponseEntity<Account> updateAccountMoney(@PathVariable("user_id") Integer user_id, @Validated @RequestBody Account balance) {
////        if (accountService.findByAccountId(user_id) == null) {
////            return ResponseEntity.notFound().build();
////        } else {
////            accountService.updateaccount(balance);
////            log.info("AccountMoney updated successfully");
////            return ResponseEntity.noContent().build();
////        }
//    }
//
