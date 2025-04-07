package com.bridgelabz.reflection;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

class User{
    private String userName;
    private int age;

    @Override
    public String toString(){
        return userName + " " + age;
    }
}

class SimpleObjectMapper{
    public static <T> T toObject(Class<T> clazz, Map<String,Object> properties){
        try{
            T instance = clazz.getDeclaredConstructor().newInstance();

            for(Field field : clazz.getDeclaredFields()){
                field.setAccessible(true);
                if(properties.containsKey(field.getName())){
                    field.set(instance, properties.get(field.getName()));;
                }
            }

            return instance;
        }
        catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}
public class CustomObjectMapper {
    public static void main(String[] args){
        Map<String, Object> data = new HashMap<>();
        data.put("userName", "Aaryan");
        data.put("age",25);

        User user = SimpleObjectMapper.toObject(User.class, data);
        System.out.println(user);
    }
}
