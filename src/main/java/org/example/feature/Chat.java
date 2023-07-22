package org.example.feature;

import org.example.enums.QuestionEnum;
import org.example.object.Player;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class Chat {

    private static final AtomicInteger messageCounter = new AtomicInteger(1);

    private GenerateMessage generateMessage = new GenerateMessage();

    public void startChat(Player sender, Player recipient) {
        System.out.println("The interview will start!");
        sendMessage(sender, recipient, "Hi " + recipient.getName());
    }

    public void endChat() {
        System.out.println("\nThe interview is over.");
        System.exit(0);
    }

    private void sendMessage(Player sender, Player recipient, String message) {
        sender.setMessagesSent(messageCounter.get());
        System.out.println("\n" + sender.getName() + " : " + message + " (" + sender.getName() + " already sent " + sender.getMessagesSent() + " messages)" + "\n");
        reply(sender, recipient, message);
    }

    private void reply(Player sender, Player recipient, String message) {
        if(Objects.isNull(QuestionEnum.getEnumFromString(message))){
            String response = "Hi " + sender.getName() + " (" + sender.getName() + " already received " + messageCounter + " messages)";
            System.out.println(recipient.getName() + " : " + response);
            recipient.setMessagesSent(messageCounter.get());
            messageCounter.incrementAndGet();
            sendMessage(sender, recipient, QuestionEnum.FIRST.getQuestion());
        } else {
            String response = generateMessage.generateResponse(message) + " (" + sender.getName() + " already received " + messageCounter + " messages)";
            System.out.println(recipient.getName() + " : " + response);
            recipient.setMessagesSent(messageCounter.get());
            messageCounter.incrementAndGet();
            if (recipient.getMessagesSent() == 10) {
                endChat();
            }
            sendMessage(sender, recipient, generateMessage.generateQuestion());
        }
    }
}
