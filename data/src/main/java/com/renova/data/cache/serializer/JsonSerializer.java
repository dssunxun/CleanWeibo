package com.renova.data.cache.serializer;

import com.google.gson.Gson;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by Renova on 2016/3/9.
 */
@Singleton
public class JsonSerializer {
    private final Gson gson = new Gson();

    @Inject
    public JsonSerializer() {
    }

    /**
     * 序列化泛型对象to Json
     *
     * @param t
     * @param <T>
     * @return
     */
    public <T> String serialize(T t) {
        String json = gson.toJson(t, t.getClass());
        return json;
    }

    /**
     * 反序列化 json to 泛型对象
     * @param json
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> T deserialize(String json, Class<T> clazz) {
        T obj = gson.fromJson(json, clazz);
        return obj;
    }

}
