package com.recruitcenter.api.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DropDownDataList {
	private static DropDownDataList instance;
	public Map<String, String> Keys = new HashMap<String, String>();
	public Map<String, Map> Values = new HashMap<String, Map>();
	private List<Item> tempList = new ArrayList<Item>();

	class Item {
		public String ParentKey;
		public String SelfKey;
		public String SelfValue;

		Item(String parentKey, String name, String value) {
			ParentKey = parentKey;
			SelfKey = name;
			SelfValue = value;
		}
	}

	@SuppressWarnings("unchecked")
	private DropDownDataList() {
		Keys.put("AAC066", "特殊人员身份");
		Keys.put("AAC005", "民族");
		Keys.put("AAC009", "户口性质");
		Keys.put("AAC011", "学历");
		Keys.put("AAC012", "个人身份");
		Keys.put("AAC014", "专业技术职务等级");
		Keys.put("AAC015", "国家职业资格等级（工人技术等级）");
		Keys.put("AAC017", "婚姻状况");
		Keys.put("AAC020", "行政职务(级别)");
		Keys.put("AAC069", "与户主关系");
		Keys.put("AAC033", "健康状况");
		Keys.put("AAC084", "到龄享受待遇标志");
		Keys.put("AAC060", "生存状态");
		Keys.put("AAC016", "就业状态");
		Keys.put("AAE146", "社会化管理形式");
		Keys.put("AJA004", "农民工标识");
		Keys.put("AAC114", "异地安置人员标识");
		Keys.put("AAC115", "居民医保参保属性");
		Keys.put("AAC117", "企业职工基本养老保险参保标志");
		Keys.put("AAC118", "被征地农民社会保险参保标志");
		Keys.put("AAC008", "人员参保状态");
		Keys.put("AAE140", "险种类型");
		Keys.put("AAB033", "征收方式");
		Keys.put("AAA0401", "缴费档次");
		Keys.put("AAC004", "性别");
		Keys.put("AAD016", "当事人缴费方式");
		Keys.put("AAA028", "当事人缴费类别");
		Keys.put("AAA099", "人员待遇停发\\续发\\终止");
		Keys.put("AAA036", "待遇项目代码");
		Keys.put("AAA085", "定期待遇标志");
		Keys.put("BAZ100", "业务申请状态");
		Keys.put("AAC201", "参加其他险种标识");
		Keys.put("AAA030", "利率类型");
		Keys.put("PSN_CODE", "用户用户类型");
		Keys.put("CAE999", "账户类型");
		Keys.put("AAZ224", "缴费扣款状态");
		Keys.put("AAE142", "通知单类型");
		Keys.put("AAE341", "筹资项目");
		Keys.put("CAE997", "变更类型");
		Keys.put("AAA076", "待遇核定类型");
		Keys.put("AAA079", "拨付方式");
		Keys.put("AAE016", "复核标志");
		Keys.put("AAA080", "异地认证标志");
		Keys.put("AAA094", "待遇领取资格认证结果");
		Keys.put("AAA088", "应付类型");
		Keys.put("AAA158", "财务拨付单据类型");
		Keys.put("AAA119", "账户类型");
		Keys.put("BAZ098", "业务申请类型");
		Keys.put("AAB019", "社会组织机构类型");
		Keys.put("AAE143", "缴费类型");
		Keys.put("AAZ225", "待遇拨付状态");
		Keys.put("AAE117", "待遇回盘标志");
		Keys.put("AAE160", "恢复缴费原因");
		Keys.put("AAA077", "补扣发业务类型");
		Keys.put("AAE160", "中断缴费原因");
		Keys.put("AAE160", "类别");
		Keys.put("AAA078", "补扣发标志");
		Keys.put("AAA097", "个人账户收支类型");
		Keys.put("AAC150", "残疾等级");
		Keys.put("AAD005", "财务实收方式");
		Keys.put("AAE116", "待遇发放状态");
		Keys.put("AAC200", "老农保标识");
		Keys.put("AAE100", "有效标识");
		Keys.put("AAC058", "证件类型");
		Keys.put("AAC149", "残疾类别");
		Keys.put("AAE145", "待遇发放方式");
		Keys.put("AAE078", "缴费到账标志");
		Keys.put("AAA038", "待遇项目统计类别");
		Keys.put("AAC059", "领取人证件类型");
		Keys.put("AIC003", "人员参保关系转出/转入");
		Keys.put("AAE017", "核销标志");
		Keys.put("AAC120", "城乡居民养老保险");
		Keys.put("AAC101", "受理状态");
		Keys.put("TARGET", "在线标志");
		Keys.put("ISREAD", "是否已阅");
		Keys.put("EMERGENCY", "紧急程度");
		Keys.put("AAC121", "放映员标志");
		Keys.put("AAA171", "待遇追回处理类型");
		Keys.put("AAC100", "复核状态");
		Keys.put("AAE160", "类型");
		Keys.put("AAE018", "录入标志");
		Keys.put("AAE035", "终止时间");
		Keys.put("AAC031", "缴费状态");
		Keys.put("ZZZ005", "所属人员");
		Keys.put("BZ", "有效标示");

		tempList.add(new Item("AAA100", "AAA102", "AAA103"));
		tempList.add(new Item("AAE357", "101", "余额不足扣款失败"));
		tempList.add(new Item("AAE357", "102", "人员编号不存在"));
		tempList.add(new Item("AAE357", "103", "银行账号校验失败"));
		tempList.add(new Item("AAE357", "104", "公民身份号码校验失败"));
		tempList.add(new Item("AAE357", "105", "姓名校验失败"));
		tempList.add(new Item("AAE357", "201", "拨付通知编号错误"));
		tempList.add(new Item("AAE357", "202", "统筹区错误"));
		tempList.add(new Item("AAE357", "203", "拨付人员校验失败"));
		tempList.add(new Item("AAE357", "204", "当事人编号与证件号码不匹配"));
		tempList.add(new Item("AAE357", "205", "当事人编号与姓名不匹配"));
		tempList.add(new Item("AAE357", "206", "当事人编号错误"));
		tempList.add(new Item("AAE357", "207", "当事人不存在拨付记录"));
		tempList.add(new Item("AAE357", "208", "个人拨付金额与到账金额不相等"));
		tempList.add(new Item("AAE357", "209", "重复导盘"));
		tempList.add(new Item("AAE357", "210", "银行拨付失败"));
		tempList.add(new Item("AAC066", "2", "非重度残疾"));
		tempList.add(new Item("AAC005", "09", "布依族"));
		tempList.add(new Item("AAC005", "07", "彝族"));
		tempList.add(new Item("AAC005", "05", "维吾尔族"));
		tempList.add(new Item("AAC005", "03", "回族"));
		tempList.add(new Item("AAC005", "51", "独龙族"));
		tempList.add(new Item("AAC005", "49", "京族"));
		tempList.add(new Item("AAC005", "48", "裕固族"));
		tempList.add(new Item("AAC005", "47", "保安族"));
		tempList.add(new Item("AAC005", "46", "德昂族"));
		tempList.add(new Item("AAC005", "44", "俄罗斯族"));
		tempList.add(new Item("AAC005", "38", "锡伯族"));
		tempList.add(new Item("AAC005", "56", "基诺族"));
		tempList.add(new Item("AAC005", "53", "赫哲族"));
		tempList.add(new Item("AAC005", "52", "鄂伦春族"));
		tempList.add(new Item("AAC005", "37", "仡佬族"));
		tempList.add(new Item("AAC005", "35", "撒拉族"));
		tempList.add(new Item("AAC005", "34", "布朗族"));
		tempList.add(new Item("AAC005", "33", "羌族"));
		tempList.add(new Item("AAC005", "32", "仫佬族"));
		tempList.add(new Item("AAC005", "23", "高山族"));
		tempList.add(new Item("AAC005", "43", "乌孜别克族"));
		tempList.add(new Item("AAC005", "42", "怒族"));
		tempList.add(new Item("AAC005", "40", "普米族"));
		tempList.add(new Item("AAC005", "39", "阿昌族"));
		tempList.add(new Item("AAC005", "22", "畲族"));
		tempList.add(new Item("AAC005", "20", "傈傈族"));
		tempList.add(new Item("AAC005", "19", "黎族"));
		tempList.add(new Item("AAC005", "18", "傣族"));
		tempList.add(new Item("AAC005", "16", "哈尼族"));
		tempList.add(new Item("AAC005", "15", "土家族"));
		tempList.add(new Item("AAC005", "30", "土族"));
		tempList.add(new Item("AAC005", "27", "纳西族"));
		tempList.add(new Item("AAC005", "26", "东乡族"));
		tempList.add(new Item("AAC005", "25", "水族"));
		tempList.add(new Item("AAC005", "14", "白族"));
		tempList.add(new Item("AAC005", "12", "侗族"));
		tempList.add(new Item("AAC005", "11", "满族"));
		tempList.add(new Item("AAC005", "99", "其他"));
		tempList.add(new Item("AAC005", "02", "蒙古族"));
		tempList.add(new Item("AAC005", "06", "苗族"));
		tempList.add(new Item("AAC005", "08", "壮族"));
		tempList.add(new Item("AAC005", "55", "珞巴族"));
		tempList.add(new Item("AAC005", "28", "景颇族"));
		tempList.add(new Item("AAC005", "24", "拉祜族"));
		tempList.add(new Item("AAC005", "10", "朝鲜族"));
		tempList.add(new Item("AAC005", "04", "藏族"));
		tempList.add(new Item("AAC005", "50", "塔塔尔族"));
		tempList.add(new Item("AAC005", "45", "鄂温克族"));
		tempList.add(new Item("AAC005", "54", "门巴族"));
		tempList.add(new Item("AAC005", "36", "毛南族"));
		tempList.add(new Item("AAC005", "31", "达翰尔族"));
		tempList.add(new Item("AAC005", "41", "塔吉克族"));
		tempList.add(new Item("AAC005", "21", "佤族"));
		tempList.add(new Item("AAC005", "17", "哈萨克族"));
		tempList.add(new Item("AAC005", "29", "柯尔克孜族"));
		tempList.add(new Item("AAC005", "13", "瑶族"));
		tempList.add(new Item("AAC005", "01", "汉族"));
		tempList.add(new Item("AAC009", "10", "非农业户口（城镇）"));
		tempList.add(new Item("AAC009", "20", "农业户口（农村）"));
		tempList.add(new Item("AAC009", "30", "台港澳人员"));
		tempList.add(new Item("AAC009", "40", "外籍人士"));
		tempList.add(new Item("AAC011", "11", "博士研究生"));
		tempList.add(new Item("AAC011", "12", "硕士研究生"));
		tempList.add(new Item("AAC011", "21", "大学本科"));
		tempList.add(new Item("AAC011", "31", "大学专科"));
		tempList.add(new Item("AAC011", "41", "中等专科"));
		tempList.add(new Item("AAC011", "44", "职业高中"));
		tempList.add(new Item("AAC011", "47", "技工学校"));
		tempList.add(new Item("AAC011", "61", "普通中学"));
		tempList.add(new Item("AAC011", "71", "初级中学"));
		tempList.add(new Item("AAC011", "81", "小学"));
		tempList.add(new Item("AAC011", "90", "其他"));
		tempList.add(new Item("AAC012", "1", "工人"));
		tempList.add(new Item("AAC012", "2", "农民"));
		tempList.add(new Item("AAC012", "3", "学生"));
		tempList.add(new Item("AAC012", "4", "干部"));
		tempList.add(new Item("AAC012", "5", "国家公务员"));
		tempList.add(new Item("AAC012", "6", "现役军人"));
		tempList.add(new Item("AAC012", "7", "无业人员"));
		tempList.add(new Item("AAC012", "9", "其他"));
		tempList.add(new Item("AAC014", "1", "正高级专业技术职务"));
		tempList.add(new Item("AAC014", "2", "副高级专业技术职务"));
		tempList.add(new Item("AAC014", "3", "中级专业技术职务"));
		tempList.add(new Item("AAC014", "4", "初级专业技术职务"));
		tempList.add(new Item("AAC015", "1", "职业资格一级(高级技师)"));
		tempList.add(new Item("AAC015", "2", "职业资格二级(技师）"));
		tempList.add(new Item("AAC015", "3", "职业资格三级(高级)"));
		tempList.add(new Item("AAC015", "4", "职业资格四级(中级)"));
		tempList.add(new Item("AAC015", "5", "职业资格五级（初级）"));
		tempList.add(new Item("AAC017", "1", "未婚"));
		tempList.add(new Item("AAC017", "2", "已婚"));
		tempList.add(new Item("AAC017", "3", "丧偶"));
		tempList.add(new Item("AAC017", "4", "离婚"));
		tempList.add(new Item("AAC017", "9", "未说明的婚姻状况"));
		tempList.add(new Item("AAC020", "030", "部、省级"));
		tempList.add(new Item("AAC020", "040", "副部、副省级"));
		tempList.add(new Item("AAC020", "050", "司、厅级，巡视员"));
		tempList.add(new Item("AAC020", "060", "副司、副厅级，助理巡视员"));
		tempList.add(new Item("AAC020", "070", "处、县级，调研员"));
		tempList.add(new Item("AAC020", "080", "副处、副县级，助理调研员"));
		tempList.add(new Item("AAC020", "090", "科、乡级，主任科员"));
		tempList.add(new Item("AAC020", "100", "副科、副乡级，副主任科员"));
		tempList.add(new Item("AAC020", "110", "科员级"));
		tempList.add(new Item("AAC020", "120", "办事员级"));
		tempList.add(new Item("AAC020", "190", "无行政职务级别"));
		tempList.add(new Item("AAC069", "1", "配偶"));
		tempList.add(new Item("AAC069", "2", "子女"));
		tempList.add(new Item("AAC069", "4", "孙子、孙女或外孙子、外孙女"));
		tempList.add(new Item("AAC069", "5", "父母"));
		tempList.add(new Item("AAC069", "6", "祖父母或外祖父母"));
		tempList.add(new Item("AAC069", "7", "兄、弟、姐、妹"));
		tempList.add(new Item("AAC069", "8", "其他亲属"));
		tempList.add(new Item("AAC069", "9", "非亲属"));
		tempList.add(new Item("AAC069", "0", "户主"));
		tempList.add(new Item("AAC033", "1", "健康或良好"));
		tempList.add(new Item("AAC033", "2", "一般或较弱"));
		tempList.add(new Item("AAC033", "3", "有慢性病"));
		tempList.add(new Item("AAC033", "6", "残疾"));
		tempList.add(new Item("AAC084", "0", "否"));
		tempList.add(new Item("AAC084", "1", "是"));
		tempList.add(new Item("AAC060", "1", "正常"));
		tempList.add(new Item("AAC060", "2", "死亡"));
		tempList.add(new Item("AAC060", "3", "被判刑收监"));
		tempList.add(new Item("AAC060", "4", "失踪"));
		tempList.add(new Item("AAC060", "9", "状态不明"));
		tempList.add(new Item("AAC016", "1", "无业"));
		tempList.add(new Item("AAC016", "2", "在业"));
		tempList.add(new Item("AAC016", "3", "失业"));
		tempList.add(new Item("AAC016", "4", "自谋职业"));
		tempList.add(new Item("AAC016", "5", "退休（离岗）"));
		tempList.add(new Item("AAE146", "1", "社区管理"));
		tempList.add(new Item("AAE146", "2", "社保经办机构管理"));
		tempList.add(new Item("AAE146", "3", "依托企业管理"));
		tempList.add(new Item("AAE146", "9", "其他方式管理"));
		tempList.add(new Item("AJA004", "0", "否"));
		tempList.add(new Item("AJA004", "1", "是"));
		tempList.add(new Item("AAC114", "0", "否"));
		tempList.add(new Item("AAC114", "1", "是"));
		tempList.add(new Item("AAC115", "1", "新参保"));
		tempList.add(new Item("AAC115", "2", "曾经参保"));
		tempList.add(new Item("AAC115", "3", "连续参保"));
		tempList.add(new Item("AAC117", "0", "否"));
		tempList.add(new Item("AAC117", "1", "是"));
		tempList.add(new Item("AAC118", "0", "否"));
		tempList.add(new Item("AAC118", "1", "是"));
		tempList.add(new Item("AAC008", "1", "正常参保"));
		tempList.add(new Item("AAC008", "4", "终止参保"));
		tempList.add(new Item("AAC008", "11", "在职"));
		tempList.add(new Item("AAC008", "21", "退休"));
		tempList.add(new Item("AAE140", "1", "养老保险"));
		tempList.add(new Item("AAE140", "2", "失业保险"));
		tempList.add(new Item("AAE140", "3", "医疗保险"));
		tempList.add(new Item("AAE140", "33", "养老保险"));
		tempList.add(new Item("AAE140", "4", "工伤保险"));
		tempList.add(new Item("AAE140", "5", "生育保险"));
		tempList.add(new Item("AAE140", "6", "公务员补助"));
		tempList.add(new Item("AAE140", "11", "养老保险"));
		tempList.add(new Item("AAE140", "12", "养老保险"));
		tempList.add(new Item("AAE140", "21", "失业保险"));
		tempList.add(new Item("AAE140", "31", "医疗保险"));
		tempList.add(new Item("AAE140", "41", "工伤保险"));
		tempList.add(new Item("AAE140", "51", "生育保险"));
		tempList.add(new Item("AAE140", "110", "养老保险"));
		tempList.add(new Item("AAE140", "120", "养老保险"));
		tempList.add(new Item("AAE140", "210", "失业保险"));
		tempList.add(new Item("AAE140", "310", "医疗保险"));
		tempList.add(new Item("AAE140", "320", "公务员医疗补助"));
		tempList.add(new Item("AAE140", "340", "离休人员医疗保障"));
		tempList.add(new Item("AAE140", "391", "城镇居民基本医疗保险"));
		tempList.add(new Item("AAE140", "410", "工伤保险"));
		tempList.add(new Item("AAE140", "510", "生育保险"));
		tempList.add(new Item("AAE140", "33", "公务员补助医疗"));
		tempList.add(new Item("AAE140", "150", "农业户口"));
		tempList.add(new Item("AAE140", "160", "非农业户口"));
		tempList.add(new Item("AAB033", "1", "银行处理"));
		tempList.add(new Item("AAB033", "3", "经办机构自收"));
		tempList.add(new Item("AAA0401", "100", "档次100"));
		tempList.add(new Item("AAA0401", "200", "档次200"));
		tempList.add(new Item("AAA0401", "300", "档次300"));
		tempList.add(new Item("AAA0401", "400", "档次400"));
		tempList.add(new Item("AAA0401", "500", "档次500"));
		tempList.add(new Item("AAA0401", "800", "档次800"));
		tempList.add(new Item("AAA0401", "1000", "档次1000"));
		tempList.add(new Item("AAC004", "1", "男"));
		tempList.add(new Item("AAC004", "2", "女"));
		tempList.add(new Item("AAC004", "9", "未说明性别"));
		tempList.add(new Item("AAD016", "6", "社区代收"));
		tempList.add(new Item("AAA028", "3", "家庭"));
		tempList.add(new Item("AAA028", "2", "人员"));
		tempList.add(new Item("AAA028", "1", "组织"));
		tempList.add(new Item("AAA099", "3", "终止"));
		tempList.add(new Item("AAA099", "2", "续发"));
		tempList.add(new Item("AAA099", "1", "停发"));
		tempList.add(new Item("AAA036", "150011", "基础养老金"));
		tempList.add(new Item("AAA036", "150012", "个人账户养老金"));
		tempList.add(new Item("AAD016", "4", "社保财务窗口缴费"));
		tempList.add(new Item("AAD016", "3", "税务征收"));
		tempList.add(new Item("AAD016", "2", "银行缴费"));
		tempList.add(new Item("AAD016", "1", "银行账户扣款"));
		tempList.add(new Item("AAD016", "5", "学校代收"));
		tempList.add(new Item("AAA036", "150013", "加发基础养老金"));
		tempList.add(new Item("AAA085", "1", "是"));
		tempList.add(new Item("AAA085", "0", "否"));
		tempList.add(new Item("BAZ100", "5", "复核通过"));
		tempList.add(new Item("BAZ100", "2", "复核不通过"));
		tempList.add(new Item("BAZ100", "1", "未复核(申请)"));
		tempList.add(new Item("AAF019", "1", "村委会"));
		tempList.add(new Item("AAF019", "0", "社区"));
		tempList.add(new Item("AAC201", "1", "是"));
		tempList.add(new Item("AAC201", "0", "否"));
		tempList.add(new Item("AAA030", "90", "社保记账利率"));
		tempList.add(new Item("AAA030", "11", "活期利率"));
		tempList.add(new Item("AAA030", "21", "三个月定期利率"));
		tempList.add(new Item("AAA030", "22", "六个月定期利率"));
		tempList.add(new Item("AAA030", "24", "一年期定期利率"));
		tempList.add(new Item("AAA030", "25", "二年期定期利率"));
		tempList.add(new Item("AAA030", "26", "三年期定期利率"));
		tempList.add(new Item("AAA030", "27", "五年期定期利率"));
		tempList.add(new Item("AAA030", "31", "三个月零存整取利率"));
		tempList.add(new Item("AAA030", "32", "六个月零存整取利率"));
		tempList.add(new Item("AAA030", "33", "九个月零存整取利率"));
		tempList.add(new Item("AAA030", "34", "一年期零存整取利率"));
		tempList.add(new Item("AAA030", "37", "五年期零存整取利率"));
		tempList.add(new Item("AAA030", "38", "十年期零存整取利率"));
		tempList.add(new Item("AAA030", "23", "九个月定期利率"));
		tempList.add(new Item("AAA030", "28", "十年期定期利率"));
		tempList.add(new Item("AAA030", "35", "二年期零存整取利率"));
		tempList.add(new Item("PSN_COD", "E0", "省级用户"));
		tempList.add(new Item("PSN_COD", "E1", "县级用户"));
		tempList.add(new Item("PSN_COD", "E2", "镇级用户"));
		tempList.add(new Item("PSN_COD", "E3", "村级用户"));
		tempList.add(new Item("CAE999", "1", "征缴账户"));
		tempList.add(new Item("CAE999", "2", "待遇账户"));
		tempList.add(new Item("CAE999", "3", "综合账户"));
		tempList.add(new Item("AAZ224", "1", "待处理"));
		tempList.add(new Item("AAZ224", "2", "在途"));
		tempList.add(new Item("AAZ224", "3", "成功"));
		tempList.add(new Item("AAZ224", "4", "失败"));
		tempList.add(new Item("AAE142", "8", "县财政缴费通知单"));
		tempList.add(new Item("AAE142", "5", "中央财政缴费通知单"));
		tempList.add(new Item("AAE142", "4", "个人零星缴费通知单"));
		tempList.add(new Item("AAE142", "3", "集体零星缴费通知单"));
		tempList.add(new Item("AAE142", "2", "银行集体征收通知单"));
		tempList.add(new Item("AAE142", "1", "银行个人征收通知单"));
		tempList.add(new Item("AAE142", "7", "市财政缴费通知单"));
		tempList.add(new Item("AAE142", "6", "省财政缴费通知单"));
		tempList.add(new Item("AAE341", "1", "个人缴费"));
		tempList.add(new Item("AAE341", "10", "特殊身份省级财政补贴"));
		tempList.add(new Item("AAE341", "11", "特殊身份市级财政补贴"));
		tempList.add(new Item("AAE341", "12", "特殊身份县级财政补贴"));
		tempList.add(new Item("AAE341", "13", "特殊身份集体补助"));
		tempList.add(new Item("AAE341", "2", "中央财政补贴"));
		tempList.add(new Item("CAE997", "25", "在职转退休"));
		tempList.add(new Item("CAE997", "24", "统筹范围内转出"));
		tempList.add(new Item("CAE997", "23", "转出统筹范围外"));
		tempList.add(new Item("CAE997", "22", "中断缴费"));
		tempList.add(new Item("CAE997", "21", "终止社会保险关系"));
		tempList.add(new Item("CAE997", "14", "统筹范围内转入"));
		tempList.add(new Item("CAE997", "13", "统筹范围外转入"));
		tempList.add(new Item("CAE997", "12", "恢复缴费"));
		tempList.add(new Item("CAE997", "11", "新参保"));
		tempList.add(new Item("AAE341", "20", "县财政代缴"));
		tempList.add(new Item("AAE341", "3", "省级财政补贴"));
		tempList.add(new Item("AAE341", "4", "市级财政补贴"));
		tempList.add(new Item("AAE341", "5", "县级财政补贴"));
		tempList.add(new Item("AAE341", "6", "集体补助"));
		tempList.add(new Item("AAE341", "7", "市财政代缴"));
		tempList.add(new Item("AAE341", "8", "省财政代缴"));
		tempList.add(new Item("AAE341", "9", "特殊身份中央财政补贴"));
		tempList.add(new Item("AAE341", "31", "放映员补贴"));
		tempList.add(new Item("AAA076", "15", "到龄人员待遇核定"));
		tempList.add(new Item("AAA076", "16", "未到龄终止参保关系待遇核定"));
		tempList.add(new Item("AAA076", "17", "享受待遇人员终止待遇核定"));
		tempList.add(new Item("AAA076", "18", "异地转出待遇核定"));
		tempList.add(new Item("AAA079", "1", "统一计划拨付"));
		tempList.add(new Item("AAA079", "2", "即时计划拨付"));
		tempList.add(new Item("AAE016", "0", "未复核"));
		tempList.add(new Item("AAE016", "1", "复核通过"));
		tempList.add(new Item("AAE016", "2", "复核未通过"));
		tempList.add(new Item("AAA080", "1", "是"));
		tempList.add(new Item("AAA080", "0", "否"));
		tempList.add(new Item("AAA094", "0", "未通过"));
		tempList.add(new Item("AAA094", "1", "通过"));
		tempList.add(new Item("AAA088", "1", "正常应付"));
		tempList.add(new Item("AAA088", "2", "补发"));
		tempList.add(new Item("AAA088", "3", "扣发"));
		tempList.add(new Item("AAA088", "4", "一次性支付"));
		tempList.add(new Item("AAA158", "1", "现金（或现金支票）"));
		tempList.add(new Item("AAA158", "2", "转账"));
		tempList.add(new Item("AAA119", "12", "居民养老个人帐户"));
		tempList.add(new Item("AAA119", "11", "新农保个人账户"));
		tempList.add(new Item("BAZ098", "12", "参保信息变更申请"));
		tempList.add(new Item("BAZ098", "11", "新参保申请"));
		tempList.add(new Item("AAB019", "10", "企业"));
		tempList.add(new Item("AAB019", "30", "机关"));
		tempList.add(new Item("AAB019", "50", "事业单位"));
		tempList.add(new Item("AAB019", "55", "全额拨款事业单位"));
		tempList.add(new Item("AAB019", "56", "差额拨款事业单位"));
		tempList.add(new Item("AAB019", "57", "自收自支事业单位"));
		tempList.add(new Item("AAB019", "70", "社会团体"));
		tempList.add(new Item("AAB019", "80", "个体工商户（有雇工的）"));
		tempList.add(new Item("AAB019", "91", "民办非企业单位"));
		tempList.add(new Item("AAB019", "93", "基金会"));
		tempList.add(new Item("AAE143", "10", "正常应缴"));
		tempList.add(new Item("AAE143", "6", "集体补助"));
		tempList.add(new Item("AAE143", "31", "中断或延迟年限补收"));
		tempList.add(new Item("AAE143", "40", "一次性缴费"));
		tempList.add(new Item("AAB019", "20", "村/社区"));
		tempList.add(new Item("AAZ225", "1", "待处理"));
		tempList.add(new Item("AAZ225", "3", "在途"));
		tempList.add(new Item("AAZ225", "4", "成功"));
		tempList.add(new Item("AAZ225", "5", "失败"));
		tempList.add(new Item("AAE117", "0", "未支付"));
		tempList.add(new Item("AAE117", "1", "已支付"));
		tempList.add(new Item("AAE160", "6203", "人员新增险种"));
		tempList.add(new Item("AAE160", "6205", "经审核人员未达到享受养老待遇条件"));
		tempList.add(new Item("AAE160", "6209", "其他原因接续缴费"));
		tempList.add(new Item("AAA077", "11", "核定补发"));
		tempList.add(new Item("AAE160", "6301", "在职人员解除/终止劳动合同"));
		tempList.add(new Item("AAE160", "6302", "人员被判刑收监执行或被劳动教养"));
		tempList.add(new Item("AAE160", "6303", "人员失踪"));
		tempList.add(new Item("AAE160", "6304", "人员参军"));
		tempList.add(new Item("AAE160", "6305", "人员上学"));
		tempList.add(new Item("AAE160", "6307", "人员统筹范围内转出"));
		tempList.add(new Item("AAE160", "6308", "人员达到享受养老待遇条件"));
		tempList.add(new Item("AAE160", "6202", "人员统筹范围内转入"));
		tempList.add(new Item("AAE160", "6309", "其他原因中断缴费"));
		tempList.add(new Item("AAE160", "6401", "死亡"));
		tempList.add(new Item("AAE160", "6402", "出国定居"));
		tempList.add(new Item("AAE160", "6403", "港澳台定居"));
		tempList.add(new Item("AAE160", "6404", "人员转出统筹范围外"));
		tempList.add(new Item("AAE160", "6506", "变更为城镇户籍"));
		tempList.add(new Item("AAE160", "6407", "参加其他社会养老保险"));
		tempList.add(new Item("AAE160", "6408", "失踪（宣告死亡）"));
		tempList.add(new Item("AAE160", "6499", "其他原因"));
		tempList.add(new Item("AAE160", "6900", "人员信息维护"));
		tempList.add(new Item("AAE160", "0010", "组织登记"));
		tempList.add(new Item("AAE160", "6901", "村(社区)信息维护"));
		tempList.add(new Item("AAE160", "0020", "组织中断缴费"));
		tempList.add(new Item("AAE160", "0030", "组织恢复缴费"));
		tempList.add(new Item("AAE160", "0040", "组织合并"));
		tempList.add(new Item("AAE160", "0050", "组织分立"));
		tempList.add(new Item("AAE160", "0060", "组织破产"));
		tempList.add(new Item("AAE160", "0070", "组织成建制转出"));
		tempList.add(new Item("AAE160", "0080", "组织成建制转入"));
		tempList.add(new Item("AAE160", "0990", "其他"));
		tempList.add(new Item("AAE160", "0090", "组织注销（含撤消、吊销）"));
		tempList.add(new Item("AAE160", "1100", "养老保险待遇新增"));
		tempList.add(new Item("AAE160", "1101", "养老待遇核定"));
		tempList.add(new Item("AAE160", "1102", "原待遇享受人员新增"));
		tempList.add(new Item("AAE160", "1199", "其他原因新增养老待遇"));
		tempList.add(new Item("AAE160", "1200", "养老保险待遇暂停"));
		tempList.add(new Item("AAE160", "1201", "养老待遇享受人员未提供生存证明"));
		tempList.add(new Item("AAE160", "1202", "养老待遇享受人员被判刑收监执行或被劳动教养"));
		tempList.add(new Item("AAE160", "1203", "养老待遇享受人员失踪"));
		tempList.add(new Item("AAE160", "1206", "银行帐号错误"));
		tempList.add(new Item("AAE160", "1207", "邮寄地址错误"));
		tempList.add(new Item("AAE160", "1299", "其他原因暂停养老待遇"));
		tempList.add(new Item("AAE160", "1300", "养老保险待遇续发"));
		tempList.add(new Item("AAE160", "1301", "养老待遇享受人员提供生存证明续发"));
		tempList.add(new Item("AAE160", "1302", "刑满"));
		tempList.add(new Item("AAE160", "1303", "失踪后生还"));
		tempList.add(new Item("AAE160", "1304", "被判刑后暂予监外执行、假释"));
		tempList.add(new Item("AAE160", "1399", "其他原因续发养老待遇"));
		tempList.add(new Item("AAE160", "1400", "养老待遇终止"));
		tempList.add(new Item("AAE160", "1401", "养老待遇享受人员死亡"));
		tempList.add(new Item("AAE160", "1402", "养老待遇享受人员出国定居"));
		tempList.add(new Item("AAE160", "1403", "养老待遇享受人员港澳台定居"));
		tempList.add(new Item("AAE160", "1499", "其他原因终止养老待遇"));
		tempList.add(new Item("AAE160", "6100", "人员新增缴费"));
		tempList.add(new Item("AAE160", "6101", "人员新参保"));
		tempList.add(new Item("AAE160", "6102", "人员统筹范围外转入"));
		tempList.add(new Item("AAE160", "6199", "其他原因新增缴费"));
		tempList.add(new Item("AAA077", "12", "待遇接续补发"));
		tempList.add(new Item("AAE160", "6201", "人员续保"));
		tempList.add(new Item("AAA077", "13", "调整补发"));
		tempList.add(new Item("AAA077", "14", "特殊补发"));
		tempList.add(new Item("AAA077", "15", "终止补发"));
		tempList.add(new Item("AAA077", "21", "待遇暂停扣发"));
		tempList.add(new Item("AAA077", "22", "终止扣发"));
		tempList.add(new Item("AAA077", "23", "调整扣发"));
		tempList.add(new Item("AAA077", "24", "特殊扣发"));
		tempList.add(new Item("AAA077", "25", "工伤转养老扣发"));
		tempList.add(new Item("AAA078", "1", "补发"));
		tempList.add(new Item("AAA078", "2", "追回"));
		tempList.add(new Item("AAA078", "3", "已补发"));
		tempList.add(new Item("AAC033", "9", "未说明健康状况"));
		tempList.add(new Item("AAA097", "205", "账户转出"));
		tempList.add(new Item("AAA097", "206", "划拨继承人"));
		tempList.add(new Item("AAA097", "207", "预划冲减"));
		tempList.add(new Item("AAA097", "102", "个人账户年度结息"));
		tempList.add(new Item("AAA097", "103", "个人账户日常结息"));
		tempList.add(new Item("AAA097", "104", "退收"));
		tempList.add(new Item("AAA097", "106", "继承他人账户"));
		tempList.add(new Item("AAA097", "108", "预划收入"));
		tempList.add(new Item("AAA097", "109", "医保退费"));
		tempList.add(new Item("AAA097", "201", "账户一次性返还"));
		tempList.add(new Item("AAA097", "203", "待遇扣减"));
		tempList.add(new Item("AAA097", "204", "医保消费"));
		tempList.add(new Item("AAA097", "101", "个人账户划账"));
		tempList.add(new Item("AAA097", "107", "帐户转入"));
		tempList.add(new Item("AAA097", "202", "定期待遇发放"));
		tempList.add(new Item("AAC150", "2", "二级"));
		tempList.add(new Item("AAC150", "3", "三级"));
		tempList.add(new Item("AAC150", "4", "四级"));
		tempList.add(new Item("AAD005", "1", "银行回单"));
		tempList.add(new Item("AAD005", "2", "税务回单"));
		tempList.add(new Item("AAD005", "3", "财务自收"));
		tempList.add(new Item("AAD005", "4", "学校回单"));
		tempList.add(new Item("AAD005", "5", "社区回单"));
		tempList.add(new Item("AAE116", "1", "正常发放"));
		tempList.add(new Item("AAE116", "2", "暂停发放"));
		tempList.add(new Item("AAC200", "0", "否"));
		tempList.add(new Item("AAC200", "1", "是"));
		tempList.add(new Item("AAE100", "0", "无效"));
		tempList.add(new Item("AAE100", "1", "有效"));
		tempList.add(new Item("AAC058", "1", "居民身份证（户口簿）"));
		tempList.add(new Item("AAC058", "10", "军烈属证明"));
		tempList.add(new Item("AAC058", "11", "低保证"));
		tempList.add(new Item("AAC058", "12", "五保证"));
		tempList.add(new Item("AAC058", "13", "独生子女证"));
		tempList.add(new Item("AAC058", "2", "中国人民解放军军官证"));
		tempList.add(new Item("AAC058", "3", "中国人民武装警察警官证"));
		tempList.add(new Item("AAC058", "4", "香港特区护照/身份证明"));
		tempList.add(new Item("AAC058", "5", "澳门特区护照/身份证明"));
		tempList.add(new Item("AAC058", "6", "台湾居民来往大陆通行证"));
		tempList.add(new Item("AAC058", "8", "外国人护照"));
		tempList.add(new Item("AAC058", "9", "残疾人证明"));
		tempList.add(new Item("AAC149", "1", "视力残疾"));
		tempList.add(new Item("AAC149", "2", "听力残疾"));
		tempList.add(new Item("AAC149", "3", "言语残疾"));
		tempList.add(new Item("AAC149", "4", "肢体残疾"));
		tempList.add(new Item("AAC149", "5", "智力残疾"));
		tempList.add(new Item("AAC149", "6", "精神残疾"));
		tempList.add(new Item("AAC149", "7", "多重残疾"));
		tempList.add(new Item("AAC150", "1", "一级"));
		tempList.add(new Item("AAC008", "2", "暂停缴费"));
		tempList.add(new Item("AAE116", "3", "终止发放"));
		tempList.add(new Item("AAE145", "11", "委托银行发放"));
		tempList.add(new Item("AAE145", "12", "委托邮寄发放"));
		tempList.add(new Item("AAE078", "0", "未到账"));
		tempList.add(new Item("AAE078", "1", "已到账"));
		tempList.add(new Item("AAA038", "716", "省新农保异地转出县级财政补助（补贴）部分金额"));
		tempList.add(new Item("AAA038", "711", "新农保异地转出个人缴费部分金额"));
		tempList.add(new Item("AAA038", "171", "账户返还"));
		tempList.add(new Item("AAA038", "152", "个人账户养老金"));
		tempList.add(new Item("AAA038", "151", "基础养老金"));
		tempList.add(new Item("AAA038", "713", "新农保异地转出集体补助部分金额"));
		tempList.add(new Item("AAA038", "712", "省新农保异地转出中央财政补助（补贴）部分金额"));
		tempList.add(new Item("AAA038", "714", "省新农保异地转出省级财政补助（补贴）部分金额"));
		tempList.add(new Item("AAA038", "715", "省新农保异地转出市级财政补助（补贴）部分金额"));
		tempList.add(new Item("AAA038", "153", "加发基础养老金"));
		tempList.add(new Item("AAE145", "13", "委托街道社区代发"));
		tempList.add(new Item("AAE145", "21", "本人直接到经办机构领取"));
		tempList.add(new Item("AAE145", "22", "指定他人直接到经办机构领取"));
		tempList.add(new Item("AAE145", "31", "单位代发（含个人委托单位领取）"));
		tempList.add(new Item("AAE145", "41", "直接对机构拨付"));
		tempList.add(new Item("AAC059", "1", "居民身份证（户口簿）"));
		tempList.add(new Item("AAC059", "2", "中国人民解放军军官证"));
		tempList.add(new Item("AAC059", "3", "中国人民武装警察警官证"));
		tempList.add(new Item("AAC059", "4", "香港特区护照/身份证明"));
		tempList.add(new Item("AAC059", "5", "澳门特区护照/身份证明"));
		tempList.add(new Item("AAC059", "6", "台湾居民来往大陆通行证"));
		tempList.add(new Item("AAC059", "8", "外国人护照"));
		tempList.add(new Item("AIC003", "3", "转出"));
		tempList.add(new Item("AIC003", "1", "转入"));
		tempList.add(new Item("AAE017", "0", "未核销"));
		tempList.add(new Item("AAE017", "1", "已核销"));
		tempList.add(new Item("AAA036", "150500", "一次性待遇"));
		tempList.add(new Item("AAC120", "0", "否"));
		tempList.add(new Item("AAC120", "1", "是"));
		tempList.add(new Item("AAA094", "2", "未认证"));
		tempList.add(new Item("AAC060", "0", "未认证"));
		tempList.add(new Item("AAC101", "0", "未处理"));
		tempList.add(new Item("AAC101", "1", "受理"));
		tempList.add(new Item("AAC101", "2", "不受理"));
		tempList.add(new Item("AAE142", "10", "银行个人正常应缴通知单"));
		tempList.add(new Item("AAE142", "11", "银行个人一次性缴费通知单"));
		tempList.add(new Item("AAE142", "12", "银行个人中断或延迟年限补收通知单"));
		tempList.add(new Item("AAE341", "21", "被征地缴费补贴"));
		tempList.add(new Item("CAE997", "26", "其它"));
		tempList.add(new Item("TARGET", "1", "在线"));
		tempList.add(new Item("TARGET", "0", "离线"));
		tempList.add(new Item("ISREAD", "0", "未阅"));
		tempList.add(new Item("ISREAD", "1", "已阅"));
		tempList.add(new Item("EMERGE", "1", "一般"));
		tempList.add(new Item("EMERGE", "2", "急"));
		tempList.add(new Item("EMERGE", "3", "特急"));
		tempList.add(new Item("AAC121", "1", "是"));
		tempList.add(new Item("AAC121", "0", "否"));
		tempList.add(new Item("AAC066", "0", "正常"));
		tempList.add(new Item("AAC066", "1", "重度残疾"));
		tempList.add(new Item("AAC066", "10", "独生子女伤残(一级二级)"));
		tempList.add(new Item("AAC066", "11", "独生子女伤残（三级以上含三级）"));
		tempList.add(new Item("AAC066", "12", "独生子女"));
		tempList.add(new Item("AAC066", "13", "独生子女领证户"));
		tempList.add(new Item("AAC066", "15", "低保一类人员"));
		tempList.add(new Item("AAC066", "3", "低保人员"));
		tempList.add(new Item("AAC066", "4", "五保户"));
		tempList.add(new Item("AAC066", "5", "重点优抚对象"));
		tempList.add(new Item("AAC066", "6", "计生家庭"));
		tempList.add(new Item("AAC066", "7", "村干部"));
		tempList.add(new Item("AAC066", "8", "独生子女伤亡"));
		tempList.add(new Item("AAC066", "9", "计划生育手术并发症"));
		tempList.add(new Item("AAA171", "1", "已追回"));
		tempList.add(new Item("AAA171", "2", "转扣减处理"));
		tempList.add(new Item("AAA171", "3", "核销为死帐"));
		tempList.add(new Item("AAC066", "14", "吉尼环长效节育"));
		tempList.add(new Item("BAZ098", "18", "个人补缴申请"));
		tempList.add(new Item("BAZ098", "19", "暂停缴费申请"));
		tempList.add(new Item("BAZ098", "20", "恢复缴费申请"));
		tempList.add(new Item("AAC100", "0", "未复核"));
		tempList.add(new Item("AAC100", "1", "复核通过"));
		tempList.add(new Item("AAC100", "2", "复核不通过"));
		tempList.add(new Item("BAZ098", "21", "人员终止参保申请"));
		tempList.add(new Item("AAE142", "13", "省代缴缴费通知单"));
		tempList.add(new Item("AAE142", "14", "市代缴缴费通知单"));
		tempList.add(new Item("AAE142", "15", "县代缴缴费通知单"));
		tempList.add(new Item("AAE160", "6204", "人员退保后重新参保"));
		tempList.add(new Item("AAE160", "6299", "其他原因接续缴费"));
		tempList.add(new Item("AAE160", "6399", "其他原因中断缴费"));
		tempList.add(new Item("AAE160", "6200", "人员接续缴费"));
		tempList.add(new Item("AAE160", "6306", "停薪留职"));
		tempList.add(new Item("AAE160", "6400", "人员终止缴费"));
		tempList.add(new Item("AAE160", "6405", "退保"));
		tempList.add(new Item("AAE160", "6300", "人员中断缴费"));
		tempList.add(new Item("AAE018", "0", "未录入"));
		tempList.add(new Item("AAE018", "1", "已录入"));
		tempList.add(new Item("AAE341", "22", "原被征地缴费补贴"));
		tempList.add(new Item("AAE035", "20140601", "死亡人员新政策开始时间"));
		tempList.add(new Item("AAA076", "19", "制度衔接转移待遇核定"));
		tempList.add(new Item("AAA088", "6", "补差"));
		tempList.add(new Item("AAE341", "41", "老农保个人缴费"));
		tempList.add(new Item("AAA088", "5", "关系转移支付"));
		tempList.add(new Item("AAC031", "0", "暂停缴费"));
		tempList.add(new Item("AAC031", "1", "正常缴费"));
		tempList.add(new Item("AAC031", "2", "暂停缴费"));
		tempList.add(new Item("AAC031", "3", "终止缴费"));
		tempList.add(new Item("AAC031", "4", "终止缴费"));
		
		tempList.add(new Item("ZZZ005", "01", "在职人员"));
		tempList.add(new Item("ZZZ005", "02", "离退休人员"));
		tempList.add(new Item("ZZZ005", "03", "灵活就业人员"));
		tempList.add(new Item("ZZZ005", "04", "城镇居民人员"));
		tempList.add(new Item("ZZZ005", "05", "农民"));
		tempList.add(new Item("ZZZ005", "10", "劳动人民"));
		
		tempList.add(new Item("BZ", "0", "其他"));
		tempList.add(new Item("BZ", "1", "正常参保"));
		tempList.add(new Item("BZ", "2", "停保"));
		tempList.add(new Item("BZ", "3", "退保"));
		
		tempList.add(new Item("BAE152", "1", "已缴费"));
		
		tempList.add(new Item("AAA115", "1", "正常实缴纪录"));
		tempList.add(new Item("AAA115", "01", "正常实缴纪录"));
		tempList.add(new Item("AAA115", "21", "灵活人员补本年往期核定"));
		tempList.add(new Item("AAA115", "26", "个人差额补基数"));
		tempList.add(new Item("AAA115", "27", "职工个人差额退"));
		tempList.add(new Item("AAA115", "10", "正常应缴"));
		tempList.add(new Item("AAA115", "11", "单位补收往期"));
		tempList.add(new Item("AAA115", "20", "个人补收"));
		tempList.add(new Item("AAA115", "25", "个人差额补比例"));
		tempList.add(new Item("AAA115", "30", "医疗一次性缴费"));
		tempList.add(new Item("AAA115", "31", "事转企一次性补贴"));
		tempList.add(new Item("AAA115", "32", "养老一次性缴费（趸补）"));
		tempList.add(new Item("AAA115", "33", "退休人员养老基金补偿金缴费"));
		tempList.add(new Item("AAA115", "34", "养老单边补缴"));
		tempList.add(new Item("AAA115", "35", "行业移交补建"));
		tempList.add(new Item("AAA115", "36", "超龄人员补收养老保险"));
		tempList.add(new Item("AAA115", "37", "国有困难单位一次性缴纳医疗补偿金"));
		tempList.add(new Item("AAA115", "38", "医疗一次性补余期"));
		tempList.add(new Item("AAA115", "39", "养老特殊趸补缴费"));
		tempList.add(new Item("AAA115", "40", "国有困难单位一次性缴纳医疗补偿金"));
		tempList.add(new Item("AAA115", "41", "离（军）休干部医疗统筹金申报"));
		
		tempList.add(new Item("AAE114", "0", "欠费"));
		tempList.add(new Item("AAE114", "1", "到账"));
		
		tempList.add(new Item("AAE127", "0", "未到账"));
		tempList.add(new Item("AAE127", "1", "到账"));
		tempList.add(new Item("AAE127", "2", "未到账"));
		
		tempList.add(new Item("BAB623", "1", "低保人员"));
		tempList.add(new Item("BAB623", "2", "优抚人员"));
		tempList.add(new Item("BAB623", "3", "重度伤残人员"));
		tempList.add(new Item("BAB623", "4", "正常缴费人员"));
		tempList.add(new Item("BAB623", "5", "低收入家庭"));
		tempList.add(new Item("BAB623", "6", "低收入家庭60周岁以上的老年人"));

		tempList.add(new Item("SYSID", "1", "省直"));
		tempList.add(new Item("SYSID", "2", "海口"));
		tempList.add(new Item("SYSID", "3", "大金保"));
		tempList.add(new Item("SYSID", "4", "三亚"));
		tempList.add(new Item("SYSID", "5", "城居医疗"));
		tempList.add(new Item("SYSID", "6", "城居养老"));
		tempList.add(new Item("SYSID", "7", "新农保"));
		
		tempList.add(new Item("REGION", "460105", "海口秀英区"));
		tempList.add(new Item("REGION", "460106", "海口龙华区"));
		tempList.add(new Item("REGION", "460107", "海口琼山区"));
		tempList.add(new Item("REGION", "460108", "海口美兰区"));
		tempList.add(new Item("REGION", "460199", "海口市"));
		tempList.add(new Item("REGION", "460200", "三亚市"));
		tempList.add(new Item("REGION", "462099", "洋浦"));
		tempList.add(new Item("REGION", "469001", "指山市"));
		tempList.add(new Item("REGION", "469002", "琼海市"));
		tempList.add(new Item("REGION", "469003", "儋州市"));
		tempList.add(new Item("REGION", "469005", "文昌市"));
		tempList.add(new Item("REGION", "469006", "万宁市"));
		tempList.add(new Item("REGION", "469007", "东方市"));
		tempList.add(new Item("REGION", "469021", "定安县"));
		tempList.add(new Item("REGION", "469022", "屯昌县"));
		tempList.add(new Item("REGION", "469023", "澄迈县"));
		tempList.add(new Item("REGION", "469024", "临高县"));
		tempList.add(new Item("REGION", "469025", "白沙县"));
		tempList.add(new Item("REGION", "469026", "昌江县"));
		tempList.add(new Item("REGION", "469027", "乐东县"));
		tempList.add(new Item("REGION", "469028", "陵水县"));
		tempList.add(new Item("REGION", "469029", "保亭县"));
		tempList.add(new Item("REGION", "469030", "琼中县"));
		tempList.add(new Item("REGION", "469031", "三沙市"));
		tempList.add(new Item("REGION", "469900", "省直"));  

		
		// TODO
		
		for(Item item : tempList) {
			if(Values.containsKey(item.ParentKey) == false) {
				Map<String, String> innerMap = new HashMap<String, String>();
				innerMap.put(item.SelfKey, item.SelfValue);
				Values.put(item.ParentKey, innerMap);
			}
			else {
				Values.get(item.ParentKey).put(item.SelfKey, item.SelfValue);
			}
		}
	}

	public static DropDownDataList getInstance() {
		if (instance == null) {
			instance = new DropDownDataList();
		}
		return instance;
	}
	
	public String getValue(String parentId, String key) {
		String value = "";
		try {
			if(key == null) {
				key = "";
			}
			else {
				key = key.trim();
			}
			value = (String)Values.get(parentId).get(key);
		}
		catch(Exception e) {
			
		}
		return value;
	}
}
