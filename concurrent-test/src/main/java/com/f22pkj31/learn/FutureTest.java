package com.f22pkj31.learn;

import lombok.AllArgsConstructor;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * <p>
 * <p>
 * 修改历史:											<br>
 * 修改日期    		修改人员   	版本	 		修改内容<br>
 * -------------------------------------------------<br>
 * 2019-06-14 10:16  bo.fan   1.0    	初始化创建<br>
 * </p>
 *
 * @author bo.fan
 * @version 1.0
 * @since JDK1.7
 */
public class FutureTest {

    private int a = 10;

    private int b = 10;

    @Test
    public void testFuture() throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        System.out.println("start" + start);
        List<Future<String>> list = new ArrayList<Future<String>>();
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            list.add(threadPool.submit(new TestTask(a, b)));
            a++;
        }

        for (Future<String> future : list) {
            String result = future.get();
        }
        System.out.println("end" + (System.currentTimeMillis() - start));
    }

    @AllArgsConstructor
    private class TestTask implements Callable<String> {

        private int a;
        private int b;

        public String call() throws Exception {
            Thread.sleep(2000);
            System.out.println(a * b);
            return "true";
        }
    }
}


