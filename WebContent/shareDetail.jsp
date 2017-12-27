<!DOCTYPE html>
<%@ page language="java" contentType="text/html; 
charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="s" uri="/struts-tags"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Share Detail</title>
        <link rel="stylesheet" href="css/login.css" />
    </head>
    <body>
    	<div class="share">
    		<div class="message">分享你的惊喜</div>
    		<div id="darkbannerwrap"></div>
    			 <s:form action="share" enctype="multipart/form-data" method="post">  
    				<s:textfield name="product.name" placeholder="分享物品名称"/>  
					<s:radio list="#{'体育用品':'体育用品','电子商品':'电子商品','会员账号':'会员账号','学习用品':'学习用品','衣物正装':'衣物正装'}" name="product.type" value="体育用品"/>
    			<s:textfield name="product.deposit" placeholder="输入商品估价" />  
    				<s:textfield name="product.rent1" type="number"  placeholder="按小时收费"/>
    				<s:textfield name="product.rent2" type="number"  placeholder="按天收费"/>
    				<s:textfield name="product.rent3" type="number" placeholder="按月收费"/>
    			<s:textfield name="product.intro" type="text" placeholder="请输入商品规格简介"/>
    			<hr class="hr15" />
    			<s:textfield name="product.extra" type="text" placeholder="请输入商品规格详情"/>
    			<hr class="hr15" />
    			<!--<input name="picture" type="image" placeholder="上传分享物品照片" class="inputimg" />-->
    			<!--<input type="file" name="uploadImage"/>-->
    			<s:file name="uploadImage" placeholder="选择图片" />  
    			<s:submit value="提交" style="width:100%;"/>
				<hr class="hr15">
    			</s:form>
    		
    	</div>
 	</body>
</html>