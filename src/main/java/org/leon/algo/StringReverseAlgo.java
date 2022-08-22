package org.leon.algo;

public class StringReverseAlgo {
    public char[] reverseStringArray(char[] s){
        if(s == null || s.length ==0) return null;
        for(int start=0, end=s.length-1;start<end;start++, end--){
            char tmp;
            tmp = s[start];
            s[start] = s[end];
            s[end] = tmp;
        }
        return s;
    }


    public String reverseWordsInSantance(String input){
        String[] words = input.split(" ");
        this.reverseStringArr(words);
        return String.join(" ", words);
    }
    public void reverseStringArr(String[] ss){
        for(int start =0, end =ss.length-1;start<end;start++, end--){
            String tmp;
            tmp = ss[start];
            ss[start] = ss[end];
            ss[end]=tmp;
        }
    }

}
