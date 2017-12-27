<!DOCTYPE html>
<%@ page language="java" contentType="text/html; 
charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
    <head>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>注册</title>
        <link rel="stylesheet" href="css/register.css" />
<script src="http://apps.bdimg.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="http://www.w3cschool.cc/try/demo_source/static/js/jquery.validate.js"></script>
	<script type="text/javascript">
	$(function () {
		$("#form1").validate({
	    	rules: {
	    		txtIdCard: "isIdCard"
	    	}
	    });
	});
	// 身份证号验证 
    function isIdCard(cardid) {
    	//身份证正则表达式(18位) 
    	var isIdCard2 = /^[1-9]\d{5}(19\d{2}|[2-9]\d{3})((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])(\d{4}|\d{3}X)$/i;
    	var stard = "10X98765432"; //最后一位身份证的号码
    	var first = [7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2]; //1-17系数
    	var sum = 0;
    	if (!isIdCard2.test(cardid)) {
   			return false;
    	}
    	var year = cardid.substr(6, 4);
    	var month = cardid.substr(10, 2);
    	var day = cardid.substr(12, 2);
    	var birthday = cardid.substr(6, 8);
    	if (birthday != dateToString(new Date(year+'/'+month+'/'+day))){//校验日期是否合法
    		return false;
    	}
    	for (var i = 0; i < cardid.length - 1; i++) {
    		sum += cardid[i] * first[i];
    	}
    	var result = sum % 11;
    	var last = stard[result]; //计算出来的最后一位身份证号码
    	if (cardid[cardid.length - 1].toUpperCase() == last) {
    		return true;
    	} else {
    		return false;
    	}
    }
    
    //日期转字符串 返回日期格式20080808
    function dateToString(date) {
    	if (date instanceof Date) {
    		var year = date.getFullYear();
    		var month = date.getMonth() + 1;
    		month = month < 10 ? '0' + month : month;
    		var day = date.getDate();
    		day = day < 10 ? '0' + day : day;
    		return year + month + day;
    	}
    	return '';
    }
    
    // jquery validate身份证号验证
    jQuery.validator.addMethod("isIdCard",function (value, element) {
    	return this.optional(element) || (isIdCard(value));
    },
    "身份证号非法！");
	</script>
    </head>
    <body>
    	<div class="register">
    		<div class="message">欢迎注册</div>
    			<div id="darkbannerwrap"></div>
    			<form action="register">
    			<input name="user.nickname" type="text" class="login_input"placeholder="请输入昵称:">
    				<hr class="hr15" />
    				<input name="user.password" type="password" class="login_input" placeholder="请输入密码" />
    				<hr class="hr15" />
    				<input  type="password" class="login_input" placeholder="请再次输入密码"/>
    				<hr class="hr15" />
    				<input  name="user.name" type="text" placeholder="请输入真实姓名:">
    				<hr class="hr15" />
    					<span class="">性别：</span>
    						<input type="radio" name="user.gender" value="男"/>男
    						<input type="radio" name="user.gender" value="女"/>女
    						<hr class="hr15" />
    				<input type="text" id="txtIdCard" name="txtIdCard" placeholder="请输入身份证号码"/>
    				<hr class="hr15" />
    				<input name="user.phone"  type="text"class="login_input" placeholder="请输入电话号码"/>
    				<hr class="hr15" />
    				<input name="user.schoolCode" type="text"class="login_input" placeholder="请输入校园卡号"/>
    				<hr class="hr15" />
   				<input name="user.email" type="email" class="login_input" placeholder="请输入邮箱"/> 
   				<hr class="hr15" />
   				<input name="user.address" type="text" class="login_input" placeholder="详细住址"/>
   				<hr class="hr15" />
    				<input type="submit" value="注册" class="login_btn" />
    			</form>
    		</div>
    	</div>
    		
    	</form>
 	</body>
</html>