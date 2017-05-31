package com.lisicen.tank.common;

import java.lang.reflect.Method;
import java.util.*;

/**
 * Created by X6TI on 2017/5/28.
 */
public class Utils {

    private static final List list = Collections.emptyList();


    /**
     * 使用分隔符连接字符串
     * @param separate
     * @param collection
     * @param <T>
     * @return
     */
    public static <T> String joinSepString(String separate, Collection<T> collection) {
        if (collection == null || collection.size() == 0) {
            return "";
        }
        separate = blankVal(separate, "");
        StringBuilder builder = new StringBuilder();
        int loopSize = collection.size() - 1;
        Iterator<T> iter = collection.iterator();
        for (int i = 0; i < loopSize; i++) {
            T obj = iter.next();
            builder.append(obj).append(separate);
        }
        T obj = iter.next();
        builder.append(obj);
        return builder.toString();
    }

    /**
     * 使用分隔符连接字符串
     * @param separate
     * @param strs
     * @return
     */
    public static String joinSepString(String separate, String ... strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        separate = blankVal(separate, "");
        StringBuilder builder = new StringBuilder();
        int loopSize = strs.length - 1;
        for (int i = 0; i < loopSize; i++) {
            builder.append(strs[i]).append(separate);
        }
        builder.append(strs[loopSize]);
        return builder.toString();
    }

    /**
     * 连接字符串
     * @param strs
     * @return
     */
    public static String joinString(String ... strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        StringBuilder builder = new StringBuilder();
        for (String str : strs) {
            builder.append(str);
        }
        return builder.toString();
    }

    /**
     * 使用K, V生成map对象
     * @param kvs
     * @param <K>
     * @param <V>
     * @return
     */
    public static <K, V> Map<K, V> map(Object ... kvs) {
        Map<K, V> map = map();
        int len = kvs.length;
        for (int i = 0; i < len && (i + 1) < len; i+=2) {
            K key = (K) kvs[i];
            V val = (V) kvs[i + 1];
            map.put(key, val);
        }
        return map;
    }

    /**
     * 新建一个hashMap实例
     * @param <K>
     * @param <V>
     * @return
     */
    public static <K, V> Map<K, V> map() {
        return new HashMap<K, V>();
    }

    /**
     * 新建一个 arrayList 实例
     * @param <T>
     * @return
     */
    public static <T> List<T> list() {
        return new ArrayList<T>();
    }

    /**
     * 获取一个只读的空list
     * @param <T>
     * @return
     */
    public static <T> List<T> roList() {
        return list;
    }

    /**
     *
     * @param objs
     * @param <T>
     * @return
     */
    public static <T> List<T> list(T ... objs) {
        List<T> list = list();
        list.addAll(Arrays.asList(objs));
        return list;
    }

    /**
     * 判断对象是否与列表中任意一个对象相等
     * @param obj
     * @param objs
     * @return
     */
    public static boolean orEquals(Object obj, Object ... objs) {
        if (obj == null || isEmptyArray(objs)) {
            return false;
        }
        boolean success = false;
        int len = objs.length;
        for (int i = 0; i < len && !success; i++) {
            success = obj.equals(objs[i]);
        }
        return success;
    }

    /**
     * 判断对象是否为空
     * isBlank(null) == true
     * isBlank("lisicen") == false
     * isBlank("") == true
     *
     * @param t
     * @return
     */
    public static boolean isBlank(Object t) {
        return t == null || (t instanceof String && ((String) t).trim().equals(""));
    }

    /**
     * 判断对象是否为不为空
     * isBlank(null) == false
     * isBlank("lisicen") == true
     * isBlank("") == false
     *
     * @param t
     * @return
     */
    public static boolean isNotBlank(Object t) {
        return !isBlank(t);
    }

    /**
     * 如果 obj 为空则返回默认值， 否则返回 defval
     * @param obj
     * @param defVal
     * @param <T>
     * @return
     */
    public static <T> T blankVal(T obj, T defVal) {
        return isBlank(obj) ? defVal : obj;
    }

    /**
     * 判断对象是否全部为空
     * isAndBlank(null, "lisice", true) == false;
     * isAndBlank(null, "", "") == true;
     * isAndBlank(null, false, null) == false;
     *
     * @param objs
     * @return
     */
    public static boolean isAndBlank(Object... objs) {
        boolean isNull = true;
        for (Object o : objs) {
            isNull = isNull && isBlank(o);
        }
        return isNull;
    }

    /**
     * 是否全部不为空
     * @param objs
     * @return
     */
    public static boolean isAndNotBlank(Object... objs) {
        boolean isNotNull = true;
        for (Object o : objs) {
            isNotNull = isNotNull && isNotBlank(o);
        }
        return isNotNull;
    }

    /**
     * 是否有任意一个元素为空
     * @param objs
     * @return
     */
    public static boolean isOrBlank(Object... objs) {
        boolean isNull = false;
        for (Object o : objs) {
            isNull = isNull || isBlank(o);
        }
        return isNull;
    }

    /**
     * 删除集合最后一个元素
     *
     * @param list
     * @param <T>
     * @return
     */
    public static <T> T removeLastObj(List<T> list) {
        int size = list.size();
        if (size == 0) {
            return null;
        }
        return list.remove(size - 1);
    }

    /**
     * 获取集合最后一个元素
     *
     * @param list
     * @param <T>
     * @return
     */
    public static <T> T getLastObj(List<T> list) {
        int size = list.size();
        if (size == 0) {
            return null;
        }
        return list.get(size - 1);
    }

    /**
     * 判断集合是否为空
     *
     * @param collection
     * @return 为空则返回 true
     */
    public static boolean isEmptyCollection(Collection collection) {
        return collection == null || collection.isEmpty();
    }

    /**
     * 判断数组是否为空
     * @param objs
     * @return
     */
    public static boolean isEmptyArray(Object[] objs) {
        return objs == null || objs.length == 0;
    }

    /**
     * 返回数组的第一个元素
     *
     * @param con
     * @param <T>
     * @return
     */
    public static <T> T firstObj(T[] con) {
        if (con == null || con.length == 0) {
            return null;
        }
        return con[0];
    }

    /**
     * 返回集合的第一个元素
     *
     * @param con
     * @param <T>
     * @return
     */
    public static <T> T firstObj(Collection<T> con) {
        if (Utils.isEmptyCollection(con)) {
            return null;
        }
        return con.iterator().next();
    }

    /**
     * 随机生成UUID
     *
     * @return UUID
     */
    public static String UUID() {
        return UUID.randomUUID().toString();
    }


    /**
     * 得到一个  0 - i 的随机数
     *
     * @param i 随机数上限， 不包括
     * @return 随机数
     */
    public static int random(int i) {
        return (int) (Math.random() * i);
    }


    private static ThreadLocal<Map<String, Object>> threadLocal = new ThreadLocal<Map<String, Object>>();

    public static void putLocalDto(String key, Object val) {
        Map<String, Object> map = threadLocal.get();
        if (map == null) {
            map = Utils.map();
            threadLocal.set(map);
        }
        map.put(key, val);
    }

    public static Object getLocalDto(String key) {
        Map<String, Object> map = threadLocal.get();
        if (map == null) {
            return null;
        }
        return map.get(key);
    }

}