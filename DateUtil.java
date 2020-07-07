package util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 鏃ユ湡宸ュ叿绫�
 * 
 */
public class DateUtil {

	// 榛樿鏃ユ湡鏍煎紡
	public static final String DATE_DEFAULT_FORMAT = "yyyy-MM-dd";

	// 榛樿鏃堕棿鏍煎紡
	public static final String DATETIME_DEFAULT_FORMAT = "yyyy-MM-dd HH:mm:ss";
	
	// 鑷畾涔�
    public static final String DATETIME_DEFAULT_FORMAT_NO = "yyyyMMddHHmmss";

	public static final String TIME_DEFAULT_FORMAT = "HH:mm:ss";

	// 鏃ユ湡鏍煎紡鍖�
	private static DateFormat dateFormat = null;

	// 鏃堕棿鏍煎紡鍖�
	private static DateFormat dateTimeFormat = null;
	
	// 鏃堕棿鏍煎紡鍖�
	private static DateFormat dateTimeFormatNo = null;

	private static DateFormat timeFormat = null;

	private static Calendar gregorianCalendar = null;

	static {
		dateFormat = new SimpleDateFormat(DATE_DEFAULT_FORMAT);
		dateTimeFormat = new SimpleDateFormat(DATETIME_DEFAULT_FORMAT);
		dateTimeFormatNo = new SimpleDateFormat(DATETIME_DEFAULT_FORMAT_NO);
		timeFormat = new SimpleDateFormat(TIME_DEFAULT_FORMAT);
		gregorianCalendar = new GregorianCalendar();
	}

