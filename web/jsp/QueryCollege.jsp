<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>学院查询</title>
    <style>
        body {
            font-family: "微软雅黑";
            background-color: #f5f5f5;
        }
        .container {
            width: 600px;
            margin: 40px auto;
            background-color: white;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 2px 12px rgba(0,0,0,0.1);
        }
        .back-btn {
            display: inline-block;
            margin-bottom: 20px;
            padding: 8px 16px;
            background-color: #1a73e8;
            color: white;
            text-decoration: none;
            border-radius: 4px;
            font-size: 14px;
        }
        .back-btn:hover {
            background-color: #0d47a1;
        }
        h2 {
            text-align: center;
            color: #333;
            margin-bottom: 25px;
        }
        .form-group {
            margin-bottom: 20px;
        }
        .form-group label {
            display: block;
            margin-bottom: 6px;
            color: #555;
            font-size: 14px;
        }
        .form-group input {
            width: 100%;
            padding: 10px;
            border: 1px solid #ddd;
            border-radius: 4px;
            font-size: 14px;
            box-sizing: border-box;
        }
        .form-group input:focus {
            border-color: #1a73e8;
            outline: none;
        }
        .btn-query {
            width: 100%;
            padding: 10px;
            background-color: #1a73e8;
            color: white;
            border: none;
            border-radius: 4px;
            font-size: 16px;
            cursor: pointer;
        }
        .btn-query:hover {
            background-color: #0d47a1;
        }
        .result-table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        .result-table th, .result-table td {
            border: 1px solid #ddd;
            padding: 10px;
            text-align: center;
        }
        .result-table th {
            background-color: #1a73e8;
            color: white;
        }
        .no-result {
            text-align: center;
            color: #e53935;
            margin-top: 15px;
            font-size: 14px;
        }
    </style>
</head>
<body>

<div class="container">
    <a href="${pageContext.request.contextPath}/jsp/CollegeIndex.jsp" class="back-btn">← 返回主页面</a>

    <h2>学院信息查询</h2>

    <!-- 查询表单 -->
    <form action="${pageContext.request.contextPath}/SchoolCl?flag=query" method="post">
        <div class="form-group">
            <label for="deptName">请输入学院名称</label>
            <input type="text" id="deptName" name="deptName"
                   placeholder="例如：计算机科学与技术学院" required>
        </div>
        <button type="submit" class="btn-query">查 询</button>
    </form>

    <!-- 查询结果 -->
    <c:if test="${not empty school}">
        <table class="result-table">
            <tr><th>学院编号</th><td>${school.schoolID}</td></tr>
            <tr><th>学院名称</th><td>${school.deptName}</td></tr>
            <tr><th>学院简称</th><td>${school.briefName}</td></tr>
            <tr><th>固定资产(千万元)</th><td>${school.fixedAsset}</td></tr>
            <tr><th>建校日期</th><td>${school.establishDate}</td></tr>
            <tr><th>地址</th><td>${school.address}</td></tr>
            <tr><th>教职工人数</th><td>${school.numberOfEmployee}</td></tr>
            <tr><th>本科专业数</th><td>${school.programBachelor}</td></tr>
            <tr><th>硕士点数</th><td>${school.programMaster}</td></tr>
            <tr><th>实验室数</th><td>${school.numberOfLaboratory}</td></tr>
            <tr><th>研究所数</th><td>${school. instituteNum}</td></tr>
            <tr><th>本科生规模</th><td>${school.sizeOfBachelor}</td></tr>
            <tr><th>研究生规模</th><td>${school.sizeOfMaster}</td></tr>
            <tr><th>博士点</th><td>${school.hasPHDProgram ? '是' : '否'}</td></tr>
            <tr><th>博士后站</th><td>${school.hasPostDoctor ? '是' : '否'}</td></tr>
            <tr><th>邮箱</th><td>${school.email}</td></tr>
            <tr><th>官网</th><td>${school.mainPage}</td></tr>
            <tr><th>院系介绍</th><td>${school. introduction}</td></tr>
        </table>
    </c:if>

    <!-- 查询失败提示 -->
    <c:if test="${empty school and not empty param.deptName}">
        <div class="no-result">
            未找到学院名称为「${param.deptName}」的学院
        </div>
    </c:if>

</div>

</body>
</html>