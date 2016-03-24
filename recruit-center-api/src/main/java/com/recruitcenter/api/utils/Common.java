package com.recruitcenter.api.utils;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.binary.Hex;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class Common {
	//后台访问
	public static final String BACKGROUND_PATH = "WEB-INF/jsp/background";
	//前台访问
	public static final String WEB_PATH = "/WEB-INF/jsp/web";
	//默认除法运算精度
	public static final int DEF_DIV_SCALE = 10;
	//状态码和相应信息
	public static final int SUCCESS_CODE = 1;
	public static final int EMPTY_CODE = 0;
	public static final int FAILURE_CODE = -1;
	public static final String SUCCESS_TAG = "success";
	public static final String FAILURE_TAG = "failed";
	public static final String SUCCESS_MESSAGE = "成功";
	public static final String FAILURE_MESSAGE = "失败";
	public static final String EMPTY_MESSAGE = "找不到数据";
	//社保计算器 单位缴费各项比率
	public static final double COMPANY_PERSION_RATE = 0.2;
	public static final double COMPANY_MEDICAL_RATE = 0.08;
	public static final double COMPANY_LOSEJOB_RATE = 0.02;
	public static final double COMPANY_BEARING_RATE = 0.005;
	public static final double COMPANY_INJURY_RATE = 0.02;
	//社保计算器 个人缴费各项比率
	public static final double INDIVID_PERSION_RATE = 0.08;
	public static final double INDIVID_MEDICAL_RATE = 0.02;
	public static final double INDIVID_LOSEJOB_RATE = 0.01;
	//东软省直接口ticketID
	public static final String YARDMAN_TICKET_ID = "NEUSERVICE_APP_001";
	//东软业务交易编码
	public static final String NEU_PERSONBASE_INFO = "HNSIMIS_APP_001";
	public static final String NEU_PERSION_INFO = "HNSIMIS_APP_010";
	public static final String NEU_MEDICAL_INFO = "HNSIMIS_APP_011";
	public static final String NEU_PERSION_PAYMENT_INFO = "HNSIMIS_APP_004";
	public static final String NEU_MEDICAL_PAYMENT_INFO = "HNSIMIS_APP_005";
	//文件对象，用于获取不同操作系统下得绝对路径
	public static File GLOBAL_FILE = null;
	public static Map<String, String> SYSEC_MAPPING = new HashMap<String, String>() {
		{
			put("1", "11");
			put("2", "21");
			put("3", "31");
			put("4", "41");
			put("5", "51");
			put("6", "33");
		}
	};
    
	/**
	 * String转换double
	 * @param string
	 * @return double
	 */
	public static double convertSourData(String dataStr) throws Exception{
		if(dataStr!=null&&!"".equals(dataStr)){
			return Double.valueOf(dataStr);
		}
		throw new NumberFormatException("convert error!");
	}
	
	/**
	 * 判断变量是否为空
	 * 
	 * @param s
	 * @return
	 */
	public static boolean isEmpty(String s) {
		if (null == s || "".equals(s) || "".equals(s.trim()) || "null".equalsIgnoreCase(s)) {
			return true;
		} else {
			return false;
		}
	}
	/**
	 * 使用率计算
	 * 
	 * @return
	 */
	public static String fromUsage(long free, long total) {
		Double d = new BigDecimal(free * 100 / total).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
		return String.valueOf(d);
	}
	/**
	 * 返回当前时间　格式：yyyy-MM-dd hh:mm:ss
	 * @return String
	 */
	public static String fromDateH(){
		DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		return format1.format(new Date());
	}
	/**
	 * 返回当前时间　格式：yyyy-MM-dd
	 * @return String
	 */
	public static String fromDateY(){
		DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		return format1.format(new Date());
	}
	/**
	 * 用来去掉List中空值和相同项的。
	 * 
	 * @param list
	 * @return
	 */
	public static List<String> removeSameItem(List<String> list) {
		List<String> difList = new ArrayList<String>();
		for (String t : list) {
			if (t != null && !difList.contains(t)) {
				difList.add(t);
			}
		}
		return difList;
	}

	/**
	 * 返回用户的IP地址
	 * 
	 * @param request
	 * @return
	 */
	public static String toIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("X-Forwarded-For");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
		ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
		ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
		ip = request.getHeader("HTTP_CLIENT_IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
		ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
		ip = request.getRemoteAddr();
		}
		return ip;
		}

	/**
	 * 传入原图名称，，获得一个以时间格式的新名称
	 * 
	 * @param fileName
	 *            　原图名称
	 * @return
	 */
	public static String generateFileName(String fileName) {
		DateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		String formatDate = format.format(new Date());
		int random = new Random().nextInt(10000);
		int position = fileName.lastIndexOf(".");
		String extension = fileName.substring(position);
		return formatDate + random + extension;
	}

	/**
	 * 取得html网页内容 UTF8编码
	 * 
	 * @param urlStr
	 *            网络地址
	 * @return String
	 */
	public static String getInputHtmlUTF8(String urlStr) {
		URL url = null;
		try {
			url = new URL(urlStr);
			HttpURLConnection httpsURLConnection = (HttpURLConnection) url.openConnection();

			httpsURLConnection.setRequestMethod("GET");
			httpsURLConnection.setConnectTimeout(5 * 1000);
			httpsURLConnection.connect();
			if (httpsURLConnection.getResponseCode() == 200) {
				// 通过输入流获取网络图片
				InputStream inputStream = httpsURLConnection.getInputStream();
				String data = readHtml(inputStream, "UTF-8");
				inputStream.close();
				return data;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		return null;

	}

	/**
	 * 取得html网页内容 GBK编码
	 * 
	 * @param urlStr
	 *            网络地址
	 * @return String
	 */
	public static String getInputHtmlGBK(String urlStr) {
		URL url = null;
		try {
			url = new URL(urlStr);
			HttpURLConnection httpsURLConnection = (HttpURLConnection) url.openConnection();

			httpsURLConnection.setRequestMethod("GET");
			httpsURLConnection.setConnectTimeout(5 * 1000);
			httpsURLConnection.connect();
			if (httpsURLConnection.getResponseCode() == 200) {
				// 通过输入流获取网络图片
				InputStream inputStream = httpsURLConnection.getInputStream();
				String data = readHtml(inputStream, "GBK");
				inputStream.close();
				return data;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		return null;

	}

	/**
	 * @param inputStream
	 * @param uncode
	 *            编码 GBK 或 UTF-8
	 * @return
	 * @throws Exception
	 */
	public static String readHtml(InputStream inputStream, String uncode) throws Exception {
		InputStreamReader input = new InputStreamReader(inputStream, uncode);
		BufferedReader bufReader = new BufferedReader(input);
		String line = "";
		StringBuilder contentBuf = new StringBuilder();
		while ((line = bufReader.readLine()) != null) {
			contentBuf.append(line);
		}
		return contentBuf.toString();
	}

	/**
	 * 
	 * @return 返回资源的二进制数据 @
	 */
	public static byte[] readInputStream(InputStream inputStream) {
		byte[] ret = {};
		// 定义一个输出流向内存输出数据
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		// 定义一个缓冲区
		byte[] buffer = new byte[1024];
		// 读取数据长度
		int len = 0;
		// 当取得完数据后会返回一个-1
		try {
			while ((len = inputStream.read(buffer)) != -1) {
				// 把缓冲区的数据 写到输出流里面
				byteArrayOutputStream.write(buffer, 0, len);
			}
		} catch (IOException e) {
			e.printStackTrace();
			ret = null;
		} finally {
			try {
				byteArrayOutputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
				ret = null;
			}
		}

		// 得到数据后返回
		ret = byteArrayOutputStream.toByteArray();
		return ret;
	}
	/**
	 * 修改配置　
	 * 
	 * @param request
	 * @param nodeId
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/modifySer")
	public static Map<String, Object> modifySer(String key, String value) throws Exception {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		try {
			PropertiesUtils.modifyProperties(key, value);
		} catch (Exception e) {
			dataMap.put("flag", false);
		}
		dataMap.put("flag", true);
		return dataMap;
	}

	/**
	 * 获取登录账号的ID
	 * @author lanyuan
	 * Email：mmm333zzz520@163.com
	 * date：2014-2-27
	 * @param request
	 * @return
	 */
	public static String findUserSessionId(HttpServletRequest request) { 
		return request.getSession().getAttribute("userSessionId").toString();
	 }
	
	/**
	 * 获取登录账号的的对象
	 * @author lanyuan
	 * Email：mmm333zzz520@163.com
	 * date：2014-2-27
	 * @param request
	 * @return Object 返回是Object..需要转型为(Account)Object
	 */
	public static Object findUserSession(HttpServletRequest request) { 
	    return (Object)request.getSession().getAttribute("userSession");
	 }
	/**
     * 提供精确的减法运算。
     * @param v1 被减数
     * @param v2 减数
     * @return 两个参数的差
     */
	public static double sub(double v1,double v2){
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.subtract(b2).doubleValue();
    } 
	 /**
     * 提供精确的加法运算。
     * @param v1 被加数
     * @param v2 加数
     * @return 两个参数的和
     */
    public static double add(double v1,double v2){
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.add(b2).doubleValue();
    }
    /**
     * 提供精确的乘法运算。
     * @param v1 被乘数
     * @param v2 乘数
     * @return 两个参数的积
     */
    public static double mul(double v1,double v2){
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.multiply(b2).doubleValue();
    }
 
    /**
     * 提供（相对）精确的除法运算，当发生除不尽的情况时，精确到
     * 小数点以后10位，以后的数字四舍五入。
     * @param v1 被除数
     * @param v2 除数
     * @return 两个参数的商
     */
    public static double div(double v1,double v2){
        return div(v1,v2,DEF_DIV_SCALE);
    }
    /**
     * 提供（相对）精确的除法运算。当发生除不尽的情况时，由scale参数指
     * 定精度，以后的数字四舍五入。
     * @param v1 被除数
     * @param v2 除数
     * @param scale 表示表示需要精确到小数点以后几位。
     * @return 两个参数的商
     */
    public static double div(double v1,double v2,int scale){
        if(scale<0){
            throw new IllegalArgumentException(
                "The scale must be a positive integer or zero");
        }
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.divide(b2,scale,BigDecimal.ROUND_HALF_UP).doubleValue();
    }
    
    public static BigDecimal formatBigDec(BigDecimal value)  {
    	DecimalFormat df = new DecimalFormat("0.00");
    	String str = df.format(value == null? 0 : value);
    	return new BigDecimal(str);
    }
    
    public static String formatDate(Date value) {
    	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    	return value == null ? "" : df.format(value);
    }
  
    @SuppressWarnings("deprecation")
    public static Date string2Date(String date) {
		Date newInsuredDate;
		double doubleDate = Double.valueOf(date) / 100;
		String[] dateParts = Double.toString(doubleDate).split("\\.");
		newInsuredDate = new Date(Integer.valueOf(dateParts[0]) - 1900, Integer.valueOf(dateParts[1]) - 1, 1);
		return newInsuredDate;
	}
	
	@SuppressWarnings("deprecation")
	public static Date addDate(String date) {
		Date newInsuredDate = new Date();
		String[] dateParts = date.split("-");
		if(dateParts.length > 0) {
			newInsuredDate = new Date(Integer.valueOf(dateParts[0]) - 1900, Integer.valueOf(dateParts[1]) - 1, 1);
		}
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(newInsuredDate);
        cal.add(Calendar.MONTH, 1);
		return cal.getTime();
	}
	
	
	public static String getAbsolutePath(URI path) {
		GLOBAL_FILE = new File(path);
		return GLOBAL_FILE.getAbsolutePath();
	}
	
	public static String getTestDataFile(String name) {
		String path = null;
		try {
			path = Common.getAbsolutePath(Common.class.getResource(name).toURI());
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return path;
	}
	
	public static String getCheckCode(String value) {
		byte[] retBytes = null;
		String checkCode = null;
		try {
			byte[] bt = value.getBytes("UTF8");
	        char lrc = (char)bt[0];
	        for(int i = 1; i < bt.length; i++){
	            lrc ^= (char)bt[i];
	        }
	        retBytes = String.valueOf(lrc).getBytes("UTF8");
	        checkCode = String.valueOf(Hex.encodeHex(retBytes));
	        System.out.println(String.format("%s 转换为校验码为：%s", value, checkCode));
		} catch (Exception e) {
			System.out.println(e);
		}
		return checkCode;
	}
	
	public static String exchangeID15to18(String idCardNo15) throws Exception
    {
		if(idCardNo15.length() < 15) {
			throw new Exception("不是15位数的身份证号码");
		}
		StringBuilder sb = new StringBuilder(idCardNo15);
		String temp = sb.insert(6, "19").toString();
		String[] eccCode = { "1", "0", "X", "9", "8", "7", "6", "5", "4", "3", "2" };
        int[] wi ={ 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2, 1 };

        char[] idCharArray = temp.toCharArray();

        if (idCharArray.length != 17)
            return "";

        int total = 0;
        int i = 0;

        try
        {
            for (char ch : idCharArray)
            {
                total += (Integer.valueOf(ch) - 48) * wi[i++];
            }
        }
        catch(Exception ex)
        {
            return "";
        }

        if (total % 11 > 10)
            return "";

        return temp + eccCode[total % 11];
    }
	
	public static String format2Chinese(String date) {
		String cDate = date;
		String dateFormat = "%s年%s月";
		if(cDate != null && cDate.equals("") == false) {
			double dDate = Double.parseDouble(cDate) / 100;
			String[] pharseArray = String.valueOf(dDate).split("\\.");
			cDate = String.format(dateFormat, pharseArray[0], pharseArray[1]);
		}
		return cDate;
	}
	
	public static JSONObject getJSONByGet(String url){
		JSONObject resultJsonObject = null;
		if ("".equals(url) || url == null) {
			return null;
		}
		CloseableHttpClient httpClient = HttpClients.createDefault();
		// 利用URL生成一个HttpGet请求
		HttpGet httpGet = new HttpGet(url);
		CloseableHttpResponse httpResponse = null;
		try {
			// HttpClient发出一个HttpGet请求
			httpResponse = httpClient.execute(httpGet);
			// 得到httpResponse的状态响应码
			int statusCode = httpResponse.getStatusLine().getStatusCode();
			if (statusCode == HttpStatus.SC_OK) {
				// 得到httpResponse的实体数据
				HttpEntity httpEntity = httpResponse.getEntity();
				if (httpEntity != null) {
					try {
						String content = EntityUtils.toString(httpEntity, "UTF-8");
						resultJsonObject = JSONObject.parseObject(content);
						EntityUtils.consume(httpEntity);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {  
			try {
				httpResponse.close();
				httpClient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}  
        }  
        return resultJsonObject;
    }
	
	public static JSONArray getJArrayByGet(String url){
		JSONArray resultJsonArray= null;
		if ("".equals(url) || url == null) {
			return null;
		}
		CloseableHttpClient httpClient = HttpClients.createDefault();
		// 利用URL生成一个HttpGet请求
		HttpGet httpGet = new HttpGet(url);
		CloseableHttpResponse httpResponse = null;
		try {
			// HttpClient发出一个HttpGet请求
			httpResponse = httpClient.execute(httpGet);
			// 得到httpResponse的状态响应码
			int statusCode = httpResponse.getStatusLine().getStatusCode();
			if (statusCode == HttpStatus.SC_OK) {
				// 得到httpResponse的实体数据
				HttpEntity httpEntity = httpResponse.getEntity();
				if (httpEntity != null) {
					try {
						String content = EntityUtils.toString(httpEntity, "UTF-8");
						resultJsonArray = JSONArray.parseArray(content);
						EntityUtils.consume(httpEntity);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {  
			try {
				httpResponse.close();
				httpClient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}  
        }  
        return resultJsonArray;
    }
}
