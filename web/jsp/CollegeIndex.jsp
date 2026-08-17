<<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学院信息管理系统</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }
        body {
            font-family: "微软雅黑", sans-serif;
            background-color: #f0f2f5;
            min-height: 100vh;
        }
        .header {
            background: linear-gradient(135deg, #1a73e8, #0d47a1);
            color: white;
            text-align: center;
            padding: 40px 0;
            box-shadow: 0 2px 10px rgba(0,0,0,0.2);
        }
        .header h1 {
            font-size: 36px;
            letter-spacing: 6px;
        }
        .btn-container {
            display: flex;
            justify-content: center;
            flex-wrap: wrap;
            gap: 24px;
            margin-top: 80px;
            padding: 0 20px;
        }
        .btn {
            background-color: white;
            border: 2px solid #1a73e8;
            color: #1a73e8;
            padding: 16px 32px;
            font-size: 18px;
            border-radius: 8px;
            cursor: pointer;
            transition: all 0.3s ease;
            min-width: 180px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
        }
        .btn:hover {
            background-color: #1a73e8;
            color: white;
            transform: translateY(-3px);
            box-shadow: 0 6px 16px rgba(26,115,232,0.4);
        }
        .footer {
            text-align: center;
            margin-top: 60px;
            padding: 20px;
            color: #999;
            font-size: 14px;
        }
    </style>
</head>
<body>

<div class="header">
    <h1>学院信息管理系统</h1>
</div>

<div class="btn-container">
    <a href="${pageContext.request.contextPath}/SchoolCl?flag=show" class="btn">显示所有学院</a>
    <a href="${pageContext.request.contextPath}/jsp/QueryCollege.jsp" class="btn">学院查询</a>
    <a href="${pageContext.request.contextPath}/jsp/AddCollege.jsp" class="btn">增加学院</a>
    <a href="${pageContext.request.contextPath}/jsp/DeleteCollege.jsp" class="btn">删除学院</a>
    <a href="${pageContext.request.contextPath}/SchoolCl?flag=show" class="btn">信息更新</a>
</div>

<div class="footer">
    学院信息管理系统 © 2026
</div>

</body>
</html>