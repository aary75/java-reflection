package com.bridgelabz.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

class Employee{
    private String name = "Aaryan";
    public int age;
    private String department;

    private int calculateAge(int age){
        return age;
    }
    public Employee(String department){
        this.department = department;
    }

}
public class displayDetails {
      public static void main(String[] args) throws  Exception{
          Employee myEmp = new Employee("CSE");
          Class<?> cls = Employee.class;

          System.out.println("Class Name: " + cls.getName());

          Field[] employeeFields = myEmp.getClass().getDeclaredFields();
          System.out.println("All fields name: ");
          for(Field field : employeeFields){
              System.out.println(field.getName());
          }

          Method[] employeeMethods = myEmp.getClass().getDeclaredMethods();
          System.out.println("All methods name: ");
          for(Method method: employeeMethods){
              System.out.println(method.getName());
          }

          Constructor[] employeeConstructor = myEmp.getClass().getConstructors();
          System.out.println("Al constructors name: ");
          for(Constructor constructor : employeeConstructor){
              System.out.println(constructor.getName());
          }
      }

}
