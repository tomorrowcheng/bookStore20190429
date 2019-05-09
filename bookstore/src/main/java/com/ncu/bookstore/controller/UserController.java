package com.ncu.bookstore.controller;

import com.ncu.bookstore.entity.User;
import com.ncu.bookstore.service.UserService;
import com.ncu.bookstore.util.Common;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

    @RequestMapping(value="/insertUser",method = RequestMethod.POST,consumes = {"multipart/form-data"})
    public @ResponseBody Map<String,Object> insertUser(@RequestPart("user") User user, @RequestPart("file") MultipartFile file, HttpServletRequest request, HttpServletResponse response){
        if(user.getUserName()==null|| user.getUserPassword()==null||user.getBirthday()==null){
            return Common.getRes(null,1001,"userName、userPassword and birthday can not be empty");
        }
        response.setHeader("Access-Control-Allow-Origin","*");
        response.setHeader("Cache-Control","no-cache");
        System.out.println("提交的用户："+user);
		//String filePath = request.getSession().getServletContext().getRealPath("/upload");//定义图片上传后的路径
        String filePath="D:/ideatest/bookStore20190429/bookstore/src/main/webapp/upload";
        String newFileName = Common.fileOperate(file,filePath);
        String imgPath="/upload/"+newFileName;
		user.setUserPhoto(imgPath);
		System.out.println("最后的user:"+user);
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
