package com.xrh.xrh_application.entity;

import com.baomidou.mybatisplus.annotation.TableName;

@TableName("user")
public class User {
    
    public String username;
    public String password;
    
  

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean setPassword(String old_password,String new_password) {
        if(old_password.equals(new_password)){
            
            this.password = new_password;
            return true;
        }
        return false;

    }
    public void setUsername(String username) {
        this.username = username;
    }

}
