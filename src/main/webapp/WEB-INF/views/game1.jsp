<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018-01-12
  Time: 20:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <meta charset="UTF-8">

    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <base href="<%=basePath%>">
    <title>测测你的人生成绩单</title>
    <link rel="stylesheet" href="<%=basePath%>css/weui.css" type="text/css"></link>
    <script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script><!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="http://cdn.bootcss.com/jquery-weui/0.8.0/js/jquery-weui.min.js"></script>
    <script type="text/javascript" src="https://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
    <script src="https://res.wx.qq.com/open/libs/weuijs/1.0.0/weui.min.js"></script>
    <script src="<%=basePath%>/js/zepto.min.js"></script>
    <style>
        .imgBody > img {
            margin: 1.4375rem 25% 1rem 20%;
            height: 20.625rem;
        }
    </style>
</head>
<body ontouchstart>
<div class="page__bd" style="height: 100%;">

    <div class="imgBody">
        <img src="<%=basePath%>/image/Achievement.jpg">
    </div>
    <%--<div class="weui-cells__title">表单</div>--%>
    <form>


        <div class="weui-cells weui-cells_form">
            <div class="weui-cell">
                <div class="weui-cell__hd"><label class="weui-label">姓名:</label></div>
                <div class="weui-cell__bd">
                    <input class="weui-input" type="text" placeholder="请输入您的姓名" name="name"/>
                </div>
            </div>

            <div class="weui-cells weui-cells_radio">
                <label class="weui-cell weui-check__label" for="x11">
                    <div class="weui-cell__bd">
                        <p>我是男生</p>
                    </div>
                    <div class="weui-cell__ft">
                        <input type="radio" class="weui-check" name="sex" id="x11" value="1"/>
                        <span class="weui-icon-checked"></span>
                    </div>
                </label>
                <label class="weui-cell weui-check__label" for="x12">

                    <div class="weui-cell__bd">
                        <p>我是女生</p>
                    </div>
                    <div class="weui-cell__ft">
                        <input type="radio" name="sex" class="weui-check" id="x12" checked="checked" value="0"/>
                        <span class="weui-icon-checked"></span>
                    </div>
                </label>
            </div>

            <div class="page__bd page__bd_spacing">
                <a href="javascript:;" class="weui-btn weui-btn_primary" id="button">提交</a>
            </div>


        </div>
    </form>
    <script>

        $(function () {
            $('#button').on('click', function () {
                var data = $('form').serialize();
                var content = JSON.stringify(data).replace(/"/gi, '').replace(/&/gi, '<br>');
                $.post('<%=basePath%>game/game1/form', data).success(function (result) {
                    window.location.href = "<%=basePath%>"+"/game/game1/result?imgSrc="+result
                })
            });
        });

        document.body.setAttribute('ontouchstart', '');
        // android
        //document.title = "WeUI表单序列化示例";

        // iOS
        if (typeof WeixinJSBridge == "object" && typeof WeixinJSBridge.invoke == "function") {
            callback();
        } else {
            if (document.addEventListener) {
                document.addEventListener("WeixinJSBridgeReady", callback, false);
            } else if (document.attachEvent) {
                document.attachEvent("WeixinJSBridgeReady", callback);
                document.attachEvent("onWeixinJSBridgeReady", callback);
            }
        }

        function callback() {
            WeixinJSBridge.invoke('setPageTitle', {title: '测试测试测试'}, function (res) {
                $.weui.alert(res.err_msg);
            });
        }

        //# sourceURL=pen.js


    </script>

    <script src="https://cdn.bootcss.com/jquery/1.11.0/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/jquery-weui/1.2.0/js/jquery-weui.min.js"></script>
</body>
</html>
