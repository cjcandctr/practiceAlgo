package org.leon.algo;

import java.util.HashMap;
import java.util.Map;

public class NonRepeatSubStr {

    public String SlidingWindow(String s){
        int start=0, end=0;
        int maxLen=0;
        int startM=0;
        int endM=0;
        for(end=0; end<s.length();end++){
            char c = s.charAt(end);
            if(!s.substring(start,end).contains(String.valueOf(c))){
                if((end-start +1) > maxLen){
                    startM = start;
                    endM = end;
                    maxLen = end - start +1;
                }
                continue;
            }else{
                int repeatCharIdx = s.substring(start,end).indexOf(c);
                start = start+repeatCharIdx + 1;
            }
        }
        return s.substring(startM, endM+1);
    }

    public int SlidingWindowI( String s){
        int start=0, end=0;
        int maxLen=0;
        int startM=0;
        int endM=0;
        for(end=0; end<s.length();end++){
            char c = s.charAt(end);
            if(!s.substring(start,end).contains(String.valueOf(c))){
                if((end-start +1) > maxLen){
                    startM = start;
                    endM = end;
                    maxLen = end - start +1;
                }
                continue;
            }else{
                int repeatCharIdx = s.substring(start,end).indexOf(c);
                start = start+repeatCharIdx + 1;
            }
        }
        return maxLen;
    }
}
