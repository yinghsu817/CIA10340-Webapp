<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.pet_groomer.model.*"%>
<%-- 此頁暫練習採用 Script 的寫法取值 --%>

<%
PetGroomerVO petGroomerVO = (PetGroomerVO) request.getAttribute("petGroomerVO"); //PetGroomerServlet.java(Concroller), 存入req的petGroomerVO物件
%>

<html>
<head>
<title>員工資料 - listOnePg.jsp</title>

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
	width: 1250px;
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

<h4>此頁暫練習採用 Script 的寫法取值:</h4>
<table id="table-1">
	<tr><td>
		 <h3>員工資料 - listOnePg.jsp</h3>
		 <h4><a href="select_page.jsp"><img src="images/14630.png" width="150" height="70" border="0">回首頁</a></h4>
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
	</tr>
	<tr>
		<td><%=petGroomerVO.getPgId()%></td>
		<td><%=petGroomerVO.getPgName()%></td>
		<td><%=petGroomerVO.getPgArea()%></td>
		<td><%=petGroomerVO.getSchDate()%></td>
		<td><%=petGroomerVO.getSchTime()%></td>
		<td><%=petGroomerVO.getPgStatus()%></td>
		<td><%=petGroomerVO.getPgBio()%></td>
		<td><%=petGroomerVO.getPgPw()%></td>
		<td><%=petGroomerVO.getPgEmail()%></td>
		<td><%=petGroomerVO.getTotalStars()%></td>
		<td><%=petGroomerVO.getRatingTimes()%></td>
		<td><%=petGroomerVO.getReportTimes()%></td>
	</tr>
</table>

</body>
</html>