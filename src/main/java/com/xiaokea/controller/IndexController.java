package com.xiaokea.controller;


import com.xiaokea.domain.User;
import com.xiaokea.service.Impl.UserServiceImpl;
import com.xiaokea.util.SSMUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Date;


/**
 * @Author: Edward Gavin
 * @Create: 2019-09-24 10:50
 */

@Controller
public class IndexController {
    /**
     * 主页展示
     * @return
     */
    @RequestMapping("/index")
    public String index(){
        return "redirect:/index.jsp";
    }

    /**
     * 前往注册界面
     * @return
     */
    @RequestMapping("/toReg")
    public String toReg(){
        return "redirect:/reg.jsp";
    }

    /**
     * 登录功能
     * @param user
     * @param sess
     * @return
     */
    @RequestMapping("/doLogin")
    public String doLogin(User user, HttpSession sess){
        String name = user.getName();
        System.out.println(name);
        String password = user.getPassword();
        System.out.println(password);
        if(!name.equals("") && !password.equals("")){
            UserServiceImpl userService = (UserServiceImpl) SSMUtil.getAC().getBean("userServiceImpl");
            System.out.println(userService);
            User user1 = userService.loginCheck(user);
            System.out.println("abc");
            if(user1 != null){
                sess.setAttribute("user", user1);
                return "redirect:/admin.jsp";
            }else{
                sess.setAttribute("warn", "账号或者密码错误！");
                return "redirect:/index.jsp";
            }
        }
        sess.setAttribute("warn", "账号或者密码为空！请输入完整！");
        return "redirect:/index";
    }

    /**
     * 注册功能
     * @param user
     * @param sess
     * @return
     */
    @RequestMapping("/doReg")
    public String doReg(User user, HttpSession sess){
        System.out.println(user.getName());
        System.out.println(user.getPassword());
        user.setRegtime(new Date().toString());
        UserServiceImpl userService = (UserServiceImpl)SSMUtil.getAC().getBean("userServiceImpl");
        try{
            userService.insert(user);
            sess.setAttribute("user", user);
            return "redirect:/admin.jsp";
        }catch (Exception e){
            System.out.println(e);
            sess.setAttribute("warn", "账号" + user.getName() + "已存在！请选择其他用户名！");
            return "redirect:/reg.jsp";
        }
    }

    /**
     * 退出登录
     * @param sess
     * @return
     */
    @RequestMapping("/doLogout")
    public String doLogout(HttpSession sess){
        try {
            sess.removeAttribute("user");
        }catch (Exception e){
            System.out.println(e);
        }
        try {
            sess.removeAttribute("warn");

        }catch (Exception e){
            System.out.println(e);
        }
        return "redirect:/index.jsp";
    }
}