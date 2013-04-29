package com.common.util;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.apache.commons.beanutils.PropertyUtils;

/**
 * 
 * @company: CARGOSMART
 * @author: LINGO
 * @version: 1.0
 * @createdOn: Mar 14, 2007
 * @description:
 * @copyright: Copyright (c) 2007
 */
public class CollectionUtil {
  private CollectionUtil() {
  }

  public static <T> List<T> newArrayList() {
    return new ArrayList<T>();
  }

  private static class DefaultKeyConstructor implements CollectionUtiltMapKeyConstructor {
    public Object construct(Object[] attributeValues) {
      if (attributeValues.length == 1) {
        return attributeValues[0];
      }
      String key = null;
      for (Object attributeValue : attributeValues) {
        if (attributeValue == null) {
          continue;
        }
        if (key == null) {
          key = "";
        } else {
          key += StringUtil.HYPHEN;
        }
        key += attributeValue.toString();
      }
      return key;
    }
  }

  public static CollectionUtiltMapKeyConstructor getDefaultKeyConstructor() {
    return new DefaultKeyConstructor();
  }

  @Deprecated
  public static <T> List<T> toList(T[] objArray) {
    if (null != objArray) {
      return new ArrayList<T>(Arrays.asList(objArray));
    }
    return null;
  }

  public static <T> List<T> toGenericList(T... objArray) {
    if (null != objArray) {
      List<T> objs = new ArrayList<T>();
      for (T obj : objArray) {
        objs.add(obj);
      }
      return objs;
    }
    return null;
  }

  public static <T> List<T> toGenericList(Collection<T> objCollection) {
    if (null != objCollection) {
      List<T> objs = new ArrayList<T>();
      for (T obj : objCollection) {
        objs.add(obj);
      }
      return objs;
    }
    return null;
  }

  public static <T> Set<T> toGenericSet(T... objArray) {
    if (null != objArray) {
      Set<T> objs = new HashSet<T>();
      for (T obj : objArray) {
        if (obj != null) {
          objs.add(obj);
        }
      }
      return objs;
    }
    return null;
  }

  @SuppressWarnings("unchecked")
  public static Set toSet(Object[] objArray) {
    HashSet objSet = null;
    if (null != objArray && objArray.length > 0) {
      objSet = new HashSet();
      for (int i = 0; i < objArray.length; i++) {
        Object object = objArray[i];
        if (null != object) {
          objSet.add(object);
        }
      }
    }
    return objSet;
  }

  public static Object[] addToArray(Object[] objArray, Object obj) {
    return CollectionUtil.addToArray(objArray, obj, (null == objArray) ? 0 : objArray.length);
  }

  public static Object[] addToArray(Object[] objArray, Object obj, int index) {
    if (null == obj) {
      return objArray;
    }

    List<Object> list = new ArrayList<Object>();

    if (null != objArray) {
      list.addAll(Arrays.asList(objArray));
    }

    int localIndex = index;
    if (localIndex < 0) {
      localIndex = 0;
    } else if (localIndex > list.size()) {
      localIndex = list.size();
    }

    list.add(localIndex, obj);

    return list.toArray((Object[]) Array.newInstance(obj.getClass(), 0));
  }

  public static boolean isEmptyList(Collection list) {
    return list == null || 0 == list.size();
  }

  public static boolean isNotEmptyList(Collection list) {
    return list != null && list.size() > 0;
  }

  public static boolean isEmptyMap(Map map) {
    return map == null || 0 == map.size();
  }

  public static boolean isEmptyArray(Object[] array) {
    return array == null || array.length == 0;
  }

  public static long[] toLongArray(List<? extends Number> list) {
    long[] result = null;
    if (!isEmptyList(list)) {
      result = new long[list.size()];
      int i = 0;
      for (Number n : list) {
        result[i++] = n.longValue();
      }
    }
    return result;
  }

