package cn.zuoye.user.service;

import cn.zuoye.user.mapper.UserMapper;
import cn.zuoye.user.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User queryById(Long id) {
        return userMapper.findById(id);
    }


    public List<User> getAllUser(){
        return userMapper.getAllUsers();
    }

    public boolean deleteUser(Long UserId){
        if(userMapper.deleteUserById(UserId)) return true;
        else return false;
    }

    public boolean addUser(User user){
        if(userMapper.addUser(user)) return true;
        else return false;
    }


}