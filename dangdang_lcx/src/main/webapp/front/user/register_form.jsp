<%@page contentType="text/html;charset=utf-8" isELIgnored="false" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="/struts-tags" prefix="s"%>
<c:set var="path" value="${pageContext.request.contextPath}" scope="page" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>用户注册 - 当当网</title>
		<link href="/dangdang_lcx/front/css/login.css" rel="stylesheet" type="text/css" />
		<link href="/front/css/page_bottom.css" rel="stylesheet" type="text/css" />

		<script type="text/javascript" src="/dangdang_lcx/front/js/jquery-1.8.3.min.js"></script>
		<script type="text/javascript" >

            //点击更新验证码
            function changeImage(){
                $("#imgVcode").attr("src","/dangdang_lcx/com.baizhi.action.AdminAction/getCodes?aaa"+new Date().getTime());
            }

            $(function(){
            //邮箱验证
            $("#txtEmail").blur(function(){
                //$("#name").val().length
                var Email = $(this).val();
                if(Email== ""){
                    $("#EmailMsg").html("<b><font color='red'>邮箱不能为空</font><b/>");
                }else{
                    var regEmail = /^[A-Za-z\d]+([-_.][A-Za-z\d]+)*@([A-Za-z\d]+[-.])+[A-Za-z\d]{2,4}$/;
                    if(regEmail.test(Email)){
                        $("#EmailMsg").html("<b><font color='green'>邮箱验证通过</font><b/>");
                        ok1=true;
                    }else{
                        $("#EmailMsg").html("<b><font color='red'>邮箱格式不正确</font><b/>");
                    }
                }
            });

            //昵称验证
            $("#txtNickName").blur(function(){
                var NickName = $(this).val();
                if(NickName== ""){
                    $("#NickNameMsg").html("<b><font color='red'>昵称不能为空</font><b/>");
                }else{
                    if(NickName.length<3 || NickName.length>20){
                        $("#NickNameMsg").html("<b><font color='red'>昵称格式不正确</font><b/>");
                    }else{
                        $("#NickNameMsg").html("<b><font color='green'>昵称验证通过</font><b/>");
                        ok2=true;
                    }
                }
            });

            //密码验证
            $("#txtPassword").blur(function(){
                var Password = $(this).val();
                if(Password== ""){
                    $("#PasswordMsg").html("<b><font color='red'>密码不能为空</font><b/>");
                }else{
                    if(Password.length<6 || Password.length>20){
                        $("#PasswordMsg").html("<b><font color='red'>密码格式不正确</font><b/>");
                    }else{
                        $("#PasswordMsg").html("<b><font color='green'>密码验证通过</font><b/>");
                        ok3=true;
                    }
                }
            });

            //确认密码验证
            $("#txtRepeatPass").blur(function(){
                var passwprd = $("#txtPassword").val();
                //alert(passwprd);
                var RepeatPass = $(this).val();
                if(RepeatPass== ""){
                    $("#RepeatPassMsg").html("<b><font color='red'>不能为空</font><b/>");
                }else{
                    if(RepeatPass == passwprd){
                        $("#RepeatPassMsg").html("<b><font color='green'>密码验证通过</font><b/>");
                        ok4=true;
                    }else{
                        $("#RepeatPassMsg").html("<b><font color='red'>密码不一致</font><b/>");
                    }
                }
            });

            //验证码验证
            $("#txtVerifyCode").blur(function(){
                var Password = $(this).val();
                if(Password== ""){
                    $("#vcodeValidMsg").html("<b><font color='red'>验证码不能为空</font><b/>");
                }else{
                    if(Password.length<4 || Password.length>4){
                        $("#vcodeValidMsg").html("<b><font color='red'>验证码格式不正确</font><b/>");
                    }else{
                        $("#vcodeValidMsg").html("<b><font color='green'>验证通过</font><b/>");
                        ok5=true;
                    }
                }
            });

            //提交按钮验证
            $("form").submit(function(){
                //首先执行需要把blur方法执行一遍，这样显示的错误信息 然后记录错误信息的长度 只要长度大于0就阻止提交
                $("input").trigger("blur");
                //提交按钮,所有验证通过方可提交
                if(ok1 && ok2 && ok3 && ok4 && ok5){
                    $('form').submit();
                }else{
                    return false;
                }
            });

            });

		</script>

	</head>
	<body>
		<%@include file="/front/common/head1.jsp"%>
		<div class="login_step">
			注册步骤:
			<span class="red_bold">1.填写信息</span> > 2.验证邮箱 > 3.注册成功
		</div>
		<div class="fill_message">
			<form name="ctl00" method="post" action="/dangdang_lcx/com.baizhi.action/UserAction/registerUser" id="f">

				<h2>
					以下均为必填项<span style="color:red;font-size: 15px;margin-left: 45px;">${sessionScope.message}</span>
				</h2>
				<table class="tab_login" >
					<tr>
						<td valign="top" class="w1">
							请填写您的Email地址：
						</td>
						<td>
							<input name="user.email" type="text" id="txtEmail" class="text_input"/>
							<div class="text_left" id="emailValidMsg">
								<p>
									请填写有效的Email地址，在下一步中您将用此邮箱接收验证邮件。
								</p>
									<span id="email.info" style="color:red"></span>
								    <span id="EmailMsg"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							设置您在当当网的昵称：
						</td>
						<td>
							<input name="user.nickname" type="text" id="txtNickName" class="text_input" />
							<div class="text_left" id="nickNameValidMsg">
								<p>
									您的昵称可以由小写英文字母、中文、数字组成，
								</p>
								<p>
									长度4－20个字符，一个汉字为两个字符。
								</p>
								<span id="name.info" style="color:red"></span>
								<span id="NickNameMsg"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							设置密码：
						</td>
						<td>
							<input name="user.password" type="password" id="txtPassword" class="text_input" />
							<div class="text_left" id="passwordValidMsg">
								<p>
									您的密码可以由大小写英文字母、数字组成，长度6－20位。
								</p>
								<span id="password.info" style="color:red"></span>
								<span id="PasswordMsg"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							再次输入您设置的密码：
						</td>
						<td>
							<input name="password1" type="password" id="txtRepeatPass" class="text_input"/>
							<div class="text_left" id="repeatPassValidMsg">
							    <span id="password1.info" style="color:red"></span>
								<span id="RepeatPassMsg"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							验证码：
						</td>
						<td>
							<img class="yzm_img" id='imgVcode' src="/dangdang_lcx/com.baizhi.action.AdminAction/getCodes" />
							<input name="code" type="text" id="txtVerifyCode" class="yzm_input"/>
							<div class="text_left t1">
								<p class="t1">
									<span id="vcodeValidMsg">请输入图片中的四个字母。</span>
									<span id="number.info" style="color:red"></span>
									
									<a href="#" onclick="changeImage()" id="changeImg" >看不清楚？换个图片</a>
									<font color="red">
										<strong>
											<s:property value="error"/>
										</strong>
									</font>
								</p>
							</div>
						</td>
					</tr>
				</table>

				<div class="login_in">

					<input id="btnClientRegister" class="button_1" name="submit"  type="submit" value="注 册"/>
				</div>
			</form>
		</div>
		<%@include file="/front/common/foot.jsp"%>
	</body>
</html>

