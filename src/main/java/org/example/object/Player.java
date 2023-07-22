package org.example.object;

public class Player {

    private String name;
    private int messagesSent; // store the number of messages already sent

    public Player(String name) {
        this.name = name;
        this.messagesSent = 0;
    }

    public String getName() {
        return name;
    }

    public int getMessagesSent() {
        return messagesSent;
    }

    // method that receives a message and print it wiht the number of messages sent by the player
    public String sendMessage(String message) {
        String numberMessages = messagesSent < 1 ? " message)" : " messages)";
        return message + " - (" + name + " already sent " + (++messagesSent) + numberMessages + "\n";
    }
}
