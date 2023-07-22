package org.example.enums;

public enum QuestionEnum {
    FIRST("How are you?"),
    SECOND("Do you have a higher education degree?"),
    THIRD("Have you ever had an experience outside your country?"),
    FOURTH("Have you started work yet?"),
    FIFTH("How many years of experience do you have?"),
    SIXTH("Which java versions have you worked with?"),
    SEVENTH("How many professional projects have you been involved in?"),
    EIGHTH("What were your main responsibilities in previous projects?"),
    NINTH("What do you want for your future?");

    private String question;

    QuestionEnum(String question) {
        this.question = question;
    }

    public static QuestionEnum getEnumFromString(String text) {
        for (QuestionEnum b : QuestionEnum.values()) {
            if (b.getQuestion().equalsIgnoreCase(text)) {
                return b;
            }
        }
        return null;
    }

    public String getQuestion() {
        return question;
    }
}
