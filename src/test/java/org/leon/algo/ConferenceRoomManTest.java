package org.leon.algo;

import org.junit.jupiter.api.Test;
import org.springframework.util.LinkedMultiValueMap;

import java.text.DecimalFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.*;

class ConferenceRoomManTest {

    @Test
    public void DateTimePractice(){
        LocalDate d = LocalDate.now();
        System.out.println("tostring: " + d.toString() );
        System.out.println( d.getYear() + "|" + d.getMonth() + d.getMonthValue() + "|" + d.getDayOfMonth() + "|" + d.getDayOfWeek());

        LocalDate d2 = LocalDate.of(2022, 8, 10);
        System.out.println(d2.toString() + " plus 2d usage: " + d2.plusDays(2) + " at time: " + d2.atTime(14,10));
        System.out.println("got time in data?: " + d2.toString());

        LocalDate d3 = LocalDate.parse("2022-08-20");
        System.out.println("parsed date from string: " + d3.toString());

        System.out.println("0 means equal compared two date: " + d.compareTo(d3));
        System.out.println("positive means greater compared two date: " + d.compareTo(d2));

        LocalTime t = LocalTime.now();
        System.out.println(t.toString());
        System.out.println(String.join("|", String.valueOf(t.getHour()), String.valueOf(t.getMinute()),String.valueOf(t.getSecond())));
        LocalTime t2 = LocalTime.of(12,30);
        LocalTime t3 = LocalTime.parse("20:08");
        System.out.println("parsed time from string: " + t3);
        System.out.println("compare two time" + t2.compareTo(t3));

        Date dt = new Date();
        System.out.println("Date: " + dt.toString());
    }

    @Test
    public void PrintFPractice(){
        System.out.printf("%4s ","a");
        System.out.println();
        System.out.printf("%4d", 3);
        System.out.println();
        System.out.printf("%5d", 3);
        System.out.println();
        System.out.printf("%6d", 3);
    }

    @Test
    public void CollectionPractise(){
        Map<String, Integer> map = new HashMap<>();
        map.put("first", 1);
        map.put("second", 2);
        map.put("third", 3);
        map.put("first", 11);

        for(String key : map.keySet()){
            System.out.println( key + " : " + map.get(key));
        }

        List<String> ls = new LinkedList<>();
        ls.add("first");
        ls.add("sec");

        for(String s : ls){
            System.out.println(s);
        }

    }

    @Test
    public void NumersPractise(){
        //        double dbl = 9.098;
        float ft =  8.24f;
        float ft2 =  0.21f;
        float opResult = (ft+ft2+0.002f)/2f;
        System.out.println("use flout all the way: "+opResult);

        double res2 = (ft+ft2+0.002)/2;
        System.out.println("use double to calc: " + res2);
        double fround = Math.round(res2 *1000.0)/1000.0;
        System.out.println("expected double number with round " + fround);

        DecimalFormat df = new DecimalFormat("#.####");
        String strDeci = df.format(res2);
        System.out.println("use decimal formatter #: " + strDeci);
    }

    @Test
    public void functionInterfaceTest(){
        //1) Predicate -- bool result
        Predicate<String> pd = str -> str.length() >3;
        System.out.println(pd.test("hello"));

        //2) Consumer -- no output
        Person a = new Person();
        Consumer<Person> consume = p-> p.live= true;;
        consume.accept(a);

        //3) Function both input and output
        Function<Integer, String> func = intA-> {
            return intA + 10 + " : number";
        };
        System.out.println("func apply--- " + func.apply(2));

        Function3<Integer, Integer, Integer, String> f3 = (in1, in2, in3)->{ return String.valueOf(in1 + in2 + in3); };
        System.out.println("fucntion 3 arguments: " + f3.apply(3,4,5));
    }


    @Test
    void roomReservation(){
        ConferenceRoomMan rman = new ConferenceRoomMan();
        rman.showAllConfRoom();

        rman.bookEvent(1,LocalDate.now(),LocalTime.of(12,0), LocalTime.of(13,0), "午休会", "Leon", "午休的时候还好休息一下在会议室里");
        rman.showAllConfRoom();

        rman.bookEvent(1,LocalDate.now(),LocalTime.of(12,30), LocalTime.of(13,0), "午休会", "Leon", "午休的时候还好休息一下在会议室里");
    }
}

@FunctionalInterface
interface Function3<T1, T2, T3, R>{
    R apply(T1 a, T2 b, T3 c);
}

class Person{
    boolean live;
    int age;
}