  public static <E> String toString(Collection<E> c, String delimiter) {
    StringBuilder sb = new StringBuilder();
    if (c != null && !c.isEmpty()) {
      for (Iterator<E> iter = c.iterator(); iter.hasNext();) {
        sb.append(iter.next());
        if (iter.hasNext()) {
          sb.append(delimiter);
        }
      }
    }
    return sb.toString();
  }

  public static String toString(Object[] objects, String delimiter) {
    if (objects == null) {
      return "";
    }
    if (1 == objects.length && null != objects[0]) {
      return objects[0].toString();
    } else {
      StringBuffer strBuf = new StringBuffer();
      for (int i = 0; i < objects.length; i++) {
        if (null != objects[i]) {
          strBuf.append(objects[i].toString());
          if (i < objects.length - 1) {
            strBuf.append(delimiter);
          }
        }
      }
      return strBuf.toString();
    }
  }

  public static String toCSVString(Collection list, String delimiter) {
    if (null == list || 0 == list.size()) {
      return "";
    }
    Object[] objs = list.toArray();
    if (1 == objs.length && null != objs[0]) {
      if (objs[0].toString().startsWith("0") && !objs[0].toString().contains(",")) {
        return "=\"" + objs[0].toString().replaceAll("\"", "\"\"") + "\"";
      } else {
        return "\"" + objs[0].toString().replaceAll("\"", "\"\"") + "\"";
      }
    } else {
      StringBuffer strBuf = new StringBuffer();
      for (int i = 0; i < objs.length; i++) {
        if (null != objs[i]) {
          if (objs[i].toString().startsWith("0") && !objs[i].toString().contains(",")) {
            strBuf.append("=");
          }
          strBuf.append("\"" + objs[i].toString().replaceAll("\"", "\"\"") + "\"");
          if (i < objs.length - 1) {
            strBuf.append(delimiter);
          }
        }
      }
      return strBuf.toString();
    }
  }

  public static <T extends Object> void addAllTo(Collection<T> dest, T[] src) {
    if (dest != null && src != null) {
      for (T entry : src) {
        dest.add(entry);
      }
    }
  }

  public static <T> List<T> extractSubListWithSafety(List<T> targetList, int targetSize) {
    if (targetSize == 0) {
      return Collections.emptyList();
    }
    if (targetList.size() < targetSize) {
      return targetList;
    }
    return targetList.subList(0, targetSize);
  }

//  public static Page toOrderListByPage(List<? extends Object> results, PagingCriteria pagingCriteria) {
//    int pageSize = pagingCriteria.getPageSize();
//    int pageNumber = pagingCriteria.getPageNumber();
//    Page page = new Page();
//    if (pageSize <= 0) {
//      throw new IllegalArgumentException("'pageSize' of bsc in public Page is 0 or less than 0!");
//    }
//    if (pageNumber <= 0) {
//      throw new IllegalArgumentException("'pageNo' of bsc in public Page is 0 or less than 0!");
//    }
//    if (!CollectionUtil.isEmptyList(results)) {
//      int recordCount = results.size();
//      if (recordCount == 0) {
//        return Page.EMPTY_PAGE;
//      }
//
//      int pageCount = recordCount / pageSize;
//      if (recordCount % pageSize > 0) {
//        pageCount = pageCount + 1;
//      }
//
//      int pageNumber1 = pageNumber > pageCount ? pageCount : pageNumber;
//      int start = pageSize * (pageNumber1 - 1);
//
//      List<Object> pageResults = new ArrayList<Object>(pageSize);
//      for (int i = 0; i < pageSize && (start + i) < recordCount; i++) {
//        pageResults.add(results.get(start + i));
//      }
//
//      page = new Page(pageResults, start, pageNumber1 < pageCount);
//      page.setPageCount(pageCount);
//      page.setPageNumber(pageNumber1);
//      page.setPageSize(pageSize);
//      page.setRecordCount(recordCount);
//    }
//    return page;
//  }

  public static <T extends Object> void addIfDoesNotContain(Collection<T> collection, T object) {
    if (!collection.contains(object)) {
      collection.add(object);
    }
  }

