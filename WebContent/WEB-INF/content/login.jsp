<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://cdn.static.runoob.com/libs/jquery/1.10.2/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆页面</title>
<s:head/><!--  暂不清楚 作用-->
<script type="text/javascript">
	$(function(){
		$("#refresh").click(function(){
			$("#vercodeImg").attr("src","vercode?"+Math.random());
		});
	});
</script>

</head>
<body>
<%@include file="header.jsp" %>
<table width="960" align="center" background="image/bodybg.jpg">
	<tr>
		<td>请输入用户名和密码登陆 <br/>
			<s:if test="actionMessages.size()>0">
				<div class="error">
					<s:actionmessage/>
				</div>
			</s:if>
			<s:actionerror cssClass="error"/>
			<div align="center">
			<s:form action="processLogin">
				<s:textfield name="manager.name" label="用户名 "></s:textfield>
				<s:textfield name="manager.pass" label="密码 "></s:textfield>
				<s:textfield name="vercode" label="输入验证码 "></s:textfield>
				<tr>
					<td colspan="2" align="center">
						<img alt="验证码" src="vercode" id="vercodeImg">
						<a href="javascript:void(0)" id="refresh">刷 新</a>
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<s:submit value="登录" theme="simple"></s:submit>
						<s:reset value="重置" theme="simple"></s:reset>
					</td>
				</tr>
			</s:form>
			</div>
		</td>
	</tr>
</table>
<%@include file="footer.jsp" %>
</body>
</html>