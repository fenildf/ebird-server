package com.ebird.ebird_server.service;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.ebird.ebird_api.UserService;
import com.ebird.ebird_entity.entity.BookEntity;
import com.ebird.ebird_entity.entity.UserEntity;
import com.ebird.ebird_entity.entity.UserExerciseDetailEntity;
import com.ebird.ebird_server.dao.UserDao;
import com.smartframe.basics.util.DES;
import com.smartframe.entity.UserCur;


@Service(version = "1.0.0")
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;

	public UserCur findUserLogin(String userName, String password) {
		try {
			password = DES.DESAndBase64Encrypt(password, "w#_L9~za", "UTF-8");//DES加密处理 
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return userDao.findUserLogin(userName, password);

	}

	public void savaUser(UserEntity entity){
		entity.setRegisterTime(new Date());
		userDao.savaUser(entity);
	}	

	public void editUser(UserEntity entity){
		entity.setUpdateTime(new Date());
		userDao.editUser(entity);
	}

	public UserEntity getUserById(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	public void updateLasterLoginTime(UserCur entity) {
		entity.setLastloginTime(new Date());
		userDao.updateLasterLoginTime(entity);
	}

	public List<UserExerciseDetailEntity> findUserExerciseDetailById(
			Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<BookEntity> findExerciseById(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 根据用户名查询用户信息
	 * @param username
	 * @return
	 */
	public List<UserEntity>  getUserByName(String username){
		return userDao.getUserByName(username);
	}


	public void updatePassword(Integer userId ,String password){
		try {
			password = DES.DESAndBase64Encrypt(password, "w#_L9~za", "UTF-8");//DES加密处理 
			Map<String, Object> map = new HashMap<String, Object>();
				map.put("userId", userId);
				map.put("password", password);
			userDao.updatePassword(map);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

}
