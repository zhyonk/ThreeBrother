package com.example.controlle;

import java.io.IOException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.weixin4j.Configuration;
import org.weixin4j.spi.HandlerFactory;
import org.weixin4j.spi.IMessageHandler;
import org.weixin4j.util.TokenUtil;
/**
 * 新手接入
 *
 * @author qsyang
 * @version 1.0
 */
@Controller
@RequestMapping("/api/weixin4j")
public class CustomWeixinUrlFilter {

    @RequestMapping(method = RequestMethod.GET)
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //微信服务器将发送GET请求到填写的URL上,这里需要判定是否为GET请求
        boolean isGet = request.getMethod().toLowerCase().equals("get");
        if (Configuration.isDebug()) {
            System.out.println("获得微信请求:" + request.getMethod() + " 方式");
            System.out.println("微信请求URL:" + request.getServletPath());
        }
        //消息来源可靠性验证
        String signature = request.getParameter("signature");// 微信加密签名
        String timestamp = request.getParameter("timestamp");// 时间戳
        String nonce = request.getParameter("nonce");       // 随机数
        //Token为weixin4j.properties中配置的Token
        String token = TokenUtil.get();
        //1.验证消息真实性
        //http://mp.weixin.qq.com/wiki/index.php?title=验证消息真实性
        //URL为http://www.weixin4j.org/api/公众号
        //成为开发者验证
        String echostr = request.getParameter("echostr");   //
        //确认此次GET请求来自微信服务器，原样返回echostr参数内容，则接入生效，成为开发者成功，否则接入失败
        if (TokenUtil.checkSignature(token, signature, timestamp, nonce)) {
            response.getWriter().write(echostr);
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/xml");
            //获取POST流
            ServletInputStream in = request.getInputStream();
            if (Configuration.isDebug()) {
                System.out.println("接收到微信输入流,准备处理...");
            }

            //处理输入消息，返回结果
            IMessageHandler messageHandler = HandlerFactory.getMessageHandler();
            //处理输入消息，返回结果
            String xml = messageHandler.invoke(in);
            //返回结果
            response.getWriter().write(xml);
            //返回结果
            response.getWriter().write(xml);
        } catch (Exception ex) {
            ex.printStackTrace();
            response.getWriter().write("");
        }
    }
}