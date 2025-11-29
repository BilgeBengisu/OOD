package model;

/*
    @author: Bilge Akyol 
**/

public class Flashcard {
    private String front;
    private String back;
    private Language language;

    // constructor for a. flashcard with front and back for display purposes, language as an attribute
    public Flashcard(String front, String back, Language language) {
        this.front = front;
        this.back = back;
        this.language = language;
    }

    // getters
    public String getFront() {
        return front;
    }

    public String getBack() {
        return back;
    }

    public Language getLanguage() {
        return language;
    }

    // overriding toString to display flashcard information
    @Override
    public String toString() {
        return front + " --> " + back + " (" + language + ")";
    }
}