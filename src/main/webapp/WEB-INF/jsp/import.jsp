<%--
  Created by IntelliJ IDEA.
  User: x231
  Date: 2023/9/19
  Time: 13:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<div style="width: 300px; margin: 0 auto">
    <h2>导入信息</h2>
</div>
<hr/>
<div style="width: 300px; margin: 0 auto">
    <form action="${pageContext.request.contextPath}/pokemen/doImport.do" method="post" enctype="multipart/form-data">
        文件:<input type="file" name="importExcel">&nbsp;&nbsp;<input type="submit" value="提交">
    </form>
</div>
</html>
