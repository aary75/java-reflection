package com.bridgelabz.reflection;


import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)

@interface Author{
    String name();
}

@Author(name = "Aaryan")
class Annotations{

}
public class RetrieveAnnotationsAtRuntime {
    public static void main(String[] args) throws Exception{
          Class<?> cls = Annotations.class;

          if(cls.isAnnotationPresent(Author.class)){
              Author author = cls.getAnnotation(Author.class);
              System.out.print(author.name());
          }

    }
}

//Aaryan