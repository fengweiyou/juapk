package com.juapk.frame.util;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * 
 * @ClassName: Convert 
 * @Description: 
 * @author HUBIN
 * @date 2012-4-29 下午10:05:59 
 * @since 1.0
 */
public class Convert {

    public static final int TREE_SPLIT_PATH_NUM = 3; //目录树分隔位数,如001002代表第一级001的第二个目录
    public static final String DEFAULT_BGCOROR = "#FFFFFF"; //默认背景色
    public static final String SPLIT_OPERATE_SELECTID = ","; //被选择路径字符串中的分隔符
    public static final String SPLIT_OPERATE_HASSELECTED = "*"; //被选中节点标识
    public static final int DEF_PARAME_INT_VALUE = -1; //HTTP默认取出整型值
    public static final String DEF_SELECT_ROOT = ",0,"; //默认选择路径的根目录节点

    /**
     * 得到目录层级数组
     * @param tClass String
     * @return String[]
     */
    public static String[] getLayerPath(String tClass) {
        return getLayerPath(tClass, TREE_SPLIT_PATH_NUM);
    }

    /**
     *
     * @param tClass String
     * @param num int
     * @return String[] 返回目录树中按目录层级数组
     */
    public static String[] getLayerPath(String tClass, int num) {
        if (num == 0) {
            num = TREE_SPLIT_PATH_NUM;
        }
        String[] strs = null;
        int len = tClass.trim().length();
        if (len % num == 0) {
            strs = new String[len / num];
            for (int i = 0; i < strs.length; i++) {
                strs[i] = tClass.substring(i * num, i * num + num);
            }
        }
        return strs;
    }

    
    
    
    public static BigDecimal getBigDecimal(String s, int defval){
        if (s == null) {
            return (new BigDecimal(defval));
        }
        
        try {
            return (new BigDecimal(s));
        }
        catch (NumberFormatException e) {
            return (new BigDecimal(defval));
        }
    }
    
    
    public static short getShort(String strN, short defVal) {
        if (strN == null) {
            return (defVal);
        }

        try {
            return (Short.parseShort(strN));
        }
        catch (NumberFormatException e) {
            return (defVal);
        }
    }

    public static int getInt(String s, int defval) {
        if (s == null) {
            return (defval);
        }

        try {
            return (Integer.parseInt(s));
        }
        catch (NumberFormatException e) {
            return (defval);
        }
    }

    public static float getFloat(String strN, float defVal) {
        if (strN == null) {
            return (defVal);
        }
        float retval;
        try {
            retval = Float.parseFloat(strN);
        }
        catch (NumberFormatException e) {
            retval = defVal;
        }
        return (retval);
    }

    public static long getLong(String strN, long defVal) {
        if (strN == null) {
            return (defVal);
        }
        long retval;
        try {
            retval = Long.parseLong(strN);
        }
        catch (NumberFormatException e) {
            retval = defVal;
        }
        return (retval);
    }
    
    public static long getLong(String strN){
    	return getLong(strN,0);
    }

    public static String getString(String s) {
        return (getString(s, ""));
    }

    public static String getString(Object o) {
        if (o == null) {
            return "";
        }
        else {
            return o.toString().trim();
        }
    }

    public static String getSqlString(String s) {
        if (isEmpty(s)) {
            return ("");
        }
        return (s.trim().replaceAll("'", "’"));
    }

    public static String getString(String s, String defval) {
        if (isEmpty(s)) {
            return (defval);
        }
        return (s.trim());
    }

    public static boolean getBoolean(String b, boolean defval) {
        if (b == null) {
            return (defval);
        }
        String upperB = b.toUpperCase();
        if ("1".equals(b)) {
            return (true);
        }
        if ("0".equals(b)) {
            return (false);
        }
        if ("TRUE".equals(upperB)) {
            return (true);
        }
        if ("FALSE".equals(upperB)) {
            return (false);
        }
        return (defval);
    }

    public static boolean getBoolean(Boolean b) {
        if (b == null) {
            return (false);
        }
        return (b.booleanValue());
    }

    public static boolean isEmpty(String s) {
        if (s == null) {
            return (true);
        }

        if (s.equals("")) {
            return (true);
        }
        return (false);
    }

    public static Date getString2Date(String date) {
        return getString2Date(date, "yyyy-MM-dd HH:mm:ss");
    }

    public static Date getString2Date(String date, String format) {
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        ParsePosition pos = new ParsePosition(0);
        return formatter.parse(date, pos);
    }

    public static String getTimestamp2String(Timestamp tdate) {
        Date date = getTimestamp2Date(tdate);
        return getDate2String(date, "yyyy-MM-dd HH:mm:ss");
    }

    public static String getTimestamp2StringDate(Timestamp tdate) {
        Date date = getTimestamp2Date(tdate);
        return getDate2String(date, "yyyy-MM-dd");
    }
    
    public static String getTimestamp2StringDate2(Timestamp tdate) {
        Date date = getTimestamp2Date(tdate);
        return getDate2String(date, "yyyy-MM");
    }
    
    public static String getDate2String(Date date) {
        return getDate2String(date, "yyyy-MM-dd HH:mm:ss");
    }

    public static String getDate2String(Date date, String format) {
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        return formatter.format(date);
    }

    public static String getDate2Tzone(Date date, TimeZone tzone, Locale locale) {
        DateFormat formatter = DateFormat.getDateTimeInstance(DateFormat.SHORT,
            DateFormat.SHORT, locale);
        formatter.setTimeZone(tzone);
        return formatter.format(date);
    }

    public static Date getTimestamp2Date(Timestamp tdate) {
        Date date = new Date(tdate.getTime());
        return date;
    }

    public static Date getOnlyDate(Date date) {
        Calendar cal = Calendar.getInstance();
        Calendar cal_temp = Calendar.getInstance();

        cal.setTime(date);
        cal_temp.clear();
        cal_temp.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH),
                     cal.get(Calendar.DAY_OF_MONTH));
        return cal_temp.getTime();
    }

    public static int subYears(Timestamp b_date, Timestamp j_date) {
        return subYears(getTimestamp2Date(b_date), getTimestamp2Date(j_date));
    }

    //使用 b_date - j_date 得到相差的年数
    public static int subYears(Date b_date, Date j_date) {
        //Date date = getOnlyDate(j_date);
        //long temp = b_date.getTime() - date.getTime();
        long temp = b_date.getTime() - j_date.getTime();
        if (temp > 0) {
            return (int) ( (temp / (24 * 60 * 60 * 1000)) / 365);
        }
        else {
            return (int) ( ( (temp / (24 * 60 * 60 * 1000)) - 1) / 365);
        }
    }
    
}
