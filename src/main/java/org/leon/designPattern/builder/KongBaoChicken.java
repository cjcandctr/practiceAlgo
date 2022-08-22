package org.leon.designPattern.builder;

public class KongBaoChicken implements DishInterface {
    String Chilli;
    String Oil;
    String[] ChickenMeat;
    String Cong;

    public KongBaoChicken(DishBuilder builder) {
        this.ChickenMeat = builder.ChickenMeat;
        this.Oil = builder.Oil;
        this.Chilli = builder.Chilli;
        this.Cong = builder.Cong;
    }

    @Override
    public void present() {
        System.out.println("KongBaoChicken is here: ");
        System.out.println(String.join(" - ",Chilli, Oil, ChickenMeat.toString(), Cong));
    }
}
