package com.ncu.bookstore.controller;

import com.ncu.bookstore.entity.User;
import com.ncu.bookstore.service.UserService;
import com.ncu.bookstore.util.Common;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by Tomorrow on 2019/4/30/030
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping(value="/insertUser",method = RequestMethod.POST)
    public @ResponseBody Map<String,Object> insertUser(@RequestBody User user){
        if(user.getUserName()==null|| user.getUserPassword()==null||user.getBirthday()==null){
            return Common.getRes(null,1001,"userName、userPassword and birthday can not be empty");
        }
        int i=userService.insertUser(user);
        if(i==1) {
            return Common.getRes(userService.selectAllUser(),1000,"success");
        } else {
            return Common.getRes(null,1002,"data insertion failure");
        }
    }

    @RequestMapping(value="/selectAllUser",method = RequestMethod.POST)
    public @ResponseBody Map<String,Object> selectAllUser(){
        List<User> userList=userService.selectAllUser();
        if(!userList.isEmpty()){
            return Common.getRes(userList,1000,"success");
        }else{
            return Common.getRes(null,1002,"no data");
        }
    }

    @RequestMapping(value="/selectUser",method= RequestMethod.POST)
    public @ResponseBody Map<String,Object> selectUser(@RequestBody User user){
        List<User> userList=userService.selectUser(user);
        if(!userList.isEmpty()){
            return Common.getRes(userList,1000,"success");
        }else{
            return Common.getRes(null,1002,"no data");
        }
    }

    @RequestMapping(value="/deleteUser",method= RequestMethod.POST)
    public @ResponseBody Map<String,Object> deleteUser(@RequestBody User user){
        int i=userService.deleteUser(user);
        if(i==1) {
            return Common.getRes(userService.selectAllUser(),1000,"success");
        }
        else {
            return Common.getRes(null,1002,"data deletion failure");
        }
    }

    @RequestMapping(value = "/updateUser",method = RequestMethod.POST)
    public @ResponseBody Map<String,Object> updateUser(@RequestBody User user){
        if(user.getUserName()==null&&user.getUserPassword()==null&&user.getBirthday()==null){
            user=userService.selectUser(user).get(0);
        }
        int i=userService.updateUser(user);
        if(i==1) {
            return Common.getRes(userService.selectAllUser(),1000,"success");
        }
        else {
            return Common.getRes(null,1002,"data update failure");
        }
    }
}
