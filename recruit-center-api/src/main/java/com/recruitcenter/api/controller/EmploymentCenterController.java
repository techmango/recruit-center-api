package com.recruitcenter.api.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.recruitcenter.api.entity.CompanyDetail;
import com.recruitcenter.api.entity.JobDetail;
import com.recruitcenter.api.entity.JobEntity;
import com.recruitcenter.api.entity.output.GlobalBaseGenericInfo;
import com.recruitcenter.api.entity.output.KeyValuePair;
import com.recruitcenter.api.entity.output.KeyValueTree;
import com.recruitcenter.api.utils.Common;
import com.recruitcenter.api.utils.EmployDictionary;
import com.recruitcenter.api.utils.ListPageUtils;

@Controller
@RequestMapping("/base/")
public class EmploymentCenterController extends BaseController {
	Log log = LogFactory.getLog(this.getClass());
	
	@RequestMapping(value="getJobList", method=RequestMethod.GET)
	@ResponseBody
	public GlobalBaseGenericInfo<JobEntity> getJobList(int page, int size) {
		GlobalBaseGenericInfo<JobEntity> info = new GlobalBaseGenericInfo<JobEntity>();
		
		try {
			JSONArray result = Common.getJArrayByGet("http://www.daijun.com/webs/zwlb.php?shu=500");
			if(result != null && result.size() > 0) {
				ArrayList<JobEntity> filterList = new ArrayList<JobEntity>();
				for(Object j : result.toArray()) {
					 JSONObject jsonObj = (JSONObject) j;
					 JobEntity job = new JobEntity();
					 job.setId(jsonObj.getString("gid"));
					 job.setName(jsonObj.getString("岗位名称"));
					 job.setLocation(jsonObj.getString("工作地点"));
					 job.setTime(jsonObj.getString("发布时间"));
					 job.setCompanyId(jsonObj.getString("uid"));
					 job.setCompany(jsonObj.getString("企业名称"));
					 job.setDegree(jsonObj.getString("学历要求"));
					 job.setSalary(jsonObj.getString("薪资水平"));
					 filterList.add(job);
				}
				
				List<JobEntity> subList = ListPageUtils.page((page - 1) * size, 
						(page - 1) * size + size, filterList);
				
				for(JobEntity job : subList) {
					info.getData().add(job);
				}
			}
			info.setResult(Common.SUCCESS_TAG);
		}
		catch(Exception ex) {
			log.error("获取天涯人力职位列表异常", ex);
			info.setResult(Common.FAILURE_TAG);
			info.setError(ex.toString());
		}
		
		return info;
	}

	@RequestMapping(value="searchJobList", method=RequestMethod.POST)
	@ResponseBody
	public GlobalBaseGenericInfo<JobEntity> searchJobList(String key, String location, String industry, String position, 
			String salary, String degree, String experience, String type, String time, int page, int size) {
		
		key = key == null ? "" : key;
		location = location == null ? "" : location;
		industry = industry == null ? "" : industry;
		position = position == null ? "" : position;
		salary = salary == null ? "" : salary;
		degree = degree == null ? "" : degree;
		experience = experience == null ? "" : experience;
		type = type == null ? "" : type;
		time = time == null ? "" : time;
		
		GlobalBaseGenericInfo<JobEntity> info = new GlobalBaseGenericInfo<JobEntity>();
		
		try {
			JSONArray result = Common.getJArrayByGet(
					String.format("http://www.daijun.com/webs/zwlb.php?key=%s&location=%s&industry=%s&position=%s&salary=%s&degree=%s&experience=%s&type=%s&time=%s", 
					key, location, industry, position, salary, degree, experience, type, time));
			if(result != null && result.size() > 0) {
				ArrayList<JobEntity> filterList = new ArrayList<JobEntity>();
				for(Object j : result.toArray()) {
					 JSONObject jsonObj = (JSONObject) j;
					 JobEntity job = new JobEntity();
					 job.setId(jsonObj.getString("gid"));
					 job.setName(jsonObj.getString("岗位名称"));
					 job.setLocation(jsonObj.getString("工作地点"));
					 job.setTime(jsonObj.getString("发布时间"));
					 job.setCompanyId(jsonObj.getString("uid"));
					 job.setCompany(jsonObj.getString("企业名称"));
					 job.setDegree(jsonObj.getString("学历要求"));
					 job.setSalary(jsonObj.getString("薪资水平"));
					 filterList.add(job);
				}
				
				List<JobEntity> subList = ListPageUtils.page((page - 1) * size, 
						(page - 1) * size + size, filterList);
				
				for(JobEntity job : subList) {
					info.getData().add(job);
				}
			}
			info.setResult(Common.SUCCESS_TAG);
		}
		catch(Exception ex) {
			log.error("搜索天涯人力职位列表异常", ex);
			info.setResult(Common.FAILURE_TAG);
			info.setError(ex.toString());
		}
		return info;
	}
	
