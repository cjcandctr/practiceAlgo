package org.leon.algo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NonRepeatSubStrTest {
    @Test
    public void StringPractice(){
        String s = "12345678";
        int i = 10;
        char c = '5';
        String s2=String.valueOf(i);
        System.out.println(String.format("string format specifier: %s, second %s, escape char %%s", 28.45, s.charAt(4)));

        String sub = s.substring(0,1);
        System.out.println("sub string is " + sub);

        Boolean contain = s.contains(String.valueOf(c));
        System.out.println(contain);

    }

    @Test
    public void SlidingWindowTest(){
        NonRepeatSubStr nrss = new NonRepeatSubStr();
        String res = nrss.SlidingWindow("pwwkew");
        System.out.println(res);
    }
}