<%@page contentType="text/html;charset=utf-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h2>
	<span class="more"><a href="#" target="_blank">更多&gt;&gt;</a> </span>热销图书
</h2>
<div class="book_c_04">
	<c:forEach var="e" items="${requestScope.lists }">
	<!--热销图书A开始-->
	<div class="second_d_wai">
		<div class="img">
			<a href="/dangdang_lcx/com.baizhi.action/SecondBookAction/showDetalisBook?id=${e.id }" target='_blank'>
				<img class="images" height=100 width=70 src="/dangdang_lcx/back/img/${e.cover }" border=0 /> 
			</a>
		</div>
		<div class="shuming">
			<a href="/dangdang_lcx/com.baizhi.action/SecondBookAction/showDetalisBook?id=${e.id }" target="_blank">${e.dname }</a><a href="#" target="_blank"></a>
		</div>
		<div class="price">
			定价：￥${e.price }
		</div>
		<div class="price">
			当当价：￥${e.dprice }
		</div>
		<div class="price">
			销量：<font color="red">${e.sale }</font>
		</div>
	</div>
	<div class="book_c_xy_long"></div>
	<!--热销图书A结束-->
</c:forEach>
</div>
<div class="clear"></div>