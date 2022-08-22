package org.leon.designPattern.builder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DishBuilderTest {
    @Test
    public void builderPractice(){
        DishBuilder builder = new DishBuilder();
        KongBaoChicken c = builder.prepareChilli("red pepper")
                .prepareCong("green cong")
                .prepareMeat("LargeChicken")
                .prepareOil("Hot Healthy Oil")
                .build();
        c.present();
    }

    @Test
    public void stringPractice(){
        String[] ss = new String[6];
        String[] ss2 = {"s1", "s2", "s3", "s4"};
        System.out.println("this is not as expected: " + ss2.toString());
        System.out.println("✅ : " + String.join(",",ss2));

        char[] chars = {'1','2','3','4'};
        System.out.println("char tostring: " + new String(chars));

        String big = "jishd,osiu,oisj";
        String[] sar = big.split("");
        for(String s : sar){
            System.out.println(s);
        }


    }
}