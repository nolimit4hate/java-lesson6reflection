package com.company;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;

/**
 * contains methods that get Class object and output List of needed information about this Class object
 */
public class ClassInfo {
    /**
     * @param clazz Class object
     * @return List with information about the fields and their annotations of the Class object in PairNameOther objects
     */
    public List<PairNameOther> getClassFields(Class clazz) {


        Field[] fields = clazz.getDeclaredFields();
        if (fields.length == 0) {
            return null;
        }
        List<PairNameOther> fieldsList = new LinkedList<>();


        for (Field field : fields) {
            String fieldName = field.getName();
            String fieldType = field.getType().getName();
            Annotation[] annotations = field.getAnnotations();
            if (annotations.length == 0)
                fieldsList.add(new PairNameOther(fieldName, fieldType));
            else
                fieldsList.add(new PairNameOther(fieldName, fieldType, annotations));
        }
        return fieldsList;
    }

    /**
     * @param clazz Class object
     * @return List with information about the methods and their annotations of Class object in PairNameOther objects
     */
    public List<PairNameOther> getClassMethods(Class clazz) {
        Method[] methods = clazz.getDeclaredMethods();
        if (methods.length == 0) {
            return null;
        }
        List<PairNameOther> methodsList = new LinkedList<>();
        for (Method method : methods) {
            String methodName = method.getName();
            StringBuilder methodSignatureB = new StringBuilder("");
            methodSignatureB.append("Signature: (out)");
            methodSignatureB.append(method.getReturnType().getName() + " (name)" + methodName + " (in)");
            Class<?>[] params = method.getParameterTypes();
            for (Class<?> param : params) {
                methodSignatureB.append(param.getSimpleName() + " ");
            }
            String methodSignature = methodSignatureB.toString();
            Annotation[] annotations = method.getDeclaredAnnotations();
            if (annotations.length == 0)
                methodsList.add(new PairNameOther(methodName, methodSignature));
            else
                methodsList.add(new PairNameOther(methodName, methodSignature, annotations));
        }
        return methodsList;
    }


}
