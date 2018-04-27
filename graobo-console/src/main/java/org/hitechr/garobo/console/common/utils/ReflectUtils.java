package org.hitechr.garobo.console.common.utils;

import org.apache.log4j.Logger;
import org.springframework.util.Assert;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by yfzhangsheng on 2015/1/21.
 */
public class ReflectUtils {
    private final static Logger logger = Logger.getLogger(ReflectUtils.class);
    private final static Map<String, Class> typeMap = new HashMap<String, Class>() {{
        put("int", Integer.class);
        put("long", Long.class);
        put("double", Double.class);
        put("float", Float.class);
        put("boolean", Boolean.class);
        put("char", Character.class);
        put("byte", Byte.class);
        put("short", Short.class);
    }};

    public static Object invokeGetterMethod(Object obj, String propertyName) {
        String getterMethodName = "get" + StringUtils.capitalize(propertyName);
        return invokeMethod(obj, getterMethodName, new Class[]{}, new Object[]{});
    }

    public static void invokeSetterMethod(Object obj, String propertyName, Object value) {
        invokeSetterMethod(obj, propertyName, value, null);
    }

    public static void invokeSetterMethod(Object obj, String propertyName, Object value, Class<?> propertyType) {
        Class<?> type = propertyType != null ? propertyType : value.getClass();
        String setterMethodName = "set" + StringUtils.capitalize(propertyName);
        invokeMethod(obj, setterMethodName, new Class[]{type}, new Object[]{value});
    }

    public static Object getFieldValue(final Object obj, final String fieldName) {
        Field field = getAccessibleField(obj, fieldName);
        if (field == null) {
            throw new IllegalArgumentException("Could not find field [" + fieldName + "] on target [" + obj + "]");
        }
        Object result = null;
        try {
            result = field.get(obj);
        } catch (IllegalAccessException e) {
            logger.error("error:", e);
        }
        return result;
    }

    public static void setFieldValue(final Object obj, final String fieldName, Object value) {
        Field field = getAccessibleField(obj, fieldName);
        if (field != null) {
            if (!field.getType().isAssignableFrom(value.getClass())) {
                value = getSimpleObjectValue(value, field.getType());
            }
            if(null!=value){
                try {
                    field.set(obj, value);
                } catch (IllegalAccessException e) {
                    logger.error("error:", e);
                }
            }
        }
    }

    public static Field getAccessibleField(final Object obj, final String fieldName) {
        Assert.notNull(obj, "object not null");
        Assert.hasText(fieldName, "fieldName");
        Set<String> names = new HashSet<String>();
        for (Class<?> superClass = obj.getClass(); superClass != Object.class; superClass = superClass.getSuperclass()) {
            try {
                for (Field df : superClass.getDeclaredFields()) {
                    names.add(df.getName());
                }
                if (names.contains(fieldName)) {
                    Field field = superClass.getDeclaredField(fieldName);
                    field.setAccessible(true);
                    return field;
                }
            } catch (NoSuchFieldException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }

    public static Object getSimpleObjectValue(Object oldValue, Class targeType) {
        try {
            return Class.forName(typeMap.get(targeType.getSimpleName()).getName()).getConstructor(String.class).newInstance(oldValue.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Set<Field> getAccessibleField(final Object obj) {
        Assert.notNull(obj, "object not null");
        Set<Field> names = new HashSet<Field>();
        for (Class<?> superClass = obj.getClass(); superClass != Object.class; superClass = superClass.getSuperclass()) {
            for (Field df : superClass.getDeclaredFields()) {
                names.add(df);
            }
        }
        return names;
    }

    public static Object invokeMethod(final Object obj, final String methodName, final Class<?>[] parameterTypes,
                                      final Object[] args) {
        Method method = getAccessibleMethod(obj, methodName, parameterTypes);
        if (method == null) {
            throw new IllegalArgumentException("Could not find method [" + methodName + "] on target [" + obj + "]");
        }
        try {
            return method.invoke(obj, args);
        } catch (Exception e) {
            throw convertReflectionExceptionToUnchecked(e);
        }
    }

    public static Method getAccessibleMethod(final Object obj, final String methodName,
                                             final Class<?>... parameterTypes) {
        Assert.notNull(obj, "object not null");
        for (Class<?> superClass = obj.getClass(); superClass != Object.class; superClass = superClass.getSuperclass()) {
            try {
                Method method = superClass.getDeclaredMethod(methodName, parameterTypes);
                method.setAccessible(true);
                return method;
            } catch (NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }


    public static <T> Class<T> getSuperClassGenricType(final Class clazz) {
        return getSuperClassGenricType(clazz, 0);
    }

    public static Class getSuperClassGenricType(final Class clazz, final int index) {
        Type genType = clazz.getGenericSuperclass();
        if (!(genType instanceof ParameterizedType)) {
//            logger.warn(clazz.getSimpleName() + "'s superclass not ParameterizedType");
            return Object.class;
        }
        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
        if (index >= params.length || index < 0) {
            logger.warn("Index: " + index + ", Size of " + clazz.getSimpleName() + "'s Parameterized Type: "
                    + params.length);
            return Object.class;
        }
        if (!(params[index] instanceof Class)) {
            logger.warn(clazz.getSimpleName() + " not set the actual class on superclass generic parameter");
            return Object.class;
        }
        return (Class) params[index];
    }

    public static RuntimeException convertReflectionExceptionToUnchecked(Exception e) {
        if (e instanceof IllegalAccessException || e instanceof IllegalArgumentException
                || e instanceof NoSuchMethodException) {
            return new IllegalArgumentException("Reflection Exception.", e);
        } else if (e instanceof InvocationTargetException) {
            return new RuntimeException("Reflection Exception.", ((InvocationTargetException) e).getTargetException());
        } else if (e instanceof RuntimeException) {
            return (RuntimeException) e;
        }
        return new RuntimeException("Unexpected Checked Exception.", e);
    }

    public static String getErrorMsg(Throwable error) {
        PrintWriter out = null;
        try {
            StringWriter sw = new StringWriter();
            out = new PrintWriter(sw);
            error.printStackTrace(out);
            return "\r\n" + sw.toString() + "\r\n";
        } catch (Exception e) {
            return "bad getErrorMap";
        } finally {
            if (null != out) {
                out.close();
            }
        }
    }
}
