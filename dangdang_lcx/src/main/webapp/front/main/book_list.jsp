<%@page contentType="text/html;charset=utf-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>当当图书 – 全球最大的中文网上书店</title>
		<link href="/dangdang_lcx/front/css/book.css" rel="stylesheet" type="text/css" />
		<link href="/dangdang_lcx/front/css/second.css" rel="stylesheet" type="text/css" />
		<link href="/dangdang_lcx/front/css/secBook_Show.css" rel="stylesheet" type="text/css" />
		<link href="/dangdang_lcx/front/css/list.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="/dangdang_lcx/main/front/js/jquery-1.8.3.min.js"></script>
	</head>
	<body>
		&nbsp;

		<!-- 头部开始 -->
		<%@include file="/front/common/head.jsp"%>
		<!-- 头部结束 -->

		<div style="width: 962px; margin: auto;">
			<a href="#"><img src="/dangdang_lcx/front/images/default/book_banner_081203.jpg" border="0" /> </a>
		</div>
		
		<div class='your_position'>
			您现在的位置:&nbsp;
			<a href='/dangdang_lcx/com.baizhi.action/BookAction/random'>当当图书</a> &gt;&gt;
			<c:forEach var="e" items="${requestScope.list }"  end="0">
			<c:if test="${sessionScope.levels==1 }">
			<font style='color: #cc3300'><strong>${e.parantId }</strong> </font>
			</c:if>
			<c:if test="${sessionScope.levels==2 }">
			<font style='color: #cc3300'><strong>${e.parantId }<font style="color:black">&gt;&gt;</font ><font style="color:green">${e.name }</font></strong> </font>
			</c:if>
		</c:forEach>
		</div>
		<div class="book">

			<!--左栏开始-->
			<div id="left" class="book_left">
				<div id="__fenleiliulan">
					<div class=second_l_border2>
						<h2>
							分类浏览
						</h2>
						<ul>
							<li>
								<div>
									<div class=second_fenlei>
									<c:forEach var="e" items="${requestScope.list }"  end="0">
									
											&middot;<a href="/dangdang_lcx/com.baizhi.action/SecondBookAction/secondAction?parantId=${e.parantId }&levels=1"><font color="red" >${e.parantId}&nbsp;</font></a>
										</c:forEach>
									</div>
								</div>
							</li>
							<div class="clear"></div>
						
							<!--2级分类开始-->
							
		
						<c:if test="${sessionScope.levels==1 }">
							<c:forEach var="s" items="${requestScope.listss }">
							<li>
							
								<div>
									<div class=second_fenlei>
										&middot;
									</div>
									<div class=second_fenlei>
									
										<a href="/dangdang_lcx/com.baizhi.action/SecondBookAction/secondAction?parantId=${s.name }&levels=${s.levels}&parpantIds=${s.parantId}">&nbsp;${s.name }</a>
									
									</div>
									
								</div>
							</li>
							
						    <div class="clear"></div>
							</c:forEach>
							</c:if>
							<c:if test="${sessionScope.levels==2 }">
							<c:forEach var="t" items="${requestScope.lis }">
							<li>
							
								<div>
									<div class=second_fenlei>
										&middot;
									</div>
									<div class=second_fenlei>
									
										
									
										<a href="/dangdang_lcx/com.baizhi.action/SecondBookAction/secondAction?parantId=${t.name }&levels=${t.levels}&parpantIds=${t.parantId}"><font <c:if test="${t.name eq parantId }">style="color:green"</c:if>>${t.name }</font>&nbsp;</a>
									
									</div>
									
								</div>
							</li>
							
						    <div class="clear"></div>
							</c:forEach>
							</c:if>
							<!--2级分类结束-->
							
							<li>
								<div></div>
							</li>
						</ul>
					</div>
				</div>
			</div>

			<!--左栏结束-->

			<!--中栏开始-->
			<div class="book_center">

				<!--图书列表开始-->
				<div id="divRight" class="list_right">

					<div id="book_list" class="list_r_title">
						<div class="list_r_title_text">
							排序方式
						</div>
						<select onchange='' name='select_order' size='1'
							class='list_r_title_ml'>
							<option value="">
								按上架时间 降序
							</option>
						</select>
						<div id="divTopPageNavi" class="list_r_title_text3">

							<!--分页导航开始-->
							<c:if test="${sessionScope.levels==1 }">
							<div class='list_r_title_text3a'>
								<a <c:if test="${requestScope.pb.page-1<1 }">onclick="return false"</c:if> name=link_page_next href="/dangdang_lcx/com.baizhi.action/SecondBookAction/secondAction?parantId=${sessionScope.parantid }&levels=${sessionScope.levels}&pn=${1}">
									<img src='/dangdang_lcx/front/images/page_up.gif' /> 
								</a>
							</div>
	
							<div class='list_r_title_text3a'>
								<a <c:if test="${requestScope.pb.page-1<1 }">onclick="return false"</c:if> name=link_page_next href="/dangdang_lcx/com.baizhi.action/SecondBookAction/secondAction?parantId=${sessionScope.parantid }&levels=${sessionScope.levels}&pn=${requestScope.pb.page-1}">
									<img src='/dangdang_lcx/front/images/page_up.gif' /> 
								</a>
							</div>
				
							<div class='list_r_title_text3b'>
								第${requestScope.pb.page }页/共${pb.maxpage }页
							</div>
							<div class='list_r_title_text3a'>
							
								<a <c:if test="${requestScope.pb.page+1 > requestScope.pb.maxpage }">onclick="return false"</c:if> name=link_page_next href="/dangdang_lcx/com.baizhi.action/SecondBookAction/secondAction?parantId=${sessionScope.parantid }&levels=${sessionScope.levels}&pn=${requestScope.pb.page+1}">
									
									<img src='/dangdang_lcx/front/images/page_down.gif' /> 
								</a>
							</div>
			
							<div class='list_r_title_text3a'>
								<a <c:if test="${requestScope.pb.page+1 > requestScope.pb.maxpage }">onclick="return false"</c:if> name=link_page_next href="/dangdang_lcx/com.baizhi.action/SecondBookAction/secondAction?parantId=${sessionScope.parantid }&levels=${sessionScope.levels}&pn=${pb.maxpage }">
									
									<img src='/dangdang_lcx/front/images/page_down.gif' /> 
								</a>
							</div>
								</c:if>
							<!--分页导航结束-->
								<!--分页导航开始-->
							<c:if test="${sessionScope.levels==2 }">
							<div class='list_r_title_text3a'>
								<a <c:if test="${requestScope.pb.page-1<1 }">onclick="return false"</c:if> name=link_page_next href="/dangdang_lcx/com.baizhi.action/SecondBookAction/secondAction?parantId=${sessionScope.parantid }&levels=${sessionScope.levels}&pn=${1}&parpantIds=${sessionScope.parantids}">
									<img src='/dangdang_lcx/front/images/page_up.gif' /> 
								</a>
							</div>
	
							<div class='list_r_title_text3a'>
								<a <c:if test="${requestScope.pb.page-1<1 }">onclick="return false"</c:if> name=link_page_next href="/dangdang_lcx/com.baizhi.action/SecondBookAction/secondAction?parantId=${sessionScope.parantid }&levels=${sessionScope.levels}&pn=${requestScope.pb.page-1}&parpantIds=${sessionScope.parantids}">
									<img src='/dangdang_lcx/front/images/page_up.gif' /> 
								</a>
							</div>
				
							<div class='list_r_title_text3b'>
								第${requestScope.pb.page }页/共${pb.maxpage-1 }页
							</div>
							<div class='list_r_title_text3a'>
							
								<a <c:if test="${requestScope.pb.page+1 > requestScope.pb.maxpage }">onclick="return false"</c:if> name=link_page_next href="/dangdang_lcx/com.baizhi.action/SecondBookAction/secondAction?parantId=${sessionScope.parantid }&levels=${sessionScope.levels}&pn=${requestScope.pb.page+1}&parpantIds=${sessionScope.parantids}">
									
									<img src='/dangdang_lcx/front/images/page_down.gif' /> 
								</a>
							</div>
			
							<div class='list_r_title_text3a'>
								<a <c:if test="${requestScope.pb.page > requestScope.pb.maxpage }">onclick="return false"</c:if> name=link_page_next href="/dangdang_lcx/com.baizhi.action/SecondBookAction/secondAction?parantId=${sessionScope.parantid }&levels=${sessionScope.levels}&pn=${pb.maxpage-1 }&parpantIds=${sessionScope.parantids}">
									
									<img src='/dangdang_lcx/front/images/page_down.gif' /> 
								</a>
							</div>
								</c:if>
							<!--分页导航结束-->
						</div>
					</div>
					
					<!--商品条目开始-->
						<c:forEach var="d" items="${requestScope.list }">
						<c:forEach var="f" items="${d.books }">
						<div class="list_r_line"></div>
						<div class="clear"></div>
							<div class="list_r_list">
								<span class="list_r_list_book">
									<a name="link_prd_img" href='/dangdang_lcx/com.baizhi.action/SecondBookAction/showDetalisBook?id=${f.id }'>
										<img width=70 height=100 src="/dangdang_lcx/back/img/${f.cover }" /> 
									</a>
								</span>
								<h2>
									<a name="link_prd_name" href='/dangdang_lcx/com.baizhi.action/SecondBookAction/showDetalisBook?id=${f.id }'>${f.dname }</a>
								</h2>
								<h3>
									顾客评分：100
								</h3>
								<h4 class="list_r_list_h4">
									作 者:
									<a href='/dangdang_lcx/com.baizhi.action/SecondBookAction/showDetalisBook?id=${f.id }' name='book.author'>${f.author }</a>
								</h4>
								<h4>
									出版社：
									<a href='/dangdang_lcx/com.baizhi.action/SecondBookAction/showDetalisBook?id=${f.id }' name='出版社'>${f.press }</a>
								</h4>
								<h4>
									出版时间：${f.pressdate }
								</h4>
								<h5>
									${f.contentAbstract }
								</h5>
								<div class="clear"></div>
								<h6>
									<span class="del">￥79</span>
									<span class="red">￥60</span>
									节省：￥${f.price-f.dprice }
								</h6>
								<span class="list_r_list_button"> 
								<a href="/dangdang_lcx/com.baizhi.action/CartAction/addCart?id=${f.id }"> 
									<img src='/dangdang_lcx/front/images/buttom_goumai.gif' /> 
								</a>
								<span id="cartinfo"></span>
							</div>
						<div class="clear"></div>
							</c:forEach>
						</c:forEach>
						
					
						<!--商品条目结束-->

					<div class="clear"></div>
					<div id="divBottomPageNavi" class="fanye_bottom">
					</div>

				</div>
				<!--图书列表结束-->

			</div>
			<!--中栏结束-->
			<div class="clear"></div>
		</div>

		<!--页尾开始 -->
		<%@include file="/front/common/foot.jsp"%>
		<!--页尾结束 -->
	</body>
</html>
