// Copyright 2007, CargoSmart, Inc.

package com.common.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import javax.xml.datatype.DatatypeFactory;

import sun.util.calendar.BaseCalendar;
import sun.util.calendar.CalendarSystem;

import org.apache.commons.lang.time.DateUtils;

import com.common.util.StringUtil;

public final class DateService {
  public static final String DEFAULT_TIMEZONE_CODE = "GMT";
  public static final Long DEFAULT_TIMEZONE_ID = 269L;
  public static final String GMT_PLUS_8_CODE = "GMT+8";
  public static final String SHORT_YEAR_FORMAT = "yy";
  public static final String EXCEL_DATE_FORMAT = "dd-MMM-yyyy";
  public static final String DATE_PICKER_DATE_FORMAT = "dd MMM yyyy";
  public static final String DATE_PICKER_DATE_FORMAT_WITH_TIME = "dd MMM yyyy,HH:mm";
  public static final String DEFAULT_DATE_FORMAT = "dd MMM yyyy, HH:mm";
  public static final String DEFAULT_DATE_FORMAT_SECOND = "dd MMM yyyy, HH:mm:ss";
  public static final String DEFAULT_DATE_FORMAT_WITH_TIMEZONE = "dd MMM yyyy, HH:mm z";
  public static final String DATE_FORMAT_WITHOUT_TIME = "yyyyMMdd";
  public static final String DATE_FORMAT_WITHOUT_MS = "yyyyMMddHHmm";
  public static final String PLAIN_DATE_FORMAT = "yyyyMMddHHmmss";
  public static final String PDF_PRINT_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss";
  public static final String SOLR_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
  public static final String SOA_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";
  public static final String TIME_FORMAT = "HH:mm:ss";
  public static final String FULL_TIME_FORMAT = "HHmmssSSS";
  public static final String SLASH_TIME_FORMAT = "MM/dd/yyyy";
  public static final String PDF_SLASH_TIME_FORMAT = "dd/MM/yyyy";
  public static final String SLASH_TIME_FORMAT_SHORT_YEAR = "MM/dd/yy";
  public static final String MILLS_DATE_FORMAT = "dd MMM yyyy hh:mm:ss,SSS";
  public static final String SOLR_DATE_FORMAT_IN_SECOND = "yyyy-MM-dd'T'HH:mm:ss'Z'";
  public static final String PLAIN_MILLS_DATE_FORMAT = "yyyyMMddHHmmssSSS";
  public static final String NORMAL_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
  public static final String NORMAL_DATE_SHORT_FORMAT = "yyyy-MM-dd";

  public static final String DATE_PICKER_DEFAULT_DATE = "dd mmm yyyy";
  public static final String DATE_PICKER_DEFAULT_DATE_WITH_TIME = "dd mmm yyyy, hh:mm";
  public static final String DATE_WITHOUT_TIMEZONE = "dd MMM yyyy EEE";

  public static final DateFormat MILLS_DATE_FORMATTER = new SimpleDateFormat(MILLS_DATE_FORMAT);

  public static final String LOCAL = " Local ";
  public static final int SECONDS_IN_A_DAY = 24 * 60 * 60;
  public static final long MILLISECONDS_IN_A_WEEK = 7 * 24 * 60 * 60 * 1000;
  public static final long MILLISECONDS_IN_A_DAY = 24 * 60 * 60 * 1000;
  public static final long MILLISECONDS_IN_AN_HOUR = 60 * 60 * 1000;
  public static final long MILLISECONDS_IN_A_MINUTE = 60 * 1000;
  public static final long MILLISECONDS_IN_A_SECOND = 1000;

  public static final int MINUTES_IN_A_DAY = 24 * 60;

  public static int DAYS_OF_TWO_WEEKS = 14;
  private TimeZone timeZone;
  private BaseCalendar.Date baseCalendarDate;

