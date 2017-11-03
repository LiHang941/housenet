package xyz.lihang.housenet.aop;

import org.apache.struts2.ServletActionContext;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import xyz.lihang.housenet.utils.JsonWriterUtil;
import xyz.lihang.housenet.utils.MyException;

import java.util.logging.Logger;

/**
 * 拦截action 特定方法 并将其转为json数据并输出
 * Created by Administrator on 2017/11/2.
 */
@Aspect
@Component
public class JSONAop {
    protected final Logger logger = Logger.getLogger(this.getClass().getName());

    public JSONAop(){
        logger.info("JsonAOP创建");
    }

    //JSONInvok层切点
    @Pointcut("@annotation(xyz.lihang.housenet.aop.JSONInvok)")
    public  void jsonAspect() {
    }

    /**
     * 环绕通知
     * @param pjp
     * @return
     * @throws Throwable
     */
    @Around("jsonAspect()")
    public void around(ProceedingJoinPoint pjp) throws Throwable{
        Object object =null;
        try {
            object = pjp.proceed();
            JsonWriterUtil.writerJson(object);
        }catch (MyException e){
            
        }catch (Exception e){
            e.printStackTrace();
            logger.info(e.getMessage());
        }
    }

}
