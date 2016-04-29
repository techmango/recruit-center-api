package com.recruitcenter.api.entity;

import java.util.ArrayList;

public class ResumeAllInfo {
	String name = "";
	String pic = "";
	String sex = "";
	String sexId = "";
	String birth = "";
	String workYear = "";
	String workYearId = "";
	String height = "";
	String weight = "";
	String marriage = "";
	String marriageId = "";
	public String getMarriageId() {
		return marriageId;
	}

	public void setMarriageId(String marriageId) {
		this.marriageId = marriageId;
	}

	String education = "";
	String educationId = "";
	public String getSexId() {
		return sexId;
	}

	public void setSexId(String sexId) {
		this.sexId = sexId;
	}

	public String getWorkYearId() {
		return workYearId;
	}

	public void setWorkYearId(String workYearId) {
		this.workYearId = workYearId;
	}

	public String getEducationId() {
		return educationId;
	}

	public void setEducationId(String educationId) {
		this.educationId = educationId;
	}

	String address = "";
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	String nationality = "";

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getWorkYear() {
		return workYear;
	}

	public void setWorkYear(String workYear) {
		this.workYear = workYear;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getMarriage() {
		return marriage;
	}

	public void setMarriage(String marriage) {
		this.marriage = marriage;
	}

	public String getHukou() {
		return hukou;
	}

	public void setHukou(String hukou) {
		this.hukou = hukou;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEvaluate() {
		return evaluate;
	}

	public void setEvaluate(String evaluate) {
		this.evaluate = evaluate;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	String hukou = "";
	String phone = "";
	String email = "";
	String evaluate = "";
	String sname = "";

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public ArrayList<ResumeEducation> getEeList() {
		return eeList;
	}

	public void setEeList(ArrayList<ResumeEducation> eeList) {
		this.eeList = eeList;
	}

	public ArrayList<ResumeExprience> getWeList() {
		return weList;
	}

	public void setWeList(ArrayList<ResumeExprience> weList) {
		this.weList = weList;
	}

	ArrayList<ResumeEducation> eeList = new ArrayList<ResumeEducation>();

	ArrayList<ResumeExprience> weList = new ArrayList<ResumeExprience>();

	String industry = "";
	String industryId = "";
	String job = "";
	String jobId = "";
	String location = "";
	String locationId = "";
	String salary = "";
	String salaryId = "";
	String type = "";
	String typeId = "";
	String arrivalDays = "";
	String arrivalDaysId = "";
	String rname = "";
	
	public String getRname() {
		return rname;
	}

	public void setRname(String rname) {
		this.rname = rname;
	}

	public String getIndustryId() {
		return industryId;
	}

	public void setIndustryId(String industryId) {
		this.industryId = industryId;
	}

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

	public String getSalaryId() {
		return salaryId;
	}

	public void setSalaryId(String salaryId) {
		this.salaryId = salaryId;
	}

	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	public String getArrivalDaysId() {
		return arrivalDaysId;
	}

	public void setArrivalDaysId(String arrivalDaysId) {
		this.arrivalDaysId = arrivalDaysId;
	}

	public String getIsLeaveId() {
		return isLeaveId;
	}

	public void setIsLeaveId(String isLeaveId) {
		this.isLeaveId = isLeaveId;
	}

	String isLeave = "";
	String isLeaveId = "";
	
	public String getIndustry() {
		return industry;
	}
	public void setIndustry(String industry) {
		this.industry = industry;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getArrivalDays() {
		return arrivalDays;
	}
	public void setArrivalDays(String arrivalDays) {
		this.arrivalDays = arrivalDays;
	}
	public String getIsLeave() {
		return isLeave;
	}
	public void setIsLeave(String isLeave) {
		this.isLeave = isLeave;
	}
}
