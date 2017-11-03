package xyz.lihang.housenet.aop;

import java.lang.annotation.*;

/**
 * Created by Administrator on 2017/11/2.
 * 拦截json返回
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface JSONInvok {
}