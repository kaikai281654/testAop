package com.kai.aopTest;

//import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSON;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Aspect
@Component
public class OperateAsp {
    /*
    定义切入点
    横切逻辑
    植入
     */
    @Pointcut("@annotation(com.kai.aopTest.RecordOperate)")
    public void pointcut(){}


    private ThreadPoolExecutor threadPoolExecutor =new ThreadPoolExecutor(
            1,1,1, TimeUnit.SECONDS,new LinkedBlockingDeque<>(100)
    );



    @Around("pointcut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object result=proceedingJoinPoint.proceed();
        threadPoolExecutor.execute(
                ()->{
                    try {
                        MethodSignature methodSignature= (MethodSignature) proceedingJoinPoint.getSignature();
                        RecordOperate annotation =methodSignature.getMethod().getAnnotation(RecordOperate.class);

                        Class<? extends Convert> convert = annotation.convert();
                        Convert convert1 = convert.newInstance();
                        OperateLogDo operateLogDo=convert1.convert(proceedingJoinPoint.getArgs()[0]);

                        operateLogDo.setDesc(annotation.desc());
                        operateLogDo.setResult(result.toString());

//                        System.out.println("insert operatLog"+ JSON.toJSONString(operateLogDo));
                        System.out.println("insert operatLog"+operateLogDo);
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }

                }
                );
                return  result;
    }


}