	@RequestMapping(value="getJobDetail", method=RequestMethod.GET)
	@ResponseBody
	public GlobalBaseGenericInfo<JobDetail> getJobDetail(String id) {
		GlobalBaseGenericInfo<JobDetail> info = new GlobalBaseGenericInfo<JobDetail>();
		try {
			JSONArray result = Common.getJArrayByGet(String.format("http://www.daijun.com/webs/zwxx.php?id=%s", id));
			if(result != null && result.size() > 0) {
				for(Object j : result.toArray()) {
					 JSONObject jsonObj = (JSONObject) j;
					 JobDetail obj = new JobDetail();
					 obj.setId(jsonObj.getString("uid"));
					 obj.setName(jsonObj.getString("岗位名称"));
					 obj.setCompanyId(jsonObj.getString("uid"));
					 obj.setCompany(jsonObj.getString("企业名称"));
					 obj.setSalary(jsonObj.getString("薪资水平"));
					 obj.setDegree(jsonObj.getString("教育程度"));
					 obj.setLocation(jsonObj.getString("工作地点"));
					 obj.setTime(jsonObj.getString("更新时间"));
					 obj.setExperience(jsonObj.getString("工作经验"));
					 obj.setAddress(jsonObj.getString("企业地址"));
					 obj.setNum(jsonObj.getString("招聘人数"));
					 obj.setType(jsonObj.getString("工作性质"));
					 obj.setDescription(jsonObj.getString("岗位描述"));
					 obj.setTel(jsonObj.getString("联系方式"));
					 info.getData().add(obj);
				}
			}
			info.setResult(Common.SUCCESS_TAG);
		}
		catch(Exception ex) {
			log.error("搜索天涯人力职位详情异常", ex);
			info.setResult(Common.FAILURE_TAG);
			info.setError(ex.toString());
		}
		return info;
	}
	
	
	@RequestMapping(value="getIndustryList", method=RequestMethod.GET)
	@ResponseBody
	public GlobalBaseGenericInfo<KeyValuePair> getIndustryList() {
		GlobalBaseGenericInfo<KeyValuePair> info = new GlobalBaseGenericInfo<KeyValuePair>();
		try {
			JSONArray result = Common.getJArrayByGet("http://www.daijun.com/webs/industry.php");
			if(result != null && result.size() > 0) {
				for(Object j : result.toArray()) {
					 JSONObject jsonObj = (JSONObject) j;
					 KeyValuePair obj = new KeyValuePair();
					 obj.setId(jsonObj.getString("id"));
					 obj.setName(jsonObj.getString("name"));
					 info.getData().add(obj);
				}
			}
			info.setResult(Common.SUCCESS_TAG);
		}
		catch(Exception ex) {
			log.error("搜索天涯人力行业类别列表异常", ex);
			info.setResult(Common.FAILURE_TAG);
			info.setError(ex.toString());
		}
		return info;
	}
	
	@RequestMapping(value="getJobClassList", method=RequestMethod.GET)
	@ResponseBody
	public GlobalBaseGenericInfo<KeyValueTree> getJobClassList() {
		GlobalBaseGenericInfo<KeyValueTree> info = new GlobalBaseGenericInfo<KeyValueTree>();
		try {
			JSONArray result = Common.getJArrayByGet("http://www.daijun.com/webs/jobclass.php");
			if(result != null && result.size() > 0) {
				for(Object j : result.toArray()) {
					 JSONObject jsonObj = (JSONObject) j;
					 KeyValueTree obj = new KeyValueTree();
					 obj.setId(jsonObj.getString("id"));
					 obj.setName(jsonObj.getString("name"));
					 if(jsonObj.getString("next") != null) {
						 obj.setNext(new ArrayList<KeyValueTree>());
						 recursionChild(jsonObj, obj.getNext());
					 }
					 info.getData().add(obj);
				}
			}
			info.setResult(Common.SUCCESS_TAG);
		}
		catch(Exception ex) {
			log.error("搜索天涯人力职位类别列表异常", ex);
			info.setResult(Common.FAILURE_TAG);
			info.setError(ex.toString());
		}
		return info;
	}

	private void recursionChild(JSONObject parentJsonObj, ArrayList<KeyValueTree> next) {
		JSONArray children = parentJsonObj.getJSONArray("next");
		for(Object j : children.toArray()) {
			JSONObject childJsonObj = (JSONObject) j;
			KeyValueTree obj = new KeyValueTree();
			 obj.setId(childJsonObj.getString("id"));
			 obj.setName(childJsonObj.getString("name"));
			 next.add(obj);
			 if(childJsonObj.getString("next") != null) {
				 obj.setNext(new ArrayList<KeyValueTree>());
				 recursionChild(childJsonObj, obj.getNext());
			 }
		}
	}
	
	@RequestMapping(value="getSalaryReqList", method=RequestMethod.GET)
	@ResponseBody
	public GlobalBaseGenericInfo<KeyValuePair> getSalaryReqList() {
		return getComClass("34", "获取天涯人力薪资要求列表");
	}
	
	@RequestMapping(value="getCityList", method=RequestMethod.GET)
	@ResponseBody
	public GlobalBaseGenericInfo<KeyValuePair> getCityList() {
		return getDic(EmployDictionary.city, "获取天涯人力工作地点列表");
	}
	
