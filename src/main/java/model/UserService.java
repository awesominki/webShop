package model;

import dto.UserVO;

import java.util.ArrayList;

public class UserService {
	UserDAO dao = new UserDAO();
	public int insertUser(UserVO user) {
		return dao.insertUser(user);
	}
	public ArrayList<UserVO> getUsers(){
		return dao.getUsers();
	}
	
}
