package com.xiaokea.controller;


import com.xiaokea.dao.IUserDao;
import com.xiaokea.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
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
    public String doLogin(User user, HttpSession sess) throws IOException {
        String name = user.getName();
        String password = user.getPassword();

        // 获取Mybatis持久层链接及查询数据操作
        InputStream in = Resources.getResourceAsStream("mybatis-conf.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = factory.openSession();
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);

        if(!name.equals("") && !password.equals("")){
            //UserServiceImpl userService = (UserServiceImpl) SSMUtil.getAC().getBean("userServiceImpl");
            User user1 = userDao.selectByUser(user);
            System.out.println("abc");
            System.out.println(user1);
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
    public String doReg(User user, HttpSession sess) throws IOException {
        user.setRegtime(new Date().toLocaleString());
        //UserServiceImpl userService = (UserServiceImpl)SSMUtil.getAC().getBean("userServiceImpl");
        InputStream in = Resources.getResourceAsStream("mybatis-conf.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);

        SqlSession sqlSession = factory.openSession();
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);

        try{
            User fromDataBase = userDao.selectByName(user.getName());
            System.out.println(fromDataBase);
            if (fromDataBase != null) {
                sess.setAttribute("wareReg","账号" + user.getName() + "已存在！请选择其他用户名！");
                return "redirect:/reg.jsp";
            }
            userDao.insert(user);
            sqlSession.commit();
            sqlSession.close();
            in.close();
            sess.setAttribute("user", user);
            return "redirect:/admin.jsp";
        }catch (Exception e){
            System.out.println(e);
            sess.setAttribute("warnReg", "未知异常");
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