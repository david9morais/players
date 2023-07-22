package org.example.object;

public class Player {

    private String name;

    private int messagesSent;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getMessagesSent() {
        return messagesSent;
    }

    public void setMessagesSent(int messagesSent) {
        this.messagesSent = messagesSent;
    }
}
