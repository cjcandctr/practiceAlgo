package org.leon.designPattern.facade;

public class TunnelDigger {
    Action act;

    public TunnelDigger(Action act) {
        this.act = act;
        System.out.println("wants to " + (act ==Action.GO_HOME));
    }
}
