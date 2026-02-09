package com.sl.anno;

import java.lang.annotation.*;

/**
 * @package: com.sl.anno
 * @author: shuliangzhao
 * @description:
 * @date 2026/2/9 14:18
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MapField {

    String key() default "";

    boolean ignore() default  false;

}
