package org.example;

import org.example.enums.QuestionEnum;
import org.example.feature.GenerateMessage;
import org.example.object.Player;

public class Main {

    private static GenerateMessage generateMessage = new GenerateMessage();

    public static void main(String[] args) {
        Player player1 = new Player("Interviewer");
        Player player2 = new Player("Interviewee");

        System.out.println("The interview will start!");

        Player initiator = player1; // Initiator is Player 1
        Player receiver = player2;

        String message = "Hi " + receiver.getName();

        do {
            String reply = initiator.sendMessage(message);
            System.out.println("\n" + initiator.getName() + " : " + reply);
            initiator = (initiator == player1) ? player2 : player1; // Switch initiator
            receiver = (receiver == player2) ? player1 : player2; // Switch receiver
            if (initiator.getMessagesSent() == 1) {
                message = QuestionEnum.FIRST.getQuestion();
            }
            if (initiator.getMessagesSent() >= 1 && receiver.getMessagesSent() >= 2 && initiator.getMessagesSent() < 10) {
                message = (initiator == player1) ? generateMessage.generateQuestion() : generateMessage.generateResponse(message);
            }
        } while (initiator.getMessagesSent() < 10);

        System.out.println("The interview is over.");
        System.exit(0);
    }
}