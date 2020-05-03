package com.apache.kotlin.zhangtao.chapter03;

/**
 * Created by Jerry on 2020-04-26.
 */
public class AJavaImpl implements AInterface {
    public static AInterface a = new AJavaImpl();

    @Override
    public void putNumber(int number) {
        System.out.println("putNumber int");
    }

    @Override
    public void putNumber(Integer number) {
        System.out.println("putNumber Integer");

    }
}
