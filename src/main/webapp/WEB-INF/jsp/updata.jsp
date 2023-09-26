<%--
  Created by IntelliJ IDEA.
  User: x231
  Date: 2023/9/14
  Time: 17:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div style="width: 300px; margin: 0 auto">
    <h2>修改信息</h2>
</div>
<hr/>
<div style="width: 300px; margin: 0 auto">
    <form action="${pageContext.request.contextPath}/pokemen/doUpdata.do" method="post" enctype="multipart/form-data">
        <input type="hidden" value="${pokemen.id}" name="id">
        编号:<input type="text" name="number" value="${pokemen.number}"><br/>
        名称:<input type="text" name="name" value="${pokemen.name}"><br/>
        战力:<input type="text" name="ss" value="${pokemen.ss}"><br/>
        属性:
        <c:forEach items="${attributes}" var="a">
            <input type="checkbox" name="attrss" value="${a.id}"
                <c:forEach items="${pokemen.attrs}" var="pa">
                   <c:if test="${a.id==pa.id}">checked</c:if>
                </c:forEach>
            >${a.name}
        </c:forEach><br/>
        身高:<input type="text" name="stature" value="${pokemen.stature}"><br/>
        体重:<input type="text" name="weight" value="${pokemen.weight}"><br/>
        头像:<input type="file" name="uploadFile"><br/>
        简介:<input type="text" name="characteristic" value="${pokemen.characteristic}"><br/>
        <input type="submit" value="提交">
        <input type="reset" value="重置">
    </form>
</div>
</body>
</html>
