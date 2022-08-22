package org.leon.designPattern.builder;

import java.util.Arrays;

public class DishBuilder {
    String Chilli;
    String Oil;
    String[] ChickenMeat;
    String Cong;

    public DishBuilder prepareChilli(String c){
        Chilli=c;
        return this;
    }
    public DishBuilder prepareOil(String o){
        Oil = o;
        return this;
    }
    public DishBuilder prepareCong(String c){
        Cong = c;
        return this;
    }
    public DishBuilder prepareMeat(String checken){
        ChickenMeat = checken.split("");
        return this;
    }
    public KongBaoChicken build(){
        return new KongBaoChicken(this);
    }
}