  private BaseCalendar calendar = (BaseCalendar) CalendarSystem.getGregorianCalendar();
  private static DateService dateService = new DateService();
  public static ThreadLocal<SimpleDateFormat> dateTimeFormatThreadLocal = new ThreadLocal<SimpleDateFormat>();
  public static ThreadLocal<String> userPreferredFullTimeZoneIDThreadLocal = new ThreadLocal<String>();

  public static DateService getInstance() {
    if (!StringUtil.compareAfterTrimToEmpty(TimeZone.getDefault().getID(), DEFAULT_TIMEZONE_CODE)) {
      dateService.setDefaultTimeZoneAsGMT();
    }
    return dateService;
  }

  private DateService() {
  }

  private void setDefaultTimeZoneAsGMT() {
    timeZone = TimeZone.getTimeZone(DEFAULT_TIMEZONE_CODE);
    TimeZone.setDefault(timeZone);
  }

  public Date today() {
    return now();
  }

  public Date tomorrow() {
    return convertToTimeZone(new Date((calendar.getTime(nowCalendarDate())) + MILLISECONDS_IN_A_DAY), DEFAULT_TIMEZONE_CODE);
  }

  public Date yesterday() {
    return convertToTimeZone(new Date((calendar.getTime(nowCalendarDate())) - MILLISECONDS_IN_A_DAY), DEFAULT_TIMEZONE_CODE);
  }

  public Date now() {
    return convertToTimeZone(new Date(calendar.getTime(nowCalendarDate())), DEFAULT_TIMEZONE_CODE);
  }

  public Date startDayOfToday() {
    return getStartDateTimeOfDay(today());
  }

  public Date endDayOfToday() {
    return getEndDateTimeOfDay(today());
  }

  public Date startDayOfYesterday() {
    return getStartDateTimeOfDay(yesterday());
  }

  public Date addMonths(Date baseDate, int months) {
    Calendar commonCalendar = Calendar.getInstance();
    commonCalendar.setTime(baseDate);
    commonCalendar.add(Calendar.MONTH, months);
    return commonCalendar.getTime();
  }

  public Date addDays(Date dateGMT, int days) {
    return addMilliSeconds(dateGMT, days * MILLISECONDS_IN_A_DAY);
  }

  public Date addWeeks(Date dateGMT, int weeks) {
    return addMilliSeconds(dateGMT, weeks * MILLISECONDS_IN_A_WEEK);
  }

  public Date getDaysLater(int daysLater) {
    return addDays(now(), daysLater);
  }

  public Date subtractDays(Date dateGMT, int days) {
    return subtractMilliSeconds(dateGMT, days * MILLISECONDS_IN_A_DAY);
  }

  public Date addTime(Date dateGMT, String timeString, String pattern) throws ParseException {
    return addMilliSeconds(dateGMT, parse(timeString, pattern, DEFAULT_TIMEZONE_CODE).getTime());
  }

  public Date addTime(Date dateGMT, Date timeGMT) throws ParseException {
    if (timeGMT == null) {
      return dateGMT;
    }
    String formatedTime = formatDate(FULL_TIME_FORMAT, timeGMT);
    return addTime(dateGMT, formatedTime, FULL_TIME_FORMAT);
  }

  public Date addHours(Date dateGMT, int hours) {
    return addMilliSeconds(dateGMT, hours * MILLISECONDS_IN_AN_HOUR);
  }

  public Date subtractHours(Date dateGMT, int hours) {
    return subtractMilliSeconds(dateGMT, hours * MILLISECONDS_IN_AN_HOUR);
  }

  public Date addMinutes(Date dateGMT, int minutes) {
    return addMilliSeconds(dateGMT, minutes * MILLISECONDS_IN_A_MINUTE);
  }

  public Date subtractMinutes(Date dateGMT, int minutes) {
    return subtractMilliSeconds(dateGMT, minutes * MILLISECONDS_IN_A_MINUTE);
  }

  public Date addSeconds(Date dateGMT, int seconds) {
    return addMilliSeconds(dateGMT, seconds * MILLISECONDS_IN_A_SECOND);
  }

  public Date subtractSeconds(Date dateGMT, int seconds) {
    return subtractMilliSeconds(dateGMT, seconds * MILLISECONDS_IN_A_SECOND);
  }

