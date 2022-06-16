<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.*,java.util.*" %>
<%
List<Bag> list=(List<Bag>)request.getAttribute("bag");
String feeling = (String)request.getAttribute("feeling");
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>気分に合わせてバッグを選んでくれるアプリ！</h1>
<p>今の気分を選択してください</p>

<form action="/BagselectAPP/Main" method="post">
<select name="feeling" >
 <option value="散歩のついでに">散歩のついでに</option>
 <option value="一日中使える">一日中使える</option>
 <option value="ちょっとしたお出かけに">ちょっとしたお出かけに</option>
</select>
<button type="submit">SELECT!</button>


<% if(list != null && list.size() >0){ %>
<p>いまの気分に合うバックはこちら！</p>
<table border="1">
<tr><th>NAME</th><th>PRICE</th><th>Image</th><tr>
<% for(Bag select :list){ %>
<tr>
<td><%=select.getName() %></td>
<td><%=select.getPrice() %></td>
<td>
<img src="<%=select.getBagImage() %>" width="200">
</td>
</tr>
<%} %>
</table>
<%} %>


</form>
</body>
</html>