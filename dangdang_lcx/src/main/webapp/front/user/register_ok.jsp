<%@page contentType="text/html;charset=utf-8" isELIgnored="false" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}" scope="page" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>用户注册 - 当当网</title>
		<link href="${path}/front/css/login.css" rel="stylesheet" type="text/css" />
		<link href="${path}/front/css/page_bottom.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="${path}/front/js/jquery-1.8.3.min.js" ></script>
		<script type="text/javascript">

            function delayURL() {
                var delay = document.getElementById("time").innerHTML;
                var t = setTimeout("delayURL()", 1000);
                if (delay > 0) {
                    delay--;
                    document.getElementById("time").innerHTML = delay;
                } else {
                    clearTimeout(t);
                    window.location.href = "${path}/com.baizhi.action/BookAction/random";
                }
            }

		</script>

	</head>
	<body onload="delayURL()">
		<%@include file="/front/common/head1.jsp"%>
		<div class="login_step">
			注册步骤: 1.填写信息 > 2.验证邮箱 >
			<span class="red_bold">3.注册成功</span>
		</div>
		<div class="login_success">
			<div class="login_bj">
				<div class="succ">
					<img src="/dangdang_lcx/front/images/login_success.jpg" />
				</div>
				<h5>
					${sessionScope.user.nickname}，欢迎加入当当网
				</h5>
				<h6>
					请牢记您的登录邮件地址：${sessionScope.user.email}
				</h6>
				<h6>
					<font color="red">页面将在<span id="time" >3</span>秒后自动跳转回主页</font> <a href="${path}/main/mainBook" title="点击访问">跳过</a>
				</h6>
					<ul>
					<li class="nobj">
						您现在可以：
					</li>
					<li>
						进入“
						<a href="#">我的当当</a>”查看并管理您的个人信息
					</li>
					<li>
						<a href="${path}/com.baizhi.action/BookAction/random">浏览并选购商品</a>
					</li>
				</ul>

			</div>
		</div>

		<%@include file="/front/common/foot.jsp"%>
	</body>
</html>
