package com.xrh.xrh_application.controller;

import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xrh.xrh_application.entity.User;
import com.xrh.xrh_application.entity.photoandtext;
import com.xrh.xrh_application.mapper.Photomapper;
import com.xrh.xrh_application.mapper.Usermapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class controller1 {


    @Autowired
    private Photomapper phm;

    @Autowired
    private Usermapper u;
    
    


    @GetMapping("/xrh/view")
    public List<photoandtext> fun1(String param) {
        List<photoandtext> a = phm.selectList(null);
        return a;
    }


 


    @PostMapping("/xrh/loginer")
    public String createaccount(@RequestBody User user) {
        QueryWrapper<User> que = new QueryWrapper<>(){};
        if(user.getUsername()!=null&&!user.getUsername().isEmpty())
            que.eq("username",user.getUsername());
            
        
        
        List<User> ans = u.selectList(que);
        if(!ans.isEmpty()&&!ans.get(0).getPassword().equals(user.getPassword())){

            return "{\"status\":\"failed\",\"specific\":\"密码错误！\"}";
        }

        if(!ans.isEmpty()&&ans.get(0).getPassword().equals(user.getPassword()))
            return"{\"status\":\"success\"}";
        int j = -1;
        if(ans.isEmpty()){
            j = u.insert(user);
        }
        
        
        

        
        
        if(j>0)
        return "{\"status\":\"success\"}";
        else 
        return "{\"status\":\"failed\",\"specific\":\"null\"}";
    }
    
    
    
}
