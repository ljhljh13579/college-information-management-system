<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>删除学院</title>
    <style>
        body {
            font-family: "微软雅黑";
            background-color: #f5f5f5;
        }
        .container {
            width: 500px;
            margin: 80px auto;
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
        .btn-delete {
            width: 100%;
            padding: 12px;
            background-color: #e53935;
            color: white;
            border: none;
            border-radius: 4px;
            font-size: 16px;
            cursor: pointer;
        }
        .btn-delete:hover {
            background-color: #b71c1c;
        }
        .msg {
            text-align: center;
            margin-top: 15px;
            font-size: 14px;
            color: #e53935;
        }
    </style>
</head>
<body>

<div class="container">
    <a href="${pageContext.request.contextPath}/jsp/CollegeIndex.jsp" class="back-btn">← 返回主页面</a>

    <h2>删除学院</h2>

    <form action="${pageContext.request.contextPath}/SchoolCl?flag=del" method="post"
          onsubmit="return confirm('确定要删除该学院吗？此操作不可恢复！');">

        <div class="form-group">
            <label for="schoolID">请输入要删除的学院编号</label>
            <input type="text" id="schoolID" name="schoolID"
                   placeholder="例如：02" required>
        </div>

        <button type="submit" class="btn-delete">确 认 删 除</button>
    </form>

    <c:if test="${not empty msg}">
        <div class="msg">${msg}</div>
    </c:if>
</div>

</body>
</html>