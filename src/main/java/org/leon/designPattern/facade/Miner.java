package org.leon.designPattern.facade;


import java.util.Arrays;

public abstract class Miner {
    abstract void working();
    abstract String getName();

    private void instructionDispatcher(Action act){
        switch(act){
            case SLEEP:
            case GO_HOME:
            case WORK:
            case WAKE_UP:
            case GO_TO_MINE:
            default:
                System.out.println("no such action");
        }
    }
    public void doWork(Action... actions){
        Arrays.stream(actions).forEach(this::instructionDispatcher);
    }
}

enum Action{
    WAKE_UP, GO_TO_MINE, WORK, GO_HOME, SLEEP
}