  public Date addMilliSeconds(Date dateGMT, long milliSeconds) {
    return new Date(calendar.getTime(calendar.getCalendarDate(dateGMT.getTime() + milliSeconds, timeZone)));
  }

  public Date subtractMilliSeconds(Date dateGMT, long milliSeconds) {
    return new Date(calendar.getTime(calendar.getCalendarDate(dateGMT.getTime() - milliSeconds, timeZone)));
  }

  public Date resetBaseDateTime(Date baseDate, int hour, int minute, int second) {
    if (null == baseDate) {
      return null;
    }
    Calendar commonCalendar = Calendar.getInstance();
    commonCalendar.setTime(baseDate);
    commonCalendar.set(Calendar.HOUR_OF_DAY, hour);
    commonCalendar.set(Calendar.MINUTE, minute);
    commonCalendar.set(Calendar.SECOND, second);
    return commonCalendar.getTime();
  }

  public Date createDateTime(int year, int month, int day, int hour, int minute, int second) {
    Date date = createDate(year, month, day);
    return resetBaseDateTime(date, hour, minute, second);
  }

  public Date resetBaseDateTime(Date baseDate, int hour, int minute, int second, int milliSeconds) {
    if (null == baseDate) {
      return null;
    }
    Calendar commonCalendar = Calendar.getInstance();
    commonCalendar.setTime(this.resetBaseDateTime(baseDate, hour, minute, second));
    commonCalendar.set(Calendar.MILLISECOND, milliSeconds);
    return commonCalendar.getTime();
  }

  public boolean isEqualToOrBefore(Date earlierDate, Date laterDate) {
    return compareTo(earlierDate, laterDate) <= 0;
  }

  public boolean isEqualToOrAfter(Date laterDate, Date earlierDate) {
    return compareTo(earlierDate, laterDate) <= 0;
  }

  public int compareTo(Date date1, Date date2) {
    if (date1 == null && date2 == null) {
      return 0;
    }
    if (date1 == null) {
      return -1;
    }
    if (date2 == null) {
      return 1;
    }
    return date1.compareTo(date2);
  }

  public Date getDate(Calendar calendar) {
    if (calendar != null) {
      return calendar.getTime();
    } else {
      return null;
    }
  }

  public Date getStartDateTimeOfDay(Date date) {
    if (null == date) {
      return null;
    }
    return resetBaseDateTime(date, 0, 0, 0, 0);
  }

  public Date getEndDateTimeOfDay(Date date) {
    if (null == date) {
      return null;
    }
    return resetBaseDateTime(date, 23, 59, 59, 999);
  }

  // The Month should be started by 0, Jan should be 0, Feb should be 1...
  public Date createDate(int year, int month, int date) {
    Calendar calendar = Calendar.getInstance();
    calendar.set(year, month, date);
    return calendar.getTime();
  }

