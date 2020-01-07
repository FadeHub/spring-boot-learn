package com.sl.learn.excel;

import com.github.crab2died.ExcelUtils;
import com.github.crab2died.sheet.wrapper.NoTemplateSheetWrapper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author shuliangzhao
 * @Title: TestExcel
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/12/12 19:23
 */
public class TestExcel {


    public void testBatchNoTemplate2Excel() throws Exception {

        List<NoTemplateSheetWrapper> sheets = new ArrayList<>();

        for (int s = 0; s < 3; s++) {
            List<Student2> list = new ArrayList<Student2>();
            for (int i = 0; i < 1000; i++) {
                list.add(new Student2(10000L + i, "学生" + i, new Date(), 201, false));
            }
            sheets.add(new NoTemplateSheetWrapper(list, Student2.class, true, "sheet_" + s));
        }
        ExcelUtils.getInstance().noTemplateSheet2Excel(sheets, "EE.xlsx");
    }
}
