package com.example.demo.aop;

import com.example.demo.annatation.CsAsync;
import com.example.demo.excute.CsAsyncExecute;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author qqq
 */
@Aspect
@Component
public class CsAsyncAop {

    @Pointcut("@annotation(com.example.demo.annatation.CsAsync)")
    public void pointcut() {
    }

    @Around("pointcut()")
    public void starRun(ProceedingJoinPoint point){
        System.out.println("开始执行切面。。。。。。。。。。。。。。。。。。。。。。。。。。");
        Method method = resolveMethod(point);
        CsAsync csAsync = method.getAnnotation(CsAsync.class);
        long time = csAsync.time();
        //如果有使用异步注解，则初始化线程池
        CsAsyncExecute csAsyncExecute = new CsAsyncExecute();
        ThreadPoolExecutor poolExecutor = csAsyncExecute.getPoolExecutor();
        Runnable runnable = () -> {
            try {
                Thread.sleep(time);
                point.proceed();
            } catch (Throwable e) {
                e.printStackTrace();
            }
        };
        poolExecutor.execute(runnable);
    }

    Method resolveMethod( ProceedingJoinPoint point) {
        MethodSignature signature = (MethodSignature)point.getSignature();
        Class<?> targetClass = point.getTarget().getClass();

        Method method = getDeclaredMethod(targetClass, signature.getName(),
                signature.getMethod().getParameterTypes());
        if (method == null) {
            throw new IllegalStateException("无法解析目标方法: " + signature.getMethod().getName());
        }
        return method;
    }

    private Method getDeclaredMethod(Class<?> clazz, String name, Class<?>... parameterTypes) {
        try {
            return clazz.getDeclaredMethod(name, parameterTypes);
        } catch (NoSuchMethodException e) {
            Class<?> superClass = clazz.getSuperclass();
            if (superClass != null) {
                return getDeclaredMethod(superClass, name, parameterTypes);
            }
        }
        return null;
    }
}
