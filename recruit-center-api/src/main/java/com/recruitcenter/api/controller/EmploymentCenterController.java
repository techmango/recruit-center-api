package com.recruitcenter.api.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.tomcat.util.http.fileupload.DiskFileUpload;
import org.apache.tomcat.util.http.fileupload.FileItem;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.util.Base64;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.recruitcenter.api.entity.CompanyDetail;
import com.recruitcenter.api.entity.JobDetail;
import com.recruitcenter.api.entity.JobEntity;
import com.recruitcenter.api.entity.ResumeAllInfo;
import com.recruitcenter.api.entity.ResumeBaseInfo;
import com.recruitcenter.api.entity.ResumeEducation;
import com.recruitcenter.api.entity.ResumeExpectInfo;
import com.recruitcenter.api.entity.ResumeExprience;
import com.recruitcenter.api.entity.UserInfo;
import com.recruitcenter.api.entity.output.GlobalBaseGenericArray;
import com.recruitcenter.api.entity.output.GlobalBaseGenericEntity;
import com.recruitcenter.api.entity.output.GlobalBaseInfo;
import com.recruitcenter.api.entity.output.KeyValuePair;
import com.recruitcenter.api.entity.output.KeyValueTree;
import com.recruitcenter.api.utils.Common;
import com.recruitcenter.api.utils.EmployDictionary;
import com.recruitcenter.api.utils.ListPageUtils;
import com.recruitcenter.api.utils.Md5Tool;

@Controller
@RequestMapping("/base/")
public class EmploymentCenterController extends BaseController {
	Log log = LogFactory.getLog(this.getClass());
	
