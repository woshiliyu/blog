package com.ly.provider.aspectj;


import com.ly.common.annotation.Log;
import com.ly.common.enums.BusinessStatus;
import com.ly.common.utils.ServletUtils;
import com.ly.common.utils.json.JsonUtils;
import com.ly.provider.sys.Service.SysOperLogService;
import com.ly.provider.sys.entity.SysOperLog;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Map;

/**
 * 操作日志记录处理
 * 
 * @author ruoyi
 */
@Aspect
@Component
public class LogAspect
{
    private static final Logger log = LoggerFactory.getLogger(LogAspect.class);

    @Autowired
    private SysOperLogService sysOperLogService;



    // 配置织入点
    @Pointcut("@annotation(com.ly.common.annotation.Log)")
    public void logPointCut()
    {
    }
    @Before("logPointCut()")
    public  void dobefore(){
        log.info("====>切面之前会执行");
    }

    /**
     * 在代码执行之后，不论代码成功执行还是抛出异常都会执行到这里
     */
    @After("logPointCut()")
    public  void doAfter(){
        log.info("====>切面执行之后");
    }

    @AfterReturning(value = "logPointCut()",returning = "result")
    public  void AfterReturning(Object result){
        log.info("====>执行结果返回值："+result.toString() );
    }


    /**
     * 前置通知 用于拦截操作
     *
     * @param joinPoint 切点
     */
    @AfterReturning(pointcut = "logPointCut()")
    public void doBefore(JoinPoint joinPoint)
    {
        handleLog(joinPoint, null);
    }

    /**
     * 拦截异常操作
     *
     * @param joinPoint
     * @param e
     */
    @AfterThrowing(value = "logPointCut()", throwing = "e")
    public void doAfter(JoinPoint joinPoint, Exception e)
    {
        handleLog(joinPoint, e);
    }


    protected void handleLog(final JoinPoint joinPoint, final Exception e)
    {
        try
        {
            // 获得注解
            Log controllerLog = getAnnotationLog(joinPoint);
            if (controllerLog == null)
            {
                return;
            }

            // 获取当前的用户
            //SysUser currentUser = ShiroUtils.getUser();

            // *========数据库日志=========*//
            SysOperLog operLog = new SysOperLog();
            operLog.setStatus(BusinessStatus.SUCCESS.ordinal());
            // 请求的地址
            String ip = "192.168.24.63";
            operLog.setOperIp(ip);

            operLog.setOperUrl(ServletUtils.getRequest().getRequestURI());
            operLog.setOperName("liyu");
//            if (currentUser != null)
//            {
//                operLog.setOperName(currentUser.getLoginName());
//                if (StringUtils.isNotNull(currentUser.getDept())
//                        && StringUtils.isNotEmpty(currentUser.getDept().getDeptName()))
//                {
//                    operLog.setDeptName(currentUser.getDept().getDeptName());
//                }
//            }

            if (e != null)
            {
                operLog.setStatus(BusinessStatus.FAIL.ordinal());
                operLog.setErrorMsg(e.getMessage().toString());
            }
            // 设置方法名称
            String className = joinPoint.getTarget().getClass().getName();
            String methodName = joinPoint.getSignature().getName();
            operLog.setMethod(className + "." + methodName + "()");
            // 处理设置注解上的参数
            getControllerMethodDescription(controllerLog, operLog);
            // 保存数据库
           // AsyncManager.me().execute(AsyncFactory.recordOper(operLog));
            sysOperLogService.insertSysOperLog(operLog);
        }
        catch (Exception exp)
        {
            // 记录本地异常日志
            log.error("==LogAspect异常==");
            log.error("异常信息:{}", exp.getMessage());
            exp.printStackTrace();
        }
    }

    /**
     * 获取注解中对方法的描述信息 用于Controller层注解
     *
     * @param log 切点
     * @return 方法描述
     * @throws Exception
     */
    public void getControllerMethodDescription(Log log, SysOperLog operLog) throws Exception
    {
        // 设置action动作
        operLog.setBusinessType(log.businessType().ordinal());
        // 设置标题
        operLog.setTitle(log.title());
        // 设置操作人类别
        operLog.setOperatorType(log.operatorType().ordinal());
        // 是否需要保存request，参数和值
        if (log.isSaveRequestData())
        {
            // 获取参数的信息，传入到数据库中。
            setRequestParam(operLog);
        }
    }

    /**
     * 获取请求的参数，放到SysOperLog中
     *
     * @param operLog 操作日志
     * @throws Exception 异常
     */
    private void setRequestParam(SysOperLog operLog) throws Exception
    {
        Map<String, String[]> map = ServletUtils.getRequest().getParameterMap();
        String params = JsonUtils.ObjToJsonStr(map);
        int len=params.length();
        operLog.setOperParam(params);
    }

    /**
     * 是否存在注解，如果存在就获取
     */
    private Log getAnnotationLog(JoinPoint joinPoint) throws Exception
    {
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();

        if (method != null)
        {
            return method.getAnnotation(Log.class);
        }
        return null;
    }


}
