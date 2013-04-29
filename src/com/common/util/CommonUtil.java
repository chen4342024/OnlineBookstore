/**
 *
 */
package com.common.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.Enumeration;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.ResourceBundle;
import java.util.TimeZone;

import com.common.service.DateService;

public class CommonUtil {

  public static final String ENGLISH = "en-US";
  public static final String SIMPLIFIED_CHINESE = "zh-CN";
  public static final String TRADITIONAL_CHINESE = "zh-TW";
  public static final String JAPANESE = "ja-JP";

  public static <T> boolean isEmptyList(List<T> list) {
    if (list == null || list.size() == 0) {
      return true;
    }
    return false;
  }

  public static <T> boolean isNotEmptyList(List<T> list) {
    return !CommonUtil.isEmptyList(list);
  }

  public static boolean isNotNullObject(Object obj) {
    if (obj != null) {
      return true;
    }
    return false;
  }

  public static boolean isNullObject(Object obj) {
    if (obj == null) {
      return true;
    }
    return false;
  }

  public static int getCurrentYear() {
    Date now = getDateService().now();
    GregorianCalendar calendar = new GregorianCalendar();
    calendar.setTime(now);

    return calendar.get(Calendar.YEAR);
  }

  public static Date getOffsetDateOfToday(int offset, boolean up) {
    Date today = getDateService().now();
    GregorianCalendar calendar = new GregorianCalendar();
    calendar.setTime(today);

    for (int i = 0; i < offset; i++) {
      calendar.roll(Calendar.DAY_OF_YEAR, up);
    }

    Date newDate = getDateService().now();
    newDate.setTime(calendar.getTimeInMillis());

    return newDate;
  }

  public static Date addOffsetDateOfToday(int offset, boolean up) {
    Date today = getDateService().now();
    GregorianCalendar calendar = new GregorianCalendar();
    calendar.setTime(today);

    calendar.add(Calendar.DAY_OF_YEAR, offset);

    Date newDate = getDateService().now();
    newDate.setTime(calendar.getTimeInMillis());

    return newDate;
  }

  public static GregorianCalendar getOffsetCalendarOfToday(int offset, boolean up) {
    Date today = getDateService().now();
    DateService dateService = DateService.getInstance();
    long millInADay = up ? (24 * 60 * 60 * 1000) : (-24 * 60 * 60 * 1000);
    for (int i = 0; i < offset; i++) {
      today = dateService.addMilliSeconds(today, millInADay);
    }
    GregorianCalendar calendar = new GregorianCalendar();
    calendar.setTime(today);
    return calendar;
  }

  public static GregorianCalendar getOffsetCalendar(Date date, int offset, boolean up) {
    GregorianCalendar newCalendar = new GregorianCalendar();
    newCalendar.setTime(date);
    for (int i = 0; i < offset; i++) {
      newCalendar.roll(Calendar.DAY_OF_YEAR, up);
    }

    return newCalendar;
  }

  public static String getCurrentDateString(int style, String timeZone, String locale) {
    String currentDateString = "";
    Date now = getDateService().now();
    TimeZone currentTimeZone = TimeZone.getTimeZone(timeZone);

    SimpleDateFormat dateFormatter = null;

    if (SIMPLIFIED_CHINESE.equals(locale) || TRADITIONAL_CHINESE.equals(locale)) {
      dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
    } else if (JAPANESE.equals(locale)) {
      dateFormatter = new SimpleDateFormat("yyyy/MM/dd");
    } else {
      dateFormatter = new SimpleDateFormat("dd MMM yyyy");
    }
    dateFormatter.setTimeZone(currentTimeZone);
    currentDateString = dateFormatter.format(now);
    // Locale aLocale = null;
    //
    // if (StringUtil.isNotNullNorEmpty(locale) && locale.length()==5){
    // aLocale =new Locale(locale.substring(0, 2), locale.substring(3));
    // }else{
    // aLocale = Locale.US;
    // }
    //
    // TimeZone currentTimeZone = TimeZone.getTimeZone(timeZone);
    //
    // DateFormat dateFormatter = DateFormat.getDateInstance(style, aLocale);
    // dateFormatter.setTimeZone(currentTimeZone);
    // Date now = getDateService().now() ;
    // currentDateString = dateFormatter.format(now);

    return currentDateString;
  }