	@RequestMapping(value="getJobList", method=RequestMethod.GET)
	@ResponseBody
	public GlobalBaseGenericArray<JobEntity> getJobList(int page, int size) {
		GlobalBaseGenericArray<JobEntity> info = new GlobalBaseGenericArray<JobEntity>();
		
		try {
			JSONArray result = Common.getJArrayByGet(String.format("http://www.daijun.com/webs/zwlb.php?page=%s&size=%s", page, size));
			if(result != null && result.size() > 0) {
				//ArrayList<JobEntity> filterList = new ArrayList<JobEntity>();
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
					 //filterList.add(job);
					 info.getData().add(job);
				}
				
//				List<JobEntity> subList = ListPageUtils.page((page - 1) * size, 
//						(page - 1) * size + size, filterList);
//				
//				for(JobEntity job : subList) {
//					info.getData().add(job);
//				}
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

	@RequestMapping(value="searchJobList", method=RequestMethod.GET)
	@ResponseBody
	public GlobalBaseGenericArray<JobEntity> searchJobList(String key, String location, String industry, String position, 
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
		
		GlobalBaseGenericArray<JobEntity> info = new GlobalBaseGenericArray<JobEntity>();
		
		try {
			String searchUrl = String.format("http://www.daijun.com/webs/zwlb.php?key=%s&location=%s&industry=%s&position=%s&salary=%s&degree=%s&experience=%s&type=%s&time=%s&page=%s&size=%s", 
					key, location, industry, position, salary, degree, experience, type, time, page, size);
			log.info(searchUrl);
			JSONArray result = Common.getJArrayByGet(searchUrl);
			if(result != null && result.size() > 0) {
				//ArrayList<JobEntity> filterList = new ArrayList<JobEntity>();
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
					 //filterList.add(job);
					 info.getData().add(job);
				}
				
//				List<JobEntity> subList = ListPageUtils.page((page - 1) * size, 
//						(page - 1) * size + size, filterList);
//				
//				for(JobEntity job : subList) {
//					info.getData().add(job);
//				}
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
	public GlobalBaseGenericArray<JobDetail> getJobDetail(String id) {
		GlobalBaseGenericArray<JobDetail> info = new GlobalBaseGenericArray<JobDetail>();
		try {
			JSONArray result = Common.getJArrayByGet(String.format("http://www.daijun.com/webs/zwxx.php?id=%s", id));
			if(result != null && result.size() > 0) {
				for(Object j : result.toArray()) {
					 JSONObject jsonObj = (JSONObject) j;
					 JobDetail obj = new JobDetail();
					 obj.setId(jsonObj.getString("gid"));
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
					 obj.setTel(jsonObj.getString("手机"));
					 obj.setEmail(jsonObj.getString("邮箱"));
					 obj.setContact(jsonObj.getString("联系人"));
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
	public GlobalBaseGenericArray<KeyValuePair> getIndustryList(String flag) {
		GlobalBaseGenericArray<KeyValuePair> info = new GlobalBaseGenericArray<KeyValuePair>();
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
			if(flag != null && flag.equals("1") == true) {
				KeyValuePair e = new KeyValuePair();
				e.setId("");
				e.setName("不限");
				info.getData().add(0, e);
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
	public GlobalBaseGenericArray<KeyValueTree> getJobClassList(String flag) {
		GlobalBaseGenericArray<KeyValueTree> info = new GlobalBaseGenericArray<KeyValueTree>();
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
			if(flag != null && flag.equals("1") == true) {
				KeyValueTree e = new KeyValueTree();
				e.setId("");
				e.setName("不限");
				info.getData().add(0, e);
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
	public GlobalBaseGenericArray<KeyValuePair> getSalaryReqList(String flag) {
		if((flag != null && flag.equals("1") == true) || flag == null)
		{
			GlobalBaseGenericArray<KeyValuePair> ret = getComClass("34","获取天涯人力薪资要求列表", flag);
			KeyValuePair e = new KeyValuePair();
			e.setId("");
			e.setName("不限");
			ret.getData().add(0, e);
			return ret;
		}
		else
			return getUserClass("29", "获取天涯人力薪资要求列表", flag);
	}
	
	@RequestMapping(value="getCityList", method=RequestMethod.GET)
	@ResponseBody
	public GlobalBaseGenericArray<KeyValuePair> getCityList(String flag) {
		return getDic(EmployDictionary.city, "获取天涯人力工作地点列表", flag);
	}
	
	@RequestMapping(value="getEducationList", method=RequestMethod.GET)
	@ResponseBody
	public GlobalBaseGenericArray<KeyValuePair> getEducationList(String flag) {
		if((flag != null && flag.equals("1") == true) || flag == null)
			return getComClass("38","获取天涯人力学历水平列表", flag);
		else
			return getUserClass("3", "获取天涯人力学历水平列表", flag);
	}
	
	@RequestMapping(value="getExperienceList", method=RequestMethod.GET)
	@ResponseBody
	public GlobalBaseGenericArray<KeyValuePair> getExperienceList(String flag) {
		if((flag != null && flag.equals("1") == true) || flag == null) {
			GlobalBaseGenericArray<KeyValuePair> ret = getComClass("10","获取天涯人力工作经验列表", flag);
			KeyValuePair e = new KeyValuePair();
			e.setId("");
			e.setName("不限");
			ret.getData().add( 0,e);
			return ret;
		}
		else
			return getUserClass("4", "获取天涯人力工作经验列表", "");
	}
	
	@RequestMapping(value="getJobTypeList", method=RequestMethod.GET)
	@ResponseBody
	public GlobalBaseGenericArray<KeyValuePair> getJobTypeList(String flag) {
		if((flag != null && flag.equals("1") == true) || flag == null)
			return getComClass("35","获取天涯人力职位类型列表", flag);
		else
			return getUserClass("56", "获取天涯人力职位类型列表", flag);
	}
	
	@RequestMapping(value="getPeriodList", method=RequestMethod.GET)
	@ResponseBody
	public GlobalBaseGenericArray<KeyValuePair> getPeriodList(String flag) {
		return getDic(EmployDictionary.period, "获取天涯人力发布时间列表", flag);
	}
	
	@RequestMapping(value="getMaritalStatus", method=RequestMethod.GET)
	@ResponseBody
	public GlobalBaseGenericArray<KeyValuePair> getMaritalStatus(String flag) {
		return getDic(EmployDictionary.maritalStatus, "获取天涯人力婚姻状况列表", flag);
	}
	
	@RequestMapping(value="getSexList", method=RequestMethod.GET)
	@ResponseBody
	public GlobalBaseGenericArray<KeyValuePair> getSexList(String flag) {
		return getDic(EmployDictionary.sexList, "获取天涯人力性别列表", flag);
	}
	
	@RequestMapping(value="getArrivalDays", method=RequestMethod.GET)
	@ResponseBody
	public GlobalBaseGenericArray<KeyValuePair> getArrivalDays(String flag) {
		return getUserClass("44", "获取天涯人力到岗时间列表", flag);
	}
	
	@RequestMapping(value="getCompanyInfo", method=RequestMethod.GET)
	@ResponseBody
	public GlobalBaseGenericArray<CompanyDetail> getCompanyInfo(String id) {
		GlobalBaseGenericArray<CompanyDetail> info = new GlobalBaseGenericArray<CompanyDetail>();
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
					 JSONArray jobList = Common.getJArrayByGet(String.format("http://www.daijun.com/webs/gsgwlist.php?uid=%s", id));
					if (jobList != null && jobList.size() > 0) {
						obj.setJob(new ArrayList<JobEntity>());
						for (Object jobObj : jobList.toArray()) {
							JSONObject jsonJob = (JSONObject) jobObj;
							JobEntity job = new JobEntity();
							job.setId(jsonJob.getString("gid"));
							job.setName(jsonJob.getString("岗位名称"));
							job.setLocation(jsonJob.getString("工作地点"));
							job.setTime(jsonJob.getString("发布时间"));
							job.setCompanyId(jsonJob.getString("uid"));
							job.setCompany(jsonJob.getString("企业名称"));
							job.setDegree(jsonJob.getString("教育程度"));
							job.setSalary(jsonJob.getString("薪资水平"));
							obj.getJob().add(job);
						}
					}
					 info.getData().add(obj);
				}
			}
			info.setResult(Common.SUCCESS_TAG);
		}
		catch(Exception ex) {
			log.error("搜索天涯人力企业详情异常", ex);
			info.setResult(Common.FAILURE_TAG);
			info.setError(ex.toString());
		}
		return info;
	}

	private GlobalBaseGenericArray<KeyValuePair> getDic(Map<String, String> dic, String category, String flag) {
		GlobalBaseGenericArray<KeyValuePair> info = new GlobalBaseGenericArray<KeyValuePair>();
		try {
			for(String key : dic.keySet()) {
				 KeyValuePair obj = new KeyValuePair();
				 obj.setId(key);
				 obj.setName(dic.get(key));
				 info.getData().add(obj);
			}
			Collections.sort(info.getData(), new Comparator<KeyValuePair>() {

				@Override
				public int compare(KeyValuePair o1, KeyValuePair o2) {
					return o1.getId().hashCode() - o2.getId().hashCode();
				}
				
			});
			if(flag != null && flag.equals("0") == true) {
				info.getData().remove(0);
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
	
	private GlobalBaseGenericArray<KeyValuePair> getUserClass(String keyId, String category, String flag) {
		GlobalBaseGenericArray<KeyValuePair> info = new GlobalBaseGenericArray<KeyValuePair>();
		try {
			JSONArray result = Common.getJArrayByGet(String.format("http://www.daijun.com/webs/userclass.php?keyid=%s", keyId));
			if(result != null && result.size() > 0) {
				for(Object j : result.toArray()) {
					 JSONObject jsonObj = (JSONObject) j;
					 KeyValuePair obj = new KeyValuePair();
					 obj.setId(jsonObj.getString("id"));
					 obj.setName(jsonObj.getString("name"));
					 info.getData().add(obj);
				}
			}
			Collections.sort(info.getData(), new Comparator<KeyValuePair>() {

				@Override
				public int compare(KeyValuePair o1, KeyValuePair o2) {
					return o1.getId().hashCode() - o2.getId().hashCode();
				}
				
			});
			if(flag != null && flag.equals("0") == true) {
				info.getData().remove(0);
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
	
	private GlobalBaseGenericArray<KeyValuePair> getComClass(String keyId, String category, String flag) {
		GlobalBaseGenericArray<KeyValuePair> info = new GlobalBaseGenericArray<KeyValuePair>();
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
			Collections.sort(info.getData(), new Comparator<KeyValuePair>() {

				@Override
				public int compare(KeyValuePair o1, KeyValuePair o2) {
					return o1.getId().hashCode() - o2.getId().hashCode();
				}
				
			});
			if(flag != null && flag.equals("0") == true) {
				info.getData().remove(0);
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
	
	@RequestMapping(value="regUser", method=RequestMethod.POST)
	@ResponseBody
	public GlobalBaseInfo regUser(int uid, String userName, String password,
			String email, String mobile) {
		GlobalBaseInfo info = new GlobalBaseInfo();
		try {
			Map<String, String> params = new HashMap<String, String>();
			params.put("uid", String.valueOf(uid + 10000000));
			params.put("username", userName);
			params.put("password", password);
			params.put("email", email);
			params.put("mobile", mobile);
			params.put("encode", Md5Tool.md5WithEncode(String.format("%s%s%s", String.valueOf(uid + 10000000), userName, password), "GB2312"));
			
			JSONObject result = Common.getJObjectByPost("http://www.daijun.com/webs/daijun_zhuce.php", params);
			if(result != null && result.size() > 0) {
				if(result.getInteger("code").equals(1) == true) {
					info.setResult(Common.SUCCESS_TAG);
				}
				else {
					info.setResult(Common.FAILURE_TAG);
					info.setError(result.getString("message"));
				}
			}
		}
		catch(Exception ex) {
			log.error("会议注册异常", ex);
			info.setResult(Common.FAILURE_TAG);
			info.setError(ex.toString());
		}
		return info;
	}
			
	
	/**
	 * 申请职位
	 * @param uid
	 * @param jobId
	 * @param companyId
	 * @return
	 */
	@RequestMapping(value="applyJob", method=RequestMethod.POST)
	@ResponseBody
	public GlobalBaseInfo applyJob(int uid, String jobId, String companyId, String password) {
		GlobalBaseInfo info = new GlobalBaseInfo();
		Map<String, String> params = new HashMap<String, String>();
		params.put("uid", String.valueOf(uid + 10000000));
		params.put("job_id", jobId);
		params.put("com_id", companyId);
		params.put("encode", Md5Tool.md5(String.format("%s%s%s", String.valueOf(uid + 10000000), jobId, companyId)));
		
		JSONObject result = Common.getJObjectByPost("http://www.daijun.com/webs/daijun_tdjl.php", params);
		if(result != null && result.size() > 0) {
			if(result.getInteger("code").equals(1) == true) {
				info.setResult(Common.SUCCESS_TAG);
			}
			else {
				info.setResult(Common.FAILURE_TAG);
				info.setError(result.getString("message"));
			}
		}
		return info;
	}
	
	/**
	 * 设置个人资料
	 * @param uid
	 * @param jobId
	 * @param companyId
	 * @return
	 */
	@RequestMapping(value="setResumeBaseInfo", method=RequestMethod.POST)
	@ResponseBody
	public GlobalBaseInfo setResumeBaseInfo(int userId, String name, String sex,
			String birthday, String idcard, String marriage, String height,
			String nationality, String weight, String telphone, String telhome,
			String email, String edu, String exp, String homepage,
			String address, String description, String living, String hukou, String password) {
		
		GlobalBaseInfo info = new GlobalBaseInfo();
		Map<String, String> params = new HashMap<String, String>();
		params.put("uid", String.valueOf(userId + 10000000));
		params.put("namea", name);
		params.put("sex", sex);
		params.put("birthday", birthday);
		params.put("idcard", idcard);
		params.put("marriage", marriage);
		params.put("height", height);
		params.put("nationality", nationality);
		params.put("weight", weight);
		params.put("telphone", telphone);
		params.put("telhome", telhome);
		params.put("email", email);
		params.put("edu", edu);
		params.put("exp", exp);
		params.put("homepage", homepage);
		params.put("address", address);
		params.put("description", description);
		params.put("living", living);
		params.put("domicile", hukou);
		params.put("encode", Md5Tool.md5WithEncode(String.format("%s%s%s", String.valueOf(userId + 10000000), name, sex), "GB2312"));
		try {
			JSONObject result = Common.getJObjectByPost("http://www.daijun.com/webs/daijun_base.php", params);
			if(result != null && result.size() > 0) {
				if(result.getInteger("code").equals(1) == true) {
					info.setResult(Common.SUCCESS_TAG);
				}
				else {
					info.setResult(Common.FAILURE_TAG);
					info.setError(result.getString("message"));
				}
			}
		}
		catch(Exception ex) {
			log.error("设置天涯人力简历个人基本资料异常", ex);
			info.setResult(Common.FAILURE_TAG);
			info.setError(ex.toString());
		}
		return info;
	}
	
	@RequestMapping(value="getResumeInfo", method=RequestMethod.GET)
	@ResponseBody
	public GlobalBaseGenericEntity<ResumeAllInfo> getResumeInfo(int userId, String userName, String password,
			String email, String mobile) {
		
		GlobalBaseGenericEntity<ResumeAllInfo> info = new GlobalBaseGenericEntity<ResumeAllInfo>();
		try {
			GlobalBaseGenericEntity<ResumeBaseInfo> baseInfo = getResumeBaseInfo(userId, userName, password, email,  mobile);
			if(baseInfo.getResult().equals(Common.SUCCESS_TAG) == true) {
				info.setResult(Common.SUCCESS_TAG);
				
				info.setData(new ResumeAllInfo());
				info.getData().setBirth(baseInfo.getData().getBirth());
				info.getData().setEmail(baseInfo.getData().getEmail());
				info.getData().setEvaluate(baseInfo.getData().getEvaluate());
				info.getData().setHeight(baseInfo.getData().getHeight());
				info.getData().setHukou(baseInfo.getData().getHukou());
				info.getData().setName(baseInfo.getData().getName());
				info.getData().setPhone(baseInfo.getData().getTelphone());
				info.getData().setSex(baseInfo.getData().getSex());
				info.getData().setSexId(baseInfo.getData().getSexId());
				info.getData().setWeight(baseInfo.getData().getWeight());
				info.getData().setWorkYear(baseInfo.getData().getWorkYear());
				info.getData().setWorkYearId(baseInfo.getData().getWorkYearId());
				info.getData().setEducation(baseInfo.getData().getEducation());
				info.getData().setEducationId(baseInfo.getData().getEducationId());
				info.getData().setMarriage(baseInfo.getData().getMarriage());
				info.getData().setMarriageId(baseInfo.getData().getMarriageId());
				info.getData().setNationality(baseInfo.getData().getNationality());
				info.getData().setAddress(baseInfo.getData().getAddress());
				
				GlobalBaseGenericArray<ResumeExprience> workInfo = getResumeExprience(userId);
				if(workInfo.getResult().equals(Common.SUCCESS_TAG) == true) {
					for(ResumeExprience j : workInfo.getData()) {
						info.getData().getWeList().add(j);
					}
				}
				
				
				GlobalBaseGenericArray<ResumeEducation> eduInfo = getResumeEducation(userId);
				if(eduInfo.getResult().equals(Common.SUCCESS_TAG) == true) {
					for(ResumeEducation j : eduInfo.getData()) {
						info.getData().getEeList().add(j);
					}
				}
				
				GlobalBaseGenericEntity<ResumeExpectInfo> expectInfo = getResumeExpectInfo(userId);
				if(expectInfo.getResult().equals(Common.SUCCESS_TAG) == true && expectInfo.getData() != null) {
					info.getData().setLocation(expectInfo.getData().getLocation());
					info.getData().setArrivalDays(expectInfo.getData().getArrivalDays());
					info.getData().setSalary(expectInfo.getData().getSalary());
					info.getData().setJob(expectInfo.getData().getJob());
					info.getData().setType(expectInfo.getData().getType());
					info.getData().setIndustry(expectInfo.getData().getIndustry());
					info.getData().setIsLeave(expectInfo.getData().getIsLeave());
					
					info.getData().setLocationId(expectInfo.getData().getLocationId());
					info.getData().setArrivalDaysId(expectInfo.getData().getArrivalDaysId());
					info.getData().setSalaryId(expectInfo.getData().getSalaryId());
					info.getData().setJobId(expectInfo.getData().getJobId());
					info.getData().setTypeId(expectInfo.getData().getTypeId());
					info.getData().setIndustryId(expectInfo.getData().getIndustryId());
					info.getData().setIsLeaveId(expectInfo.getData().getIsLeaveId());
					info.getData().setSname(expectInfo.getData().getName());
					expectInfo.getData().setIsLeave(expectInfo.getData().getIsLeave());
				}
				//获取头像地址
				info.getData().setPic(getPicUrl(userId));
			}
			else {
				info.setResult(Common.FAILURE_TAG);
			}
		}
		catch(Exception ex) {
			log.error("获取天涯人力整个简历异常", ex);
			info.setResult(Common.FAILURE_TAG);
			info.setError(ex.toString());
		}
		return info;
	}
	
	private String getPicUrl(int userId) {
		String picUrl = "";
		
		try {
			userId = userId + 10000000;
			JSONObject result = Common.getJObjectByGet(String.format("http://www.daijun.com/webs/pic.php?uid=%s", userId));
			if(result != null && result.size() > 0) {
				if(result.getString("resume_photo") != null) {
					picUrl = String.format("http://www.daijun.com%s", result.getString("resume_photo").replaceFirst("\\.", ""));
				}
			}
		}
		catch(Exception ex) {
			log.error("获取天涯人力简历头像地址异常", ex);
		}
		return picUrl;
	}
	@RequestMapping(value="getResumeBaseInfo", method=RequestMethod.GET)
	@ResponseBody
	public GlobalBaseGenericEntity<ResumeBaseInfo> getResumeBaseInfo(int userId, String userName, String password,
			String email, String mobile) {
		
		GlobalBaseGenericEntity<ResumeBaseInfo> info = new GlobalBaseGenericEntity<ResumeBaseInfo>();
		try {
			userId = userId + 10000000;
			JSONObject result = Common.getJObjectByGet(String.format("http://www.daijun.com/webs/daijun_base_e.php?uid=%s", userId));
			if(result != null && result.size() > 0) {
				
				info.setData(new ResumeBaseInfo());
				info.getData().setBirth(result.getString("birthday"));
				info.getData().setEducation(result.getString("edu"));
				info.getData().setEducationId(result.getString("eduId"));
				info.getData().setEmail(result.getString("email"));
				info.getData().setEvaluate(result.getString("description"));
				info.getData().setHeight(result.getString("height"));
				info.getData().setHukou(result.getString("domicile"));
				info.getData().setMarriage(result.getString("marriage"));
				info.getData().setMarriageId(result.getString("marriageId"));
				info.getData().setName(result.getString("name"));
				info.getData().setSex(result.getString("sex"));
				info.getData().setSexId(result.getString("sexId"));
				info.getData().setTelphone(result.getString("telphone"));
				info.getData().setWeight(result.getString("weight"));
				info.getData().setWorkYear(result.getString("exp"));
				info.getData().setWorkYearId(result.getString("expId"));
				info.getData().setNationality(result.getString("nationality"));
				info.getData().setAddress(result.getString("living"));
			}
			else {
				//模拟注册, 不管存不存在都去天涯人力注册:)
				userId = userId - 10000000;
				GlobalBaseInfo regInfo = regUser(Integer.valueOf(userId), userName,  password, email,  mobile);
				if(regInfo.getResult().equals(Common.SUCCESS_TAG) == true) {
					log.info(String.format("注册成功, userID:%s, name:%s", userId, userName));
					
					info = getResumeBaseInfo(userId, userName, password, email, mobile);
				}
				else {
					info = new GlobalBaseGenericEntity<ResumeBaseInfo>();
					info.setData(new ResumeBaseInfo());
				}
			}
			info.setResult(Common.SUCCESS_TAG);
		}
		catch(Exception ex) {
			log.error("获取天涯人力简历个人基本资料异常", ex);
			info.setResult(Common.FAILURE_TAG);
			info.setError(ex.toString());
		}
		return info;
	}
	
	@RequestMapping(value="getResumeExprience", method=RequestMethod.GET)
	@ResponseBody
	public GlobalBaseGenericArray<ResumeExprience> getResumeExprience(int userId) {
		GlobalBaseGenericArray<ResumeExprience> info = new GlobalBaseGenericArray<ResumeExprience>();
		try {
			userId  = userId + 10000000;
			JSONArray result = Common.getJArrayByGet(String.format("http://www.daijun.com/webs/daijun_work_list.php?uid=%s", userId));
			if(result != null && result.size() > 0) {
				for(Object j : result.toArray()) {
					JSONObject jsonObj = (JSONObject)j;
					ResumeExprience exp = new ResumeExprience();
					exp.setId(jsonObj.getString("id"));
					exp.setCompany(jsonObj.getString("name"));
					exp.setPosition(jsonObj.getString("title"));
					exp.setDepartment(jsonObj.getString("department"));
					exp.setEntryDate(jsonObj.getString("sdate"));
					exp.setLastDate(jsonObj.getString("edate"));
					exp.setDescription(jsonObj.getString("content"));
					info.getData().add(exp);
				}
			}
			info.setResult(Common.SUCCESS_TAG);
		}
		catch(Exception ex) {
			log.error("获取天涯人力简历工作经验资料异常", ex);
			info.setResult(Common.FAILURE_TAG);
			info.setError(ex.toString());
		}
		return info;
	}
	
	@RequestMapping(value="getResumeEducation", method=RequestMethod.GET)
	@ResponseBody
	public GlobalBaseGenericArray<ResumeEducation> getResumeEducation(int userId) {
		GlobalBaseGenericArray<ResumeEducation> info = new GlobalBaseGenericArray<ResumeEducation>();
		try {
			userId  = userId + 10000000;
			JSONArray result = Common.getJArrayByGet(String.format("http://www.daijun.com/webs/daijun_edu_list.php?uid=%s", userId));
			if(result != null && result.size() > 0) {
				for(Object j : result.toArray()) {
					JSONObject jsonObj = (JSONObject)j;
					ResumeEducation edu = new ResumeEducation();
					edu.setId(jsonObj.getString("id"));
					edu.setDegree(jsonObj.getString("title"));
					edu.setEnrollDate(jsonObj.getString("sdate"));
					edu.setGraduateDate(jsonObj.getString("edate"));
					edu.setMajor(jsonObj.getString("specialty"));
					edu.setSchool(jsonObj.getString("name"));
					edu.setDescription(jsonObj.getString("content"));
					info.getData().add(edu);
				}
				
			}
			info.setResult(Common.SUCCESS_TAG);
		}
		catch(Exception ex) {
			log.error("获取天涯人力简历教育经历资料异常", ex);
			info.setResult(Common.FAILURE_TAG);
			info.setError(ex.toString());
		}
		return info;
	}
	
	@RequestMapping(value="getResumeExpectInfo", method=RequestMethod.GET)
	@ResponseBody
	public GlobalBaseGenericEntity<ResumeExpectInfo> getResumeExpectInfo(int userId) {
		GlobalBaseGenericEntity<ResumeExpectInfo> info = new GlobalBaseGenericEntity<ResumeExpectInfo>();
		try {
			userId  = userId + 10000000;
			JSONObject result = Common.getJObjectByGet(String.format("http://www.daijun.com/webs/daijun_expect_e.php?uid=%s", userId));
			if(result != null && result.size() > 0) {
				info.setData(new ResumeExpectInfo());
				info.getData().setName(result.getString("name"));
				info.getData().setArrivalDays(result.getString("report"));
				info.getData().setIndustry(result.getString("hy"));
				info.getData().setIsLeave(result.getString("sflz"));
				info.getData().setJob(result.getString("job_classid"));
				info.getData().setLocation(result.getString("cityid"));
				info.getData().setSalary(result.getString("salary"));
				info.getData().setType(result.getString("type"));
				
				info.getData().setArrivalDaysId(result.getString("reportId"));
				info.getData().setIndustryId(result.getString("hyId"));
				info.getData().setIsLeaveId(result.getString("sflzId"));
				info.getData().setJobId(result.getString("job_classidId"));
				info.getData().setLocationId(result.getString("cityidId"));
				info.getData().setSalaryId(result.getString("salaryId"));
				info.getData().setTypeId(result.getString("typeId"));
			}
			info.setResult(Common.SUCCESS_TAG);
		}
		catch(Exception ex) {
			log.error("获取天涯人力简历求职意向异常", ex);
			info.setResult(Common.FAILURE_TAG);
			info.setError(ex.toString());
		}
		return info;
	}
	
	@RequestMapping(value="setResumeExpectInfo", method=RequestMethod.POST)
	@ResponseBody
	public GlobalBaseInfo setResumeExpectInfo(int userId, String name, String industry,
			String job, String location, String salary, String type, String report, String sflz, String password) {
		
		GlobalBaseInfo info = new GlobalBaseInfo();
		Map<String, String> params = new HashMap<String, String>();
		params.put("uid", String.valueOf(userId + 10000000));
		params.put("namea", name);
		params.put("hy", industry);
		params.put("job_classid", job);
		params.put("provinceid", "22");
		params.put("cityid", location);
		params.put("three_cityid", "0");
		params.put("salary", salary);
		params.put("type", type);
		params.put("report", report);
		params.put("sflz", sflz);
		params.put("encode", Md5Tool.md5WithEncode(String.format("%s%s%s", String.valueOf(userId + 10000000), name, industry), "GB2312"));
		
		try {
			JSONObject result = Common.getJObjectByPost("http://www.daijun.com/webs/daijun_expect.php", params);
			if(result != null && result.size() > 0) {
				if(result.getInteger("code").equals(1) == true) {
					info.setResult(Common.SUCCESS_TAG);
				}
				else {
					info.setResult(Common.FAILURE_TAG);
					info.setError(result.getString("message"));
				}
			}
		}
		catch(Exception ex) {
			log.error("设置天涯人力简历求职意向异常", ex);
			info.setResult(Common.FAILURE_TAG);
			info.setError(ex.toString());
		}
		return info;
	}
	
	@RequestMapping(value="setResumeExprienceInfo", method=RequestMethod.POST)
	@ResponseBody
	public GlobalBaseInfo setResumeExprienceInfo(String id, int userId, String company,
			String entryDate, String lastDate, String position,
			String industry, String department, String positionDesc, String password) {
		
		GlobalBaseInfo info = new GlobalBaseInfo();
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", id);
		params.put("uid", String.valueOf(userId + 10000000));
		params.put("company", company);
		params.put("entryDate", entryDate);
		params.put("lastDate", lastDate);
		params.put("department", department);
		params.put("position", position);
		params.put("positionDesc", positionDesc);
		params.put("encode", Md5Tool.md5WithEncode(String.format("%s%s%s", String.valueOf(userId + 10000000), company, entryDate), "GB2312"));
		
		try {
			JSONObject result = Common.getJObjectByPost("http://www.daijun.com/webs/daijun_work.php", params);
			if(result != null && result.size() > 0) {
				if(result.getInteger("code").equals(1) == true) {
					info.setResult(Common.SUCCESS_TAG);
				}
				else {
					info.setResult(Common.FAILURE_TAG);
					info.setError(result.getString("message"));
				}
			}
		}
		catch(Exception ex) {
			log.error("设置天涯人力简历工作经验异常", ex);
			info.setResult(Common.FAILURE_TAG);
			info.setError(ex.toString());
		}
		return info;
	}
	
	@RequestMapping(value="setResumeEducationInfo", method=RequestMethod.POST)
	@ResponseBody
	public GlobalBaseInfo setResumeEducationInfo(String id, int userId, String school,
			String enrollDate, String graduateDate, String major, String industry,
			String degree, String description, String password) {
		
		GlobalBaseInfo info = new GlobalBaseInfo();
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", id);
		params.put("uid", String.valueOf(userId + 10000000));
		params.put("school", school);
		params.put("enrollDate", enrollDate);
		params.put("graduateDate", graduateDate);
		params.put("major", major);
		params.put("degree", degree);
		params.put("description", description);
		params.put("encode", Md5Tool.md5WithEncode(String.format("%s%s%s", String.valueOf(userId + 10000000), school, enrollDate), "GB2312"));
		
		try {
			JSONObject result = Common.getJObjectByPost("http://www.daijun.com/webs/daijun_edu.php", params);
			if(result != null && result.size() > 0) {
				if(result.getInteger("code").equals(1) == true) {
					info.setResult(Common.SUCCESS_TAG);
				}
				else {
					info.setResult(Common.FAILURE_TAG);
					info.setError(result.getString("message"));
				}
			}
		}
		catch(Exception ex) {
			log.error("设置天涯人力简历教育经历异常", ex);
			info.setResult(Common.FAILURE_TAG);
			info.setError(ex.toString());
		}
		return info;
	}
	
	@RequestMapping(value="delResumeExprienceInfo", method=RequestMethod.POST)
	@ResponseBody
	public GlobalBaseInfo delResumeExprienceInfo(String id, int userId, String password) {
		
		GlobalBaseInfo info = new GlobalBaseInfo();
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", id);
		params.put("uid", String.valueOf(userId + 10000000));
		params.put("del", "1");
		params.put("encode", Md5Tool.md5(String.format("%s%s%s", id, String.valueOf(userId + 10000000), "1")));
		
		try {
			JSONObject result = Common.getJObjectByPost("http://www.daijun.com/webs/daijun_work.php", params);
			if(result != null && result.size() > 0) {
				if(result.getInteger("code").equals(1) == true) {
					info.setResult(Common.SUCCESS_TAG);
				}
				else {
					info.setResult(Common.FAILURE_TAG);
					info.setError(result.getString("message"));
				}
			}
		}
		catch(Exception ex) {
			log.error("删除天涯人力简历工作经验异常", ex);
			info.setResult(Common.FAILURE_TAG);
			info.setError(ex.toString());
		}
		return info;
	}
	
	
	@RequestMapping(value="delResumeEducationInfo", method=RequestMethod.POST)
	@ResponseBody
	public GlobalBaseInfo delResumeEducationInfo(String id, int userId, String password) {
		
		GlobalBaseInfo info = new GlobalBaseInfo();
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", id);
		params.put("uid", String.valueOf(userId + 10000000));
		params.put("del", "1");
		params.put("encode", Md5Tool.md5(String.format("%s%s%s", id, String.valueOf(userId + 10000000), "1")));
		
		try {
			JSONObject result = Common.getJObjectByPost("http://www.daijun.com/webs/daijun_edu.php", params);
			if(result != null && result.size() > 0) {
				if(result.getInteger("code").equals(1) == true) {
					info.setResult(Common.SUCCESS_TAG);
				}
				else {
					info.setResult(Common.FAILURE_TAG);
					info.setError(result.getString("message"));
				}
			}
		}
		catch(Exception ex) {
			log.error("删除天涯人力简历教育经历异常", ex);
			info.setResult(Common.FAILURE_TAG);
			info.setError(ex.toString());
		}
		return info;
	}
	
	
	@RequestMapping(value="modifyIcon", method=RequestMethod.POST)
	@ResponseBody
	public GlobalBaseInfo modifyIcon(@RequestParam(value="icon",required=false) MultipartFile icon, String userId, 
			 String password, HttpServletRequest request) {
		
		GlobalBaseInfo info = new GlobalBaseInfo();
		Map<String, String> params = new HashMap<String, String>();
		//params.put("uid", String.valueOf(Integer.valueOf(userId) + 10000000));
		
		try {
			byte[] pic = null;
			DiskFileUpload diskFileUpload = new DiskFileUpload();
			List fileItems = diskFileUpload.parseRequest(request);
			Iterator iter = fileItems.iterator();
		    for( ; iter.hasNext(); ) {
		        FileItem fileItem = (FileItem) iter.next();
		        if( fileItem.isFormField() ) {
		            // 当前是一个表单项
		        	if(fileItem.getFieldName().equals("userId") == true) {
		        		userId = fileItem.getString();
		        	}
		        } else {
		            // 当前是一个上传的文件
		        	pic = fileItem.get();
		        }
		    }
			params.put("pic", org.apache.commons.codec.binary.Base64.encodeBase64String(pic));
			params.put("uid", String.valueOf(Integer.valueOf(userId) + 10000000));
			JSONObject result = Common.getJObjectByPost("http://www.daijun.com/webs/daijun_pic.php", params);
			if(result != null && result.size() > 0) {
				if(result.getInteger("code").equals(1) == true) {
					info.setResult(Common.SUCCESS_TAG);
				}
				else {
					info.setResult(Common.FAILURE_TAG);
					info.setError(result.getString("message"));
				}
			}
		}
		catch(Exception ex) {
			log.error("天涯人力上传头像异常", ex);
			info.setResult(Common.FAILURE_TAG);
			info.setError(ex.toString());
		}
		return info;
	}
}
