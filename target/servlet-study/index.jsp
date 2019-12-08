<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>

<!DOCTYPE HTML>
<html>
<head>
    <title>HttpSessionListener监听器监听HttpSession对象的创建</title>
</head>

<body>
一访问JSP页面，HttpSession就创建了，创建好的Session的Id是：${pageContext.session.id}
</body>
</html>
<jsp:forward  page="WEB-INF/jsp/upload.jsp" />


<%--5--%>
<%--<%@page contentType="text/html;charset=UTF-8"%>
<%@page import="java.util.*"%>
<jsp:forward  page="WEB-INF/jsp/calculator.jsp" />--%>


<%--4--%>
<%--<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>--%>
<%--&lt;%&ndash;--%>
<%--在jsp中使用jsp:useBean标签来实例化一个Java类的对象--%>
<%--<jsp:useBean id="person" class="gacl.javabean.study.Person" scope="page"/>--%>
    <%--┝<jsp:useBean>：表示在JSP中要使用JavaBean。--%>
    <%--┝id:表示生成的实例化对象，凡是在标签中看见了id，则肯定表示一个实例对象。--%>
    <%--┝class：此对象对应的包.类名称--%>
    <%--┝scope：此javaBean的保存范围，四种范围：page、request、session、application--%>
<%--&ndash;%&gt;--%>
<%--<jsp:useBean id="person" class="com.servlet.study.Person" scope="page"/>--%>

<%--&lt;%&ndash;--%>
<%--使用jsp:setProperty标签设置person对象的属性值--%>
<%--jsp:setProperty在设置对象的属性值时会自动把字符串转换成8种基本数据类型--%>
<%--但是jsp:setProperty对于复合数据类型无法自动转换--%>
<%--&ndash;%&gt;--%>
<%--<jsp:setProperty property="name" name="person" value="白虎神皇"/>--%>
<%--<jsp:setProperty property="sex" name="person" value="男"/>--%>
<%--<jsp:setProperty property="age" name="person" value="24"/>--%>
<%--<jsp:setProperty property="married" name="person" value="false"/>--%>
<%--&lt;%&ndash;--%>
<%--birthday属性是一个Date类型，这个属于复合数据类型，因此无法将字符串自动转换成Date ，用下面这种写法是会报错的--%>
<%--<jsp:setProperty property="birthday" name="person" value="1988-05-07"/>--%>
<%--&ndash;%&gt;--%>
<%--<jsp:setProperty property="birthday" name="person" value="<%=new Date()%>"/>--%>
<%--<!DOCTYPE HTML>--%>
<%--<html>--%>
<%--<head>--%>
    <%--<title>jsp:getProperty标签使用范例</title>--%>
<%--</head>--%>

<%--<body>--%>
<%--&lt;%&ndash;使用jsp:getProperty标签获取对象的属性值 &ndash;%&gt;--%>
<%--<h2>姓名：<jsp:getProperty property="name" name="person"/></h2>--%>
<%--<h2>性别：<jsp:getProperty property="sex" name="person"/></h2>--%>
<%--<h2>年龄：<jsp:getProperty property="age" name="person"/></h2>--%>
<%--<h2>已婚：<jsp:getProperty property="married" name="person"/></h2>--%>
<%--<h2>出生日期：<jsp:getProperty property="birthday" name="person"/></h2>--%>
<%--</body>--%>
<%--</html>--%>


<%--3--%>
<%--<html>--%>
<%--<body>--%>
<%--<h2>Hello World!</h2>--%>
<%--</body>--%>
<%--</html>--%>


<%--2--%>
<%--<%@page contentType="text/html;charset=UTF-8"%>--%>
<%--<%@page import="java.util.*"%>--%>
<%--<%--%>
    <%--//此时设置的属性只能够在本页中取得--%>
    <%--pageContext.setAttribute("name","哈哈哈哈",PageContext.REQUEST_SCOPE);  //设置属性--%>
    <%--pageContext.setAttribute("date",new Date(),PageContext.REQUEST_SCOPE); //设置属性--%>
    <%--//注意：这里设置的两个属性的名字分别为name和date，这两个是字符串类型的数据，但对应的属性值MLDN和new Date这个两个值却不是字符串类型，而是两个Object类型的数据。--%>
<%--%>--%>
<%--<%--%>
    <%--//取得设置的属性--%>
    <%--String name = (String)pageContext.getAttribute("name",PageContext.REQUEST_SCOPE);--%>
    <%--//由于取得的值为Object类型，因此必须使用String强制向下转型，转换成String类型--%>
    <%--Date date = (Date)pageContext.getAttribute("date",PageContext.REQUEST_SCOPE);--%>
<%--%>--%>
<%--<h1>姓名：<%=name%></h1>--%>
<%--<h1>日期：<%=date%></h1>--%>
<%--<jsp:include  page="WEB-INF/jsp/pageSecondT.jsp" >--%>
    <%--<jsp:param name="parm1" value="ha ha ha" />--%>
    <%--<jsp:param name="parm2" value="six six six" />--%>
<%--</jsp:include>--%>


<%--1--%>
<%--<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>--%>
<%--<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">--%>
<%--<html>--%>
<%--<head>--%>
    <%--<title>在Form表单中使用验证码</title>--%>
    <%--<script type="text/javascript">--%>
        <%--//刷新验证码--%>
        <%--function changeImg(){--%>
            <%--document.getElementById("validateCodeImg").src="${pageContext.request.contextPath}/servlet/DrawImage?"+Math.random();--%>
        <%--}--%>
    <%--</script>--%>
<%--</head>--%>

<%--<body>--%>
<%--<form action="${pageContext.request.contextPath}/servlet/CheckServlet" method="post">--%>
    <%--验证码：<input type="text" name="validateCode"/>--%>
    <%--<img alt="验证码看不清，换一张" src="${pageContext.request.contextPath}/servlet/DrawImage" id="validateCodeImg" onclick="changeImg()">--%>
    <%--<a href="javascript:void(0)" onclick="changeImg()">看不清，换一张</a>--%>
    <%--<br/>--%>
    <%--<input type="submit" value="提交">--%>
<%--</form>--%>
<%--</body>--%>
<%--</html>--%>
