<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>学院列表</title>
    <style>
        body {
            font-family: "微软雅黑";
            background-color: #f5f5f5;
        }
        .container {
            width: 98%;
            margin: 20px auto;
            overflow-x: auto;
        }
        .back-btn {
            display: inline-block;
            margin-bottom: 15px;
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
        table {
            border-collapse: collapse;
            width: 100%;
            background-color: white;
            box-shadow: 0 2px 8px rgba(0,0,0,0.1);
            font-size: 13px;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 8px 6px;
            text-align: center;
            white-space: nowrap;
        }
        th {
            background-color: #1a73e8;
            color: white;
        }
        tr:nth-child(even) {
            background-color: #f9f9f9;
        }
        tr:hover {
            background-color: #e3f2fd;
        }
        caption {
            font-size: 24px;
            margin-bottom: 15px;
            color: #333;
            font-weight: bold;
        }
        .op-link {
            color: #1a73e8;
            text-decoration: none;
            margin: 0 4px;
        }
        .op-link:hover {
            text-decoration: underline;
        }
        .op-link.del {
            color: #e53935;
        }
    </style>
</head>
<body>

<div class="container">
    <a href="${pageContext.request.contextPath}/jsp/CollegeIndex.jsp" class="back-btn">← 返回主页面</a>

    <table>
        <caption>学院信息列表</caption>
        <tr>
            <th>学院编号</th>
            <th>学院名称</th>
            <th>学院简称</th>
            <th>固定资产(千万元)</th>
            <th>建院日期</th>
            <th>地址</th>
            <th>教职工人数</th>
            <th>本科专业数</th>
            <th>硕士点数</th>
            <th>实验室数</th>
            <th>研究所数</th>
            <th>本科生规模</th>
            <th>硕士生规模</th>
            <th>博士点</th>
            <th>博士后站</th>
            <th>邮箱</th>
            <th>官网</th>
            <th>简介</th>
            <th>操作</th>
        </tr>

        <c:forEach items="${schoolList}" var="s">
            <tr>
                <td>${s.schoolID}</td>
                <td>${s.deptName}</td>
                <td>${s.briefName}</td>
                <td>${s.fixedAsset}</td>
                <td>${s.establishDate}</td>
                <td>${s.address}</td>
                <td>${s.numberOfEmployee}</td>
                <td>${s.programBachelor}</td>
                <td>${s.programMaster}</td>
                <td>${s.numberOfLaboratory}</td>
                <td>${s.instituteNum}</td>
                <td>${s.sizeOfBachelor}</td>
                <td>${s.sizeOfMaster}</td>
                <td>${s.hasPHDProgram ? '是' : '否'}</td>
                <td>${s.hasPostDoctor ? '是' : '否'}</td>
                <td>${s.email}</td>
                <td>${s.mainPage}</td>
                <td>${s.introduction}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/SchoolCl?flag=gotoUpdate&schoolID=${s.schoolID}" class="op-link">修改</a>
                    <a href="${pageContext.request.contextPath}/SchoolCl?flag=del&schoolID=${s.schoolID}"
                       class="op-link del"
                       onclick="return confirm('确定删除该学院吗？')">删除</a>
                </td>
            </tr>
        </c:forEach>

    </table>
</div>

</body>
</html>