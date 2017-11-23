package com.ebird.ebird_server.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.smartframe.entity.UserCur;

@Repository
public interface UserDao {
	
	@Select("SELECT id ,username ,email,telphone,birthday,avatar,registerTime,lastloginTime FROM userInfo t WHERE  t.username=#{username} AND t.password=#{password} ")
	public UserCur findUserLogin(@Param("username")String username ,@Param("password")String password);
	
	
	public void updateLasterLoginTime(UserCur entity);

}
