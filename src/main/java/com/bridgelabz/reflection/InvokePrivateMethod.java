package com.bridgelabz.reflection;

import java.lang.reflect.Method;

class Addition{

    private int add(int first, int second){
        return first + second;
    }
}
public class InvokePrivateMethod {
    public static void main(String[] args) throws Exception{
        Addition addition = new Addition();

        Method method = addition.getClass().getDeclaredMethod("add",int.class,int.class);
        method.setAccessible(true);

        int result = (int) method.invoke(addition, 12, 24);
        System.out.print("The sum is: " + result);

    }
}

//The sum is: 36
