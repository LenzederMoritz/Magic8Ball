package model;

public class Magic8BallAnswer implements Answerable {




    private final String[] ANSWERS= {
            "Yes",
            "No",
            "Maybe",
            "Frag doch einfach nochmal"
    };




    public String getAnswer() {

        return ANSWERS[(int)Math.round(Math.random()*(ANSWERS.length-1))];
    }
}
