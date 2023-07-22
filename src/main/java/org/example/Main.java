package org.example;

import org.example.enums.QuestionEnum;
import org.example.feature.GenerateMessage;
import org.example.object.Player;

public class Main {

    private static final GenerateMessage generateMessage = new GenerateMessage();

    public static void main(String[] args) {
        // instantiate 2 players
        Player player1 = new Player("Interviewer");
        Player player2 = new Player("Interviewee");

        System.out.println("The interview will start!");

        // Define which player will send the first message
        Player initiator = player1;
        Player receiver = player2;

        String message = null;

        do {
            // condition to send the first message of each player as a Hi with the name of the player that will receive the message
            if (initiator.getMessagesSent() < 1) {
                message= "Hi " + receiver.getName();
            }
            String reply = initiator.sendMessage(message);
            System.out.println("\n" + initiator.getName() + " : " + reply);
            initiator = (initiator == player1) ? player2 : player1; // Switch initiator
            receiver = (receiver == player2) ? player1 : player2; // Switch receiver
            // condition to send the first question as default after the greetings
            if (initiator.getMessagesSent() == 1) {
                message = QuestionEnum.FIRST.getQuestion();
            }
            // condition to start the generation of questions and answers after the geetings and the default question
            if (initiator.getMessagesSent() >= 1 && receiver.getMessagesSent() >= 2 && initiator.getMessagesSent() < 10) {
                message = (initiator == player1) ? generateMessage.generateQuestion() : generateMessage.generateResponse(message);
            }
        } while (initiator.getMessagesSent() < 10); // only repeat the code above until the player2 send 10 messages

        System.out.println("The interview is over.");
        System.exit(0);
    }
}