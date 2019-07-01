package com.f22pkj31.learn.log;

import java.lang.annotation.*;

/**
 * (类型功能说明描述)
 * <p>
 * <p>
 * 修改历史:											<br>
 * 修改日期    		修改人员   	版本	 		修改内容<br>
 * -------------------------------------------------<br>
 * 2019-05-22 17:46  liulihan     1.0    	初始化创建<br>
 * </p>
 *
 * @author liulihan
 * @version 1.0
 * @since JDK1.7
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface SkyLog {
    SkyNetEnums.LogLevelEnum level();

    SkyNetEnums.ModelEnum model();

    SkyNetEnums.CategorieyEnum category();

    SkyNetEnums.SubCategoryEnum subCategory();
}
