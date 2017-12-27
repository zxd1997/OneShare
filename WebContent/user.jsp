<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="css/user.css" />
<title>用户信息</title>
</head>
<body id="body">

	
	<div id="user">
		<div id="photo">
			<img src="OS_image/logo.png" style="width:150px;height:150px;">
		</div>
		<div id="word">
		<div id="editor">
        </div>
		<div id="information">
			<div id="name">姓名：<s:property value="user.getName()"/></div>
			<div id="nickName">用户名:<s:property value="user.getNickname()"/></div>
			<div id="email">Email:<s:property value="user.getEmail()"/></div>
			<div id="phone">手机:<s:property value="user.getPhone()"/></div>
			<div id="address">地址:<s:property value="user.getAddress()"/></div>
			<div id="studentnum"> 学生卡号:<s:property value="user.getSchoolCode()"/></div>
		</div>
		</div>
	</div>
	
	<div id="mine">
	<div id="orderTitle"><a>我的订单</a></div>			
		<div id="order">
				
 <s:iterator value="olist">	
			<div class="content">
				<div class="contentBox">
					<div class="contentBox1">
						<a >时间</a>
					</div>
					<div class="contentBox2">
						<img src="OS_image/logo.png" style="width:100px;height:100px;">
						<a >产品信息:<s:property value="productId"/></a>	
						
						
						
						<a >共享人:<s:property value="userId"/></a>
						<a>价格：<s:property value="cost"/></a>
						<div class="but">
							<a href="returnaction?orderid=${id}">归还</a>
						</div>						
					</div>
					</div>
					</div>
    </s:iterator>
				</div>	
			
		
		<div id="productTitle"><a>我的共享</a></div>
		<div id="product">			
			 <s:iterator value="plist">
			<div class="content">
				<div class="contentBox">
					<div class="contentBox1">
						<a >时间</a>
					</div>
					<div class="contentBox2">
						<img src="${photo}" style="width:50px;height:50px;">
						<a>产品信息：<s:property value="name"/></a>
						<a>产品类型：<s:property value="type"/></a>
						<a>产品介绍：<s:property value="intro"/></a>
						<a href="product?productName=${name}">详情</a>
						<a>租借人：<s:property value="userId"/></a>
						<div class="but">
							<a href="offaction?productName=${name}">追回</a>
						</div>						
					</div>
				</div>
				</div>	
    </s:iterator>
			</div>
	</div>	

</body>
</html>
