<%@page contentType="text/html;charset=utf-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h2>
	编辑推荐
</h2>

<div id=__bianjituijian/danpin>

	<div class=second_c_02>
	<c:forEach var="e" items="${requestScope.list }">
		<div class=second_c_02_b1>
			<div class=second_c_02_b1_1>
				<a href='/dangdang_lcx/com.baizhi.action/SecondBookAction/showDetalisBook?id=${e.id }' target='_blank'>
					<img class="images" height=120 src="/dangdang_lcx/back/img/${e.cover }" width=70 border=0 /> 
				</a>
			</div>
			<div class=second_c_02_b1_2>
				<h3>
					<a href='/dangdang_lcx/com.baizhi.action/SecondBookAction/showDetalisBook?id=${e.id }' target='_blank' title='输赢'>${e.dname }</a>
				</h3>
				<h4>
					作者:${e.author } 著
					<br />
					出版社：${e.press }&nbsp;&nbsp;&nbsp;&nbsp;
					出版时间：${e.pressdate }
				</h4>
				<h5>
					简介:${e.contentAbstract }
				</h5>
				<h6>
					定价：￥${e.price }&nbsp;&nbsp;
					当当价：￥${e.dprice }
					销量：<font color="red">${e.sale }</font>
				</h6>
				<div class=line_xx></div>
			</div>
		</div>
	</c:forEach>
	</div>
	
</div>

