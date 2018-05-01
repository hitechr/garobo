package org.hitechr.garobo.console.common.utils;

import org.springframework.beans.BeansException;
import org.springframework.beans.FatalBeanException;
import org.springframework.util.Assert;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2015/8/11.
 */
public class BeanUtils extends org.springframework.beans.BeanUtils {

    public static void copyProperties(Object source, Object target) throws BeansException {
        Class<?> actualEditable = target.getClass();
        PropertyDescriptor[] targetPds = getPropertyDescriptors(actualEditable);
        for (PropertyDescriptor targetPd : targetPds) {
            if (targetPd.getWriteMethod() != null) {
                PropertyDescriptor sourcePd = getPropertyDescriptor(source.getClass(), targetPd.getName());
                if (sourcePd != null && sourcePd.getReadMethod() != null) {
                    try {
                        Method readMethod = sourcePd.getReadMethod();
                        if (!Modifier.isPublic(readMethod.getDeclaringClass().getModifiers())) {
                            readMethod.setAccessible(true);
                        }
                        Object value = readMethod.invoke(source);
                        // 这里判断以下value是否为空 当然这里也能进行一些特殊要求的处理 例如绑定时格式转换等等
                        if (value != null) {
                            Method writeMethod = targetPd.getWriteMethod();
                            if (!Modifier.isPublic(writeMethod.getDeclaringClass().getModifiers())) {
                                writeMethod.setAccessible(true);
                            }
                            writeMethod.invoke(target, value);
                        }
                    } catch (Throwable ex) {
                        throw new FatalBeanException("Could not copy properties from source to target", ex);
                    }
                }
            }
        }
    }


    public static void copyPropertiesNoType(Object source, Object target) throws BeansException {
        copyPropertiesNoType(source, target, null, (String[]) null);
    }

    public static void copyPropertiesNoType(Object source, Object target, Class<?> editable) throws BeansException {
        copyPropertiesNoType(source, target, editable, (String[]) null);
    }

    public static void copyPropertiesNoType(Object source, Object target, String... ignoreProperties) throws BeansException {
        copyPropertiesNoType(source, target, null, ignoreProperties);
    }

