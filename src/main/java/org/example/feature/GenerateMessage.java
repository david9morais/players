package org.example.feature;


import org.example.enums.QuestionEnum;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

import static org.example.enums.QuestionEnum.*;

public class GenerateMessage {


    ArrayList<String> list = new ArrayList<>();

    public GenerateMessage() { // add values to the list when GenerateMessage is instantiated
        list.add(SECOND.getQuestion());
        list.add(THIRD.getQuestion());
        list.add(FOURTH.getQuestion());
        list.add(FIFTH.getQuestion());
        list.add(SIXTH.getQuestion());
        list.add(SEVENTH.getQuestion());
        list.add(EIGHTH.getQuestion());
        list.add(NINTH.getQuestion());
    }

    // method to generate a random question from a list of questions and remove the selected one
    public String generateQuestion() {

        Random r = new Random();

        int randomNumber = r.nextInt(list.size()); // a random number between 0 and size of this list
        String message = list.get(randomNumber); // get the random response from the list
        list.remove(randomNumber); // delete the item selected randomly from the list
        return message;
    }

    // method to generate a response depending on the question that was received as a parameter
    public String generateResponse(String question) {
        String response = "Hi";
        QuestionEnum questionEnum = QuestionEnum.getEnumFromString(question);
        if(Objects.nonNull(questionEnum)) {
            switch (questionEnum) {
                case FIRST:
                    response = "Good";
                    break;
                case SECOND:
                    response = "Yes, I have a degree in Computer Science";
                    break;
                case THIRD:
                    response = "Not as a professional, but during my degree I did Erasmus for 6 months in Hungary";
                    break;
                case FOURTH:
                    response = "Yes, as a java software developer";
                    break;
                case FIFTH:
                    response = "I have 3 years of experience in java web development";
                    break;
                case SIXTH:
                    response = "I have already worked with java 8 and 11";
                    break;
                case SEVENTH:
                    response = "I participated in 3 projects, 2 in the banking sector and 1 in the health sector";
                    break;
                case EIGHTH:
                    response = "Develop new features and fix bugs";
                    break;
                case NINTH:
                    response = "An opportunity to have an experience outside my comfort zone and thereby develop myself on a professional and personal level";
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + question);
            }
        }
        return response;
    }
}
