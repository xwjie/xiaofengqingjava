package cn.xiaowenjie.spider.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Description TODO
 * @Date 2021/1/12 0012
 * @Author 晓风轻 https://github.com/xwjie
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface CssSelctor {

    String value();

    boolean html() default false;
}
