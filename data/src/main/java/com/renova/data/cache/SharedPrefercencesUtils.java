package com.renova.data.cache;

import android.content.Context;
import android.content.SharedPreferences;

import java.lang.reflect.Method;
import java.util.Map;

/**
 * Created by 孙逊 on 2015/4/3.
 * Copyright (c) Ruixing constant information technology co., LTD. All rights reserved.
 */
public class SharedPrefercencesUtils {
    /**
     * 保存在手机里的文件名
     *  apply方法是开异步实现保存的��
     */
    public static final String FILE_NAME = "share_data";

    /**
     * �保存数据的方法，我们需要拿到保存数据的具体类型，然后根据类型调用不同的保存方法
     *
     * @param context
     * @param key
     * @param object
     */
    public static void put(Context context, String key, Object object) {
        SharedPreferences sp = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();

        if (object instanceof String) {
                editor.putString(key, (String) object);
            } else if (object instanceof Integer) {
                editor.putInt(key, (Integer) object);
            } else if (object instanceof Boolean) {
                editor.putBoolean(key, (Boolean) object);
            } else if (object instanceof Float) {
                editor.putFloat(key, (Float) object);
            } else if (object instanceof Long) {
                editor.putLong(key, (Long) object);
            } else {
                editor.putString(key, object.toString());
        }
        SharedPreferenceCompat.apply(editor);
    }

    /**
     * �得到保存数据的方法，我们根据默认值得到保存的数据的具体类型，然后调用相应的方法获取值
     *
     * @param context
     * @param key
     * @param defaultObject
     * @return
     */
    public static Object get(Context context, String key, Object defaultObject) {
        SharedPreferences sp = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        if (defaultObject instanceof String) {
            return sp.getString(key, (String) defaultObject);
        } else if (defaultObject instanceof Integer) {
            return sp.getInt(key, (Integer) defaultObject);
        } else if (defaultObject instanceof Boolean) {
            return sp.getBoolean(key, (Boolean) defaultObject);
        } else if (defaultObject instanceof Float) {
            return sp.getFloat(key, (Float) defaultObject);
        } else if (defaultObject instanceof Long) {
            return sp.getLong(key, (Long) defaultObject);
        }
        return null;
    }

    /**
     * �移除某个key值已经对应的值
    *
     * @param context
    * @param key
    */
    public static void remove(Context context, String key) {
        SharedPreferences sp = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.remove(key);
        SharedPreferenceCompat.apply(editor);
    }

    /**
     * �清除所有数据
     *
     * @param context
     */
    public static void clear(Context context) {
        SharedPreferences sp = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.clear();
        SharedPreferenceCompat.apply(editor);
    }

    /**
     * 查询key值是否存在
     *
     * @param context
     * @param key
     * @return
     */
    public static boolean contains(Context context, String key) {
        SharedPreferences sp = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        return sp.contains(key);
    }

    /**
     * 返回所有键值对
     *
     * @param context
     * @return
     */
    public static Map<String, ?> getAll(Context context) {
        SharedPreferences sp = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        return sp.getAll();
    }


    private static class SharedPreferenceCompat {
        private static final Method sApplyMethod = findApplyMethod();

        /**
         * �反射查找apply方法
         *
         * @return
         */
             private static Method findApplyMethod() {
            try {
                return SharedPreferences.Editor.class.getMethod("apply");
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
            return null;
        }

        public static void apply(SharedPreferences.Editor editor) {

            try {
                if (sApplyMethod != null) {
                    sApplyMethod.invoke(editor);
                    return;
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            editor.commit();
        }
    }
}