	@RequestMapping(value="getEducationList", method=RequestMethod.GET)
	@ResponseBody
	public GlobalBaseGenericInfo<KeyValuePair> getEducationList() {
		return getComClass("38", "获取天涯人力学历水平列表");
	}
	
	@RequestMapping(value="getExperienceList", method=RequestMethod.GET)
	@ResponseBody
	public GlobalBaseGenericInfo<KeyValuePair> getExperienceList() {
		return getComClass("10", "获取天涯人力工作经验列表");
	}
	
	@RequestMapping(value="getJobTypeList", method=RequestMethod.GET)
	@ResponseBody
	public GlobalBaseGenericInfo<KeyValuePair> getJobTypeList() {
		return getComClass("35", "获取天涯人力职位类型列表");
	}
	
	@RequestMapping(value="getPeriodList", method=RequestMethod.GET)
	@ResponseBody
	public GlobalBaseGenericInfo<KeyValuePair> getPeriodList() {
		return getDic(EmployDictionary.period, "获取天涯人力发布时间列表");
	}
	
	@RequestMapping(value="getMaritalStatus", method=RequestMethod.GET)
	@ResponseBody
	public GlobalBaseGenericInfo<KeyValuePair> getMaritalStatus() {
		return getDic(EmployDictionary.maritalStatus, "获取天涯人力婚姻状况列表");
	}
	
	@RequestMapping(value="getSexList", method=RequestMethod.GET)
	@ResponseBody
	public GlobalBaseGenericInfo<KeyValuePair> getSexList() {
		return getDic(EmployDictionary.sexList, "获取天涯人力性别列表");
	}
	
	@RequestMapping(value="getArrivalDays", method=RequestMethod.GET)
	@ResponseBody
	public GlobalBaseGenericInfo<KeyValuePair> getArrivalDays() {
		return getComClass("36", "获取天涯人力到岗时间列表");
	}
	
	@RequestMapping(value="getCompanyInfo", method=RequestMethod.GET)
	@ResponseBody
	public GlobalBaseGenericInfo<CompanyDetail> getCompanyInfo(String id) {
		GlobalBaseGenericInfo<CompanyDetail> info = new GlobalBaseGenericInfo<CompanyDetail>();
		try {
			JSONArray result = Common.getJArrayByGet(String.format("http://www.daijun.com/webs/gsxx.php?uid=%s", id));
			if(result != null && result.size() > 0) {
				for(Object j : result.toArray()) {
					 JSONObject jsonObj = (JSONObject) j;
					 CompanyDetail obj = new CompanyDetail();
					 obj.setId(id);
					 obj.setName(jsonObj.getString("企业名称"));
					 obj.setIndustry(jsonObj.getString("从事行业"));
					 obj.setType(jsonObj.getString("企业性质"));
					 obj.setSize(jsonObj.getString("企业规模"));
					 obj.setContact(jsonObj.getString("联系人"));
					 obj.setTel(jsonObj.getString("手机"));
					 obj.setEmail(jsonObj.getString("联系邮箱"));
					 obj.setAddress(jsonObj.getString("企业地址"));
					 obj.setDescription(jsonObj.getString("企业简介"));
					 info.getData().add(obj);
				}
			}
			info.setResult(Common.SUCCESS_TAG);
		}
		catch(Exception ex) {
			log.error("搜索天涯人力职位详情异常", ex);
			info.setResult(Common.FAILURE_TAG);
			info.setError(ex.toString());
		}
		return info;
	}

	private GlobalBaseGenericInfo<KeyValuePair> getDic(Map<String, String> dic, String category) {
		GlobalBaseGenericInfo<KeyValuePair> info = new GlobalBaseGenericInfo<KeyValuePair>();
		try {
			for(String key : dic.keySet()) {
				 KeyValuePair obj = new KeyValuePair();
				 obj.setId(key);
				 obj.setName(dic.get(key));
				 info.getData().add(obj);
			}
			info.setResult(Common.SUCCESS_TAG);
		}
		catch(Exception ex) {
			log.error(String.format("%s异常", category), ex);
			info.setResult(Common.FAILURE_TAG);
			info.setError(ex.toString());
		}
		return info;
	}
	
	private GlobalBaseGenericInfo<KeyValuePair> getComClass(String keyId, String category) {
		GlobalBaseGenericInfo<KeyValuePair> info = new GlobalBaseGenericInfo<KeyValuePair>();
		try {
			JSONArray result = Common.getJArrayByGet(String.format("http://www.daijun.com/webs/comclass.php?keyid=%s", keyId));
			if(result != null && result.size() > 0) {
				for(Object j : result.toArray()) {
					 JSONObject jsonObj = (JSONObject) j;
					 KeyValuePair obj = new KeyValuePair();
					 obj.setId(jsonObj.getString("id"));
					 obj.setName(jsonObj.getString("name"));
					 info.getData().add(obj);
				}
			}
			info.setResult(Common.SUCCESS_TAG);
		}
		catch(Exception ex) {
			log.error(String.format("%s异常", category), ex);
			info.setResult(Common.FAILURE_TAG);
			info.setError(ex.toString());
		}
		return info;
	}
}
