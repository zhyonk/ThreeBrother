package com.example.controlle;

import com.example.model.Game1Form;
import com.example.service.GameService;
import com.example.service.WechatService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.weixin4j.Menu;
import org.weixin4j.Weixin;
import org.weixin4j.WeixinException;
import org.weixin4j.menu.SingleButton;
import org.weixin4j.menu.ViewButton;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/game")
public class GameController {

    //添加一个日志器
    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    //    @Resource
//    private GameService gameService;
    @ResponseBody
    @RequestMapping(value = "/game1/form", method = RequestMethod.POST)
    public String game1Form(HttpServletRequest request, Model model) throws UnsupportedEncodingException {
        request.setCharacterEncoding("utf-8");//设置参数的编码格式
        int max = 100;
        int min = 94;
        Random random = new Random();

        int s = random.nextInt(max) % (max - min + 1) + min;

        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        System.out.println(name + ":" + sex);
        //如果收的的值不是空的
        if (name != null && sex != null) {
            if (sex.equals("1")) {
                System.out.println("image/game1/1-" + Integer.toString(s)+".jpg");
                return "image/game1/1-" + Integer.toString(s)+".jpg";

            } else if (sex.equals("0")) {
                System.out.println("image/game1/0-" + Integer.toString(s));
                return "image/game1/0-" + Integer.toString(s)+".jpg";
            }
        }else {
            return null;
        }
        return null;
    }

    @RequestMapping(value = "/game1/result")
    public String game1Result(HttpServletRequest request, Model model) throws UnsupportedEncodingException {
        request.setCharacterEncoding("utf-8");//设置参数的编码格式
        String imgSrc = request.getParameter("imgSrc");
        model.addAttribute("image",imgSrc);
        return "game1_result";
    }
}
