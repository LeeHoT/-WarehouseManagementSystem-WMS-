<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html lang="zh" class="no-js">
<%
	String path = request.getContextPath() + "/"; 
%>
    <head>

        <meta charset="utf-8">
        <title>登录(Login)</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">

        <!-- CSS -->
        <link rel="stylesheet" href="<%=path%>assets/css/reset.css">
        <link rel="stylesheet" href="<%=path%>assets/css/supersized.css">
        <link rel="stylesheet" href="<%=path%>assets/css/style.css">

        <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
        <!--[if lt IE 9]>
            <script src="assets/js/html5.js"></script>
        <![endif]-->

    </head>

    <body>
<!--MOB SHARE BEGIN-->
                            <div class="-mob-share-ui-button -mob-share-open">分享</div>
                            <div class="-mob-share-ui" style="display: none">
                                <ul class="-mob-share-list">
                                    <li class="-mob-share-weibo"><p>新浪微博</p></li>
                                    <li class="-mob-share-tencentweibo"><p>腾讯微博</p></li>
                                    <li class="-mob-share-qzone"><p>QQ空间</p></li>
                                    <li class="-mob-share-qq"><p>QQ好友</p></li>
                                    <li class="-mob-share-weixin"><p>微信</p></li>
                                    <li class="-mob-share-douban"><p>豆瓣</p></li>
                                    <li class="-mob-share-renren"><p>人人网</p></li>
                                    <li class="-mob-share-kaixin"><p>开心网</p></li>
                                    <li class="-mob-share-facebook"><p>Facebook</p></li>
                                    <li class="-mob-share-twitter"><p>Twitter</p></li>
                                    <li class="-mob-share-pocket"><p>Pocket</p></li>
                                    <li class="-mob-share-google"><p>Google+</p></li>
                                    <li class="-mob-share-youdao"><p>有道云笔记</p></li>
                                    <li class="-mob-share-mingdao"><p>明道</p></li>
                                    <li class="-mob-share-pengyou"><p>朋友网</p></li>
                                    <li class="-mob-share-tumblr"><p>Tumblr</p></li>
                                    <li class="-mob-share-instapaper"><p>Instapaper</p></li>
                                    <li class="-mob-share-linkedin"><p>LinkedIn</p></li>
                                </ul>
                                <div class="-mob-share-close">取消</div>
                            </div>
                            <div class="-mob-share-ui-bg"></div>
                            <script id="-mob-share"
                            src="http://f1.webshare.mob.com/code/mob-share.js?appkey=1b157b0144340"></script>
                            <!--MOB SHARE END-->
        <div class="page-container">
            <h1>登录(Login)</h1>
            
            <s:form action="pages/product/login" method="post" theme="simple">                
                <s:textfield name="userId" cssClass="username" placeholder="请输入您的用户编号！"></s:textfield>
                <s:fielderror fieldName="IdNull" escape="false"></s:fielderror>
                <s:password name="userPassword" cssClass="password" placeholder="请输入您的用户密码！"></s:password>
                <s:fielderror fieldName="PasswordNull" escape="false"></s:fielderror>
                <br><br>
                &nbsp;
				<br><br>
                <button type="submit" class="submit_button">登录</button>      
            </s:form>
        </div>
		
        <!-- Javascript -->
        <script src="<%=path%>assets/js/jquery-1.8.2.min.js" ></script>
        <script src="<%=path%>assets/js/supersized.3.2.7.min.js" ></script>
        <script src="<%=path%>assets/js/supersized-init.js" ></script>
        <!-- <script src="assets/js/scripts.js" ></script> --> 
		
    </body>

</html>

