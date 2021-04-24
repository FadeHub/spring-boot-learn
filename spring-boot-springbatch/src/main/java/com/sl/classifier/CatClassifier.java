package com.sl.classifier;

import com.sl.entity.Cat;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.classify.Classifier;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author shuliangzhao
 * @Title: CatClassifier
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2021/4/21 14:04
 */
public class CatClassifier implements Classifier<Cat, ItemProcessor<Cat,Cat>> {

    private ItemProcessor<Cat,Cat> catNameUpperProcessor;

    private ItemProcessor<Cat,Cat> catAddressUpperProcessor;

    public CatClassifier(ItemProcessor<Cat, Cat> catNameUpperProcessor, ItemProcessor<Cat, Cat> catAddressUpperProcessor) {
        this.catNameUpperProcessor = catNameUpperProcessor;
        this.catAddressUpperProcessor = catAddressUpperProcessor;
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("1","12");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            System.out.println(next);
        }
    }

    @Override
    public ItemProcessor<Cat, Cat> classify(Cat cat) {
        return cat.getId() % 2==0 ? catNameUpperProcessor:catAddressUpperProcessor;
    }
}
