package org.leon.algo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;


class ConferenceRoom {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    private  int roomId;
    private String name;
    private List<BookTime> booked = new LinkedList<>();

    public boolean CheckAvailable(BookTime b){

        return booked.stream().filter(bk->bk.overlap(b)).findAny().isEmpty();
    }
    public void ShowRoomInfo(){
        System.out.println(name + " Room Info " + ": ");
        if(booked.size() ==0) {
            System.out.println("No Event");
            return;
        }
        StringBuilder sb = new StringBuilder();
        for(BookTime t : booked){
            sb.append(t.title).append(" - ").append(t.bookedDate).append(" - ").append(t.bookUser).append(" - ").append(t.description).append("\n");
        }
        System.out.println(sb);
    }
    public void Book(BookTime time){
        booked.add(time);
    }
}
class BookTime{
    String title;
    String description;
    String bookUser;

    LocalDate bookedDate;
    LocalTime start;
    LocalTime end;

    public BookTime(LocalDate ld, LocalTime start, LocalTime end) {
        this.bookedDate = ld;
        this.start = start;
        this.end = end;
    }

    public boolean overlap(BookTime bt){
        if(bt.bookedDate.compareTo(bookedDate)!=0) return true;
        return !(this.end.compareTo(bt.start)<=0 || this.start.compareTo(bt.end) >=0);
    }
}
public class ConferenceRoomMan {
    List<ConferenceRoom> rooms = new LinkedList<>();

    public ConferenceRoomMan() {
        ConferenceRoom r = new ConferenceRoom();
        r.setName("Default Room Alpha");
        r.setRoomId(1);
        rooms.add(r);

        ConferenceRoom beta = new ConferenceRoom();
        beta.setName("Default Room Beta");
        beta.setRoomId(2);
        rooms.add(beta);
    }

    public void showAllConfRoom(){
        rooms.forEach(room->{
            room.ShowRoomInfo();
        });
    }

    public ConferenceRoom getRoomById(int roomId){
        Optional<ConferenceRoom> or = rooms.stream().filter(r->r.getRoomId() == roomId).findFirst();
        return or.isEmpty()? null : or.get();
    }
    public boolean bookEvent(int roomId, LocalDate date, LocalTime start, LocalTime end, String title, String user, String desc){
        ConferenceRoom r = getRoomById(roomId);
        if(r == null){
            System.out.println("cannot find room info");
            return false;
        }
        BookTime bt = new BookTime(date, start, end);
        if(!r.CheckAvailable(bt)){
            System.out.println("room not available for the time");
            return false;
        }
        bt.title = title;
        bt.bookUser = user;
        bt.description = desc;
        r.Book(bt);
        return true;
    }
}
