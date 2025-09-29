package com.nrz.efj.chapter05.item39;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 예외 클래스파일이 컴파일에 존재했으나, 런타임에 없는경우  -> TypeNotPresentException
 * */
public class RunTests3 {

    public static void main(String[] args) throws Exception{
        int tests = 0;
        int passed = 0;
        Class<?> testClass = Class.forName("com.nrz.efj.chapter05.item39.Sample2");

        for(Method m: testClass.getDeclaredMethods()){
            if(m.isAnnotationPresent(ExceptionTest.class)){
                tests++;
                try {
                    m.invoke(null);
                    System.out.printf("테스트 %s 실패: 예외를 던지지 않음%n", m);
                }catch (Throwable wrappedExc){
                    Throwable exc = wrappedExc.getCause();
                    int oldPassed = passed;
                    Class<? extends Throwable>[] excTypes =
                        m.getAnnotation(ExceptionTest2.class).value();

                    for(Class<? extends Throwable> excType: excTypes){
                        if(excType.isInstance(exc)){
                            passed++;
                            break;
                        }
                    }
                    if(passed == oldPassed){
                        System.out.printf("테스트 %s 실패: %s %n", m, exc);
                    }
                }
            }
        }
    }
}
