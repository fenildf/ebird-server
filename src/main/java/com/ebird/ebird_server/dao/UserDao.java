package com.ebird.ebird_server.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.ebird.ebird_entity.entity.UserEntity;
import com.smartframe.entity.UserCur;

@Repository
public interface UserDao {
	
	/**
	 * 根据 用户名 密码 查询用户
	 * @param username
	 * @param password
	 * @return
	 */
	@Select("SELECT id ,username ,email,telphone,birthday,avatar,registerTime,lastloginTime FROM userInfo t WHERE  t.username=#{username} AND t.password=#{password} ")
	public UserCur findUserLogin(@Param("username")String username ,@Param("password")String password);
	
	
	/**
	 * 更新用户最后登录时间
	 * @param entity
	 */
	public void updateLasterLoginTime(UserCur entity);
	
	/**
	 * 根据用户名 查询用户信息
	 * @param userName
	 * @return
	 */
	@Select("select * from userInfo t where t.username=#{username} ")
	public List<UserEntity> getUserByName(@Param("username")String userName);
	
	
	/**
	 * 修改用户信息
	 * @param entity
	 */
	public void editUser(UserEntity entity);
	
	
	/**
	 * 新增保存用户
	 * @param entity
	 */
	public void savaUser(UserEntity entity);
	
	
	/**
	 * 修改用户密码
	 * @param map
	 */
	public void updatePassword(Map<String, Object> map);

}
