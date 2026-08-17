package com.mag.service;

import com.mag.domain.School;
import com.mag.util.SqlHelper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SchoolService {


    /* ================= 查询全部 ================= */
    public List<School> getAll() {
        List<School> list = new ArrayList<>();
        String sql = "select * from schools_info";
        ResultSet rs = SqlHelper.executeQuery(sql, null);
        try {
            while (rs.next()) {
                School school = new School();
                fillSchool(school, rs);
                list.add(school);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // 把错误打印到控制台
        } finally {
            SqlHelper.close(null, null, rs);
        }
        return list;
    }



    /* ================= 按名称查询 ================= */
    public School getByName(String deptName) {
        School school = new School();
        String sql = "select * from schools_info where DeptName=?";
        ResultSet rs = SqlHelper.executeQuery(sql, new String[]{deptName});
        try {
            if (rs.next()) {
                fillSchool(school, rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            SqlHelper.close(null, null, rs);
        }
        return school;
    }

    /* ================= 增加学院 ================= */
    public boolean add(School school) {

        String sql = "INSERT INTO schools_info (" +
                "SchoolID, DeptName, BriefName, FixedAsset, EstablishDate, " +
                "Address, NumberOfEmployee, ProgramBachelor, ProgramMaster, " +
                "NumberOfLaboratory, InstituteNum, SizeOfBachelor, SizeOfMaster, " +
                "HasPHDProgram, HasPostDoctor, Email, MainPage, Introduction" +
                ") VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        String[] params = {
                school.getSchoolID(),
                school.getDeptName(),
                school.getBriefName(),
                school.getFixedAsset() == null ? "0" : school.getFixedAsset().toString(),
                school.getEstablishDate() == null ? null :
                        new java.sql.Date(school.getEstablishDate().getTime()).toString(),
                school.getAddress(),
                school.getNumberOfEmployee() == null ? "0" : school.getNumberOfEmployee().toString(),
                school.getProgramBachelor() == null ? "0" : school.getProgramBachelor().toString(),
                school.getProgramMaster() == null ? "0" : school.getProgramMaster().toString(),
                school.getNumberOfLaboratory() == null ? "0" : school.getNumberOfLaboratory().toString(),
                school.getInstituteNum() == null ? "0" : school.getInstituteNum().toString(),
                school.getSizeOfBachelor() == null ? "0" : school.getSizeOfBachelor().toString(),
                school.getSizeOfMaster() == null ? "0" : school.getSizeOfMaster().toString(),
                school.getHasPHDProgram() != null && school.getHasPHDProgram() ? "1" : "0",
                school.getHasPostDoctor() != null && school.getHasPostDoctor() ? "1" : "0",
                school.getEmail(),
                school.getMainPage(),
                school.getIntroduction()
        };

        int rows = SqlHelper.executeUpdate(sql, params);
        return rows > 0;
    }


    /* ================= 删除 ================= */
    public boolean delete(String schoolID) {
        String sql = "DELETE FROM schools_info WHERE SchoolID = ?";
        String[] params = {schoolID};

        int rows = SqlHelper.executeUpdate(sql, params);
        return rows > 0;
    }



    /* ================= 修改 ================= */
    public boolean update(School school) {

        String sql = "UPDATE schools_info SET " +
                "DeptName=?, BriefName=?, FixedAsset=?, EstablishDate=?, " +
                "Address=?, NumberOfEmployee=?, ProgramBachelor=?, ProgramMaster=?, " +
                "NumberOfLaboratory=?, InstituteNum=?, SizeOfBachelor=?, SizeOfMaster=?, " +
                "HasPHDProgram=?, HasPostDoctor=?, EMail=?, MainPage=?, Introduction=? " +
                "WHERE SchoolID=?";

        String[] params = {
                school.getDeptName(),
                school.getBriefName(),
                school.getFixedAsset() == null ? "0" : school.getFixedAsset().toString(),
                school.getEstablishDate() == null ? null :
                        new java.sql.Date(school.getEstablishDate().getTime()).toString(),
                school.getAddress(),
                school.getNumberOfEmployee() == null ? "0" : school.getNumberOfEmployee().toString(),
                school.getProgramBachelor() == null ? "0" : school.getProgramBachelor().toString(),
                school.getProgramMaster() == null ? "0" : school.getProgramMaster().toString(),
                school.getNumberOfLaboratory() == null ? "0" : school.getNumberOfLaboratory().toString(),
                school.getInstituteNum() == null ? "0" : school.getInstituteNum().toString(),
                school.getSizeOfBachelor() == null ? "0" : school.getSizeOfBachelor().toString(),
                school.getSizeOfMaster() == null ? "0" : school.getSizeOfMaster().toString(),
                school.getHasPHDProgram() != null && school.getHasPHDProgram() ? "1" : "0",
                school.getHasPostDoctor() != null && school.getHasPostDoctor() ? "1" : "0",
                school.getEmail(),
                school.getMainPage(),
                school.getIntroduction(),
                school.getSchoolID()  // WHERE 条件
        };

        int rows = SqlHelper.executeUpdate(sql, params);
        return rows > 0;
    }
    /**
     * 根据学院编号查询
     */
    public School getById(String schoolID) {
        School school = new School();
        String sql = "SELECT * FROM schools_info WHERE SchoolID = ?";
        String[] params = {schoolID};
        ResultSet rs = null;

        try {
            rs = SqlHelper.executeQuery(sql, params);
            if (rs.next()) {
                school.setSchoolID(rs.getString("SchoolID"));
                school.setDeptName(rs.getString("DeptName"));
                school.setBriefName(rs.getString("BriefName"));
                school.setFixedAsset(rs.getDouble("FixedAsset"));
                school.setEstablishDate(rs.getDate("EstablishDate"));
                school.setAddress(rs.getString("Address"));
                school.setNumberOfEmployee(rs.getInt("NumberOfEmployee"));
                school.setProgramBachelor(rs.getInt("ProgramBachelor"));
                school.setProgramMaster(rs.getInt("ProgramMaster"));
                school.setNumberOfLaboratory(rs.getInt("NumberOfLaboratory"));
                school.setInstituteNum(rs.getInt("InstituteNum"));
                school.setSizeOfBachelor(rs.getInt("SizeOfBachelor"));
                school.setSizeOfMaster(rs.getInt("SizeOfMaster"));
                school.setHasPHDProgram(rs.getBoolean("HasPHDProgram"));
                school.setHasPostDoctor(rs.getBoolean("HasPostDoctor"));
                school.setEmail(rs.getString("EMail"));
                school.setMainPage(rs.getString("MainPage"));
                school.setIntroduction(rs.getString("Introduction"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (SqlHelper.getPs() != null) SqlHelper.getPs().close();
                if (SqlHelper.getCt() != null) SqlHelper.getCt().close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return school;
    }

    /* ================= 私有工具方法 ================= */
    //从数据库rs里get方法得到字段，通过set放入school类
    private void fillSchool(School school, ResultSet rs) throws SQLException {
        school.setSchoolID(rs.getString("SchoolID"));
        school.setDeptName(rs.getString("DeptName"));
        school.setBriefName(rs.getString("BriefName"));
        school.setFixedAsset(rs.getDouble("FixedAsset"));
        school.setEstablishDate(rs.getDate("EstablishDate"));
        school.setAddress(rs.getString("Address"));
        school.setNumberOfEmployee(rs.getInt("NumberOfEmployee"));
        school.setProgramBachelor(rs.getInt("ProgramBachelor"));
        school.setProgramMaster(rs.getInt("ProgramMaster"));
        school.setNumberOfLaboratory(rs.getInt("NumberOfLaboratory"));
        school.setInstituteNum(rs.getInt("InstituteNum"));
        school.setSizeOfBachelor(rs.getInt("SizeOfBachelor"));
        school.setSizeOfMaster(rs.getInt("SizeOfMaster"));
        school.setHasPHDProgram(rs.getBoolean("HasPHDProgram"));
        school.setHasPostDoctor(rs.getBoolean("HasPostDoctor"));
        school.setEmail(rs.getString("Email"));
        school.setMainPage(rs.getString("MainPage"));
        school.setIntroduction(rs.getString("Introduction"));
    }
}