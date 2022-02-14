package com.sl;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.util.ListUtils;
import com.sl.data.Student;
import org.junit.Test;

import java.util.List;

/**
 * @package: com.sl
 * @author: shuliangzhao
 * @description:
 * @date 2022/1/29 15:54
 */
public class ExcelWrite {

    @Test
    public void write() {
        String fileName = "D:\\aplus" + System.currentTimeMillis() + ".xlsx";
        EasyExcel.write(fileName, Student.class).sheet("模板")
                .doWrite(() -> {
                    return data();
                });

    }

    private List<Student> data() {
        List<Student> list = ListUtils.newArrayList();
        for (int i = 0; i < 10; i++) {
            Student student = new Student();
            student.setId(i);
            student.setName("张三" + i);
            student.setBirthday("2021-12-20");
            student.setAge("20");
            list.add(student);
        }
        return list;
    }
}
