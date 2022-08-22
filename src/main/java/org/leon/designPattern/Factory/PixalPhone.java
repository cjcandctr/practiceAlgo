package org.leon.designPattern.Factory;

public class PixalPhone implements  PhoneInterface{
    private String phoneType;

    public PixalPhone(String phoneType) {
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
