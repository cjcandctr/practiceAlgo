package org.leon.designPattern.Factory;

public class MiPhone implements PhoneInterface{
    private String phoneType;

    public MiPhone(String phoneType) {
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
