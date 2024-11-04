<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.pet_groomer.model.*"%> 
<%-- 此頁練習採用 EL 的寫法取值 --%>

<%
	PetGroomerService pgSvc = new PetGroomerService();
    List<PetGroomerVO> list = pgSvc.getAll();
    pageContext.setAttribute("list",list);
%>


<html>
<head>
<title>所有員工資料 - listAllPg.jsp</title>

<style>
  table#table-1 {
	background-color: #CCCCFF;
    border: 2px solid black;
    text-align: center;
  }
  table#table-1 h4 {
    color: red;
    display: block;
    margin-bottom: 1px;
  }
  h4 {
    color: blue;
    display: inline;
  }
</style>

<style>
  table {
	width: 1300px;
	background-color: white;
	margin-top: 5px;
	margin-bottom: 5px;
  }
  table, th, td {
    border: 1px solid #CCCCFF;
  }
  th, td {
    padding: 5px;
    text-align: center;
  }
</style>

</head>
<body bgcolor='white'>

<h4>此頁練習採用 EL 的寫法取值:</h4>
<table id="table-1">
	<tr><td>
		 <h3>所有美容師資料 - listAllPg.jsp</h3>
		 <h4><a href="select_page.jsp"><img src="images/14491.jpg" width="130" height="60" border="0">回首頁</a></h4>
	</td></tr>
</table>

<table>
	<tr>
		<th>編號</th>
		<th>姓名</th>
		<th>服務地區</th>
		<th>每週服務日</th>
		<th>每日服務時段</th>
		<th>營業狀態</th>
		<th>簡介</th>
		<th>密碼</th>
		<th>電子信箱</th>
		<th>評價總星數</th>
		<th>評價總次數</th>
		<th>違規記點次數</th>
		<th>編輯</th>
		<th>刪除</th>
		
	</tr>
	<%@ include file="page1.file" %> 
	<c:forEach var="petGroomerVO" items="${list}" begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>">
		
		<tr>
			<td>${petGroomerVO.pgId}</td>
			<td>${petGroomerVO.pgName}</td>
			<td>${petGroomerVO.pgArea}</td>
			<td>${petGroomerVO.schDate}</td>
			<td>${petGroomerVO.schTime}</td>
			<td>${petGroomerVO.pgStatus}</td> 
			<td>${petGroomerVO.pgBio}</td>
			<td>${petGroomerVO.pgPw}</td>
			<td>${petGroomerVO.pgEmail}</td>
			<td>${petGroomerVO.totalStars}</td>
			<td>${petGroomerVO.ratingTimes}</td>
			<td>${petGroomerVO.reportTimes}</td>
		
			
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/backend/pg/pg.do" style="margin-bottom: 0px;">
			     <input type="submit" value="修改">
			     <input type="hidden" name="pgId"  value="${petGroomerVO.pgId}">
			     <input type="hidden" name="action"	value="getOne_For_Update"></FORM>
			</td>
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/backend/pg/pg.do" style="margin-bottom: 0px;">
			     <input type="submit" value="刪除">
			     <input type="hidden" name="pgId"  value="${petGroomerVO.pgId}">
			     <input type="hidden" name="action" value="delete"></FORM>
			</td>
		</tr>
	</c:forEach>
</table>
<%@ include file="page2.file" %>

</body>
</html>