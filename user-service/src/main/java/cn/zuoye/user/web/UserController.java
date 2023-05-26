package cn.zuoye.user.web;

import cn.zuoye.user.pojo.User;
import cn.zuoye.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 路径： /user/110
     *
     * @param id 用户id
     * @return 用户
     */
    @GetMapping("/{id}")
    public User queryById(@PathVariable("id") Long id) {
        return userService.queryById(id);
    }


    @GetMapping("/getAllUsers")
    public List<User> queryAllUser() {
        // 根据id查询订单并返回
        return userService.getAllUser();
    }
    @DeleteMapping("delete/{orderId}")
    public String deleteUser(@PathVariable("orderId") Long userId) {
        // 根据id查询订单并返回
        if(userService.deleteUser(userId)) return "seccess";
        return "false";
    }
    @PostMapping("addUser")
    public String addUser(@RequestBody User user){
        if(userService.addUser(user)) return "success";
        return "false";
    }








}
