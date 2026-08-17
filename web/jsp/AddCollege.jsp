<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>增加学院</title>
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
      color: #e53935;
    }
    .msg.success {
      color: #2e7d32;
    }
  </style>
</head>
<body>

<div class="container">
  <a href="${pageContext.request.contextPath}/jsp/CollegeIndex.jsp" class="back-btn">← 返回主页面</a>

  <h2>增加学院</h2>

  <form action="${pageContext.request.contextPath}/SchoolCl?flag=add" method="post">
    <div class="form-row">
      <div class="form-group">
        <label>学院编号 *</label>
        <input type="text" name="schoolID" placeholder="例如：08" required>
      </div>
      <div class="form-group">
        <label>学院名称 *</label>
        <input type="text" name="deptName" placeholder="例如：人工智能学院" required>
      </div>
    </div>

    <div class="form-row">
      <div class="form-group">
        <label>学院简称</label>
        <input type="text" name="briefName" placeholder="例如：AI学院">
      </div>
      <div class="form-group">
        <label>固定资产(千万元)</label>
        <input type="number" name="fixedAsset" placeholder="例如：5000" step="0.01">
      </div>
    </div>

    <div class="form-row">
      <div class="form-group">
        <label>建院日期</label>
        <input type="date" name="establishDate">
      </div>
      <div class="form-group">
        <label>教职工人数</label>
        <input type="number" name="numberOfEmployee" placeholder="例如：120">
      </div>
    </div>

    <div class="form-row">
      <div class="form-group">
        <label>本科专业数</label>
        <input type="number" name="programBachelor" placeholder="例如：8">
      </div>
      <div class="form-group">
        <label>硕士点数</label>
        <input type="number" name="programMaster" placeholder="例如：5">
      </div>
    </div>

    <div class="form-row">
      <div class="form-group">
        <label>实验室数量</label>
        <input type="number" name="numberOfLaboratory" placeholder="例如：3">
      </div>
      <div class="form-group">
        <label>研究所数量</label>
        <input type="number" name="instituteNum" placeholder="例如：4">
      </div>
    </div>

    <div class="form-row">
      <div class="form-group">
        <label>本科生人数</label>
        <input type="number" name="sizeOfBachelor" placeholder="例如：2000">
      </div>
      <div class="form-group">
        <label>硕士生人数</label>
        <input type="number" name="sizeOfMaster" placeholder="例如：500">
      </div>
    </div>

    <div class="form-row">
      <div class="form-group">
        <label>是否有博士点</label>
        <select name="hasPHDProgram">
          <option value="true">是</option>
          <option value="false">否</option>
        </select>
      </div>
      <div class="form-group">
        <label>是否有博士后站</label>
        <select name="hasPostDoctor">
          <option value="true">是</option>
          <option value="false">否</option>
        </select>
      </div>
    </div>

    <div class="form-row">
      <div class="form-group">
        <label>邮箱</label>
        <input type="email" name="email" placeholder="例如：ai@university.edu.cn">
      </div>
      <div class="form-group">
        <label>官网地址</label>
        <input type="url" name="mainPage" placeholder="例如：https://ai.university.edu.cn">
      </div>
    </div>

    <div class="form-group">
      <label>地址</label>
      <input type="text" name="address" placeholder="例如：XX市XX区XX路XX号">
    </div>

    <div class="form-group">
      <label>学院简介</label>
      <input type="text" name="introduction" placeholder="请输入学院简介">
    </div>

    <button type="submit" class="btn-submit">确认添加</button>
  </form>

  <!-- 提示信息 -->
  <c:if test="${not empty msg}">
    <div class="msg ${msgType}">${msg}</div>
  </c:if>
</div>

</body>
</html>