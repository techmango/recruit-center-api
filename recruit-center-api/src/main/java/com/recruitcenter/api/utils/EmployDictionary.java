package com.recruitcenter.api.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class EmployDictionary {
	public static Map<String, String> city = new TreeMap<String, String>() {
		{
			put("", "不限");
			put("361", "海口");
			put("362", "三亚");
			put("492", "儋州");
			put("493", "文昌");
			put("494", "万宁");
			put("495", "屯昌");
			put("496", "琼中");
			put("497", "琼海");
			put("498", "陵水");
			put("499", "临高");
			put("500", "乐东");
			put("501", "东方");
			put("502", "定安");
			put("503", "澄迈");
			put("504", "昌江");
			put("505", "保亭");
			put("506", "白沙");
			put("507", "五指山");
			put("508", "洋浦");
	        put("510", "三沙");
		}
	};
	
	public static Map<String, String> industry = new TreeMap<String, String>() {
		{
			put("", "不限");
			put("73",	"计算机(IT)类");
			put("74",	"销售类");
			put("75",	"经营/管理类");
			put("76",	"财务/审(统)计类");
			put("77",	"金融/保险/证券类");
			put("78",	"电子通讯/电气(器)类");
			put("79",	"机械(电)/仪表类");
			put("80",	"房地产/建筑施工类");
			put("81",	"公司文职类");
			put("82",	"广告(装潢、包装)设计类");
			put("83",	"文体/教育/培训类");
			put("84",	"卫生医疗/美容保健类");
			put("85",	"化工/制药类");
			put("86",	"宾馆饭店/餐饮旅游类");
			put("87",	"商店/零售服务类");
			put("88",	"行政/人事类");
			put("89",	"技工/普工类");
			put("90",	"客户服务类");
			put("91",	"法律专业人员类");
			put("92",	"汽车");
			put("93",	"其他");
			put("94",	"物业管理");
			put("95",	"策划/公关/推广");
			put("96",	"行政后勤");
			put("97",	"环境科学/环保");
			put("98",	"物流运输");
			put("99",	"装饰装修");
		}
	};
	
	public static Map<String, String> period = new TreeMap<String, String>() {
		{
			put("",		"全部");
			put("1",	"今天");
			put("3",	"最近三天");
			put("7",	"最近一周");
			put("30",	"最近一个月");
		}
	};
	
	public static Map<String, String> maritalStatus = new TreeMap<String, String>() {
		{
			put("72",	"不限");
			put("73",	"已婚");
			put("112",	"未婚");
		}
	};
	
	public static Map<String, String> sexList = new TreeMap<String, String>() {
		{
			put("62",	"不限");
			put("63",	"男");
			put("64",	"女");
		}
	};
}
