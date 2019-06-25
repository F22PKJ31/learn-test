package com.f22pkj31.learn;

import lombok.Data;
import lombok.ToString;
import org.junit.Test;

/**
 * <p>
 * <p>
 * 修改历史:											<br>
 * 修改日期    		修改人员   	版本	 		修改内容<br>
 * -------------------------------------------------<br>
 * 2019-06-14 14:30  bo.fan   1.0    	初始化创建<br>
 * </p>
 *
 * @author bo.fan
 * @version 1.0
 * @since JDK1.7
 */
public class FinalTest {

    @Test
    public void testFinal() {
        final Student student = new Student();
        student.setName("123");
        student.setAge(123);
        System.out.println(student);

    }
}

@Data
@ToString
class Student {
    private String name;

    private int age;
}
