// Creating methodInvocation class to get output of all methods declared in private method
package com.bridgelabz.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

class MathOperations{
    private int firstNumber;
    private int secondNumber;

    private MathOperations(int firstNumber, int secondNumber){
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

    public void add(){
        System.out.println("Addition of " + firstNumber + " and " + secondNumber + " is " + (firstNumber + secondNumber));
    }

    public void subtract(){
        System.out.println("Subtraction of " + firstNumber + " and " + secondNumber + " is " + (Math.max(firstNumber, secondNumber) - Math.min(firstNumber, secondNumber)));
    }

    public void multiply(){
        System.out.println("Multiplication of " + firstNumber + " and " + secondNumber  + " is " + firstNumber * secondNumber);
    }
}

public class MethodInvocation {
    public static void main(String[] args) throws Exception{
        Class<?> cls = MathOperations.class;
        Constructor<?> construct = cls.getDeclaredConstructor(int.class, int.class);
        construct.setAccessible(true);
        MathOperations mathFunctions = (MathOperations) construct.newInstance(25,10);


        Method[] methods = mathFunctions.getClass().getDeclaredMethods();

        for(Method method : methods){
            method.invoke(mathFunctions);
        }
    }
}

//Addition of 25 and 10 is 35
//Multiplication of 25 and 10 is 250
//Subtraction of 25 and 10 is 15
