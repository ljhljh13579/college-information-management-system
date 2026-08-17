<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>修改学院信息</title>
    <style>
        body {
            font-family: "微软雅黑";
            background-color: #f5f5f5;
        }
        .container {
            width: 700px;
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
        .form-row {
            display: flex;
            gap: 20px;
            margin-bottom: 16px;
        }
        .form-group {
            flex: 1;
        }
        .form-group label {
            display: block;
            margin-bottom: 6px;
            color: #555;
            font-size: 14px;
        }
        .form-group input, .form-group select {
            width: 100%;
            padding: 10px;
            border: 1px solid #ddd;
            border-radius: 4px;
            font-size: 14px;
            box-sizing: border-box;
        }
        .form-group input:focus, .form-group select:focus {
            border-color: #1a73e8;
            outline: none;
        }
        .btn-submit {
            width: 100%;
            padding: 12px;
            background-color: #1a73e8;
            color: white;
            border: none;
            border-radius: 4px;
            font-size: 16px;
            cursor: pointer;
            margin-top: 10px;
        }
        .btn-submit:hover {
            background-color: #0d47a1;
        }
        .msg {
            text-align: center;
            margin-top: 15px;
            font-size: 14px;
            color: #2e7d32;
        }
    </style>
</head>
<body>

<div class="container">
    <a href="${pageContext.request.contextPath}/jsp/CollegeIndex.jsp" class="back-btn">← 返回主页面</a>

    <h2>修改学院信息</h2>

    <form action="${pageContext.request.contextPath}/SchoolCl?flag=update" method="post">

        <!-- 隐藏域：学院编号（不可修改） -->
        <input type="hidden" name="schoolID" value="${school.schoolID}">

        <div class="form-row">
            <div class="form-group">
                <label>学院编号</label>
                <input type="text" value="${school.schoolID}" disabled>
            </div>
            <div class="form-group">
                <label>学院名称</label>
                <input type="text" name="deptName" value="${school.deptName}">
            </div>
        </div>

        <div class="form-row">
            <div class="form-group">
                <label>简称</label>
                <input type="text" name="briefName" value="${school.briefName}">
            </div>
            <div class="form-group">
                <label>固定资产(万元)</label>
                <input type="number" name="fixedAsset" value="${school.fixedAsset}" step="0.01">
            </div>
        </div>

        <div class="form-row">
            <div class="form-group">
                <label>建校日期</label>
                <input type="date" name="establishDate"
                       value="${school.establishDate != null ? school.establishDate.toString() : ''}">
            </div>
            <div class="form-group">
                <label>教职工人数</label>
                <input type="number" name="numberOfEmployee" value="${school.numberOfEmployee}">
            </div>
        </div>

        <div class="form-row">
            <div class="form-group">
                <label>本科点</label>
                <input type="number" name="programBachelor" value="${school.programBachelor}">
            </div>
            <div class="form-group">
                <label>硕士点</label>
                <input type="number" name="programMaster" value="${school.programMaster}">
            </div>
        </div>

        <div class="form-row">
            <div class="form-group">
                <label>实验室数量</label>
                <input type="number" name="numberOfLaboratory" value="${school.numberOfLaboratory}">
            </div>
            <div class="form-group">
                <label>学院数量</label>
                <input type="number" name="instituteNum" value="${school.instituteNum}">
            </div>
        </div>

        <div class="form-row">
            <div class="form-group">
                <label>本科生人数</label>
                <input type="number" name="sizeOfBachelor" value="${school.sizeOfBachelor}">
            </div>
            <div class="form-group">
                <label>硕士生人数</label>
                <input type="number" name="sizeOfMaster" value="${school.sizeOfMaster}">
            </div>
        </div>

        <div class="form-row">
            <div class="form-group">
                <label>是否有博士点</label>
                <select name="hasPHDProgram">
                    <option value="true" ${school.hasPHDProgram ? 'selected' : ''}>是</option>
                    <option value="false" ${!school.hasPHDProgram ? 'selected' : ''}>否</option>
                </select>
            </div>
            <div class="form-group">
                <label>是否有博士后</label>
                <select name="hasPostDoctor">
                    <option value="true" ${school.hasPostDoctor ? 'selected' : ''}>是</option>
                    <option value="false" ${!school.hasPostDoctor ? 'selected' : ''}>否</option>
                </select>
            </div>
        </div>

        <div class="form-row">
            <div class="form-group">
                <label>邮箱</label>
                <input type="email" name="email" value="${school.email}">
            </div>
            <div class="form-group">
                <label>官网地址</label>
                <input type="url" name="mainPage" value="${school.mainPage}">
            </div>
        </div>

        <div class="form-group">
            <label>地址</label>
            <input type="text" name="address" value="${school.address}">
        </div>

        <div class="form-group">
            <label>学院简介</label>
            <input type="text" name="introduction" value="${school.introduction}">
        </div>

        <button type="submit" class="btn-submit">确认修改</button>
    </form>

    <c:if test="${not empty msg}">
        <div class="msg">${msg}</div>
    </c:if>
</div>

</body>
</html>