  public static <T extends Object> void addAllIfDoesNotContain(Collection<T> fromCollection, Collection<T> toCollection) {
    for (T object : fromCollection) {
      addIfDoesNotContain(toCollection, object);
    }
  }

  public static <T extends Object> void addIfNotNullAndNotContain(Collection<T> collection, T object) {
    if (null != object && !collection.contains(object)) {
      collection.add(object);
    }
  }

  public static <T extends Object> void addIfNotNull(Collection<T> collection, T object) {
    if (null != object) {
      collection.add(object);
    }
  }

  public static <T extends Object> List<T> convertNullListToEmptyList(List<T> list) {
    if (list == null) {
      return Collections.emptyList();
    }
    return list;
  }

  public static <T extends Comparable<? super T>> boolean compareList(List<T> list1, List<T> list2) {
    if (CollectionUtil.isEmptyList(list1) && CollectionUtil.isEmptyList(list2)) {
      return true;
    }
    if ((!CollectionUtil.isEmptyList(list1) && CollectionUtil.isEmptyList(list2))
        || (CollectionUtil.isEmptyList(list1) && !CollectionUtil.isEmptyList(list2)) || list1.size() != list2.size()) {
      return false;
    }
    List<T> tempList1 = new ArrayList<T>();
    tempList1.addAll(list1);
    List<T> tempList2 = new ArrayList<T>();
    tempList2.addAll(list2);
    Collections.sort(tempList1);
    Collections.sort(tempList2);
    for (int i = 0; i < tempList1.size(); i++) {
      if (!tempList1.get(i).equals(tempList2.get(i))) {
        return false;
      }
    }
    return true;
  }

  public static <E> List<E>[] divideList(List<E> list) {
    ArrayList<E> first = new ArrayList<E>();
    ArrayList<E> second = new ArrayList<E>();
    if (list != null && !list.isEmpty()) {
      int size = list.size();
      if (size == 1) {
        first.add(list.get(0));
      } else {
        int half = (size + 1) / 2;
        for (int i = 0; i < size; i++) {
          if (i < half) {
            first.add(list.get(i));
          } else {
            second.add(list.get(i));
          }
        }
      }
    }
    return new List[] { first, second };
  }

