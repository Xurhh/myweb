package com.xrh.xrh_application.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.xrh.xrh_application.entity.photoandtext;
import com.xrh.xrh_application.mapper.Photomapper;

import jakarta.servlet.http.HttpServletRequest;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
public class uploadphotos {

    @Autowired
    private Photomapper phm;

    @PostMapping("/xrh/upload")
    public ResponseEntity<Map<String, String>> up(String text,MultipartFile photo,HttpServletRequest request)throws IOException {
        String path = "/usr/local/nginx/html/src/";
        Map<String, String> response = new HashMap<>();
        String p1 = photo.getOriginalFilename();

        phm.insert(new photoandtext(p1, text));
         try {
            savefile(path, photo);
            response.put("success", "true");
            response.put("message", "File uploaded successfully");
            return ResponseEntity.ok(response);
        } catch (IOException e) {
            response.put("success", "false");
            response.put("message", "Failed to upload file: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
        
            public void savefile(String path, MultipartFile photo) throws IOException{
                
                File file = new File(path+photo.getOriginalFilename());
                if(file.exists()){
                    String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
                    File file2 = new File(path+timestamp+photo.getOriginalFilename());
                    photo.transferTo(file2);
                    return;
                }
                photo.transferTo(file);
            }
    

}
