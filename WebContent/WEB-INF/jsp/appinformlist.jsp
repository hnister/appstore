<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="statics/js/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		$('p>a').click(function(){
			var pageNow = $(this).attr('data');
			$('#pageNow').val(pageNow);
			$('form').submit();
		});
	});
</script>
</head>
<body>
	<form action="selectAppInformByPage.do" method="get">
		<label>APP名</label>
		<input type="text" name="softwareName" value="${param.softwareName}">
		<label>类别</label>
		<select name="id">
			<option value="-1">--请选择--</option>
			<option value="1"
				<c:if test="${param.id == 1}">
					selected="true"
				</c:if>
			>国内</option>
			<option value="2"
				<c:if test="${param.id == 2}">
					selected="true"
				</c:if>
			>国际</option>
			<option value="3"
				<c:if test="${param.id == 3}">
					selected="true"
				</c:if>
			>军事</option>
		</select>
		<input type="hidden" value="1" name="pageNow" id="pageNow">
		<input type="submit" value="查询">
	</form>
	<br>
	<table border="1" style="width: 80%">
		<tr>
			<th>序号</th>
			<th>APP名</th>
		</tr>
		<c:forEach items="${pageInfo.list}" var="appInform">
			<tr>
				<td>${appInform.id}</td>
				<td>${appInform.softwareName}</td>
			</tr>
		</c:forEach>
	</table>
	<p>
		<a data="1" href="javascript:void(0);">首页</a>
		<a data="${pageInfo.pageNow-1 == 0 ? 1 : pageInfo.pageNow-1 }" href="javascript:void(0);">上一页</a>
		<span>${pageInfo.pageNow}/${pageInfo.totalePage}</span>
		<a data="${pageInfo.pageNow+1 > pageInfo.totalePage ? pageInfo.totalePage : pageInfo.pageNow+1}" href="javascript:void(0);">下一页</a>
		<a data="${pageInfo.totalePage}" href="javascript:void(0);">尾页</a>
	</p>
</body>
</html>