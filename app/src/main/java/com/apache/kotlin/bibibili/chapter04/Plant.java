package com.apache.kotlin.bibibili.chapter04;

/**
 * author: jerry
 * created on: 2020/9/24 9:17 PM
 * description:
 */
class Plant<T> {

    <T> void printIfTypeMatch(Object item, Class<T> type){
        if (type.isInstance(item)){
            System.out.println(String.format("%s isInstance of %s ",type,item));
        }else {
            System.out.println(String.format("%s is not instance of %s ",type,item));
        }
    }

    public static void main(String[] args) {
        Plant<Apple> plant = new Plant<Apple>();
        plant.printIfTypeMatch(plant, Apple.class);
        plant.printIfTypeMatch(plant, Pear.class);
        plant.printIfTypeMatch(plant, Plant.class);

    }





}