  public static String getDateString(Date date, String locale) {
    String dateTimeString = "";
    SimpleDateFormat dateFormatter = null;

    if (SIMPLIFIED_CHINESE.equals(locale) || TRADITIONAL_CHINESE.equals(locale)) {
      dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
    } else if (JAPANESE.equals(locale)) {
      dateFormatter = new SimpleDateFormat("yyyy/MM/dd");
    } else {
      dateFormatter = new SimpleDateFormat("dd MMM yyyy");
    }

    dateTimeString = dateFormatter.format(date);
    return dateTimeString;
  }

  public static String getDateTimeString(Date date, String locale) {
    String dateTimeString = "";
    SimpleDateFormat dateFormatter = null;

    if (SIMPLIFIED_CHINESE.equals(locale) || TRADITIONAL_CHINESE.equals(locale)) {
      dateFormatter = new SimpleDateFormat("yyyy-MM-dd, HH:mm");
    } else if (JAPANESE.equals(locale)) {
      dateFormatter = new SimpleDateFormat("yyyy/MM/dd, HH:mm");
    } else {
      dateFormatter = new SimpleDateFormat("dd MMM yyyy, HH:mm");
    }

    dateTimeString = dateFormatter.format(date);
    return dateTimeString;
  }

  public static boolean isCodeExist(ResourceBundle bundle, String key) {
    Enumeration<String> keys = bundle.getKeys();
    while (keys.hasMoreElements()) {
      if (key.equals(keys.nextElement())) {
        return true;
      }
    }

    return false;
  }

  public static <T> List<T> uniqueItemsForList(List<T> list) {
    if (CommonUtil.isEmptyList(list)) {
      return list;
    }

    List<T> tempList = new ArrayList<T>();

    for (int i = 0; i < list.size(); i++) {
      if (!tempList.contains(list.get(i))) {
        tempList.add(list.get(i));
      }
    }

    return tempList;
  }

  public static int transferBooleanToInt(Boolean bObj) {
    int i = 0;
    if (bObj != null && bObj.booleanValue() == true) {
      i = 1;
    }
    return i;
  }

  public static int transferBooleanToInt(boolean bType) {
    int i = 0;
    if (bType == true) {
      i = 1;
    }
    return i;
  }

  public static Integer transferBooleanToInteger(Boolean bObj) {
    Integer i = null;
    if (bObj != null) {
      if (bObj.booleanValue() == true) {
        i = Integer.valueOf(1);
      } else {
        i = Integer.valueOf(0);
      }
    }
    return i;
  }

  public static Integer transferBooleanToInteger(boolean bType) {
    Integer i = null;
    if (bType == true) {
      i = Integer.valueOf(1);
    } else {
      i = Integer.valueOf(0);
    }
    return i;
  }

  public static Boolean transferIntToBoolean(Integer bObj) {
    Boolean bResult = null;
    if (bObj != null) {
      if (bObj.intValue() == 1) {
        bResult = Boolean.TRUE;
      } else {
        bResult = Boolean.FALSE;
      }
    }
    return bResult;
  }

  public static Boolean transferIntToBoolean(int b) {
    Boolean bResult = null;

    if (b == 1) {
      bResult = Boolean.TRUE;
    } else {
      bResult = Boolean.FALSE;
    }

    return bResult;
  }

  public static String getPhoneOrFax(String sCntrCode, String sAreaCode, String sNumber) {
    String sReturnNumber = null;

    if (sNumber != null) {
      if (sCntrCode != null && !sCntrCode.trim().equals("")) {
        sReturnNumber = sCntrCode + "-";
      }
      if (sAreaCode != null && !sAreaCode.trim().equals("")) {
        sReturnNumber = sReturnNumber + sAreaCode + "-";
      }
      sReturnNumber = sReturnNumber + sNumber;
    }
    return sReturnNumber;
  }

  public static String getDateTimeString(Date date, String format, String timeZone) {
    String currentDateString = "";

    TimeZone currentTimeZone = TimeZone.getTimeZone(timeZone);

    SimpleDateFormat dateFormatter = null;

    dateFormatter = new SimpleDateFormat(format);
    dateFormatter.setTimeZone(currentTimeZone);
    currentDateString = dateFormatter.format(date);

    return currentDateString;
  }

