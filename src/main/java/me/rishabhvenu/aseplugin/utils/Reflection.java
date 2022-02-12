package me.rishabhvenu.aseplugin.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Reflection {
    public static void setPrivateField(Class<?> clazz, Object obj, String fieldName, Object val) {
        try {
            Field field = clazz.getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(clazz.cast(obj), val);
        } catch (NoSuchFieldException|IllegalAccessException e) {
            e.printStackTrace();
        }
    }
    public static Object instantiateClass(String className) {
        try {
            Class<?> clazz = Class.forName(className);
            return clazz.getConstructor().newInstance();
        } catch (ClassNotFoundException|NoSuchMethodException|InstantiationException|IllegalAccessException| InvocationTargetException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Object getPrivateField(Object obj, String field) {
        return getPrivateField(obj.getClass(), obj, field);
    }

    public static Object getPrivateField(Class<?> clazz, Object obj, String field) {
        try {
            Field f = clazz.getDeclaredField(field);
            f.setAccessible(true);
            return f.get(obj);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Object getPrivateField(Class<?> clazz, String field) {
        try {
            Field f = clazz.getDeclaredField(field);
            f.setAccessible(true);
            return f.get(null);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
