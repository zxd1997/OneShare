<%@page contentType="text/html"%>
<%@page language="java" %>
<%@page import="com.beans.*" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ShareItem Detail</title>
        <link rel="stylesheet" href="css/itemdetail.css" />
        <link rel="stylesheet" href="css/home.css" />
        
    </head>
    <body id="body">
    <div id="top">
    	<div id="topInfo">   	
    	    <a href="">WELCOME TO ONE SHARE</a>
         </div>

    <div id="tophelp">
    <%
 	HttpSession s = request.getSession();
    Product product=(Product)request.getAttribute("product");
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
      	<a href="shareDetail.jsp"/></a>
      </div>
      
    </div>
  </div>  
  
  
  
  <div id="galleryItem">
    <div id="galleryBar">
      <ul id="galleryList">
        <li>
          <a href="type?Type=1" >体育用品</a>
        </li>
        <li >
          <a href="type?Type=2" >电子商品</a>
        </li>
        <li >
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
  	<div class="picbox">
    		<div class="picture"><img src="${product.getPhoto()}"></div>
    		<div class="detailbox">
    			<div class="name"><a href="#"><p><s:property value="product.getName()"></s:property></p></a></div>
    			<div class="intro"><p><s:property value="product.getIntro()"/></p></div>
    			<div class="saleBox">
    				<div class="price1">
    					<p class="pricename">按小时计费</p>
				<p class="price">￥<span><s:property value="product.getRent1()"/></span></p><br />
    				</div>
    				
				<div class="price2">
					<p class="pricename">按天计费</p>
				<p class="price">￥<span><s:property value="product.getRent2()"/></span></p>
				</div>
				<div class="price3">
					<p class="pricename">按月计费</p>
				<p class="price">￥<span><s:property value="product.getRent3()"/></span></p>
				</div>
				<div class="etraBox">
					<p class="etra"><s:property value="product.getExtra()"/></p>
				</div>
    			</div>
    			<div class="pay">
    			<%if (str==null) {%>请登录！！！！！！！！！！！！！！！！<%}else{ %>
    				<s:if test= "product.isOnUse()==false">
    			<form action="orderaction">
    					<p >请选择计费方式:</p>
    				<label><input name="order.payType" type="radio" value="1">按小时</label>
    				<label><input name="order.payType" type="radio" value="2">按天</label>
    				<label><input name="order.payType" type="radio" value="3">按月</label>
    				<input name="productName" value=${productName} type=hidden>
    					<br>
    					<div class="start">
    				<p class="cash">押金:<s:property value="product.getDeposit()"/></p>
    					
    					<input type="submit" value="发起租用"> 
    					</form>
    					</s:if>
    			
    					<s:else>已被租用！！！！！！</s:else>
    			</div><%} %>
    			</div>
    			
    		</div>
    		
    		</div>
	<from action="comment">
		<s:property value="c.overall" placeholder="评分"/>
		<s:property value="c.comment" placeholder="评价"/>
		<input type="submit" value="提交评价">
	</from>
	 <s:iterator value="list">
		<s:property value="userId"></s:property>
		<s:property value="overall"></s:property>
		<s:property value="comment"></s:property>
	</s:iterator>
 	</body>
</html>