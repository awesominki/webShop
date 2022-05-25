package model;

import dto.UsersVO;

public class UsersService {
    UsersDAO dao = new UsersDAO();
    public UsersVO selectById(String user_id, String user_pass){
        return dao.selectById(user_id,user_pass);
    }

}
