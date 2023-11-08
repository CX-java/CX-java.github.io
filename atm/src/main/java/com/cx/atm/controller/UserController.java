//package com.cx.atm.controller;
//import com.cx.atm.pojo.User;
//import com.cx.atm.service.UserService;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@Slf4j
//@RestController
//@RequestMapping("/users")
//public class UserController {
//
//    private  UserService userService;
//
//    public UserController(UserService userService) {
//        this.userService = userService;
//    }
//    @GetMapping("/user")
//    public List<User> findAll() {
//        log.info("查询到user");
//        return userService.findAll();
//    }
//    @GetMapping("/{uid}")
//    public ResponseEntity<User> getUser(@PathVariable("uid") int uid) {
//        User user = userService.findById(uid);
//        if (user == null) {
//            return ResponseEntity.notFound().build();
//        } else {
//            return ResponseEntity.ok(user);
//        }
//    }
//
//    @PostMapping
//    public ResponseEntity<?> saveUser(@Validated @RequestBody User user) {
//        userService.saveuser(user);
//        return ResponseEntity.status(HttpStatus.CREATED).build();
//    }
//
//    @PutMapping("/{uid}")
//    public ResponseEntity<?> updateUser(@PathVariable("uid") int uid, @Validated @RequestBody User user) {
//        if (userService.findById(uid) == null) {
//            return ResponseEntity.notFound().build();
//        } else {
//            user.setUid((int) uid);
//            userService.updateuser(user);
//            return ResponseEntity.noContent().build();
//        }
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<?> deleteUser(@PathVariable("uid") int uid) {
//        if (userService.findById(uid) == null) {
//            return ResponseEntity.notFound().build();
//        } else {
//            userService.deleteuser(uid);
//            return ResponseEntity.noContent().build();
//        }
//    }
//}
