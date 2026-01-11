package com.example.java17.records;

public class Main {
    public static void main(String[] args) {

        RecordExample example = new RecordExample(1024, "MyRecord");

        System.out.println(example.name());
//        example.name = "otherName";       // ошибка - объект неизменяемый
        System.out.println(example.size());
        System.out.println(example.toString());
        example.sayHello();
        System.out.println(RecordExample.TEST);
    }
}
