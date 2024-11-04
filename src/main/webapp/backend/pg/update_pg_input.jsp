<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.pet_groomer.model.*"%>

<% //見com.emp.controller.EmpServlet.java第163行存入req的empVO物件 (此為從資料庫取出的empVO, 也可以是輸入格式有錯誤時的empVO物件)
PetGroomerVO petGroomerVO = (PetGroomerVO) request.getAttribute("petGroomerVO");
%>

<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<title>員工資料修改 - update_pg_input.jsp</title>

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
	width: 450px;
	background-color: white;
	margin-top: 1px;
	margin-bottom: 1px;
  }
  table, th, td {
    border: 0px solid #CCCCFF;
  }
  th, td {
    padding: 1px;
  }
</style>

</head>
<body bgcolor='white'>

<table id="table-1">
	<tr><td>
		 <h3>員工資料修改 - update_pg_input.jsp</h3>
		 <h4><a href="select_page.jsp"><img src="images/w644.jpg" width="180" height="85" border="0">回首頁</a></h4>
	</td></tr>
</table>

<h3>資料修改:</h3>

<%-- 錯誤表列 --%>
<c:if test="${not empty errorMsgs}">
	<font style="color:red">請修正以下錯誤:</font>
	<ul>
		<c:forEach var="message" items="${errorMsgs}">
			<li style="color:red">${message}</li>
		</c:forEach>
	</ul>
</c:if>

<FORM METHOD="post" ACTION="pg.do" name="form1">
<table>
	<tr>
		<td>編號:<font color=red><b>*</b></font></td>
		<td><%=petGroomerVO.getPgId()%></td>
	</tr>
	<tr>
		<td>姓名:</td>
		<td><input type="TEXT" name="pgName" value="<%=petGroomerVO.getPgName()%>" size="45"/></td>
	</tr>
	<tr>
		<td>服務地區:</td>
		<td><input type="TEXT" name="pgArea"   value="<%=petGroomerVO.getPgArea()%>" size="45"/></td>
	</tr>
	<tr>
		<td>每週服務日:</td>
		<td><input type="TEXT" name="schDate"   value="<%=petGroomerVO.getSchDate()%>" size="45"/></td>
	</tr>
	<tr>
		<td>每日服務時段:</td>
		<td><input type="TEXT" name="schTime"  value="<%=petGroomerVO.getSchTime()%>" size="45"/></td>
	</tr>
	<tr>
		<td>營業狀態:</td>
		<td><input type="TEXT" name="pgStatus"  value="<%=petGroomerVO.getPgStatus()%>" size="45"/></td>
	</tr>
	<tr>
		<td>簡介:</td>
		<td><input type="TEXT" name="pgBio"  value="<%=petGroomerVO.getPgBio()%>" size="45"/></td>
	</tr>
	<tr>
		<td>密碼:</td>
		<td><input type="TEXT" name="pgPw"  value="<%=petGroomerVO.getPgPw()%>" size="45"/></td>
	</tr>
	<tr>
		<td>Email:</td>
		<td><input type="TEXT" name="pgEmail"  value="<%=petGroomerVO.getPgEmail()%>" size="45"/></td>
	</tr>
		<tr>
		<td>評價總星數:</td>
		<td><input type="TEXT" name="totalStars"  value="<%=petGroomerVO.getTotalStars()%>" size="45"/></td>
	</tr>
	<tr>
		<td>評價總次數:</td>
		<td><input type="TEXT" name="ratingTimes"  value="<%=petGroomerVO.getRatingTimes()%>" size="45"/></td>
	</tr>
	<tr>
		<td>違規記點次數:</td>
		<td><input type="TEXT" name="reportTimes"  value="<%=petGroomerVO.getReportTimes()%>" size="45"/></td>
	</tr>

	

</table>
<br>
<input type="hidden" name="action" value="update">
<input type="hidden" name="pgId" value="<%=petGroomerVO.getPgId()%>">
<input type="submit" value="送出修改"></FORM>
</body>
 
</html>