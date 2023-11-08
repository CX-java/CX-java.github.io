package com.cx.atm.mapper;

import com.cx.atm.pojo.Account;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AccountsMapper {
    @Select("SELECT UserName,CardId,Password,Sex,money,limitMoney FROM accounts WHERE CardId = #{cardId}")
    Account findByAccountId(Integer cardId);

    //@Select("SELECT * FROM accounts WHERE UserName LIKE ")
   @Select("SELECT * FROM accounts WHERE UserName =#{lastName}")
    Account findByLastName(String lastName);

    @Select("SELECT * FROM accounts")
    List<Account> findAll();

    @Insert("INSERT INTO accounts(UserName,CardId,Password,Sex,limitMoney) VALUES (#{userName},#{cardId},#{passWord},#{sex},#{limitMoney})")
    void insertAccount(Account account);

    @Update("UPDATE accounts SET money = #{money} WHERE CardId= #{cardId}")
     int updateAccount(Account account);

    @Delete("DELETE FROM accounts WHERE CardId = #{cardId}")
    int deleteAccount(Integer cardId);
}
