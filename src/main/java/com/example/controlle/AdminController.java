package com.example.controlle;

import com.example.model.User;
import com.example.service.ManagerService;
import com.example.service.WechatService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.weixin4j.Menu;
import org.weixin4j.Weixin;
import org.weixin4j.WeixinException;
import org.weixin4j.menu.SingleButton;
import org.weixin4j.menu.ViewButton;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static java.awt.SystemColor.menu;

@Controller
@RequestMapping("/admin")
public class AdminController {
    //添加一个日志器
    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
    @Resource
    private ManagerService managerService;

    @RequestMapping("/")
    public String admin(HttpSession httpSession, String name, String password, HttpServletRequest request) throws WeixinException {
        //输出日志文件

        return "login";
    }

    @RequestMapping("/login")
    public String login(User user, HttpServletRequest request) {

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
        try {
            //调用subject.login(token)进行登录，会自动委托给securityManager,调用之前
            subject.login(token);//会跳到自定义的realm中
            request.getSession().setAttribute("user", user);
            return "adminIndex";
        } catch (Exception e) {
            e.printStackTrace();
            request.getSession().setAttribute("user", user);
            request.setAttribute("error", "用户名或密码错误");
            return "login";
        }
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return "index";
    }

    @RequestMapping("/admin")
    public String admin(HttpServletRequest request) {
        return "success";
    }

    @RequestMapping("/student")
    public String student(HttpServletRequest request) {
        return "success";
    }

    @RequestMapping("/teacher")
    public String teacher(HttpServletRequest request) {
        return "success";
    }

    @RequestMapping("/adminLogin")
    public String adminLogin(HttpSession httpSession, String name, String password, HttpServletRequest request) throws WeixinException {
        //输出日志文件
        logger.info("后台登录");
        if (managerService.adminLogin(name, password)) {
            Date now = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//可以方便地修改日期格式


            String now_time = dateFormat.format(now);
            logger.info(name + "在" + now_time + "登录系统，ip为：" + request.getRemoteAddr());
            return "index";
        }
        return "index";
    }

}
