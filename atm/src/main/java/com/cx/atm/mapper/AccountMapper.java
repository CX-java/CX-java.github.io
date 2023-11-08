//package com.cx.atm.mapper;
//
//import com.baomidou.mybatisplus.core.mapper.BaseMapper;
//import com.cx.atm.pojo.Account;
//import org.apache.ibatis.annotations.*;
//
//import java.util.List;
//@Mapper
//public interface AccountMapper extends BaseMapper<Account> {
//    @Select("SELECT * FROM account WHERE user_id = #{userId}")
//    Account findByAccountId(Integer userId);
//
//
//    @Select("SELECT * FROM account")
//    List<Account> findAll();
//
//    @Select("SELECT * FROM account LIMIT #{currentPage}, #{pageSize}")
//    List<Account> getAllAccountsByPage(int currentPage, int pageSize);
//
//    @Insert("INSERT INTO account(user_id,balance) VALUES (#{userId},#{balance})")
//    void addAccount(Account account);
//
//    @Update("UPDATE account SET balance = #{balance} WHERE user_id = #{userId}")
//    void updateAccount(Account account);
//
//    @Delete("DELETE FROM account WHERE aid = #{aid}")
//    void deleteAccount(int aid);
////    @Insert("INSERT INTO account(balance) VALUES(#{balance} where user_id = #{userId}")
////    void addaccountMoney(Account balance, Integer userId);
//}
