<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.pet_groomer.model.*"%>

<% //見com.emp.controller.EmpServlet.java第238行存入req的empVO物件 (此為輸入格式有錯誤時的empVO物件)
PetGroomerVO petGroomerVO = (PetGroomerVO) request.getAttribute("petGroomerVO");
%>

<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<title>美容師資料新增 - addPg.jsp</title>

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
		 <h3>美容師資料新增 - addPg.jsp</h3></td>
		 <td><h4><a href="select_page.jsp"><img src="images/w644.jpg" width="180" height="100" border="0"><br>回首頁</a></h4>
	</td></tr>
</table>

<h3>資料新增:</h3>

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
		<td>美容師姓名:</td>
		<td><input type="TEXT" name="pgName" value="<%= (petGroomerVO==null)? "吳永志" : petGroomerVO.getPgName()%>" size="45"/></td>
	</tr>
	<tr>
		<td>服務區域:</td>
		<td><input type="TEXT" name="pgArea"   value="<%= (petGroomerVO==null)? "北部" : petGroomerVO.getPgArea()%>" size="45"/></td>
	</tr>
	<tr>
		<td>每周服務日:</td>
		<td><input type="TEXT" name="schDate"  value="<%= (petGroomerVO==null)? "1111100" : petGroomerVO.getSchDate()%>" size="45"/></td>
	</tr>
	<tr>
		<td>每日服務時段:</td>
		<td><input type="TEXT" name="schTime"   value="<%= (petGroomerVO==null)? "110" : petGroomerVO.getSchTime()%>" size="45"/></td>
	</tr>
	<tr>
		<td>營業狀態:</td>
		<td><input type="TEXT" name="pgStatus"   value="<%= (petGroomerVO==null)? "1" : petGroomerVO.getPgStatus()%>" size="45"/></td>
	</tr>
	<tr>
		<td>簡介:</td>
		<td><input type="TEXT" name="pgBio"   value="<%= (petGroomerVO==null)? "紙上得來終覺淺，絕知此事要躬行" : petGroomerVO.getPgBio()%>" size="45"/></td>
	</tr>
	<tr>
		<td>密碼:</td>
		<td><input type="TEXT" name="pgPw"   value="<%= (petGroomerVO==null)? "testtset" : petGroomerVO.getPgPw()%>" size="10"/></td>
	</tr>
	<tr>
		<td>E-mail:</td>
		<td><input type="TEXT" name="pgEmail"   value="<%= (petGroomerVO==null)? "no1@gmail.com" : petGroomerVO.getPgEmail()%>" size="45"/></td>
	</tr>
	


</table>
<br>
<input type="hidden" name="action" value="insert">
<input type="submit" value="送出新增"></FORM>

</body>




</html>