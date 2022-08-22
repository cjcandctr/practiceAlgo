package org.leon.algo;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class LRUCacheTest {

    @Test
    public void LRUTest(){
        LRUCache cache = new LRUCache(2);
        cache.put(1,1);
        cache.put(2,2);
        cache.get(1);
        cache.put(3,3);
        cache.get(2);
        cache.put(4,4);
        cache.get(1);
        cache.get(3);
        cache.get(4);
    }

    @Test
    public void LinkedListTest() {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        list.forEach(item -> {
            System.out.println(item);
        });
        int val = list.remove(4);
        list.addFirst(val);
        System.out.println("rearranged: ");
        list.forEach(item -> {
            System.out.println(item);
        });
    }

    @Test
    public void StringCompareTest(){
        String newline = System.getProperty("line.separator");
        String a = """ 
                  hello from fist line
                  and from second line
                  and the third line
                """;
        System.out.println(a);
        String b = "sjjlavjk汉子934";
        System.out.println(String.join(newline,"88888", "9999", "000000"));
        System.out.println("ssd".concat("-").concat("sdds"));// concat compiles to +
        System.out.println(String.format("'a == b': %s", a==b));
        System.out.println("a equals b : " + a.equals(b));
    }
}