  public static <E> List<E> removeNulls(List<E> list) {
    List<E> newlist = new ArrayList<E>();
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i) != null)
        newlist.add(list.get(i));
    }
    return newlist;
  }

  public static List<String> removeNullOrEmptyStrs(List<String> list) {
    List<String> newList = new ArrayList<String>();
    for (String string : list) {
      if (StringUtil.isNotNullNorEmpty(string)) {
        newList.add(string.trim());
      }
    }
    return newList;
  }

  public static <E> boolean removeObject(List<E> list, E object) {
    return isNotEmptyList(list) && list.remove(object);
  }

  public static <T extends Object, V extends Object> void putValueInToMapList(Map<T, List<V>> map, T key, V value) {
    if (value == null || key == null) {
      return;
    }
    if (!map.containsKey(key) || map.get(key) == null) {
      map.put(key, new ArrayList<V>());
    }
    CollectionUtil.addIfDoesNotContain(map.get(key), value);
  }

  public static <T extends Object, V extends Object> void putValueInToMapListAllowingDuplicate(Map<T, List<V>> map, T key, V value) {
    if (value == null || key == null) {
      return;
    }
    List<V> values = map.get(key);
    if (values == null) {
      values = new ArrayList<V>();
      map.put(key, values);
    }
    values.add(value);
  }

  public static String[] toArray(Collection<String> list) {
    String[] array = new String[list.size()];
    int index = 0;
    for (String v : list) {
      array[index++] = v;
    }
    return array;
  }

  public static <T, V> void mergeValueIntoMap(Map<T, List<V>> map, Map<T, List<V>> valueMap) {
    for (Entry<T, List<V>> entry : valueMap.entrySet()) {
      for (V value : entry.getValue()) {
        CollectionUtil.putValueInToMapList(map, entry.getKey(), value);
      }
    }
  }

  public static <T> List<List<T>> splitList(List<T> src, int batchSize) {
    List<List<T>> result = new ArrayList<List<T>>();
    if (src == null || batchSize == 0 || src.size() <= batchSize) {
      result.add(src);
    } else {
      for (int start = 0; start < src.size(); start = start + batchSize) {
        int end = (start + batchSize > src.size()) ? src.size() : (start + batchSize);
        result.add(src.subList(start, end));
      }
    }
    return result;
  }

  public static <T extends Comparable<? super T>> boolean compareToListWitOneElementEqual(List<T> list1, List<T> list2) {
    Map<Object, Object> list1Map = new HashMap<Object, Object>();
    for (Iterator iter1 = list1.iterator(); iter1.hasNext();) {
      Object element = iter1.next();
      list1Map.put(element, element);
    }
    for (Iterator iter2 = list2.iterator(); iter2.hasNext();) {
      if (list1Map.get(iter2.next()) != null) {
        return true;
      }
    }
    return false;
  }

  public static <T extends Comparable<? super T>> int compareToList(List<T> list1, List<T> list2) {
    int result = 0;
    if (CollectionUtil.isEmptyList(list1) && CollectionUtil.isEmptyList(list2)) {
      return result;
    }
    if (!CollectionUtil.isEmptyList(list1) && CollectionUtil.isEmptyList(list2)) {
      return 1;
    }
    if ((CollectionUtil.isEmptyList(list1) && !CollectionUtil.isEmptyList(list2))) {
      return -1;
    }
    if (list1.size() != list2.size()) {
      return Integer.valueOf(list1.size()).compareTo(list2.size());
    }
    List<T> tempList1 = new ArrayList<T>();
    tempList1.addAll(list1);
    List<T> tempList2 = new ArrayList<T>();
    tempList2.addAll(list2);
    Collections.sort(tempList1);
    Collections.sort(tempList2);
    for (int i = 0; i < tempList1.size(); i++) {
      result = tempList1.get(i).compareTo(tempList2.get(i));
      if (result != 0) {
        return result;
      }
    }
    return result;
  }

  public static <T> int compareToList(List<T> list1, List<T> list2, Comparator<T> comparator) {
    int result = 0;
    if (CollectionUtil.isEmptyList(list1) && CollectionUtil.isEmptyList(list2)) {
      return result;
    }
    if (!CollectionUtil.isEmptyList(list1) && CollectionUtil.isEmptyList(list2)) {
      return 1;
    }
    if ((CollectionUtil.isEmptyList(list1) && !CollectionUtil.isEmptyList(list2))) {
      return -1;
    }
    if (list1.size() != list2.size()) {
      return Integer.valueOf(list1.size()).compareTo(list2.size());
    }
    List<T> tempList1 = new ArrayList<T>();
    tempList1.addAll(list1);
    List<T> tempList2 = new ArrayList<T>();
    tempList2.addAll(list2);
    Collections.sort(tempList1, comparator);
    Collections.sort(tempList2, comparator);
    for (int i = 0; i < tempList1.size(); i++) {
      result = comparator.compare(tempList1.get(i), tempList2.get(i));
      if (result != 0) {
        return result;
      }
    }
    return result;
  }

  public static <K, V extends Comparable<? super V>> int compareToMap(Map<K, V> map1, Map<K, V> map2) {
    int result = 0;
    if (CollectionUtil.isEmptyMap(map1) && CollectionUtil.isEmptyMap(map2)) {
      return result;
    }
    if (CollectionUtil.isEmptyMap(map2)) {
      return 1;
    }
    if ((CollectionUtil.isEmptyMap(map1))) {
      return -1;
    }
    if (map1.size() != map2.size()) {
      return Integer.valueOf(map1.size()).compareTo(map2.size());
    }
    for (Entry<K, V> entry : map1.entrySet()) {
      if (!map1.containsKey(entry.getKey())) {
        return 1;
      } else if (entry.getValue() == null || map2.get(entry.getKey()) == null) {
        if (entry.getValue() == null && map2.get(entry.getKey()) == null) {
          return 0;
        } else if (entry.getValue() == null) {
          return -1;
        } else {
          return 1;
        }
      } else {
        result = entry.getValue().compareTo(map2.get(entry.getKey()));
        if (result != 0) {
          return result;
        }
      }
    }
    return result;
  }

  public static <K, V> int compareToMap(Map<K, V> map1, Map<K, V> map2, Comparator<V> comparator) {
    int result = 0;
    if (CollectionUtil.isEmptyMap(map1) && CollectionUtil.isEmptyMap(map2)) {
      return result;
    }
    if (CollectionUtil.isEmptyMap(map2)) {
      return 1;
    }
    if ((CollectionUtil.isEmptyMap(map1))) {
      return -1;
    }
    if (map1.size() != map2.size()) {
      return Integer.valueOf(map1.size()).compareTo(map2.size());
    }
    for (Entry<K, V> entry : map1.entrySet()) {
      if (!map1.containsKey(entry.getKey())) {
        return 1;
      } else {
        result = comparator.compare(entry.getValue(), map2.get(entry.getKey()));
        if (result != 0) {
          return result;
        }
      }
    }
    return result;
  }

  public static String toCollectionString(Collection<? extends Object> collection) {
    return toCollectionString(collection, StringUtil.COMMA);
  }

  public static String toCollectionString(Collection<? extends Object> collection, String seperator) {
    if (CollectionUtil.isEmptyList(collection)) {
      return StringUtil.EMPTY_STRING;
    }
    if (null == seperator) {
      seperator = StringUtil.EMPTY_STRING;
    }
    Iterator<? extends Object> iterator = collection.iterator();
    StringBuilder builder = new StringBuilder();
    builder.append(iterator.next());
    while (iterator.hasNext()) {
      builder.append(seperator);
      builder.append(iterator.next());
    }
    return builder.toString();
  }

  public static Set<String> toStringSet(String... strArray) {
    HashSet<String> strSet = null;
    if (null != strArray && strArray.length > 0) {
      strSet = new HashSet<String>();
      for (String str : strArray) {
        if (null != str) {
          strSet.add(str);
        }
      }
    }
    return strSet;
  }

  public static String[] toTrimStringArray(String... strings) {
    int length = strings.length;
    String[] stringArrays = new String[length];
    for (int i = 0; i < length; i++) {
      stringArrays[i] = strings[i].trim();
    }
    return stringArrays;
  }

  public static <T> String[] toStringArray(Collection<T> collection) {
    if (isNotEmptyList(collection)) {
      String[] result = new String[collection.size()];
      int i = 0;
      for (T obj : collection) {
        result[i++] = obj.toString();
      }
      return result;
    }
    return new String[0];
  }

  public static <T extends Comparable<? super T>> void sort(List<T> list, boolean ascending) {
    if (ascending) {
      Collections.sort(list);
    } else {
      Collections.sort(list, new Comparator<T>() {
        public int compare(T o1, T o2) {
          return 0 - (o1.compareTo(o2));
        }
      });
    }
  }

  public static <T> String toString(List<T> c, String attribute, String delimiter) throws Exception {
    StringBuilder sb = new StringBuilder();
    if (c != null && !c.isEmpty()) {
      for (Iterator<T> iter = c.iterator(); iter.hasNext();) {
        sb.append(PropertyUtils.getProperty(iter.next(), attribute));
        if (iter.hasNext()) {
          sb.append(delimiter);
        }
      }
    }
    return sb.toString();
  }

  public static <E> String toProcedureInString(List<E> c, String delimiter) {
    StringBuilder sb = new StringBuilder();
    String singleQuote = StringUtil.SINGLE_QUOTE;
    if (c != null && !c.isEmpty()) {
      for (Iterator<E> iter = c.iterator(); iter.hasNext();) {
        sb.append(singleQuote).append(iter.next()).append(singleQuote);
        if (iter.hasNext()) {
          sb.append(delimiter);
        }
      }
    }
    return sb.toString();
  }
}
