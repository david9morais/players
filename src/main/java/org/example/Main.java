package org.example;

import org.example.feature.Chat;
import org.example.object.Player;

public class Main {
    private static Player player1;
    private static Player player2;
    private static Chat chat = new Chat();

    public static void main(String[] args) {
        player1 = new Player("Interviewer");
        player2 = new Player("Interviewee");

        chat.startChat(player1, player2);
    }
}