<%--
  Created by IntelliJ IDEA.
  User: x231
  Date: 2023/9/15
  Time: 11:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/bootstrap/css/bootstrap.min.css">
    <style type="text/css" rel="stylesheet">
        .head{
            height: 300px;
            background: url("/static/img/bkm.png") no-repeat center center;
            background-size: cover ;
        }
        .head span{
            color: white;
            float: left;
            margin-top: 140px;
        }
        .hs1{
            margin-left: 400px;
        }
        .hs2{
            margin-left: 580px;
        }
        .hs1:hover{
            color: red;
        }
        .hs2:hover{
            color: red;
        }
    </style>
</head>
<body>
    <div>
        <div class="head">
            <span class="hs1" onclick='location.href=("${pageContext.request.contextPath}/pokemen/toAtlas.do")'>宝可梦图鉴</span>
            <span class="hs2" onclick='location.href=("${pageContext.request.contextPath}/pokemen/toPokemen.do")'>宝可梦管理</span>
        </div>
        <div>

        </div>
    </div>
<script src="${pageContext.request.contextPath}/static/jquery/jquery-2.1.1.min.js"></script>
<script src="${pageContext.request.contextPath}/static/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript">

</script>
</body>
</body>
</html>
