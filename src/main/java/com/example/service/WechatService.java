package com.example.service;

import com.example.model.T_Token;
import org.weixin4j.Weixin;
import org.weixin4j.WeixinException;
import org.weixin4j.http.OAuthToken;

public interface WechatService{
    public T_Token selectUser();
    public OAuthToken getOAuthToken();
    public void saveOAuthToken(String access_token, int expires_in);

    public Weixin getWeixin()throws WeixinException;
}
