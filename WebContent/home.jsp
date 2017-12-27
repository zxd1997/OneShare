<%@ page language = "java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>OneShare Home page</title>
        <link rel="stylesheet" href="css/home.css" />
        <script type="text/javascript" src="js/banner.js"></script>
    </head>
    <body id="body">
    <div id="top">
    	<div id="topInfo">   	
    	    <a href="">WELCOME TO ONE SHARE</a>
         </div>

    <div id="tophelp">
    <%
 	HttpSession s = request.getSession();
	String str = (String)s.getAttribute("userName");
 	if((str==null)){%>  
 	   
             <a href="login.jsp">请登录</a>          
            <a href="register.jsp">免费注册</a>
            
<%}else { %>
	 <a href="user"><%=str%></a> 
	 <a href="logoff">注销</a>
<%} %>
    </div>    
  	</div>
    	<div id="fixBar">
    <div id="logo">
      <img src="OS_image/logo.png" alt="ONE SHARE" style="width:200px;height:200px;margin-top: -35px;"/>
    </div>
    <div id="searchBar">
       <form action="search">
        <input type="text" id="searchText" name="key">
        <input type="submit" id="searchSubmit"value="搜索一下">
      </form>  
      <div id="share">
      	<a href="shareDetail.jsp"/>
      </div>
      
    </div>
  </div>  
  
  
   
    <div id="galleryBar">
    <div id="gallery">
      <ul id="galleryList">
        <li>
          <a href="type?Type=1" >体育用品</a>
        </li>
        <li>
          <a href="type?Type=2" >电子商品</a>
        </li>
        <li>
          <a href="type?Type=3" >会员账号</a>
        </li>
        <li >
          <a href="type?Type=4" >学习用品</a>
        </li>
        <li >
          <a href="type?Type=5" >衣物正装</a>
        </li>
      </ul>
      </div>
    </div>
    <div id="banner">
        <div id="introductionVideo">
           <video width="279px"  autoplay="" loop="">
              <source src="video/introduction.mp4" type="video/mp4">
           </video>
        </div>
        <div id="container">
            <div id="list" style="left: -960px;">
                <img src="img/5.jpg" alt="1"/>
                <img src="img/1.jpg" alt="1"/>
                <img src="img/2.jpg" alt="2"/>
                <img src="img/3.jpg" alt="3"/>
                <img src="img/4.jpg" alt="4"/>
                <img src="img/5.jpg" alt="5"/>
                <img src="img/1.jpg" alt="5"/>
            </div>
        <div id="buttons">
            <span index="1" class="on"></span>
            <span index="2"></span>
            <span index="3"></span>
            <span index="4"></span>
            <span index="5"></span>
        </div>
        <a href="javascript:;" id="prev" class="arrow"><img src="img/prev.png"></a>
        <a href="javascript:;" id="next" class="arrow"><img src="img/next.png"></a>
        </div>
        <div id="introductionVideo">
           <video width="279px"  autoplay="" loop="">
              <source src="video/introduction.mp4" type="video/mp4">
           </video>
        </div>
    </div>
    
    <div id="listAll">
  
     <!--  <div class="listbox">
       
        <s:iterator value="list">
      
		<div class="box">
			<img src="" style="margin-top: 2px;" />
			<ul>
			<li><s:property value="name"/></li>
			<li><s:property value="type"/></li>
			<li><s:property value="intro"/></li>
			<li>用户名<s:property value="userid"/></li>
			<li><a href="product?productName=${name}">详情</a></li>
			</ul>
		</div>
    </s:iterator>
      
    </div>  -->
    
   
    <div class="listbox">
       
       <div class="box" >
           <img src="img/shop1.jpg" style="margin-top: 2px;"/>
           <a href="">【ONE SHARE】爱奇艺视频会员账号</a>
       </div>

       <div class="box" >
           <img src="img/shop2.jpg" style="margin-top: 2px;"/>
           <a href="">【ONE SHARE】尤尼克斯羽毛球拍</a>
       </div>
       <div class="box" >
           <img src="img/shop3.jpg" style="margin-top: 2px;"/>
           <a href="">【ONE SHARE】三体全集</a>
       </div>
       <div class="box" >
           <img src="img/shop4.jpg" style="margin-top: 2px;"/>
           <a href="">【ONE SHARE】男生正装</a>
       </div>
    </div>
    
    <div class="listbox">
       
       <div class="box" >
           <img src="img/shop1.jpg" style="margin-top: 2px;"/>
           <a href="">【ONE SHARE】爱奇艺视频会员账号</a>
       </div>

       <div class="box" >
           <img src="img/shop2.jpg" style="margin-top: 2px;"/>
           <a href="">【ONE SHARE】尤尼克斯羽毛球拍</a>
       </div>
       <div class="box" >
           <img src="img/shop3.jpg" style="margin-top: 2px;"/>
           <a href="">【ONE SHARE】三体全集</a>
       </div>
       <div class="box" >
           <img src="img/shop4.jpg" style="margin-top: 2px;"/>
           <a href="">【ONE SHARE】男生正装</a>
       </div>
    </div>
    
    <div class="listbox">
       
       <div class="box" >
           <img src="img/shop1.jpg" style="margin-top: 2px;"/>
           <a href="">【ONE SHARE】爱奇艺视频会员账号</a>
       </div>

       <div class="box" >
           <img src="img/shop2.jpg" style="margin-top: 2px;"/>
           <a href="">【ONE SHARE】尤尼克斯羽毛球拍</a>
       </div>
       <div class="box" >
           <img src="img/shop3.jpg" style="margin-top: 2px;"/>
           <a href="">【ONE SHARE】三体全集</a>
       </div>
       <div class="box" >
           <img src="img/shop4.jpg" style="margin-top: 2px;"/>
           <a href="">【ONE SHARE】男生正装</a>
       </div>
    </div>
  </div>
   <div id="footer">
    	<div id="footerContent">
    	<div id="footerLeft">
    		<ul>
    			<li><a href="">关于one share</a></li>
    			<li><a href="">帮助中心</a></li>
    			<li><a href="">开放平台</a></li>
    			<li><a href="">联系我们</a></li>
    			<li><a href="">网站合作</a></li>
    			<li><a href="">知识产权</a></li>
    			<li><a href="">规则意见征集</a></li>
    		</ul>
    	</div>
    	<div id="footerRight">
    		<img src="OS_image/logo.png"  style="width:200px;height:200px"/>
    		<a href="">ONE SHARE,因为有你而变得更好</a>
    	</div>
    	</div>
    </div>
 	</body>
</html>
