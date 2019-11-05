<%@page contentType="text/html;charset=utf-8" pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="book_l_border1" id="__FenLeiLiuLan">
	<div class="book_sort_tushu">
		<h2>
			分类浏览
		</h2>
		
		<!--1级分类开始-->
			<c:forEach var="e" items="${requestScope.listssss }">
			
			<div class="bg_old" onmouseover="this.className = 'bg_white';"
				onmouseout="this.className = 'bg_old';">
				<h3>
					[<a href='/dangdang_lcx/com.baizhi.action/SecondBookAction/secondAction?parantId=${e.name }&levels=${e.levels}'>${e.name }</a>]
				</h3>
				<ul class="ul_left_list">

						<!--2级分类开始-->
						<c:forEach var="d" items="${e.categroys }">
						<li>
							<a href='/dangdang_lcx/com.baizhi.action/SecondBookAction/secondAction?parantId=${d.name }&levels=${d.levels}&parpantIds=${d.parantId}'>${d.name }</a>
						</li>
					</c:forEach>
						<!--2级分类结束-->
				</ul>
				<div class="empty_left">
				</div>
			</div>

		

			<div class="more2">
			</div>
		<!--2级分类结束-->
		
			</c:forEach>

		<div class="bg_old">
			<h3>
				&nbsp;
			</h3>
		</div>
	</div>
</div>
