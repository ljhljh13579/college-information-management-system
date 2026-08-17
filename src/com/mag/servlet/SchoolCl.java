package com.mag.servlet;

import com.mag.domain.School;
import com.mag.service.SchoolService;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class SchoolCl extends HttpServlet {

    @Override//查询数据
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        //从浏览器发来的请求里，把名叫 flag的这个参数拿出来
        String flag = request.getParameter("flag");

        if (flag == null || "show".equals(flag)) {
            showSchools(request, response);
        } else if ("query".equals(flag)) {
            querySchool(request, response);
        } else if ("add".equals(flag)) {
            addSchool(request, response);
        } else if ("del".equals(flag)) {
            delSchool(request, response);
        } else if ("gotoUpdate".equals(flag)) {
            gotoUpdate(request, response);
        } else if ("update".equals(flag)) {
            updateSchool(request, response);
        }
        System.out.println("=== SchoolCl 收到请求，flag=" + request.getParameter("flag") + " ===");
    }

    @Override//新增和修改
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response); // ✅ 修正：POST 复用 GET
        System.out.println("=== SchoolCl 收到请求，flag=" + request.getParameter("flag") + " ===");
    }

    /**
     * 显示学院列表
     */
    private void showSchools(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        SchoolService service = new SchoolService();
        List<School> list = service.getAll();
        //把 list（学院数据）存进当前请求的 request对象里，起个名字叫 "schoolList"
        request.setAttribute("schoolList", list);
        //把当前请求（连同里面的 schoolList）转发给 SchoolList.jsp
        request.getRequestDispatcher("/jsp/SchoolList.jsp").forward(request, response);
    }


    //查询学院
    private void querySchool(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String deptName = request.getParameter("deptName");
        System.out.println("=== 查询学院，名称：" + deptName + " ===");

        SchoolService service = new SchoolService();
        School school = service.getByName(deptName);

        request.setAttribute("school", school);
        request.getRequestDispatcher("/jsp/QueryCollege.jsp").forward(request, response);
    }

    /**
     * 添加学院
     */
    private void addSchool(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        try {
            School school = new School();
            //从表单取值,直接 set 进 School对象
            school.setSchoolID(request.getParameter("schoolID"));
            school.setDeptName(request.getParameter("deptName"));
            school.setBriefName(request.getParameter("briefName"));
            school.setAddress(request.getParameter("address"));
            school.setEmail(request.getParameter("email"));
            school.setMainPage(request.getParameter("mainPage"));
            school.setIntroduction(request.getParameter("introduction"));

            // 数值字段（允许为空）
            String fixedAsset = request.getParameter("fixedAsset");
            school.setFixedAsset(fixedAsset == null || fixedAsset.isEmpty() ? 0 : Double.parseDouble(fixedAsset));
            //日期
            String establishDate = request.getParameter("establishDate");
            if (establishDate != null && !establishDate.isEmpty()) {
                school.setEstablishDate(java.sql.Date.valueOf(establishDate));
            }

            String numberOfEmployee = request.getParameter("numberOfEmployee");
            school.setNumberOfEmployee(numberOfEmployee == null || numberOfEmployee.isEmpty() ? 0 : Integer.parseInt(numberOfEmployee));

            String programBachelor = request.getParameter("programBachelor");
            school.setProgramBachelor(programBachelor == null || programBachelor.isEmpty() ? 0 : Integer.parseInt(programBachelor));

            String programMaster = request.getParameter("programMaster");
            school.setProgramMaster(programMaster == null || programMaster.isEmpty() ? 0 : Integer.parseInt(programMaster));

            String numberOfLaboratory = request.getParameter("numberOfLaboratory");
            school.setNumberOfLaboratory(numberOfLaboratory == null || numberOfLaboratory.isEmpty() ? 0 : Integer.parseInt(numberOfLaboratory));

            String instituteNum = request.getParameter("instituteNum");
            school.setInstituteNum(instituteNum == null || instituteNum.isEmpty() ? 0 : Integer.parseInt(instituteNum));

            String sizeOfBachelor = request.getParameter("sizeOfBachelor");
            school.setSizeOfBachelor(sizeOfBachelor == null || sizeOfBachelor.isEmpty() ? 0 : Integer.parseInt(sizeOfBachelor));

            String sizeOfMaster = request.getParameter("sizeOfMaster");
            school.setSizeOfMaster(sizeOfMaster == null || sizeOfMaster.isEmpty() ? 0 : Integer.parseInt(sizeOfMaster));

            school.setHasPHDProgram("true".equals(request.getParameter("hasPHDProgram")));
            school.setHasPostDoctor("true".equals(request.getParameter("hasPostDoctor")));

            SchoolService service = new SchoolService();
            boolean success = service.add(school);

            if (success) {
                //msg：页面要显示的提示文字
                //•
                //msgType：标记“成功”，JSP 可用来显示绿色提示
                request.setAttribute("msg", "学院添加成功！");
                request.setAttribute("msgType", "success");
            } else {
                request.setAttribute("msg", "学院添加失败，请检查编号是否重复。");
                request.setAttribute("msgType", "");
            }

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("msg", "添加失败：" + e.getMessage());
            request.setAttribute("msgType", "");
        }

        request.getRequestDispatcher("/jsp/AddCollege.jsp").forward(request, response);
    }


    /**
     * 删除学院
     */
    private void delSchool(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String schoolID = request.getParameter("schoolID");

        System.out.println("=== 删除学院，编号：" + schoolID + " ===");

        SchoolService service = new SchoolService();
        boolean success = service.delete(schoolID);

        if (success) {
            request.setAttribute("msg", "学院删除成功！");
        } else {
            request.setAttribute("msg", "删除失败，未找到该学院编号！");
        }

        // 删除完成后，回到列表页
        request.getRequestDispatcher("/jsp/SchoolList.jsp").forward(request, response);
    }

    /**
     * 跳转到修改页面（数据回填）
     */
    private void gotoUpdate(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("====== 进入 gotoUpdate 方法 ======"); // ✅ 加这行

        String schoolID = request.getParameter("schoolID");
        System.out.println("====== 接收到的 schoolID=" + schoolID + " ======");

        SchoolService service = new SchoolService();
        School school = service.getById(schoolID);

        System.out.println("====== 查到的学院名称=" + school.getDeptName() + " ======");

        request.setAttribute("school", school);
        request.getRequestDispatcher("/jsp/UpdateCollege.jsp").forward(request, response);
    }

    /**
     * 执行修改
     */
    private void updateSchool(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");

        try {
            School school = new School();
            school.setSchoolID(request.getParameter("schoolID"));
            school.setDeptName(request.getParameter("deptName"));
            school.setBriefName(request.getParameter("briefName"));
            school.setAddress(request.getParameter("address"));
            school.setEmail(request.getParameter("email"));
            school.setMainPage(request.getParameter("mainPage"));
            school.setIntroduction(request.getParameter("introduction"));

            String fixedAsset = request.getParameter("fixedAsset");
            school.setFixedAsset(fixedAsset == null || fixedAsset.isEmpty() ? 0 : Double.parseDouble(fixedAsset));

            String establishDate = request.getParameter("establishDate");
            if (establishDate != null && !establishDate.isEmpty()) {
                school.setEstablishDate(java.sql.Date.valueOf(establishDate));
            }

            String numberOfEmployee = request.getParameter("numberOfEmployee");
            school.setNumberOfEmployee(numberOfEmployee == null || numberOfEmployee.isEmpty() ? 0 : Integer.parseInt(numberOfEmployee));

            String programBachelor = request.getParameter("programBachelor");
            school.setProgramBachelor(programBachelor == null || programBachelor.isEmpty() ? 0 : Integer.parseInt(programBachelor));

            String programMaster = request.getParameter("programMaster");
            school.setProgramMaster(programMaster == null || programMaster.isEmpty() ? 0 : Integer.parseInt(programMaster));

            String numberOfLaboratory = request.getParameter("numberOfLaboratory");
            school.setNumberOfLaboratory(numberOfLaboratory == null || numberOfLaboratory.isEmpty() ? 0 : Integer.parseInt(numberOfLaboratory));

            String instituteNum = request.getParameter("instituteNum");
            school.setInstituteNum(instituteNum == null || instituteNum.isEmpty() ? 0 : Integer.parseInt(instituteNum));

            String sizeOfBachelor = request.getParameter("sizeOfBachelor");
            school.setSizeOfBachelor(sizeOfBachelor == null || sizeOfBachelor.isEmpty() ? 0 : Integer.parseInt(sizeOfBachelor));

            String sizeOfMaster = request.getParameter("sizeOfMaster");
            school.setSizeOfMaster(sizeOfMaster == null || sizeOfMaster.isEmpty() ? 0 : Integer.parseInt(sizeOfMaster));

            school.setHasPHDProgram("true".equals(request.getParameter("hasPHDProgram")));
            school.setHasPostDoctor("true".equals(request.getParameter("hasPostDoctor")));

            SchoolService service = new SchoolService();
            boolean success = service.update(school);

            if (success) {
                request.setAttribute("msg", "学院信息修改成功！");
            } else {
                request.setAttribute("msg", "修改失败，请重试。");
            }

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("msg", "修改失败：" + e.getMessage());
        }

        // 跳转到列表页展示结果
        response.sendRedirect(request.getContextPath() + "/SchoolCl?flag=show");
    }

}
