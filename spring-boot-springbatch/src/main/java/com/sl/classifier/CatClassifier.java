package com.sl.classifier;

import com.sl.entity.Cat;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.classify.Classifier;

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

    @Override
    public ItemProcessor<Cat, Cat> classify(Cat cat) {
        return cat.getId() % 2==0 ? catNameUpperProcessor:catAddressUpperProcessor;
    }
}
