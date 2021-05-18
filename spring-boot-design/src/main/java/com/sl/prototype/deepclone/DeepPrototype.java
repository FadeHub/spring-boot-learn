package com.sl.prototype.deepclone;

import java.io.*;

/**
 * @author shuliangzhao
 * @Title: DeepPrototype
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2021/5/18 21:07
 */
public class DeepPrototype implements Serializable,Cloneable {

    private String name;

    private DeepCloneableTarget deepCloneableTarget;

    public DeepPrototype(String name, DeepCloneableTarget deepCloneableTarget) {
        this.name = name;
        this.deepCloneableTarget = deepCloneableTarget;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //方法1 深拷贝
    @Override
    protected Object clone() throws CloneNotSupportedException {
        DeepPrototype deepPrototype = (DeepPrototype) super.clone();
        deepPrototype.deepCloneableTarget = (DeepCloneableTarget)deepCloneableTarget.clone();
        return deepPrototype;
    }

    //使用序列化进行深拷贝
    public Object deepClone() {
        try(ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream os = new ObjectOutputStream(bos);
            ){
            os.writeObject(this);
            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream is = new ObjectInputStream(bis);
            Object o = is.readObject();
            return o;
        }   catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
