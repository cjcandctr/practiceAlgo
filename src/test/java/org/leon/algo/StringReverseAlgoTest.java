package org.leon.algo;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import static org.junit.jupiter.api.Assertions.*;

class StringReverseAlgoTest {
    @Test
    public void StringReverPractice(){
        StringReverseAlgo sa = new StringReverseAlgo();
        char[] sss = {'1','2','3','4'};
        sa.reverseStringArray(sss);
        System.out.println(new String(sss));
    }

    @Test
    void reverseWordsInSantance() {
        StringReverseAlgo sa = new StringReverseAlgo();
        System.out.println(sa.reverseWordsInSantance("Hello world from a input"));
    }

    @Test
    void repeatFormString(){
        String s = "123456789";
        CharSequence sub = s.subSequence(3,6);
        System.out.println(sub);

        String s1 = "bhyybhyybhyy";
        String s2 = "olp0olp0ol";

        String ss1 = s1+s1;
        String containing = ss1.substring(1,ss1.length()-2);
        System.out.println(containing + " contains: " + containing.contains(s1));

        String ss2 = s2+s2;
        containing = ss2.substring(1,ss2.length()-2);
        System.out.println(containing + "contains: " + containing.contains(s2));

        String a = "hellworldexample";
        String b = "world";
        int idx = a.indexOf(b);
        System.out.println(idx);
    }

    @Test
    void originReverse(){
        String s ="   1234 56 ";
        String[] sa = s.split("");


        System.out.println("origin string: " + s);
        for(int i=0,j=s.length()-1;i<j;i++,j--){
            String tmp = sa[i];
            sa[i]=sa[j];
            sa[j]=tmp;
        }
        System.out.println(String.join("",sa));
        Assert.assertEquals(String.join("",sa), " 65 4321   ");
    }
}