package com.see0gan.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class TemplateController {

    @GetMapping
    public String getIndexView(){
        return "index";
    }

    // TODO : block the access without login
    @GetMapping("userprofile")
    public String getProfileView(){
        return "userprofile";
    }

    @GetMapping("hostCenter")
    public String getHostCenterView(){
        return "hostCenter";
    }

    @GetMapping("login")
    public String getLoginView(){
        return "login";
    }

    @GetMapping("join")
    public String getJoinView(){
        return "join";
    }

    // TODO : save model with session attribute
    @GetMapping("space/registration/basicInfoForm")
    public String getSpaceBasicForm1(){
        return "space/registration/basicInfoForm";
    }

    @GetMapping("space/registration/hostInfoForm")
    public String getHostInfoForm2(){
        return "space/registration/hostInfoForm";
    }

    @GetMapping("space/registration/facilityInfoForm")
    public String getSpaceBasicForm3(){
        return "space/registration/facilityInfoForm";
    }


}
