package com.example.controlle;

import com.example.model.T_Token;
import com.example.service.WechatService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.weixin4j.Menu;
import org.weixin4j.Weixin;
import org.weixin4j.WeixinException;
import org.weixin4j.http.OAuthToken;
import org.weixin4j.menu.SingleButton;
import org.weixin4j.menu.ViewButton;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Chingyu Mo
 * @create 2016-07-23-20:20
 */
// 注解标注此类为springmvc的controller，url映射为"/home"
@Controller
@RequestMapping("/home")
public class HomeController {
    //添加一个日志器
    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
    @Resource
    private WechatService wechatService;
    //映射一个action
    @RequestMapping("/index")
    public  String index() throws WeixinException {
        //输出日志文件
        logger.info("主页index");

        Weixin weixin = wechatService.getWeixin();

        Menu menu = weixin.getMenu();

        if (menu !=null){
            String s = menu.toJSONObject().toString();
            logger.info(s);
        }
        List<SingleButton> button_list = new ArrayList<SingleButton>();
        button_list.add(new ViewButton("测试","http://localhost:8080/maven-SpringMVC/home/test"));
        menu.setButton(button_list);
        weixin.createMenu(menu);
        logger.info(String.valueOf(weixin));
        //返回一个index.jsp这个视图
        return "index";
    }
    @RequestMapping("/test")
    public  String test() throws WeixinException {
        //输出日志文件
        logger.info("点击测试");

        //返回一个index.jsp这个视图
        return "index";
    }
}