	/**
	 * 鏃ユ湡鏍煎紡鍖杫yyy-MM-dd
	 * 
	 * @param date
	 * @return
	 */
	public static Date formatDate(String date, String format) {
		try {
			return new SimpleDateFormat(format).parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 鏃ユ湡鏍煎紡鍖杫yyy-MM-dd
	 * 
	 * @param date
	 * @return
	 */
	public static String getDateFormat(Date date) {
		return dateFormat.format(date);
	}

	/**
	 * 鏃ユ湡鏍煎紡鍖杫yyy-MM-dd HH:mm:ss
	 * 
	 * @param date
	 * @return
	 */
	public static String getDateTimeFormat(Date date) {
		return dateTimeFormat.format(date);
	}
	
	/**
	 * 鏃ユ湡鏍煎紡鍖杫yyy-MM-dd HH:mm:ss
	 * 
	 * @param date
	 * @return
	 */
	public static String getDateTimeFormatNo(Date date) {
		return dateTimeFormatNo.format(date);
	}

	/**
	 * 鏃堕棿鏍煎紡鍖�
	 * 
	 * @param date
	 * @return HH:mm:ss
	 */
	public static String getTimeFormat(Date date) {
		return timeFormat.format(date);
	}


	/**
	 * 鏃ユ湡鏍煎紡鍖�
	 * 
	 * @param date
	 * @return
	 */
	public static Date getDateFormat(String date) {
		try {
			return dateFormat.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 鏃堕棿鏍煎紡鍖�
	 * 
	 * @param date
	 * @return
	 */
	public static Date getDateTimeFormat(String date) {
		try {
			return dateTimeFormat.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 鑾峰彇褰撳墠鏃ユ湡(yyyy-MM-dd)
	 * 
	 * @param date
	 * @return
	 */
	public static Date getNowDate() {
		return DateUtil.getDateFormat(dateFormat.format(new Date()));
	}

	/**
	 * 鑾峰彇褰撳墠鏃ユ湡鏄熸湡涓�鏃ユ湡
	 * 
	 * @return date
	 */
	public static Date getFirstDayOfWeek() {
		gregorianCalendar.setFirstDayOfWeek(Calendar.MONDAY);
		gregorianCalendar.setTime(new Date());
		gregorianCalendar.set(Calendar.DAY_OF_WEEK, gregorianCalendar.getFirstDayOfWeek()); // Monday
		return gregorianCalendar.getTime();
	}

	/**
	 * 鑾峰彇褰撳墠鏃ユ湡鏄熸湡鏃ユ棩鏈�
	 * 
	 * @return date
	 */
	public static Date getLastDayOfWeek() {
		gregorianCalendar.setFirstDayOfWeek(Calendar.MONDAY);
		gregorianCalendar.setTime(new Date());
		gregorianCalendar.set(Calendar.DAY_OF_WEEK, gregorianCalendar.getFirstDayOfWeek() + 6); // Monday
		return gregorianCalendar.getTime();
	}

	/**
	 * 鑾峰彇鏃ユ湡鏄熸湡涓�鏃ユ湡
	 * 
	 * @param 鎸囧畾鏃ユ湡
	 * @return date
	 */
	public static Date getFirstDayOfWeek(Date date) {
		if (date == null) {
			return null;
		}
		gregorianCalendar.setFirstDayOfWeek(Calendar.MONDAY);
		gregorianCalendar.setTime(date);
		gregorianCalendar.set(Calendar.DAY_OF_WEEK, gregorianCalendar.getFirstDayOfWeek()); // Monday
		return gregorianCalendar.getTime();
	}

	/**
	 * 鑾峰彇鏃ユ湡鏄熸湡涓�鏃ユ湡
	 * 
	 * @param 鎸囧畾鏃ユ湡
	 * @return date
	 */
	public static Date getLastDayOfWeek(Date date) {
		if (date == null) {
			return null;
		}
		gregorianCalendar.setFirstDayOfWeek(Calendar.MONDAY);
		gregorianCalendar.setTime(date);
		gregorianCalendar.set(Calendar.DAY_OF_WEEK, gregorianCalendar.getFirstDayOfWeek() + 6); // Monday
		return gregorianCalendar.getTime();
	}

	/**
	 * 鑾峰彇褰撳墠鏈堢殑绗竴澶�
	 * 
	 * @return date
	 */
	public static Date getFirstDayOfMonth() {
		gregorianCalendar.setTime(new Date());
		gregorianCalendar.set(Calendar.DAY_OF_MONTH, 1);
		return gregorianCalendar.getTime();
	}

	/**
	 * 鑾峰彇褰撳墠鏈堢殑鏈�鍚庝竴澶�
	 * 
	 * @return
	 */
	public static Date getLastDayOfMonth() {
		gregorianCalendar.setTime(new Date());
		gregorianCalendar.set(Calendar.DAY_OF_MONTH, 1);
		gregorianCalendar.add(Calendar.MONTH, 1);
		gregorianCalendar.add(Calendar.DAY_OF_MONTH, -1);
		return gregorianCalendar.getTime();
	}

	/**
	 * 鑾峰彇鎸囧畾鏈堢殑绗竴澶�
	 * 
	 * @param date
	 * @return
	 */
	public static Date getFirstDayOfMonth(Date date) {
		gregorianCalendar.setTime(date);
		gregorianCalendar.set(Calendar.DAY_OF_MONTH, 1);
		return gregorianCalendar.getTime();
	}

	/**
	 * 鑾峰彇鎸囧畾鏈堢殑鏈�鍚庝竴澶�
	 * 
	 * @param date
	 * @return
	 */
	public static Date getLastDayOfMonth(Date date) {
		gregorianCalendar.setTime(date);
		gregorianCalendar.set(Calendar.DAY_OF_MONTH, 1);
		gregorianCalendar.add(Calendar.MONTH, 1);
		gregorianCalendar.add(Calendar.DAY_OF_MONTH, -1);
		return gregorianCalendar.getTime();
	}

	/**
	 * 鑾峰彇鏃ユ湡鍓嶄竴澶�
	 * 
	 * @param date
	 * @return
	 */
	public static Date getDayBefore(Date date) {
		gregorianCalendar.setTime(date);
		int day = gregorianCalendar.get(Calendar.DATE);
		gregorianCalendar.set(Calendar.DATE, day - 1);
		return gregorianCalendar.getTime();
	}

	/**
	 * 鑾峰彇鏃ユ湡鍚庝竴澶�
	 * 
	 * @param date
	 * @return
	 */
	public static Date getDayAfter(Date date) {
		gregorianCalendar.setTime(date);
		int day = gregorianCalendar.get(Calendar.DATE);
		gregorianCalendar.set(Calendar.DATE, day + 1);
		return gregorianCalendar.getTime();
	}

	/**
	 * 鑾峰彇褰撳墠骞�
	 * 
	 * @return
	 */
	public static int getNowYear() {
		Calendar d = Calendar.getInstance();
		return d.get(Calendar.YEAR);
	}

	/**
	 * 鑾峰彇褰撳墠鏈堜唤
	 * 
	 * @return
	 */
	public static int getNowMonth() {
		Calendar d = Calendar.getInstance();
		return d.get(Calendar.MONTH) + 1;
	}

	/**
	 * 鑾峰彇褰撴湀澶╂暟
	 * 
	 * @return
	 */
	public static int getNowMonthDay() {
		Calendar d = Calendar.getInstance();
		return d.getActualMaximum(Calendar.DATE);
	}

	/**
	 * 鑾峰彇鏃堕棿娈电殑姣忎竴澶�
	 * 
	 * @param 寮�濮嬫棩鏈�
	 * @param 缁撶畻鏃ユ湡
	 * @return 鏃ユ湡鍒楄〃
	 */
	public static List<Date> getEveryDay(Date startDate, Date endDate) {
		if (startDate == null || endDate == null) {
			return null;
		}
		// 鏍煎紡鍖栨棩鏈�(yy-MM-dd)
		startDate = DateUtil.getDateFormat(DateUtil.getDateFormat(startDate));
		endDate = DateUtil.getDateFormat(DateUtil.getDateFormat(endDate));
		List<Date> dates = new ArrayList<Date>();
		gregorianCalendar.setTime(startDate);
		dates.add(gregorianCalendar.getTime());
		while (gregorianCalendar.getTime().compareTo(endDate) < 0) {
			// 鍔�1澶�
			gregorianCalendar.add(Calendar.DAY_OF_MONTH, 1);
			dates.add(gregorianCalendar.getTime());
		}
		return dates;
	}

	/**
	 * 鑾峰彇鎻愬墠澶氬皯涓湀
	 * 
	 * @param monty
	 * @return
	 */
	public static Date getFirstMonth(int monty) {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH, -monty);
		return c.getTime();
	}
	/**
	 * 瀛楃涓茬被鍨嬬殑鏃ユ湡姣旇緝澶у皬
	 * @param DATE1
	 * @param DATE2
	 * @return
	 */
	public static int compare_date(String DATE1, String DATE2) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date dt1 = df.parse(DATE1);
            Date dt2 = df.parse(DATE2);
            if (dt1.getTime() > dt2.getTime()) {
                System.out.println("dt1 鍦╠t2鍓�");
                return 1;
            } else if (dt1.getTime() < dt2.getTime()) {
                System.out.println("dt1鍦╠t2鍚�");
                return -1;
            } else {
                return 0;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return 0;
    }
	/**
	 * 杩斿洖涓や釜瀛楃涓茬被鍨嬬殑鏃ユ湡鐩稿樊鐨勫ぉ鏁�
	 * @param smdate
	 * @param bdate
	 * @return
	 */
	public static int daysBetween(String smdate,String bdate){  
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
        Calendar cal = Calendar.getInstance();    
        long time1 = 0;
        long time2 = 0;
        
        try{
             cal.setTime(sdf.parse(smdate));   
             time1 = cal.getTimeInMillis();    
             cal.setTime(sdf.parse(bdate)); 
             time2 = cal.getTimeInMillis();  
        }catch(Exception e){
            e.printStackTrace();
        }
        long between_days=(time2-time1)/(1000*3600*24);  
            
       return Integer.parseInt(String.valueOf(between_days));     
    }
	/**
	 * 杩斿洖涓や釜瀛楃涓茬被鍨嬬殑鏃ユ湡鐩稿樊鐨勫皬鏃舵暟
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public static int daysBetween2(String startTime, String endTime) {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH");  
        Calendar cal = Calendar.getInstance();    
        long time1 = 0;
        long time2 = 0;
        
        try{
             cal.setTime(sdf.parse(startTime));   
             time1 = cal.getTimeInMillis();    
             cal.setTime(sdf.parse(endTime)); 
             time2 = cal.getTimeInMillis();  
        }catch(Exception e){
            e.printStackTrace();
        }
        long between_days=(time2-time1)/(1000*3600);  
            
       return Integer.parseInt(String.valueOf(between_days));     
    }
	
	/**
	 * 璁＄畻涓や釜鏃ユ湡涔嬮棿鐨勬湀鏁�
	 * @param minDate
	 * @param maxDate
	 * @return
	 * @throws ParseException
	 */
	public static List<String> getMonthBetween(String minDate, String maxDate) {
	    ArrayList<String> result = new ArrayList<String>();
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");//鏍煎紡鍖栦负骞存湀

	    Calendar min = Calendar.getInstance();
	    Calendar max = Calendar.getInstance();

	    try {
			min.setTime(sdf.parse(minDate));
			min.set(min.get(Calendar.YEAR), min.get(Calendar.MONTH), 1);

			max.setTime(sdf.parse(maxDate));
			max.set(max.get(Calendar.YEAR), max.get(Calendar.MONTH), 2);
		} catch (ParseException e) {
			throw new RuntimeException("鏃ユ湡杞崲澶辫触锛�");
		}

	    Calendar curr = min;
	    while (curr.before(max)) {
	     result.add(sdf.format(curr.getTime()));
	     curr.add(Calendar.MONTH, 1);
	    }

	    return result;
	  }
	
	
	/**
     * 璁＄畻涓ゆ鏃ユ湡鐨勯噸鍚堟棩鏈�
     * @param str1 寮�濮嬫棩鏈�1
     * @param str2 缁撴潫鏃ユ湡1
     * @param str3 寮�濮嬫棩鏈�2
     * @param str4 缁撴潫鏃ユ湡2
     * @return
     * @throws Exception
     */
    public static Map<String,Object> comparisonRQ(String str1, String str2, String str3,
            String str4) throws Exception {
        String mesg = "";
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String startdate = "";
        String enddate = "";
        try {
            Date dt1 = df.parse(str1);
            Date dt2 = df.parse(str2);
            Date dt3 = df.parse(str3);
            Date dt4 = df.parse(str4);
            if (dt1.getTime()<=dt3.getTime()&&dt3.getTime()<=dt2.getTime()&&dt2.getTime()<=dt4.getTime()) {
                mesg = "f";//閲嶅悎
                startdate = str3;
                enddate = str2;
            }
            if (dt1.getTime()>=dt3.getTime()&&dt3.getTime()<=dt2.getTime()&&dt2.getTime()<=dt4.getTime()) {
                mesg = "f";//閲嶅悎
                startdate = str1;
                enddate = str2;
            }
            
            if (dt3.getTime()<=dt1.getTime()&&dt1.getTime()<=dt4.getTime()&&dt4.getTime()<=dt2.getTime()) {
                mesg = "f";//閲嶅悎
                startdate = str1;
                enddate = str4;
            }
            if (dt3.getTime()>=dt1.getTime()&&dt1.getTime()<=dt4.getTime()&&dt4.getTime()<=dt2.getTime()) {
                mesg = "f";//閲嶅悎
                startdate = str3;
                enddate = str4;
            }
            
            System.out.println(startdate+"----"+enddate);
            
            
        }catch (ParseException e) {
            e.printStackTrace();
            throw new ParseException(e.getMessage(), 0);
        }catch(Exception e){
            e.printStackTrace();
            throw new Exception(e);
        }
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("startdate", startdate);
        map.put("enddate", enddate);
        return map;
    }
    
	public static int compareDateToMonth(String DATE1, String DATE2) {

		DateFormat df = new SimpleDateFormat("yyyy-MM");
		try {
			Date dt1 = df.parse(DATE1);
			Date dt2 = df.parse(DATE2);
			if (dt1.getTime() > dt2.getTime()) {
				System.out.println("dt1 鍦╠t2鍓�");
				return 1;
			} else if (dt1.getTime() < dt2.getTime()) {
				System.out.println("dt1鍦╠t2鍚�");
				return -1;
			} else {
				return 0;
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return 0;
	}
	
	/**
	 * 寰楀埌鎸囧畾鏃ユ湡鐨勪笂涓�涓ぉ锛屾湀锛屽勾
	 * 
	 * @return
	 */
	@SuppressWarnings("finally")
	public static String getLastMonth(String dateStr, int addYear, int addMonth, int addDate){
		String dateTmp = "";
		try {
			java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH");
			java.util.Date sourceDate = sdf.parse(dateStr);
			Calendar cal = Calendar.getInstance();
			cal.setTime(sourceDate);
			cal.add(Calendar.YEAR, addYear);
			cal.add(Calendar.MONTH, addMonth);
			cal.add(Calendar.DATE, addDate);

			java.text.SimpleDateFormat returnSdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH");
			dateTmp = returnSdf.format(cal.getTime());
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			return dateTmp;
		}
	}
    
    public static void main(String[] args) throws Exception {
    	System.out.println(getDateTimeFormatNo(new Date()));
	}
	
}