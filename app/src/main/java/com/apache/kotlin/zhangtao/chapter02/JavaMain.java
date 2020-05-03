package com.apache.kotlin.zhangtao.chapter02;

import com.apache.kotlin.zhangtao.chapter05.Animal;
import com.apache.kotlin.zhangtao.chapter05.Dog;
import com.apache.kotlin.zhangtao.chapter09.StaticMethodDemo;

import java.io.File;

/**
 * Created by Jerry on 2020-04-25.
 */
public class JavaMain {
    public static String in  = "abc";
    public static void main(String[] args) {
        BasicGrammerDemoKt.echo("Helllo");
        ObjectDemo.INSTANCE.sayMessage(".java 调用");
        ObjectDemo.sayMessage(".java JvmStatic 调用");

        File file = new File("/sdcard/test.txt");
        //FilesKt.readText(file, Charsets.UTF_8);

        printName((Animal) new Dog(),(Animal) new Dog());

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });

        Thread thread2 = new Thread(() ->{

        });

        StaticMethodDemo.Companion.isEmpty("");
    }

    public static String format(String str){
        return str.isEmpty()? null:str;
    }


    public static final String name(Animal receiver){
        return "animal";
    }

    public static final String name(Dog receiver){
        return "dog";
    }

    public static void printName(Animal r,Animal a){
        String str = name(a);
        System.out.println(str);
    }


}


