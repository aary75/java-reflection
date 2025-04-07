// Creating the ModifyStaticFields class to access and modify the static fields
package com.bridgelabz.reflection;

import java.lang.reflect.Field;

class Configuration{
    private static String API_KEY = "64944545547887487554";
}

public class ModifyStaticFields {
    public static void main(String[] args) throws Exception{
        Configuration configure = new Configuration();


        Field field = configure.getClass().getDeclaredField("API_KEY");
        field.setAccessible(true);
        System.out.println("Before Modification");
        System.out.println(field.get(configure));
        System.out.println("After Modification");
        field.set(field,"56464f6466546354");
        System.out.println(field.get(configure));
    }
}

//Before Modification
//64944545547887487554
//After Modification
//56464f6466546354