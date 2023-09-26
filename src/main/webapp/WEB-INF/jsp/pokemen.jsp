<%--
  Created by IntelliJ IDEA.
  User: x231
  Date: 2023/9/14
  Time: 14:11
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
        <div style="margin: 20px;">
            <form action="${pageContext.request.contextPath}/pokemen/toPokemen.do" method="post">
                编号:
                <input type="text" name="number" value="${qeVo.number}">
                名称:
                <input type="text" name="name" value="${qeVo.name}">

                <input type="submit" value="确定">
                <input type="reset" value="重置">
                <span style="float: right">
                    <input type="button" value="添加" onclick='location.href=("${pageContext.request.contextPath}/pokemen/toAdd.do")'>
                    <input type="button" value="导入" onclick='location.href=("${pageContext.request.contextPath}/pokemen/toImport.do")'>
                    <input type="button" value="导出" onclick='location.href=("${pageContext.request.contextPath}/pokemen/doExport.do")'>
                </span>
            </form>
            <form method="post">
                <table  class="table table-striped table-hover">
                    <tr>
                        <th>编号</th>
                        <th>名称</th>
                        <th>头像</th>
                        <th>属性</th>
                        <th>身高</th>
                        <th>体重</th>
                        <th>宝可梦特性</th>
                        <th colspan="2">编辑</th>
                    </tr>
                    <c:forEach items="${pageInfo.list}" var="p">
                        <tr>
                            <td>${p.number}</td>
                            <td>${p.name}</td>
                            <td>
                                <img src="${pageContext.request.contextPath}/upload/${p.url}" width="100px" height="100px">
                            </td>
                            <td>
                                <c:forEach items="${p.attrs}" var="a">
                                    <span>${a.name}</span>
                                </c:forEach>
                            </td>
                            <td>${p.stature}</td>
                            <td>${p.weight}</td>
                            <td>${p.characteristic}</td>
                            <td><a href="${pageContext.request.contextPath}/pokemen/preUpdata.do?pid=${p.id}">修改</a></td>
                            <td><a href="${pageContext.request.contextPath}/pokemen/delete.do?pid=${p.id}">删除</a></td>
                        </tr>
                    </c:forEach>
                </table>
            </form>
            <div style="float: right;">

                &nbsp;&nbsp;
                第${pageInfo.pageNum}页/共${pageInfo.pages}页 ${pageInfo.total}条记录
                &nbsp;&nbsp;

                <a href="${pageContext.request.contextPath}/pokemen/toPokemen.do?pageNum=${pageInfo.firstPage}">首页</a>
                <c:if test="${!pageInfo.isFirstPage}">
                    <a href="${pageContext.request.contextPath}/pokemen/toPokemen.do?pageNum=${pageInfo.prePage}">上一页</a>
                </c:if>
                <c:if test="${pageInfo.isFirstPage}">
                    上一页
                </c:if>
                <c:if test="${!pageInfo.isLastPage}">
                    <a href="${pageContext.request.contextPath}/pokemen/toPokemen.do?pageNum=${pageInfo.nextPage}">下一页</a>
                </c:if>
                <c:if test="${pageInfo.isLastPage}">
                    下一页
                </c:if>
                <a href="${pageContext.request.contextPath}/pokemen/toPokemen.do?pageNum=${pageInfo.lastPage}">尾页</a>
                &nbsp;

            </div>
        </div>
    </div>
    <script src="${pageContext.request.contextPath}/static/jquery/jquery-2.1.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript">

    </script>
</body>
</html>
