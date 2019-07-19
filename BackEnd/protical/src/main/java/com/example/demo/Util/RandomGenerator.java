package com.example.demo.Util;


import java.util.Random;
import java.util.UUID;

public class RandomGenerator {
    public static String generateUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public static String generateCode(){
        String tem = "";
        Random ra =new Random();
        for (int i=0;i<4;i++)
            tem  += ra.nextInt(10);
        return tem;
    }

}