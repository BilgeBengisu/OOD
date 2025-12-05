package model;

/**
 * Flashcard.java
 * Represents a single flashcard for language learning.
 * 
 * Each flashcard contains a front side (original language phrase), a back side
 * (translation), and the associated Language. Flashcards are typically created
 * by the CSVLoader and managed within a Deck.
 * 
 * @author Bilge Akyol
 */
public class Flashcard {
    private String front;
    private String back;
    private Language language;

    /**
     * Constructs a Flashcard with the specified front and back content.
     * 
     * front The text displayed on the front of the flashcard (original language phrase)
     * back The text displayed on the back of the flashcard (translation)
     * language The Language enum value associated with this flashcard
     */
    public Flashcard(String front, String back, Language language) {
        this.front = front;
        this.back = back;
        this.language = language;
    }

    // gets the front side of the flashcard.
    public String getFront() {
        return front;
    }

    // gets the back side of the flashcard.
    public String getBack() {
        return back;
    }

    // gets the language associated with this flashcard.
    public Language getLanguage() {
        return language;
    }

    // overriding toString to display flashcard information
    @Override
    public String toString() {
        return front + " --> " + back + " (" + language + ")";
    }
}