package com.epam.talixo.framework.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.InputStreamReader;

public class JsonUtils {

    private static Gson gson = new GsonBuilder().setLenient().create();

    /**
     * This method deserializes the Json read into an object of the specified class.
     * Use for an array of data.
     *
     * @param filepath  the path to the file from which the object is to be deserialized
     * @param <T>       the type of the desired object
     * @param className the class of T
     * @return objects of type T from the string
     */
    public static <T> T[] readJsonArray(String filepath, Class<T[]> className) {
        T[] objs;
        objs = gson.fromJson(new InputStreamReader(JsonUtils.class.getResourceAsStream(filepath)), className);
        return objs;
    }

    /**
     * This method deserializes the Json read into an object of the specified class.
     *
     * @param filepath  the path to the file from which the object is to be deserialized
     * @param <T>       the type of the desired object
     * @param className the class of T
     * @return an object of type T from the string
     */
    public static <T> T readJsonSingleObject(String filepath, Class<T> className) {
        T obj;
        obj = gson.fromJson(new InputStreamReader(JsonUtils.class.getResourceAsStream(filepath)), className);
        return obj;
    }

}