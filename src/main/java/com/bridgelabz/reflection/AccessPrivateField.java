package com.bridgelabz.reflection;

import java.lang.reflect.Field;

class Person{
    private final int age = 23;

}
public class AccessPrivateField {
    public static void main(String[] args) throws Exception{
        Person person = new Person();

        Field modifyAge = person.getClass().getDeclaredField("age");

        modifyAge.setAccessible(true);
        System.out.println("Old Age: " + modifyAge.get(person));

        modifyAge.set(person,42);

        System.out.println("New Age: " + modifyAge.get(person));
    }
}

//Old Age: 23
//New Age: 42
