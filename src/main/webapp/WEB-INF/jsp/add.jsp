<%--
  Created by IntelliJ IDEA.
  User: x231
  Date: 2023/9/6
  Time: 16:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
    <style>input{margin: 5px;}</style>
</head>
<body>
<div style="width: 300px; margin: 0 auto">
    <h2>添加信息</h2>
</div>
<hr/>
<div style="width: 300px; margin: 0 auto">
    <form action="${pageContext.request.contextPath}/pokemen/doAdd.do" method="post" enctype="multipart/form-data">
        编号:<input type="text" name="number"><br/>
        名称:<input type="text" name="name"><br/>
        战力:<input type="text" name="ss"><br/>
        属性:
        <c:forEach items="${attributes}" var="a">
            <input type="checkbox" name="attrss" value="${a.id}">${a.name}
        </c:forEach><br/>
        身高:<input type="text" name="stature"><br/>
        体重:<input type="text" name="weight"><br/>
        头像:<input type="file" name="uploadFile"><br/>
        简介:<input type="text" name="characteristic"><br/>
        <input type="submit" value="提交">
        <input type="reset" value="重置">
    </form>
</div>
</body>
</html>
