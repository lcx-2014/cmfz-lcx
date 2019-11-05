<%@page contentType="text/html;charset=utf-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>当当图书 – 全球最大的中文网上书店</title>
		<link href="/dangdang_lcx/front/css/book.css" rel="stylesheet" type="text/css" />
		<link href="/dangdang_lcx/front/css/second.css" rel="stylesheet" type="text/css" />
		<link href="/dangdang_lcx/front/css/secBook_Show.css" rel="stylesheet" type="text/css" />
		<link href="/dangdang_lcx/front/css/shopping_vehicle.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="/dangdang_lcx/front/js/jquery-1.8.3.min.js"></script>
		<script type="text/javascript" >
			function updateCount(bookId){
                //获取input的值
                var count = $("#"+bookId).val();
                //正则验证正整数
                var r = /^\+?[1-9][0-9]*$/;
                if(r.test(count)){
                    location.href ="/dangdang_lcx/com.baizhi.action/CartAction/updateCart?id="+bookId+"&count="+count;
                }
                else {
                    alert("请输入正确的数量");
                }
			}
		</script>
	</head>
	<body>
		<br />
		<br />
		<div class="my_shopping">
			<img class="pic_shop" src="/dangdang_lcx/front/images/pic_myshopping.gif" />
		</div>
			<c:choose>
		<c:when test="${sessionScope.car.totalPrice==0 || sessionScope.car== null}" >
		<div id="div_no_choice">
			<div class="choice_title"></div>
			<div class="no_select">
				您还没有挑选商品[<a href='/dangdang_lcx/com.baizhi.action/BookAction/random'> 继续挑选商品&gt;&gt;</a>]
			</div>
		</div>
			</c:when>

        <c:otherwise >
		<div id="div_choice" class="choice_merch">
			<h2 id="cart_tips">
				您已选购以下商品
			</h2>
			<div class="choice_bord">
				<table class="tabl_buy" id="tbCartItemsNormal">
					<tr class="tabl_buy_title">
						<td class="buy_td_6">
							<span>&nbsp;</span>
						</td>
						<td>
							<span class="span_w1">商品名</span>
						</td>
						<td class="buy_td_5">
							<span class="span_w2">市场价</span>
						</td>
						<td class="buy_td_4">
							<span class="span_w3">当当价</span>
						</td>
						<td class="buy_td_1">
							<span class="span_w2">数量</span>
						</td>
						<td class="buy_td_2">
							<span>变更数量</span>
						</td>
						<td class="buy_td_1">
							<span>删除</span>
						</td>
					</tr>
					<tr class='objhide' over="no">
						<td colspan="8">
							&nbsp;
						</td>
					</tr>
					
					<!-- 购物列表开始 -->
					<c:forEach var="e" items="${sessionScope.car.car }">
					<tr class='td_no_bord'>
						<td style='display: none'>
							${e.key }
						</td>
						<td class="buy_td_6">
							<span class="objhide">
								<img src="/dangdang_lcx/back/img/${e.value.book.cover }" /> 
							</span>
						</td>
						<td>
							<a href="/dangdang_lcx/com.baizhi.action/SecondBookAction/showDetalisBook?id=${e.value.book.id }">${e.value.book.dname }</a>
						</td>
						<td class="buy_td_5">
							<span class="c_gray">￥${e.value.book.price }</span>
						</td>
						<td class="buy_td_4">
							&nbsp;&nbsp;
							<span>￥${e.value.book.dprice }</span>
						</td>
						<td class="buy_td_1">
							&nbsp;&nbsp;${e.value.count }
						</td>

						<td >
							<input id="${e.key }" class="del_num" type="number" size="1" maxlength="2" />
							<a onclick="updateCount('${e.key}')" href="#" >变更</a>
						</td>
						<td>
							<a href="/dangdang_lcx/com.baizhi.action/CartAction/deleteCart?id=${e.value.book.id  }">删除</a>
						</td>
					</tr>
					</c:forEach>
				</table>

				<div class="choice_balance">
					<div class="select_merch">
						<a href="/dangdang_lcx/com.baizhi.action/BookAction/random"> 继续挑选商品>></a>
					</div>
					<div class="total_balance">
						<div class="save_total">
							您共节省：
							<span class="c_red"> ￥<span id="total_economy">${sessionScope.car.savePrice }</span> </span>
							<span style="font-size: 14px">|</span>
							<span class="t_add">商品金额总计：</span>
							<span class="c_red_b"> ￥<span id='total_account'>${sessionScope.car.totalPrice }</span>
							</span>
						</div>
						<div id="balance" class="balance">
							<a name='checkout' href='/dangdang_lcx/front/order/order_info.jsp' > 
								<img src="/dangdang_lcx/front/images/butt_balance.gif" alt="结算" border="0" title="结算" />
							</a>
						</div>
					</div>
				</div>
			</div>
		</div>
		</c:otherwise>
		</c:choose>
		<!--页尾开始 -->
		<div style="position:absolute;bottom: 10px;width:100%;">
			<%@include file="/front/common/foot.jsp"%>
		</div>
		<!--页尾结束 -->
	</body>
</html>



