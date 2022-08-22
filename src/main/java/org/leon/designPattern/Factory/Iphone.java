package org.leon.designPattern.Factory;

public class Iphone implements PhoneInterface{
    private String phoneType;

    public Iphone(String phoneType) {
        this.phoneType = phoneType;
    }

    @Override
    public void displayText(String text) {
        System.out.println("displaying on " + this.phoneType + ": ");
        System.out.println(text);
    }

    @Override
    public void dial(Long number) {

    }
}
