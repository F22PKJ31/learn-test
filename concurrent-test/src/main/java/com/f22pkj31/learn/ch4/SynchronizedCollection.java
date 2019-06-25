package com.f22pkj31.learn.ch4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * <p>
 * <p>
 * 修改历史:											<br>
 * 修改日期    		修改人员   	版本	 		修改内容<br>
 * -------------------------------------------------<br>
 * 2019-06-13 11:32  bo.fan   1.0    	初始化创建<br>
 * </p>
 *
 * @author bo.fan
 * @version 1.0
 * @since JDK1.7
 */
public class SynchronizedCollection {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        List<String> strings = new ArrayList<String>();
        //装饰者模式
        strings = Collections.synchronizedList(strings);

    }
}
