package com.sl.reader;

import com.sl.entity.CreditBill;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import javax.annotation.PostConstruct;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;

/**
 * @author shuliangzhao
 * @Title: CommonFieldSetMapper
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2020/12/4 22:14
 */
public class CommonFieldSetMapper<T> implements FieldSetMapper<T> {

    private Class<? extends T> type;


    @Override
    public T mapFieldSet(FieldSet fieldSet) throws BindException {
        try {
            T t = type.newInstance();
            Field[] declaredFields = type.getDeclaredFields();
            if (declaredFields != null) {
                for (Field field : declaredFields) {
                    field.setAccessible(true);
                    if (field.getName().equals("id")) {
                        continue;
                    }
                    String name = field.getType().getName();
                    if (name.equals("java.lang.Integer")) {
                        field.set(t,fieldSet.readInt(field.getName()));
                    }else if (name.equals("java.lang.String")) {
                        field.set(t,fieldSet.readString(field.getName()));
                    }else if (name.equals("java.util.Date")) {
                        field.set(t,fieldSet.readDate(field.getName()));
                    }else{
                        field.set(t,fieldSet.readString(field.getName()));
                    }
                }
                return t;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void setTargetType(Class<? extends T> type) {
        this.type = type;
    }

    public static void main(String[] args) {
        CreditBill creditBill = new CreditBill();
        Field[] declaredFields = creditBill.getClass().getDeclaredFields();
        for (Field field:declaredFields) {
            System.out.println(field.getType().getName());
        }
    }
}
