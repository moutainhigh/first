package com.deppon.dpm.tongxunlu.server.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 非受检cookie标注
 * ClassName: CookieNotCheckedRequired <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * date: 2014-8-20 下午8:59:37 <br/>
 *
 * @author 157229-zxy
 * @version 
 * @since JDK 1.6
 */
@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface CookieNotCheckedRequired {
    
}
