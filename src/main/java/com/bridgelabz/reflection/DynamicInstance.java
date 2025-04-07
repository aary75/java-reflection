package com.bridgelabz.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

class Student{
    private int age;

    private Student(int age){
        this.age = age;
    }

    private void display(){
        System.out.println("Here is the value of age as outcome of method " + age);
    }
}
public class DynamicInstance {
    public static void main(String[] ars) throws Exception{
          Class<?> cls = Student.class;

        Constructor<?> construct = cls.getDeclaredConstructor(int.class);
        construct.setAccessible(true);
        Student student = (Student) construct.newInstance(23);

        Field field = cls.getDeclaredField("age");
        field.setAccessible(true);
        System.out.println("Here is the value of age as field " + field.get(student));

        Method method = cls.getDeclaredMethod("display");
        method.setAccessible(true);
      //  System.out.print(method.get(student));
        method.invoke( student);
    }
}

//Here is the value of age as field 23
//Here is the value of age as outcome of method 23