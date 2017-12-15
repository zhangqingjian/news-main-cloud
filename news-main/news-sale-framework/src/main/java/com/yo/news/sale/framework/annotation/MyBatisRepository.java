/**
 * 
 */
package com.yo.news.sale.framework.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.stereotype.Repository;

/**
*/
/**
 * @author JAN
 * @CreatedTime：2017年10月17日 下午1:49:54 说明：
 */
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target(ElementType.TYPE)
@Repository
public @interface MyBatisRepository
{

}
