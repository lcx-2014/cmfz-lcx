<%@page contentType="text/html;charset=utf-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set value="${pageContext.request.contextPath}" var="path" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>生成订单 - 当当网</title>
		<link href="${path}/front/css/login.css" rel="stylesheet" type="text/css" />
		<link href="${path}/front/css/page_bottom.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="${path}/front/js/jquery-1.8.3.min.js"></script>
		<script type="text/javascript">
			function change(addId){

				var addId = $("#address").val();
				location.href="${path}/com.baizhi.action/AddressAction/getByAddId?addId="+addId;
            }

            $(function(){
                $("#receiveName").blur(function () {
                    var name = $(this).val();
                    if (name == "") {
                        $("#nameMsg").html("<b><font color='red'>收件人不能为空~~!</font><b/>");
                    } else {
                        $("#nameMsg").html("<b><font color='green'>验证通过~~!</font><b/>");
                        ok1 = true;
                    }
                });

                $("#fullAddress").blur(function () {
                        var addr = $(this).val();
                        if (addr == "") {
                            $("#addrMsg").html("<b><font color='red'>地址不能为空~~!</font><b/>");
                        } else {
                            $("#addrMsg").html("<b><font color='green'>验证通过~~!</font><b/>");
                            ok2 = true;
                        }
                });
                $("#postalCode").blur(function () {

                        var zip = $(this).val();
                        if (zip == "") {
                            $("#zipMsg").html("<b><font color='red'>邮编不能为空~~!</font><b/>");
                        } else {
                            $("#zipMsg").html("<b><font color='green'>验证通过~~!</font><b/>");
                            ok3 = true;
                        }
                });
                $("#phone").blur(function () {
                        var phone = $(this).val();
                        if (phone == "") {
                            $("#phoneMsg").html("<b><font color='red'>手机号不能为空~~!</font><b/>");
                        } else {
                            $("#phoneMsg").html("<b><font color='green'>验证通过~~!</font><b/>");
                            ok4 = true;
                        }
                });
            });


		</script>
	</head>
	<body>
		<%@include file="/front/common/head1.jsp"%>
		<div class="login_step">
			生成订单骤: 1.确认订单 >
			<span class="red_bold"> 2.填写送货地址</span> > 3.订单成功
		</div>
	<form name="ctl00" method="post" action="/dangdang_lcx/com.baizhi.action/OrderAction/success" id="f">
		<div class="fill_message">
			<p>
				选择地址：

				<select name="newaddress" id="address" onchange="change(this.value)"  >
					<option value="xindizhi" >
						填写新地址
					</option>
					<c:forEach items="${requestScope.list}" var="a">
						<option value="${a.id }" <c:if test="${a.id eq address.id}">selected</c:if>   >${a.local }</option>
					</c:forEach>
				</select>
			</p>
				<input type="hidden" name="address.id" value="${address.id}" id="addressId" />
				<table class="tab_login">
					<tr>
						<td valign="top" class="w1">
							收件人姓名：
						</td>
						<td>
							<input type="text" value="${requestScope.address.name}" class="text_input" name="address.name" id="receiveName" />
							<div class="text_left" id="nameValidMsg">
								<p>
									请填写有效的收件人姓名
								</p>
								<span id="nameMsg"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							收件人详细地址：
						</td>
						<td>
							<input type="text" value="${requestScope.address.local}" name="address.local" class="text_input" id="fullAddress" />
							<div class="text_left" id="addressValidMsg">
								<p>
									请填写有效的收件人的详细地址
								</p>
								<span id="addrMsg"></span>

							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							邮政编码
						</td>
						<td>
							<input type="text" value="${requestScope.address.zipCode}" class="text_input" name="address.zipCode" id="postalCode" />
							<div class="text_left" id="codeValidMsg">
								<p>
									请填写有效的收件人的邮政编码
								</p>
								<span id="zipMsg"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							电话
						</td>
						<td>
							<input type="text" value="${requestScope.address.phone}" class="text_input" name="address.phone" id="phone" />
							<div class="text_left" id="phoneValidMsg">
								<p>
									请填写有效的收件人的电话
								</p>
								<span id="phoneMsg"></span>
							</div>
						</td>
					</tr>
				</table>

				<div class="login_in">
					<a href="${path}/front/order/order_info.jsp">
						<input id="btnClientRegister1" class="button_1" name="submit" type="button" value="取消" />
					</a>			
				<input id="btnClientRegister" class="button_1" name="submit" type="submit" value="下一步" />
				</div>
			</form>
		</div>
		<%@include file="/front/common/foot.jsp"%>
	</body>
</html>