  public static void trimObject(Object po) {
    if (po == null) {
      return;
    }
    ArrayList<String> attributeList = new ArrayList<String>();

    try {
      attributeList = retrieveAllAttribute(po.getClass(), attributeList);
      for (String att : attributeList) {
        trimObjectAttribute(po, att);
      }
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  private static void trimObjectAttribute(Object obj, String attribute) throws SecurityException, NoSuchMethodException, IllegalArgumentException,
      IllegalAccessException, InvocationTargetException {
    Class<?> clazz = obj.getClass();
    String getName = makeGetMethodName(attribute);
    String setName = makeSetMethodName(attribute);
    if (getName == null || setName == null) {
      return;
    }
    Method getMe = clazz.getMethod(getName, new Class[0]);
    Method setMe = clazz.getMethod(setName, new Class[] { String.class });
    if (getMe == null || setMe == null || (!String.class.getName().equals(getMe.getReturnType().getName()))) {
      return;
    }
    String value = (String) getMe.invoke(obj, new Object[0]);
    if (value == null) {
      return;
    }
    value = value.trim();
    setMe.invoke(obj, new Object[] { value });
  }

  private static String makeGetMethodName(String name) {
    if (name == null || name.trim().length() < 1) {
      return null;
    }
    return new StringBuffer("get").append(Character.toUpperCase(name.charAt(0))).append(name.substring(1)).toString();
  }

  private static String makeSetMethodName(String name) {
    if (name == null || name.trim().length() < 1) {
      return null;
    }
    return new StringBuffer("set").append(Character.toUpperCase(name.charAt(0))).append(name.substring(1)).toString();
  }

  private static ArrayList<String> retrieveAllAttribute(Class<?> clazz, ArrayList<String> list) {
    if (clazz == null || Object.class.getName().equals(clazz.getClass().getName())) {
      return list;
    }
    Field[] field = clazz.getDeclaredFields();
    for (Field fd : field) {
      String name = fd.getName();
      if (name == null || (!String.class.getName().equals(fd.getType().getName())) || list.contains(name)) {
        continue;
      }
      list.add(name);
    }
    return retrieveAllAttribute(clazz.getSuperclass(), list);
  }

  public static String generatePassword() {
    String password = Long.toHexString(System.currentTimeMillis());
    return password;
  }

  public static Object cloneObject(Object obj) throws Exception {
    ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
    ObjectOutputStream out = new ObjectOutputStream(byteOut);
    out.writeObject(obj);

    ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
    ObjectInputStream in = new ObjectInputStream(byteIn);

    return in.readObject();
  }

  private static DateService getDateService() {
    return DateService.getInstance();
  }

  public static boolean isEqual(Object firstObject, Object secondObject) {
    return (firstObject == secondObject) || (firstObject != null && secondObject != null && (firstObject.equals(secondObject)));
  }

  public static String toString(Object object) {
    return (object == null) ? "" : object.toString();
  }

  public static String combinateStringArray(String[] array, String seperatedString) {
    if (array == null) {
      return "";
    }
    String value = "";
    int beginPos = -1;
    for (int i = 0; i < array.length; i++) {
      if (StringUtil.isNotNullNorEmpty(array[i]) && beginPos == -1) {
        beginPos = i;
        value = array[i];
        continue;
      }
      if (i > beginPos && beginPos > -1) {
        value = value + (StringUtil.isNullOrEmpty(array[i]) ? "" : seperatedString + array[i]);
      }
    }
    return value;
  }

  public static <T extends Comparable<? super T>> int compareTo(T t1, T t2) {
    if (t1 == null && t2 == null) {
      return 0;
    }
    if (t1 == null) {
      return -1;
    }
    if (t2 == null) {
      return 1;
    }
    return t1.compareTo(t2);
  }

  public static <T> int compareTo(T t1, T t2, Comparator<T> comparator) {
    if (t1 == null && t2 == null) {
      return 0;
    }
    if (t1 == null) {
      return -1;
    }
    if (t2 == null) {
      return 1;
    }
    return comparator.compare(t1, t2);
  }
}
