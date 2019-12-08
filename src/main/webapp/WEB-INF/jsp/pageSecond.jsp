<%@page contentType="text/html;charset=UTF-8"%>
<%@page import="java.util.*"%>
<%
    String name = (String)pageContext.getAttribute("name",PageContext.REQUEST_SCOPE);
    Date date = (Date)pageContext.getAttribute("date",PageContext.REQUEST_SCOPE);
%>
<h1 style="color:red;">姓名：<%=name%></h1>
<h1 style="color:blue;">日期：<%=date%></h1>

