package com.mag.domain;

import java.util.Date;

public class School {

	public School() {}

	private String schoolID;
	private String deptName;
	private String briefName;
	private Double fixedAsset;
	private Date establishDate;
	private String address;
	private Integer numberOfEmployee;
	private Integer programBachelor;
	private Integer programMaster;
	private Integer numberOfLaboratory;
	private Integer instituteNum;
	private Integer sizeOfBachelor;
	private Integer sizeOfMaster;
	private Boolean hasPHDProgram;
	private Boolean hasPostDoctor;
	private String email;
	private String mainPage;
	private String introduction;

	//get从School实体对象中获取已封装好的数据
	//set是把外部数据（数据库查出来的 / 表单提交过来的）填进 School对象的内存属性里

	public String getSchoolID() {
		return schoolID;
	}

	public void setSchoolID(String schoolID) {
		this.schoolID = schoolID;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getBriefName() {
		return briefName;
	}

	public void setBriefName(String briefName) {
		this.briefName = briefName;
	}

	public Double getFixedAsset() {
		return fixedAsset;
	}

	public void setFixedAsset(Double fixedAsset) {
		this.fixedAsset = fixedAsset;
	}

	public Date getEstablishDate() {
		return establishDate;
	}

	public void setEstablishDate(Date establishDate) {
		this.establishDate = establishDate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getNumberOfEmployee() {
		return numberOfEmployee;
	}

	public void setNumberOfEmployee(Integer numberOfEmployee) {
		this.numberOfEmployee = numberOfEmployee;
	}

	public Integer getProgramBachelor() {
		return programBachelor;
	}

	public void setProgramBachelor(Integer programBachelor) {
		this.programBachelor = programBachelor;
	}

	public Integer getProgramMaster() {
		return programMaster;
	}

	public void setProgramMaster(Integer programMaster) {
		this.programMaster = programMaster;
	}

	public Integer getNumberOfLaboratory() {
		return numberOfLaboratory;
	}

	public void setNumberOfLaboratory(Integer numberOfLaboratory) {
		this.numberOfLaboratory = numberOfLaboratory;
	}

	public Integer getInstituteNum() {
		return instituteNum;
	}

	public void setInstituteNum(Integer instituteNum) {
		this.instituteNum = instituteNum;
	}

	public Integer getSizeOfBachelor() {
		return sizeOfBachelor;
	}

	public void setSizeOfBachelor(Integer sizeOfBachelor) {
		this.sizeOfBachelor = sizeOfBachelor;
	}

	public Integer getSizeOfMaster() {
		return sizeOfMaster;
	}

	public void setSizeOfMaster(Integer sizeOfMaster) {
		this.sizeOfMaster = sizeOfMaster;
	}

	public Boolean getHasPHDProgram() {
		return hasPHDProgram;
	}

	public void setHasPHDProgram(Boolean hasPHDProgram) {
		this.hasPHDProgram = hasPHDProgram;
	}

	public Boolean getHasPostDoctor() {
		return hasPostDoctor;
	}

	public void setHasPostDoctor(Boolean hasPostDoctor) {
		this.hasPostDoctor = hasPostDoctor;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMainPage() {
		return mainPage;
	}

	public void setMainPage(String mainPage) {
		this.mainPage = mainPage;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
}