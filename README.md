# college-information-management-system
学院信息管理系统-一个基于Java Web的学院信息管理系统，用于管理大学下属各学院的基本信息，属于课程大作业；
功能特性：学院信息列表展示、按学院名称查询、新增 / 删除 / 修改学院信息、前端表单 JS 校验、中文编码过滤；
技术栈：后端：Java、Servlet（Jakarta Servlet 6.0）、JSP、JSTL，数据库：MySQL，JDBC（原生封装 SqlHelper），前端：JSP + HTML/CSS/JavaScript，服务器：Apache Tomcat
项目结构
  src/com/mag/
  ├── domain/   School.java         # 实体类
  ├── service/  SchoolService.java  # 业务逻辑层
  ├── servlet/  SchoolCl.java       # 控制层（Servlet）
  ├── filter/   MyFilter.java       # 字符编码过滤器
  └── util/     SqlHelper.java      # JDBC 封装工具类
  web/
  ├── index.jsp                     # 入口页
  ├── js/                           # 前端校验脚本
  └── jsp/                          # 各功能页面
运行说明
  1. 创建 MySQL 数据库 schools，建表 schools_info（字段对应 School 实体类）。
  2. 在 src/dbinfo.properties 中配置数据库连接（驱动、URL、用户名、密码）。
  3. 用 Tomcat 部署并启动，访问首页即可。
