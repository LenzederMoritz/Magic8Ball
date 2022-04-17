package model;

public class MagischeMiesmuschelAnswer implements Answerable {


    private final String[] ANSWERS= {
            "Ja",
            "Nein",
            "Vielleicht",
            "Weiß ich doch nicht",
            "Frag nicht so dumm",
            "Frag doch einfach nochmal"
    };




    @Override
    public String getAnswer() {

        return ANSWERS[(int)Math.round(Math.random()*(ANSWERS.length-1))];
    }
}