    private static void copyPropertiesNoType(Object source, Object target, Class<?> editable, String... ignoreProperties)
            throws BeansException {
        Assert.notNull(source, "Source must not be null");
        Assert.notNull(target, "Target must not be null");
        Class<?> actualEditable = target.getClass();
        if (editable != null) {
            if (!editable.isInstance(target)) {
                throw new IllegalArgumentException("Target class [" + target.getClass().getName() +
                        "] not assignable to Editable class [" + editable.getName() + "]");
            }
            actualEditable = editable;
        }
        PropertyDescriptor[] targetPds = getPropertyDescriptors(actualEditable);
        List<String> ignoreList = (ignoreProperties != null) ? Arrays.asList(ignoreProperties) : null;

        for (PropertyDescriptor targetPd : targetPds) {
            Method writeMethod = targetPd.getWriteMethod();
            if (writeMethod != null && (ignoreProperties == null || (!ignoreList.contains(targetPd.getName())))) {
                PropertyDescriptor sourcePd = getPropertyDescriptor(source.getClass(), targetPd.getName());
                if (sourcePd != null) {
                    Method readMethod = sourcePd.getReadMethod();
                    if (readMethod != null) {
                        try {
                            if (!Modifier.isPublic(readMethod.getDeclaringClass().getModifiers())) {
                                readMethod.setAccessible(true);
                            }
                            Object value = readMethod.invoke(source);
                            if (!Modifier.isPublic(writeMethod.getDeclaringClass().getModifiers())) {
                                writeMethod.setAccessible(true);
                            }
                            //writeMethod.invoke(target, value);
                            String sourceType = sourcePd.getReadMethod().getReturnType().getSimpleName();
                            String targetType = targetPd.getReadMethod().getReturnType().getSimpleName();
                            String targetType1 = writeMethod.getParameterTypes()[0].getName();
                            if (sourceType.equals(targetType)) {
                                writeMethod.invoke(target, new Object[]{value});
                            } else {
                                try {
                                    if ((((sourceType.equals("boolean")) || (sourceType.equals("Boolean")))) && ((
                                            (!targetType.equals("boolean")) || (!targetType.equals("Boolean"))))) {
                                        if (!Boolean.valueOf(value.toString()).booleanValue()) {
                                            value = Integer.valueOf(0);
                                        }

                                        if (Boolean.valueOf(value.toString()).booleanValue()) {
                                            value = Integer.valueOf(1);
                                        }
                                    }
                                    if (targetType.equals("int"))
                                        writeMethod.invoke(target, new Object[]{Integer.valueOf((value == null) ? 0 : Integer.valueOf(value.toString()).intValue())});
                                    else if (targetType.equals("Integer"))
                                        writeMethod.invoke(target, new Object[]{(value == null) ? null : Integer.valueOf(value.toString())});
                                    else if (targetType.equals("double"))
                                        writeMethod.invoke(target, new Object[]{Double.valueOf((value == null) ? 0.0D : Double.valueOf(value.toString()).doubleValue())});
                                    else if (targetType.equals("Double"))
                                        writeMethod.invoke(target, new Object[]{(value == null) ? null : Double.valueOf(value.toString())});
                                    else if (targetType.equals("long"))
                                        writeMethod.invoke(target, new Object[]{Long.valueOf((value == null) ? 0L : Long.valueOf(value.toString()).longValue())});
                                    else if (targetType.equals("Long"))
                                        writeMethod.invoke(target, new Object[]{(value == null) ? null : Long.valueOf(value.toString())});
                                    else if (targetType.equals("byte"))
                                        writeMethod.invoke(target, new Object[]{Byte.valueOf((value == null) ? 0 : Byte.valueOf(value.toString()).byteValue())});
                                    else if (targetType.equals("Byte"))
                                        writeMethod.invoke(target, new Object[]{(value == null) ? null : Byte.valueOf(value.toString())});
                                    else if (targetType.equals("short"))
                                        writeMethod.invoke(target, new Object[]{Short.valueOf((value == null) ? 0 : Short.valueOf(value.toString()).shortValue())});
                                    else if (targetType.equals("Short"))
                                        writeMethod.invoke(target, new Object[]{(value == null) ? null : Short.valueOf(value.toString())});
                                    else if (targetType.equals("boolean"))
                                        writeMethod.invoke(target, new Object[]{Boolean.valueOf((value == null) ? null : Boolean.valueOf(value.toString()).booleanValue())});
                                    else if (targetType.equals("Boolean"))
                                        writeMethod.invoke(target, new Object[]{(value == null) ? null : Boolean.valueOf(value.toString())});
                                    else if (targetType.equals("char"))
                                        writeMethod.invoke(target, new Object[]{Character.valueOf((value == null) ? 110 : value.toString().charAt(0))});
                                    else if (targetType.equals("Character"))
                                        writeMethod.invoke(target, new Object[]{(value == null) ? null : Character.valueOf(value.toString().charAt(0))});
                                    else if (targetType.equals("float"))
                                        writeMethod.invoke(target, new Object[]{Double.valueOf(Float.valueOf(value.toString()).floatValue())});
                                    else if (targetType.equals("Float"))
                                        writeMethod.invoke(target, new Object[]{(value == null) ? null : Float.valueOf(value.toString())});
                                    else if (targetType.equals("BigDecimal"))
                                        writeMethod.invoke(target, new Object[]{(value == null) ? null : new BigDecimal(value.toString())});
                                    else if (targetType.equals("byte[]"))
                                        writeMethod.invoke(target, new Object[]{(value == null) ? null : value.toString().getBytes()});
                                    else if (targetType.equals("Byte[]")) {
                                        writeMethod.invoke(target, new Object[]{(value == null) ? null : value.toString().getBytes()});
                                    }
                                } catch (Throwable ex) {
                                    if (targetType1.equals("int"))
                                        writeMethod.invoke(target, new Object[]{Integer.valueOf((value == null) ? 0 : Integer.valueOf(value.toString()).intValue())});
                                    else if (targetType1.equals("Integer"))
                                        writeMethod.invoke(target, new Object[]{(value == null) ? null : Integer.valueOf(value.toString())});
                                    else if (targetType1.equals("double"))
                                        writeMethod.invoke(target, new Object[]{Double.valueOf((value == null) ? 0.0D : Double.valueOf(value.toString()).doubleValue())});
                                    else if (targetType1.equals("Double"))
                                        writeMethod.invoke(target, new Object[]{(value == null) ? null : Double.valueOf(value.toString())});
                                    else if (targetType1.equals("long"))
                                        writeMethod.invoke(target, new Object[]{Long.valueOf((value == null) ? 0L : Long.valueOf(value.toString()).longValue())});
                                    else if (targetType1.equals("Long"))
                                        writeMethod.invoke(target, new Object[]{(value == null) ? null : Long.valueOf(value.toString())});
                                    else if (targetType1.equals("byte"))
                                        writeMethod.invoke(target, new Object[]{Byte.valueOf((value == null) ? 0 : Byte.valueOf(value.toString()).byteValue())});
                                    else if (targetType1.equals("Byte"))
                                        writeMethod.invoke(target, new Object[]{(value == null) ? null : Byte.valueOf(value.toString())});
                                    else if (targetType1.equals("short"))
                                        writeMethod.invoke(target, new Object[]{Short.valueOf((value == null) ? 0 : Short.valueOf(value.toString()).shortValue())});
                                    else if (targetType1.equals("Short"))
                                        writeMethod.invoke(target, new Object[]{(value == null) ? null : Short.valueOf(value.toString())});
                                    else if (targetType1.equals("boolean"))
                                        writeMethod.invoke(target, new Object[]{Boolean.valueOf((value == null) ? null : Boolean.valueOf(value.toString()).booleanValue())});
                                    else if (targetType1.equals("Boolean"))
                                        writeMethod.invoke(target, new Object[]{(value == null) ? null : Boolean.valueOf(value.toString())});
                                    else if (targetType1.equals("char"))
                                        writeMethod.invoke(target, new Object[]{Character.valueOf((value == null) ? 110 : value.toString().charAt(0))});
                                    else if (targetType1.equals("Character"))
                                        writeMethod.invoke(target, new Object[]{(value == null) ? null : Character.valueOf(value.toString().charAt(0))});
                                    else if (targetType1.equals("float"))
                                        writeMethod.invoke(target, new Object[]{Double.valueOf(Float.valueOf(value.toString()).floatValue())});
                                    else if (targetType1.equals("Float"))
                                        writeMethod.invoke(target, new Object[]{(value == null) ? null : Float.valueOf(value.toString())});
                                    else if (targetType1.equals("BigDecimal"))
                                        writeMethod.invoke(target, new Object[]{(value == null) ? null : new BigDecimal(value.toString())});
                                    else if (targetType1.equals("byte[]"))
                                        writeMethod.invoke(target, new Object[]{(value == null) ? null : value.toString().getBytes()});
                                    else if (targetType1.equals("Byte[]")) {
                                        writeMethod.invoke(target, new Object[]{(value == null) ? null : value.toString().getBytes()});
                                    }
                                }
                            }
                        } catch (Throwable ex) {
                            throw new FatalBeanException(
                                    "Could not copy property '" + targetPd.getName() + "' from source to target", ex);
                        }
                    }
                }
            }
        }
    }

}