  public long getTimeInMillis(Date date) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    return calendar.getTimeInMillis();
  }

  public long getMillisecondsInDateTimeFormat() {
    return Long.parseLong(formatDate(PLAIN_DATE_FORMAT, now()));
  }

  public long getMillisecondsInDateTimeFormat(Date dateGMT) {
    if (null == dateGMT) {
      return 0;
    }
    return Long.parseLong(formatDate(PLAIN_DATE_FORMAT, dateGMT));
  }

  public long getDiffInMillis(Date date1, Date date2) {
    return getTimeInMillis(date1) - getTimeInMillis(date2);
  }

  protected BaseCalendar.Date nowCalendarDate() {
    if (baseCalendarDate == null) {
      return (BaseCalendar.Date) calendar.getCalendarDate(System.currentTimeMillis(), timeZone);
    } else {
      return baseCalendarDate;
    }
  }

  public Calendar nowCalendarGMT() {
    return Calendar.getInstance(TimeZone.getTimeZone("GMT"));
  }

  public void setBaseDate(Date baseDateGMT) {
    if (baseDateGMT != null) {
      baseCalendarDate = (BaseCalendar.Date) calendar.getCalendarDate(convertToTimeZone(baseDateGMT, getTimeZone(DEFAULT_TIMEZONE_CODE),
          TimeZone.getDefault()).getTime(), timeZone);
    } else {
      baseCalendarDate = null;
    }
  }

  protected void rollDayForward(int day) {
    if (baseCalendarDate == null) {
      throw new RuntimeException("There is no base date.");
    }
    baseCalendarDate = (BaseCalendar.Date) calendar.getCalendarDate(calendar.getTime(baseCalendarDate) + day * MILLISECONDS_IN_A_DAY, timeZone);
  }

  protected void rollDayBackward(int day) {
    if (baseCalendarDate == null) {
      throw new RuntimeException("There is no base date.");
    }
    baseCalendarDate = (BaseCalendar.Date) calendar.getCalendarDate(calendar.getTime(baseCalendarDate) - day * MILLISECONDS_IN_A_DAY, timeZone);
  }

  protected void rollHourForward(int hour) {
    if (baseCalendarDate == null) {
      throw new RuntimeException("There is no base date.");
    }
    baseCalendarDate = (BaseCalendar.Date) calendar.getCalendarDate(calendar.getTime(baseCalendarDate) + hour * MILLISECONDS_IN_AN_HOUR, timeZone);
  }

  protected void rollHourBackward(int hour) {
    if (baseCalendarDate == null) {
      throw new RuntimeException("There is no base date.");
    }
    baseCalendarDate = (BaseCalendar.Date) calendar.getCalendarDate(calendar.getTime(baseCalendarDate) - hour * MILLISECONDS_IN_AN_HOUR, timeZone);
  }

  public void rollMinuteForward(int minute) {
    if (baseCalendarDate == null) {
      throw new RuntimeException("There is no base date.");
    }
    baseCalendarDate = (BaseCalendar.Date) calendar.getCalendarDate(calendar.getTime(baseCalendarDate) + minute * MILLISECONDS_IN_A_MINUTE, timeZone);
  }

  public void rollMinuteBackward(int minute) {
    if (baseCalendarDate == null) {
      throw new RuntimeException("There is no base date.");
    }
    baseCalendarDate = (BaseCalendar.Date) calendar.getCalendarDate(calendar.getTime(baseCalendarDate) - minute * MILLISECONDS_IN_A_MINUTE, timeZone);
  }

  public Date getWeekOfCurrentDay(Date date, int num) {
    Calendar c = Calendar.getInstance();
    c.setTime(date);
    if (num == 1) {
      c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
    } else if (num == 2) {
      c.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
    } else if (num == 3) {
      c.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
    } else if (num == 4) {
      c.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
    } else if (num == 5) {
      c.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
    } else if (num == 6) {
      c.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
    } else if (num == 0) {
      c.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
    }
    return c.getTime();
  }

  public Date getMonday(Date date) {
    return getWeekOfCurrentDay(date, 1);
  }

  /*
   * For UI only
   */
  public String convertToUserPreferredTimeZone(Date dateGMT, String dateTimeFormat) {
    return formatDate(getUserPreferredFullTimeZoneID(), dateGMT, dateTimeFormat);
  }

  /*
   * For UI only
   */
  public Date convertToUserPreferredTimeZone(Date dateGMT) {
    return convertToTimeZone(dateGMT, DEFAULT_TIMEZONE_CODE, getUserPreferredFullTimeZoneID());
  }

  /*
   * For UI only
   */
  public Date convertUserPreferredDateToGMT(String dateString, String dateTimeFormat) throws ParseException {
    return convertToTimeZone(parse(dateString, dateTimeFormat), getUserPreferredFullTimeZoneID(), DEFAULT_TIMEZONE_CODE);
  }

  /*
   * For UI only
   */
  public Date convertUserPreferredDateToGMT(Date userPreferredDate) throws ParseException {
    return convertToTimeZone(userPreferredDate, getUserPreferredFullTimeZoneID(), DEFAULT_TIMEZONE_CODE);
  }

  public Date convertToGMT(String dateString, String fromFullTimeZoneID, String dateTimeFormat) throws ParseException {
    return convertToTimeZone(parse(dateString, dateTimeFormat, fromFullTimeZoneID), DEFAULT_TIMEZONE_CODE);
  }

  public Date convertToGMT(Date date, String fromFullTimeZoneID) {
    return convertToTimeZone(date, fromFullTimeZoneID, DEFAULT_TIMEZONE_CODE);
  }

  public Date convertToTimeZone(Date date, String fromFullTimeZoneID, String toFullTimeZoneID) {
    return convertToTimeZone(date, getTimeZone(fromFullTimeZoneID), getTimeZone(toFullTimeZoneID));
  }

  public Date convertToTimeZone(Date date, String toFullTimeZoneID) {
    return convertToTimeZone(date, getTimeZone(toFullTimeZoneID));
  }

  public Date convertToTimeZone(Date date, TimeZone toTimeZone) {
    return convertToTimeZone(date, TimeZone.getDefault(), toTimeZone);
  }

  public Date convertToTimeZone(Date date, TimeZone fromTimeZone, TimeZone toTimeZone) {
    if (null == date) {
      return null;
    }
    Calendar calendarDate = Calendar.getInstance();
    calendarDate.setTimeZone(fromTimeZone);
    calendarDate.setTime(date);
    long milliTime = calendarDate.getTimeInMillis();
    int oldOffset = calendarDate.getTimeZone().getOffset(milliTime);
    calendarDate.setTimeZone(toTimeZone);
    milliTime = calendarDate.getTimeInMillis();
    int newOffset = calendarDate.getTimeZone().getOffset(milliTime);
    int diff = newOffset - oldOffset;
    milliTime += diff;
    calendarDate.setTimeInMillis(milliTime);
    return calendarDate.getTime();
  }

  public TimeZone getTimeZone(String timeZoneID) {
    if (StringUtil.isNullOrEmpty(timeZoneID)) {
      return TimeZone.getTimeZone(DEFAULT_TIMEZONE_CODE);
    }
    String localTimeZoneID = timeZoneID.trim();
    int beginIndex = localTimeZoneID.lastIndexOf(' ');
    if (beginIndex > 0) {
      return TimeZone.getTimeZone(localTimeZoneID.substring(beginIndex + 1));
    }
    return TimeZone.getTimeZone(localTimeZoneID);
  }

  public String getTimeZoneCode(String timeZoneID) {
    if (StringUtil.isNullOrEmpty(timeZoneID)) {
      return DEFAULT_TIMEZONE_CODE;
    }
    String localTimeZoneID = timeZoneID.trim();
    int beginIndex = localTimeZoneID.indexOf(' ');
    if (beginIndex > 0) {
      return localTimeZoneID.substring(0, beginIndex);
    }
    return localTimeZoneID;
  }

  public String formatDate(Date dateGMT, boolean withTimeZoneCode) {
    return formatDate(dateGMT, DEFAULT_TIMEZONE_CODE, DEFAULT_DATE_FORMAT, withTimeZoneCode);
  }

  public String formatCurrentDate(boolean withTimeZoneCode) {
    return formatDate(getInstance().now(), withTimeZoneCode);
  }

  public String formatDate(Date dateGMT) {
    return formatDate(dateGMT, DEFAULT_TIMEZONE_CODE, DEFAULT_DATE_FORMAT, true);
  }

  public String formatToSlashDate(Date dateGMT) {
    return formatDate(dateGMT, DEFAULT_TIMEZONE_CODE, SLASH_TIME_FORMAT, false);
  }

  public String formatDate(Date dateGMT, String timeZoneID) {
    return formatDate(dateGMT, timeZoneID, DEFAULT_DATE_FORMAT, true);
  }

  public String formatDate(Date dateGMT, String timeZoneID, boolean withTimeZoneCode) {
    return formatDate(dateGMT, timeZoneID, DEFAULT_DATE_FORMAT, withTimeZoneCode);
  }

  public String formatDate(Date dateGMT, String timeZoneID, String dateFormat, boolean withTimeZoneCode) {
    return formatDate(dateGMT, getTimeZone(timeZoneID), dateFormat) + (dateGMT != null && withTimeZoneCode ? " " + getTimeZoneCode(timeZoneID) : "");
  }

  public String formatDate(Date dateGMT, TimeZone timeZone) {
    return formatDate(dateGMT, timeZone, DEFAULT_DATE_FORMAT);
  }

  public SimpleDateFormat getDateTimeFormat(String dateTimeFormatString) {
    if (dateTimeFormatThreadLocal.get() == null
        || !StringUtil.compareAfterTrimToEmpty(dateTimeFormatThreadLocal.get().toPattern(), dateTimeFormatString)) {
      dateTimeFormatThreadLocal.set(new SimpleDateFormat(dateTimeFormatString));
    }
    return dateTimeFormatThreadLocal.get();
  }

  public String formatDateToGmt(Date date, TimeZone timeZone, String dateFormat) {
    if (null == date) {
      return "";
    }
    SimpleDateFormat simpleDateFormat = getDateTimeFormat(StringUtil.isNullOrEmpty(dateFormat) ? DEFAULT_DATE_FORMAT : dateFormat);
    return simpleDateFormat.format(timeZone != null ? convertToTimeZone(date, timeZone, getTimeZone(DEFAULT_TIMEZONE_CODE)) : date);
  }

  /*
   * For UI only
   */
  public String getUserPreferredFullTimeZoneID() {
    return userPreferredFullTimeZoneIDThreadLocal.get();
  }

  public void setUserPreferredFullTimeZoneID(String userPreferredFullTimeZoneID) {
    userPreferredFullTimeZoneIDThreadLocal.set(userPreferredFullTimeZoneID);
  }

  public String formatDate(Date dateGMT, TimeZone timeZone, String dateFormat) {
    if (null == dateGMT) {
      return "";
    }
    SimpleDateFormat simpleDateFormat = getDateTimeFormat(StringUtil.isNullOrEmpty(dateFormat) ? DEFAULT_DATE_FORMAT : dateFormat);
    return simpleDateFormat.format(timeZone != null ? convertToTimeZone(dateGMT, getTimeZone(DEFAULT_TIMEZONE_CODE), timeZone) : dateGMT);
  }

  public String formatDate(String tofullTimeZoneID, Date dateGMT, String dateTimeFormat) {
    return formatDate(dateGMT, getTimeZone(tofullTimeZoneID), dateTimeFormat);
  }

  public String formatDate(String dateFormat, Date dateGMT) {
    if (null == dateGMT) {
      return "";
    }
    SimpleDateFormat simpleDateFormat = getDateTimeFormat(StringUtil.isNullOrEmpty(dateFormat) ? DEFAULT_DATE_FORMAT : dateFormat);
    return simpleDateFormat.format(dateGMT);
  }

  public String formatDateToLocalWithOffSet(Date date, TimeZone timeZone) {
    if (null == date) {
      return "";
    }
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(SOA_DATE_FORMAT);
    simpleDateFormat.setTimeZone(timeZone);
    String dateStr = simpleDateFormat.format(date);
    StringBuilder sb = new StringBuilder(dateStr);
    sb.insert(26, StringUtil.COLON);
    return sb.toString();
  }

  public Date parse(String dateString, String pattern) throws ParseException {
    DateFormat df = new SimpleDateFormat(pattern);
    return df.parse(dateString);
  }

  public Date parse(String dateString, String pattern, String fullTimeZoneID) throws ParseException {
    DateFormat df = new SimpleDateFormat(pattern);
    df.setTimeZone(getTimeZone(fullTimeZoneID));
    return df.parse(dateString);
  }

  public Date parseXmlDateTimeString(String xmlDatetimeString) {
    Date date = null;
    if (StringUtil.isNotNullNorEmpty(xmlDatetimeString)) {
      try {
        DatatypeFactory dataFactory = DatatypeFactory.newInstance();
        date = dataFactory.newXMLGregorianCalendar(xmlDatetimeString).toGregorianCalendar().getTime();
      } catch (Exception e) {
        throw new RuntimeException("Can't parse xml datatime string:" + xmlDatetimeString, e);
      }
    }
    return date;
  }

  public String formatXmlDateTime(Date date) {
    String xmlDatetime = null;
    if (date != null) {
      try {
        DatatypeFactory dataFactory = DatatypeFactory.newInstance();
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        xmlDatetime = dataFactory.newXMLGregorianCalendar(calendar).toString();
      } catch (Exception e) {
        throw new RuntimeException("Can't format date to xml datetime:" + date, e);
      }
    }
    return xmlDatetime;
  }

  public int getMonthOfYear(Date dateTime) {
    Calendar commonCalendar = Calendar.getInstance();
    commonCalendar.setTime(dateTime);
    return commonCalendar.get(Calendar.MONTH) + 1;
  }

  public int getDayOfMonth(Date dateTime) {
    Calendar commonCalendar = Calendar.getInstance();
    commonCalendar.setTime(dateTime);
    return commonCalendar.get(Calendar.DAY_OF_MONTH);
  }

  public int getDayOfWeek(Date dateTime) {
    Calendar commonCalendar = Calendar.getInstance();
    commonCalendar.setTime(dateTime);
    return commonCalendar.get(Calendar.DAY_OF_WEEK);
  }

  public int getCurrentDayOfWeek(String timeZoneID) {
    return Calendar.getInstance(getTimeZone(timeZoneID)).get(Calendar.DAY_OF_WEEK);
  }

  public int getHour(Date dateTime) {
    Calendar commonCalendar = Calendar.getInstance();
    commonCalendar.setTime(dateTime);
    return commonCalendar.get(Calendar.HOUR_OF_DAY);
  }

  public int getMinute(Date dateTime) {
    Calendar commonCalendar = Calendar.getInstance();
    commonCalendar.setTime(dateTime);
    return commonCalendar.get(Calendar.MINUTE);
  }

  public String getLocalTimeZone(String localTimeZone) {
    if (StringUtil.isNotNullNorEmpty(localTimeZone)) {
      return localTimeZone;
    } else {
      return TimeZone.getDefault().getDisplayName(false, TimeZone.SHORT);
    }
  }

  public String getCargoSmartTimeZone(String csTimeZone) {
    if (StringUtil.isNotNullNorEmpty(csTimeZone)) {
      return csTimeZone;
    } else {
      return LOCAL;
    }
  }

  public long getWeeksBetweenDates(Date date1, Date date2) {
    return getDiffInMillis(date1, date2) / (DateService.MILLISECONDS_IN_A_DAY * 7);
  }

  public boolean isTheSameDate(Date date1, Date date2) {
    return compareTo(date1, date2) == 0;
  }

  public boolean isTheSameDateIgnoreSecond(Calendar calendar1, Calendar calendar2) throws ParseException {
    if (calendar1 == null || calendar2 == null) {
      return (calendar1 == calendar2);
    }
    calendar1.set(Calendar.SECOND, 0);
    calendar1.set(Calendar.MILLISECOND, 0);
    calendar2.set(Calendar.SECOND, 0);
    calendar2.set(Calendar.MILLISECOND, 0);
    return isTheSameDate(convertToGMT(calendar1.getTime(), calendar1.getTimeZone().getID()), convertToGMT(calendar2.getTime(), calendar2
        .getTimeZone().getID()));
  }


  public Calendar convertToCalendarGMT(Date dateGMT) {
    if (null == dateGMT) {
      return null;
    }
    Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
    calendar.setTime(dateGMT);
    calendar.set(Calendar.MILLISECOND, 0);
    return calendar;
  }


  public String formatDateRange(Date startDateGMT, Date endDateGMT, TimeZone timeZone, String dateFormat) {
    if (startDateGMT != null && endDateGMT != null) {
      return formatDate(startDateGMT, timeZone, dateFormat) + " - " + formatDate(endDateGMT, timeZone, dateFormat);
    }
    if (startDateGMT == null && endDateGMT != null) {
      return " - " + formatDate(endDateGMT, timeZone, dateFormat);
    }
    if (startDateGMT != null && endDateGMT == null) {
      return formatDate(startDateGMT, timeZone, dateFormat) + " + ";
    }
    return null;
  }

  public Date getEarlierDate(Date date1, Date date2) {
    if (date1 == null) {
      return date2;
    }
    if (date2 == null) {
      return date1;
    }
    return date1.before(date2) ? date1 : date2;
  }

  public Calendar createCalendar(Date date) {
    if (null != date) {
      Calendar calendar = Calendar.getInstance();
      calendar.setTime(date);
      return calendar;
    }
    return null;
  }

  public int getIntervalDays(Date fromDate, Date toDate) {
    Date startDate = fromDate;
    Date endDate = toDate;
    if (startDate.after(endDate)) {
      Date tempDate = startDate;
      startDate = endDate;
      endDate = tempDate;
    }
    long fromDateTime = startDate.getTime();
    long endDateTime = endDate.getTime();
    long ei = endDateTime - fromDateTime;
    return (int) (ei / (1000 * 60 * 60 * 24));
  }

  public int getIntervalHours(Date fromDate, Date toDate) {
    Date startDate = fromDate;
    Date endDate = toDate;
    if (startDate.after(endDate)) {
      Date tempDate = startDate;
      startDate = endDate;
      endDate = tempDate;
    }
    long fromDateTime = startDate.getTime();
    long endDateTime = endDate.getTime();
    long ei = endDateTime - fromDateTime;
    return (int) (ei / (1000 * 60 * 60));
  }

  public String printNowForPDF() {
    return formatDate(PDF_PRINT_DATE_FORMAT, now());
  }

  public String getFormattedDateWithTimeZone(Date date, String timeZone) {
    if (date == null) {
      return StringUtil.EMPTY_STRING;
    }
    StringBuffer formattedDate = new StringBuffer(convertDateToStringWithFormat(date, DEFAULT_DATE_FORMAT));
    if (StringUtil.isNotNullNorEmpty(timeZone)) {
      formattedDate.append(StringUtil.SPACE_STRING).append(getTimeZoneCode(timeZone));
    }
    return formattedDate.toString();
  }

  public static boolean isDateInDatePeriod(Date target, Date from, Date to) {
    if ((from == null && to == null)) {
      return true;
    }
    if (target == null) {
      return false;
    }
    if (from == null) {
      return target.compareTo(to) <= 0;
    } else if (to == null) {
      return target.compareTo(from) >= 0;
    } else {
      return target.compareTo(to) <= 0 && target.compareTo(from) >= 0;
    }
  }

  public String getDatePickerFomatDate(Date date) {
    return convertDateToStringWithFormat(date, DATE_PICKER_DATE_FORMAT);
  }

  public String convertDateToStringWithFormat(Date date, String fromat) {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(fromat);
    return simpleDateFormat.format(date);
  }

  public Date convertedDate(String dateVal, String dateFormat) {
    Date date = null;
    if (StringUtil.isNotNullNorEmpty(dateVal)) {
      try {
        date = parse(dateVal, dateFormat);
      } catch (Exception e) {
        date = null;
      }
    }
    return date;
  }

  public Date getTruncateToDateTime(int timeZoneId) {
    Date gmtDate = DateService.getInstance().now();
    if (timeZoneId != 0) {
      String timeZoneCode = "GMT" + (timeZoneId > 0 ? "+" : "-") + timeZoneId;
      Date localDate = DateService.getInstance().convertToTimeZone(gmtDate, timeZoneCode);
      localDate = DateService.getInstance().resetBaseDateTime(localDate, 0, 0, 0, 0);
      gmtDate = DateService.getInstance().addHours(localDate, -timeZoneId);
    } else {
      gmtDate = DateUtils.truncate(gmtDate, Calendar.DATE);
    }
    return gmtDate;
  }

}
