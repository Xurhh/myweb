package com.xrh.xrh_application.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

public class photoandtext {
    @TableId(type = IdType.AUTO)
    public String photo;
    public String text;
    

     public photoandtext(String photo2, String text2) {
        photo = photo2;
        text = text2;
       
    }
    public void set_text(String _text){
        text = _text;
    }
    public void set_url(String _url){
        photo = _url;
    }

    public String getPhoto() {
        return photo;
    }
    public String getText() {
        return text;
    }
   
}
