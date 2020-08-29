package com.sl.generic;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shuliangzhao
 * @Title: Favorites
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2020/8/2 17:46
 */
public class Favorites {
    private Map<Class<?>, Object> favorites = new HashMap<>();

    public <T> void putFavorite(Class<T> type, T instance){
        if (type == null) {
            throw new NullPointerException("Type is null");
        }
        favorites.put(type, type.cast(instance));
    }

    public <T> T getFavorite(Class<T> type){
        return type.cast(favorites.get(type));
    }
}
