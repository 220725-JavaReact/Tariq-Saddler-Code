package javaReflectionsDemoPackage;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;


//This is an annotation to tell our custom annotation to keep this annotation during runtime
//TDLR: we can use it in our reflection
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD) //We can also add this annotation to indicate that our Test annotation can only be applied to methods
public @interface Test {
    
    //Will determine if it will run the unit test or not
    public boolean enable() default true;
}